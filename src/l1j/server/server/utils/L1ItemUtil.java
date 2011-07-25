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
package l1j.server.server.utils;

import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Item;

public class L1ItemUtil {

	public static void createNewItem(L1PcInstance pc, int itemId, int count) {
		L1ItemInstance item = ItemTable.getInstance().createItem(itemId);
		item.setCount(count);
		if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
			pc.getInventory().storeItem(item);
		} else {
			L1World.getInstance().getInventory(pc.getX(), pc.getY(),
					pc.getMapId()).storeItem(item);
		}
		pc.sendPackets(new S_ServerMessage(403, item
				.getLogName()));
	}

	public static boolean isFood(L1Item item) {
		return item.getType2() == 0 && item.getType() == 7;
	}
}