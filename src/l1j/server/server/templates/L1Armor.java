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

public class L1Armor extends L1Item {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1Armor() {
	}

	private int _ac = 0; // AC

	@Override
	public int get_ac() {
		return _ac;
	}

	public void set_ac(int i) {
		this._ac = i;
	}

	private int _damageReduction = 0; // damage

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

	private int _bowHitRate = 0; 

	@Override
	public int getBowHitRate() {
		return _bowHitRate;
	}

	public void setBowHitRate(int i) {
		_bowHitRate = i;
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

	private int _regist_stun = 0; 

	public void set_regist_stun(int i) {
		_regist_stun = i;
	}

	@Override
	public int get_regist_stun() {
		return this._regist_stun;
	}

	private int _regist_stone = 0; 

	public void set_regist_stone(int i) {
		_regist_stone = i;
	}

	@Override
	public int get_regist_stone() {
		return this._regist_stone;
	}

	private int _regist_sleep = 0;

	public void set_regist_sleep(int i) {
		_regist_sleep = i;
	}

	@Override
	public int get_regist_sleep() {
		return this._regist_sleep;
	}

	private int _regist_freeze = 0; 

	public void set_regist_freeze(int i) {
		_regist_freeze = i;
	}

	@Override
	public int get_regist_freeze() {
		return this._regist_freeze;
	}

	private int _regist_sustain = 0; //

	public void set_regist_sustain(int i) {
		_regist_sustain = i;
	}

	@Override
	public int get_regist_sustain() {
		return this._regist_sustain;
	}

	private int _regist_blind = 0; // 

	public void set_regist_blind(int i) {
		_regist_blind = i;
	}

	@Override
	public int get_regist_blind() {
		return this._regist_blind;
	}

}
