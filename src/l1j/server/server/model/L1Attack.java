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

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.WarTimeController;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.poison.L1DamagePoison;
import l1j.server.server.model.poison.L1ParalysisPoison;
import l1j.server.server.model.poison.L1SilencePoison;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.serverpackets.S_AttackMissPacket;
import l1j.server.server.serverpackets.S_AttackPacket;
import l1j.server.server.serverpackets.S_AttackStatus;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_UseArrowSkill;
import l1j.server.server.serverpackets.S_UseAttackSkill;
import l1j.server.server.types.Point;

public class L1Attack {

	private L1PcInstance _pc = null;

	private L1Character _target = null;

	private L1PcInstance _targetPc = null;

	private L1NpcInstance _npc = null;

	private L1NpcInstance _targetNpc = null;

	private int _weaponDoubleDmgChance = 0;
	
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

	private int _attckGrfxId = 0;

	private int _attckActId = 0;

	// If the attacker is the player's weapons information
	private L1ItemInstance weapon = null;

	private int _weaponId = 0;

	private int _weaponType = 0;

	private int _weaponAddHit = 0;

	private int _weaponAddDmg = 0;

	private int _weaponSmall = 0;

	private int _weaponLarge = 0;

	private int _weaponBless = 1;

	private int _weaponEnchant = 0;

	private int _weaponMaterial = 0;

	private L1ItemInstance _arrow = null;

	private L1ItemInstance _sting = null;

	private int _leverage = 10; // 1/10 Expressions times.

	public void setLeverage(int i) {
		_leverage = i;
	}

	private int getLeverage() {
		return _leverage;
	}

	// If the attacker is the player's status correction
	private static final int[] strHit = { -2, -2, -2, -2, -2, -2, -2, -2, -2,
			-2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9,
			9, 10, 10, 11, 11, 12, 12, 13, 13, 14 };

	private static final int[] dexHit = { -2, -2, -2, -2, -2, -2, -2, -2, -2,
			-1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8,
			9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14 };

	private static final int[] strDmg = new int[128];

	static {
		// STR Damage Compensation
		int dmg = -6;
		for (int str = 0; str <= 22; str++) { 
			if (str % 2 == 1) {
				dmg++;
			}
			strDmg[str] = dmg;
		}
		for (int str = 23; str <= 28; str++) { 
			if (str % 3 == 2) {
				dmg++;
			}
			strDmg[str] = dmg;
		}
		for (int str = 29; str <= 32; str++) { 
			if (str % 2 == 1) {
				dmg++;
			}
			strDmg[str] = dmg;
		}
		for (int str = 33; str <= 39; str++) { 
			dmg++;
			strDmg[str] = dmg;
		}
		for (int str = 40; str <= 46; str++) { 
			dmg += 2;
			strDmg[str] = dmg;
		}
		for (int str = 47; str <= 127; str++) { 
			dmg++;
			strDmg[str] = dmg;
		}
	}

	private static final int[] dexDmg = new int[128];

