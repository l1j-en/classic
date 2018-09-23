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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1EquipmentTimer implements Runnable {
	private static Logger _log = LoggerFactory.getLogger(L1EquipmentTimer.class);

	public L1EquipmentTimer(L1PcInstance pc, L1ItemInstance item) {
		_pc = pc;
		_item = item;
	}

	@Override
	public void run() {
		try {
			if ((_item.getRemainingTime() - 1) > 0) {
				_item.setRemainingTime(_item.getRemainingTime() - 1);
				_pc.getInventory().updateItem(_item,
						L1PcInventory.COL_REMAINING_TIME);
			} else {
				_pc.getInventory().removeItem(_item, 1);
				_pc.sendPackets(new S_SystemMessage("Your " + _item.getItem().getName() + " has disappeared!"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("",e);
		}
	}

	private final L1PcInstance _pc;
	private final L1ItemInstance _item;
}
