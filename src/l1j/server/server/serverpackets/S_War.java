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
public class S_War extends ServerBasePacket {
//	private static Logger _log = LoggerFactory.getLogger(S_War.class.getName());
	private static final String S_WAR = "[S] S_War";
	private byte[] _byte = null;

	public S_War(int type, String clan_name1, String clan_name2) {
		buildPacket(type, clan_name1, clan_name2);
	}

	private void buildPacket(int type, String clan_name1, String clan_name2) {
		// 1: __ __ clan to clan declaration of war.
		// 2: __ __ clan clan to surrender.
		// 3: _ _ blood and blood to end the war.
		// 4: _ __ clan and clan wars in victory.
		// 6: _ _ clan and clan is allied with the team.
		// 7: _ _ clan and the clan's alliance has been removed.
		// 8: Your blood is currently at war _ clan.
		writeC(Opcodes.S_OPCODE_WAR);
		writeC(type);
		writeS(clan_name1);
		writeS(clan_name2);
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
		return S_WAR;
	}
}