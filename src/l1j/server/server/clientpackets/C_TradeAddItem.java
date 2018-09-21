/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be trading_partnerful,
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
import l1j.server.server.datatables.IpTable;
import l1j.server.server.log.LogTradeBugItem;
import l1j.server.server.model.L1CheckPcItem;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Trade;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_TradeAddItem extends ClientBasePacket {
	private static final String C_TRADE_ADD_ITEM = "[C] C_TradeAddItem";
	private static Logger _log = LoggerFactory.getLogger(C_TradeAddItem.class
			.getName());

	public C_TradeAddItem(byte abyte0[], Client client) throws Exception {
		super(abyte0);

		int itemid = readD();
		int itemcount = readD();
		L1PcInstance pc = client.getActiveChar();
		L1PcInstance target = (L1PcInstance) L1World.getInstance().findObject(
				pc.getTradeID());
		// additional dupe checks. Thanks Mike
		if (pc.getOnlineStatus() != 1) {
			if (Config.AUTO_BAN) {
				Account.ban(pc.getAccountName(), "AutoBan", "TradeAddItem Dupe Check Player Offline");
				IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			}
			_log.info(pc.getName()
					+ " Attempted Dupe Exploit (C_TradeAddItem).");
			L1World.getInstance().broadcastServerMessage(
					"Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}
		L1ItemInstance item = pc.getInventory().getItem(itemid);
		// TRICIDTODO: set configurable autoban
		if ((!item.isStackable() && itemcount != 1) || item.getCount() <= 0
				|| itemcount <= 0 || itemcount > 2000000000
				|| itemcount > item.getCount()) {
			if (Config.AUTO_BAN) {
				Account.ban(pc.getAccountName(), "AutoBan", "TradeAddItem Dupe Check Count Mixup");
				IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			}
			_log.info(pc.getName()
					+ " Attempted Dupe Exploit (C_TradeAddItem).");
			L1World.getInstance().broadcastServerMessage(
					"Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}
		if (itemid != item.getId()) {
			_log.warn(pc.getName() + " had item " + Integer.toString(itemid)
					+ " not match.");
		}
		L1Trade trade = new L1Trade();
		L1CheckPcItem checkPcItem = new L1CheckPcItem();
		boolean isCheat = checkPcItem.checkPcItem(item, pc);
		if (isCheat) {
			LogTradeBugItem ltbi = new LogTradeBugItem();
			ltbi.storeLogTradeBugItem(pc, target, item);
			return;
		}

		if (!item.getItem().isTradable()) {
			pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
			return;
		}

		if (item.getBless() >= 128) {
			pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
			return;
		}
		Object[] petlist = pc.getPetList().values().toArray();
		for (Object petObject : petlist) {
			if (petObject instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) petObject;
				if (item.getId() == pet.getItemObjId()) {
					pc.sendPackets(new S_ServerMessage(210, item.getItem()
							.getName()));
					return;
				}
			}
		}
		L1PcInstance tradingPartner = (L1PcInstance) L1World.getInstance()
				.findObject(pc.getTradeID());

		if (tradingPartner == null) {
			return;
		}

		if (pc.getTradeOk()) {
			return;
		}

		if (tradingPartner.getInventory().checkAddItem(item, itemcount) != L1Inventory.OK) {
			tradingPartner.sendPackets(new S_ServerMessage(270));
			pc.sendPackets(new S_ServerMessage(271));
			return;
		}
		if (isCheat) {
			LogTradeBugItem ltbi = new LogTradeBugItem();
			ltbi.storeLogTradeBugItem(tradingPartner, pc, item);
			return;
		}
		trade.TradeAddItem(pc, itemid, itemcount);
	}

	@Override
	public String getType() {
		return C_TRADE_ADD_ITEM;
	}
}
