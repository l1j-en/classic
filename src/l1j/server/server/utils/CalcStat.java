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

import l1j.server.Config;

public class CalcStat {

	private static Random rnd = new Random();

	private CalcStat() {

	}

	/**
	 * AC Bonus returns
	 * 
	 * @param level
	 * @param dex
	 * @return acBonus
	 * 
	 */
	public static int calcAc(int level, int dex) {
		int acBonus = 10;
		if (dex <= 9) {
			acBonus -= level / 8;
		} else if (dex >= 10 && dex <= 12) {
			acBonus -= level / 7;
		} else if (dex >= 13 && dex <= 15) {
			acBonus -= level / 6;
		} else if (dex >= 16 && dex <= 17) {
			acBonus -= level / 5;
		} else if (dex >= 18) {
			acBonus -= level / 4;
		}
		return acBonus;
	}

	/**
	 * respond to the arguments to return bonuses MR/WIS
	 * 
	 * @param wis
	 * @return mrBonus
	 */
	public static int calcStatMr(int wis) {
		int mrBonus = 0;
		if (wis <= 14) {
			mrBonus = 0;
		} else if (wis >= 15 && wis <= 16) {
			mrBonus = 3;
		} else if (wis == 17) {
			mrBonus = 6;
		} else if (wis == 18) {
			mrBonus = 10;
		} else if (wis == 19) {
			mrBonus = 15;
		} else if (wis == 20) {
			mrBonus = 21;
		} else if (wis == 21) {
			mrBonus = 28;
		} else if (wis == 22) {
			mrBonus = 37;
		} else if (wis == 23) {
			mrBonus = 47;
		} else if (wis == 24) {
			mrBonus = 50;
		} else {
			mrBonus = 50;
		}
		return mrBonus;
	}

	public static int calcDiffMr(int wis, int diff) {
		return calcStatMr(wis + diff) - calcStatMr(wis);
	}

	/**
	 * HP LVUP during each class to rise in value returns
	 * 
	 * @param charType
	 * @param baseMaxHp
	 * @param baseCon
	 * @param originalHpup
	 * @return
	 */
	public static short calcStatHp(int charType, int baseMaxHp, byte baseCon,
			int originalHpup) {
		short randomhp = 0;
		if (baseCon > 15) {
			randomhp = (short) (baseCon - 15);
		}
		if (charType == 0) { // Prince
			randomhp += (short) (11 + rnd.nextInt(2));

			if (baseMaxHp + randomhp > Config.PRINCE_MAX_HP) {
				randomhp = (short) (Config.PRINCE_MAX_HP - baseMaxHp);
			}
		} else if (charType == 1) { // Knight
			randomhp += (short) (17 + rnd.nextInt(2));

			if (baseMaxHp + randomhp > Config.KNIGHT_MAX_HP) {
				randomhp = (short) (Config.KNIGHT_MAX_HP - baseMaxHp);
			}
		} else if (charType == 2) { // Elf
			randomhp += (short) (10 + rnd.nextInt(2));

			if (baseMaxHp + randomhp > Config.ELF_MAX_HP) {
				randomhp = (short) (Config.ELF_MAX_HP - baseMaxHp);
			}
		} else if (charType == 3) { // Wizard
			randomhp += (short) (7 + rnd.nextInt(2));

			if (baseMaxHp + randomhp > Config.WIZARD_MAX_HP) {
				randomhp = (short) (Config.WIZARD_MAX_HP - baseMaxHp);
			}
		} else if (charType == 4) { // Dark Elf
			randomhp += (short) (10 + rnd.nextInt(2));

			if (baseMaxHp + randomhp > Config.DARKELF_MAX_HP) {
				randomhp = (short) (Config.DARKELF_MAX_HP - baseMaxHp);
			}
		} else if (charType == 5) { // Dragon Knight
			randomhp += (short) (13 + rnd.nextInt(2)); // l

			if (baseMaxHp + randomhp > Config.DRAGONKNIGHT_MAX_HP) {
				randomhp = (short) (Config.DRAGONKNIGHT_MAX_HP - baseMaxHp);
			}
		} else if (charType == 6) { // Illusionist
			randomhp += (short) (9 + rnd.nextInt(2)); // l

			if (baseMaxHp + randomhp > Config.ILLUSIONIST_MAX_HP) {
				randomhp = (short) (Config.ILLUSIONIST_MAX_HP - baseMaxHp);
			}
		}
		randomhp += originalHpup;

		if (randomhp < 0) {
			randomhp = 0;
		}
		return randomhp;
	}

