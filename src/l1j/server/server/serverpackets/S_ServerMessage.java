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

import java.util.logging.Logger;

import l1j.server.server.Opcodes;

public class S_ServerMessage extends ServerBasePacket {
	private static final String S_SERVER_MESSAGE = "[S] S_ServerMessage";

	private static Logger _log = Logger.getLogger(S_ServerMessage.class
			.getName());

	public static final int NO_PLEDGE = 208;

	public static final int CANNOT_GLOBAL = 195;

	public static final int CANNOT_BOOKMARK_LOCATION = 214;

	public static final int USER_NOT_ON = 73;

	public static final int NOT_ENOUGH_MP = 278;

	public static final int YOU_FEEL_BETTER = 77;

	public static final int YOUR_WEAPON_BLESSING = 693;

	public static final int YOUR_Are_Slowed = 29;

	private byte[] _byte = null;

	public S_ServerMessage(int type) {
		buildPacket(type, null, null, null, null, null, 0);
	}

	public S_ServerMessage(int type, String msg1) {
		buildPacket(type, msg1, null, null, null, null, 1);
	}

	public S_ServerMessage(int type, String msg1, String msg2) {
		buildPacket(type, msg1, msg2, null, null, null, 2);
	}

	public S_ServerMessage(int type, String msg1, String msg2, String msg3) {
		buildPacket(type, msg1, msg2, msg3, null, null, 3);
	}

	public S_ServerMessage(int type, String msg1, String msg2, String msg3,
			String msg4) {
		buildPacket(type, msg1, msg2, msg3, msg4, null, 4);
	}

	public S_ServerMessage(int type, String msg1, String msg2, String msg3,
			String msg4, String msg5) {

		buildPacket(type, msg1, msg2, msg3, msg4, msg5, 5);
	}

	private void buildPacket(int type, String msg1, String msg2, String msg3,
			String msg4, String msg5, int check) {

		writeC(Opcodes.S_OPCODE_SERVERMSG);
		writeH(type);

		if (check == 0) {
			writeC(0);
		} else if (check == 1) {
			writeC(1);
			writeS(msg1);
		} else if (check == 2) {
			writeC(2);
			writeS(msg1);
			writeS(msg2);
		} else if (check == 3) {
			writeC(3);
			writeS(msg1);
			writeS(msg2);
			writeS(msg3);
		} else if (check == 4) {
			writeC(4);
			writeS(msg1);
			writeS(msg2);
			writeS(msg3);
			writeS(msg4);
		} else {
			writeC(5);
			writeS(msg1);
			writeS(msg2);
			writeS(msg3);
			writeS(msg4);
			writeS(msg5);
		}
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		}

		return _byte;
	}

	@Override
	public String getType() {
		return S_SERVER_MESSAGE;
	}
}
