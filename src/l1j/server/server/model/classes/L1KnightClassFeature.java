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

import l1j.server.server.model.L1Attribute;

class L1KnightClassFeature extends L1ClassFeature {
	@Override
	public int getAcDefenseMax(int ac) {
		return ac / 2;
	}

	@Override
	public int getMagicLevel(int playerLevel) {
		return playerLevel / 50;
	}

	@Override
	public int getER(int level) {
		return level / 4;
	}

	@Override
	public Map<L1Attribute, Integer> getFixedStats() {
		Map<L1Attribute, Integer> fixedStats = new HashMap<L1Attribute, Integer>();
		fixedStats.put(L1Attribute.Str, 16);
		fixedStats.put(L1Attribute.Dex, 12);
		fixedStats.put(L1Attribute.Con, 14);
		fixedStats.put(L1Attribute.Wis, 9);
		fixedStats.put(L1Attribute.Int, 8);
		fixedStats.put(L1Attribute.Cha, 12);
		return fixedStats;
	}

	@Override
	public Map<L1Attribute, Integer> getMaxFixedStats() {
		Map<L1Attribute, Integer> maxFixedStats = new HashMap<L1Attribute, Integer>();
		maxFixedStats.put(L1Attribute.Str, 20);
		maxFixedStats.put(L1Attribute.Dex, 16);
		maxFixedStats.put(L1Attribute.Con, 18);
		maxFixedStats.put(L1Attribute.Wis, 13);
		maxFixedStats.put(L1Attribute.Int, 12);
		maxFixedStats.put(L1Attribute.Cha, 16);
		return maxFixedStats;
	}

	@Override
	public int getFloatingStats() {
		return 4;
	}

	@Override
	public int getBaseMR() {
		return 10;
	}

	@Override
	public int getStartingHp() {
		return 16;
	}

	@Override
	public int getStartingMp(int wis) {
		return wis >= 12 ? 2 : 1;
	}

	@Override
	public int getOriginalHpBonus(int con) {
		return con >= 17 ? 3 : con >= 15 ? 1 : 0;
	}

	@Override
	public int getOriginalMpBonus(int wis) {
		return 0;
	}

	@Override
	public int getOriginalStrWeightReduction(int str) {
		return 0;
	}

	@Override
	public int getOriginalConWeightReduction(int con) {
		return con >= 15 ? 1 : 0;
	}

	@Override
	public int getOriginalMeleeDamage(int str) {
		return str == 20 ? 4 : str >= 18 ? 2 : 0;
	}

	@Override
	public int getOriginalRangedDamage(int dex) {
		return 0;
	}

	@Override
	public int getOriginalMeleeHit(int str) {
		return str >= 19 ? 4 : str >= 16 ? 2 : 0;
	}

	@Override
	public int getOriginalRangedHit(int dex) {
		return 0;
	}

	@Override
	public int getOriginalMR(int wis) {
		return wis >= 12 ? 2 : wis >= 10 ? 1 : 0;
	}

	@Override
	public int getOriginalER(int dex) {
		return dex >= 16 ? 3 : dex >= 14 ? 1 : 0;
	}

	@Override
	public int getOriginalMagicHit(int intel) {
		return intel >= 12 ? 2 : intel >= 10 ? 1 : 0;
	}

	@Override
	public int getOriginalMagicCrit(int intel) {
		return 0;
	}

	@Override
	public int getOriginalMpReduction(int intel) {
		return intel >= 11 ? 2 : intel >= 9 ? 1 : 0;
	}

	@Override
	public int getOriginalMagicDamage(int intel) {
		return 0;
	}

	@Override
	public int getOriginalAC(int dex) {
		return dex >= 15 ? 3 : dex >= 13 ? 1 : 0;
	}

	@Override
	public int getOriginalHpRegen(int con) {
		return con == 18 ? 4 : con >= 16 ? 2 : 0;
	}

	@Override
	public int getOriginalMpRegen(int wis) {
		return wis >= 13 ? 2 : wis >= 11 ? 1 : 0;
	}
}
