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

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.util.TimeZone;

import l1j.server.Config;
import l1j.server.server.ClientThread;
import l1j.server.server.controllers.CrackOfTimeController;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.DoorTable;
import l1j.server.server.datatables.HouseTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.NpcActionTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.datatables.TownTable;
import l1j.server.server.datatables.UBTable;
import l1j.server.server.model.L1PolyRace;
import l1j.server.server.model.L1DeathMatch;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1HauntedHouse;
import l1j.server.server.model.L1HouseLocation;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1PetMatch;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1Quest;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1TownLocation;
import l1j.server.server.model.L1UltimateBattle;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1HousekeeperInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1MerchantInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.npc.L1NpcHtml;
import l1j.server.server.model.npc.action.L1NpcAction;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_ApplyAuction;
import l1j.server.server.serverpackets.S_AuctionBoardRead;
import l1j.server.server.serverpackets.S_CharReset;
import l1j.server.server.serverpackets.S_CloseList;
import l1j.server.server.serverpackets.S_DelSkill;
import l1j.server.server.serverpackets.S_War;
import l1j.server.server.serverpackets.S_Deposit;
import l1j.server.server.serverpackets.S_Drawal;
import l1j.server.server.serverpackets.S_HouseMap;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_PetList;
import l1j.server.server.serverpackets.S_RetrieveList;
import l1j.server.server.serverpackets.S_RetrieveElfList;
import l1j.server.server.serverpackets.S_RetrievePledgeList;
import l1j.server.server.serverpackets.S_SelectTarget;
import l1j.server.server.serverpackets.S_SellHouse;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_ShopBuyList;
import l1j.server.server.serverpackets.S_ShopSellList;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillIconAura;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_TaxRate;
import l1j.server.server.templates.L1Castle;
import l1j.server.server.templates.L1House;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Skill;
import l1j.server.server.templates.L1Town;
import static l1j.server.server.model.skill.L1SkillId.*;

public class C_NPCAction extends ClientBasePacket {

	private static final String	C_NPC_ACTION	= "[C] C_NPCAction";
	private static Logger _log = Logger.getLogger(C_NPCAction.class.getName());
	private static Random _random = new Random();

	public C_NPCAction(byte abyte0[], ClientThread client) throws Exception {
		super(abyte0);
		
		int objid = readD();
		
		String s = readS();
		String s2 = null;
		
		if (s.equalsIgnoreCase("select") || s.equalsIgnoreCase("map") || s.equalsIgnoreCase("apply")) {
			s2 = readS();
		} else if (s.equalsIgnoreCase("ent")) {
			L1Object obj = L1World.getInstance().findObject(objid);
			if (obj != null && obj instanceof L1NpcInstance) {
				if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80088) {
				s2 = readS();
				}
			}
		}

		int[] materials = null;
		int[] counts = null;
		int[] createitem = null;
		int[] createcount = null;

		String htmlid = null;
		String success_htmlid = null;
		String failure_htmlid = null;
		String[] htmldata = null;

		L1PcInstance pc = client.getActiveChar();
		L1PcInstance target;
		L1Object obj = L1World.getInstance().findObject(objid);
		if (obj != null) {
			if (obj instanceof L1NpcInstance) {
				L1NpcInstance npc = (L1NpcInstance) obj;
				int difflocx = Math.abs(pc.getX() - npc.getX());
				int difflocy = Math.abs(pc.getY() - npc.getY());
				if (difflocx > 3 || difflocy > 3) {
				return;
				}
				npc.onFinalAction(pc, s);
			} else if (obj instanceof L1PcInstance) {
				target = (L1PcInstance) obj;
				if (s.matches("[0-9]+")) {
					if (target.isSummonMonster()) {
						summonMonster(target, s);
						target.setSummonMonster(false);
					}
				} else {
					int awakeSkillId = target.getAwakeSkillId();
					if (awakeSkillId == AWAKEN_ANTHARAS || awakeSkillId == AWAKEN_FAFURION || awakeSkillId == AWAKEN_VALAKAS) {
						target.sendPackets(new S_ServerMessage(1384));
						return;
					}
					if (target.isShapeChange()) {
						L1PolyMorph.handleCommands(target, s);
						target.setShapeChange(false);
					} else {
						L1PolyMorph poly = PolyTable.getInstance().getTemplate(s);
						if (poly != null || s.equals("none")) {
							if (target.getInventory().checkItem(40088) && usePolyScroll(target, 40088, s)) {
							}
							if (target.getInventory().checkItem(40096) && usePolyScroll(target, 40096, s)) {
							}
							if (target.getInventory().checkItem(140088) && usePolyScroll(target, 140088, s)) {
							}
						}
					}
				}
				return;
			}
		} else {
			// _log.warning("object not found, oid " + i);
		}
		L1NpcAction action = NpcActionTable.getInstance().get(s, pc, obj);
		if (action != null) {
			L1NpcHtml result = action.execute(s, pc, obj, readByte());
			if (result != null) {
				pc.sendPackets(new S_NPCTalkReturn(obj.getId(), result));
			}
			return;
		}

		// AFDFASGDAFDSFSDAF
		L1NpcInstance npc = (L1NpcInstance) obj;
		int npcid = npc.getNpcTemplate().get_npcId();
		String npcName = npc.getNpcTemplate().get_name();

