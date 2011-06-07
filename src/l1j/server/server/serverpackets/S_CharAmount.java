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

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.ClientThread;
import l1j.server.server.Opcodes;

public class S_CharAmount extends ServerBasePacket {

	private byte[] _byte = null;

	public S_CharAmount(int value, ClientThread client) {
		buildPacket(value, client);
	}

	private void buildPacket(int value, ClientThread client) {
		Account account = Account.load(client.getAccountName());
		int characterSlot = account.getCharacterSlot();
		int maxAmount = Config.DEFAULT_CHARACTER_SLOT + characterSlot;

		writeC(Opcodes.S_OPCODE_CHARAMOUNT);
		writeC(value);
// writeD(0x00000000);
// writeD(0x0000);
		writeC(maxAmount); // max amount
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}
}
