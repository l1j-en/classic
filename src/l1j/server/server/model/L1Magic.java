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
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.templates.L1Skill;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1Magic {
	private static Logger _log = Logger.getLogger(L1Magic.class.getName());
	private int _calcType;
	private final int PC_PC = 1;
	private final int PC_NPC = 2;
	private final int NPC_PC = 3;
	private final int NPC_NPC = 4;
	private L1PcInstance _pc = null;
	private L1PcInstance _targetPc = null;
	private L1NpcInstance _npc = null;
	private L1NpcInstance _targetNpc = null;
	private int _leverage = 10; 
	private static Random _random = new Random();

	private final L1Character _attacker;
	private final L1Character _target;

	// Candidates for configuration options.
	private static final int MAX_PROBABILITY = 90;
	private static final int INT_ADJUSTMENT = 12;
	private static final int BASE_CRIT_RATE = 10;
	private static final double CRIT_MULTIPLIER = 1.5;
	private static final int CRIT_LEVEL_LIMIT = 6;
	// TODO: determine what this should be - one player suggested live is 1.2.
	private static final double ELEMENTAL_WEAKNESS_MULTIPLIER = 1.2;

	public void setLeverage(int i) {
		_leverage = i;
	}

	private int getLeverage() {
		return _leverage;
	}

	public L1Magic(L1Character attacker, L1Character target) {
		if (attacker instanceof L1PcInstance) {
			if (target instanceof L1PcInstance) {
				_calcType = PC_PC;
				_pc = (L1PcInstance) attacker;
				_targetPc = (L1PcInstance) target;
			} else {
				_calcType = PC_NPC;
				_pc = (L1PcInstance) attacker;
				_targetNpc = (L1NpcInstance) target;
			}
		} else {
			if (target instanceof L1PcInstance) {
				_calcType = NPC_PC;
				_npc = (L1NpcInstance) attacker;
				_targetPc = (L1PcInstance) target;
			} else {
				_calcType = NPC_NPC;
				_npc = (L1NpcInstance) attacker;
				_targetNpc = (L1NpcInstance) target;
			}
		}
		_attacker = attacker;
		_target = target;
	}

	public boolean calcProbabilityMagic(int skillId) {
		int probability = 0;
		boolean isSuccess = false;

		if (_pc != null && _pc.isGm()) {
			return true;
		}
		if (isMissingSkillEffect()) {
			return false;
		}
 		if (!checkZone(skillId)) {
			return false;
		}
		if (skillId == CANCELLATION) {
			if (_calcType == PC_PC && _pc != null && _targetPc != null) {
	
				if (_pc.getId() == _targetPc.getId()) {
					return true;
				}
				if (_pc.getClanid() > 0
						&& (_pc.getClanid() == _targetPc.getClanid())) {
					return true;
				}
				if (_pc.isInParty()) {
					if (_pc.getParty().isMember(_targetPc)) {
						return true;
					}
				}
				if (_pc.getZoneType() == 1 || _targetPc.getZoneType() == 1) {
					return false;
				}
			}
			if (_calcType == PC_NPC || _calcType == NPC_PC || _calcType == NPC_NPC) {
				return true;
			}
		}
		if(_target.hasSkillEffect(EARTH_BIND)) {
			if (skillId != WEAPON_BREAK && skillId != CANCELLATION) {
				return false;
			}
		}
		probability = calcProbability(skillId);
		int rnd = _random.nextInt(100) + 1;
		if (probability > MAX_PROBABILITY) {
			probability = MAX_PROBABILITY;
		}
		isSuccess = probability >= rnd;

		if (!Config.ALT_ATKMSG) {
			return isSuccess;
		}
		if (Config.ALT_ATKMSG) {
			if ((_calcType == PC_PC || _calcType == PC_NPC) && !_pc.isGm()) {
				return isSuccess;
			}
			if ((_calcType == PC_PC || _calcType == NPC_PC) && !_targetPc.isGm()) {
				return isSuccess;
			}
		}

		String msg0 = _attacker.getName();
		String msg1 = "to";
		String msg2 = "probability:" + probability + "%";
		String msg3 = isSuccess ? "success" : "failed";
		String msg4 = _target.getName();

		if (_calcType == PC_PC || _calcType == PC_NPC) {
			_pc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2, msg3,
					msg4)); 
		}
		if (_calcType == NPC_PC || _calcType == PC_PC) { 
			_targetPc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2,
					msg3, msg4)); 
		}

		return isSuccess;
	}

	private boolean checkZone(int skillId) {
		if (_pc != null && _targetPc != null) {
			if (_pc.getZoneType() == 1 || _targetPc.getZoneType() == 1) {
				if (skillId == WEAPON_BREAK || skillId == SLOW
						|| skillId == CURSE_PARALYZE || skillId == MANA_DRAIN
						|| skillId == DARKNESS || skillId == WEAKNESS
						|| skillId == DISEASE || skillId == DECAY_POTION
						|| skillId == MASS_SLOW || skillId == ENTANGLE
						|| skillId == ERASE_MAGIC || skillId == EARTH_BIND
						|| skillId == AREA_OF_SILENCE || skillId == WIND_SHACKLE
						|| skillId == STRIKER_GALE || skillId == SHOCK_STUN
						|| skillId == FOG_OF_SLEEPING || skillId == ICE_LANCE
						|| skillId == FREEZING_BLIZZARD || skillId == CANCELLATION
						|| skillId == POLLUTE_WATER || skillId == CURSE_POISON
						|| skillId == ELEMENTAL_FALL_DOWN || skillId == CURSE_BLIND
						|| skillId == RETURN_TO_NATURE || skillId == DARK_BLIND
						|| skillId == SILENCE || skillId == FREEZING_BREATH) {
					return false;
				}
			}
		}
		return true;
	}

	private int calcProbability(int skillId) {
		L1Skill skill = SkillTable.getInstance().findBySkillId(skillId);
		
		int defenseLevel = _target.getLevel();
		if (skillId == RETURN_TO_NATURE) {
			if (_targetNpc instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) _targetNpc;
				defenseLevel = summon.getMaster().getLevel();
			}
		}

		int levelDifference = _attacker.getLevel() - defenseLevel;

		int probability = 0;
		if (skillId == ELEMENTAL_FALL_DOWN || skillId == RETURN_TO_NATURE
				|| skillId == ENTANGLE || skillId == ERASE_MAGIC
				|| skillId == AREA_OF_SILENCE || skillId == WIND_SHACKLE
				|| skillId == STRIKER_GALE || skillId == POLLUTE_WATER
				|| skillId == EARTH_BIND) {
			probability = skill.getProbabilityValue() +
				(int) (((skill.getProbabilityDice()) / 10D) * levelDifference);

			if (_calcType == PC_PC || _calcType == PC_NPC) {
				probability += 2 * _pc.getOriginalMagicHit();
			}
		} else if (skillId == SHOCK_STUN) {

			probability = skill.getProbabilityValue() + levelDifference * 2;

			if (_calcType == PC_PC || _calcType == PC_NPC) {
				probability += 2 * _pc.getOriginalMagicHit();
			}
		} else if (skillId == COUNTER_BARRIER) {
			int bonus = Math.max(0, (_attacker.getLevel() - 60) / 4);

			probability = skill.getProbabilityValue() + bonus;

			if (_calcType == PC_PC || _calcType == PC_NPC) {
				probability += 2 * _pc.getOriginalMagicHit();
			}
		} else if (skillId == GUARD_BRAKE || skillId == RESIST_FEAR
				|| skillId == HORROR_OF_DEATH) {
			// As of an update on live early 2012, these skills aren't affected
			// by MR.
			probability = 100;
		} else {
			int dice = skill.getProbabilityDice();
			int diceCount = 
				_attacker.getMagicBonus() + _attacker.getMagicLevel();
			if (_calcType == PC_PC || _calcType == PC_NPC) {
				diceCount += _pc.isWizard() ? 1 : -1;
			}
			diceCount = diceCount < 1 ? 1 : diceCount;
			for (int i = 0; i < diceCount; i++) {
				probability += (_random.nextInt(dice) + 1);
			}
			probability = probability * getLeverage() / 10;


			if (_calcType == PC_PC || _calcType == PC_NPC) {
				probability += 2 * _pc.getOriginalMagicHit();
			}

			probability -= _target.getMr();

			if (skillId == TAMING_MONSTER) {
				double probabilityRevision = 1;
				if ((_targetNpc.getMaxHp() * 1 / 4) > _targetNpc.getCurrentHp()) {
					probabilityRevision = 1.3;
				} else if ((_targetNpc.getMaxHp() * 2 / 4) > _targetNpc.getCurrentHp()) {
					probabilityRevision = 1.2;
				} else if ((_targetNpc.getMaxHp() * 3 / 4) > _targetNpc.getCurrentHp()) {
					probabilityRevision = 1.1;
				}
				probability *= probabilityRevision;
			}
		}

		if (_calcType == PC_PC || _calcType == NPC_PC) {
			switch(skillId) {
				case EARTH_BIND:
					probability -= _target.getRegistSustain();
					break;
				case SHOCK_STUN:
					probability -= 2 * _target.getRegistStun();
					break;
				case CURSE_PARALYZE:
					probability -= _target.getRegistStone();
					break;
				case FOG_OF_SLEEPING:
					probability -= _target.getRegistSleep();
					break;
				case ICE_LANCE:
				case FREEZING_BLIZZARD:
				case FREEZING_BREATH:
					probability -= _target.getRegistFreeze();
					break;
				case CURSE_BLIND:
				case DARKNESS:
				case DARK_BLIND:
					probability -= _target.getRegistBlind();
					break;
			}
		}
		return probability;
	}

	public int calcMagicDamage(int skillId) {
		int damage = 0;
		if (_calcType == PC_PC || _calcType == NPC_PC) {
			damage = calcPcMagicDamage(skillId);
		} else if (_calcType == PC_NPC || _calcType == NPC_NPC) {
			damage = calcNpcMagicDamage(skillId);
		}
		return skillId == JOY_OF_PAIN || skillId == FINAL_BURN
			? damage
			: calcMrDefense(damage);
	}

	public int calcFireWallDamage() {
		double attrDeffence = calcAttrResistance(Element.Fire);
		L1Skill firewall = SkillTable.getInstance().findBySkillId(FIRE_WALL);
		int damage = (int) ((1.0 - attrDeffence) * firewall.getDamageValue());

		if (L1Attack.isImmune(_target)) {
			damage = 0;
		}
		
		return damage < 0 ? 0 : damage;
	}

	private int calcPcMagicDamage(int skillId) {
		int dmg = skillId == FINAL_BURN
			? _attacker.getCurrentMp()
			: (calcMagicDiceDamage(skillId) * getLeverage()) / 10;

		dmg -= _targetPc.getDamageReductionByArmor(); 
		
		Object[] targetDollList = _targetPc.getDollList().values().toArray();
		for (Object dollObject : targetDollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			dmg -= doll.getDamageReductionByDoll();
		}
		if (_targetPc.hasSkillEffect(COOKING_1_0_S)
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
		if (_targetPc.hasSkillEffect(COOKING_1_7_S) 
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
			dmg -= 3;
		}
		
		if (_targetPc.hasSkillEffect(PATIENCE)) {
			dmg -= 2;
		}
		if (_calcType == NPC_PC) { 
			boolean isNowWar = false;
			int castleId = L1CastleLocation.getCastleIdByArea(_targetPc);
			if (castleId > 0) {
				isNowWar = WarTimeController.getInstance().isNowWar(castleId);
			}
			// NOTE: changed these dmgs since pets will get insta-pwned by magic mobs
			if (!isNowWar) {
				if (_npc instanceof L1PetInstance) {
					dmg /= 16; // was 8
				}
				if (_npc instanceof L1SummonInstance) {
					L1SummonInstance summon = (L1SummonInstance) _npc;
					if (summon.isExsistMaster()) {
						dmg /= 16; // was 8
					}
				}
			}
		}
		if (_targetPc.hasSkillEffect(IMMUNE_TO_HARM)) {
			dmg /= 2;
		}
		if (L1Attack.isImmune(_target)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(COUNTER_MIRROR)) {
			if (_calcType == PC_PC) {
				if (_targetPc.getWis() >= _random.nextInt(100)) {
					_pc.sendPackets(new S_DoActionGFX(_pc.getId(), ActionCodes.ACTION_Damage));
					_pc.broadcastPacket(new S_DoActionGFX(_pc.getId(), ActionCodes.ACTION_Damage));
					_targetPc.sendPackets(new S_SkillSound(_targetPc.getId(), 4395));
					_targetPc.broadcastPacket(new S_SkillSound(_targetPc.getId(), 4395));
					_pc.receiveDamage(_targetPc, dmg, false);
					dmg = 0;
					_targetPc.killSkillEffectTimer(COUNTER_MIRROR);
				}
			} else if (_calcType == NPC_PC) {
				int npcId = _npc.getNpcTemplate().get_npcId();
				if (npcId == 45681 || npcId == 45682 || npcId == 45683
						|| npcId == 45684) {
				} else if (!_npc.getNpcTemplate().get_IsErase()) {
				} else {
					if (_targetPc.getWis() >= _random.nextInt(100)) {
						_npc.broadcastPacket(new S_DoActionGFX(_npc.getId(), ActionCodes.ACTION_Damage));
						_targetPc.sendPackets(new S_SkillSound(_targetPc.getId(), 4395));
						_targetPc.broadcastPacket(new S_SkillSound(_targetPc.getId(), 4395));
						_npc.receiveDamage(_targetPc, dmg);
						dmg = 0;
						_targetPc.killSkillEffectTimer(COUNTER_MIRROR);
					}
				}
			}
		}
		if (dmg < 0) {
			dmg = 0;
		}

		if (skillId == FINAL_BURN) {
			dmg = _attacker.getCurrentMp();
			if (dmg < 0) {
				dmg = 0;
			}
		} else if (skillId == JOY_OF_PAIN) {
			int missinghp = _attacker.getMaxHp() - _attacker.getCurrentHp();
			dmg = missinghp/3;
			if (dmg < 5) {
				dmg = 5;
			}			
		}
		return dmg;
	}

	/**
	 * Whether or not the attacker (still) needs a buff to affect the
	 * target. Only arises in pve situations, e.g. attacking Chaos.
	 * TODO: find a better name.
	 * TODO: L1Attack and L1Magic both need this check. Duplicating code to
	 * 		 avoid lots of casting. (Need to test whether it's really worth it.)
	 */
	private boolean isMissingSkillEffect() {
		if (_calcType == PC_NPC && _targetNpc != null) {
			int npcId = _targetNpc.getNpcTemplate().get_npcId();
			switch (npcId) {
				case 45912: case 45913: case 45914: case 45915:
					return !_pc.hasSkillEffect(STATUS_HOLY_WATER);
				case 45916:
					return !_pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER);
				case 45941:
					return !_pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA);
				case 45752: case 45753:
					return !_pc.hasSkillEffect(STATUS_CURSE_BARLOG);
				case 45675: case 81082: case 45625: case 45674: case 45685: 
					return !_pc.hasSkillEffect(STATUS_CURSE_YAHEE);
			}
			if (npcId >= 46068 && npcId <= 46091) {
				return _pc.getTempCharGfx() == 6035;
			}
			if (npcId >= 46092 && npcId <= 46106) {
				return _pc.getTempCharGfx() == 6034;
			}
		}
		return false;
	}

	private int calcNpcMagicDamage(int skillId) {
		int dmg = 0;
		
		if (skillId == FINAL_BURN) {
			dmg = _attacker.getCurrentMp();
		} else if (skillId == JOY_OF_PAIN) {
			int missinghp = _attacker.getMaxHp() - _attacker.getCurrentHp();
			dmg = Math.max(missinghp / 3, 5);
		} else {
			dmg = (calcMagicDiceDamage(skillId) * getLeverage()) / 10;
		}
		if (_calcType == PC_NPC) {
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
		}
		if (L1Attack.isImmune(_target) || isMissingSkillEffect()) {
			dmg = 0;
		}
		return dmg;
	}

	private int calcMagicDiceDamage(int skillId) {
		L1Skill skill = SkillTable.getInstance().findBySkillId(skillId);
		int dice = skill.getDamageDice();
		int diceCount = skill.getDamageDiceCount();
		int value = (int) skill.getDamageValue();

		int damage = 0;

		for (int i = 0; i < diceCount; i++) {
			damage += (_random.nextInt(dice) + 1);
		}
		damage += value;

		if (_calcType == PC_PC || _calcType == PC_NPC) {
			int weaponAddDmg = 0;
			L1ItemInstance weapon = _pc.getWeapon();
			if (weapon != null) {
				weaponAddDmg = weapon.getItem().getMagicDmgModifier();
			}
			damage += weaponAddDmg;
		}
		int spByItem = _attacker.getSp() - _attacker.getTrueSp();
		int charaIntelligence = 
			Math.max(_attacker.getInt() + spByItem - INT_ADJUSTMENT, 1);

		double attrDeffence = calcAttrResistance(skill.getAttr());
		double coefficient = 
			Math.max((1.0 - attrDeffence + charaIntelligence * 3.0 / 32.0), 0);

		damage *= coefficient;

		// TODO: determine proper place (order of operations-wise) for this.
		if (_calcType == PC_NPC) {
			int weakness = _targetNpc.getNpcTemplate().get_weakAttr();
			int element = skill.getAttr();
			if (element != Element.None && weakness == element) {
				damage *= ELEMENTAL_WEAKNESS_MULTIPLIER;
			}
		}

		if (_calcType == PC_PC || _calcType == PC_NPC) { 
			if (skill.getSkillLevel() <= CRIT_LEVEL_LIMIT &&
					_random.nextInt(100) + 1 <= BASE_CRIT_RATE +
						_pc.getOriginalMagicCritical()) {
				damage *= CRIT_MULTIPLIER;
			}

			damage += _pc.getOriginalMagicDamage();
			
			if (_pc.hasSkillEffect(ILLUSION_AVATAR)) {
				damage += 10;
			}
		}
		return damage;
	}

	public int calcHealing(int skillId) {
		L1Skill skill = SkillTable.getInstance().findBySkillId(skillId);
		int dice = skill.getDamageDice();
		int value = (int) skill.getDamageValue();
		int damage = 0;

		int magicBonus = Math.min(10, _attacker.getMagicBonus());

		int diceCount = value + magicBonus;
		for (int i = 0; i < diceCount; i++) {
			damage += (_random.nextInt(dice) + 1);
		}

		double alignmentRevision = 1.0;
		if (_attacker.getLawful() > 0) {
			alignmentRevision += (_attacker.getLawful() / 32768.0);
		}

		damage *= alignmentRevision;
		damage = (damage * getLeverage()) / 10;
		return damage;
	}

	private int calcMrDefense(int dmg) {
		int mr = _target.getMr();

		double mrFloor = 0;
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			if (mr <= 100) {
				mrFloor = Math.floor((mr - _pc.getOriginalMagicHit()) / 2);
			} else if (mr >= 100) {
				mrFloor = Math.floor((mr - _pc.getOriginalMagicHit()) / 10);
			}
			double mrCoefficient = 0;
			if (mr <= 100) {
				mrCoefficient = 1 - 0.01 * mrFloor;
			} else if (mr >= 100) {
				mrCoefficient = 0.6 - 0.01 * mrFloor;
			}
			dmg *= mrCoefficient;
		} else if (_calcType == NPC_PC || _calcType == NPC_NPC) {
			if (mr >= _random.nextInt(100) + 1) {
				dmg /= 2;
			}
		}
		return dmg;
	}

	private double calcAttrResistance(int attr) {
		int resist = 0;
		if (_calcType == PC_PC || _calcType == NPC_PC) {
			if (attr == Element.Earth) {
				resist = _targetPc.getEarth();
			} else if (attr == Element.Fire) {
				resist = _targetPc.getFire();
			} else if (attr == Element.Water) {
				resist = _targetPc.getWater();
			} else if (attr == Element.Wind) {
				resist = _targetPc.getWind();
			}
		}
		int resistFloor = (int) (0.32 * Math.abs(resist));
		if (resist >= 0) {
			resistFloor *= 1;
		} else {
			resistFloor *= -1;
		}
		double attrDeffence = resistFloor / 32.0;
		return attrDeffence;
	}

	public void commit(int damage, int drainMana) {
		if (_calcType == PC_PC || _calcType == NPC_PC) {
			commitPc(damage, drainMana);
		} else if (_calcType == PC_NPC || _calcType == NPC_NPC) {
			commitNpc(damage, drainMana);
		}

		if (!Config.ALT_ATKMSG) {
			return;
		}
		if (Config.ALT_ATKMSG) {
			if ((_calcType == PC_PC || _calcType == PC_NPC)
					&& !_pc.isGm()) {
				return;
			}
			if ((_calcType == PC_PC || _calcType == NPC_PC)
					&& !_targetPc.isGm()) {
				return;
			}
		}

		String msg0 = _attacker.getName();
		String msg1 = "to";
		String msg2 = "";
		String msg3 = damage + "currentHp";
		String msg4 = _target.getName();

		if (_calcType == NPC_PC || _calcType == PC_PC) { 
			msg2 = "THP" + _targetPc.getCurrentHp();
		} else if (_calcType == PC_NPC) {
			msg2 = "THp" + _targetNpc.getCurrentHp();
		}

		if (_calcType == PC_PC || _calcType == PC_NPC) { 
			_pc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2, msg3,
					msg4)); 
		}
		if (_calcType == NPC_PC || _calcType == PC_PC) {
			_targetPc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2,
					msg3, msg4)); 
		}
	}

	private void commitPc(int damage, int drainMana) {
		if (_calcType == PC_PC) {
			if (drainMana > 0 && _targetPc.getCurrentMp() > 0) {
				if (drainMana > _targetPc.getCurrentMp()) {
					drainMana = _targetPc.getCurrentMp();
				}
				int newMp = _pc.getCurrentMp() + drainMana;
				_pc.setCurrentMp(newMp);
			}
			_targetPc.receiveManaDamage(_pc, drainMana);
			_targetPc.receiveDamage(_pc, damage, true);
		} else if (_calcType == NPC_PC) {
			_targetPc.receiveDamage(_npc, damage, true);
		}
	}

	private void commitNpc(int damage, int drainMana) {
		if (_calcType == PC_NPC) {
			if (drainMana > 0) {
				int drainValue = _targetNpc.drainMana(drainMana);
				int newMp = _pc.getCurrentMp() + drainValue;
				_pc.setCurrentMp(newMp);
			}
			_targetNpc.ReceiveManaDamage(_pc, drainMana);
			_targetNpc.receiveDamage(_pc, damage);
		} else if (_calcType == NPC_NPC) {
			_targetNpc.receiveDamage(_npc, damage);
		}
	}
}
