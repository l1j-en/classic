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
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;

public class S_OwnCharStatus extends ServerBasePacket {

	private static final String S_OWB_CHAR_STATUS = "[S] S_OwnCharStatus";
	private byte[] _byte = null;

	

	public S_OwnCharStatus(L1PcInstance pc) {
		this(pc, -1, -1);
	}

	public S_OwnCharStatus(L1PcInstance pc, int hp, int mp) {

		long time = L1GameTimeClock.getInstance().currentTime().getSeconds();
		time = time - (time % 300);

		writeC(Opcodes.S_OPCODE_OWNCHARSTATUS);
		writeD(pc.getId());

		if (pc.getLevel() < 1) {
			writeC(1);
		} else if (pc.getLevel() > 127) {
			writeC(127);
		} else {
			writeC(pc.getLevel());
		}

		writeD(pc.getExp());
		writeC(pc.getStr());
		writeC(pc.getInt());
		writeC(pc.getWis());
		writeC(pc.getDex());
		writeC(pc.getCon());
		writeC(pc.getCha());
		writeH(hp == -1 ? pc.getCurrentHp() : hp);
		writeH(pc.getMaxHp());
		writeH(mp == -1 ? pc.getCurrentMp() : mp);
		writeH(pc.getMaxMp());
		writeC(pc.getAc());
		writeD((int)time);
		writeC(pc.get_food());
		writeC(pc.getInventory().getWeight240());
		writeH(pc.getLawful());
		writeC(pc.getFire());
		writeC(pc.getWater());
		writeC(pc.getWind());
		writeC(pc.getEarth());
		writeD(pc.getMonsterKill());

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
		return S_OWB_CHAR_STATUS;
	}
}
