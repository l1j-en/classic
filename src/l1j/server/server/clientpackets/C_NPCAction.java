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
import l1j.server.server.ActionCodes;
import l1j.server.server.ClientThread;
import l1j.server.server.WarTimeController;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.DoorSpawnTable;
import l1j.server.server.datatables.HouseTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.NpcActionTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.datatables.TownTable;
import l1j.server.server.datatables.UBTable;
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
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_ApplyAuction;
import l1j.server.server.serverpackets.S_AuctionBoardRead;
import l1j.server.server.serverpackets.S_CloseList;
import l1j.server.server.serverpackets.S_DelSkill;
import l1j.server.server.serverpackets.S_Deposit;
import l1j.server.server.serverpackets.S_Drawal;
import l1j.server.server.serverpackets.S_HouseMap;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
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
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SkillIconBlessOfEva;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_TaxRate;
import l1j.server.server.templates.L1Castle;
import l1j.server.server.templates.L1House;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Skills;
import l1j.server.server.templates.L1Town;
import static l1j.server.server.model.skill.L1SkillId.*;

public class C_NPCAction extends ClientBasePacket {

	private static final String C_NPC_ACTION = "[C] C_NPCAction";
	private static Logger _log = Logger.getLogger(C_NPCAction.class.getName());
	private static Random _random = new Random();

