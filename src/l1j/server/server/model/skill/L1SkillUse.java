/**
 * GPLv2. See License.
 */
package l1j.server.server.model.skill;

import static l1j.server.server.model.item.L1ItemId.BRAVE_STONE;
import static l1j.server.server.model.item.L1ItemId.BRING_STONE;
import static l1j.server.server.model.item.L1ItemId.DARK_STONE;
import static l1j.server.server.model.item.L1ItemId.KAISER_STONE;
import static l1j.server.server.model.item.L1ItemId.WISE_STONE;
import static l1j.server.server.model.skill.L1SkillId.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.model.Element;
import l1j.server.server.model.L1Awake;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1CurseParalysis;
import l1j.server.server.model.L1EffectSpawn;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1Magic;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1PinkName;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1War;
import l1j.server.server.model.L1World;
import l1j.server.server.model.ZoneType;
import l1j.server.server.model.Instance.L1AuctionBoardInstance;
import l1j.server.server.model.Instance.L1BoardInstance;
import l1j.server.server.model.Instance.L1CrownInstance;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1DwarfInstance;
import l1j.server.server.model.Instance.L1EffectInstance;
import l1j.server.server.model.Instance.L1FieldObjectInstance;
import l1j.server.server.model.Instance.L1FurnitureInstance;
import l1j.server.server.model.Instance.L1GuardInstance;
import l1j.server.server.model.Instance.L1HousekeeperInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1MerchantInstance;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.Instance.L1TeleporterInstance;
import l1j.server.server.model.Instance.L1TowerInstance;
import l1j.server.server.model.poison.L1DamagePoison;
import l1j.server.server.model.trap.L1WorldTraps;
import l1j.server.server.random.RandomGenerator;
import l1j.server.server.random.RandomGeneratorFactory;
import l1j.server.server.serverpackets.S_ChangeHeading;
import l1j.server.server.serverpackets.S_ChangeName;
import l1j.server.server.serverpackets.S_ChangeShape;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_ChatPacket;
import l1j.server.server.serverpackets.S_CurseBlind;
import l1j.server.server.serverpackets.S_Dexup;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_DoActionShop;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_Invis;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_NpcChatPacket;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_Paralysis;
import l1j.server.server.serverpackets.S_Poison;
import l1j.server.server.serverpackets.S_RangeSkill;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_ShowPolyList;
import l1j.server.server.serverpackets.S_ShowSummonList;
import l1j.server.server.serverpackets.S_SkillBrave;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillIconAura;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SkillIconShield;
import l1j.server.server.serverpackets.S_SkillIconWaterLife;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_Sound;
import l1j.server.server.serverpackets.S_Strup;
import l1j.server.server.serverpackets.S_TrueTarget;
import l1j.server.server.serverpackets.S_UseAttackSkill;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Skill;
import l1j.server.server.utils.collections.IntArrays;

public class L1SkillUse {
	public static final int TYPE_NORMAL = 0;
	public static final int TYPE_LOGIN = 1;
	public static final int TYPE_SPELLSC = 2;
	public static final int TYPE_NPCBUFF = 3;
	public static final int TYPE_GMBUFF = 4;

	private L1Skill _skill;
	private int _skillId;
	private int _dmg;
	private int _shockStunDuration;
	private int _boneBreakDuration;
	private int _confusionDuration;
	private int _targetID;
	private int _mpConsume = 0;
	private int _hpConsume = 0;
	private int _targetX = 0;
	private int _targetY = 0;
	private String _message = null;
	private int _skillTime = 0;
	private int _type = 0;
	private boolean _isPK = false;
	private int _bookmarkId = 0;
	private int _itemobjid = 0;
	private boolean _checkedUseSkill = false;
	private int _leverage = 10;
	private boolean _isFreeze = false;
	private boolean _isCounterMagic = true;
	private boolean _isGlanceCheckFail = false;

	private L1Character _user = null;
	private L1Character _target = null;

	private L1PcInstance _player = null;
	private L1NpcInstance _npc = null;
	private L1NpcInstance _targetNpc = null;

	private int _calcType;
	private static final int PC_PC = 1;
	private static final int PC_NPC = 2;
	private static final int NPC_PC = 3;
	private static final int NPC_NPC = 4;

	private ArrayList<TargetStatus> _targetList;

	private static Logger _log = Logger.getLogger(L1SkillUse.class.getName());

	private static final int[] CAST_WITH_INVIS = { 1, 2, 3, 5, 8, 9, 12, 13,
			14, 19, 21, 26, 31, 32, 35, 37, 42, 43, 44, 48, 49, 52, 54, 55, 57,
			60, 61, 63, 67, 68, 69, 72, 73, 75, 78, 79, REDUCTION_ARMOR,
			BOUNCE_ATTACK, SOLID_CARRIAGE, COUNTER_BARRIER, 97, 98, 99, 100,
			101, 102, 104, 105, 106, 107, 109, 110, 111, 113, 114, 115, 116,
			117, 118, 129, 130, 131, 133, 134, 137, 138, 146, 147, 148, 149,
			150, 151, 155, 156, 158, 159, 163, 164, 165, 166, 168, 169, 170,
			171, SOUL_OF_FLAME, ADDITIONAL_FIRE, DRAGON_SKIN, AWAKEN_ANTHARAS,
			AWAKEN_FAFURION, AWAKEN_VALAKAS, MIRROR_IMAGE, ILLUSION_OGRE,
			ILLUSION_LICH, PATIENCE, ILLUSION_DIA_GOLEM, INSIGHT,
			ILLUSION_AVATAR };

	private static final int[] EXCEPT_COUNTER_MAGIC = { 1, 2, 3, 5, 8, 9, 12,
			13, 14, 19, 21, 26, 31, 32, 35, 37, 42, 43, 44, 48, 49, 52, 54, 55,
			57, 60, 61, 63, 67, 68, 69, 72, 73, 75, 78, 79, SHOCK_STUN,
			REDUCTION_ARMOR, BOUNCE_ATTACK, SOLID_CARRIAGE, COUNTER_BARRIER,
			97, 98, 99, 100, 101, 102, 104, 105, 106, 107, 109, 110, 111, 113,
			114, 115, 116, 117, 118, 129, 130, 131, 132, 134, 137, 138, 146,
			147, 148, 149, 150, 151, 155, 156, 158, 159, 161, 163, 164, 165,
			166, 168, 169, 170, 171, SOUL_OF_FLAME, ADDITIONAL_FIRE,
			DRAGON_SKIN, FOE_SLAYER, AWAKEN_ANTHARAS, AWAKEN_FAFURION,
			AWAKEN_VALAKAS, MIRROR_IMAGE, ILLUSION_OGRE, ILLUSION_LICH,
			PATIENCE, 10026, 10027, ILLUSION_DIA_GOLEM, INSIGHT,
			ILLUSION_AVATAR, 10028, 10029 };

	private static final int[] CAN_STACK = { HASTE, HOLY_WALK,
			MOVING_ACCELERATION, UNCANNY_DODGE, DRESS_MIGHTY, DRESS_DEXTERITY,
			DRESS_EVASION };

	private static final int[] UNCANCELABLE = { ENCHANT_WEAPON, BLESSED_ARMOR,
			ABSOLUTE_BARRIER, ADVANCE_SPIRIT, SHOCK_STUN, SHADOW_FANG,
			REDUCTION_ARMOR, SOLID_CARRIAGE, COUNTER_BARRIER, AWAKEN_ANTHARAS,
			AWAKEN_FAFURION, AWAKEN_VALAKAS, BONE_BREAK, MASS_SHOCK_STUN,
			CONFUSION };

	private static final int[][] NONOVERLAPPING_SKILLS = {
			// { HOLY_WEAPON, ENCHANT_WEAPON, BLESS_WEAPON, SHADOW_FANG },
			{ FIRE_WEAPON, WIND_SHOT, FIRE_BLESS, STORM_EYE, BURNING_WEAPON,
					STORM_SHOT },
			{ SHIELD, SHADOW_ARMOR, EARTH_SKIN, EARTH_BLESS, IRON_SKIN },
			{ HOLY_WALK, MOVING_ACCELERATION, WIND_WALK, STATUS_BRAVE,
					STATUS_ELFBRAVE, BLOODLUST },
			{ HASTE, GREATER_HASTE, STATUS_HASTE },
			{ PHYSICAL_ENCHANT_DEX, DRESS_DEXTERITY },
			{ PHYSICAL_ENCHANT_STR, DRESS_MIGHTY },
			{ GLOWING_AURA, SHINING_AURA } };

	// Poison, paralysis, polymorphs, and item-targeted spells all get
	// handled separately.
	private static final int[] SEPARATE_TIMERS = { CURSE_POISON,
			CURSE_PARALYZE, CURSE_PARALYZE2, SHAPE_CHANGE, BLESSED_ARMOR,
			HOLY_WEAPON, BLESS_WEAPON, SHADOW_FANG, AWAKEN_ANTHARAS,
			AWAKEN_FAFURION, AWAKEN_VALAKAS, ENCHANT_WEAPON };

	private static final int[] CAST_WITH_SILENCE = { SHOCK_STUN,
			REDUCTION_ARMOR, BOUNCE_ATTACK, SOLID_CARRIAGE, COUNTER_BARRIER };

	private static final S_SkillIconGFX EndRevealWeakness = new S_SkillIconGFX(
			75, 0);

	static {
		Arrays.sort(CAST_WITH_INVIS);
		Arrays.sort(EXCEPT_COUNTER_MAGIC);
		Arrays.sort(UNCANCELABLE);
		Arrays.sort(SEPARATE_TIMERS);
		Arrays.sort(CAST_WITH_SILENCE);
	}

	private static final S_ServerMessage SkillFailed = new S_ServerMessage(280); // The spell failed.

	public L1SkillUse() {
	}

	private static class TargetStatus {
		private L1Character _target = null;
		private boolean _isAction = false;
		private boolean _isSendStatus = false;
		private boolean _isCalc = true;

		public TargetStatus(L1Character _cha) {
			_target = _cha;
		}

		public TargetStatus(L1Character _cha, boolean _flg) {
			_isCalc = _flg;
		}

		public L1Character getTarget() {
			return _target;
		}

		public boolean isCalc() {
			return _isCalc;
		}

		public void isAction(boolean _flg) {
			_isAction = _flg;
		}

		public boolean isAction() {
			return _isAction;
		}

		public void isSendStatus(boolean _flg) {
			_isSendStatus = _flg;
		}

		public boolean isSendStatus() {
			return _isSendStatus;
		}
	}

	public void setLeverage(int i) {
		_leverage = i;
	}

	public int getLeverage() {
		return _leverage;
	}

	private boolean isCheckedUseSkill() {
		return _checkedUseSkill;
	}

	private void setCheckedUseSkill(boolean flg) {
		_checkedUseSkill = flg;
	}

	public boolean checkUseSkill(L1PcInstance player, int skillid,
			int target_id, int x, int y, String message, int time, int type,
			L1Character attacker) {
		setCheckedUseSkill(true);
		_targetList = new ArrayList<TargetStatus>();

		_skill = SkillTable.getInstance().findBySkillId(skillid);
		_skillId = skillid;
		_targetX = x;
		_targetY = y;
		_message = message;
		_skillTime = time;
		_type = type;
		boolean checkedResult = true;

		if (attacker == null) {
			// pc
			_player = player;
			_user = _player;
		} else {
			// npc
			_npc = (L1NpcInstance) attacker;
			_user = _npc;
		}

		if (_skill.getTarget().equals("none")) {
			_targetID = _user.getId();
			_targetX = _user.getX();
			_targetY = _user.getY();
		} else {
			_targetID = target_id;
		}

		if (type == TYPE_NORMAL) {
			checkedResult = isNormalSkillUsable();
		} else if (type == TYPE_SPELLSC) {
			checkedResult = isSpellScrollUsable();
		} else if (type == TYPE_NPCBUFF) {
			checkedResult = true;
		}
		if (!checkedResult) {
			return false;
		}

		if (_skillId == FIRE_WALL || _skillId == LIFE_STREAM) {
			return true;
		}

		L1Object l1object = L1World.getInstance().findObject(_targetID);
		if (l1object instanceof L1ItemInstance) {
			_log.fine("skill target item name: "
					+ ((L1ItemInstance) l1object).getViewName());
			return false;
		}
		if (_user instanceof L1PcInstance) {
			if (l1object instanceof L1PcInstance) {
				_calcType = PC_PC;
			} else {
				_calcType = PC_NPC;
				_targetNpc = (L1NpcInstance) l1object;
			}
		} else if (_user instanceof L1NpcInstance) {
			if (l1object instanceof L1PcInstance) {
				_calcType = NPC_PC;
			} else if (_skill.getTarget().equals("none")) {
				_calcType = NPC_PC;
			} else {
				_calcType = NPC_NPC;
				_targetNpc = (L1NpcInstance) l1object;
			}
		}

		if (_skillId == TELEPORT || _skillId == MASS_TELEPORT) {
			_bookmarkId = target_id;
		}
		if (_skillId == CREATE_MAGICAL_WEAPON || _skillId == PURIFY_STONE
				|| _skillId == BLESSED_ARMOR || _skillId == ENCHANT_WEAPON
				|| _skillId == SHADOW_FANG) {
			_itemobjid = target_id;
		}
		_target = (L1Character) l1object;

		if (!(_target instanceof L1MonsterInstance)
				&& _skill.getTarget().equals("attack")
				&& _user.getId() != target_id) {
			_isPK = true;
		}

		if (!(l1object instanceof L1Character)) {
			checkedResult = false;
		}
		makeTargetList();
		if (_targetList.size() == 0 && (_user instanceof L1NpcInstance)) {
			checkedResult = false;
		}
		return checkedResult;
	}

