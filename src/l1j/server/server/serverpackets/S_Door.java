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

public class S_Door extends ServerBasePacket {
	private static final String S_DOOR = "[S] S_Door";
	private byte[] _byte = null;

	private static final int PASS = 0;
	private static final int NOT_PASS = 1;

	public S_Door(int x, int y, int direction, boolean isPassable) {
		buildPacket(x, y, direction, isPassable);
	}

	private void buildPacket(int x, int y, int direction, boolean isPassable) {
		writeC(Opcodes.S_OPCODE_ATTRIBUTE);
		writeH(x);
		writeH(y);
		writeC(direction);
		writeC(isPassable ? PASS : NOT_PASS);
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
		return S_DOOR;
	}
}