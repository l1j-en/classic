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
package l1j.server.server.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.L1NpcDeleteTimer;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;

public class L1SpawnUtil {
	private static Logger _log = LoggerFactory.getLogger(L1SpawnUtil.class.getName());

	public static void spawn(L1PcInstance pc, int npcId, int randomRange,
			int timeMillisToDelete) {
		try {
			L1NpcInstance npc = NpcTable.getInstance().newNpcInstance(npcId);
			npc.setId(IdFactory.getInstance().nextId());
			npc.setMap(pc.getMapId());
			if (randomRange == 0) {
				npc.getLocation().set(pc.getLocation());
				npc.getLocation().forward(pc.getHeading());
			} else {
				int tryCount = 0;
				do {
					tryCount++;
					npc.setX(pc.getX() + (int) (Math.random() * randomRange)
							- (int) (Math.random() * randomRange));
					npc.setY(pc.getY() + (int) (Math.random() * randomRange)
							- (int) (Math.random() * randomRange));
					if (npc.getMap().isInMap(npc.getLocation())
							&& npc.getMap().isPassable(npc.getLocation())) {
						break;
					}
					Thread.sleep(1);
				} while (tryCount < 50);

				if (tryCount >= 50) {
					npc.getLocation().set(pc.getLocation());
					npc.getLocation().forward(pc.getHeading());
				}
			}
			npc.setHomeX(npc.getX());
			npc.setHomeY(npc.getY());
			npc.setHeading(pc.getHeading());
			L1World.getInstance().storeObject(npc);
			
			L1World.getInstance().addVisibleObject(npc);
			npc.turnOnOffLight();
			npc.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE);
			if (0 < timeMillisToDelete) {
				L1NpcDeleteTimer timer = new L1NpcDeleteTimer(npc,
						timeMillisToDelete);
				timer.begin();
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}
	
	public static void spawn(L1PcInstance pc, int npcId, int x, int y,
			int timeMillisToDelete) {
		try {
			L1NpcInstance npc = NpcTable.getInstance().newNpcInstance(npcId);
			npc.setId(IdFactory.getInstance().nextId());
			npc.setMap(pc.getMapId());
			npc.setX(x);
			npc.setY(y);
			
			npc.setHomeX(npc.getX());
			npc.setHomeY(npc.getY());
			npc.setHeading(pc.getHeading());
			L1World.getInstance().storeObject(npc);
			
			L1World.getInstance().addVisibleObject(npc);
			npc.turnOnOffLight();
			npc.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE);
			if (0 < timeMillisToDelete) {
				L1NpcDeleteTimer timer = new L1NpcDeleteTimer(npc,
						timeMillisToDelete);
				timer.begin();
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}
}