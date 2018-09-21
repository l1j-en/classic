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

import java.util.ArrayList;
import java.util.List;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_SystemMessage

public class S_FixWeaponList extends ServerBasePacket {
//	private static Logger _log = LoggerFactory.getLogger(S_FixWeaponList.class
//			.getName());
	private static final String S_FIX_WEAPON_LIST = "[S] S_FixWeaponList";

	public S_FixWeaponList(L1PcInstance pc) {
		buildPacket(pc);
	}

	private void buildPacket(L1PcInstance pc) {
		writeC(Opcodes.S_OPCODE_SELECTLIST);
		writeD(0x000000c8); // Price
		List<L1ItemInstance> weaponList = new ArrayList<L1ItemInstance>();
		List<L1ItemInstance> itemList = pc.getInventory().getItems();
		for (L1ItemInstance item : itemList) {
			// Find Weapon
			switch (item.getItem().getType2()) {
			case 1:
				if (item.get_durability() > 0) {
					weaponList.add(item);
				}
				break;
			}
		}
		writeH(weaponList.size()); // Weapon Amount
		for (L1ItemInstance weapon : weaponList) {
			writeD(weapon.getId()); // Item ID
			writeC(weapon.get_durability()); // Fix Level
		}
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return S_FIX_WEAPON_LIST;
	}
}