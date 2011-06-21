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

import java.util.logging.Logger;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1ItemInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_AddItem extends ServerBasePacket {
	private static Logger _log = Logger.getLogger(S_AddItem.class.getName());
	private static final String S_ADD_ITEM = "[S] S_AddItem";
	/**
	 * One item to add to the inventory.
	 */
	public S_AddItem(L1ItemInstance item) {
		writeC(Opcodes.S_OPCODE_ADDITEM);
		writeD(item.getId());
		writeC(item.getItem().getUseType());
		writeC(0);
		writeH(item.get_gfxid());
		writeC(item.getBless());
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

	@Override
	public byte[] getContent() {
		return _bao.toByteArray();
	}

	@Override
	public String getType() {
		return S_ADD_ITEM;
	}
}