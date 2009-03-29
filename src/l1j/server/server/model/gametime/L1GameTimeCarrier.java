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
package l1j.server.server.model.gametime;

import java.util.Timer;
import java.util.TimerTask;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.serverpackets.S_GameTime;

public class L1GameTimeCarrier extends TimerTask {
	private static final Timer _timer = new Timer();
	private L1PcInstance _pc;

	public L1GameTimeCarrier(L1PcInstance pc) {
		_pc = pc;
	}

	@Override
	public void run() {
		try {
			if (_pc.getNetConnection() == null) {
				cancel();
				return;
			}

			int serverTime = L1GameTimeClock.getInstance().currentTime()
					.getSeconds();
			if (serverTime % 300 == 0) {
				_pc.sendPackets(new S_GameTime(serverTime));
			}
		} catch (Exception e) {
			// ignore
		}
	}

	public void start() {
		_timer.scheduleAtFixedRate(this, 0, 500);
	}

	public void stop() {
		cancel();
	}
}
