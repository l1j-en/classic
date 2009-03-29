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

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ClientThread;
import l1j.server.server.WarTimeController;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ClanTable;
import l1j.server.server.datatables.HouseTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1ChatParty;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Party;
import l1j.server.server.model.L1Quest;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1War;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.model.map.L1Map;
import l1j.server.server.serverpackets.S_ChangeName;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_OwnCharStatus2;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_Resurrection;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_Trade;
import l1j.server.server.templates.L1House;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Pet;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_Attr extends ClientBasePacket {

	private static final Logger _log = Logger.getLogger(C_Attr.class.getName());
	private static final String C_ATTR = "[C] C_Attr";

	public C_Attr(byte abyte0[], ClientThread clientthread) throws Exception {
		super(abyte0);
		int i = readH();
		int c;
		String name;

		L1PcInstance pc = clientthread.getActiveChar();

		switch (i) {
		case 97: 
			c = readC();
			L1PcInstance joinPc = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getTempID());
			pc.setTempID(0);
			if (joinPc != null) {
				if (c == 0) { // No
					joinPc.sendPackets(new S_ServerMessage(96, pc
							.getName()));
				} else if (c == 1) { // Yes
					int clan_id = pc.getClanid();
					String clanName = pc.getClanname();
					L1Clan clan = L1World.getInstance().getClan(clanName);
					if (clan != null) {
						int maxMember = 0;
						int charisma = pc.getCha();
						boolean lv45quest = false;
						if (pc.getQuest().isEnd(L1Quest.QUEST_LEVEL45)) {
							lv45quest = true;
						}
						if (pc.getLevel() >= 50) { // Lv50
							if (lv45quest == true) { // Lv45
								maxMember = charisma * 9;
							} else {
								maxMember = charisma * 3;
							}
						} else { // Lv50
							if (lv45quest == true) { // Lv45
								maxMember = charisma * 6;
							} else {
								maxMember = charisma * 2;
							}
						}
						if (Config.MAX_CLAN_MEMBER > 0) { 
							maxMember = Config.MAX_CLAN_MEMBER;
						}

						if (joinPc.getClanid() == 0) { 
							String clanMembersName[] = clan.getAllMembers();
							if (maxMember <= clanMembersName.length) {
								joinPc.sendPackets(
										new S_ServerMessage(188, pc.getName()));
								return;
							}
							for (L1PcInstance clanMembers : clan
									.getOnlineClanMember()) {
								clanMembers.sendPackets(new S_ServerMessage(94,
										joinPc.getName())); 
							}
							joinPc.setClanid(clan_id);
							joinPc.setClanname(clanName);
							joinPc.setClanRank(L1Clan.CLAN_RANK_PUBLIC);
							joinPc.save(); 
							clan.addMemberName(joinPc.getName());
							joinPc.sendPackets(new S_ServerMessage(95,
									clanName));
						} else {
							if (Config.CLAN_ALLIANCE) {
								changeClan(clientthread, pc, joinPc, maxMember);
							} else {
								joinPc.sendPackets(new S_ServerMessage(89)); 
							}
						}
					}
				}
			}
			break;

		case 217: 
		case 221: 
		case 222:
			c = readC();
			L1PcInstance enemyLeader = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getTempID());
			if (enemyLeader == null) {
				return;
			}
			pc.setTempID(0);
			String clanName = pc.getClanname();
			String enemyClanName = enemyLeader.getClanname();
			if (c == 0) { // No
				if (i == 217) {
					enemyLeader.sendPackets(new S_ServerMessage(236, clanName));
				} else if (i == 221 || i == 222) {
					enemyLeader.sendPackets(new S_ServerMessage(237, clanName)); 
				}
			} else if (c == 1) { // Yes
				if (i == 217) {
					L1War war = new L1War();
					war.handleCommands(2, enemyClanName, clanName);
				} else if (i == 221 || i == 222) {
					for (L1War war : L1World.getInstance().getWarList()) {
						if (war.CheckClanInWar(clanName)) { 
							if (i == 221) {
								war.SurrenderWar(enemyClanName, clanName); 
							} else if (i == 222) {
								war.CeaseWar(enemyClanName, clanName);
							}
							break;
						}
					}
				}
			}
			break;

		case 252:
			c = readC();
			L1PcInstance trading_partner = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getTradeID());
			if (trading_partner != null) {
				if (c == 0) // No
				{
					trading_partner.sendPackets(new S_ServerMessage(253, pc
							.getName())); 
					pc.setTradeID(0);
					trading_partner.setTradeID(0);
				} else if (c == 1) // Yes
				{
					pc.sendPackets(new S_Trade(trading_partner.getName()));
					trading_partner.sendPackets(new S_Trade(pc.getName()));
				}
			}
			break;

		case 321: 
			c = readC();
			L1PcInstance resusepc1 = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getTempID());
			pc.setTempID(0);
			if (resusepc1 != null) { 
				if (c == 0) { // No
					;
				} else if (c == 1) { // Yes
					pc.sendPackets(new S_SkillSound(pc.getId(), '\346'));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), '\346'));
					pc.resurrect(pc.getMaxHp() / 2);
					pc.setCurrentHp(pc.getMaxHp() / 2);
					pc.startHpRegeneration();
					pc.startMpRegeneration();
					pc.startMpRegenerationByDoll();
					pc.sendPackets(new S_Resurrection(pc, resusepc1, 0));
					pc.broadcastPacket(new S_Resurrection(pc, resusepc1, 0));
					pc.sendPackets(new S_CharVisualUpdate(pc));
					pc.broadcastPacket(new S_CharVisualUpdate(pc));
				}
			}
			break;

		case 322:
			c = readC();
			L1PcInstance resusepc2 = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getTempID());
			pc.setTempID(0);
			if (resusepc2 != null) {
				if (c == 0) { // No
					;
				} else if (c == 1) { // Yes
					pc.sendPackets(new S_SkillSound(pc.getId(), '\346'));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), '\346'));
					pc.resurrect(pc.getMaxHp());
					pc.setCurrentHp(pc.getMaxHp());
					pc.startHpRegeneration();
					pc.startMpRegeneration();
					pc.startMpRegenerationByDoll();
					pc.sendPackets(new S_Resurrection(pc, resusepc2, 0));
					pc.broadcastPacket(new S_Resurrection(pc, resusepc2, 0));
					pc.sendPackets(new S_CharVisualUpdate(pc));
					pc.broadcastPacket(new S_CharVisualUpdate(pc));
				
					if (pc.getExpRes() == 1 && pc.isGres() && pc.isGresValid()) {
						pc.resExp();
						pc.setExpRes(0);
						pc.setGres(false);
					}
				}
			}
			break;

		case 325:
			c = readC(); 
			name = readS();
			L1PetInstance pet = (L1PetInstance) L1World.getInstance()
					.findObject(pc.getTempID());
			pc.setTempID(0);
			renamePet(pet, name);
			break;

		case 512:
			c = readC();
			name = readS();
			int houseId = pc.getTempID();
			pc.setTempID(0);
			if (name.length() <= 16) {
				L1House house = HouseTable.getInstance().getHouseTable(houseId);
				house.setHouseName(name);
				HouseTable.getInstance().updateHouse(house);
			} else {
				pc.sendPackets(new S_ServerMessage(513)); 
			}
			break;

		case 630: 
			c = readC();
			L1PcInstance fightPc = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getFightId());
			if (c == 0) {
				pc.setFightId(0);
				fightPc.setFightId(0);
				fightPc.sendPackets(new S_ServerMessage(631, pc.getName())); //
			} else if (c == 1) {
				fightPc.sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL,
						fightPc.getFightId(), fightPc.getId()));
				pc.sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL, pc
						.getFightId(), pc.getId()));
			}
			break;

		case 653: //
			c = readC();
			if (c == 0) { // No
				;
			} else if (c == 1) { // Yes
				pc.setPartnerId(0);
				pc.save();
			}
			break;

		case 654: 
			c = readC();
			L1PcInstance partner = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getTempID());
			pc.setTempID(0);
			if (partner != null) {
				if (c == 0) { // No
					partner.sendPackets(new S_ServerMessage(
							656, pc.getName()));
				} else if (c == 1) { // Yes
					pc.setPartnerId(partner.getId());
					pc.save();
					pc.sendPackets(new S_ServerMessage(
							790));
					pc.sendPackets(new S_ServerMessage( 
							655, partner.getName()));

					partner.setPartnerId(pc.getId());
					partner.save();
					partner.sendPackets(new S_ServerMessage(
							790));
					partner.sendPackets(new S_ServerMessage( 
							655, pc.getName()));
				}
			}
			break;


		case 729: //
			c = readC();
			if (c == 0) { // No
				;
			} else if (c == 1) { // Yes
				callClan(pc);
			}
			break;

		case 738: 
			c = readC();
			if (c == 0) { // No
				;
			} else if (c == 1 && pc.getExpRes() == 1) { // Yes
				int cost = 0;
				int level = pc.getLevel();
				int lawful = pc.getLawful();
				if (level < 45) {
					cost = level * level * 100;
				} else {
					cost = level * level * 200;
				}
				if (lawful >= 0) {
					cost = (cost / 2);
				}
				if (pc.getInventory().consumeItem(L1ItemId.ADENA, cost)) {
					pc.resExp();
					pc.setExpRes(0);
				} else {
					pc.sendPackets(new S_ServerMessage(189)); //
				}
			}
			break;

		case 951: //
			c = readC();
			L1PcInstance chatPc = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getPartyID());
			if (chatPc != null) {
				if (c == 0) { // No
					chatPc.sendPackets(new S_ServerMessage(423, pc.getName()));  
					pc.setPartyID(0);
				} else if (c == 1) { // Yes
					if (chatPc.isInChatParty()) {
						if (chatPc.getChatParty().isVacancy() || chatPc
								.isGm()) {
							chatPc.getChatParty().addMember(pc);
						} else {
							chatPc.sendPackets(new S_ServerMessage(417));
						}
					} else {
						L1ChatParty chatParty = new L1ChatParty();
						chatParty.addMember(chatPc);
						chatParty.addMember(pc);
						chatPc.sendPackets(new S_ServerMessage(424, pc
								.getName())); 
					}
				}
			}
			break;

		case 953:
			c = readC();
			L1PcInstance target = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getPartyID());
			if (target != null) {
				if (c == 0) // No
				{
					target.sendPackets(new S_ServerMessage(423, pc.getName()));
					pc.setPartyID(0);
				} else if (c == 1) // Yes
				{
					if (target.isInParty()) {

						if (target.getParty().isVacancy() || target.isGm()) {
							target.getParty().addMember(pc);
						} else {

							target.sendPackets(new S_ServerMessage(417));
						}
					} else {
						L1Party party = new L1Party();
						party.addMember(target);
						party.addMember(pc);
						target.sendPackets(new S_ServerMessage(424, pc
								.getName()));
					}
				}
			}
			break;

		case 479:
			if (readC() == 1) {
				String s = readS();
				if (!(pc.getLevel() - 50 > pc.getBonusStats())) {
					return;
				}
				if (s.toLowerCase().equals("str".toLowerCase())) {
					if (pc.getBaseStr() < 25) {
						pc.addBaseStr((byte) 1); 
						pc.setBonusStats(pc.getBonusStats() + 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.save(); 
					} else {
						pc.sendPackets(new S_ServerMessage(481));
					}
				} else if (s.toLowerCase().equals("dex".toLowerCase())) {
					if (pc.getBaseDex() < 25) {
						pc.addBaseDex((byte) 1); 
						pc.resetBaseAc();
						pc.setBonusStats(pc.getBonusStats() + 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.save(); 
					} else {
						pc.sendPackets(new S_ServerMessage(481)); 
					}
				} else if (s.toLowerCase().equals("con".toLowerCase())) {
					if (pc.getBaseCon() < 25) {
						pc.addBaseCon((byte) 1);
						pc.setBonusStats(pc.getBonusStats() + 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.save(); 
					} else {
						pc.sendPackets(new S_ServerMessage(481)); 
					}
				} else if (s.toLowerCase().equals("int".toLowerCase())) {
					if (pc.getBaseInt() < 25) {
						pc.addBaseInt((byte) 1);
						pc.setBonusStats(pc.getBonusStats() + 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.save(); 
					} else {
						pc.sendPackets(new S_ServerMessage(481)); 
					}
				} else if (s.toLowerCase().equals("wis".toLowerCase())) {
					if (pc.getBaseWis() < 25) {
						pc.addBaseWis((byte) 1);
						pc.resetBaseMr();
						pc.setBonusStats(pc.getBonusStats() + 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.save(); 
					} else {
						pc.sendPackets(new S_ServerMessage(481));
					}
				} else if (s.toLowerCase().equals("cha".toLowerCase())) {
					if (pc.getBaseCha() < 25) {
						pc.addBaseCha((byte) 1); 
						pc.setBonusStats(pc.getBonusStats() + 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.save(); 
					} else {
						pc.sendPackets(new S_ServerMessage(481)); 
					}
				}
			}
			break;
		default:
			break;
		}
	}

	private void changeClan(ClientThread clientthread,
			L1PcInstance pc, L1PcInstance joinPc, int maxMember) {
		int clanId = pc.getClanid();
		String clanName = pc.getClanname();
		L1Clan clan = L1World.getInstance().getClan(clanName);
		String clanMemberName[] = clan.getAllMembers();
		int clanNum = clanMemberName.length;

		int oldClanId = joinPc.getClanid();
		String oldClanName = joinPc.getClanname();
		L1Clan oldClan = L1World.getInstance().getClan(oldClanName);
		String oldClanMemberName[] = oldClan.getAllMembers();
		int oldClanNum = oldClanMemberName.length;
		if (clan != null && oldClan != null && joinPc.isCrown() &&
				joinPc.getId() == oldClan.getLeaderId()) {
			if (maxMember < clanNum + oldClanNum) {
				joinPc.sendPackets(
						new S_ServerMessage(188, pc.getName()));
				return;
			}
			L1PcInstance clanMember[] = clan.getOnlineClanMember();
			for (int cnt = 0; cnt < clanMember.length; cnt++) {
				clanMember[cnt].sendPackets(new S_ServerMessage(94, joinPc
						.getName())); 
			}

			for (int i = 0; i < oldClanMemberName.length; i++) {
				L1PcInstance oldClanMember = L1World.getInstance().getPlayer(
						oldClanMemberName[i]);
				if (oldClanMember != null) {
					oldClanMember.setClanid(clanId);
					oldClanMember.setClanname(clanName);
					if (oldClanMember.getId() == joinPc.getId()) {
						oldClanMember.setClanRank(L1Clan.CLAN_RANK_GUARDIAN);
					} else {
						oldClanMember.setClanRank(L1Clan.CLAN_RANK_PROBATION);
					}
					try {
						//
						oldClanMember.save();
					} catch (Exception e) {
						_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
					clan.addMemberName(oldClanMember.getName());
					oldClanMember.sendPackets(new S_ServerMessage(95,
							clanName)); //
				} else { //
					try {
						L1PcInstance offClanMember = CharacterTable
								.getInstance().restoreCharacter(
										oldClanMemberName[i]);
						offClanMember.setClanid(clanId);
						offClanMember.setClanname(clanName);
						offClanMember.setClanRank(L1Clan.CLAN_RANK_PROBATION);
						offClanMember.save(); 
						clan.addMemberName(offClanMember.getName());
					} catch (Exception e) {
						_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
			}
			String emblem_file = String.valueOf(oldClanId);
			File file = new File("emblem/" + emblem_file);
			file.delete();
			ClanTable.getInstance().deleteClan(oldClanName);
		}
	}

	private static void renamePet(L1PetInstance pet, String name) {
		if (pet == null || name == null) {
			throw new NullPointerException();
		}

		int petItemObjId = pet.getItemObjId();
		L1Pet petTemplate = PetTable.getInstance().getTemplate(petItemObjId);
		if (petTemplate == null) {
			throw new NullPointerException();
		}

		L1PcInstance pc = (L1PcInstance) pet.getMaster();
		if (PetTable.isNameExists(name)) {
			pc.sendPackets(new S_ServerMessage(327)); 
			return;
		}
		L1Npc l1npc = NpcTable.getInstance().getTemplate(pet.getNpcId());
		if (!(pet.getName().equalsIgnoreCase(l1npc.get_name())) ) {
			pc.sendPackets(new S_ServerMessage(326)); 
			return;
		}
 		pet.setName(name);
		petTemplate.set_name(name);
		PetTable.getInstance().storePet(petTemplate); 
		L1ItemInstance item = pc.getInventory().getItem(pet.getItemObjId());
		pc.getInventory().updateItem(item); 
		pc.sendPackets(new S_ChangeName(pet.getId(), name));
		pc.broadcastPacket(new S_ChangeName(pet.getId(), name));
	}

	private void callClan(L1PcInstance pc) {
		L1PcInstance callClanPc = (L1PcInstance) L1World.getInstance()
				.findObject(pc.getTempID());
		pc.setTempID(0);
		if (callClanPc == null) {
			return;
		}
		if (!pc.getMap().isEscapable() && !pc.isGm()) {
			// GlM[e|[gWQBAe|[ggpB
			pc.sendPackets(new S_ServerMessage(647));
			L1Teleport.teleport(pc, pc.getLocation(), pc.getHeading(), false);
			return;
		}
		if (pc.getId() != callClanPc.getCallClanId()) {
			return;
		}

		boolean isInWarArea = false;
		int castleId = L1CastleLocation.getCastleIdByArea(callClanPc);
		if (castleId != 0) {
			isInWarArea = true;
			if (WarTimeController.getInstance().isNowWar(castleId)) {
				isInWarArea = false; // gp\
			}
		}
		short mapId = callClanPc.getMapId();
		if (mapId != 0 && mapId != 4 && mapId != 304 || isInWarArea) {
			// \f1p[gi[svCB
			pc.sendPackets(new S_ServerMessage(547));
			return;
		}

		L1Map map = callClanPc.getMap();
		int callCalnX = callClanPc.getX();
		int callCalnY = callClanPc.getY();
		int locX = 0;
		int locY = 0;
		int heading = 0;
		switch (callClanPc.getCallClanHeading()) {
		case 0:
			locY = callCalnY - 1;
			heading = 4;
			break;

		case 1:
			locX = callCalnX + 1;
			locY = callCalnY - 1;
			heading = 5;
			break;

		case 2:
			locX = callCalnX + 1;
			heading = 6;
			break;

		case 3:
			locX = callCalnX + 1;
			locY = callCalnY + 1;
			heading = 7;
			break;

		case 4:
			locY = callCalnY + 1;
			heading = 0;
			break;

		case 5:
			locX = callCalnX - 1;
			locY = callCalnY + 1;
			heading = 1;
			break;

		case 6:
			locX = callCalnX - 1;
			heading = 2;
			break;

		case 7:
			locX = callCalnX - 1;
			locY = callCalnY - 1;
			heading = 3;
			break;

		default:
			break;
		}

		boolean isExsistCharacter = false;
		for (L1Object object : L1World.getInstance()
				.getVisibleObjects(callClanPc, 1)) {
			if (object instanceof L1Character) {
				L1Character cha = (L1Character) object;
				if (cha.getX() == locX && cha.getY() == locY
						&& cha.getMapId() == mapId) {
					isExsistCharacter = true;
					break;
				}
			}
		}

		if (locX == 0 && locY == 0 || !map.isPassable(locX, locY)
				|| isExsistCharacter) {
			// QB
			pc.sendPackets(new S_ServerMessage(627));
			return;
		}
		L1Teleport.teleport(pc, locX, locY, mapId, heading, true, L1Teleport
				.CALL_CLAN);
	}

	@Override
	public String getType() {
		return C_ATTR;
	}
}
