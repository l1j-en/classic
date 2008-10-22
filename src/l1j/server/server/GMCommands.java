/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */

package l1j.server.server;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.lang.NumberFormatException;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.DropTable;
import l1j.server.server.datatables.ExpTable;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.LetterTable;
import l1j.server.server.datatables.NpcSpawnTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.datatables.SpawnTable;
import l1j.server.server.model.L1DwarfInventory;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1NpcDeleteTimer;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Party;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1Spawn;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.Instance.L1TrapInstance;
import l1j.server.server.model.map.L1WorldMap;
import static l1j.server.server.model.skill.L1SkillId.*;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.model.trap.L1WorldTraps;
import l1j.server.server.serverpackets.S_AddSkill;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_HPMeter;
import l1j.server.server.serverpackets.S_Invis;
import l1j.server.server.serverpackets.S_ItemName;
import l1j.server.server.serverpackets.S_Lawful;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_OpCode_Test;
import l1j.server.server.serverpackets.S_OtherCharPacks;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillBrave;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_Weather;
import l1j.server.server.templates.L1Drop;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Skills;
import l1j.server.server.utils.CalcExp;
import l1j.server.server.utils.IntRange;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// ClientThread, Shutdown, IpTable, MobTable,
// PolyTable, IdFactory
//

public class GMCommands {
	private static Logger _log = Logger.getLogger(GMCommands.class.getName());

	boolean spawnTF = false;
	
	private static GMCommands _instance;
	private String _lastCmd = "";
	private int _lastItemId = 0;
	private int _lastSpawnId = 45000;

	private GMCommands() {
	}

	public static GMCommands getInstance() {
		if (_instance == null) {
			_instance = new GMCommands();
		}
		return _instance;
	}

	public void handleCommands(L1PcInstance gm, String cmdLine) {
		StringTokenizer token = new StringTokenizer(cmdLine);
		String cmd = token.nextToken();
		String param = "";
		while (token.hasMoreTokens()) {
			param = new StringBuilder(param).append(token.nextToken()).append(' ').toString();
		}
		param = param.trim();
		try {
			if (!gm.isMonitor() && !gm.isGm()) {
				//gm.sendPackets(new S_SystemMessage(""));
				return;
			}
			if (!gm.isGm() && !Config.MONITOR_COMMANDS) {
				//gm.sendPackets(new S_SystemMessage(""));
				return;
			}
			if (cmd.equalsIgnoreCase("help")) {
				showHelp(gm);
			} else if (cmd.equalsIgnoreCase("test")) {
				if(gm.isGm())
					showTest(gm);
			} else if (cmd.equalsIgnoreCase("summon")) {
				if(gm.isGm())
					summon(gm, param);
			} else if (cmd.equalsIgnoreCase("pet")) {
				if(gm.isGm())
					pet(gm, param);
			} else if (cmd.equalsIgnoreCase("cleanup")) {
				if(gm.isGm())
					deleteItem();
			} else if (cmd.equalsIgnoreCase("change")) {
				if(gm.isGm())
					changeAbility(gm, param);
			} else if (cmd.equalsIgnoreCase("allrecall")) {
				if(gm.isGm())
					allrecall(gm);
			} else if (cmd.equalsIgnoreCase("addskill")) {
				if(gm.isGm())
					addSkill(gm);
			} else if (cmd.equalsIgnoreCase("speed")) {
				speed(gm);
			} else if (cmd.equalsIgnoreCase("level")) {
				if(gm.isGm())
					level(gm, param);
			} else if (cmd.equalsIgnoreCase("recall")) {
				recall(gm, param);
			} else if (cmd.equalsIgnoreCase("precall")) {
				if(gm.isGm())
					partyrecall(gm, param);
			} else if (cmd.equalsIgnoreCase("tele")) {
				teleportTo(gm, param);
			} else if (cmd.equalsIgnoreCase("loc")) {
				loc(gm);
			} else if (cmd.equalsIgnoreCase("kill")) {
				if(gm.isGm())
					kill(gm, param);
			} else if (cmd.equalsIgnoreCase("heal")) {
				if(gm.isGm())
					ress(gm);
			} else if (cmd.equalsIgnoreCase("adena")) {
				if(gm.isGm())
					gm.sendPackets(new S_SystemMessage("Use: .create 40308 0 amount"));
			} else if (cmd.equalsIgnoreCase("goto")) {
				moveToChar(gm, param);
			} else if (cmd.equalsIgnoreCase("tospawn")) {
				if(gm.isGm())
					tospawn(gm, param);
			} else if (cmd.equalsIgnoreCase("invis")) {
				invisible(gm);
			} else if (cmd.equalsIgnoreCase("show")) {
				visible(gm);
			} else if (cmd.equalsIgnoreCase("weather")) {
				changeWeather(gm, param);
			} else if (cmd.equalsIgnoreCase("gmroom")) {
				if(gm.isGm())
					gmRoom(gm, param);
			} else if (cmd.equalsIgnoreCase("jail")) {
				jail(gm, param);
			} else if (cmd.equalsIgnoreCase("kick")) {
				kick(gm, param);
			} else if (cmd.equalsIgnoreCase("ban")) {
				if(gm.isGm())
					powerkick(gm, param);
			} else if (cmd.equalsIgnoreCase("unBan")) {
				if(gm.isGm())
					unBan(gm, param);
			} else if (cmd.equalsIgnoreCase("buffme")) {
				if(gm.isGm())
					buff(gm, param, true);
			} else if (cmd.equalsIgnoreCase("buff")) {
				if(gm.isGm())
					buff(gm, param, false);
			} else if (cmd.equalsIgnoreCase("spawn")) {
				if(gm.isGm())
					spawn(gm, param);
			} else if (cmd.equalsIgnoreCase("npcspawn")) {
				if(gm.isGm())
					npcSpawn(gm, param);
			} else if (cmd.equalsIgnoreCase("poly")) {
				if(gm.isGm())
					polymorph(gm, param);
				else if(gm.isMonitor())
					monitorPoly(gm);
			} else if (cmd.equalsIgnoreCase("itemset")) {
				if(gm.isGm())
					makeItemSet(gm, param);
			} else if (cmd.equalsIgnoreCase("find")) {
				if(gm.isGm())
					find(gm, param);
			} else if (cmd.equalsIgnoreCase("create")) {
				if(gm.isGm())
					createItem(gm, param);
			} else if (cmd.equalsIgnoreCase("c")) {
				if(gm.isGm())
					c(gm);
			} else if (cmd.equalsIgnoreCase("s")) {
				if(gm.isGm())
					s(gm);
			} else if (cmd.equalsIgnoreCase("allbuff")) {
				allBuff(gm, param);
			} else if (cmd.equalsIgnoreCase("silence")) {
				chatng(gm, param);
			} else if (cmd.equalsIgnoreCase("global")) {
				if(gm.isGm())
					chat(gm, param);
			} else if (cmd.equalsIgnoreCase("present")) {
				if(gm.isGm())
					present(gm, param);
			} else if (cmd.equalsIgnoreCase("lvpresent")) {
				if(gm.isGm())
					lvPresent(gm, param);
			} else if (cmd.equalsIgnoreCase("shutdown!")) {
				if(gm.isGm())
					shutdownNow();
			} else if (cmd.equalsIgnoreCase("!shutdown")) {
				if(gm.isGm())
					shutdownAbort();
			} else if (cmd.equalsIgnoreCase("shutdown")) {
				if(gm.isGm())
					shutdown(gm, param);
			} else if (cmd.equalsIgnoreCase("resettrap")) {
				if(gm.isGm())
					resetTrap();
			} else if (cmd.equalsIgnoreCase("hometown")) {
				if(gm.isGm())
					hometown(gm, param);
			} else if (cmd.equalsIgnoreCase("gfxid")) {
				if(gm.isGm())
					gfxId(gm, param);
			} else if (cmd.equalsIgnoreCase("invgfxid")) {
				if(gm.isGm())
					invGfxId(gm, param);
			} else if (cmd.equalsIgnoreCase("action")) {
				if(gm.isGm())
					action(gm, param);
			} else if (cmd.equalsIgnoreCase("banip")) {
				if(gm.isGm())
					banIp(gm, param);
			} else if (cmd.equalsIgnoreCase("who")) {
				if(param.equals("")){
					who(gm);
				} else {
					who(gm, param);
				}
			} else if (cmd.equalsIgnoreCase("sprite")) {
				if(gm.isGm())
					viewSprite(gm, param);
			} else if (cmd.equalsIgnoreCase("hpbar")) {
				if(gm.isGm())
					hpBar(gm);
			} else if (cmd.equalsIgnoreCase("showtrap")) {
				if(gm.isGm())
					showTraps(gm);
			} else if (cmd.equalsIgnoreCase("reloadtrap")) {
				if(gm.isGm())
					reloadTraps();
			} else if (cmd.equalsIgnoreCase("pbuff")){
				pbuff();
			}else if (cmd.equalsIgnoreCase("r")) {
				if(gm.isGm())
					redo(gm, param);
			} else if (cmd.equalsIgnoreCase("f")) {
				if(gm.isGm())
					favorite(gm, param);
			}
			else if (cmd.equalsIgnoreCase("opcid2")) {
				if(gm.isGm())
					opcId2(gm, param);
			} else if (cmd.equalsIgnoreCase("opcid1")) {
				if(gm.isGm())
					opcId1(gm, param);
			} else if (cmd.equalsIgnoreCase("opcid")) {
				if(gm.isGm())
					opcId(gm, param);
			} else if (cmd.equalsIgnoreCase("opc2")) {
				if(gm.isGm())
					opc2(gm, param);
			} else if (cmd.equalsIgnoreCase("opc1")) {
				if(gm.isGm())
					opc1(gm, param);
			} else if (cmd.equalsIgnoreCase("opc")) {
				if(gm.isGm())
					opc(gm, param);
			}
			else if(cmd.equalsIgnoreCase("viewboard")) {
				if(gm.isGm())
					viewBoardMessage(gm, param);
			} else if(cmd.equalsIgnoreCase("delboard")) {
				if(gm.isGm())
					deleteBoard(gm, param);
			} else if(cmd.equalsIgnoreCase("mob")) {
				getDrops(gm, param);
			} else if(cmd.equalsIgnoreCase("item")) {
				getMobs(gm, param);
			} else if(cmd.equalsIgnoreCase("account")) {
				if(gm.isGm())
					getChars(gm, param);
			} else if(cmd.equalsIgnoreCase("resolve")) {
				if(gm.isGm())
					resolveBug(gm, param);
			} else if(cmd.equalsIgnoreCase("viewbug")) {
				if(gm.isGm())
					viewBug(gm, param);
			} else if(cmd.equalsIgnoreCase("gotoBug")) {
				if(gm.isGm())
					gotoBug(gm, param);
			} else if(cmd.equalsIgnoreCase("rates")) {
				if(gm.isGm())
					changeRates(gm, param);
			} else if(cmd.equalsIgnoreCase("pdbug")) {
				if(gm.isGm())
					togglePacketDebug(gm);
			}
			else {
				gm.sendPackets(new S_SystemMessage("The command: ."+ cmd + " does not exist."));
				return;
			}
			if (!cmd.equalsIgnoreCase("r")) {
				_lastCmd = cmdLine;
			}
			_log.info(gm.getName() + " commanded ." + cmdLine);
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

    private void showHelp(L1PcInstance pc) {
    	if(pc.isGm()){
			try {
				pc.sendPackets(new S_SystemMessage(""));
				pc.sendPackets(new S_SystemMessage(".cleanup .shutdown .shutdown! .!shutdown .test"));
				pc.sendPackets(new S_SystemMessage(".who .loc .account .global .viewboard .delboard"));
				pc.sendPackets(new S_SystemMessage(".recall .precall .allrecall .goto .tele .gmroom"));
				pc.sendPackets(new S_SystemMessage(".weather .hometown .rates .hpbar .showtrap .level"));
				pc.sendPackets(new S_SystemMessage(".viewbug .gotobug .resolve .silence .summon .pet"));
				pc.sendPackets(new S_SystemMessage(".invis .show .item .mob .find .create .itemset .r"));
				pc.sendPackets(new S_SystemMessage(".speed .poly .buffme .buff .pbuff .allbuff .change"));
				pc.sendPackets(new S_SystemMessage(".spawn .npcspawn .resettrap .reloadtrap"));
				pc.sendPackets(new S_SystemMessage(".jail .kill .kick .ban .banip .unban .addskill .f"));
			} catch (Exception exception) {
			}
		}
		else if(pc.isMonitor()){
			try {
				pc.sendPackets(new S_SystemMessage(""));
				pc.sendPackets(new S_SystemMessage(".recall .goto .invis .show .silence  .jail .item"));
				pc.sendPackets(new S_SystemMessage(".mob .pbuff .who .where .tele .weather .bug .poly"));
			} catch (Exception exception) {
			}
		}
    }

    private void showTest(L1PcInstance pc) {
    	try {
			pc.sendPackets(new S_SystemMessage("Testcommands:"));
			pc.sendPackets(new S_SystemMessage(".gfxid .invgfxid .action .sprite .c .s .pdbug"));
			pc.sendPackets(new S_SystemMessage(".opcid .opcid1 .opcid2 .opc .opc1 .opc2"));
		} catch (Exception exception) {
		}
    }

	// Get PC from name
	private L1PcInstance getPcInstance(String name) {
		L1PcInstance pc = L1World.getInstance().getPlayer(name);
		if (pc == null) {
			for (L1PcInstance player : L1World.getInstance().getAllPlayers()) {
				if (player.getName().toLowerCase().equals(name.toLowerCase())) {
					pc = player;
					break;
				}
			}
		}
		return pc;
	}

	private void broadcastToAll(String s) {
		L1World.getInstance().broadcastPacketToAll(new S_SystemMessage(s));
	}

	// Get character sex
	private String getSex(int classID){
		if(classID == 0 || classID == 61 || classID == 138 || classID == 734 || classID == 2786){
			return "Male";
		} else if(classID == 1 || classID == 48 || classID == 37 || classID == 1186 || classID == 2796){
			return "Female";
		} else{
			return "error";
		}
	}

	// Get character class
	private String getClass(int classID){
		if(classID == 0 || classID == 1){
			return "Royal";
		} else if(classID == 61 || classID == 48){
			return "Knight";
		} else if(classID == 138 || classID == 37){
			return "Elf";
		} else if(classID == 734 || classID == 1186){
			return "Mage";
		} else if(classID == 2786 || classID == 2796){
			return "Dark Elf";
		} else{
			return "error";
		}
	}

	private void togglePacketDebug(L1PcInstance l1pcinstance) {
		String setting;
		if(Config.LOGGING_INCOMING_PACKETS) {
			Config.LOGGING_INCOMING_PACKETS = false;
			setting = "Off";
		} else {
			Config.LOGGING_INCOMING_PACKETS = true;
			setting = "On";
		}
		l1pcinstance.sendPackets(new S_SystemMessage("Incoming packet logging is "+setting));
	}

	private void changeAbility(L1PcInstance l1pcinstance, String params) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(params);

			String char_name = stringtokenizer.nextToken();

			String param = stringtokenizer.nextToken();

			String value = stringtokenizer.nextToken();

			int data = Integer.parseInt(value);

			L1PcInstance target = getPcInstance(char_name);

			boolean worked = true;

			if (param.equalsIgnoreCase("HP")) {
				target.addBaseMaxHp((short) (data - target.getBaseMaxHp()));
				target.setCurrentHpDirect(target.getMaxHp());
				target.sendPackets(new S_SystemMessage("HP Changed"));
			} else if (param.equalsIgnoreCase("MP")) {
				target.addBaseMaxMp((short) (data - target.getBaseMaxMp()));
				target.setCurrentMpDirect(target.get_maxMp());
				target.sendPackets(new S_SystemMessage("MP Changed"));
			} else if (param.equalsIgnoreCase("STR")) {
				target.addBaseStr((byte)(data - target.getBaseStr()));
				target.sendPackets(new S_SystemMessage("STR Changed"));
				target.sendPackets(new S_OwnCharStatus(target));
			} else if (param.equalsIgnoreCase("DEX")) {
				target.addBaseDex((byte) (data - target.getBaseDex()));
				target.sendPackets(new S_SystemMessage("DEX Changed"));
				target.sendPackets(new S_OwnCharStatus(target));
			} else if (param.equalsIgnoreCase("CON")) {
				target.addBaseCon((byte) (data - target.getBaseCon()));
				target.sendPackets(new S_SystemMessage("CON Changed"));
				target.sendPackets(new S_OwnCharStatus(target));
			} else if (param.equalsIgnoreCase("WIS")) {
				target.addBaseWis((byte) (data - target.getBaseWis()));
				target.sendPackets(new S_SystemMessage("WIS Changed"));
				target.sendPackets(new S_OwnCharStatus(target));
			} else if (param.equalsIgnoreCase("INT")) {
				target.addBaseInt((byte) (data - target.getBaseInt()));
				target.sendPackets(new S_SystemMessage("INT Changed"));
				target.sendPackets(new S_OwnCharStatus(target));
			} else if (param.equalsIgnoreCase("CHA")) {
				target.addBaseCha((byte) (data - target.getBaseCha()));
				target.sendPackets(new S_SystemMessage("CHA Changed"));
				target.sendPackets(new S_OwnCharStatus(target));
			} else if (param.equalsIgnoreCase("AC")) {
				target.addAc((byte) (data - target.getAc()));
				target.sendPackets(new S_SystemMessage("AC Changed"));
				target.sendPackets(new S_OwnCharStatus(target));
			} else if (param.equalsIgnoreCase("MR")) {
				target.addMr((short) (data - target.getMr()));
			} else if (param.equalsIgnoreCase("HIT")) {
				target.addHitup((short) (data - target.getHitup()));
			} else if (param.equalsIgnoreCase("DMG")) {
				target.addDmgup((short) (data - target.getDmgup()));
			} else if (param.equalsIgnoreCase("GM")) {
				if(data > 199) {
					data = 200;
				}
				else if(data > 99) {
					data = 100;
				}
				else{
					data = 0;
				}
				target.setAccessLevel((short) data);
				if(data == 200){
					target.sendPackets(new S_SystemMessage(target.getName() + " is now a GM."));
				}
				else if(data == 100){
					target.sendPackets(new S_SystemMessage(target.getName() + " is now a Monitor."));
				}
				else{
					target.sendPackets(new S_SystemMessage(target.getName() + " is now a Commoner."));
				}
				target.sendPackets(new S_OwnCharStatus(target));
			} else if (param.equalsIgnoreCase("LAW")) {
				target.setLawful(data);
				target.sendPackets(new S_SystemMessage("LAW Changed"));
				target.sendPackets(new S_OwnCharStatus(target));
				S_Lawful s_lawful = new S_Lawful(target.getId(), target.getLawful());
				target.sendPackets(s_lawful);
				target.broadcastPacket(s_lawful);
			} else if (param.equalsIgnoreCase("KARMA")) {
				target.setKarma(data);
			} else {
				worked = false;
				l1pcinstance.sendPackets(new S_SystemMessage("No such stat to change"));
			}
			if(worked){
				l1pcinstance.sendPackets(new S_SystemMessage("Changed "+ char_name + " " + param + " to " + value));
				target.save();
			}
		} catch (Exception e) {
			l1pcinstance.sendPackets(new S_SystemMessage(".change charName [HP MP AC MR HIT DMG STR DEX CON WIS INT CHA GM LAW KARMA] value"));
		}
	}

