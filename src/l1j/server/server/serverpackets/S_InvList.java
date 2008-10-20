/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 * 
 * http://www.gnu.org/copyleft/gpl.html
 */

package l1j.server.server.serverpackets;

import java.util.List;

import l1j.server.packethandler.Opcodes;
import l1j.server.server.model.Instance.L1ItemInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_InvList extends ServerBasePacket {
	private static final String S_INV_LIST = "[S] S_InvList";

	/**
	 * Inventory items to add several at once.
	 */
	public S_InvList(List<L1ItemInstance> items) {
		writeC(Opcodes.S_OPCODE_INVLIST);
		writeC(items.size()); // The number of items

		for (L1ItemInstance item : items) {
			writeD(item.getId());
			writeC(item.getItem().getUseType());
			writeC(0);
			writeH(item.get_gfxid());
			writeC(item.getItem().getBless());
			writeD(item.getCount());
			writeC((item.isIdentified()) ? 1 : 0);
			writeS(item.getViewName());
			if (!item.isIdentified()) {
				// No expert opinion if there is no need to send status
				writeC(0);
			} else {
				byte[] status = item.getStatusBytes();
				writeC(status.length);
				for (byte b : status) {
					writeC(b);
				}
			}
		}
	}

	@Override
	public byte[] getContent() {
		return _bao.toByteArray();
	}

	public String getType() {
		return S_INV_LIST;
	}
}