		if (s.equalsIgnoreCase("buy")) {
			if (isNpcSellOnly(npc)) {
				return;
			}
			pc.sendPackets(new S_ShopSellList(objid));
		} else if (s.equalsIgnoreCase("sell")) {
			if (npcid == 70523 || npcid == 70805) {
				htmlid = "ladar2";
			} else if (npcid == 70537 || npcid == 70807) { 
				htmlid = "farlin2";
			} else if (npcid == 70525 || npcid == 70804) { 
				htmlid = "lien2";
			} else if (npcid == 50527 || npcid == 50505 || npcid == 50519
					|| npcid == 50545 || npcid == 50531 || npcid == 50529
					|| npcid == 50516 || npcid == 50538 || npcid == 50518
					|| npcid == 50509 || npcid == 50536 || npcid == 50520
					|| npcid == 50543 || npcid == 50526 || npcid == 50512
					|| npcid == 50510 || npcid == 50504 || npcid == 50525
					|| npcid == 50534 || npcid == 50540 || npcid == 50515
					|| npcid == 50513 || npcid == 50528 || npcid == 50533
					|| npcid == 50542 || npcid == 50511 || npcid == 50501
					|| npcid == 50503 || npcid == 50508 || npcid == 50514
					|| npcid == 50532 || npcid == 50544 || npcid == 50524
					|| npcid == 50535 || npcid == 50521 || npcid == 50517
					|| npcid == 50537 || npcid == 50539 || npcid == 50507
					|| npcid == 50530 || npcid == 50502 || npcid == 50506
					|| npcid == 50522 || npcid == 50541 || npcid == 50523
					|| npcid == 50620 || npcid == 50623 || npcid == 50619
					|| npcid == 50621 || npcid == 50622 || npcid == 50624
					|| npcid == 50617 || npcid == 50614 || npcid == 50618
					|| npcid == 50616 || npcid == 50615 || npcid == 50626
					|| npcid == 50627 || npcid == 50628 || npcid == 50629
					|| npcid == 50630 || npcid == 50631) { 
				String sellHouseMessage = sellHouse(pc, objid, npcid);
				if (sellHouseMessage != null) {
					htmlid = sellHouseMessage;
				}
			} else { 
				pc.sendPackets(new S_ShopBuyList(objid, pc));
			}
		} else if (s.equalsIgnoreCase("retrieve")) {
			if (pc.getLevel() >= 5) {
				pc.sendPackets(new S_RetrieveList(objid, pc));
			}
		} else if (s.equalsIgnoreCase("retrieve-elven")) {
			if (pc.getLevel() >= 5 && pc.isElf()) {
				pc.sendPackets(new S_RetrieveElfList(objid, pc));
			}
		} else if (s.equalsIgnoreCase("retrieve-pledge")) {
			if (pc.getLevel() >= 5) {
				if (pc.getClanid() == 0) {
					pc.sendPackets(new S_ServerMessage(208));
					return;
				}
				int rank = pc.getClanRank();
				if (rank != L1Clan.CLAN_RANK_PUBLIC && rank != L1Clan.CLAN_RANK_GUARDIAN 
						&& rank != L1Clan.CLAN_RANK_PRINCE) {
					pc.sendPackets(new S_ServerMessage(728));
					return;
				}
				if (rank != L1Clan.CLAN_RANK_PRINCE && pc.getTitle().equalsIgnoreCase("")) {
					pc.sendPackets(new S_ServerMessage(728));
					return;
				}
				pc.sendPackets(new S_RetrievePledgeList(objid, pc));
			}
		} else if (s.equalsIgnoreCase("get")) {
			if (npcid == 70099 || npcid == 70796) {
				L1ItemInstance item = pc.getInventory().storeItem(20081, 1); 
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				pc.getQuest().set_end(L1Quest.QUEST_OILSKINMANT);
				htmlid = ""; 
			} else if (npcid == 70528 || npcid == 70546 || npcid == 70567
                    || npcid == 70594 || npcid == 70654 || npcid == 70748
					|| npcid == 70774 || npcid == 70799 || npcid == 70815 
					|| npcid == 70860) {
				if (pc.getHomeTownId() > 0) {
				} else {
            	}
         	}
		} else if (s.equalsIgnoreCase("fix")) { 
		} else if (s.equalsIgnoreCase("room")) {
		} else if (s.equalsIgnoreCase("hall") && obj instanceof L1MerchantInstance) { 
		} else if (s.equalsIgnoreCase("return")) { 
		} else if (s.equalsIgnoreCase("enter")) { 
		} else if (s.equalsIgnoreCase("openigate")) { 
			openCloseGate(pc, npcid, true);
			htmlid = "";
		} else if (s.equalsIgnoreCase("closeigate")) {
			openCloseGate(pc, npcid, false);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("askwartime")) { 
			if (npcid == 60514) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.KENT_CASTLE_ID);
				htmlid = "ktguard7";
			} else if (npcid == 60560) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.OT_CASTLE_ID);
				htmlid = "orcguard7";
			} else if (npcid == 60552) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.WW_CASTLE_ID);
				htmlid = "wdguard7";
			} else if (npcid == 60524 || 
				npcid == 60525 || 
				npcid == 60529) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.GIRAN_CASTLE_ID);
				htmlid = "grguard7";
			} else if (npcid == 70857) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.HEINE_CASTLE_ID);
				htmlid = "heguard7";
			} else if (npcid == 60530 ||
				npcid == 60531) {
				htmldata = makeWarTimeStrings(L1CastleLocation.DOWA_CASTLE_ID);
				htmlid = "dcguard7";
			} else if (npcid == 60533 ||
				npcid == 60534) {
				htmldata = makeWarTimeStrings(L1CastleLocation.ADEN_CASTLE_ID);
				htmlid = "adguard7";
			} else if (npcid == 81156) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.DIAD_CASTLE_ID);
				htmlid = "dfguard3";
			}
		} else if (s.equalsIgnoreCase("inex")) {
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int castle_id = clan.getCastleId();
				if (castle_id != 0) { 
					L1Castle l1castle = CastleTable.getInstance().getCastleTable(castle_id);
					pc.sendPackets(new S_ServerMessage(309, l1castle.getName(), String.valueOf(l1castle.getPublicMoney())));
					htmlid = "";
				}
			}
		} else if (s.equalsIgnoreCase("declarewar")) {
            L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
            if (npcid == 60514 && pc.getClassId() == 1 && isExistDefenseClan(L1CastleLocation.KENT_CASTLE_ID)) {
                    pc.sendPackets(new S_War(1, clan.getClanName(), getDefenseClanName(L1CastleLocation.KENT_CASTLE_ID)));
                    WarTimeController.getInstance();
            } else if (npcid == 60560 && pc.getClassId() == 1 && isExistDefenseClan(L1CastleLocation.OT_CASTLE_ID)) {
                       pc.sendPackets(new S_War(1, clan.getClanName(), getDefenseClanName(L1CastleLocation.OT_CASTLE_ID)));
                       WarTimeController.getInstance();
            } else if (npcid == 60552 && pc.getClassId() == 1 && isExistDefenseClan(L1CastleLocation.WW_CASTLE_ID)) {
                       pc.sendPackets(new S_War(1, clan.getClanName(), getDefenseClanName(L1CastleLocation.WW_CASTLE_ID)));
                       WarTimeController.getInstance();
            } else if (npcid == 60524 || npcid == 60525 || npcid == 60529 && isExistDefenseClan(L1CastleLocation.GIRAN_CASTLE_ID)) {
                       pc.sendPackets(new S_War(1, clan.getClanName(), getDefenseClanName(L1CastleLocation.GIRAN_CASTLE_ID)));
                       WarTimeController.getInstance();
            } else if (npcid == 70857 && pc.getClassId() == 1 && isExistDefenseClan(L1CastleLocation.HEINE_CASTLE_ID)) {
                       pc.sendPackets(new S_War(1, clan.getClanName(), getDefenseClanName(L1CastleLocation.HEINE_CASTLE_ID)));
                       WarTimeController.getInstance();
            } else if (npcid == 60530 || npcid == 60531 && pc.getClassId() == 1 && isExistDefenseClan(L1CastleLocation.DOWA_CASTLE_ID)) {
                       pc.sendPackets(new S_War(1, clan.getClanName(), getDefenseClanName(L1CastleLocation.DOWA_CASTLE_ID)));
                       WarTimeController.getInstance();
            } else if (npcid == 60533 || npcid == 60534 && pc.getClassId() == 1 && isExistDefenseClan(L1CastleLocation.ADEN_CASTLE_ID)) {
                       pc.sendPackets(new S_War(1, clan.getClanName(), getDefenseClanName(L1CastleLocation.ADEN_CASTLE_ID)));
                       WarTimeController.getInstance();
            } else if (npcid == 81156 && pc.getClassId() == 1 && isExistDefenseClan(L1CastleLocation.DIAD_CASTLE_ID)) {
                       pc.sendPackets(new S_War(1, clan.getClanName(), getDefenseClanName(L1CastleLocation.DIAD_CASTLE_ID)));
                       WarTimeController.getInstance();
            } else {
                    pc.sendPackets(new S_SystemMessage("Castle owned by npcs cant be attacked."));
            }
            htmlid = "";
		} else if (s.equalsIgnoreCase("tax")) { 
			pc.sendPackets(new S_TaxRate(pc.getId()));
		} else if (s.equalsIgnoreCase("withdrawal")) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int castle_id = clan.getCastleId();
				if (castle_id != 0) { 
					L1Castle l1castle = CastleTable.getInstance().getCastleTable(castle_id);
					pc.sendPackets(new S_Drawal(pc.getId(), l1castle.getPublicMoney()));
				}
			}
		} else if (s.equalsIgnoreCase("cdeposit")) { 
			pc.sendPackets(new S_Deposit(pc.getId()));
		} else if (s.equalsIgnoreCase("employ")) { 

		} else if (s.equalsIgnoreCase("arrange")) { 

		} else if (s.equalsIgnoreCase("castlegate")) {

			repairGate(pc);
			htmlid = "";
		} else if (s.equalsIgnoreCase("encw")) {
			if (pc.getWeapon() == null) {
				pc.sendPackets(new S_ServerMessage(79));
			} else {
				for (L1ItemInstance item : pc.getInventory().getItems()) {
					if (pc.getWeapon().equals(item)) {
						L1SkillUse l1skilluse = new L1SkillUse();
						l1skilluse.handleCommands(pc, ENCHANT_WEAPON, item.getId(), 0, 0, null, 0, L1SkillUse.TYPE_SPELLSC);
						break;
					}
				}
			}
			htmlid = "";
		} else if (s.equalsIgnoreCase("enca")) {
			L1ItemInstance item = pc.getInventory().getItemEquipped(2, 2);
			if (item != null) {
				L1SkillUse l1skilluse = new L1SkillUse();
				l1skilluse.handleCommands(pc, BLESSED_ARMOR, item.getId(), 0, 0, null, 0, L1SkillUse.TYPE_SPELLSC);
			} else {
				pc.sendPackets(new S_ServerMessage(79));
			}
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("depositnpc")) { 
			Object[] petList = pc.getPetList().values().toArray();
			for (Object petObject : petList) {
				if (petObject instanceof L1PetInstance) { 
					L1PetInstance pet = (L1PetInstance) petObject;
					pet.save(); // fix for pet xp. do not remove
					pet.collect();
					pc.getPetList().remove(pet.getId());
					pet.deleteMe();
				}
			}
			htmlid = "";
		} else if (s.equalsIgnoreCase("withdrawnpc")) {
			pc.sendPackets(new S_PetList(objid, pc));
		} else if (s.equalsIgnoreCase("changename")) {
			pc.setTempID(objid); 
			pc.sendPackets(new S_Message_YN(325, "")); 
		} else if (s.equalsIgnoreCase("attackchr")) {
			if (obj instanceof L1Character) {
				L1Character cha = (L1Character) obj;
				pc.sendPackets(new S_SelectTarget(cha.getId()));
			}
		} else if (s.equalsIgnoreCase("select")) {
			pc.sendPackets(new S_AuctionBoardRead(objid, s2));
		} else if (s.equalsIgnoreCase("map")) {
			pc.sendPackets(new S_HouseMap(objid, s2));
		} else if (s.equalsIgnoreCase("apply")) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				if (pc.isCrown() && pc.getId() == clan.getLeaderId()) { 
					if (pc.getLevel() >= 15) {
						if (clan.getHouseId() == 0) {
							pc.sendPackets(new S_ApplyAuction(objid, s2));
						} else {
							pc.sendPackets(new S_ServerMessage(521)); 
							htmlid = ""; 
						}
					} else {
						pc.sendPackets(new S_ServerMessage(519));
						htmlid = ""; 
					}
				} else {
					pc.sendPackets(new S_ServerMessage(518)); 
					htmlid = ""; 
				}
			} else {
				pc.sendPackets(new S_ServerMessage(518));
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("open")
				|| s.equalsIgnoreCase("close")) { 
			openCloseDoor(pc, npc, s);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("expel")) {
			expelOtherClan(pc, npcid); 
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("pay")) {
			htmldata = makeHouseTaxStrings(pc, npc);
            htmlid = "agpay";
        } else if (s.equalsIgnoreCase("payfee")) {
			payFee(pc, npc);
            htmlid = "";
		} else if (s.equalsIgnoreCase("name")) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int houseId = clan.getHouseId();
				if (houseId != 0) {
					L1House house = HouseTable.getInstance().getHouseTable(houseId);
					int keeperId = house.getKeeperId();
					if (npcid == keeperId) {
						pc.setTempID(houseId); 
						pc.sendPackets(new S_Message_YN(512, ""));
					}
				}
			}
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("rem")) { 
		} else if (s.equalsIgnoreCase("tel0")
				|| s.equalsIgnoreCase("tel1") 
				|| s.equalsIgnoreCase("tel2") 
				|| s.equalsIgnoreCase("tel3")) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int houseId = clan.getHouseId();
				if (houseId != 0) {
					L1House house = HouseTable.getInstance().getHouseTable(houseId);
					int keeperId = house.getKeeperId();
					if (npcid == keeperId) {
						int[] loc = new int[3];
						if (s.equalsIgnoreCase("tel0")) {
							loc = L1HouseLocation.getHouseTeleportLoc(houseId, 0);
						} else if (s.equalsIgnoreCase("tel1")) {
							loc = L1HouseLocation.getHouseTeleportLoc(houseId, 1);
						} else if (s.equalsIgnoreCase("tel2")) {
							loc = L1HouseLocation.getHouseTeleportLoc(houseId, 2);
						} else if (s.equalsIgnoreCase("tel3")) {
							loc = L1HouseLocation.getHouseTeleportLoc(houseId, 3);
						}
						L1Teleport.teleport(pc, loc[0], loc[1], (short) loc[2], 5, true);
					}
				}
			}
			htmlid = "";
		} else if (s.equalsIgnoreCase("upgrade")) {
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int houseId = clan.getHouseId();
				if (houseId != 0) {
					L1House house = HouseTable.getInstance().getHouseTable(houseId);
					int keeperId = house.getKeeperId();
					if (npcid == keeperId) {
						if (pc.isCrown() && pc.getId() == clan.getLeaderId()) { 
							if (house.isPurchaseBasement()) {
								pc.sendPackets(new S_ServerMessage(1135));
							} else {
								if (pc.getInventory().consumeItem(L1ItemId.ADENA, 5000000)) {
									house.setPurchaseBasement(true);
									HouseTable.getInstance().updateHouse(house);
									pc.sendPackets(new S_ServerMessage(1099));
								} else {
									pc.sendPackets(new S_ServerMessage(189));
								}
							}
						} else {
							pc.sendPackets(new S_ServerMessage(518));
						}
					}
				}
			}
			htmlid = "";
		} else if (s.equalsIgnoreCase("hall") && obj instanceof L1HousekeeperInstance) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int houseId = clan.getHouseId();
				if (houseId != 0) {
					L1House house = HouseTable.getInstance().getHouseTable(houseId);
					int keeperId = house.getKeeperId();
					if (npcid == keeperId) {
						if (house.isPurchaseBasement()) {
							int[] loc = new int[3];
							loc = L1HouseLocation.getBasementLoc(houseId);
							L1Teleport.teleport(pc, loc[0], loc[1], (short) (loc[2]), 5, true);
						} else {
							pc.sendPackets(new S_ServerMessage(1098));
						}
					}
				}
			}
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("fire")) {
			if (pc.isElf()) {
				if (pc.getElfAttr() != 0) {
					return;
				}
				pc.setElfAttr(2);
				pc.save(); 
				pc.sendPackets(new S_SkillIconGFX(15, 1)); 
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("water")) { 
			if (pc.isElf()) {
				if (pc.getElfAttr() != 0) {
					return;
				}
				pc.setElfAttr(4);
				pc.save(); 
				pc.sendPackets(new S_SkillIconGFX(15, 2)); 
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("air")) {
			if (pc.isElf()) {
				if (pc.getElfAttr() != 0) {
					return;
				}
				pc.setElfAttr(8);
				pc.save(); 
				pc.sendPackets(new S_SkillIconGFX(15, 3));
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("earth")) { 
			if (pc.isElf()) {
				if (pc.getElfAttr() != 0) {
					return;
				}
				pc.setElfAttr(1);
				pc.save(); 
				pc.sendPackets(new S_SkillIconGFX(15, 4)); 
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("init")) {
			if (pc.isElf()) {
				if (pc.getElfAttr() == 0) {
					return;
				}
				for (int cnt = 129; cnt <= 176; cnt++)
				{
					L1Skill l1skills1 = SkillTable.getInstance().findBySkillId(cnt);
					int skill_attr = l1skills1.getAttr();
					if (skill_attr != 0) 
					{
						SkillTable.getInstance().spellLost(pc.getId(), l1skills1.getSkillId());
					}
				}
				if (pc.hasSkillEffect(ELEMENTAL_PROTECTION)) {
					pc.removeSkillEffect(ELEMENTAL_PROTECTION);
				}
				pc.sendPackets(new S_DelSkill(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 248, 252, 252, 255, 0, 0, 0, 0, 0, 0));
				pc.setElfAttr(0);
				pc.save(); 
				pc.sendPackets(new S_ServerMessage(678));
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("exp")) {
			if (pc.getExpRes() == 1) {
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
				pc.sendPackets(new S_Message_YN(738, String.valueOf(cost))); 
			} else {
				pc.sendPackets(new S_ServerMessage(739)); 
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("pk")) {
			if (pc.getLawful() < 30000) {
				pc.sendPackets(new S_ServerMessage(559)); 
			} else if (pc.get_PKcount() < 5) {
				pc.sendPackets(new S_ServerMessage(560)); 
			} else {
				if (pc.getInventory().consumeItem(L1ItemId.ADENA, 700000)) {
					pc.set_PKcount(pc.get_PKcount() - 5);
					pc.sendPackets(new S_ServerMessage(561, String.valueOf(pc.get_PKcount()))); 
				} else {
					pc.sendPackets(new S_ServerMessage(189)); 
				}
			}
			htmlid = "";

		} else if (npcid == 90521) {
            int pccount = 0;
            for (L1PcInstance map784pc : L1World.getInstance().getAllPlayers()) {
                    if (map784pc.getMapId() == 784) {
                            pccount++;
                    }
            }
            if (pccount >= 20) {
                    htmlid = "tikalgate4";
            }
            if (s.equalsIgnoreCase("e") && pccount <= 19) {
                    if (CrackOfTimeController.getStart().map784gateopen() == false) {
                            htmlid = "tikalgate2";
                    } else {
                            if (pc.getInventory().checkItem(49308, 1)) {
                                    pc.getInventory().consumeItem(49308, 1);
                                    L1Teleport.teleport(pc, 32730, 32866, (short) 784, 2, true);
                                    htmlid = "";
                            } else {
                                    htmlid = "tikalgate3";
                            }
                    }
            }
		} else if (s.equalsIgnoreCase("ent")) {
			if (npcid == 80085) {
				htmlid = enterHauntedHouse(pc);
			} else if (npcid == 80088) {
				htmlid = enterPetMatch(pc, Integer.valueOf(s2));
            } else if (npcid == 80168) {
                L1PolyRace.getInstance().enterGame(pc);
            } else if (npcid == 80086 || npcid == 80087) {
                L1DeathMatch.getInstance().enterGame(pc, npcid);
			} else if (npcid == 50038 || npcid == 50042 || npcid == 50029
					|| npcid == 50019 || npcid == 50062) {
				htmlid = watchUb(pc, npcid);
			} else if (npcid == 71251) {
				if (!pc.getInventory().checkItem(49142)) {
					pc.sendPackets(new S_ServerMessage(1290));
					return;
				}
				pc.save();
				L1SkillUse l1skilluse = new L1SkillUse();
				l1skilluse.handleCommands(pc, CANCELLATION, pc.getId(), pc.getX(), pc.getY(), null, 0, L1SkillUse.TYPE_LOGIN);
				pc.getInventory().takeoffEquip(945);
				L1Teleport.teleport(pc, 32737, 32789, (short) 997, 4, false);
				// NOTE: apparently we're not using the character's (database)
				// maxLevel so that people who have dlvled keep their current
				// level. Feature not bug?
				int initStatusPoint = 75 + pc.getElixirStats();
				int pcStatusPoint = pc.getBaseStr() + pc.getBaseInt()
				+ pc.getBaseWis() + pc.getBaseDex() + pc.getBaseCon() + pc.getBaseCha();
				if (pc.getLevel() > 50) {
					pcStatusPoint += (pc.getLevel() - 50 - pc.getBonusStats());
				}
				int diff = pcStatusPoint - initStatusPoint;
				int maxLevel = 1;

				if (diff > 0) {
					maxLevel = Math.min(50 + diff, 99);
				} else {
					maxLevel = pc.getLevel();
				}

				_log.log(Level.INFO, String.format("Candle: %s started " +
							"candling with maxLevel = %d and pc.getLevel()" +
							" = %d.", pc.getName(), maxLevel, pc.getLevel()));
				if (maxLevel > pc.getLevel()) {
					_log.log(Level.WARNING, String.format("Candle: %s's " +
							"maxLevel: %d was too high compared to " +
							"pc.getLevel(): %d.",
							pc.getName(), maxLevel, pc.getLevel()));
					pc.sendPackets(new S_SystemMessage(
							"Your level and stats don't seem to match. " +
							"Contact a GM for help."));
					maxLevel = pc.getLevel();
				} else if (maxLevel < pc.getLevel()) {
					// Minority case where the character candling has lost stat
					// points. Using their current level should be safe.
					_log.log(Level.WARNING, String.format("Candle: %s's " +
							"maxLevel: %d was less than pc.getLevel(): %d." +
							" Using pc.getLevel().",
							pc.getName(), maxLevel, pc.getLevel()));
					maxLevel = pc.getLevel();
				}

				pc.setTempMaxLevel(maxLevel);
				pc.setTempLevel(1);
				pc.setInCharReset(true);
				pc.sendPackets(new S_CharReset(pc));
			} else {
				htmlid = enterUb(pc, npcid);
			}
		} else if (s.equalsIgnoreCase("par")) { 
			htmlid = enterUb(pc, npcid);
		} else if (s.equalsIgnoreCase("info")) { 
			if (npcid == 80085) {
			} else {
				htmlid = "colos2";
			}
		} else if (s.equalsIgnoreCase("sco")) { 
			htmldata = new String[10];
			htmlid = "colos3";
		} else if (s.equalsIgnoreCase("haste")) { 
			if (npcid == 70514) {
				pc.sendPackets(new S_ServerMessage(183));
				pc.sendPackets(new S_SkillHaste(pc.getId(), 1, 1600));
				pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1, 0));
				pc.sendPackets(new S_SkillSound(pc.getId(), 755));
				pc.broadcastPacket(new S_SkillSound(pc.getId(), 755));
				pc.setMoveSpeed(1);
				pc.setSkillEffect(STATUS_HASTE, 1600 * 1000);
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("skeleton nbmorph")) {
			poly(client, 2374);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("lycanthrope nbmorph")) {
			poly(client, 3874);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("shelob nbmorph")) {
			poly(client, 95);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("ghoul nbmorph")) {
			poly(client, 3873);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("ghast nbmorph")) {
			poly(client, 3875);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("atuba orc nbmorph")) {
			poly(client, 3868);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("skeleton axeman nbmorph")) {
			poly(client, 2376);
			htmlid = "";
		} else if (s.equalsIgnoreCase("troll nbmorph")) {
			poly(client, 3878);
			htmlid = ""; 
		} else if (npcid > 50111 && npcid < 50118) { 
			// lekman talking scroll trade 
			if (s.equalsIgnoreCase("0"))  { 
				if (pc.getInventory().checkItem(40641) == true){  
					// it ts, it leather armor, it gloves, it sandal, it ring, it edo, it staff, it spear, it axe, it claw, it bow /*
					/*final int[] item_ids = { 20082, 20126, 20173, 20212, 20282, 73, 105, 120, 147, 156, 174, 40373}; 
					final int[] item_amounts = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};*/
					int[] item_ids = {}; int[] item_amounts = {};
					if(pc.isWizard()) { 
						int[] i = {20082, 20126, 20173, 20212, 20282, 120, 40373, 40029, 40085}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1, 20, 10}; item_ids = i; item_amounts = j; } 
					else if(pc.isDarkelf()) {
						int[] i = {20082, 20126, 20173, 20212, 20282, 73, 156, 174, 40373, 40029, 40085}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1, 1, 1, 20, 10}; item_ids = i; item_amounts = j; } 
					else if(pc.isCrown()) { 
						int[] i = {20082, 20126, 20173, 20212, 20282, 147, 40373, 40029, 40085}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1, 20, 10}; item_ids = i; item_amounts = j; } 
					else if(pc.isKnight()) { 
						int[] i = {20082, 20126, 20173, 20212, 20282, 105, 147, 174, 40373, 40029, 40085}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1, 1, 1, 20, 10}; item_ids = i; item_amounts = j; } 
					else if (pc.isDragonKnight()) {
						int[] i = {20082, 20126, 20173, 20212, 20282, 147, 40373, 40029, 40085}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1, 20, 10}; item_ids = i; item_amounts = j; } 
					else if (pc.isIllusionist()) {
						int[] i = {20082, 20126, 20173, 20212, 20282, 147, 40373, 40029, 40085}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1, 20, 10}; item_ids = i; item_amounts = j; } 
					else { //elf 
						int[] i = {20082, 20126, 20173, 20212, 20282, 174, 40373, 40029, 40085}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1, 20, 10}; item_ids = i; item_amounts = j; }  
					for (int i = 0; i < item_ids.length; i++)  {  
						L1ItemInstance item = pc.getInventory().storeItem(item_ids[i], item_amounts[i]);  
						pc.sendPackets(new S_ServerMessage(143, npcName, item.getLogName())); 
					}  pc.getInventory().consumeItem(40641, 1);  
					pc.getQuest().set_step(L1Quest.QUEST_DOROMOND, 1);  
					pc.save();  htmlid = "jpe0015";  } 
				else {  
					pc.sendPackets(new S_SystemMessage("You do not possess a Talking Scroll!"));  
					}  
				} 
		} else if (npcid == 71038) {
			if (s.equalsIgnoreCase("A")) {
				L1ItemInstance item = pc.getInventory().storeItem(41060, 1); 
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfnoname9";
			} else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41060, 1)) {
					htmlid = "orcfnoname11";
				}
			}
		} else if (npcid == 71039) {
			if (s.equalsIgnoreCase("teleportURL")) {
				htmlid = "orcfbuwoo2";
			}
		} else if (npcid == 71040) {
			if (s.equalsIgnoreCase("A")) {
				L1ItemInstance item = pc.getInventory().storeItem(41065, 1); 
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
				htmlid = "orcfnoa4";
			} else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41065, 1)) {
					htmlid = "orcfnoa7";
				}
			}
		} else if (npcid == 71041) {
			if (s.equalsIgnoreCase("A")) {
				L1ItemInstance item = pc.getInventory().storeItem(41064, 1);
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfhuwoomo4";
			} else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41064, 1)) {
					htmlid = "orcfhuwoomo6";
				}
			}
		} else if (npcid == 71042) {
			if (s.equalsIgnoreCase("A")) {
				L1ItemInstance item = pc.getInventory().storeItem(41062, 1); 
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfbakumo4";
			} else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41062, 1)) {
					htmlid = "orcfbakumo6";
				}
			}
		} else if (npcid == 71043) {
			if (s.equalsIgnoreCase("A")) {
				L1ItemInstance item = pc.getInventory().storeItem(41063, 1);
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfbuka4";
			} else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41063, 1)) {
					htmlid = "orcfbuka6";
				}
			}
		} else if (npcid == 71044) {
			if (s.equalsIgnoreCase("A")) {
				L1ItemInstance item = pc.getInventory().storeItem(41061, 1); 
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfkame4";
			} else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41061, 1)) {
					htmlid = "orcfkame6";
				}
			}
		} else if (npcid == 71078) {
			if (s.equalsIgnoreCase("teleportURL")) {
				htmlid = "usender2";
			}
		} else if (npcid == 71080) {
			if (s.equalsIgnoreCase("teleportURL")) {
				htmlid = "amisoo2";
			}
		} else if (npcid == 80048) {
			if (s.equalsIgnoreCase("2")) {
				htmlid = ""; 
			}
		} else if (npcid == 80049) {
			if (s.equalsIgnoreCase("1")) {
				if (pc.getKarma() <= -10000000) {
					pc.setKarma(1000000);
					pc.sendPackets(new S_ServerMessage(1078));
					htmlid = "betray13";
				}
			}
		} else if (npcid == 80050) {
			if (s.equalsIgnoreCase("1")) {
				htmlid = "meet105";
			} else if (s.equalsIgnoreCase("2")) {
				if (pc.getInventory().checkItem(40718)) { 
					htmlid = "meet106";
				} else {
					htmlid = "meet110";
				}
			} else if (s.equalsIgnoreCase("a")) {
				if (pc.getInventory().consumeItem(40718, 1)) {
					pc.addKarma((int) (-100 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1079));
					htmlid = "meet107";
				} else {
					htmlid = "meet104";
				}
			} else if (s.equalsIgnoreCase("b")) {
				if (pc.getInventory().consumeItem(40718, 10)) {
					pc.addKarma((int) (-1000 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1079));
					htmlid = "meet108";
				} else {
					htmlid = "meet104";
				}
			} else if (s.equalsIgnoreCase("c")) {
				if (pc.getInventory().consumeItem(40718, 100)) {
					pc.addKarma((int) (-10000 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1079));
					htmlid = "meet109";
				} else {
					htmlid = "meet104";
				}
			} else if (s.equalsIgnoreCase("d")) {
				if (pc.getInventory().checkItem(40615) 
						|| pc.getInventory().checkItem(40616)) { 
					htmlid = "";
				} else {
					L1Teleport.teleport(pc, 32683, 32895, (short) 608, 5, true);
				}
			}
		} else if (npcid == 80052) {
			if (s.equalsIgnoreCase("a")) {
				if (pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
					pc.sendPackets(new S_ServerMessage(79)); //
				} else {
					pc.setSkillEffect(STATUS_CURSE_BARLOG, 1020 * 1000);
					pc.sendPackets(new S_SkillIconAura(221, 1020, 2));
					pc.sendPackets(new S_SkillSound(pc.getId(), 750));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 750));
					pc.sendPackets(new S_ServerMessage(1127));
				}
			}
		} else if (npcid == 80053) {
			if (s.equalsIgnoreCase("a")) {
				int aliceMaterialId = 0;
				int karmaLevel = 0;
				int[] material = null;
				int[] count = null;
				int createItem = 0;
				String successHtmlId = null;
				String htmlId = null;

				int[] aliceMaterialIdList = { 40991, 196, 197, 198, 199, 200,
						201, 202 };
				int[] karmaLevelList = { -1, -2, -3, -4, -5, -6, -7, -8 };
				int[][] materialsList = { {40995, 40718, 40991},
						{40997, 40718, 196}, {40990, 40718, 197},
						{40994, 40718, 198}, {40993, 40718, 199},
						{40998, 40718, 200}, {40996, 40718, 201},
						{40992, 40718, 202} };
				int[][] countList = { {100, 100, 1}, {100, 100, 1},
						{100, 100, 1}, {50, 100, 1},
						{50, 100, 1}, {50, 100, 1},
						{10, 100, 1}, {10, 100, 1} };
				int[] createItemList = { 196, 197, 198, 199, 200, 201, 202,
						203 };
				String[] successHtmlIdList = { "alice_1", "alice_2", "alice_3",
						"alice_4", "alice_5", "alice_6", "alice_7", "alice_8" };
				String[] htmlIdList = { "aliceyet", "alice_1", "alice_2",
						"alice_3", "alice_4", "alice_5", "alice_5" , "alice_7"};

				for (int i = 0; i < aliceMaterialIdList.length; i++) {
					if (pc.getInventory().checkItem(aliceMaterialIdList[i])) {
						aliceMaterialId = aliceMaterialIdList[i];
						karmaLevel = karmaLevelList[i];
						material = materialsList[i];
						count = countList[i];
						createItem = createItemList[i];
						successHtmlId = successHtmlIdList[i];
						htmlId = htmlIdList[i];
						break;
					}
				}

				if (aliceMaterialId == 0) {
					htmlid = "alice_no";
				} else if (aliceMaterialId == aliceMaterialId) {
					if (pc.getKarmaLevel() <= karmaLevel) {
						materials = material;
						counts = count;
						createitem = new int[] { createItem };
						createcount = new int[] { 1 };
						success_htmlid = successHtmlId;
						failure_htmlid = "alice_no";
					} else {
						htmlid = htmlId;
					}
				} else if (aliceMaterialId == 203) {
					htmlid = "alice_8";
				}
			}
		} else if (npcid == 80055) {
			htmlid = getYaheeAmulet(pc, npc, s);
		} else if (npcid == 80056) {
			if (pc.getKarma() <= -10000000) {
				getBloodCrystalByKarma(pc, npc, s);
			}
			htmlid = "";
		} else if (npcid == 80063) {
			if (s.equalsIgnoreCase("a")) {
				if (pc.getInventory().checkItem(40921)) { 
					L1Teleport.teleport(pc, 32674, 32832, (short) 603, 2, true);
				} else {
					htmlid = "gpass02";
				}
			}
		} else if (npcid == 80064) {
			if (s.equalsIgnoreCase("1")) {
				htmlid = "meet005";
			} else if (s.equalsIgnoreCase("2")) {
				if (pc.getInventory().checkItem(40678)) { 
					htmlid = "meet006";
				} else {
					htmlid = "meet010";
				}
			} else if (s.equalsIgnoreCase("a")) {
				if (pc.getInventory().consumeItem(40678, 1)) {
					pc.addKarma((int) (100 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1078));
					htmlid = "meet007";
				} else {
					htmlid = "meet004";
				}
			} else if (s.equalsIgnoreCase("b")) {
				if (pc.getInventory().consumeItem(40678, 10)) {
					pc.addKarma((int) (1000 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1078));
					htmlid = "meet008";
				} else {
					htmlid = "meet004";
				}
			} else if (s.equalsIgnoreCase("c")) {
				if (pc.getInventory().consumeItem(40678, 100)) {
					pc.addKarma((int) (10000 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1078));
					htmlid = "meet009";
				} else {
					htmlid = "meet004";
				}
			} else if (s.equalsIgnoreCase("d")) {
				if (pc.getInventory().checkItem(40909) 
						|| pc.getInventory().checkItem(40910) 
						|| pc.getInventory().checkItem(40911)
						|| pc.getInventory().checkItem(40912) 
						|| pc.getInventory().checkItem(40913) 
						|| pc.getInventory().checkItem(40914) 
						|| pc.getInventory().checkItem(40915) 
						|| pc.getInventory().checkItem(40916) 
						|| pc.getInventory().checkItem(40917) 
						|| pc.getInventory().checkItem(40918) 
						|| pc.getInventory().checkItem(40919) 
						|| pc.getInventory().checkItem(40920)
						|| pc.getInventory().checkItem(40921)) { 
					htmlid = "";
				} else {
					L1Teleport.teleport(pc, 32674, 32832, (short) 602, 2, true);
				}
			}
		} else if (npcid == 80066) {
			if (s.equalsIgnoreCase("1")) {
				if (pc.getKarma() >= 10000000) {
					pc.setKarma(-1000000);
					pc.sendPackets(new S_ServerMessage(1079));
					htmlid = "betray03";
				}
			}
		} else if (npcid == 80071) {
			htmlid = getBarlogEarring(pc, npc, s);
		} else if (npcid == 80073) {
			if (s.equalsIgnoreCase("a")) {
				if (pc.hasSkillEffect(STATUS_CURSE_BARLOG)) {
					pc.sendPackets(new S_ServerMessage(79)); //
				} else {
					pc.setSkillEffect(STATUS_CURSE_YAHEE, 1020 * 1000);
					pc.sendPackets(new S_SkillIconAura(221, 1020, 2));
					pc.sendPackets(new S_SkillSound(pc.getId(), 750));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 750));
					pc.sendPackets(new S_ServerMessage(1127));
				}
			}
		} else if (npcid == 80072) {
			String sEquals = null;
			int karmaLevel = 0;
			int[] material = null;
			int[] count = null;
			int createItem = 0;
			String failureHtmlId = null;
			String htmlId = null;

			String[] sEqualsList = { "0", "1", "2", "3", "4", "5", "6", "7",
					"8", "a", "b", "c", "d", "e", "f", "g", "h" };
			String[] htmlIdList = { "lsmitha", "lsmithb", "lsmithc", "lsmithd",
					"lsmithe", "", "lsmithf", "lsmithg", "lsmithh" };
			int[] karmaLevelList = { 1, 2, 3, 4, 5, 6, 7, 8 };
			int[][] materialsList = { {20158, 40669, 40678},
					{20144, 40672, 40678}, {20075, 40671, 40678},
					{20183, 40674, 40678}, {20190, 40674, 40678},
					{20078, 40674, 40678}, {20078, 40670, 40678},
					{40719, 40673, 40678} };
			int[][] countList = { {1, 50, 100}, {1, 50, 100}, {1, 50, 100},
					{1, 20, 100}, {1, 40, 100}, {1, 5, 100}, {1, 1, 100},
					{1, 1, 100} };
			int[] createItemList = { 20083, 20131, 20069, 20179 , 20209, 20290,
					20261, 20031 };
			String[] failureHtmlIdList = { "lsmithaa", "lsmithbb", "lsmithcc",
					"lsmithdd", "lsmithee", "lsmithff", "lsmithgg",
					"lsmithhh" };

			for (int i = 0; i < sEqualsList.length; i++) {
				if (s.equalsIgnoreCase(sEqualsList[i])) {
					sEquals = sEqualsList[i];
					if (i <= 8) {
						htmlId = htmlIdList[i];
					} else if (i > 8) {
						karmaLevel = karmaLevelList[i - 9];
						material = materialsList[i - 9];
						count = countList[i - 9];
						createItem = createItemList[i - 9];
						failureHtmlId = failureHtmlIdList[i - 9];
					}
					break;
				}
			}
			if (s.equalsIgnoreCase(sEquals)) {
				if (karmaLevel != 0 && (pc.getKarmaLevel() >= karmaLevel)) {
					materials = material;
					counts = count;
					createitem = new int[] { createItem };
					createcount = new int[] { 1 };
					success_htmlid = "";
					failure_htmlid = failureHtmlId;
				} else {
					htmlid = htmlId;
				}
			}
		} else if (npcid == 80074) {
			if (pc.getKarma() >= 10000000) {
				getSoulCrystalByKarma(pc, npc, s);
			}
			htmlid = "";
		} else if (npcid == 80057) {
			htmlid = karmaLevelToHtmlId(pc.getKarmaLevel());
			htmldata = new String[] { String.valueOf(pc.getKarmaPercent()) };
		} else if (npcid == 80059
				|| npcid == 80060
				|| npcid == 80061
				|| npcid == 80062) {
			htmlid = talkToDimensionDoor(pc, (L1NpcInstance) obj, s);
		} else if (npcid == 81124) {
			if (s.equalsIgnoreCase("1")) {
				poly(client, 4002);
				htmlid = ""; 
			} else if (s.equalsIgnoreCase("2")) {
				poly(client, 4004);
				htmlid = ""; 
			} else if (s.equalsIgnoreCase("3")) {
				poly(client, 4950);
				htmlid = ""; 
			}
		} else if (s.equalsIgnoreCase("contract1")) {
			pc.getQuest().set_step(L1Quest.QUEST_LYRA, 1);
			htmlid = "lyraev2";
		} else if (s.equalsIgnoreCase("contract1yes") || 
				s.equalsIgnoreCase("contract1no")) { 

			if (s.equalsIgnoreCase("contract1yes")) {
				htmlid = "lyraev5";
			} else if (s.equalsIgnoreCase("contract1no")) {

				pc.getQuest().set_step(L1Quest.QUEST_LYRA, 0);
				htmlid = "lyraev4";
			}
			int totem = 0;
			if (pc.getInventory().checkItem(40131)) {
				totem++;
			}
			if (pc.getInventory().checkItem(40132)) {
				totem++;
			}
			if (pc.getInventory().checkItem(40133)) {
				totem++;
			}
			if (pc.getInventory().checkItem(40134)) {
				totem++;
			}
			if (pc.getInventory().checkItem(40135)) {
				totem++;
			}
			if (totem != 0) {
				materials = new int[totem];
				counts = new int[totem];
				createitem = new int[totem];
				createcount = new int[totem];

				totem = 0;
				if (pc.getInventory().checkItem(40131)) {
					L1ItemInstance l1iteminstance = pc.getInventory()
							.findItemId(40131);
					int i1 = l1iteminstance.getCount();
					materials[totem] = 40131;
					counts[totem] = i1;
					createitem[totem] = L1ItemId.ADENA;
					createcount[totem] = i1 * 50;
					totem++;
				}
				if (pc.getInventory().checkItem(40132)) {
					L1ItemInstance l1iteminstance = pc.getInventory()
							.findItemId(40132);
					int i1 = l1iteminstance.getCount();
					materials[totem] = 40132;
					counts[totem] = i1;
					createitem[totem] = L1ItemId.ADENA;
					createcount[totem] = i1 * 100;
					totem++;
				}
				if (pc.getInventory().checkItem(40133)) {
					L1ItemInstance l1iteminstance = pc.getInventory()
							.findItemId(40133);
					int i1 = l1iteminstance.getCount();
					materials[totem] = 40133;
					counts[totem] = i1;
					createitem[totem] = L1ItemId.ADENA;
					createcount[totem] = i1 * 50;
					totem++;
				}
				if (pc.getInventory().checkItem(40134)) {
					L1ItemInstance l1iteminstance = pc.getInventory()
							.findItemId(40134);
					int i1 = l1iteminstance.getCount();
					materials[totem] = 40134;
					counts[totem] = i1;
					createitem[totem] = L1ItemId.ADENA;
					createcount[totem] = i1 * 30;
					totem++;
				}
				if (pc.getInventory().checkItem(40135)) {
					L1ItemInstance l1iteminstance = pc.getInventory()
							.findItemId(40135);
					int i1 = l1iteminstance.getCount();
					materials[totem] = 40135;
					counts[totem] = i1;
					createitem[totem] = L1ItemId.ADENA;
					createcount[totem] = i1 * 200;
					totem++;
				}
			}
		} else if (s.equalsIgnoreCase("pandora6") || s.equalsIgnoreCase("cold6")
				|| s.equalsIgnoreCase("balsim3")
				|| s.equalsIgnoreCase("mellin3") || s.equalsIgnoreCase("glen3")) {
			htmlid = s;
			int taxRatesCastle = L1CastleLocation
					.getCastleTaxRateByNpcId(npcid);
			htmldata = new String[] { String.valueOf(taxRatesCastle) };
		} else if (s.equalsIgnoreCase("set")) {
			if (obj instanceof L1NpcInstance) {
				int town_id = L1TownLocation.getTownIdByNpcid(npcid);

				if (town_id >= 1 && town_id <= 10) {
					if (pc.getHomeTownId() == -1) {
						pc.sendPackets(new S_ServerMessage(759));
						htmlid = "";
					} else if (pc.getHomeTownId() > 0) {
						if (pc.getHomeTownId() != town_id) {
							L1Town town = TownTable.getInstance().getTownTable(
									pc.getHomeTownId());
							if (town != null) {
								pc.sendPackets(new S_ServerMessage(758, town
										.get_name()));
							}
							htmlid = "";
						} else {
							htmlid = "";
						}
					} else if (pc.getHomeTownId() == 0) {
						if (pc.getLevel() < 10) {
							pc.sendPackets(new S_ServerMessage(757));
							htmlid = "";
						} else {
							int level = pc.getLevel();
							int cost = level * level * 10;
							if (pc.getInventory().consumeItem(L1ItemId.ADENA,
									cost)) {
								pc.setHomeTownId(town_id);
								pc.setContribution(0); 
								pc.save();
							} else {
								pc.sendPackets(new S_ServerMessage(337, "$4"));
							}
							htmlid = "";
						}
					}
				}
			}
		} else if (s.equalsIgnoreCase("clear")) {
			if (obj instanceof L1NpcInstance) {
				int town_id = L1TownLocation.getTownIdByNpcid(npcid);
				if (town_id > 0) {
					if (pc.getHomeTownId() > 0) {
						if (pc.getHomeTownId() == town_id) {
							pc.setHomeTownId(-1);
							pc.setContribution(0); 
							pc.save();
						} else {
							pc.sendPackets(new S_ServerMessage(756));
						}
					}
					htmlid = "";
				}
			}
		} else if (s.equalsIgnoreCase("ask")) {
			if (obj instanceof L1NpcInstance) {
				int town_id = L1TownLocation.getTownIdByNpcid(npcid);

				if (town_id >= 1 && town_id <= 10) {
					L1Town town = TownTable.getInstance().getTownTable(town_id);
					String leader = town.get_leader_name();
					if (leader != null && leader.length() != 0) {
						htmlid = "owner";
						htmldata = new String[] { leader };
					} else {
						htmlid = "noowner";
					}
				}
			}
		} else if (npcid == 70534 || npcid == 70556 || npcid == 70572
				|| npcid == 70631 || npcid == 70663 || npcid == 70761 
				|| npcid == 70788 || npcid == 70806 || npcid == 70830 
				|| npcid == 70876) {
			// NOTE: The following is the custom mayor code. Integrate changes carefully.
			int town_id = L1TownLocation.getTownIdByNpcid(npcid);
			if (town_id >= 1 && town_id <= 10) {
				if (s.equalsIgnoreCase("r")) {//TODO Town mayor report about income
					if (obj instanceof L1NpcInstance) {
						if(TownTable.getInstance().isLeader(client.getActiveChar(), town_id)) {
							String salesMoney = ""+TownTable.getInstance().getTodaySales(town_id);
							String salesMoneyYesterday = ""+TownTable.getInstance().getYesterdaySales(town_id);
							htmlid = "secretary4";
							htmldata = new String[] { salesMoneyYesterday, salesMoney };
							}
						}
				} else if (s.equalsIgnoreCase("t")) {//TODO Town mayor change tax rates
					if (obj instanceof L1NpcInstance) {
						if(TownTable.getInstance().isLeader(client.getActiveChar(), town_id)) {
						}
					}
				} else if (s.equalsIgnoreCase("c")) {//TODO Town mayor recieve compensation
					if (obj instanceof L1NpcInstance) {
						L1PcInstance player = client.getActiveChar();
						if(TownTable.getInstance().isLeader(player, town_id)) {
							int taxMoney = TownTable.getInstance().recieveInfoAboutTaxes(town_id);
							L1ItemInstance item = ItemTable.getInstance().createItem(40308);
							item.setCount(taxMoney);
							if (player.getInventory().checkAddItem(item , taxMoney) == L1Inventory.OK) {
								TownTable.getInstance().removeTaxes(town_id);
								player.getInventory().storeItem(item);
								player.sendPackets(new S_SystemMessage("You recieved "+taxMoney+" adena in taxes."));
							}
						}
					}
				}
			} else if (s.equalsIgnoreCase("t")) {

			} else if (s.equalsIgnoreCase("c")) {

			}
		} else if (npcid == 70997) {
			if (s.equalsIgnoreCase("0")) {
				final int[] item_ids = { 41146, 4, 20322, 173, 40743, };
				final int[] item_amounts = { 1, 1, 1, 1, 500, };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143, npcName,
							item.getLogName()));
				}
				pc.getQuest().set_step(L1Quest.QUEST_DOROMOND, 1);
				htmlid = "jpe0015";
			}
		} else if (npcid == 70999) {
			if (s.equalsIgnoreCase("1")) {
				if (pc.getInventory().consumeItem(41146, 1)) {
					final int[] item_ids = { 23, 20219, 20193, };
					final int[] item_amounts = { 1, 1, 1, };
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143, npcName, 
									item.getLogName()));
					}
					pc.getQuest().set_step(L1Quest.QUEST_DOROMOND, 2);
					htmlid = "";
				}
			} else if (s.equalsIgnoreCase("2")) {
				L1ItemInstance item = pc.getInventory().storeItem(41227, 1);
				pc.sendPackets(new S_ServerMessage(143, npcName,
						item.getLogName()));
						pc.getQuest().set_step(L1Quest.QUEST_AREX,
						L1Quest.QUEST_END);
				htmlid = "";
			}
		} else if (npcid == 71005) {
			if (s.equalsIgnoreCase("0")) {
				if (!pc.getInventory().checkItem(41209)) {
					L1ItemInstance item = pc.getInventory().storeItem(41209, 1);
					pc.sendPackets(new S_ServerMessage(143, npcName,
							item.getItem().getName()));
					htmlid = "";
				}
			} else if (s.equalsIgnoreCase("1")) {
				if (pc.getInventory().consumeItem(41213, 1)) {
					L1ItemInstance item = pc.getInventory().storeItem(40029,
							20);
					pc.sendPackets(new S_ServerMessage(143, npcName,
							item.getItem().getName()
							+ " (" + 20 + ")"));
					htmlid = "";
				}
			}
		} else if (npcid == 71006) {
			if (s.equalsIgnoreCase("0")) {
				if (pc.getLevel() > 25) {
					htmlid = "jpe0057";
				} else if (pc.getInventory().checkItem(41213)) { 
					htmlid = "jpe0056";
				} else if (pc.getInventory().checkItem(41210)
						|| pc.getInventory().checkItem(41211)) { 
					htmlid = "jpe0055";
				} else if (pc.getInventory().checkItem(41209)) {
					htmlid = "jpe0054";
				} else if (pc.getInventory().checkItem(41212)) { 
					htmlid = "jpe0056";
					materials = new int[] { 41212 }; 
					counts = new int[] { 1 };
					createitem = new int[] { 41213 }; 
					createcount = new int[] { 1 };
				} else {
					htmlid = "jpe0057";
				}
			}
		} else if (npcid == 70512) {
			if (s.equalsIgnoreCase("0") || s.equalsIgnoreCase("fullheal")) {
				int hp = _random.nextInt(30) + 70;
				pc.setCurrentHp(pc.getCurrentHp() + hp);
				pc.sendPackets(new S_ServerMessage(77));
				pc.sendPackets(new S_SkillSound(pc.getId(), 830));
				pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
				htmlid = "";
			}
		} else if (npcid == 71037) {
			if (s.equalsIgnoreCase("0")) {
				pc.setCurrentHp(pc.getMaxHp());
				pc.setCurrentMp(pc.getMaxMp());
				pc.sendPackets(new S_ServerMessage(77));
				pc.sendPackets(new S_SkillSound(pc.getId(), 830));
				pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
				pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
			}
		} else if (npcid == 71030) {
			if (s.equalsIgnoreCase("fullheal")) {
				if (pc.getInventory().checkItem(L1ItemId.ADENA, 5)) { 
					pc.getInventory().consumeItem(L1ItemId.ADENA, 5); 
					pc.setCurrentHp(pc.getMaxHp());
					pc.setCurrentMp(pc.getMaxMp());
					pc.sendPackets(new S_ServerMessage(77));
					pc.sendPackets(new S_SkillSound(pc.getId(), 830));
					pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
					pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
					if (pc.isInParty()) {
						pc.getParty().updateMiniHP(pc);
					}
				} else {
					pc.sendPackets(new S_ServerMessage(337, "$4")); 
				}
			}
		} else if (npcid == 71002) {
			if (s.equalsIgnoreCase("0")) {
				if (pc.getLevel() <= 13) {
					L1SkillUse skillUse = new L1SkillUse();
					skillUse.handleCommands(pc, CANCELLATION, pc
							.getId(), pc.getX(), pc.getY(), null, 0,
							L1SkillUse.TYPE_NPCBUFF, (L1NpcInstance) obj);
					htmlid = ""; 
				}
			}
		} else if (npcid == 71025) {
			if (s.equalsIgnoreCase("0")) {
				L1ItemInstance item = pc.getInventory().storeItem(41225, 1);
				pc.sendPackets(new S_ServerMessage(143, npcName,
						item.getItem().getName()));
				htmlid = "jpe0083";
			}
		} else if (npcid == 71055) {
			if (s.equalsIgnoreCase("0")) {
				L1ItemInstance item = pc.getInventory().storeItem(40701, 1);
				pc.sendPackets(new S_ServerMessage(143, npcName,
						item.getItem().getName()));
						pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 1);
				htmlid = "lukein8";
			} else if (s.equalsIgnoreCase("2")) {
				htmlid = "lukein12";
				pc.getQuest().set_step(L1Quest.QUEST_RESTA, 3);
			}
		} else if (npcid == 71063) {
			if (s.equalsIgnoreCase("0")) {
				materials = new int[] { 40701 }; 
				counts = new int[] { 1 };
				createitem = new int[] { 40702 }; 
				createcount = new int[] { 1 };
				htmlid = "maptbox1";
				pc.getQuest().set_end(L1Quest.QUEST_TBOX1);
				int[] nextbox = { 1, 2, 3 };
				int pid = _random.nextInt(nextbox.length);
				int nb = nextbox[pid];
				if (nb == 1) { 
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 2);
				} else if (nb == 2) { 
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 3);
				} else if (nb == 3) { 
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 4);
				}
			}
		} else if (npcid == 71064
				|| npcid == 71065
				|| npcid == 71066) {
			if (s.equalsIgnoreCase("0")) {
				materials = new int[] { 40701 }; 
				counts = new int[] { 1 };
				createitem = new int[] { 40702 };
				createcount = new int[] { 1 };
				htmlid = "maptbox1";
				pc.getQuest().set_end(L1Quest.QUEST_TBOX2);
				int[] nextbox2 = { 1, 2, 3, 4, 5, 6 };
				int pid = _random.nextInt(nextbox2.length);
				int nb2 = nextbox2[pid];
				if (nb2 == 1) { 
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 5);
				} else if (nb2 == 2) { 
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 6);
				} else if (nb2 == 3) { 
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 7);
				} else if (nb2 == 4) { 
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 8);
				} else if (nb2 == 5) { 
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 9);
				} else if (nb2 == 6) {
					pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 10);
				}
			}
		} else if (npcid == 71056) {
			if (s.equalsIgnoreCase("a")) {
				pc.getQuest().set_step(L1Quest.QUEST_SIMIZZ, 1);
				htmlid = "SIMIZZ7";
			} else if (s.equalsIgnoreCase("b")) {
				if (pc.getInventory().checkItem(40661)
						&& pc.getInventory().checkItem(40662)
						&& pc.getInventory().checkItem(40663)) {
					htmlid = "SIMIZZ8";
					pc.getQuest().set_step(L1Quest.QUEST_SIMIZZ, 2);
					materials = new int[] { 40661, 40662, 40663 };
					counts = new int[] { 1, 1, 1 };
					createitem = new int[] { 20044 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "SIMIZZ9";
				}
			} else if (s.equalsIgnoreCase("d")) {
				htmlid = "SIMIZZ12";
				pc.getQuest().set_step(L1Quest.QUEST_SIMIZZ, L1Quest.QUEST_END);
			}
		} else if (npcid == 71057) {
			if (s.equalsIgnoreCase("3")) {
				htmlid = "doil4";
			} else if (s.equalsIgnoreCase("6")) {
				htmlid = "doil6";
			} else if (s.equalsIgnoreCase("1")) {
				if (pc.getInventory().checkItem(40714)) {
					htmlid = "doil8";
					materials = new int[] { 40714 };
					counts = new int[] { 1 };
					createitem = new int[] { 40647 };
					createcount = new int[] { 1 };
					pc.getQuest().set_step(L1Quest.QUEST_DOIL,
							L1Quest.QUEST_END);
				} else {
					htmlid = "doil7";
				}
			}
		} else if (npcid == 71059) {
			if (s.equalsIgnoreCase("A")) {
				htmlid = "rudian6";
				L1ItemInstance item = pc.getInventory().storeItem(40700 , 1);
				pc.sendPackets(new S_ServerMessage(143, npcName,
						item.getItem().getName()));
				pc.getQuest().set_step(L1Quest.QUEST_RUDIAN, 1);
			} else if (s.equalsIgnoreCase("B")) {
				if (pc.getInventory().checkItem(40710)) {
					htmlid = "rudian8";
					materials = new int[] { 40700, 40710 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 40647 };
					createcount = new int[] { 1 };
					pc.getQuest().set_step(L1Quest.QUEST_RUDIAN,
							L1Quest.QUEST_END);
				} else {
					htmlid = "rudian9";
				}
			}
		} else if (npcid == 71060) {
			if (s.equalsIgnoreCase("A")) {
				if (pc.getQuest().get_step(L1Quest.QUEST_RUDIAN) == L1Quest.QUEST_END) {
					htmlid = "resta6";
				} else {
					htmlid = "resta4";
				}
			} else if (s.equalsIgnoreCase("B")) {
				htmlid = "resta10";
				pc.getQuest().set_step(L1Quest.QUEST_RESTA, 2);
			}
		} else if (npcid == 71061) {
			if (s.equalsIgnoreCase("A")) {
				if (pc.getInventory().checkItem(40647, 3)) {
					htmlid = "cadmus6";
					pc.getInventory().consumeItem(40647, 3);
					pc.getQuest().set_step(L1Quest.QUEST_CADMUS, 2);
				} else {
					htmlid = "cadmus5";
					pc.getQuest().set_step(L1Quest.QUEST_CADMUS, 1);
				}
			}
		} else if (npcid == 71036) {
			if (s.equalsIgnoreCase("a")) {
				htmlid = "kamyla7";
				pc.getQuest().set_step(L1Quest.QUEST_KAMYLA, 1);
			} else if (s.equalsIgnoreCase("c")) {
				htmlid = "kamyla10";
				pc.getInventory().consumeItem(40644, 1);
				pc.getQuest().set_step(L1Quest.QUEST_KAMYLA, 3);
			} else if (s.equalsIgnoreCase("e")) {
				htmlid = "kamyla13";
				pc.getInventory().consumeItem(40630, 1);
				pc.getQuest().set_step(L1Quest.QUEST_KAMYLA, 4);
			} else if (s.equalsIgnoreCase("i")) {
				htmlid = "kamyla25";
			} else if (s.equalsIgnoreCase("b")) { //
				if (pc.getQuest().get_step(L1Quest.QUEST_KAMYLA) == 1) {
					L1Teleport.teleport(pc, 32679, 32742, (short) 482, 5, true);
				}
			} else if (s.equalsIgnoreCase("d")) { // 
				if (pc.getQuest().get_step(L1Quest.QUEST_KAMYLA) == 3) {
					L1Teleport.teleport(pc, 32736, 32800, (short) 483, 5, true);
				}
			} else if (s.equalsIgnoreCase("f")) { // 
				if (pc.getQuest().get_step(L1Quest.QUEST_KAMYLA) == 4) {
					L1Teleport.teleport(pc, 32746, 32807, (short) 484, 5, true);
				}
			}
		} else if (npcid == 71089) {
			if (s.equalsIgnoreCase("a")) {
				htmlid = "francu10";
				L1ItemInstance item = pc.getInventory().storeItem(40644, 1);
				pc.sendPackets(new S_ServerMessage(143, npcName,
						item.getItem().getName()));
				pc.getQuest().set_step(L1Quest.QUEST_KAMYLA, 2);
			}
		} else if (npcid == 71090) {
			if (s.equalsIgnoreCase("a")) {
				htmlid = "";
				final int[] item_ids = { 246, 247, 248, 249, 40660 };
				final int[] item_amounts = { 1, 1, 1, 1, 5 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143, npcName,
							item.getItem().getName()));
					pc.getQuest().set_step(L1Quest.QUEST_CRYSTAL, 1);
				}
			} else if (s.equalsIgnoreCase("b")) {
				if (pc.getInventory().checkEquipped(246)
						|| pc.getInventory().checkEquipped(247)
						|| pc.getInventory().checkEquipped(248)
						|| pc.getInventory().checkEquipped(249)) {
					htmlid = "jcrystal5";
				} else if (pc.getInventory().checkItem(40660)) {
					htmlid = "jcrystal4";
				} else {
					pc.getInventory().consumeItem(246, 1);
					pc.getInventory().consumeItem(247, 1);
					pc.getInventory().consumeItem(248, 1);
					pc.getInventory().consumeItem(249, 1);
					pc.getInventory().consumeItem(40620, 1);
					pc.getQuest().set_step(L1Quest.QUEST_CRYSTAL, 2);
					L1Teleport.teleport(pc, 32801, 32895, (short) 483, 4, true);
				}
			} else if (s.equalsIgnoreCase("c")) {
				if (pc.getInventory().checkEquipped(246)
						|| pc.getInventory().checkEquipped(247)
						|| pc.getInventory().checkEquipped(248)
						|| pc.getInventory().checkEquipped(249)) {
					htmlid = "jcrystal5";
				} else {
					pc.getInventory().checkItem(40660);
					L1ItemInstance l1iteminstance = pc.getInventory()
							.findItemId(40660);
					int sc = l1iteminstance.getCount();
					if (sc > 0) {
						pc.getInventory().consumeItem(40660, sc);
					} else {
					}
					pc.getInventory().consumeItem(246, 1);
					pc.getInventory().consumeItem(247, 1);
					pc.getInventory().consumeItem(248, 1);
					pc.getInventory().consumeItem(249, 1);
					pc.getInventory().consumeItem(40620, 1);
					pc.getQuest().set_step(L1Quest.QUEST_CRYSTAL, 0);
					L1Teleport.teleport(pc, 32736, 32800, (short) 483, 4, true);
				}
			}
		} else if (npcid == 71091) {
			if (s.equalsIgnoreCase("a")) {
				htmlid = "";
				pc.getInventory().consumeItem(40654, 1);
				pc.getQuest()
						.set_step(L1Quest.QUEST_CRYSTAL, L1Quest.QUEST_END);
				L1Teleport.teleport(pc, 32744, 32927, (short) 483, 4, true);
			}
		} else if (npcid == 71074) {
			if (s.equalsIgnoreCase("A")) {
				htmlid = "lelder5";
				pc.getQuest().set_step(L1Quest.QUEST_LIZARD, 1);
			} else if (s.equalsIgnoreCase("B")) {
				htmlid = "lelder10";
				pc.getInventory().consumeItem(40633, 1);
				pc.getQuest().set_step(L1Quest.QUEST_LIZARD, 3);
			} else if (s.equalsIgnoreCase("C")) {
				htmlid = "lelder13";
				if (pc.getQuest().get_step(L1Quest.QUEST_LIZARD) == L1Quest.QUEST_END) {
				}
				materials = new int[] { 40634 };
				counts = new int[] { 1 };
				createitem = new int[] { 20167 };
				createcount = new int[] { 1 };
				pc.getQuest().set_step(L1Quest.QUEST_LIZARD, L1Quest.QUEST_END);
			}
		} else if (npcid == 71198) {
			if (s.equalsIgnoreCase("A")) {
				if (pc.getQuest().get_step(71198) != 0
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().consumeItem(41339, 5)) { 
					L1ItemInstance item = ItemTable.getInstance().createItem(
							41340); // 
					if (item != null) {
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143, npcName,
											item.getItem().getName())); 
						}
					}
					pc.getQuest().set_step(71198, 1);
					htmlid = "tion4";
				} else {
					htmlid = "tion9";
				}
			} else if (s.equalsIgnoreCase("B")) {
				if (pc.getQuest().get_step(71198) != 1
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().consumeItem(41341, 1)) { 
					pc.getQuest().set_step(71198, 2);
					htmlid = "tion5";
				} else {
					htmlid = "tion10";
				}
			} else if (s.equalsIgnoreCase("C")) {
				if (pc.getQuest().get_step(71198) != 2
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().consumeItem(41343, 1)) { 
					L1ItemInstance item = ItemTable.getInstance().createItem(
							21057); // 
					if (item != null) {
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143, npcName,
											item.getItem().getName())); 
						}
					}
					pc.getQuest().set_step(71198, 3);
					htmlid = "tion6";
				} else {
					htmlid = "tion12";
				}
			} else if (s.equalsIgnoreCase("D")) {
				if (pc.getQuest().get_step(71198) != 3
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().consumeItem(41344, 1)) {
					L1ItemInstance item = ItemTable.getInstance().createItem(
							21058); // 
					if (item != null) {
						pc.getInventory().consumeItem(21057, 1);
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143, npcName,
											item.getItem().getName())); 
						}
					}
					pc.getQuest().set_step(71198, 4);
					htmlid = "tion7";
				} else {
					htmlid = "tion13";
				}
			} else if (s.equalsIgnoreCase("E")) {
				if (pc.getQuest().get_step(71198) != 4
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().consumeItem(41345, 1)) { 
					L1ItemInstance item = ItemTable.getInstance().createItem(
							21059); // 
					if (item != null) {
						pc.getInventory().consumeItem(21058, 1);
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143, npcName,
											item.getItem().getName())); 
						}
					}
					pc.getQuest().set_step(71198, 0);
					pc.getQuest().set_step(71199, 0);
					htmlid = "tion8";
				} else {
					htmlid = "tion15";
				}
			}
		} else if (npcid == 71199) {
			if (s.equalsIgnoreCase("A")) {
				if (pc.getQuest().get_step(71199) != 0
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().checkItem(41340, 1)) { 
					pc.getQuest().set_step(71199, 1);
					htmlid = "jeron2";
				} else {
					htmlid = "jeron10";
				}
			} else if (s.equalsIgnoreCase("B")) {
				if (pc.getQuest().get_step(71199) != 1
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().consumeItem(40308, 1000000)) {
					L1ItemInstance item = ItemTable.getInstance().createItem(
							41341);
					if (item != null) {
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143, npcName,
											item.getItem().getName())); 
						}
					}
					pc.getInventory().consumeItem(41340, 1);
					pc.getQuest().set_step(71199, 255);
					htmlid = "jeron6";
				} else {
					htmlid = "jeron8";
				}
			} else if (s.equalsIgnoreCase("C")) {
				if (pc.getQuest().get_step(71199) != 1
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().consumeItem(41342, 1)) { 
					L1ItemInstance item = ItemTable.getInstance().createItem(
							41341); // 
					if (item != null) {
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143, npcName,
											item.getItem().getName())); 
						}
					}
					pc.getInventory().consumeItem(41340, 1);
					pc.getQuest().set_step(71199, 255);
					htmlid = "jeron5";
				} else {
					htmlid = "jeron9";
				}
			}
		} else if (npcid == 80079) {
			if (s.equalsIgnoreCase("0")) {
				if (!pc.getInventory().checkItem(41312)) { 
					L1ItemInstance item = pc.getInventory().storeItem(41312, 1);
					if (item != null) {
						pc.sendPackets(new S_ServerMessage(143, npcName,
									item.getItem().getName()));
						pc.getQuest().set_step(L1Quest.QUEST_KEPLISHA,
								L1Quest.QUEST_END);
					}
					htmlid = "keplisha7";
				}
			} else if (s.equalsIgnoreCase("1")) {
				if (!pc.getInventory().checkItem(41314)) {
					if (pc.getInventory().checkItem(L1ItemId.ADENA, 1000)) {
						materials = new int[] { L1ItemId.ADENA, 41313 }; 
						counts = new int[] { 1000, 1 };
						createitem = new int[] { 41314 }; 
						createcount = new int[] { 1 };
						int htmlA = _random.nextInt(3) + 1;
						int htmlB = _random.nextInt(100) + 1;
						switch (htmlA) {
							case 1:
								htmlid = "horosa" + htmlB;
								break;
							case 2:
								htmlid = "horosb" + htmlB;
								break;
							case 3:
								htmlid = "horosc" + htmlB;
								break;
							default:
								break;
						}
					} else {
						htmlid = "keplisha8";
					}
				}
			} else if (s.equalsIgnoreCase("2")) {
				if (pc.getTempCharGfx() != pc.getClassId()) {
					htmlid = "keplisha9";
				} else {
					if (pc.getInventory().checkItem(41314)) { 
						pc.getInventory().consumeItem(41314, 1);
						int html = _random.nextInt(9) + 1;
						int PolyId = 6180 + _random.nextInt(64);
						polyByKeplisha(client, PolyId);
						switch (html) {
							case 1:
								htmlid = "horomon11";
								break;
							case 2:
								htmlid = "horomon12";
								break;
							case 3:
								htmlid = "horomon13";
								break;
							case 4:
								htmlid = "horomon21";
								break;
							case 5:
								htmlid = "horomon22";
								break;
							case 6:
								htmlid = "horomon23";
								break;
							case 7:
								htmlid = "horomon31";
								break;
							case 8:
								htmlid = "horomon32";
								break;
							case 9:
								htmlid = "horomon33";
								break;
							default:
								break;
						}
					}
				}
			} else if (s.equalsIgnoreCase("3")) {
				if (pc.getInventory().checkItem(41312)) { 
					pc.getInventory().consumeItem(41312, 1);
					htmlid = "";
				}
				if (pc.getInventory().checkItem(41313)) { 
					pc.getInventory().consumeItem(41313, 1);
					htmlid = "";
				}
				if (pc.getInventory().checkItem(41314)) { 
					pc.getInventory().consumeItem(41314, 1);
					htmlid = "";
				}
			}
		} else if (npcid == 80082) {
			if (s.equalsIgnoreCase("L")) {
				if (pc.getInventory().checkItem(L1ItemId.ADENA, 1000)) {
					materials = new int[] { L1ItemId.ADENA };
					counts = new int[] { 1000 };
					createitem = new int[] { 41293 };
					createcount = new int[] { 1 };
					L1PolyMorph.undoPoly(pc);
					L1Teleport
							.teleport(pc, 32815, 32809, (short) 5124, 6, true);
				} else {
					htmlid = "fk_in_0";
				}
			} else if (s.equalsIgnoreCase("S")) {
				if (pc.getInventory().checkItem(L1ItemId.ADENA, 1000)) {
					materials = new int[] { L1ItemId.ADENA };
					counts = new int[] { 1000 };
					createitem = new int[] { 41294 };
					createcount = new int[] { 1 };
					L1PolyMorph.undoPoly(pc);
					L1Teleport
							.teleport(pc, 32815, 32809, (short) 5124, 6, true);
				} else {
					htmlid = "fk_in_0";
				}
			}
		} else if (npcid == 80083) {
			if (s.equalsIgnoreCase("O")) {
				if (!pc.getInventory().checkItem(41293, 1)
						&& !pc.getInventory().checkItem(41294, 1)) {
					htmlid = "fk_out_0";
				} else if (pc.getInventory().consumeItem(41293, 1)) {
					L1Teleport.teleport(pc, 32613, 32781, (short) 4, 4, true);
				} else if (pc.getInventory().consumeItem(41294, 1)) {
					L1Teleport.teleport(pc, 32613, 32781, (short) 4, 4, true);
				}
			}
		} else if (npcid == 80084) {
			if (s.equalsIgnoreCase("q")) {
				if (pc.getInventory().checkItem(41356, 1)) {
					htmlid = "rparum4";
				} else {
					L1ItemInstance item = pc.getInventory().storeItem(41356, 1);
					if (item != null) {
						pc.sendPackets(new S_ServerMessage(143, npcName,
										item.getItem().getName()));
					}
					htmlid = "rparum3";
				}
			}
		} else if (npcid == 80105) {
			if (s.equalsIgnoreCase("c")) {
				if (pc.isCrown()) {
					if (pc.getInventory().checkItem(20383, 1)) {
						if (pc.getInventory().checkItem(L1ItemId.ADENA, 100000)) {
							L1ItemInstance item = pc.getInventory().findItemId(
									20383);
							if (item != null && item.getChargeCount() != 50) {
								item.setChargeCount(50);
								pc.getInventory().updateItem(item,
										L1PcInventory.COL_CHARGE_COUNT);
								pc.getInventory().consumeItem(L1ItemId.ADENA,
										100000);
								htmlid = "";
							}
						} else {
							pc.sendPackets(new S_ServerMessage(337, "$4")); 
						}
					}
				}
			}
		} else if (npcid == 71126) {
			// uBv
			if (s.equalsIgnoreCase("B")) {
				if (pc.getInventory().checkItem(41007, 1)) { // 
					htmlid = "eris10";
				} else {
					L1ItemInstance item = pc.getInventory().storeItem(41007, 1);
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
					htmlid = "eris6";
				}
			} else if (s.equalsIgnoreCase("C")) {
				if (pc.getInventory().checkItem(41009, 1)) { // 
					htmlid = "eris10";
				} else {
					L1ItemInstance item = pc.getInventory().storeItem(41009, 1);
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
					htmlid = "eris8";
				}
			} else if (s.equalsIgnoreCase("A")) {
				if (pc.getInventory().checkItem(41007, 1)) { // 
					if (pc.getInventory().checkItem(40969, 20)) { // _[NGt
						htmlid = "eris18";
						materials = new int[] { 40969, 41007 };
						counts = new int[] { 20, 1 };
						createitem = new int[] { 41008 }; // 
						createcount = new int[] { 1 };
					} else {
						htmlid = "eris5";
					}
				} else {
					htmlid = "eris2";
				}
			} else if (s.equalsIgnoreCase("E")) {
				if (pc.getInventory().checkItem(41010, 1)) { // 
					htmlid = "eris19";
				} else {
					htmlid = "eris7";
				}
			} else if (s.equalsIgnoreCase("D")) {
				if (pc.getInventory().checkItem(41010, 1)) { // 
					htmlid = "eris19";
				} else {
					if (pc.getInventory().checkItem(41009, 1)) { // 
						if (pc.getInventory().checkItem(40959, 1)) { // 
							htmlid = "eris17";
							materials = new int[] { 40959, 41009 }; // 
							counts = new int[] { 1, 1 };
							createitem = new int[] { 41010 }; // 
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40960, 1)) { // 
							htmlid = "eris16";
							materials = new int[] { 40960, 41009 }; // 
							counts = new int[] { 1, 1 };
							createitem = new int[] { 41010 }; // 
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40961, 1)) { // 
							htmlid = "eris15";
							materials = new int[] { 40961, 41009 }; // 
							counts = new int[] { 1, 1 };
							createitem = new int[] { 41010 }; // 
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40962, 1)) { // 
							htmlid = "eris14";
							materials = new int[] { 40962, 41009 }; // 
							counts = new int[] { 1, 1 };
							createitem = new int[] { 41010 }; // 
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40635, 10)) { // 
							htmlid = "eris12";
							materials = new int[] { 40635, 41009 }; // 
							counts = new int[] { 10, 1 };
							createitem = new int[] { 41010 }; // 
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40638, 10)) { // 
							htmlid = "eris11";
							materials = new int[] { 40638, 41009 }; // 
							counts = new int[] { 10, 1 };
							createitem = new int[] { 41010 }; // 
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40642, 10)) { // 
							htmlid = "eris13";
							materials = new int[] { 40642, 41009 }; // 
							counts = new int[] { 10, 1 };
							createitem = new int[] { 41010 }; // 
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40667, 10)) { // 
							htmlid = "eris13";
							materials = new int[] { 40667, 41009 }; // 
							counts = new int[] { 10, 1 };
							createitem = new int[] { 41010 }; // 
							createcount = new int[] { 1 };
						} else {
							htmlid = "eris8";
						}
					} else {
						htmlid = "eris7";
					}
				}
			}
		} else if (npcid == 80076) {
			if (s.equalsIgnoreCase("A")) {
				int[] diaryno = { 49082, 49083 };
				int pid = _random.nextInt(diaryno.length);
				int di = diaryno[pid];
				if (di == 49082) { // 
					htmlid = "voyager6a";
					L1ItemInstance item = pc.getInventory().storeItem(di, 1);
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
				} else if (di == 49083) { // 
					htmlid = "voyager6b";
					L1ItemInstance item = pc.getInventory().storeItem(di, 1);
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
				}
			}
		} else if (npcid == 71128) {
			if (s.equals("A")) {
				if (pc.getInventory().checkItem(41010, 1)) { // 
					htmlid = "perita2";
				} else {
					htmlid = "perita3";
				}
			} else if (s.equals("p")) {
				// ubNCAO
				if (pc.getInventory().checkItem(40987, 1) // 
						&& pc.getInventory().checkItem(40988, 1) // 
						&& pc.getInventory().checkItem(40989, 1)) { // 
					htmlid = "perita43";
				} else if (pc.getInventory().checkItem(40987, 1) // 
						&& pc.getInventory().checkItem(40989, 1)) { // 
					htmlid = "perita44";
				} else if (pc.getInventory().checkItem(40987, 1) // 
						&& pc.getInventory().checkItem(40988, 1)) { // 
					htmlid = "perita45";
				} else if (pc.getInventory().checkItem(40988, 1) // 
						&& pc.getInventory().checkItem(40989, 1)) { // 
					htmlid = "perita47";
				} else if (pc.getInventory().checkItem(40987, 1)) { // 
					htmlid = "perita46";
				} else if (pc.getInventory().checkItem(40988, 1)) { // 
					htmlid = "perita49";
				} else if (pc.getInventory().checkItem(40987, 1)) { // 
					htmlid = "perita48";
				} else {
					htmlid = "perita50";
				}
			} else if (s.equals("q")) {
				// ubNCAO
				if (pc.getInventory().checkItem(41173, 1) // 
						&& pc.getInventory().checkItem(41174, 1) // 
						&& pc.getInventory().checkItem(41175, 1)) { // 
					htmlid = "perita54";
				} else if (pc.getInventory().checkItem(41173, 1) // 
						&& pc.getInventory().checkItem(41175, 1)) { // 
					htmlid = "perita55";
				} else if (pc.getInventory().checkItem(41173, 1) // 
						&& pc.getInventory().checkItem(41174, 1)) { // 
					htmlid = "perita56";
				} else if (pc.getInventory().checkItem(41174, 1) // 
						&& pc.getInventory().checkItem(41175, 1)) { // 
					htmlid = "perita58";
				} else if (pc.getInventory().checkItem(41174, 1)) { // 
					htmlid = "perita57";
				} else if (pc.getInventory().checkItem(41175, 1)) { // 
					htmlid = "perita60";
				} else if (pc.getInventory().checkItem(41176, 1)) { // 
					htmlid = "perita59";
				} else {
					htmlid = "perita61";
				}
			} else if (s.equals("s")) {
				if (pc.getInventory().checkItem(41161, 1) // 
						&& pc.getInventory().checkItem(41162, 1) // 
						&& pc.getInventory().checkItem(41163, 1)) { // 
					htmlid = "perita62";
				} else if (pc.getInventory().checkItem(41161, 1) // 
						&& pc.getInventory().checkItem(41163, 1)) { // 
					htmlid = "perita63";
				} else if (pc.getInventory().checkItem(41161, 1) // 
						&& pc.getInventory().checkItem(41162, 1)) { // 
					htmlid = "perita64";
				} else if (pc.getInventory().checkItem(41162, 1) // 
						&& pc.getInventory().checkItem(41163, 1)) { // 
					htmlid = "perita66";
				} else if (pc.getInventory().checkItem(41161, 1)) { // 
					htmlid = "perita65";
				} else if (pc.getInventory().checkItem(41162, 1)) { // 
					htmlid = "perita68";
				} else if (pc.getInventory().checkItem(41163, 1)) { // 
					htmlid = "perita67";
				} else {
					htmlid = "perita69";
				}
			} else if (s.equals("B")) {
				if (pc.getInventory().checkItem(40651, 10) // 
						&& pc.getInventory().checkItem(40643, 10) // 
						&& pc.getInventory().checkItem(40618, 10) // 
						&& pc.getInventory().checkItem(40645, 10) // 
						&& pc.getInventory().checkItem(40676, 10) // 
						&& pc.getInventory().checkItem(40442, 5) // 
						&& pc.getInventory().checkItem(40051, 1)) { // 
					htmlid = "perita7";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40442, 40051 };
					counts = new int[] { 10, 10, 10, 10, 20, 5, 1 };
					createitem = new int[] { 40925 }; // 
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita8";
				}
			} else if (s.equals("G") || s.equals("h") || s.equals("i")) {
				if (pc.getInventory().checkItem(40651, 5)
						&& pc.getInventory().checkItem(40643, 5)
						&& pc.getInventory().checkItem(40618, 5)
						&& pc.getInventory().checkItem(40645, 5)
						&& pc.getInventory().checkItem(40676, 5)
						&& pc.getInventory().checkItem(40675, 5)
						&& pc.getInventory().checkItem(40049, 3)
						&& pc.getInventory().checkItem(40051, 1)) {
					htmlid = "perita27";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40675, 40049, 40051 };
					counts = new int[] { 5, 5, 5, 5, 10, 10, 3, 1 };
					createitem = new int[] { 40926 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita28";
				}
			} else if (s.equals("H") || s.equals("j") || s.equals("k")) {
				if (pc.getInventory().checkItem(40651, 10)
						&& pc.getInventory().checkItem(40643, 10)
						&& pc.getInventory().checkItem(40618, 10)
						&& pc.getInventory().checkItem(40645, 10)
						&& pc.getInventory().checkItem(40676, 20)
						&& pc.getInventory().checkItem(40675, 10)
						&& pc.getInventory().checkItem(40048, 3)
						&& pc.getInventory().checkItem(40051, 1)) {
					htmlid = "perita29";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40675, 40048, 40051 };
					counts = new int[] { 10, 10, 10, 10, 20, 10, 3, 1 };
					createitem = new int[] { 40927 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita30";
				}
			} else if (s.equals("I") || s.equals("l") || s.equals("m")) {
				if (pc.getInventory().checkItem(40651, 20)
						&& pc.getInventory().checkItem(40643, 20)
						&& pc.getInventory().checkItem(40618, 20)
						&& pc.getInventory().checkItem(40645, 20)
						&& pc.getInventory().checkItem(40676, 30)
						&& pc.getInventory().checkItem(40675, 10)
						&& pc.getInventory().checkItem(40050, 3)
						&& pc.getInventory().checkItem(40051, 1)) {
					htmlid = "perita31";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40675, 40050, 40051 };
					counts = new int[] { 20, 20, 20, 20, 30, 10, 3, 1 };
					createitem = new int[] { 40928 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita32";
				}
			} else if (s.equals("J") || s.equals("n") || s.equals("o")) {
				if (pc.getInventory().checkItem(40651, 30)
						&& pc.getInventory().checkItem(40643, 30)
						&& pc.getInventory().checkItem(40618, 30)
						&& pc.getInventory().checkItem(40645, 30)
						&& pc.getInventory().checkItem(40676, 30)
						&& pc.getInventory().checkItem(40675, 20)
						&& pc.getInventory().checkItem(40052, 1)
						&& pc.getInventory().checkItem(40051, 1)) {
					htmlid = "perita33";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40675, 40052, 40051 };
					counts = new int[] { 30, 30, 30, 30, 30, 20, 1, 1 };
					createitem = new int[] { 40928 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita34";
				}
			} else if (s.equals("K")) {
				int earinga = 0;
				int earingb = 0;
				if (pc.getInventory().checkEquipped(21014)
						|| pc.getInventory().checkEquipped(21006)
						|| pc.getInventory().checkEquipped(21007)) {
					htmlid = "perita36";
				} else if (pc.getInventory().checkItem(21014, 1)) {
					earinga = 21014;
					earingb = 41176;
				} else if (pc.getInventory().checkItem(21006, 1)) {
					earinga = 21006;
					earingb = 41177;
				} else if (pc.getInventory().checkItem(21007, 1)) {
					earinga = 21007;
					earingb = 41178;
				} else {
					htmlid = "perita36";
				}
				if (earinga > 0) {
					materials = new int[] { earinga };
					counts = new int[] { 1 };
					createitem = new int[] { earingb };
					createcount = new int[] { 1 };
				}
			} else if (s.equals("L")) {
				if (pc.getInventory().checkEquipped(21015)) {
					htmlid = "perita22";
				} else if (pc.getInventory().checkItem(21015, 1)) {
					materials = new int[] { 21015 };
					counts = new int[] { 1 };
					createitem = new int[] { 41179 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita22";
				}
			} else if (s.equals("M")) {
				if (pc.getInventory().checkEquipped(21016)) {
					htmlid = "perita26";
				} else if (pc.getInventory().checkItem(21016, 1)) {
					materials = new int[] { 21016 };
					counts = new int[] { 1 };
					createitem = new int[] { 41182 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita26";
				}
			} else if (s.equals("b")) {
				if (pc.getInventory().checkEquipped(21009)) {
					htmlid = "perita39";
				} else if (pc.getInventory().checkItem(21009, 1)) {
					materials = new int[] { 21009 };
					counts = new int[] { 1 };
					createitem = new int[] { 41180 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita39";
				}
			} else if (s.equals("d")) {
				if (pc.getInventory().checkEquipped(21012)) {
					htmlid = "perita41";
				} else if (pc.getInventory().checkItem(21012, 1)) {
					materials = new int[] { 21012 };
					counts = new int[] { 1 };
					createitem = new int[] { 41183 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita41";
				}
			} else if (s.equals("a")) {
				if (pc.getInventory().checkEquipped(21008)) {
					htmlid = "perita38";
				} else if (pc.getInventory().checkItem(21008, 1)) {
					materials = new int[] { 21008 };
					counts = new int[] { 1 };
					createitem = new int[] { 41181 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita38";
				}
			} else if (s.equals("c")) {
				if (pc.getInventory().checkEquipped(21010)) {
					htmlid = "perita40";
				} else if (pc.getInventory().checkItem(21010, 1)) {
					materials = new int[] { 21010 };
					counts = new int[] { 1 };
					createitem = new int[] { 41184 };
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita40";
				}
			}
		} else if (npcid == 71129) {
			if (s.equals("Z")) {
				htmlid = "rumtis2";
			} else if (s.equals("Y")) {
				if (pc.getInventory().checkItem(41010, 1)) {
					htmlid = "rumtis3";
				} else {
					htmlid = "rumtis4";
				}
			} else if (s.equals("q")) {
				htmlid = "rumtis92";
			} else if (s.equals("A")) {
				if (pc.getInventory().checkItem(41161, 1)) {
					htmlid = "rumtis6";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("B")) {
				if (pc.getInventory().checkItem(41164, 1)) {
					htmlid = "rumtis7";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("C")) {
				if (pc.getInventory().checkItem(41167, 1)) {
					htmlid = "rumtis8";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("T")) {
				if (pc.getInventory().checkItem(41167, 1)) {
					htmlid = "rumtis9";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("w")) {
				if (pc.getInventory().checkItem(41162, 1)) {
					htmlid = "rumtis14";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("x")) {
				if (pc.getInventory().checkItem(41165, 1)) {
					htmlid = "rumtis15";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("y")) {
				if (pc.getInventory().checkItem(41168, 1)) {
					htmlid = "rumtis16";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("z")) {
				if (pc.getInventory().checkItem(41171, 1)) {
					htmlid = "rumtis17";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("U")) {
				if (pc.getInventory().checkItem(41163, 1)) {
					htmlid = "rumtis10";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("V")) {
				if (pc.getInventory().checkItem(41166, 1)) {
					htmlid = "rumtis11";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("W")) {
				if (pc.getInventory().checkItem(41169, 1)) {
					htmlid = "rumtis12";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("X")) {
				if (pc.getInventory().checkItem(41172, 1)) {
					htmlid = "rumtis13";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("D") || s.equals("E") || s.equals("F")
					|| s.equals("G")) {
				int insn = 0;
				int bacn = 0;
				int me = 0;
				int mr = 0;
				int mj = 0;
				int an = 0;
				int men = 0;
				int mrn = 0;
				int mjn = 0;
				int ann = 0;
				if (pc.getInventory().checkItem(40959, 1)
						&& pc.getInventory().checkItem(40960, 1)
						&& pc.getInventory().checkItem(40961, 1)
						&& pc.getInventory().checkItem(40962, 1)) {
					insn = 1;
					me = 40959;
					mr = 40960;
					mj = 40961;
					an = 40962;
					men = 1;
					mrn = 1;
					mjn = 1;
					ann = 1;
				} else if (pc.getInventory().checkItem(40642, 10)
						&& pc.getInventory().checkItem(40635, 10)
						&& pc.getInventory().checkItem(40638, 10)
						&& pc.getInventory().checkItem(40667, 10)) {
					bacn = 1;
					me = 40642;
					mr = 40635;
					mj = 40638;
					an = 40667;
					men = 10;
					mrn = 10;
					mjn = 10;
					ann = 10;
				}
				if (pc.getInventory().checkItem(40046, 1)
						&& pc.getInventory().checkItem(40618, 5)
						&& pc.getInventory().checkItem(40643, 5)
						&& pc.getInventory().checkItem(40645, 5)
						&& pc.getInventory().checkItem(40651, 5)
						&& pc.getInventory().checkItem(40676, 5)) {
					if (insn == 1 || bacn == 1) {
						htmlid = "rumtis60";
						materials = new int[] { me, mr, mj, an, 40046, 40618,
								40643, 40651, 40676 };
						counts = new int[] { men, mrn, mjn, ann, 1, 5, 5, 5, 5,
								5 };
						createitem = new int[] { 40926 };
						createcount = new int[] { 1 };
					} else {
						htmlid = "rumtis18";
					}
				}
			}
		} else if (npcid == 71119) {
			if (s.equalsIgnoreCase("request las history book")) {
				materials = new int[] { 41019, 41020, 41021, 41022, 41023,
						41024, 41025, 41026 };
				counts = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
				createitem = new int[] { 41027 };
				createcount = new int[] { 1 };
				htmlid = "";
			}
		} else if (npcid == 71170) {
			if (s.equalsIgnoreCase("request las weapon manual")) {
				materials = new int[] { 41027 };
				counts = new int[] { 1 };
				createitem = new int[] { 40965 };
				createcount = new int[] { 1 };
				htmlid = "";
			}
		} else if (npcid == 71168) {
			if (s.equalsIgnoreCase("a")) {
				if (pc.getInventory().checkItem(41028, 1)) {
					L1Teleport.teleport(pc, 32648, 32921, (short) 535, 6, true);
					pc.getInventory().consumeItem(41028, 1);
				}
			}
		} else if (npcid == 80067) {
			if (s.equalsIgnoreCase("n")) {
				htmlid = "";
				poly(client, 6034);
				final int[] item_ids = { 41132, 41133, 41134 };
				final int[] item_amounts = { 1, 1, 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143, npcName,
							item.getItem().getName()));
					pc.getQuest().set_step(L1Quest.QUEST_DESIRE, 1);
				}
			} else if (s.equalsIgnoreCase("d")) {
				htmlid = "minicod09";
				pc.getInventory().consumeItem(41130, 1);
				pc.getInventory().consumeItem(41131, 1);
			} else if (s.equalsIgnoreCase("k")) {
				htmlid = "";
				pc.getInventory().consumeItem(41132, 1);
				pc.getInventory().consumeItem(41133, 1);
				pc.getInventory().consumeItem(41134, 1);
				pc.getInventory().consumeItem(41135, 1);
				pc.getInventory().consumeItem(41136, 1);
				pc.getInventory().consumeItem(41137, 1);
				pc.getInventory().consumeItem(41138, 1);
				pc.getQuest().set_step(L1Quest.QUEST_DESIRE, 0);
			} else if (s.equalsIgnoreCase("e")) {
				if (pc.getQuest().get_step(L1Quest.QUEST_DESIRE) == L1Quest.QUEST_END
						|| pc.getKarmaLevel() >= 1) {
					htmlid = "";
				} else {
					if (pc.getInventory().checkItem(41138)) {
						htmlid = "";
						pc.addKarma((int) (1600 * Config.RATE_KARMA));
						pc.getInventory().consumeItem(41130, 1); // 
						pc.getInventory().consumeItem(41131, 1); // 
						pc.getInventory().consumeItem(41138, 1); // 
						pc.getQuest().set_step(L1Quest.QUEST_DESIRE,
								L1Quest.QUEST_END);
					} else {
						htmlid = "minicod04";
					}
				}
			} else if (s.equalsIgnoreCase("g")) {
				htmlid = "";
				L1ItemInstance item = pc.getInventory().storeItem(41130 , 1); // 
				pc.sendPackets(new S_ServerMessage(143, npcName,
						item.getItem().getName())); 
			}
		} else if (npcid == 81202) {
			if (s.equalsIgnoreCase("n")) {
				htmlid = "";
				poly(client, 6035);
				final int[] item_ids = { 41123, 41124, 41125 };
				final int[] item_amounts = { 1, 1, 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143, npcName,
							item.getItem().getName()));
					pc.getQuest().set_step(L1Quest.QUEST_SHADOWS, 1);
				}
			} else if (s.equalsIgnoreCase("d")) {
				htmlid = "minitos09";
				pc.getInventory().consumeItem(41121, 1);
				pc.getInventory().consumeItem(41122, 1);
			} else if (s.equalsIgnoreCase("k")) {
				htmlid = "";
				pc.getInventory().consumeItem(41123, 1); // 
				pc.getInventory().consumeItem(41124, 1); // 
				pc.getInventory().consumeItem(41125, 1); // 
				pc.getInventory().consumeItem(41126, 1); // 
				pc.getInventory().consumeItem(41127, 1); // 
				pc.getInventory().consumeItem(41128, 1); // 
				pc.getInventory().consumeItem(41129, 1); // 
				pc.getQuest().set_step(L1Quest.QUEST_SHADOWS, 0);
			} else if (s.equalsIgnoreCase("e")) {
				if (pc.getQuest().get_step(L1Quest.QUEST_SHADOWS) == L1Quest.QUEST_END
						|| pc.getKarmaLevel() >= 1) {
					htmlid = "";
				} else {
					if (pc.getInventory().checkItem(41129)) {
						htmlid = "";
						pc.addKarma((int) (-1600 * Config.RATE_KARMA));
						pc.getInventory().consumeItem(41121, 1); // 
						pc.getInventory().consumeItem(41122, 1); // 
						pc.getInventory().consumeItem(41129, 1); // 
						pc.getQuest().set_step(L1Quest.QUEST_SHADOWS,
								L1Quest.QUEST_END);
					} else {
						htmlid = "minitos04";
					}
				}
			} else if (s.equalsIgnoreCase("g")) {
				htmlid = "";
				L1ItemInstance item = pc.getInventory().storeItem(41121 , 1);
				pc.sendPackets(new S_ServerMessage(143, npcName,
						item.getItem().getName()));
			}
		} else if (npcid == 71252) {
			int weapon1 = 0;
			int weapon2 = 0;
			int newWeapon = 0;
			if (s.equalsIgnoreCase("A")) {
				weapon1 = 5;
				weapon2 = 6;
				newWeapon = 259;
				htmlid = "joegolem9";
			} else if (s.equalsIgnoreCase("B")) {
				weapon1 = 145;
				weapon2 = 148;
				newWeapon = 260;
				htmlid = "joegolem10";
			} else if (s.equalsIgnoreCase("C")) {
				weapon1 = 52;
				weapon2 = 64;
				newWeapon = 262;
				htmlid = "joegolem11";
			} else if (s.equalsIgnoreCase("D")) {
				weapon1 = 125;
				weapon2 = 129;
				newWeapon = 261;
				htmlid = "joegolem12";
			} else if (s.equalsIgnoreCase("E")) {
				weapon1 = 99;
				weapon2 = 104;
				newWeapon = 263;
				htmlid = "joegolem13";
			} else if (s.equalsIgnoreCase("F")) {
				weapon1 = 32;
				weapon2 = 42;
				newWeapon = 264;
				htmlid = "joegolem14";
			}
			if (pc.getInventory().checkEnchantItem(weapon1, 7, 1)
					&& pc.getInventory().checkEnchantItem(weapon2, 7, 1)
					&& pc.getInventory().checkItem(41246, 1000)
					&& pc.getInventory().checkItem(49143, 10)) {
				pc.getInventory().consumeEnchantItem(weapon1, 7, 1);
				pc.getInventory().consumeEnchantItem(weapon2, 7, 1);
				pc.getInventory().consumeItem(41246,1000);
				pc.getInventory().consumeItem(49143,10);
				L1ItemInstance item = pc.getInventory().storeItem(newWeapon, 1);
				pc.sendPackets(new S_ServerMessage(143, npcName,
						item.getItem().getName()));
			} else {
				htmlid = "joegolem15";
				if (!pc.getInventory().checkEnchantItem(weapon1, 7, 1)) {
					pc.sendPackets(new S_ServerMessage(337, "+7 "
							+ ItemTable.getInstance().getTemplate(weapon1)
							.getName()));
				}
				if (!pc.getInventory().checkEnchantItem(weapon2, 7, 1)) {
					pc.sendPackets(new S_ServerMessage(337, "+7 "
							+ ItemTable.getInstance().getTemplate(weapon2)
							.getName()));
				}
				if (!pc.getInventory().checkItem(41246, 1000)) {
					int itemCount = 0;
					itemCount = 1000 - pc.getInventory().countItems(41246);
					pc.sendPackets(new S_ServerMessage(337, ItemTable
							.getInstance().getTemplate(41246).getName()
							+ "(" + itemCount + ")" ));
				}
				if (!pc.getInventory().checkItem(49143, 10)) {
					int itemCount = 0;
					itemCount = 10 - pc.getInventory().countItems(49143);
					pc.sendPackets(new S_ServerMessage(337, ItemTable
							.getInstance().getTemplate(49143).getName()
							+ "(" + itemCount + ")" ));
				}
			}
		} else if (npcid == 71253) {
			if (s.equalsIgnoreCase("A")) {
				if (pc.getInventory().checkItem(49101, 100)) {
					materials = new int[] { 49101 };
					counts = new int[] { 100 };
					createitem = new int[] { 49092 };
					createcount = new int[] { 1 };
					htmlid = "joegolem18";
				} else {
					htmlid = "joegolem19";
				}
			} else if (s.equalsIgnoreCase("B")) {
				if (pc.getInventory().checkItem(49101, 1)) {
					pc.getInventory().consumeItem(49101, 1);
					L1Teleport.teleport(pc, 33966, 33253, (short) 4, 5, true);
					htmlid = "";
				} else {
					htmlid = "joegolem20";
				}
			}
		} else if (npcid == 71255) {
			if (s.equalsIgnoreCase("e")) {
				if (pc.getInventory().checkItem(49242, 1)) {
					pc.getInventory().consumeItem(49242, 1);
					L1Teleport.teleport(pc, 32735, 32831, (short) 782, 2, true);
					htmlid = "";
				} else {
					htmlid = "tebegate3";
					// htmlid = "tebegate4";
				}
			}
		} else if (npcid == 71256) {
			if (s.equalsIgnoreCase("E")) {
				if ((pc.getQuest().get_step(L1Quest.QUEST_MOONOFLONGBOW) == 8)
						&& pc.getInventory().checkItem(40491,30)
						&& pc.getInventory().checkItem(40495,40)
						&& pc.getInventory().checkItem(100,1)
						&& pc.getInventory().checkItem(40509,12)
						&& pc.getInventory().checkItem(40052,1)
						&& pc.getInventory().checkItem(40053,1)
						&& pc.getInventory().checkItem(40054,1)
						&& pc.getInventory().checkItem(40055,1)
						&& pc.getInventory().checkItem(41347,1)
						&& pc.getInventory().checkItem(41350,1)) {
					pc.getInventory().consumeItem(40491,30);
					pc.getInventory().consumeItem(40495,40);
					pc.getInventory().consumeItem(100,1);
					pc.getInventory().consumeItem(40509,12);
					pc.getInventory().consumeItem(40052,1);
					pc.getInventory().consumeItem(40053,1);
					pc.getInventory().consumeItem(40054,1);
					pc.getInventory().consumeItem(40055,1);
					pc.getInventory().consumeItem(41347,1);
					pc.getInventory().consumeItem(41350,1);
					htmlid = "robinhood12";
					pc.getInventory().storeItem(205,1);
					pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 0); // makes the quest repeatable
				}
			} else if (s.equalsIgnoreCase("C")) {
				if (pc.getQuest().get_step(L1Quest.QUEST_MOONOFLONGBOW) == 7) {
					if (pc.getInventory().checkItem(41352,4)
							&& pc.getInventory().checkItem(40618,30)
							&& pc.getInventory().checkItem(40643,30)
							&& pc.getInventory().checkItem(40645,30)
							&& pc.getInventory().checkItem(40651,30)
							&& pc.getInventory().checkItem(40676,30)
							&& pc.getInventory().checkItem(40514,20)
							&& pc.getInventory().checkItem(41351,1)
							&& pc.getInventory().checkItem(41346,1)) {
						pc.getInventory().consumeItem(41352,4);
						pc.getInventory().consumeItem(40618,30);
						pc.getInventory().consumeItem(40643,30);
						pc.getInventory().consumeItem(40645,30);
						pc.getInventory().consumeItem(40651,30);
						pc.getInventory().consumeItem(40676,30);
						pc.getInventory().consumeItem(40514,20);
						pc.getInventory().consumeItem(41351,1);
						pc.getInventory().consumeItem(41346,1);
						pc.getInventory().storeItem(41347,1);
						pc.getInventory().storeItem(41350,1);
						htmlid = "robinhood10";
						pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 8);
					}
				}
			} else if (s.equalsIgnoreCase("B")) {
				if (pc.getInventory().checkItem(41348)
						&& pc.getInventory().checkItem(41346)) {
					htmlid = "robinhood13";
				} else {
					pc.getInventory().storeItem(41348,1);
					pc.getInventory().storeItem(41346,1);
					htmlid = "robinhood13";
					pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 2);
				}
			} else if (s.equalsIgnoreCase("A")) {
				if (pc.getInventory().checkItem(40028)) {
					pc.getInventory().consumeItem(40028,1);
					htmlid = "robinhood4";
					pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 1);
				} else {
					htmlid = "robinhood19";
				}
			}
		} else if (npcid == 71257) {
			if (s.equalsIgnoreCase("D")) {
				if (pc.getInventory().checkItem(41349)) {
					htmlid ="zybril10";
					pc.getInventory().storeItem(41351,1);
					pc.getInventory().consumeItem(41349,1);
					pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 7);
				} else {
					htmlid ="zybril14";
				}
			} else if (s.equalsIgnoreCase("C")) {
				if (pc.getInventory().checkItem(40514,10)
						&& pc.getInventory().checkItem(41353)) {
					pc.getInventory().consumeItem(40514,10);
					pc.getInventory().consumeItem(41353,1);
					pc.getInventory().storeItem(41354,1);
					htmlid ="zybril9";
					pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 6);
				}
			} else if (pc.getInventory().checkItem(41353)
					&& pc.getInventory().checkItem(40514,10)) {
				htmlid = "zybril8";
			} else if (s.equalsIgnoreCase("B")) {
				if (pc.getInventory().checkItem(40048,10)
						&& pc.getInventory().checkItem(40049,10)
						&& pc.getInventory().checkItem(40050,10)
						&& pc.getInventory().checkItem(40051,10)) {
					pc.getInventory().consumeItem(40048,10);
					pc.getInventory().consumeItem(40049,10);
					pc.getInventory().consumeItem(40050,10);
					pc.getInventory().consumeItem(40051,10);
					pc.getInventory().storeItem(41353,1);
					htmlid = "zybril15";
					pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 5);
				} else {
					htmlid = "zybril12";
					pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 4);
				}
			} else if (s.equalsIgnoreCase("A")) {
				if (pc.getInventory().checkItem(41348)
						&& pc.getInventory().checkItem(41346)) {
					htmlid = "zybril3";
					pc.getQuest().set_step(L1Quest.QUEST_MOONOFLONGBOW, 3);
				} else {
					htmlid = "zybril11";
				}
			}
		} else if (npcid == 71258) {
			if (pc.getInventory().checkItem(40665)) {
				htmlid = "marba17";
				if (s.equalsIgnoreCase("B")) {
					htmlid = "marba7";
					if (pc.getInventory().checkItem(214)
							&& pc.getInventory().checkItem(20389)
							&& pc.getInventory().checkItem(20393)
							&& pc.getInventory().checkItem(20401)
							&& pc.getInventory().checkItem(20406)
							&& pc.getInventory().checkItem(20409)) {
						htmlid = "marba15";
					}
				}
			} else if (s.equalsIgnoreCase("A")) {
				if (pc.getInventory().checkItem(40637)) {
					htmlid = "marba20";
				} else {
					L1ItemInstance item = pc.getInventory().storeItem(40637, 1);
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
					htmlid = "marba6";
				}
			}
		} else if (npcid == 71259) {
			if (pc.getInventory().checkItem(40665)) {
				htmlid = "aras8";
			} else if (pc.getInventory().checkItem(40637)) {
				htmlid = "aras1";
				if (s.equalsIgnoreCase("A")) {
					if (pc.getInventory().checkItem(40664)) {
						htmlid = "aras6";
						if (pc.getInventory().checkItem(40679)
								|| pc.getInventory().checkItem(40680)
								|| pc.getInventory().checkItem(40681)
								|| pc.getInventory().checkItem(40682)
								|| pc.getInventory().checkItem(40683)
								|| pc.getInventory().checkItem(40684)
								|| pc.getInventory().checkItem(40693)
								|| pc.getInventory().checkItem(40694)
								|| pc.getInventory().checkItem(40695)
								|| pc.getInventory().checkItem(40697)
								|| pc.getInventory().checkItem(40698)
								|| pc.getInventory().checkItem(40699)) {
							htmlid = "aras3";
						} else {
							htmlid = "aras6";
						}
					} else {
						L1ItemInstance item = pc.getInventory().storeItem(40664,
								1);
						String itemName = item.getItem().getName();
						pc.sendPackets(new S_ServerMessage(143, npcName,
								itemName));
						htmlid = "aras6";
					}
				} else if (s.equalsIgnoreCase("B")) {
					if (pc.getInventory().checkItem(40664)) {
						pc.getInventory().consumeItem(40664, 1);
						L1ItemInstance item = pc.getInventory().storeItem(40665,
								1);
						String itemName = item.getItem().getName();
						pc.sendPackets(new S_ServerMessage(143, npcName,
								itemName));
						htmlid = "aras13";
					} else {
						htmlid = "aras14";
						L1ItemInstance item = pc.getInventory().storeItem(40665,
								1);
						String itemName = item.getItem().getName();
						pc.sendPackets(new S_ServerMessage(143, npcName,
								itemName));
					}
				} else {
					if (s.equalsIgnoreCase("7")) {
						if (pc.getInventory().checkItem(40693)
								&& pc.getInventory().checkItem(40694)
								&& pc.getInventory().checkItem(40695)
								&& pc.getInventory().checkItem(40697)
								&& pc.getInventory().checkItem(40698)
								&& pc.getInventory().checkItem(40699)) {
							htmlid = "aras10";
						} else {
							htmlid = "aras9";
						}
					}
				}
			} else {
				htmlid = "aras7";
			}
		} else if (npcid == 80099) {
			if (s.equalsIgnoreCase("A")) {
				if (pc.getInventory().checkItem(40308, 300)) {
					pc.getInventory().consumeItem(40308,300);
					pc.getInventory().storeItem(41315, 1);
					pc.getQuest().set_step(L1Quest
							.QUEST_GENERALHAMELOFRESENTMENT, 1);
					htmlid = "rarson16";
				} else if (!pc.getInventory().checkItem(40308, 300)) {
					htmlid = "rarson7";
				}
			} else if (s.equalsIgnoreCase("B")) {
				if ((pc.getQuest().get_step(L1Quest
						.QUEST_GENERALHAMELOFRESENTMENT) ==1)
						&& (pc.getInventory().checkItem(41325, 1))) {
					pc.getInventory().consumeItem(41325, 1);
					pc.getInventory().storeItem(40308, 2000);
					pc.getInventory().storeItem(41317, 1);
					pc.getQuest().set_step(L1Quest
							.QUEST_GENERALHAMELOFRESENTMENT, 2);
					htmlid = "rarson9";
				} else {
					htmlid = "rarson10";
				}
			} else if (s.equalsIgnoreCase("C")) {
				if ((pc.getQuest().get_step(L1Quest
						.QUEST_GENERALHAMELOFRESENTMENT) ==4)
						&& (pc.getInventory().checkItem(41326, 1))) {
					pc.getInventory().storeItem(40308, 30000);
					pc.getInventory().consumeItem(41326, 1);
					htmlid = "rarson12";
					pc.getQuest().set_step(L1Quest
							.QUEST_GENERALHAMELOFRESENTMENT, 5);
				} else {
					htmlid = "rarson17";
				}
			} else if (s.equalsIgnoreCase("D")) {
				if ((pc.getQuest().get_step(L1Quest
						.QUEST_GENERALHAMELOFRESENTMENT) <=1)
						|| (pc.getQuest().get_step(L1Quest
						.QUEST_GENERALHAMELOFRESENTMENT) ==5)) {
					if (pc.getInventory().checkItem(40308, 300)) {
						pc.getInventory().consumeItem(40308,300);
						pc.getInventory().storeItem(41315, 1);
						pc.getQuest().set_step(L1Quest
								.QUEST_GENERALHAMELOFRESENTMENT, 1);
						htmlid = "rarson16";
					} else if (!pc.getInventory().checkItem(40308, 300)) {
						htmlid = "rarson7";
					}
				} else if ((pc.getQuest().get_step(L1Quest
						.QUEST_GENERALHAMELOFRESENTMENT) >= 2)
						&& (pc.getQuest().get_step(L1Quest
						.QUEST_GENERALHAMELOFRESENTMENT) <= 4)) {
					if (pc.getInventory().checkItem(40308, 300)) {
						pc.getInventory().consumeItem(40308,300);
						pc.getInventory().storeItem(41315, 1);
						htmlid = "rarson16";
					} else if (!pc.getInventory().checkItem(40308, 300)) {
						htmlid = "rarson7";
					}
				}
			}
		} else if (npcid == 80101) {
			if (s.equalsIgnoreCase("request letter of kuen")) {
				if ((pc.getQuest().get_step(L1Quest
						.QUEST_GENERALHAMELOFRESENTMENT) == 2)
						&& (pc.getInventory().checkItem(41317, 1))) {
					pc.getInventory().consumeItem(41317, 1);
					pc.getInventory().storeItem(41318, 1);
					pc.getQuest().set_step(L1Quest
							.QUEST_GENERALHAMELOFRESENTMENT, 3);
					htmlid = "";
				} else {
					htmlid = "";
				}
			} else if (s.equalsIgnoreCase("request holy mithril dust")) {
				if ((pc.getQuest().get_step(L1Quest
						.QUEST_GENERALHAMELOFRESENTMENT) == 3)
						&& (pc.getInventory().checkItem(41315, 1))
						&& pc.getInventory().checkItem(40494, 30)
						&& pc.getInventory().checkItem(41318, 1)) {
					pc.getInventory().consumeItem(41315, 1);
					pc.getInventory().consumeItem(41318, 1);
					pc.getInventory().consumeItem(40494, 30);
					pc.getInventory().storeItem(41316, 1);
					pc.getQuest().set_step(L1Quest
							.QUEST_GENERALHAMELOFRESENTMENT, 4);
					htmlid = "";
				} else {
					htmlid = "";
				}
			}
		} else if (npcid == 80136) {
			int lv15_step = pc.getQuest().get_step(L1Quest.QUEST_LEVEL15);
			int lv30_step = pc.getQuest().get_step(L1Quest.QUEST_LEVEL30);
			int lv45_step = pc.getQuest().get_step(L1Quest.QUEST_LEVEL45);
			int lv50_step = pc.getQuest().get_step(L1Quest.QUEST_LEVEL50);
			if (pc.isDragonKnight()) {
				if (s.equalsIgnoreCase("a") && lv15_step == 0) {
					L1ItemInstance item = pc.getInventory().storeItem(49210, 1);
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
					pc.getQuest().set_step(L1Quest.QUEST_LEVEL15, 1);
					htmlid = "prokel3";
				} else if (s.equalsIgnoreCase("c") && lv30_step == 0) {
					final int[] item_ids = { 49211, 49215, };
					final int[] item_amounts = { 1, 1,};
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143, npcName,
										item.getItem().getName()));
					}
					pc.getQuest().set_step(L1Quest.QUEST_LEVEL30, 1);
					htmlid = "prokel9";
				} else if (s.equalsIgnoreCase("e")) {
					if (pc.getInventory().checkItem(49215, 1)) {
						htmlid = "prokel35";
					} else {
						L1ItemInstance item = pc.getInventory().storeItem(49215, 1);
						String itemName = item.getItem().getName();
						pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
						htmlid = "prokel13";
					}
				} else if (s.equalsIgnoreCase("f") && lv45_step == 0) {
					final int[] item_ids = { 49209, 49212, 49226, };
					final int[] item_amounts = { 1, 1, 1,};
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143, npcName,
										item.getItem().getName()));
					}
					pc.getQuest().set_step(L1Quest.QUEST_LEVEL45, 1);
					htmlid = "prokel16";
				}
			}
		} else if (npcid == 80135) {
			if (pc.isDragonKnight()) {
				if (s.equalsIgnoreCase("a")) {
					if (pc.getInventory().checkItem(49220, 1)) {
						htmlid = "elas5";
					} else {
						L1ItemInstance item = pc.getInventory().storeItem(49220, 1);
						String itemName = item.getItem().getName();
						pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
						htmlid = "elas4";
					}
				}
			}
		} else if (npcid == 81245) {
			if (pc.isDragonKnight()) {
				if(s.equalsIgnoreCase("request flute of spy")) {
					if (pc.getInventory().checkItem(49223, 1)) {
						pc.getInventory().consumeItem(49223, 1);
						L1ItemInstance item = pc.getInventory().storeItem(49222, 1);
						String itemName = item.getItem().getName();
						pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
						htmlid = "";
					} else {
						htmlid = "";
					}
				}
			}
		} else if (npcid == 80145) {
			int lv15_step = pc.getQuest().get_step(L1Quest.QUEST_LEVEL15);
			int lv30_step = pc.getQuest().get_step(L1Quest.QUEST_LEVEL30);
			int lv45_step = pc.getQuest().get_step(L1Quest.QUEST_LEVEL45);
			int lv50_step = pc.getQuest().get_step(L1Quest.QUEST_LEVEL50);
			if (pc.isIllusionist()) {
				if (s.equalsIgnoreCase("a") && lv15_step == 0) {
					final int[] item_ids = { 49172, 49182, };
					final int[] item_amounts = { 1, 1,};
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143, npcName,
										item.getItem().getName()));
					}
					pc.getQuest().set_step(L1Quest.QUEST_LEVEL15, 1);
					htmlid = "silrein3";
				} else if (s.equalsIgnoreCase("c") && lv30_step == 0) {
					final int[] item_ids = { 49173, 49179, };
					final int[] item_amounts = { 1, 1,};
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143, npcName,
										item.getItem().getName()));
					}
					pc.getQuest().set_step(L1Quest.QUEST_LEVEL30, 1);
					htmlid = "silrein12";
				} else if (s.equalsIgnoreCase("e") && lv45_step == 0) {
					final int[] item_ids = { 49174, 49180, };
					final int[] item_amounts = { 1, 1,};
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143, npcName,
										item.getItem().getName()));
					}
					pc.getQuest().set_step(L1Quest.QUEST_LEVEL45, 1);
					htmlid = "silrein19";

				}
			}
			if (pc.isDragonKnight()) {
				if (s.equalsIgnoreCase("l") && lv45_step == 1) {
					if (pc.getInventory().checkItem(49209, 1)) {
						pc.getInventory().consumeItem(49209, 1);
						pc.getQuest().set_step(L1Quest.QUEST_LEVEL45, 2);
						htmlid = "silrein38";
					}
				} else if (s.equalsIgnoreCase("m") && lv45_step == 2) {
					pc.getQuest().set_step(L1Quest.QUEST_LEVEL45, 3);
					htmlid = "silrein39";
				}
			}
		} // Jewel Craftsman David IQ Earring Quest
		else if (npcid == 80192) {
			if (s.equalsIgnoreCase("b")) {// Ice Queen's Earring Lv1
				if (pc.getInventory().checkEquipped(21081)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21081, 1)) { // Earring Lv0
					materials = new int[] { 49031, 21081 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21082 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("c")) {// Ice Queen's Earring Lv2
				if (pc.getInventory().checkEquipped(21082)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21082, 1)) { // Earring Lv1
					materials = new int[] { 49031, 21082 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21083 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("d")) {// Ice Queen's Earring Lv3
				if (pc.getInventory().checkEquipped(21083)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21083, 1)) { // Earring Lv2
					materials = new int[] { 49031, 21083 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21084 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("e")) {// Ice Queen's Earring Lv4
				if (pc.getInventory().checkEquipped(21084)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21084, 1)) { // Earring Lv3
					materials = new int[] { 49031, 21084 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21085 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("f")) {// Ice Queen's Earring  Lv5
				if (pc.getInventory().checkEquipped(21085)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21085, 1)) { // Earring Lv4
					materials = new int[] { 49031, 21085 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21086 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("g")) {// Ice Queen's Earring Lv6
				if (pc.getInventory().checkEquipped(21086)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21086, 1)) { // Earring Lv5
					materials = new int[] { 49031, 21086 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21087 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("h")) {// Ice Queen's Earring Lv 7
				if (pc.getInventory().checkEquipped(21087)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21087, 1)) { // Earring Lv6
					materials = new int[] { 49031, 21087 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21088 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("i")) {// Ice Queen's Earring Lv8 +STR
				if (pc.getInventory().checkEquipped(21088)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21088, 1)) { // Earring Lv7
					materials = new int[] { 49031, 21088 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21089 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("j")) {// Ice Queen's Earring Lv8 +DEX
				if (pc.getInventory().checkEquipped(21088)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21088, 1)) { // Earring Lv7
					materials = new int[] { 49031, 21088 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21090 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else if (s.equalsIgnoreCase("k")) {// Ice Queen's Earring Lv8 +WIS
				if (pc.getInventory().checkEquipped(21088)) {
					htmlid = "8event6";
				} else if (pc.getInventory().checkItem(49031, 1) && // Ice Crystal
						pc.getInventory().checkItem(21088, 1)) { // Earring Lv7
					materials = new int[] { 49031, 21088 };
					counts = new int[] { 1, 1 };
					createitem = new int[] { 21091 };
					createcount = new int[] { 1 };
					htmlid = "8event4";
				}
			} else {
				htmlid = "8event3";
			}
		} else if (npcid == 81246) {
			if (s.equalsIgnoreCase("0")) {
				materials = new int[] { 40308 };
				counts = new int[] { 2500 };
				if (pc.getLevel() < 30) {
					htmlid = "sharna4";
				} else if (pc.getLevel() >= 30 && pc.getLevel() <= 39) {
					createitem = new int[] { 49149 };
					createcount = new int[] { 1 };
				} else if (pc.getLevel() >= 40 && pc.getLevel() <= 51) {
					createitem = new int[] { 49150 };
					createcount = new int[] { 1 };
				} else if (pc.getLevel() >= 52 && pc.getLevel() <= 54) {
					createitem = new int[] { 49151 };
					createcount = new int[] { 1 };
				} else if (pc.getLevel() >= 55 && pc.getLevel() <= 59) {
					createitem = new int[] { 49152 };
					createcount = new int[] { 1 };
				} else if (pc.getLevel() >= 60 && pc.getLevel() <= 64) {
					createitem = new int[] { 49153 };
					createcount = new int[] { 1 };
				} else if (pc.getLevel() >= 65 && pc.getLevel() <= 69) {
					createitem = new int[] { 49154 };
					createcount = new int[] { 1 };
				} else if (pc.getLevel() >= 70) {
					createitem = new int[] { 49155 };
					createcount = new int[] { 1 };
				}
				success_htmlid = "sharna3";
				failure_htmlid = "sharna5";
			}
		}

		// else System.out.println("C_NpcAction: " + s);
		if (htmlid != null && htmlid.equalsIgnoreCase("colos2")) {
			htmldata = makeUbInfoStrings(npcid);
		}
		if (createitem != null) {
			boolean isCreate = true;
			for (int j = 0; j < materials.length; j++) {
				if (!pc.getInventory().checkItemNotEquipped(materials[j],
						counts[j])) {
					L1Item temp = ItemTable.getInstance().getTemplate(
							materials[j]);
					pc.sendPackets(new S_ServerMessage(337, temp.getName()));
					isCreate = false;
				}
			}

			if (isCreate) {
				// 
				int create_count = 0; 
				int create_weight = 0;
				for (int k = 0; k < createitem.length; k++) {
					L1Item temp = ItemTable.getInstance().getTemplate(
							createitem[k]);
					if (temp.isStackable()) {
						if (!pc.getInventory().checkItem(createitem[k])) {
							create_count += 1;
						}
					} else {
						create_count += createcount[k];
					}
					create_weight += temp.getWeight() * createcount[k] / 1000;
				}
				if (pc.getInventory().getSize() + create_count > 180) {
					pc.sendPackets(new S_ServerMessage(263)); 
					return;
				}
				if (pc.getMaxWeight() < pc.getInventory().getWeight()
						+ create_weight) {
					pc.sendPackets(new S_ServerMessage(82)); 
					return;
				}
				for (int j = 0; j < materials.length; j++) {
					pc.getInventory().consumeItem(materials[j], counts[j]);
				}
				for (int k = 0; k < createitem.length; k++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							createitem[k], createcount[k]);
					if (item != null) {
						String itemName = ItemTable.getInstance().getTemplate(
								createitem[k]).getName();
						String createrName = "";
						if (obj instanceof L1NpcInstance) {
							createrName = npcName;
						}
						if (createcount[k] > 1) {
							pc.sendPackets(new S_ServerMessage(143,
									createrName, itemName + " ("
											+ createcount[k] + ")")); 
						} else {
							pc.sendPackets(new S_ServerMessage(143,
									createrName, itemName)); 
						}
					}
				}
				if (success_htmlid != null) { 
					pc.sendPackets(new S_NPCTalkReturn(objid, success_htmlid,
							htmldata));
				}
			} else {
				if (failure_htmlid != null) { 
					pc.sendPackets(new S_NPCTalkReturn(objid, failure_htmlid,
							htmldata));
				}
			}
		}

		if (htmlid != null) { 
			pc.sendPackets(new S_NPCTalkReturn(objid, htmlid, htmldata));
		}
	}

	private String karmaLevelToHtmlId(int level) {
		if (level == 0 || level < -7 || 7 < level) {
			return "";
		}
		String htmlid = "";
		if (0 < level) {
			htmlid = "vbk" + level;
		} else if (level < 0) {
			htmlid = "vyk" + Math.abs(level);
		}
		return htmlid;
	}

	private String watchUb(L1PcInstance pc, int npcId) {
		L1UltimateBattle ub = UBTable.getInstance().getUbForNpcId(npcId);
		L1Location loc = ub.getLocation();
		if (pc.getInventory().consumeItem(L1ItemId.ADENA, 100)) {
			try {
				pc.save();
				pc.beginGhost(loc.getX(), loc.getY(), (short) loc.getMapId(), true);
				pc.isInvisble();
				pc.isGhost();
			} catch (Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		} else {
			pc.sendPackets(new S_ServerMessage(189)); 
		}
		return "";
	}

	private String enterUb(L1PcInstance pc, int npcId) {
		L1UltimateBattle ub = UBTable.getInstance().getUbForNpcId(npcId);
		if (!ub.isActive() || !ub.canPcEnter(pc)) {
			return "colos2";
		}
		if (ub.isNowUb()) { 
			return "colos1";
		}
		if (ub.getMembersCount() >= ub.getMaxPlayer()) { 
			return "colos4";
		}

		ub.addMember(pc); 
		L1Location loc = ub.getLocation().randomLocation(10, false);
		L1Teleport.teleport(pc, loc.getX(), loc.getY(), ub.getMapId(), 5, true);
		return "";
	}

	private String enterHauntedHouse(L1PcInstance pc) {
		if (L1HauntedHouse.getInstance().getHauntedHouseStatus() == L1HauntedHouse.STATUS_PLAYING) { // 
			pc.sendPackets(new S_ServerMessage(1182)); 
			return "";
		}
		if (L1HauntedHouse.getInstance().getMembersCount() >= 10) { 
			pc.sendPackets(new S_ServerMessage(1184)); 
			return "";
		}

		L1HauntedHouse.getInstance().addMember(pc); 
		L1Teleport.teleport(pc, 32722, 32830, (short) 5140, 2, true);
		return "";
	}

	private String enterPetMatch(L1PcInstance pc, int objid2) {
		Object[] petlist = pc.getPetList().values().toArray();
		if (petlist.length > 0) {
			pc.sendPackets(new S_ServerMessage(1187)); //
			return "";
		}
		if (!L1PetMatch.getInstance().enterPetMatch(pc, objid2)) {
			pc.sendPackets(new S_ServerMessage(1182)); //
		}
		return "";
	}

	private void summonMonster(L1PcInstance pc, String s) {
		String[] summonstr_list;
		int[] summonid_list;
		int[] summonlvl_list;
		int[] summoncha_list;
		int summonid = 0;
		int levelrange = 0;
		int summoncost = 0;
		/*
		 * summonstr_list = new String[] { "7", "263", "8", "264", "9", "265",
		 * "10", "266", "11", "267", "12", "268", "13", "269", "14", "270",
		 * "526", "15", "271", "527", "17", "18" }; summonid_list = new int[] {
		 * 81083, 81090, 81084, 81091, 81085, 81092, 81086, 81093, 81087, 81094,
		 * 81088, 81095, 81089, 81096, 81097, 81098, 81099, 81100, 81101, 81102,
		 * 81103, 81104 }; summonlvl_list = new int[] { 28, 28, 32, 32, 36, 36,
		 * 40, 40, 44, 44, 48, 48, 52, 52, 56, 56, 56, 60, 60, 60, 68, 72 };
		 * summoncha_list = new int[] { 6,
		 * 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8, 8, 8, 8, 10, 10, 10, 36, 40 };
		 */
		summonstr_list = new String[] { "7", "263", "519", "8", "264", "520",
				"9", "265", "521", "10", "266", "522", "11", "267", "523",
				"12", "268", "524", "13", "269", "525", "14", "270", "526",
				"15", "271", "527", "16", "17", "18", "274" };
		summonid_list = new int[] { 81210, 81211, 81212, 81213, 81214, 81215,
				81216, 81217, 81218, 81219, 81220, 81221, 81222, 81223, 81224,
				81225, 81226, 81227, 81228, 81229, 81230, 81231, 81232, 81233,
				81234, 81235, 81236, 81237, 81238, 81239, 81240 };
		summonlvl_list = new int[] { 28, 28, 28, 32, 32, 32, 36, 36, 36, 40,
				40, 40, 44, 44, 44, 48, 48, 48, 52, 52, 52, 56, 56, 56, 60, 60,
				60, 64, 68, 72, 72 };
		// summoncha_list = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
		// 8, 8, 8, 8, 8, 8, 8, 10, 10, 10, 12, 12, 12, 20, 42, 42, 50 };
		summoncha_list = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, // 28 ~ 44
				8, 8, 8, 8, 8, 8, 10, 10, 10, 12, 12, 12, // 48 ~ 60
				20, 36, 36, 44 }; // 64,68,72,72
		for (int loop = 0; loop < summonstr_list.length; loop++) {
			if (s.equalsIgnoreCase(summonstr_list[loop])) {
				summonid = summonid_list[loop];
				levelrange = summonlvl_list[loop];
				summoncost = summoncha_list[loop];
				break;
			}
		}
		
		if (pc.getLevel() < levelrange) {
			pc.sendPackets(new S_ServerMessage(743));
			return;
		}

		int petcost = 0;
		Object[] petlist = pc.getPetList().values().toArray();
		for (Object pet : petlist) {
			petcost += ((L1NpcInstance) pet).getPetcost();
		}

		/*
		 * if ((summonid == 81103 || summonid ==
		 * 81104) && petcost != 0) { pc.sendPackets(new S_CloseList(pc.getId()));
		 * return; } int charisma = pc.getCha() + 6 - petcost; int summoncount =
		 * charisma / summoncost;
		 */
		int pcCha = pc.getCha();
		int charisma = 0;
		int summoncount = 0;
		if (levelrange <= 56 // max count = 5
				|| levelrange == 64) { // max count = 2
			if (pcCha > 34) {
				pcCha = 34;
			}
		} else if (levelrange == 60) {
			if (pcCha > 30) { // max count = 3
				pcCha = 30;
			}
		} else if (levelrange > 64) {
			if (pcCha > 44) { // max count = 1
				pcCha = 44;
			}
		}
		charisma = pcCha + 6 - petcost;
		summoncount = charisma / summoncost;

		L1Npc npcTemp = NpcTable.getInstance().getTemplate(summonid);
		for (int cnt = 0; cnt < summoncount; cnt++) {
			L1SummonInstance summon = new L1SummonInstance(npcTemp, pc);
			// if (summonid == 81103 || summonid == 81104) {
			// summon.setPetcost(pc.getCha() + 7);
			// } else {
			summon.setPetcost(summoncost);
			// }
		}
		pc.sendPackets(new S_CloseList(pc.getId()));
	}

	private void poly(ClientThread clientthread, int polyId) {
		L1PcInstance pc = clientthread.getActiveChar();
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS
				|| awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384));
			return;
		}

		if (pc.getInventory().checkItem(L1ItemId.ADENA, 100)) { 
			pc.getInventory().consumeItem(L1ItemId.ADENA, 100); 

			L1PolyMorph.doPoly(pc, polyId, 1800, L1PolyMorph.MORPH_BY_NPC);
		} else {
			pc.sendPackets(new S_ServerMessage(337, "$4")); // 
		}
	}

	private void polyByKeplisha(ClientThread clientthread, int polyId) {
		L1PcInstance pc = clientthread.getActiveChar();
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS
				|| awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384));
			return;
		}

		if (pc.getInventory().checkItem(L1ItemId.ADENA, 100)) { // check
			pc.getInventory().consumeItem(L1ItemId.ADENA, 100); // del

			L1PolyMorph.doPoly(pc, polyId, 1800, L1PolyMorph.MORPH_BY_KEPLISHA);
		} else {
			pc.sendPackets(new S_ServerMessage(337, "$4")); 
		}
	}

	private String sellHouse(L1PcInstance pc, int objectId, int npcId) {
		L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
		if (clan == null) {
			return ""; 
		}
		int houseId = clan.getHouseId();
		if (houseId == 0) {
			return ""; 
		}
		L1House house = HouseTable.getInstance().getHouseTable(houseId);
		int keeperId = house.getKeeperId();
		if (npcId != keeperId) {
			return "";
		}
		if (!pc.isCrown()) {
			pc.sendPackets(new S_ServerMessage(518)); 
			return ""; 
		}
		if (pc.getId() != clan.getLeaderId()) {
			pc.sendPackets(new S_ServerMessage(518));
			return ""; 
		}
		if (house.isOnSale()) {
			return "agonsale";
		}

		pc.sendPackets(new S_SellHouse(objectId, String.valueOf(houseId)));
		return null;
	}

	private void openCloseDoor(L1PcInstance pc, L1NpcInstance npc, String s) {
		@SuppressWarnings("unused")
		int doorId = 0;
		L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
		int npcid = npc.getNpcTemplate().get_npcId();
		if (clan != null) {
			int houseId = clan.getHouseId();
			if (houseId != 0) {
				L1House house = HouseTable.getInstance().getHouseTable(houseId);
				int keeperId = house.getKeeperId();
				if (npcid == keeperId) {
					L1DoorInstance door1 = null;
					L1DoorInstance door2 = null;
					L1DoorInstance door3 = null;
					L1DoorInstance door4 = null;
					for (L1DoorInstance door : DoorTable.getInstance()
							.getDoorList()) {
						if (door.getKeeperId() == keeperId) {
							if (door1 == null) {
								door1 = door;
								continue;
							}
							if (door2 == null) {
								door2 = door;
								continue;
							}
							if (door3 == null) {
								door3 = door;
								continue;
							}
							if (door4 == null) {
								door4 = door;
								break;
							}
						}
					}
					if (door1 != null) {
						if (s.equalsIgnoreCase("open")) {
							door1.open();
						} else if (s.equalsIgnoreCase("close")) {
							door1.close();
						}
					}
					if (door2 != null) {
						if (s.equalsIgnoreCase("open")) {
							door2.open();
						} else if (s.equalsIgnoreCase("close")) {
							door2.close();
						}
					}
					if (door3 != null) {
						if (s.equalsIgnoreCase("open")) {
							door3.open();
						} else if (s.equalsIgnoreCase("close")) {
							door3.close();
						}
					}
					if (door4 != null) {
						if (s.equalsIgnoreCase("open")) {
							door4.open();
						} else if (s.equalsIgnoreCase("close")) {
							door4.close();
						}
					}
				}
			}
		}
	}

	private void openCloseGate(L1PcInstance pc, int keeperId, boolean isOpen) {
		boolean isNowWar = false;
		int pcCastleId = 0;
		if (pc.getClanid() != 0) {
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				pcCastleId = clan.getCastleId();
			}
		}
		if (keeperId == 70656 || keeperId == 70549 || keeperId == 70985) {
			if (isExistDefenseClan(L1CastleLocation.KENT_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.KENT_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.KENT_CASTLE_ID);
		} else if (keeperId == 70600) { // OT
			if (isExistDefenseClan(L1CastleLocation.OT_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.OT_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.OT_CASTLE_ID);
		} else if (keeperId == 70778 || keeperId == 70987 || keeperId == 70687) {
			if (isExistDefenseClan(L1CastleLocation.WW_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.WW_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.WW_CASTLE_ID);
		} else if (keeperId == 70817 || keeperId == 70800 || keeperId == 70988
				|| keeperId == 70990 || keeperId == 70989 || keeperId == 70991) {
			if (isExistDefenseClan(L1CastleLocation.GIRAN_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.GIRAN_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.GIRAN_CASTLE_ID);
		} else if (keeperId == 70863 || keeperId == 70992 || keeperId == 70862) {
			if (isExistDefenseClan(L1CastleLocation.HEINE_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.HEINE_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.HEINE_CASTLE_ID);
		} else if (keeperId == 70995 || keeperId == 70994 || keeperId == 70993) {
			if (isExistDefenseClan(L1CastleLocation.DOWA_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.DOWA_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.DOWA_CASTLE_ID);
		} else if (keeperId == 70996) { 
			if (isExistDefenseClan(L1CastleLocation.ADEN_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.ADEN_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.ADEN_CASTLE_ID);
		}

		for (L1DoorInstance door : DoorTable.getInstance().getDoorList()) {
			if (door.getKeeperId() == keeperId) {
				if (isNowWar && door.getMaxHp() > 1) {
				} else {
					if (isOpen) {
						door.open();
					} else {
						door.close();
					}
				}
			}
		}
	}

	private boolean isExistDefenseClan(int castleId) {
		boolean isExistDefenseClan = false;
		for (L1Clan clan : L1World.getInstance().getAllClans()) {
			if (castleId == clan.getCastleId()) {
				isExistDefenseClan = true;
				break;
			}
		}
		return isExistDefenseClan;
	}

	private String getDefenseClanName(int castleId) {
        String DefenseClan = "";
        for (L1Clan clan : L1World.getInstance().getAllClans()) {
                if (castleId == clan.getCastleId()) {
                        DefenseClan = clan.getClanName();
                        break;
                }
        }
        return DefenseClan;
    }

	private void expelOtherClan(L1PcInstance clanPc, int keeperId) {
		int houseId = 0;
		for (L1House house : HouseTable.getInstance().getHouseTableList()) {
			if (house.getKeeperId() == keeperId) {
				houseId = house.getHouseId();
			}
		}
		if (houseId == 0) {
			return;
		}

		int[] loc = new int[3];
		for (L1Object object : L1World.getInstance().getObject()) {
			if (object instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) object;
				if (L1HouseLocation.isInHouseLoc(houseId, pc.getX(), pc.getY(),
						pc.getMapId())
						&& clanPc.getClanid() != pc.getClanid()) {
					loc = L1HouseLocation.getHouseTeleportLoc(houseId, 0);
					if (pc != null) {
						L1Teleport.teleport(pc, loc[0], loc[1], (short) loc[2],
								5, true);
					}
				}
			}
		}
	}

	private void repairGate(L1PcInstance pc) {
		L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
		if (clan != null) {
			int castleId = clan.getCastleId();
			if (castleId != 0) {
				if (!WarTimeController.getInstance().isNowWar(castleId)) {
					for (L1DoorInstance door : DoorTable.getInstance()
							.getDoorList()) {
						if (L1CastleLocation.checkInWarArea(castleId, door)) {
							door.repairGate();
						}
					}
					pc.sendPackets(new S_ServerMessage(990));
				} else {
					pc.sendPackets(new S_ServerMessage(991));
				}
			}
		}
	}

	private void payFee(L1PcInstance pc, L1NpcInstance npc) {
		L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
		int npcid = npc.getNpcTemplate().get_npcId();
		if (clan != null) {
			int houseId = clan.getHouseId();
			if (houseId != 0) {
				L1House house = HouseTable.getInstance().getHouseTable(houseId);
				int keeperId = house.getKeeperId();
				if (npcid == keeperId) {
					if (pc.getInventory().checkItem(L1ItemId.ADENA, 2000)) {
						pc.getInventory().consumeItem(L1ItemId.ADENA, 2000);
						TimeZone tz = TimeZone.getTimeZone(Config.TIME_ZONE);
						Calendar cal = Calendar.getInstance(tz);
						cal.add(Calendar.DATE, Config.HOUSE_TAX_INTERVAL);
						cal.set(Calendar.MINUTE, 0);
						cal.set(Calendar.SECOND, 0);
						house.setTaxDeadline(cal);
						HouseTable.getInstance().updateHouse(house); 
					} else {
						pc.sendPackets(new S_ServerMessage(189));
					}
				}
			}
		}
	}

	private String[] makeHouseTaxStrings(L1PcInstance pc, L1NpcInstance npc) {
		String name = npc.getNpcTemplate().get_name();
		String[] result;
		result = new String[] { name, "2000", "1", "1", "00" };
		L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
		int npcid = npc.getNpcTemplate().get_npcId();
		if (clan != null) {
			int houseId = clan.getHouseId();
			if (houseId != 0) {
				L1House house = HouseTable.getInstance().getHouseTable(houseId);
				int keeperId = house.getKeeperId();
				if (npcid == keeperId) {
					Calendar cal = house.getTaxDeadline();
					int month = cal.get(Calendar.MONTH) + 1;
					int day = cal.get(Calendar.DATE);
					int hour = cal.get(Calendar.HOUR_OF_DAY);
					result = new String[] { name, "2000",
							String.valueOf(month), String.valueOf(day),
							String.valueOf(hour) };
				}
			}
		}
		return result;
	}

	private String[] makeWarTimeStrings(int castleId) {
		L1Castle castle = CastleTable.getInstance().getCastleTable(castleId);
		if (castle == null) {
			return null;
		}
		Calendar warTime = castle.getWarTime();
		int year = warTime.get(Calendar.YEAR);
		int month = warTime.get(Calendar.MONTH) + 1;
		int day = warTime.get(Calendar.DATE);
		int hour = warTime.get(Calendar.HOUR_OF_DAY);
		int minute = warTime.get(Calendar.MINUTE);
		String[] result;
		if (castleId == L1CastleLocation.OT_CASTLE_ID) {
			result = new String[] { String.valueOf(year),
					String.valueOf(month), String.valueOf(day),
					String.valueOf(hour), String.valueOf(minute) };
		} else {
			result = new String[] { "", String.valueOf(year),
					String.valueOf(month), String.valueOf(day),
					String.valueOf(hour), String.valueOf(minute) };
		}
		return result;
	}

	private String getYaheeAmulet(L1PcInstance pc, L1NpcInstance npc, String s) {
		int[] amuletIdList = { 20358, 20359, 20360, 20361, 20362, 20363, 20364,
				20365 };
		int amuletId = 0;
		L1ItemInstance item = null;
		String htmlid = null;
		if (s.equalsIgnoreCase("1")) {
			amuletId = amuletIdList[0];
		} else if (s.equalsIgnoreCase("2")) {
			amuletId = amuletIdList[1];
		} else if (s.equalsIgnoreCase("3")) {
			amuletId = amuletIdList[2];
		} else if (s.equalsIgnoreCase("4")) {
			amuletId = amuletIdList[3];
		} else if (s.equalsIgnoreCase("5")) {
			amuletId = amuletIdList[4];
		} else if (s.equalsIgnoreCase("6")) {
			amuletId = amuletIdList[5];
		} else if (s.equalsIgnoreCase("7")) {
			amuletId = amuletIdList[6];
		} else if (s.equalsIgnoreCase("8")) {
			amuletId = amuletIdList[7];
		}
		if (amuletId != 0) {
			item = pc.getInventory().storeItem(amuletId, 1);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			for (int id : amuletIdList) {
				if (id == amuletId) {
					break;
				}
				if (pc.getInventory().checkItem(id)) {
					pc.getInventory().consumeItem(id, 1);
				}
			}
			htmlid = "";
		}
		return htmlid;
	}

	private String getBarlogEarring(L1PcInstance pc, L1NpcInstance npc, String s) {
		int[] earringIdList = { 21020, 21021, 21022, 21023, 21024, 21025,
				21026, 21027 };
		int earringId = 0;
		L1ItemInstance item = null;
		String htmlid = null;
		if (s.equalsIgnoreCase("1")) {
			earringId = earringIdList[0];
		} else if (s.equalsIgnoreCase("2")) {
			earringId = earringIdList[1];
		} else if (s.equalsIgnoreCase("3")) {
			earringId = earringIdList[2];
		} else if (s.equalsIgnoreCase("4")) {
			earringId = earringIdList[3];
		} else if (s.equalsIgnoreCase("5")) {
			earringId = earringIdList[4];
		} else if (s.equalsIgnoreCase("6")) {
			earringId = earringIdList[5];
		} else if (s.equalsIgnoreCase("7")) {
			earringId = earringIdList[6];
		} else if (s.equalsIgnoreCase("8")) {
			earringId = earringIdList[7];
		}
		if (earringId != 0) {
			item = pc.getInventory().storeItem(earringId, 1);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName()));
			}
			for (int id : earringIdList) {
				if (id == earringId) {
					break;
				}
				if (pc.getInventory().checkItem(id)) {
					pc.getInventory().consumeItem(id, 1);
				}
			}
			htmlid = "";
		}
		return htmlid;
	}

	private String[] makeUbInfoStrings(int npcId) {
		L1UltimateBattle ub = UBTable.getInstance().getUbForNpcId(npcId);
		return ub.makeUbInfoStrings();
	}

	private String talkToDimensionDoor(L1PcInstance pc, L1NpcInstance npc,
			String s) {
		String htmlid = "";
		int protectionId = 0;
		int sealId = 0;
		int locX = 0;
		int locY = 0;
		short mapId = 0;
		int npcid = npc.getNpcTemplate().get_npcId();
		if (npcid == 80059) { 
			protectionId = 40909;
			sealId = 40913;
			locX = 32773;
			locY = 32835;
			mapId = 607;
		} else if (npcid == 80060) { 
			protectionId = 40912;
			sealId = 40916;
			locX = 32757;
			locY = 32842;
			mapId = 606;
		} else if (npcid == 80061) {
			protectionId = 40910;
			sealId = 40914;
			locX = 32830;
			locY = 32822;
			mapId = 604;
		} else if (npcid == 80062) {
			protectionId = 40911;
			sealId = 40915;
			locX = 32835;
			locY = 32822;
			mapId = 605;
		}

		if (s.equalsIgnoreCase("a")) {
			L1Teleport.teleport(pc, locX, locY, mapId, 5, true);
			htmlid = "";
		} else if (s.equalsIgnoreCase("b")) {
			L1ItemInstance item = pc.getInventory().storeItem(protectionId, 1);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			htmlid = "";
		} else if (s.equalsIgnoreCase("c")) {
			htmlid = "wpass07";
		} else if (s.equalsIgnoreCase("d")) {
			if (pc.getInventory().checkItem(sealId)) {
				L1ItemInstance item = pc.getInventory().findItemId(sealId);
				pc.getInventory().consumeItem(sealId, item.getCount());
			}
		} else if (s.equalsIgnoreCase("e")) {
			htmlid = "";
		} else if (s.equalsIgnoreCase("f")) {
			if (pc.getInventory().checkItem(protectionId)) { 
				pc.getInventory().consumeItem(protectionId, 1);
			}
			if (pc.getInventory().checkItem(sealId)) {
				L1ItemInstance item = pc.getInventory().findItemId(sealId);
				pc.getInventory().consumeItem(sealId, item.getCount());
			}
			htmlid = "";
		}
		return htmlid;
	}

	private boolean isNpcSellOnly(L1NpcInstance npc) {
		int npcId = npc.getNpcTemplate().get_npcId();
		String npcName = npc.getNpcTemplate().get_name();
		if (npcId == 70027 
				|| "[aden] trade group".equals(npcName)) {
			return true;
		}
		return false;
	}

	private void getBloodCrystalByKarma(L1PcInstance pc, L1NpcInstance npc,
			String s) {
		L1ItemInstance item = null;

		if (s.equalsIgnoreCase("1")) {
			pc.addKarma((int) (500 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40718, 1);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			pc.sendPackets(new S_ServerMessage(1081));
		} else if (s.equalsIgnoreCase("2")) {
			pc.addKarma((int) (5000 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40718, 10);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			pc.sendPackets(new S_ServerMessage(1081));
		} else if (s.equalsIgnoreCase("3")) {
			pc.addKarma((int) (50000 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40718, 100);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName()));
			}
			pc.sendPackets(new S_ServerMessage(1081));
		}
	}

	private void getSoulCrystalByKarma(L1PcInstance pc, L1NpcInstance npc,
			String s) {
		L1ItemInstance item = null;

		if (s.equalsIgnoreCase("1")) {
			pc.addKarma((int) (-500 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40678, 1);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			pc.sendPackets(new S_ServerMessage(1080));
		} else if (s.equalsIgnoreCase("2")) {
			pc.addKarma((int) (-5000 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40678, 10);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			pc.sendPackets(new S_ServerMessage(1080));
		} else if (s.equalsIgnoreCase("3")) {
			pc.addKarma((int) (-50000 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40678, 100);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName()));
			}
			pc.sendPackets(new S_ServerMessage(1080));
		}
	}

	private boolean usePolyScroll(L1PcInstance pc, int itemId, String s) {
		int time = 0;
		if (itemId == 40088 || itemId == 40096) {
			time = 1800;
		} else if (itemId == 140088) {
			time = 2100;
		}

		L1PolyMorph poly = PolyTable.getInstance().getTemplate(s);
		L1ItemInstance item = pc.getInventory().findItemId(itemId);
		boolean isUseItem = false;
		if (poly != null || s.equals("none")) {
			if (s.equals("none")) {
				if (pc.getTempCharGfx() == 6034
						|| pc.getTempCharGfx() == 6035) {
					isUseItem = true;
				} else {
					pc.removeSkillEffect(SHAPE_CHANGE);
					isUseItem = true;
				}
			} else if (poly.getMinLevel() <= pc.getLevel() || pc.isGm()) {
				L1PolyMorph.doPoly(pc, poly.getPolyId(), time,
				L1PolyMorph.MORPH_BY_ITEMMAGIC);
				isUseItem = true;
			}
		}
		if (isUseItem) {
			pc.getInventory().removeItem(item, 1);
		} else {
			pc.sendPackets(new S_ServerMessage(181));
		}
		return isUseItem;
	}

	@Override
	public String getType() {
		return C_NPC_ACTION;
	}
}
