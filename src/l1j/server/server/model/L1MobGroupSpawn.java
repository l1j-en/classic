/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 * 
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.model;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.MobGroupTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.templates.L1MobGroup;
import l1j.server.server.templates.L1NpcCount;

// Referenced classes of package l1j.server.server.model:
// L1MobGroupSpawn
public class L1MobGroupSpawn {

	private static final Logger _log = LoggerFactory.getLogger(L1MobGroupSpawn.class
			.getName());

	private static L1MobGroupSpawn _instance;
 	private boolean _isRespawnScreen;
	private boolean _isInitSpawn;

	private L1MobGroupSpawn() {
	}

	public static L1MobGroupSpawn getInstance() {
		if (_instance == null) {
			_instance = new L1MobGroupSpawn();
		}
		return _instance;
	}

	public void doSpawn(L1NpcInstance leader, int groupId,
			boolean isRespawnScreen, boolean isInitSpawn) {

		L1MobGroup mobGroup = MobGroupTable.getInstance().getTemplate(groupId);
		if (mobGroup == null) {
			return;
		}
		L1NpcInstance mob;
		_isRespawnScreen = isRespawnScreen;
		_isInitSpawn = isInitSpawn;
		L1MobGroupInfo mobGroupInfo = new L1MobGroupInfo();
		mobGroupInfo.setRemoveGroup(mobGroup.isRemoveGroupIfLeaderDie());
		mobGroupInfo.addMember(leader);
		for (L1NpcCount minion : mobGroup.getMinions()) {
			if (minion.isZero()) {
				continue;
			}
			for (int i = 0; i < minion.getCount(); i++) {
				mob = spawn(leader, minion.getId());
				if (mob != null) {
					mobGroupInfo.addMember(mob);
				}
			}
		}
	}

	private L1NpcInstance spawn(L1NpcInstance leader, int npcId) {
		L1NpcInstance mob = null;
		try {
			mob = NpcTable.getInstance().newNpcInstance(npcId);
			mob.setId(IdFactory.getInstance().nextId());
			mob.setHeading(leader.getHeading());
			mob.setMap(leader.getMapId());
			mob.setMovementDistance(leader.getMovementDistance());
			mob.setRest(leader.isRest());
			mob.setX(leader.getX() + ThreadLocalRandom.current().nextInt(5) - 2);
			mob.setY(leader.getY() + ThreadLocalRandom.current().nextInt(5) - 2);
			if (!canSpawn(mob)) {
				mob.setX(leader.getX());
				mob.setY(leader.getY());
			}
			mob.setHomeX(mob.getX());
			mob.setHomeY(mob.getY());
			if (mob instanceof L1MonsterInstance) {
				((L1MonsterInstance) mob).initHideForMinion(leader);
			}
			mob.setSpawn(leader.getSpawn());
			mob.setreSpawn(leader.isReSpawn());
			mob.setSpawnNumber(leader.getSpawnNumber());
			if (mob instanceof L1MonsterInstance) {
				if (mob.getMapId() == 666) {
					((L1MonsterInstance) mob).set_storeDroped(true);
				}
			}
			L1World.getInstance().storeObject(mob);
			L1World.getInstance().addVisibleObject(mob);
			if (mob instanceof L1MonsterInstance) {
				if (!_isInitSpawn && mob.getHiddenStatus() == 0) {
					mob.onNpcAI();
				}
			}
			mob.turnOnOffLight();
			mob.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE);
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
		return mob;
	}

	private boolean canSpawn(L1NpcInstance mob) {
		if (mob.getMap().isInMap(mob.getLocation())
				&& mob.getMap().isPassable(mob.getLocation())) {
			if (_isRespawnScreen) {
				return true;
			}
			if (L1World.getInstance().getVisiblePlayer(mob).size() == 0) {
				return true;
			}
		}
		return false;
	}
}