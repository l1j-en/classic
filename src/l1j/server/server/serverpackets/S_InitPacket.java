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

import static l1j.server.server.encryptions.Opcodes.S_OPCODE_INITPACKET;
import l1j.server.server.utils.RandomArrayList;

public class S_InitPacket extends ServerBasePacket {
private static final String S_INIT_PACKET = "[S] S_InitPacket";

private byte[] key = new byte[4];
private byte[] data = new byte[11];

public S_InitPacket() {
	RandomArrayList.getByte(key);
	RandomArrayList.getByte(data);

	writeC(S_OPCODE_INITPACKET);
	writeByte(key);
	writeByte(data);
}

public int getKey() {
	int keys = key[0] & 0xFF;
	keys |= key[1] << 8 & 0xFF00;
	keys |= key[2] << 16 & 0xFF0000;
	keys |= key[3] << 24 & 0xFF000000;
	return keys;
}

@Override
public byte[] getContent() {
	return getBytes();
}

@Override
public String getType() {
	return S_INIT_PACKET;
}
}