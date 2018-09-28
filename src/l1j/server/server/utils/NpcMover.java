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

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.datatables.NpcSpawnTable;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Spawn;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;

public class NpcMover {
	private static final Logger _log = LoggerFactory.getLogger(NpcMover.class.getName());
	
	public static void Move(int spawnId, int [][] movableLocations) {
		try {
			if(!Config.MOVE_MACROABLE_NPCS)
				return;
			
			// Move the NPC to one of several locations to make it harder to macro
			L1Spawn npcSpawn = NpcSpawnTable.getInstance().getTemplate(spawnId);
			L1NpcInstance npcInstance = null;
			
			for(L1Object worldObject : L1World.getInstance().getObject()){
				if(worldObject instanceof L1NpcInstance) {
					L1NpcInstance worldNpc = (L1NpcInstance)worldObject;
					if(npcSpawn != null && worldNpc.getSpawn()
							== npcSpawn)
						npcInstance = worldNpc;
				}
			}
			
			if(npcInstance == null) {
				_log.warn("Unable to move Npc to prevent macroing. Npc not found!");
				return;
			}
			
			Random rand = new Random();
			int [] newLoc = movableLocations[rand.nextInt(movableLocations.length)];
			npcInstance.setLocation(newLoc[0], newLoc[1], newLoc[2]);
			
			// update the location for anyone on screen
			for(L1Object object : L1World.getInstance().getVisibleObjects(npcInstance)) {
				if(object instanceof L1PcInstance)
					npcInstance.onPerceive((L1PcInstance)object);
			}
		} catch(Exception ex) {
			_log.warn("Unable to move Npc to prevent macroing. Error: " + ex.getMessage());
		}
	}
}
