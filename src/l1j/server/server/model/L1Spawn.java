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
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTime;
import l1j.server.server.model.gametime.L1GameTimeAdapter;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1SpawnTime;
import l1j.server.server.types.Point;

public class L1Spawn extends L1GameTimeAdapter {
	private static Logger _log = Logger.getLogger(L1Spawn.class.getName());
	private final L1Npc _template;
	private int _id; // just to find this in the spawn table
	private String _location;
	private int _maximumCount;
	private int _npcid;
	private int _groupId;
	private int _locx;
	private int _locy;
	private int _randomx;
	private int _randomy;
	private int _locx1;
	private int _locy1;
	private int _locx2;
	private int _locy2;
	private int _heading;
	private int _minRespawnDelay;
	private int _maxRespawnDelay;
	private short _mapid;
	private boolean _respaenScreen;
	private int _movementDistance;
	private boolean _rest;
	private int _spawnType;
	private int _delayInterval;
	private L1SpawnTime _time;
	private HashMap<Integer, Point> _homePoint = null; // init spawn of individual objects in the home points
	private List<L1NpcInstance> _mobs = new ArrayList<L1NpcInstance>();
	private static Random _random = new Random();
	private String _name;
	private int _spawnHome;
	private int _spawnHomeRange;
	private int _spawnHomeCount;
	private int _spawnHomeDelay;

	private class SpawnTask implements Runnable {
		private int _spawnNumber;
		private int _objectId;

		private SpawnTask(int spawnNumber, int objectId) {
			_spawnNumber = spawnNumber;
			_objectId = objectId;
		}

		@Override
		public void run() {
			doSpawn(_spawnNumber, _objectId);
		}
	}

