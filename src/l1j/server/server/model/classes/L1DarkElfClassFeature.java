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
package l1j.server.server.model.classes;

import java.util.HashMap;
import java.util.Map;

import l1j.server.Config;
import l1j.server.server.model.L1Attribute;

class L1DarkElfClassFeature extends L1ClassFeature {
	@Override
	public int getAcDefenseMax(int ac) {
		if (Config.SOFT_AC) {
			return ac / 4;
		} else {
			return ac / 2;
		}
	}

	@Override
	public int getMagicLevel(int playerLevel) {
		return Math.min(2, playerLevel / 12);
	}

	@Override
	public int getER(int level) {
		return level / 6;
	}

	@Override
	public Map<L1Attribute, Integer> getFixedStats() {
		Map<L1Attribute, Integer> fixedStats = new HashMap<L1Attribute, Integer>();
		fixedStats.put(L1Attribute.Str, 12);
		fixedStats.put(L1Attribute.Dex, 15);
		fixedStats.put(L1Attribute.Con, 8);
		fixedStats.put(L1Attribute.Wis, 10);
		fixedStats.put(L1Attribute.Int, 11);
		fixedStats.put(L1Attribute.Cha, 9);
		return fixedStats;
	}

	@Override
	public Map<L1Attribute, Integer> getMaxFixedStats() {
		Map<L1Attribute, Integer> maxFixedStats = new HashMap<L1Attribute, Integer>();
		maxFixedStats.put(L1Attribute.Str, 18);
		maxFixedStats.put(L1Attribute.Dex, 18);
		maxFixedStats.put(L1Attribute.Con, 18);
		maxFixedStats.put(L1Attribute.Wis, 18);
		maxFixedStats.put(L1Attribute.Int, 18);
		maxFixedStats.put(L1Attribute.Cha, 18);
		return maxFixedStats;
	}

	@Override
	public int getFloatingStats() {
		return 10;
	}

	@Override
	public int getBaseMR() {
		return 10;
	}

	@Override
	public int getStartingHp() {
		return 12;
	}

	@Override
	public int getStartingMp(int wis) {
		return wis >= 16 ? 6 : wis >= 12 ? 4 : 3;
	}

	@Override
	public int getOriginalHpBonus(int con) {
		return con >= 12 ? 2 : con >= 10 ? 1 : 0;
	}

	@Override
	public int getOriginalMpBonus(int wis) {
		return wis >= 12 ? 1 : 0;
	}

	@Override
	public int getOriginalStrWeightReduction(int str) {
		return str >= 16 ? 3 : str >= 13 ? 2 : 0;
	}

	@Override
	public int getOriginalConWeightReduction(int con) {
		return con >= 9 ? 1 : 0;
	}

	@Override
	public int getOriginalMeleeDamage(int str) {
		return str == 18 ? 2 : str >= 14 ? 1 : 0;
	}

	@Override
	public int getOriginalRangedDamage(int dex) {
		return dex == 18 ? 2 : 0;
	}

	@Override
	public int getOriginalMeleeHit(int str) {
		return str == 18 ? 2 : str >= 15 ? 1 : 0;
	}

	@Override
	public int getOriginalRangedHit(int dex) {
		return dex == 17 ? 1 : dex == 18 ? 2 : 0;
	}

	@Override
	public int getOriginalMR(int wis) {
	    return wis >= 16 ? 4 : wis == 15 ? 3 : wis == 14 ? 2 : wis == 13 ? 1 : 0;
	}

	@Override
	public int getOriginalER(int dex) {
		return dex >= 16 ? 2 : 0;
	}

	@Override
	public int getOriginalMagicHit(int intel) {
		return intel >= 14 ? 2 : intel >= 12 ? 1 : 0;
	}

	@Override
	public int getOriginalMagicCrit(int intel) {
		return 0;
	}

	@Override
	public int getOriginalMpReduction(int intel) {
		return intel >= 15 ? 2 : intel >= 13 ? 1 : 0;
	}

	@Override
	public int getOriginalMagicDamage(int intel) {
		return 0;
	}

	@Override
	public int getOriginalAC(int dex) {
		return dex >= 17 ? 1 : 0;
	}

	@Override
	public int getOriginalHpRegen(int con) {
		return con >= 13 ? 2 : con >= 11 ? 1 : 0;
	}

	@Override
	public int getOriginalMpRegen(int wis) {
		return wis >= 13 ? 1 : 0;
	}
}
