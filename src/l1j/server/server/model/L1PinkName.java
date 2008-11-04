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
package l1j.server.server.model;

import java.util.logging.Logger;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.WarTimeController;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_PinkName;

// Referenced classes of package l1j.server.server.model:
// L1PinkName

public class L1PinkName {
	private static final Logger _log = Logger.getLogger(L1PinkName.class
			.getName());

	private L1PinkName() {
	}

	static class PinkNameTimer implements Runnable {
		private L1PcInstance _attacker = null;

		public PinkNameTimer(L1PcInstance attacker) {
			_attacker = attacker;
		}

		@Override
		public void run() {
			for (int i = 0; i < 180; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception exception) {
					break;
				}
				if (_attacker.isDead()) {
					break;
				}
				if (_attacker.getLawful() < 0) {
					_attacker.setPinkName(false);
					break;
				}
			}
			stopPinkName(_attacker);
		}

		private void stopPinkName(L1PcInstance attacker) {
			attacker.sendPackets(new S_PinkName(attacker.getId(), 0));
			attacker.broadcastPacket(new S_PinkName(attacker.getId(), 0));
			// BCM: added this, as pinkname flag wasn't getting reset properly on timeout, affecting -warp usage.
			_attacker.setPinkName(false);
		}
	}

	public static void onAction(L1PcInstance player, L1Character cha) {
		if (player == null || cha == null) {
			return;
		}

		if (!(cha instanceof L1PcInstance)) {
			return;
		}
		L1PcInstance attacker = (L1PcInstance) cha;
		if (player == attacker) {
			return;
		}

		boolean is_now_war = false;
		int castle_id = L1CastleLocation.getCastleIdByArea(player);
		if (castle_id != 0) {
			is_now_war = WarTimeController.getInstance().isNowWar(castle_id);
		}

		if (player.getLawful() >= 0
				&& !player.isPinkName() && attacker.getLawful() >= 0
				&& !attacker.isPinkName()) {
			if (player.getZoneType() == 0 && 
					attacker.getZoneType() == 0 && is_now_war == false) {
				attacker.setPinkName(true);
				attacker.sendPackets(new S_PinkName(attacker.getId(), 180));
				if (!attacker.isGmInvis()) {
					attacker.broadcastPacket(new S_PinkName(attacker.getId(),
							180));
				}
				PinkNameTimer pink = new PinkNameTimer(attacker);
				GeneralThreadPool.getInstance().execute(pink);
			}
		}
	}
}
