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
package l1j.server.server.model;

import java.util.Random;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.WarTimeController;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.poison.L1DamagePoison;
import l1j.server.server.model.poison.L1ParalysisPoison;
import l1j.server.server.model.poison.L1SilencePoison;
import l1j.server.server.serverpackets.S_AttackMissPacket;
import l1j.server.server.serverpackets.S_AttackPacketForNpc;
import l1j.server.server.serverpackets.S_AttackPacket;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_UseArrowSkill;
import l1j.server.server.serverpackets.S_UseAttackSkill;
import l1j.server.server.types.Point;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1Attack {
	private static Logger _log = Logger.getLogger(L1Attack.class.getName());

	private L1PcInstance _pc = null;

	private L1Character _target = null;

	private L1PcInstance _targetPc = null;

	private L1NpcInstance _npc = null;

	private L1NpcInstance _targetNpc = null;

	private final int _targetId;

	private int _targetX;

	private int _targetY;

	private int _statusDamage = 0;

	private static final Random _random = new Random();

	private int _hitRate = 0;

	private int _calcType;

	private static final int PC_PC = 1;

	private static final int PC_NPC = 2;

	private static final int NPC_PC = 3;

	private static final int NPC_NPC = 4;

	private boolean _isHit = false;

	private int _damage = 0;

	private int _drainMana = 0;

	private int _drainHp = 0;

	private int _attckGrfxId = 0;

	private int _attckActId = 0;

	// UvC[
	private L1ItemInstance weapon = null;

	private int _weaponId = 0;

	private int _weaponType = 0;

	private int _weaponType2 = 0;

	private int _weaponAddHit = 0;

	private int _weaponAddDmg = 0;

	private int _weaponSmall = 0;

	private int _weaponLarge = 0;

	private int _weaponRange = 1;

	private int _weaponBless = 1;

	private int _weaponEnchant = 0;

	private int _weaponMaterial = 0;

	private int _weaponDoubleDmgChance = 0;

	private int _weaponAttrEnchantKind = 0;

	private int _weaponAttrEnchantLevel = 0;

	private L1ItemInstance _arrow = null;

	private L1ItemInstance _sting = null;

	private int _leverage = 10; // 1/10{\B

	public void setLeverage(int i) {
		_leverage = i;
	}

	private int getLeverage() {
		return _leverage;
	}

	// UvC[Xe[^X
// private static final int[] strHit = { -2, -2, -2, -2, -2, -2, -2, -2, -2,
// -2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9,
// 9, 10, 10, 11, 11, 12, 12, 13, 13, 14 };

// private static final int[] dexHit = { -2, -2, -2, -2, -2, -2, -2, -2, -2,
// -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8,
// 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14 };

/*
 * private static final int[] strHit = { -2, -2, -2, -2, -2, -2, -2, // 0`7
 * -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, // 8`26 7, 7, 7,
 * 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, // 27`44 13, 13, 13,
 * 14, 14, 14, 15, 15, 15, 16, 16, 16, 17, 17, 17}; // 45`59
 * 
 * private static final int[] dexHit = { -2, -2, -2, -2, -2, -2, -1, -1, 0, 0, //
 * 1`10 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, //
 * 11`30 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, //
 * 31`45 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46 }; //
 * 46`60
 * 
 * private static final int[] strDmg = new int[128];
 * 
 * static { // rsq_[W int dmg = -6; for (int str = 0; str <= 22; str++) { //
 * O`QQQ{P if (str % 2 == 1) { dmg++; } strDmg[str] = dmg; } for (int str =
 * 23; str <= 28; str++) { // QR`QWR{P if (str % 3 == 2) { dmg++; }
 * strDmg[str] = dmg; } for (int str = 29; str <= 32; str++) { // QX`RQQ{P if
 * (str % 2 == 1) { dmg++; } strDmg[str] = dmg; } for (int str = 33; str <= 39;
 * str++) { // RR`RXP{P dmg++; strDmg[str] = dmg; } for (int str = 40; str <=
 * 46; str++) { // SO`SUP{Q dmg += 2; strDmg[str] = dmg; } for (int str = 47;
 * str <= 127; str++) { // SV`PQVP{P dmg++; strDmg[str] = dmg; } }
 * 
 * private static final int[] dexDmg = new int[128];
 * 
 * static { // cdw_[W for (int dex = 0; dex <= 14; dex++) { // O`PSO
 * dexDmg[dex] = 0; } dexDmg[15] = 1; dexDmg[16] = 2; dexDmg[17] = 3; dexDmg[18] =
 * 4; dexDmg[19] = 4; dexDmg[20] = 4; dexDmg[21] = 5; dexDmg[22] = 5; dexDmg[23] =
 * 5; int dmg = 5; for (int dex = 24; dex <= 127; dex++) { // QS`PQVP{P
 * dmg++; dexDmg[dex] = dmg; } }
 */

	private static final int[] strHit = { -2, -2, -2, -2, -2, -2, -2, // 1`7
			-2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, // 8`26
			7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, // 27`44
			13, 13, 13, 14, 14, 14, 15, 15, 15, 16, 16, 16, 17, 17, 17}; // 45`59

	private static final int[] dexHit = { -2, -2, -2, -2, -2, -2, -1, -1, 0, 0, // 1`10
			1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, // 11`30
			17, 18, 19, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 22, 23, // 31`45
			23, 23, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28 }; // 46`60

	private static final int[] strDmg = new int[128];

	static {
		// STR_[W
		int dmg = -6;
		for (int str = 0; str <= 22; str++) { // 0`222+1
			if (str % 2 == 1) {
				dmg++;
			}
			strDmg[str] = dmg;
		}
		for (int str = 23; str <= 28; str++) { // 23`283+1
			if (str % 3 == 2) {
				dmg++;
			}
			strDmg[str] = dmg;
		}
		for (int str = 29; str <= 32; str++) { // 29`322+1
			if (str % 2 == 1) {
				dmg++;
			}
			strDmg[str] = dmg;
		}
		for (int str = 33; str <= 34; str++) { // 33`341+1
			dmg++;
			strDmg[str] = dmg;
		}
		for (int str = 35; str <= 127; str++) { // 35`1274+1
			if (str % 4 == 1) {
				dmg++;
			}
			strDmg[str] = dmg;
		}
	}

	private static final int[] dexDmg = new int[128];

	static {
		// DEX_[W
		for (int dex = 0; dex <= 14; dex++) {
			// 0`140
			dexDmg[dex] = 0;
		}
		dexDmg[15] = 1;
		dexDmg[16] = 2;
		dexDmg[17] = 3;
		dexDmg[18] = 4;
		dexDmg[19] = 4;
		dexDmg[20] = 4;
		dexDmg[21] = 5;
		dexDmg[22] = 5;
		dexDmg[23] = 5;
		int dmg = 5;
		for (int dex = 24; dex <= 35; dex++) { // 24`353+1
			if (dex % 3 == 1) {
				dmg++;
			}
			dexDmg[dex] = dmg;
		}
		for (int dex = 36; dex <= 127; dex++) { // 36`12741
			if (dex % 4 == 1) {
				dmg++;
			}
			dexDmg[dex] = dmg;
		}
	}

	public void setActId(int actId) {
		_attckActId = actId;
	}

	public void setGfxId(int gfxId) {
		_attckGrfxId = gfxId;
	}

	public int getActId() {
		return _attckActId;
	}

	public int getGfxId() {
		return _attckGrfxId;
	}

	public L1Attack(L1Character attacker, L1Character target) {
		if (attacker instanceof L1PcInstance) {
			_pc = (L1PcInstance) attacker;
			if (target instanceof L1PcInstance) {
				_targetPc = (L1PcInstance) target;
				_calcType = PC_PC;
			} else if (target instanceof L1NpcInstance) {
				_targetNpc = (L1NpcInstance) target;
				_calcType = PC_NPC;
			}
			// 
			weapon = _pc.getWeapon();
			if (weapon != null) {
				_weaponId = weapon.getItem().getItemId();
				_weaponType = weapon.getItem().getType1();
				_weaponType2 = weapon.getItem().getType();
				_weaponAddHit = weapon.getItem().getHitModifier()
						+ weapon.getHitByMagic();
				_weaponAddDmg = weapon.getItem().getDmgModifier()
						+ weapon.getDmgByMagic();
				_weaponSmall = weapon.getItem().getDmgSmall();
				_weaponLarge = weapon.getItem().getDmgLarge();
				_weaponRange = weapon.getItem().getRange();
				_weaponBless = weapon.getItem().getBless();
				if (_weaponType != 20 && _weaponType != 62) {
					_weaponEnchant = weapon.getEnchantLevel()
							- weapon.get_durability(); // }CiX
				} else {
					_weaponEnchant = weapon.getEnchantLevel();
				}
				_weaponMaterial = weapon.getItem().getMaterial();
				if (_weaponType == 20) { // A[
					_arrow = _pc.getInventory().getArrow();
					if (_arrow != null) {
						_weaponBless = _arrow.getItem().getBless();
						_weaponMaterial = _arrow.getItem().getMaterial();
					}
				}
				if (_weaponType == 62) { // XeBO
					_sting = _pc.getInventory().getSting();
					if (_sting != null) {
						_weaponBless = _sting.getItem().getBless();
						_weaponMaterial = _sting.getItem().getMaterial();
					}
				}
				_weaponDoubleDmgChance = weapon.getItem().getDoubleDmgChance();
				_weaponAttrEnchantKind = weapon.getAttrEnchantKind();
				_weaponAttrEnchantLevel = weapon.getAttrEnchantLevel();
			}
			// Xe[^X_[W
			if (_weaponType == 20) { // |cdwlQ
				_statusDamage = dexDmg[_pc.getDex()];
			} else { // OrsqlQ
				_statusDamage = strDmg[_pc.getStr()];
			}
		} else if (attacker instanceof L1NpcInstance) {
			_npc = (L1NpcInstance) attacker;
			if (target instanceof L1PcInstance) {
				_targetPc = (L1PcInstance) target;
				_calcType = NPC_PC;
			} else if (target instanceof L1NpcInstance) {
				_targetNpc = (L1NpcInstance) target;
				_calcType = NPC_NPC;
			}
		}
		_target = target;
		_targetId = target.getId();
		_targetX = target.getX();
		_targetY = target.getY();
	}

	/*    */

	public boolean calcHit() {
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			if (_weaponRange != -1) {
				if (_pc.getLocation().getTileLineDistance(
						_target.getLocation()) > _weaponRange + 1) { // BIGX^[+1
					_isHit = false; // O
					return _isHit;
				}
			} else {
				if (!_pc.getLocation().isInScreen(_target.getLocation())) {
					_isHit = false; // O
					return _isHit;
				}
			}
			if (_weaponType == 20 && _weaponId != 190 && _arrow == null) {
				_isHit = false; // ~X
			} else if (_weaponType == 62 && _sting == null) {
				_isHit = false; // XeBO~X
			} else if (!_pc.glanceCheck(_targetX, _targetY)) {
				_isHit = false; // UvC[Q
			} else if (_weaponId == 247 || _weaponId == 248
					|| _weaponId == 249) {
				_isHit = false; // B`C U
			} else if (_calcType == PC_PC) {
				_isHit = calcPcPcHit();
			} else if (_calcType == PC_NPC) {
				_isHit = calcPcNpcHit();
			}
		} else if (_calcType == NPC_PC) {
			_isHit = calcNpcPcHit();
		} else if (_calcType == NPC_NPC) {
			_isHit = calcNpcNpcHit();
		}
		return _isHit;
	}

	//  vC[  vC[  
	/*
	 * ob iPCLv{NX{STR{DEX{{DAI/2{@j~0.68|10
	 * Zol(95%)^PCAC PCAC11
	 * 5% 95%
	 */
	private boolean calcPcPcHit() {
		_hitRate = _pc.getLevel();

		if (_pc.getStr() > 59) {
			_hitRate += strHit[58];
		} else {
			_hitRate += strHit[_pc.getStr() - 1];
		}

		if (_pc.getDex() > 60) {
			_hitRate += dexHit[59];
		} else {
			_hitRate += dexHit[_pc.getDex() - 1];
		}

		if (_weaponType != 20 && _weaponType != 62) {
			_hitRate += _weaponAddHit + _pc.getHitup() + _pc.getOriginalHitup()
					+ (_weaponEnchant / 2);
		} else {
			_hitRate += _weaponAddHit + _pc.getBowHitup() + _pc
					.getOriginalBowHitup() + (_weaponEnchant / 2);
		}

		if (_weaponType != 20 && _weaponType != 62) { // h
			_hitRate += _pc.getHitModifierByArmor();
		} else {
			_hitRate += _pc.getBowHitModifierByArmor();
		}

		if (80 < _pc.getInventory().getWeight240() // d
				&& 120 >= _pc.getInventory().getWeight240()) {
			_hitRate -= 1;
		} else if (121 <= _pc.getInventory().getWeight240()
				&& 160 >= _pc.getInventory().getWeight240()) {
			_hitRate -= 3;
		} else if (161 <= _pc.getInventory().getWeight240()
				&& 200 >= _pc.getInventory().getWeight240()) {
			_hitRate -= 5;
		}

		if (_pc.hasSkillEffect(COOKING_2_0_N) // 
				|| _pc.hasSkillEffect(COOKING_2_0_S)) {
			if (_weaponType != 20 && _weaponType != 62) {
				_hitRate += 1;
			}
		}
		if (_pc.hasSkillEffect(COOKING_3_2_N) // 
				|| _pc.hasSkillEffect(COOKING_3_2_S)) {
			if (_weaponType != 20 && _weaponType != 62) {
				_hitRate += 2;
			}
		}
		if (_pc.hasSkillEffect(COOKING_2_3_N) // 
				|| _pc.hasSkillEffect(COOKING_2_3_S)
				|| _pc.hasSkillEffect(COOKING_3_0_N)
				|| _pc.hasSkillEffect(COOKING_3_0_S)) {
			if (_weaponType == 20 || _weaponType == 62) {
				_hitRate += 1;
			}
		}

		int attackerDice = _random.nextInt(20) + 1 + _hitRate - 10;

		if (_targetPc.hasSkillEffect(UNCANNY_DODGE)) {
			attackerDice -= 5;
		}

		if (_targetPc.hasSkillEffect(MIRROR_IMAGE)) {
			attackerDice -= 5;
		}

		if (_targetPc.hasSkillEffect(RESIST_FEAR)) {
			attackerDice += 5;
		}

		int defenderDice = 0;

		int defenderValue = (int) (_targetPc.getAc() * 1.5) * -1;

		if (_targetPc.getAc() >= 0) {
			defenderDice = 10 - _targetPc.getAc();
		} else if (_targetPc.getAc() < 0) {
			defenderDice = 10 + _random.nextInt(defenderValue) + 1;
		}

		int fumble = _hitRate - 9;
		int critical = _hitRate + 10;

		if (attackerDice <= fumble) {
			_hitRate = 0;
		} else if (attackerDice >= critical) {
			_hitRate = 100;
		} else {
			if (attackerDice > defenderDice) {
				_hitRate = 100;
			} else if (attackerDice <= defenderDice) {
				_hitRate = 0;
			}
		}

		if (_weaponType2 == 17) {
			_hitRate = 100; // L[N100%
		}

		if (_targetPc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(ICE_LANCE)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BLIZZARD)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BREATH)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(EARTH_BIND)) {
			_hitRate = 0;
		}
		int rnd = _random.nextInt(100) + 1;
		if (_weaponType == 20 && _hitRate > rnd) { // |AqbgERxsB
			return calcErEvasion();
		}

		return _hitRate >= rnd;