	private boolean isNormalSkillUsable() {
		if (_user instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) _user;
			L1PcInventory pcInventory = pc.getInventory();

			if (pc.isParalyzed()) {
				return false;
			}
			if ((pc.isInvisble() || pc.isInvisDelay())
					&& !isInvisUsableSkill(_skillId)) {
				return false;
			}
			if (pc.getInventory().getWeight240() >= 197) {
				pc.sendPackets(new S_ServerMessage(316)); // You cannot use the spell while so heavily loaded with baggage.
				return false;
			}
			int polyId = pc.getTempCharGfx();
			L1PolyMorph poly = PolyTable.getInstance().getTemplate(polyId);
			if (poly != null && !poly.canUseSkill()) {
				pc.sendPackets(new S_ServerMessage(285)); // You can't cast a spell in that state.
				return false;
			}

			if (!isAttrAgrees()) {
				return false;
			}

			if (_skillId == ELEMENTAL_PROTECTION && pc.getElfAttr() == 0) {
				pc.sendPackets(new S_ServerMessage(280)); // Magic has failed.
				return false;
			}

			if (_skillId == ELEMENTAL_FALL_DOWN && pc.getElfAttr() == 0) {
				pc.sendPackets(new S_ServerMessage(280)); // Magic has failed.
				return false;
			}

			if (pc.isSkillDelay()) {
				return false;
			}

			if ((pc.hasSkillEffect(SILENCE)
					|| pc.hasSkillEffect(AREA_OF_SILENCE) || pc
						.hasSkillEffect(STATUS_POISON_SILENCE))
					&& !IntArrays.sContains(CAST_WITH_SILENCE, _skillId)) {
				pc.sendPackets(new S_ServerMessage(285)); // You can't cast a spell in that state.
				return false;
			}

			if (_skillId == DISINTEGRATE && pc.getLawful() < 500) {
				pc.sendPackets(new S_ServerMessage(352, "$967")); // Your alignment must be 'Lawful' to cast this spell.
				return false;
			}

			if (_skillId == CUBE_IGNITION || _skillId == CUBE_QUAKE
					|| _skillId == CUBE_SHOCK || _skillId == CUBE_BALANCE) {
				boolean isNearSameCube = false;
				int gfxId = 0;
				for (L1Object obj : L1World.getInstance().getVisibleObjects(pc,
						2)) {
					if (obj instanceof L1EffectInstance) {
						L1EffectInstance effect = (L1EffectInstance) obj;
						gfxId = effect.getGfxId();
						if (_skillId == CUBE_IGNITION && gfxId == 6706
								|| _skillId == CUBE_QUAKE && gfxId == 6712
								|| _skillId == CUBE_SHOCK && gfxId == 6718
								|| _skillId == CUBE_BALANCE && gfxId == 6724) {
							isNearSameCube = true;
							break;
						}
					}
				}
				if (isNearSameCube) {
					pc.sendPackets(new S_ServerMessage(1412)); // The cube is already summoned on the ground.
					return false;
				}
			}

			if (pc.getAwakeSkillId() == AWAKEN_ANTHARAS
					&& _skillId != AWAKEN_ANTHARAS && _skillId != MAGMA_BREATH
					&& _skillId != SHOCK_SKIN && _skillId != FREEZING_BREATH
					|| pc.getAwakeSkillId() == AWAKEN_FAFURION
					&& _skillId != AWAKEN_FAFURION && _skillId != MAGMA_BREATH
					&& _skillId != SHOCK_SKIN && _skillId != FREEZING_BREATH
					|| pc.getAwakeSkillId() == AWAKEN_VALAKAS
					&& _skillId != AWAKEN_VALAKAS && _skillId != MAGMA_BREATH
					&& _skillId != SHOCK_SKIN && _skillId != FREEZING_BREATH) {
				pc.sendPackets(new S_ServerMessage(1385)); // You cannot use awakening magic in the current condition.
				return false;
			}

			if (_skillId == SOLID_CARRIAGE
					&& pcInventory.getTypeEquipped(2, 7) == 0
					&& pcInventory.getTypeEquipped(2, 13) == 0) {
				pc.sendPackets(new S_ServerMessage(1008)); // You cannot cast magic in that condition.
				return false;
			}

			if (isItemConsume() == false && !_player.isGm()) {
				_player.sendPackets(new S_ServerMessage(299)); // There are not enough ingredients to use the spell.
				return false;
			}
		} else if (_user instanceof L1NpcInstance) {
			if (_user.hasSkillEffect(SILENCE)) {
				_user.removeSkillEffect(SILENCE);
				return false;
			}
		}

		if (!isHPMPConsume()) {
			return false;
		}

