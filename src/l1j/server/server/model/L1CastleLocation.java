/**
 * GPLv2. See License.
 */
package l1j.server.server.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import l1j.server.server.datatables.CastleTable;
import l1j.server.server.model.gametime.L1GameTime;
import l1j.server.server.model.gametime.L1GameTimeAdapter;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.templates.L1Castle;

public class L1CastleLocation {

	public static final int KENT_CASTLE_ID = 1;
	public static final int OT_CASTLE_ID = 2;
	public static final int WW_CASTLE_ID = 3;
	public static final int GIRAN_CASTLE_ID = 4;
	public static final int HEINE_CASTLE_ID = 5;
	public static final int DOWA_CASTLE_ID = 6;
	public static final int ADEN_CASTLE_ID = 7;
	public static final int DIAD_CASTLE_ID = 8;

	private static final L1Location KentTower = new L1Location(33170, 32774, 4);
	private static final L1MapArea KentArea = new L1MapArea(33089, 32717,
			33219, 32827, 4);
	private static final short KENT_INNER_CASTLE_MAP = 15;

	private static final short OT_MAP = 4;
	private static final L1Location OTTower = new L1Location(32800, 32290,
			OT_MAP);
	private static final L1MapArea OTArea = new L1MapArea(32750, 32250, 32850,
			32350, OT_MAP);

	private static final L1Location WWTower = new L1Location(32675, 33408, 4);
	private static final L1MapArea WWArea = new L1MapArea(32571, 33350, 32721,
			33460, 4);
	private static final short WW_INNER_CASTLE_MAP = 29;

	private static final L1Location GiranTower = new L1Location(33631, 32678, 4);
	private static final L1MapArea GiranArea = new L1MapArea(33559, 32615,
			33686, 32755, 4);
	private static final short GIRAN_INNER_CASTLE_MAP = 52;

	private static final L1Location HeineTower = new L1Location(33524, 33396, 4);
	private static final L1MapArea HeineArea = new L1MapArea(33458, 33315,
			33583, 33490, 4);
	private static final short HEINE_INNER_CASTLE_MAP = 64;

	private static final short DOWA_MAP = 66;
	private static final L1Location DowaTower = new L1Location(32828, 32818,
			DOWA_MAP);
	private static final L1MapArea DowaArea = new L1MapArea(32755, 32790,
			32870, 32920, DOWA_MAP);

	private static final L1Location AdenTower = new L1Location(34090, 33260, 4);
	private static final L1MapArea AdenArea = new L1MapArea(34007, 33172,
			34162, 33332, 4);
	private static final short ADEN_INNER_CASTLE_MAP = 300;
	private static final L1Location AdenSub1 = new L1Location(34057, 33291, 4);
	private static final L1Location AdenSub2 = new L1Location(34123, 33291, 4);
	private static final L1Location AdenSub3 = new L1Location(34057, 33230, 4);
	private static final L1Location AdenSub4 = new L1Location(34123, 33230, 4);

	private static final L1Location DiadTower = new L1Location(33033, 32895,
			320);
	private static final L1MapArea DiadArea = new L1MapArea(32888, 32839,
			33070, 32953, 320);
	private static final short DIAD_INNER_CASTLE_MAP = 330;

	private static final Map<Integer, L1Location> _towers = new HashMap<Integer, L1Location>();

	private static final Map<Integer, L1MapArea> _areas = new HashMap<Integer, L1MapArea>();

	private static final Map<Integer, Integer> _innerTowerMaps = new HashMap<Integer, Integer>();

	private static final Map<Integer, L1Location> _subTowers = new HashMap<Integer, L1Location>();

