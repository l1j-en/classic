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
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1MagicInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.templates.L1Skills;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1Magic {

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
	}

	private int getSpellPower() {
		int spellPower = 0;
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			spellPower = _pc.getSp();
		} else if (_calcType == NPC_PC || _calcType == NPC_NPC) {
			spellPower = _npc.getSp();
		}
		return spellPower;
	}

	private int getMagicLevel() {
		int magicLevel = 0;
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			magicLevel = _pc.getMagicLevel();
		} else if (_calcType == NPC_PC || _calcType == NPC_NPC) {
			magicLevel = _npc.getMagicLevel();
		}
		return magicLevel;
	}

	private int getMagicBonus() {
		int magicBonus = 0;
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			magicBonus = _pc.getMagicBonus();
		} else if (_calcType == NPC_PC || _calcType == NPC_NPC) {
			magicBonus = _npc.getMagicBonus();
		}
		return magicBonus;
	}

	private int getLawful() {
		int lawful = 0;
		if (_calcType == PC_PC || _calcType == PC_NPC) {
			lawful = _pc.getLawful();
		} else if (_calcType == NPC_PC || _calcType == NPC_NPC) {
			lawful = _npc.getLawful();
		}
		return lawful;
	}

	private int getTargetMr() {
		int mr = 0;
		if (_calcType == PC_PC || _calcType == NPC_PC) {
			mr = _targetPc.getMr();
		} else {
			mr = _targetNpc.getMr();
		}
		return mr;
	}

	public boolean calcProbabilityMagic(int skillId) {
		int probability = 0;
		boolean isSuccess = false;

		if (_pc != null && _pc.isGm()) {
			return true;
		}

		if (_calcType == PC_NPC && _targetNpc != null) {
			int npcId = _targetNpc.getNpcTemplate().get_npcId();
			if (npcId >= 45912 && npcId <= 45915
					&& !_pc.hasSkillEffect(STATUS_HOLY_WATER)) {
				return false;
			}
			if (npcId == 45916 
					&& !_pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER)) {
				return false;
			}
			if (npcId == 45941 
					&& !_pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA)) {
				return false;
			}
			if (npcId == 45752 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_BARLOG)) {
				return false;
			}
			if (npcId == 45753 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_BARLOG)) {
				return false;
			}
			if (npcId == 45675 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				return false;
			}
			if (npcId == 81082 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				return false;
			}
			if (npcId == 45625 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				return false;
			}
			if (npcId == 45674 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				return false;
			}
			if (npcId == 45685 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				return false;
			}
			if (npcId >= 46068 && npcId <= 46091 // 
					&& _pc.getTempCharGfx() == 6035) {
				return false;
			}
			if (npcId >= 46092 && npcId <= 46106 // e_amob
					&& _pc.getTempCharGfx() == 6034) {
				return false;
			}
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
	
			if (_calcType == PC_NPC
					|| _calcType == NPC_PC || _calcType == NPC_NPC) {
				return true;
			}
		}

		if (_calcType == PC_PC || _calcType == NPC_PC) {
			if (_targetPc.hasSkillEffect(EARTH_BIND)) {
				if (skillId != WEAPON_BREAK
						&& skillId != CANCELLATION) {
					return false;
				}
			}
		} else {
			if (_targetNpc.hasSkillEffect(EARTH_BIND)) {
				if (skillId != WEAPON_BREAK
						&& skillId != CANCELLATION) {
					return false;
				}
			}
		}

		probability = calcProbability(skillId);

		Random random = new Random();
		int rnd = random.nextInt(100) + 1;
		if (probability > 90) {
			probability = 90;
		}

		if (probability >= rnd) {
			isSuccess = true;
		} else {
			isSuccess = false;
		}

		if (!Config.ALT_ATKMSG) {
			return isSuccess;
		}
		if (Config.ALT_ATKMSG) {
			if ((_calcType == PC_PC || _calcType == PC_NPC)
					&& !_pc.isGm()) {
				return isSuccess;
			}
			if ((_calcType == PC_PC || _calcType == NPC_PC)
					&& !_targetPc.isGm()) {
				return isSuccess;
			}
		}

		String msg0 = "";
		String msg1 = "to";
		String msg2 = "";
		String msg3 = "";
		String msg4 = "";

		if (_calcType == PC_PC || _calcType == PC_NPC) { 
			msg0 = _pc.getName();
		} else if (_calcType == NPC_PC) {
			msg0 = _npc.getName();
		}

		msg2 = "probability:" + probability + "%";
		if (_calcType == NPC_PC || _calcType == PC_PC) { 
			msg4 = _targetPc.getName();
		} else if (_calcType == PC_NPC) { 
			msg4 = _targetNpc.getName();
		}
		if (isSuccess == true) {
			msg3 = "success";
		} else {
			msg3 = "failed";
		}

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
			if (_pc.getZoneType() == 1 || _targetPc.getZoneType() == 1) { //
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
						|| skillId == SILENCE) {
					return false;
				}
			}
		}
		return true;
	}

	private int calcProbability(int skillId) {
		L1Skills l1skills = SkillsTable.getInstance().getTemplate(skillId);
		int attackLevel = 0;
		int defenseLevel = 0;
		@SuppressWarnings("unused")
		int mr = 0;
		int probability = 0;

		if (_calcType == PC_PC || _calcType == PC_NPC) {
			attackLevel = _pc.getLevel();
		} else {
			attackLevel = _npc.getLevel();
		}

		if (_calcType == PC_PC || _calcType == NPC_PC) {
			defenseLevel = _targetPc.getLevel();
		} else {
			defenseLevel = _targetNpc.getLevel();
			if (skillId == RETURN_TO_NATURE) {
				if (_targetNpc instanceof L1SummonInstance) {
					L1SummonInstance summon = (L1SummonInstance) _targetNpc;
					defenseLevel = summon.getMaster().getLevel();
				}
			}
		}

		if (skillId == ELEMENTAL_FALL_DOWN || skillId == RETURN_TO_NATURE
				|| skillId == ENTANGLE || skillId == ERASE_MAGIC
				|| skillId == AREA_OF_SILENCE || skillId == WIND_SHACKLE
				|| skillId == STRIKER_GALE || skillId == POLLUTE_WATER
				|| skillId == EARTH_BIND) {
			//
			probability = (int) (((l1skills.getProbabilityDice()) / 10D)
					* (attackLevel - defenseLevel)) + l1skills
					.getProbabilityValue();
		} else if (skillId == SHOCK_STUN
				|| skillId == COUNTER_BARRIER) {
			//
			probability = l1skills.getProbabilityValue() + attackLevel - defenseLevel;
		} else {
			Random random = new Random();
			int dice = l1skills.getProbabilityDice();
			int diceCount = 0;
			if (_calcType == PC_PC || _calcType == PC_NPC) {
				if (_pc.isWizard()) {
					diceCount = getMagicBonus() + getMagicLevel() + 1;
				} else if (_pc.isElf()) {
					diceCount = getMagicBonus() + getMagicLevel() - 1;
				} else {
					diceCount = getMagicBonus() + getMagicLevel() - 1;
				}
			} else {
				diceCount = getMagicBonus() + getMagicLevel();
			}
			if (diceCount < 1) {
				diceCount = 1;
			}

			for (int i = 0; i < diceCount; i++) {
				probability += (random.nextInt(dice) + 1);
			}
			probability = probability * getLeverage() / 10;

			probability -= getTargetMr();

			if (skillId == TAMING_MONSTER) {
				double probabilityRevision = 1;
				if ((_targetNpc.getMaxHp() * 1 / 4) > _targetNpc.getCurrentHp()) {
					probabilityRevision = 1.3;
				} else if ((_targetNpc.getMaxHp() * 2 / 4) > _targetNpc
						.getCurrentHp()) {
					probabilityRevision = 1.2;
				} else if ((_targetNpc.getMaxHp() * 3 / 4) > _targetNpc
						.getCurrentHp()) {
					probabilityRevision = 1.1;
				}
				probability *= probabilityRevision;
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

		damage = calcMrDefense(damage);

		if (_calcType == PC_PC || _calcType == NPC_PC) {
			if (damage > _targetPc.getCurrentHp()) {
				damage = _targetPc.getCurrentHp();
			}
		} else {
			if (damage > _targetNpc.getCurrentHp()) {
				damage = _targetNpc.getCurrentHp();
			}
		}
		return damage;
	}

	public int calcPcFireWallDamage() {
		int dmg = 0;
		double attrDeffence = calcAttrResistance(L1Skills.ATTR_FIRE);
		L1Skills l1skills = SkillsTable.getInstance().getTemplate(FIRE_WALL);
		dmg = (int) ((1.0 - attrDeffence) * l1skills.getDamageValue());

		if (_targetPc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(EARTH_BIND)) {
			dmg = 0;
		}

		if (dmg < 0) {
			dmg = 0;
		}

		return dmg;
	}

	//
	public int calcNpcFireWallDamage() {
		int dmg = 0;
		double attrDeffence = calcAttrResistance(L1Skills.ATTR_FIRE);
		L1Skills l1skills = SkillsTable.getInstance().getTemplate(FIRE_WALL);
		dmg = (int) ((1.0 - attrDeffence) * l1skills.getDamageValue());

		if (_targetNpc.hasSkillEffect(ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(EARTH_BIND)) {
			dmg = 0;
		}

		if (dmg < 0) {
			dmg = 0;
		}

		return dmg;
	}

	private int calcPcMagicDamage(int skillId) {
		int dmg = 0;
		if (skillId == FINAL_BURN) {
			if (_calcType == PC_PC || _calcType == PC_NPC) {
				dmg = _pc.getCurrentMp();
			} else {
				dmg = _npc.getCurrentMp();
			}
		} else {
			dmg = calcMagicDiceDamage(skillId);
			dmg = (dmg * getLeverage()) / 10;
		}

		dmg -= _targetPc.getDamageReductionByArmor(); 

		if (_targetPc.hasSkillEffect(COOKING_1_0_S)
				|| _targetPc.hasSkillEffect(COOKING_1_1_S)
				|| _targetPc.hasSkillEffect(COOKING_1_2_S)
				|| _targetPc.hasSkillEffect(COOKING_1_3_S)
				|| _targetPc.hasSkillEffect(COOKING_1_4_S)
				|| _targetPc.hasSkillEffect(COOKING_1_5_S)
				|| _targetPc.hasSkillEffect(COOKING_1_6_S)) {
			dmg -= 5;
		}
		if (_targetPc.hasSkillEffect(COOKING_1_7_S)) { 
			dmg -= 5;
		}

		if (_targetPc.hasSkillEffect(REDUCTION_ARMOR)) {
			int targetPcLvl = _targetPc.getLevel();
			if (targetPcLvl < 50) {
				targetPcLvl = 50;
			}
			dmg -= (targetPcLvl - 50) / 5 + 1;
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
		if (_targetPc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetPc.hasSkillEffect(EARTH_BIND)) {
			dmg = 0;
		}

		if (_targetPc.hasSkillEffect(COUNTER_MIRROR)) {
			if (_calcType == PC_PC) {
				if (_targetPc.getWis() >= _random.nextInt(100)) {
					_pc.sendPackets(new S_DoActionGFX(_pc.getId(),
							ActionCodes.ACTION_Damage));
					_pc.broadcastPacket(new S_DoActionGFX(_pc.getId(),
							ActionCodes.ACTION_Damage));
					_targetPc.sendPackets(new S_SkillSound(_targetPc.getId(),
							4395));
					_targetPc.broadcastPacket(new S_SkillSound(_targetPc
							.getId(), 4395));
					_pc.receiveDamage(_targetPc, dmg);
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
						_npc.broadcastPacket(new S_DoActionGFX(_npc.getId(),
								ActionCodes.ACTION_Damage));
						_targetPc.sendPackets(new S_SkillSound(_targetPc
								.getId(), 4395));
						_targetPc.broadcastPacket(new S_SkillSound(_targetPc
								.getId(), 4395));
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

		return dmg;
	}

	private int calcNpcMagicDamage(int skillId) {
		int dmg = 0;
		if (skillId == FINAL_BURN) {
			if (_calcType == PC_PC || _calcType == PC_NPC) {
				dmg = _pc.getCurrentMp();
			} else {
				dmg = _npc.getCurrentMp();
			}
		} else {
			dmg = calcMagicDiceDamage(skillId);
			dmg = (dmg * getLeverage()) / 10;
		}

		if (_calcType == PC_NPC) { //
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

		if (_targetNpc.hasSkillEffect(ICE_LANCE)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(FREEZING_BLIZZARD)) {
			dmg = 0;
		}
		if (_targetNpc.hasSkillEffect(EARTH_BIND)) {
			dmg = 0;
		}

		if (_calcType == PC_NPC && _targetNpc != null) {
			int npcId = _targetNpc.getNpcTemplate().get_npcId();
			if (npcId >= 45912 && npcId <= 45915 //
					&& !_pc.hasSkillEffect(STATUS_HOLY_WATER)) {
				dmg = 0;
			}
			if (npcId == 45916 //
					&& !_pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER)) {
				dmg = 0;
			}
			if (npcId == 45941 //
					&& !_pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA)) {
				dmg = 0;
			}
			if (npcId == 45752 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_BARLOG)) {
				dmg = 0;
			}
			if (npcId == 45753 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_BARLOG)) {
				dmg = 0;
			}
			if (npcId == 45675 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				dmg = 0;
			}
			if (npcId == 81082 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				dmg = 0;
			}
			if (npcId == 45625 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				dmg = 0;
			}
			if (npcId == 45674 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				dmg = 0;
			}
			if (npcId == 45685 // 
					&& !_pc.hasSkillEffect(STATUS_CURSE_YAHEE)) {
				dmg = 0;
			}
			if (npcId >= 46068 && npcId <= 46091 // 
					&& _pc.getTempCharGfx() == 6035) {
				dmg = 0;
			}
			if (npcId >= 46092 && npcId <= 46106 // 
					&& _pc.getTempCharGfx() == 6034) {
				dmg = 0;
			}
		}

		return dmg;
	}

	private int calcMagicDiceDamage(int skillId) {
		L1Skills l1skills = SkillsTable.getInstance().getTemplate(skillId);
		int dice = l1skills.getDamageDice();
		int diceCount = l1skills.getDamageDiceCount();
		int value = l1skills.getDamageValue();
		int magicDamage = 0;
		int charaIntelligence = 0;
		Random random = new Random();

		for (int i = 0; i < diceCount; i++) {
			magicDamage += (random.nextInt(dice) + 1);
		}
		magicDamage += value;

		if (_calcType == PC_PC || _calcType == PC_NPC) {
			int weaponAddDmg = 0;
			L1ItemInstance weapon = _pc.getWeapon();
			if (weapon != null) {
				weaponAddDmg = weapon.getItem().getMagicDmgModifier();
			}
			magicDamage += weaponAddDmg;
		}

		if (_calcType == PC_PC || _calcType == PC_NPC) {
			int spByItem = _pc.getSp() - _pc.getTrueSp();
			charaIntelligence = _pc.getInt() + spByItem - 12;
		} else if (_calcType == NPC_PC || _calcType == NPC_NPC) {
			int spByItem = _npc.getSp() - _npc.getTrueSp(); // 
			charaIntelligence = _npc.getInt() + spByItem - 12;
		}
		if (charaIntelligence < 1) {
			charaIntelligence = 1;
		}

		double attrDeffence = calcAttrResistance(l1skills.getAttr());

		double coefficient = (1.0 - attrDeffence + charaIntelligence * 3.0 / 32.0);
		if (coefficient < 0) {
			coefficient = 0;
		}

		magicDamage *= coefficient;

		return magicDamage;
	}

	public int calcHealing(int skillId) {
		L1Skills l1skills = SkillsTable.getInstance().getTemplate(skillId);
		int dice = l1skills.getDamageDice();
		int value = l1skills.getDamageValue();
		int magicDamage = 0;

		int magicBonus = getMagicBonus();
		if (magicBonus > 10) {
			magicBonus = 10;
		}

		Random random = new Random();
		int diceCount = value + magicBonus;
		for (int i = 0; i < diceCount; i++) {
			magicDamage += (random.nextInt(dice) + 1);
		}

		double alignmentRevision = 1.0;
		if (getLawful() > 0) {
			alignmentRevision += (getLawful() / 32768.0);
		}

		magicDamage *= alignmentRevision;

		magicDamage = (magicDamage * getLeverage()) / 10;

		return magicDamage;
	}

	private int calcMrDefense(int dmg) {
		int mr = getTargetMr();
		Random random = new Random();
		int rnd = random.nextInt(100) + 1;
		if (mr >= rnd) {
			dmg /= 2;
		}

		return dmg;
	}

	private double calcAttrResistance(int attr) {
		int resist = 0;
		if (_calcType == PC_PC || _calcType == NPC_PC) {
			if (attr == L1Skills.ATTR_EARTH) {
				resist = _targetPc.getEarth();
			} else if (attr == L1Skills.ATTR_FIRE) {
				resist = _targetPc.getFire();
			} else if (attr == L1Skills.ATTR_WATER) {
				resist = _targetPc.getWater();
			} else if (attr == L1Skills.ATTR_WIND) {
				resist = _targetPc.getWind();
			}
		} else if (_calcType == PC_NPC || _calcType == NPC_NPC) {
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

		String msg0 = "";
		String msg1 = "to";
		String msg2 = "";
		String msg3 = "";
		String msg4 = "";

		if (_calcType == PC_PC || _calcType == PC_NPC) {
			msg0 = _pc.getName();
		} else if (_calcType == NPC_PC) { 
			msg0 = _npc.getName();
		}

		if (_calcType == NPC_PC || _calcType == PC_PC) { 
			msg4 = _targetPc.getName();
			msg2 = "THP" + _targetPc.getCurrentHp();
		} else if (_calcType == PC_NPC) {
			msg4 = _targetNpc.getName();
			msg2 = "THp" + _targetNpc.getCurrentHp();
		}

		msg3 = damage + "currentHp";

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
			_targetPc.receiveDamage(_pc, damage);
		} else if (_calcType == NPC_PC) {
			_targetPc.receiveDamage(_npc, damage);
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
