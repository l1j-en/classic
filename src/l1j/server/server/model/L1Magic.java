package l1j.server.server.model;

import static l1j.server.server.model.skill.L1SkillId.AREA_OF_SILENCE;
import static l1j.server.server.model.skill.L1SkillId.CANCELLATION;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_7_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_7_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_7_S;
import static l1j.server.server.model.skill.L1SkillId.COUNTER_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.COUNTER_MIRROR;
import static l1j.server.server.model.skill.L1SkillId.CURSE_BLIND;
import static l1j.server.server.model.skill.L1SkillId.CURSE_PARALYZE;
import static l1j.server.server.model.skill.L1SkillId.CURSE_POISON;
import static l1j.server.server.model.skill.L1SkillId.DARKNESS;
import static l1j.server.server.model.skill.L1SkillId.DARK_BLIND;
import static l1j.server.server.model.skill.L1SkillId.DECAY_POTION;
import static l1j.server.server.model.skill.L1SkillId.DISEASE;
import static l1j.server.server.model.skill.L1SkillId.DRAGON_SKIN;
import static l1j.server.server.model.skill.L1SkillId.EARTH_BIND;
import static l1j.server.server.model.skill.L1SkillId.ELEMENTAL_FALL_DOWN;
import static l1j.server.server.model.skill.L1SkillId.ENTANGLE;
import static l1j.server.server.model.skill.L1SkillId.ERASE_MAGIC;
import static l1j.server.server.model.skill.L1SkillId.FINAL_BURN;
import static l1j.server.server.model.skill.L1SkillId.FIRE_WALL;
import static l1j.server.server.model.skill.L1SkillId.FOG_OF_SLEEPING;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BLIZZARD;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BREATH;
import static l1j.server.server.model.skill.L1SkillId.GUARD_BRAKE;
import static l1j.server.server.model.skill.L1SkillId.HORROR_OF_DEATH;
import static l1j.server.server.model.skill.L1SkillId.ICE_LANCE;
import static l1j.server.server.model.skill.L1SkillId.ILLUSION_AVATAR;
import static l1j.server.server.model.skill.L1SkillId.IMMUNE_TO_HARM;
import static l1j.server.server.model.skill.L1SkillId.JOY_OF_PAIN;
import static l1j.server.server.model.skill.L1SkillId.MANA_DRAIN;
import static l1j.server.server.model.skill.L1SkillId.MASS_SLOW;
import static l1j.server.server.model.skill.L1SkillId.PATIENCE;
import static l1j.server.server.model.skill.L1SkillId.POLLUTE_WATER;
import static l1j.server.server.model.skill.L1SkillId.REDUCTION_ARMOR;
import static l1j.server.server.model.skill.L1SkillId.RESIST_FEAR;
import static l1j.server.server.model.skill.L1SkillId.RETURN_TO_NATURE;
import static l1j.server.server.model.skill.L1SkillId.SHOCK_STUN;
import static l1j.server.server.model.skill.L1SkillId.SILENCE;
import static l1j.server.server.model.skill.L1SkillId.SLOW;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CURSE_BARLOG;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CURSE_YAHEE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_DESTRUCTION_NOSTRUM;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_MITHRIL_POWDER;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_WATER;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_WATER_OF_EVA;
import static l1j.server.server.model.skill.L1SkillId.STRIKER_GALE;
import static l1j.server.server.model.skill.L1SkillId.TAMING_MONSTER;
import static l1j.server.server.model.skill.L1SkillId.THUNDER_GRAB;
import static l1j.server.server.model.skill.L1SkillId.WEAKNESS;
import static l1j.server.server.model.skill.L1SkillId.WEAPON_BREAK;
import static l1j.server.server.model.skill.L1SkillId.WIND_SHACKLE;

import java.util.Arrays;
import java.util.Random;

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
import l1j.server.server.model.skill.L1NamedSkill;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Skill;
import l1j.server.server.utils.collections.IntArrays;

public class L1Magic {
	private int _calcType;
	private static final int PC_PC = 1;
	private static final int PC_NPC = 2;
	private static final int NPC_PC = 3;
	private static final int NPC_NPC = 4;
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

	private static final int[] NOT_IN_SAFE_ZONES = new int[] { WEAPON_BREAK,
			SLOW, CURSE_PARALYZE, MANA_DRAIN, DARKNESS, WEAKNESS, DISEASE,
			DECAY_POTION, MASS_SLOW, ENTANGLE, ERASE_MAGIC, EARTH_BIND,
			AREA_OF_SILENCE, WIND_SHACKLE, STRIKER_GALE, SHOCK_STUN,
			FOG_OF_SLEEPING, ICE_LANCE, FREEZING_BLIZZARD, CANCELLATION,
			POLLUTE_WATER, CURSE_POISON, ELEMENTAL_FALL_DOWN, CURSE_BLIND,
			RETURN_TO_NATURE, DARK_BLIND, SILENCE, FREEZING_BREATH };

