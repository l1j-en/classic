package l1j.server.server.model.map;

import java.util.Arrays;

import l1j.server.server.model.L1Character;
import l1j.server.server.types.Point;
import l1j.server.server.utils.collections.IntArrays;

public class Maps {
	public static final int ADEN = 4;
	public static final int SILVERIA = 1000;
	public static final int BEHIMOUS = 1001;

	private static final int[] CASTLES = new int[] { 15, 29, 52, 64, 66, 300 };

	private static final int[] INNS = new int[] { 16384, 16896, 17408, 17920,
			18432, 18944, 19968, 19456, 20480, 20992, 21504, 22016, 22528,
			23040, 23552, 24064, 24576, 25088 };

	private static final Point MotherTree = new Point(33055, 32336);
	private static final Point TownCenter = new Point(32801, 32863);

	static {
		Arrays.sort(INNS);
	}

	public static boolean isInCastle(L1Character character) {
		return IntArrays.contains(CASTLES, character.getMapId());
	}

	public static boolean isInInn(L1Character character) {
		return IntArrays.sContains(INNS, character.getMapId());
	}

	public static boolean isLvl50Quest(L1Character character) {
		int id = character.getMapId();
		return id == 2000 || id == 2001;
	}

	public static boolean atMotherTree(L1Character character) {
		return character.getMapId() == ADEN
				&& character.getLocation().isInScreen(MotherTree);
	}

	public static boolean atSilveriaCenter(L1Character character) {
		return character.getMapId() == SILVERIA
				&& character.getLocation().isInScreen(TownCenter);
	}

	public static boolean atBehimousCenter(L1Character character) {
		return character.getMapId() == BEHIMOUS
				&& character.getLocation().isInScreen(TownCenter);
	}
}