    //For viewing Board Messages
    private void viewBoardMessage(L1PcInstance pc, String s) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(s);
			String number = stringtokenizer.nextToken();
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM board WHERE id=?");
			pstm.setInt(1, Integer.valueOf(number).intValue());
			rs = pstm.executeQuery();
			if(rs.next()){
				pc.sendPackets(new S_SystemMessage(rs.getInt("id")+". ("+rs.getString("name")+") "+rs.getString("date")+" "+rs.getString("title")+": "+rs.getString("content")));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".viewboard (messageID)"));
			listBoard(pc);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

    //For listing all the Board Messages
	private void listBoard(L1PcInstance pc) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT id,name,title,content FROM board");
			rs = pstm.executeQuery();
			pc.sendPackets(new S_SystemMessage("Listing Board contents:"));
			while(rs.next()){
				String cont = rs.getString("content");
				int str1length=cont.length();
				if(str1length>30){
					str1length=30;
				}
				pc.sendPackets(new S_SystemMessage(rs.getInt("id")+". ("+rs.getString("name")+") "+rs.getString("title")+": "+cont.substring(0,str1length)));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".viewboard (messageID)"));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	private void allBuff(L1PcInstance gm, String args) {
		int[] allBuffSkill = { LIGHT, DECREASE_WEIGHT, PHYSICAL_ENCHANT_DEX,
				MEDITATION, PHYSICAL_ENCHANT_STR, BLESS_WEAPON,
				BERSERKERS, IMMUNE_TO_HARM, ADVANCE_SPIRIT,
				REDUCTION_ARMOR, BOUNCE_ATTACK, SOLID_CARRIAGE,
				ENCHANT_VENOM, BURNING_SPIRIT, VENOM_RESIST,
				DOUBLE_BRAKE, UNCANNY_DODGE, DRESS_EVASION,
				GLOWING_AURA, BRAVE_AURA,
				RESIST_MAGIC, CLEAR_MIND, ELEMENTAL_PROTECTION,
				AQUA_PROTECTER, BURNING_WEAPON, IRON_SKIN,
				EXOTIC_VITALIZE, WATER_LIFE, ELEMENTAL_FIRE,
				SOUL_OF_FLAME, ADDITIONAL_FIRE };
		try {
			StringTokenizer st = new StringTokenizer(args);
			String name = st.nextToken();
			L1PcInstance pc = L1World.getInstance().getPlayer(name);
			if (pc == null) {
				gm.sendPackets(new S_ServerMessage(73, name));
				return;
			}

			speed(pc);
			L1PolyMorph.doPoly(pc, 5641, 7200);
			for (int i = 0; i < allBuffSkill.length; i++) {
				L1Skills skill = SkillsTable.getInstance()
						.getTemplate(allBuffSkill[i]);
				new L1SkillUse().handleCommands(pc, allBuffSkill[i], pc
						.getId(), pc.getX(), pc.getY(), null, skill
						.getBuffDuration() * 1000, L1SkillUse.TYPE_GMBUFF);
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".allBuff failed"));
		}
	}

	//For deleting Board Messages
	private void deleteBoard(L1PcInstance pc, String s) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(s);
			String number = stringtokenizer.nextToken();
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("DELETE FROM board WHERE id=?");
			pstm.setInt(1, Integer.valueOf(number).intValue());
			pstm.execute();
			pc.sendPackets(new S_SystemMessage("Removed Boardpost number: "+number));
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".delboard messageID"));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	//For debugging and finding new Sprites in the client. Can cause many fings like exiting the client. Use with care!
	private void viewSprite(L1PcInstance pc, String sprite){
		try {
			int spriteID=Integer.parseInt(sprite);
			pc.sendPackets(new S_SystemMessage("Viewing Sprite: "+spriteID));
			S_SkillSound s_skillsound = new S_SkillSound(pc.getId(), spriteID);
			pc.sendPackets(s_skillsound);
			pc.broadcastPacket(s_skillsound);
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".sprite spriteID"));
		}
	}

	//View a specific bug or get buglisting if you send empty string
	private void viewBug(L1PcInstance pc, String bug){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();

			int bugid=Integer.valueOf(bug).intValue();
			pstm = con.prepareStatement("select * from bugs where id = ?");
			pstm.setInt(1, bugid);
			rs = pstm.executeQuery();
			rs.next();
			if(rs.getInt("resolved")==1) {
				pc.sendPackets(new S_SystemMessage(rs.getInt("id")+"(Resolved). "+
					rs.getString("charname")+" (on Map:"+rs.getInt("mapID")+
					", X:"+rs.getInt("mapX")+", Y:"+rs.getInt("mapY")+
					") wrote: "+rs.getString("bugtext")+"."
					));
			} else {
				pc.sendPackets(new S_SystemMessage(rs.getInt("id")+". "+
					rs.getString("charname")+" (on Map:"+rs.getInt("mapID")+
					", X:"+rs.getInt("mapX")+", Y:"+rs.getInt("mapY")+
					") wrote: "+rs.getString("bugtext")+"."
					));
			}
			rs.close();
		} catch (Exception e) {
			listBugs(pc);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	//List all unresolved bugs
	private void listBugs(L1PcInstance pc){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();

			pstm = con.prepareStatement("select * from bugs where resolved = 0");// ORDER BY id
			rs = pstm.executeQuery();
			while (rs.next()){
				String str1 = rs.getString("bugtext");
				int str1length=str1.length();
				if(str1length>45){
					str1length=45;
				}
				pc.sendPackets(new S_SystemMessage(rs.getInt("id") + ": " + rs.getString("bugtext").substring(0,str1length)));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("Could not access the buglist!"));
			pc.sendPackets(new S_SystemMessage(".viewbug (bugID)"));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	//Teleport to where player reported the bug
	private void gotoBug(L1PcInstance pc, String bug){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();

			int bugid=Integer.valueOf(bug).intValue();
			pstm = con.prepareStatement("select * from bugs where id = ?");
			pstm.setInt(1, bugid);
			rs = pstm.executeQuery();
			rs.next();
			L1Teleport.teleport(pc, rs.getInt("mapX"), rs.getInt("mapY"), (short) rs.getInt("mapID"), 5, true);
			if(rs.getInt("resolved")==1) {
				pc.sendPackets(new S_SystemMessage(rs.getInt("id")+"(Resolved). "+
					rs.getString("charname")+" (on Map:"+rs.getInt("mapID")+
					", X:"+rs.getInt("mapX")+", Y:"+rs.getInt("mapY")+
					") wrote: "+rs.getString("bugtext")+"."
					));
			} else {
				pc.sendPackets(new S_SystemMessage(rs.getInt("id")+". "+
					rs.getString("charname")+" (on Map:"+rs.getInt("mapID")+
					", X:"+rs.getInt("mapX")+", Y:"+rs.getInt("mapY")+
					") wrote: "+rs.getString("bugtext")+"."
					));
			}
			rs.close();
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("Could not access the buglist!"));
			pc.sendPackets(new S_SystemMessage(".viewbug (bugID)"));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	//Close a bugreport
	private void resolveBug(L1PcInstance pc, String bug){
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE bugs SET resolved=1 WHERE id=?");
			pstm.setInt(1, Integer.valueOf(bug).intValue());
			pstm.execute();
			pc.sendPackets(new S_SystemMessage("Bug #"+bug+" has been resolved!"));
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".resolve bugID"));
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void getChars(L1PcInstance pc, String accountName){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT char_name,level,MaxHp,MaxMp,Class FROM characters WHERE account_name=?");
			pstm.setString(1, accountName.trim());
			rs = pstm.executeQuery();
			pc.sendPackets(new S_SystemMessage("Account ("+accountName+"):"));
			while(rs.next()) {
				pc.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(rs.getString("char_name"))
						.append(": L").append(rs.getInt("level"))
						.append(" ").append(getSex(rs.getInt("Class")))
						.append(" ").append(getClass(rs.getInt("Class")))
						.append(" ").append(rs.getInt("MaxHp"))
						.append("/").append(rs.getInt("MaxMp"))
						.toString()));
			}
			rs.close();
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".chars account_name"));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void getMobs(L1PcInstance pc, String drop) {
		int dropID = 0;
		try
		{
			dropID=Integer.parseInt(drop);
		}
		catch (NumberFormatException e)
		{
			pc.sendPackets(new S_SystemMessage(".item itemID"));
		}
		if(dropID==40308) {
			pc.sendPackets(new S_SystemMessage("Adena(40308) drops from almost everything"));
		} else {
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			int[] mobID;
			int[] min;
			int[] max;
			double[] chance;
			String[] name;
			try {
				L1Item item = ItemTable.getInstance().getTemplate(dropID);
				String blessed;
				if(item.getBless() == 1){
					blessed = "";
				}
				else if(item.getBless() == 0){
					blessed = "\\fR";
				}
				else{
					blessed = "\\fY";
				}

				con = L1DatabaseFactory.getInstance().getConnection();
				pstm = con.prepareStatement("SELECT mobId,min,max,chance FROM droplist WHERE itemId=?");
				pstm.setInt(1, dropID);
				rs = pstm.executeQuery();
				rs.last();
				int rows=rs.getRow();
				mobID = new int[rows];
				min = new int[rows];
				max = new int[rows];
				chance = new double[rows];
				name = new String[rows];
				rs.beforeFirst();

				int i=0;
				while(rs.next()) {
					mobID[i]=rs.getInt("mobId");
					min[i]=rs.getInt("min");
					max[i]=rs.getInt("max");
					chance[i]=rs.getInt("chance")/(double)10000;
					i++;
				}
				rs.close();
				pstm.close();

				pc.sendPackets(new S_SystemMessage(blessed+item.getName()+"("+dropID+") drops from:"));
				for(int j=0; j<mobID.length; j++) {
					pstm = con.prepareStatement("SELECT name FROM npc WHERE npcid=?");
					pstm.setInt(1, mobID[j]);
					rs = pstm.executeQuery();
					while(rs.next()) {
						name[j]=rs.getString("name");
					}
					rs.close();
					pstm.close();
					pc.sendPackets(new S_SystemMessage(min[j]+"-"+max[j]+" "+mobID[j]+" "+name[j]+" "+chance[j]+"%"));
				}
			} catch (Exception e) {
				pc.sendPackets(new S_SystemMessage(".item itemID"));
			} finally {
				SQLUtil.close(rs);
				SQLUtil.close(pstm);
				SQLUtil.close(con);
			}
		}
	}

	private void getDrops(L1PcInstance pc, String mob){
		int mobID=Integer.parseInt(mob);
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT gfxid FROM npc WHERE npcid=?");
			pstm.setInt(1, mobID);
			rs = pstm.executeQuery();

			int gfxID;
			rs.next();
			gfxID=rs.getInt("gfxid");
			rs.close();
			pstm.close();
			con.close();

			ArrayList<L1Drop> mobDrops = DropTable.getInstance().getDrops(mobID);
			L1Item item;
			String blessed;
			L1Npc theMob = NpcTable.getInstance().getTemplate(mobID);
			pc.sendPackets(new S_SystemMessage(theMob.get_name()+"("+mobID+") | gfxID: "+gfxID+" | drops:"));
			for (L1Drop drop : mobDrops) {
				item = ItemTable.getInstance().getTemplate(drop.getItemid());
				if(item.getBless() == 1){
					blessed = "";
				}
				else if(item.getBless() == 0){
					blessed = "\\fR";
				}
				else{
					blessed = "\\fY";
				}
				double chance = drop.getChance()/(double)10000;
				pc.sendPackets(new S_SystemMessage(blessed+drop.getMin()+"-"+drop.getMax()+" "+drop.getItemid()+" "+item.getName()+" "+chance+"%"));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".mob npcID"));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	//Allows for changing the rates during play
	private void changeRates(L1PcInstance pc, String s){
		String changed="Error";
		double data=0;
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(s);
			String param = stringtokenizer.nextToken();
			if (param.equalsIgnoreCase("RESET")) {
				Config.reset();
				changed="RESET";
			}
			else {
				String value = stringtokenizer.nextToken();
				data = Double.parseDouble(value);
				if (param.equalsIgnoreCase("XP")) {
					Config.setParameterValue("RateXp", ""+(Config.RATE_XP_ORG*data));
					changed="XP";
				} else if (param.equalsIgnoreCase("ADENA")) {
					Config.setParameterValue("RateDropAdena", ""+(Config.RATE_DROP_ADENA_ORG*data));
					changed="ADENA";
				} else if (param.equalsIgnoreCase("DROP")) {
					Config.setParameterValue("RateDropItems", ""+(Config.RATE_DROP_ITEMS_ORG*data));
					changed="DROP";
				} else if (param.equalsIgnoreCase("LAW")) {
					Config.setParameterValue("RateLawful", ""+(Config.RATE_LA_ORG*data));
					changed="LAW";
				} else if (param.equalsIgnoreCase("KARMA")) {
					Config.setParameterValue("RateKarma", ""+(Integer.valueOf(value)*Config.RATE_KARMA_ORG));
					changed="KARMA";
				} else if (param.equalsIgnoreCase("WEIGHT")) {
					int rate = (int)(data*Config.RATE_WEIGHT_LIMIT_ORG);
					Config.setParameterValue("Weightrate", ""+rate);
					changed="WEIGHT";
				} else if (param.equalsIgnoreCase("ALL")) {
					Config.setParameterValue("RateXp", ""+(Config.RATE_XP_ORG*data));
					Config.setParameterValue("RateDropAdena", ""+(Config.RATE_DROP_ADENA_ORG*data));
					Config.setParameterValue("RateDropItems", ""+(Config.RATE_DROP_ITEMS_ORG*data));
					Config.setParameterValue("RateLawful", ""+(Config.RATE_LA_ORG*data));
					Config.setParameterValue("RateKarma", ""+(Config.RATE_KARMA_ORG*data));
					int rate = (int)(data*Config.RATE_WEIGHT_LIMIT_ORG);
					Config.setParameterValue("Weightrate", ""+rate);
					changed="ALL";
				} else {
					pc.sendPackets(new S_SystemMessage(".rates ([XP,ADENA,DROP,LAW,KARMA,WEIGHT,ALL] VALUE) | RESET"));
					pc.sendPackets(new S_SystemMessage("XP: "+(int)Config.RATE_XP));
					pc.sendPackets(new S_SystemMessage("ADENA: "+(int)Config.RATE_DROP_ADENA));
					pc.sendPackets(new S_SystemMessage("DROP: "+(int)Config.RATE_DROP_ITEMS));
					pc.sendPackets(new S_SystemMessage("LAW: "+(int)Config.RATE_LA));
					pc.sendPackets(new S_SystemMessage("KARMA: "+(int)Config.RATE_KARMA));
					pc.sendPackets(new S_SystemMessage("WEIGHT: "+(int)Config.RATE_WEIGHT_LIMIT));
				}
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".rates ([XP,ADENA,DROP,LAW,KARMA,WEIGHT,ALL] VALUE) | RESET"));
			pc.sendPackets(new S_SystemMessage("XP: "+(int)Config.RATE_XP));
			pc.sendPackets(new S_SystemMessage("ADENA: "+(int)Config.RATE_DROP_ADENA));
			pc.sendPackets(new S_SystemMessage("DROP: "+(int)Config.RATE_DROP_ITEMS));
			pc.sendPackets(new S_SystemMessage("LAW: "+(int)Config.RATE_LA));
			pc.sendPackets(new S_SystemMessage("KARMA: "+(int)Config.RATE_KARMA));
			pc.sendPackets(new S_SystemMessage("WEIGHT: "+(int)Config.RATE_WEIGHT_LIMIT));
		}
		if(!changed.equals("Error")) {
			if(changed.equals("RESET")) {
				broadcastToAll("Rates has been reset to x1.0");
			} else {
				broadcastToAll("Rates for "+changed+" changed by x"+data);
			}
		}
	}

    private void pbuff(){
    	L1World world = L1World.getInstance();
    	if (Config.POWER_BUFF == false){
    		Config.POWER_BUFF = true;
    		world.broadcastServerMessage("Power Buff Command has been Enabled!");	
    	}else{
    		Config.POWER_BUFF = false;
    		world.broadcastServerMessage("Power Buff Command has been Disabled!");
    	}
    }

	private void summon(L1PcInstance pc, String param) {
		try {
			StringTokenizer tok = new StringTokenizer(param);
			String nameid = tok.nextToken();
			int npcid = 0;
			try {
				npcid = Integer.parseInt(nameid);
			} catch (NumberFormatException e) {
				npcid = NpcTable.getInstance().findNpcIdByNameWithoutSpace(nameid);
				if (npcid == 0) {
					pc.sendPackets(new S_SystemMessage("Cant find NPC " + nameid + "."));
					return;
				}
			}
			int count = 1;
			if (tok.hasMoreTokens()) {
				count = Integer.parseInt(tok.nextToken());
			}
			L1Npc npc = NpcTable.getInstance().getTemplate(npcid);
			for (int i = 0; i < count; i++) {
				L1SummonInstance summonInst = new L1SummonInstance(npc, pc);
				summonInst.setPetcost(0);
			}
			nameid = NpcTable.getInstance().getTemplate(npcid).get_name();
			pc.sendPackets(new S_SystemMessage("Summoned: " + nameid + "(ID:" + npcid + ") (" + count + ")"));
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			pc.sendPackets(new S_SystemMessage(".summon npcid|name count"));
		}
	}

	private void pet(L1PcInstance pc, String param) {//TODO
		boolean done=false;
		try {
			StringTokenizer tok = new StringTokenizer(param);
			int petId = Integer.parseInt(tok.nextToken());
			int level=0;
			int number=1;
			if(tok.hasMoreTokens()) {
				level = Integer.parseInt(tok.nextToken());
			}
			if(tok.hasMoreTokens()) {
				number = Integer.parseInt(tok.nextToken());
			}
			L1PcInventory inv = pc.getInventory();

			for(int i=0; i<number; i++) {
				L1NpcInstance target = new L1NpcInstance(NpcTable.getInstance().getTemplate(petId));
				L1ItemInstance petamu;
				if(target.getName().startsWith("High ")) {
					petamu = inv.storeItem(40316, 1);
				} else {
					petamu = inv.storeItem(40314, 1);
				}
				L1PetInstance pet;
				if (petamu != null) {
					pet = new L1PetInstance(target, pc, petamu.getId());
					pc.sendPackets(new S_ItemName(petamu));
					done=true;
					if(level != 0 && !(pet.getLevel()>=level)) {
						if (!IntRange.includes(level, 1, 99)) {
							pc.sendPackets(new S_SystemMessage("Level should be between 1 and 99"));
							pc.sendPackets(new S_SystemMessage(".pet npcId (level) (count)"));
							return;
						} else {
							CalcExp.LevelPet(pet, level);
						}
					}
				}
			}
		} catch (Exception e) {
			
		}
		if(!done) {
			pc.sendPackets(new S_SystemMessage("That is not an npc that can be made into a Pet."));
			pc.sendPackets(new S_SystemMessage(".pet npcId (level) (count)"));
		}
	}

	private void addSkill(L1PcInstance pc) {
		try {
			int cnt = 0;
			String skill_name = "";
			int skill_id = 0;

			int object_id = pc.getId();
			pc.sendPackets(new S_SkillSound(object_id, '\343'));
			pc.broadcastPacket(new S_SkillSound(object_id, '\343'));

			if (pc.isCrown()) {
				pc.sendPackets(new S_AddSkill(255, 255, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 255, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				for (cnt = 1; cnt <= 16; cnt++) { // LV1~2
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
				for (cnt = 113; cnt <= 120; cnt++) {
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
			} else if (pc.isKnight()) {
				pc.sendPackets(new S_AddSkill(255, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						192, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				for (cnt = 1; cnt <= 8; cnt++) { // LV1
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
				for (cnt = 87; cnt <= 91; cnt++) {
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
			} else if (pc.isElf()) {
				pc.sendPackets(new S_AddSkill(255, 255, 127, 255, 255, 255, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 127, 3, 255, 255, 255, 255, 0, 0));
				for (cnt = 1; cnt <= 48; cnt++) { // LV1~6
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
				for (cnt = 129; cnt <= 176; cnt++) {
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
			} else if (pc.isWizard()) {
				pc.sendPackets(new S_AddSkill(255, 255, 127, 255, 255, 255,
						255, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				for (cnt = 1; cnt <= 80; cnt++) { // LV1~10
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
			} else if (pc.isDarkelf()) {
				pc.sendPackets(new S_AddSkill(255, 255, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 255, 127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				for (cnt = 1; cnt <= 16; cnt++) // LV1~2
					{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
				for (cnt = 97; cnt <= 111; cnt++) { // DE
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(cnt);
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id, skill_name, 0, 0);
				}
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".addskill"));
		}
	}

	private void speed(L1PcInstance pc) {
		int objectId = pc.getId();
		try {
			int time = 3600 * 1000;

			pc.setSkillEffect(STATUS_BRAVE, time);

			pc.sendPackets(new S_SkillBrave(objectId, 1, 3600));
			pc.sendPackets(new S_SkillSound(objectId, 751));
			pc.broadcastPacket(new S_SkillSound(objectId, 751));
			pc.setBraveSpeed(1);

			pc.setSkillEffect(STATUS_HASTE, time);

			pc.sendPackets(new S_SkillHaste(objectId, 1, 3600));
			pc.sendPackets(new S_SkillSound(objectId, 191));
			pc.broadcastPacket(new S_SkillSound(objectId, 191));
			pc.setMoveSpeed(1);

		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".speed"));
		}
	}

	private void level(L1PcInstance pc, String param) {
		try {
			StringTokenizer tok = new StringTokenizer(param);
			int level = Integer.parseInt(tok.nextToken());
			if (level == pc.getLevel()) {
				return;
			}
			if (!IntRange.includes(level, 1, 99)) {
				pc.sendPackets(new S_SystemMessage(".level 1-99"));
				return;
			}
			pc.setExp(ExpTable.getExpByLevel(level));
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".level 1-99"));
		}
	}

	private void loc(L1PcInstance pc) {
		try {
			int locx = pc.getX();
			int locy = pc.getY();
			short mapid = pc.getMapId();
			int gab = L1WorldMap.getInstance().getMap(mapid).getOriginalTile(locx, locy);
			pc.sendPackets(new S_SystemMessage((new StringBuilder()).append(
					"(X:").append(locx).append(", Y:").append(locy).append(", Map:")
					.append(mapid).append(") | Tile: ").append(gab).toString()));
		} catch (Exception e) {
		}
	}

	private void moveToChar(L1PcInstance gm, String s) {
		try {
			StringTokenizer tokenizer = new StringTokenizer(s);
			String targetName = tokenizer.nextToken();
			L1PcInstance target = getPcInstance(targetName);
			if (target != null) {
				L1Teleport.teleport(gm, target.getX(), target.getY(), (short)target.getMapId(), 5, true);
				/*if(!l1pcinstance1.isGm() && gm.isGm()) { //enable if you want GM to see the character after teleport in case of invisibility
					gm.sendPackets(new S_Invis(l1pcinstance1.getId(), 0));
				}*/
				gm.sendPackets(new S_SystemMessage("You appear at "+ target.getName()+"'s feet."));
			} else {
				gm.sendPackets(new S_SystemMessage(targetName + " is not online."));
			}
		} catch (Exception exception) {
		}
	}

	private void resetTrap() {
		L1WorldTraps.getInstance().resetAllTraps();
	}

	private void hometown(L1PcInstance gm, String param) {
		try {
			StringTokenizer st = new StringTokenizer(param);
			String para1 = st.nextToken();
			if (para1.equalsIgnoreCase("daily")) {
				HomeTownTimeController.getInstance().dailyProc();
			} else if (para1.equalsIgnoreCase("monthly")) {
				HomeTownTimeController.getInstance().monthlyProc();
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".hometown daily|monthly"));
		}

	}

	private void opc(L1PcInstance gm, String param) {
		try {
			gm.sendPackets(new S_OpCode_Test(Integer.parseInt(param), 0, gm));
		} catch (Exception ex) {
			try {
				gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(0, 0, gm)).getInfo()));
			} catch (Exception ex2) {
				gm.sendPackets(new S_SystemMessage("S_OpCode_Test"));
			}
		}
	}

	private void opc1(L1PcInstance gm, String param) {
		try {
			gm.sendPackets(new S_OpCode_Test(Integer.parseInt(param), 1, gm));
		} catch (Exception ex) {
			try {
				gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(0, 1, gm)).getInfo()));
			} catch (Exception ex2) {
				gm.sendPackets(new S_SystemMessage(	"S_OpCode_Test"));
			}
		}
	}

	private void opc2(L1PcInstance gm, String param) {
		try {
			gm.sendPackets(new S_OpCode_Test(Integer.parseInt(param), 2, gm));
		} catch (Exception ex) {
			try {
				gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(0, 2, gm)).getInfo()));
			} catch (Exception ex2) {
				gm.sendPackets(new S_SystemMessage("S_OpCode_Test"));
			}
		}
	}

	private void opcId(L1PcInstance gm, String param) {
		try {
			gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(Integer.parseInt(param), 0, gm)).getCode()));
		} catch (Exception ex) {
			try {
				gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(0, 0, gm)).getCodeList()));
			} catch (Exception ex2) {
				gm.sendPackets(new S_SystemMessage("S_OpCode_Test"));
			}
		}
	}

	private void opcId1(L1PcInstance gm, String param) {
		try {
			gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(Integer.parseInt(param), 1, gm)).getCode()));
		} catch (Exception ex) {
			try {
				gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(0, 1, gm)).getCodeList()));
			} catch (Exception ex2) {
				gm.sendPackets(new S_SystemMessage("S_OpCode_Test"));
			}
		}
	}

	private void opcId2(L1PcInstance gm, String param) {
		try {
			gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(Integer.parseInt(param), 2, gm)).getCode()));
		} catch (Exception ex) {
			try {
				gm.sendPackets(new S_SystemMessage((new S_OpCode_Test(0, 2, gm)).getCodeList()));
			} catch (Exception ex2) {
				gm.sendPackets(new S_SystemMessage("S_OpCode_Test"));
			}
		}
	}

	private void shutdownAbort() {
		GameServer.getInstance().abortShutdown();
	}

	private void shutdownNow() {
		GameServer.getInstance().shutdown();
	}

	private void shutdown(L1PcInstance gm, String params) {
		try {
			int sec = 0;
			StringTokenizer st = new StringTokenizer(params);
			if (st.hasMoreTokens()) {
				String param1 = st.nextToken();
				sec = Integer.parseInt(param1, 10);
			}
			if (sec < 5) {
				sec = 5;
			}
			GameServer.getInstance().shutdownWithCountdown(sec);
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".shutdown seconds"));
		}
	}

	private void npcSpawn(L1PcInstance gm, String param) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(param);
			String s23 = stringtokenizer.nextToken();
			int l1 = Integer.parseInt(s23);
			L1Npc l1npc = NpcTable.getInstance().getTemplate(l1);
			if (l1npc != null) {
				String npc_type = l1npc.getImpl();
				if (npc_type.equals("L1Monster")) {
					gm.sendPackets(new S_SystemMessage(Integer.toString(l1) + " is not an NPC"));
				} else {
					NpcSpawnTable.getInstance().storeSpawn(gm, l1npc);
					mobspawn(gm, l1, 0, false);
					gm.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(l1npc.get_name()).append(" (").append(l1)
						.append(")  insert spawnlist").toString()));
				}
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".npcspawn NPCID"));
		}
	}

	private void s(L1PcInstance pc){
		_lastSpawnId++;
		pc.sendPackets(new S_SystemMessage("Try to spawn: "+_lastSpawnId));
		spawn(pc, ""+_lastSpawnId);
	}

	private void spawn(L1PcInstance gm, String param) {
		try {
			StringTokenizer tok = new StringTokenizer(param);
			String nameid = tok.nextToken();
			int count = 1;
			if (tok.hasMoreTokens()) {
				count = Integer.parseInt(tok.nextToken());
			}
			int randomrange = 0;
			if (tok.hasMoreTokens()) {
				randomrange = Integer.parseInt(tok.nextToken(), 10);
			}
			int npcid = 0;
			try {
				npcid = Integer.parseInt(nameid);
				_lastSpawnId = npcid; //for the s function
			} catch (NumberFormatException e) {
				npcid = NpcTable.getInstance().findNpcIdByNameWithoutSpace(nameid);
				if (npcid == 0) {
					gm.sendPackets(new S_SystemMessage("Cannot find NPC " + nameid + "."));
					return;
				}
			}
			spawnTF = true;
			for (int k3 = 0; k3 < count; k3++) {
				mobspawn(gm, npcid, randomrange, false);
			}
			nameid = NpcTable.getInstance().getTemplate(npcid).get_name();
			gm.sendPackets(new S_SystemMessage(nameid + "(" + npcid + ") (" + count + ") (:" + randomrange + ")"));
			spawnTF = false;
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			gm.sendPackets(new S_SystemMessage(".spawn npcid|name (count) (random)"));
		}
	}

	private void changeWeather(L1PcInstance gm, String param) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(param);
			String s27 = stringtokenizer.nextToken();
			int weather = Integer.parseInt(s27);
			L1World world = L1World.getInstance();
			world.setWeather(weather);
			L1World.getInstance().broadcastPacketToAll(new S_Weather(weather));
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".weather number"));
		}
	}

	private void visible(L1PcInstance gm) {
		try {
			gm.setGmInvis(false);
			gm.sendPackets(new S_Invis(gm.getId(), 0));
			// pc.broadcastPacket(new S_Invis(pc.get_objectId(), 0));
			gm.broadcastPacket(new S_OtherCharPacks(gm));
			gm.sendPackets(new S_SystemMessage("You are visible."));
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".show"));
		}
	}

	private void invisible(L1PcInstance gm) {
		try {
			gm.setGmInvis(true);
			gm.sendPackets(new S_Invis(gm.getId(), 1));
			// pc.broadcastPacket(new S_Invis(pc.get_objectId(), 1));
			gm.broadcastPacket(new S_RemoveObject(gm));
			gm.sendPackets(new S_SystemMessage("You are invisible."));
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".invis"));
		}
	}

	private void deleteItem() {
		for (L1Object l1object : L1World.getInstance().getObject()) {
			if (l1object instanceof L1ItemInstance) {
				L1ItemInstance l1iteminstance = (L1ItemInstance) l1object;
				if (l1iteminstance.getX() == 0 && l1iteminstance.getY() == 0) {
					continue;
				}

				ArrayList<L1PcInstance> players = L1World.getInstance().getVisiblePlayer(l1iteminstance, 0);
				if (0 == players.size()) {
					L1Inventory groundInventory = L1World.getInstance().getInventory(l1iteminstance.getX(),
							l1iteminstance.getY(), l1iteminstance.getMapId());
					if (l1iteminstance.getItem().getItemId() == 40314 || l1iteminstance.getItem().getItemId() == 40316) {
						PetTable.getInstance().deletePet(l1iteminstance.getId());
					}
					if (l1iteminstance.getItem().getItemId() >= 49016 && l1iteminstance.getItem().getItemId() <= 49025) {
						LetterTable lettertable = new LetterTable();
						lettertable.deleteLetter(l1iteminstance.getId());
					}
					groundInventory.deleteItem(l1iteminstance);
					L1World.getInstance().removeVisibleObject(l1iteminstance);
					L1World.getInstance().removeObject(l1iteminstance);
				}
			}
		}
		L1World.getInstance().broadcastServerMessage("All items on the ground were removed.");
	}

	private void recall(L1PcInstance gm, String param) {
		try {
			StringTokenizer tokenizer = new StringTokenizer(param);
			String pcName = tokenizer.nextToken();

			L1PcInstance target = getPcInstance(pcName);
			if (target != null) {
				recallnow(gm, target);
			} else {
				gm.sendPackets(new S_SystemMessage(""));
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".recall player"));
		}
	}

	private void allrecall(L1PcInstance gm) {
		try {
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getAccessLevel() != 200) {
					recallnow(gm, pc);
				}
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".allrecall"));
		}
	}

	private void partyrecall(L1PcInstance pc, String param) {
		StringTokenizer tokenizer = new StringTokenizer(param);
		String pcName = tokenizer.nextToken();

		L1PcInstance target = getPcInstance(pcName);
		if (target != null) {
			L1Party party = target.getParty();
			if (party != null) {
				int x = pc.getX();
				int y = pc.getY() + 2;
				short map = pc.getMapId();
				L1PcInstance[] players = party.getMembers();
				for (L1PcInstance pc2 : players) {
					try {
						L1Teleport.teleport(pc2, x, y, map, 5, true);
						pc2.sendPackets(new S_SystemMessage("You are transported to " + pc.getName() + "."));
					} catch (Exception e) {
						_log.log(Level.SEVERE, "", e);
					}
				}
			} else {
				pc.sendPackets(new S_SystemMessage(target.getName() + " are not in a party."));
			}
		} else {
			pc.sendPackets(new S_SystemMessage(pcName + " is not online."));
		}
	}

	private void recallnow(L1PcInstance gm, L1PcInstance target) {
		try {
			L1Teleport.teleportToTargetFront(target, gm, 2);
			gm.sendPackets(new S_SystemMessage((new StringBuilder()).append(target.getName()).append(" appears before you").toString()));
			target.sendPackets(new S_SystemMessage(gm.getName() + " called you."));
		} catch (Exception e) {
			_log.log(Level.SEVERE, "", e);
		}
	}

	private void polymorph(L1PcInstance gm, String param) {
		try {
			boolean flag = false;
			StringTokenizer stringtokenizer = new StringTokenizer(param);
			String name = stringtokenizer.nextToken();
			String s2 = stringtokenizer.nextToken();
			L1PcInstance pc = getPcInstance(name);
			if (pc != null) {
				try {
					flag = true;
					int j = Integer.parseInt(s2);
					L1PolyMorph.doPoly(pc, j, 7200);
				} catch (Exception exception) {
					gm.sendPackets(new S_SystemMessage(".poly player id"));
				}
			}
			if (!flag) {
				S_ServerMessage s_servermessage = new S_ServerMessage(73, name);
				gm.sendPackets(s_servermessage);
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".poly player id"));
		}
	}

	private void monitorPoly(L1PcInstance gm) {
		try {
			L1PolyMorph.doPoly(gm, 1080, 7200);
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".poly"));
		}
	}

	private void chatng(L1PcInstance gm, String param) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(param);
			String name = stringtokenizer.nextToken();
			L1PcInstance pc = getPcInstance(name);
			String s2 = stringtokenizer.nextToken();
			int time = Integer.parseInt(s2);
			if(pc.isGm()){
				gm.sendPackets(new S_SystemMessage("You cannot silence a GM."));
			}
			if (pc != null) {
				pc.setSkillEffect(STATUS_CHAT_PROHIBITED, time * 60 * 1000);
				pc.sendPackets(new S_SkillIconGFX(36, time * 60));
				pc.sendPackets(new S_ServerMessage(286, String.valueOf(time)));
				gm.sendPackets(new S_ServerMessage(287, name));
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".silence player minutes"));
		}
	}

	private void chat(L1PcInstance gm, String param) {
		try {
			StringTokenizer st = new StringTokenizer(param);
			if (st.hasMoreTokens()) {
				String flag = st.nextToken();
				String msg;
				if (flag.compareToIgnoreCase("on") == 0) {
					L1World.getInstance().set_worldChatElabled(true);
					msg = "Global Off";
				} else if (flag.compareToIgnoreCase("off") == 0) {
					L1World.getInstance().set_worldChatElabled(false);
					msg = "Global Off";
				} else {
					throw new Exception();
				}
				gm.sendPackets(new S_SystemMessage(msg));
			} else {
				String msg;
				if (L1World.getInstance().isWorldChatElabled()) {
					msg = "Global is On";
				} else {
					msg = "Global is Off";
				}
				gm.sendPackets(new S_SystemMessage(msg));
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".global [on|off]"));
		}
	}

	private void teleportTo(L1PcInstance pc, String param) {
		try {
			StringTokenizer st = new StringTokenizer(param);
			int locx = Integer.parseInt(st.nextToken());
			int locy = Integer.parseInt(st.nextToken());
			short mapid;
			if (st.hasMoreTokens()) {
				mapid = Short.parseShort(st.nextToken());
			} else {
				mapid = pc.getMapId();
			}
			L1Teleport.teleport(pc, locx, locy, mapid, 5, false);
			pc.sendPackets(new S_SystemMessage("Teleported to X:" + locx + ", Y:" + locy + " on Map:" + mapid));
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".tele locX locY (mapID)"));
		}
	}

	private int _spawnId = 0;

	private void tospawn(L1PcInstance gm, String param) {
		try {
			if (param.isEmpty() || param.equals("+")) {
				_spawnId++;
			} else if (param.equals("-")) {
				_spawnId--;
			} else {
				StringTokenizer st = new StringTokenizer(param);
				_spawnId = Integer.parseInt(st.nextToken());
			}
			L1Spawn spawn = NpcSpawnTable.getInstance().getTemplate(_spawnId);
			if (spawn == null) {
				spawn = SpawnTable.getInstance().getTemplate(_spawnId);
			}
			if (spawn != null) {
				L1Teleport.teleport(gm, spawn.getLocX(),
						spawn.getLocY(), spawn.getMapId(), 5, false);
				gm.sendPackets(new S_SystemMessage("spawnid(" + _spawnId + ")"));
			} else {
				gm.sendPackets(new S_SystemMessage("spawnid(" + _spawnId + ")"));
			}
		} catch (Exception exception) {
			gm.sendPackets(new S_SystemMessage(".tospawn spawnid|+|-"));
		}
	}

	private void makeItemSet(L1PcInstance gm, String param) {
		try {
			String name = new StringTokenizer(param).nextToken();
			List<ItemSetItem> list = GMCommandsConfig.ITEM_SETS.get(name);
			if (list == null) {
				gm.sendPackets(new S_SystemMessage(name + " does not exist"));
				return;
			}
			for (ItemSetItem item : list) {
				L1Item temp = ItemTable.getInstance().getTemplate(item.getId());
				if (!temp.isStackable() && 0 != item.getEnchant()) {
					for (int i = 0; i < item.getAmount(); i++) {
						L1ItemInstance inst = ItemTable.getInstance().createItem(item.getId());
						inst.setEnchantLevel(item.getEnchant());
						gm.getInventory().storeItem(inst);
					}
				} else {
					gm.getInventory().storeItem(item.getId(), item.getAmount());
				}
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".itemset name"));
		}
	}

	private void find(L1PcInstance pc, String param) {
		if (pc.isGm()) {
			try{
				StringTokenizer st = new StringTokenizer(param);
				String type = "";
				String name = "";
				String add = "";
				boolean simpleS=true;
				int itCount=0;
				while(st.hasMoreTokens()){
					if(itCount==1){
						add="%";
					}
					String tempVar = st.nextToken();
					if(itCount==0 && (tempVar.equals("armor") || tempVar.equals("weapon") || tempVar.equals("misci") ||  tempVar.equals("npc"))){
						simpleS=false;
						type=tempVar;
					}
					else{
						name=name+add+tempVar;
					}
					itCount++;
				}
				if (simpleS==false) {
					find_object(pc, type, name);
				}
				else {
					find_object(pc, name);
				}
			} catch (Exception e) {
				pc.sendPackets(new S_SystemMessage(".find (type[armor,misci,weapon,npc]) searchText"));
			}
		}
	}

	private void find_object(L1PcInstance pc, String type, String name){
		try{
		   String str1 = null;
		   String str2 = null;
		   int bless = 0;
		   int count = 0;
		   java.sql.Connection con = null;
		   con = L1DatabaseFactory.getInstance().getConnection();
		   PreparedStatement statement = null;
		   boolean error = false;

		   pc.sendPackets(new S_SystemMessage(" "));
		   
		   if(type.equals("misci")){
			   statement = con.prepareStatement("select item_id,name,bless from etcitem where name Like '%" + name + "%'");
		   }
		   else if(type.equals("weapon")){
			   statement = con.prepareStatement("select item_id,name,bless from weapon where name Like '%" + name + "%'");
		   }
		   else if(type.equals("armor")){
			   statement = con.prepareStatement("select item_id,name,bless from armor where name Like '%" + name + "%'");
		   }
		   else if(type.equals("poly")){
			   statement = con.prepareStatement("select polyid,name from polymorphs where name Like '%" + name + "%'");
		   }
		   else if(type.equals("npc")){
			   statement = con.prepareStatement("select npcid,name from npc where name Like '%" + name + "%'");
		   }
		   else{
			   error = true;
			   pc.sendPackets(new S_SystemMessage(".find type[armor,misci,weapon,npc] searchText"));
		   }
		   String blessed = null;
		   if(error == false){
			   ResultSet rs = statement.executeQuery();
			   pc.sendPackets(new S_SystemMessage("Searching " + type + " for '" + name.replace("%"," ") + "'"));
			   while (rs.next()){
				   str1 = rs.getString(1);
				   str2 = rs.getString(2);
				   if(type.equals("misci") || type.equals("weapon") || type.equals("armor")){
					   bless = rs.getInt(3);
					   if(bless == 1){
						   blessed = "";
					   }
					   else if(bless == 0){
						   blessed = "\\fR";
					   }
					   else{
						   blessed = "\\fY";
					   }
					   pc.sendPackets(new S_SystemMessage(blessed+"ID: "+ str1 + ", " + str2));
				   }
				   else {
					   pc.sendPackets(new S_SystemMessage("ID: "+ str1 + ", " + str2));
				   }
				   count++;
			   }
			   rs.close();
			   statement.close();
			   con.close();
			   pc.sendPackets(new S_SystemMessage("Found " + count + " instance(s) that matched " + type + "."));
		   }
		}catch (Exception e){
		}
	}

	private void find_object(L1PcInstance pc, String name){
		try{
		   String str1 = null;
		   String str2 = null;
		   int bless = 0;
		   String blessed = null;
		   
		   java.sql.Connection con = null;
		   con = L1DatabaseFactory.getInstance().getConnection();
		   PreparedStatement statement = null;

		   pc.sendPackets(new S_SystemMessage(" "));

		   pc.sendPackets(new S_SystemMessage("Searching for '" + name.replace("%"," ") + "' in all places:"));

		   statement = con.prepareStatement("select item_id,name,bless from armor where name Like '%" + name + "%'");
		   int count1 = 0;
		   ResultSet rs = statement.executeQuery();
		   while (rs.next()){
			   if(count1==0){
				   pc.sendPackets(new S_SystemMessage("Armors:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   bless = rs.getInt(3);
			   if(bless == 1){
				   blessed = "";
			   }
			   else if(bless == 0){
				   blessed = "\\fR";
			   }
			   else{
				   blessed = "\\fY";
			   }
			   pc.sendPackets(new S_SystemMessage(blessed+"ID: "+ str1 + ", " + str2));
			   count1++;
		   }
		   rs.close();
		   statement.close();

		   statement = con.prepareStatement("select item_id,name,bless from weapon where name Like '%" + name + "%'");
		   int count2 = 0;
		   rs = statement.executeQuery();
		   while (rs.next()){
			   if(count2==0){
				   pc.sendPackets(new S_SystemMessage("Weapons:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   bless = rs.getInt(3);
			   if(bless == 1){
				   blessed = "";
			   }
			   else if(bless == 0){
				   blessed = "\\fR";
			   }
			   else{
				   blessed = "\\fY";
			   }
			   pc.sendPackets(new S_SystemMessage(blessed+"ID: "+ str1 + ", " + str2));
			   count2++;
		   }
		   rs.close();
		   statement.close();

		   statement = con.prepareStatement("select item_id,name,bless from etcitem where name Like '%" + name + "%'");
		   int count3 = 0;
		   rs = statement.executeQuery();
		   while (rs.next()){
			   if(count3==0){
				   pc.sendPackets(new S_SystemMessage("Etcitems:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   bless = rs.getInt(3);
			   if(bless == 1){
				   blessed = "";
			   }
			   else if(bless == 0){
				   blessed = "\\fR";
			   }
			   else{
				   blessed = "\\fY";
			   }
			   pc.sendPackets(new S_SystemMessage(blessed+"ID: "+ str1 + ", " + str2));
			   count3++;
		   }
		   rs.close();
		   statement.close();

		   statement = con.prepareStatement("select polyid,name from polymorphs where name Like '%" + name + "%'");
		   int count4 = 0;
		   rs = statement.executeQuery();
		   while (rs.next()){
			   if(count4==0){
				   pc.sendPackets(new S_SystemMessage("Polymorphs:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   pc.sendPackets(new S_SystemMessage("ID: "+ str1 + ", " + str2));
			   count4++;
		   }
		   rs.close();
		   statement.close();

		   statement = con.prepareStatement("select npcid,name from npc where name Like '%" + name + "%'");
		   int count5 = 0;
		   rs = statement.executeQuery();
		   while (rs.next()){
			   if(count5==0){
				   pc.sendPackets(new S_SystemMessage("NPCs:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   pc.sendPackets(new S_SystemMessage("ID: "+ str1 + ", " + str2));
			   count5++;
		   }
		   rs.close();
		   statement.close();
		   con.close();

		   pc.sendPackets(new S_SystemMessage("Found:"));
		   String found="";
		   if(count1>0) {
			   found+=count1+" Armors,";
		   }
		   if(count2>0) {
			   found+=count2+" Weapons,";
		   }
		   if(count3>0) {
			   found+=count3+" Etcitems,";
		   }
		   if(count4>0) {
			   found+=count4+" Polymorphs,";
		   }
		   if(count5>0) {
			   found+=count5+" NPCs.";
		   }
		   if(found.length()>0) {
			   found=found.substring(0, found.length()-1)+".";
		   } else {
			   found="Nothing";
		   }
		   pc.sendPackets(new S_SystemMessage(found));
		}catch (Exception e){
		}
	}

	private void c(L1PcInstance pc){
		_lastItemId++;
		createItem(pc, ""+_lastItemId);
	}

	private void createItem(L1PcInstance player, String s) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(s);
			String s1 = stringtokenizer.nextToken();
			int itemid = Integer.parseInt(s1);
			_lastItemId = itemid; //for the c function
			String s2 = "0";
			if(stringtokenizer.hasMoreTokens()){
				s2 = stringtokenizer.nextToken();
			}
			int enchant = Integer.parseInt(s2);
			String s3 = "1";
			if(stringtokenizer.hasMoreTokens()){
				s3 = stringtokenizer.nextToken();
			}
			int count = Integer.parseInt(s3);
			L1Item temp = ItemTable.getInstance().getTemplate(itemid);
			if (temp != null) {
				if (temp.isStackable()) {
					L1ItemInstance item = ItemTable.getInstance().createItem(itemid);
					item.setEnchantLevel(enchant);
					item.setCount(count);
					if (player.getInventory().checkAddItem(item , count) == L1Inventory.OK) {
						player.getInventory().storeItem(item);
						player.sendPackets(new S_SystemMessage((new StringBuilder()).append("Created: ").append(count).append(" ").append(item.getName()).toString()+" ID:"+item.getItemId()));
					}
				} else {
					L1ItemInstance item = null;
					int createCount;
					for (createCount = 0; createCount < count; createCount++) {
						item = ItemTable.getInstance().createItem(itemid);
						item.setEnchantLevel(enchant);
						if (player.getInventory().checkAddItem(item , 1) == L1Inventory.OK) {
							player.getInventory().storeItem(item);
						} else
							break;
					}
					if (createCount > 0){
						player.sendPackets(new S_SystemMessage((new StringBuilder()).append("Created: ")
							.append(count).append(" ").append(createCount).append(" ").append(item.getViewName()).toString()+
							" Name:" + item.getName() + " ID:"+item.getItemId()));
					}
				}
			} else{
				player.sendPackets(new S_SystemMessage(".create itemID (enchantLvL) (ammount)"));
			}
		} catch (Exception exception) {
			player.sendPackets(new S_SystemMessage(".create itemID (enchantLvL) (ammount)"));
		}
	}

	private void present(L1PcInstance gm, String param) {
		try {
			StringTokenizer st = new StringTokenizer(param);
			String account = st.nextToken();
			int itemid = Integer.parseInt(st.nextToken(), 10);
			int enchant = Integer.parseInt(st.nextToken(), 10);
			int count = Integer.parseInt(st.nextToken(), 10);

			L1Item temp = ItemTable.getInstance().getTemplate(itemid);
			if (temp == null) {
				gm.sendPackets(new S_SystemMessage("Item not found."));
				return;
			}
			L1DwarfInventory.present(account, itemid, enchant, count);
			gm.sendPackets(new S_SystemMessage(temp.getNameId() + count + "[", true));
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".present itemId"));
		}
	}

	private void lvPresent(L1PcInstance gm, String param) {
		try {
			StringTokenizer st = new StringTokenizer(param);
			int minlvl = Integer.parseInt(st.nextToken(), 10);
			int maxlvl = Integer.parseInt(st.nextToken(), 10);
			int itemid = Integer.parseInt(st.nextToken(), 10);
			int enchant = Integer.parseInt(st.nextToken(), 10);
			int count = Integer.parseInt(st.nextToken(), 10);
			L1Item temp = ItemTable.getInstance().getTemplate(itemid);
			if (temp == null) {
				gm.sendPackets(new S_SystemMessage("Item not found."));
				return;
			}
			L1DwarfInventory.present(minlvl, maxlvl, itemid, enchant, count);
			gm.sendPackets(new S_SystemMessage(temp.getName() + count + "[(Lv" + minlvl + "'" + maxlvl + ")"));
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".lvpresent minlvl maxlvl itemId enchant count"));
		}
	}

	private void kill(L1PcInstance gm, String param) {
		try {
			StringTokenizer tokenizer = new StringTokenizer(param);
			String pcName = tokenizer.nextToken();
			L1PcInstance target = getPcInstance(pcName);
			if (target != null) {
				target.setCurrentHp(0);
				target.death(null);
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".kill player"));
		}
	}

	private void ress(L1PcInstance gm) {
		try {
			int objid = gm.getId();
			gm.sendPackets(new S_SkillSound(objid, 759));
			gm.broadcastPacket(new S_SkillSound(objid, 759));
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getCurrentHp() == 0 && pc.isDead()) {
					pc.setTempID(objid);
					pc.sendPackets(new S_Message_YN(322, ""));
				} else {
					pc.setCurrentHp(pc.getMaxHp());
					pc.setCurrentMp(pc.get_maxMp());
				}
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".heal"));
		}
	}

	private void gmRoom(L1PcInstance gm, String room) {
		try {
			int i = 0;
			try {
				i = Integer.parseInt(room);
			} catch (NumberFormatException e) {
			}
			if (i == 1) {
				L1Teleport.teleport(gm, 32737, 32796, (short) 99, 5, false);
			} else if (i == 2) {
				L1Teleport.teleport(gm, 33083, 33390, (short) 4, 5, false);
			} else if (i == 3) {
				L1Teleport.teleport(gm, 32644, 32955, (short) 0, 5, false);
			} else if (i == 4) {
				L1Teleport.teleport(gm, 33429, 32814, (short) 4, 5, false);
			} else if (i == 5) {
				L1Teleport.teleport(gm, 32894, 32535, (short) 300, 5, false);
			} else {
				L1Location loc = GMCommandsConfig.ROOMS.get(room.toLowerCase());
				if (loc == null) {
					gm.sendPackets(new S_SystemMessage(".gmroom 1-5 or .gmroom name"));
					return;
				}
				L1Teleport.teleport(gm, loc.getX(), loc.getY(), (short) loc.getMapId(), 5, false);
			}
		} catch (Exception exception) {
			gm.sendPackets(new S_SystemMessage(".gmroom 1-5 or .gmroom name"));
		}
	}

	private void jail(L1PcInstance gm, String name){
		try {
			L1PcInstance convict = getPcInstance(name);
			L1Teleport.teleport(convict , 32737, 32796, (short) 99, 5, true);
			convict.sendPackets(new S_SystemMessage(gm.getName()+" jailed you for bad behavior."));
			gm.sendPackets(new S_SystemMessage(name+" has been jailed."));
			broadcastToAll(name + " has been jailed for bad behaviour.");
		}
		catch (Exception exception) {
			gm.sendPackets(new S_SystemMessage(name + " does not seem to be online."));
		}
	}

	private void kick(L1PcInstance gm, String s) {
		L1PcInstance target = getPcInstance(s);
		if (target != null && !target.isGm()) {
			s=target.getName();
			target.sendPackets(new S_Disconnect());
			broadcastToAll(s+" got its arse kicked");
		} else if(target.isGm()) {
			gm.sendPackets(new S_SystemMessage("It is not possible to kick a GM."));
		} else {
			gm.sendPackets(new S_SystemMessage("That character is not online."));
		}
	}

	private void powerkick(L1PcInstance gm, String name) {
		L1PcInstance badPlayer = getPcInstance(name);
		if (badPlayer != null && !badPlayer.isGm()) {
			name=badPlayer.getName();
			Account.ban(badPlayer.getAccountName());
			IpTable.getInstance().banIp(badPlayer.getNetConnection().getIp());
			gm.sendPackets(new S_SystemMessage((new StringBuilder()).append(name).append(" is kicked and banned.").toString()));
			badPlayer.sendPackets(new S_Disconnect());
			broadcastToAll(name + " is banned. Bye bye!");
		} else if(badPlayer.isGm()) {
			gm.sendPackets(new S_SystemMessage("It is not possible to ban a GM."));
		} else {
			banOfflineChar(gm, name);
		}
	}

	private void banOfflineChar(L1PcInstance gm, String name){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String accountName = null;
		String ip = null;
		String error = "Character does not exist";
		int accesslevel = 0;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT account_name,IsGM FROM characters WHERE char_name=?");
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			rs.next();
			accountName = rs.getString(1);
			accesslevel = rs.getInt(2);
			SQLUtil.close(pstm);

			error = "Account does not exist.";
			pstm = con.prepareStatement("SELECT ip FROM accounts WHERE login=?");
			pstm.setString(1, accountName);
			rs = pstm.executeQuery();
			rs.next();
			ip = rs.getString(1);
			rs.close();
			SQLUtil.close(pstm);

			error = "No IP address in accounts table.";
			if(accesslevel == 200){
				gm.sendPackets(new S_SystemMessage("You cant ban a GM."));
			} else{
				IpTable.getInstance().banIp(ip);
				Account.ban(accountName);
				gm.sendPackets(new S_SystemMessage("Banned: "+ip+" ("+accountName+")"));
				broadcastToAll(name+" is banned. Bye bye!");
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(error));
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void unBan(L1PcInstance gm, String accountName){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String ip = null;
		String error = "Account does not exist.";
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT ip FROM accounts WHERE login=?");
			pstm.setString(1, accountName);
			rs = pstm.executeQuery();
			rs.next();
			ip = rs.getString(1);
			SQLUtil.close(pstm);

			error = "That account is not banned.";
			pstm = con.prepareStatement("DELETE FROM ban_ip WHERE ip=?");
			pstm.setString(1, ip);
			pstm.execute();
			rs.close();
			SQLUtil.close(pstm);

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE accounts SET banned=? WHERE login=?");
			pstm.setInt(1, 0);
			pstm.setString(2, accountName);
			pstm.execute();

			gm.sendPackets(new S_SystemMessage("Unbanned: "+ip+" ("+accountName+")"));
			//broadcastToAll(name+" is unbanned. Welcome back!");
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(error));
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void buff(L1PcInstance gm, String args, boolean buffMe) {
		try {
			StringTokenizer tok = new StringTokenizer(args);
			int skillId = Integer.parseInt(tok.nextToken());
			int time = 0;
			if (tok.hasMoreTokens()) {
				time = Integer.parseInt(tok.nextToken());
			}

			L1Skills skill = SkillsTable.getInstance().getTemplate(skillId);

			ArrayList<L1PcInstance> players = new ArrayList<L1PcInstance>();
			if (buffMe) {
				players.add(gm);
			} else {
				players = L1World.getInstance().getVisiblePlayer(gm);
			}
			if (skill.getTarget().equals("buff")) {
				for (L1PcInstance pc : players) {
					new L1SkillUse().handleCommands(gm, skillId, pc.getId(), pc.getX(), pc.getY(), null, time, L1SkillUse.TYPE_SPELLSC);
				}
			} else if (skill.getTarget().equals("none")) {
				for (L1PcInstance pc : players) {
					new L1SkillUse().handleCommands(pc, skillId, pc.getId(), pc.getX(), pc.getY(), null, time, L1SkillUse.TYPE_GMBUFF);
				}
			} else {
				gm.sendPackets(new S_SystemMessage("Skill does not exist."));
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".buff skillId time"));
		}
	}

	private void mobspawn(L1PcInstance gm, int i, int randomrange, boolean isPineWand) {
		try {
			L1Npc l1npc = NpcTable.getInstance().getTemplate(i);
			if (l1npc != null) {
				try {
					String s = l1npc.getImpl();
					Constructor<?> constructor = Class.forName("l1j.server.server.model.Instance." + s + "Instance").getConstructors()[0];
					Object aobj[] = { l1npc };
					L1NpcInstance npc = (L1NpcInstance) constructor.newInstance(aobj);
					npc.setId(IdFactory.getInstance().nextId());
					npc.setMap(gm.getMapId());
					if (randomrange == 0) {
						if (gm.getHeading() == 0) {
							npc.setX(gm.getX());
							npc.setY(gm.getY() - 1);
						} else if (gm.getHeading() == 1) {
							npc.setX(gm.getX() + 1);
							npc.setY(gm.getY() - 1);
						} else if (gm.getHeading() == 2) {
							npc.setX(gm.getX() + 1);
							npc.setY(gm.getY());
						} else if (gm.getHeading() == 3) {
							npc.setX(gm.getX() + 1);
							npc.setY(gm.getY() + 1);
						} else if (gm.getHeading() == 4) {
							npc.setX(gm.getX());
							npc.setY(gm.getY() + 1);
						} else if (gm.getHeading() == 5) {
							npc.setX(gm.getX() - 1);
							npc.setY(gm.getY() + 1);
						} else if (gm.getHeading() == 6) {
							npc.setX(gm.getX() - 1);
							npc.setY(gm.getY());
						} else if (gm.getHeading() == 7) {
							npc.setX(gm.getX() - 1);
							npc.setY(gm.getY() - 1);
						}
					} else {
						int tryCount = 0;
						do {
							tryCount++;
							npc.setX(gm.getX()
									+ (int) (Math.random() * randomrange)
									- (int) (Math.random() * randomrange));
							npc.setY(gm.getY()
									+ (int) (Math.random() * randomrange)
									- (int) (Math.random() * randomrange));
							if (npc.getMap().isInMap(npc.getLocation()) && npc.getMap().isPassable(npc.getLocation())) {
								break;
							}
							Thread.sleep(1);
						} while (tryCount < 50);

						if (tryCount >= 50) {
							if (gm.getHeading() == 0) {
								npc.setX(gm.getX());
								npc.setY(gm.getY() - 1);
							} else if (gm.getHeading() == 1) {
								npc.setX(gm.getX() + 1);
								npc.setY(gm.getY() - 1);
							} else if (gm.getHeading() == 2) {
								npc.setX(gm.getX() + 1);
								npc.setY(gm.getY());
							} else if (gm.getHeading() == 3) {
								npc.setX(gm.getX() + 1);
								npc.setY(gm.getY() + 1);
							} else if (gm.getHeading() == 4) {
								npc.setX(gm.getX());
								npc.setY(gm.getY() + 1);
							} else if (gm.getHeading() == 5) {
								npc.setX(gm.getX() - 1);
								npc.setY(gm.getY() + 1);
							} else if (gm.getHeading() == 6) {
								npc.setX(gm.getX() - 1);
								npc.setY(gm.getY());
							} else if (gm.getHeading() == 7) {
								npc.setX(gm.getX() - 1);
								npc.setY(gm.getY() - 1);
							}
						}
					}

					npc.setHomeX(npc.getX());
					npc.setHomeY(npc.getY());
					npc.setHeading(gm.getHeading());

					L1World.getInstance().storeObject(npc);
					L1World.getInstance().addVisibleObject(npc);
					if (spawnTF == true) {
						L1Object object = L1World.getInstance().findObject(npc.getId());
						L1NpcInstance newnpc = (L1NpcInstance) object;
						newnpc.onNpcAI();
					}
					if (isPineWand) {
						L1NpcDeleteTimer timer = new L1NpcDeleteTimer(npc, 300000);
						timer.begin();
					}
				} catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
		} catch (Exception exception) {
		}
	}

	public void mobspawn(ClientThread client, int i, int randomrange, boolean isPineWand) {
		mobspawn(client.getActiveChar(), i, randomrange, isPineWand);
	}

	private void gfxId(L1PcInstance gm, String param) {
		try {
			StringTokenizer st = new StringTokenizer(param);
			int gfxid = Integer.parseInt(st.nextToken(), 10);
			int count = Integer.parseInt(st.nextToken(), 10);
			for (int i = 0; i < count; i++) {
				L1Npc l1npc = NpcTable.getInstance().getTemplate(45001);
				if (l1npc != null) {
					String s = l1npc.getImpl();
					Constructor<?> constructor = Class.forName("l1j.server.server.model.Instance." + s + "Instance").getConstructors()[0];
					Object aobj[] = { l1npc };
					L1NpcInstance npc = (L1NpcInstance) constructor.newInstance(aobj);
					npc.setId(IdFactory.getInstance().nextId());
					npc.setGfxId(gfxid + i);
					npc.setNameId("");
					npc.setMap(gm.getMapId());
					npc.setX(gm.getX() + i * 2);
					npc.setY(gm.getY() + i * 2);
					npc.setHomeX(npc.getX());
					npc.setHomeY(npc.getY());
					npc.setHeading(4);

					L1World.getInstance().storeObject(npc);
					L1World.getInstance().addVisibleObject(npc);
				}
			}
		} catch (Exception exception) {
			gm.sendPackets(new S_SystemMessage(".gfxid id count"));
		}
	}

	private void invGfxId(L1PcInstance pc, String param) {
		try {
			StringTokenizer st = new StringTokenizer(param);
			int gfxid = Integer.parseInt(st.nextToken(), 10);
			int count = Integer.parseInt(st.nextToken(), 10);
			for (int i = 0; i < count; i++) {
				L1ItemInstance item = ItemTable.getInstance().createItem(40005);
				item.getItem().setGfxId(gfxid + i);
				item.getItem().setName(String.valueOf(gfxid + i));
				pc.getInventory().storeItem(item);
			}
		} catch (Exception exception) {
			pc.sendPackets(new S_SystemMessage(".invgfxid ID count"));
		}
	}

	private void action(L1PcInstance pc, String param) {
		try {
			StringTokenizer st = new StringTokenizer(param);
			int actId = Integer.parseInt(st.nextToken(), 10);
			pc.sendPackets(new S_DoActionGFX(pc.getId(), actId));
		} catch (Exception exception) {
			pc.sendPackets(new S_SystemMessage(".action actID"));
		}
	}

	private void banIp(L1PcInstance gm, String param) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(param);
			String s1 = stringtokenizer.nextToken();
			String s2 = null;
			try {
				s2 = stringtokenizer.nextToken();
			} catch (Exception e) {
			}
			IpTable iptable = IpTable.getInstance();
			boolean isBanned = iptable.isBannedIp(s1);

			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (s1.equals(pc.getNetConnection().getIp())) {
					String msg = new StringBuilder().append("IP:").append(s1).append(" with character:").append(pc.getName()).toString();
					gm.sendPackets(new S_SystemMessage(msg));
				}
			}
			if ("add".equals(s2) && !isBanned) {
				iptable.banIp(s1);
				String msg = new StringBuilder().append("IP:").append(s1).append(" has been banned").toString();
				gm.sendPackets(new S_SystemMessage(msg));
			} else if ("del".equals(s2) && isBanned) {
				if (iptable.liftBanIp(s1)) {
					String msg = new StringBuilder().append("IP:").append(s1).append(" has been unbanned").toString();
					gm.sendPackets(new S_SystemMessage(msg));
				}
			} else {
				if (isBanned) {
					String msg = new StringBuilder().append("IP:").append(s1).append(" is banned").toString();
					gm.sendPackets(new S_SystemMessage(msg));
				} else {
					String msg = new StringBuilder().append("IP:").append(s1).append(" is not banned").toString();
					gm.sendPackets(new S_SystemMessage(msg));
				}
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".banip IP [add|del]"));
		}
	}

	private void who(L1PcInstance gm, String name) {  
		try{
			L1PcInstance target = getPcInstance(name.trim());
			if(target == null) {
				gm.sendPackets(new S_SystemMessage("-"+name.trim()+"-"));
				whoOffline(gm, name);
			} else {
				gm.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(target.getName())
						.append("(").append(target.getAccountName())
						.append("): L").append(target.getLevel())
						.append(" ").append(getSex(target.getClassId()))
						.append(" ").append(getClass(target.getClassId()))
						.append(" ").append(target.getMaxHp())
						.append("/").append(target.get_maxMp()+ " | ")
						.append("Dmg: +" + gm.getDmgup() + " | ")
						.append("Hit: +" + gm.getHitup() + " | ")
						.append("MR: " + gm.getMr() + " | ")
						.append("HPR: " + gm.getHpr() + gm.getInventory().hpRegenPerTick() + " | ")
						.append("MPR: " + gm.getMpr() + gm.getInventory().mpRegenPerTick() + " | ")
						.append("Karma: " + gm.getKarma() + " | ")
						.append("MR: ").append(target.getMr()).append(" | ")
						.append("Items: " + gm.getInventory().getSize())
						.toString()));
			}
		} catch (Exception exception) {
			whoOffline(gm, name);
		}
	}
	private void who(L1PcInstance gm) {
		try{
			String charC = "";
			String charS = "";
			int i = 1;
			for (L1PcInstance player : L1World.getInstance().getAllPlayers()){
				charC = getClass(player.getClassId());
				charS = getSex(player.getClassId());
				gm.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(i).append(". ") .append(player.getName())
						.append("(").append(player.getAccountName())
						.append("): L").append(player.getLevel())
						.append(" ").append(charS).append(" ").append(charC)
						.append(" ").append(player.getMaxHp())
						.append("/").append(player.get_maxMp())
						.append(" ").append(player.getMr()).append("MR")
						.toString()));
				i++;
			}
		} catch (Exception exception) {
		}
	}
	private void whoOffline(L1PcInstance gm, String name) {  
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT account_name,char_name,level,MaxHp,MaxMp,Class FROM characters WHERE char_name=?");
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			rs.next();
			gm.sendPackets(new S_SystemMessage((new StringBuilder())
					.append(rs.getString("char_name"))
					.append("(").append(rs.getString("account_name"))
					.append("): L").append(rs.getInt("level"))
					.append(" ").append(getSex(rs.getInt("Class")))
					.append(" ").append(getClass(rs.getInt("Class")))
					.append(" ").append(rs.getInt("MaxHp"))
					.append("/").append(rs.getInt("MaxMp"))
					.append(" (Offline)")
					.toString()));
		} catch (Exception exception) {
			gm.sendPackets(new S_SystemMessage("'" + name + "' is not an existing character."));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static boolean isHpBarTarget(L1Object obj) {
		if (obj instanceof L1MonsterInstance) {
			return true;
		}
		if (obj instanceof L1PcInstance) {
			return true;
		}
		if (obj instanceof L1SummonInstance) {
			return true;
		}
		if (obj instanceof L1PetInstance) {
			return true;
		}
		return false;
	}

	private void hpBar(L1PcInstance gm) {
		if(gm.hasSkillEffect(GMSTATUS_HPBAR)) {
			gm.removeSkillEffect(GMSTATUS_HPBAR);
			for (L1Object obj : gm.getKnownObjects()) {
				if (isHpBarTarget(obj)) {
					gm.sendPackets(new S_HPMeter(obj.getId(), 0xFF));
				}
			}
			gm.sendPackets(new S_SystemMessage("HPBars is deactivated."));
		} else {
			gm.setSkillEffect(GMSTATUS_HPBAR, 0);
			gm.sendPackets(new S_SystemMessage("HPBars is activated."));
		}
	}

	private void reloadTraps() {
		L1WorldTraps.reloadTraps();
	}

	private void showTraps(L1PcInstance gm) {
		if (gm.hasSkillEffect(GMSTATUS_SHOWTRAPS)) {
			gm.removeSkillEffect(GMSTATUS_SHOWTRAPS);
			for (L1Object obj : gm.getKnownObjects()) {
				if (obj instanceof L1TrapInstance) {
					gm.removeKnownObject(obj);
					gm.sendPackets(new S_RemoveObject(obj));
				}
			}
			gm.sendPackets(new S_SystemMessage("Traps are invisible."));
		} else {
			gm.setSkillEffect(GMSTATUS_SHOWTRAPS, 0);
			gm.sendPackets(new S_SystemMessage("Traps are visible."));
		}
	}

	private void redo(L1PcInstance gm, String param) {
		try {
			if (_lastCmd.isEmpty()) {
				gm.sendPackets(new S_SystemMessage("No command found"));
				return;
			}
			if (param.isEmpty()) {
				gm.sendPackets(new S_SystemMessage("No parameters for " + _lastCmd));
				handleCommands(gm, _lastCmd);
			} else {
				StringTokenizer token = new StringTokenizer(_lastCmd);
				String cmd = token.nextToken() + " " + param;
				gm.sendPackets(new S_SystemMessage("Doing " + cmd));
				handleCommands(gm, cmd);
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			gm.sendPackets(new S_SystemMessage(".r (?)"));
		}
	}

	private String _faviCom = "";

	private void favorite(L1PcInstance gm, String param) {
		try {
			if (param.startsWith("set")) {
				StringTokenizer st = new StringTokenizer(param);
				st.nextToken();
				if (!st.hasMoreTokens()) {
					gm.sendPackets(new S_SystemMessage("f ?"));
					return;
				}
				StringBuilder cmd = new StringBuilder();
				String temp = st.nextToken();
				if (temp.equalsIgnoreCase("f")) {
					gm.sendPackets(new S_SystemMessage("f ?"));
					return;
				}
				cmd.append(temp + " ");
				while (st.hasMoreTokens()) {
					cmd.append(st.nextToken() + " ");
				}
				_faviCom = cmd.toString().trim();
				gm.sendPackets(new S_SystemMessage(_faviCom + " '"));
			} else if (param.startsWith("show")) {
				gm.sendPackets(new S_SystemMessage("123: " + _faviCom));
			} else if (_faviCom.isEmpty()) {
				gm.sendPackets(new S_SystemMessage(""));
			} else {
				StringBuilder cmd = new StringBuilder();
				StringTokenizer st = new StringTokenizer(param);
				StringTokenizer st2 = new StringTokenizer(_faviCom);
				while (st2.hasMoreTokens()) {
					String temp = st2.nextToken();
					if (temp.startsWith("%")) {
						cmd.append(st.nextToken() + " ");
					} else {
						cmd.append(temp + " ");
					}
				}
				while (st.hasMoreTokens()) {
					cmd.append(st.nextToken() + " ");
				}
				gm.sendPackets(new S_SystemMessage(cmd + " "));
				handleCommands(gm, cmd.toString());
			}
		} catch (Exception e) {
			gm.sendPackets(new S_SystemMessage(".f set | .f show | .f []"));
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}
}