	static {
		_towers.put(KENT_CASTLE_ID, KentTower);
		_towers.put(OT_CASTLE_ID, OTTower);
		_towers.put(WW_CASTLE_ID, WWTower);
		_towers.put(GIRAN_CASTLE_ID, GiranTower);
		_towers.put(HEINE_CASTLE_ID, HeineTower);
		_towers.put(DOWA_CASTLE_ID, DowaTower);
		_towers.put(ADEN_CASTLE_ID, AdenTower);
		_towers.put(DIAD_CASTLE_ID, DiadTower);

		_areas.put(KENT_CASTLE_ID, KentArea);
		_areas.put(OT_CASTLE_ID, OTArea);
		_areas.put(WW_CASTLE_ID, WWArea);
		_areas.put(GIRAN_CASTLE_ID, GiranArea);
		_areas.put(HEINE_CASTLE_ID, HeineArea);
		_areas.put(DOWA_CASTLE_ID, DowaArea);
		_areas.put(ADEN_CASTLE_ID, AdenArea);
		_areas.put(DIAD_CASTLE_ID, DiadArea);

		_innerTowerMaps.put(KENT_CASTLE_ID, (int) KENT_INNER_CASTLE_MAP);
		_innerTowerMaps.put(WW_CASTLE_ID, (int) WW_INNER_CASTLE_MAP);
		_innerTowerMaps.put(GIRAN_CASTLE_ID, (int) GIRAN_INNER_CASTLE_MAP);
		_innerTowerMaps.put(HEINE_CASTLE_ID, (int) HEINE_INNER_CASTLE_MAP);
		_innerTowerMaps.put(ADEN_CASTLE_ID, (int) ADEN_INNER_CASTLE_MAP);
		_innerTowerMaps.put(DIAD_CASTLE_ID, (int) DIAD_INNER_CASTLE_MAP);

		_subTowers.put(1, AdenSub1);
		_subTowers.put(2, AdenSub2);
		_subTowers.put(3, AdenSub3);
		_subTowers.put(4, AdenSub4);
	}

	private L1CastleLocation() {
	}

	public static int getCastleId(L1Location loc) {
		for (Map.Entry<Integer, L1Location> entry : _towers.entrySet()) {
			if (entry.getValue().equals(loc)) {
				return entry.getKey();
			}
		}
		return 0;
	}

	public static int getCastleId(int locx, int locy, short mapid) {
		return getCastleId(new L1Location(locx, locy, mapid));
	}

	public static int getCastleIdByArea(L1Location loc) {
		for (Map.Entry<Integer, L1MapArea> entry : _areas.entrySet()) {
			if (entry.getValue().contains(loc)) {
				return entry.getKey();
			}
		}
		for (Map.Entry<Integer, Integer> entry : _innerTowerMaps.entrySet()) {
			if (entry.getValue() == loc.getMapId()) {
				return entry.getKey();
			}
		}
		return 0;
	}

	public static int getCastleIdByArea(L1Character cha) {
		return getCastleIdByArea(cha.getLocation());
	}

	public static boolean checkInWarArea(int castleId, L1Location loc) {
		return castleId == getCastleIdByArea(loc);
	}

	public static boolean checkInWarArea(int castleId, L1Character cha) {
		return checkInWarArea(castleId, cha.getLocation());
	}

	public static boolean checkInAllWarArea(L1Location loc) {
		return 0 != getCastleIdByArea(loc);
	}

	public static boolean checkInAllWarArea(int locx, int locy, short mapid) {
		return checkInAllWarArea(new L1Location(locx, locy, mapid));
	}

	public static int[] getTowerLoc(int castleId) {
		int[] result = new int[3];
		L1Location loc = _towers.get(castleId);
		if (loc != null) {
			result[0] = loc.getX();
			result[1] = loc.getY();
			result[2] = loc.getMapId();
		}
		return result;
	}

	public static int[] getWarArea(int castleId) {
		L1MapArea area = _areas.get(castleId);
		if (area == null)
			return new int[5];
		return new int[] { area.getLeft(), area.getRight(), area.getTop(),
				area.getBottom(), area.getMapId() };
	}

	private static final Map<Integer, int[]> castleLocations = new HashMap<Integer, int[]>();

	static {
		castleLocations.put(KENT_CASTLE_ID, new int[] { 32731, 32810,
				KENT_INNER_CASTLE_MAP });
		castleLocations.put(OT_CASTLE_ID, new int[] { 32800, 32277, OT_MAP });
		castleLocations.put(WW_CASTLE_ID, new int[] { 32730, 32814,
				WW_INNER_CASTLE_MAP });
		castleLocations.put(GIRAN_CASTLE_ID, new int[] { 32724, 32827,
				GIRAN_INNER_CASTLE_MAP });
		castleLocations.put(HEINE_CASTLE_ID, new int[] { 32568, 32855,
				HEINE_INNER_CASTLE_MAP });
		castleLocations.put(DOWA_CASTLE_ID,
				new int[] { 32853, 32810, DOWA_MAP });
		castleLocations.put(ADEN_CASTLE_ID, new int[] { 32892, 32572,
				ADEN_INNER_CASTLE_MAP });
		castleLocations.put(DIAD_CASTLE_ID, new int[] { 32733, 32985,
				DIAD_INNER_CASTLE_MAP });
	}

	public static int[] getCastleLoc(int castleId) {
		int[] location = castleLocations.get(castleId);
		return location == null ? new int[3] : location;
	}

