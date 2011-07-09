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
package l1j.server.server.datatables;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.templates.L1DoorGfx;
import l1j.server.server.templates.L1DoorSpawn;
import l1j.server.server.utils.collections.Maps;

public class DoorTable {
	private static Logger _log = Logger.getLogger(DoorTable.class.getName());
	private static DoorTable _instance;

	private final Map<L1Location, L1DoorInstance> _doors 
	= Maps.newConcurrentHashMap();

	public static void initialize() {
		_instance = new DoorTable();
	}

	public static DoorTable getInstance() {
		return _instance;
	}

	private DoorTable() {
		loadDoors();
	}

	private void loadDoors() {
		for (L1DoorSpawn spawn : L1DoorSpawn.all()) {
			L1Location loc = spawn.getLocation();
			if (_doors.containsKey(loc)) {
				continue;
			}
			createDoor(spawn.getId(), spawn.getGfx(), loc, spawn.getHp(), spawn
					.getKeeper());
		}
	}

	public L1DoorInstance createDoor(int doorId, L1DoorGfx gfx, L1Location loc,
			int hp, int keeper) {
		if (_doors.containsKey(loc)) {
			return null;
		}
		L1DoorInstance door = new L1DoorInstance(doorId, gfx, loc, hp, keeper);

		door.setId(IdFactory.getInstance().nextId());

		L1World.getInstance().storeObject(door);
		L1World.getInstance().addVisibleObject(door);

		_doors.put(door.getLocation(), door);
		return door;
	}

	public void deleteDoorByLocation(L1Location loc) {
		L1DoorInstance door = _doors.remove(loc);
		if (door != null) {
			door.deleteMe();
		}
	}

	public L1DoorInstance findByDoorId(int doorId) {
		for (L1DoorInstance door : _doors.values()) {
			if (door.getDoorId() == doorId) {
				return door;
			}
		}
		return null;
	}

	public L1DoorInstance[] getDoorList() {
		return _doors.values().toArray(new L1DoorInstance[_doors.size()]);
	}
}