	static {
		for (int dex = 0; dex <= 14; dex++) {
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
		for (int dex = 24; dex <= 127; dex++) {
			dmg++;
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
			// Information obtained weapons
			weapon = _pc.getWeapon();
			if (weapon != null) {
				_weaponId = weapon.getItem().getItemId();
				_weaponType = weapon.getItem().getType1();
				_weaponAddHit = weapon.getItem().getHitModifier()
						 + weapon.getHitByMagic();
				_weaponAddDmg = weapon.getItem().getDmgModifier();
				_weaponSmall = weapon.getItem().getDmgSmall();
				_weaponLarge = weapon.getItem().getDmgLarge();
				_weaponBless = weapon.getItem().getBless();
				if (_weaponType != 20 && _weaponType != 62) {
					_weaponEnchant = weapon.getEnchantLevel()
							+ weapon.getDmgByMagic()
							- weapon.get_durability(); 
				} else {
					_weaponEnchant = weapon.getEnchantLevel();
				}
				_weaponMaterial = weapon.getItem().getMaterial();
				if (_weaponType == 20) { // Arrow acquisition
					_arrow = _pc.getInventory().getArrow();
					if (_arrow != null) {
						_weaponBless = _arrow.getItem().getBless();
						_weaponMaterial = _arrow.getItem().getMaterial();
					}
				}
				if (_weaponType == 62) { // Sting's acquisition
					_sting = _pc.getInventory().getSting();
					if (_sting != null) {
						_weaponBless = _sting.getItem().getBless();
						_weaponMaterial = _sting.getItem().getMaterial();
						
					}
				}
				_weaponDoubleDmgChance = weapon.getItem().getDoubleDmgChance();
			}
			// Additional compensation status Damage
			if (_weaponType == 20) { // If the arch reference value DEX
				_statusDamage = dexDmg[_pc.getDex()];
			} else { // Otherwise, the reference value STR
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

	/* hit determine */

	public boolean calcHit() {
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			if (_weaponType == 20 && _weaponId != 190 && _arrow == null) {
				_isHit = false; // If there is no mistake arrow
			} else if (_weaponType == 62 && _sting == null) {
				_isHit = false; // If there is no mistake Sting
			} else if (!_pc.glanceCheck(_targetX, _targetY)) {
				_isHit = false; // If the attacker is the player's decision is an obstacle
			} else if (_weaponId == 247 || _weaponId == 248
					|| _weaponId == 249) {
				_isHit = false; // B ~ C sword attack ordeal disabled
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

	// player to hit from a judgement Player
	/*
	 * C's hit rate = (PC-class Lv + + STR correction correction correction + + DEX + DAI the number of weapons correction / 2 + magic correction) ~ 0.68-10
	 * The figures are calculated in their biggest hit (95%) gives the other side of the PC can take the other side of the PC's AC AC is better at self-hit rate of 1 per pull out
	 * The minimum rate hit 5 percent hit rate of up to 95%
	 */
	private boolean calcPcPcHit() {
		final int MIN_HITRATE = 5;

		_hitRate = _pc.getLevel();

		if (_pc.getStr() > 39) {
			_hitRate += strHit[39];
		} else {
			_hitRate += strHit[_pc.getStr()];
		}

		if (_pc.getDex() > 39) {
			_hitRate += dexHit[39];
		} else {
			_hitRate += dexHit[_pc.getDex()];
		}

		if (_weaponType != 20 && _weaponType != 62) {
			_hitRate += _weaponAddHit + _pc.getHitup() + (_weaponEnchant / 2);
		} else {
			_hitRate += _weaponAddHit + _pc.getBowHitup() + (_weaponEnchant / 2);
		}

		if (_weaponType == 20 || _weaponType == 62) {
			_hitRate += _pc.getBowHitRate();
		}

		int hitAc = (int) (_hitRate * 0.68 - 10) * -1;

		if (hitAc <= _targetPc.getAc()) {
			_hitRate = 95;
		} else {
			_hitRate = 95 - (hitAc - _targetPc.getAc());
		}

		if (_targetPc.hasSkillEffect(L1SkillId.UNCANNY_DODGE)) {
			_hitRate -= 20;
		}

		if (_hitRate < MIN_HITRATE) {
			_hitRate = MIN_HITRATE;
		}

		if (_targetPc.hasSkillEffect(L1SkillId.ABSOLUTE_BARRIER)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.ICE_LANCE)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.FREEZING_BLIZZARD)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.EARTH_BIND)) {
			_hitRate = 0;
		}
		int rnd = _random.nextInt(100) + 1;
		if (_weaponType == 20 && _hitRate > rnd) { // If the arch, even if hit again work in the ER.
			return calcErEvasion();
		}

		return _hitRate >= rnd;
	}

	// player to hit NPC decision
	private boolean calcPcNpcHit() {
		// NPC's hit rate
		// = (PC-class Lv + + STR correction correction correction + + DEX 
		// + DAI the number of weapons correction / 2 + magic correction) 
		// ~ 5 - (NPC's AC ~ (-5))
		_hitRate = _pc.getLevel();

		if (_pc.getStr() > 39) {
			_hitRate += strHit[39];
		} else {
			_hitRate += strHit[_pc.getStr()];
		}

		if (_pc.getDex() > 39) {
			_hitRate += dexHit[39];
		} else {
			_hitRate += dexHit[_pc.getDex()];
		}

		if (_weaponType != 20 && _weaponType != 62) {
			_hitRate += _weaponAddHit + _pc.getHitup() + (_weaponEnchant / 2);
		} else {
			_hitRate += _weaponAddHit + _pc.getBowHitup() + (_weaponEnchant / 2);
		}

		if (_weaponType == 20 || _weaponType == 62) {
			_hitRate += _pc.getBowHitRate();
		}

		_hitRate *= 5;
		_hitRate += _targetNpc.getAc() * 5;

		if (_hitRate > 95) {
			_hitRate = 95;
		} else if (_hitRate < 5) {
			_hitRate = 5;
		}
		int npcId = _targetNpc.getNpcTemplate().get_npcId();   
		if (npcId >= 45912 && npcId <= 45915 && !_pc.hasSkillEffect(L1SkillId.STATUS_HOLY_WATER)) {   
			_hitRate = 0; 
		}  
		if (npcId == 45916 && !_pc.hasSkillEffect(L1SkillId.STATUS_HOLY_MITHRIL_POWDER)) {   
			_hitRate = 0;  
		}   
		if (npcId == 45941 && !_pc.hasSkillEffect(L1SkillId.STATUS_HOLY_WATER_OF_EVA)) {   
			_hitRate = 0; 
		}   
		int rnd = _random.nextInt(100) + 1; 

		return _hitRate >= rnd;
	}

	//NPC decision from the players to hit
	private boolean calcNpcPcHit() {
		// PC's hit rate
		// = (NPC's Lv ~ 2) ~ 5 - (NPC's AC ~ (-5))
		_hitRate = _npc.getLevel() * 2;
		_hitRate *= 5;
		_hitRate += _targetPc.getAc() * 5;

		if (_npc instanceof L1PetInstance) { // LV1 for each additional pet is hit +2
			_hitRate += _npc.getLevel() * 2;
		}

		_hitRate += _npc.getHitup();

		// NPC hit rate from the level set
		if (_hitRate < _npc.getLevel()) {
			_hitRate = _npc.getLevel();
		}

		if (_hitRate > 95) {
			_hitRate = 95;
		}

		if (_targetPc.hasSkillEffect(L1SkillId.UNCANNY_DODGE)) {
			_hitRate -= 20;
		}

		if (_hitRate < 5) {
			_hitRate = 5;
		}

		if (_targetPc.hasSkillEffect(L1SkillId.ABSOLUTE_BARRIER)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.ICE_LANCE)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.FREEZING_BLIZZARD)) {
			_hitRate = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.EARTH_BIND)) {
			_hitRate = 0;
		}

		int rnd = _random.nextInt(100) + 1;

		// NPC attack range of more than 10 cases, if two or more away from the attack and considered arch
		if (_npc.getNpcTemplate().get_ranged() >= 10
				&& _hitRate > rnd
				&& _npc.getLocation().getTileLineDistance(
						new Point(_targetX, _targetY)) >= 2) {
			return calcErEvasion();
		}
		return _hitRate >= rnd;
	}

