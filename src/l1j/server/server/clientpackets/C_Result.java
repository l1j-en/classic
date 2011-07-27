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

import java.util.ArrayList;
import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.ShopTable;
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
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1PrivateShopBuyList;
import l1j.server.server.templates.L1PrivateShopSellList;

public class C_Result extends ClientBasePacket {

	private static Logger _log = Logger.getLogger(C_Result.class.getName());
	private static final String C_RESULT = "[C] C_Result";

	public C_Result(byte abyte0[], ClientThread clientthread) throws Exception {
		super(abyte0);
		int npcObjectId = readD();
		int resultType = readC();
		int size = readC();
		int unknown = readC();

		L1PcInstance pc = clientthread.getActiveChar();
		int level = pc.getLevel();

		int npcId = 0;
		String npcImpl = "";
		boolean isPrivateShop = false;
		boolean tradable = true;
		L1Object findObject = L1World.getInstance().findObject(npcObjectId);
		if (findObject != null) {
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

		if (resultType == 0 && size != 0 && npcImpl.equalsIgnoreCase("L1Merchant")) {
			L1Shop shop = ShopTable.getInstance().get(npcId);
			L1ShopBuyOrderList orderList = shop.newBuyOrderList();
			for (int i = 0; i < size; i++) {
				orderList.add(readD(), readD());
			}
			shop.sellItems(pc, orderList);
		} else if (resultType == 1 && size != 0 && npcImpl.equalsIgnoreCase("L1Merchant")) { 
			L1Shop shop = ShopTable.getInstance().get(npcId);
			L1ShopSellOrderList orderList = shop.newSellOrderList(pc);
			for (int i = 0; i < size; i++) {
				orderList.add(readD(), readD());
			}
			shop.buyItems(orderList);
		} else if (resultType == 2 && size != 0 && npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5) { 
			int objectId, count;
			for (int i = 0; i < size; i++) {
				tradable = true;
				objectId = readD();
				count = readD();
				L1Object object = pc.getInventory().getItem(objectId);
				L1ItemInstance item = (L1ItemInstance) object;
				if (!item.getItem().isTradable()) {
					tradable = false;
					pc.sendPackets(new S_ServerMessage(210, item.getItem().getName())); 
				}
				Object[] petlist = pc.getPetList().values().toArray();
				for (Object petObject : petlist) {
					if (petObject instanceof L1PetInstance) {
						L1PetInstance pet = (L1PetInstance) petObject;
						if (item.getId() == pet.getItemObjId()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
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
				if (pc.getDwarfInventory().checkAddItemToWarehouse(item, count, L1Inventory.WAREHOUSE_TYPE_PERSONAL) == L1Inventory.SIZE_OVER) {
					pc.sendPackets(new S_ServerMessage(75));
					break;
				}
				if (tradable) {
					pc.getInventory().tradeItem(objectId, count, pc.getDwarfInventory());
					pc.turnOnOffLight();
				}
			}
		} else if (resultType == 3 && size != 0 && npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5) {
			int objectId, count;
			L1ItemInstance item;
			for (int i = 0; i < size; i++) {
				objectId = readD();
				count = readD();
				item = pc.getDwarfInventory().getItem(objectId);
				if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) 
				{
					if (pc.getInventory().consumeItem(L1ItemId.ADENA, 30)) {
						pc.getDwarfInventory().tradeItem(item, count, pc.getInventory());
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
					L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
					L1Object object = pc.getInventory().getItem(objectId);
					L1ItemInstance item = (L1ItemInstance) object;
					if (clan != null) {
						if (!item.getItem().isTradable()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
						}
						if (item.getBless() >= 128) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
						}
						Object[] petlist = pc.getPetList().values().toArray();
						for (Object petObject : petlist) {
							if (petObject instanceof L1PetInstance) {
								L1PetInstance pet = (L1PetInstance) petObject;
								if (item.getId() == pet.getItemObjId()) {
									tradable = false;
									pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
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
						if (clan.getDwarfForClanInventory().checkAddItemToWarehouse(item, count, L1Inventory.WAREHOUSE_TYPE_CLAN) == L1Inventory.SIZE_OVER) {
							pc.sendPackets(new S_ServerMessage(75));
							break;
						}
						if (tradable) {
							pc.getInventory().tradeItem(objectId, count, clan.getDwarfForClanInventory());
							pc.turnOnOffLight();
						}
					}
				}
			} else {
				pc.sendPackets(new S_ServerMessage(208)); 
			}
		} else if (resultType == 5 && size != 0 && npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5) { 
			int objectId, count;
			L1ItemInstance item;

			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				for (int i = 0; i < size; i++) {
					objectId = readD();
					count = readD();
					item = clan.getDwarfForClanInventory().getItem(objectId);
					if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) { 
						if (pc.getInventory().consumeItem(L1ItemId.ADENA, 30)) {
							clan.getDwarfForClanInventory().tradeItem(item, count, pc.getInventory());
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
		} else if (resultType == 8 && size != 0 && npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5 && pc.isElf()) {
			int objectId, count;
			for (int i = 0; i < size; i++) {
				tradable = true;
				objectId = readD();
				count = readD();
				L1Object object = pc.getInventory().getItem(objectId);
				L1ItemInstance item = (L1ItemInstance) object;
				if (!item.getItem().isTradable()) {
					tradable = false;
					pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
				}
				Object[] petlist = pc.getPetList().values().toArray();
				for (Object petObject : petlist) {
					if (petObject instanceof L1PetInstance) {
						L1PetInstance pet = (L1PetInstance) petObject;
						if (item.getId() == pet.getItemObjId()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
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
				if (pc.getDwarfForElfInventory().checkAddItemToWarehouse(item, count, L1Inventory.WAREHOUSE_TYPE_PERSONAL) == L1Inventory.SIZE_OVER) {
					pc.sendPackets(new S_ServerMessage(75));
					break;
				}
				if (tradable) {
					pc.getInventory().tradeItem(objectId, count, pc.getDwarfForElfInventory());
					pc.turnOnOffLight();
				}
			}
		} else if (resultType == 9 && size != 0 && npcImpl.equalsIgnoreCase("L1Dwarf") && level >= 5 && pc.isElf()) {
			int objectId, count;
			L1ItemInstance item;
			for (int i = 0; i < size; i++) {
				objectId = readD();
				count = readD();
				item = pc.getDwarfForElfInventory().getItem(objectId);
				if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
					if (pc.getInventory().consumeItem(40494, 2)) {
						pc.getDwarfForElfInventory().tradeItem(item, count, pc.getInventory());
					} else {
						pc.sendPackets(new S_ServerMessage(337,"$767"));
						break;
					}
				} else {
					pc.sendPackets(new S_ServerMessage(270));
					break;
				}
			}
		} else if (resultType == 0 && size != 0 && isPrivateShop) {
			int order;
			int count;
			int price;
			ArrayList sellList;
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
				if (targetPc == null) {
					return;
				}
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

				for (int i = 0; i < size; i++) { 
					order = readD();
					count = readD();
					pssl = (L1PrivateShopSellList) sellList.get(order);
					itemObjectId = pssl.getItemObjectId();
					sellPrice = pssl.getSellPrice();
					sellTotalCount = pssl.getSellTotalCount(); 
					sellCount = pssl.getSellCount(); 
					item = targetPc.getInventory().getItem(itemObjectId);
					if (item == null) {
						continue;
					}
					if (count > sellTotalCount - sellCount) {
						count = sellTotalCount - sellCount;
					}
					if (count == 0) {
						continue;
					}
					if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
						for (int j = 0; j < count; j++) {
							if (sellPrice * j > 2000000000) {
								pc.sendPackets(new S_ServerMessage(904, "2000000000"));
								targetPc.setTradingInPrivateShop(false);
								return;
							}
						}
						price = count * sellPrice;
						if (pc.getInventory().checkItem(L1ItemId.ADENA, price)) {
							L1ItemInstance adena = pc.getInventory().findItemId(L1ItemId.ADENA);
							if (targetPc != null && adena != null) {
								if (targetPc.getInventory().tradeItem(item, count, pc.getInventory()) == null) {
									targetPc.setTradingInPrivateShop(false);
									return;
								}
								pc.getInventory().tradeItem(adena, price, targetPc.getInventory());
								String message = item.getItem().getName() + " (" + String.valueOf(count) + ")";
								targetPc.sendPackets(new S_ServerMessage(877, pc.getName(), message));
								pssl.setSellCount(count + sellCount);
								sellList.set(order, pssl);
								if (pssl.getSellCount() == pssl.getSellTotalCount()) { 
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
		} else if (resultType == 1 && size != 0 && isPrivateShop) {
			int count;
			int order;
			ArrayList buyList;
			L1PrivateShopBuyList psbl;
			int itemObjectId;
			L1ItemInstance item;
			int buyPrice;
			int buyTotalCount;
			int buyCount;
			L1ItemInstance targetItem;
			boolean[] isRemoveFromList = new boolean[8];

			L1PcInstance targetPc = null;
			if (findObject instanceof L1PcInstance) {
				targetPc = (L1PcInstance) findObject;
				if (targetPc == null) {
					return;
				}
			}
			if (targetPc.isTradingInPrivateShop()) {
				return;
			}
			targetPc.setTradingInPrivateShop(true);
			buyList = targetPc.getBuyList();

			for (int i = 0; i < size; i++) {
				itemObjectId = readD();
				count = readCH();
				order = readC();
				item = pc.getInventory().getItem(itemObjectId);
				if (item == null) {
					continue;
				}
				psbl = (L1PrivateShopBuyList) buyList.get(order);
				buyPrice = psbl.getBuyPrice();
				buyTotalCount = psbl.getBuyTotalCount(); 
				buyCount = psbl.getBuyCount();
				if (count > buyTotalCount - buyCount) {
					count = buyTotalCount - buyCount;
				}
				if (item.isEquipped()) {
					pc.sendPackets(new S_ServerMessage(905)); 
					continue;
				}

				if (targetPc.getInventory().checkAddItem(item, count) == L1Inventory.OK) { 
					for (int j = 0; j < count; j++) { 
						if (buyPrice * j > 2000000000) {
							targetPc.sendPackets(new S_ServerMessage(904, "2000000000"));
							return;
						}
					}
					if (targetPc.getInventory().checkItem(L1ItemId.ADENA,
							count * buyPrice)) {
						L1ItemInstance adena = targetPc.getInventory().findItemId(L1ItemId.ADENA);
						if (adena != null) {
							targetPc.getInventory().tradeItem(adena, count * buyPrice, pc.getInventory());
							pc.getInventory().tradeItem(item, count, targetPc.getInventory());
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