/**
 * GPLv2. See License.
 */
package l1j.server.server.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import l1j.server.server.datatables.TownTable;
import l1j.server.server.templates.L1Town;
import l1j.server.server.types.Point;

public class L1TownLocation {
	private static final Random random = new Random();

	public static final int TOWNID_TALKING_ISLAND = 1;
	public static final int TOWNID_SILVER_KNIGHT_TOWN = 2;
	public static final int TOWNID_GLUDIO = 3;
	public static final int TOWNID_ORCISH_FOREST = 4;
	public static final int TOWNID_WINDAWOOD = 5;
	public static final int TOWNID_KENT = 6;
	public static final int TOWNID_GIRAN = 7;
	public static final int TOWNID_HEINE = 8;
	public static final int TOWNID_WERLDAN = 9;
	public static final int TOWNID_OREN = 10;
	public static final int TOWNID_ELVEN_FOREST = 11;
	public static final int TOWNID_ADEN = 12;
	public static final int TOWNID_SILENT_CAVERN = 13;
	public static final int TOWNID_OUM_DUNGEON = 14;
	public static final int TOWNID_RESISTANCE = 15;
	public static final int TOWNID_PIRATE_ISLAND = 16;
	public static final int TOWNID_RECLUSE_VILLAGE = 17;

	private static final Point[] GETBACK_LOC_TALKING_ISLAND = {
			new Point(32600, 32942), new Point(32574, 32944),
			new Point(32580, 32923), new Point(32557, 32975),
			new Point(32597, 32914), new Point(32580, 32974), };

	private static final Point[] GETBACK_LOC_SILVER_KNIGHT_TOWN = {
			new Point(33071, 33402), new Point(33091, 33396),
			new Point(33085, 33402), new Point(33097, 33366),
			new Point(33110, 33365), new Point(33072, 33392), };

	private static final Point[] GETBACK_LOC_GLUDIO = {
			new Point(32601, 32757), new Point(32625, 32809),
			new Point(32611, 32726), new Point(32612, 32781),
			new Point(32605, 32761), new Point(32614, 32739),
			new Point(32612, 32775), };

	private static final Point[] GETBACK_LOC_ORCISH_FOREST = {
			new Point(32750, 32435), new Point(32745, 32447),
			new Point(32738, 32452), new Point(32741, 32436),
			new Point(32749, 32446), };

	private static final Point[] GETBACK_LOC_WINDAWOOD = {
			new Point(32608, 33178), new Point(32626, 33185),
			new Point(32630, 33179), new Point(32625, 33207),
			new Point(32638, 33203), new Point(32621, 33179), };

	private static final Point[] GETBACK_LOC_KENT = { new Point(33048, 32750),
			new Point(33059, 32768), new Point(33047, 32761),
			new Point(33059, 32759), new Point(33051, 32775),
			new Point(33048, 32778), new Point(33064, 32773),
			new Point(33057, 32748), };

	private static final Point[] GETBACK_LOC_GIRAN = { new Point(33435, 32803),
			new Point(33439, 32817), new Point(33440, 32809),
			new Point(33419, 32810), new Point(33426, 32823),
			new Point(33418, 32818), new Point(33432, 32824), };

	private static final Point[] GETBACK_LOC_HEINE = { new Point(33593, 33242),
			new Point(33593, 33248), new Point(33604, 33236),
			new Point(33599, 33236), new Point(33610, 33247),
			new Point(33610, 33241), new Point(33599, 33252),
			new Point(33605, 33252), };

	private static final Point[] GETBACK_LOC_WERLDAN = {
			new Point(33702, 32492), new Point(33747, 32508),
			new Point(33696, 32498), new Point(33723, 32512),
			new Point(33710, 32521), new Point(33724, 32488),
			new Point(33693, 32513), };

	private static final Point[] GETBACK_LOC_OREN = { new Point(34086, 32280),
			new Point(34037, 32230), new Point(34022, 32254),
			new Point(34021, 32269), new Point(34044, 32290),
			new Point(34049, 32316), new Point(34081, 32249),
			new Point(34074, 32313), new Point(34064, 32230), };

	private static final Point[] GETBACK_LOC_ELVEN_FOREST = {
			new Point(33065, 32358), new Point(33052, 32313),
			new Point(33030, 32342), new Point(33068, 32320),
			new Point(33071, 32314), new Point(33030, 32370),
			new Point(33076, 32324), new Point(33068, 32336), };

