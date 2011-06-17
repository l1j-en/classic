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

import l1j.server.Config;
/**
 * Experience to provide value-class table
 */
public final class ExpTable {
	private ExpTable() {
	}

	public static final int MAX_LEVEL = 99;
	public static final int MAX_EXP = 0x6ecf16da;

	/**
	 * The level required to become a cumulative experience of value.
	 * 
	 * @param level
	 * @return Value of cumulative experience necessary
	 */
	public static int getExpByLevel(int level) {
		return _expTable[level - 1];
	}

	/**
	 * The next level of experience required to become a value.
	 * 
	 * @param level
	 *            The current level
	 * @return Value necessary experience
	 */
	public static int getNeedExpNextLevel(int level) {
		return getExpByLevel(level + 1) - getExpByLevel(level);
	}

	/**
	 * Seek value from the cumulative experience level.
	 * 
	 * @param exp
	 *            Cumulative value of experience
	 * @return Asked level
	 */
	public static int getLevelByExp(int exp) {
		int level;
		for (level = 1; level < _expTable.length; level++) {
			// Might be tricky
			if (exp < _expTable[level]) {
			break;
			}
		}
		return Math.min(level, MAX_LEVEL);
	}

	public static int getExpPercentage(int level, int exp) {
		return (int) (100.0 * ((double) (exp - getExpByLevel(level)) / (double) getNeedExpNextLevel(level)));
	}

	/**
	 * From the current level, experience and values call for penalty rates
	 * 
	 * @param level
	 *            The current level
	 * @return Asked to experience the value of penalty rates
	 */
	public static double getPenaltyRate(int level) {
		if (level < 50) {
		return 1.0;
		}
		double expPenalty = 1.0;
		expPenalty = 1.0 / _expPenalty[level - 50];
		return expPenalty;
	}

	/**
	 * Experience table (cumulative) Lv0-100
	 */
	private static final int _expTable[] = { 0, 125, 300, 500, 750, 1296, 2401,
			4096, 6581, 10000, 14661, 20756, 28581, 38436, 50645, 0x10014,
			0x14655, 0x19a24, 0x1fd25, 0x27114, 0x2f7c5, 0x39324, 0x44535,
			0x51010, 0x5f5f1, 0x6f920, 0x81c01, 0x96110, 0xacae1, 0xc5c20,
			0xe1791, 0x100010, 0x121891, 0x146420, 0x16e5e1, 0x19a110,
			0x1c9901, 0x1fd120, 0x234cf1, 0x271010, 0x2b1e31, 0x2f7b21,
			0x342ac2, 0x393111, 0x3e9222, 0x49b332, 0x60b772, 0x960cd1,
			0x12d4c4e, 0x3539b92, 0x579ead6, 0x7a03a1a, 0x9c6895e, 0xbecd8a2,
			0xe1327e6, 0x1039772a, 0x125fc66e, 0x148615b2, 0x16ac64f6,
			0x18d2b43a, 0x1af9037e, 0x1d1f52c2, 0x1f45a206, 0x216bf14a,
			0x2392408e, 0x25b88fd2, 0x27dedf16, 0x2a052e5a, 0x2c2b7d9e,
			0x2e51cce2, 0x30781c26, 0x329e6b6a, 0x34c4baae, 0x36eb09f2,
			0x39115936, 0x3b37a87a, 0x3d5df7be, 0x3f844702, 0x41aa9646,
			0x43d0e58a, 0x45f734ce, 0x481d8412, 0x4a43d356, 0x4c6a229a,
			0x4e9071de, 0x50b6c122, 0x52dd1066, 0x55035faa, 0x5729aeee,
			0x594ffe32, 0x5b764d76, 0x5d9c9cba, 0x5fc2ebfe, 0x61e93b42,
			0x640f8a86, 0x6635d9ca, 0x685c290e, 0x6a827852, 0x6ca8c796,
			0x6ecf16da, };

	private static final int _expPenalty[] = { Config.LV50_EXP,
			Config.LV51_EXP, Config.LV52_EXP, Config.LV53_EXP, Config.LV54_EXP,
			Config.LV55_EXP, Config.LV56_EXP, Config.LV57_EXP, Config.LV58_EXP,
			Config.LV59_EXP, Config.LV60_EXP, Config.LV61_EXP, Config.LV62_EXP,
			Config.LV63_EXP, Config.LV64_EXP, Config.LV65_EXP, Config.LV66_EXP,
			Config.LV67_EXP, Config.LV68_EXP, Config.LV69_EXP, Config.LV70_EXP,
			Config.LV71_EXP, Config.LV72_EXP, Config.LV73_EXP, Config.LV74_EXP,
			Config.LV75_EXP, Config.LV76_EXP, Config.LV77_EXP, Config.LV78_EXP,
			Config.LV79_EXP, Config.LV80_EXP, Config.LV81_EXP, Config.LV82_EXP,
			Config.LV83_EXP, Config.LV84_EXP, Config.LV85_EXP, Config.LV86_EXP,
			Config.LV87_EXP, Config.LV88_EXP, Config.LV89_EXP, Config.LV90_EXP,
			Config.LV91_EXP, Config.LV92_EXP, Config.LV93_EXP, Config.LV94_EXP,
			Config.LV95_EXP, Config.LV96_EXP, Config.LV97_EXP, Config.LV98_EXP,
			Config.LV99_EXP };
}