package l1j.server.server.templates;

public class L1Armor extends L1Item {
	private static final long serialVersionUID = 1L;

	public L1Armor() {
	}

	private int _ac = 0;

	@Override
	public int get_ac() {
		return _ac;
	}

	public void set_ac(int i) {
		this._ac = i;
	}

	private int _damageReduction = 0;

	@Override
	public int getDamageReduction() {
		return _damageReduction;
	}

	public void setDamageReduction(int i) {
		_damageReduction = i;
	}

	private int _weightReduction = 0;

	@Override
	public int getWeightReduction() {
		return _weightReduction;
	}

	public void setWeightReduction(int i) {
		_weightReduction = i;
	}

	private int _hitModifierByArmor = 0;

	@Override
	public int getHitModifierByArmor() {
		return _hitModifierByArmor;
	}

	public void setHitModifierByArmor(int i) {
		_hitModifierByArmor = i;
	}

	private int _dmgModifierByArmor = 0;

	@Override
	public int getDmgModifierByArmor() {
		return _dmgModifierByArmor;
	}

	public void setDmgModifierByArmor(int i) {
		_dmgModifierByArmor = i;
	}

	private int _bowHitModifierByArmor = 0;

	@Override
	public int getBowHitModifierByArmor() {
		return _bowHitModifierByArmor;
	}

	public void setBowHitModifierByArmor(int i) {
		_bowHitModifierByArmor = i;
	}

	private int _bowDmgModifierByArmor = 0;

	@Override
	public int getBowDmgModifierByArmor() {
		return _bowDmgModifierByArmor;
	}

	public void setBowDmgModifierByArmor(int i) {
		_bowDmgModifierByArmor = i;
	}

	private int _defense_water = 0;

	public void set_defense_water(int i) {
		_defense_water = i;
	}

	@Override
	public int get_defense_water() {
		return this._defense_water;
	}

	private int _defense_wind = 0;

	public void set_defense_wind(int i) {
		_defense_wind = i;
	}

	@Override
	public int get_defense_wind() {
		return this._defense_wind;
	}

	private int _defense_fire = 0;

	public void set_defense_fire(int i) {
		_defense_fire = i;
	}

	@Override
	public int get_defense_fire() {
		return this._defense_fire;
	}

	private int _defense_earth = 0;

	public void set_defense_earth(int i) {
		_defense_earth = i;
	}

	@Override
	public int get_defense_earth() {
		return this._defense_earth;
	}

	private int _resist_stun = 0;

	public void set_resist_stun(int i) {
		_resist_stun = i;
	}

	@Override
	public int get_resist_stun() {
		return this._resist_stun;
	}

	private int _resist_stone = 0;

	public void set_resist_stone(int i) {
		_resist_stone = i;
	}

	@Override
	public int get_resist_stone() {
		return this._resist_stone;
	}

	private int _resist_sleep = 0;

	public void set_resist_sleep(int i) {
		_resist_sleep = i;
	}

	@Override
	public int get_resist_sleep() {
		return this._resist_sleep;
	}

	private int _resist_freeze = 0;

	public void set_resist_freeze(int i) {
		_resist_freeze = i;
	}

	@Override
	public int get_resist_freeze() {
		return this._resist_freeze;
	}

	private int _resist_sustain = 0; //

	public void set_resist_sustain(int i) {
		_resist_sustain = i;
	}

	@Override
	public int get_resist_sustain() {
		return this._resist_sustain;
	}

	private int _resist_blind = 0; //

	public void set_resist_blind(int i) {
		_resist_blind = i;
	}

	@Override
	public int get_resist_blind() {
		return this._resist_blind;
	}

	private int _grade;

	@Override
	public int getGrade() {
		return _grade;
	}

	public void setGrade(int grade) {
		_grade = grade;
	}
}