	private static final Point[] GETBACK_LOC_ADEN = { new Point(33915, 33114),
			new Point(34061, 33115), new Point(34090, 33168),
			new Point(34011, 33136), new Point(34093, 33117),
			new Point(33959, 33156), new Point(33992, 33120),
			new Point(34047, 33156), };

	private static final Point[] GETBACK_LOC_SILENT_CAVERN = {
			new Point(32856, 32898), new Point(32860, 32916),
			new Point(32868, 32893), new Point(32875, 32903),
			new Point(32855, 32898), };

	private static final Point[] GETBACK_LOC_OUM_DUNGEON = {
			new Point(32818, 32805), new Point(32800, 32798),
			new Point(32815, 32819), new Point(32823, 32811),
			new Point(32817, 32828), };

	private static final Point[] GETBACK_LOC_RESISTANCE = {
			new Point(32570, 32667), new Point(32559, 32678),
			new Point(32564, 32683), new Point(32574, 32661),
			new Point(32576, 32669), new Point(32572, 32662), };

	private static final Point[] GETBACK_LOC_PIRATE_ISLAND = {
			new Point(32431, 33058), new Point(32407, 33054), };

	private static final Point[] GETBACK_LOC_RECLUSE_VILLAGE = {
			new Point(32599, 32916), new Point(32599, 32923),
			new Point(32603, 32908), new Point(32595, 32908),
			new Point(32591, 32918), };

	private static final Map<Integer, Point[]> townToEscapePoints = new HashMap<Integer, Point[]>();

	private static final Map<Integer, Integer> townToMap = new HashMap<Integer, Integer>();

	static {
		townToEscapePoints.put(TOWNID_TALKING_ISLAND,
				GETBACK_LOC_TALKING_ISLAND);
		townToEscapePoints.put(TOWNID_SILVER_KNIGHT_TOWN,
				GETBACK_LOC_SILVER_KNIGHT_TOWN);
		townToEscapePoints.put(TOWNID_GLUDIO, GETBACK_LOC_GLUDIO);
		townToEscapePoints.put(TOWNID_ORCISH_FOREST, GETBACK_LOC_ORCISH_FOREST);
		townToEscapePoints.put(TOWNID_WINDAWOOD, GETBACK_LOC_WINDAWOOD);
		townToEscapePoints.put(TOWNID_KENT, GETBACK_LOC_KENT);
		townToEscapePoints.put(TOWNID_GIRAN, GETBACK_LOC_GIRAN);
		townToEscapePoints.put(TOWNID_HEINE, GETBACK_LOC_HEINE);
		townToEscapePoints.put(TOWNID_WERLDAN, GETBACK_LOC_WERLDAN);
		townToEscapePoints.put(TOWNID_OREN, GETBACK_LOC_OREN);
		townToEscapePoints.put(TOWNID_ELVEN_FOREST, GETBACK_LOC_ELVEN_FOREST);
		townToEscapePoints.put(TOWNID_ADEN, GETBACK_LOC_ADEN);
		townToEscapePoints.put(TOWNID_SILENT_CAVERN, GETBACK_LOC_SILENT_CAVERN);
		townToEscapePoints.put(TOWNID_OUM_DUNGEON, GETBACK_LOC_OUM_DUNGEON);
		townToEscapePoints.put(TOWNID_RESISTANCE, GETBACK_LOC_RESISTANCE);
		townToEscapePoints.put(TOWNID_PIRATE_ISLAND, GETBACK_LOC_PIRATE_ISLAND);
		townToEscapePoints.put(TOWNID_RECLUSE_VILLAGE,
				GETBACK_LOC_RECLUSE_VILLAGE);

		// TODO: use MapId constants somewhere.
		townToMap.put(TOWNID_TALKING_ISLAND, 0);
		townToMap.put(TOWNID_SILVER_KNIGHT_TOWN, 4);
		townToMap.put(TOWNID_GLUDIO, 4);
		townToMap.put(TOWNID_ORCISH_FOREST, 4);
		townToMap.put(TOWNID_WINDAWOOD, 4);
		townToMap.put(TOWNID_KENT, 4);
		townToMap.put(TOWNID_GIRAN, 4);
		townToMap.put(TOWNID_HEINE, 4);
		townToMap.put(TOWNID_WERLDAN, 4);
		townToMap.put(TOWNID_OREN, 4);
		townToMap.put(TOWNID_ELVEN_FOREST, 4);
		townToMap.put(TOWNID_ADEN, 4);
		townToMap.put(TOWNID_SILENT_CAVERN, 304);
		townToMap.put(TOWNID_OUM_DUNGEON, 310);
		townToMap.put(TOWNID_RESISTANCE, 400);
		townToMap.put(TOWNID_PIRATE_ISLAND, 440);
		townToMap.put(TOWNID_RECLUSE_VILLAGE, 400);
	}