		return true;
	}

	private boolean isSpellScrollUsable() {
		L1PcInstance pc = (L1PcInstance) _user;

		if (pc.isParalyzed()) {
			return false;
		}

		if ((pc.isInvisble() || pc.isInvisDelay())
				&& !isInvisUsableSkill(_skillId)) {
			return false;
		}

		return true;
	}

	private static boolean isInvisUsableSkill(int skillId) {
		return IntArrays.sContains(CAST_WITH_INVIS, skillId);
	}

	private boolean isStackableSkill() {
		for (int skillId : CAN_STACK) {
			if (skillId == _skillId) {
				return true;
			}
		}
		return false;
	}

	public void handleCommands(L1PcInstance player, int skillId, int targetId,
			int x, int y, String message, int timeSecs, int type) {
		L1Character attacker = null;
		handleCommands(player, skillId, targetId, x, y, message, timeSecs,
				type, attacker);
	}

	public void handleCommands(L1PcInstance player, int skillId, int targetId,
			int x, int y, String message, int timeSecs, int type,
			L1Character attacker) {

		try {
			if (!isCheckedUseSkill()) {
				boolean isUseSkill = checkUseSkill(player, skillId, targetId,
						x, y, message, timeSecs, type, attacker);

				if (!isUseSkill) {
					failSkill();
					return;
				}
			}

			switch (type) { // When casting magic
			case TYPE_NORMAL:
				// Fix for stacking if that option is on
				_skillTime = _skill.getBuffDuration();

				if (Config.STACKING) {
					if (isStackableSkill()) {
						if (_target.hasSkillEffect(_skillId)) {
							_skillTime += _target
									.getSkillEffectTimeSec(_skillId);
						}
						if (_skillTime > 1800) {
							_skillTime = 1800;
						}
					}
				}

				runSkill();
				// this flag is only set to true if running the skill got far
				// enough to check
				// if the target was valid, if not it won't consume
				// HP/MP/reagents
				// Area check to make sure AoE always uses MP.
				if (!_isGlanceCheckFail || _skill.getArea() > 0
						|| _skill.getTarget().equals("none"))
					useConsume();
				sendGrfx(true);
				sendFailMessageHandle();
				setDelay();
				break;
			case TYPE_LOGIN:
				if (_skillId == DECREASE_WEIGHT) {// Fix for DW graphic sent at
													// login
					sendGrfx(false);
				}
				runSkill();
				break;
			case TYPE_GMBUFF:
				runSkill();
				sendGrfx(false);
				break;
			case TYPE_NPCBUFF:
			case TYPE_SPELLSC:
				runSkill();
				sendGrfx(true);
				break;
			default:
				_log.log(Level.SEVERE, "Skill didn't have a handled type!");
			}
			setCheckedUseSkill(false);
		} catch (Exception e) {
			_log.log(Level.SEVERE, "", e);
		}
	}

	private void failSkill() {
		setCheckedUseSkill(false);
		if (_skillId == TELEPORT || _skillId == MASS_TELEPORT
				|| _skillId == TELEPORT_TO_MATHER) {
			_player.sendPackets(new S_Paralysis(
					S_Paralysis.TYPE_TELEPORT_UNLOCK, false));
		}
	}

	private boolean isTarget(L1Character cha) {
		boolean flg = false;

		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			if (pc.isGhost() || pc.isGmInvis()) {
				return false;
			}
		}
		if (_calcType == NPC_PC
				&& (cha instanceof L1PcInstance || cha instanceof L1PetInstance || cha instanceof L1SummonInstance)) {
			flg = true;
		}

		if (cha instanceof L1DoorInstance) {
			if (cha.getMaxHp() == 0 || cha.getMaxHp() == 1) {
				return false;
			}
		}

		if (cha instanceof L1DollInstance && _skillId != HASTE) {
			return false;
		}

		if (_calcType == PC_NPC
				&& _target instanceof L1NpcInstance
				&& !(_target instanceof L1PetInstance)
				&& !(_target instanceof L1SummonInstance)
				&& (cha instanceof L1PetInstance
						|| cha instanceof L1SummonInstance || cha instanceof L1PcInstance)) {
			return false;
		}

		if (_calcType == PC_NPC && _target instanceof L1NpcInstance
				&& !(_target instanceof L1GuardInstance)
				&& cha instanceof L1GuardInstance) {
			return false;
		}

		if ((_skill.getTarget().equals("attack") || _skill.getType() == L1Skill.TYPE_ATTACK)
				&& _calcType == NPC_PC
				&& !(cha instanceof L1PetInstance)
				&& !(cha instanceof L1SummonInstance)
				&& !(cha instanceof L1PcInstance)) {
			return false;
		}

		if ((_skill.getTarget().equals("attack") || _skill.getType() == L1Skill.TYPE_ATTACK)
				&& _calcType == NPC_NPC
				&& _user instanceof L1MonsterInstance
				&& cha instanceof L1MonsterInstance) {
			return false;
		}

		if (_skill.getTarget().equals("none")
				&& _skill.getType() == L1Skill.TYPE_ATTACK
				&& (cha instanceof L1AuctionBoardInstance
						|| cha instanceof L1BoardInstance
						|| cha instanceof L1CrownInstance
						|| cha instanceof L1DwarfInstance
						|| cha instanceof L1EffectInstance
						|| cha instanceof L1FieldObjectInstance
						|| cha instanceof L1FurnitureInstance
						|| cha instanceof L1HousekeeperInstance
						|| cha instanceof L1MerchantInstance || cha instanceof L1TeleporterInstance)) {
			return false;
		}

		if (_skill.getType() == L1Skill.TYPE_ATTACK
				&& cha.getId() == _user.getId()) {
			return false;
		}

		if (cha.getId() == _user.getId() && _skillId == HEAL_ALL) {
			return false;
		}

		int targetTo = _skill.getTargetTo();
		if (((targetTo & L1Skill.TARGET_TO_PC) == L1Skill.TARGET_TO_PC
				|| (targetTo & L1Skill.TARGET_TO_CLAN) == L1Skill.TARGET_TO_CLAN || (targetTo & L1Skill.TARGET_TO_PARTY) == L1Skill.TARGET_TO_PARTY)
				&& cha.getId() == _user.getId() && _skillId != HEAL_ALL) {
			return true;
		}

		if (_user instanceof L1PcInstance
				&& (_skill.getTarget().equals("attack") || _skill.getType() == L1Skill.TYPE_ATTACK)
				&& _isPK == false) {
			if (cha instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) cha;
				if (_player.getId() == summon.getMaster().getId()) {
					return false;
				}
			} else if (cha instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) cha;
				if (_player.getId() == pet.getMaster().getId()) {
					return false;
				}
			}
		}

		if ((_skill.getTarget().equals("attack") || _skill.getType() == L1Skill.TYPE_ATTACK)
				&& !(cha instanceof L1MonsterInstance)
				&& _isPK == false
				&& _target instanceof L1PcInstance) {
			L1PcInstance enemy = (L1PcInstance) cha;
			if (_skillId == COUNTER_DETECTION
					&& enemy.getZoneType() != ZoneType.Safety
					&& (cha.hasSkillEffect(INVISIBILITY) || cha
							.hasSkillEffect(BLIND_HIDING))) {
				return true;
			}
			if (_player.getClanid() != 0 && enemy.getClanid() != 0) {
				for (L1War war : L1World.getInstance().getWarList()) {
					if (war.CheckClanInWar(_player.getClanname())) {
						if (war.CheckClanInSameWar(_player.getClanname(),
								enemy.getClanname())) {
							if (L1CastleLocation.checkInAllWarArea(
									enemy.getX(), enemy.getY(),
									enemy.getMapId())) {
								return true;
							}
						}
					}
				}
			}
			return false;
		}

		if (_user.glanceCheck(cha.getX(), cha.getY()) == false
				&& _skill.isThrough() == false) {
			if (!(_skill.getType() == L1Skill.TYPE_CHANGE || _skill.getType() == L1Skill.TYPE_RESTORE)) {
				_isGlanceCheckFail = true;
				return false;
			}
		}

		if (_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD
				|| _skillId == FREEZING_BREATH)
			if (cha.hasSkillEffect(ICE_LANCE)
					|| cha.hasSkillEffect(FREEZING_BREATH)
					|| cha.hasSkillEffect(FREEZING_BLIZZARD))
				return false;

		if ((_skillId == EARTH_BIND || _skillId == BONE_BREAK
				|| _skillId == CONFUSION || _skillId == ARM_BREAKER)
				&& cha.hasSkillEffect(EARTH_BIND))
			return false;

		if (cha.hasSkillEffect(FOG_OF_SLEEPING) && _skillId == PHANTASM) {
			return false;
		}

		if (cha.hasSkillEffect(PHANTASM) && _skillId == FOG_OF_SLEEPING) {
			return false;
		}

		if (!(cha instanceof L1MonsterInstance)
				&& (_skillId == TAMING_MONSTER || _skillId == CREATE_ZOMBIE)) {
			return false;
		}
		if (cha.isDead()
				&& (_skillId != CREATE_ZOMBIE && _skillId != RESURRECTION
						&& _skillId != GREATER_RESURRECTION && _skillId != CALL_OF_NATURE)) {
			return false;
		}

		if (cha.isDead() == false
				&& (_skillId == CREATE_ZOMBIE || _skillId == RESURRECTION
						|| _skillId == GREATER_RESURRECTION || _skillId == CALL_OF_NATURE)) {
			return false;
		}

		if ((cha instanceof L1TowerInstance || cha instanceof L1DoorInstance)
				&& (_skillId == CREATE_ZOMBIE || _skillId == RESURRECTION
						|| _skillId == GREATER_RESURRECTION || _skillId == CALL_OF_NATURE)) {
			return false;
		}

		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			if (pc.hasSkillEffect(ABSOLUTE_BARRIER)) {
				if (_skillId == CURSE_BLIND || _skillId == WEAPON_BREAK
						|| _skillId == DARKNESS || _skillId == WEAKNESS
						|| _skillId == DISEASE || _skillId == FOG_OF_SLEEPING
						|| _skillId == MASS_SLOW || _skillId == SLOW
						|| _skillId == CANCELLATION || _skillId == SILENCE
						|| _skillId == DECAY_POTION
						|| _skillId == MASS_TELEPORT || _skillId == DETECTION
						|| _skillId == DARK_BLIND
						|| _skillId == COUNTER_DETECTION
						|| _skillId == ERASE_MAGIC || _skillId == ENTANGLE
						|| _skillId == PHYSICAL_ENCHANT_DEX
						|| _skillId == PHYSICAL_ENCHANT_STR
						|| _skillId == BLESS_WEAPON || _skillId == EARTH_SKIN
						|| _skillId == IMMUNE_TO_HARM
						|| _skillId == REMOVE_CURSE) {
					return true;
				} else {
					return false;
				}
			}
		}

		if (cha instanceof L1NpcInstance) {
			int hiddenStatus = ((L1NpcInstance) cha).getHiddenStatus();
			if (hiddenStatus == L1NpcInstance.HIDDEN_STATUS_SINK) {
				if (_skillId == DETECTION || _skillId == COUNTER_DETECTION) {
					return true;
				} else {
					return false;
				}
			} else if (hiddenStatus == L1NpcInstance.HIDDEN_STATUS_FLY) {
				return false;
			}
		}

		if ((targetTo & L1Skill.TARGET_TO_PC) == L1Skill.TARGET_TO_PC
				&& cha instanceof L1PcInstance) {
			flg = true;
		} else if ((targetTo & L1Skill.TARGET_TO_NPC) == L1Skill.TARGET_TO_NPC
				&& (cha instanceof L1MonsterInstance
						|| cha instanceof L1NpcInstance
						|| cha instanceof L1SummonInstance || cha instanceof L1PetInstance)) {
			flg = true;
		} else if ((targetTo & L1Skill.TARGET_TO_PET) == L1Skill.TARGET_TO_PET
				&& _user instanceof L1PcInstance) {
			if (cha instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) cha;
				if (summon.getMaster() != null) {
          // Steve_: added another clause so RTN can get a greenlight on L893
					if (_player.getId() == summon.getMaster().getId() || _skillId == RETURN_TO_NATURE) {
						flg = true;
					}
				}
			}
			if (cha instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) cha;
				if (pet.getMaster() != null) {
					if (_player.getId() == pet.getMaster().getId()) {
						flg = true;
					}
				}
			}
		}

		if (_calcType == PC_PC && cha instanceof L1PcInstance) {
			if ((targetTo & L1Skill.TARGET_TO_CLAN) == L1Skill.TARGET_TO_CLAN
					&& ((_player.getClanid() != 0 && _player.getClanid() == ((L1PcInstance) cha)
							.getClanid()) || _player.isGm())) {
				return true;
			}
			if ((targetTo & L1Skill.TARGET_TO_PARTY) == L1Skill.TARGET_TO_PARTY
					&& (_player.getParty().isMember((L1PcInstance) cha) || _player
							.isGm())) {
				return true;
			}
		}

		return flg;
	}

	private void makeTargetList() {
		try {
			if (_type == TYPE_LOGIN) {
				_targetList.add(new TargetStatus(_user));
				return;
			}
			if (_skill.getTargetTo() == L1Skill.TARGET_TO_ME
					&& (_skill.getType() & L1Skill.TYPE_ATTACK) != L1Skill.TYPE_ATTACK) {
				_targetList.add(new TargetStatus(_user));
				return;
			}

			if (_skill.getRanged() != -1) {
				if (_user.getLocation().getTileLineDistance(
						_target.getLocation()) > _skill.getRanged()) {
					return;
				}
			} else {
				if (!_user.getLocation().isInScreen(_target.getLocation())) {
					return;
				}
			}

			if (isTarget(_target) == false
					&& !(_skill.getTarget().equals("none"))) {
				return;
			}

			if (_skillId == LIGHTNING || _skillId == FREEZING_BREATH) {
				ArrayList<L1Object> al1object = L1World.getInstance()
						.getVisibleLineObjects(_user, _target);

				for (L1Object tgobj : al1object) {
					if (tgobj == null) {
						continue;
					}
					if (!(tgobj instanceof L1Character)) {
						continue;
					}
					L1Character cha = (L1Character) tgobj;
					if (isTarget(cha) == false) {
						continue;
					}
					_targetList.add(new TargetStatus(cha));
				}
				return;
			}

			if (_skill.getArea() == 0) {
				if (!_user.glanceCheck(_target.getX(), _target.getY())) {
					if ((_skill.getType() & L1Skill.TYPE_ATTACK) == L1Skill.TYPE_ATTACK
							&& _skillId != 10026
							&& _skillId != 10027
							&& _skillId != 10028 && _skillId != 10029) {
						_targetList.add(new TargetStatus(_target, false));
						return;
					}
				}
				_targetList.add(new TargetStatus(_target));
			} else {
				if (!_skill.getTarget().equals("none")) {
					_targetList.add(new TargetStatus(_target));
				}

				if (_skillId != 49
						&& !(_skill.getTarget().equals("attack") || _skill
								.getType() == L1Skill.TYPE_ATTACK)) {
					_targetList.add(new TargetStatus(_user));
				}

				List<L1Object> objects;
				if (_skill.getArea() == -1) {
					objects = L1World.getInstance().getVisibleObjects(_user);
				} else {
					objects = L1World.getInstance().getVisibleObjects(_target,
							_skill.getArea());
				}
				for (L1Object tgobj : objects) {
					if (tgobj == null) {
						continue;
					}
					if (!(tgobj instanceof L1Character)) {
						continue;
					}
					L1Character cha = (L1Character) tgobj;
					if (!isTarget(cha)) {
						continue;
					}

					_targetList.add(new TargetStatus(cha));
				}
				return;
			}

		} catch (Exception e) {
			_log.finest("exception in L1Skilluse makeTargetList" + e);
		}
	}

	private void sendHappenMessage(L1PcInstance pc) {
		int msgID = _skill.getSysmsgIdHappen();
		// Added some fixes for various happen messages
		if (msgID == 161) { // TODO
			if (_skillId == BLESSED_ARMOR || _skillId == ENCHANT_WEAPON) { // happen
																			// message
																			// not
																			// needed
																			// here
																			// now
				return;
			} else if ((_skillId == BLESS_WEAPON || _skillId == HOLY_WEAPON)
					&& pc != null) {
				L1ItemInstance weapon = pc.getWeapon();
				String weaponString = "";
				if (weapon != null) {
					weaponString = weapon.getName();
				} else {
					weaponString = "hands";
				}
				pc.sendPackets(new S_ServerMessage(msgID, weaponString, "blue",
						"short while"));
			} else {// Have to get other fixes here for items that are not
					// selected
				pc.sendPackets(new S_ServerMessage(msgID));
			}
		} else if (msgID > 0) {
			pc.sendPackets(new S_ServerMessage(msgID));
		}
	}

	private void sendFailMessageHandle() {
		if (_skill.getType() != L1Skill.TYPE_ATTACK
				&& !_skill.getTarget().equals("none")
				&& _targetList.size() == 0) {
			sendFailMessage();
		}
	}

	private void sendFailMessage() {
		int msgID = _skill.getSysmsgIdFail();
		if (msgID > 0 && (_user instanceof L1PcInstance)) {
			_player.sendPackets(new S_ServerMessage(msgID));
		}
	}

	private boolean isAttrAgrees() {
		int magicattr = _skill.getAttr();
		if (_user instanceof L1NpcInstance) {
			return true;
		}

		if (_skill.getSkillLevel() >= 17 && _skill.getSkillLevel() <= 22
				&& magicattr != 0 && magicattr != _player.getElfAttr()
				&& !_player.isGm()) {
			return false;
		}

		return true;
	}

	private boolean isHPMPConsume() {
		_mpConsume = _skill.getMpConsume();
		_hpConsume = _skill.getHpConsume();
		int currentMp = 0;
		int currentHp = 0;

		if (_user instanceof L1NpcInstance) {
			currentMp = _npc.getCurrentMp();
			currentHp = _npc.getCurrentHp();
		} else {
			currentMp = _player.getCurrentMp();
			currentHp = _player.getCurrentHp();

			int intelligence = _player.getInt();
			if (_skillId <= FREEZING_BLIZZARD) {
				if (intelligence > 12 && _skillId > HOLY_WEAPON)
					_mpConsume--;
				if (intelligence > 13 && _skillId > STALAC)
					_mpConsume--;
				if (intelligence > 14 && _skillId > WEAK_ELEMENTAL)
					_mpConsume--;
				if (intelligence > 15 && _skillId > MEDITATION)
					_mpConsume--;
				if (intelligence > 16 && _skillId > DARKNESS)
					_mpConsume--;
				if (intelligence > 17 && _skillId > BLESS_WEAPON)
					_mpConsume--;
				if (intelligence > 18 && _skillId > DISEASE)
					_mpConsume--;
				if (intelligence > 22 && _skillId > SILENCE)
					_mpConsume--;
				if (intelligence > 26 && _skillId > COUNTER_DETECTION)
					_mpConsume--;
			}

			if (intelligence > 12 && _skillId >= SHOCK_STUN
					&& _skillId <= COUNTER_BARRIER) {
				_mpConsume -= (intelligence - 12);
			}

			L1PcInventory inventory = _player.getInventory();
			if ((_skillId == PHYSICAL_ENCHANT_DEX || _skillId == HASTE)
					&& inventory.checkEquipped(20013)) {
				_mpConsume /= 2;
			}
			if ((_skillId == HEAL || _skillId == EXTRA_HEAL)
					&& inventory.checkEquipped(20014)) {
				_mpConsume /= 2;
			}
			if ((_skillId == ENCHANT_WEAPON || _skillId == DETECTION || _skillId == PHYSICAL_ENCHANT_STR)
					&& inventory.checkEquipped(20015)) {
				_mpConsume /= 2;
			}
			if (_skillId == HASTE && inventory.checkEquipped(20008)) {
				_mpConsume /= 2;
			}
			if (_skillId == GREATER_HASTE && inventory.checkEquipped(20023)) {
				_mpConsume /= 2;
			}

			if (0 < _skill.getMpConsume()) {
				_mpConsume -= _player.getOriginalMagicConsumeReduction();
				_mpConsume = Math.max(_mpConsume, 1);
			}
		}

		if (currentHp < _hpConsume + 1) {
			if (_user instanceof L1PcInstance) {
				_player.sendPackets(new S_ServerMessage(279)); // You don't have enough HP to use the spell.
			}
			return false;
		} else if (currentMp < _mpConsume) {
			if (_user instanceof L1PcInstance) {
				_player.sendPackets(new S_ServerMessage(278)); // You don't have enough MP to use the spell.
			}
			return false;
		}

		return true;
	}

	private boolean isItemConsume() {
		int itemConsume = _skill.getItemConsumeId();
		int itemConsumeCount = _skill.getItemConsumeCount();

		if (itemConsume == 0) {
			return true;
		}

		if (!_player.getInventory().checkItem(itemConsume, itemConsumeCount)) {
			return false;
		}

		return true;
	}

	private void useConsume() {
		if (_user instanceof L1NpcInstance) {
			int current_hp = _npc.getCurrentHp() - _hpConsume;
			_npc.setCurrentHp(current_hp);

			int current_mp = _npc.getCurrentMp() - _mpConsume;
			_npc.setCurrentMp(current_mp);
			return;
		}

		if (isHPMPConsume()) {
			if (_skillId == FINAL_BURN) {
				_player.setCurrentHp(1);
				_player.setCurrentMp(0);
			} else {
				int current_hp = _player.getCurrentHp() - _hpConsume;
				_player.setCurrentHp(current_hp);

				int current_mp = _player.getCurrentMp() - _mpConsume;
				_player.setCurrentMp(current_mp);
			}
		}

		int lawful = _player.getLawful() + _skill.getLawful();
		if (lawful > 32767) {
			lawful = 32767;
		}
		if (lawful < -32767) {
			lawful = -32767;
		}
		_player.setLawful(lawful);

		int itemConsume = _skill.getItemConsumeId();
		int itemConsumeCount = _skill.getItemConsumeCount();

		if (itemConsume == 0) {
			return;
		}

		_player.getInventory().consumeItem(itemConsume, itemConsumeCount);
	}

	private void addMagicList(L1Character cha, boolean repetition) {
		int buffDuration;
		if (_skillTime == 0) {
			buffDuration = _skill.getBuffDuration() * 1000;
			if (_skill.getBuffDuration() == 0) {
				if (_skillId == INVISIBILITY) {
					cha.setSkillEffect(INVISIBILITY, 0);
				}
				return;
			}
		} else {
			buffDuration = _skillTime * 1000;
		}

		if (_skillId == SHOCK_STUN || _skillId == MASS_SHOCK_STUN) {
			buffDuration = _shockStunDuration;
		}

		if (_skillId == CURSE_POISON) { //
			return;
		}
		if (_skillId == CURSE_PARALYZE || _skillId == CURSE_PARALYZE2) {
			return;
		}
		if (_skillId == SHAPE_CHANGE) { //
			return;
		}
		if (!(cha instanceof L1PcInstance)
				&& (_skillId == CURSE_BLIND || _skillId == DARKNESS || _skillId == DARK_BLIND)) { // BCM:
																									// fix
																									// darkness
																									// exploit
			return;
		}
		if (_skillId == BLESSED_ARMOR || _skillId == HOLY_WEAPON
				|| _skillId == ENCHANT_WEAPON || _skillId == BLESS_WEAPON
				|| _skillId == SHADOW_FANG) {
			return;
		}
		if ((_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD || _skillId == FREEZING_BREATH)
				&& !_isFreeze) {
			return;
		}
		if (_skillId == AWAKEN_ANTHARAS || _skillId == AWAKEN_FAFURION
				|| _skillId == AWAKEN_VALAKAS) {
			return;
		}
		if (_skillId == CONFUSION) {
			buffDuration = _confusionDuration;
		}

		if (IntArrays.sContains(SEPARATE_TIMERS, _skillId))
			return;

		cha.setSkillEffect(_skillId, buffDuration);

		if (cha instanceof L1PcInstance && repetition) {
			L1PcInstance pc = (L1PcInstance) cha;
			sendIcon(pc);
		}
	}

	private void sendIcon(L1PcInstance pc) {
		int buffIconDuration = _skillTime == 0 ? _skill.getBuffDuration()
				: _skillTime;

		switch (_skillId) {
		case SHIELD:
			pc.sendPackets(new S_SkillIconShield(5, buffIconDuration));
			break;
		case SHADOW_ARMOR:
			pc.sendPackets(new S_SkillIconShield(3, buffIconDuration));
			break;
		case DRESS_DEXTERITY:
			pc.sendPackets(new S_Dexup(pc, 2, buffIconDuration));
			break;
		case DRESS_MIGHTY:
			pc.sendPackets(new S_Strup(pc, 2, buffIconDuration));
			break;
		case GLOWING_AURA:
			pc.sendPackets(new S_SkillIconAura(113, buffIconDuration));
			break;
		case SHINING_AURA:
			pc.sendPackets(new S_SkillIconAura(114, buffIconDuration));
			break;
		case BRAVE_AURA:
			pc.sendPackets(new S_SkillIconAura(116, buffIconDuration));
			break;
		case FIRE_WEAPON:
			pc.sendPackets(new S_SkillIconAura(147, buffIconDuration));
			break;
		case WIND_SHOT:
			pc.sendPackets(new S_SkillIconAura(148, buffIconDuration));
			break;
		case FIRE_BLESS:
			pc.sendPackets(new S_SkillIconAura(154, buffIconDuration));
			break;
		case STORM_EYE:
			pc.sendPackets(new S_SkillIconAura(155, buffIconDuration));
			break;
		case EARTH_BLESS:
			pc.sendPackets(new S_SkillIconShield(7, buffIconDuration));
			break;
		case BURNING_WEAPON:
			pc.sendPackets(new S_SkillIconAura(162, buffIconDuration));
			break;
		case STORM_SHOT:
			pc.sendPackets(new S_SkillIconAura(165, buffIconDuration));
			break;
		case IRON_SKIN:
			pc.sendPackets(new S_SkillIconShield(10, buffIconDuration));
			break;
		case EARTH_SKIN:
			pc.sendPackets(new S_SkillIconShield(6, buffIconDuration));
			break;
		case PHYSICAL_ENCHANT_STR:
			pc.sendPackets(new S_Strup(pc, 5, buffIconDuration));
			break;
		case PHYSICAL_ENCHANT_DEX:
			pc.sendPackets(new S_Dexup(pc, 5, buffIconDuration));
			break;
		case HASTE:
		case GREATER_HASTE:
			pc.sendPackets(new S_SkillHaste(pc.getId(), 1, buffIconDuration));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1, 0));
			break;
		case HOLY_WALK:
		case MOVING_ACCELERATION:
		case WIND_WALK:
			pc.sendPackets(new S_SkillBrave(pc.getId(), 4, buffIconDuration));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 4, 0));
			break;
		case BLOODLUST:
			pc.sendPackets(new S_SkillBrave(pc.getId(), 6, buffIconDuration));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 6, 0));
			break;
		case SLOW:
		case MASS_SLOW:
		case ENTANGLE:
			pc.sendPackets(new S_SkillHaste(pc.getId(), 2, buffIconDuration));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 2, 0));
			break;
		case IMMUNE_TO_HARM:
			pc.sendPackets(new S_SkillIconGFX(40, buffIconDuration));
			break;
		default:
			pc.sendPackets(new S_OwnCharStatus(pc));
		}
	}

	private void sendGrfx(boolean isSkillAction) {
		int actionId = _skill.getActionId();
		int castgfx = _skill.getCastGfx();
		if (castgfx == 0) {
			return;
		}

		if (_user instanceof L1PcInstance) {
			if (_skillId == FIRE_WALL || _skillId == LIFE_STREAM) {
				L1PcInstance pc = (L1PcInstance) _user;
				if (_skillId == FIRE_WALL) {
					pc.setHeading(pc.targetDirection(_targetX, _targetY));
					pc.sendPackets(new S_ChangeHeading(pc));
					pc.broadcastPacket(new S_ChangeHeading(pc));
				}
				S_DoActionGFX gfx = new S_DoActionGFX(pc.getId(), actionId);
				pc.sendPackets(gfx);
				pc.broadcastPacket(gfx);
				return;
			}

			int targetid = _target.getId();

			if (_skillId == SHOCK_STUN || _skillId == MASS_SHOCK_STUN) {
				if (_targetList.size() == 0) {
					return;
				} else {
					if (_target instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) _target;
						pc.sendPackets(new S_SkillSound(pc.getId(), 4434));
						pc.broadcastPacket(new S_SkillSound(pc.getId(), 4434));
					} else if (_target instanceof L1NpcInstance) {
						_target.broadcastPacket(new S_SkillSound(_target
								.getId(), 4434));
					}
					return;
				}
			}

			if (_skillId == BONE_BREAK) {
				return;
			}

			if (_skillId == SMASH) {
				return;
			}

			if (_skillId == ARM_BREAKER) {
				return;
			}

			if (_skillId == LIGHT) {
				L1PcInstance pc = (L1PcInstance) _target;
				pc.sendPackets(new S_Sound(145));
			}

			if (_targetList.size() == 0 && !(_skill.getTarget().equals("none"))) {
				int tempchargfx = _player.getTempCharGfx();
				if (tempchargfx == 5727 || tempchargfx == 5730) {
					actionId = ActionCodes.ACTION_SkillBuff;
				} else if (tempchargfx == 5733 || tempchargfx == 5736) {
					actionId = ActionCodes.ACTION_Attack;
				}
				if (isSkillAction) {
					S_DoActionGFX gfx = new S_DoActionGFX(_player.getId(),
							actionId);
					_player.sendPackets(gfx);
					_player.broadcastPacket(gfx);
				}
				return;
			}

			if (_skill.getTarget().equals("attack") && _skillId != 18) {
				if (isPcSummonPet(_target)) {
					if (_player.getZoneType() == ZoneType.Safety
							|| _target.getZoneType() == ZoneType.Safety
							|| _player.checkNonPvP(_player, _target)) {
						_player.sendPackets(new S_UseAttackSkill(_player, 0,
								castgfx, _targetX, _targetY, actionId));
						_player.broadcastPacket(new S_UseAttackSkill(_player,
								0, castgfx, _targetX, _targetY, actionId));
						return;
					}
				}
				if (_skill.getArea() == 0) {
					if (_skillId == MIND_BREAK || _skillId == CONFUSION
							|| _skillId == JOY_OF_PAIN) {
						_player.sendPackets(new S_SkillSound(targetid, castgfx));
						_player.broadcastPacket(new S_SkillSound(targetid,
								castgfx));
						S_DoActionGFX gfx = new S_DoActionGFX(_player.getId(),
								actionId);
						_player.sendPackets(gfx);
						_player.broadcastPacket(gfx);
					} else {
						_player.sendPackets(new S_UseAttackSkill(_player,
								targetid, castgfx, _targetX, _targetY, actionId));
						_player.broadcastPacket(new S_UseAttackSkill(_player,
								targetid, castgfx, _targetX, _targetY, actionId));
						_target.broadcastPacketExceptTargetSight(
								new S_DoActionGFX(targetid,
										ActionCodes.ACTION_Damage), _player);
					}
				} else {
					L1Character[] cha = new L1Character[_targetList.size()];
					int i = 0;
					for (TargetStatus ts : _targetList) {
						cha[i] = ts.getTarget();
						i++;
					}
					_player.sendPackets(new S_RangeSkill(_player, cha, castgfx,
							actionId, S_RangeSkill.TYPE_DIR));
					_player.broadcastPacket(new S_RangeSkill(_player, cha,
							castgfx, actionId, S_RangeSkill.TYPE_DIR));
				}
			} else if (_skill.getTarget().equals("none")
					&& _skill.getType() == L1Skill.TYPE_ATTACK) {
				L1Character[] cha = new L1Character[_targetList.size()];
				int i = 0;
				for (TargetStatus ts : _targetList) {
					cha[i] = ts.getTarget();
					cha[i].broadcastPacketExceptTargetSight(new S_DoActionGFX(
							cha[i].getId(), ActionCodes.ACTION_Damage), _player);
					i++;
				}
				_player.sendPackets(new S_RangeSkill(_player, cha, castgfx,
						actionId, S_RangeSkill.TYPE_NODIR));
				_player.broadcastPacket(new S_RangeSkill(_player, cha, castgfx,
						actionId, S_RangeSkill.TYPE_NODIR));
			} else {
				if (_skillId != 5 && _skillId != 69 && _skillId != 131) {
					if (isSkillAction && _skillId != BURNING_SLASH) {
						S_DoActionGFX gfx = new S_DoActionGFX(_player.getId(),
								_skill.getActionId());
						_player.sendPackets(gfx);
						_player.broadcastPacket(gfx);
					}
					if (_skillId == COUNTER_MAGIC
							|| _skillId == COUNTER_BARRIER
							|| _skillId == COUNTER_MIRROR) {
						_player.sendPackets(new S_SkillSound(targetid, castgfx));
					} else if (_skillId == TRUE_TARGET) {
						return;
					} else if (_skillId == DECREASE_WEIGHT && isSkillAction) {
						// I think this was a custom fix.
						_player.sendPackets(new S_SkillSound(targetid, _skill
								.getCastGfx()));
						_player.broadcastPacket(new S_SkillSound(targetid,
								_skill.getCastGfx()));
					} else if (_skillId == AWAKEN_ANTHARAS
							|| _skillId == AWAKEN_FAFURION
							|| _skillId == AWAKEN_VALAKAS) {
						if (_skillId == _player.getAwakeSkillId()) {
							_player.sendPackets(new S_SkillSound(targetid,
									castgfx));
							_player.broadcastPacket(new S_SkillSound(targetid,
									castgfx));
						} else {
							return;
						}
					} else {
						_player.sendPackets(new S_SkillSound(targetid, castgfx));
						_player.broadcastPacket(new S_SkillSound(targetid,
								castgfx));
					}
				}

				for (TargetStatus ts : _targetList) {
					L1Character cha = ts.getTarget();
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_OwnCharStatus(pc));
					}
				}
			}
		} else if (_user instanceof L1NpcInstance) {
			int targetid = _target.getId();

			if (_user instanceof L1MerchantInstance) {
				_user.broadcastPacket(new S_SkillSound(targetid, castgfx));
				return;
			}

			if (_targetList.size() == 0 && !(_skill.getTarget().equals("none"))) {
				S_DoActionGFX gfx = new S_DoActionGFX(_user.getId(),
						_skill.getActionId());
				_user.broadcastPacket(gfx);
				return;
			}

			if (_skill.getTarget().equals("attack") && _skillId != 18) {
				if (_skill.getArea() == 0) {
					_user.broadcastPacket(new S_UseAttackSkill(_user, targetid,
							castgfx, _targetX, _targetY, actionId));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							targetid, ActionCodes.ACTION_Damage), _user);
				} else {
					L1Character[] cha = new L1Character[_targetList.size()];
					int i = 0;
					for (TargetStatus ts : _targetList) {
						cha[i] = ts.getTarget();
						cha[i].broadcastPacketExceptTargetSight(
								new S_DoActionGFX(cha[i].getId(),
										ActionCodes.ACTION_Damage), _user);
						i++;
					}
					_user.broadcastPacket(new S_RangeSkill(_user, cha, castgfx,
							actionId, S_RangeSkill.TYPE_DIR));
				}
			} else if (_skill.getTarget().equals("none")
					&& _skill.getType() == L1Skill.TYPE_ATTACK) {
				L1Character[] cha = new L1Character[_targetList.size()];
				int i = 0;
				for (TargetStatus ts : _targetList) {
					cha[i] = ts.getTarget();
					i++;
				}
				_user.broadcastPacket(new S_RangeSkill(_user, cha, castgfx,
						actionId, S_RangeSkill.TYPE_NODIR));
			} else {
				if (_skillId != 5 && _skillId != 69 && _skillId != 131) {
					S_DoActionGFX gfx = new S_DoActionGFX(_user.getId(),
							_skill.getActionId());
					_user.broadcastPacket(gfx);
					_user.broadcastPacket(new S_SkillSound(targetid, castgfx));
				}
			}
		}
	}

	private void deleteRepeatedSkills(L1Character cha) {
		for (int[] skills : NONOVERLAPPING_SKILLS) {
			for (int id : skills) {
				if (id == _skillId) {
					stopSkillList(cha, skills);
				}
			}
		}
	}

	private void stopSkillList(L1Character cha, int[] repeat_skill) {
		for (int skillId : repeat_skill) {
			if (skillId != _skillId) {
				cha.removeSkillEffect(skillId);
			}
		}
	}

	private void setDelay() {
		if (_skill.getReuseDelay() > 0) {
			L1SkillDelay.onSkillUse(_user, _skill.getReuseDelay());
		}
	}

	private void handleCube() {
		int xPlus = 0;
		int yPlus = 0;
		int head = _user.getHeading();
		if (head % 4 == 0) {
			xPlus = 0;
		} else if (head / 4 == 0) {
			xPlus = 1;
		} else {
			xPlus = -1;
		}
		head = (head + 2) % 8;
		if (head % 4 == 0) {
			yPlus = 0;
		} else if (head / 4 == 0) {
			yPlus = -1;
		} else {
			yPlus = 1;
		}
		if (!_user.getMap().isPassable(_targetX + xPlus, _targetY + yPlus)) {
			xPlus = 0;
			yPlus = 0;
		}
		int effect = 0;
		switch (_skillId) {
		case CUBE_IGNITION:
			effect = 80149;
			break;
		case CUBE_QUAKE:
			effect = 80150;
			break;
		case CUBE_SHOCK:
			effect = 80151;
			break;
		case CUBE_BALANCE:
			effect = 80152;
			break;
		}
		L1EffectSpawn.getInstance().spawnEffect(effect,
				_skill.getBuffDuration() * 1000, _targetX + xPlus,
				_targetY + yPlus, _user.getMapId(), (L1PcInstance) _user,
				_skillId);
	}

	private void runSkill() {
		L1Skill l1skills = SkillTable.getInstance().findBySkillId(_skillId);
		if (_skillId == LIFE_STREAM) {
			L1EffectSpawn.getInstance().spawnEffect(81169,
					_skill.getBuffDuration() * 1000, _targetX, _targetY,
					_user.getMapId());
			return;
		} else if (_skillId == CUBE_IGNITION || _skillId == CUBE_QUAKE
				|| _skillId == CUBE_SHOCK || _skillId == CUBE_BALANCE) {
			handleCube();
			return;
		}

		if (_skillId == FIRE_WALL) {
			L1EffectSpawn.getInstance().doSpawnFireWall(_user, _targetX,
					_targetY);
			return;
		}

		_isCounterMagic = !IntArrays.sContains(EXCEPT_COUNTER_MAGIC, _skillId);
		if ((_skillId == SHOCK_STUN || _skillId == BONE_BREAK || _skillId == MASS_SHOCK_STUN)
				|| _skillId == SMASH
				|| _skillId == ARM_BREAKER
				&& _user instanceof L1PcInstance) {
			_target.onAction(_player);
		}

		if (!isTargetCalc(_target)) {
			return;
		}

		try {
			TargetStatus ts = null;
			L1Character cha = null;
			int dmg = 0;
			int drainMana = 0;
			int heal = 0;
			boolean isSuccess = false;
			int undeadType = 0;

			for (Iterator<TargetStatus> iter = _targetList.iterator(); iter
					.hasNext();) {
				ts = null;
				cha = null;
				dmg = 0;
				heal = 0;
				isSuccess = false;
				undeadType = 0;

				ts = iter.next();
				cha = ts.getTarget();

				if (!ts.isCalc() || !isTargetCalc(cha)) {
					continue;
				}

				L1Magic _magic = new L1Magic(_user, cha);
				_magic.setLeverage(getLeverage());

				if (cha instanceof L1MonsterInstance) {
					undeadType = ((L1MonsterInstance) cha).getNpcTemplate()
							.get_undead();
				}

				if ((_skill.getType() == L1Skill.TYPE_CURSE || _skill.getType() == L1Skill.TYPE_PROBABILITY)
						&& isTargetFailure(cha)) {
					iter.remove();
					continue;
				}

				int buffIconDuration = 0;
				if (cha instanceof L1PcInstance) {
					if (_skillTime == 0) {
						buffIconDuration = _skill.getBuffDuration();
					} else {
						buffIconDuration = _skillTime;
					}
				}

				deleteRepeatedSkills(cha);

				if (_skill.getType() == L1Skill.TYPE_ATTACK
						&& _user.getId() != cha.getId()) {
					
					if (_user instanceof L1PcInstance) {
						((L1PcInstance)_user).setLastAggressiveAct();
					}
						
					if (isUseCounterMagic(cha)) {
						iter.remove();
						continue;
					}
					dmg = _magic.calcMagicDamage(_skillId);
					_dmg = dmg;
					cha.removeSkillEffect(ERASE_MAGIC);
				} else if (_skill.getType() == L1Skill.TYPE_CURSE
						|| _skill.getType() == L1Skill.TYPE_PROBABILITY) {
					if (_user instanceof L1PcInstance) {
						((L1PcInstance)_user).setLastAggressiveAct();
					}
						
					isSuccess = _magic.calcProbabilityMagic(_skillId);
					if (_skillId != ERASE_MAGIC) {
						cha.removeSkillEffect(ERASE_MAGIC);
					}
					if (_skillId != FOG_OF_SLEEPING) {
						cha.removeSkillEffect(FOG_OF_SLEEPING);
					}
					if (_skillId != PHANTASM) {
						cha.removeSkillEffect(PHANTASM);
					}
					if (isSuccess) {
						if(cha instanceof L1PcInstance) {
							((L1PcInstance)cha).setLastAggressiveAct();
						}	
						
						if (isUseCounterMagic(cha)) {
							iter.remove();
							continue;
						}
					} else {
						if (_skillId == FOG_OF_SLEEPING
								&& cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							pc.sendPackets(new S_ServerMessage(297)); // You feel slightly dizzy.
						}
						iter.remove();
						continue;
					}
				} else if (_skill.getType() == L1Skill.TYPE_HEAL) {
					dmg = -1 * _magic.calcHealing(_skillId);
					if (cha.hasSkillEffect(WATER_LIFE)) {
						dmg *= 2;
					}
					if (cha.hasSkillEffect(POLLUTE_WATER)) {
						dmg /= 2;
					}
				}

				if (cha.hasSkillEffect(_skillId) && _skillId != SHOCK_STUN
						&& _skillId != BONE_BREAK && _skillId != ARM_BREAKER
						&& _skillId != MASS_SHOCK_STUN) {
					addMagicList(cha, true);
					if (_skillId != SHAPE_CHANGE) {
						continue;
					}
				}

				if (_skillId == HASTE) {
					if (cha.getMoveSpeed() != 2) {
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							if (pc.getHasteItemEquipped() > 0) {
								continue;
							}
							pc.setDrink(false);
							pc.sendPackets(new S_SkillHaste(pc.getId(), 1,
									buffIconDuration));
						}
						cha.broadcastPacket(new S_SkillHaste(cha.getId(), 1, 0));
						cha.setMoveSpeed(1);
					} else {
						int skillNum = 0;
						if (cha.hasSkillEffect(SLOW)) {
							skillNum = SLOW;
						} else if (cha.hasSkillEffect(MASS_SLOW)) {
							skillNum = MASS_SLOW;
						} else if (cha.hasSkillEffect(ENTANGLE)) {
							skillNum = ENTANGLE;
						}
						if (skillNum != 0) {
							cha.removeSkillEffect(skillNum);
							cha.removeSkillEffect(HASTE);
							cha.setMoveSpeed(0);
							continue;
						}
					}
				} else if (_skillId == CURE_POISON) {
					cha.curePoison();
				} else if (_skillId == REMOVE_CURSE) {
					cha.curePoison();
					if (cha.hasSkillEffect(STATUS_CURSE_PARALYZING)
							|| cha.hasSkillEffect(STATUS_CURSE_PARALYZED)) {
						cha.cureParalaysis();
					}
				} else if (_skillId == RESURRECTION
						|| _skillId == GREATER_RESURRECTION) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (_player.getId() != pc.getId()) {
							if (L1World.getInstance().getVisiblePlayer(pc, 0)
									.size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(pc, 0)) {
									if (!visiblePc.isDead()) {
										_player.sendPackets(new S_ServerMessage(
												592)); // Your attempt at resurrection has failed because the location is occupied by someone else.
										return;
									}
								}
							}
							if (pc.getCurrentHp() == 0 && pc.isDead()) {
								if (pc.getMap().isUseResurrection()) {
									if (_skillId == RESURRECTION) {
										pc.setGres(false);
									} else if (_skillId == GREATER_RESURRECTION) {
										pc.setGres(true);
									}
									pc.setTempID(_player.getId());
									pc.sendPackets(new S_Message_YN(322, ""));
								}
							}
						}
					}
					if (cha instanceof L1NpcInstance) {
						if (!(cha instanceof L1TowerInstance)) {
							L1NpcInstance npc = (L1NpcInstance) cha;
							if (npc.getNpcTemplate().isCantResurrect()
									&& !(npc instanceof L1PetInstance)) {
								return;
							}
							if (npc instanceof L1PetInstance
									&& L1World.getInstance()
											.getVisiblePlayer(npc, 0).size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(npc, 0)) {
									if (!visiblePc.isDead()) {
										_player.sendPackets(new S_ServerMessage(
												592)); // Your attempt at resurrection has failed because the location is occupied by someone else.
										return;
									}
								}
							}
							if (npc.getCurrentHp() == 0 && npc.isDead()) {
								if (_skillId == GREATER_RESURRECTION) {
									npc.resurrect(npc.getMaxHp());
								} else {
									npc.resurrect(npc.getMaxHp() / 4);
								}
								npc.startHpRegeneration();
								npc.startMpRegeneration();
								npc.setResurrect(true);
							}
						}
					}
				} else if (_skillId == CALL_OF_NATURE) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (_player.getId() != pc.getId()) {
							if (L1World.getInstance().getVisiblePlayer(pc, 0)
									.size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(pc, 0)) {
									if (!visiblePc.isDead()) {
										_player.sendPackets(new S_ServerMessage(
												592)); // Your attempt at resurrection has failed because the location is occupied by someone else.
										return;
									}
								}
							}
							if (pc.getCurrentHp() == 0 && pc.isDead()) {
								pc.setTempID(_player.getId());
								pc.sendPackets(new S_Message_YN(322, ""));
							}
						}
					}
					if (cha instanceof L1NpcInstance) {
						if (!(cha instanceof L1TowerInstance)) {
							L1NpcInstance npc = (L1NpcInstance) cha;
							if (npc.getNpcTemplate().isCantResurrect()
									&& !(npc instanceof L1PetInstance)) {
								return;
							}
							if (npc instanceof L1PetInstance
									&& L1World.getInstance()
											.getVisiblePlayer(npc, 0).size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(npc, 0)) {
									if (!visiblePc.isDead()) {
										_player.sendPackets(new S_ServerMessage(
												592)); // Your attempt at resurrection has failed because the location is occupied by someone else.
										return;
									}
								}
							}
							if (npc.getCurrentHp() == 0 && npc.isDead()) {
								npc.resurrect(cha.getMaxHp());
								npc.resurrect(cha.getMaxMp() / 100);
								npc.setResurrect(true);
							}
						}
					}
				} else if (_skillId == DETECTION) {
					if (cha instanceof L1NpcInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						int hiddenStatus = npc.getHiddenStatus();
						if (hiddenStatus == L1NpcInstance.HIDDEN_STATUS_SINK) {
							npc.appearOnGround(_player);
						}
					}
				} else if (_skillId == COUNTER_DETECTION) {
					if (cha instanceof L1PcInstance) {
						dmg = _magic.calcMagicDamage(_skillId);
					} else if (cha instanceof L1NpcInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						int hiddenStatus = npc.getHiddenStatus();
						if (hiddenStatus == L1NpcInstance.HIDDEN_STATUS_SINK) {
							npc.appearOnGround(_player);
							dmg = _magic.calcMagicDamage(_skillId);
						} else {
							dmg = 0;
						}
					} else {
						dmg = 0;
					}
				} else if (_skillId == TRUE_TARGET) {
					if (_user instanceof L1PcInstance) {
						L1PcInstance pri = (L1PcInstance) _user;
						pri.sendPackets(new S_TrueTarget(_targetID,
								pri.getId(), _message));
						L1Clan clan = pri.getClan();
						if (clan != null) {
							L1PcInstance players[] = clan.getOnlineClanMember();
							for (L1PcInstance pc : players) {
								pc.sendPackets(new S_TrueTarget(_targetID, pc
										.getId(), _message));
							}
						}
					}
				} else if (_skillId == ELEMENTAL_FALL_DOWN) {
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if ((_skillId == HEAL || _skillId == EXTRA_HEAL
						|| _skillId == GREATER_HEAL || _skillId == FULL_HEAL
						|| _skillId == HEAL_ALL || _skillId == NATURES_BLESSING)
						&& (_user instanceof L1PcInstance)) {
					cha.removeSkillEffect(WATER_LIFE);
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_SkillIconWaterLife());
					}

				} else if (_skillId == NATURES_TOUCH) {
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == CHILL_TOUCH
						|| _skillId == VAMPIRIC_TOUCH) {
					heal = dmg;
				} else if (_skillId == TRIPLE_ARROW) {
					// GFX Check (Made by HuntBoy)
					boolean gfxcheck = false;
					int[] BowGFX = { 138, 37, 3860, 3126, 3420, 2284, 3105,
							3145, 3148, 3151, 3871, 4125, 2323, 3892, 3895,
							3898, 3901, 4917, 4918, 4919, 4950, 6087, 6140,
							6145, 6150, 6155, 6160, 6269, 6272, 6275, 6278,
							6826, 6827, 6836, 6837, 6846, 6847, 6856, 6857,
							6866, 6867, 6876, 6877, 6886, 6887 };
					int playerGFX = _player.getTempCharGfx();
					for (int gfx : BowGFX) {
						if (playerGFX == gfx) {
							gfxcheck = true;
							break;
						}
					}
					if (!gfxcheck) {
						return;
					}

					for (int i = 3; i > 0; i--) {
						_target.onAction(_player);
					}
					_player.sendPackets(new S_SkillSound(_player.getId(), 4394));
					_player.broadcastPacket(new S_SkillSound(_player.getId(),
							4394));
				} else if (_skillId == FOE_SLAYER) {
					_player.setFoeSlayer(true);
					for (int i = 3; i > 0; i--) {
						_target.onAction(_player);
					}
					_player.setFoeSlayer(false);
					_player.sendPackets(new S_SkillSound(_target.getId(), 6509));
					_player.sendPackets(new S_SkillSound(_player.getId(), 7020));
					_player.broadcastPacket(new S_SkillSound(_target.getId(),
							6509));
					_player.broadcastPacket(new S_SkillSound(_player.getId(),
							7020));
					if (!_player.isFoeSlayerSuccess())
						continue;
					// Foe Slayer will kill the effect of weakness exposure
					if (_player.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV1)) {
						_player.killSkillEffectTimer(STATUS_WEAKNESS_EXPOSURE_LV1);
						_player.sendPackets(EndRevealWeakness);
					} else if (_player
							.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV2)) {
						_player.killSkillEffectTimer(STATUS_WEAKNESS_EXPOSURE_LV2);
						_player.sendPackets(EndRevealWeakness);
					} else if (_player
							.hasSkillEffect(STATUS_WEAKNESS_EXPOSURE_LV3)) {
						_player.killSkillEffectTimer(STATUS_WEAKNESS_EXPOSURE_LV3);
						_player.sendPackets(EndRevealWeakness);
					}
					_player.setFoeSlayerSuccess(false);
				} else if (_skillId == 10026 || _skillId == 10027
						|| _skillId == 10028 || _skillId == 10029) {
					if (_user instanceof L1NpcInstance) {
						_user.broadcastPacket(new S_NpcChatPacket(_npc,
								"$3717", 0));
					} else {
						_player.broadcastPacket(new S_ChatPacket(_player,
								"$3717", 0, 0));
					}
				} else if (_skillId == 10057) {
					L1Teleport.teleportToTargetFront(cha, _user, 1);
				}

				else if (_skillId == SLOW || _skillId == MASS_SLOW
						|| _skillId == ENTANGLE) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getHasteItemEquipped() > 0) {
							continue;
						}
					}
					if (cha.getMoveSpeed() == 0) {
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							pc.sendPackets(new S_SkillHaste(pc.getId(), 2,
									buffIconDuration));
						}
						cha.broadcastPacket(new S_SkillHaste(cha.getId(), 2,
								buffIconDuration));
						cha.setMoveSpeed(2);
					} else if (cha.getMoveSpeed() == 1) {
						int skillNum = 0;
						if (cha.hasSkillEffect(HASTE)) {
							skillNum = HASTE;
						} else if (cha.hasSkillEffect(GREATER_HASTE)) {
							skillNum = GREATER_HASTE;
						} else if (cha.hasSkillEffect(STATUS_HASTE)) {
							skillNum = STATUS_HASTE;
						}
						if (skillNum != 0) {
							cha.removeSkillEffect(skillNum);
							cha.removeSkillEffect(_skillId);
							cha.setMoveSpeed(0);
							continue;
						}
					}
					// dark blind fix?
				} else if (_skillId == CURSE_BLIND || _skillId == DARKNESS
						|| _skillId == DARK_BLIND) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.hasSkillEffect(STATUS_FLOATING_EYE)) {
							pc.sendPackets(new S_CurseBlind(2));
						} else {
							pc.sendPackets(new S_CurseBlind(1));
						}
					}
				} else if (_skillId == CURSE_POISON) {
					L1DamagePoison.doInfection(_user, cha, 3000, 5);
				} else if (_skillId == CURSE_PARALYZE
						|| _skillId == CURSE_PARALYZE2) {
					if (!cha.hasSkillEffect(EARTH_BIND)
							&& !cha.hasSkillEffect(ICE_LANCE)
							&& !cha.hasSkillEffect(FREEZING_BLIZZARD)
							&& !cha.hasSkillEffect(FREEZING_BREATH)) {
						if (cha instanceof L1PcInstance) {
							L1CurseParalysis.curse(cha, 8000, 16000);
						} else if (cha instanceof L1MonsterInstance) {
							L1CurseParalysis.curse(cha, 0, 16000);
						}
					}
				} else if (_skillId == WEAKNESS) {
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == DISEASE) {
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == ICE_LANCE
						|| _skillId == FREEZING_BLIZZARD
						|| _skillId == FREEZING_BREATH) {
					_isFreeze = _magic.calcProbabilityMagic(_skillId);
					if (_isFreeze) {
						int time = _skill.getBuffDuration() * 1000;
						L1EffectSpawn.getInstance().spawnEffect(81168, time,
								cha.getX(), cha.getY(), cha.getMapId());
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							pc.sendPackets(new S_Poison(pc.getId(), 2));
							pc.broadcastPacket(new S_Poison(pc.getId(), 2));
							pc.sendPackets(new S_Paralysis(
									S_Paralysis.TYPE_FREEZE, true));
						} else if (cha instanceof L1MonsterInstance
								|| cha instanceof L1SummonInstance
								|| cha instanceof L1PetInstance) {
							L1NpcInstance npc = (L1NpcInstance) cha;
							npc.broadcastPacket(new S_Poison(npc.getId(), 2));
							npc.setParalyzed(true);
							npc.setParalysisTime(time);
						}
					}
				} else if (_skillId == EARTH_BIND) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Poison(pc.getId(), 2));
						pc.broadcastPacket(new S_Poison(pc.getId(), 2));
						pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_FREEZE,
								true));
					} else if (cha instanceof L1MonsterInstance
							|| cha instanceof L1SummonInstance
							|| cha instanceof L1PetInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						npc.broadcastPacket(new S_Poison(npc.getId(), 2));
						npc.setParalyzed(true);
						npc.setParalysisTime(_skill.getBuffDuration() * 1000);
					}
				} else if (_skillId == SHOCK_STUN) {

					int targetLevel = 0;
					int diffLevel = 0;
					int stunTime = 0;
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						targetLevel = pc.getLevel();
					} else if (cha instanceof L1MonsterInstance
							|| cha instanceof L1SummonInstance
							|| cha instanceof L1PetInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						targetLevel = npc.getLevel();
					}
					diffLevel = _user.getLevel() - targetLevel;
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();

					_shockStunDuration = random.nextInt(3000) + 1000;
					
					L1EffectSpawn.getInstance().spawnEffect(81162,
							_shockStunDuration, cha.getX(), cha.getY(),
							cha.getMapId());
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_STUN,
								true));
					} else if (cha instanceof L1MonsterInstance
							|| cha instanceof L1SummonInstance
							|| cha instanceof L1PetInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						npc.setParalyzed(true);
						npc.setParalysisTime(_shockStunDuration);
					}
				} else if (_skillId == MASS_SHOCK_STUN) {
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int stunTime = (random.nextInt(21) + 30) * 100;

					_shockStunDuration = stunTime;
					L1EffectSpawn.getInstance().spawnEffect(81162,
							_shockStunDuration, cha.getX(), cha.getY(),
							cha.getMapId());
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_STUN,
								true));
					} else if (cha instanceof L1SummonInstance
							|| cha instanceof L1PetInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						npc.setParalyzed(true);
						npc.setParalysisTime(_shockStunDuration);
					}
				} else if (_skillId == WIND_SHACKLE) {
					_skill.newBuffSkillExecutor().addEffect(_user, cha,
							buffIconDuration);
				} else if (_skillId == CANCELLATION) {
					if (cha instanceof L1NpcInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						int npcId = npc.getNpcTemplate().get_npcId();
						if (npcId == 71092) {
							if (npc.getGfxId() == npc.getTempCharGfx()) {
								npc.setTempCharGfx(1314);
								npc.broadcastPacket(new S_ChangeShape(npc
										.getId(), 1314));
								return;
							} else {
								return;
							}
						}
						if (npcId == 45640) {
							if (npc.getGfxId() == npc.getTempCharGfx()) {
								npc.setCurrentHp(npc.getMaxHp());
								npc.setTempCharGfx(2332);
								npc.broadcastPacket(new S_ChangeShape(npc
										.getId(), 2332));
								npc.setName("$2103");
								npc.setNameId("$2103");
								npc.broadcastPacket(new S_ChangeName(npc
										.getId(), "$2103"));
							} else if (npc.getTempCharGfx() == 2332) {
								npc.setCurrentHp(npc.getMaxHp());
								npc.setTempCharGfx(2755);
								npc.broadcastPacket(new S_ChangeShape(npc
										.getId(), 2755));
								npc.setName("$2488");
								npc.setNameId("$2488");
								npc.broadcastPacket(new S_ChangeName(npc
										.getId(), "$2488"));
							}
						}
						if (npcId == 81209) {
							if (npc.getGfxId() == npc.getTempCharGfx()) {
								npc.setTempCharGfx(4310);
								npc.broadcastPacket(new S_ChangeShape(npc
										.getId(), 4310));
								return;
							} else {
								return;
							}
						}
					}
					if (_player != null && _player.isInvisble()) {
						_player.delInvis();
					}
					if (!(cha instanceof L1PcInstance)) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						npc.setMoveSpeed(0);
						npc.setBraveSpeed(0);
						npc.broadcastPacket(new S_SkillHaste(cha.getId(), 0, 0));
						npc.broadcastPacket(new S_SkillBrave(cha.getId(), 0, 0));
						npc.setWeaponBreaked(false);
						npc.setParalyzed(false);
						npc.setParalysisTime(0);
					}

					for (int skillNum = SKILLS_BEGIN; skillNum <= SKILLS_END; skillNum++) {
						if (isNotCancelable(skillNum) && !cha.isDead()) {
							continue;
						}
						cha.removeSkillEffect(skillNum);
					}

					cha.curePoison();
					cha.cureParalaysis();
					for (int skillNum = STATUS_BEGIN; skillNum <= STATUS_END; skillNum++) {
						if (skillNum == STATUS_CHAT_PROHIBITED
								|| skillNum == STATUS_CURSE_BARLOG
								|| skillNum == STATUS_CURSE_YAHEE) {
							continue;
						}
						cha.removeSkillEffect(skillNum);
					}

					for (int skillNum = COOKING_BEGIN; skillNum <= COOKING_END; skillNum++) {
						if (isNotCancelable(skillNum)) {
							continue;
						}
						cha.removeSkillEffect(skillNum);
					}

					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;

						L1PolyMorph.undoPoly(pc);
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.broadcastPacket(new S_CharVisualUpdate(pc));

						if (pc.getHasteItemEquipped() > 0) {
							pc.setMoveSpeed(0);
							pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
							pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0,
									0));
						}
					}
					cha.removeSkillEffect(STATUS_FREEZE);
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.broadcastPacket(new S_CharVisualUpdate(pc));
						if (pc.isPrivateShop()) {
							pc.sendPackets(new S_DoActionShop(pc.getId(),
									ActionCodes.ACTION_Shop, pc.getShopChat()));
							pc.broadcastPacket(new S_DoActionShop(pc.getId(),
									ActionCodes.ACTION_Shop, pc.getShopChat()));
						}
						if (_user instanceof L1PcInstance) {
							((L1PcInstance) _user)._pinkName.onAction(pc);
						}
					}
				} else if (_skillId == TURN_UNDEAD
						&& (undeadType == 1 || undeadType == 3)) {
					dmg = cha.getCurrentHp();
				} else if (_skillId == MANA_DRAIN) {
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int chance = random.nextInt(10) + 5;
					drainMana = chance + (_user.getInt() / 2);
					if (cha.getCurrentMp() < drainMana) {
						drainMana = cha.getCurrentMp();
					}
				} else if (_skillId == WEAPON_BREAK) {
					if (_calcType == PC_PC || _calcType == NPC_PC) {
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							L1ItemInstance weapon = pc.getWeapon();
							if (weapon != null) {
								RandomGenerator random = RandomGeneratorFactory
										.getSharedRandom();
								int weaponDamage = random.nextInt(_user
										.getInt() / 3) + 1;
								pc.sendPackets(new S_ServerMessage(268, weapon
										.getLogName())); // Your 'weapon' was damaged.
								pc.getInventory().receiveDamage(weapon,
										weaponDamage);
							}
						}
					} else {
						((L1NpcInstance) cha).setWeaponBreaked(true);
					}
				} else if (_skillId == FOG_OF_SLEEPING) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_SLEEP,
								true));
					}
					cha.setSleeped(true);
				} else if (_skillId == STATUS_FREEZE) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_BIND,
								true));
					}
				} else if (_skillId == GUARD_BRAKE) {
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == HORROR_OF_DEATH) {
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == THUNDER_GRAB) {
					if (_magic.calcProbabilityMagic(_skillId)) {
						int chance = (_user.getLevel() - cha.getLevel())
								* 5
								+ RandomGeneratorFactory.getSharedRandom()
										.nextInt(99) + 1;

						int time = 0;
						if (chance > 85) {
							time = 4000;
						} else if (chance > 75) {
							time = 3500;
						} else if (chance > 65) {
							time = 3000;
						} else if (chance > 55) {
							time = 2500;
						} else if (chance > 45) {
							time = 2000;
						} else if (chance > 35) {
							time = 1500;
						} else {
							time = 1000;
						}

						if (cha instanceof L1PcInstance) {
							L1PcInstance targetPc = (L1PcInstance) cha;
							targetPc.setSkillEffect(STATUS_FREEZE, time);
							targetPc.sendPackets(new S_SkillSound(targetPc
									.getId(), 4184));
							targetPc.broadcastPacket(new S_SkillSound(targetPc
									.getId(), 4184));
							targetPc.sendPackets(new S_Paralysis(
									S_Paralysis.TYPE_BIND, true));
						} else if (cha instanceof L1MonsterInstance
								|| cha instanceof L1SummonInstance
								|| cha instanceof L1PetInstance) {
							L1NpcInstance npc = (L1NpcInstance) cha;
							npc.setSkillEffect(STATUS_FREEZE, time);
							npc.broadcastPacket(new S_SkillSound(npc.getId(),
									4184));
							npc.setParalyzed(true);
						}
					}
				} else if (_skillId == BONE_BREAK) {
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int stunTime = (random.nextInt(10) + 6) * 100;
					_boneBreakDuration = stunTime;
					int intbonus = _user.getInt() - 12;
					if (intbonus > 0) {
						_boneBreakDuration = _boneBreakDuration
								+ (intbonus * 40);
					}
					if (_boneBreakDuration > 6000) {
						_boneBreakDuration = 6000;
					}
					int chance = (random.nextInt(100) + 1);
					int probability = (l1skills.getProbabilityValue() - (2 * cha
							.getResistStun()));
					if (chance <= probability) {
						L1EffectSpawn.getInstance().spawnEffect(91208,
								_boneBreakDuration, cha.getX(), cha.getY(),
								cha.getMapId());
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;

							pc.sendPackets(new S_Paralysis(
									S_Paralysis.TYPE_STUN, true));
						} else if (cha instanceof L1MonsterInstance
								|| cha instanceof L1SummonInstance
								|| cha instanceof L1PetInstance) {
							L1NpcInstance npc = (L1NpcInstance) cha;

							npc.setParalyzed(true);
							npc.setParalysisTime(_boneBreakDuration);
						}
					}
				} else if (_skillId == SMASH) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_SkillSound(pc.getId(), 6526));
						pc.broadcastPacket(new S_SkillSound(pc.getId(), 6526));
					} else if (cha instanceof L1MonsterInstance
							|| cha instanceof L1SummonInstance
							|| cha instanceof L1PetInstance
							|| cha instanceof L1DwarfInstance
							|| cha instanceof L1GuardInstance
							|| cha instanceof L1MerchantInstance
							|| cha instanceof L1TeleporterInstance
							|| cha instanceof L1HousekeeperInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						npc.broadcastPacket(new S_SkillSound(npc.getId(), 6526));
					}
				} else if (_skillId == CONFUSION) {
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int silenceTime = (random.nextInt(60) + 40) * 100;
					_confusionDuration = silenceTime;
					int chance = (random.nextInt(100) + 1);
					int probability = l1skills.getProbabilityValue();
					if (chance <= probability) {
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							pc.sendPackets(new S_ServerMessage(697)); // You feel your magical powers being cut off.
							pc.setSkillEffect(SILENCE, _confusionDuration);
						} else if (cha instanceof L1MonsterInstance
								|| cha instanceof L1SummonInstance
								|| cha instanceof L1PetInstance) {
							L1NpcInstance npc = (L1NpcInstance) cha;
							npc.setSkillEffect(SILENCE, _confusionDuration);
						}
					}
				} else if (_skillId == PHANTASM) {
					int time = _skill.getBuffDuration() * 1000;
					if (cha instanceof L1PcInstance) {
						L1PcInstance targetPc = (L1PcInstance) cha;
						targetPc.setSkillEffect(FOG_OF_SLEEPING, time);
						targetPc.sendPackets(new S_Paralysis(
								S_Paralysis.TYPE_SLEEP, true));
					} else if (cha instanceof L1MonsterInstance
							|| cha instanceof L1SummonInstance
							|| cha instanceof L1PetInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						npc.setSkillEffect(FOG_OF_SLEEPING, time);
						npc.setSleeped(true);
					}
				} else if (_skillId == ARM_BREAKER) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_SkillSound(pc.getId(), 6551));
						pc.broadcastPacket(new S_SkillSound(pc.getId(), 6551));
					} else if (cha instanceof L1MonsterInstance
							|| cha instanceof L1SummonInstance
							|| cha instanceof L1PetInstance
							|| cha instanceof L1DwarfInstance
							|| cha instanceof L1GuardInstance
							|| cha instanceof L1MerchantInstance
							|| cha instanceof L1TeleporterInstance
							|| cha instanceof L1HousekeeperInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						npc.broadcastPacket(new S_SkillSound(npc.getId(), 6551));
					}
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int chance = (random.nextInt(100) + 1);
					int probability = l1skills.getProbabilityValue();
					int time = _skill.getBuffDuration();
					if (chance <= probability) {
						if (cha instanceof L1PcInstance) {
							if (cha instanceof L1PcInstance) {
								L1PcInstance pc = (L1PcInstance) cha;
								pc.addHitup(-5);
								pc.setSkillEffect(ARM_BREAKER, time);
								pc.sendPackets(new S_SkillIconGFX(74,
										(time / 3)));
							}
						} else if (cha instanceof L1MonsterInstance
								|| cha instanceof L1SummonInstance
								|| cha instanceof L1PetInstance) {
							L1NpcInstance npc = (L1NpcInstance) cha;
							npc.addHitup(-5);
							npc.setSkillEffect(ARM_BREAKER, time);
						}
					}
				}

				if (_calcType == PC_PC || _calcType == NPC_PC) {
					if (_skillId == TELEPORT || _skillId == MASS_TELEPORT) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1BookMark bookm = pc.getBookMark(_bookmarkId);
						if (bookm != null) {
							if (pc.getMap().isEscapable() || pc.isGm()) {
								int newX = bookm.getLocX();
								int newY = bookm.getLocY();
								short mapId = bookm.getMapId();

								if (_skillId == MASS_TELEPORT) {
									List<L1PcInstance> clanMember = L1World
											.getInstance().getVisiblePlayer(pc);
									for (L1PcInstance member : clanMember) {
										if (pc.getLocation()
												.getTileLineDistance(
														member.getLocation()) <= 3
												&& member.getClanid() == pc
														.getClanid()
												&& pc.getClanid() != 0
												&& member.getId() != pc.getId()) {
											L1Teleport.teleport(member, newX,
													newY, mapId, 5, true);
										}
									}
								}
								L1Teleport.teleport(pc, newX, newY, mapId, 5,
										true);
							} else {
								L1Teleport.teleport(pc, pc.getX(), pc.getY(),
										pc.getMapId(), pc.getHeading(), false);
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
							}
						} else {
							if (pc.getMap().isTeleportable() || pc.isGm()) {
								L1Location newLocation = pc.getLocation()
										.randomLocation(200, true);
								int newX = newLocation.getX();
								int newY = newLocation.getY();
								short mapId = (short) newLocation.getMapId();

								if (_skillId == MASS_TELEPORT) {
									List<L1PcInstance> clanMember = L1World
											.getInstance().getVisiblePlayer(pc);
									for (L1PcInstance member : clanMember) {
										if (pc.getLocation()
												.getTileLineDistance(
														member.getLocation()) <= 3
												&& member.getClanid() == pc
														.getClanid()
												&& pc.getClanid() != 0
												&& member.getId() != pc.getId()) {
											L1Teleport.teleport(member, newX,
													newY, mapId, 5, true);
										}
									}
								}
								L1Teleport.teleport(pc, newX, newY, mapId, 5,
										true);
							} else {
								pc.sendPackets(new S_ServerMessage(276)); // You can't randomly teleport here.
								L1Teleport.teleport(pc, pc.getX(), pc.getY(),
										pc.getMapId(), pc.getHeading(), false);
							}
						}
					} else if (_skillId == TELEPORT_TO_MATHER) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getMap().isEscapable() || pc.isGm()) {
							L1Teleport.teleport(pc, 33051, 32337, (short) 4, 5,
									true);
						} else {
							pc.sendPackets(new S_ServerMessage(647)); // You cannot teleport in this location.
							L1Teleport.teleport(pc, pc.getX(), pc.getY(),
									pc.getMapId(), pc.getHeading(), false);
						}
					} else if (_skillId == CALL_CLAN) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1PcInstance clanPc = (L1PcInstance) L1World
								.getInstance().findObject(_targetID);
						if (clanPc != null) {
							clanPc.setTempID(pc.getId());
							clanPc.sendPackets(new S_Message_YN(729, ""));
						}
					} else if (_skillId == RUN_CLAN) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1PcInstance clanPc = (L1PcInstance) L1World
								.getInstance().findObject(_targetID);
						if (clanPc != null) {
							if (pc.getMap().isEscapable() || pc.isGm()) {
								boolean castle_area = L1CastleLocation
										.checkInAllWarArea(clanPc.getX(),
												clanPc.getY(),
												clanPc.getMapId());
								if ((clanPc.getMapId() == 0
										|| clanPc.getMapId() == 4 || clanPc
										.getMapId() == 304)
										&& castle_area == false) {
									L1Teleport.teleport(pc, clanPc.getX(),
											clanPc.getY(), clanPc.getMapId(),
											5, true);
								} else {
									pc.sendPackets(new S_ServerMessage(547)); // Your partner is playing in an area that you can't go.
								}
							} else {
								pc.sendPackets(new S_ServerMessage(647)); // You cannot teleport in this location.
								L1Teleport.teleport(pc, pc.getX(), pc.getY(),
										pc.getMapId(), pc.getHeading(), false);
							}
						}
					} else if (_skillId == CREATE_MAGICAL_WEAPON) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null && item.getItem().getType2() == 1) {
							int item_type = item.getItem().getType2();
							int safe_enchant = item.getItem().get_safeenchant();
							int enchant_level = item.getEnchantLevel();
							String item_name = item.getName();
							if (safe_enchant < 0) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
							} else if (safe_enchant == 0) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
							} else if (item_type == 1 && enchant_level == 0) {
								if (!item.isIdentified()) {
									pc.sendPackets(new S_ServerMessage(161,
											item_name, "$245", "$247")); // Your 'item' glows 'blue' for a 'moment'.
								} else {
									item_name = "+0 " + item_name;
									pc.sendPackets(new S_ServerMessage(161,
											"+0 " + item_name, "$245", "$247")); // Your 'item' glows 'blue' for a 'moment'.
								}
								item.setEnchantLevel(1);
								pc.getInventory().updateItem(item,
										L1PcInventory.COL_ENCHANTLVL);
							} else {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
							}
						} else {
							pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						}
					} else if (_skillId == PURIFY_STONE) {
						L1PcInstance pc = (L1PcInstance) cha;
						turnStone(pc, pc.getInventory().getItem(_itemobjid), 1,
								1, true);
					} else if (_skillId == SUMMON_MONSTER) {
						L1PcInstance pc = (L1PcInstance) cha;
						int level = pc.getLevel();
						int[] summons;
						if (pc.getMap().isRecallPets() || pc.isGm()) {
							if (pc.getInventory().checkEquipped(20284)) {
								pc.sendPackets(new S_ShowSummonList(pc.getId()));
								if (!pc.isSummonMonster()) {
									pc.setSummonMonster(true);
								}
							} else {
								/*
								 * summons = new int[] { 81083, 81084, 81085,
								 * 81086, 81087, 81088, 81089 };
								 */
								summons = new int[] { 81210, 81213, 81216,
										81219, 81222, 81225, 81228 };
								int summonid = 0;
								// int summoncost = 6;
								int summoncost = 8;
								int levelRange = 32;
								for (int i = 0; i < summons.length; i++) {
									if (level < levelRange
											|| i == summons.length - 1) {
										summonid = summons[i];
										break;
									}
									levelRange += 4;
								}

								int petcost = 0;
								Object[] petlist = pc.getPetList().values()
										.toArray();
								for (Object pet : petlist) {
									petcost += ((L1NpcInstance) pet)
											.getPetcost();
								}
								int pcCha = pc.getCha();
								if (pcCha > 34) { // max count = 5
									pcCha = 34;
								}
								int charisma = pcCha + 6 - petcost;
								// int charisma = pc.getCha() + 6 - petcost;
								int summoncount = charisma / summoncost;
								L1Npc npcTemp = NpcTable.getInstance()
										.getTemplate(summonid);
								for (int i = 0; i < summoncount; i++) {
									L1SummonInstance summon = new L1SummonInstance(
											npcTemp, pc);
									summon.setPetcost(summoncost);
								}
							}
						} else {
							pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						}
					} else if (_skillId == LESSER_ELEMENTAL
							|| _skillId == GREATER_ELEMENTAL) {
						L1PcInstance pc = (L1PcInstance) cha;
						int attr = pc.getElfAttr();
						if (attr != 0) {
							if (pc.getMap().isRecallPets() || pc.isGm()) {
								int petcost = 0;
								Object[] petlist = pc.getPetList().values()
										.toArray();
								for (Object pet : petlist) {
									petcost += ((L1NpcInstance) pet)
											.getPetcost();
								}

								if (petcost == 0) {
									int summonid = 0;
									int summons[];
									if (_skillId == LESSER_ELEMENTAL) {
										summons = new int[] { 45306, 45303,
												45304, 45305 };
									} else {
										summons = new int[] { 81053, 81050,
												81051, 81052 };
									}
									int npcattr = 1;
									for (int i = 0; i < summons.length; i++) {
										if (npcattr == attr) {
											summonid = summons[i];
											i = summons.length;
										}
										npcattr *= 2;
									}
									if (summonid == 0) {
										RandomGenerator random = RandomGeneratorFactory
												.getSharedRandom();
										int k3 = random.nextInt(4);
										summonid = summons[k3];
									}

									L1Npc npcTemp = NpcTable.getInstance()
											.getTemplate(summonid);
									L1SummonInstance summon = new L1SummonInstance(
											npcTemp, pc);
									summon.setPetcost(pc.getCha() + 7);
								}
							} else {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
							}
						}
					} else if (_skillId == ABSOLUTE_BARRIER) {
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					}

					if (_skillId == GLOWING_AURA) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addHitup(5);
						pc.addBowHitup(5);
						pc.addMr(20);
						pc.sendPackets(new S_SPMR(pc));
						pc.sendPackets(new S_SkillIconAura(113,
								buffIconDuration));
					} else if (_skillId == SHINING_AURA) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-8);
						pc.sendPackets(new S_SkillIconAura(114,
								buffIconDuration));
					} else if (_skillId == BRAVE_AURA) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(5);
						pc.sendPackets(new S_SkillIconAura(116,
								buffIconDuration));
					} else if (_skillId == SHIELD) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-2);
						pc.sendPackets(new S_SkillIconShield(5,
								buffIconDuration));
					} else if (_skillId == SHADOW_ARMOR) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-3);
						pc.sendPackets(new S_SkillIconShield(3,
								buffIconDuration));
					} else if (_skillId == DRESS_DEXTERITY) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDex((byte) 2);
						pc.sendPackets(new S_Dexup(pc, 2, buffIconDuration));
					} else if (_skillId == DRESS_MIGHTY) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addStr((byte) 2);
						pc.sendPackets(new S_Strup(pc, 2, buffIconDuration));
					} else if (_skillId == SHADOW_FANG) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null && item.getItem().getType2() == 1) {
							item.setSkillWeaponEnchant(pc, _skillId,
									_skill.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						}
					} else if (_skillId == ENCHANT_WEAPON) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null && item.getItem().getType2() == 1) {
							pc.sendPackets(new S_ServerMessage(161, item
									.getLogName(), "$245", "$247")); // your 'item' glows 'blue' for a 'moment'.
							item.setSkillWeaponEnchant(pc, _skillId,
									_skill.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						}
					} else if (_skillId == HOLY_WEAPON
							|| _skillId == BLESS_WEAPON) {
						if (!(cha instanceof L1PcInstance)) {
							return;
						}
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getWeapon() == null) {
							pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
							return;
						}
						for (L1ItemInstance item : pc.getInventory().getItems()) {
							if (pc.getWeapon().equals(item)) {
								pc.sendPackets(new S_ServerMessage(161, item
										.getLogName(), "$245", "$247")); // your 'item' glows 'blue' for a 'moment'.
								item.setSkillWeaponEnchant(pc, _skillId,
										_skill.getBuffDuration() * 1000);
								return;
							}
						}
					} else if (_skillId == BLESSED_ARMOR) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null && item.getItem().getType2() == 2
								&& item.getItem().getType() == 2) {
							pc.sendPackets(new S_ServerMessage(161, item
									.getLogName(), "$245", "$247")); // your 'item' glows 'blue' for a 'moment'.
							item.setSkillArmorEnchant(pc, _skillId,
									_skill.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						}
					} else if (_skillId == EARTH_BLESS) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-7);
						pc.sendPackets(new S_SkillIconShield(7,
								buffIconDuration));
					} else if (_skillId == RESIST_MAGIC) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addMr(10);
						pc.sendPackets(new S_SPMR(pc));
					} else if (_skillId == CLEAR_MIND) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addWis((byte) 3);
						pc.resetBaseMr();
					} else if (_skillId == RESIST_ELEMENTAL) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addWind(10);
						pc.addWater(10);
						pc.addFire(10);
						pc.addEarth(10);
						pc.sendPackets(new S_OwnCharAttrDef(pc));
					} else if (_skillId == BODY_TO_MIND) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.setCurrentMp(pc.getCurrentMp() + 2);
					} else if (_skillId == BLOODY_SOUL) {
						L1PcInstance pc = (L1PcInstance) cha;
						// this has been changed to US server settings. do not
						// remove.
						pc.setCurrentMp(pc.getCurrentMp() + 16);
					} else if (_skillId == MIND_BREAK) {
						if (cha.getCurrentMp() > 10) {
							cha.setCurrentMp(cha.getCurrentMp() - 10);
							cha.setCurrentHp(cha.getCurrentHp() - 20);
						}
					} else if (_skillId == ELEMENTAL_PROTECTION) {
						L1PcInstance pc = (L1PcInstance) cha;
						int attr = pc.getElfAttr();
						if (attr == Element.Earth) {
							pc.addEarth(50);
						} else if (attr == Element.Fire) {
							pc.addFire(50);
						} else if (attr == Element.Water) {
							pc.addWater(50);
						} else if (attr == Element.Wind) {
							pc.addWind(50);
						}
					} else if (_skillId == INVISIBILITY
							|| _skillId == BLIND_HIDING) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Sound(147));
						pc.sendPackets(new S_Invis(pc.getId(), 1));
						pc.broadcastPacketForFindInvis(new S_RemoveObject(pc),
								false);
						// pc.broadcastPacket(new S_RemoveObject(pc));
					} else if (_skillId == IRON_SKIN) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-10);
						pc.sendPackets(new S_SkillIconShield(10,
								buffIconDuration));
					} else if (_skillId == EARTH_SKIN) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-6);
						pc.sendPackets(new S_SkillIconShield(6,
								buffIconDuration));
					} else if (_skillId == PHYSICAL_ENCHANT_STR) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addStr((byte) 5);
						pc.sendPackets(new S_Strup(pc, 5, buffIconDuration));
					} else if (_skillId == PHYSICAL_ENCHANT_DEX) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDex((byte) 5);
						pc.sendPackets(new S_Dexup(pc, 5, buffIconDuration));
					} else if (_skillId == FIRE_WEAPON) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(4);
						pc.sendPackets(new S_SkillIconAura(147,
								buffIconDuration));
					} else if (_skillId == FIRE_BLESS) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(4);
						pc.sendPackets(new S_SkillIconAura(154,
								buffIconDuration));
					} else if (_skillId == BURNING_WEAPON) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(6);
						pc.addHitup(3);
						pc.sendPackets(new S_SkillIconAura(162,
								buffIconDuration));
					} else if (_skillId == WIND_SHOT) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowHitup(6);
						pc.sendPackets(new S_SkillIconAura(148,
								buffIconDuration));
					} else if (_skillId == STORM_EYE) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowHitup(2);
						pc.addBowDmgup(3);
						pc.sendPackets(new S_SkillIconAura(155,
								buffIconDuration));
					} else if (_skillId == STORM_SHOT) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowDmgup(5);
						pc.addBowHitup(-1);
						pc.sendPackets(new S_SkillIconAura(165,
								buffIconDuration));
					} else if (_skillId == BERSERKERS) {
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					} else if (_skillId == SHAPE_CHANGE) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_ShowPolyList(pc.getId()));
						if (!pc.isShapeChange()) {
							pc.setShapeChange(true);
						}
					} else if (_skillId == ADVANCE_SPIRIT) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.setAdvenHp(pc.getBaseMaxHp() / 5);
						pc.setAdvenMp(pc.getBaseMaxMp() / 5);
						pc.addMaxHp(pc.getAdvenHp());
						pc.addMaxMp(pc.getAdvenMp());
						pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc
								.getMaxHp()));
						if (pc.isInParty()) {
							pc.getParty().updateMiniHP(pc);
						}
						pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc
								.getMaxMp()));
					} else if (_skillId == GREATER_HASTE) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getHasteItemEquipped() > 0) {
							continue;
						}
						if (pc.getMoveSpeed() != 2) {
							pc.setDrink(false);
							pc.setMoveSpeed(1);
							pc.sendPackets(new S_SkillHaste(pc.getId(), 1,
									buffIconDuration));
							pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1,
									0));
						} else {
							int skillNum = 0;
							if (pc.hasSkillEffect(SLOW)) {
								skillNum = SLOW;
							} else if (pc.hasSkillEffect(MASS_SLOW)) {
								skillNum = MASS_SLOW;
							} else if (pc.hasSkillEffect(ENTANGLE)) {
								skillNum = ENTANGLE;
							}
							if (skillNum != 0) {
								pc.removeSkillEffect(skillNum);
								pc.removeSkillEffect(GREATER_HASTE);
								pc.setMoveSpeed(0);
								continue;
							}
						}
					} else if (_skillId == HOLY_WALK
							|| _skillId == MOVING_ACCELERATION
							|| _skillId == WIND_WALK) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.setBraveSpeed(4);
						pc.sendPackets(new S_SkillBrave(pc.getId(), 4,
								buffIconDuration));
						pc.broadcastPacket(new S_SkillBrave(pc.getId(), 4, 0));
					} else if (_skillId == BLOODLUST) {
						L1PcInstance pc = (L1PcInstance) cha;
						// Remove Forbidden Fruit (STATUS_RIBRAVE) first
						pc.sendPackets(new S_SkillBrave(pc.getId(), 4, 0));
						pc.broadcastPacket(new S_SkillBrave(pc.getId(), 4, 0));
						pc.removeSkillEffect(STATUS_RIBRAVE);

						pc.setBraveSpeed(6);
						pc.sendPackets(new S_SkillBrave(pc.getId(), 6,
								buffIconDuration));
						pc.broadcastPacket(new S_SkillBrave(pc.getId(), 6, 0));
					} else if (_skillId == AWAKEN_ANTHARAS) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1Awake.start(pc, _skillId);
					} else if (_skillId == AWAKEN_FAFURION) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1Awake.start(pc, _skillId);
					} else if (_skillId == AWAKEN_VALAKAS) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1Awake.start(pc, _skillId);
					} else if (_skillId == ILLUSION_OGRE) {
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					} else if (_skillId == ILLUSION_LICH) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addSp(2);
						pc.sendPackets(new S_SPMR(pc));
					} else if (_skillId == ILLUSION_DIA_GOLEM) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-20);
					} else if (_skillId == ILLUSION_AVATAR) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(10);
						pc.addBowDmgup(10);
					} else if (_skillId == INSIGHT) {
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					} else if (_skillId == PANIC) {
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					}
				}

				if (_calcType == PC_NPC || _calcType == NPC_NPC) {
					if (_skillId == TAMING_MONSTER
							&& ((L1MonsterInstance) cha).getNpcTemplate()
									.isTamable()) {
						int petcost = 0;
						Object[] petlist = _user.getPetList().values()
								.toArray();
						for (Object pet : petlist) {
							petcost += ((L1NpcInstance) pet).getPetcost();
						}
						int charisma = _user.getCha();
						if (_player.isElf()) {
							if (charisma > 30) { // max count = 7
								charisma = 30;
							}
							charisma += 12;
						} else if (_player.isWizard()) {
							if (charisma > 36) { // max count = 7
								charisma = 36;
							}
							charisma += 6;
						}
						charisma -= petcost;
						if (charisma >= 6) {
							L1SummonInstance summon = new L1SummonInstance(
									_targetNpc, _user, false);
							_target = summon;
						} else {
							_player.sendPackets(new S_ServerMessage(319)); // You can't control more monsters.
						}
					} else if (_skillId == CREATE_ZOMBIE) {
						int petcost = 0;
						Object[] petlist = _user.getPetList().values()
								.toArray();
						for (Object pet : petlist) {
							petcost += ((L1NpcInstance) pet).getPetcost();
						}
						int charisma = _user.getCha();
						if (_player.isElf()) {
							if (charisma > 30) { // max count = 7
								charisma = 30;
							}
							charisma += 12;
						} else if (_player.isWizard()) {
							if (charisma > 36) { // max count = 7
								charisma = 36;
							}
							charisma += 6;
						}
						charisma -= petcost;
						if (charisma >= 6) {
							L1SummonInstance summon = new L1SummonInstance(
									_targetNpc, _user, true);
							_target = summon;
						} else {
							_player.sendPackets(new S_ServerMessage(319)); // You can't control more monsters.
						}
					} else if (_skillId == WEAK_ELEMENTAL) {
						if (cha instanceof L1MonsterInstance) {
							L1Npc npcTemp = ((L1MonsterInstance) cha)
									.getNpcTemplate();
							int weakAttr = npcTemp.get_weakAttr();
							if ((weakAttr & Element.Earth) == Element.Earth) {
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2169));
							}
							if ((weakAttr & Element.Fire) == Element.Fire) {
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2167));
							}
							if ((weakAttr & Element.Water) == Element.Water) {
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2166));
							}
							if ((weakAttr & Element.Wind) == Element.Wind) {
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2168));
							}
						}
					} else if (_skillId == RETURN_TO_NATURE) {
						if (Config.RETURN_TO_NATURE
								&& cha instanceof L1SummonInstance) {
							L1SummonInstance summon = (L1SummonInstance) cha;
							summon.broadcastPacket(new S_SkillSound(summon
									.getId(), 2245));
							summon.returnToNature();
						} else {
							if (_user instanceof L1PcInstance) {
								_player.sendPackets(new S_ServerMessage(79)); // Nothing happened.
							}
						}
					}
				}

				if (_skill.getType() == L1Skill.TYPE_HEAL
						&& _calcType == PC_NPC && undeadType == 1) {
					dmg *= -1;
				}

				if (_skill.getType() == L1Skill.TYPE_HEAL
						&& _calcType == PC_NPC && undeadType == 3) {
					dmg = 0;
				}

				if ((cha instanceof L1TowerInstance || cha instanceof L1DoorInstance)
						&& dmg < 0) {
					dmg = 0;
				}

				if (dmg != 0 || drainMana != 0) {
					_magic.commit(dmg, drainMana);
				}

				if (heal > 0) {
					if ((heal + _user.getCurrentHp()) > _user.getMaxHp()) {
						_user.setCurrentHp(_user.getMaxHp());
					} else {
						_user.setCurrentHp(heal + _user.getCurrentHp());
					}
				}

				if (cha instanceof L1PcInstance) {
					L1PcInstance pc = (L1PcInstance) cha;
					pc.turnOnOffLight();
					pc.sendPackets(new S_OwnCharAttrDef(pc));
					pc.sendPackets(new S_OwnCharStatus(pc));
					sendHappenMessage(pc);
				}

				addMagicList(cha, false);

				if (cha instanceof L1PcInstance) {
					L1PcInstance pc = (L1PcInstance) cha;
					pc.turnOnOffLight();
				}

				if (_skillId == DETECTION || _skillId == COUNTER_DETECTION) {
					detection(_player);
				}
			}

		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	private static final boolean isNotCancelable(int skillId) {
		return IntArrays.sContains(UNCANCELABLE, skillId);
	}

	private void detection(L1PcInstance pc) {
		if (!pc.isGmInvis() && pc.isInvisble()) {
			pc.delInvis();
			pc.beginInvisTimer();
		}

		for (L1PcInstance target : L1World.getInstance().getVisiblePlayer(pc)) {
			if (!target.isGmInvis() && target.isInvisble()) {
				target.delInvis();
			}
		}

		L1WorldTraps.getInstance().onDetection(pc);
	}

	private boolean isTargetCalc(L1Character cha) {
		if (_skill.getTarget().equals("attack") && _skillId != 18) {
			if (isPcSummonPet(cha)) {
				if (_player.getZoneType() == ZoneType.Safety
						|| cha.getZoneType() == ZoneType.Safety
						|| _player.checkNonPvP(_player, cha)) {
					return false;
				}
			}
		}

    // Steve_: return to nature doesn't work if target is in safety zone
    if (_skillId == RETURN_TO_NATURE && cha.getZoneType() == ZoneType.Safety){
      return false;
    }

		if (_skillId == FOG_OF_SLEEPING && _user.getId() == cha.getId()) {
			return false;
		}

		if (_skillId == MASS_SLOW) {
			if (_user.getId() == cha.getId()) {
				return false;
			}
			if (cha instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) cha;
				if (_user.getId() == summon.getMaster().getId()) {
					return false;
				}
			} else if (cha instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) cha;
				if (_user.getId() == pet.getMaster().getId()) {
					return false;
				}
			}
		}

		if (_skillId == MASS_TELEPORT) {
			if (_user.getId() != cha.getId()) {
				return false;
			}
		}

		return true;
	}

	private boolean isPcSummonPet(L1Character cha) {
		if (_calcType == PC_PC) {
			return true;
		}

		if (_calcType == PC_NPC) {
			if (cha instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) cha;
				if (summon.isExsistMaster()) {
					return true;
				}
			}
			if (cha instanceof L1PetInstance) {
				return true;
			}
		}
		return false;
	}

	private boolean isTargetFailure(L1Character cha) {
		boolean isTU = false;
		boolean isErase = false;
		boolean isManaDrain = false;
		int undeadType = 0;

		if (cha instanceof L1TowerInstance || cha instanceof L1DoorInstance) {
			return true;
		}

		if (cha instanceof L1PcInstance) {
			if (_calcType == PC_PC && _player.checkNonPvP(_player, cha)) {
				L1PcInstance pc = (L1PcInstance) cha;
				if (_player.getId() == pc.getId()
						|| (pc.getClanid() != 0 && _player.getClanid() == pc
								.getClanid())) {
					return false;
				}
				return true;
			}
			return false;
		}

		if (cha instanceof L1MonsterInstance) {
			L1MonsterInstance monster = (L1MonsterInstance) cha;
			isTU = monster.getNpcTemplate().get_IsTU();
			isErase = monster.getNpcTemplate().get_IsErase();
			undeadType = monster.getNpcTemplate().get_undead();
			isManaDrain = true;
		}

		if ((_skillId == TURN_UNDEAD && (undeadType == 0 || undeadType == 2))
				|| (_skillId == TURN_UNDEAD && isTU == false)
				|| ((_skillId == ERASE_MAGIC || _skillId == SLOW
						|| _skillId == MANA_DRAIN || _skillId == MASS_SLOW
						|| _skillId == ENTANGLE || _skillId == WIND_SHACKLE) && isErase == false)
				|| (_skillId == MANA_DRAIN && isManaDrain == false)) {
			return true;
		}
		return false;
	}

	private boolean isUseCounterMagic(L1Character cha) {
		if (_isCounterMagic && cha.hasSkillEffect(COUNTER_MAGIC)) {
			cha.removeSkillEffect(COUNTER_MAGIC);
			int castgfx = SkillTable.getInstance().findBySkillId(COUNTER_MAGIC)
					.getCastGfx();
			cha.broadcastPacket(new S_SkillSound(cha.getId(), castgfx));
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillSound(pc.getId(), castgfx));
			}
			return true;
		}
		return false;
	}

	public static void turnStone(final L1PcInstance player,
			final L1ItemInstance item, double penalty, int count, boolean report) {
		if (item == null)
			return;

		int dark = (int) (penalty * (10 + (player.getLevel() * 0.8) + (player
				.getWis() - 6) * 1.2));
		int brave = (int) (dark / 2.1);
		int wise = (int) (brave / 2.0);
		int kaiser = (int) (wise / 1.9);

		switch (item.getItem().getItemId()) {
		case BRING_STONE:
			turnStone(player, item, dark, DARK_STONE, "$2475", count, report);
			break;
		case DARK_STONE:
			turnStone(player, item, brave, BRAVE_STONE, "$2476", count, report);
			break;
		case BRAVE_STONE:
			turnStone(player, item, wise, WISE_STONE, "$2477", count, report);
			break;
		case WISE_STONE:
			turnStone(player, item, kaiser, KAISER_STONE, "$2478", count, report);
			break;
		}
	}

	private static void turnStone(final L1PcInstance player,
			final L1ItemInstance item, int chance, int nextStone, String name,
			int count, boolean report) {
		// This should never actually happen...
		if (count > item.getCount()) {
			_log.log(Level.WARNING, "turnStone count did not match.");
			return;
		}

		RandomGenerator random = RandomGeneratorFactory.getSharedRandom();
		L1PcInventory inventory = player.getInventory();

		for (int i = 0; i < count; i++) {
			inventory.removeItem(item, 1);
			if (chance > random.nextInt(100) + 1) {
				inventory.storeItem(nextStone, 1);
				if (report)
					player.sendPackets(new S_ServerMessage(403, name)); // obtained 'item'.
			} else if (report)
				player.sendPackets(SkillFailed);
		}
	}
}
