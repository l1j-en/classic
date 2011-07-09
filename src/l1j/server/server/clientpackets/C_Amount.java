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

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ClientThread;
import l1j.server.server.datatables.AuctionBoardTable;
import l1j.server.server.datatables.HouseTable;
import l1j.server.server.datatables.InnKeyTable;
import l1j.server.server.datatables.InnTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.NpcActionTable;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.model.npc.L1NpcHtml;
import l1j.server.server.model.npc.action.L1NpcAction;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.storage.CharactersItemStorage;
import l1j.server.server.templates.L1AuctionBoard;
import l1j.server.server.templates.L1House;
import l1j.server.server.templates.L1Inn;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket, C_Amount
public class C_Amount extends ClientBasePacket {

	private static final Logger _log = Logger.getLogger(C_Amount.class.getName());
	private static final String C_AMOUNT = "[C] C_Amount";

	public C_Amount(byte[] decrypt, ClientThread client) throws Exception {
		super(decrypt);
		int objectId = readD();
		int amount = readD();
		int c = readC();
		String s = readS();

		L1PcInstance pc = client.getActiveChar();
		L1NpcInstance npc = (L1NpcInstance) L1World.getInstance().findObject(objectId);
		if (npc == null) {
		return;
		}

		String s1 = "";
		String s2 = "";
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(s);
			s1 = stringtokenizer.nextToken();
			s2 = stringtokenizer.nextToken();
		} catch (NoSuchElementException e) {
			s1 = "";
			s2 = "";
		}
		if (s1.equalsIgnoreCase("agapply")) {
			String pcName = pc.getName();
			AuctionBoardTable boardTable = new AuctionBoardTable();
			for (L1AuctionBoard board : boardTable.getAuctionBoardTableList()) {
				if (pcName.equalsIgnoreCase(board.getBidder())) {
					pc.sendPackets(new S_ServerMessage(523)); 
					return;
				}
			}
			int houseId = Integer.valueOf(s2);
			L1AuctionBoard board = boardTable.getAuctionBoardTable(houseId);
			if (board != null) {
				int nowPrice = board.getPrice();
				int nowBidderId = board.getBidderId();
				if (pc.getInventory().consumeItem(L1ItemId.ADENA, amount)) {
					board.setPrice(amount);
					board.setBidder(pcName);
					board.setBidderId(pc.getId());
					boardTable.updateAuctionBoard(board);
					if (nowBidderId != 0) {
						L1PcInstance bidPc = (L1PcInstance) L1World.getInstance().findObject(nowBidderId);
						if (bidPc != null) { 
							bidPc.getInventory().storeItem(L1ItemId.ADENA, nowPrice);
							bidPc.sendPackets(new S_ServerMessage(525, String.valueOf(nowPrice)));
						} else { 
							L1ItemInstance item = ItemTable.getInstance().createItem(L1ItemId.ADENA);
							item.setCount(nowPrice);
							CharactersItemStorage storage = CharactersItemStorage.create();
							storage.storeItem(nowBidderId, item);
						}
					}
				} else {
					pc.sendPackets(new S_ServerMessage(189)); 
				}
			}
		} else if (s1.equalsIgnoreCase("agsell")) {
			int houseId = Integer.valueOf(s2);
			AuctionBoardTable boardTable = new AuctionBoardTable();
			L1AuctionBoard board = new L1AuctionBoard();
			if (board != null) {
				board.setHouseId(houseId);
				L1House house = HouseTable.getInstance().getHouseTable(houseId);
				board.setHouseName(house.getHouseName());
				board.setHouseArea(house.getHouseArea());
				TimeZone tz = TimeZone.getTimeZone(Config.TIME_ZONE);
				Calendar cal = Calendar.getInstance(tz);
				cal.add(Calendar.DATE, 5); 
				cal.set(Calendar.MINUTE, 0); 
				cal.set(Calendar.SECOND, 0);
				board.setDeadline(cal);
				board.setPrice(amount);
				board.setLocation(house.getLocation());
				board.setOldOwner(pc.getName());
				board.setOldOwnerId(pc.getId());
				board.setBidder("");
				board.setBidderId(0);
				boardTable.insertAuctionBoard(board);
				house.setOnSale(true); 
				house.setPurchaseBasement(true); 
				HouseTable.getInstance().updateHouse(house); 
			}
		} else {
			// Inn NPC
			int npcId = npc.getNpcId();
			if (npcId == 70070 || npcId == 70019 || npcId == 70075
					|| npcId == 70012 || npcId == 70031 || npcId == 70084
					|| npcId == 70065 || npcId == 70054 || npcId == 70096) {

				if (pc.getInventory().checkItem(L1ItemId.ADENA, (300 * amount))) {
					L1Inn inn = InnTable.getInstance().getTemplate(npcId,
							pc.getInnRoomNumber());
					if (inn != null) {
						Timestamp dueTime = inn.getDueTime();
						if (dueTime != null) {
							Calendar cal = Calendar.getInstance();
							if (((cal.getTimeInMillis() - dueTime.getTime()) / 1000) < 0) {
								pc.sendPackets(new S_NPCTalkReturn(npcId, ""));
								return;
							}
						}
						Timestamp ts = new Timestamp(System.currentTimeMillis()
								+ (60 * 60 * 4 * 1000));
						L1ItemInstance item = ItemTable.getInstance()
								.createItem(40312);
						if (item != null) {
							item.setKeyId(item.getId());
							item.setInnNpcId(npcId);
							item.setHall(pc.checkRoomOrHall());
							item.setDueTime(ts);
							item.setCount(amount);
							inn.setKeyId(item.getKeyId());
							inn.setLodgerId(pc.getId());
							inn.setHall(pc.checkRoomOrHall());
							inn.setDueTime(ts);
							InnTable.getInstance().updateInn(inn);
							
							pc.getInventory().consumeItem(L1ItemId.ADENA, (300 * amount));
							L1Inventory inventory;
							
							if (pc.getInventory().checkAddItem(item, amount) == L1Inventory.OK) {
								inventory = pc.getInventory();
							} else {
								inventory = L1World.getInstance().getInventory(pc.getLocation());
							}
							inventory.storeItem(item);

							if (InnKeyTable.checkey(item)) {
								InnKeyTable.DeleteKey(item);
								InnKeyTable.StoreKey(item);
							} else {
								InnKeyTable.StoreKey(item);
							}

							String itemName = (item.getItem().getName() + item.getInnKeyName());
							if (amount > 1) {
								itemName = (itemName + " (" + amount + ")");
							}
							String[] msg = { npc.getName() };
							pc.sendPackets(new S_NPCTalkReturn(npcId, "inn4", msg));
						}
					}
				} else {
					String[] msg = { npc.getName() };
					pc.sendPackets(new S_NPCTalkReturn(npcId, "inn3", msg));
				}
			} else {
				L1NpcAction action = NpcActionTable.getInstance().get(s, pc,
						npc);
				if (action != null) {
					L1NpcHtml result = action.executeWithAmount(s, pc, npc,
							amount);
					if (result != null) {
						pc.sendPackets(new S_NPCTalkReturn(npc.getId(), result));
					}
					return;
				}
			}
		}
	}

	@Override
	public String getType() {
		return C_AMOUNT;
	}
}