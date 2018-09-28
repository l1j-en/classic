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

class L1WizardClassFeature extends L1ClassFeature {
	@Override
	public int getAcDefenseMax(int ac) {
		if (Config.SOFT_AC) {
			return ac / 5;
		} else {
			return ac / 2;
		}
	}

	@Override
	public int getMagicLevel(int playerLevel) {
		return Math.min(10, playerLevel / 4);
	}

	@Override
	public int getER(int level) {
		return level / 10;
	}

	@Override
	public Map<L1Attribute, Integer> getFixedStats() {
		Map<L1Attribute, Integer> fixedStats = new HashMap<L1Attribute, Integer>();
		fixedStats.put(L1Attribute.Str, 8);
		fixedStats.put(L1Attribute.Dex, 7);
		fixedStats.put(L1Attribute.Con, 12);
		fixedStats.put(L1Attribute.Wis, 12);
		fixedStats.put(L1Attribute.Int, 12);
		fixedStats.put(L1Attribute.Cha, 8);
		return fixedStats;
	}

	@Override
	public Map<L1Attribute, Integer> getMaxFixedStats() {
		Map<L1Attribute, Integer> maxFixedStats = new HashMap<L1Attribute, Integer>();
		maxFixedStats.put(L1Attribute.Str, 20);
		maxFixedStats.put(L1Attribute.Dex, 18);
		maxFixedStats.put(L1Attribute.Con, 18);
		maxFixedStats.put(L1Attribute.Wis, 18);
		maxFixedStats.put(L1Attribute.Int, 18);
		maxFixedStats.put(L1Attribute.Cha, 18);
		return maxFixedStats;
	}

	@Override
	public int getFloatingStats() {
		return 16;
	}

	@Override
	public int getBaseMR() {
		return 15;
	}

	@Override
	public int getStartingHp() {
		return 12;
	}

	@Override
	public int getStartingMp(int wis) {
		return wis >= 16 ? 8 : 6;
	}

	@Override
	public int getOriginalHpBonus(int con) {
		return con >= 16 ? 2 : con >= 14 ? 1 : 0;
	}

	@Override
	public int getOriginalMpBonus(int wis) {
		return wis >= 17 ? 2 : wis >= 13 ? 1 : 0;
	}

	@Override
	public int getOriginalStrWeightReduction(int str) {
		return str >= 9 ? 1 : 0;
	}

	@Override
	public int getOriginalConWeightReduction(int con) {
		return con >= 15 ? 2 : con >= 13 ? 1 : 0;
	}

	@Override
	public int getOriginalMeleeDamage(int str) {
		return str >= 12 ? 2 : str >= 10 ? 1 : 0;
	}

	@Override
	public int getOriginalRangedDamage(int dex) {
		return 0;
	}

	@Override
	public int getOriginalMeleeHit(int str) {
		return str >= 13 ? 2 : str >= 11 ? 1 : 0;
	}

	@Override
	public int getOriginalRangedHit(int dex) {
		return 0;
	}

	@Override
	public int getOriginalMR(int wis) {
		return wis >= 15 ? 1 : 0;
	}

	@Override
	public int getOriginalER(int dex) {
		return dex >= 11 ? 2 : dex >= 9 ? 1 : 0;
	}

	@Override
	public int getOriginalMagicHit(int intel) {
		return intel >= 14 ? 1 : 0;
	}

	@Override
	public int getOriginalMagicCrit(int intel) {
		switch (intel) {
		case 15:
			return 2;
		case 16:
			return 4;
		case 17:
			return 6;
		case 18:
			return 8;
		default:
			return 0;
		}
	}

	@Override
	public int getOriginalMpReduction(int intel) {
		return 0;
	}

	@Override
	public int getOriginalMagicDamage(int intel) {
		return intel >= 13 ? 1 : 0;
	}

	@Override
	public int getOriginalAC(int dex) {
		return dex >= 10 ? 2 : dex >= 8 ? 1 : 0;
	}

	@Override
	public int getOriginalHpRegen(int con) {
		return con == 18 ? 2 : con == 17 ? 1 : 0;
	}

	@Override
	public int getOriginalMpRegen(int wis) {
		return wis == 18 ? 3 : wis >= 16 ? 2 : wis >= 14 ? 1 : 0;
	}
}