	static {
		Arrays.sort(NOT_IN_SAFE_ZONES);
	}

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
				if (_pc.getZoneType() == ZoneType.Safety
						|| _targetPc.getZoneType() == ZoneType.Safety) {
					return false;
				}
			}
			if (_calcType == PC_NPC || _calcType == NPC_PC
					|| _calcType == NPC_NPC) {
				return true;
			}
		}
		if (_target.hasSkillEffect(EARTH_BIND)) {
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
			if ((_calcType == PC_PC || _calcType == NPC_PC)
					&& !_targetPc.isGm()) {
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
		if (_pc == null || _targetPc == null)
			return true;

		if (_pc.getZoneType() == ZoneType.Safety
				|| _targetPc.getZoneType() == ZoneType.Safety)
			return !IntArrays.sContains(NOT_IN_SAFE_ZONES, skillId);

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
			probability = skill.getProbabilityValue()
					+ (int) (((skill.getProbabilityDice()) / 10D) * levelDifference);

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
		} else if (skillId == THUNDER_GRAB) {
			// success rate is probability_value(50%) * (attackerlvl/
			// defenselvl) + random(0-20)
			probability = skill.getProbabilityValue()
					* (_attacker.getLevel() / Math.max(1, defenseLevel))
					+ _random.nextInt(21);

			if (_calcType == PC_PC || _calcType == PC_NPC) {
				probability += 2 * _pc.getOriginalMagicHit();
			}
		} else {
			int dice = skill.getProbabilityDice();
			int diceCount = _attacker.getMagicBonus()
					+ _attacker.getMagicLevel();
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

		if (_calcType == PC_PC || _calcType == NPC_PC) {
			switch (skillId) {
			case EARTH_BIND:
				probability -= _target.getResistSustain();
				break;
			case SHOCK_STUN:
				probability -= 2 * _target.getResistStun();
				break;
			case CURSE_PARALYZE:
				probability -= _target.getResistStone();
				break;
			case FOG_OF_SLEEPING:
				probability -= _target.getResistSleep();
				break;
			case ICE_LANCE:
			case FREEZING_BLIZZARD:
			case FREEZING_BREATH:
				probability -= _target.getResistFreeze();
				break;
			case CURSE_BLIND:
			case DARKNESS:
			case DARK_BLIND:
				probability -= _target.getResistBlind();
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
		damage = skillId == JOY_OF_PAIN ? damage : calcMrDefense(damage);
		if (_calcType == PC_NPC && _pc.getDmgMessages()) {
			_pc.sendPackets(new S_SystemMessage(L1NamedSkill.getName(skillId)
					+ " Dealt:" + String.valueOf(damage)));
		}
		return damage;
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
		int dmg = skillId == FINAL_BURN ? _attacker.getCurrentMp()
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
			// NOTE: changed these dmgs since pets will get insta-pwned by magic
			// mobs
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

		dmg = tryCounterMirror(_targetPc, _calcType, _pc, _npc, dmg) ? 0 : dmg;

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
			dmg = missinghp / 5;
			if (dmg < 5) {
				dmg = 5;
			}
		}
		return dmg;
	}

	// Returns true when Counter Mirror procs.
	private static boolean tryCounterMirror(L1PcInstance target, int type,
			L1PcInstance pcAttacker, L1NpcInstance npcAttacker, int damage) {
		if (!target.hasSkillEffect(COUNTER_MIRROR)
				|| target.getWis() <= _random.nextInt(100) || type == NPC_NPC
				|| type == PC_NPC)
			return false;
		if (type == NPC_PC) {
			int npcId = npcAttacker.getNpcTemplate().get_npcId();
			if (npcId == 45681 || npcId == 45682 || npcId == 45683
					|| npcId == 45684
					|| !npcAttacker.getNpcTemplate().get_IsErase())
				return false;
			npcAttacker.broadcastPacket(new S_DoActionGFX(npcAttacker.getId(),
					ActionCodes.ACTION_Damage));
			npcAttacker.receiveDamage(target, damage);
		} else { // PC_PC
			pcAttacker.sendAndBroadcast(new S_DoActionGFX(pcAttacker.getId(),
					ActionCodes.ACTION_Damage));
			pcAttacker.receiveDamage(target, damage, false);
		}
		target.sendAndBroadcast(new S_SkillSound(target.getId(), 4395));
		target.killSkillEffectTimer(COUNTER_MIRROR);
		return true;
	}

	/**
	 * Whether or not the attacker (still) needs a buff to affect the target.
	 * Only arises in pve situations, e.g. attacking Chaos. TODO: find a better
	 * name. TODO: L1Attack and L1Magic both need this check. Duplicating code
	 * to avoid lots of casting. (Need to test whether it's really worth it.)
	 */
	private boolean isMissingSkillEffect() {
		if (_calcType == PC_NPC && _targetNpc != null) {
			int npcId = _targetNpc.getNpcTemplate().get_npcId();
			switch (npcId) {
			case 45912:
			case 45913:
			case 45914:
			case 45915:
				return !_pc.hasSkillEffect(STATUS_HOLY_WATER);
			case 45916:
				return !_pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER);
			case 45941:
				return !_pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA);
			case 45752:
			case 45753:
				return !_pc.hasSkillEffect(STATUS_CURSE_BARLOG);
			case 45675:
			case 81082:
			case 45625:
			case 45674:
			case 45685:
				return !_pc.hasSkillEffect(STATUS_CURSE_YAHEE);
			case 91310:
				// Altar of Reviving
				return !_pc.hasSkillEffect(STATUS_DESTRUCTION_NOSTRUM);
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
			dmg = Math.max(missinghp / 5, 5);
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
		int charaIntelligence = Math.max(_attacker.getInt() + spByItem
				- INT_ADJUSTMENT, 1);

		double attrDeffence = calcAttrResistance(skill.getAttr());
		double coefficient = Math.max(
				(1.0 - attrDeffence + charaIntelligence * 3.0 / 32.0), 0);

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
			if (skill.getSkillLevel() <= CRIT_LEVEL_LIMIT
					&& _random.nextInt(100) + 1 <= BASE_CRIT_RATE
							+ _pc.getOriginalMagicCritical()) {
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
			if ((_calcType == PC_PC || _calcType == PC_NPC) && !_pc.isGm()) {
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
