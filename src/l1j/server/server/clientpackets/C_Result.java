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

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.ClientThread;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.datatables.ShopTable;
import l1j.server.server.log.LogDwarfOut;
import l1j.server.server.log.LogElfDwarfIn;
import l1j.server.server.log.LogElfDwarfOut;
import l1j.server.server.log.LogPrivateShopBuy;
import l1j.server.server.log.LogPrivateShopSell;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.model.shop.L1Shop;
import l1j.server.server.model.shop.L1ShopBuyOrderList;
import l1j.server.server.model.shop.L1ShopSellOrderList;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1PrivateShopBuyList;
import l1j.server.server.templates.L1PrivateShopSellList;

public class C_Result extends ClientBasePacket {

	private static Logger _log = Logger.getLogger(C_Result.class.getName());
	private static final String C_RESULT = "[C] C_Result";

	// TODO: somewhere more accessible, since we use this other places.
	public void ban(final L1PcInstance player) {
		// This ban had false positives, such as a player using a potion
		// while their storage window is open, so disable it for now

		//if (Config.AUTO_BAN) {
			//Account.ban(player.getAccountName());
			//IpTable.getInstance().banIp(player.getNetConnection().getIp());
			//player.sendPackets(new S_Disconnect());
		//}
	}

	public C_Result(byte abyte0[], ClientThread clientthread) throws Exception {
		super(abyte0);
		int npcObjectId = readD();
		int resultType = readC();
		int size = readC();
		readC();
		
		boolean deleteAfterAction = false;
		L1PcInstance pc = clientthread.getActiveChar();
		int level = pc.getLevel();
		
		int npcId = 0;
		String npcImpl = "";
		boolean isPrivateShop = false;
		boolean tradable = true;
		L1Object findObject = L1World.getInstance().findObject(npcObjectId);
		if (findObject != null) {
			if(npcObjectId != pc.getId() || !pc.isGm()){
				int diffLocX = Math.abs(pc.getX() - findObject.getX());
				int diffLocY = Math.abs(pc.getY() - findObject.getY());
				if (diffLocX > 3 || diffLocY > 3) {
					return;
				}
				if (findObject instanceof L1NpcInstance) {
					L1NpcInstance targetNpc = (L1NpcInstance) findObject;
					npcId = targetNpc.getNpcTemplate().get_npcId();
					npcImpl = targetNpc.getNpcTemplate().getImpl();
				} else if (findObject instanceof L1PcInstance) {
					isPrivateShop = true;
				}
			}
		}
		
		if(resultType == 0 && size != 0 
				&& npcImpl.equals("") && npcObjectId == pc.getId() 
				&& pc.isGm()) {
			npcImpl = "L1Merchant";
			npcId = pc.getId();
		} 
		
		if (resultType == 0 && size != 0
				&& npcImpl.equalsIgnoreCase("L1Merchant")) {
			int orderNumber = 0;
			int count = 0;
			L1Shop shop = ShopTable.getInstance().get(npcId);
			L1ShopBuyOrderList orderList = shop.newBuyOrderList();
			for (int i = 0; i < size; i++) {
				orderNumber = readD();
				count = readD();
				if (count > 1000 || count < 1) {
					pc.sendPackets(new S_SystemMessage("Temporary 1000 item limit."));
					continue;
				}
				orderList.add(orderNumber, count);
			}
			shop.sellItems(pc, orderList);
			// if the shop is one created by the GM action, then remove it now that we've used it
			if(deleteAfterAction)
				ShopTable.getInstance().removeGMShop(pc.getId());
		} else if (resultType == 1 && size != 0
				&& npcImpl.equalsIgnoreCase("L1Merchant")) {
			int itemObjId = 0;
			int count = 0;
			L1Shop shop = ShopTable.getInstance().get(npcId);
			L1ShopSellOrderList orderList = shop.newSellOrderList(pc);
			for (int i = 0; i < size; i++) {
				itemObjId = readD();
				count = readD();
				if (count > 1000 || count < 1) {
					pc.sendPackets(new S_SystemMessage("Temporary 1000 item limit."));
					continue;
				}
				orderList.add(itemObjId, count);
			}
			shop.buyItems(orderList);
		} else if (resultType == 2 && size != 0
				&& npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5) {
			int objectId, count;
			for (int i = 0; i < size; i++) {
				tradable = true;
				objectId = readD();
				count = readD();
				L1Object object = pc.getInventory().getItem(objectId);
				L1ItemInstance item = (L1ItemInstance) object;
				//unused
				//int item_count_before = item.getCount();
				//int item_count_after = 0;
				if (!item.getItem().isTradable()) {
					tradable = false;
					pc.sendPackets(new S_ServerMessage(210, item.getItem()
							.getName()));
				}
				Object[] petlist = pc.getPetList().values().toArray();
				for (Object petObject : petlist) {
					if (petObject instanceof L1PetInstance) {
						L1PetInstance pet = (L1PetInstance) petObject;
						if (item.getId() == pet.getItemObjId()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(210, item
									.getItem().getName()));
							break;
						}
					}
				}
				Object[] dolllist = pc.getDollList().values().toArray();
				for (Object dollObject : dolllist) {
					if (dollObject instanceof L1DollInstance) {
						L1DollInstance doll = (L1DollInstance) dollObject;
						if (item.getId() == doll.getItemObjId()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(1181));
							break;
						}
					}
				}
				if (pc.getDwarfInventory().checkAddItemToWarehouse(item, count,
						L1Inventory.WAREHOUSE_TYPE_PERSONAL) == L1Inventory.SIZE_OVER) {
					pc.sendPackets(new S_ServerMessage(75));
					break;
				}
				if (count > item.getCount()) {
					_log.log(Level.SEVERE, pc.getName() + " tried to store "
							+ count + " of " + objectId + " but server has "
							+ item.getCount() + ".");
					ban(pc);
					return;
				}
				if (tradable) {
					pc.getInventory().tradeItem(objectId, count,
							pc.getDwarfInventory());
					pc.turnOnOffLight();
					L1ItemInstance pcitem = pc.getInventory().getItem(objectId);
					if (pcitem != null) {
						//unused
						//item_count_after = pcitem.getCount();
					}
					// LogDwarfIn ldi = new LogDwarfIn();
					// ldi.storeLogDwarfIn(pc, item, item_count_before,
					// item_count_after, count);
				}
			}
			pc.saveInventory();
		} else if (resultType == 3 && size != 0
				&& npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5) {
			int objectId, count;
			L1ItemInstance item;
			for (int i = 0; i < size; i++) {
				objectId = readD();
				count = readD();
				item = pc.getDwarfInventory().getItem(objectId);
				int item_count_before = item.getCount();
				int item_count_after = 0;
				if (count > item.getCount()) {
					_log.log(Level.SEVERE, pc.getName() + " tried to retrieve "
							+ count + " of " + objectId + " but server has "
							+ item.getCount() + ".");
					ban(pc);
					return;
				}
				if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
					if (pc.getInventory().consumeItem(L1ItemId.ADENA, 30)) {
						pc.getDwarfInventory().tradeItem(item, count,
								pc.getInventory());
						L1ItemInstance dwitem = pc.getDwarfInventory().getItem(
								objectId);
						if (dwitem != null) {
							item_count_after = dwitem.getCount();
						}
						LogDwarfOut ldo = new LogDwarfOut();
						ldo.storeLogDwarfOut(pc, item, item_count_before,
								item_count_after, count);
					} else {
						pc.sendPackets(new S_ServerMessage(189));
						break;
					}
				} else {
					pc.sendPackets(new S_ServerMessage(270));
					break;
				}
			}
		} else if (resultType == 4 && size != 0
				&& npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5) {
			int objectId, count;
			if (pc.getClanid() != 0) {
				for (int i = 0; i < size; i++) {
					tradable = true;
					objectId = readD();
					count = readD();
					L1Clan clan = L1World.getInstance().getClan(
							pc.getClanname());
					L1Object object = pc.getInventory().getItem(objectId);
					L1ItemInstance item = (L1ItemInstance) object;
					//unused
					//int item_count_before = item.getCount();
					//int item_count_after = 0;
					if (count > item.getCount()) {
						_log.log(Level.SEVERE,
								pc.getName() + " tried to (clan) store "
										+ count + " of " + objectId
										+ " but server has " + item.getCount()
										+ ".");
						ban(pc);
						return;
					}
					if (clan != null) {
						if (!item.getItem().isTradable()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(210, item
									.getItem().getName()));
						}
						if (item.getBless() >= 128) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(210, item
									.getItem().getName()));
						}
						Object[] petlist = pc.getPetList().values().toArray();
						for (Object petObject : petlist) {
							if (petObject instanceof L1PetInstance) {
								L1PetInstance pet = (L1PetInstance) petObject;
								if (item.getId() == pet.getItemObjId()) {
									tradable = false;
									pc.sendPackets(new S_ServerMessage(210,
											item.getItem().getName()));
									break;
								}
							}
						}
						Object[] dolllist = pc.getDollList().values().toArray();
						for (Object dollObject : dolllist) {
							if (dollObject instanceof L1DollInstance) {
								L1DollInstance doll = (L1DollInstance) dollObject;
								if (item.getId() == doll.getItemObjId()) {
									tradable = false;
									pc.sendPackets(new S_ServerMessage(1181));
									break;
								}
							}
						}
						if (clan.getDwarfForClanInventory()
								.checkAddItemToWarehouse(item, count,
										L1Inventory.WAREHOUSE_TYPE_CLAN) == L1Inventory.SIZE_OVER) {
							pc.sendPackets(new S_ServerMessage(75));
							break;
						}
						if (tradable) {
							pc.getInventory().tradeItem(objectId, count,
									clan.getDwarfForClanInventory());
							pc.turnOnOffLight();
							L1ItemInstance pcitem = pc.getInventory().getItem(
									objectId);
							if (pcitem != null) {
								//unused
								//item_count_after = pcitem.getCount();
							}
							// LogClanDwarfIn lcdi = new LogClanDwarfIn();
							// lcdi.storeLogClanDwarfIn(pc, item,
							// item_count_before, item_count_after, count);
						}
					}
				}
				pc.saveInventory();
			} else {
				pc.sendPackets(new S_ServerMessage(208));
			}
		} else if (resultType == 5 && size != 0
				&& npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5) {
			int objectId, count;
			L1ItemInstance item;

			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				for (int i = 0; i < size; i++) {
					objectId = readD();
					count = readD();
					item = clan.getDwarfForClanInventory().getItem(objectId);
					//unused
					//int item_count_before = item.getCount();
					//int item_count_after = 0;
					if (count > item.getCount()) {
						_log.log(Level.SEVERE,
								pc.getName() + " tried to (clan) retrieve "
										+ count + " of " + objectId
										+ " but server has " + item.getCount()
										+ ".");
						ban(pc);
						return;
					}
					if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
						if (pc.getInventory().consumeItem(L1ItemId.ADENA, 30)) {
							clan.getDwarfForClanInventory().tradeItem(item,
									count, pc.getInventory());
							L1ItemInstance dwitem = clan
									.getDwarfForClanInventory().getItem(
											objectId);
							if (dwitem != null) {
								//unused
								//item_count_after = dwitem.getCount();
							}
							// LogClanDwarfOut lcdo = new LogClanDwarfOut();
							// lcdo.storeLogClanDwarfOut(pc, item,
							// item_count_before, item_count_after, count);
						} else {
							pc.sendPackets(new S_ServerMessage(189));
							break;
						}
					} else {
						pc.sendPackets(new S_ServerMessage(270));
						break;
					}
				}
				clan.setWarehouseUsingChar(0);
			}
		} else if (resultType == 5 && size == 0
				&& npcImpl.equalsIgnoreCase("L1Dwarf")) {
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				clan.setWarehouseUsingChar(0);
			}
		} else if (resultType == 8 && size != 0
				&& npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5
				&& pc.isElf()) {
			int objectId, count;
			for (int i = 0; i < size; i++) {
				tradable = true;
				objectId = readD();
				count = readD();
				L1Object object = pc.getInventory().getItem(objectId);
				L1ItemInstance item = (L1ItemInstance) object;
				int item_count_before = item.getCount();
				int item_count_after = 0;
				if (count > item.getCount()) {
					_log.log(Level.SEVERE, pc.getName()
							+ " tried to (elf) store " + count + " of "
							+ objectId + " but server has " + item.getCount()
							+ ".");
					ban(pc);
					return;
				}
				if (!item.getItem().isTradable()) {
					tradable = false;
					pc.sendPackets(new S_ServerMessage(210, item.getItem()
							.getName()));
				}
				Object[] petlist = pc.getPetList().values().toArray();
				for (Object petObject : petlist) {
					if (petObject instanceof L1PetInstance) {
						L1PetInstance pet = (L1PetInstance) petObject;
						if (item.getId() == pet.getItemObjId()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(210, item
									.getItem().getName()));
							break;
						}
					}
				}
				Object[] dolllist = pc.getDollList().values().toArray();
				for (Object dollObject : dolllist) {
					if (dollObject instanceof L1DollInstance) {
						L1DollInstance doll = (L1DollInstance) dollObject;
						if (item.getId() == doll.getItemObjId()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(1181));
							break;
						}
					}
				}
				if (pc.getDwarfForElfInventory().checkAddItemToWarehouse(item,
						count, L1Inventory.WAREHOUSE_TYPE_PERSONAL) == L1Inventory.SIZE_OVER) {
					pc.sendPackets(new S_ServerMessage(75));
					break;
				}
				if (tradable) {
					pc.getInventory().tradeItem(objectId, count,
							pc.getDwarfForElfInventory());
					pc.turnOnOffLight();
					L1ItemInstance pcitem = pc.getInventory().getItem(objectId);
					if (pcitem != null) {
						item_count_after = pcitem.getCount();
					}
					LogElfDwarfIn ledi = new LogElfDwarfIn();
					ledi.storeLogElfDwarfIn(pc, item, item_count_before,
							item_count_after, count);
				}
				pc.saveInventory();
			}
		} else if (resultType == 9 && size != 0
				&& npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5
				&& pc.isElf()) {
			int objectId, count;
			L1ItemInstance item;
			for (int i = 0; i < size; i++) {
				objectId = readD();
				count = readD();
				item = pc.getDwarfForElfInventory().getItem(objectId);
				int item_count_before = item.getCount();
				int item_count_after = 0;
				if (count > item.getCount()) {
					_log.log(Level.SEVERE, pc.getName()
							+ " tried to (elf) retrieve " + count + " of "
							+ objectId + " but server has " + item.getCount()
							+ ".");
					ban(pc);
					return;
				}
				if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
					if (pc.getInventory().consumeItem(40494, 2)) {
						pc.getDwarfForElfInventory().tradeItem(item, count,
								pc.getInventory());
						L1ItemInstance pcitem = pc.getDwarfForElfInventory()
								.getItem(objectId);
						if (pcitem != null) {
							item_count_after = pcitem.getCount();
						}
						LogElfDwarfOut ledo = new LogElfDwarfOut();
						ledo.storeLogElfDwarfOut(pc, item, item_count_before,
								item_count_after, count);
					} else {
						pc.sendPackets(new S_ServerMessage(337, "$767"));
						break;
					}
				} else {
					pc.sendPackets(new S_ServerMessage(270));
					break;
				}
			}
		} else if (resultType == 0 && size != 0 && isPrivateShop) { //private shop is selling an item
			int order;
			int count;
			int price;
			List<L1PrivateShopSellList> sellList;
			L1PrivateShopSellList pssl;
			int itemObjectId;
			int sellPrice;
			int sellTotalCount;
			int sellCount;
			L1ItemInstance item;
			boolean[] isRemoveFromList = new boolean[8];

			L1PcInstance targetPc = null;
			if (findObject instanceof L1PcInstance) {
				targetPc = (L1PcInstance) findObject;

			}
			if (targetPc.isTradingInPrivateShop()) {
				return;
			}
			sellList = targetPc.getSellList();
			synchronized (sellList) {
				if (pc.getPartnersPrivateShopItemCount() != sellList.size()) {
					return;
				}
				targetPc.setTradingInPrivateShop(true);
				String transactionId = UUID.randomUUID().toString();

				for (int i = 0; i < size; i++) {
					order = readD();
					count = readD();
					pssl = sellList.get(order);
					itemObjectId = pssl.getItemObjectId();
					sellPrice = pssl.getSellPrice();
					sellTotalCount = pssl.getSellTotalCount();
					sellCount = pssl.getSellCount();
					if (count > sellTotalCount - sellCount) {
						count = sellTotalCount - sellCount;
					}
					if (count > 1000 || count < 1) {
						pc.sendPackets(new S_SystemMessage("Temporary 1000 item limit."));
						continue;
					}
					item = targetPc.getInventory().getItem(itemObjectId);
					if (item == null) {
						continue;
					}
					int item_count_before = item.getCount();
					int item_count_after = 0;

					if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
						for (int j = 0; j < count; j++) {
							if (sellPrice * j > 2000000000) {
								pc.sendPackets(new S_ServerMessage(904,
										"2000000000"));
								targetPc.setTradingInPrivateShop(false);
								return;
							}
						}
						price = count * sellPrice;
						if (pc.getInventory().checkItem(L1ItemId.ADENA, price)) {
							L1ItemInstance adena = pc.getInventory()
									.findItemId(L1ItemId.ADENA);
							if (pc != null && targetPc != null && adena != null) {
								// log that trade has started
								LogPrivateShopBuy lpsb = new LogPrivateShopBuy();
								long itemTransactionId = lpsb.storeLogPrivateShopBuy(transactionId, pc, targetPc,
										item, item_count_before, count);
								
								if (targetPc.getInventory().tradeItem(item,
										count, pc.getInventory()) == null) {
									targetPc.setTradingInPrivateShop(false);
									return;
								}
								
								L1ItemInstance tpitem = targetPc.getInventory()
										.getItem(itemObjectId);
								if (tpitem != null) {
									item_count_after = tpitem.getCount();
								}
								
								// update trade to say it was completed
								lpsb.completeTransaction(itemTransactionId, item_count_before, item_count_after);
								
								int adena_before = adena.getCount();
								// log the start of the trade of the adena
								long adenaTransactionId = lpsb.storeLogPrivateShopBuy(transactionId, targetPc, pc,
										adena, adena_before, price);
								
								pc.getInventory().tradeItem(adena, price,
										targetPc.getInventory());
								
								int adena_after = 0;
								
								L1ItemInstance adenaItem = pc.getInventory().findItemId(L1ItemId.ADENA);
								if(adenaItem != null) {
									adena_after = adenaItem.getCount();
								}
								
								// update trade to say it was completed
								lpsb.completeTransaction(adenaTransactionId, adena_before, adena_after);
								
								String message = item.getItem().getName()
										+ " (" + String.valueOf(count) + ")";
								targetPc.sendPackets(new S_ServerMessage(877,
										pc.getName(), message));
								pssl.setSellCount(count + sellCount);
								sellList.set(order, pssl);
								if (pssl.getSellCount() == pssl
										.getSellTotalCount()) {
									isRemoveFromList[order] = true;
								}
							}
						} else {
							pc.sendPackets(new S_ServerMessage(189));
							break;
						}
					} else {
						pc.sendPackets(new S_ServerMessage(270));
						break;
					}
				}
				for (int i = 7; i >= 0; i--) {
					if (isRemoveFromList[i]) {
						sellList.remove(i);
					}
				}
				targetPc.setTradingInPrivateShop(false);
			}
		} else if (resultType == 1 && size != 0 && isPrivateShop) { // private shop buying an item
			int count;
			int order;
			List<L1PrivateShopBuyList> buyList;
			L1PrivateShopBuyList psbl;
			int itemObjectId;
			L1ItemInstance item;
			int buyPrice;
			int buyItemId;
			int buyEnchantLevel;
			int buyTotalCount;
			int buyCount;
			//unused
			//L1ItemInstance targetItem;
			boolean[] isRemoveFromList = new boolean[8];

			L1PcInstance targetPc = null;
			if (findObject instanceof L1PcInstance) {
				targetPc = (L1PcInstance) findObject;
			}
			if (targetPc.isTradingInPrivateShop()) {
				return;
			}
			targetPc.setTradingInPrivateShop(true);
			buyList = targetPc.getBuyList();
			String transactionId = UUID.randomUUID().toString();
			
			for (int i = 0; i < size; i++) {
				itemObjectId = readD();
				count = readCH();
				order = readC();
				item = pc.getInventory().getItem(itemObjectId);
				if (item == null) {
					continue;
				}
				psbl = buyList.get(order);
				buyPrice = psbl.getBuyPrice();
				buyTotalCount = psbl.getBuyTotalCount();
				buyCount = psbl.getBuyCount();
				buyItemId = psbl.getItemId();
				buyEnchantLevel = psbl.getItemEnchantLevel();
				
				if (item.getItemId() != buyItemId && item.getEnchantLevel() == buyEnchantLevel){
					if (Config.AUTO_BAN) {
						Account.ban(pc.getAccountName(), "AutoBan", "Result Shop Check Exploit Attempt");
						IpTable.getInstance().banIp(pc.getNetConnection().getIp());
					}
					_log.info(pc.getName() + " Attempted Private Shop Exploit (C_Result ObjectId).");
					L1World.getInstance().broadcastServerMessage(
							"Player " + pc.getName() + " Attempted A Private Shop exploit!");
					pc.sendPackets(new S_Disconnect());
					targetPc.setTradingInPrivateShop(false);
					return;
				}
								
				if (count > buyTotalCount - buyCount) {
					count = buyTotalCount - buyCount;
				}
				if (count > 1000 || count < 1) {
					pc.sendPackets(new S_SystemMessage("Temporary 1000 item limit."));
					continue;
				}

				if (item.isEquipped()) {
					pc.sendPackets(new S_ServerMessage(905));
					continue;
				}
				
				if (!item.isStackable() && count != 1){
					if (Config.AUTO_BAN) {
						Account.ban(pc.getAccountName(), "AutoBan", "Result Shop Check Exploit Attempt");
						IpTable.getInstance().banIp(pc.getNetConnection().getIp());
					}
					_log.info(pc.getName() + " Attempted Private Shop Exploit (C_Result Stackable).");
					L1World.getInstance().broadcastServerMessage(
							"Player " + pc.getName() + " Attempted A Private Shop exploit!");
					pc.sendPackets(new S_Disconnect());
					targetPc.setTradingInPrivateShop(false);
					return;
				}
				
				int item_count_before = item.getCount();
				int item_count_after = 0;

				if (targetPc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
					for (int j = 0; j < count; j++) {
						if (buyPrice * j > 2000000000) {
							targetPc.sendPackets(new S_ServerMessage(904,
									"2000000000"));
							return;
						}
					}
					if (targetPc.getInventory().checkItem(L1ItemId.ADENA,
							count * buyPrice)) {
						L1ItemInstance adena = targetPc.getInventory()
								.findItemId(L1ItemId.ADENA);
						if (pc != null && targetPc != null && adena != null) {
							
							// log that trade has started
							LogPrivateShopSell lpss = new LogPrivateShopSell();
							long itemTransactionId = lpss.storeLogPrivateShopSell(transactionId, pc, targetPc,
									item, item_count_before, count);
							
							if (pc.getInventory().tradeItem(item, count,
									targetPc.getInventory()) == null) {
								targetPc.setTradingInPrivateShop(false);
								return;
							}
							
							L1ItemInstance pcitem = pc.getInventory().getItem(
									itemObjectId);
							if (pcitem != null) {
								item_count_after = pcitem.getCount();
							}

							// update trade to say it was completed
							lpss.completeTransaction(itemTransactionId, item_count_before, item_count_after);
							
							int adena_before = adena.getCount();
							// log the start of the trade of the adena
							long adenaTransactionId = lpss.storeLogPrivateShopSell(transactionId, targetPc, pc,
									adena, adena_before, count);
							
							// log that the adena trade has started
							targetPc.getInventory().tradeItem(adena,
									count * buyPrice, pc.getInventory());
							
							int adena_after = 0;
							
							L1ItemInstance adenaItem = targetPc.getInventory().findItemId(L1ItemId.ADENA);
							if(adenaItem != null) {
								adena_after = adenaItem.getCount();
							}
							
							// update trade to say it was completed
							lpss.completeTransaction(adenaTransactionId, adena_before, adena_after);
							
							psbl.setBuyCount(count + buyCount);
							buyList.set(order, psbl);
							if (psbl.getBuyCount() == psbl.getBuyTotalCount()) {
								isRemoveFromList[order] = true;
							}
						}
					} else {
						targetPc.sendPackets(new S_ServerMessage(189));
						break;
					}
				} else {
					pc.sendPackets(new S_ServerMessage(271));
					break;
				}
			}
			for (int i = 7; i >= 0; i--) {
				if (isRemoveFromList[i]) {
					buyList.remove(i);
				}
			}
			targetPc.setTradingInPrivateShop(false);
		}
	}

	@Override
	public String getType() {
		return C_RESULT;
	}
}