/**
 * GPLv2. See license.
 */
package l1j.server.server.model;

import static l1j.server.server.model.item.L1ItemId.C_DICE_DAGGER;
import static l1j.server.server.model.item.L1ItemId.DAGGER_OF_MAGIC_POWER;
import static l1j.server.server.model.item.L1ItemId.DICE_DAGGER;
import static l1j.server.server.model.item.L1ItemId.FINGER_OF_DEATH;
import static l1j.server.server.model.item.L1ItemId.GREAT_SWORD_OF_DESTRUCTION;
import static l1j.server.server.model.item.L1ItemId.SAYHAS_BOW;
import static l1j.server.server.model.item.L1ItemId.STAFF_OF_MANA;
import static l1j.server.server.model.item.L1ItemId.STEEL_STAFF_OF_MANA;
import static l1j.server.server.model.item.L1ItemId.SWORD_OF_ANCIENT_ELF;
import static l1j.server.server.model.item.L1ItemId.SWORD_OF_ORDEAL;
import static l1j.server.server.model.item.L1ItemId.SWORD_OF_ORDEAL_B;
import static l1j.server.server.model.item.L1ItemId.SWORD_OF_ORDEAL_C;
import static l1j.server.server.model.item.L1ItemId.THEBES_BOW;
import static l1j.server.server.model.item.L1ItemId.THEBES_EDORYU;
import static l1j.server.server.model.item.L1ItemId.THEBES_STAFF;
import static l1j.server.server.model.item.L1ItemId.THEBES_SWORD;
import static l1j.server.server.model.item.L1ItemId.UNARMED;
import static l1j.server.server.model.item.L1ItemId.WIND_BLADE_DAGGER;
import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.BERSERKERS;
import static l1j.server.server.model.skill.L1SkillId.BOUNCE_ATTACK;
import static l1j.server.server.model.skill.L1SkillId.BURNING_SPIRIT;
import static l1j.server.server.model.skill.L1SkillId.BURNING_WEAPON;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_7_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_0_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_3_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_7_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_0_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_2_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_7_S;
import static l1j.server.server.model.skill.L1SkillId.DOUBLE_BRAKE;
import static l1j.server.server.model.skill.L1SkillId.DRAGON_SKIN;
import static l1j.server.server.model.skill.L1SkillId.EARTH_BIND;
import static l1j.server.server.model.skill.L1SkillId.ELEMENTAL_FIRE;
import static l1j.server.server.model.skill.L1SkillId.ENCHANT_VENOM;
import static l1j.server.server.model.skill.L1SkillId.FIRE_BLESS;
import static l1j.server.server.model.skill.L1SkillId.FIRE_WEAPON;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BLIZZARD;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BREATH;
import static l1j.server.server.model.skill.L1SkillId.ICE_LANCE;
import static l1j.server.server.model.skill.L1SkillId.IMMUNE_TO_HARM;
import static l1j.server.server.model.skill.L1SkillId.MIRROR_IMAGE;
import static l1j.server.server.model.skill.L1SkillId.PATIENCE;
import static l1j.server.server.model.skill.L1SkillId.REDUCTION_ARMOR;
import static l1j.server.server.model.skill.L1SkillId.RESIST_FEAR;
import static l1j.server.server.model.skill.L1SkillId.SOUL_OF_FLAME;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CURSE_BARLOG;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CURSE_YAHEE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_DESTRUCTION_NOSTRUM;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_MITHRIL_POWDER;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_WATER;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_WATER_OF_EVA;
import static l1j.server.server.model.skill.L1SkillId.STATUS_WEAKNESS_EXPOSURE_LV1;
import static l1j.server.server.model.skill.L1SkillId.STATUS_WEAKNESS_EXPOSURE_LV2;
import static l1j.server.server.model.skill.L1SkillId.STATUS_WEAKNESS_EXPOSURE_LV3;
import static l1j.server.server.model.skill.L1SkillId.UNCANNY_DODGE;
import static l1j.server.server.model.skill.L1SkillId.BURNING_SLASH;

import java.util.Arrays;
import java.util.Random;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.controllers.BossEventController;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.item.WeaponType;
import l1j.server.server.model.poison.L1DamagePoison;
import l1j.server.server.model.poison.L1ParalysisPoison;
import l1j.server.server.model.poison.L1SilencePoison;
import l1j.server.server.serverpackets.S_AttackMissPacket;
import l1j.server.server.serverpackets.S_AttackPacket;
import l1j.server.server.serverpackets.S_AttackPacketForNpc;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_EffectLocation;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_UseArrowSkill;
import l1j.server.server.serverpackets.S_UseAttackSkill;
import l1j.server.server.templates.L1Item;
import l1j.server.server.types.Point;

public class L1Attack {
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
	private int _leverage = 10;

	// TODO: in progress
	// Logically final
	private boolean isRanged;
	private boolean isBow;
	private boolean isGauntlet;
	private boolean isKiringku;
	private static final int[] PREVENT_DAMAGE = { ABSOLUTE_BARRIER, ICE_LANCE,
			FREEZING_BLIZZARD, FREEZING_BREATH, EARTH_BIND };

	public void setLeverage(int i) {
		_leverage = i;
	}

	private int getLeverage() {
		return _leverage;
	}