/*
 * final int MIN_HITRATE = 5;
 * 
 * _hitRate = _pc.getLevel();
 * 
 * if (_pc.getStr() > 39) { _hitRate += strHit[39]; } else { _hitRate +=
 * strHit[_pc.getStr()]; }
 * 
 * if (_pc.getDex() > 39) { _hitRate += dexHit[39]; } else { _hitRate +=
 * dexHit[_pc.getDex()]; }
 * 
 * if (_weaponType != 20 && _weaponType != 62) { _hitRate += _weaponAddHit +
 * _pc.getHitup() + _pc.getOriginalHitup() + (_weaponEnchant / 2); } else {
 * _hitRate += _weaponAddHit + _pc.getBowHitup() + _pc .getOriginalBowHitup() +
 * (_weaponEnchant / 2); }
 * 
 * if (_weaponType != 20 && _weaponType != 62) { // h _hitRate +=
 * _pc.getHitModifierByArmor(); } else { _hitRate +=
 * _pc.getBowHitModifierByArmor(); }
 * 
 * int hitAc = (int) (_hitRate * 0.68 - 10) * -1;
 * 
 * if (hitAc <= _targetPc.getAc()) { _hitRate = 95; } else { _hitRate = 95 -
 * (hitAc - _targetPc.getAc()); }
 * 
 * if (_targetPc.hasSkillEffect(UNCANNY_DODGE)) { _hitRate -= 20; }
 * 
 * if (_targetPc.hasSkillEffect(MIRROR_IMAGE)) { _hitRate -= 20; }
 * 
 * if (_pc.hasSkillEffect(COOKING_2_0_N) //  ||
 * _pc.hasSkillEffect(COOKING_2_0_S)) { if (_weaponType != 20 && _weaponType !=
 * 62) { _hitRate += 1; } } if (_pc.hasSkillEffect(COOKING_3_2_N) //  ||
 * _pc.hasSkillEffect(COOKING_3_2_S)) { if (_weaponType != 20 && _weaponType !=
 * 62) { _hitRate += 2; } } if (_pc.hasSkillEffect(COOKING_2_3_N) //  ||
 * _pc.hasSkillEffect(COOKING_2_3_S) || _pc.hasSkillEffect(COOKING_3_0_N) ||
 * _pc.hasSkillEffect(COOKING_3_0_S)) { if (_weaponType == 20 || _weaponType ==
 * 62) { _hitRate += 1; } }
 * 
 * if (_hitRate < MIN_HITRATE) { _hitRate = MIN_HITRATE; }
 * 
 * if (_weaponType2 == 17) { _hitRate = 100; // L[N100% }
 * 
 * if (_targetPc.hasSkillEffect(ABSOLUTE_BARRIER)) { _hitRate = 0; } if
 * (_targetPc.hasSkillEffect(ICE_LANCE)) { _hitRate = 0; } if
 * (_targetPc.hasSkillEffect(FREEZING_BLIZZARD)) { _hitRate = 0; } if
 * (_targetPc.hasSkillEffect(FREEZING_BREATH)) { _hitRate = 0; } if
 * (_targetPc.hasSkillEffect(EARTH_BIND)) { _hitRate = 0; } int rnd =
 * _random.nextInt(100) + 1; if (_weaponType == 20 && _hitRate > rnd) { //
 * |AqbgERxsB return calcErEvasion(); }
 * 
 * return _hitRate >= rnd;
 */
	}

	//  vC[  mob  
	private boolean calcPcNpcHit() {
		// mob
		// iPCLv{NX{STR{DEX{{DAI/2{@j~5|{NPCAC~i-5j}
		_hitRate = _pc.getLevel();

		if (_pc.getStr() > 59) {
			_hitRate += strHit[58];
		} else {
			_hitRate += strHit[_pc.getStr() - 1];
		}

		if (_pc.getDex() > 60) {
			_hitRate += dexHit[59];
		} else {
			_hitRate += dexHit[_pc.getDex() - 1];
		}

		if (_weaponType != 20 && _weaponType != 62) {
			_hitRate += _weaponAddHit + _pc.getHitup() + _pc.getOriginalHitup()
					+ (_weaponEnchant / 2);
		} else {
			_hitRate += _weaponAddHit + _pc.getBowHitup() + _pc
					.getOriginalBowHitup() + (_weaponEnchant / 2);
		}

		if (_weaponType != 20 && _weaponType != 62) { // h
			_hitRate += _pc.getHitModifierByArmor();
		} else {
			_hitRate += _pc.getBowHitModifierByArmor();
		}

		if (80 < _pc.getInventory().getWeight240() // d
				&& 120 >= _pc.getInventory().getWeight240()) {
			_hitRate -= 1;
		} else if (121 <= _pc.getInventory().getWeight240()
				&& 160 >= _pc.getInventory().getWeight240()) {
			_hitRate -= 3;
		} else if (161 <= _pc.getInventory().getWeight240()
				&& 200 >= _pc.getInventory().getWeight240()) {
			_hitRate -= 5;
		}

		if (_pc.hasSkillEffect(COOKING_2_0_N) // 
				|| _pc.hasSkillEffect(COOKING_2_0_S)) {
			if (_weaponType != 20 && _weaponType != 62) {
				_hitRate += 1;
			}
		}
		if (_pc.hasSkillEffect(COOKING_3_2_N) // 
				|| _pc.hasSkillEffect(COOKING_3_2_S)) {
			if (_weaponType != 20 && _weaponType != 62) {
				_hitRate += 2;
			}
		}
		if (_pc.hasSkillEffect(COOKING_2_3_N) // 
				|| _pc.hasSkillEffect(COOKING_2_3_S)
				|| _pc.hasSkillEffect(COOKING_3_0_N)
				|| _pc.hasSkillEffect(COOKING_3_0_S)) {
			if (_weaponType == 20 || _weaponType == 62) {
				_hitRate += 1;
			}
		}

		int attackerDice = _random.nextInt(20) + 1 + _hitRate - 10;

		if (_targetNpc.hasSkillEffect(UNCANNY_DODGE)) {
			attackerDice -= 5;
		}

		if (_targetNpc.hasSkillEffect(MIRROR_IMAGE)) {
			attackerDice -= 5;
		}

		if (_targetNpc.hasSkillEffect(RESIST_FEAR)) {
			attackerDice += 5;
		}

		int defenderDice = 10 - _targetNpc.getAc();

		int fumble = _hitRate - 9;
		int critical = _hitRate + 10;

		if (attackerDice <= fumble) {
			_hitRate = 0;
		} else if (attackerDice >= critical) {
			_hitRate = 100;
		} else {
			if (attackerDice > defenderDice) {
				_hitRate = 100;
			} else if (attackerDice <= defenderDice) {
				_hitRate = 0;
			}
		}

		if (_weaponType2 == 17) {
			_hitRate = 100; // L[N100%
		}

		int npcId = _targetNpc.getNpcTemplate().get_npcId();
		if (npcId >= 45912 && npcId <= 45915 // \W[\W[S[Xg
				&& !_pc.hasSkillEffect(STATUS_HOLY_WATER)) {
			_hitRate = 0;
		}
		if (npcId == 45916 // nR
				&& !_pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER)) {
			_hitRate = 0;
		}
		if (npcId == 45941 // TG
				&& !_pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA)) {
			_hitRate = 0;
		}
		if (npcId == 45752 // oO(gO)
				&& !_pc.hasSkillEffect(STATUS_CURSE_BARLOG)) {
			_hitRate = 0;
		}
		if (npcId == 45753 // oO(g)
				&& !_pc.hasSkillEffect(STATUS_CURSE_BARLOG)) {
			_hitRate = 0;
		}
		if (npcId == 45675 // q(gO)
				&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
			_hitRate = 0;
		}
		if (npcId == 81082 // q(g)
				&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
			_hitRate = 0;
		}
		if (npcId == 45625 // 
				&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
			_hitRate = 0;
		}
		if (npcId == 45674 // 
				&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
			_hitRate = 0;
		}
		if (npcId == 45685 // 
				&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
			_hitRate = 0;
		}
		if (npcId >= 46068 && npcId <= 46091 // ~]Amob
				&& _pc.getTempCharGfx() == 6035) {
			_hitRate = 0;
		}
		if (npcId >= 46092 && npcId <= 46106 // e_amob
				&& _pc.getTempCharGfx() == 6034) {
			_hitRate = 0;
		}

 		int rnd = _random.nextInt(100) + 1;

		return _hitRate >= rnd;
	}

	//  mob  vC[  
	private boolean calcNpcPcHit() {

		_hitRate += _npc.getLevel();

		if (_npc instanceof L1PetInstance) { // ybg
			_hitRate += ((L1PetInstance) _npc).getHitByWeapon();
		}

		_hitRate += _npc.getHitup();

		int attackerDice = _random.nextInt(20) + 1 + _hitRate - 1;

		if (_targetPc.hasSkillEffect(UNCANNY_DODGE)) {
			attackerDice -= 5;
		}

		if (_targetPc.hasSkillEffect(MIRROR_IMAGE)) {
			attackerDice -= 5;
		}

		if (_targetPc.hasSkillEffect(RESIST_FEAR)) {
			attackerDice += 5;
		}

		int defenderDice = 0;

		int defenderValue = (_targetPc.getAc()) * -1;

		if (_targetPc.getAc() >= 0) {
			defenderDice = 10 - _targetPc.getAc();
		} else if (_targetPc.getAc() < 0) {
			defenderDice = 10 + _random.nextInt(defenderValue) + 1;
		}

		int fumble = _hitRate;
		int critical = _hitRate + 19;

		if (attackerDice <= fumble) {
			_hitRate = 0;
		} else if (attackerDice >= critical) {
			_hitRate = 100;
		} else {
			if (attackerDice > defenderDice) {
				_hitRate = 100;
			} else if (attackerDice <= defenderDice) {
				_hitRate = 0;
			}
		}

		if (_targetPc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(ICE_LANCE)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BLIZZARD)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BREATH)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(EARTH_BIND)) {
			_hitRate = 0;
		}

		int rnd = _random.nextInt(100) + 1;

		// NPCUW10A2|U
		if (_npc.getNpcTemplate().get_ranged() >= 10
				&& _hitRate > rnd
				&& _npc.getLocation().getTileLineDistance(
						new Point(_targetX, _targetY)) >= 2) {
			return calcErEvasion();
		}
		return _hitRate >= rnd;
	}

	//  mob  mob  
	private boolean calcNpcNpcHit() {

		_hitRate += _npc.getLevel();

		if (_npc instanceof L1PetInstance) { // ybg
			_hitRate += ((L1PetInstance) _npc).getHitByWeapon();
		}

		_hitRate += _npc.getHitup();

		int attackerDice = _random.nextInt(20) + 1 + _hitRate - 1;

		if (_targetNpc.hasSkillEffect(UNCANNY_DODGE)) {
			attackerDice -= 5;
		}

		if (_targetNpc.hasSkillEffect(MIRROR_IMAGE)) {
			attackerDice -= 5;
		}

		if (_targetNpc.hasSkillEffect(RESIST_FEAR)) {
			attackerDice += 5;
		}

		int defenderDice = 0;

		int defenderValue = (_targetNpc.getAc()) * -1;

		if (_targetNpc.getAc() >= 0) {
			defenderDice = 10 - _targetNpc.getAc();
		} else if (_targetNpc.getAc() < 0) {
			defenderDice = 10 + _random.nextInt(defenderValue) + 1;
		}

		int fumble = _hitRate;
		int critical = _hitRate + 19;

		if (attackerDice <= fumble) {
			_hitRate = 0;
		} else if (attackerDice >= critical) {
			_hitRate = 100;
		} else {
			if (attackerDice > defenderDice) {
				_hitRate = 100;
			} else if (attackerDice <= defenderDice) {
				_hitRate = 0;
			}
		}

		int rnd = _random.nextInt(100) + 1;
		return _hitRate >= rnd;
	}

	//  dq 
	private boolean calcErEvasion() {
		int er = _targetPc.getEr();

		int rnd = _random.nextInt(100) + 1;
		return er < rnd;
	}

	/*  _[WZo  */

	public int calcDamage() {
		if (_calcType == PC_PC) {
			_damage = calcPcPcDamage();
		} else if (_calcType == PC_NPC) {
			_damage = calcPcNpcDamage();
		} else if (_calcType == NPC_PC) {
			_damage = calcNpcPcDamage();
		} else if (_calcType == NPC_NPC) {
			_damage = calcNpcNpcDamage();
		}
		return _damage;
	}

	//  vC[  vC[ _[WZo 
	public int calcPcPcDamage() {
		int weaponMaxDamage = _weaponSmall;

		int weaponDamage = 0;
		if (_weaponType == 58 && (_random.nextInt(100) + 1) <=
				_weaponDoubleDmgChance) { // NeBJqbg
			weaponDamage = weaponMaxDamage;
			_pc.sendPackets(new S_SkillSound(_pc.getId(), 3671));
			_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 3671));
		} else if (_weaponType == 0 || _weaponType == 20 || _weaponType == 62) { // fA|AKggbg
			weaponDamage = 0;
		} else {
			weaponDamage = _random.nextInt(weaponMaxDamage) + 1;
		}
		if (_pc.hasSkillEffect(SOUL_OF_FLAME)) {
			if (_weaponType != 20 && _weaponType != 62) {
				weaponDamage = weaponMaxDamage;
			}
		}

		int weaponTotalDamage = weaponDamage + _weaponAddDmg + _weaponEnchant;
		if (_weaponType == 54 && (_random.nextInt(100) + 1) <=
				_weaponDoubleDmgChance) { // _uqbg
			weaponTotalDamage *= 2;
			_pc.sendPackets(new S_SkillSound(_pc.getId(), 3398));
			_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 3398));
		}

		weaponTotalDamage += calcAttrEnchantDmg(); // _[W{[iX
		if (_pc.hasSkillEffect(DOUBLE_BRAKE)
				&& (_weaponType == 54 || _weaponType == 58)) {
			if ((_random.nextInt(100) + 1) <= 33) {
				weaponTotalDamage *= 2;
			}
		}

		if (_weaponId == 262 && _random.nextInt(100) + 1 <= 75) { // fBXgNVm(b)75%
			weaponTotalDamage += calcDestruction(weaponTotalDamage);
		}

		double dmg;
		if (_weaponType != 20 && _weaponType != 62) {
			dmg = weaponTotalDamage + _statusDamage + _pc.getDmgup()
					+ _pc.getOriginalDmgup();
		} else {
			dmg = weaponTotalDamage + _statusDamage + _pc.getBowDmgup()
					+ _pc.getOriginalBowDmgup();
		}

		if (_weaponType == 20) { // |
			if (_arrow != null) {
				int add_dmg = _arrow.getItem().getDmgSmall();
				if (add_dmg == 0) {
					add_dmg = 1;
				}
				dmg = dmg + _random.nextInt(add_dmg) + 1;
			} else if (_weaponId == 190) { // TCn|
				dmg = dmg + _random.nextInt(15) + 1;
			}
		} else if (_weaponType == 62) { // Kggbg
			int add_dmg = _sting.getItem().getDmgSmall();
			if (add_dmg == 0) {
				add_dmg = 1;
			}
			dmg = dmg + _random.nextInt(add_dmg) + 1;
		}

		dmg = calcBuffDamage(dmg);

		if (_weaponId == 124) { // otHbgX^bt
			dmg += L1WeaponSkill.getBaphometStaffDamage(_pc, _target);
		} else if (_weaponId == 2 || _weaponId == 200002) { // _CX_K[
			dmg = L1WeaponSkill.getDiceDaggerDamage(_pc, _targetPc, weapon);
		} else if (_weaponId == 204 || _weaponId == 100204) { // ^gNX{E
			L1WeaponSkill.giveFettersEffect(_pc, _targetPc); 
		} else if (_weaponId == 264) { // CgjOGbW
			dmg += L1WeaponSkill.getLightningEdgeDamage(_pc, _target);
		} else if (_weaponId == 260 || _weaponId == 263) { // CWOEBhAt[WOT[
			dmg += L1WeaponSkill.getAreaSkillWeaponDamage(_pc, _target,
					_weaponId);
		} else if (_weaponId == 261) { // A[NCWX^bt
			L1WeaponSkill.giveArkMageDiseaseEffect(_pc, _target);
		} else {
			dmg += L1WeaponSkill.getWeaponSkillDamage(_pc, _target, _weaponId);
		}

		if (_weaponType == 0) { // f
			dmg = (_random.nextInt(5) + 4) / 4;
		}

		if (_weaponType2 == 17) { // L[N
			dmg = L1WeaponSkill.getKiringkuDamage(_pc, _target);
			dmg += calcAttrEnchantDmg();
		}

		if (_weaponType != 20 && _weaponType != 62) { // h_[W
			dmg += _pc.getDmgModifierByArmor();
		} else {
			dmg += _pc.getBowDmgModifierByArmor();
		}

		if (_weaponType != 20 && _weaponType != 62) {
			Object[] dollList = _pc.getDollList().values().toArray(); // }WbNh[_[W
			for (Object dollObject : dollList) {
				L1DollInstance doll = (L1DollInstance) dollObject;
				dmg += doll.getDamageByDoll();
			}
		}

		if (_pc.hasSkillEffect(COOKING_2_0_N) // _[W
				|| _pc.hasSkillEffect(COOKING_2_0_S)
				|| _pc.hasSkillEffect(COOKING_3_2_N)
				|| _pc.hasSkillEffect(COOKING_3_2_S)) {
			if (_weaponType != 20 && _weaponType != 62) {
				dmg += 1;
			}
		}
		if (_pc.hasSkillEffect(COOKING_2_3_N) // _[W
				|| _pc.hasSkillEffect(COOKING_2_3_S)
				|| _pc.hasSkillEffect(COOKING_3_0_N)
				|| _pc.hasSkillEffect(COOKING_3_0_S)) {
			if (_weaponType == 20 || _weaponType == 62) {
				dmg += 1;
			}
		}

		dmg -= _targetPc.getDamageReductionByArmor(); // h_[Wy

		Object[] targetDollList = _targetPc.getDollList().values().toArray(); // }WbNh[_[Wy
		for (Object dollObject : targetDollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			dmg -= doll.getDamageReductionByDoll();
		}

		if (_targetPc.hasSkillEffect(COOKING_1_0_S) // _[Wy
				|| _targetPc.hasSkillEffect(COOKING_1_1_S)
				|| _targetPc.hasSkillEffect(COOKING_1_2_S)
				|| _targetPc.hasSkillEffect(COOKING_1_3_S)
				|| _targetPc.hasSkillEffect(COOKING_1_4_S)
				|| _targetPc.hasSkillEffect(COOKING_1_5_S)
				|| _targetPc.hasSkillEffect(COOKING_1_6_S)
				|| _targetPc.hasSkillEffect(COOKING_2_0_S)
				|| _targetPc.hasSkillEffect(COOKING_2_1_S)
				|| _targetPc.hasSkillEffect(COOKING_2_2_S)
				|| _targetPc.hasSkillEffect(COOKING_2_3_S)
				|| _targetPc.hasSkillEffect(COOKING_2_4_S)
				|| _targetPc.hasSkillEffect(COOKING_2_5_S)
				|| _targetPc.hasSkillEffect(COOKING_2_6_S)
				|| _targetPc.hasSkillEffect(COOKING_3_0_S)
				|| _targetPc.hasSkillEffect(COOKING_3_1_S)
				|| _targetPc.hasSkillEffect(COOKING_3_2_S)
				|| _targetPc.hasSkillEffect(COOKING_3_3_S)
				|| _targetPc.hasSkillEffect(COOKING_3_4_S)
				|| _targetPc.hasSkillEffect(COOKING_3_5_S)
				|| _targetPc.hasSkillEffect(COOKING_3_6_S)) {
			dmg -= 5;
		}
		if (_targetPc.hasSkillEffect(COOKING_1_7_S) // fU[g_[Wy
				|| _targetPc.hasSkillEffect(COOKING_2_7_S)
				|| _targetPc.hasSkillEffect(COOKING_3_7_S)) {
			dmg -= 5;
		}

		if (_targetPc.hasSkillEffect(REDUCTION_ARMOR)) {
			int targetPcLvl = _targetPc.getLevel();
			if (targetPcLvl < 50) {
				targetPcLvl = 50;
			}
			dmg -= (targetPcLvl - 50) / 5 + 1;
		}
		if (_targetPc.hasSkillEffect(DRAGON_SKIN)) {
			dmg -= 2;
		}
		if (_targetPc.hasSkillEffect(PATIENCE)) {
			dmg -= 2;
		}
		if (_targetPc.hasSkillEffect(IMMUNE_TO_HARM)) {
			dmg /= 2;
		}
		if (_targetPc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BREATH)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(EARTH_BIND)) {
			dmg = 0;
		}

		if (dmg <= 0) {
			_isHit = false;
			_drainHp = 0; // _[Wz
		}

		return (int) dmg;
	}

	//  vC[  mob _[WZo 
	private int calcPcNpcDamage() {
		int weaponMaxDamage = 0;
		if (_targetNpc.getNpcTemplate().get_size().equalsIgnoreCase("small")
				&& _weaponSmall > 0) {
			weaponMaxDamage = _weaponSmall;
		} else if (_targetNpc.getNpcTemplate().get_size().equalsIgnoreCase(
				"large")
				&& _weaponLarge > 0) {
			weaponMaxDamage = _weaponLarge;
		}

		int weaponDamage = 0;
		if (_weaponType == 58 && (_random.nextInt(100) + 1) <=
				_weaponDoubleDmgChance) { // NeBJqbg
			weaponDamage = weaponMaxDamage;
			_pc.sendPackets(new S_SkillSound(_pc.getId(), 3671));
			_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 3671));
		} else if (_weaponType == 0 || _weaponType == 20 || _weaponType == 62) { // fA|AKggbg
			weaponDamage = 0;
		} else {
			weaponDamage = _random.nextInt(weaponMaxDamage) + 1;
		}
		if (_pc.hasSkillEffect(SOUL_OF_FLAME)) {
			if (_weaponType != 20 && _weaponType != 62) {
				weaponDamage = weaponMaxDamage;
			}
		}

		int weaponTotalDamage = weaponDamage + _weaponAddDmg + _weaponEnchant;

		weaponTotalDamage += calcMaterialBlessDmg(); // j_[W{[iX
		if (_weaponType == 54 && (_random.nextInt(100) + 1) <=
				_weaponDoubleDmgChance) { // _uqbg
			weaponTotalDamage *= 2;
			_pc.sendPackets(new S_SkillSound(_pc.getId(), 3398));
			_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 3398));
		}

		weaponTotalDamage += calcAttrEnchantDmg(); // _[W{[iX
		if (_pc.hasSkillEffect(DOUBLE_BRAKE)
				&& (_weaponType == 54 || _weaponType == 58)) {
			if ((_random.nextInt(100) + 1) <= 33) {
				weaponTotalDamage *= 2;
			}
		}

		if (_weaponId == 262 && _random.nextInt(100) + 1 <= 75) { // fBXgNVm(b)75%
			weaponTotalDamage += calcDestruction(weaponTotalDamage);
		}

		double dmg;
		if (_weaponType != 20 && _weaponType != 62) {
			dmg = weaponTotalDamage + _statusDamage + _pc.getDmgup()
					+ _pc.getOriginalDmgup();
		} else {
			dmg = weaponTotalDamage + _statusDamage + _pc.getBowDmgup()
					+ _pc.getOriginalBowDmgup();
		}

		if (_weaponType == 20) { // |
			if (_arrow != null) {
				int add_dmg = 0;
				if (_targetNpc.getNpcTemplate().get_size().
						equalsIgnoreCase("large")) {
					add_dmg = _arrow.getItem().getDmgLarge();
				} else {
					add_dmg = _arrow.getItem().getDmgSmall();
				}
				if (add_dmg == 0) {
					add_dmg = 1;
				}
				if (_targetNpc.getNpcTemplate().is_hard()) {
					add_dmg /= 2;
				}
				dmg = dmg + _random.nextInt(add_dmg) + 1;
			} else if (_weaponId == 190) { // TCn|
				dmg = dmg + _random.nextInt(15) + 1;
			}
		} else if (_weaponType == 62) { // Kggbg
			int add_dmg = 0;
			if (_targetNpc.getNpcTemplate().get_size().
					equalsIgnoreCase("large")) {
				add_dmg = _sting.getItem().getDmgLarge();
			} else {
				add_dmg = _sting.getItem().getDmgSmall();
			}
			if (add_dmg == 0) {
				add_dmg = 1;
			}
			dmg = dmg + _random.nextInt(add_dmg) + 1;
		}

		dmg = calcBuffDamage(dmg);

		if (_weaponId == 124) { // otHbgX^bt
			dmg += L1WeaponSkill.getBaphometStaffDamage(_pc, _target);
		} else if (_weaponId == 204 || _weaponId == 100204) { // ^gNX{E
			L1WeaponSkill.giveFettersEffect(_pc, _targetNpc); 
		} else if (_weaponId == 264) { // CgjOGbW
			dmg += L1WeaponSkill.getLightningEdgeDamage(_pc, _target);
		} else if (_weaponId == 260 || _weaponId == 263) { // CWOEBhAt[WOT[
			dmg += L1WeaponSkill.getAreaSkillWeaponDamage(_pc, _target,
					_weaponId);
		} else if (_weaponId == 261) { // A[NCWX^bt
			L1WeaponSkill.giveArkMageDiseaseEffect(_pc, _target);
		} else {
			dmg += L1WeaponSkill.getWeaponSkillDamage(_pc, _target, _weaponId);
		}

		if (_weaponType == 0) { // f
			dmg = (_random.nextInt(5) + 4) / 4;
		}

		if (_weaponType2 == 17) { // L[N
			dmg = L1WeaponSkill.getKiringkuDamage(_pc, _target);
			dmg += calcAttrEnchantDmg();
		}

		if (_weaponType != 20 && _weaponType != 62) { // h_[W
			dmg += _pc.getDmgModifierByArmor();
		} else {
			dmg += _pc.getBowDmgModifierByArmor();
		}

		if (_weaponType != 20 && _weaponType != 62) {
			Object[] dollList = _pc.getDollList().values().toArray(); // }WbNh[_[W
			for (Object dollObject : dollList) {
				L1DollInstance doll = (L1DollInstance) dollObject;
				dmg += doll.getDamageByDoll();
			}
		}

		if (_pc.hasSkillEffect(COOKING_2_0_N) // _[W
				|| _pc.hasSkillEffect(COOKING_2_0_S)
				|| _pc.hasSkillEffect(COOKING_3_2_N)
				|| _pc.hasSkillEffect(COOKING_3_2_S)) {
			if (_weaponType != 20 && _weaponType != 62) {
				dmg += 1;
			}
		}
		if (_pc.hasSkillEffect(COOKING_2_3_N) // _[W
				|| _pc.hasSkillEffect(COOKING_2_3_S)
				|| _pc.hasSkillEffect(COOKING_3_0_N)
				|| _pc.hasSkillEffect(COOKING_3_0_S)) {
			if (_weaponType == 20 || _weaponType == 62) {
				dmg += 1;
			}
		}

		dmg -= calcNpcDamageReduction();

		// vC[ybgATU
		boolean isNowWar = false;
		int castleId = L1CastleLocation.getCastleIdByArea(_targetNpc);
		if (castleId > 0) {
			isNowWar = WarTimeController.getInstance().isNowWar(castleId);
		}
		if (!isNowWar) {
			if (_targetNpc instanceof L1PetInstance) {
				dmg /= 8;
			}
			if (_targetNpc instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) _targetNpc;
				if (summon.isExsistMaster()) {
					dmg /= 8;
				}
			}
		}

		if (_targetNpc.hasSkillEffect(ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(FREEZING_BREATH)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(EARTH_BIND)) {
			dmg = 0;
		}

		if (dmg <= 0) {
			_isHit = false;
			_drainHp = 0; // _[Wz
		}

		return (int) dmg;
	}

	//  mob  vC[ _[WZo 
	private int calcNpcPcDamage() {
		int lvl = _npc.getLevel();
		double dmg = 0D;
		if (lvl < 10) {
			dmg = _random.nextInt(lvl) + 10D + _npc.getStr() / 2 + 1;
		} else {
			dmg = _random.nextInt(lvl) + _npc.getStr() / 2 + 1;
		}

		if (_npc instanceof L1PetInstance) {
			dmg += (lvl / 16); // ybgLV16
			dmg += ((L1PetInstance) _npc).getDamageByWeapon();
		}

		dmg += _npc.getDmgup();

		if (isUndeadDamage()) {
			dmg *= 1.1;
		}

		dmg = dmg * getLeverage() / 10;

		dmg -= calcPcDefense();

		if (_npc.isWeaponBreaked()) { // mobEF|uCNB
			dmg /= 2;
		}

		dmg -= _targetPc.getDamageReductionByArmor(); // h_[Wy

		Object[] targetDollList = _targetPc.getDollList().values().toArray(); // }WbNh[_[Wy
		for (Object dollObject : targetDollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			dmg -= doll.getDamageReductionByDoll();
		}

		if (_targetPc.hasSkillEffect(COOKING_1_0_S) // _[Wy
				|| _targetPc.hasSkillEffect(COOKING_1_1_S)
				|| _targetPc.hasSkillEffect(COOKING_1_2_S)
				|| _targetPc.hasSkillEffect(COOKING_1_3_S)
				|| _targetPc.hasSkillEffect(COOKING_1_4_S)
				|| _targetPc.hasSkillEffect(COOKING_1_5_S)
				|| _targetPc.hasSkillEffect(COOKING_1_6_S)
				|| _targetPc.hasSkillEffect(COOKING_2_0_S)
				|| _targetPc.hasSkillEffect(COOKING_2_1_S)
				|| _targetPc.hasSkillEffect(COOKING_2_2_S)
				|| _targetPc.hasSkillEffect(COOKING_2_3_S)
				|| _targetPc.hasSkillEffect(COOKING_2_4_S)
				|| _targetPc.hasSkillEffect(COOKING_2_5_S)
				|| _targetPc.hasSkillEffect(COOKING_2_6_S)
				|| _targetPc.hasSkillEffect(COOKING_3_0_S)
				|| _targetPc.hasSkillEffect(COOKING_3_1_S)
				|| _targetPc.hasSkillEffect(COOKING_3_2_S)
				|| _targetPc.hasSkillEffect(COOKING_3_3_S)
				|| _targetPc.hasSkillEffect(COOKING_3_4_S)
				|| _targetPc.hasSkillEffect(COOKING_3_5_S)
				|| _targetPc.hasSkillEffect(COOKING_3_6_S)) {
			dmg -= 5;
		}
		if (_targetPc.hasSkillEffect(COOKING_1_7_S) // fU[g_[Wy
				|| _targetPc.hasSkillEffect(COOKING_2_7_S)
				|| _targetPc.hasSkillEffect(COOKING_3_7_S)) {
			dmg -= 5;
		}

		if (_targetPc.hasSkillEffect(REDUCTION_ARMOR)) {
			int targetPcLvl = _targetPc.getLevel();
			if (targetPcLvl < 50) {
				targetPcLvl = 50;
			}
			dmg -= (targetPcLvl - 50) / 5 + 1;
		}
		if (_targetPc.hasSkillEffect(DRAGON_SKIN)) {
			dmg -= 2;
		}
		if (_targetPc.hasSkillEffect(PATIENCE)) {
			dmg -= 2;
		}
		if (_targetPc.hasSkillEffect(IMMUNE_TO_HARM)) {
			dmg /= 2;
		}
		if (_targetPc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BREATH)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(EARTH_BIND)) {
			dmg = 0;
		}

		// ybgATvC[U
		boolean isNowWar = false;
		int castleId = L1CastleLocation.getCastleIdByArea(_targetPc);
		if (castleId > 0) {
			isNowWar = WarTimeController.getInstance().isNowWar(castleId);
		}
		if (!isNowWar) {
			if (_npc instanceof L1PetInstance) {
				dmg /= 8;
			}
			if (_npc instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) _npc;
				if (summon.isExsistMaster()) {
					dmg /= 8;
				}
			}
		}

		if (dmg <= 0) {
			_isHit = false;
		}

		addNpcPoisonAttack(_npc, _targetPc);

		return (int) dmg;
	}

	//  mob  mob _[WZo 
	private int calcNpcNpcDamage() {
		int lvl = _npc.getLevel();
		double dmg = 0;

		if (_npc instanceof L1PetInstance) {
			dmg = _random.nextInt(_npc.getNpcTemplate().get_level())
					+ _npc.getStr() / 2 + 1;
			dmg += (lvl / 16); // ybgLV16
			dmg += ((L1PetInstance) _npc).getDamageByWeapon();
		} else {
			dmg = _random.nextInt(lvl) + _npc.getStr() / 2 + 1;
		}

		if (isUndeadDamage()) {
			dmg *= 1.1;
		}

		dmg = dmg * getLeverage() / 10;

		dmg -= calcNpcDamageReduction();

		if (_npc.isWeaponBreaked()) { // mobEF|uCNB
			dmg /= 2;
		}

		addNpcPoisonAttack(_npc, _targetNpc);

		if (_targetNpc.hasSkillEffect(ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(FREEZING_BREATH)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(EARTH_BIND)) {
			dmg = 0;
		}

		if (dmg <= 0) {
			_isHit = false;
		}

		return (int) dmg;
	}

	//  vC[_[W@ 
	private double calcBuffDamage(double dmg) {
		// Ao[T[J[_[W1.5{
		if (_pc.hasSkillEffect(BURNING_SPIRIT) 
				|| (_pc.hasSkillEffect(ELEMENTAL_FIRE)
						&& _weaponType != 20 && _weaponType != 62
						&& _weaponType2 !=17)) {
			if ((_random.nextInt(100) + 1) <= 33) {
				double tempDmg = dmg;
				if (_pc.hasSkillEffect(FIRE_WEAPON)) {
					tempDmg -= 4;
				}
				if (_pc.hasSkillEffect(FIRE_BLESS)) {
					tempDmg -= 4;
				}
				if (_pc.hasSkillEffect(BURNING_WEAPON)) {
					tempDmg -= 6;
				}
				if (_pc.hasSkillEffect(BERSERKERS)) {
					tempDmg -= 5;
				}
				double diffDmg = dmg - tempDmg;
				dmg = tempDmg * 1.5 + diffDmg;
			}
		}

		return dmg;
	}

	//  vC[`b_[Wy 
	private int calcPcDefense() {
		int ac = Math.max(0, 10 - _targetPc.getAc());
		int acDefMax = _targetPc.getClassFeature().getAcDefenseMax(ac);
		return _random.nextInt(acDefMax + 1);
	}

	//  mob_[W_NVy 
	private int calcNpcDamageReduction() {
		return _targetNpc.getNpcTemplate().get_damagereduction();
	}

	//  j_[WZo 
	private int calcMaterialBlessDmg() {
		int damage = 0;
		int undead = _targetNpc.getNpcTemplate().get_undead();
		if ((_weaponMaterial == 14 || _weaponMaterial == 17
				|| _weaponMaterial == 22)
				&& (undead == 1 || undead == 3 || undead == 5)) { // E~XEInRAAAfbhnEAfbhn{XEX^[
			damage += _random.nextInt(20) + 1;
		}
		if ((_weaponMaterial == 17 || _weaponMaterial == 22)
				&& undead == 2) { // ~XEInRAAn
			damage += _random.nextInt(3) + 1;
		}
		if (_weaponBless == 0 && (undead == 1 || undead == 2 || undead == 3)) { // jAAAfbhnEnEAfbhn{X
			damage += _random.nextInt(4) + 1;
		}
		if (_pc.getWeapon() != null && _weaponType != 20 && _weaponType != 62
				&& weapon.getHolyDmgByMagic() != 0 && (undead == 1 || undead == 3)) {
			damage += weapon.getHolyDmgByMagic();
		}
		return damage;
	}

	//  _[WZo 
	private int calcAttrEnchantDmg() {
		int damage = 0;
// int weakAttr = _targetNpc.getNpcTemplate().get_weakAttr();
// if ((weakAttr & 1) == 1 && _weaponAttrEnchantKind == 1 // n
// || (weakAttr & 2) == 2 && _weaponAttrEnchantKind == 2 // 
// || (weakAttr & 4) == 4 && _weaponAttrEnchantKind == 4 // 
// || (weakAttr & 8) == 8 && _weaponAttrEnchantKind == 8) { // 
// damage = _weaponAttrEnchantLevel;
// }
		if (_weaponAttrEnchantLevel == 1) {
			damage = 1;
		} else if (_weaponAttrEnchantLevel == 2) {
			damage = 3;
		} else if (_weaponAttrEnchantLevel == 3) {
			damage = 5;
		}

		// XXX {AvlAelaB
		int resist = 0;
		if (_calcType == PC_PC) {
			if (_weaponAttrEnchantKind == 1) { // n
				resist = _targetPc.getEarth();
			} else if (_weaponAttrEnchantKind == 2) { // 
				resist = _targetPc.getFire();
			} else if (_weaponAttrEnchantKind == 4) { // 
				resist = _targetPc.getWater();
			} else if (_weaponAttrEnchantKind == 8) { // 
				resist = _targetPc.getWind();
			}
		} else if (_calcType == PC_NPC) {
			int weakAttr = _targetNpc.getNpcTemplate().get_weakAttr();
			if ((_weaponAttrEnchantKind == 1 && weakAttr == 1) // n
				|| (_weaponAttrEnchantKind == 2 && weakAttr == 2) // 
				|| (_weaponAttrEnchantKind == 4 && weakAttr == 4) // 
				|| (_weaponAttrEnchantKind == 8 && weakAttr == 8)) { // 
				resist = -50;
			}
		}

		int resistFloor = (int) (0.32 * Math.abs(resist));
		if (resist >= 0) {
			resistFloor *= 1;
		} else {
			resistFloor *= -1;
		}

		double attrDeffence = resistFloor / 32.0;
		double attrCoefficient = 1 - attrDeffence;

		damage *= attrCoefficient;

		return damage;
	}

	//  mobAfbhU 
	private boolean isUndeadDamage() {
		boolean flag = false;
		int undead = _npc.getNpcTemplate().get_undead();
		boolean isNight = L1GameTimeClock.getInstance().currentTime().isNight();
		if (isNight && (undead == 1 || undead == 3 || undead == 4)) { // 18`6AAAfbhnEAfbhn{XE_Afbhn
			flag = true;
		}
		return flag;
	}

	//  mobUt 
	private void addNpcPoisonAttack(L1Character attacker, L1Character target) {
		if (_npc.getNpcTemplate().get_poisonatk() != 0) { // U
			if (15 >= _random.nextInt(100) + 1) { // 15%mU
				if (_npc.getNpcTemplate().get_poisonatk() == 1) { // 
					// 3b_[W5
					L1DamagePoison.doInfection(attacker, target, 3000, 5);
				} else if (_npc.getNpcTemplate().get_poisonatk() == 2) { // 
					L1SilencePoison.doInfection(target);
				} else if (_npc.getNpcTemplate().get_poisonatk() == 4) { // 
					// 20b45b
					L1ParalysisPoison.doInfection(target, 20000, 45000);
				}
			}
		} else if (_npc.getNpcTemplate().get_paralysisatk() != 0) { // U
		}
	}

	//  }iX^btA|S}iX^btA}io[[hMPzZo 
	public void calcStaffOfMana() {
		if (_weaponId == 126 || _weaponId == 127) { // SOM|SSOM
			int som_lvl = _weaponEnchant + 3; // MPz
			if (som_lvl < 0) {
				som_lvl = 0;
			}
			// MPz_
			_drainMana = _random.nextInt(som_lvl) + 1;
			// MPz9
			if (_drainMana > Config.MANA_DRAIN_LIMIT_PER_SOM_ATTACK) {
				_drainMana = Config.MANA_DRAIN_LIMIT_PER_SOM_ATTACK;
			}
		} else if (_weaponId == 259) { // }io[[h
			if (_calcType == PC_PC) {
				if (_targetPc.getMr() <= _random.nextInt(100) + 1) { // m^[QbgMR
					_drainMana = 1; // z1
				}
			} else if (_calcType == PC_NPC) {
				if (_targetNpc.getMr() <= _random.nextInt(100) + 1) { // m^[QbgMR
					_drainMana = 1; // z1
				}
			}
		}
	}

	//  fBXgNVHPzZo 
	private int calcDestruction(int dmg) {
		_drainHp = (dmg / 8) + 1;
		if (_drainHp <= 0) {
			_drainHp = 1;
		}
		return _drainHp;
	}

	//  obUt 
	public void addPcPoisonAttack(L1Character attacker, L1Character target) {
		int chance = _random.nextInt(100) + 1;
		if ((_weaponId == 13 || _weaponId == 44 // FODA_[NGt\[h
				|| (_weaponId != 0 && _pc.hasSkillEffect(ENCHANT_VENOM))) // G`g
																			// xm
				&& chance <= 10) {
			// A3bA_[WHP-5
			L1DamagePoison.doInfection(attacker, target, 3000, 5);
		}
	}

	//  `FCT[Ut 
	public void addChaserAttack() {
		int mr = 0;
		if (_calcType == PC_PC) {
			mr = _targetPc.getMr() - 2 * _pc.getOriginalMagicHit();
		} else if (_calcType == PC_NPC) {
			mr = _targetNpc.getMr() - 2 * _pc.getOriginalMagicHit();
		}
		double probability = 3.0 + _pc.getTrueSp() * 0.18;
		probability -= (mr / 10) * 0.1;
		if (probability < 3.0) {
			probability = 3.0;
		}
		if (_weaponId == 265 || _weaponId == 266
				|| _weaponId == 267 || _weaponId == 268) {
			if (probability > _random.nextInt(100) + 1) {
				L1Chaser chaser = new L1Chaser(_pc, _target);
				chaser.begin();
			}
		}
	}

	/*  U[VM  */

	public void action() {
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			actionPc();
		} else if (_calcType == NPC_PC || _calcType == NPC_NPC) {
			actionNpc();
		}
	}

	//  vC[U[VM 
	private void actionPc() {
		_pc.setHeading(_pc.targetDirection(_targetX, _targetY)); // Zbg
		if (_weaponType == 20) {
			if (_arrow != null) { // 
				_pc.sendPackets(new S_UseArrowSkill(_pc, _targetId, 66,
						_targetX, _targetY, _isHit));
				_pc.broadcastPacket(new S_UseArrowSkill(_pc, _targetId, 66,
						_targetX, _targetY, _isHit));
				if (_isHit) {
					_target.broadcastPacketExceptTargetSight(
							new S_DoActionGFX(_targetId,
							ActionCodes.ACTION_Damage), _pc);
				}
				_pc.getInventory().removeItem(_arrow, 1);
			} else if (_weaponId == 190) { // TCn
				_pc.sendPackets(new S_UseArrowSkill(_pc, _targetId, 2349,
						_targetX, _targetY, _isHit));
				_pc.broadcastPacket(new S_UseArrowSkill(_pc, _targetId,
						2349, _targetX, _targetY, _isHit));
				if (_isHit) {
					_target.broadcastPacketExceptTargetSight(
							new S_DoActionGFX(_targetId,
							ActionCodes.ACTION_Damage), _pc);
				}
			}
		} else if (_weaponType == 62 && _sting != null) { // Kgbg
			_pc.sendPackets(new S_UseArrowSkill(_pc, _targetId, 2989,
					_targetX, _targetY, _isHit));
			_pc.broadcastPacket(new S_UseArrowSkill(_pc, _targetId, 2989,
					_targetX, _targetY, _isHit));
			if (_isHit) {
				_target.broadcastPacketExceptTargetSight(
						new S_DoActionGFX(_targetId,
						ActionCodes.ACTION_Damage), _pc);
			}
			_pc.getInventory().removeItem(_sting, 1);
		} else {
			if (_isHit) {
				_pc.sendPackets(new S_AttackPacket(_pc, _targetId,
						ActionCodes.ACTION_Attack));
				_pc.broadcastPacket(new S_AttackPacket(_pc, _targetId,
						ActionCodes.ACTION_Attack));
				_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
						_targetId, ActionCodes.ACTION_Damage), _pc);
			} else {
				if (_targetId > 0) {
					_pc.sendPackets(new S_AttackMissPacket(_pc, _targetId));
					_pc.broadcastPacket(new S_AttackMissPacket(_pc, _targetId));
				} else {
					_pc.sendPackets(new S_AttackPacket(_pc, 0,
							ActionCodes.ACTION_Attack));
					_pc.broadcastPacket(new S_AttackPacket(_pc, 0,
							ActionCodes.ACTION_Attack));
				}
			}
		}
	}

	//  mobU[VM 
	private void actionNpc() {
		int _npcObjectId = _npc.getId();
		int bowActId = 0;
		int actId = 0;

		_npc.setHeading(_npc.targetDirection(_targetX, _targetY)); // Zbg

		// ^[Qbg2U
		boolean isLongRange = (_npc.getLocation().getTileLineDistance(
				new Point(_targetX, _targetY)) > 1);
		bowActId = _npc.getNpcTemplate().getBowActId();

		if (getActId() > 0) {
			actId = getActId();
		} else {
			actId = ActionCodes.ACTION_Attack;
		}

		// 2AU|ANVIDU
		if (isLongRange && bowActId > 0) {
			_npc.broadcastPacket(new S_UseArrowSkill(_npc, _targetId,
					bowActId, _targetX, _targetY, _isHit));
		} else {
			if (_isHit) {
				if (getGfxId() > 0) {
					_npc.broadcastPacket(new S_UseAttackSkill(_target,
							_npcObjectId, getGfxId(), _targetX,
									_targetY, actId));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							_targetId, ActionCodes.ACTION_Damage), _npc);
				} else {
					_npc.broadcastPacket(new S_AttackPacketForNpc(_target,
							_npcObjectId, actId));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							_targetId, ActionCodes.ACTION_Damage), _npc);
				}
			} else {
				if (getGfxId() > 0) {
					_npc.broadcastPacket(new S_UseAttackSkill(_target,
							_npcObjectId, getGfxId(), _targetX, _targetY,
							actId, 0));
				} else {
					_npc.broadcastPacket(new S_AttackMissPacket(_npc,
							_targetId, actId));
				}
			}
		}
	}