	/**
	 * Each class LVUP rise in value when the MP returns
	 * 
	 * @param charType
	 * @param baseMaxMp
	 * @param baseWis
	 * @param originalMpup
	 * @return MPl
	 */
	public static short calcStatMp(int charType, int baseMaxMp, byte baseWis,
			int originalMpup) {
		int randommp = 0;
		int seedY = 0;
		int seedZ = 0;
		if (baseWis < 9 || baseWis > 9 && baseWis < 12) {
			seedY = 2;
		} else if (baseWis == 9 || baseWis >= 12 && baseWis <= 17) {
			seedY = 3;
		} else if (baseWis >= 18 && baseWis <= 23 || baseWis == 25
				|| baseWis == 26 || baseWis == 29 || baseWis == 30
				|| baseWis == 33 || baseWis == 34) {
			seedY = 4;
		} else if (baseWis == 24 || baseWis == 27 || baseWis == 28
				|| baseWis == 31 || baseWis == 32 || baseWis >= 35) {
			seedY = 5;
		}

		if (baseWis >= 7 && baseWis <= 9) {
			seedZ = 0;
		} else if (baseWis >= 10 && baseWis <= 14) {
			seedZ = 1;
		} else if (baseWis >= 15 && baseWis <= 20) {
			seedZ = 2;
		} else if (baseWis >= 21 && baseWis <= 24) {
			seedZ = 3;
		} else if (baseWis >= 25 && baseWis <= 28) {
			seedZ = 4;
		} else if (baseWis >= 29 && baseWis <= 32) {
			seedZ = 5;
		} else if (baseWis >= 33) {
			seedZ = 6;
		}

		randommp = rnd.nextInt(seedY) + 1 + seedZ;

		if (charType == 0) { // Prince
			if (baseMaxMp + randommp > Config.PRINCE_MAX_MP) {
				randommp = Config.PRINCE_MAX_MP - baseMaxMp;
			}
		} else if (charType == 1) { // Knight
			randommp = randommp * 2 / 3;
			if (baseMaxMp + randommp > Config.KNIGHT_MAX_MP) {
				randommp = Config.KNIGHT_MAX_MP - baseMaxMp;
			}
		} else if (charType == 2) { // Elf
			randommp = (int) (randommp * 1.5);

			if (baseMaxMp + randommp > Config.ELF_MAX_MP) {
				randommp = Config.ELF_MAX_MP - baseMaxMp;
			}
		} else if (charType == 3) { // Wizard
			randommp *= 2;

			if (baseMaxMp + randommp > Config.WIZARD_MAX_MP) {
				randommp = Config.WIZARD_MAX_MP - baseMaxMp;
			}
		} else if (charType == 4) { // Dark Elf
			randommp = (int) (randommp * 1.5);

			if (baseMaxMp + randommp > Config.DARKELF_MAX_MP) {
				randommp = Config.DARKELF_MAX_MP - baseMaxMp;
			}
		} else if (charType == 5) { // Dragon Knight
			randommp = randommp * 2 / 3;

			if (baseMaxMp + randommp > Config.DRAGONKNIGHT_MAX_MP) {
				randommp = Config.DRAGONKNIGHT_MAX_MP - baseMaxMp;
			}
		} else if (charType == 6) { // Illusionist
			randommp = randommp * 5 / 3;

			if (baseMaxMp + randommp > Config.ILLUSIONIST_MAX_MP) {
				randommp = Config.ILLUSIONIST_MAX_MP - baseMaxMp;
			}
		}

		randommp += originalMpup;

		if (randommp < 0) {
			randommp = 0;
		}
		return (short) randommp;
	}
}
