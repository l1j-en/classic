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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.map.L1Map;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.ServerBasePacket;
import l1j.server.server.types.Point;

public class L1World {
	private static Logger _log = LoggerFactory.getLogger(L1World.class.getName());

	private final ConcurrentHashMap<String, L1PcInstance> _allPlayers;
	private final ConcurrentHashMap<Integer, L1PetInstance> _allPets;
	private final ConcurrentHashMap<Integer, L1SummonInstance> _allSummons;
	private final ConcurrentHashMap<Integer, L1Object> _allObjects;
	private final ArrayList<ConcurrentHashMap<Integer, L1Object>> _visibleObjects;
	private final CopyOnWriteArrayList<L1War> _allWars;
	private final ConcurrentHashMap<String, L1Clan> _allClans;

	private int _weather = 4;

	private boolean _worldChatEnabled = true;

	private boolean _processingContributionTotal = false;

	private static final int MAX_MAP_ID = 10000;

	private static L1World _instance;

	private L1World() {
		_allPlayers = new ConcurrentHashMap<String, L1PcInstance>();
		_allPets = new ConcurrentHashMap<Integer, L1PetInstance>();
		_allSummons = new ConcurrentHashMap<Integer, L1SummonInstance>();
		_allObjects = new ConcurrentHashMap<Integer, L1Object>();
		_visibleObjects = new ArrayList<ConcurrentHashMap<Integer, L1Object>>(MAX_MAP_ID + 1);
		_allWars = new CopyOnWriteArrayList<L1War>();
		_allClans = new ConcurrentHashMap<String, L1Clan>();

		for (int i = 0; i <= MAX_MAP_ID; i++) {
			_visibleObjects.add(new ConcurrentHashMap<Integer, L1Object>());
		}
	}

	public static L1World getInstance() {
		if (_instance == null) {
			_instance = new L1World();
		}
		return _instance;
	}

	/**
	 * All Clear state. <br>
	 * Debugging, testing, and other special purpose other than to call it.
	 */
	public void clear() {
		_instance = new L1World();
	}

	public void storeObject(L1Object object) {
		/*
		 * Debugging in progress... if (_allPlayers.size() > 0) {
		 * System.out.println( String.format("Adding %s with id %d.", object,
		 * object.getId())); if (object instanceof L1ItemInstance) {
		 * L1ItemInstance item = (L1ItemInstance) object;
		 * System.out.println(String.format("Item %s", item.getName())); } }
		 */

		_allObjects.put(object.getId(), object);
		if (object instanceof L1PcInstance) {
			_allPlayers.put(((L1PcInstance) object).getName(),
					(L1PcInstance) object);
		}
		if (object instanceof L1PetInstance) {
			_allPets.put(object.getId(), (L1PetInstance) object);
		}
		if (object instanceof L1SummonInstance) {
			_allSummons.put(object.getId(), (L1SummonInstance) object);
		}
	}

	public void removeObject(L1Object object) {
		/*
		 * Debugging in process... =( if (_allPlayers.size() > 0)
		 * System.out.println(String.format( "Removing %s with id %d.", object,
		 * object.getId()));
		 */

		_allObjects.remove(object.getId());
		if (object instanceof L1PcInstance) {
			_allPlayers.remove(((L1PcInstance) object).getName());
		}
		if (object instanceof L1PetInstance) {
			_allPets.remove(object.getId());
		}
		if (object instanceof L1SummonInstance) {
			_allSummons.remove(object.getId());
		}
	}

	public L1Object findObject(int oID) {
		return _allObjects.get(oID);
	}

	private Collection<L1Object> _allValues;

	public Collection<L1Object> getObject() {
		Collection<L1Object> vs = _allValues;
		return (vs != null) ? vs : (_allValues = Collections
				.unmodifiableCollection(_allObjects.values()));
	}

	public L1GroundInventory getInventory(int x, int y, short map) {
		int inventoryKey = ((x - 30000) * 10000 + (y - 30000)) * -1;

		Object object = _visibleObjects.get(map).get(inventoryKey);
		if (object == null) {
			return new L1GroundInventory(inventoryKey, x, y, map);
		} else {
			return (L1GroundInventory) object;
		}
	}

	public L1GroundInventory getInventory(L1Location loc) {
		return getInventory(loc.getX(), loc.getY(), (short) loc.getMap()
				.getId());
	}

