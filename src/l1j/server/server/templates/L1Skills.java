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

public class L1Skills {

	public static final int ATTR_NONE = 0;

	public static final int ATTR_EARTH = 1;

	public static final int ATTR_FIRE = 2;

	public static final int ATTR_WATER = 4;

	public static final int ATTR_WIND = 8;

	public static final int ATTR_RAY = 16;

	public static final int TYPE_PROBABILITY = 1;

	public static final int TYPE_CHANGE = 2;

	public static final int TYPE_CURSE = 4;

	public static final int TYPE_DEATH = 8;

	public static final int TYPE_HEAL = 16;

	public static final int TYPE_RESTORE = 32;

	public static final int TYPE_ATTACK = 64;

	public static final int TYPE_OTHER = 128;

	public static final int TARGET_TO_ME = 0;

	public static final int TARGET_TO_PC = 1;

	public static final int TARGET_TO_NPC = 2;

	public static final int TARGET_TO_CLAN = 4;

	public static final int TARGET_TO_PARTY = 8;

	public static final int TARGET_TO_PET = 16;

	public static final int TARGET_TO_PLACE = 32;

	private int _skillId;

	public int getSkillId() {
		return _skillId;
	}

	public void setSkillId(int i) {
		_skillId = i;
	}

	private String _name;

	public String getName() {
		return _name;
	}

	public void setName(String s) {
		_name = s;
	}

	private int _skillLevel;

	public int getSkillLevel() {
		return _skillLevel;
	}

	public void setSkillLevel(int i) {
		_skillLevel = i;
	}

	private int _skillNumber;

	public int getSkillNumber() {
		return _skillNumber;
	}

	public void setSkillNumber(int i) {
		_skillNumber = i;
	}

	private int _mpConsume;

	public int getMpConsume() {
		return _mpConsume;
	}

	public void setMpConsume(int i) {
		_mpConsume = i;
	}

	private int _hpConsume;

	public int getHpConsume() {
		return _hpConsume;
	}

	public void setHpConsume(int i) {
		_hpConsume = i;
	}

	private int _itmeConsumeId;

	public int getItemConsumeId() {
		return _itmeConsumeId;
	}

	public void setItemConsumeId(int i) {
		_itmeConsumeId = i;
	}

	private int _itmeConsumeCount;

	public int getItemConsumeCount() {
		return _itmeConsumeCount;
	}

	public void setItemConsumeCount(int i) {
		_itmeConsumeCount = i;
	}

	private int _reuseDelay; 

	public int getReuseDelay() {
		return _reuseDelay;
	}

	public void setReuseDelay(int i) {
		_reuseDelay = i;
	}

	private int _buffDuration; 

	public int getBuffDuration() {
		return _buffDuration;
	}

	public void setBuffDuration(int i) {
		_buffDuration = i;
	}

	private String _target;

	public String getTarget() {
		return _target;
	}

	public void setTarget(String s) {
		_target = s;
	}

	private int _targetTo; 

	public int getTargetTo() {
		return _targetTo;
	}

	public void setTargetTo(int i) {
		_targetTo = i;
	}

	private int _damageValue;

	public int getDamageValue() {
		return _damageValue;
	}

	public void setDamageValue(int i) {
		_damageValue = i;
	}

	private int _damageDice;

	public int getDamageDice() {
		return _damageDice;
	}

	public void setDamageDice(int i) {
		_damageDice = i;
	}

	private int _damageDiceCount;

	public int getDamageDiceCount() {
		return _damageDiceCount;
	}

	public void setDamageDiceCount(int i) {
		_damageDiceCount = i;
	}

	private int _probabilityValue;

	public int getProbabilityValue() {
		return _probabilityValue;
	}

	public void setProbabilityValue(int i) {
		_probabilityValue = i;
	}

	private int _probabilityDice;

	public int getProbabilityDice() {
		return _probabilityDice;
	}

	public void setProbabilityDice(int i) {
		_probabilityDice = i;
	}

	private int _attr;

	public int getAttr() {
		return _attr;
	}

	public void setAttr(int i) {
		_attr = i;
	}

	private int _type; 

	public int getType() {
		return _type;
	}

	public void setType(int i) {
		_type = i;
	}

	private int _lawful;

	public int getLawful() {
		return _lawful;
	}

	public void setLawful(int i) {
		_lawful = i;
	}

	private int _ranged;

	public int getRanged() {
		return _ranged;
	}

	public void setRanged(int i) {
		_ranged = i;
	}

	private int _area;

	public int getArea() {
		return _area;
	}

	public void setArea(int i) {
		_area = i;
	}

	boolean _isThrough;

	public boolean isThrough() {
		return _isThrough;
	}

	public void setThrough(boolean flag) {
		_isThrough = flag;
	}

	private int _id;

	public int getId() {
		return _id;
	}

	public void setId(int i) {
		_id = i;
	}

	private String _nameId;

	public String getNameId() {
		return _nameId;
	}

	public void setNameId(String s) {
		_nameId = s;
	}

	private int _actionId;

	public int getActionId() {
		return _actionId;
	}

	public void setActionId(int i) {
		_actionId = i;
	}

	private int _castGfx;

	public int getCastGfx() {
		return _castGfx;
	}

	public void setCastGfx(int i) {
		_castGfx = i;
	}

	private int _castGfx2;

	public int getCastGfx2() {
		return _castGfx2;
	}

	public void setCastGfx2(int i) {
		_castGfx2 = i;
	}


	private int _sysmsgIdHappen;

	public int getSysmsgIdHappen() {
		return _sysmsgIdHappen;
	}

	public void setSysmsgIdHappen(int i) {
		_sysmsgIdHappen = i;
	}

	private int _sysmsgIdStop;

	public int getSysmsgIdStop() {
		return _sysmsgIdStop;
	}

	public void setSysmsgIdStop(int i) {
		_sysmsgIdStop = i;
	}

	private int _sysmsgIdFail;

	public int getSysmsgIdFail() {
		return _sysmsgIdFail;
	}

	public void setSysmsgIdFail(int i) {
		_sysmsgIdFail = i;
	}

}