	// NPC and NPC decision to hit
	private boolean calcNpcNpcHit() {
		int target_ac = 10 - _targetNpc.getNpcTemplate().get_ac();
		int attacker_lvl = _npc.getNpcTemplate().get_level();

		if (target_ac != 0) {
			_hitRate = (100 / target_ac * attacker_lvl); // AC = under attack by an attacker Lv
			// When the rate hit 100%
		} else {
			_hitRate = 100 / 1 * attacker_lvl;
		}

		if (_npc instanceof L1PetInstance) { // LV1 for each additional pet is hit +2
			_hitRate += _npc.getLevel() * 2;
		}

		if (_hitRate < attacker_lvl) {
			_hitRate = attacker_lvl; // Starting hit rate = Lv%
		}
		if (_hitRate > 95) {
			_hitRate = 95; // The highest hit rate is 95%
		}
		if (_hitRate < 5) {
			_hitRate = 5; // Lv five attackers hit rate at less than 5%
		}

		int rnd = _random.nextInt(100) + 1;
		return _hitRate >= rnd;
	}

	// ER avoidance of judgement
	private boolean calcErEvasion() {
		int er = _targetPc.getEr();

		int rnd = _random.nextInt(100) + 1;
		return er < rnd;
	}

	/* Damage calculated */

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