	public void addVisibleObject(L1Object object) {
		if (object.getMapId() <= MAX_MAP_ID) {
			_visibleObjects.get(object.getMapId()).put(object.getId(), object);
		}
	}

	public void removeVisibleObject(L1Object object) {
		if (object.getMapId() <= MAX_MAP_ID) {
			_visibleObjects.get(object.getMapId()).remove(object.getId());
		}
	}

	public void moveVisibleObject(L1Object object, int newMap) {
		if (object.getMapId() != newMap) {
			if (object.getMapId() <= MAX_MAP_ID) {
				_visibleObjects.get(object.getMapId()).remove(object.getId());
			}
			if (newMap <= MAX_MAP_ID) {
				_visibleObjects.get(newMap).put(object.getId(), object);
			}
		}
	}

	private ConcurrentHashMap<Integer, Integer> createLineMap(Point src,
			Point target) {
		ConcurrentHashMap<Integer, Integer> lineMap = new ConcurrentHashMap<Integer, Integer>();

		/*
		 * http://www2.starcat.ne.jp/~fussy/algo/algo1-1.htm
		 */
		int E;
		int x;
		int y;
		int key;
		int i;
		int x0 = src.getX();
		int y0 = src.getY();
		int x1 = target.getX();
		int y1 = target.getY();
		int sx = (x1 > x0) ? 1 : -1;
		int dx = (x1 > x0) ? x1 - x0 : x0 - x1;
		int sy = (y1 > y0) ? 1 : -1;
		int dy = (y1 > y0) ? y1 - y0 : y0 - y1;

		x = x0;
		y = y0;
		/* If the slope is less */
		if (dx >= dy) {
			E = -dx;
			for (i = 0; i <= dx; i++) {
				key = (x << 16) + y;
				lineMap.put(key, key);
				x += sx;
				E += 2 * dy;
				if (E >= 0) {
					y += sy;
					E -= 2 * dx;
				}
			}
			/* If the slope is greater than 1 */
		} else {
			E = -dy;
			for (i = 0; i <= dy; i++) {
				key = (x << 16) + y;
				lineMap.put(key, key);
				y += sy;
				E += 2 * dx;
				if (E >= 0) {
					x += sx;
					E -= 2 * dy;
				}
			}
		}

		return lineMap;
	}

	public ArrayList<L1Object> getVisibleLineObjects(L1Object src,
			L1Object target) {
		ConcurrentHashMap<Integer, Integer> lineMap = createLineMap(
				src.getLocation(), target.getLocation());

		int map = target.getMapId();
		ArrayList<L1Object> result = new ArrayList<L1Object>();

		if (map <= MAX_MAP_ID) {
			for (L1Object element : _visibleObjects.get(map).values()) {
				if (element.equals(src)) {
					continue;
				}

				int key = (element.getX() << 16) + element.getY();
				if (lineMap.containsKey(key)) {
					result.add(element);
				}
			}
		}

		return result;
	}

	public ArrayList<L1Object> getVisibleBoxObjects(L1Object object,
			int heading, int width, int height) {
		int x = object.getX();
		int y = object.getY();
		int map = object.getMapId();
		L1Location location = object.getLocation();
		ArrayList<L1Object> result = new ArrayList<L1Object>();
		int headingRotate[] = { 6, 7, 0, 1, 2, 3, 4, 5 };
		double cosSita = Math.cos(headingRotate[heading] * Math.PI / 4);
		double sinSita = Math.sin(headingRotate[heading] * Math.PI / 4);

		if (map <= MAX_MAP_ID) {
			for (L1Object element : _visibleObjects.get(map).values()) {
				if (element.equals(object)) {
					continue;
				}
				if (map != element.getMapId()) {
					continue;
				}

				if (location.isSamePoint(element.getLocation())) {
					result.add(element);
					continue;
				}

				int distance = location.getTileLineDistance(element
						.getLocation());
				// Straight-line distance of height, width greater than either,
				// so the calculation of range
				if (distance > height && distance > width) {
					continue;
				}

				// and the origin of the object position to coordinate
				// correction
				int x1 = element.getX() - x;
				int y1 = element.getY() - y;

				// Z axis of rotation angle of 0 degrees.
				int rotX = (int) Math.round(x1 * cosSita + y1 * sinSita);
				int rotY = (int) Math.round(-x1 * sinSita + y1 * cosSita);

				int xmin = 0;
				int xmax = height;
				int ymin = -width;
				int ymax = width;

				// Differ with range and depth to determine the crow flies, so
				// be sure to change.
				// if (rotX > xmin && rotX <= xmax && rotY >= ymin && rotY <=
				// ymax) {
				if (rotX > xmin && distance <= xmax && rotY >= ymin
						&& rotY <= ymax) {
					result.add(element);
				}
			}
		}

		return result;
	}

