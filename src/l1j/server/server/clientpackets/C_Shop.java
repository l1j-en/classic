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
import java.util.logging.Logger;
import l1j.server.server.Account;
import l1j.server.server.model.L1World;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.ActionCodes;
import l1j.server.server.ClientThread;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_DoActionShop;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1PrivateShopBuyList;
import l1j.server.server.templates.L1PrivateShopSellList;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_Shop extends ClientBasePacket {

	private static final String C_SHOP = "[C] C_Shop";
	private static Logger _log = Logger.getLogger(C_Shop.class.getName());

	public C_Shop(byte abyte0[], ClientThread clientthread) {
		super(abyte0);

		L1PcInstance pc = clientthread.getActiveChar();
		if (pc.isGhost()) {
			return;
		}
		// additional dupe checks. Thanks Mike
		if (pc.getOnlineStatus() != 1) {
			Account.ban(pc.getAccountName());
			IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_Shop).");
			L1World.getInstance().broadcastServerMessage(
					"Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}
		int mapId = pc.getMapId();
		if (mapId != 340 && mapId != 350 && mapId != 360 && mapId != 370) {
			pc.sendPackets(new S_ServerMessage(876));
			return;
		}

		List sellList = pc.getSellList();
		List buyList = pc.getBuyList();
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
				// TRICIDTODO: Set configurable autoban
				if (sellObjectId != checkItem.getId()
						|| (!checkItem.isStackable() && sellCount != 1)
						|| checkItem.getCount() <= 0 || sellCount <= 0
						|| sellCount > 2000000000
						|| sellCount > checkItem.getCount()) {
					Account.ban(pc.getAccountName());
					IpTable.getInstance().banIp(pc.getNetConnection().getIp());
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
				// removed some checks that don't make sense here
				// just commented them out to test for now
				if (buyObjectId != checkItem.getId() || /*
														 * buyCount >
														 * checkItem.getCount
														 * ()||
														 * (!checkItem.isStackable
														 * () && buyCount != 1)
														 * ||
														 * checkItem.getCount()
														 * <= 0 ||
														 */buyCount <= 0
						|| buyCount > 2000000000) {
					Account.ban(pc.getAccountName());
					IpTable.getInstance().banIp(pc.getNetConnection().getIp());
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
				buyList.add(psbl);
			}
			if (!tradable) {
				sellList.clear();
				buyList.clear();
				pc.setPrivateShop(false);
				pc.sendPackets(new S_DoActionGFX(pc.getId(),
						ActionCodes.ACTION_Idle));
				pc.broadcastPacket(new S_DoActionGFX(pc.getId(),
						ActionCodes.ACTION_Idle));
				return;
			}
			byte[] chat = readByte();
			pc.setShopChat(chat);
			pc.setPrivateShop(true);
			pc.sendPackets(new S_DoActionShop(pc.getId(),
					ActionCodes.ACTION_Shop, chat));
			pc.broadcastPacket(new S_DoActionShop(pc.getId(),
					ActionCodes.ACTION_Shop, chat));
		} else if (type == 1) {
			sellList.clear();
			buyList.clear();
			pc.setPrivateShop(false);
			pc.sendPackets(new S_DoActionGFX(pc.getId(),
					ActionCodes.ACTION_Idle));
			pc.broadcastPacket(new S_DoActionGFX(pc.getId(),
					ActionCodes.ACTION_Idle));
		}
	}

	@Override
	public String getType() {
		return C_SHOP;
	}
}