/*
 * // iAXeBOj~XOvZ public void calcOrbit(int cx, int cy, int
 * head) // N_w N_x  { float dis_x = Math.abs(cx - _targetX); //
 * w^[Qbg float dis_y = Math.abs(cy - _targetY); // x^[Qbg float
 * dis = Math.max(dis_x, dis_y); // ^[Qbg float avg_x = 0; float avg_y = 0;
 * if (dis == 0) { // Wu^ if (head == 1) { avg_x = 1; avg_y =
 * -1; } else if (head == 2) { avg_x = 1; avg_y = 0; } else if (head == 3) {
 * avg_x = 1; avg_y = 1; } else if (head == 4) { avg_x = 0; avg_y = 1; } else if
 * (head == 5) { avg_x = -1; avg_y = 1; } else if (head == 6) { avg_x = -1;
 * avg_y = 0; } else if (head == 7) { avg_x = -1; avg_y = -1; } else if (head ==
 * 0) { avg_x = 0; avg_y = -1; } } else { avg_x = dis_x / dis; avg_y = dis_y /
 * dis; }
 * 
 * int add_x = (int) Math.floor((avg_x * 15) + 0.59f); // ED int
 * add_y = (int) Math.floor((avg_y * 15) + 0.59f); // ED
 * 
 * if (cx > _targetX) { add_x *= -1; } if (cy > _targetY) { add_y *= -1; }
 * 
 * _targetX = _targetX + add_x; _targetY = _targetY + add_y; }
 */

	/*  vZf  */

	public void commit() {
		if (_isHit) {
			if (_calcType == PC_PC || _calcType == NPC_PC) {
				commitPc();
			} else if (_calcType == PC_NPC || _calcType == NPC_NPC) {
				commitNpc();
			}
		}

		// _[WlymFpbZ[W
		if (!Config.ALT_ATKMSG) {
			return;
		}
		if (Config.ALT_ATKMSG) {
			if ((_calcType == PC_PC || _calcType == PC_NPC) && !_pc.isGm()) {
				return;
			}
			if ((_calcType == PC_PC || _calcType == NPC_PC)
					&& !_targetPc.isGm()) {
				return;
			}
		}
		String msg0 = "";
		String msg1 = "";
		String msg2 = "";
		String msg3 = "";
		String msg4 = "";
		if (_calcType == PC_PC || _calcType == PC_NPC) { // A^bJ[ob
			msg0 = _pc.getName();
		} else if (_calcType == NPC_PC) { // A^bJ[mob
			msg0 = _npc.getName();
		}

		if (_calcType == NPC_PC || _calcType == PC_PC) { // ^[Qbgob
			msg4 = _targetPc.getName();
			msg2 = "HitR" + _hitRate + "% THP" + _targetPc.getCurrentHp();
		} else if (_calcType == PC_NPC) { // ^[Qbgmob
			msg4 = _targetNpc.getName();
			msg2 = "Hit" + _hitRate + "% Hp" + _targetNpc.getCurrentHp();
		}
		msg3 = _isHit ? _damage + "^" : "~X";

		if (_calcType == PC_PC || _calcType == PC_NPC) { // A^bJ[ob
			_pc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2, msg3,
					msg4)); // \f1%0%4%1%3 %2
		}
		if (_calcType == NPC_PC || _calcType == PC_PC) { // ^[Qbgob
			_targetPc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2,
					msg3, msg4)); // \f1%0%4%1%3 %2
		}
	}

	//  vC[vZf 
	private void commitPc() {
		if (_calcType == PC_PC) {
			if (_drainMana > 0 && _targetPc.getCurrentMp() > 0) {
				if (_drainMana > _targetPc.getCurrentMp()) {
					_drainMana = _targetPc.getCurrentMp();
				}
				short newMp = (short) (_targetPc.getCurrentMp() - _drainMana);
				_targetPc.setCurrentMp(newMp);
				newMp = (short) (_pc.getCurrentMp() + _drainMana);
				_pc.setCurrentMp(newMp);
			}
			if (_drainHp > 0) { // HPz
				short newHp = (short) (_pc.getCurrentHp() + _drainHp);
				_pc.setCurrentHp(newHp);
			}
			damagePcWeaponDurability(); // B
			_targetPc.receiveDamage(_pc, _damage, false);
		} else if (_calcType == NPC_PC) {
			_targetPc.receiveDamage(_npc, _damage, false);
		}
	}

	//  mobvZf 
	private void commitNpc() {
		if (_calcType == PC_NPC) {
			if (_drainMana > 0) {
				int drainValue = _targetNpc.drainMana(_drainMana);
				int newMp = _pc.getCurrentMp() + drainValue;
				_pc.setCurrentMp(newMp);
				if (drainValue > 0) {
					int newMp2 = _targetNpc.getCurrentMp() - drainValue;
					_targetNpc.setCurrentMpDirect(newMp2);
				}
			}
			if (_drainHp > 0) { // HPz
				short newHp = (short) (_pc.getCurrentHp() + _drainHp);
				_pc.setCurrentHp(newHp);
			}
			damageNpcWeaponDurability(); // B
			_targetNpc.receiveDamage(_pc, _damage);
		} else if (_calcType == NPC_NPC) {
			_targetNpc.receiveDamage(_npc, _damage);
		}
	}

	/*  JE^[oA  */

	//  JE^[oAU[VM 
	public void actionCounterBarrier() {
		if (_calcType == PC_PC) {
			_pc.setHeading(_pc.targetDirection(_targetX, _targetY)); // Zbg
			_pc.sendPackets(new S_AttackMissPacket(_pc, _targetId));
			_pc.broadcastPacket(new S_AttackMissPacket(_pc, _targetId));
			_pc.sendPackets(new S_DoActionGFX(_pc.getId(),
					ActionCodes.ACTION_Damage));
			_pc.broadcastPacket(new S_DoActionGFX(_pc.getId(),
					ActionCodes.ACTION_Damage));
		} else if (_calcType == NPC_PC) {
			int actId = 0;
			_npc.setHeading(_npc.targetDirection(_targetX, _targetY)); // Zbg
			if (getActId() > 0) {
				actId = getActId();
			} else {
				actId = ActionCodes.ACTION_Attack;
			}
			if (getGfxId() > 0) {
				_npc
						.broadcastPacket(new S_UseAttackSkill(_target, _npc
								.getId(), getGfxId(), _targetX, _targetY,
								actId, 0));
			} else {
				_npc.broadcastPacket(new S_AttackMissPacket(_npc, _targetId,
						actId));
			}
			_npc.broadcastPacket(new S_DoActionGFX(_npc.getId(),
					ActionCodes.ACTION_Damage));
		}
	}

	//  UJE^[oAL 
	public boolean isShortDistance() {
		boolean isShortDistance = true;
		if (_calcType == PC_PC) {
			if (_weaponType == 20 || _weaponType == 62) { // |Kgbg
				isShortDistance = false;
			}
		} else if (_calcType == NPC_PC) {
			boolean isLongRange = (_npc.getLocation().getTileLineDistance(
					new Point(_targetX, _targetY)) > 1);
			int bowActId = _npc.getNpcTemplate().getBowActId();
			// 2AU|ANVIDU
			if (isLongRange && bowActId > 0) {
				isShortDistance = false;
			}
		}
		return isShortDistance;
	}

	//  JE^[oA_[Wf 
	public void commitCounterBarrier() {
		int damage = calcCounterBarrierDamage();
		if (damage == 0) {
			return;
		}
		if (_calcType == PC_PC) {
			_pc.receiveDamage(_targetPc, damage, false);
		} else if (_calcType == NPC_PC) {
			_npc.receiveDamage(_targetPc, damage);
		}
	}

	//  JE^[oA_[WZo 
	private int calcCounterBarrierDamage() {
		int damage = 0;
		L1ItemInstance weapon = null;
		weapon = _targetPc.getWeapon();
		if (weapon != null) {
			if (weapon.getItem().getType() == 3) { // 
				// (BIG_[W++_[W)*2
				damage = (weapon.getItem().getDmgLarge() + weapon
						.getEnchantLevel() + weapon.getItem()
								.getDmgModifier()) * 2;
			}
		}
		return damage;
	}

	/*
	 * B NPCAm10%Bj3%B
	 */
	private void damageNpcWeaponDurability() {
		int chance = 10;
		int bchance = 3;

		/*
		 * NPCAfAgpASOFB
		 */
		if (_calcType != PC_NPC
				|| _targetNpc.getNpcTemplate().is_hard() == false
				|| _weaponType == 0 || weapon.getItem().get_canbedmg() == 0
				|| _pc.hasSkillEffect(SOUL_OF_FLAME)) {
			return;
		}
		// E
		if ((_weaponBless == 1 || _weaponBless == 2)
				&& ((_random.nextInt(100) + 1) < chance)) {
			// \f1%0B
			_pc.sendPackets(new S_ServerMessage(268, weapon.getLogName()));
			_pc.getInventory().receiveDamage(weapon);
		}
		// j
		if (_weaponBless == 0 && ((_random.nextInt(100) + 1) < bchance)) {
			// \f1%0B
			_pc.sendPackets(new S_ServerMessage(268, weapon.getLogName()));
			_pc.getInventory().receiveDamage(weapon);
		}
	}

	/*
	 * oEXA^bNB oEXA^bNm10%
	 */
	private void damagePcWeaponDurability() {
		// PvPOAfA|AKggbgAoEXA^bNgpASOF
		if (_calcType != PC_PC || _weaponType == 0 || _weaponType == 20
				|| _weaponType == 62
				|| _targetPc.hasSkillEffect(BOUNCE_ATTACK) == false
				|| _pc.hasSkillEffect(SOUL_OF_FLAME)) {
			return;
		}

		if (_random.nextInt(100) + 1 <= 10) {
			// \f1%0B
			_pc.sendPackets(new S_ServerMessage(268, weapon.getLogName()));
			_pc.getInventory().receiveDamage(weapon);
		}
	}
}
