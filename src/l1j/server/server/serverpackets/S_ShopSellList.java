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
package l1j.server.server.serverpackets;

import java.io.IOException;
import java.util.List;

import l1j.server.Config;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.ShopTable;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1TaxCalculator;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.shop.L1Shop;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1ShopItem;

public class S_ShopSellList extends ServerBasePacket {
	/**
	 * A list of goods store. BUY character and send button.
	 */
	public S_ShopSellList(L1PcInstance pc) {
		writeC(Opcodes.S_OPCODE_SHOWSHOPBUYLIST);
		writeD(pc.getId());
		
		L1Shop shop = ShopTable.getInstance().get(pc.getId());
		List<L1ShopItem> shopItems = shop.getSellingItems();
		writeH(shopItems.size());
		
		L1ItemInstance dummy = new L1ItemInstance();
		for (int i = 0; i < shopItems.size(); i++) {
			L1ShopItem shopItem = shopItems.get(i);
			L1Item item = shopItem.getItem();
			
			writeD(i);
			writeH(shopItem.getItem().getGfxId());
			writeD(0);
			
			if (shopItem.getPackCount() > 1) {
				writeS(item.getName() + " (" + shopItem.getPackCount() + ")");
			} else {
				writeS(item.getName());
			}
			
			L1Item template = ItemTable.getInstance().getTemplate(
					item.getItemId());
			
			if (template == null) {
				writeC(0);
			} else {
				dummy.setItem(template);
				dummy.setEnchantLevel(shopItem.getEnchantLevel());
				dummy.setIdentified(true);
				byte[] status = dummy.getStatusBytes();
				writeC(status.length);
				for (byte b : status) {
					writeC(b);
				}
			}
		}
		
		writeH(0x07);
	}
	
	public S_ShopSellList(int objId) {
		writeC(Opcodes.S_OPCODE_SHOWSHOPBUYLIST);
		writeD(objId);
		L1Object npcObj = L1World.getInstance().findObject(objId);
		if (!(npcObj instanceof L1NpcInstance)) {
			writeH(0);
			return;
		}
		int npcId = ((L1NpcInstance) npcObj).getNpcTemplate().get_npcId();
		L1TaxCalculator calc = new L1TaxCalculator(npcId);
		L1Shop shop = ShopTable.getInstance().get(npcId);
		List<L1ShopItem> shopItems = shop.getSellingItems();
		writeH(shopItems.size());
		// In order to use the L1ItemInstance getStatusBytes
		L1ItemInstance dummy = new L1ItemInstance();
		for (int i = 0; i < shopItems.size(); i++) {
			L1ShopItem shopItem = shopItems.get(i);
			L1Item item = shopItem.getItem();
			int price;
			if (npcId != 70017 && npcId != 70049) {// Exclude Orim and Rozen
													// from taxes
				price = (int)(shopItem.getPrice()* Config.RATE_SHOP_SELLING_PRICE) + calc.layTax(shopItem, 1);
			} else {
				price = (int) (shopItem.getPrice() * Config.RATE_SHOP_SELLING_PRICE);
			}
			writeD(i);
			writeH(shopItem.getItem().getGfxId());
			writeD(price);
			if (shopItem.getPackCount() > 1) {
				writeS(item.getName() + " (" + shopItem.getPackCount() + ")");
			} else {
				writeS(item.getName());
			}
			L1Item template = ItemTable.getInstance().getTemplate(
					item.getItemId());
			if (template == null) {
				writeC(0);
			} else {
				dummy.setItem(template);
				byte[] status = dummy.getStatusBytes();
				writeC(status.length);
				for (byte b : status) {
					writeC(b);
				}
			}
		}
		writeH(0x07); // 0x00:kaimo 0x01:pearl 0x07:adena
	}

	@Override
	public byte[] getContent() throws IOException {
		return _bao.toByteArray();
	}
}