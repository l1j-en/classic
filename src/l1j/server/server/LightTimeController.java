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

import l1j.server.server.datatables.LightSpawnTable;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.Instance.L1FieldObjectInstance;

public class LightTimeController implements Runnable {
	private static Logger _log = Logger.getLogger(LightTimeController.class
			.getName());

	private static LightTimeController _instance;

	private boolean isSpawn = false;

	public static LightTimeController getInstance() {
		if (_instance == null) {
			_instance = new LightTimeController();
		}
		return _instance;
	}

	@Override
	public void run() {
		try {
			while (true) {
				checkLightTime();
				Thread.sleep(60000);
			}
		} catch (Exception e1) {
		}
	}

	private void checkLightTime() {
		int serverTime = L1GameTimeClock.getInstance().currentTime()
				.getSeconds();
		int nowTime = serverTime % 86400;
		if (nowTime >= ((5 * 3600) + 3300) && nowTime < ((17 * 3600) + 3300)) { // 5:55~17:55
			if (isSpawn) {
				isSpawn = false;
				for (L1Object object : L1World.getInstance().getObject()) {
					if (object instanceof L1FieldObjectInstance) {
						L1FieldObjectInstance npc = (L1FieldObjectInstance)
								object;
						if ((npc.getNpcTemplate().get_npcId() == 81177
							|| npc.getNpcTemplate().get_npcId() == 81178
							|| npc.getNpcTemplate().get_npcId() == 81179
							|| npc.getNpcTemplate().get_npcId() == 81180
							|| npc.getNpcTemplate().get_npcId() == 81181)
							&& (npc.getMapId() == 0 || npc.getMapId() == 4)) {
						npc.deleteMe();
						}
					}
				}
			}
		} else if ((nowTime >= ((17 * 3600) + 3300) && nowTime <= 24 * 3600)
				|| (nowTime >= 0 * 3600 && nowTime < ((5 * 3600) + 3300))) { // 17:55~24:00,0:00~5:55
			if (!isSpawn) {
				isSpawn = true;
				LightSpawnTable.getInstance();
			}
		}
	}

}
