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

public class S_LoginResult extends ServerBasePacket {
	public static final String S_LOGIN_RESULT = "[S] S_LoginResult";

	public static final int REASON_LOGIN_OK = 0x00;

	public static final int REASON_ACCOUNT_IN_USE = 0x16;

	public static final int REASON_ACCOUNT_ALREADY_EXISTS = 0x07;

	public static final int REASON_ACCESS_FAILED = 0x08;

	public static final int REASON_USER_OR_PASS_WRONG = 0x08;

	public static final int REASON_PASS_WRONG = 0x08;

	// public static int REASON_SYSTEM_ERROR = 0x01;

	private byte[] _byte = null;

	public S_LoginResult(int reason) {
		buildPacket(reason);
	}

	private void buildPacket(int reason) {
		writeC(Opcodes.S_OPCODE_LOGINRESULT);
		writeC(reason);
		writeD(0x00000000);
		writeD(0x00000000);
		writeD(0x00000000);
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
		return S_LOGIN_RESULT;
	}
}
