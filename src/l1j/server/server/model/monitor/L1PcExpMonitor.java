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
package l1j.server.server.model.monitor;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Lawful;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.utils.IntRange;

public class L1PcExpMonitor extends L1PcMonitor {

	private int _old_lawful;

	private int _old_exp;

	public L1PcExpMonitor(int oId) {
		super(oId);
	}

	@Override
	public void execTask(L1PcInstance pc) {
		if (_old_lawful != pc.getLawful() && !((IntRange.includes(_old_lawful, 9000, 32767) && IntRange
						.includes(pc.getLawful(), 9000, 32767)) || (IntRange
						.includes(_old_lawful, -32768, -2000) && IntRange
						.includes(pc.getLawful(), -32768, -2000)))) {
			_old_lawful = pc.getLawful();
			S_Lawful s_lawful = new S_Lawful(_id, _old_lawful);
			pc.sendPackets(s_lawful);
			pc.broadcastPacket(s_lawful);
		} else if (_old_lawful != pc.getLawful()) {
			pc.sendPackets(new S_OwnCharStatus(pc));
		}

		if (_old_exp != pc.getExp()) {
			_old_exp = pc.getExp();
			pc.onChangeExp();
		}
	}
}
