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

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket
public class S_Paralysis extends ServerBasePacket {
	public static final int TYPE_PARALYSIS = 1;
	public static final int TYPE_PARALYSIS2 = 2;
	public static final int TYPE_SLEEP = 3;
	public static final int TYPE_FREEZE = 4;
	public static final int TYPE_STUN = 5;
	public static final int TYPE_BIND = 6;
	public static final int TYPE_TELEPORT_UNLOCK = 7;
//	private static final String _S__2F_PARALYSIS = "[S] S_Paralysis";

	public S_Paralysis(int type, boolean flag) {
		writeC(Opcodes.S_OPCODE_PARALYSIS);
		if (type == TYPE_PARALYSIS) // The body is completely paralyzed.
		{
			if (flag == true) {
				writeC(2);
			} else {
				writeC(3);
			}
		} else if (type == TYPE_PARALYSIS2) // The body is completely paralyzed.
		{
			if (flag == true) {
				writeC(4);
			} else {
				writeC(5);
			}
		} else if (type == TYPE_TELEPORT_UNLOCK) // Teleport lifting of state of
													// waiting
		{
			writeC(7);
		} else if (type == TYPE_SLEEP) // I sleep a powerful wave, sleep
		{
			if (flag == true) {
				writeC(10);
			} else {
				writeC(11);
			}
		} else if (type == TYPE_FREEZE) {
			if (flag == true) {
				writeC(12);
			} else {
				writeC(13);
			}
		} else if (type == TYPE_STUN) {
			if (flag == true) {
				writeC(22);
			} else {
				writeC(23);
			}
		} else if (type == TYPE_BIND) {
			if (flag == true) {
				writeC(24);
			} else {
				writeC(25);
			}
		}
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return "[S] S_Paralysis";
	}
}