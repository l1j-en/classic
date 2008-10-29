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

public class S_PingPacket extends ServerBasePacket {
	private static final String S_PingPacket = "[S] S_PingPacket";
	private byte[] _byte = null;
	private int type = 0;// type 0 = ping Server time 
	private int type1 = 1;// type 1 = ping Auth Server time
	private int type2 = 2;// type 2 = ping Cach server 
	
	public S_PingPacket() {
		buildPacket();	
	}

	private void buildPacket() {
		writeC(Opcodes.S_OPCODE_PINGTIME);
		writeC(type);
		writeC(type1);
		writeC(type2);
	}

	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	public String getType() {
		return S_PingPacket;
	}
}
