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

import l1j.server.server.model.Instance.L1PcInstance;

public abstract class L1ClassFeature {
	public static L1ClassFeature newClassFeature(int Type) {

		switch(Type) {
		case L1ClassId.ROYAL:
		case L1ClassId.Del_ROYAL:
			return new L1RoyalClassFeature();
		case L1ClassId.KNIGHT:
		case L1ClassId.Del_KNIGHT:
			return new L1KnightClassFeature();
		case L1ClassId.ELF:
		case L1ClassId.Del_ELF:
			return new L1ElfClassFeature();
		case L1ClassId.WIZARD:
		case L1ClassId.Del_WIZARD:
			return new L1WizardClassFeature();
		case L1ClassId.DARK_ELF:
		case L1ClassId.Del_DARK_ELF:
			return new L1DarkElfClassFeature();
		case L1ClassId.DRAGON_KNIGHT:
		case L1ClassId.Del_DRAGON_KNIGHT:
			return new L1DragonKnightClassFeature();
		case L1ClassId.ILLUSIONIST:
		case L1ClassId.Del_ILLUSIONIST:
			return new L1IllusionistClassFeature();
		default:
			throw new IllegalArgumentException();
		}
	}

	public abstract int getAcDefenseMax(int ac);
	public abstract int getMagicLevel(int playerLevel);
	public abstract int getMaxSpellLevel(); 
	public abstract int getSpellLearningInterval();
	public abstract int []InitSpawn(int type);
	public abstract int InitSex(int sex);
	public abstract int InitHp();
	public abstract int InitMp(int BaseWis);
	public abstract int []InitPoints();
	public abstract int InitMr();
	public abstract int calcAcDefense(int ac);
	public abstract int calcLvUpEr(int lv);
	public abstract int calcLvHit(int lv);
	public abstract int calcLvFightDmg(int lv);
	public abstract int calcLvShotDmg(int lv);
	public abstract int calcMagicLevel(int lv);
	public abstract int bounsCha();
	public abstract int calclvUpHp(int baseCon);
	public abstract int calclvUpMp(int BaseWis);
	public abstract int MaxHp();
	public abstract int MaxMp();

	public static byte[] Dex2AC = {
		//	 0  1  2  3  4  5  6  7  8  9
			 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, // Dex =  0 ~  9
			 7, 7, 7, 6, 6, 6, 5, 5, 4};   // Dex = 10 ~ 18
	
	public int calcLvDex2AC(int level, int dex) {
		int temp_dex = (dex > 17) ? 18 : dex;
		int base_ac = 10;
		base_ac -= (level / Dex2AC[temp_dex]);
		return base_ac;
	}

	public static byte[] StatMr = {
		//	 0  1  2  3  4  5  6  7  8  9
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // Wis =  0 ~  9
			 0, 0, 0, 0, 0, 3, 3, 6, 10, 15, // Wis = 10 ~ 19
			21, 28, 37, 47, 50, 50};			   // Wis = 20 ~ 25
	
	public byte calcStatMr(int wis) {
		int temp_wis = (wis > 24) ? 25 : wis;
		return StatMr[temp_wis];
	}
}