	private L1TownLocation() {
	}

	public static int[] getGetBackLoc(int townId) {
		Point[] points = townToEscapePoints.get(townId);
		if (points == null)
			points = townToEscapePoints.get(TOWNID_SILVER_KNIGHT_TOWN);
		Point point = points[random.nextInt(points.length)];
		return new int[] { point.getX(), point.getY(), townToMap.get(townId) };
	}

	public static int getTownTaxRateByNpcid(int npcid) {
		int taxRate = 0;

		int townId = getTownIdByNpcid(npcid);
		if (townId >= 1 && townId <= 10) {
			L1Town town = TownTable.getInstance().getTownTable(townId);
			taxRate = town.get_tax_rate() + 2; // 2%
		}
		return taxRate;
	}

	public static int getTownIdByNpcid(int npcid) {
		// Aden Castle: Aden throughout the kingdom
		// Kent Castle: Kent, GURUDIN
		// UINDAUDDO Castle: UDDOBEKKU oasis, SHIRUBANAITOTAUN
		// Guillain Castle: Ilan, speaking island
		// Heine Castle: Heine
		// Dwarf Castle: well-done, ivory, ivory village
		// Oak fort: Tue Tamura
		// DIADO fortress: Some war tax
		switch (npcid) {
		case 70528:
		case 50015:
		case 70010:
		case 70011:
		case 70012:
		case 70014:
		case 70532:
		case 70536:
		case 70534:
			return TOWNID_TALKING_ISLAND;
		case 70799:
		case 50056:
		case 70073:
		case 70074:
		case 70075:
		case 70806:
			return TOWNID_SILVER_KNIGHT_TOWN;
		case 70546:
		case 50020:
		case 70018:
		case 70016:
		case 70544:
		case 70556:
			return TOWNID_KENT;
		case 70567:
		case 50024:
		case 70019:
		case 70020:
		case 70021:
		case 70022:
		case 70024:
		case 70572:
			return TOWNID_GLUDIO;
		case 70815:
		case 70079:
		case 70836:
		case 70830:
			return TOWNID_ORCISH_FOREST;
		case 70774:
		case 50054:
		case 70070:
		case 70071:
		case 70072:
		case 70773:
		case 70788:
			return TOWNID_WINDAWOOD;
		case 70594:
		case 50036:
		case 70026:
		case 70028:
		case 70029:
		case 70030:
		case 70031:
		case 70032:
		case 70033:
		case 70038:
		case 70039:
		case 70043:
		case 70617:
		case 70632:
		case 70631:
			return TOWNID_GIRAN;
		case 70860:
		case 50066:
		case 70082:
		case 70083:
		case 70084:
		case 70873:
		case 70876:
			return TOWNID_HEINE;
		case 70654:
		case 50039:
		case 70045:
		case 70044:
		case 70664:
		case 70663:
			return TOWNID_WERLDAN;
		case 70748:
		case 50051:
		case 70059:
		case 70060:
		case 70061:
		case 70062:
		case 70063:
		case 70065:
		case 70066:
		case 70067:
		case 70068:
		case 70749:
		case 70761:
			return TOWNID_OREN;
		case 50044:
		case 70057:
		case 70048:
		case 70052:
		case 70053:
			// case 70049: // NOTE: Don't put this back in.
		case 70051:
		case 70047:
		case 70058:
		case 70054:
		case 70055:
		case 70056:
			return TOWNID_ADEN;
		case 70092:
		case 70093:
			return TOWNID_OUM_DUNGEON;
		default:
			return 0;
		}
	}
}
