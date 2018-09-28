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

import java.util.Map;

import l1j.server.server.model.L1Attribute;

/**
 * Class related constants.
 * 
 * A lot of this could really go into Config files, but that's a pain in the
 * rear and even the super custom servers don't seem to tweak this from classic
 * Lineage.
 */
public abstract class L1ClassFeature {
	public static L1ClassFeature newClassFeature(int classId) {
		switch (classId) {
		case L1ClassId.CLASSID_PRINCE:
		case L1ClassId.CLASSID_PRINCESS:
			return new L1RoyalClassFeature();
		case L1ClassId.CLASSID_ELF_MALE:
		case L1ClassId.CLASSID_ELF_FEMALE:
			return new L1ElfClassFeature();
		case L1ClassId.CLASSID_KNIGHT_MALE:
		case L1ClassId.CLASSID_KNIGHT_FEMALE:
			return new L1KnightClassFeature();
		case L1ClassId.CLASSID_WIZARD_MALE:
		case L1ClassId.CLASSID_WIZARD_FEMALE:
			return new L1WizardClassFeature();
		case L1ClassId.CLASSID_DARK_ELF_MALE:
		case L1ClassId.CLASSID_DARK_ELF_FEMALE:
			return new L1DarkElfClassFeature();
		case L1ClassId.CLASSID_DRAGON_KNIGHT_MALE:
		case L1ClassId.CLASSID_DRAGON_KNIGHT_FEMALE:
			return new L1DragonKnightClassFeature();
		case L1ClassId.CLASSID_ILLUSIONIST_MALE:
		case L1ClassId.CLASSID_ILLUSIONIST_FEMALE:
			return new L1IllusionistClassFeature();
		default:
			throw new IllegalArgumentException();
		}
	}

	public abstract int getStartingHp();

	public abstract int getStartingMp(int wis);

	public abstract int getAcDefenseMax(int ac);

	public abstract int getMagicLevel(int playerLevel);

	public abstract int getER(int level);

	/**
	 * The fixed starting stats.
	 */
	public abstract Map<L1Attribute, Integer> getFixedStats();

	/**
	 * The maximum starting stats.
	 */
	public abstract Map<L1Attribute, Integer> getMaxFixedStats();

	/**
	 * The number of player-assigned starting stats.
	 */
	public abstract int getFloatingStats();

	public abstract int getBaseMR();

	/**
	 * All of the getOriginal* methods refer to bonuses from starting stats, so
	 * it's assuming the original str/dex/con/wis/int/cha will be passed.
	 */
	public abstract int getOriginalHpBonus(int con);

	public abstract int getOriginalMpBonus(int wis);

	public abstract int getOriginalStrWeightReduction(int str);

	public abstract int getOriginalConWeightReduction(int con);

	public abstract int getOriginalMeleeDamage(int str);

	public abstract int getOriginalRangedDamage(int dex);

	public abstract int getOriginalMeleeHit(int str);

	public abstract int getOriginalRangedHit(int dex);

	public abstract int getOriginalMR(int wis);

	public abstract int getOriginalER(int dex);

	public abstract int getOriginalMagicHit(int intel);

	public abstract int getOriginalMagicCrit(int intel);

	public abstract int getOriginalMpReduction(int intel);

	public abstract int getOriginalMagicDamage(int intel);

	public abstract int getOriginalAC(int dex);

	public abstract int getOriginalHpRegen(int con);

	public abstract int getOriginalMpRegen(int wis);
}
