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

package l1j.server.server.templates;

public class L1MobSkill implements Cloneable {
	public static final int TYPE_NONE = 0;

	public static final int TYPE_PHYSICAL_ATTACK = 1;

	public static final int TYPE_MAGIC_ATTACK = 2;

	public static final int TYPE_SUMMON = 3;

	public static final int TYPE_POLY = 4;

	public static final int CHANGE_TARGET_NO = 0;

	public static final int CHANGE_TARGET_COMPANION = 1;

	public static final int CHANGE_TARGET_ME = 2;

	public static final int CHANGE_TARGET_RANDOM = 3;

	private final int skillSize;

	@Override
	public L1MobSkill clone() {
		try {
			return (L1MobSkill) (super.clone());
		} catch (CloneNotSupportedException e) {
			throw (new InternalError(e.getMessage()));
		}
	}

	public int getSkillSize() {
		return skillSize;
	}

	public L1MobSkill(int sSize) {
		skillSize = sSize;

		type = new int[skillSize];
		triRnd = new int[skillSize];
		triHp = new int[skillSize];
		triCompanionHp = new int[skillSize];
		triRange = new int[skillSize];
		triCount = new int[skillSize];
		changeTarget = new int[skillSize];
		range = new int[skillSize];
		areaWidth = new int[skillSize];
		areaHeight = new int[skillSize];
		leverage = new int[skillSize];
		skillId = new int[skillSize];
		gfxid = new int[skillSize];
		actid = new int[skillSize];
		summon = new int[skillSize];
		summonMin = new int[skillSize];
		summonMax = new int[skillSize];
		polyId = new int[skillSize];
	}

	private int mobid;

	public int get_mobid() {
		return mobid;
	}

	public void set_mobid(int i) {
		mobid = i;
	}

	private String mobName;

	public String getMobName() {
		return mobName;
	}

	public void setMobName(String s) {
		mobName = s;
	}

	/*
	 * 0 -> type of skills do nothing, 1 -> physical attacks, 2 -> magic attack,
	 * 3 -> Salmon
	 */
	private int type[];

	public int getType(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return type[idx];
	}

	public void setType(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		type[idx] = i;
	}

	/*
	 * Imposition of conditions skills: random probability (0% to 100%)
	 * imposition of skills
	 */
	private int triRnd[];

	public int getTriggerRandom(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return triRnd[idx];
	}

	public void setTriggerRandom(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		triRnd[idx] = i;
	}

	/*
	 * Imposition of conditions skills: HP is following imposition%
	 */
	int triHp[];

	public int getTriggerHp(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return triHp[idx];
	}

	public void setTriggerHp(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		triHp[idx] = i;
	}

	/*
	 * Imposition of conditions skills: HP is akin to invoke%
	 */
	int triCompanionHp[];

	public int getTriggerCompanionHp(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return triCompanionHp[idx];
	}

	public void setTriggerCompanionHp(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		triCompanionHp[idx] = i;
	}

	/*
	 * Imposition of conditions skills: triRange <0 if the target is too abs
	 * (triRange) following the imposition of TriRange> 0, the distance covered
	 * over when the engine is triRange
	 */
	int triRange[];

	public int getTriggerRange(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return triRange[idx];
	}

	public void setTriggerRange(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		triRange[idx] = i;
	}

	// distance Idx specified skills or the imposition of conditions
	public boolean isTriggerDistance(int idx, int distance) {
		int triggerRange = getTriggerRange(idx);

		if ((triggerRange < 0 && distance <= Math.abs(triggerRange))
				|| (triggerRange > 0 && distance >= triggerRange)) {
			return true;
		}
		return false;
	}

	int triCount[];

	/*
	 * Imposition of conditions skills: Skills triCount following the imposition
	 * of a number of fires
	 */
	public int getTriggerCount(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return triCount[idx];
	}

	public void setTriggerCount(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		triCount[idx] = i;
	}

	/*
	 * Imposition of skills, or to change the target
	 */
	int changeTarget[];

	public int getChangeTarget(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return changeTarget[idx];
	}

	public void setChangeTarget(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		changeTarget[idx] = i;
	}

	/*
	 * If the distance range attacks, physical attacks if the attacks, even if
	 * the proximity to more than 1 set
	 */
	int range[];

	public int getRange(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return range[idx];
	}

	public void setRange(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		range[idx] = i;
	}

	/*
	 * Wide range of attacks, stand-alone if it attacks 0 you, if you attack a
	 * range of zero to set Width and Height setting is an attacker from the
	 * width of Width, Height and depth. Width + - so, do you specify the
	 * target, mainly as a left-right up until the target.
	 */
	int areaWidth[];

	public int getAreaWidth(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return areaWidth[idx];
	}

	public void setAreaWidth(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		areaWidth[idx] = i;
	}

	/*
	 * High-range attack in a single attack if 0 you, if you attack a range of
	 * more than 1 set
	 */
	int areaHeight[];

	public int getAreaHeight(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return areaHeight[idx];
	}

	public void setAreaHeight(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		areaHeight[idx] = i;
	}

	/*
	 * Damage magnification, 1 / 10, respectively. Physical attacks, magic
	 * attacks both effective
	 */
	int leverage[];

	public int getLeverage(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return leverage[idx];
	}

	public void setLeverage(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		leverage[idx] = i;
	}

	/*
	 * If you use magic, SkillId specifying
	 */
	int skillId[];

	public int getSkillId(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return skillId[idx];
	}

	public void setSkillId(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		skillId[idx] = i;
	}

	/*
	 * Physical attacks against the motion graphics
	 */
	int gfxid[];

	public int getGfxid(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return gfxid[idx];
	}

	public void setGfxid(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		gfxid[idx] = i;
	}

	/*
	 * Physical attacks graphics ID Action
	 */
	int actid[];

	public int getActid(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return actid[idx];
	}

	public void setActid(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		actid[idx] = i;
	}

	/*
	 * Summon the Monster NPCID
	 */
	int summon[];

	public int getSummon(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return summon[idx];
	}

	public void setSummon(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		summon[idx] = i;
	}

	/*
	 * Summon the minimum number of Monster
	 */
	int summonMin[];

	public int getSummonMin(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return summonMin[idx];
	}

	public void setSummonMin(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		summonMin[idx] = i;
	}

	/*
	 * Summon the maximum number of Monster
	 */
	int summonMax[];

	public int getSummonMax(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return summonMax[idx];
	}

	public void setSummonMax(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		summonMax[idx] = i;
	}

	/*
	 * What forced to mutate?
	 */
	int polyId[];

	public int getPolyId(int idx) {
		if (idx < 0 || idx >= getSkillSize()) {
			return 0;
		}
		return polyId[idx];
	}

	public void setPolyId(int idx, int i) {
		if (idx < 0 || idx >= getSkillSize()) {
			return;
		}
		polyId[idx] = i;
	}
}
