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

import l1j.server.Config;
import l1j.server.server.model.classes.L1ClassId;
import l1j.server.server.utils.RandomArrayList;

class L1DragonKnightClassFeature extends L1ClassFeature {
	@Override
	public int getAcDefenseMax(int ac) {
		if (Config.SOFT_AC)
		{
			return ac / 3;
		}
		else
		{
			return ac / 2; 
		}
	}

	@Override
	public int getMagicLevel(int playerLevel) {
		return Math.min(4, playerLevel / 9);
	}

	@Override 
	public int getMaxSpellLevel() { 
		return 0; 
	} 
	
	@Override 
	public int getSpellLearningInterval() { 
		return 0; 
	}

	@Override
	public int[] InitSpawn(int type) {
		int spawn[] = {32714, 32877, 69};
		return spawn;
	}

	@Override
	public int InitSex(int sex) {
		switch(sex) {
		case 0:
			return L1ClassId.DRAGON_KNIGHT_MALE;
		default:
			return L1ClassId.DRAGON_KNIGHT_FEMALE;
		}
	}

	@Override
	public int InitHp() {
		return 16;
	}

	@Override
	public int InitMp(int BaseWis) {
		switch(BaseWis) {
		case 1: case 2: case 3: case 4: case 5:
		case 6: case 7: case 8: case 9: case 10:
		case 11: case 12: case 13: case 14: case 15:
			return 2;
		default:
			return 4;
		}
	}

	@Override
	public int InitMr() {
		return 18;
	}

	@Override
	public int[] InitPoints() {
		int points[] = {13, 11, 14, 12, 8, 11, 6};
		return points;
	}

	@Override
	public int bounsCha() {
		return 6;
	}

	@Override
	public int calcAcDefense(int ac) {
		return (ac / 3);
	}

	@Override
	public int calcLvFightDmg(int lv) {
		return (lv / 10);
	}

	@Override
	public int calcLvShotDmg(int lv) {
		return 0;
	}

	@Override
	public int calcLvHit(int lv) {
		return (lv / 4);
	}

	@Override
	public int calcLvUpEr(int lv) {
		return (lv / 7);
	}

	@Override
	public int calcMagicLevel(int lv) {
		return Math.min(6, lv / 9);
	}

	@Override
	public int calclvUpHp(int baseCon) {
		short randomhp = 0;
		int randomadd = RandomArrayList.getInc(5, -2);
		byte playerbasecon = (byte) (baseCon / 2);
		randomhp += (short) (playerbasecon + randomadd + 5);

		return randomhp;
	}

	public static int[] DK_RandomMp = {
		//	 0  1  2  3  4  5  6  7  8  9
			 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, // baseWis =  0 ~  9
			 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, // baseWis = 10 ~ 19
			 4, 4, 4, 4, 5, 4, 4, 5, 5, 4, // baseWis = 20 ~ 29
			 4, 5, 5, 4, 4, 5 };		   // baseWis = 30 ~ 35
	public static int[] DK_BaseMp = {
		//	 0  1  2  3  4  5  6  7  8  9
			 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, // baseWis =  0 ~  9
			 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, // baseWis = 10 ~ 19
			 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, // baseWis = 20 ~ 29
			 6, 6, 6, 7, 7, 7 };		   // baseWis = 30 ~ 35

	@Override
	public int calclvUpMp(int baseWis) {
		int randommp = 0;
		int temp_baseWis = (baseWis > 34) ? 35 : baseWis;
		randommp = RandomArrayList.getInc(DK_RandomMp[temp_baseWis]
				, DK_BaseMp[temp_baseWis]);
		return (int) (randommp * 2 / 3);
	}

	@Override
	public int MaxHp() {
		return Config.DRAGONKNIGHT_MAX_HP;
	}

	@Override
	public int MaxMp() {
		return Config.DRAGONKNIGHT_MAX_MP;
	}
}