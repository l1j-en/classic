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
import l1j.server.server.model.gametime.L1GameTimeClock;

public class S_GameTime extends ServerBasePacket {
	public S_GameTime(int time) {
		buildPacket(time);
	}

	public S_GameTime() {
		int time = L1GameTimeClock.getInstance().currentTime().getSeconds();
		buildPacket(time);
	}

	private void buildPacket(int time) {
		writeC(Opcodes.S_OPCODE_GAMETIME);
		writeD(time);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}
}
