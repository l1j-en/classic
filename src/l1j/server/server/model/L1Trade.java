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
package l1j.server.server.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.log.LogTradeAddItem;
import l1j.server.server.log.LogTradeComplete;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_TradeAddItem;
import l1j.server.server.serverpackets.S_TradeStatus;

// Referenced classes of package l1j.server.server.model:
// L1Trade

public class L1Trade {
	private static L1Trade _instance;
	private static Logger _log = LoggerFactory.getLogger(L1Trade.class.getName());

	public L1Trade() {
	}

	public static L1Trade getInstance() {
		if (_instance == null) {
			_instance = new L1Trade();
		}
		return _instance;
	}

	public void TradeAddItem(L1PcInstance player, int itemid, int itemcount) {
		L1PcInstance trading_partner = (L1PcInstance) L1World.getInstance()
				.findObject(player.getTradeID());
		L1ItemInstance l1iteminstance = player.getInventory().getItem(itemid);
		if (l1iteminstance != null && trading_partner != null) {
			if (!l1iteminstance.isEquipped()) {
				int itembefore = player.getInventory().countItems(
						l1iteminstance.getItem().getItemId());
				if (l1iteminstance.getCount() < itemcount || 0 > itemcount) {
					player.sendPackets(new S_TradeStatus(1));
					trading_partner.sendPackets(new S_TradeStatus(1));
					player.setTradeOk(false);
					trading_partner.setTradeOk(false);
					player.setTradeID(0);
					trading_partner.setTradeID(0);
					return;
				}
				player.getInventory().tradeItem(l1iteminstance, itemcount,
						player.getTradeWindowInventory());
				player.sendPackets(new S_TradeAddItem(l1iteminstance,
						itemcount, 0));
				trading_partner.sendPackets(new S_TradeAddItem(l1iteminstance,
						itemcount, 1));
				int itemafter = player.getInventory().countItems(
						l1iteminstance.getItem().getItemId());
				LogTradeAddItem ltai = new LogTradeAddItem();
				ltai.storeLogTradeAddItem(player, trading_partner,
						l1iteminstance, itembefore, itemafter, itemcount);
			}
		}
	}

	public void TradeOK(L1PcInstance player) {
		int cnt;
		L1PcInstance trading_partner = (L1PcInstance) L1World.getInstance()
				.findObject(player.getTradeID());

		if (trading_partner != null && player != null) {
			List<L1ItemInstance> player_tradelist = player.getTradeWindowInventory().getItems();
			int player_tradecount = player.getTradeWindowInventory().getSize();

			List<L1ItemInstance> trading_partner_tradelist = trading_partner
					.getTradeWindowInventory().getItems();
			int trading_partner_tradecount = trading_partner
					.getTradeWindowInventory().getSize();

			for (cnt = 0; cnt < player_tradecount; cnt++) {
				L1ItemInstance l1iteminstance1 = player_tradelist.get(0);
				int itembeforeinven = player.getInventory().countItems(
						l1iteminstance1.getItem().getItemId());
				L1ItemInstance transfer_item = player.getTradeWindowInventory().tradeItem(l1iteminstance1,
						l1iteminstance1.getCount(),
						trading_partner.getInventory());
				
				if(transfer_item == null) {
					_log.warn(String.format("Player %s tried to trade with player %s for item %s (%d) but it failed!",
							player.getName(),
							trading_partner.getName(),
							l1iteminstance1.getName(), 
							l1iteminstance1.getCount()));
				} else {
					int itemafter = player.getInventory().countItems(
							l1iteminstance1.getItem().getItemId());
					LogTradeComplete ltc = new LogTradeComplete();
					ltc.storeLogTradeComplete(player, trading_partner,
							l1iteminstance1, player_tradecount, itembeforeinven,
							itemafter, player_tradecount);
				}
			}
			
			for (cnt = 0; cnt < trading_partner_tradecount; cnt++) {
				L1ItemInstance l1iteminstance2 = trading_partner_tradelist.get(0);
				int itembeforeinven = player.getInventory().countItems(
						l1iteminstance2.getItem().getItemId());
				L1ItemInstance transfer_item = trading_partner.getTradeWindowInventory().tradeItem(
						l1iteminstance2, l1iteminstance2.getCount(),
						player.getInventory());
				
				
				if(transfer_item == null) {
					_log.warn(String.format("Player %s tried to trade with player %s for item %s (%d) but it failed!",
							trading_partner.getName(),
							player.getName(),
							l1iteminstance2.getName(), 
							l1iteminstance2.getCount()));
				} else {
					int itemafter = player.getInventory().countItems(
							l1iteminstance2.getItem().getItemId());
					LogTradeComplete ltc = new LogTradeComplete();
					ltc.storeLogTradeComplete(trading_partner, player,
							l1iteminstance2, trading_partner_tradecount,
							itembeforeinven, itemafter, trading_partner_tradecount);
				}
			}

			player.sendPackets(new S_TradeStatus(0));
			trading_partner.sendPackets(new S_TradeStatus(0));
			player.setTradeOk(false);
			trading_partner.setTradeOk(false);
			player.setTradeID(0);
			trading_partner.setTradeID(0);
			player.turnOnOffLight();
			trading_partner.turnOnOffLight();
		}
	}

	public void TradeCancel(L1PcInstance player) {
		int cnt;
		L1PcInstance trading_partner = (L1PcInstance) L1World.getInstance()
				.findObject(player.getTradeID());
		if (trading_partner != null) {
			List<L1ItemInstance> player_tradelist = player.getTradeWindowInventory().getItems();
			int player_tradecount = player.getTradeWindowInventory().getSize();

			List<L1ItemInstance> trading_partner_tradelist = trading_partner
					.getTradeWindowInventory().getItems();
			int trading_partner_tradecount = trading_partner
					.getTradeWindowInventory().getSize();

			for (cnt = 0; cnt < player_tradecount; cnt++) {
				L1ItemInstance l1iteminstance1 = player_tradelist.get(0);
				player.getTradeWindowInventory().tradeItem(l1iteminstance1,
						l1iteminstance1.getCount(), player.getInventory());
			}
			for (cnt = 0; cnt < trading_partner_tradecount; cnt++) {
				L1ItemInstance l1iteminstance2 = trading_partner_tradelist.get(0);
				trading_partner.getTradeWindowInventory().tradeItem(
						l1iteminstance2, l1iteminstance2.getCount(),
						trading_partner.getInventory());
			}

			player.sendPackets(new S_TradeStatus(1));
			trading_partner.sendPackets(new S_TradeStatus(1));
			player.setTradeOk(false);
			trading_partner.setTradeOk(false);
			player.setTradeID(0);
			trading_partner.setTradeID(0);
		}
	}
}
