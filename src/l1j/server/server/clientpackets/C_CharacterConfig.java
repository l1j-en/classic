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
package l1j.server.server.clientpackets;

import l1j.server.config.Config;
import l1j.server.server.ClientThread;
import l1j.server.server.datatables.CharacterConfigTable;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_CharacterConfig extends ClientBasePacket {
	private static final String C_CHARACTER_CONFIG = "[C] C_CharacterConfig";

	public C_CharacterConfig(byte abyte0[], ClientThread client) throws Exception {
		super(abyte0);
		if (Config.CHARACTER_CONFIG_IN_SERVER_SIDE) {
			L1PcInstance pc = client.getActiveChar();
			int length = readD() - 3;
			byte data[] = readByte();
			int count = CharacterConfigTable.getInstance()
					.countCharacterConfig(pc.getId());
			if (count == 0) {
				CharacterConfigTable.getInstance().storeCharacterConfig(pc
						.getId(), length, data);
			} else {
				CharacterConfigTable.getInstance().updateCharacterConfig(pc
						.getId(),length, data);
			}
		}
	}

	@Override
	public String getType() {
		return C_CHARACTER_CONFIG;
	}
}
