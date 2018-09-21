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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.log.LogPickUpItem;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_AttackPacket;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_ServerMessage;

public class C_PickUpItem extends ClientBasePacket {

	private static final String C_PICK_UP_ITEM = "[C] C_PickUpItem";
	private static Logger _log = LoggerFactory.getLogger(C_PickUpItem.class.getName());

	public C_PickUpItem(byte decrypt[], Client client) throws Exception {
		super(decrypt);
		int x = readH();
		int y = readH();
		int objectId = readD();
		int pickupCount = readD();

		L1PcInstance pc = client.getActiveChar();
		// additional dupe checks. Thanks Mike
		if (pc.getOnlineStatus() != 1) {
			if (Config.AUTO_BAN) {
				Account.ban(pc.getAccountName(), "AutoBan", "PickUpItem Dupe Check Player Offline");
				IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			}
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_PickUpItem).");
			L1World.getInstance().broadcastServerMessage(
					"Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}
		// TRICIDTODO: Set configurable auto ban
		if (pickupCount < 0) {
			if (Config.AUTO_BAN) {
				Account.ban(pc.getAccountName(), "AutoBan", "PickUpItem Dupe Check Overflow Attempt");
				IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			}
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_PickUpItem).");
			L1World.getInstance().broadcastServerMessage(
					"Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}

		if (pc.isDead() || pc.isGhost()) {
			return;
		}

		if (pc.isInvisble()) {
			return;
		}

		if (pc.isInvisDelay()) {
			return;
		}

		L1Inventory groundInventory = L1World.getInstance().getInventory(x, y,
				pc.getMapId());
		L1Object object = groundInventory.getItem(objectId);

		if (object != null && !pc.isDead()) {
			L1ItemInstance item = (L1ItemInstance) object;
			if ((!item.isStackable() && pickupCount != 1)
					|| item.getCount() <= 0 || pickupCount <= 0
					|| pickupCount > 2000000000
					|| pickupCount > item.getCount()) {
				if (Config.AUTO_BAN) {
					Account.ban(pc.getAccountName(), "AutoBan", "PickUpItem Dupe Check Count Mixup");
					IpTable.getInstance().banIp(pc.getNetConnection().getIp());
				}
				_log.info(pc.getName()
						+ " Attempted Dupe Exploit (C_PickUpItem).");
				L1World.getInstance()
						.broadcastServerMessage(
								"Player " + pc.getName()
										+ " Attempted A Dupe exploit!");
				pc.sendPackets(new S_Disconnect());
				return;
			}
			if (objectId != item.getId()) {
				_log.warn(pc.getName() + " had item "
						+ Integer.toString(objectId) + " not match.");
			}

			if (item.getItemOwnerId() != 0
					&& pc.getId() != item.getItemOwnerId()) {
				pc.sendPackets(new S_ServerMessage(623));
				return;
			}

			if (pc.getLocation().getTileLineDistance(item.getLocation()) > 3) {
				return;
			}

			if (item.getItem().getItemId() == L1ItemId.ADENA) {
				L1ItemInstance inventoryItem = pc.getInventory().findItemId(
						L1ItemId.ADENA);
				int inventoryItemCount = 0;
				if (inventoryItem != null) {
					inventoryItemCount = inventoryItem.getCount();
				}

				if ((long) inventoryItemCount + (long) pickupCount > 2000000000L) {
					pc.sendPackets(new S_ServerMessage(166,
							"You Cannot Carry More Than 2,000,000,000 Of An Item."));
					return;
				}
			}
			if (pc.getInventory().checkAddItem(item, pickupCount) == L1Inventory.OK) {
				if (item.getX() != 0 && item.getY() != 0) {
					L1ItemInstance pcitem = pc.getInventory().getItem(objectId);
					int before_inven = 0;
					if (item.isStackable()) {
						before_inven = pc.getInventory().countItems(
								item.getItem().getItemId());
					} else {
						if (pcitem != null) {
							before_inven = pcitem.getCount();
						}
					}
					int brfore_ground = groundInventory.getItem(objectId)
							.getCount();
					groundInventory.tradeItem(item, pickupCount,
							pc.getInventory());
					pc.turnOnOffLight();
					int after_inven = 0;
					if (item.isStackable()) {
						after_inven = pc.getInventory().countItems(
								item.getItem().getItemId());
					} else {
						after_inven = pc.getInventory().getItem(objectId)
								.getCount();
					}
					L1ItemInstance gditem = groundInventory.getItem(objectId);
					int after_ground = 0;
					if (gditem != null) {
						after_ground = groundInventory.getItem(objectId)
								.getCount();
					}
					LogPickUpItem lpui = new LogPickUpItem();
					lpui.storeLogPickUpItem(pc, item, before_inven,
							after_inven, brfore_ground, after_ground,
							pickupCount);
					pc.sendPackets(new S_AttackPacket(pc, objectId,
							ActionCodes.ACTION_Pickup));
					if (!pc.isGmInvis()) {
						pc.broadcastPacket(new S_AttackPacket(pc, objectId,
								ActionCodes.ACTION_Pickup));
					}
				}
			}
		}
	}

	@Override
	public String getType() {
		return C_PICK_UP_ITEM;
	}
}
