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

import l1j.server.server.Opcodes;

public class S_DeleteCharOK extends ServerBasePacket {
	private static final String S_DELETE_CHAR_OK = "[S] S_DeleteCharOK";

	public static final int DELETE_CHAR_NOW = 0x05;
	public static final int DELETE_CHAR_AFTER_7DAYS = 0x51;

	public S_DeleteCharOK(int type) {
		writeC(Opcodes.S_OPCODE_DETELECHAROK);
		writeC(type);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return S_DELETE_CHAR_OK;
	}
}
