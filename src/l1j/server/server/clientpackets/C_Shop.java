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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_DoActionShop;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1PrivateShopBuyList;
import l1j.server.server.templates.L1PrivateShopSellList;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_Shop extends ClientBasePacket {

	private static final String C_SHOP = "[C] C_Shop";
	private static Logger _log = LoggerFactory.getLogger(C_Shop.class.getName());

	public C_Shop(byte abyte0[], Client client) {
		super(abyte0);

		L1PcInstance pc = client.getActiveChar();
		if (pc.isGhost()) {
			return;
		}
		// additional dupe checks. Thanks Mike
		if (pc.getOnlineStatus() != 1) {
			if(Config.AUTO_BAN) {
				Account.ban(pc.getAccountName(), "AutoBan", "Shop Dupe Check Player Offline");
				IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			}
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_Shop).");
			L1World.getInstance().broadcastServerMessage(
					"Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}
		
		List<L1PrivateShopSellList> sellList = pc.getSellList();
		List<L1PrivateShopBuyList> buyList = pc.getBuyList();
		
		if (!pc.getMap().isTradeZone()) {
			// if somehow they got out of the zone, 
			// disable private shop
			if(pc.isPrivateShop()) {
				stopShop(pc, sellList, buyList);
				return;
			}
				
			
			pc.sendPackets(new S_ServerMessage(876));
			return;
		}

		L1ItemInstance checkItem;
		boolean tradable = true;

		int type = readC();
		if (type == 0) {
			int sellTotalCount = readH();
			int sellObjectId;
			int sellPrice;
			int sellCount;
			for (int i = 0; i < sellTotalCount; i++) {
				sellObjectId = readD();
				sellPrice = readD();
				sellCount = readD();
				checkItem = pc.getInventory().getItem(sellObjectId);
				
				if (sellObjectId != checkItem.getId()
						|| (!checkItem.isStackable() && sellCount != 1)
						|| checkItem.getCount() <= 0 || sellCount <= 0
						|| sellCount > 2000000000
						|| sellCount > checkItem.getCount()) {
					if(Config.AUTO_BAN) {
						Account.ban(pc.getAccountName(), "AutoBan", "Shop Dupe Check Count Mixup SellList");
						IpTable.getInstance().banIp(pc.getNetConnection().getIp());
					}
					_log.info(pc.getName()
							+ " Attempted Dupe Exploit (C_Shop).");
					L1World.getInstance().broadcastServerMessage(
							"Player " + pc.getName()
									+ " Attempted A Dupe exploit!");
					pc.sendPackets(new S_Disconnect());
					return;
				}

				if (!checkItem.getItem().isTradable()) {
					tradable = false;
					pc.sendPackets(new S_ServerMessage(166, checkItem.getItem()
							.getName(), "Ready"));
				}
				Object[] petlist = pc.getPetList().values().toArray();
				for (Object petObject : petlist) {
					if (petObject instanceof L1PetInstance) {
						L1PetInstance pet = (L1PetInstance) petObject;
						if (checkItem.getId() == pet.getItemObjId()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(166, checkItem
									.getItem().getName(), "Ready"));
							break;
						}
					}
				}
				L1PrivateShopSellList pssl = new L1PrivateShopSellList();
				pssl.setItemObjectId(sellObjectId);
				pssl.setSellPrice(sellPrice);
				pssl.setSellTotalCount(sellCount);
				sellList.add(pssl);
			}
			int buyTotalCount = readH();
			int buyObjectId;
			int buyPrice;
			int buyCount;
			for (int i = 0; i < buyTotalCount; i++) {
				buyObjectId = readD();
				buyPrice = readD();
				buyCount = readD();
				checkItem = pc.getInventory().getItem(buyObjectId);
				
				if (buyObjectId != checkItem.getId() || buyCount <= 0
						|| buyCount > 2000000000 || buyPrice <= 0
						|| buyPrice > 2000000000) {
					if(Config.AUTO_BAN) {
						Account.ban(pc.getAccountName(), "AutoBan", "Shop Dupe Check Count Mixup BuyList");
						IpTable.getInstance().banIp(pc.getNetConnection().getIp());
					}
					
					_log.info(pc.getName()
							+ " Attempted Dupe Exploit (C_Shop).");
					L1World.getInstance().broadcastServerMessage(
							"Player " + pc.getName()
									+ " Attempted A Dupe exploit!");
					pc.sendPackets(new S_Disconnect());
					return;
				}

				if (!checkItem.getItem().isTradable()) {
					tradable = false;
					pc.sendPackets(new S_ServerMessage(166, checkItem.getItem()
							.getName(), "Ready"));
				}
				if (checkItem.getBless() >= 128) {
					pc.sendPackets(new S_ServerMessage(210, checkItem.getItem()
							.getName()));
					return;
				}
				Object[] petlist = pc.getPetList().values().toArray();
				for (Object petObject : petlist) {
					if (petObject instanceof L1PetInstance) {
						L1PetInstance pet = (L1PetInstance) petObject;
						if (checkItem.getId() == pet.getItemObjId()) {
							tradable = false;
							pc.sendPackets(new S_ServerMessage(166, checkItem
									.getItem().getName(), "Ready"));
							break;
						}
					}
				}
				L1PrivateShopBuyList psbl = new L1PrivateShopBuyList();
				psbl.setItemObjectId(buyObjectId);
				psbl.setBuyPrice(buyPrice);
				psbl.setBuyTotalCount(buyCount);
				psbl.setItemId(checkItem.getItemId());
				psbl.setItemEnchantLevel(checkItem.getEnchantLevel());
				buyList.add(psbl);
			}
			if (!tradable) {
				stopShop(pc, sellList, buyList);
				return;
			}
			
			// some players have been able to list more than 8 items, 
			// so this check will kick them if they are able to
			if(buyList.size() > 8 || sellList.size() > 8) {
				int buyCountLog = buyList.size();
				int sellCountLog = sellList.size();
				
				stopShop(pc, sellList, buyList);
				_log.warn(
						String.format("Character '%s' attempted to add more than 8 items to sell/buy shop. " + 
								"Disconnecting user. Sell Count: %d, Buy Count: %d",
								pc.getName(), sellCountLog, buyCountLog));
				pc.sendPackets(new S_Disconnect());
			}
			
			byte[] chat = readByte();
			pc.setShopChat(chat);
			pc.setPrivateShop(true);
			pc.sendPackets(new S_DoActionShop(pc.getId(),
					ActionCodes.ACTION_Shop, chat));
			pc.broadcastPacket(new S_DoActionShop(pc.getId(),
					ActionCodes.ACTION_Shop, chat));
		} else if (type == 1) {
			stopShop(pc, sellList, buyList);
		}
	}
	
	private void stopShop(L1PcInstance pc, List<L1PrivateShopSellList> sellList, 
			List<L1PrivateShopBuyList> buyList) {
		sellList.clear();
		buyList.clear();
		pc.setPrivateShop(false);
		pc.sendPackets(new S_DoActionGFX(pc.getId(),
				ActionCodes.ACTION_Idle));
		pc.broadcastPacket(new S_DoActionGFX(pc.getId(),
				ActionCodes.ACTION_Idle));
	}

	@Override
	public String getType() {
		return C_SHOP;
	}
}