	public C_NPCAction(byte abyte0[], ClientThread client) throws Exception {
		super(abyte0);
		int objid = readD();
		String s = readS();

		String s2 = null;
		if (s.equalsIgnoreCase("select")
				|| s.equalsIgnoreCase("map") 
				|| s.equalsIgnoreCase("apply")) {
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
					summonMonster(target, s);
				} else {
					L1PolyMorph.handleCommands(target, s);
				}
				return;
			}
		} else {
		}
		L1NpcAction action = NpcActionTable.getInstance().get(s, pc, obj);
		if (action != null) {
			L1NpcHtml result = action.execute(s, pc, obj, readByte());
			if (result != null) {
				pc.sendPackets(new S_NPCTalkReturn(obj.getId(), result));
			}
			return;
		}

		if (s.equalsIgnoreCase("buy")) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			if (isNpcSellOnly(npc)) {
				return;
			}
			pc.sendPackets(new S_ShopSellList(objid));
		} else if (s.equalsIgnoreCase("sell")) {
			int npcid = ((L1NpcInstance) obj).getNpcTemplate().get_npcId();
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
		} else if (s.equalsIgnoreCase("retrieve-elven")) { //
			if (pc.getLevel() >= 5 && pc.isElf()) {
				pc.sendPackets(new S_RetrieveElfList(objid, pc));
			}
		} else if (s.equalsIgnoreCase("retrieve-pledge")) { //
			if (pc.getLevel() >= 5) {
				if (pc.getClanid() == 0) {
					//
					pc.sendPackets(new S_ServerMessage(208));
					return;
				}
				int rank = pc.getClanRank();
				// fix for bp store. this only exludes probationary members.
				if (rank == L1Clan.CLAN_RANK_PROBATION) {
					//
					pc.sendPackets(new S_ServerMessage(728));
					return;
				}
				pc.sendPackets(new S_RetrievePledgeList(objid, pc));
			}
		} else if (s.equalsIgnoreCase("get")) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			int npcId = npc.getNpcTemplate().get_npcId();
			if (npcId == 70099 || npcId == 70796) {
				L1ItemInstance item = pc.getInventory().storeItem(20081, 1); 
				String npcName = npc.getNpcTemplate().get_name();
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				pc.getQuest().set_end(L1Quest.QUEST_OILSKINMANT);
				htmlid = ""; 
			}
			else if (npcId == 70528 || npcId == 70546 || npcId == 70567
					|| npcId == 70594 || npcId == 70654 || npcId == 70748
					|| npcId == 70774 || npcId == 70799 || npcId == 70815
					|| npcId == 70860) {

				if (pc.getHomeTownId() > 0) {

				} else {

				}
			}
		} else if (s.equalsIgnoreCase("fix")) { 

		} else if (s.equalsIgnoreCase("room")) { 

		} else if (s.equalsIgnoreCase("hall")
				&& obj instanceof L1MerchantInstance) { 

		} else if (s.equalsIgnoreCase("return")) { 

		} else if (s.equalsIgnoreCase("enter")) { 

		} else if (s.equalsIgnoreCase("openigate")) { 
			L1NpcInstance npc = (L1NpcInstance) obj;
			openCloseGate(pc, npc.getNpcTemplate().get_npcId(), true);
			htmlid = "";
		} else if (s.equalsIgnoreCase("closeigate")) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			openCloseGate(pc, npc.getNpcTemplate().get_npcId(), false);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("askwartime")) { 
			L1NpcInstance npc = (L1NpcInstance) obj;
			if (npc.getNpcTemplate().get_npcId() == 60514) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.KENT_CASTLE_ID);
				htmlid = "ktguard7";
			} else if (npc.getNpcTemplate().get_npcId() == 60560) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.OT_CASTLE_ID);
				htmlid = "orcguard7";
			} else if (npc.getNpcTemplate().get_npcId() == 60552) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.WW_CASTLE_ID);
				htmlid = "wdguard7";
			} else if (npc.getNpcTemplate().get_npcId() == 60524 || 
					npc.getNpcTemplate().get_npcId() == 60525 || 
					npc.getNpcTemplate().get_npcId() == 60529) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.GIRAN_CASTLE_ID);
				htmlid = "grguard7";
			} else if (npc.getNpcTemplate().get_npcId() == 70857) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.HEINE_CASTLE_ID);
				htmlid = "heguard7";
			} else if (npc.getNpcTemplate().get_npcId() == 60530 ||
					npc.getNpcTemplate().get_npcId() == 60531) {
				htmldata = makeWarTimeStrings(L1CastleLocation.DOWA_CASTLE_ID);
				htmlid = "dcguard7";
			} else if (npc.getNpcTemplate().get_npcId() == 60533 ||
					npc.getNpcTemplate().get_npcId() == 60534) {
				htmldata = makeWarTimeStrings(L1CastleLocation.ADEN_CASTLE_ID);
				htmlid = "adguard7";
			} else if (npc.getNpcTemplate().get_npcId() == 81156) { 
				htmldata = makeWarTimeStrings(L1CastleLocation.DIAD_CASTLE_ID);
				htmlid = "dfguard3";
			}
		} else if (s.equalsIgnoreCase("inex")) {
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int castle_id = clan.getCastleId();
				if (castle_id != 0) { 
					L1Castle l1castle = CastleTable.getInstance()
							.getCastleTable(castle_id);
					pc.sendPackets(new S_ServerMessage(309, 
							l1castle.getName(), String.valueOf(l1castle
									.getPublicMoney())));
					htmlid = "";
				}
			}
		} else if (s.equalsIgnoreCase("tax")) { 
			pc.sendPackets(new S_TaxRate(pc.getId()));
		} else if (s.equalsIgnoreCase("withdrawal")) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int castle_id = clan.getCastleId();
				if (castle_id != 0) { 
					L1Castle l1castle = CastleTable.getInstance()
							.getCastleTable(castle_id);
					pc.sendPackets(new S_Drawal(pc.getId(), l1castle
							.getPublicMoney()));
				}
			}
		} else if (s.equalsIgnoreCase("cdeposit")) { 
			pc.sendPackets(new S_Deposit(pc.getId()));
		} else if (s.equalsIgnoreCase("employ")) { 

		} else if (s.equalsIgnoreCase("arrange")) { 

		} else if (s.equalsIgnoreCase("castlegate")) { //

			repairGate(pc);
			htmlid = ""; //
		} else if (s.equalsIgnoreCase("encw")) { //
			if (pc.getWeapon() == null) {
				pc.sendPackets(new S_ServerMessage(79));
			} else {
				for (L1ItemInstance item : pc.getInventory().getItems()) {
					if (pc.getWeapon().equals(item)) {
						L1SkillUse l1skilluse = new L1SkillUse();
						l1skilluse.handleCommands(pc, L1SkillId.ENCHANT_WEAPON,
								item.getId(), 0, 0, null, 0,
								L1SkillUse.TYPE_SPELLSC);
						break;
					}
				}
			}
			htmlid = ""; // 
		} else if (s.equalsIgnoreCase("enca")) { //
			L1ItemInstance item = pc.getInventory().getItemEquipped(2, 2);
			if (item != null) {
				L1SkillUse l1skilluse = new L1SkillUse();
				l1skilluse.handleCommands(pc, L1SkillId.BLESSED_ARMOR, item
						.getId(), 0, 0, null, 0, L1SkillUse.TYPE_SPELLSC);
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
		} else if(s.equalsIgnoreCase("attackchr")) {
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
			L1NpcInstance npc = (L1NpcInstance) obj;
			openCloseDoor(pc, npc, s);
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("expel")) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			expelOtherClan(pc, npc.getNpcTemplate().get_npcId());
			htmlid = ""; 
		} else if (s.equalsIgnoreCase("pay")) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			htmldata = makeHouseTaxStrings(pc, npc);
			htmlid = "agpay";
		} else if (s.equalsIgnoreCase("payfee")) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			payFee(pc, npc);
			htmlid = "";
		} else if (s.equalsIgnoreCase("name")) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int houseId = clan.getHouseId();
				if (houseId != 0) {
					L1House house = HouseTable.getInstance().getHouseTable(
							houseId);
					int keeperId = house.getKeeperId();
					L1NpcInstance npc = (L1NpcInstance) obj;
					if (npc.getNpcTemplate().get_npcId() == keeperId) {
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
					L1House house = HouseTable.getInstance().getHouseTable(
							houseId);
					int keeperId = house.getKeeperId();
					L1NpcInstance npc = (L1NpcInstance) obj;
					if (npc.getNpcTemplate().get_npcId() == keeperId) {
						int[] loc = new int[3];
						if (s.equalsIgnoreCase("tel0")) {
							loc = L1HouseLocation.getHouseTeleportLoc(houseId,
									0);
						} else if (s.equalsIgnoreCase("tel1")) {
							loc = L1HouseLocation.getHouseTeleportLoc(houseId,
									1);
						} else if (s.equalsIgnoreCase("tel2")) {
							loc = L1HouseLocation.getHouseTeleportLoc(houseId,
									2);
						} else if (s.equalsIgnoreCase("tel3")) {
							loc = L1HouseLocation.getHouseTeleportLoc(houseId,
									3);
						}
						L1Teleport.teleport(pc, loc[0], loc[1], (short) loc[2],
								5, true);
					}
				}
			}
			htmlid = "";
		} else if (s.equalsIgnoreCase("upgrade")) {
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int houseId = clan.getHouseId();
				if (houseId != 0) {
					L1House house = HouseTable.getInstance().getHouseTable(
							houseId);
					int keeperId = house.getKeeperId();
					L1NpcInstance npc = (L1NpcInstance) obj;
					if (npc.getNpcTemplate().get_npcId() == keeperId) {
						if (pc.isCrown() && pc.getId() == clan.getLeaderId()) { 
							if (house.isPurchaseBasement()) {
								pc.sendPackets(new S_ServerMessage(1135));
							} else {
								if (pc.getInventory().consumeItem(
										L1ItemId.ADENA, 5000000)) {
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
		} else if (s.equalsIgnoreCase("hall")
				&& obj instanceof L1HousekeeperInstance) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				int houseId = clan.getHouseId();
				if (houseId != 0) {
					L1House house = HouseTable.getInstance().getHouseTable(
							houseId);
					int keeperId = house.getKeeperId();
					L1NpcInstance npc = (L1NpcInstance) obj;
					if (npc.getNpcTemplate().get_npcId() == keeperId) {
						if (house.isPurchaseBasement()) {
							int[] loc = new int[3];
							loc = L1HouseLocation.getBasementLoc(houseId);
							L1Teleport.teleport(pc, loc[0], loc[1],
									(short) (loc[2]), 5, true);
						} else {
							pc.sendPackets(new S_ServerMessage(1098));
						}
					}
				}
			}
			htmlid = ""; 
		}

		// 
		else if (s.equalsIgnoreCase("fire")) 
		{
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
					L1Skills l1skills1 = SkillsTable.getInstance().getTemplate(
							cnt);
					int skill_attr = l1skills1.getAttr();
					if (skill_attr != 0) 
					{
						SkillsTable.getInstance().spellLost(pc.getId(),
								l1skills1.getSkillId());
					}
				}
				if (pc.hasSkillEffect(L1SkillId.ELEMENTAL_PROTECTION)) {
					pc.removeSkillEffect(L1SkillId.ELEMENTAL_PROTECTION);
				}
				pc.sendPackets(new S_DelSkill(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 248, 252, 252, 255, 0, 0));
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
					pc.sendPackets(new S_ServerMessage(561, String.valueOf(pc
							.get_PKcount()))); 
				} else {
					pc.sendPackets(new S_ServerMessage(189)); 
				}
			}
			htmlid = "";
		} else if (s.equalsIgnoreCase("ent")) {
			int npcId = ((L1NpcInstance) obj).getNpcId();
			if (npcId == 80085 || npcId == 80086 || npcId == 80087) {
				htmlid = enterHauntedHouse(pc);
			} else if (npcId == 80088) {
				htmlid = enterPetMatch(pc, Integer.valueOf(s2));
			} else if (npcId == 50038 || npcId == 50042 || npcId == 50029
					|| npcId == 50019 || npcId == 50062) {
				htmlid = watchUb(pc, npcId);
			} else {
				htmlid = enterUb(pc, npcId);
			}
		} else if (s.equalsIgnoreCase("par")) { 
			htmlid = enterUb(pc, ((L1NpcInstance) obj).getNpcId());
		} else if (s.equalsIgnoreCase("info")) { 
			int npcId = ((L1NpcInstance) obj).getNpcId();
			if (npcId == 80085 || npcId == 80086 || npcId == 80087) {
			} else {
				htmlid = "colos2";
			}
		} else if (s.equalsIgnoreCase("sco")) { 
			htmldata = new String[10];
			htmlid = "colos3";
		}

		else if (s.equalsIgnoreCase("haste")) { 
			L1NpcInstance l1npcinstance = (L1NpcInstance) obj;
			int npcid = l1npcinstance.getNpcTemplate().get_npcId();
			if (npcid == 70514) {
				pc.sendPackets(new S_ServerMessage(183));
				pc.sendPackets(new S_SkillHaste(pc.getId(), 1, 1600));
				pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1, 0));
				pc.sendPackets(new S_SkillSound(pc.getId(), 755));
				pc.broadcastPacket(new S_SkillSound(pc.getId(), 755));
				pc.setMoveSpeed(1);
				pc.setSkillEffect(L1SkillId.STATUS_HASTE, 1600 * 1000);
				htmlid = ""; 
			}
		}
		else if (s.equalsIgnoreCase("skeleton nbmorph")) {
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
		}
		// lekman talking scroll trade 
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() > 50111 && 
				((L1NpcInstance) obj).getNpcTemplate().get_npcId() < 50118) { 
			if (s.equalsIgnoreCase("0"))  { 
				L1NpcInstance npc = (L1NpcInstance) obj; String npcName = npc.getNpcTemplate().get_name(); 
				if (pc.getInventory().checkItem(40641) == true){  
					// it ts, it leather armor, it gloves, it sandal, it ring, it edo, it staff, it spear, it axe, it claw, it bow /*
					/*final int[] item_ids = { 20082, 20126, 20173, 20212, 20282, 73, 105, 120, 147, 156, 174, 40373}; 
					final int[] item_amounts = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};*/
					int[] item_ids = {}; int[] item_amounts = {}; if(pc.isWizard()) { 
						int[] i = {20082, 20126, 20173, 20212, 20282, 120, 40373}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1}; item_ids = i; item_amounts = j; } 
					else if(pc.isDarkelf()) { int[] i = {20082, 20126, 20173, 20212, 20282, 73, 156, 174, 40373}; 
					int[] j = {1, 1, 1, 1, 1, 1, 1, 1, 1}; item_ids = i; item_amounts = j; } 
					else if(pc.isCrown()) { 
						int[] i = {20082, 20126, 20173, 20212, 20282, 147, 40373}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1}; item_ids = i; item_amounts = j; } 
					else if(pc.isKnight()) { 
						int[] i = {20082, 20126, 20173, 20212, 20282, 105, 147, 174, 40373}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1, 1, 1}; item_ids = i; item_amounts = j; } 
					else { //elf 
						int[] i = {20082, 20126, 20173, 20212, 20282, 174, 40373}; 
						int[] j = {1, 1, 1, 1, 1, 1, 1}; item_ids = i; item_amounts = j; }  
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
			} 
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71038) {
			if (s.equalsIgnoreCase("A")) {
				L1NpcInstance npc = (L1NpcInstance) obj;
				L1ItemInstance item = pc.getInventory().storeItem(41060, 1); 
				String npcName = npc.getNpcTemplate().get_name();
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfnoname9";
			}
			else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41060, 1)) {
					htmlid = "orcfnoname11";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71039) {
			if (s.equalsIgnoreCase("teleportURL")) {
				htmlid = "orcfbuwoo2";
			}
		}
		//
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71040) {
			if (s.equalsIgnoreCase("A")) {
				L1NpcInstance npc = (L1NpcInstance) obj;
				L1ItemInstance item = pc.getInventory().storeItem(41065, 1); 
				String npcName = npc.getNpcTemplate().get_name();
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
				htmlid = "orcfnoa4";
			}
			else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41065, 1)) {
					htmlid = "orcfnoa7";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71041) {
			if (s.equalsIgnoreCase("A")) {
				L1NpcInstance npc = (L1NpcInstance) obj;
				L1ItemInstance item = pc.getInventory().storeItem(41064, 1);
				String npcName = npc.getNpcTemplate().get_name();
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfhuwoomo4";
			}
			else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41064, 1)) {
					htmlid = "orcfhuwoomo6";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71042) {
			if (s.equalsIgnoreCase("A")) {
				L1NpcInstance npc = (L1NpcInstance) obj;
				L1ItemInstance item = pc.getInventory().storeItem(41062, 1); 
				String npcName = npc.getNpcTemplate().get_name();
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfbakumo4";
			}
			else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41062, 1)) {
					htmlid = "orcfbakumo6";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71043) {
			if (s.equalsIgnoreCase("A")) {
				L1NpcInstance npc = (L1NpcInstance) obj;
				L1ItemInstance item = pc.getInventory().storeItem(41063, 1);
				String npcName = npc.getNpcTemplate().get_name();
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfbuka4";
			}
			else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41063, 1)) {
					htmlid = "orcfbuka6";
				}
			}
		}
		// 
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71044) {
			if (s.equalsIgnoreCase("A")) {
				L1NpcInstance npc = (L1NpcInstance) obj;
				L1ItemInstance item = pc.getInventory().storeItem(41061, 1); 
				String npcName = npc.getNpcTemplate().get_name();
				String itemName = item.getItem().getName();
				pc.sendPackets(new S_ServerMessage(143, npcName, itemName)); 
				htmlid = "orcfkame4";
			}
			else if (s.equalsIgnoreCase("Z")) {
				if (pc.getInventory().consumeItem(41061, 1)) {
					htmlid = "orcfkame6";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71078) {
			if (s.equalsIgnoreCase("teleportURL")) {
				htmlid = "usender2";
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71080) {
			if (s.equalsIgnoreCase("teleportURL")) {
				htmlid = "amisoo2";
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80048) {
			if (s.equalsIgnoreCase("2")) {
				htmlid = ""; 
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80049) {
			if (s.equalsIgnoreCase("1")) {
				if (pc.getKarma() <= -10000000) {
					pc.setKarma(1000000);
					pc.sendPackets(new S_ServerMessage(1078));
					htmlid = "betray13";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80050) {
			if (s.equalsIgnoreCase("1")) {
				htmlid = "meet105";
			}
			else if (s.equalsIgnoreCase("2")) {
				if (pc.getInventory().checkItem(40718)) { 
					htmlid = "meet106";
				} else {
					htmlid = "meet110";
				}
			}
			else if (s.equalsIgnoreCase("a")) {
				if (pc.getInventory().consumeItem(40718, 1)) {
					pc.addKarma((int) (-100 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1079));
					htmlid = "meet107";
				} else {
					htmlid = "meet104";
				}
			}
			else if (s.equalsIgnoreCase("b")) {
				if (pc.getInventory().consumeItem(40718, 10)) {
					pc.addKarma((int) (-1000 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1079));
					htmlid = "meet108";
				} else {
					htmlid = "meet104";
				}
			}
			else if (s.equalsIgnoreCase("c")) {
				if (pc.getInventory().consumeItem(40718, 100)) {
					pc.addKarma((int) (-10000 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1079));
					htmlid = "meet109";
				} else {
					htmlid = "meet104";
				}
			}
			else if (s.equalsIgnoreCase("d")) {
				if (pc.getInventory().checkItem(40615) 
						|| pc.getInventory().checkItem(40616)) { 
					htmlid = "";
				} else {
					L1Teleport.teleport(pc, 32683, 32895, (short) 608, 5, true);
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80052) {
			// EEE
			if (s.equalsIgnoreCase("a")) {
				if (pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
					pc.sendPackets(new S_ServerMessage(79)); // \f1NB
				} else {
					pc.setSkillEffect(STATUS_CURSE_BARLOG, 1020 * 1000);
					pc.sendPackets(new S_SkillIconBlessOfEva(pc.getId(), 1020));
					pc.sendPackets(new S_SkillSound(pc.getId(), 750));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 750));
					pc.sendPackets(new S_ServerMessage(1127));
				}
			}
		}
		// qb
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80053) {
			int karmaLevel = pc.getKarmaLevel();
			if (s.equalsIgnoreCase("a")) {
				int aliceMaterialId = 0;
				int[] aliceMaterialIdList = { 40991, 196, 197, 198, 199, 200,
						201, 202, 203 };
				for (int id : aliceMaterialIdList) {
					if (pc.getInventory().checkItem(id)) {
						aliceMaterialId = id;
						break;
					}
				}
				if (aliceMaterialId == 0) {
					htmlid = "alice_no";
				} else if (aliceMaterialId == 40991) {
					if (karmaLevel <= -1) {
						materials = new int[] { 40995, 40718, 40991 };
						counts = new int[] { 100, 100, 1 };
						createitem = new int[] { 196 };
						createcount = new int[] { 1 };
						success_htmlid = "alice_1";
						failure_htmlid = "alice_no";
					} else {
						htmlid = "aliceyet";
					}
				} else if (aliceMaterialId == 196) {
					if (karmaLevel <= -2) {
						materials = new int[] { 40997, 40718, 196 };
						counts = new int[] { 100, 100, 1 };
						createitem = new int[] { 197 };
						createcount = new int[] { 1 };
						success_htmlid = "alice_2";
						failure_htmlid = "alice_no";
					} else {
						htmlid = "alice_1";
					}
				} else if (aliceMaterialId == 197) {
					if (karmaLevel <= -3) {
						materials = new int[] { 40990, 40718, 197 };
						counts = new int[] { 100, 100, 1 };
						createitem = new int[] { 198 };
						createcount = new int[] { 1 };
						success_htmlid = "alice_3";
						failure_htmlid = "alice_no";
					} else {
						htmlid = "alice_2";
					}
				} else if (aliceMaterialId == 198) {
					if (karmaLevel <= -4) {
						materials = new int[] { 40994, 40718, 198 };
						counts = new int[] { 50, 100, 1 };
						createitem = new int[] { 199 };
						createcount = new int[] { 1 };
						success_htmlid = "alice_4";
						failure_htmlid = "alice_no";
					} else {
						htmlid = "alice_3";
					}
				} else if (aliceMaterialId == 199) {
					if (karmaLevel <= -5) {
						materials = new int[] { 40993, 40718, 199 };
						counts = new int[] { 50, 100, 1 };
						createitem = new int[] { 200 };
						createcount = new int[] { 1 };
						success_htmlid = "alice_5";
						failure_htmlid = "alice_no";
					} else {
						htmlid = "alice_4";
					}
				} else if (aliceMaterialId == 200) {
					if (karmaLevel <= -6) {
						materials = new int[] { 40998, 40718, 200 };
						counts = new int[] { 50, 100, 1 };
						createitem = new int[] { 201 };
						createcount = new int[] { 1 };
						success_htmlid = "alice_6";
						failure_htmlid = "alice_no";
					} else {
						htmlid = "alice_5";
					}
				} else if (aliceMaterialId == 201) {
					if (karmaLevel <= -7) {
						materials = new int[] { 40996, 40718, 201 };
						counts = new int[] { 10, 100, 1 };
						createitem = new int[] { 202 };
						createcount = new int[] { 1 };
						success_htmlid = "alice_7";
						failure_htmlid = "alice_no";
					} else {
						htmlid = "alice_6";
					}
				} else if (aliceMaterialId == 202) {
					if (karmaLevel <= -8) {
						materials = new int[] { 40992, 40718, 202 };
						counts = new int[] { 10, 100, 1 };
						createitem = new int[] { 203 };
						createcount = new int[] { 1 };
						success_htmlid = "alice_8";
						failure_htmlid = "alice_no";
					} else {
						htmlid = "alice_7";
					}
				} else if (aliceMaterialId == 203) {
					htmlid = "alice_8";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80055) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			htmlid = getYaheeAmulet(pc, npc, s);
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80056) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			if (pc.getKarma() <= -10000000) {
				getBloodCrystalByKarma(pc, npc, s);
			}
			htmlid = "";
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80063) {
			if (s.equalsIgnoreCase("a")) {
				if (pc.getInventory().checkItem(40921)) { 
					L1Teleport.teleport(pc, 32674, 32832, (short) 603, 2, true);
				} else {
					htmlid = "gpass02";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80064) {
			if (s.equalsIgnoreCase("1")) {
				htmlid = "meet005";
			}
			else if (s.equalsIgnoreCase("2")) {
				if (pc.getInventory().checkItem(40678)) { 
					htmlid = "meet006";
				} else {
					htmlid = "meet010";
				}
			}
			else if (s.equalsIgnoreCase("a")) {
				if (pc.getInventory().consumeItem(40678, 1)) {
					pc.addKarma((int) (100 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1078));
					htmlid = "meet007";
				} else {
					htmlid = "meet004";
				}
			}
			else if (s.equalsIgnoreCase("b")) {
				if (pc.getInventory().consumeItem(40678, 10)) {
					pc.addKarma((int) (1000 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1078));
					htmlid = "meet008";
				} else {
					htmlid = "meet004";
				}
			}
			else if (s.equalsIgnoreCase("c")) {
				if (pc.getInventory().consumeItem(40678, 100)) {
					pc.addKarma((int) (10000 * Config.RATE_KARMA));
					pc.sendPackets(new S_ServerMessage(1078));
					htmlid = "meet009";
				} else {
					htmlid = "meet004";
				}
			}
			else if (s.equalsIgnoreCase("d")) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80066) {
			if (s.equalsIgnoreCase("1")) {
				if (pc.getKarma() >= 10000000) {
					pc.setKarma(-1000000);
					pc.sendPackets(new S_ServerMessage(1079));
					htmlid = "betray03";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80071) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			htmlid = getBarlogEarring(pc, npc, s);
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80073) {
			// EEE
			if (s.equalsIgnoreCase("a")) {
				if (pc.hasSkillEffect(STATUS_CURSE_BARLOG)) {
					pc.sendPackets(new S_ServerMessage(79)); // \f1NB
				} else {
					pc.setSkillEffect(STATUS_CURSE_YAHEE, 1020 * 1000);
					pc.sendPackets(new S_SkillIconBlessOfEva(pc.getId(), 1020));
					pc.sendPackets(new S_SkillSound(pc.getId(), 750));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 750));
					pc.sendPackets(new S_ServerMessage(1127));
				}
			}
		}
		// oOb
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80072) {
			int karmaLevel = pc.getKarmaLevel();
			if (s.equalsIgnoreCase("0")) {
				htmlid = "lsmitha";
			} else if (s.equalsIgnoreCase("1")) {
				htmlid = "lsmithb";
			} else if (s.equalsIgnoreCase("2")) {
				htmlid = "lsmithc";
			} else if (s.equalsIgnoreCase("3")) {
				htmlid = "lsmithd";
			} else if (s.equalsIgnoreCase("4")) {
				htmlid = "lsmithe";
			} else if (s.equalsIgnoreCase("5")) {
				htmlid = "lsmithf";
			} else if (s.equalsIgnoreCase("6")) {
				htmlid = "";
			} else if (s.equalsIgnoreCase("7")) {
				htmlid = "lsmithg";
			} else if (s.equalsIgnoreCase("8")) {
				htmlid = "lsmithh";
			}
			else if (s.equalsIgnoreCase("a") && karmaLevel >= 1) {
				materials = new int[] { 20158, 40669, 40678 };
				counts = new int[] { 1, 50, 100 };
				createitem = new int[] { 20083 };
				createcount = new int[] { 1 };
				success_htmlid = "";
				failure_htmlid = "lsmithaa";
			}
			else if (s.equalsIgnoreCase("b") && karmaLevel >= 2) {
				materials = new int[] { 20144, 40672, 40678 };
				counts = new int[] { 1, 50, 100 };
				createitem = new int[] { 20131 };
				createcount = new int[] { 1 };
				success_htmlid = "";
				failure_htmlid = "lsmithbb";
			}
			else if (s.equalsIgnoreCase("c") && karmaLevel >= 3) {
				materials = new int[] { 20075, 40671, 40678 };
				counts = new int[] { 1, 50, 100 };
				createitem = new int[] { 20069 };
				createcount = new int[] { 1 };
				success_htmlid = "";
				failure_htmlid = "lsmithcc";
			}
			else if (s.equalsIgnoreCase("d") && karmaLevel >= 4) {
				materials = new int[] { 20183, 40674, 40678 };
				counts = new int[] { 1, 20, 100 };
				createitem = new int[] { 20179 };
				createcount = new int[] { 1 };
				success_htmlid = "";
				failure_htmlid = "lsmithdd";
			}
			else if (s.equalsIgnoreCase("e") && karmaLevel >= 5) {
				materials = new int[] { 20190, 40674, 40678 };
				counts = new int[] { 1, 40, 100 };
				createitem = new int[] { 20209 };
				createcount = new int[] { 1 };
				success_htmlid = "";
				failure_htmlid = "lsmithee";
			}
			else if (s.equalsIgnoreCase("f") && karmaLevel >= 6) {
				materials = new int[] { 20078, 40674, 40678 };
				counts = new int[] { 1, 5, 100 };
				createitem = new int[] { 20290 };
				createcount = new int[] { 1 };
				success_htmlid = "";
				failure_htmlid = "lsmithff";
			}
			else if (s.equalsIgnoreCase("g") && karmaLevel >= 7) {
				materials = new int[] { 20078, 40670, 40678 };
				counts = new int[] { 1, 1, 100 };
				createitem = new int[] { 20261 };
				createcount = new int[] { 1 };
				success_htmlid = "";
				failure_htmlid = "lsmithgg";
			}
			else if (s.equalsIgnoreCase("h") && karmaLevel >= 8) {
				materials = new int[] { 40719, 40673, 40678 };
				counts = new int[] { 1, 1, 100 };
				createitem = new int[] { 20031 };
				createcount = new int[] { 1 };
				success_htmlid = "";
				failure_htmlid = "lsmithhh";
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80074) {
			L1NpcInstance npc = (L1NpcInstance) obj;
			if (pc.getKarma() >= 10000000) {
				getSoulCrystalByKarma(pc, npc, s);
			}
			htmlid = "";
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80057) {
			htmlid = karmaLevelToHtmlId(pc.getKarmaLevel());
			htmldata = new String[] { String.valueOf(pc.getKarmaPercent()) };
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80059
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80060
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80061
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80062) {
			htmlid = talkToDimensionDoor(pc, (L1NpcInstance) obj, s);
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 81124) {
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
		}
		else if (s.equalsIgnoreCase("contract1")) {
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
		}
		else if (s.equalsIgnoreCase("pandora6") || s.equalsIgnoreCase("cold6")
				|| s.equalsIgnoreCase("balsim3")
				|| s.equalsIgnoreCase("mellin3") || s.equalsIgnoreCase("glen3")) {
			htmlid = s;
			int npcid = ((L1NpcInstance) obj).getNpcTemplate().get_npcId();
			int taxRatesCastle = L1CastleLocation
					.getCastleTaxRateByNpcId(npcid);
			htmldata = new String[] { String.valueOf(taxRatesCastle) };
		}
		else if (s.equalsIgnoreCase("set")) {
			if (obj instanceof L1NpcInstance) {
				int npcid = ((L1NpcInstance) obj).getNpcTemplate().get_npcId();
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
		}
		else if (s.equalsIgnoreCase("clear")) {
			if (obj instanceof L1NpcInstance) {
				int npcid = ((L1NpcInstance) obj).getNpcTemplate().get_npcId();
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
		}
		else if (s.equalsIgnoreCase("ask")) {
			if (obj instanceof L1NpcInstance) {
				int npcid = ((L1NpcInstance) obj).getNpcTemplate().get_npcId();
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70534
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70556
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70572
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70631
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70663
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70761
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70788
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70806
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70830
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70876) {
				if (s.equalsIgnoreCase("r")) {//TODO Town mayor report about income
					if (obj instanceof L1NpcInstance) {
					int npcid = ((L1NpcInstance) obj).getNpcTemplate()
							.get_npcId();
					int town_id = L1TownLocation.getTownIdByNpcid(npcid);
				}
			}
			else if (s.equalsIgnoreCase("t")) {

			}
			else if (s.equalsIgnoreCase("c")) {

			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70997) {
			if (s.equalsIgnoreCase("0")) {
				final int[] item_ids = { 41146, 4, 20322, 173, 40743, };
				final int[] item_amounts = { 1, 1, 1, 1, 500, };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getLogName()));
				}
				pc.getQuest().set_step(L1Quest.QUEST_DOROMOND, 1);
				htmlid = "jpe0015";
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70999) {
			if (s.equalsIgnoreCase("1")) {
				if (pc.getInventory().consumeItem(41146, 1)) {
					final int[] item_ids = { 23, 20219, 20193, };
					final int[] item_amounts = { 1, 1, 1, };
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143,
								((L1NpcInstance) obj).getNpcTemplate()
										.get_name(), item.getLogName()));
					}
					pc.getQuest().set_step(L1Quest.QUEST_DOROMOND, 2);
					htmlid = "";
				}
			} else if (s.equalsIgnoreCase("2")) {
				final int[] item_ids = { 41227 };
				final int[] item_amounts = { 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getLogName()));
				}
				pc.getQuest().set_step(L1Quest.QUEST_AREX, L1Quest.QUEST_END);
					htmlid = "";
				}
			}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71005) {
			if (s.equalsIgnoreCase("0")) {
				if (!pc.getInventory().checkItem(41209)) {
					final int[] item_ids = { 41209, };
					final int[] item_amounts = { 1, };
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143,
								((L1NpcInstance) obj).getNpcTemplate()
										.get_name(), item.getItem().getName()));
					}
				}
				htmlid = "";
			}
			else if (s.equalsIgnoreCase("1")) {
				if (pc.getInventory().consumeItem(41213, 1)) {
					final int[] item_ids = { 40029, };
					final int[] item_amounts = { 20, };
					for (int i = 0; i < item_ids.length; i++) {
						L1ItemInstance item = pc.getInventory().storeItem(
								item_ids[i], item_amounts[i]);
						pc.sendPackets(new S_ServerMessage(143,
								((L1NpcInstance) obj).getNpcTemplate()
										.get_name(), item.getItem().getName()
										+ " (" + item_amounts[i] + ")"));
					}
					htmlid = ""; 
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71006) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 70512) {
			if (s.equalsIgnoreCase("0") || s.equalsIgnoreCase("fullheal")) {
				int hp = _random.nextInt(21) + 70;
				pc.setCurrentHp(pc.getCurrentHp() + hp);
				pc.sendPackets(new S_ServerMessage(77));
				pc.sendPackets(new S_SkillSound(pc.getId(), 830));
				pc
						.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc
								.getMaxHp()));
				htmlid = ""; // EBhE
			}
		}
		// tiPFHPMPj
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71037) {
			if (s.equalsIgnoreCase("0")) {
				pc.setCurrentHp(pc.getMaxHp());
				pc.setCurrentMp(pc.getMaxMp());
				pc.sendPackets(new S_ServerMessage(77));
				pc.sendPackets(new S_SkillSound(pc.getId(), 830));
				pc
						.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc
								.getMaxHp()));
				pc
						.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc
								.getMaxMp()));
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71030) {
			if (s.equalsIgnoreCase("fullheal")) {
				if (pc.getInventory().checkItem(L1ItemId.ADENA, 5)) { 
					pc.getInventory().consumeItem(L1ItemId.ADENA, 5); 
					pc.setCurrentHp(pc.getMaxHp());
					pc.setCurrentMp(pc.getMaxMp());
					pc.sendPackets(new S_ServerMessage(77));
					pc.sendPackets(new S_SkillSound(pc.getId(), 830));
					pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc
							.getMaxHp()));
					pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc
							.getMaxMp()));
					if (pc.isInParty()) {
						pc.getParty().updateMiniHP(pc);
					}
				} else {
					pc.sendPackets(new S_ServerMessage(337, "$4")); 
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71002) {
			if (s.equalsIgnoreCase("0")) {
				if (pc.getLevel() <= 13) {
					L1SkillUse skillUse = new L1SkillUse();
					skillUse.handleCommands(pc, L1SkillId.CANCELLATION, pc
							.getId(), pc.getX(), pc.getY(), null, 0,
							L1SkillUse.TYPE_NPCBUFF, (L1NpcInstance) obj);
					htmlid = ""; 
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71025) {
			if (s.equalsIgnoreCase("0")) {
				final int[] item_ids = { 41225, };
				final int[] item_amounts = { 1, };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
				}
				htmlid = "jpe0083";
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71055) {
			if (s.equalsIgnoreCase("0")) {
				final int[] item_ids = { 40701, };
				final int[] item_amounts = { 1, };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
				}
				pc.getQuest().set_step(L1Quest.QUEST_LUKEIN1, 1);
				htmlid = "lukein8";
			} else if (s.equalsIgnoreCase("2")) {
				htmlid = "lukein12";
				pc.getQuest().set_step(L1Quest.QUEST_RESTA, 3);
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71063) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71064
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71065
				|| ((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71066) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71056) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71057) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71059) {
			if (s.equalsIgnoreCase("A")) {
				htmlid = "rudian6";
				final int[] item_ids = { 40700 };
				final int[] item_amounts = { 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
				}
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71060) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71061) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71062) {
			if (s.equalsIgnoreCase("start")) {
				htmlid = "kamit2";
				final int[] item_ids = { 40711 };
				final int[] item_amounts = { 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
					pc.getQuest().set_step(L1Quest.QUEST_CADMUS, 3);
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71036) {
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
			} else if (s.equalsIgnoreCase("b")) { // J[~itR{j
				if (pc.getQuest().get_step(L1Quest.QUEST_KAMYLA) == 1) {
					L1Teleport.teleport(pc, 32679, 32742, (short) 482, 5, true);
				}
			} else if (s.equalsIgnoreCase("d")) { // J[~ifBGSSj
				if (pc.getQuest().get_step(L1Quest.QUEST_KAMYLA) == 3) {
					L1Teleport.teleport(pc, 32736, 32800, (short) 483, 5, true);
				}
			} else if (s.equalsIgnoreCase("f")) { // J[~izZnSj
				if (pc.getQuest().get_step(L1Quest.QUEST_KAMYLA) == 4) {
					L1Teleport.teleport(pc, 32746, 32807, (short) 484, 5, true);
				}
			}
		}
		// tR(C)
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71089) {
			if (s.equalsIgnoreCase("a")) {
				htmlid = "francu10";
				final int[] item_ids = { 40644 };
				final int[] item_amounts = { 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
					pc.getQuest().set_step(L1Quest.QUEST_KAMYLA, 2);
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71090) {
			if (s.equalsIgnoreCase("a")) {
				htmlid = "";
				final int[] item_ids = { 246, 247, 248, 249, 40660 };
				final int[] item_amounts = { 1, 1, 1, 1, 5 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71091) {
			if (s.equalsIgnoreCase("a")) {
				htmlid = "";
				pc.getInventory().consumeItem(40654, 1);
				pc.getQuest()
						.set_step(L1Quest.QUEST_CRYSTAL, L1Quest.QUEST_END);
				L1Teleport.teleport(pc, 32744, 32927, (short) 483, 4, true);
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71074) {
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
				createitem = new int[] { 20167 }; // U[h}O[u
				createcount = new int[] { 1 };
				pc.getQuest().set_step(L1Quest.QUEST_LIZARD, L1Quest.QUEST_END);
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71198) {
			if (s.equalsIgnoreCase("A")) {
				if (pc.getQuest().get_step(71198) != 0
						|| pc.getInventory().checkItem(21059, 1)) {
					return;
				}
				if (pc.getInventory().consumeItem(41339, 5)) { 
					L1ItemInstance item = ItemTable.getInstance().createItem(
							41340); // bc eBI
					if (item != null) {
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143,
									((L1NpcInstance) obj).getNpcTemplate()
											.get_name(),item.getItem()
													.getName())); 
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
							21057); // PRm}g1
					if (item != null) {
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143,
									((L1NpcInstance) obj).getNpcTemplate()
											.get_name(),item.getItem()
													.getName())); 
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
							21058); // PRm}g2
					if (item != null) {
						pc.getInventory().consumeItem(21057, 1);
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143,
									((L1NpcInstance) obj).getNpcTemplate()
											.get_name(),item.getItem()
													.getName())); 
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
							21059); // |CY T[yg N[N
					if (item != null) {
						pc.getInventory().consumeItem(21058, 1);
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143,
									((L1NpcInstance) obj).getNpcTemplate()
											.get_name(),item.getItem()
													.getName())); 
						}
					}
					pc.getQuest().set_step(71198, 0);
					pc.getQuest().set_step(71199, 0);
					htmlid = "tion8";
				} else {
					htmlid = "tion15";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71199) {
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
							41341); // WF{
					if (item != null) {
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143,
									((L1NpcInstance) obj).getNpcTemplate()
											.get_name(),item.getItem()
													.getName())); 
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
							41341); // WF{
					if (item != null) {
						if (pc.getInventory().checkAddItem(item, 1) == 0) {
							pc.getInventory().storeItem(item);
							pc.sendPackets(new S_ServerMessage(143,
									((L1NpcInstance) obj).getNpcTemplate()
											.get_name(),item.getItem()
													.getName())); 
						}
					}
					pc.getInventory().consumeItem(41340, 1);
					pc.getQuest().set_step(71199, 255);
					htmlid = "jeron5";
				} else {
					htmlid = "jeron9";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80079) {
			if (s.equalsIgnoreCase("0")) {
				if (!pc.getInventory().checkItem(41312)) { 
					L1ItemInstance item = pc.getInventory().storeItem(41312, 1);
					if (item != null) {
						pc.sendPackets(new S_ServerMessage(143,
								((L1NpcInstance) obj).getNpcTemplate()
								.get_name(),item.getItem().getName()));
						pc.getQuest().set_step(L1Quest.QUEST_KEPLISHA,
								L1Quest.QUEST_END);
					}
					htmlid = "keplisha7";
				}
			}
			else if (s.equalsIgnoreCase("1")) {
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
			}
			else if (s.equalsIgnoreCase("2")) {
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
			}
			else if (s.equalsIgnoreCase("3")) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80082) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80083) {
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
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80084) {
			if (s.equalsIgnoreCase("q")) {
				if (pc.getInventory().checkItem(41356, 1)) {
					htmlid = "rparum4";
				} else {
					L1ItemInstance item = pc.getInventory().storeItem(41356, 1);
					if (item != null) {
						pc.sendPackets(new S_ServerMessage(143,
								((L1NpcInstance) obj).getNpcTemplate()
								.get_name(),item.getItem().getName()));
					}
					htmlid = "rparum3";
				}
			}
		}
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80105) {
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
		}

		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71126) {
			// uBv
			if (s.equalsIgnoreCase("B")) {
				if (pc.getInventory().checkItem(41007, 1)) { // CXF
					htmlid = "eris10";
				} else {
					L1NpcInstance npc = (L1NpcInstance) obj;
					L1ItemInstance item = pc.getInventory().storeItem(41007, 1);
					String npcName = npc.getNpcTemplate().get_name();
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
					htmlid = "eris6";
				}
			} else if (s.equalsIgnoreCase("C")) {
				if (pc.getInventory().checkItem(41009, 1)) { // CXFv
					htmlid = "eris10";
				} else {
					L1NpcInstance npc = (L1NpcInstance) obj;
					L1ItemInstance item = pc.getInventory().storeItem(41009, 1);
					String npcName = npc.getNpcTemplate().get_name();
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
					htmlid = "eris8";
				}
			} else if (s.equalsIgnoreCase("A")) {
				if (pc.getInventory().checkItem(41007, 1)) { // CXF
					if (pc.getInventory().checkItem(40969, 20)) { // _[NGt
						htmlid = "eris18";
						materials = new int[] { 40969, 41007 };
						counts = new int[] { 20, 1 };
						createitem = new int[] { 41008 }; // CXobN
						createcount = new int[] { 1 };
					} else {
						htmlid = "eris5";
					}
				} else {
					htmlid = "eris2";
				}
			} else if (s.equalsIgnoreCase("E")) {
				if (pc.getInventory().checkItem(41010, 1)) { // CXE
					htmlid = "eris19";
				} else {
					htmlid = "eris7";
				}
			} else if (s.equalsIgnoreCase("D")) {
				if (pc.getInventory().checkItem(41010, 1)) { // CXE
					htmlid = "eris19";
				} else {
					if (pc.getInventory().checkItem(41009, 1)) { // CXFv
						if (pc.getInventory().checkItem(40959, 1)) { // @R
							htmlid = "eris17";
							materials = new int[] { 40959, 41009 }; // @R
							counts = new int[] { 1, 1 };
							createitem = new int[] { 41010 }; // CXE
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40960, 1)) { // R
							htmlid = "eris16";
							materials = new int[] { 40960, 41009 }; // R
							counts = new int[] { 1, 1 };
							createitem = new int[] { 41010 }; // CXE
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40961, 1)) { // bR
							htmlid = "eris15";
							materials = new int[] { 40961, 41009 }; // bR
							counts = new int[] { 1, 1 };
							createitem = new int[] { 41010 }; // CXE
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40962, 1)) { // ER
							htmlid = "eris14";
							materials = new int[] { 40962, 41009 }; // ER
							counts = new int[] { 1, 1 };
							createitem = new int[] { 41010 }; // CXE
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40635, 10)) { // RobW
							htmlid = "eris12";
							materials = new int[] { 40635, 41009 }; // RobW
							counts = new int[] { 10, 1 };
							createitem = new int[] { 41010 }; // CXE
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40638, 10)) { // bRobW
							htmlid = "eris11";
							materials = new int[] { 40638, 41009 }; // RobW
							counts = new int[] { 10, 1 };
							createitem = new int[] { 41010 }; // CXE
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40642, 10)) { // @RobW
							htmlid = "eris13";
							materials = new int[] { 40642, 41009 }; // @RobW
							counts = new int[] { 10, 1 };
							createitem = new int[] { 41010 }; // CXE
							createcount = new int[] { 1 };
						} else if (pc.getInventory().checkItem(40667, 10)) { // ERobW
							htmlid = "eris13";
							materials = new int[] { 40667, 41009 }; // ERobW
							counts = new int[] { 10, 1 };
							createitem = new int[] { 41010 }; // CXE
							createcount = new int[] { 1 };
						} else {
							htmlid = "eris8";
						}
					} else {
						htmlid = "eris7";
					}
				}
			}
		}
		// |qCm
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80076) {
			if (s.equalsIgnoreCase("A")) {
				int[] diaryno = { 49082, 49083 };
				int pid = _random.nextInt(diaryno.length);
				int di = diaryno[pid];
				if (di == 49082) { // y[W
					htmlid = "voyager6a";
					L1NpcInstance npc = (L1NpcInstance) obj;
					L1ItemInstance item = pc.getInventory().storeItem(di, 1);
					String npcName = npc.getNpcTemplate().get_name();
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
				} else if (di == 49083) { // y[W
					htmlid = "voyager6b";
					L1NpcInstance npc = (L1NpcInstance) obj;
					L1ItemInstance item = pc.getInventory().storeItem(di, 1);
					String npcName = npc.getNpcTemplate().get_name();
					String itemName = item.getItem().getName();
					pc.sendPackets(new S_ServerMessage(143, npcName, itemName));
				}
			}
		}
		// Bpt y^[
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71128) {
			if (s.equals("A")) {
				if (pc.getInventory().checkItem(41010, 1)) { // CXE
					htmlid = "perita2";
				} else {
					htmlid = "perita3";
				}
			} else if (s.equals("p")) {
				// ubNCAO
				if (pc.getInventory().checkItem(40987, 1) // EBU[hNX
						&& pc.getInventory().checkItem(40988, 1) // iCgNX
						&& pc.getInventory().checkItem(40989, 1)) { // EH[ANX
					htmlid = "perita43";
				} else if (pc.getInventory().checkItem(40987, 1) // EBU[hNX
						&& pc.getInventory().checkItem(40989, 1)) { // EH[ANX
					htmlid = "perita44";
				} else if (pc.getInventory().checkItem(40987, 1) // EBU[hNX
						&& pc.getInventory().checkItem(40988, 1)) { // iCgNX
					htmlid = "perita45";
				} else if (pc.getInventory().checkItem(40988, 1) // iCgNX
						&& pc.getInventory().checkItem(40989, 1)) { // EH[ANX
					htmlid = "perita47";
				} else if (pc.getInventory().checkItem(40987, 1)) { // EBU[hNX
					htmlid = "perita46";
				} else if (pc.getInventory().checkItem(40988, 1)) { // iCgNX
					htmlid = "perita49";
				} else if (pc.getInventory().checkItem(40987, 1)) { // EH[ANX
					htmlid = "perita48";
				} else {
					htmlid = "perita50";
				}
			} else if (s.equals("q")) {
				// ubNCAO
				if (pc.getInventory().checkItem(41173, 1) // EBU[hNX
						&& pc.getInventory().checkItem(41174, 1) // iCgNX
						&& pc.getInventory().checkItem(41175, 1)) { // EH[ANX
					htmlid = "perita54";
				} else if (pc.getInventory().checkItem(41173, 1) // EBU[hNX
						&& pc.getInventory().checkItem(41175, 1)) { // EH[ANX
					htmlid = "perita55";
				} else if (pc.getInventory().checkItem(41173, 1) // EBU[hNX
						&& pc.getInventory().checkItem(41174, 1)) { // iCgNX
					htmlid = "perita56";
				} else if (pc.getInventory().checkItem(41174, 1) // iCgNX
						&& pc.getInventory().checkItem(41175, 1)) { // EH[ANX
					htmlid = "perita58";
				} else if (pc.getInventory().checkItem(41174, 1)) { // EBU[hNX
					htmlid = "perita57";
				} else if (pc.getInventory().checkItem(41175, 1)) { // iCgNX
					htmlid = "perita60";
				} else if (pc.getInventory().checkItem(41176, 1)) { // EH[ANX
					htmlid = "perita59";
				} else {
					htmlid = "perita61";
				}
			} else if (s.equals("s")) {
				// ~XeAX ubNCAO
				if (pc.getInventory().checkItem(41161, 1) // EBU[hNX
						&& pc.getInventory().checkItem(41162, 1) // iCgNX
						&& pc.getInventory().checkItem(41163, 1)) { // EH[ANX
					htmlid = "perita62";
				} else if (pc.getInventory().checkItem(41161, 1) // EBU[hNX
						&& pc.getInventory().checkItem(41163, 1)) { // EH[ANX
					htmlid = "perita63";
				} else if (pc.getInventory().checkItem(41161, 1) // EBU[hNX
						&& pc.getInventory().checkItem(41162, 1)) { // iCgNX
					htmlid = "perita64";
				} else if (pc.getInventory().checkItem(41162, 1) // iCgNX
						&& pc.getInventory().checkItem(41163, 1)) { // EH[ANX
					htmlid = "perita66";
				} else if (pc.getInventory().checkItem(41161, 1)) { // EBU[hNX
					htmlid = "perita65";
				} else if (pc.getInventory().checkItem(41162, 1)) { // iCgNX
					htmlid = "perita68";
				} else if (pc.getInventory().checkItem(41163, 1)) { // EH[ANX
					htmlid = "perita67";
				} else {
					htmlid = "perita69";
				}
			} else if (s.equals("B")) {
				// |[V
				if (pc.getInventory().checkItem(40651, 10) // 
						&& pc.getInventory().checkItem(40643, 10) // 
						&& pc.getInventory().checkItem(40618, 10) // n
						&& pc.getInventory().checkItem(40645, 10) // 
						&& pc.getInventory().checkItem(40676, 10) // 
						&& pc.getInventory().checkItem(40442, 5) // vbut
						&& pc.getInventory().checkItem(40051, 1)) { // Gh
					htmlid = "perita7";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40442, 40051 };
					counts = new int[] { 10, 10, 10, 10, 20, 5, 1 };
					createitem = new int[] { 40925 }; // |[V
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita8";
				}
			} else if (s.equals("G") || s.equals("h") || s.equals("i")) {
				// ~XeAX |[VFPiK
				if (pc.getInventory().checkItem(40651, 5) // 
						&& pc.getInventory().checkItem(40643, 5) // 
						&& pc.getInventory().checkItem(40618, 5) // n
						&& pc.getInventory().checkItem(40645, 5) // 
						&& pc.getInventory().checkItem(40676, 5) // 
						&& pc.getInventory().checkItem(40675, 5) // z
						&& pc.getInventory().checkItem(40049, 3) // r[
						&& pc.getInventory().checkItem(40051, 1)) { // Gh
					htmlid = "perita27";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40675, 40049, 40051 };
					counts = new int[] { 5, 5, 5, 5, 10, 10, 3, 1 };
					createitem = new int[] { 40926 }; // ~XeAX|[VFPiK
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita28";
				}
			} else if (s.equals("H") || s.equals("j") || s.equals("k")) {
				// ~XeAX |[VFQiK
				if (pc.getInventory().checkItem(40651, 10) // 
						&& pc.getInventory().checkItem(40643, 10) // 
						&& pc.getInventory().checkItem(40618, 10) // n
						&& pc.getInventory().checkItem(40645, 10) // 
						&& pc.getInventory().checkItem(40676, 20) // 
						&& pc.getInventory().checkItem(40675, 10) // z
						&& pc.getInventory().checkItem(40048, 3) // _CAh
						&& pc.getInventory().checkItem(40051, 1)) { // Gh
					htmlid = "perita29";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40675, 40048, 40051 };
					counts = new int[] { 10, 10, 10, 10, 20, 10, 3, 1 };
					createitem = new int[] { 40927 }; // ~XeAX|[VFQiK
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita30";
				}
			} else if (s.equals("I") || s.equals("l") || s.equals("m")) {
				// ~XeAX |[VFRiK
				if (pc.getInventory().checkItem(40651, 20) // 
						&& pc.getInventory().checkItem(40643, 20) // 
						&& pc.getInventory().checkItem(40618, 20) // n
						&& pc.getInventory().checkItem(40645, 20) // 
						&& pc.getInventory().checkItem(40676, 30) // 
						&& pc.getInventory().checkItem(40675, 10) // z
						&& pc.getInventory().checkItem(40050, 3) // Tt@CA
						&& pc.getInventory().checkItem(40051, 1)) { // Gh
					htmlid = "perita31";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40675, 40050, 40051 };
					counts = new int[] { 20, 20, 20, 20, 30, 10, 3, 1 };
					createitem = new int[] { 40928 }; // ~XeAX|[VFRiK
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita32";
				}
			} else if (s.equals("J") || s.equals("n") || s.equals("o")) {
				// ~XeAX |[VFSiK
				if (pc.getInventory().checkItem(40651, 30) // 
						&& pc.getInventory().checkItem(40643, 30) // 
						&& pc.getInventory().checkItem(40618, 30) // n
						&& pc.getInventory().checkItem(40645, 30) // 
						&& pc.getInventory().checkItem(40676, 30) // 
						&& pc.getInventory().checkItem(40675, 20) // z
						&& pc.getInventory().checkItem(40052, 1) // _CAh
						&& pc.getInventory().checkItem(40051, 1)) { // Gh
					htmlid = "perita33";
					materials = new int[] { 40651, 40643, 40618, 40645, 40676,
							40675, 40052, 40051 };
					counts = new int[] { 30, 30, 30, 30, 30, 20, 1, 1 };
					createitem = new int[] { 40928 }; // ~XeAX|[VFSiK
					createcount = new int[] { 1 };
				} else {
					htmlid = "perita34";
				}
			} else if (s.equals("K")) { // PiKCAO(CAO)
				int earinga = 0;
				int earingb = 0;
				if (pc.getInventory().checkEquipped(21014)
						|| pc.getInventory().checkEquipped(21006)
						|| pc.getInventory().checkEquipped(21007)) {
					htmlid = "perita36";
				} else if (pc.getInventory().checkItem(21014, 1)) { // EBU[hNX
					earinga = 21014;
					earingb = 41176;
				} else if (pc.getInventory().checkItem(21006, 1)) { // iCgNX
					earinga = 21006;
					earingb = 41177;
				} else if (pc.getInventory().checkItem(21007, 1)) { // EH[ANX
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
			} else if (s.equals("L")) { // QiKCAO(mbCAO)
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
			} else if (s.equals("M")) { // RiKCAO(^CAO)
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
			} else if (s.equals("b")) { // QiKCAO(MCAO)
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
			} else if (s.equals("d")) { // RiKCAO(_CAO)
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
			} else if (s.equals("a")) { // QiKCAO({CAO)
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
			} else if (s.equals("c")) { // RiKCAO(ECAO)
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
		}
		// Ht [BX
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71129) {
			if (s.equals("Z")) {
				htmlid = "rumtis2";
			} else if (s.equals("Y")) {
				if (pc.getInventory().checkItem(41010, 1)) { // CXE
					htmlid = "rumtis3";
				} else {
					htmlid = "rumtis4";
				}
			} else if (s.equals("q")) {
				htmlid = "rumtis92";
			} else if (s.equals("A")) {
				if (pc.getInventory().checkItem(41161, 1)) {
					// ~XeAXubNCAO
					htmlid = "rumtis6";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("B")) {
				if (pc.getInventory().checkItem(41164, 1)) {
					// ~XeAXEBU[hCAO
					htmlid = "rumtis7";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("C")) {
				if (pc.getInventory().checkItem(41167, 1)) {
					// ~XeAXO[EBU[hCAO
					htmlid = "rumtis8";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("T")) {
				if (pc.getInventory().checkItem(41167, 1)) {
					// ~XeAXzCgEBU[hCAO
					htmlid = "rumtis9";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("w")) {
				if (pc.getInventory().checkItem(41162, 1)) {
					// ~XeAXubNCAO
					htmlid = "rumtis14";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("x")) {
				if (pc.getInventory().checkItem(41165, 1)) {
					// ~XeAXiCgCAO
					htmlid = "rumtis15";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("y")) {
				if (pc.getInventory().checkItem(41168, 1)) {
					// ~XeAXO[iCgCAO
					htmlid = "rumtis16";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("z")) {
				if (pc.getInventory().checkItem(41171, 1)) {
					// ~XeAXzCgiCgCAO
					htmlid = "rumtis17";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("U")) {
				if (pc.getInventory().checkItem(41163, 1)) {
					// ~XeAXubNCAO
					htmlid = "rumtis10";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("V")) {
				if (pc.getInventory().checkItem(41166, 1)) {
					// ~XeAXEH[ACAO
					htmlid = "rumtis11";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("W")) {
				if (pc.getInventory().checkItem(41169, 1)) {
					// ~XeAXO[EH[ACAO
					htmlid = "rumtis12";
				} else {
					htmlid = "rumtis101";
				}
			} else if (s.equals("X")) {
				if (pc.getInventory().checkItem(41172, 1)) {
					// ~XeAXzCEH[ACAO
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
				if (pc.getInventory().checkItem(40959, 1) // @R
						&& pc.getInventory().checkItem(40960, 1) // R
						&& pc.getInventory().checkItem(40961, 1) // bR
						&& pc.getInventory().checkItem(40962, 1)) { // ER
					insn = 1;
					me = 40959;
					mr = 40960;
					mj = 40961;
					an = 40962;
					men = 1;
					mrn = 1;
					mjn = 1;
					ann = 1;
				} else if (pc.getInventory().checkItem(40642, 10) // @RobW
						&& pc.getInventory().checkItem(40635, 10) // RobW
						&& pc.getInventory().checkItem(40638, 10) // bRobW
						&& pc.getInventory().checkItem(40667, 10)) { // ERobW
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
				if (pc.getInventory().checkItem(40046, 1) // Tt@CA
						&& pc.getInventory().checkItem(40618, 5) // n
						&& pc.getInventory().checkItem(40643, 5) // 
						&& pc.getInventory().checkItem(40645, 5) // 
						&& pc.getInventory().checkItem(40651, 5) // 
						&& pc.getInventory().checkItem(40676, 5)) { // 
					if (insn == 1 || bacn == 1) {
						htmlid = "rumtis60";
						materials = new int[] { me, mr, mj, an, 40046, 40618,
								40643, 40651, 40676 };
						counts = new int[] { men, mrn, mjn, ann, 1, 5, 5, 5, 5,
								5 };
						createitem = new int[] { 40926 }; // HTt@CAFPiK
						createcount = new int[] { 1 };
					} else {
						htmlid = "rumtis18";
					}
				}
			}
		}
		// A^[
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71119) {
			// uX^ohj18Snv
			if (s.equalsIgnoreCase("request las history book")) {
				materials = new int[] { 41019, 41020, 41021, 41022, 41023,
						41024, 41025, 41026 };
				counts = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
				createitem = new int[] { 41027 };
				createcount = new int[] { 1 };
				htmlid = "";
			}
		}
		// VsNX
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71170) {
			// uX^ohjnv
			if (s.equalsIgnoreCase("request las weapon manual")) {
				materials = new int[] { 41027 };
				counts = new int[] { 1 };
				createitem = new int[] { 40965 };
				createcount = new int[] { 1 };
				htmlid = "";
			}
		}
		// ^ _eX
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 71168) {
			// uEv
			if (s.equalsIgnoreCase("a")) {
				if (pc.getInventory().checkItem(41028, 1)) {
					L1Teleport.teleport(pc, 32648, 32921, (short) 535, 6, true);
					pc.getInventory().consumeItem(41028, 1);
				}
			}
		}
		// (~]A)
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 80067) {
			// uhv
			if (s.equalsIgnoreCase("n")) {
				htmlid = "";
				poly(client, 6034);
				final int[] item_ids = { 41132, 41133, 41134 };
				final int[] item_amounts = { 1, 1, 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
					pc.getQuest().set_step(L1Quest.QUEST_DESIRE, 1);
				}
				// uCv
			} else if (s.equalsIgnoreCase("d")) {
				htmlid = "minicod09";
				pc.getInventory().consumeItem(41130, 1);
				pc.getInventory().consumeItem(41131, 1);
				// uv
			} else if (s.equalsIgnoreCase("k")) {
				htmlid = "";
				pc.getInventory().consumeItem(41132, 1); // 
				pc.getInventory().consumeItem(41133, 1); // 
				pc.getInventory().consumeItem(41134, 1); // 
				pc.getInventory().consumeItem(41135, 1); // Jw
				pc.getInventory().consumeItem(41136, 1); // Jw
				pc.getInventory().consumeItem(41137, 1); // Jw
				pc.getInventory().consumeItem(41138, 1); // Jw
				pc.getQuest().set_step(L1Quest.QUEST_DESIRE, 0);
				// n
			} else if (s.equalsIgnoreCase("e")) {
				if (pc.getQuest().get_step(L1Quest.QUEST_DESIRE) == L1Quest.QUEST_END
						|| pc.getKarmaLevel() >= 1) {
					htmlid = "";
				} else {
					if (pc.getInventory().checkItem(41138)) {
						htmlid = "";
						pc.addKarma((int) (1600 * Config.RATE_KARMA));
						pc.getInventory().consumeItem(41130, 1); // _
						pc.getInventory().consumeItem(41131, 1); // w
						pc.getInventory().consumeItem(41138, 1); // Jw
						pc.getQuest().set_step(L1Quest.QUEST_DESIRE,
								L1Quest.QUEST_END);
					} else {
						htmlid = "minicod04";
					}
				}
				// v[g
			} else if (s.equalsIgnoreCase("g")) {
				htmlid = "";
				final int[] item_ids = { 41130 }; // _
				final int[] item_amounts = { 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
				}
			}
		}
		// (e_a)
		else if (((L1NpcInstance) obj).getNpcTemplate().get_npcId() == 81202) {
			// uv
			if (s.equalsIgnoreCase("n")) {
				htmlid = "";
				poly(client, 6035);
				final int[] item_ids = { 41123, 41124, 41125 };
				final int[] item_amounts = { 1, 1, 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
					pc.getQuest().set_step(L1Quest.QUEST_SHADOWS, 1);
				}
				// uCv
			} else if (s.equalsIgnoreCase("d")) {
				htmlid = "minitos09";
				pc.getInventory().consumeItem(41121, 1);
				pc.getInventory().consumeItem(41122, 1);
				// uv
			} else if (s.equalsIgnoreCase("k")) {
				htmlid = "";
				pc.getInventory().consumeItem(41123, 1); // Jw
				pc.getInventory().consumeItem(41124, 1); // Jw
				pc.getInventory().consumeItem(41125, 1); // Jw
				pc.getInventory().consumeItem(41126, 1); // 
				pc.getInventory().consumeItem(41127, 1); // 
				pc.getInventory().consumeItem(41128, 1); // 
				pc.getInventory().consumeItem(41129, 1); // 
				pc.getQuest().set_step(L1Quest.QUEST_SHADOWS, 0);
				// n
			} else if (s.equalsIgnoreCase("e")) {
				if (pc.getQuest().get_step(L1Quest.QUEST_SHADOWS) == L1Quest.QUEST_END
						|| pc.getKarmaLevel() >= 1) {
					htmlid = "";
				} else {
					if (pc.getInventory().checkItem(41129)) {
						htmlid = "";
						pc.addKarma((int) (-1600 * Config.RATE_KARMA));
						pc.getInventory().consumeItem(41121, 1); // Jw_
						pc.getInventory().consumeItem(41122, 1); // Jww
						pc.getInventory().consumeItem(41129, 1); // 
						pc.getQuest().set_step(L1Quest.QUEST_SHADOWS,
								L1Quest.QUEST_END);
					} else {
						htmlid = "minitos04";
					}
				}
				// f
			} else if (s.equalsIgnoreCase("g")) {
				htmlid = "";
				final int[] item_ids = { 41121 }; // Jw_
				final int[] item_amounts = { 1 };
				for (int i = 0; i < item_ids.length; i++) {
					L1ItemInstance item = pc.getInventory().storeItem(
							item_ids[i], item_amounts[i]);
					pc.sendPackets(new S_ServerMessage(143,
							((L1NpcInstance) obj).getNpcTemplate().get_name(),
							item.getItem().getName()));
				}
			}
		}
		// else System.out.println("C_NpcAction: " + s);
		if (htmlid != null && htmlid.equalsIgnoreCase("colos2")) {
			htmldata = makeUbInfoStrings(((L1NpcInstance) obj).getNpcTemplate()
					.get_npcId());
		}
		if (createitem != null) { // 
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
							createrName = ((L1NpcInstance) obj)
									.getNpcTemplate().get_name();
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
				pc.beginGhost(loc.getX(), loc.getY(), (short) loc.getMapId(),
						true);
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
		if (L1HauntedHouse.getInstance().getHauntedHouseStatus() == L1HauntedHouse.STATUS_PLAYING) { // Z
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
		summonstr_list = new String[] { "7", "263", "8", "264", "9", "265",
				"10", "266", "11", "267", "12", "268", "13", "269", "14",
				"270", "526", "15", "271", "527", "17", "18" };
		summonid_list = new int[] { 81083, 81090, 81084, 81091, 81085, 81092,
				81086, 81093, 81087, 81094, 81088, 81095, 81089, 81096, 81097,
				81098, 81099, 81100, 81101, 81102, 81103, 81104 };
		summonlvl_list = new int[] { 28, 28, 32, 32, 36, 36, 40, 40, 44, 44,
				48, 48, 52, 52, 56, 56, 56, 60, 60, 60, 68, 72 };
		summoncha_list = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8,
				8, 8, 8, 10, 10, 10, 36, 40 };
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
		if ((summonid == 81103 || summonid == 81104) && petcost != 0) {
			pc.sendPackets(new S_CloseList(pc.getId()));
			return;
		}
		int charisma = pc.getCha() + 6 - petcost;
		int summoncount = charisma / summoncost;
		L1Npc npcTemp = NpcTable.getInstance().getTemplate(summonid);
		for (int cnt = 0; cnt < summoncount; cnt++) {
			L1SummonInstance summon = new L1SummonInstance(npcTemp, pc);
			if (summonid == 81103 || summonid == 81104) {
				summon.setPetcost(pc.getCha() + 7);
			} else {
				summon.setPetcost(summoncost);
			}
		}
		pc.sendPackets(new S_CloseList(pc.getId()));
	}

	private void poly(ClientThread clientthread, int polyId) {
		L1PcInstance pc = clientthread.getActiveChar();

		if (pc.getInventory().checkItem(L1ItemId.ADENA, 100)) { 
			pc.getInventory().consumeItem(L1ItemId.ADENA, 100); 

			L1PolyMorph.doPoly(pc, polyId, 1800, L1PolyMorph.MORPH_BY_NPC);
		} else {
			pc.sendPackets(new S_ServerMessage(337, "$4")); // AfisB
		}
	}

	private void polyByKeplisha(ClientThread clientthread, int polyId) {
		L1PcInstance pc = clientthread.getActiveChar();

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
		if (clan != null) {
			int houseId = clan.getHouseId();
			if (houseId != 0) {
				L1House house = HouseTable.getInstance().getHouseTable(houseId);
				int keeperId = house.getKeeperId();
				if (npc.getNpcTemplate().get_npcId() == keeperId) {
					L1DoorInstance door1 = null;
					L1DoorInstance door2 = null;
					L1DoorInstance door3 = null;
					L1DoorInstance door4 = null;
					for (L1DoorInstance door : DoorSpawnTable.getInstance()
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
		if (keeperId == 70656 || keeperId == 70549 || keeperId == 70985) { // Pg
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
		} else if (keeperId == 70778 || keeperId == 70987 || keeperId == 70687) { // WW
			if (isExistDefenseClan(L1CastleLocation.WW_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.WW_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.WW_CASTLE_ID);
		} else if (keeperId == 70817 || keeperId == 70800 || keeperId == 70988
				|| keeperId == 70990 || keeperId == 70989 || keeperId == 70991) { // M
			if (isExistDefenseClan(L1CastleLocation.GIRAN_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.GIRAN_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.GIRAN_CASTLE_ID);
		} else if (keeperId == 70863 || keeperId == 70992 || keeperId == 70862) { // nCl
			if (isExistDefenseClan(L1CastleLocation.HEINE_CASTLE_ID)) {
				if (pcCastleId != L1CastleLocation.HEINE_CASTLE_ID) {
					return;
				}
			}
			isNowWar = WarTimeController.getInstance().isNowWar(
					L1CastleLocation.HEINE_CASTLE_ID);
		} else if (keeperId == 70995 || keeperId == 70994 || keeperId == 70993) { // h[t
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

		for (L1DoorInstance door : DoorSpawnTable.getInstance().getDoorList()) {
			if (door.getKeeperId() == keeperId) {
				if (isNowWar && door.getMaxHp() > 1) { // Js
				} else {
				if (isOpen) { //
					door.open();
				} else { //
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
			if (castleId != 0) { //
				if (!WarTimeController.getInstance().isNowWar(castleId)) {
					for (L1DoorInstance door : DoorSpawnTable.getInstance()
							.getDoorList()) {
						if (L1CastleLocation.checkInWarArea(castleId, door)) {
							door.repairGate();
						}
					}
					pc.sendPackets(new S_ServerMessage(990)); // 
				} else {
					pc.sendPackets(new S_ServerMessage(991)); // 
				}
			}
		}
	}

	private void payFee(L1PcInstance pc, L1NpcInstance npc) {
		L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
		if (clan != null) {
			int houseId = clan.getHouseId();
			if (houseId != 0) {
				L1House house = HouseTable.getInstance().getHouseTable(houseId);
				int keeperId = house.getKeeperId();
				if (npc.getNpcTemplate().get_npcId() == keeperId) {
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
		if (clan != null) {
			int houseId = clan.getHouseId();
			if (houseId != 0) {
				L1House house = HouseTable.getInstance().getHouseTable(houseId);
				int keeperId = house.getKeeperId();
				if (npc.getNpcTemplate().get_npcId() == keeperId) {
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
		if (npc.getNpcTemplate().get_npcId() == 80059) { 
			protectionId = 40909;
			sealId = 40913;
			locX = 32773;
			locY = 32835;
			mapId = 607;
		} else if (npc.getNpcTemplate().get_npcId() == 80060) { 
			protectionId = 40912;
			sealId = 40916;
			locX = 32757;
			locY = 32842;
			mapId = 606;
		} else if (npc.getNpcTemplate().get_npcId() == 80061) {
			protectionId = 40910;
			sealId = 40914;
			locX = 32830;
			locY = 32822;
			mapId = 604;
		} else if (npc.getNpcTemplate().get_npcId() == 80062) {
			protectionId = 40911;
			sealId = 40915;
			locX = 32835;
			locY = 32822;
			mapId = 605;
		}

		if (s.equalsIgnoreCase("a")) {
			L1Teleport.teleport(pc, locX, locY, mapId, 5, true);
			htmlid = "";
		}
		else if (s.equalsIgnoreCase("b")) {
			L1ItemInstance item = pc.getInventory().storeItem(protectionId, 1);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			htmlid = "";
		}
		else if (s.equalsIgnoreCase("c")) {
			htmlid = "wpass07";
		}
		else if (s.equalsIgnoreCase("d")) {
			if (pc.getInventory().checkItem(sealId)) {
				L1ItemInstance item = pc.getInventory().findItemId(sealId);
				pc.getInventory().consumeItem(sealId, item.getCount());
			}
		}
		else if (s.equalsIgnoreCase("e")) {
			htmlid = "";
		}
		else if (s.equalsIgnoreCase("f")) {
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
		}
		else if (s.equalsIgnoreCase("2")) {
			pc.addKarma((int) (5000 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40718, 10);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			pc.sendPackets(new S_ServerMessage(1081));
		}
		else if (s.equalsIgnoreCase("3")) {
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
		}
		else if (s.equalsIgnoreCase("2")) {
			pc.addKarma((int) (-5000 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40678, 10);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName())); 
			}
			pc.sendPackets(new S_ServerMessage(1080));
		}
		else if (s.equalsIgnoreCase("3")) {
			pc.addKarma((int) (-50000 * Config.RATE_KARMA));
			item = pc.getInventory().storeItem(40678, 100);
			if (item != null) {
				pc.sendPackets(new S_ServerMessage(143, npc.getNpcTemplate()
						.get_name(), item.getLogName()));
			}
			pc.sendPackets(new S_ServerMessage(1080));
		}
	}

	@Override
	public String getType() {
		return C_NPC_ACTION;
	}

}
