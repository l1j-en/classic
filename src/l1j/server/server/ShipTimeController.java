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
package l1j.server.server;

import java.util.logging.Logger;

import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;

public class ShipTimeController implements Runnable {
	private static Logger _log = Logger.getLogger(ShipTimeController.class.getName());

	private static ShipTimeController _instance;

	public static ShipTimeController getInstance() {
		if (_instance == null) {
			_instance = new ShipTimeController();
		}
		return _instance;
	}

	@Override
	public void run() {
		try {
			while (true) {
				checkShipTime(); 
				Thread.sleep(5000);
			}
		} catch (Exception e1) {
		}
	}

	private void checkShipTime() {
		int servertime = L1GameTimeClock.getInstance().getGameTime().getSeconds();
		int nowtime = servertime % 86400;
		if (nowtime >= 485 * 60 && nowtime < 480 * 60 // 7.35~8
				|| nowtime >= 665 * 60 && nowtime < 660 * 60 // 10.35~11
				|| nowtime >= 905 * 60 && nowtime < 900 * 60 // 14.35~15
				|| nowtime >= 1145 * 60 && nowtime < 1140 * 60) { // 18.35~19
		for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
			if (pc.getMapId() == 5) {
				L1Teleport.teleport(pc, 32631, 32982, (short) 0, 0, false);
			  }
		   }
	    }
		if (nowtime >= 515 * 60 && nowtime < 1260 * 60 // 8.35~9
				|| nowtime >= 785 * 60 && nowtime < 780 * 60 // 12.35~13
				|| nowtime >= 1025 * 60 && nowtime < 1020 * 60  // 16.35~17
				|| nowtime >= 1265 * 60 && nowtime < 1260 * 60) { // 20.35~21
		for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
			if (pc.getMapId() == 6) {
				L1Teleport.teleport(pc, 32544, 32727, (short) 4, 0, false);
		      }
		   }
	    }
		if (nowtime >= 395 * 60 && nowtime < 420 * 60 // 6.35~7
				|| nowtime >= 665 * 60 && nowtime < 660 * 60 // 10.35~11
				|| nowtime >= 905 * 60 && nowtime < 900 * 60 // 14.35~15
				|| nowtime >= 1145 * 60 && nowtime < 1140 * 60) { // 18.35~19
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getMapId() == 83) {
					L1Teleport.teleport(pc, 32936, 33057, (short) 70, 0, false);
				}
			}
		}
		if (nowtime >= 515 * 60 && nowtime < 1260 * 60 // 8.35~9
				|| nowtime >= 785 * 60 && nowtime < 780 * 60 // 12.35~13
				|| nowtime >= 1025 * 60 && nowtime < 1020 * 60  // 16.35~17
				|| nowtime >= 1265 * 60 && nowtime < 1260 * 60) { // 20.35~21
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getMapId() == 84) {
					L1Teleport.teleport(pc, 33426, 33499, (short) 4, 0, false);
				}
			}
		}
		if (nowtime >= 515 * 60 && nowtime < 1260 * 60 // 8.30~9
				|| nowtime >= 785 * 60 && nowtime < 780 * 60 // 12.30~13
				|| nowtime >= 1025 * 60 && nowtime < 1020 * 60  // 16.30~17
				|| nowtime >= 1265 * 60 && nowtime < 1260 * 60) { // 20.30~21
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getMapId() == 447) {
					L1Teleport.teleport(pc, 32297, 33087, (short) 440, 0, false);
				}
			}
		}
		if (nowtime >= 395 * 60 && nowtime < 420 * 60 // 6.30~7
				|| nowtime >= 665 * 60 && nowtime < 660 * 60 // 10.30~11
				|| nowtime >= 905 * 60 && nowtime < 900 * 60 // 14.30~15
				|| nowtime >= 1145 * 60 && nowtime < 1140 * 60) { // 18.30~19
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getMapId() == 446) {
					L1Teleport.teleport(pc, 32750, 32874, (short) 445, 0, false);
				}
			}
		}
	}
}
