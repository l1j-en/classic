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

package l1j.server.server.clientpackets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.BadNamesList;
import l1j.server.server.ClientThread;
import l1j.server.server.IdFactory;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.model.Beginner;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_AddSkill;
import l1j.server.server.serverpackets.S_CharCreateStatus;
import l1j.server.server.serverpackets.S_NewCharPacket;
import l1j.server.server.templates.L1Skills;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_CreateChar extends ClientBasePacket {

	private static Logger _log = Logger.getLogger(C_CreateChar.class.getName());

	private static final String C_CREATE_CHAR = "[C] C_CreateChar";

	public C_CreateChar(byte[] abyte0, ClientThread client)
			throws Exception {
		super(abyte0);
		L1PcInstance pc = new L1PcInstance();
		String name = readS();
		name = name.replaceAll("\\s", ""); 
        name = name.replaceAll("@", "");  
        if (name.length() == 0) {  
        S_CharCreateStatus s_charcreatestatus = new S_CharCreateStatus(  
        S_CharCreateStatus.REASON_INVALID_NAME);  
        client.sendPacket(s_charcreatestatus);  
        return;  
        } 
		if (isInvalidName(name)) {
			S_CharCreateStatus s_charcreatestatus = new S_CharCreateStatus(
					S_CharCreateStatus.REASON_INVALID_NAME);
			client.sendPacket(s_charcreatestatus);
			return;
		}

		if (CharacterTable.doesCharNameExist(name)) {
			_log.fine("Charname: " + pc.getName()
					+ " already exists. creation failed.");
			S_CharCreateStatus s_charcreatestatus1 = new S_CharCreateStatus(
					S_CharCreateStatus.REASON_ALREADY_EXSISTS);
			client.sendPacket(s_charcreatestatus1);
			return;
		}
		
		if (client.getAccount().countCharacters() >= 4) {
			_log.fine("Account: " + client.getAccountName()
					+ " attempted to create more than 4 characters.");
			S_CharCreateStatus s_charcreatestatus1 = new S_CharCreateStatus(
					S_CharCreateStatus.REASON_WRONG_AMOUNT);
			client.sendPacket(s_charcreatestatus1);
			return;
		}

		pc.setName(name);
		pc.setType(readC());
		pc.set_sex(readC());
		pc.addBaseStr((byte) readC());
		pc.addBaseDex((byte) readC());
		pc.addBaseCon((byte) readC());
		pc.addBaseWis((byte) readC());
		pc.addBaseCha((byte) readC());
		pc.addBaseInt((byte) readC());

		int statusAmount = pc.getDex() + pc.getCha() + pc.getCon()
				+ pc.getInt() + pc.getStr() + pc.getWis();

		if (statusAmount != 75) {
			_log.finest("Character have wrong value");
			S_CharCreateStatus s_charcreatestatus3 = new S_CharCreateStatus(
					S_CharCreateStatus.REASON_WRONG_AMOUNT);
			client.sendPacket(s_charcreatestatus3);
			return;
		}

		_log.fine("charname: " + pc.getName() + " classId: " + pc.getClassId());
		S_CharCreateStatus s_charcreatestatus2 = new S_CharCreateStatus(S_CharCreateStatus.REASON_OK);
		client.sendPacket(s_charcreatestatus2);
		initNewChar(client, pc);
	}

	private static final int[] MALE_LIST = new int[] { 0, 61, 138, 734, 2786 };
	private static final int[] FEMALE_LIST = new int[] { 1, 48, 37, 1186, 2796 };
	private static final int[] LOCX_LIST = new int[] { 33090, 33090, 33090, 33090, 33090 };//{ 32734, 32734, 32734, 32734, 32734 };
	private static final int[] LOCY_LIST = new int[] { 33392, 33392, 33392, 33392, 33392 };//{ 32798, 32798, 32798, 32798, 32798 };
	private static final short[] MAPID_LIST = new short[] { 4, 4, 4, 4, 4 };

	private static final int[] LOCX_LIST_ORG = new int[] { 32780, 32714, 33043, 32780, 32876 };
	private static final int[] LOCY_LIST_ORG = new int[] { 32781, 32877, 32336, 32781, 32910 };
	private static final short[] MAPID_LIST_ORG = new short[] { 68, 69, 4, 68, 304 };

	private static void initNewChar(ClientThread client, L1PcInstance pc) throws IOException, Exception {

		short init_hp = 0;
		short init_mp = 0;

		pc.setId(IdFactory.getInstance().nextId());
		if (pc.get_sex() == 0) {
			pc.setClassId(MALE_LIST[pc.getType()]);
		} else {
			pc.setClassId(FEMALE_LIST[pc.getType()]);
		}

		if(Config.SKT_START) {
			pc.setX(LOCX_LIST[pc.getType()]);
			pc.setY(LOCY_LIST[pc.getType()]);
			pc.setMap(MAPID_LIST[pc.getType()]);
		} else {
			pc.setX(LOCX_LIST_ORG[pc.getType()]);
			pc.setY(LOCY_LIST_ORG[pc.getType()]);
			pc.setMap(MAPID_LIST_ORG[pc.getType()]);
		}
		pc.setHeading(0);
		pc.setLawful(0);
		if (pc.isCrown()) {
			init_hp = 14;
			switch (pc.getWis()) {
			case 11:
				init_mp = 2;
				break;
			case 12:
			case 13:
			case 14:
			case 15:
				init_mp = 3;
				break;
			case 16:
			case 17:
			case 18:
				init_mp = 4;
				break;
			default:
				init_mp = 2;
				break;
			}
		} else if (pc.isKnight()) { 
			init_hp = 16;
			switch (pc.getWis()) {
			case 9:
			case 10:
			case 11:
				init_mp = 1;
				break;
			case 12:
			case 13:
				init_mp = 2;
				break;
			default:
				init_mp = 1;
				break;
			}
		} else if (pc.isElf()) { 
			init_hp = 15;
			switch (pc.getWis()) {
			case 12:
			case 13:
			case 14:
			case 15:
				init_mp = 4;
				break;
			case 16:
			case 17:
			case 18:
				init_mp = 6;
				break;
			default:
				init_mp = 4;
				break;
			}
		} else if (pc.isWizard()) { // WIZ
			init_hp = 12;
			switch (pc.getWis()) {
			case 12:
			case 13:
			case 14:
			case 15:
				init_mp = 6;
				break;
			case 16:
			case 17:
			case 18:
				init_mp = 8;
				break;
			default:
				init_mp = 6;
				break;
			}
		} else if (pc.isDarkelf()) { // DE
			init_hp = 12;
			switch (pc.getWis()) {
			case 10:
			case 11:
				init_mp = 3;
				break;
			case 12:
			case 13:
			case 14:
			case 15:
				init_mp = 4;
				break;
			case 16:
			case 17:
			case 18:
				init_mp = 6;
				break;
			default:
				init_mp = 3;
				break;
			}
		}
		pc.addBaseMaxHp(init_hp);
		pc.setCurrentHp(init_hp);
		pc.addBaseMaxMp(init_mp);
		pc.setCurrentMp(init_mp);
		pc.resetBaseAc();
		pc.setTitle("");
		pc.setClanid(0);
		pc.setClanRank(0);
		pc.set_food(3);

		int accessLevel = client.getAccount().getAccessLevel();
		pc.setAccessLevel((short) accessLevel);
		if(accessLevel == 200){
			pc.setGm(true);
			pc.setMonitor(false);
		} else if(accessLevel == 100) {
			pc.setGm(false);
			pc.setMonitor(true);
		} else {
			pc.setGm(false);
			pc.setMonitor(false);
		}

		pc.setGmInvis(false);
		pc.setExp(0);
		pc.setHighLevel(0);
		pc.setStatus(0);
		pc.setAccessLevel((short) 0);
		pc.setClanname("");
		pc.setBonusStats(0);
		pc.setElixirStats(0);
		pc.resetBaseMr();
		pc.setElfAttr(0);
		pc.set_PKcount(0);
		pc.setExpRes(0);
		pc.setPartnerId(0);
		pc.setOnlineStatus(0);
		pc.setHomeTownId(0);
		pc.setContribution(0);
		pc.setBanned(false);
		pc.setKarma(0);
		if (pc.isWizard()) { // WIZ
			pc.sendPackets(new S_AddSkill(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			int object_id = pc.getId();
			L1Skills l1skills = SkillsTable.getInstance().getTemplate(4); // EB
			String skill_name = l1skills.getName();
			int skill_id = l1skills.getSkillId();
			SkillsTable.getInstance().spellMastery(object_id, skill_id,
					skill_name, 0, 0); 
		}
		Beginner.getInstance().GiveItem(pc);
		pc.setAccountName(client.getAccountName());
		CharacterTable.getInstance().storeNewCharacter(pc);
		S_NewCharPacket s_newcharpacket = new S_NewCharPacket(pc);
		client.sendPacket(s_newcharpacket);
	}

	private static boolean isAlphaNumeric(String s) {
		boolean flag = true;
		char ac[] = s.toCharArray();
		int i = 0;
		do {
			if (i >= ac.length) {
				break;
			}
			if (!Character.isLetterOrDigit(ac[i])) {
				flag = false;
				break;
			}
			i++;
		} while (true);
		return flag;
	}

	private static boolean isInvalidName(String name) {
		int numOfNameBytes = 0;
		try {
			numOfNameBytes = name.getBytes("UTF-8").length;
		} catch (UnsupportedEncodingException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			return false;
		}

		if (isAlphaNumeric(name)) {
			return false;
		}

		if (5 < (numOfNameBytes - name.length()) || 12 < numOfNameBytes) {
			return false;
		}

		if (BadNamesList.getInstance().isBadName(name)) {
			return false;
		}
		return true;
	}

	@Override
	public String getType() {
		return C_CREATE_CHAR;
	}
}
