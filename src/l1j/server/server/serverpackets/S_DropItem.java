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

import java.util.logging.Logger;

import l1j.server.server.Opcodes;
import l1j.server.server.model.Instance.L1ItemInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_DropItem extends ServerBasePacket {

	private static final String _S__OB_DropItem = "[S] S_DropItem";
	private static Logger _log = Logger.getLogger(S_DropItem.class.getName());

	private byte[] _byte = null;

	public S_DropItem(L1ItemInstance item) {
		buildPacket(item);
	}

	private void buildPacket(L1ItemInstance item) {
		// int addbyte = 0;
		// int addbyte1 = 1;
		// int addbyte2 = 13;
		// int setting = 4;
		writeC(Opcodes.S_OPCODE_DROPITEM);
		writeH(item.getX());
		writeH(item.getY());
		writeD(item.getId());
		writeH(item.getItem().getGroundGfxId());
		writeC(0);
		writeC(0);
		if (item.isNowLighting()) {
			writeC(item.getItem().getLightRange());
		} else {
			writeC(0);
		}
		writeC(0);
		writeD(item.getCount());
		writeC(0);
		writeC(0);
		if (item.getCount() > 1) {
			writeS(item.getItem().getName() + " (" + item.getCount() + ")");
		} else {
			int itemId = item.getItem().getItemId();
			int isId = item.isIdentified() ? 1 : 0;
			if (itemId == 20383 && isId == 1) { // Rnpw
				writeS(item.getItem().getName() + " [" + item
						.getChargeCount() + "]");
			} else if ((itemId == 40006 || itemId == 40007
					|| itemId == 40008 || itemId == 40009
					|| itemId == 140006 || itemId == 140008) && isId == 1) { // hÞ
				writeS(item.getItem().getName() + " (" + item
						.getChargeCount() + ")");
			} else if (item.getItem().getLightRange() != 0 && item
					.isNowLighting()) {
				writeS(item.getItem().getName() + " ($10)");
			} else {
				writeS(item.getItem().getName());
			}
		}
		writeC(0);
		writeD(0);
		writeD(0);
		writeC(255);
		writeC(0);
		writeC(0);
		writeC(0);
		writeH(65535);
		// writeD(0x401799a);
		writeD(0);
		writeC(8);
		writeC(0);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		}
		return _byte;
	}

	public String getType() {
		return _S__OB_DropItem;
	}

}