	public L1Spawn(L1Npc mobTemplate) {
		_template = mobTemplate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public short getMapId() {
		return _mapid;
	}

	public void setMapId(short _mapid) {
		this._mapid = _mapid;
	}

	public boolean isRespawnScreen() {
		return _respaenScreen;
	}

	public void setRespawnScreen(boolean flag) {
		_respaenScreen = flag;
	}

	public int getMovementDistance() {
		return _movementDistance;
	}

	public void setMovementDistance(int i) {
		_movementDistance = i;
	}

	public int getAmount() {
		return _maximumCount;
	}

	public int getGroupId() {
		return _groupId;
	}

	public int getId() {
		return _id;
	}

	public String getLocation() {
		return _location;
	}

	public int getLocX() {
		return _locx;
	}

	public int getLocY() {
		return _locy;
	}

	public int getNpcId() {
		return _npcid;
	}

	public int getHeading() {
		return _heading;
	}

	public int getRandomx() {
		return _randomx;
	}

	public int getRandomy() {
		return _randomy;
	}

	public int getLocX1() {
		return _locx1;
	}

	public int getLocY1() {
		return _locy1;
	}

	public int getLocX2() {
		return _locx2;
	}

	public int getLocY2() {
		return _locy2;
	}

	public int getMinRespawnDelay() {
		return _minRespawnDelay;
	}

	public int getMaxRespawnDelay() {
		return _maxRespawnDelay;
	}

	public int getSpawnHome() {
		return _spawnHome;
	}
	public int getSpawnHomeRange() {
		return _spawnHomeRange;
	}
	public int getSpawnHomeCount() {
		return _spawnHomeCount;
	}
	public int getSpawnHomeDelay() {
		return _spawnHomeDelay;
	}

	public void setAmount(int amount) {
		_maximumCount = amount;
	}

	public void setId(int id) {
		_id = id;
	}

	public void setGroupId(int i) {
		_groupId = i;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public void setLocX(int locx) {
		_locx = locx;
	}

	public void setLocY(int locy) {
		_locy = locy;
	}

	public void setNpcid(int npcid) {
		_npcid = npcid;
	}

	public void setHeading(int heading) {
		_heading = heading;
	}

	public void setRandomx(int randomx) {
		_randomx = randomx;
	}

	public void setRandomy(int randomy) {
		_randomy = randomy;
	}

	public void setLocX1(int locx1) {
		_locx1 = locx1;
	}

	public void setLocY1(int locy1) {
		_locy1 = locy1;
	}

	public void setLocX2(int locx2) {
		_locx2 = locx2;
	}

	public void setLocY2(int locy2) {
		_locy2 = locy2;
	}

	public void setMinRespawnDelay(int i) {
		_minRespawnDelay = i;
	}

	public void setMaxRespawnDelay(int i) {
		_maxRespawnDelay = i;
	}	
	public void setSpawnHome(int i) {
		_spawnHome = i;
	}

	public void setSpawnHomeRange(int i) {
		_spawnHomeRange = i;
	}
	public void setSpawnHomeCount(int i) {
		_spawnHomeCount = i;
	}
	public void setSpawnHomeDelay(int i) {
		_spawnHomeDelay = i;
	}

	private int calcRespawnDelay() {
		int respawnDelay = _minRespawnDelay * 1000;
		if (_delayInterval > 0) {
			respawnDelay += _random.nextInt(_delayInterval) * 1000;
		}
		L1GameTime currentTime = L1GameTimeClock.getInstance().currentTime();
		if (_time != null && !_time.getTimePeriod().includes(currentTime)) {
			long diff = (_time.getTimeStart().getTime() - currentTime.toTime().getTime());
			if (diff < 0) {
				diff += 24 * 1000L * 3600L;
			}
			diff /= 6; // real time to game time
			respawnDelay = (int) diff;
		}
		return respawnDelay;
	}

	/**
	 * SpawnTask To start.
	 * @param spawnNumber L1Spawn Which is administered by the numbers. 
	 * Home to specify what point does not exist and it's good.
	 */
	public void executeSpawnTask(int spawnNumber, int objectId) {
		SpawnTask task = new SpawnTask(spawnNumber, objectId);
		GeneralThreadPool.getInstance().schedule(task, calcRespawnDelay());
	}

	private boolean _initSpawn = false;
	private boolean _spawnHomePoint;

	public void init() {
		if (_time != null && _time.isDeleteAtEndTime()) {
			L1GameTimeClock.getInstance().addListener(this);
		}
		_delayInterval = _maxRespawnDelay - _minRespawnDelay;
		_initSpawn = true;
		// Points to give the home or
		if (getSpawnHome() == 1
				&& getSpawnHomeCount() <= getAmount()
				&& getSpawnHomeDelay() >= getMinRespawnDelay()
				&& isAreaSpawn()) {
			_spawnHomePoint = true;
			_homePoint = new HashMap<Integer, Point>();
		}
		int spawnNum = 0;
		while (spawnNum < _maximumCount) {
			// spawnNum maxmumCount
			doSpawn(++spawnNum);
		}
		_initSpawn = false;
	}

	/**
	 * If you have a point home, spawnNumber based spawn.
	 * If not, spawnNumber not used.
	 */
	protected void doSpawn(int spawnNumber) {
		if (_time != null
				&& !_time.getTimePeriod().includes(
						L1GameTimeClock.getInstance().currentTime())) {
			executeSpawnTask(spawnNumber, 0);
			return;
		}
		doSpawn(spawnNumber, 0);
	}

	protected void doSpawn(int spawnNumber, int objectId) {
		L1NpcInstance mob = null;
		try {
			int newlocx = getLocX();
			int newlocy = getLocY();
			int tryCount = 0;

			mob = NpcTable.getInstance().newNpcInstance(_template);
			synchronized (_mobs) {
				_mobs.add(mob);
			}
			if (objectId == 0) {
				mob.setId(IdFactory.getInstance().nextId());
			} else {
				mob.setId(objectId);
			}
			if (0 <= getHeading() && getHeading() <= 7) {
				mob.setHeading(getHeading());
			} else {
				// heading Value is not correct
				mob.setHeading(5);
			}

			int npcId = mob.getNpcTemplate().get_npcId();
			if (npcId == 45488 && getMapId() == 9) {
				mob.setMap((short) (getMapId() + _random.nextInt(2)));
			} else if (npcId == 45601 && getMapId() == 11) {
				mob.setMap((short) (getMapId() + _random.nextInt(3)));
			} else {
				mob.setMap(getMapId());
			}
			mob.setMovementDistance(getMovementDistance());
			mob.setRest(isRest());
			while (tryCount <= 50) {
				switch (getSpawnType()) {
				case SPAWN_TYPE_PC_AROUND: // Area real PC to type
					if (!_initSpawn) { // The initial deployment is usually spawn unconditionally
						ArrayList<L1PcInstance> players = new ArrayList<L1PcInstance>();
						for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
							if (getMapId() == pc.getMapId()) {
								players.add(pc);
							}
						}
						if (players.size() > 0) {
							L1PcInstance pc = players.get(_random
									.nextInt(players.size()));
							L1Location loc = pc.getLocation().randomLocation(
									PC_AROUND_DISTANCE, false);
							newlocx = loc.getX();
							newlocy = loc.getY();
							break;
						}
					}
					// PC floor if you have no way normal appearance
				default:
					if (isAreaSpawn()) { // Coordinates of the range specified in the case
						Point pt = null;
						if (_spawnHomePoint
								&& null != (pt = _homePoint.get(spawnNumber))) { // Home to the original point out that if re-emergence
							L1Location loc = new L1Location(pt, getMapId())
									.randomLocation(
											getSpawnHomeRange(),
											false);
							newlocx = loc.getX();
							newlocy = loc.getY();
						} else {
							int rangeX = getLocX2() - getLocX1();
							int rangeY = getLocY2() - getLocY1();
							newlocx = _random.nextInt(rangeX) + getLocX1();
							newlocy = _random.nextInt(rangeY) + getLocY1();
						}
						if (tryCount > 49) { // When that happens appearance position locx, locy value
							newlocx = getLocX();
							newlocy = getLocY();
						}
					} else if (isRandomSpawn()) { // Coordinate random value is if
						newlocx = (getLocX() + ((int) (Math.random() * getRandomx()) - (int) (Math
								.random() * getRandomx())));
						newlocy = (getLocY() + ((int) (Math.random() * getRandomy()) - (int) (Math
								.random() * getRandomy())));
					} else { // Both did not specify if
						newlocx = getLocX();
						newlocy = getLocY();
					}
				}
				mob.setX(newlocx);
				mob.setHomeX(newlocx);
				mob.setY(newlocy);
				mob.setHomeY(newlocy);

				if (mob.getMap().isInMap(mob.getLocation())
						&& mob.getMap().isPassable(mob.getLocation())) {
					if (mob instanceof L1MonsterInstance) {
						if (isRespawnScreen()) {
							break;
						}
						L1MonsterInstance mobtemp = (L1MonsterInstance) mob;
						if (L1World.getInstance().getVisiblePlayer(mobtemp)
								.size() == 0) {
							break;
						}
						// To make the PC screen can not occur in the three seconds after the re-scheduling 
						SpawnTask task = new SpawnTask(spawnNumber, mob.getId());
						GeneralThreadPool.getInstance().schedule(task, 3000L);
						return;
					}
				}
				tryCount++;
			}
			if (mob instanceof L1MonsterInstance) {
				((L1MonsterInstance) mob).initHide();
			}
			mob.setSpawn(this);
			mob.setreSpawn(true);
			mob.setSpawnNumber(spawnNumber); // Number of L1Spawn (Home points)
			if (_initSpawn && _spawnHomePoint) { // Home points to set the initial deployment
				Point pt = new Point(mob.getX(), mob.getY());
				_homePoint.put(spawnNumber, pt); // This saved a point when the re-emergence use
			}
			if (mob instanceof L1MonsterInstance) {
				if (mob.getMapId() == 666) {
					((L1MonsterInstance) mob).set_storeDroped(true);
				}
			}
			if (npcId == 45573 && mob.getMapId() == 2) {
				for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
					if (pc.getMapId() == 2) {
						L1Teleport.teleport(pc, 32664, 32797, (short) 2, 0,
								true);
					}
				}
			}

			if (npcId == 46142 && mob.getMapId() == 73
					|| npcId == 46141 && mob.getMapId() == 74) {
				for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
					if (pc.getMapId() >= 72 && pc.getMapId() <= 74) {
						L1Teleport.teleport(pc, 32840, 32833, (short) 72,
								pc.getHeading(), true);
					}
				}
			}
			doCrystalCave(npcId);
			L1World.getInstance().storeObject(mob);
			L1World.getInstance().addVisibleObject(mob);

			if (mob instanceof L1MonsterInstance) {
				L1MonsterInstance mobtemp = (L1MonsterInstance) mob;
				if (!_initSpawn && mobtemp.getHiddenStatus() == 0) {
					mobtemp.onNpcAI(); // Monster AI to start
				}
			}
			if (getGroupId() != 0) {
				L1MobGroupSpawn.getInstance().doSpawn(mob, getGroupId(),
						isRespawnScreen(), _initSpawn);
			}
			mob.turnOnOffLight();
			mob.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE);
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	public void setRest(boolean flag) {
		_rest = flag;
	}

