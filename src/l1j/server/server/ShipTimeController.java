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
import l1j.server.server.model.gametime.L1GameTime;
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
		int servertime = L1GameTimeClock.getInstance().getGameTime()
				.getSeconds();
		int nowtime = servertime % 86400;
		if (nowtime >= 90 * 60 && nowtime < 180 * 60 // 1:30 ~ 3:00 
				|| nowtime >= 270 * 60 && nowtime < 360 * 60 // 4:30 ~ 6:00 
				|| nowtime >= 450 * 60 && nowtime < 540 * 60 // 7:30 ~ 9:00 
				|| nowtime >= 630 * 60 && nowtime < 720 * 60 // 10:30 ~ 12:00 
				|| nowtime >= 810 * 60 && nowtime < 900 * 60 // 13:30 ~ 15:00 
				|| nowtime >= 990 * 60 && nowtime < 1080 * 60 // 16:30 ~ 18:00 
				|| nowtime >= 1170 * 60 && nowtime < 1260 * 60 // 19:30 ~ 21:00 
				|| nowtime >= 1350 * 60 && nowtime < 1440 * 60 // 22:30 ~ 24:00 
				) {
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getMapId() == 83) {
					pc.getInventory().consumeItem(40300, 1);
					L1Teleport.teleport(pc, 32936, 33057, (short) 70, 0, false);
				}
			}
		}
		if (nowtime >= 0 && nowtime < 90 * 60 // 0:00~ 1:30 
				|| nowtime >= 180 * 60 && nowtime < 270 * 60 // 3:00 ~ 4:30 
				|| nowtime >= 360 * 60 && nowtime < 450 * 60 // 6:00 ~ 7:30 
				|| nowtime >= 540 * 60 && nowtime < 630 * 60 // 9:00 ~ 10:30 
				|| nowtime >= 720 * 60 && nowtime < 810 * 60 // 12:00 ~ 13:30 
				|| nowtime >= 900 * 60 && nowtime < 990 * 60 // 15:00 ~ 16:30 
				|| nowtime >= 1080 * 60 && nowtime < 1170 * 60 // 18:00 ~ 19:30 
				|| nowtime >= 1260 * 60 && nowtime < 1350 * 60 // 21:00 ~ 22:30 
				) {
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getMapId() == 84) {
					pc.getInventory().consumeItem(40301, 1);
					L1Teleport.teleport(pc, 33426, 33499, (short) 4, 0, false);
				}
			}
		}
		if (nowtime >= 0 && nowtime < 90 * 60 // 0:00 ~1:30 
				|| nowtime >= 180 * 60 && nowtime < 270 * 60 // 3:00 ~4:30 
				|| nowtime >= 360 * 60 && nowtime < 450 * 60 // 6:00 ~7:30 
				|| nowtime >= 540 * 60 && nowtime < 630 * 60 // 9:00 ~10:30 
				|| nowtime >= 720 * 60 && nowtime < 810 * 60 // 12:00 ~13:30 
				|| nowtime >= 900 * 60 && nowtime < 990 * 60 // 15:00 ~16:30 
				|| nowtime >= 1080 * 60 && nowtime < 1170 * 60 // 18:00 ~19:30 
				|| nowtime >= 1260 * 60 && nowtime < 1350 * 60 // 21:00 ~22:30 
				) { 
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getMapId() == 447) {
					pc.getInventory().consumeItem(40302, 1);
					L1Teleport.teleport(pc, 32297, 33087, (short) 440, 0, false);
				}
			}
		}
		if (nowtime >= 90 * 60 && nowtime < 180 * 60 // 1:30 ~ 3:00 
				|| nowtime >= 270 * 60 && nowtime < 360 * 60 // 4:30 ~ 6:00 
				|| nowtime >= 450 * 60 && nowtime < 540 * 60 // 7:30 ~ 9:00 
				|| nowtime >= 630 * 60 && nowtime < 720 * 60 // 10:30 ~ 12:00 
				|| nowtime >= 810 * 60 && nowtime < 900 * 60 // 13:30 ~ 15:00 
				|| nowtime >= 990 * 60 && nowtime < 1080 * 60 // 16:30 ~ 18:00 
				|| nowtime >= 1170 * 60 && nowtime < 1260 * 60 // 19:30 ~ 21:00 
				|| nowtime >= 1350 * 60 && nowtime < 1440 * 60 // 22:30 ~ 24:00 
				) { 
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc.getMapId() == 446) {
					pc.getInventory().consumeItem(40303, 1);
					L1Teleport.teleport(pc, 32750, 32874, (short) 445, 0, false);
				}
			}
		}
	}
}
