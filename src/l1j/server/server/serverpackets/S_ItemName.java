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

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1ItemInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_SendInvOnLogin
public class S_ItemName extends ServerBasePacket {
	private static final String S_ITEM_NAME = "[S] S_ItemName";
//	private static Logger _log = LoggerFactory.getLogger(S_ItemName.class.getName());

	/**
	 * To change the name of the item. Equipment and strengthening of state when
	 * someone has changed.
	 */
	public S_ItemName(L1ItemInstance item) {
		if (item == null) {
			return;
		}
		// jump to all appearances, this is an item Opcode to update one's name
		// used solely for the purpose pattern (OE and after the equipment only
		// after?)
		// Later, some data continues to send all of them ignored
		writeC(Opcodes.S_OPCODE_ITEMNAME);
		writeD(item.getId());
		writeS(item.getViewName());
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return S_ITEM_NAME;
	}
}