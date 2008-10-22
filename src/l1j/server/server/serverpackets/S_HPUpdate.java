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
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.IntRange;

public class S_HPUpdate extends ServerBasePacket {
	private static final IntRange hpRange = new IntRange(1, 32767);

	public S_HPUpdate(int currentHp, int maxHp) {
		buildPacket(currentHp, maxHp);
	}

	public S_HPUpdate(L1PcInstance pc) {
		buildPacket(pc.getCurrentHp(), pc.getMaxHp());
	}

	public void buildPacket(int currentHp, int maxHp) {
		writeC(Opcodes.S_OPCODE_HPUPDATE);
		writeH(hpRange.ensure(currentHp));
		writeH(hpRange.ensure(maxHp));
		// writeC(0);
		// writeD(GameTimeController.getInstance().getGameTime());
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}
}
