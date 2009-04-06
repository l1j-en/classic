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

package l1j.server.server.model.skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
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
import l1j.server.server.model.Instance.*;
import l1j.server.server.model.poison.L1DamagePoison;
import l1j.server.server.model.trap.L1WorldTraps;
import l1j.server.server.serverpackets.S_AttackMissPacket;
import l1j.server.server.serverpackets.S_ChangeHeading;
import l1j.server.server.serverpackets.S_ChangeName;
import l1j.server.server.serverpackets.S_ChangeShape;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_ChatPacket;
import l1j.server.server.serverpackets.S_CurseBlind;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_Dexup;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_DoActionShop;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_Invis;
import l1j.server.server.serverpackets.S_Light;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_NpcChatPacket;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_Paralysis;
import l1j.server.server.serverpackets.S_Poison;
import l1j.server.server.serverpackets.S_RangeSkill;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_ShowPolyList;
import l1j.server.server.serverpackets.S_ShowSummonList;
import l1j.server.server.serverpackets.S_SkillBrave;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillIconAura;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SkillIconShield;
import l1j.server.server.serverpackets.S_SkillIconWindShackle;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_Sound;
import l1j.server.server.serverpackets.S_Strup;
import l1j.server.server.serverpackets.S_TrueTarget;
import l1j.server.server.serverpackets.S_UseArrowSkill;
import l1j.server.server.serverpackets.S_UseAttackSkill;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Skills;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1SkillUse {
	public static final int TYPE_NORMAL = 0;
	public static final int TYPE_LOGIN = 1;
	public static final int TYPE_SPELLSC = 2;
	public static final int TYPE_NPCBUFF = 3;
	public static final int TYPE_GMBUFF = 4;

	private L1Skills _skill;
	private int _skillId;
	private int _getBuffDuration;
	private int _shockStunDuration;
	private int _getBuffIconDuration;
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
	private boolean _isGlanceCheckFail = false; // added for spell LoS. do not remove.

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
			171, SOUL_OF_FLAME, ADDITIONAL_FIRE };

	private static final int[] EXCEPT_COUNTER_MAGIC = { 1, 2, 3, 5, 8, 9, 12,
			13, 14, 19, 21, 26, 31, 32, 35, 37, 42, 43, 44, 48, 49, 52, 54, 55,
			57, 60, 61, 63, 67, 68, 69, 72, 73, 75, 78, 79, SHOCK_STUN,
			REDUCTION_ARMOR, BOUNCE_ATTACK, SOLID_CARRIAGE, COUNTER_BARRIER,
			97, 98, 99, 100, 101, 102, 104, 105, 106, 107, 109, 110, 111, 113,
			114, 115, 116, 117, 118, 129, 130, 131, 132, 134, 137, 138, 146,
			147, 148, 149, 150, 151, 155, 156, 158, 159, 161, 163, 164, 165,
			166, 168, 169, 170, 171, SOUL_OF_FLAME, ADDITIONAL_FIRE, 10026,
			10027, 10028, 10029 };

	private static final Map<Integer, Integer> CAN_STACK = new HashMap<Integer, Integer>();

	public L1SkillUse() {
		CAN_STACK.put(HASTE, 1800);
		CAN_STACK.put(HOLY_WALK, 1800);
//		CAN_STACK.put(ENCHANT_VENOM, 1800);
//		CAN_STACK.put(SHADOW_ARMOR, 1800);
		CAN_STACK.put(MOVING_ACCELERATION, 1800);
//		CAN_STACK.put(BURNING_SPIRIT, 1800);
		CAN_STACK.put(UNCANNY_DODGE, 1800);
		CAN_STACK.put(DRESS_MIGHTY, 1800);
		CAN_STACK.put(DRESS_DEXTERITY, 1800);
		CAN_STACK.put(DRESS_EVASION, 1800);
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

		_skill = SkillsTable.getInstance().getTemplate(skillid);
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
		
		if (_skillId == CREATE_MAGICAL_WEAPON || _skillId == BRING_STONE
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

			if (pc.isParalyzed()) { //
				return false;
			}
			if ((pc.isInvisble() || pc.isInvisDelay()) && !isInvisUsableSkill()) { //
				return false;
			}
			if (pc.getInventory().getWeight30() > 24) { //
				pc.sendPackets(new S_ServerMessage(316));
				return false;
			}
			int polyId = pc.getTempCharGfx();
			L1PolyMorph poly = PolyTable.getInstance().getTemplate(polyId);
		
			if (poly != null && !poly.canUseSkill()) {
				pc.sendPackets(new S_ServerMessage(285)); 
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

			if (pc.hasSkillEffect(SILENCE)
					|| pc.hasSkillEffect(AREA_OF_SILENCE)
					|| pc.hasSkillEffect(STATUS_POISON_SILENCE)) {
				pc.sendPackets(new S_ServerMessage(285)); 
				return false;
			}

			if (_skillId == DISINTEGRATE && pc.getLawful() < 500) {
				pc.sendPackets(new S_ServerMessage(352, "$967")); 
				return false;
			}

			if (isItemConsume() == false && !_player.isGm()) {
				_player.sendPackets(new S_ServerMessage(299));
				return false;
			}
		}
		else if (_user instanceof L1NpcInstance) {

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

		if (pc.isParalyzed()) { //
			return false;
		}
		if ((pc.isInvisble() || pc.isInvisDelay()) && !isInvisUsableSkill()) {
			return false;
		}

		return true;
	}

	private boolean isInvisUsableSkill() {
		for (int skillId : CAST_WITH_INVIS) {
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

			if (type == TYPE_NORMAL) { // When casting magic
				//Fix for stacking if that option is on
				_skillTime = SkillsTable.getInstance().getTemplate(_skillId).getBuffDuration();

				if(Config.STACKING) {					
					if (CAN_STACK.containsKey(_skillId)) {
						if (_target.hasSkillEffect(_skillId)) {
							_skillTime += _target.getSkillEffectTimeSec(_skillId);
						}
						if(_skillTime > CAN_STACK.get(_skillId)){
							_skillTime = CAN_STACK.get(_skillId);
						}
					}
				}

				runSkill();
				// this flag is only set to true if running the skill got far enough to check
				// if the target was valid, if not it won't consume HP/MP/reagents
				// Area check to make sure AoE always uses MP.
				if (!_isGlanceCheckFail || _skill.getArea() > 0 || _skill.getTarget().equals("none"))
					useConsume();
				sendGrfx(true);
				sendFailMessageHandle();
				setDelay();
			} else if (type == TYPE_LOGIN) { // Login (HPMP no material consumption, graphic)
				if(_skillId == DECREASE_WEIGHT) {//TODO
					sendGrfx(false);
				}
				runSkill();
			} else if (type == TYPE_SPELLSC) { 
				runSkill();
				sendGrfx(true);
			} else if (type == TYPE_GMBUFF) {
				runSkill();
				sendGrfx(false);
			} else if (type == TYPE_NPCBUFF) { 
				runSkill();
				sendGrfx(true);
			}
			setCheckedUseSkill(false);
		} catch (Exception e) {
			_log.log(Level.SEVERE, "", e);
		}
	}

	private void failSkill() {
		setCheckedUseSkill(false);
		if (_skillId == TELEPORT || _skillId == MASS_TELEPORT
				|| _skillId == TELEPORT_TO_MOTHER) {
			_player.sendPackets(new S_Paralysis(
					S_Paralysis.TYPE_TELEPORT_UNLOCK, false));
		}
	}

	private boolean isTarget(L1Character cha) throws Exception {
		boolean _flg = false;

		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			if (pc.isGhost() || pc.isGmInvis()) {
				return false;
			}
		}
		if (_calcType == NPC_PC
				&& (cha instanceof L1PcInstance || cha instanceof L1PetInstance || cha instanceof L1SummonInstance)) {
			_flg = true;
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

		if ((_skill.getTarget().equals("attack") || _skill.getType() == L1Skills.TYPE_ATTACK)
				&& _calcType == NPC_PC
				&& !(cha instanceof L1PetInstance)
				&& !(cha instanceof L1SummonInstance)
				&& !(cha instanceof L1PcInstance)) {
			return false;
		}

		if ((_skill.getTarget().equals("attack")
				|| _skill.getType() == L1Skills.TYPE_ATTACK)
				&& _calcType == NPC_NPC
				&& _user instanceof L1MonsterInstance
				&& cha instanceof L1MonsterInstance) {
			return false;
		}

		//
		if (_skill.getTarget().equals("none")
				&& _skill.getType() == L1Skills.TYPE_ATTACK
				&& (cha instanceof L1AuctionBoardInstance
						|| cha instanceof L1BoardInstance
						|| cha instanceof L1CrownInstance
						|| cha instanceof L1DwarfInstance
						|| cha instanceof L1EffectInstance
						|| cha instanceof L1FieldObjectInstance
						|| cha instanceof L1FurnitureInstance
						|| cha instanceof L1HousekeeperInstance
						|| cha instanceof L1MerchantInstance
						|| cha instanceof L1TeleporterInstance)) {
			return false;
		}

		//
		if (_skill.getType() == L1Skills.TYPE_ATTACK
				&& cha.getId() == _user.getId()) {
			return false;
		}

		//
		if (cha.getId() == _user.getId() && _skillId == HEAL_ALL) {
			return false;
		}

		if (((_skill.getTargetTo() & L1Skills.TARGET_TO_PC) == L1Skills.TARGET_TO_PC
				|| (_skill.getTargetTo() & L1Skills.TARGET_TO_CLAN) == L1Skills.TARGET_TO_CLAN || (_skill
				.getTargetTo() & L1Skills.TARGET_TO_PARTY) == L1Skills.TARGET_TO_PARTY)
				&& cha.getId() == _user.getId() && _skillId != HEAL_ALL) {
			return true; 
		}

		if (_user instanceof L1PcInstance
				&& (_skill.getTarget().equals("attack") || _skill.getType() == L1Skills.TYPE_ATTACK)
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

		if ((_skill.getTarget().equals("attack")
				|| _skill.getType() == L1Skills.TYPE_ATTACK)
				&& !(cha instanceof L1MonsterInstance)
				&& _isPK == false
				&& _target instanceof L1PcInstance) {
			L1PcInstance enemy = (L1PcInstance) cha;
			if (_skillId == COUNTER_DETECTION && enemy.getZoneType() != 1
					&& (cha.hasSkillEffect(INVISIBILITY)
							|| cha.hasSkillEffect(BLIND_HIDING))) {
				return true; 
			}
			if (_player.getClanid() != 0 && enemy.getClanid() != 0) {
				for (L1War war : L1World.getInstance().getWarList()) {
					if (war.CheckClanInWar(_player.getClanname())) { 
						if (war.CheckClanInSameWar( 
								_player.getClanname(), enemy.getClanname())) {
							if (L1CastleLocation.checkInAllWarArea(enemy.getX(),
									enemy.getY(), enemy.getMapId())) {
								return true;
							}
						}
					}
				}
			}
			return false; 
		}

		if (_user.glanceCheck(cha.getX(), cha.getY()) == false
				&& _skill.getIsThrough() == false) {
			if (!(_skill.getType() == L1Skills.TYPE_CHANGE || _skill.getType() == L1Skills.TYPE_RESTORE)) {
				_isGlanceCheckFail = true;
				return false; // Obstacles on a straight line
			}
		}

		if (cha.hasSkillEffect(ICE_LANCE)
				&& (_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD)) {
			return false;
		}

		if (cha.hasSkillEffect(FREEZING_BLIZZARD)
				&& (_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD)) {
			return false;
		}

		if (cha.hasSkillEffect(EARTH_BIND) && _skillId == EARTH_BIND) {
			return false; 
		}

		if (!(cha instanceof L1MonsterInstance)
				&& (_skillId == TAMING_MONSTER || _skillId == CREATE_ZOMBIE)) {
			return false; 
		}
		if (cha.isDead()
				&& (_skillId != CREATE_ZOMBIE
				&& _skillId != RESURRECTION
				&& _skillId != GREATER_RESURRECTION
				&& _skillId != CALL_OF_NATURE)) {
			return false; 
		}

		if (cha.isDead() == false
				&& (_skillId == CREATE_ZOMBIE
				|| _skillId == RESURRECTION
				|| _skillId == GREATER_RESURRECTION
				|| _skillId == CALL_OF_NATURE)) {
			return false; 
		}

		if ((cha instanceof L1TowerInstance || cha instanceof L1DoorInstance)
				&& (_skillId == CREATE_ZOMBIE
				|| _skillId == RESURRECTION
				|| _skillId == GREATER_RESURRECTION
				|| _skillId == CALL_OF_NATURE)) {
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
						|| _skillId == DECAY_POTION || _skillId == MASS_TELEPORT
						|| _skillId == DETECTION || _skillId == DARK_BLIND 
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

		if ((_skill.getTargetTo() & L1Skills.TARGET_TO_PC) == L1Skills.TARGET_TO_PC 
				&& cha instanceof L1PcInstance) {
			_flg = true;
		} else if ((_skill.getTargetTo() & L1Skills.TARGET_TO_NPC) == L1Skills.TARGET_TO_NPC 
				&& (cha instanceof L1MonsterInstance
						|| cha instanceof L1NpcInstance
						|| cha instanceof L1SummonInstance || cha instanceof L1PetInstance)) {
			_flg = true;
		} else if ((_skill.getTargetTo() & L1Skills.TARGET_TO_PET) == L1Skills
				.TARGET_TO_PET && _user instanceof L1PcInstance) { // 
			if (cha instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) cha;
				if (summon.getMaster() != null) {
					if (_player.getId() == summon.getMaster().getId()) {
						_flg = true;
					}
				}
			}
			if (cha instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) cha;
				if (pet.getMaster() != null) {
					if (_player.getId() == pet.getMaster().getId()) {
						_flg = true;
					}
				}
			}
		}

		if (_calcType == PC_PC && cha instanceof L1PcInstance) {
			if ((_skill.getTargetTo() & L1Skills.TARGET_TO_CLAN) == L1Skills.TARGET_TO_CLAN
					&& ((_player.getClanid() != 0 
					&& _player.getClanid() == ((L1PcInstance) cha).getClanid()) || _player
							.isGm())) {
				return true;
			}
			if ((_skill.getTargetTo() & L1Skills.TARGET_TO_PARTY) == L1Skills.TARGET_TO_PARTY
					&& (_player.getParty() 
							.isMember((L1PcInstance) cha) || _player.isGm())) {
				return true;
			}
		}

		return _flg;
	}

	private void makeTargetList() {
		try {
			if (_type == TYPE_LOGIN) { // 
				_targetList.add(new TargetStatus(_user));
				return;
			}
			if (_skill.getTargetTo() == L1Skills.TARGET_TO_ME
					&& (_skill.getType() & L1Skills.TYPE_ATTACK) != L1Skills.TYPE_ATTACK) {
				_targetList.add(new TargetStatus(_user)); 
				return;
			}

			if (_skill.getRanged() != -1) {
				if (_user.getLocation().getTileLineDistance(
						_target.getLocation()) > _skill.getRanged()) {
					return; //
				}
			} else {
				if (!_user.getLocation().isInScreen(_target.getLocation())) {
					return; //
				}
			}

			if (isTarget(_target) == false
					&& !(_skill.getTarget().equals("none"))) {
				return;
			}

			if (_skillId == LIGHTNING) {
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
				if (_user.glanceCheck(_target.getX(), _target.getY()) 
				== false) {
					if ((_skill.getType() & L1Skills.TYPE_ATTACK) == L1Skills.TYPE_ATTACK) {
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
								.getType() == L1Skills.TYPE_ATTACK)) {
					_targetList.add(new TargetStatus(_user));
				}

				List<L1Object> objects;
				if (_skill.getArea() == -1) {
					objects = L1World.getInstance()
							.getVisibleObjects(_user);
				} else {
					objects = L1World.getInstance()
							.getVisibleObjects(_target, _skill.getArea());
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
		if(msgID == 161) { //TODO
			if (_skillId == BLESSED_ARMOR || _skillId == ENCHANT_WEAPON) {	// happen message not needed here now
				return;
			} else if ((_skillId == BLESS_WEAPON || _skillId == HOLY_WEAPON) && pc != null) {
				L1ItemInstance weapon = pc.getWeapon();
				String weaponString = "";
				if (weapon != null)
				{
					weaponString = weapon.getName();
				}
				else
				{
					weaponString = "hands";
				}
				pc.sendPackets(new S_ServerMessage(msgID, weaponString, "blue", "short while"));
			} else {//Have to get other fixes here for items that are not selected
				pc.sendPackets(new S_ServerMessage(msgID));
			}
		} else if (msgID > 0) {
			pc.sendPackets(new S_ServerMessage(msgID));
		}
	}

	private void sendFailMessageHandle() {
		if (_skill.getType() != L1Skills.TYPE_ATTACK
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

		if ((_skill.getSkillLevel() >= 17 && magicattr != 0) 
				&& (magicattr != _player.getElfAttr() 
				&& !_player.isGm())) { 
			return false;
		}
		return true;
	}

	private boolean isEnoughHp() {
		return false;
	}

	private boolean isEnoughMp() {
		return false;
	}

	//
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

			//
			if (_player.getInt() > 12
					&& _skillId > HOLY_WEAPON
					&& _skillId <= FREEZING_BLIZZARD) { // LV2
				_mpConsume--;
			}
			if (_player.getInt() > 13
					&& _skillId > STALAC
					&& _skillId <= FREEZING_BLIZZARD) { // LV3
				_mpConsume--;
			}
			if (_player.getInt() > 14
					&& _skillId > WEAK_ELEMENTAL
					&& _skillId <= FREEZING_BLIZZARD) { // LV4
				_mpConsume--;
			}
			if (_player.getInt() > 15
					&& _skillId > MEDITATION
					&& _skillId <= FREEZING_BLIZZARD) { // LV5
				_mpConsume--;
			}
			if (_player.getInt() > 16
					&& _skillId > DARKNESS
					&& _skillId <= FREEZING_BLIZZARD) { // LV6
				_mpConsume--;
			}
			if (_player.getInt() > 17
					&& _skillId > BLESS_WEAPON
					&& _skillId <= FREEZING_BLIZZARD) { // LV7
				_mpConsume--;
			}
			if (_player.getInt() > 18
					&& _skillId > DISEASE
					&& _skillId <= FREEZING_BLIZZARD) { // LV8
				_mpConsume--;
			}

			if (_player.getInt() > 12
					&& _skillId >= SHOCK_STUN && _skillId <= COUNTER_BARRIER) {
				_mpConsume -= (_player.getInt() - 12);
			}

			if (_skillId == PHYSICAL_ENCHANT_DEX
					&& _player.getInventory().checkEquipped(20013)) {
				_mpConsume /= 2;
			}
			if (_skillId == HASTE
					&& _player.getInventory().checkEquipped(20013)) { 
				_mpConsume /= 2;
			}
			if (_skillId == HEAL
					&& _player.getInventory().checkEquipped(20014)) { 
				_mpConsume /= 2;
			}
			if (_skillId == EXTRA_HEAL
					&& _player.getInventory().checkEquipped(20014)) {
				_mpConsume /= 2;
			}
			if (_skillId == ENCHANT_WEAPON
					&& _player.getInventory().checkEquipped(20015)) { 
				_mpConsume /= 2;
			}
			if (_skillId == DETECTION
					&& _player.getInventory().checkEquipped(20015)) { 
				_mpConsume /= 2;
			}
			if (_skillId == PHYSICAL_ENCHANT_STR
					&& _player.getInventory().checkEquipped(20015)) { 
				_mpConsume /= 2;
			}
			if (_skillId == HASTE
					&& _player.getInventory().checkEquipped(20008)) { 
				_mpConsume /= 2;
			}
			if (_skillId == GREATER_HASTE
					&& _player.getInventory().checkEquipped(20023)) {
				_mpConsume /= 2;
			}

			if (0 < _skill.getMpConsume()) {
				_mpConsume = Math.max(_mpConsume, 1); 
			}
		}

		if (currentHp < _hpConsume + 1) {
			if (_user instanceof L1PcInstance) {
				_player.sendPackets(new S_ServerMessage(279));
			}
			return false;
		} else if (currentMp < _mpConsume) {
			if (_user instanceof L1PcInstance) {
				_player.sendPackets(new S_ServerMessage(278));
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
		if (_skillTime == 0) {
			_getBuffDuration = _skill.getBuffDuration() * 1000; 
			if (_skill.getBuffDuration() == 0) {
				if (_skillId == INVISIBILITY) { 
					cha.setSkillEffect(INVISIBILITY, 0);
				}
				return;
			}
		} else {
			_getBuffDuration = _skillTime * 1000; 
		}

		if (_skillId == SHOCK_STUN) {
			_getBuffDuration = _shockStunDuration;
		}

		if (_skillId == CURSE_POISON) { // 
			return;
		}
		if (_skillId == CURSE_PARALYZE
				|| _skillId == CURSE_PARALYZE2) { 
			return;
		}
		if (_skillId == SHAPE_CHANGE) { // 
			return;
		}
		if (!(cha instanceof L1PcInstance) && (_skillId == CURSE_BLIND || _skillId == DARKNESS || _skillId == DARK_BLIND)) { // BCM: fix darkness exploit
			return;
		}
		if (_skillId == BLESSED_ARMOR || _skillId == HOLY_WEAPON 
				|| _skillId == ENCHANT_WEAPON || _skillId == BLESS_WEAPON
				|| _skillId == SHADOW_FANG) {
			return;
		}
		if ((_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD)
				&& !_isFreeze) {
			return;
		}
		cha.setSkillEffect(_skillId, _getBuffDuration);

		if (cha instanceof L1PcInstance && repetition) { 
			L1PcInstance pc = (L1PcInstance) cha;
			sendIcon(pc);
		}
	}

	private void sendIcon(L1PcInstance pc) {
		if (_skillTime == 0) {
			_getBuffIconDuration = _skill.getBuffDuration(); 
		} else {
			_getBuffIconDuration = _skillTime; 
		}

		if (_skillId == SHIELD) {
			pc.sendPackets(new S_SkillIconShield(5, _getBuffIconDuration));
		} else if (_skillId == SHADOW_ARMOR) { 
			pc.sendPackets(new S_SkillIconShield(3, _getBuffIconDuration));
		} else if (_skillId == DRESS_DEXTERITY) { 
			pc.sendPackets(new S_Dexup(pc, 2, _getBuffIconDuration));
		} else if (_skillId == DRESS_MIGHTY) { 
			pc.sendPackets(new S_Strup(pc, 2, _getBuffIconDuration));
		} else if (_skillId == GLOWING_AURA) { 
			pc.sendPackets(new S_SkillIconAura(113, _getBuffIconDuration));
		} else if (_skillId == SHINING_AURA) { 
			pc.sendPackets(new S_SkillIconAura(114, _getBuffIconDuration));
		} else if (_skillId == BRAVE_AURA) {
			pc.sendPackets(new S_SkillIconAura(116, _getBuffIconDuration));
		} else if (_skillId == FIRE_WEAPON) { 
			pc.sendPackets(new S_SkillIconAura(147, _getBuffIconDuration));
		} else if (_skillId == WIND_SHOT) { 
			pc.sendPackets(new S_SkillIconAura(148, _getBuffIconDuration));
		} else if (_skillId == FIRE_BLESS) { 
			pc.sendPackets(new S_SkillIconAura(154, _getBuffIconDuration));
		} else if (_skillId == STORM_EYE) {
			pc.sendPackets(new S_SkillIconAura(155, _getBuffIconDuration));
		} else if (_skillId == EARTH_BLESS) { 
			pc.sendPackets(new S_SkillIconShield(7, _getBuffIconDuration));
		} else if (_skillId == BURNING_WEAPON) { 
			pc.sendPackets(new S_SkillIconAura(162, _getBuffIconDuration));
		} else if (_skillId == STORM_SHOT) { 
			pc.sendPackets(new S_SkillIconAura(165, _getBuffIconDuration));
		} else if (_skillId == IRON_SKIN) { 
			pc.sendPackets(new S_SkillIconShield(10, _getBuffIconDuration));
		} else if (_skillId == EARTH_SKIN) { 
			pc.sendPackets(new S_SkillIconShield(6, _getBuffIconDuration));
		} else if (_skillId == PHYSICAL_ENCHANT_STR) { 
			pc.sendPackets(new S_Strup(pc, 5, _getBuffIconDuration));
		} else if (_skillId == PHYSICAL_ENCHANT_DEX) {
			pc.sendPackets(new S_Dexup(pc, 5, _getBuffIconDuration));
		} else if (_skillId == HASTE || _skillId == GREATER_HASTE) { 
			pc.sendPackets(new S_SkillHaste(pc.getId(), 1,
					_getBuffIconDuration));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1, 0));
		} else if (_skillId == HOLY_WALK
				|| _skillId == MOVING_ACCELERATION || _skillId == WIND_WALK) {
			pc.sendPackets(new S_SkillBrave(pc.getId(), 4,
					_getBuffIconDuration));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 4, 0));
		} else if (_skillId == SLOW
				|| _skillId == MASS_SLOW || _skillId == ENTANGLE) {
			pc.sendPackets(new S_SkillHaste(pc.getId(), 2,
					_getBuffIconDuration));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 2, 0));
		} else if (_skillId == IMMUNE_TO_HARM) {
			pc.sendPackets(new S_SkillIconGFX(40, _getBuffIconDuration));
		}
		pc.sendPackets(new S_OwnCharStatus(pc));
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

			if (_skillId == SHOCK_STUN) {
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
				if (isPcSummonPet(_target)) { // 
					if (_player.getZoneType() == 1
							|| _target.getZoneType() == 1 
							|| _player.checkNonPvP(_player, _target)) { 
						_player.sendPackets(new S_UseAttackSkill(_player, 0,
								castgfx, _targetX, _targetY, actionId)); 
						_player.broadcastPacket(new S_UseAttackSkill(_player,
								0, castgfx, _targetX, _targetY, actionId));
						return;
					}
				}

				if (_skill.getArea() == 0) {
					_player.sendPackets(new S_UseAttackSkill(_player, targetid,
							castgfx, _targetX, _targetY, actionId));
					_player.broadcastPacket(new S_UseAttackSkill(_player,
							targetid, castgfx, _targetX, _targetY, actionId));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							targetid, ActionCodes.ACTION_Damage), _player);
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
			} else if (_skill.getTarget().equals("none") && _skill.getType() ==
					L1Skills.TYPE_ATTACK) { 
				L1Character[] cha = new L1Character[_targetList.size()];
				int i = 0;
				for (TargetStatus ts : _targetList) {
					cha[i] = ts.getTarget();
					cha[i].broadcastPacketExceptTargetSight(new S_DoActionGFX(
							cha[i].getId(), ActionCodes.ACTION_Damage),
									_player);
					i++;
				}
				_player.sendPackets(new S_RangeSkill(_player, cha, castgfx,
						actionId, S_RangeSkill.TYPE_NODIR));
				_player.broadcastPacket(new S_RangeSkill(_player, cha,
						castgfx, actionId, S_RangeSkill.TYPE_NODIR));
			} else { 
				if (_skillId != 5 && _skillId != 69 && _skillId != 131) {
					if (isSkillAction) {
						S_DoActionGFX gfx = new S_DoActionGFX(_player.getId(),
								_skill.getActionId());
						_player.sendPackets(gfx);
						_player.broadcastPacket(gfx);
					}
					if (_skillId == COUNTER_MAGIC
							|| _skillId == COUNTER_BARRIER
							|| _skillId == COUNTER_MIRROR) {
						_player.sendPackets(new S_SkillSound(targetid,
								castgfx));
					} else if (_skillId == TRUE_TARGET) { 
						return;
					} else if (_skillId == DECREASE_WEIGHT && isSkillAction) {
						_player.sendPackets(new S_SkillSound(targetid, _skill.getCastGfx()));
						_player.broadcastPacket(new S_SkillSound(targetid,
								_skill.getCastGfx()));
					} else {
						_player.sendPackets(new S_SkillSound(targetid,
								castgfx));
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

			if (_targetList.size() == 0 && !(_skill.getTarget()
					.equals("none"))) {
				S_DoActionGFX gfx = new S_DoActionGFX(_user.getId(), _skill
						.getActionId());
				_user.broadcastPacket(gfx);
				return;
			}

			if (_skill.getTarget().equals("attack") && _skillId != 18) {
				if (_skill.getArea() == 0) { //
					_user.broadcastPacket(new S_UseAttackSkill(_user, targetid,
							castgfx, _targetX, _targetY, actionId));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							targetid, ActionCodes.ACTION_Damage), _user);
				} else { //
					L1Character[] cha = new L1Character[_targetList.size()];
					int i = 0;
					for (TargetStatus ts : _targetList) {
						cha[i] = ts.getTarget();
						cha[i].broadcastPacketExceptTargetSight(
								new S_DoActionGFX(cha[i].getId(), ActionCodes
										.ACTION_Damage), _user);
						i++;
					}
					_user.broadcastPacket(new S_RangeSkill(_user, cha,
							castgfx, actionId, S_RangeSkill.TYPE_DIR));
				}
			} else if (_skill.getTarget().equals("none") && _skill.getType() ==
					L1Skills.TYPE_ATTACK) { 
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
					S_DoActionGFX gfx = new S_DoActionGFX(_user.getId(), _skill
							.getActionId());
					_user.broadcastPacket(gfx);
					_user.broadcastPacket(new S_SkillSound(targetid, castgfx));
				}
			}
		}
	}

	private void deleteRepeatedSkills(L1Character cha) {
		final int[][] repeatedSkills = {
				
               // { HOLY_WEAPON, ENCHANT_WEAPON, BLESS_WEAPON, SHADOW_FANG },
				{ FIRE_WEAPON, WIND_SHOT, FIRE_BLESS, STORM_EYE,
						BURNING_WEAPON, STORM_SHOT },
				{ SHIELD, SHADOW_ARMOR, EARTH_SKIN, EARTH_BLESS, IRON_SKIN },
				{ HOLY_WALK, MOVING_ACCELERATION, WIND_WALK, STATUS_BRAVE,
						STATUS_ELFBRAVE },
				{ HASTE, GREATER_HASTE, STATUS_HASTE },
				{ PHYSICAL_ENCHANT_DEX, DRESS_DEXTERITY },
				{ PHYSICAL_ENCHANT_STR, DRESS_MIGHTY },
				{ GLOWING_AURA, SHINING_AURA } };

		for (int[] skills : repeatedSkills) {
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

	private void runSkill() {

		if (_skillId == LIFE_STREAM) {
			L1EffectSpawn.getInstance().spawnEffect(81169,
					_skill.getBuffDuration() * 1000,
					_targetX, _targetY, _user.getMapId());
			return;
		}

		if (_skillId == FIRE_WALL) { //
			L1EffectSpawn.getInstance()
					.doSpawnFireWall(_user, _targetX, _targetY);
			return;
		}


		for (int skillId : EXCEPT_COUNTER_MAGIC) {
			if (_skillId == skillId) {
				_isCounterMagic = false; 
				break;
			}
		}

		if (_skillId == SHOCK_STUN && _user instanceof L1PcInstance) {
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

				if ((_skill.getType() == L1Skills.TYPE_CURSE || _skill
						.getType() == L1Skills.TYPE_PROBABILITY)
						&& isTargetFailure(cha)) {
					iter.remove();
					continue;
				}

				if (cha instanceof L1PcInstance) { 
					if (_skillTime == 0) {
						_getBuffIconDuration = _skill.getBuffDuration(); 
					} else {
						_getBuffIconDuration = _skillTime;
					}
				}

				deleteRepeatedSkills(cha); 

				if (_skill.getType() == L1Skills.TYPE_ATTACK
						&& _user.getId() != cha.getId()) {
					if (isUseCounterMagic(cha)) { 
						iter.remove();
						continue;
					}
					dmg = _magic.calcMagicDamage(_skillId);
					cha.removeSkillEffect(ERASE_MAGIC); 
				} else if (_skill.getType() == L1Skills.TYPE_CURSE
						|| _skill.getType() == L1Skills.TYPE_PROBABILITY) { 
					isSuccess = _magic.calcProbabilityMagic(_skillId);
					if (_skillId != ERASE_MAGIC) {
						cha.removeSkillEffect(ERASE_MAGIC); //
					}
					if (_skillId != FOG_OF_SLEEPING) {
						cha.removeSkillEffect(FOG_OF_SLEEPING); //
					}
					if (isSuccess) { 
						if (isUseCounterMagic(cha)) { // JE^[}WbN
							iter.remove();
							continue;
						}
					} else { 
						if (_skillId == FOG_OF_SLEEPING
								&& cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							pc.sendPackets(new S_ServerMessage(297)); 
						}
						iter.remove();
						continue;
					}
				} else if (_skill.getType() == L1Skills.TYPE_HEAL) {
					dmg = -1 * _magic.calcHealing(_skillId);
					if (cha.hasSkillEffect(WATER_LIFE)) { 
						dmg *= 2;
					}
					if (cha.hasSkillEffect(POLLUTE_WATER)) { 
						dmg /= 2;
					}
				}

				if (cha.hasSkillEffect(_skillId) && _skillId != SHOCK_STUN) {
					addMagicList(cha, true);
					if (_skillId != SHAPE_CHANGE) { 
						continue;
					}
				}

				//
				if (_skillId == HASTE) {
					if (cha.getMoveSpeed() != 2) {
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							if (pc.getHasteItemEquipped() > 0) {
								continue;
							}
							pc.setDrink(false);
							pc.sendPackets(new S_SkillHaste(pc.getId(), 1,
									_getBuffIconDuration));
						}
						cha.broadcastPacket(new S_SkillHaste(cha.getId(),
										1, 0));
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
							if (L1World.getInstance().getVisiblePlayer(pc,
									0).size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(pc,
												0)) {
									if (!visiblePc.isDead()) {
										_player.sendPackets(new S_ServerMessage(
												592));
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
							if (npc instanceof L1PetInstance
									&& L1World.getInstance()
											.getVisiblePlayer(npc, 0)
											.size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(npc,
												0)) {
									if (!visiblePc.isDead()) {
										_player.sendPackets(new S_ServerMessage(
												592));
										return;
									}
								}
							}
							if (npc.getCurrentHp() == 0 && npc.isDead()) {
								npc.resurrect(npc.getMaxHp() / 4);
								npc.setResurrect(true);
							}
						}
					}
				} else if (_skillId == CALL_OF_NATURE) {
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (_player.getId() != pc.getId()) {
							if (L1World.getInstance().getVisiblePlayer(pc,
									0).size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(pc,
												0)) {
									if (!visiblePc.isDead()) {
										_player.sendPackets(new S_ServerMessage(
												592));
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
							if (npc instanceof L1PetInstance
									&& L1World.getInstance()
											.getVisiblePlayer(npc, 0)
											.size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(npc,
												0)) {
									if (!visiblePc.isDead()) {
										_player.sendPackets(new S_ServerMessage(
												592));
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
						L1PcInstance players[] = L1World.getInstance().getClan(
								pri.getClanname()).getOnlineClanMember();
						for (L1PcInstance pc : players) {
							pc.sendPackets(new S_TrueTarget(_targetID, pc
									.getId(), _message));
						}
					}
				} else if (_skillId == ELEMENTAL_FALL_DOWN) {
					if (_user instanceof L1PcInstance) {
						int playerAttr = _player.getElfAttr();
						int i = -50;
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							switch (playerAttr) {
							case 0:
								_player.sendPackets(new S_ServerMessage(79));
								break;
							case 1:
								pc.addEarth(i);
								pc.setAddAttrKind(1);
								break;
							case 2:
								pc.addFire(i);
								pc.setAddAttrKind(2);
								break;
							case 4:
								pc.addWater(i);
								pc.setAddAttrKind(4);
								break;
							case 8:
								pc.addWind(i);
								pc.setAddAttrKind(8);
								break;
							default:
								break;
							}
						} else if (cha instanceof L1MonsterInstance) {
							L1MonsterInstance mob = (L1MonsterInstance) cha;
							switch (playerAttr) {
							case 0:
								_player.sendPackets(new S_ServerMessage(79));
								break;
							case 1:
								mob.addEarth(i);
								mob.setAddAttrKind(1);
								break;
							case 2:
								mob.addFire(i);
								mob.setAddAttrKind(2);
								break;
							case 4:
								mob.addWater(i);
								mob.setAddAttrKind(4);
								break;
							case 8:
								mob.addWind(i);
								mob.setAddAttrKind(8);
								break;
							default:
								break;
							}
						}
					}
				}
				else if ((_skillId == HEAL || _skillId == EXTRA_HEAL
						|| _skillId == GREATER_HEAL || _skillId == FULL_HEAL
						|| _skillId == HEAL_ALL || _skillId == NATURES_TOUCH
						|| _skillId == NATURES_BLESSING)
						&& (_user instanceof L1PcInstance)) {
					cha.removeSkillEffect(WATER_LIFE);
				}

				else if (_skillId == CHILL_TOUCH || _skillId == VAMPIRIC_TOUCH) {
					heal = dmg;
				} else if (_skillId == TRIPLE_ARROW) { 
		
					boolean gfxcheck = false;
					int[] BowGFX = { 138, 37, 3860, 3126, 3420, 2284, 3105,
							3145, 3148, 3151, 3871, 4125, 2323, 3892, 3895,
							3898, 3901, 4917, 4918, 4919, 4950, 6087, 6140,
							6145, 6150, 6155, 6160, 6269, 6272, 6275, 6278 };
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
 					_player.sendPackets(new S_SkillSound(_player.getId(),
							4394));
					_player.broadcastPacket(new S_SkillSound(_player.getId(),
							4394));
				} else if (_skillId == 10026 || _skillId == 10027
						|| _skillId == 10028 || _skillId == 10029) { 
					if (_user instanceof L1NpcInstance) {
						_user.broadcastPacket(new S_NpcChatPacket(_npc,
								"$3717", 0));
					} else {
						_player.broadcastPacket(new S_ChatPacket(_player,
								"$3717", 0, 0)); 
					}
					dmg = cha.getCurrentHp();
				} else if (_skillId == 10057) { 
					L1Teleport.teleportToTargetFront(cha, _user, 1);
				}

				else if (_skillId == SLOW
						|| _skillId == MASS_SLOW || _skillId == ENTANGLE) {
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
									_getBuffIconDuration));
						}
						cha.broadcastPacket(new S_SkillHaste(cha.getId(),
								2, _getBuffIconDuration));
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
				} else if (_skillId == CURSE_BLIND || _skillId == DARKNESS || _skillId == DARK_BLIND) {
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
							&& !cha.hasSkillEffect(FOG_OF_SLEEPING)) {
						if (cha instanceof L1PcInstance) {
							L1CurseParalysis.curse(cha, 8000, 16000);
						} else if (cha instanceof L1MonsterInstance) {
							L1CurseParalysis.curse(cha, 0, 16000);
						}
					}
				} else if (_skillId == WEAKNESS) { 
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(-5);
						pc.addHitup(-1);
					}
				} else if (_skillId == DISEASE) { 
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(-6);
						pc.addAc(12);
					}
				} else if (_skillId == ICE_LANCE
						|| _skillId == FREEZING_BLIZZARD) { 
					_isFreeze = _magic.calcProbabilityMagic(_skillId);
					if (_isFreeze) {
						int time = _skill.getBuffDuration() * 1000;
						L1EffectSpawn.getInstance()
								.spawnEffect(81168, time,
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
				} else if (_skillId == EARTH_BIND) { //
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
						npc.setParalysisTime(_skill.getBuffDuration() * 1000);
					}
				} else if (_skillId == SHOCK_STUN) {
					int[] stunTimeArray = { 500, 1000, 1500, 2000, 2500, 3000 };
					Random random = new Random();
					int rnd = random.nextInt(stunTimeArray.length);
					_shockStunDuration = stunTimeArray[rnd];
					if (cha instanceof L1PcInstance
							&& cha.hasSkillEffect(SHOCK_STUN)) {
						_shockStunDuration += cha
								.getSkillEffectTimeSec(SHOCK_STUN) * 1000;
					}

					L1EffectSpawn.getInstance()
							.spawnEffect(81162, _shockStunDuration,
									cha.getX(), cha.getY(), cha.getMapId());
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
				} else if (_skillId == WIND_SHACKLE) { 
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_SkillIconWindShackle(pc.getId(),
								_getBuffIconDuration));
					}
				} else if (_skillId == CANCELLATION) {
					if (cha instanceof L1NpcInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						int npcId = npc.getNpcTemplate().get_npcId();
						if (npcId == 71092) { //
							if (npc.getGfxId() == npc.getTempCharGfx()) {
								npc.setTempCharGfx(1314);
								npc.broadcastPacket(new S_ChangeShape(npc
										.getId(), 1314));
								return;
							} else {
								return;
							}
						}
						if (npcId == 45640) { //
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
						if (npcId == 81209) { // 
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
						npc.broadcastPacket(new S_SkillHaste(cha.getId(), 0,
								0));
						npc.broadcastPacket(new S_SkillBrave(cha.getId(), 0,
								0));
						npc.setWeaponBreaked(false);
						npc.setParalyzed(false);
						npc.setParalysisTime(0);
					}
					for (int skillNum = SKILLS_BEGIN; skillNum <= SKILLS_END; skillNum++) {
						if (isNotCancelable(skillNum)) {
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
							L1PinkName.onAction(pc, _user);
						}
					}
				} else if (_skillId == TURN_UNDEAD 
						&& (undeadType == 1 || undeadType == 3)) {
					dmg = cha.getCurrentHp();
				} else if (_skillId == MANA_DRAIN) { 
					Random random = new Random();
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
								Random random = new Random();
								int weaponDamage = random.nextInt(_user
										.getInt() / 3) + 1;
								pc.sendPackets(new S_ServerMessage(268, weapon
										.getLogName()));
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
				} else if (_skillId == STATUS_FREEZE) { // Freeze
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_BIND,
								true));
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
								pc.sendPackets(new S_ServerMessage(79));
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
								pc.sendPackets(new S_ServerMessage(276));
								L1Teleport.teleport(pc, pc.getX(), pc.getY(),
										pc.getMapId(), pc.getHeading(), false);
							}
						}
					} else if (_skillId == TELEPORT_TO_MOTHER) {
																	
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getMap().isEscapable() || pc.isGm()) {
							L1Teleport.teleport(pc, 33051, 32337, (short) 4, 5,
									true);
						} else {
							pc.sendPackets(new S_ServerMessage(647));
							L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc
									.getMapId(), pc.getHeading(), false);
						}
					} else if (_skillId == CALL_CLAN) { // 
						L1PcInstance pc = (L1PcInstance) cha;
						L1PcInstance clanPc = (L1PcInstance) L1World
								.getInstance().findObject(_targetID);
						if (clanPc != null) {
							clanPc.setTempID(pc.getId()); //
							clanPc.sendPackets(new S_Message_YN(729, "")); //
						}
					} else if (_skillId == RUN_CLAN) { // 
						L1PcInstance pc = (L1PcInstance) cha;
						L1PcInstance clanPc = (L1PcInstance) L1World
								.getInstance().findObject(_targetID);
						if (clanPc != null) {
							if (pc.getMap().isEscapable() || pc.isGm()) {
								boolean castle_area = L1CastleLocation
										.checkInAllWarArea(
												clanPc.getX(), clanPc.getY(),
												clanPc.getMapId());
								if ((clanPc.getMapId() == 0
										|| clanPc.getMapId() == 4 || clanPc
										.getMapId() == 304)
										&& castle_area == false) {
									L1Teleport.teleport(pc, clanPc.getX(),
											clanPc.getY(), clanPc.getMapId(),
											5, true);
								} else {
									pc.sendPackets(new S_ServerMessage(547));
								}
							} else {
								pc.sendPackets(new S_ServerMessage(647));
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
								pc.sendPackets(
										new S_ServerMessage(79));
							} else if (safe_enchant == 0) { 
								pc.sendPackets( 
										new S_ServerMessage(79));
							} else if (item_type == 1 && enchant_level == 0) {
								if (!item.isIdentified()) {
									pc.sendPackets( 
											new S_ServerMessage(161, item_name,
													"$245", "$247"));
								} else {
									item_name = "+0 " + item_name;
									pc.sendPackets(
											new S_ServerMessage(161, "+0 "
													+ item_name, "$245", "$247"));
								}
								item.setEnchantLevel(1);
								pc.getInventory().updateItem(item,
										L1PcInventory.COL_ENCHANTLVL);
							} else {
								pc.sendPackets( 
										new S_ServerMessage(79));
							}
						} else {
							pc.sendPackets( 
									new S_ServerMessage(79));
						}
					} else if (_skillId == BRING_STONE) { 
						L1PcInstance pc = (L1PcInstance) cha;
						Random random = new Random();
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null) {
							int dark = (int) (10 + (pc.getLevel() * 0.8) + (pc
									.getWis() - 6) * 1.2);
							int brave = (int) (dark / 2.1);
							int wise = (int) (brave / 2.0);
							int kayser = (int) (wise / 1.9);
							int chance = random.nextInt(100) + 1;
							if (item.getItem().getItemId() == 40320) {
								pc.getInventory().removeItem(item, 1);
								if (dark >= chance) {
									pc.getInventory().storeItem(40321, 1);
									pc.sendPackets(new S_ServerMessage(403,
											"$2475")); 
								} else {
									pc.sendPackets(new S_ServerMessage(280)); 
								}
							} else if (item.getItem().getItemId() == 40321) {
								pc.getInventory().removeItem(item, 1);
								if (brave >= chance) {
									pc.getInventory().storeItem(40322, 1);
									pc.sendPackets(new S_ServerMessage(403,
											"$2476")); 
								} else {
									pc.sendPackets(new S_ServerMessage(280));
								}
							} else if (item.getItem().getItemId() == 40322) {
								pc.getInventory().removeItem(item, 1);
								if (wise >= chance) {
									pc.getInventory().storeItem(40323, 1);
									pc.sendPackets(new S_ServerMessage(403,
											"$2477"));
								} else {
									pc.sendPackets(new S_ServerMessage(280)); 
								}
							} else if (item.getItem().getItemId() == 40323) {
								pc.getInventory().removeItem(item, 1);
								if (kayser >= chance) {
									pc.getInventory().storeItem(40324, 1);
									pc.sendPackets(new S_ServerMessage(403,
											"$2478")); 
								} else {
									pc.sendPackets(new S_ServerMessage(280));
								}
							}
						}
					} else if (_skillId == SUMMON_MONSTER) { 
						L1PcInstance pc = (L1PcInstance) cha;
						int level = pc.getLevel();
						int[] summons;
						if (pc.getMap().isRecallPets() || pc.isGm()) {
							if (pc.getInventory().checkEquipped(20284)) {
								pc
										.sendPackets(new S_ShowSummonList(pc
												.getId()));
							} else {
								summons = new int[] { 81083, 81084, 81085,
										81086, 81087, 81088, 81089 };
								int summonid = 0;
								int summoncost = 6;
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
								int charisma = pc.getCha() + 6 - petcost;
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
							pc.sendPackets(new S_ServerMessage(79));
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
										Random random = new Random();
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
								pc.sendPackets(new S_ServerMessage(79));
							}
						}
					} else if (_skillId == ABSOLUTE_BARRIER) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.stopHpRegeneration();
						pc.stopMpRegeneration();
						pc.stopMpRegenerationByDoll();
					}

					if (_skillId == LIGHT) { 
						
					} else if (_skillId == GLOWING_AURA) { // 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addHitup(5);
						pc.addBowHitup(5);
						pc.addMr(20);
						pc.sendPackets(new S_SPMR(pc));
						pc.sendPackets(new S_SkillIconAura(113,
								_getBuffIconDuration));
					} else if (_skillId == SHINING_AURA) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-8);
						pc.sendPackets(new S_SkillIconAura(114,
								_getBuffIconDuration));
					} else if (_skillId == BRAVE_AURA) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(5);
						pc.sendPackets(new S_SkillIconAura(116,
								_getBuffIconDuration));
					} else if (_skillId == SHIELD) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-2);
						pc.sendPackets(new S_SkillIconShield(5,
								_getBuffIconDuration));
					} else if (_skillId == SHADOW_ARMOR) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-3);
						pc.sendPackets(new S_SkillIconShield(3,
								_getBuffIconDuration));
					} else if (_skillId == DRESS_DEXTERITY) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDex((byte) 2);
						pc
								.sendPackets(new S_Dexup(pc, 2,
										_getBuffIconDuration));
					} else if (_skillId == DRESS_MIGHTY) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addStr((byte) 2);
						pc
								.sendPackets(new S_Strup(pc, 2,
										_getBuffIconDuration));
					} else if (_skillId == SHADOW_FANG) { 
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory()
								.getItem(_itemobjid);
						if (item != null && item.getItem().getType2() == 1) {
							item.setSkillWeaponEnchant(pc, _skillId,
									_skill.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else if (_skillId == ENCHANT_WEAPON) { 
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory()
								.getItem(_itemobjid);
						if (item != null && item.getItem().getType2() == 1) {
							pc.sendPackets(new S_ServerMessage(161,
									item.getLogName(), "$245", "$247"));
							item.setSkillWeaponEnchant(pc, _skillId,
									_skill.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else if (_skillId == HOLY_WEAPON 
							|| _skillId == BLESS_WEAPON) {
						if (!(cha instanceof L1PcInstance)) {
							return;
						}
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getWeapon() == null) {
							pc.sendPackets(new S_ServerMessage(79));
							return;
						}
						for (L1ItemInstance item : pc.getInventory()
								.getItems()) {
							if (pc.getWeapon().equals(item)) {
								pc.sendPackets(new S_ServerMessage(161,
										item.getLogName(), "$245", "$247"));
								item.setSkillWeaponEnchant(pc, _skillId,
										_skill.getBuffDuration() * 1000);
								return;
							}
						}
					} else if (_skillId == BLESSED_ARMOR) {
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory()
								.getItem(_itemobjid);
						if (item != null && item.getItem().getType2() == 2
								&& item.getItem().getType() == 2) {
							pc.sendPackets(new S_ServerMessage(161, item
									.getLogName(), "$245", "$247"));
							item.setSkillArmorEnchant(pc, _skillId,
									_skill.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else if (_skillId == EARTH_BLESS) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-7);
						pc.sendPackets(new S_SkillIconShield(7,
								_getBuffIconDuration));
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
						// this has been changed to US server settings. do not remove.
						pc.setCurrentMp(pc.getCurrentMp() + 16);
					} else if (_skillId == ELEMENTAL_PROTECTION) {
						L1PcInstance pc = (L1PcInstance) cha;
						int attr = pc.getElfAttr();
						if (attr == 1) {
							pc.addEarth(50);
						} else if (attr == 2) {
							pc.addFire(50);
						} else if (attr == 4) {
							pc.addWater(50);
						} else if (attr == 8) {
							pc.addWind(50);
						}
					} else if (_skillId == INVISIBILITY
							|| _skillId == BLIND_HIDING) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Invis(pc.getId(), 1));
						pc.broadcastPacket(new S_RemoveObject(pc));
					} else if (_skillId == IRON_SKIN) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-10);
						pc.sendPackets(new S_SkillIconShield(10,
								_getBuffIconDuration));
					} else if (_skillId == EARTH_SKIN) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-6);
						pc.sendPackets(new S_SkillIconShield(6,
								_getBuffIconDuration));
					} else if (_skillId == PHYSICAL_ENCHANT_STR) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addStr((byte) 5);
						pc
								.sendPackets(new S_Strup(pc, 5,
										_getBuffIconDuration));
					} else if (_skillId == PHYSICAL_ENCHANT_DEX) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDex((byte) 5);
						pc
								.sendPackets(new S_Dexup(pc, 5,
										_getBuffIconDuration));
					} else if (_skillId == FIRE_WEAPON) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(4);
						pc.sendPackets(new S_SkillIconAura(147,
								_getBuffIconDuration));
					} else if (_skillId == FIRE_BLESS) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(4);
						pc.sendPackets(new S_SkillIconAura(154,
								_getBuffIconDuration));
					} else if (_skillId == BURNING_WEAPON) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(6);
						pc.addHitup(3);
						pc.sendPackets(new S_SkillIconAura(162,
								_getBuffIconDuration));
					} else if (_skillId == WIND_SHOT) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowHitup(6);
						pc.sendPackets(new S_SkillIconAura(148,
								_getBuffIconDuration));
					} else if (_skillId == STORM_EYE) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowHitup(2);
						pc.addBowDmgup(3);
						pc.sendPackets(new S_SkillIconAura(155,
								_getBuffIconDuration));
					} else if (_skillId == STORM_SHOT) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowDmgup(5);
						pc.addBowHitup(-1);
						pc.sendPackets(new S_SkillIconAura(165,
								_getBuffIconDuration));
					} else if (_skillId == BERSERKERS) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(10);
						pc.addDmgup(5);
						pc.addHitup(2);
					} else if (_skillId == SHAPE_CHANGE) { 
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_ShowPolyList(pc.getId()));
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
									_getBuffIconDuration));
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
								_getBuffIconDuration));
						pc.broadcastPacket(new S_SkillBrave(pc.getId(), 4,
								0));
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
							charisma += 12;
						} else if (_player.isWizard()) { 
							charisma += 6;
						}
						charisma -= petcost;
						if (charisma >= 6) { 
							L1SummonInstance summon = new L1SummonInstance(
									_targetNpc, _user, false);
							_target = summon; 
						} else {
							_player.sendPackets(new S_ServerMessage(319));
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
							charisma += 12;
						} else if (_player.isWizard()) { 
							charisma += 6;
						}
						charisma -= petcost;
						if (charisma >= 6) { 
							L1SummonInstance summon = new L1SummonInstance(
									_targetNpc, _user, true);
							_target = summon; 
						} else {
							_player.sendPackets(new S_ServerMessage(319)); 
						}
					} else if (_skillId == WEAK_ELEMENTAL) {
						if (cha instanceof L1MonsterInstance) {
							L1Npc npcTemp = ((L1MonsterInstance) cha)
									.getNpcTemplate();
							int weakAttr = npcTemp.get_weakAttr();
							if ((weakAttr & 1) == 1) { // 
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2169));
							}
							if ((weakAttr & 2) == 2) { // 
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2167));
							}
							if ((weakAttr & 4) == 4) { // 
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2166));
							}
							if ((weakAttr & 8) == 8) { // 
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
								_player.sendPackets(new S_ServerMessage(79));
							}
						}
					}
				}

				if (_skill.getType() == L1Skills.TYPE_HEAL
						&& _calcType == PC_NPC && undeadType == 1) {
					dmg *= -1; 
				}

				if (_skill.getType() == L1Skills.TYPE_HEAL
						&& _calcType == PC_NPC && undeadType == 3) {
					dmg = 0; 
				}

				if ((cha instanceof L1TowerInstance
						|| cha instanceof L1DoorInstance) && dmg < 0) { // 
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
					sendHappenMessage(pc); //
				}

				addMagicList(cha, false); //

				if (cha instanceof L1PcInstance) { //
					L1PcInstance pc = (L1PcInstance) cha;
					pc.turnOnOffLight();
				}
			}

			if (_skillId == DETECTION || _skillId == COUNTER_DETECTION) { 
				detection(_player);
			}

		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	private boolean isNotCancelable(int skillNum) {
		return skillNum == ENCHANT_WEAPON || skillNum == BLESSED_ARMOR
				|| skillNum == ABSOLUTE_BARRIER || skillNum == ADVANCE_SPIRIT
				|| skillNum == SHOCK_STUN || skillNum == SHADOW_FANG
				|| skillNum == REDUCTION_ARMOR || skillNum == SOLID_CARRIAGE
				|| skillNum == COUNTER_BARRIER;
	}

	private void detection(L1PcInstance pc) {
		if (!pc.isGmInvis() && pc.isInvisble()) { 
			pc.delInvis();
			pc.beginInvisTimer();
		}

		for (L1PcInstance tgt : L1World.getInstance().getVisiblePlayer(pc)) {
			if (!tgt.isGmInvis() && tgt.isInvisble()) {
				tgt.delInvis();
			}
		}
		L1WorldTraps.getInstance().onDetection(pc);
	}

	private boolean isTargetCalc(L1Character cha) {
		//
		if (_skill.getTarget().equals("attack") && _skillId != 18) { 
			if (isPcSummonPet(cha)) { //
				if (_player.getZoneType() == 1 || cha.getZoneType() == 1 
						|| _player.checkNonPvP(_player, cha)) { 
					return false;
				}
			}
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
		if (_calcType == PC_PC) { // 
			return true;
		}

		if (_calcType == PC_NPC) {
			if (cha instanceof L1SummonInstance) { // 
				L1SummonInstance summon = (L1SummonInstance) cha;
				if (summon.isExsistMaster()) { //
					return true;
				}
			}
			if (cha instanceof L1PetInstance) { // 
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

		if (cha instanceof L1TowerInstance || cha instanceof L1DoorInstance) { //
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
			isTU = ((L1MonsterInstance) cha).getNpcTemplate().get_IsTU();
		}

		if (cha instanceof L1MonsterInstance) { 
			isErase = ((L1MonsterInstance) cha).getNpcTemplate().get_IsErase();
		}

		if (cha instanceof L1MonsterInstance) { 
			undeadType = ((L1MonsterInstance) cha).getNpcTemplate()
					.get_undead();
		}

		if (cha instanceof L1MonsterInstance) {
			isManaDrain = true;
		}
	
		if ((_skillId == TURN_UNDEAD && (undeadType == 0 || undeadType == 2))
				|| (_skillId == TURN_UNDEAD && isTU == false)
				|| ((_skillId == ERASE_MAGIC || _skillId == SLOW
						|| _skillId == MANA_DRAIN || _skillId == MASS_SLOW
						|| _skillId == ENTANGLE || _skillId == WIND_SHACKLE)
								&& isErase == false)
				|| (_skillId == MANA_DRAIN && isManaDrain == false)) {
			return true;
		}
		return false;
	}
	private boolean isUseCounterMagic(L1Character cha) {
		if (_isCounterMagic && cha.hasSkillEffect(COUNTER_MAGIC)) {
			cha.removeSkillEffect(COUNTER_MAGIC);
			int castgfx = SkillsTable.getInstance().getTemplate(
					COUNTER_MAGIC).getCastGfx();
			cha.broadcastPacket(new S_SkillSound(cha.getId(), castgfx));
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillSound(pc.getId(), castgfx));
			}
			return true;
		}
		return false;
	}

}