	public ArrayList<L1Object> getVisibleObjects(L1Object object) {
		return getVisibleObjects(object, -1);
	}

	public ArrayList<L1Object> getVisibleObjects(L1Object object, int radius) {
		L1Map map = object.getMap();
		Point pt = object.getLocation();
		ArrayList<L1Object> result = new ArrayList<L1Object>();
		if (map.getId() <= MAX_MAP_ID) {
			for (L1Object element : _visibleObjects.get(map.getId()).values()) {
				if (element.equals(object)) {
					continue;
				}
				if (map != element.getMap()) {
					continue;
				}

				if (radius == -1) {
					if (pt.isInScreen(element.getLocation())) {
						result.add(element);
					}
				} else if (radius == 0) {
					if (pt.isSamePoint(element.getLocation())) {
						result.add(element);
					}
				} else {
					if (pt.getTileLineDistance(element.getLocation()) <= radius) {
						result.add(element);
					}
				}
			}
		}

		return result;
	}

	public ArrayList<L1Object> getVisiblePoint(L1Location loc, int radius) {
		ArrayList<L1Object> result = new ArrayList<L1Object>();
		int mapId = loc.getMapId(); // And called for a serious loop

		if (mapId <= MAX_MAP_ID) {
			for (L1Object element : _visibleObjects.get(mapId).values()) {
				if (mapId != element.getMapId()) {
					continue;
				}

				if (loc.getTileLineDistance(element.getLocation()) <= radius) {
					result.add(element);
				}
			}
		}

		return result;
	}

	public ArrayList<L1PcInstance> getVisiblePlayer(L1Object object) {
		return getVisiblePlayer(object, -1);
	}
	
	public ArrayList<L1PcInstance> getVisiblePlayer(L1Object object, int radius) {
		return getVisiblePlayer(object, radius, false);
	}

	public ArrayList<L1PcInstance> getVisiblePlayer(L1Object object, int radius, boolean ignoreInvisGm) {
		int map = object.getMapId();
		Point pt = object.getLocation();
		ArrayList<L1PcInstance> result = new ArrayList<L1PcInstance>();

		for (L1PcInstance element : _allPlayers.values()) {
			if(ignoreInvisGm && element.isGmInvis()) {
				continue;
			}
			
			if (element.equals(object)) {
				continue;
			}

			if (map != element.getMapId()) {
				continue;
			}

			if (radius == -1) {
				if (pt.isInScreen(element.getLocation())) {
					result.add(element);
				}
			} else if (radius == 0) {
				if (pt.isSamePoint(element.getLocation())) {
					result.add(element);
				}
			} else {
				if (pt.getTileLineDistance(element.getLocation()) <= radius) {
					result.add(element);
				}
			}
		}
		return result;
	}

	public ArrayList<L1PcInstance> getVisiblePlayerExceptTargetSight(
			L1Object object, L1Object target) {
		int map = object.getMapId();
		Point objectPt = object.getLocation();
		Point targetPt = target.getLocation();
		ArrayList<L1PcInstance> result = new ArrayList<L1PcInstance>();

		for (L1PcInstance element : _allPlayers.values()) {
			if (element.equals(object)) {
				continue;
			}

			if (map != element.getMapId()) {
				continue;
			}

			if (Config.PC_RECOGNIZE_RANGE == -1) {
				if (objectPt.isInScreen(element.getLocation())) {
					if (!targetPt.isInScreen(element.getLocation())) {
						result.add(element);
					}
				}
			} else {
				if (objectPt.getTileLineDistance(element.getLocation()) <= Config.PC_RECOGNIZE_RANGE) {
					if (targetPt.getTileLineDistance(element.getLocation()) > Config.PC_RECOGNIZE_RANGE) {
						result.add(element);
					}
				}
			}
		}
		return result;
	}
	