	public boolean isRest() {
		return _rest;
	}

	private static final int SPAWN_TYPE_PC_AROUND = 1;
	private static final int PC_AROUND_DISTANCE = 30;

	private int getSpawnType() {
		return _spawnType;
	}

	public void setSpawnType(int type) {
		_spawnType = type;
	}

	private boolean isAreaSpawn() {
		return getLocX1() != 0 && getLocY1() != 0 && getLocX2() != 0
				&& getLocY2() != 0;
	}

	private boolean isRandomSpawn() {
		return getRandomx() != 0 || getRandomy() != 0;
	}

	public L1SpawnTime getTime() {
		return _time;
	}

	public void setTime(L1SpawnTime time) {
		_time = time;
	}

	@Override
	public void onMinuteChanged(L1GameTime time) {
		if (_time.getTimePeriod().includes(time)) {
			return;
		}
		synchronized (_mobs) {
			if (_mobs.isEmpty()) {
				return;
			}
			for (L1NpcInstance mob : _mobs) {
				mob.setCurrentHpDirect(0);
				mob.setDead(true);
				mob.setStatus(ActionCodes.ACTION_Die);
				mob.deleteMe();
			}
			_mobs.clear();
		}
	}

	public static void doCrystalCave(int npcId) {
		int[] npcId2 = { 46143, 46144, 46145, 46146, 46147,
				46148, 46149, 46150, 46151, 46152 };
		int[] doorId = { 5001, 5002, 5003, 5004, 5005, 5006,
				5007, 5008, 5009, 5010};

		for (int i = 0; i < npcId2.length; i++) {
			if (npcId == npcId2[i]) {
				closeDoorInCrystalCave(doorId[i]);
			}
		}
	}

	private static void closeDoorInCrystalCave(int doorId) {
		for (L1Object object : L1World.getInstance().getObject()) {
			if (object instanceof L1DoorInstance) {
				L1DoorInstance door = (L1DoorInstance) object;
				if (door.getDoorId() == doorId) {
					door.close();
				}
			}
		}
	}
}
