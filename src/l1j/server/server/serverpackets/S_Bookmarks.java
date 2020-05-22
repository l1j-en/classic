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

public class S_Bookmarks extends ServerBasePacket {
	private static final String _S__1F_S_Bookmarks = "[S] S_Bookmarks";
	private byte[] _byte = null;

	public S_Bookmarks(String name, int map, int id, int x, int y) {
		buildPacket(name, map, id, x, y);
	}

	private void buildPacket(String name, int map, int id, int x, int y) {
		writeC(Opcodes.S_OPCODE_BOOKMARKS);
		writeS(name);
		writeH(map);
		writeH(x);
		writeH(y);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}

		return _byte;
	}

	@Override
	public String getType() {
		return _S__1F_S_Bookmarks;
	}
}