	public ArrayList<L1PcInstance> getRecognizePlayer(L1Object object, boolean ignoreInvisGm) {
		return getVisiblePlayer(object, Config.PC_RECOGNIZE_RANGE, ignoreInvisGm);
	}

	/**
	 * object Players are able to get the range
	 * 
	 * @param object
	 * @return
	 */
	public ArrayList<L1PcInstance> getRecognizePlayer(L1Object object) {
		return getRecognizePlayer(object, false);
	}

	// _allPlayers
	private Collection<L1PcInstance> _allPlayerValues;

	public Collection<L1PcInstance> getAllPlayers() {
		Collection<L1PcInstance> vs = _allPlayerValues;
		return (vs != null) ? vs : (_allPlayerValues = Collections
				.unmodifiableCollection(_allPlayers.values()));
	}

	/**
	 * World in the given name to get the players.
	 * 
	 * @Param name players (capital letters are ignored lowercase)
	 * @Return given name L1PcInstance. If there is no appropriate players to
	 *         return null.
	 */
	public L1PcInstance getPlayer(String name) {
		if (_allPlayers.containsKey(name)) {
			return _allPlayers.get(name);
		}
		for (L1PcInstance each : getAllPlayers()) {
			if (each.getName().equalsIgnoreCase(name)) {
				return each;
			}
		}
		return null;
	}

	// _allPets
	private Collection<L1PetInstance> _allPetValues;

	public Collection<L1PetInstance> getAllPets() {
		Collection<L1PetInstance> vs = _allPetValues;
		return (vs != null) ? vs : (_allPetValues = Collections
				.unmodifiableCollection(_allPets.values()));
	}

	// _allSummons
	private Collection<L1SummonInstance> _allSummonValues;

	public Collection<L1SummonInstance> getAllSummons() {
		Collection<L1SummonInstance> vs = _allSummonValues;
		return (vs != null) ? vs : (_allSummonValues = Collections
				.unmodifiableCollection(_allSummons.values()));
	}

	public final Map<Integer, L1Object> getAllVisibleObjects() {
		return _allObjects;
	}

	public final Map<Integer, L1Object> getVisibleObjects(int mapId) {
		return _visibleObjects.get(mapId);
	}

	public Object getRegion(Object object) {
		return null;
	}

	public void addWar(L1War war) {
		if (!_allWars.contains(war)) {
			_allWars.add(war);
		}
	}

	public void removeWar(L1War war) {
		if (_allWars.contains(war)) {
			_allWars.remove(war);
		}
	}

	// _allWars
	private List<L1War> _allWarList;

	public List<L1War> getWarList() {
		List<L1War> vs = _allWarList;
		return (vs != null) ? vs : (_allWarList = Collections
				.unmodifiableList(_allWars));
	}

	public void storeClan(L1Clan clan) {
		L1Clan temp = getClan(clan.getClanName());
		if (temp == null) {
			_allClans.put(clan.getClanName(), clan);
		}
	}

	public void removeClan(L1Clan clan) {
		L1Clan temp = getClan(clan.getClanName());
		if (temp != null) {
			_allClans.remove(clan.getClanName());
		}
	}

	public L1Clan getClan(String clan_name) {
		return _allClans.get(clan_name);
	}

	// _allClans
	private Collection<L1Clan> _allClanValues;

	public Collection<L1Clan> getAllClans() {
		Collection<L1Clan> vs = _allClanValues;
		return (vs != null) ? vs : (_allClanValues = Collections
				.unmodifiableCollection(_allClans.values()));
	}

	public void setWeather(int weather) {
		_weather = weather;
	}

	public int getWeather() {
		return _weather;
	}

	public void set_worldChatElabled(boolean flag) {
		_worldChatEnabled = flag;
	}

	public boolean isWorldChatElabled() {
		return _worldChatEnabled;
	}

	public void setProcessingContributionTotal(boolean flag) {
		_processingContributionTotal = flag;
	}

	public boolean isProcessingContributionTotal() {
		return _processingContributionTotal;
	}

	public void broadcastPacketToAll(ServerBasePacket packet) {
		_log.trace("players to notify : " + getAllPlayers().size());
		for (L1PcInstance pc : getAllPlayers()) {
			pc.sendPackets(packet);
		}
	}

	public void broadcastServerMessage(String message) {
		broadcastPacketToAll(new S_SystemMessage(message));
	}
}