	// player from the player to calculate the damage
	public int calcPcPcDamage() {
		int weaponMaxDamage = _weaponSmall;

		int weaponDamage = 0;
		if (_weaponType == 58 && (_random.nextInt(100) + 1) <= _weaponDoubleDmgChance) {   // Critical hit
			weaponDamage = weaponMaxDamage;
			_pc.sendPackets(new S_SkillSound(_pc.getId(), 3671));
			_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 3671));
		} else if (_weaponType == 0 || _weaponType == 20 || _weaponType == 62) { 
			weaponDamage = 0;
		} else {
			weaponDamage = _random.nextInt(weaponMaxDamage) + 1;
		}
		if (_pc.hasSkillEffect(L1SkillId.SOUL_OF_FLAME)) {
			if (_weaponType != 20 && _weaponType != 62) {
				weaponDamage = weaponMaxDamage;
			}
		}

		int weaponTotalDamage = weaponDamage + _weaponAddDmg + _weaponEnchant;
		if (_pc.hasSkillEffect(L1SkillId.DOUBLE_BRAKE)
				&& (_weaponType == 54 || _weaponType == 58)) {
			if ((_random.nextInt(100) + 1) <= 33) {
				weaponTotalDamage *= 2;
			}
		}

		if (_weaponType == 54 && (_random.nextInt(100) + 1) <= _weaponDoubleDmgChance) {   // Double hit
			weaponTotalDamage *= 2;
			_pc.sendPackets(new S_SkillSound(_pc.getId(), 3398));
			_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 3398));
		}

		double dmg;
		if (_weaponType != 20 && _weaponType != 62) {
			dmg = weaponTotalDamage + _statusDamage + _pc.getDmgup();
		} else {
			dmg = weaponTotalDamage + _statusDamage + _pc.getBowDmgup();
		}

		if (_pc.isKnight() || _pc.isDarkelf()) { 
			if (_weaponType == 20 || _weaponType == 62) { // Arch, GANTOTORETTO class, no bonus Damage
				dmg -= _pc.getBaseDmgup();
			}
		} else if (_pc.isElf()) { 
			if (_weaponType != 20 && _weaponType != 62) { // Arch, class, non-Damage bonus without GANTOTORETTO
				dmg -= _pc.getBaseDmgup();
			}
		}

		if (_weaponType == 20) { // bow
			if (_arrow != null) {
				int add_dmg = _arrow.getItem().getDmgSmall();
				if (add_dmg == 0) {
					add_dmg = 1;
				}
				dmg = dmg + _random.nextInt(add_dmg) + 1;
			} else if (_weaponId == 190) { // sahya bow
				dmg = dmg + _random.nextInt(15) + 1;
			}
		} else if (_weaponType == 62) {
			int add_dmg = _sting.getItem().getDmgSmall();
			if (add_dmg == 0) {
				add_dmg = 1;
			}
			dmg = dmg + _random.nextInt(add_dmg) + 1;
		}

		dmg = calcBuffDamage(dmg);

		if (_weaponId == 124) {
			dmg += L1WeaponSkill.getBaphometStaffDamage(_pc, _target);
		} else if (_weaponId == 2 || _weaponId == 200002) { // 
			dmg = L1WeaponSkill.getDiceDaggerDamage(_pc, _targetPc, weapon);
		} else {
			dmg += L1WeaponSkill.getWeaponSkillDamage(_pc, _target, _weaponId);
		}

		if (_weaponType == 0) { // bare hands
			dmg = (_random.nextInt(5) + 4) / 4;
		}

		Object[] dollList = _pc.getDollList().values().toArray(); 
		for (Object dollObject : dollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			dmg += doll.getDamageByDoll();
		}

		dmg -= _targetPc.getDamageReductionByArmor(); 

		if (_targetPc.hasSkillEffect(L1SkillId.COOKING_1_0_S) 
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_1_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_2_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_3_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_4_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_5_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_6_S)) {
			dmg -= 5;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.COOKING_1_7_S)) { 
			dmg -= 5;
		}

		if (_targetPc.hasSkillEffect(L1SkillId.REDUCTION_ARMOR)) {
			int targetPcLvl = _targetPc.getLevel();
			if (targetPcLvl < 50) {
				targetPcLvl = 50;
			}
			dmg -= (targetPcLvl - 50) / 5 + 1;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.IMMUNE_TO_HARM)) {
			dmg /= 2;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.ABSOLUTE_BARRIER)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.EARTH_BIND)) {
			dmg = 0;
		}

		if (dmg <= 0) {
			_isHit = false;
		}

		return (int) dmg;
	}

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
		if (_weaponType == 58 && (_random.nextInt(100) + 1) <= _weaponDoubleDmgChance) {   // Critical hit
			weaponDamage = weaponMaxDamage;
			_pc.sendPackets(new S_SkillSound(_pc.getId(), 3671));
			_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 3671));
		} else if (_weaponType == 0 || _weaponType == 20 || _weaponType == 62) { 
			weaponDamage = 0;
		} else {
			weaponDamage = _random.nextInt(weaponMaxDamage) + 1;
		}
		if (_pc.hasSkillEffect(L1SkillId.SOUL_OF_FLAME)) {
			if (_weaponType != 20 && _weaponType != 62) {
				weaponDamage = weaponMaxDamage;
			}
		}

		int weaponTotalDamage = weaponDamage + _weaponAddDmg + _weaponEnchant;
		if (_pc.hasSkillEffect(L1SkillId.DOUBLE_BRAKE)
				&& (_weaponType == 54 || _weaponType == 58)) {
			if ((_random.nextInt(100) + 1) <= 33) {
				weaponTotalDamage *= 2;
			}
		}

		weaponTotalDamage += calcMaterialBlessDmg(); // Damage bonus blessing silver
		if (_weaponType == 54 && (_random.nextInt(100) + 1) <= _weaponDoubleDmgChance) {   // Double hit
			weaponTotalDamage *= 2;
			_pc.sendPackets(new S_SkillSound(_pc.getId(), 3398));
			_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 3398));
		}

		double dmg;
		if (_weaponType != 20 && _weaponType != 62) {
			dmg = weaponTotalDamage + _statusDamage + _pc.getDmgup();
		} else {
			dmg = weaponTotalDamage + _statusDamage + _pc.getBowDmgup();
		}

		if (_pc.isKnight() || _pc.isDarkelf()) { 
			if (_weaponType == 20 || _weaponType == 62) { 
				dmg -= _pc.getBaseDmgup();
			}
		} else if (_pc.isElf()) { 
			if (_weaponType != 20 && _weaponType != 62) {
				dmg -= _pc.getBaseDmgup();
			}
		}

		if (_weaponType == 20) { // bow
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
			} else if (_weaponId == 190) { // sahya bow
				dmg = dmg + _random.nextInt(15) + 1;
			}
		} else if (_weaponType == 62) {
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

		if (_weaponId == 124) {
			dmg += L1WeaponSkill.getBaphometStaffDamage(_pc, _target);
		} else {
			dmg += L1WeaponSkill.getWeaponSkillDamage(_pc, _target, _weaponId);
		}

		if (_weaponType == 0) {
			dmg = (_random.nextInt(5) + 4) / 4;
		}

		Object[] dollList = _pc.getDollList().values().toArray(); 
		for (Object dollObject : dollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			dmg += doll.getDamageByDoll();
		}

		dmg -= calcNpcDamageReduction();

		boolean isNowWar = false;  
		int castleId = L1CastleLocation.getCastleIdByArea(_targetNpc);
        if (castleId > 0) {  
    	isNowWar = WarTimeController.getInstance().isNowWar(castleId);  
        }  
        if (!isNowWar) {  
        if (_targetNpc instanceof L1PetInstance) { 
        dmg /= 16;
        }  
        if (_targetNpc instanceof L1SummonInstance) 
        {  
        L1SummonInstance summon = (L1SummonInstance) _targetNpc;  
        if (summon.isExsistMaster()) 
        {  
        dmg /= 16;  
        }  
        } 
        }

		if (_targetNpc.hasSkillEffect(L1SkillId.ICE_LANCE)) {
			dmg = 0;
		}
		
		if (_targetNpc.hasSkillEffect(L1SkillId.FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(L1SkillId.EARTH_BIND)) {
			dmg = 0;
		}

		if (dmg <= 0) {
			_isHit = false;
		}

		return (int) dmg;
	}

	private int calcNpcPcDamage() {
		int lvl = _npc.getLevel();
		double dmg = 0D;
		if (lvl < 10) {
			dmg = _random.nextInt(lvl) + 10D + _npc.getStr() / 2 + 1;
		} else {
			dmg = _random.nextInt(lvl) + _npc.getStr() / 2 + 1;
		}

		if (_npc instanceof L1PetInstance) {
			dmg += (lvl / 16); // Each additional pet is hit LV16
		}

		dmg += _npc.getDmgup();

		if (isUndeadDamage()) {
			dmg *= 1.1;
		}

		dmg = dmg * getLeverage() / 10;

		dmg -= calcPcDefense();

		if (_npc.isWeaponBreaked()) { // weap break for NPC.
			dmg /= 2;
		}

		dmg -= _targetPc.getDamageReductionByArmor(); 

		if (_targetPc.hasSkillEffect(L1SkillId.COOKING_1_0_S) 
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_1_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_2_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_3_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_4_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_5_S)
				|| _targetPc.hasSkillEffect(L1SkillId.COOKING_1_6_S)) {
			dmg -= 5;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.COOKING_1_7_S)) { 
			dmg -= 5;
		}

		if (_targetPc.hasSkillEffect(L1SkillId.REDUCTION_ARMOR)) {
			int targetPcLvl = _targetPc.getLevel();
			if (targetPcLvl < 50) {
				targetPcLvl = 50;
			}
			dmg -= (targetPcLvl - 50) / 5 + 1;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.IMMUNE_TO_HARM)) {
			dmg /= 2;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.ABSOLUTE_BARRIER)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(L1SkillId.EARTH_BIND)) {
			dmg = 0;
		}

		boolean isNowWar = false;  
        int castleId = L1CastleLocation.getCastleIdByArea(_targetPc); 
        if (castleId > 0) {  
        isNowWar = WarTimeController.getInstance().isNowWar(castleId);  
        }  
        if (!isNowWar) 
        {  
        if (_npc instanceof L1PetInstance) 
        { 
        dmg /= 16;  // was 8
        }  
        if (_npc instanceof L1SummonInstance) 
        {  
        L1SummonInstance summon = (L1SummonInstance) _npc; 
        if (summon.isExsistMaster()) 
        {  
        dmg /= 16;  // was 8
        } 
        }
        }
		if (dmg <= 0) {
			_isHit = false;
		}

		addNpcPoisonAttack(_npc, _targetPc);

		return (int) dmg;
	}

	private int calcNpcNpcDamage() {
		int lvl = _npc.getLevel();
		double dmg = 0;

		if (_npc instanceof L1PetInstance) {
			dmg = _random.nextInt(_npc.getNpcTemplate().get_level())
					+ _npc.getStr() / 2 + 1;
			dmg += (lvl / 16); // Each additional pet is hit LV16
		} else {
			dmg = _random.nextInt(lvl) + _npc.getStr() / 2 + 1;
		}

		if (isUndeadDamage()) {
			dmg *= 1.1;
		}

		dmg = dmg * getLeverage() / 10;

		dmg -= calcNpcDamageReduction();

		if (_npc.isWeaponBreaked()) { 
			dmg /= 2;
		}

		addNpcPoisonAttack(_npc, _targetNpc);

		if (_targetNpc.hasSkillEffect(L1SkillId.ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(L1SkillId.FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(L1SkillId.EARTH_BIND)) {
			dmg = 0;
		}

		if (dmg <= 0) {
			_isHit = false;
		}

		return (int) dmg;
	}

	// Magic players to strengthen Damage
	private double calcBuffDamage(double dmg) {
		if (_weaponType == 20 || _weaponType == 62) { // Gauntlet or arch, the near-magical minutes minus process
			if (_pc.hasSkillEffect(L1SkillId.FIRE_WEAPON)) {
				dmg -= 4;
			}
			if (_pc.hasSkillEffect(L1SkillId.FIRE_BLESS)) {
				dmg -= 4;
			}
			if (_pc.hasSkillEffect(L1SkillId.BURNING_WEAPON)) {
				dmg -= 6;
			}
		} else {
			if (_pc.hasSkillEffect(L1SkillId.STORM_EYE)) {
				dmg -= 3;
			}
			if (_pc.hasSkillEffect(L1SkillId.STORM_SHOT)) {
				dmg -= 5;
			}
		}

		// Arms fire, the damage will be 1.5 times not Berserker
		if (_pc.hasSkillEffect(L1SkillId.BURNING_SPIRIT)
				|| (_pc.hasSkillEffect(L1SkillId.ELEMENTAL_FIRE) && _weaponType != 20 && _weaponType != 62)) {
			if ((_random.nextInt(100) + 1) <= 33) {
				double tempDmg = dmg;
				if (_pc.hasSkillEffect(L1SkillId.FIRE_WEAPON)) {
					tempDmg -= 4;
				}
				if (_pc.hasSkillEffect(L1SkillId.FIRE_BLESS)) {
					tempDmg -= 4;
				}
				if (_pc.hasSkillEffect(L1SkillId.BURNING_WEAPON)) {
					tempDmg -= 6;
				}
				if (_pc.hasSkillEffect(L1SkillId.BERSERKERS)) {
					tempDmg -= 5;
				}
				double diffDmg = dmg - tempDmg;
				dmg = tempDmg * 1.5 + diffDmg;
			}
		}

		return dmg;
	}

	// AC Player of the damage
	private int calcPcDefense() {
		int ac = Math.max(0, 10 - _targetPc.getAc());
		int acDefMax = _targetPc.getClassFeature().getAcDefenseMax(ac);
		return _random.nextInt(acDefMax + 1);
	}

	// NPC reduce damage due to reduction
	private int calcNpcDamageReduction() {
		return _targetNpc.getNpcTemplate().get_damagereduction();
	}

	// weapons material damage and celebration calculated by adding
	private int calcMaterialBlessDmg() {
		int damage = 0;
		int undead = _targetNpc.getNpcTemplate().get_undead();
		if ((_weaponMaterial == 14 || _weaponMaterial == 17 || _weaponMaterial == 22)
				&& (undead == 1 || undead == 3)) { // Mithril Oriharukon silver, and the curse-the curse-boss
			damage += _random.nextInt(20) + 1;
		}
		if (_weaponBless == 0 && (undead == 1 || undead == 2 || undead == 3)) { // Weapons blessing and a curse-the curse of the devil-boss system
			damage += _random.nextInt(4) + 1;
		}
		if (_pc.getWeapon() != null && _weaponType != 20 && _weaponType != 62
				&& weapon.getHolyDmgByMagic() != 0 && (undead == 1 || undead == 3)) {
			damage += weapon.getHolyDmgByMagic();
		}
		return damage;
	}

	private boolean isUndeadDamage() {
		boolean flag = false;
		int undead = _npc.getNpcTemplate().get_undead();
		boolean isNight = L1GameTimeClock.getInstance().getGameTime().isNight();
		if (isNight && (undead == 1 || undead == 3)) { // 18 to 6 pm, and the curse-the curse-boss
			flag = true;
		}
		return flag;
	}

	public void addNpcPoisonAttack(L1Character attacker, L1Character target) {
		if (_npc.getNpcTemplate().get_poisonatk() != 0) {
			if (12 >= _random.nextInt(100) + 1) { // 12% chance of poison attacks
				if (_npc.getNpcTemplate().get_poisonatk() == 1) { // normal poison
					// Damage period of 5 seconds 3
					L1DamagePoison.doInfection(attacker, target, 3000, 5);
				} else if (_npc.getNpcTemplate().get_poisonatk() == 2) { // Silence poison
					L1SilencePoison.doInfection(target);
				} else if (_npc.getNpcTemplate().get_poisonatk() == 4) { // Paralytic poison
					// 20 seconds to 45 seconds paralysis
					L1ParalysisPoison.doInfection(target, 20000, 45000);
				}
			}
		} else if (_npc.getNpcTemplate().get_paralysisatk() != 0) { // Paralysis in attack
		}
	}

	public void calcStaffOfMana() {
		// SOM steel or SOM
		if (_weaponId == 126 || _weaponId == 127) {
			int som_lvl = _weaponEnchant + 3; // MP to set the maximum amount of absorption
			if (som_lvl < 0) {
				som_lvl = 0;
			}
			// MP sinks to retrieve random
			_drainMana = _random.nextInt(som_lvl) + 1;
			// 9 maximum limit on the amount of absorption MP
			if (_drainMana > Config.MANA_DRAIN_LIMIT_PER_SOM_ATTACK) {
				_drainMana = Config.MANA_DRAIN_LIMIT_PER_SOM_ATTACK;
			}
		}
	}

	// PC poison attacks added
	public void addPcPoisonAttack(L1Character attacker, L1Character target) {
		int chance = _random.nextInt(100) + 1;
		if ((_weaponId == 13 || _weaponId == 44 // FOD, ancient DAKUERUFUSODO
				|| (_weaponId != 0 && _pc.hasSkillEffect(L1SkillId.ENCHANT_VENOM))) // Enchant venom
				&& chance <= 10) {
			// Usually poison, 3 second period, HP-5 Damage
			L1DamagePoison.doInfection(attacker, target, 3000, 5);
		}
	}

	/* attack sent motion */

	public void action() {
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			actionPc();
		} else if (_calcType == NPC_PC || _calcType == NPC_NPC) {
			actionNpc();
		}
	}

	// motion attacking players sent
	private void actionPc() {
		_pc.setHeading(_pc.targetDirection(_targetX, _targetY)); // Set-oriented
		if (_isHit) {
			if (_weaponType == 20) {
				if (_arrow != null) { // If you have an arrow
					_pc.sendPackets(new S_UseArrowSkill(_pc, _targetId, 66,
							_targetX, _targetY));
					_pc.broadcastPacket(new S_UseArrowSkill(_pc, _targetId, 66,
							_targetX, _targetY));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							_targetId, ActionCodes.ACTION_Damage), _pc);
					_pc.getInventory().removeItem(_arrow, 1);
				} else if (_weaponId == 190) { // If an arrow is superfluous SAIHA
					_pc.sendPackets(new S_UseArrowSkill(_pc, _targetId, 2349,
							_targetX, _targetY));
					_pc.broadcastPacket(new S_UseArrowSkill(_pc, _targetId,
							2349, _targetX, _targetY));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							_targetId, ActionCodes.ACTION_Damage), _pc);
				}
			} else if (_weaponType == 62 && _sting != null) { // Gauntlet
				_pc.sendPackets(new S_UseArrowSkill(_pc, _targetId, 2989,
						_targetX, _targetY));
				_pc.broadcastPacket(new S_UseArrowSkill(_pc, _targetId, 2989,
						_targetX, _targetY));
				_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
						_targetId, ActionCodes.ACTION_Damage), _pc);
				_pc.getInventory().removeItem(_sting, 1);
			} else {
				_pc.sendPackets(new S_AttackStatus(_pc, _targetId,
						ActionCodes.ACTION_Attack));
				_pc.broadcastPacket(new S_AttackStatus(_pc, _targetId,
						ActionCodes.ACTION_Attack));
				_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
						_targetId, ActionCodes.ACTION_Damage), _pc);
			}
		} else {
			if (_weaponType == 20 && (_weaponId == 190 || _arrow != null)) {
				calcOrbit(_pc.getX(), _pc.getY(), _pc.getHeading()); // Calculated orbit
				if (_arrow != null) { // If you have an arrow
					_pc.sendPackets(new S_UseArrowSkill(_pc, 0, 66, _targetX,
							_targetY));
					_pc.broadcastPacket(new S_UseArrowSkill(_pc, 0, 66,
							_targetX, _targetY));
					_pc.getInventory().removeItem(_arrow, 1);
				} else if (_weaponId == 190) { // If an arrow is superfluous SAIHA
					_pc.sendPackets(new S_UseArrowSkill(_pc, 0, 2349, _targetX,
							_targetY));
					_pc.broadcastPacket(new S_UseArrowSkill(_pc, 0, 2349,
							_targetX, _targetY));
				}
			} else if (_weaponType == 62 && _sting != null) { // Gauntlet
				calcOrbit(_pc.getX(), _pc.getY(), _pc.getHeading()); // Calculated orbit
				_pc.sendPackets(new S_UseArrowSkill(_pc, 0, 2989, _targetX,
						_targetY));
				_pc.broadcastPacket(new S_UseArrowSkill(_pc, 0, 2989, _targetX,
						_targetY));
				_pc.getInventory().removeItem(_sting, 1);
			} else {
				if (_targetId > 0) {
					_pc.sendPackets(new S_AttackMissPacket(_pc, _targetId));
					_pc.broadcastPacket(new S_AttackMissPacket(_pc, _targetId));
				} else {
					_pc.sendPackets(new S_AttackStatus(_pc, 0,
							ActionCodes.ACTION_Attack));
					_pc.broadcastPacket(new S_AttackStatus(_pc, 0,
							ActionCodes.ACTION_Attack));
				}
			}
		}
	}

	// NPC motion attack sent
	private void actionNpc() {
		int _npcObjectId = _npc.getId();
		int bowActId = 0;
		int actId = 0;

		_npc.setHeading(_npc.targetDirection(_targetX, _targetY)); 

		// The distance between the target and if two or more long-distance attacks
		boolean isLongRange = (_npc.getLocation().getTileLineDistance(
				new Point(_targetX, _targetY)) > 1);
		bowActId = _npc.getNpcTemplate().getBowActId();

		if (getActId() > 0) {
			actId = getActId();
		} else {
			actId = ActionCodes.ACTION_Attack;
		}

		if (_isHit) {
			// The distance between two or more of the attacker's arch Action ID if you have far-attack
			if (isLongRange && bowActId > 0) {
				_npc.broadcastPacket(new S_UseArrowSkill(_npc, _targetId,
						bowActId, _targetX, _targetY));
			} else {
				if (getGfxId() > 0) {
					_npc
							.broadcastPacket(new S_UseAttackSkill(_target,
									_npcObjectId, getGfxId(), _targetX,
									_targetY, actId));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							_targetId, ActionCodes.ACTION_Damage), _npc);
				} else {
					_npc.broadcastPacket(new S_AttackPacket(_target,
							_npcObjectId, actId));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							_targetId, ActionCodes.ACTION_Damage), _npc);
				}
			}
		} else {

			// The distance between two or more of the attacker's arch Action ID if you have far-attack
			if (isLongRange && bowActId > 0) {
				_npc.broadcastPacket(new S_UseArrowSkill(_npc, 0, bowActId,
						_targetX, _targetY));
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

	// Missile (arrow, Sting) when the error was calculated orbit
	public void calcOrbit(int cx, int cy, int head) // X Y origin of the origin of the direction I'm facing now
	{
		float dis_x = Math.abs(cx - _targetX); // X-way distance to the target
		float dis_y = Math.abs(cy - _targetY); // Y-way distance to the target
		float dis = Math.max(dis_x, dis_y); // The distance to the target
		float avg_x = 0;
		float avg_y = 0;
		if (dis == 0) { // If I'm facing the same goals and toward the straight position
			if (head == 1) {
				avg_x = 1;
				avg_y = -1;
			} else if (head == 2) {
				avg_x = 1;
				avg_y = 0;
			} else if (head == 3) {
				avg_x = 1;
				avg_y = 1;
			} else if (head == 4) {
				avg_x = 0;
				avg_y = 1;
			} else if (head == 5) {
				avg_x = -1;
				avg_y = 1;
			} else if (head == 6) {
				avg_x = -1;
				avg_y = 0;
			} else if (head == 7) {
				avg_x = -1;
				avg_y = -1;
			} else if (head == 0) {
				avg_x = 0;
				avg_y = -1;
			}
		} else {
			avg_x = dis_x / dis;
			avg_y = dis_y / dis;
		}

		int add_x = (int) Math.floor((avg_x * 15) + 0.59f); // Rounding side is kind of priority
		int add_y = (int) Math.floor((avg_y * 15) + 0.59f); // Rounding side is kind of priority

		if (cx > _targetX) {
			add_x *= -1;
		}
		if (cy > _targetY) {
			add_y *= -1;
		}

		_targetX = _targetX + add_x;
		_targetY = _targetY + add_y;
	}

	/* results reflect */

	public void commit() {
		if (_isHit) {
			if (_calcType == PC_PC || _calcType == NPC_PC) {
				commitPc();
			} else if (_calcType == PC_NPC || _calcType == NPC_NPC) {
				commitNpc();
			}
		}

		// Damage value, and hit rate for confirmation message
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
		String msg1 = "to";
		String msg2 = "";
		String msg3 = "";
		String msg4 = "";
		if (_calcType == PC_PC || _calcType == PC_NPC) { // If the attacker PC
			msg0 = _pc.getName();
		} else if (_calcType == NPC_PC) { // If the attacker NPC
			msg0 = _npc.getName();
		}

		if (_calcType == NPC_PC || _calcType == PC_PC) { // If the target is a PC
			msg4 = _targetPc.getName();
			msg2 = "HitR" + _hitRate + "% THP" + _targetPc.getCurrentHp();
		} else if (_calcType == PC_NPC) { // If the target is an NPC
			msg4 = _targetNpc.getName();
			msg2 = "Hit" + _hitRate + "% Hp" + _targetNpc.getCurrentHp();
		}
		msg3 = _isHit ? " gave " + _damage  : " miss.";

		if (_calcType == PC_PC || _calcType == PC_NPC) { // If the attacker PC
			_pc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2, msg3,
					msg4)); 
		}
		if (_calcType == NPC_PC || _calcType == PC_PC) { //If the target is a PC
			_targetPc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2,
					msg3, msg4)); 
		}
	}

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
			damagePcWeaponDurability();
			_targetPc.receiveDamage(_pc, _damage);
		} else if (_calcType == NPC_PC) {
			_targetPc.receiveDamage(_npc, _damage);
		}
	}

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

			damageNpcWeaponDurability(); 
			_targetNpc.receiveDamage(_pc, _damage);
		} else if (_calcType == NPC_NPC) {
			_targetNpc.receiveDamage(_npc, _damage);
		}
	}

	public void actionCounterBarrier() {
		if (_calcType == PC_PC) {
			_pc.setHeading(_pc.targetDirection(_targetX, _targetY)); 
			_pc.sendPackets(new S_AttackMissPacket(_pc, _targetId));
			_pc.broadcastPacket(new S_AttackMissPacket(_pc, _targetId));
			_pc.sendPackets(new S_DoActionGFX(_pc.getId(),
					ActionCodes.ACTION_Damage));
			_pc.broadcastPacket(new S_DoActionGFX(_pc.getId(),
					ActionCodes.ACTION_Damage));
		} else if (_calcType == NPC_PC) {
			int actId = 0;
			_npc.setHeading(_npc.targetDirection(_targetX, _targetY));
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

	public boolean isShortDistance() {
		boolean isShortDistance = true;
		if (_calcType == PC_PC) {
			if (_weaponType == 20 || _weaponType == 62) { // Gauntlet or bow
				isShortDistance = false;
			}
		} else if (_calcType == NPC_PC) {
			boolean isLongRange = (_npc.getLocation().getTileLineDistance(
					new Point(_targetX, _targetY)) > 1);
			int bowActId = _npc.getNpcTemplate().getBowActId();
			// The distance between two or more of the attacker's arch Action ID if you have far-attack
			if (isLongRange && bowActId > 0) {
				isShortDistance = false;
			}
		}
		return isShortDistance;
	}

	public void commitCounterBarrier() {
		int damage = calcCounterBarrierDamage();
		if (damage == 0) {
			return;
		}
		if (_calcType == PC_PC) {
			_pc.receiveDamage(_targetPc, damage);
		} else if (_calcType == NPC_PC) {
			_npc.receiveDamage(_targetPc, damage);
		}
	}

	private int calcCounterBarrierDamage() {
		int damage = 0;
		L1ItemInstance weapon = null;
		weapon = _targetPc.getWeapon();
		int weaponType = weapon.getItem().getType();
		if (weapon != null && weaponType == 3) { // Two-handed sword
			// (BIG strengthen the maximum number + + Additional Damage Damage) * 2
			damage = (weapon.getItem().getDmgLarge() + weapon.getEnchantLevel() + weapon
					.getItem().getDmgModifier()) * 2;
		}
		return damage;
	}

	/*
	 * Weapon damage. In the case against the NPC, and a 10 percent chance of injury. 
	 * Arms and blessed with 3 percent.
	 */
	private void damageNpcWeaponDurability() {
		int chance = 10;
		int bchance = 3;

		/*
		 * Damage NPC, bare hands, do not damage the use of arms if nothing else.
		 */
		if (_calcType != PC_NPC
				|| _targetNpc.getNpcTemplate().is_hard() == false
				|| _weaponType == 0 || weapon.getItem().get_canbedmg() == 0) {
			return;
		}
		// normal weapons cursed weapons
		if ((_weaponBless == 1 || _weaponBless == 2)
				&& ((_random.nextInt(100) + 1) < chance)) {
			// your injury is 0%.
			_pc.sendPackets(new S_ServerMessage(268, weapon.getLogName()));
			_pc.getInventory().receiveDamage(weapon);
		}
		// Blessed weapons
		if (_weaponBless == 0 && ((_random.nextInt(100) + 1) < bchance)) {
			// your injury is 0%.
			_pc.sendPackets(new S_ServerMessage(268, weapon.getLogName()));
			_pc.getInventory().receiveDamage(weapon);
		}
	}

	/*
	 * 10% probability of damage
	 */
	private void damagePcWeaponDurability() {
		// PvP except bare hands, bow, GANTOTORETTO, BAUNSUATAKKU unused nothing if not
		if (_calcType != PC_PC || _weaponType == 0 || _weaponType == 20
				|| _weaponType == 62
				|| _targetPc.hasSkillEffect(L1SkillId.BOUNCE_ATTACK) == false) {
			return;
		}

		if (_random.nextInt(100) + 1 <= 10) {
			_pc.sendPackets(new S_ServerMessage(268, weapon.getLogName()));
			_pc.getInventory().receiveDamage(weapon);
		}
	}
}
