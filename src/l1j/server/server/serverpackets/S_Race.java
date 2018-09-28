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

import java.util.List;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;

public class S_Race extends ServerBasePacket {
	private static final String S_RACE = "[S] S_Race";

	private byte[] _byte = null;

	public static final int GameStart = 0x40;
	public static final int CountDown = 0x41;
	public static final int PlayerInfo = 0x42;
	public static final int Lap = 0x43;
	public static final int Winner = 0x44;
	public static final int GameOver = 0x45;
	public static final int GameEnd = 0x46;

	// GameStart// CountDown// GameOver// GameEnd
	public S_Race(int type) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(type);
		if (type == GameStart) {
			writeC(0x05);
		}
	}

	public S_Race(List<L1PcInstance> playerList, L1PcInstance pc) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(PlayerInfo);
		writeH(playerList.size());
		writeH(playerList.indexOf(pc));
		for (L1PcInstance player : playerList) {
			if (player == null) {
				continue;
			}
			writeS(player.getName());
		}
	}

	public S_Race(int maxLap, int lap) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(Lap);
		writeH(maxLap);
		writeH(lap);
	}

	public S_Race(String winnerName, int time) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(Winner);
		writeS(winnerName);
		writeD(time * 1000);
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
		return S_RACE;
	}
}