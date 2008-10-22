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

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import l1j.server.Config;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.IdFactory;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.types.Point;

public class L1Spawn {
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
	@SuppressWarnings("unchecked")
	private final Constructor _constructor;
	private short _mapid;
	private boolean _respaenScreen;
	private int _movementDistance;
	private boolean _rest;
	private int _spawnType;
	private int _delayInterval;
	private HashMap<Integer, Point> _homePoint = null; // init spawn of individual objects in the home points

	private static Random _random = new Random();

	private String _name;

	private class SpawnTask implements Runnable {
		private int _spawnNumber;

		private SpawnTask(int spawnNumber) {
			_spawnNumber = spawnNumber;
		}

		@Override
		public void run() {
			doSpawn(_spawnNumber);
		}
	}

	public L1Spawn(L1Npc mobTemplate) throws SecurityException,
			ClassNotFoundException {
		_template = mobTemplate;
		String implementationName = _template.getImpl();
		_constructor = Class.forName(
				"l1j.server.server.model.Instance." + implementationName
						+ "Instance").getConstructors()[0];
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

	private int calcRespawnDelay() {
		int respawnDelay = _minRespawnDelay * 1000;
		if (_delayInterval > 0) {
			respawnDelay += _random.nextInt(_delayInterval) * 1000;
		}
		return respawnDelay;
	}

	/**
	 * SpawnTask To start.
	 * @param spawnNumber L1Spawn Which is administered by the numbers. 
	 * Home to specify what point does not exist and it's good.
	 */
	public void executeSpawnTask(int spawnNumber) {
		SpawnTask task = new SpawnTask(spawnNumber);
		GeneralThreadPool.getInstance().schedule(task, calcRespawnDelay());
	}

	private boolean _initSpawn = false;

	private boolean _spawnHomePoint;

	public void init() {
		_delayInterval = _maxRespawnDelay - _minRespawnDelay;
		_initSpawn = true;
		// Points to give the home or
		if (Config.SPAWN_HOME_POINT
				&& Config.SPAWN_HOME_POINT_COUNT <= getAmount()
				&& Config.SPAWN_HOME_POINT_DELAY >= getMinRespawnDelay()
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
		L1NpcInstance mob = null;
		try {
			Object parameters[] = { _template };

			int newlocx = getLocX();
			int newlocy = getLocY();
			int tryCount = 0;

			mob = (L1NpcInstance) _constructor.newInstance(parameters);
			mob.setId(IdFactory.getInstance().nextId());

			if (0 <= getHeading() && getHeading() <= 7) {
				mob.setHeading(getHeading());
			} else {
				// heading Value is not correct
				mob.setHeading(5);
			}

			if (mob.getNpcTemplate().get_npcId() == 45488 && getMapId() == 9) { 
				mob.setMap((short) (getMapId() + _random.nextInt(2)));
			} else if (mob.getNpcTemplate().get_npcId() == 45601
					&& getMapId() == 11) { 
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
						for (L1PcInstance pc : L1World.getInstance()
								.getAllPlayers()) {
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
						if (!_initSpawn && _spawnHomePoint) { // Home to the original point out that if re-emergence
							Point pt = _homePoint.get(spawnNumber);
							L1Location loc = new L1Location(pt, getMapId())
									.randomLocation(
											Config.SPAWN_HOME_POINT_RANGE,
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
						&& mob.getMap().isPassable(mob.getLocation())
						&& mob.getPassispeed() > 0 || mob.getPassispeed() == 0) {
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
						SpawnTask task = new SpawnTask(spawnNumber);
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

	//private static final int SPAWN_TYPE_NORMAL = 0;
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
}