	private static final int[] strHit = { -2, -2, -2, -2, -2, -2, -2, // 1`7
			-2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, // 8`26
			7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, // 27`44
			13, 13, 13, 14, 14, 14, 15, 15, 15, 16, 16, 16, 17, 17, 17 }; // 45`59

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
			if ((str + 1) % 4 == 0) {
				dmg++;
			}
			strDmg[str] = dmg;
		}

		Arrays.sort(PREVENT_DAMAGE);
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
			if (dex % 3 == 0) {
				dmg++;
			}
			dexDmg[dex] = dmg;
		}
		for (int dex = 36; dex <= 127; dex++) { // 36`12741
			if (dex % 4 == 0) {
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
			weapon = _pc.getWeapon();
			if (weapon != null) {
				L1Item item = weapon.getItem();
				_weaponId = item.getItemId();
				_weaponType = item.getType1();
				_weaponType2 = item.getType();
				isKiringku = _weaponType2 == WeaponType.Kiringku;
				_weaponAddHit = item.getHitModifier() + weapon.getHitByMagic();
				_weaponAddDmg = item.getDmgModifier() + weapon.getDmgByMagic();
				_weaponSmall = item.getDmgSmall();
				_weaponLarge = item.getDmgLarge();
				_weaponRange = item.getRange();
				_weaponBless = item.getBless();
				isBow = _weaponType == WeaponType.Bow;
				isGauntlet = _weaponType == WeaponType.Gauntlet;
				isRanged = isBow | isGauntlet;
				_weaponEnchant = weapon.getEnchantLevel()
						- (isRanged ? 0 : weapon.get_durability());
				_weaponMaterial = item.getMaterial();
				if (isBow) { // Arrow acquisition
					_arrow = _pc.getInventory().getArrow();
					if (_arrow != null) {
						// if weapon or arrow is blessed, set weapon blessed
						// else just go by the arrow
						if (_weaponBless == 0
								|| _arrow.getItem().getBless() == 0) {
							_weaponBless = 0;
						} else {
							_weaponBless = _arrow.getItem().getBless();
						}
						_weaponMaterial = _arrow.getItem().getMaterial();
					}
				}
				if (isGauntlet) { // Sting's acquisition
					_sting = _pc.getInventory().getSting();
					if (_sting != null) {
						_weaponBless = _sting.getItem().getBless();
						_weaponMaterial = _sting.getItem().getMaterial();
					}
				}
				_weaponDoubleDmgChance = item.getDoubleDmgChance();
				_weaponAttrEnchantKind = weapon.getAttrEnchantKind();
				_weaponAttrEnchantLevel = weapon.getAttrEnchantLevel();
			}
			// Extra damage from stats - dex for bow, str for all others.
			_statusDamage = isBow ? dexDmg[_pc.getDex()] : strDmg[_pc.getStr()];
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
			if (_weaponRange != -1) {
				if (_pc.getLocation()
						.getTileLineDistance(_target.getLocation()) > _weaponRange + 1) {
					_isHit = false;
					return _isHit;
				}
			} else {
				if (!_pc.getLocation().isInScreen(_target.getLocation())) {
					_isHit = false;
					return _isHit;
				}
			}
			if (isBow && _weaponId != SAYHAS_BOW && _arrow == null) {
				_isHit = false;
			} else if (isGauntlet && _sting == null) {
				_isHit = false;
			} else if (!_pc.glanceCheck(_targetX, _targetY)) {
				_isHit = false; // If the attacker is the player's decision is
								// an obstacle
			} else if (_weaponId == SWORD_OF_ORDEAL || _weaponId == SWORD_OF_ORDEAL_B ||
					_weaponId == SWORD_OF_ORDEAL_C) {
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

	private int getBasePcHit() {
		int hitRate = _pc.getLevel();

		int str = _pc.getStr();
		hitRate += str > 59 ? strHit[58] : strHit[str - 1];
		int dex = _pc.getDex();
		hitRate += dex > 60 ? dexHit[59] : dexHit[dex - 1];

		hitRate += _weaponAddHit + _weaponEnchant / 2;
		hitRate += isRanged ? _pc.getBowHitup() + _pc.getOriginalBowHitup()
				+ _pc.getBowHitModifierByArmor() : _pc.getHitup()
				+ _pc.getOriginalHitup() + _pc.getHitModifierByArmor();

		hitRate += getWeightHitModifier(_pc);
		hitRate += getCookingHitModifier(_pc, isRanged);
		hitRate += getDollHitModifier(_pc, isRanged);

		return hitRate;
	}

	private static int getDollHitModifier(final L1PcInstance pc,
			final boolean ranged) {
		int hitRate = 0;
		Object[] dollList = pc.getDollList().values().toArray();
		for (Object dollObject : dollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			hitRate += ranged ? doll.getRangedHitByDoll() : doll.getMeleeHitByDoll();
		}
		return hitRate;
	}

	private static int getDollDmgModifier(final L1PcInstance pc,
			final boolean ranged) {
		int damage = 0;
		Object[] dollList = pc.getDollList().values().toArray();
		for (Object dollObject : dollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			damage += ranged ? doll.getRangedDmgByDoll() : doll.getMeleeDmgByDoll();
		}
		return damage;
	}

	// TODO: skill implementation should make this unnecessary.
	private static int getCookingHitModifier(final L1PcInstance pc,
			final boolean ranged) {
		int cookingModifier = 0;
		if (!ranged
				&& (pc.hasSkillEffect(COOKING_2_0_N) || pc
						.hasSkillEffect(COOKING_2_0_S))) {
			cookingModifier += 1;
		}
		if (!ranged
				&& (pc.hasSkillEffect(COOKING_3_2_N) || pc
						.hasSkillEffect(COOKING_3_2_S))) {
			cookingModifier += 2;
		}
		if (ranged
				&& (pc.hasSkillEffect(COOKING_2_3_N)
						|| pc.hasSkillEffect(COOKING_2_3_S)
						|| pc.hasSkillEffect(COOKING_3_0_N) || pc
							.hasSkillEffect(COOKING_3_0_S))) {
			cookingModifier += 1;
		}
		return cookingModifier;
	}
	
	private static int getCookingDmgModifier(final L1PcInstance pc,
			final boolean ranged) {
		int damage = 0;
		if (!ranged
				&& (pc.hasSkillEffect(COOKING_2_0_N)
						|| pc.hasSkillEffect(COOKING_2_0_S)
						|| pc.hasSkillEffect(COOKING_3_2_N) || pc
							.hasSkillEffect(COOKING_3_2_S))) {
			damage += 1;
		}
		if (ranged
				&& (pc.hasSkillEffect(COOKING_2_3_N)
						|| pc.hasSkillEffect(COOKING_2_3_S)
						|| pc.hasSkillEffect(COOKING_3_0_N) || pc
							.hasSkillEffect(COOKING_3_0_S))) {
			damage += 1;
		}
		return damage;
	}

	private int getWeightHitModifier(final L1PcInstance pc) {
		int weightModifier = 0;
		int currentWeight = pc.getInventory().getWeight240();
		if (80 < currentWeight && 120 >= currentWeight)
			weightModifier = -1;
		else if (121 <= currentWeight && 160 >= currentWeight)
			weightModifier = -3;
		else if (161 <= currentWeight && 200 >= currentWeight)
			weightModifier = -5;
		return weightModifier;
	}

	private static int getSkillAdjustment(final L1Character target) {
		int skillAdjustment = 0;
		if (target.hasSkillEffect(UNCANNY_DODGE))
			skillAdjustment -= 5;
		if (target.hasSkillEffect(MIRROR_IMAGE))
			skillAdjustment -= 5;
		if (target.hasSkillEffect(RESIST_FEAR))
			skillAdjustment += 5;
		return skillAdjustment;
	}

	/*
	 * C's hit rate = (PC-class Lv + + STR correction correction correction + +
	 * DEX + DAI the number of weapons correction / 2 + magic correction) ~
	 * 0.68-10 The figures are calculated in their biggest hit (95%) gives the
	 * other side of the PC can take the other side of the PC's AC AC is better
	 * at self-hit rate of 1 per pull out The minimum rate hit 5 percent hit
	 * rate of up to 95%
	 */
	private boolean calcPcPcHit() {
		// wrap in try/catch to make sure the command doesn't
		// accidentally crap out the action
		try {
			if(_targetPc instanceof L1PcInstance && _targetPc.isGmInvul()) {
				
				return false;
			}
		} catch(Exception ex) { }
		
		_hitRate = getBasePcHit();

		int attackerDice = _random.nextInt(20) + 1 + _hitRate - 10;

		attackerDice += getSkillAdjustment(_targetPc);

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
			_hitRate = attackerDice > defenderDice ? 100 : 0;
		}

		if (isKiringku) {
			_hitRate = 100;
		}

		if (isImmune(_targetPc))
			_hitRate = 0;

		int rnd = _random.nextInt(100) + 1;
		if (isBow && _hitRate >= rnd) { // Check ER against arrows.
			return calcErEvasion();
		}
		return _hitRate >= rnd;
	}

	public static boolean isImmune(L1Character character) {
		for (int skillId : PREVENT_DAMAGE)
			if (character.hasSkillEffect(skillId))
				return true;
		return false;
	}

	/**
	 * Whether or not the attacker (still) needs a buff to affect the target.
	 * Only arises in pve situations, e.g. attacking Chaos. See notes in
	 * L1Magic.
	 */
	public boolean isMissingSkillEffect() {
		return isMissingSkillEffect(null);
	}
	
	// if it is a pc hitting a mob, or a pet hitting a mob
	private boolean isMissingSkillEffect(L1PetInstance pet) {
			boolean isPet = _calcType == NPC_NPC && pet != null;
		
		if ((_calcType == PC_NPC || isPet)
				&& _targetNpc != null) {
			
			L1PcInstance player = _pc;
			
			// if it is a pet or summon, lets get their master
			if(isPet) {
				L1Character master = pet.getMaster();
				
				// looks like it isn't owned by a player, so assume
				// that they aren't missing the skill
				if(master == null ||  !(master instanceof L1PcInstance)) {
					return false;
				}
				
				player = (L1PcInstance)master;
			}
			
			int npcId = _targetNpc.getNpcTemplate().get_npcId();
			
			if(BossEventController.getInstance().getBossIds().contains(_targetNpc.getId())) {
				return false;
			}
			
			switch (npcId) {
			case 45912:
			case 45913:
			case 45914:
			case 45915:
				return !player.hasSkillEffect(STATUS_HOLY_WATER);
			case 45916:
				return !player.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER);
			case 45941:
				return !player.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA);
			case 45752:
			case 45753:
				return !player.hasSkillEffect(STATUS_CURSE_BARLOG);
			case 45675:
			case 81082:
			case 45625:
			case 45674:
			case 45685:
				return !player.hasSkillEffect(STATUS_CURSE_YAHEE);
			case 91310:
				// Altar of Reviving
				return !player.hasSkillEffect(STATUS_DESTRUCTION_NOSTRUM);
			}
			if (npcId >= 46068 && npcId <= 46091) {
				return player.getTempCharGfx() == 6035;
			}
			if (npcId >= 46092 && npcId <= 46106) {
				return player.getTempCharGfx() == 6034;
			}
		}
		
		return false;
	}

	private boolean calcPcNpcHit() {
		// NPC's hit rate
		// = (PC-class Lv + + STR correction correction correction + + DEX
		// + DAI the number of weapons correction / 2 + magic correction)
		// ~ 5 - (NPC's AC ~ (-5))
		_hitRate = getBasePcHit();

		int attackerDice = _random.nextInt(20) + 1 + _hitRate - 10;

		attackerDice += getSkillAdjustment(_targetNpc);

		int defenderDice = 10 - _targetNpc.getAc();
		int fumble = _hitRate - 9;
		int critical = _hitRate + 10;

		if (attackerDice <= fumble) {
			_hitRate = 0;
		} else if (attackerDice >= critical) {
			_hitRate = 100;
		} else {
			_hitRate = attackerDice > defenderDice ? 100 : 0;
		}

		if (isKiringku) {
			_hitRate = 100;
		}

		if (isMissingSkillEffect()) {
			_hitRate = 0;
		}

		int rnd = _random.nextInt(100) + 1;
		return _hitRate >= rnd;
	}

	private static int getNpcHitRate(final L1NpcInstance attacker,
			final L1Character target) {
		int hitRate = attacker.getLevel() + attacker.getHitup();
		if (attacker instanceof L1PetInstance) {
			hitRate += ((L1PetInstance) attacker).getHitByWeapon();
		}

		int attackerDice = _random.nextInt(20) + 1 + hitRate - 1;
		attackerDice += getSkillAdjustment(target);
		int targetAc = target.getAc();
		int defenderValue = targetAc * -1;
		int defenderDice = targetAc >= 0 ? 10 - targetAc : 10 + _random
				.nextInt(defenderValue) + 1;

		int fumble = hitRate;
		int critical = hitRate + 19;

		if (attackerDice <= fumble)
			hitRate = 0;
		else if (attackerDice >= critical)
			hitRate = 100;
		else
			hitRate = attackerDice > defenderDice ? 100 : 0;
		return hitRate;
	}

	private boolean calcNpcPcHit() {
		// wrap in try/catch to make sure the command doesn't
		// accidentally crap out the action
		try {
			if(_targetPc instanceof L1PcInstance && _targetPc.isGmInvul()) {
				return false;
			}
		} catch(Exception ex) { }
		
		_hitRate = getNpcHitRate(_npc, _targetPc);

		if (isImmune(_targetPc))
			_hitRate = 0;

		int rnd = _random.nextInt(100) + 1;

		// NPC attack range of more than 10 cases, if two or more away from
		// the attack and considered an archer.
		if (_npc.getNpcTemplate().get_ranged() >= 10
				&& _hitRate >= rnd
				&& _npc.getLocation().getTileLineDistance(
						new Point(_targetX, _targetY)) >= 2) {
			return calcErEvasion();
		}
		return _hitRate >= rnd;
	}

	private boolean calcNpcNpcHit() {
		_hitRate = getNpcHitRate(_npc, _targetNpc);
		
		if(_npc instanceof L1PetInstance) {
			L1Character master = ((L1PetInstance)_npc).getMaster();
			
			if(master != null && master instanceof L1PcInstance) {
				if (isMissingSkillEffect((L1PetInstance)_npc)) {
					_hitRate = 0;
				}
			}
		}
		
		return _hitRate >= _random.nextInt(100) + 1;
	}

	// ER avoidance of judgement
	private boolean calcErEvasion() {
		return _targetPc.getEr() < _random.nextInt(100) + 1;
	}

	/* Damage calculated */
	public int calcDamage() {
		if (_calcType == PC_PC) {
			_damage = calcPcPcDamage();
		} else if (_calcType == PC_NPC) {
			_damage = calcPcNpcDamage();
			if (_pc.getDmgMessages()) {
				_pc.sendPackets(new S_SystemMessage("Damage Dealt:"
						+ String.valueOf(_damage)));
			}
		} else if (_calcType == NPC_PC) {
			_damage = calcNpcPcDamage();
		} else if (_calcType == NPC_NPC) {
			_damage = calcNpcNpcDamage();
		}
		return _damage;
	}

	private double calcPcBaseDamage(boolean small, boolean materialBonus,
			boolean hardSkinned, boolean diceDagger) {
		int weaponMaxDamage = small ? _weaponSmall : _weaponLarge;
		int weaponDamage = 0;
		if (_weaponType == WeaponType.Claw
				&& _random.nextInt(100) + 1 <= _weaponDoubleDmgChance) {
			weaponDamage = weaponMaxDamage;
			_pc.sendAndBroadcast(new S_SkillSound(_pc.getId(), 3671));
		} else if (_weaponType == WeaponType.Fist || isRanged) {
			weaponDamage = 0;
		} else {
			weaponDamage = _random.nextInt(weaponMaxDamage) + 1;
		}

		if (!isRanged && _pc.hasSkillEffect(SOUL_OF_FLAME)) {
			weaponDamage = weaponMaxDamage;
		}

		int weaponTotalDamage = weaponDamage + _weaponAddDmg + _weaponEnchant;

		if (materialBonus)
			weaponTotalDamage += calcMaterialBlessDmg();

		if (_weaponType == WeaponType.Edoryu
				&& (_random.nextInt(100) + 1) <= _weaponDoubleDmgChance) {
			weaponTotalDamage *= 2;
			_pc.sendAndBroadcast(new S_SkillSound(_pc.getId(), 3398));
		}

		weaponTotalDamage += calcAttrEnchantDmg();

		if (_pc.hasSkillEffect(DOUBLE_BRAKE)
				&& (_weaponType == WeaponType.Edoryu || _weaponType == WeaponType.Claw)) {
			if ((_random.nextInt(100) + 1) <= 33) {
				weaponTotalDamage *= 2;
			}
		}

		if ( (_weaponId == GREAT_SWORD_OF_DESTRUCTION || _weaponId == WIND_BLADE_DAGGER) && _random.nextInt(100) + 1 <= 75) {
			weaponTotalDamage += calcDestruction(weaponTotalDamage);
		}

		double damage = weaponTotalDamage
				+ _statusDamage
				+ (isRanged ? _pc.getBowDmgup() + _pc.getOriginalBowDmgup()
						: _pc.getDmgup() + _pc.getOriginalDmgup());

		if (isBow) {
			if (_arrow != null) {
				int arrowDamage = small ? _arrow.getItem().getDmgSmall()
						: _arrow.getItem().getDmgLarge();
				if (arrowDamage == 0)
					arrowDamage = 1;
				if (hardSkinned)
					arrowDamage /= 2;
				damage = damage + _random.nextInt(arrowDamage) + 1;
			} else if (_weaponId == SAYHAS_BOW) {
				damage = damage + _random.nextInt(15) + 1;
			}
		} else if (isGauntlet) {
			int knifeDamage = small ? _sting.getItem().getDmgSmall() : _sting
					.getItem().getDmgLarge();
			if (knifeDamage == 0)
				knifeDamage = 1;
			damage = damage + _random.nextInt(knifeDamage) + 1;
		}

		damage = calcBuffDamage(damage);

		if ((_weaponId == DICE_DAGGER || _weaponId == C_DICE_DAGGER) && diceDagger) {
			damage = L1WeaponSkill.getDiceDaggerDamage(_pc, _target, weapon);
		} else {
			damage += L1WeaponSkill.getWeaponSkillDamage(_pc, _target,
					_weaponId);
		}
		if (_weaponType == WeaponType.Fist) {
			damage = (_random.nextInt(5) + 4) / 4;
		}
		if (isKiringku) {
			damage = L1WeaponSkill.getKiringkuDamage(_pc, _target);
			damage += calcAttrEnchantDmg();
		}

		if (_weaponType2 == WeaponType.Chainsword) {
			if (_pc.isFoeSlayer()) {
				if (_pc.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV3)) {
					damage += 60;
				} else if (_pc.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV2)) {
					damage += 40;
				} else if (_pc.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV1)) {
					damage += 20;
				}
				_pc.setFoeSlayerSuccess(true);
			} else
				revealWeakness();
		}

		damage += isRanged ? _pc.getBowDmgModifierByArmor() : _pc
				.getDmgModifierByArmor();

		damage += getCookingDmgModifier(_pc, isRanged);
		damage += getDollDmgModifier(_pc, isRanged);

		return damage;
	}

	// player from the player to calculate the damage
	public int calcPcPcDamage() {
		double dmg = calcPcBaseDamage(true, false, false, true);

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
		if (_targetPc.hasSkillEffect(IMMUNE_TO_HARM)) {
			dmg /= 2;
		}

		if (isImmune(_targetPc))
			dmg = 0;

		if (dmg <= 0) {
			_isHit = false;
			_drainHp = 0;
		}
		return (int) dmg;
	}

	private int calcPcNpcDamage() {
		boolean small = _targetNpc.getNpcTemplate().get_size()
				.equalsIgnoreCase("small");
		boolean hardSkin = _targetNpc.getNpcTemplate().is_hard();
		
		double dmg = calcPcBaseDamage(small, true, hardSkin, false);

		dmg -= calcNpcDamageReduction();

		boolean isNowWar = false;
		int castleId = L1CastleLocation.getCastleIdByArea(_targetNpc);
		if (castleId > 0) {
			isNowWar = WarTimeController.getInstance().isNowWar(castleId);
		}
		if (isImmune(_targetNpc))
			dmg = 0;

		if (dmg <= 0) {
			_isHit = false;
			_drainHp = 0;
		}
		return (int) dmg;
	}

	private int calcNpcPcDamage() {
		int lvl = _npc.getLevel();
		double dmg = 0D;
		dmg = _random.nextInt(lvl) + _npc.getStr() / 2 + 1;

		if (_npc instanceof L1PetInstance) {
			dmg += (lvl / 10); // Each additional pet is hit LV10
			dmg += ((L1PetInstance) _npc).getDamageByWeapon();
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
		if (_targetPc.hasSkillEffect(IMMUNE_TO_HARM)) {
			dmg /= 2;
		}

		if (isImmune(_targetPc))
			dmg = 0;

		boolean isNowWar = false;
		int castleId = L1CastleLocation.getCastleIdByArea(_targetPc);
		if (castleId > 0) {
			isNowWar = WarTimeController.getInstance().isNowWar(castleId);
		}
		if (!isNowWar) {
			if (_npc instanceof L1PetInstance) {
				dmg /= 2;
			}
		}
		if (dmg <= 0) {
			_isHit = false;
		}
		addNpcPoisonAttack(_npc, _targetPc);
		return (int) dmg;
	}

	private int calcNpcNpcDamage() {
		int level = _npc.getLevel();
		double damage = _random.nextInt(level) + _npc.getStr() / 2 + 1;

		if (_npc instanceof L1PetInstance) {
			damage += (level / 10); // Each additional pet is hit LV10
			damage += ((L1PetInstance) _npc).getDamageByWeapon();
		}

		damage += _npc.getDmgup();

		if (isUndeadDamage()) {
			damage *= 1.1;
		}

		damage = damage * getLeverage() / 10;
		damage -= calcNpcDamageReduction();

		if (_npc.isWeaponBreaked()) {
			damage /= 2;
		}

		addNpcPoisonAttack(_npc, _targetNpc);

		if (isImmune(_targetNpc))
			damage = 0;
		if (damage <= 0) {
			_isHit = false;
		}
		return (int) damage;
	}

	// Magic players to strengthen Damage
	private double calcBuffDamage(double dmg) {
		if (_pc.hasSkillEffect(BURNING_SPIRIT)
				|| (_pc.hasSkillEffect(ELEMENTAL_FIRE) && !isBow && !isGauntlet && !isKiringku)) {
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
		
		if (_pc.hasSkillEffect(BURNING_SLASH)) {
			dmg += 10;
			_pc.sendPackets(new S_EffectLocation(_targetX, _targetY, 6591));
			_pc.broadcastPacket(new S_EffectLocation(_targetX, _targetY, 6591));
			_pc.killSkillEffectTimer(BURNING_SLASH);
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
				&& (undead == 1 || undead == 3 || undead == 5)) { // Mithril
																	// Oriharukon
																	// silver,
																	// and the
																	// curse-the
																	// curse-boss
			damage += _random.nextInt(20) + 1;
		}
		if ((_weaponMaterial == 17 || _weaponMaterial == 22) && undead == 2) {
			damage += _random.nextInt(3) + 1;
		}
		if (_weaponBless == 0 && (undead == 1 || undead == 2 || undead == 3)) { // Weapons
																				// blessing
																				// and
																				// a
																				// curse-the
																				// curse
																				// of
																				// the
																				// devil-boss
																				// system
			damage += _random.nextInt(4) + 1;
		}
		if (_pc.getWeapon() != null && !isRanged
				&& weapon.getHolyDmgByMagic() != 0
				&& (undead == 1 || undead == 3)) {
			damage += weapon.getHolyDmgByMagic();
		}
		return damage;
	}

	private int calcAttrEnchantDmg() {
		if (!Config.ELEMENTAL_ENCHANTING || _weaponAttrEnchantLevel < 1)
			return 0;

		int damage = _weaponAttrEnchantLevel * 2 - 1;

		int resist = 0;
		if (_calcType == PC_PC) {
			if (_weaponAttrEnchantKind == Element.Earth) {
				resist = _targetPc.getEarth();
			} else if (_weaponAttrEnchantKind == Element.Fire) {
				resist = _targetPc.getFire();
			} else if (_weaponAttrEnchantKind == Element.Water) {
				resist = _targetPc.getWater();
			} else if (_weaponAttrEnchantKind == Element.Wind) {
				resist = _targetPc.getWind();
			}
		} else if (_calcType == PC_NPC) {
			if ((_weaponAttrEnchantKind & _targetNpc.getNpcTemplate()
					.get_weakAttr()) == _weaponAttrEnchantKind) {
				resist = -50;
			}
		}

		return (int) (damage * (1 - resist / 100.0));
	}

	private boolean isUndeadDamage() {
		int undead = _npc.getNpcTemplate().get_undead();
		boolean isNight = L1GameTimeClock.getInstance().currentTime().isNight();
		return isNight && (undead == 1 || undead == 3 || undead == 4);
	}

	private void addNpcPoisonAttack(L1Character attacker, L1Character target) {
		if (_npc.getNpcTemplate().get_poisonatk() != 0) {
			if (12 >= _random.nextInt(100) + 1) { // 12% chance of poison
													// attacks
				if (_npc.getNpcTemplate().get_poisonatk() == 1) { // normal
																	// poison
					// Damage period of 5 seconds 3
					L1DamagePoison.doInfection(attacker, target, 3000, 5);
				} else if (_npc.getNpcTemplate().get_poisonatk() == 2) { // Silence
																			// poison
					L1SilencePoison.doInfection(target);
				} else if (_npc.getNpcTemplate().get_poisonatk() == 4) { // Paralytic
																			// poison
					// 20 seconds to 45 seconds paralysis
					L1ParalysisPoison.doInfection(target, 20000, 45000);
				}
			}
		} else if (_npc.getNpcTemplate().get_paralysisatk() != 0) { // Paralysis
																	// in attack
		}
	}

	public void calcStaffOfMana() {
		if (_weaponId == STAFF_OF_MANA || _weaponId == STEEL_STAFF_OF_MANA) {
			// Limit the maximum absorption.
			int som_lvl = _weaponEnchant + 3;
			if (som_lvl < 0) {
				som_lvl = 0;
			}
			// MP sinks to retrieve random
			_drainMana = _random.nextInt(som_lvl) + 1;
			if (_drainMana > Config.MANA_DRAIN_LIMIT_PER_SOM_ATTACK) {
				_drainMana = Config.MANA_DRAIN_LIMIT_PER_SOM_ATTACK;
			}
		}
		/*
		 * Edited to work the same as SOM above. Left in its own if block so we
		 * can easily adjust it later if we decide this is OP
		 */
		else if (_weaponId == DAGGER_OF_MAGIC_POWER) {
			// Limit the maximum absorption.
			int som_lvl = _weaponEnchant + 3;
			if (som_lvl < 0) {
				som_lvl = 0;
			}
			// MP sinks to retrieve random
			_drainMana = _random.nextInt(som_lvl) + 1;
			if (_drainMana > Config.MANA_DRAIN_LIMIT_PER_SOM_ATTACK) {
				_drainMana = Config.MANA_DRAIN_LIMIT_PER_SOM_ATTACK;
			}
		}
	}

	private int calcDestruction(int dmg) {
		_drainHp = Math.max(1, (dmg / 4) + 1);
		return _drainHp;
	}

	// PC poison attacks added
	public void addPcPoisonAttack(L1Character attacker, L1Character target) {
		int chance = _random.nextInt(100) + 1;
		if ((_weaponId == FINGER_OF_DEATH || _weaponId == SWORD_OF_ANCIENT_ELF ||
				(_weaponId != UNARMED && _pc.hasSkillEffect(ENCHANT_VENOM))) && chance <= 10) {
			// Usually poison, 3 second period, HP-5 Damage
			L1DamagePoison.doInfection(attacker, target, 3000, 5);
		}
	}

	public void addChaserAttack() {
		if (_weaponId != THEBES_BOW && _weaponId != THEBES_STAFF &&
				_weaponId != THEBES_SWORD && _weaponId != THEBES_EDORYU)
			return;

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
		if (probability > _random.nextInt(100) + 1) {
			L1Chaser chaser = new L1Chaser(_pc, _target);
			chaser.begin();
		}
	}

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
		if (isBow) {
			if (_arrow != null) {
				_pc.sendAndBroadcast(new S_UseArrowSkill(_pc, _targetId, 66,
						_targetX, _targetY, _isHit));
				_pc.getInventory().removeItem(_arrow, 1);
			} else if (_weaponId == SAYHAS_BOW) {
				_pc.sendAndBroadcast(new S_UseArrowSkill(_pc, _targetId, 2349,
						_targetX, _targetY, _isHit));
			}
		} else if (isGauntlet && _sting != null) {
			_pc.sendAndBroadcast(new S_UseArrowSkill(_pc, _targetId, 2989,
					_targetX, _targetY, _isHit));
			_pc.getInventory().removeItem(_sting, 1);
		} else {
			if (_isHit) {
				_pc.sendAndBroadcast(new S_AttackPacket(_pc, _targetId,
						ActionCodes.ACTION_Attack));
			} else {
				if (_targetId > 0) {
					_pc.sendAndBroadcast(new S_AttackMissPacket(_pc, _targetId));
				} else {
					_pc.sendAndBroadcast(new S_AttackPacket(_pc, 0,
							ActionCodes.ACTION_Attack));
				}
			}
		}
		if (_isHit)
			_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
					_targetId, ActionCodes.ACTION_Damage), _pc);
	}

	// NPC motion attack sent
	private void actionNpc() {
		int _npcObjectId = _npc.getId();
		int bowActId = 0;
		int actId = 0;

		_npc.setHeading(_npc.targetDirection(_targetX, _targetY));
		// The distance between the target and if two or more long-distance
		// attacks
		boolean isLongRange = (_npc.getLocation().getTileLineDistance(
				new Point(_targetX, _targetY)) > 1);
		bowActId = _npc.getNpcTemplate().getBowActId();

		if (getActId() > 0) {
			actId = getActId();
		} else {
			actId = ActionCodes.ACTION_Attack;
		}
		// The distance between two or more of the attacker's arch Action ID if
		// you have far-attack
		if (isLongRange && bowActId > 0) {
			_npc.broadcastPacket(new S_UseArrowSkill(_npc, _targetId, bowActId,
					_targetX, _targetY, _isHit));
		} else {
			if (_isHit) {
				if (getGfxId() > 0) {
					_npc.broadcastPacket(new S_UseAttackSkill(_target,
							_npcObjectId, getGfxId(), _targetX, _targetY, actId));
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

		if (_calcType == NPC_PC || _calcType == PC_PC) { // If the target is a
															// PC
			msg4 = _targetPc.getName();
			msg2 = "HitR" + _hitRate + "% THP" + _targetPc.getCurrentHp();
		} else if (_calcType == PC_NPC) { // If the target is an NPC
			msg4 = _targetNpc.getName();
			msg2 = "Hit" + _hitRate + "% Hp" + _targetNpc.getCurrentHp();
		}
		msg3 = _isHit ? " gave " + _damage : " miss.";

		if (_calcType == PC_PC || _calcType == PC_NPC) { // If the attacker PC
			_pc.sendPackets(new S_ServerMessage(166, msg0, msg1, msg2, msg3,
					msg4));
		}
		if (_calcType == NPC_PC || _calcType == PC_PC) { // If the target is a
															// PC
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
			if (_drainHp > 0) {
				short newHp = (short) (_pc.getCurrentHp() + _drainHp);
				_pc.setCurrentHp(newHp);
			}
			damagePcWeaponDurability();
			_targetPc.receiveDamage(_pc, _damage, false);
		} else if (_calcType == NPC_PC) {
			_targetPc.receiveDamage(_npc, _damage, false);
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
			if (_drainHp > 0) {
				short newHp = (short) (_pc.getCurrentHp() + _drainHp);
				_pc.setCurrentHp(newHp);
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
				_npc.broadcastPacket(new S_UseAttackSkill(_target,
						_npc.getId(), getGfxId(), _targetX, _targetY, actId, 0));
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
			isShortDistance = !isRanged && !isKiringku;
		} else if (_calcType == NPC_PC) {
			boolean isLongRange = (_npc.getLocation().getTileLineDistance(
					new Point(_targetX, _targetY)) > 1);
			int bowActId = _npc.getNpcTemplate().getBowActId();
			// The distance between two or more of the attacker's arch Action ID
			// if you have far-attack
			if (isLongRange && bowActId > 0) {
				isShortDistance = false;
			}
		}
		return isShortDistance;
	}

	public void commitCounterBarrier() {
		int damage = calcCounterBarrierDamage(_targetPc);
		if (damage == 0) {
			return;
		}
		if (_calcType == PC_PC) {
			_pc.receiveDamage(_targetPc, damage, false);
		} else if (_calcType == NPC_PC) {
			_npc.receiveDamage(_targetPc, damage);
			if (_targetPc.getDmgMessages()) {
				_targetPc.sendPackets(new S_SystemMessage("CB Dealt:"
						+ String.valueOf(damage)));
			}
		}
	}

	private static int calcCounterBarrierDamage(final L1PcInstance target) {
		int damage = 0;
		L1ItemInstance weapon = target.getWeapon();
		if (weapon != null) {
			if (weapon.getItem().getType() == 3) { // Two-handed sword
				// (max large damage + bonus damage) * 2
				damage = (weapon.getItem().getDmgLarge()
						+ weapon.getEnchantLevel() + weapon.getItem()
						.getDmgModifier()) * 2;
			}
		}
		
		if(target.hasSkillEffect(IMMUNE_TO_HARM)) {
			damage = damage / 2;
		}
		
		return damage;
	}

	/*
	 * Weapon damage. In the case against the NPC, and a 10 percent chance of
	 * injury. Arms and blessed with 3 percent.
	 */
	private void damageNpcWeaponDurability() {
		int chance = 10;
		int bchance = 3;
		/*
		 * Damage NPC, bare hands, do not damage the use of arms if nothing
		 * else.
		 */
		if (_calcType != PC_NPC
				|| _targetNpc.getNpcTemplate().is_hard() == false
				|| _weaponType == WeaponType.Fist
				|| weapon.getItem().get_canbedmg() == 0
				|| _pc.hasSkillEffect(SOUL_OF_FLAME)) {
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
		// PvP except bare hands, bow, GANTOTORETTO, BAUNSUATAKKU unused nothing
		// if not
		if (_calcType != PC_PC || _weaponType == WeaponType.Fist || isRanged
				|| _targetPc.hasSkillEffect(BOUNCE_ATTACK) == false
				|| _pc.hasSkillEffect(SOUL_OF_FLAME)) {
			return;
		}
		if (_random.nextInt(100) + 1 <= 10) {
			_pc.sendPackets(new S_ServerMessage(268, weapon.getLogName()));
			_pc.getInventory().receiveDamage(weapon);
		}
	}

	private static final S_SkillIconGFX Weakness1 = new S_SkillIconGFX(75, 1);
	private static final S_SkillIconGFX Weakness2 = new S_SkillIconGFX(75, 2);
	private static final S_SkillIconGFX Weakness3 = new S_SkillIconGFX(75, 3);

	private void revealWeakness() {

		int random = _random.nextInt(100) + 1;
		int weaponWeaknessExposureChance = 30;
		if (random <= weaponWeaknessExposureChance) {
			if (_pc.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV3)) {
				// Level 3 duration can not be overwritten
			} else if (_pc.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV2)) {
				_pc.killSkillEffectTimer(STATUS_WEAKNESS_EXPOSURE_LV2);
				_pc.setSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV3, 16000);
				_pc.sendPackets(Weakness3);
			} else if (_pc.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV1)) {
				_pc.killSkillEffectTimer(STATUS_WEAKNESS_EXPOSURE_LV1);
				_pc.setSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV2, 16000);
				_pc.sendPackets(Weakness2);
			} else {
				_pc.setSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV1, 16000);
				_pc.sendPackets(Weakness1);
			}
		}
	}
}