	public static int[] getGetBackLoc(int castle_id) {
		int[] loc;
		if (castle_id == KENT_CASTLE_ID) {
			loc = L1TownLocation.getGetBackLoc(L1TownLocation.TOWNID_KENT);
		} else if (castle_id == OT_CASTLE_ID) {
			loc = L1TownLocation
					.getGetBackLoc(L1TownLocation.TOWNID_ORCISH_FOREST);
		} else if (castle_id == WW_CASTLE_ID) {
			loc = L1TownLocation.getGetBackLoc(L1TownLocation.TOWNID_WINDAWOOD);
		} else if (castle_id == GIRAN_CASTLE_ID) {
			loc = L1TownLocation.getGetBackLoc(L1TownLocation.TOWNID_GIRAN);
		} else if (castle_id == HEINE_CASTLE_ID) {
			loc = L1TownLocation.getGetBackLoc(L1TownLocation.TOWNID_HEINE);
		} else if (castle_id == DOWA_CASTLE_ID) {
			loc = L1TownLocation.getGetBackLoc(L1TownLocation.TOWNID_WERLDAN);
		} else if (castle_id == ADEN_CASTLE_ID) {
			loc = L1TownLocation.getGetBackLoc(L1TownLocation.TOWNID_ADEN);
		} else if (castle_id == DIAD_CASTLE_ID) {
			new Random();
			int rnd = ThreadLocalRandom.current().nextInt(3);
			loc = new int[3];
			if (rnd == 0) {
				loc[0] = 32792;
				loc[1] = 32807;
				loc[2] = 310;
			} else if (rnd == 1) {
				loc[0] = 32816;
				loc[1] = 32820;
				loc[2] = 310;
			} else if (rnd == 2) {
				loc[0] = 32823;
				loc[1] = 32797;
				loc[2] = 310;
			}
		} else {
			loc = L1TownLocation
					.getGetBackLoc(L1TownLocation.TOWNID_SILVER_KNIGHT_TOWN);
		}
		return loc;
	}

	/**
	 * Gets the id of the castle associated with the given npc.
	 */
	public static int getCastleIdByNpcid(int npcid) {
		switch (L1TownLocation.getTownIdByNpcid(npcid)) {
		case L1TownLocation.TOWNID_KENT:
		case L1TownLocation.TOWNID_GLUDIO:
			return KENT_CASTLE_ID;
		case L1TownLocation.TOWNID_ORCISH_FOREST:
			return OT_CASTLE_ID;
		case L1TownLocation.TOWNID_SILVER_KNIGHT_TOWN:
		case L1TownLocation.TOWNID_WINDAWOOD:
			return WW_CASTLE_ID;
		case L1TownLocation.TOWNID_TALKING_ISLAND:
		case L1TownLocation.TOWNID_GIRAN:
			return GIRAN_CASTLE_ID;
		case L1TownLocation.TOWNID_HEINE:
			return HEINE_CASTLE_ID;
		case L1TownLocation.TOWNID_WERLDAN:
		case L1TownLocation.TOWNID_OREN:
			return DOWA_CASTLE_ID;
		case L1TownLocation.TOWNID_ADEN:
			return ADEN_CASTLE_ID;
		case L1TownLocation.TOWNID_OUM_DUNGEON:
			return DIAD_CASTLE_ID;
		default:
			return 0;
		}
	}

	public static int getCastleTaxRateByNpcId(int npcId) {
		int castleId = getCastleIdByNpcid(npcId);
		if (castleId != 0) {
			return _castleTaxRate.get(castleId);
		}
		return 0;
	}

	private static HashMap<Integer, Integer> _castleTaxRate = new HashMap<Integer, Integer>();
	private static L1CastleTaxRateListener _listener;

	// GameServer#initialize,L1CastleTaxRateListener#onDayChanged
	public static void setCastleTaxRate() {
		for (L1Castle castle : CastleTable.getInstance().getCastleTableList()) {
			_castleTaxRate.put(castle.getId(), castle.getTaxRate());
		}
		if (_listener == null) {
			_listener = new L1CastleTaxRateListener();
			L1GameTimeClock.getInstance().addListener(_listener);
		}
	}

	private static class L1CastleTaxRateListener extends L1GameTimeAdapter {
		@Override
		public void onDayChanged(L1GameTime time) {
			L1CastleLocation.setCastleTaxRate();
		}
	}

	public static int[] getSubTowerLoc(int no) {
		int[] result = new int[3];
		L1Location loc = _subTowers.get(no);
		if (loc != null) {
			result[0] = loc.getX();
			result[1] = loc.getY();
			result[2] = loc.getMapId();
		}
		return result;
	}
}
