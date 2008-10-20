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

import l1j.server.packethandler.Opcodes;
import l1j.server.server.model.gametime.L1GameTimeClock;

public class S_ServerVersion extends ServerBasePacket {
	private static final String S_SERVER_VERSION = "[S] ServerVersion";

	public S_ServerVersion() {
		int time = L1GameTimeClock.getInstance().getGameTime().getSeconds();
		time = time - (time % 300);
		writeC(Opcodes.S_OPCODE_SERVERVERSION); // opcode
		writeC(0x00); // must be
		writeC(0x02); // low version
		writeD(0x00009D7C); // serverver
		writeD(0x0000791A); // cache version
		writeD(0x0000791A); // auth ver
		writeD(0x00009DD1); // npc ver
		writeD(time); // Log time to time
		writeC(0x00); // unk 1
		writeC(0x00); // unk 2
		writeC(0x01); // 0: English 4: JP
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	public String getType() {
		return S_SERVER_VERSION;
	}
}
