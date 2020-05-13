/* This program is free software; you can redistribute it and/or modify
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

public class S_LoginGame extends ServerBasePacket {
	public S_LoginGame() {
		writeC(Opcodes.S_OPCODE_LOGINTOGAME);
		writeC(0x03);
		writeC(0x15);
		writeC(0x8b);
		writeC(0x7b);
		writeC(0x94);
		writeC(0xf0);
		writeC(0x2f);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}
}
