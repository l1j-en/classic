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

import static l1j.server.server.model.skill.L1SkillId.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.SkillTable;
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
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_Sound;
import l1j.server.server.serverpackets.S_Strup;
import l1j.server.server.serverpackets.S_TrueTarget;
import l1j.server.server.serverpackets.S_UseAttackSkill;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Skill;

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
	private boolean _checkedUseSkill = false; // 事前チェック済みか
	private int _leverage = 10; // 1/10倍なので10で1倍
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
		DRAGON_SKIN, FOE_SLAYER,
		AWAKEN_ANTHARAS, AWAKEN_FAFURION, AWAKEN_VALAKAS,
		MIRROR_IMAGE, ILLUSION_OGRE, ILLUSION_LICH, PATIENCE, 10026, 10027,
		ILLUSION_DIA_GOLEM, INSIGHT, ILLUSION_AVATAR, 10028, 10029 };


	public L1SkillUse() {
	}

	private static class TargetStatus {
		private L1Character _target = null;
		private boolean _isAction = false; // ダメージモーションが発生するか？
		private boolean _isSendStatus = false; // キャラクターステータスを送信するか？（ヒール、スローなど状態が変わるとき送る）
		private boolean _isCalc = true; // ダメージや確率魔法の計算をする必要があるか？

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

	/*
	 * 1/10倍で表現する。
	 */
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
		// 初期設定ここから
		setCheckedUseSkill(true);
		_targetList = new ArrayList<TargetStatus>(); // ターゲットリストの初期化

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

		if (type == TYPE_NORMAL) { // 通常の魔法使用時
			checkedResult = isNormalSkillUsable();
		} else if (type == TYPE_SPELLSC) { // スペルスクロール使用時
			checkedResult = isSpellScrollUsable();
		} else if (type == TYPE_NPCBUFF) {
			checkedResult = true;
		}
		if (!checkedResult) {
			return false;
		}

		// ファイアーウォール、ライフストリームは詠唱対象が座標
		// キューブは詠唱者の座標に配置されるため例外
		if (_skillId == FIRE_WALL || _skillId == LIFE_STREAM) {
			return true;
		}

		L1Object l1object = L1World.getInstance().findObject(_targetID);
		if (l1object instanceof L1ItemInstance) {
			_log.fine("skill target item name: "
					+ ((L1ItemInstance) l1object).getViewName());
			// スキルターゲットが精霊の石になることがある。
			// Linux環境で確認（Windowsでは未確認）
			// 2008.5.4追記：地面のアイテムに魔法を使うとなる。継続してもエラーになるだけなのでreturn
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

		// テレポート、マステレポートは対象がブックマークID
		if (_skillId == TELEPORT || _skillId == MASS_TELEPORT) {
			_bookmarkId = target_id;
		}
		// 対象がアイテムのスキル
		if (_skillId == CREATE_MAGICAL_WEAPON || _skillId == BRING_STONE
				|| _skillId == BLESSED_ARMOR || _skillId == ENCHANT_WEAPON
				|| _skillId == SHADOW_FANG) {
			_itemobjid = target_id;
		}
		_target = (L1Character) l1object;

		if (!(_target instanceof L1MonsterInstance)
				&& _skill.getTarget().equals("attack")
				&& _user.getId() != target_id) {
			_isPK = true; // ターゲットがモンスター以外で攻撃系スキルで、自分以外の場合PKモードとする。
		}

		// 初期設定ここまで

		// 事前チェック
		if (!(l1object instanceof L1Character)) { // ターゲットがキャラクター以外の場合何もしない。
			checkedResult = false;
		}
		makeTargetList(); // ターゲットの一覧を作成
		if (_targetList.size() == 0 && (_user instanceof L1NpcInstance)) {
			checkedResult = false;
		}
		// 事前チェックここまで
		return checkedResult;
	}

	/**
	 * 通常のスキル使用時に使用者の状態からスキルが使用可能であるか判断する
	 * 
	 * @return false スキルが使用不可能な状態である場合
	 */
	private boolean isNormalSkillUsable() {

		// スキル使用者がPCの場合のチェック
		if (_user instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) _user;
			L1PcInventory pcInventory = pc.getInventory();

			if (pc.isParalyzed()) { // 麻痺・凍結状態か
				return false;
			}
			if ((pc.isInvisble() || pc.isInvisDelay())
					&& !isInvisUsableSkill()) { // インビジ中に使用不可のスキル
				return false;
			}
			if (pc.getInventory().getWeight240() >= 197) { // 重量オーバーならスキルを使用できない
				pc.sendPackets(new S_ServerMessage(316));
				return false;
			}
			int polyId = pc.getTempCharGfx();
			L1PolyMorph poly = PolyTable.getInstance().getTemplate(polyId);
			// 魔法が使えない変身
			if (poly != null && !poly.canUseSkill()) {
				pc.sendPackets(new S_ServerMessage(285)); // \f1その状態では魔法を使えません。
				return false;
			}

			if (!isAttrAgrees()) { // 精霊魔法で、属性が一致しなければ何もしない。
				return false;
			}

			if (_skillId == ELEMENTAL_PROTECTION && pc.getElfAttr() == 0) {
				pc.sendPackets(new S_ServerMessage(280)); // \f1魔法が失敗しました。
				return false;
			}

			// スキルディレイ中使用不可
			if (pc.isSkillDelay()) {
				return false;
			}

			// サイレンス状態では使用不可
			if (pc.hasSkillEffect(SILENCE)
					|| pc.hasSkillEffect(AREA_OF_SILENCE)
					|| pc.hasSkillEffect(STATUS_POISON_SILENCE)) {
				pc.sendPackets(new S_ServerMessage(285)); // \f1その状態では魔法を使えません。
				return false;
			}

			// DIGはロウフルでのみ使用可
			if (_skillId == DISINTEGRATE && pc.getLawful() < 500) {
				// このメッセージであってるか未確認
				pc.sendPackets(new S_ServerMessage(352, "$967")); // この魔法を利用するには性向値が%0でなければなりません。
				return false;
			}

			// 同じキューブは効果範囲外であれば配置可能
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
					pc.sendPackets(new S_ServerMessage(1412)); // すでに床にキューブが召喚されています。
					return false;
				}
			}

			// 覚醒状態では覚醒スキル以外使用不可
			if (pc.getAwakeSkillId() == AWAKEN_ANTHARAS
					&& _skillId != AWAKEN_ANTHARAS && _skillId != MAGMA_BREATH
					&& _skillId != SHOCK_SKIN && _skillId != FREEZING_BREATH
					|| pc.getAwakeSkillId() == AWAKEN_FAFURION
					&& _skillId != AWAKEN_FAFURION && _skillId != MAGMA_BREATH
					&& _skillId != SHOCK_SKIN && _skillId != FREEZING_BREATH
					|| pc.getAwakeSkillId() == AWAKEN_VALAKAS
					&& _skillId != AWAKEN_VALAKAS && _skillId != MAGMA_BREATH
					&& _skillId != SHOCK_SKIN && _skillId != FREEZING_BREATH) {
				pc.sendPackets(new S_ServerMessage(1385)); // 現在の状態では覚醒魔法が使えません。
				return false;
			}

			if (_skillId == SOLID_CARRIAGE && 
					pcInventory.getTypeEquipped(2, 7) == 0 && 
					pcInventory.getTypeEquipped(2, 13) == 0) {
				// シールドを装備しているかチェック
				// メッセージは未確認だが一応表示させておく。
				pc.sendPackets(new S_ServerMessage(1008)); // その状態では詠唱できません。
				return false;
			}

			if (isItemConsume() == false && !_player.isGm()) { // 消費アイテムはあるか
				_player.sendPackets(new S_ServerMessage(299)); // 詠唱する材料がありません。
				return false;
			}
		}
		// スキル使用者がNPCの場合のチェック
		else if (_user instanceof L1NpcInstance) {

			// サイレンス状態では使用不可
			if (_user.hasSkillEffect(SILENCE)) {
				// NPCにサイレンスが掛かっている場合は1回だけ使用をキャンセルさせる効果。
				_user.removeSkillEffect(SILENCE);
				return false;
			}
		}

		// PC、NPC共通のチェック
		if (!isHPMPConsume()) { // 消費HP、MPはあるか
			return false;
		}
		return true;
	}

	/**
	 * スペルスクロール使用時に使用者の状態からスキルが使用可能であるか判断する
	 * 
	 * @return false スキルが使用不可能な状態である場合
	 */
	private boolean isSpellScrollUsable() {
		// スペルスクロールを使用するのはPCのみ
		L1PcInstance pc = (L1PcInstance) _user;

		if (pc.isParalyzed()) { // 麻痺・凍結状態か
			return false;
		}

		// インビジ中に使用不可のスキル
		if ((pc.isInvisble() || pc.isInvisDelay())
				&& !isInvisUsableSkill()) {
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
			// 事前チェックをしているか？
			if (!isCheckedUseSkill()) {
				boolean isUseSkill = checkUseSkill(player, skillId, targetId,
						x, y, message, timeSecs, type, attacker);

				if (!isUseSkill) {
					failSkill();
					return;
				}
			}

			switch (type) {
				case TYPE_NORMAL:
					if (_isGlanceCheckFail && _skill.getArea() <= 0 &&
							!_skill.getTarget().equals("none"))
						break;

					// TODO: original version of this used _skillId instead
					// of skillId - figure out if we can just use the local.
					if (Config.STACKING && _target.hasSkillEffect(_skillId)) {
						int max = _skill.getBuffDuration() * 
							_skill.getStackLimit();
						_skillTime = _skill.getBuffDuration() + 
							_target.getSkillEffectTimeSec(_skillId);
						_skillTime = _skillTime > max ? max : _skillTime;
					} else
						_skillTime = _skill.getBuffDuration();

					runSkill();
					useConsume();
					sendGrfx(true);
					sendFailMessageHandle();
					setDelay();
					break;	
				case TYPE_LOGIN:
					runSkill();
					break;
				case TYPE_GMBUFF:
					runSkill();
					sendGrfx(false);
					break;
				case TYPE_NPCBUFF: case TYPE_SPELLSC:
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

	/**
	 * スキルの失敗処理(PCのみ）
	 */
	private void failSkill() {
		// HPが足りなくてスキルが使用できない場合のみ、MPのみ消費したいが未実装（必要ない？）
		// その他の場合は何も消費されない。
		// useConsume(); // HP、MPは減らす
		setCheckedUseSkill(false);
		// テレポートスキル
		if (_skillId == TELEPORT || _skillId == MASS_TELEPORT
				|| _skillId == TELEPORT_TO_MATHER) {
			// テレポートできない場合でも、クライアント側は応答を待っている
			// テレポート待ち状態の解除（第2引数に意味はない）
			_player.sendPackets(new S_Paralysis(
					S_Paralysis.TYPE_TELEPORT_UNLOCK, false));
		}
	}

	// ターゲットか？
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

		// 破壊不可能なドアは対象外
		if (cha instanceof L1DoorInstance) {
			if (cha.getMaxHp() == 0 || cha.getMaxHp() == 1) {
				return false;
			}
		}

		// マジックドールは対象外
		if (cha instanceof L1DollInstance && _skillId != HASTE) {
			return false;
		}

		// 元のターゲットがPet、Summon以外のNPCの場合、PC、Pet、Summonは対象外
		if (_calcType == PC_NPC
				&& _target instanceof L1NpcInstance
				&& !(_target instanceof L1PetInstance)
				&& !(_target instanceof L1SummonInstance)
				&& (cha instanceof L1PetInstance
						|| cha instanceof L1SummonInstance || cha instanceof L1PcInstance)) {
			return false;
		}

		// 元のターゲットがガード以外のNPCの場合、ガードは対象外
		if (_calcType == PC_NPC && _target instanceof L1NpcInstance
				&& !(_target instanceof L1GuardInstance)
				&& cha instanceof L1GuardInstance) {
			return false;
		}

		// NPC対PCでターゲットがモンスターの場合ターゲットではない。
		if ((_skill.getTarget().equals("attack") || _skill.getType() == L1Skill.TYPE_ATTACK)
				&& _calcType == NPC_PC
				&& !(cha instanceof L1PetInstance)
				&& !(cha instanceof L1SummonInstance)
				&& !(cha instanceof L1PcInstance)) {
			return false;
		}

		// NPC対NPCで使用者がMOBで、ターゲットがMOBの場合ターゲットではない。
		if ((_skill.getTarget().equals("attack") || _skill.getType() == L1Skill.TYPE_ATTACK)
				&& _calcType == NPC_NPC
				&& _user instanceof L1MonsterInstance
				&& cha instanceof L1MonsterInstance) {
			return false;
		}

		// 無方向範囲攻撃魔法で攻撃できないNPCは対象外
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

		// 攻撃系スキルで対象が自分は対象外
		if (_skill.getType() == L1Skill.TYPE_ATTACK
				&& cha.getId() == _user.getId()) {
			return false;
		}

		// ターゲットが自分でH-Aの場合効果無し
		if (cha.getId() == _user.getId() && _skillId == HEAL_ALL) {
			return false;
		}

		if (((_skill.getTargetTo() & L1Skill.TARGET_TO_PC) == L1Skill.TARGET_TO_PC
				|| (_skill.getTargetTo() & L1Skill.TARGET_TO_CLAN) == L1Skill.TARGET_TO_CLAN || (_skill
				.getTargetTo() & L1Skill.TARGET_TO_PARTY) == L1Skill.TARGET_TO_PARTY)
				&& cha.getId() == _user.getId() && _skillId != HEAL_ALL) {
			return true; // ターゲットがパーティーかクラン員のものは自分に効果がある。（ただし、ヒールオールは除外）
		}

		// スキル使用者がPCで、PKモードではない場合、自分のサモン・ペットは対象外
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
			// カウンターディテクション
			if (_skillId == COUNTER_DETECTION
					&& enemy.getZoneType() != 1
					&& (cha.hasSkillEffect(INVISIBILITY) || cha
							.hasSkillEffect(BLIND_HIDING))) {
				return true; // インビジかブラインドハイディング中
			}
			if (_player.getClanid() != 0 && enemy.getClanid() != 0) { // クラン所属中
				// 全戦争リストを取得
				for (L1War war : L1World.getInstance().getWarList()) {
					if (war.CheckClanInWar(_player.getClanname())) { // 自クランが戦争に参加中
						if (war.CheckClanInSameWar( // 同じ戦争に参加中
								_player.getClanname(), enemy.getClanname())) {
							if (L1CastleLocation.checkInAllWarArea(
									enemy.getX(), enemy.getY(), enemy
											.getMapId())) {
								return true;
							}
						}
					}
				}
			}
			return false; // 攻撃スキルでPKモードじゃない場合
		}

		if (_user.glanceCheck(cha.getX(), cha.getY()) == false
				&& _skill.isThrough() == false) {
			// エンチャント、復活スキルは障害物の判定をしない
			if (!(_skill.getType() == L1Skill.TYPE_CHANGE || _skill.getType() == L1Skill.TYPE_RESTORE)) {
				_isGlanceCheckFail = true;
				return false; // 直線上に障害物がある
			}
		}

		if (cha.hasSkillEffect(ICE_LANCE)
				&& (_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD || _skillId == FREEZING_BREATH)) {
			return false; // アイスランス中にアイスランス、フリージングブリザード、フリージングブレス
		}

		if (cha.hasSkillEffect(FREEZING_BLIZZARD)
				&& (_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD || _skillId == FREEZING_BREATH)) {
			return false; // フリージングブリザード中にアイスランス、フリージングブリザード、フリージングブレス
		}

		if (cha.hasSkillEffect(FREEZING_BREATH)
				&& (_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD || _skillId == FREEZING_BREATH)) {
			return false; // フリージングブレス中にアイスランス、フリージングブリザード、フリージングブレス
		}

		if (cha.hasSkillEffect(EARTH_BIND) && _skillId == EARTH_BIND) {
			return false; // アース バインド中にアース バインド
		}

		if (cha.hasSkillEffect(EARTH_BIND) && _skillId == BONE_BREAK) {
			return false; // アース バインド中にﾎﾞｰﾝブレイク
		}

		if (cha.hasSkillEffect(EARTH_BIND) && _skillId == CONFUSION) {
			return false; // アース バインド中にコンフュージョン
		}

		if (cha.hasSkillEffect(EARTH_BIND) && _skillId == ARM_BREAKER) {
			return false; // アース バインド中にアームブレイカ―
		}

		if (cha.hasSkillEffect(FOG_OF_SLEEPING) && _skillId == PHANTASM) {
			return false; // フォグオブスリーピング中にファンタズム
		}

		if (cha.hasSkillEffect(PHANTASM) && _skillId == FOG_OF_SLEEPING) {
			return false; // ファンタズム中にフォグオブスリーピング
		}

		if (!(cha instanceof L1MonsterInstance)
				&& (_skillId == TAMING_MONSTER || _skillId == CREATE_ZOMBIE)) {
			return false; // ターゲットがモンスターじゃない（テイミングモンスター）
		}
		if (cha.isDead()
				&& (_skillId != CREATE_ZOMBIE && _skillId != RESURRECTION
						&& _skillId != GREATER_RESURRECTION && _skillId != CALL_OF_NATURE)) {
			return false; // ターゲットが死亡している
		}

		if (cha.isDead() == false
				&& (_skillId == CREATE_ZOMBIE || _skillId == RESURRECTION
						|| _skillId == GREATER_RESURRECTION || _skillId == CALL_OF_NATURE)) {
			return false; // ターゲットが死亡していない
		}

		if ((cha instanceof L1TowerInstance || cha instanceof L1DoorInstance)
				&& (_skillId == CREATE_ZOMBIE || _skillId == RESURRECTION
						|| _skillId == GREATER_RESURRECTION || _skillId == CALL_OF_NATURE)) {
			return false; // ターゲットがガーディアンタワー、ドア
		}

		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			if (pc.hasSkillEffect(ABSOLUTE_BARRIER)) { // アブソルートバリア中
				if (_skillId == CURSE_BLIND || _skillId == WEAPON_BREAK
						|| _skillId == DARKNESS || _skillId == WEAKNESS
						|| _skillId == DISEASE || _skillId == FOG_OF_SLEEPING
						|| _skillId == MASS_SLOW || _skillId == SLOW
						|| _skillId == CANCELLATION || _skillId == SILENCE
						|| _skillId == DECAY_POTION
						|| _skillId == MASS_TELEPORT || _skillId == DETECTION
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
				if (_skillId == DETECTION || _skillId == COUNTER_DETECTION) { // ディテク、Cディテク
					return true;
				} else {
					return false;
				}
			} else if (hiddenStatus == L1NpcInstance.HIDDEN_STATUS_FLY) {
				return false;
			}
		}

		if ((_skill.getTargetTo() & L1Skill.TARGET_TO_PC) == L1Skill.TARGET_TO_PC // ターゲットがPC
				&& cha instanceof L1PcInstance) {
			flg = true;
		} else if ((_skill.getTargetTo() & L1Skill.TARGET_TO_NPC) == L1Skill.TARGET_TO_NPC // ターゲットがNPC
				&& (cha instanceof L1MonsterInstance
						|| cha instanceof L1NpcInstance
						|| cha instanceof L1SummonInstance || cha instanceof L1PetInstance)) {
			flg = true;
		} else if ((_skill.getTargetTo() & L1Skill.TARGET_TO_PET) == L1Skill.TARGET_TO_PET
				&& _user instanceof L1PcInstance) { // ターゲットがSummon,Pet
			if (cha instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) cha;
				if (summon.getMaster() != null) {
					if (_player.getId() == summon.getMaster().getId()) {
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
			if ((_skill.getTargetTo() & L1Skill.TARGET_TO_CLAN) == L1Skill.TARGET_TO_CLAN
					&& ((_player.getClanid() != 0 // ターゲットがクラン員
					&& _player.getClanid() == ((L1PcInstance) cha).getClanid()) || _player
							.isGm())) {
				return true;
			}
			if ((_skill.getTargetTo() & L1Skill.TARGET_TO_PARTY) == L1Skill.TARGET_TO_PARTY
					&& (_player.getParty() // ターゲットがパーティー
							.isMember((L1PcInstance) cha) || _player.isGm())) {
				return true;
			}
		}

		return flg;
	}

	// ターゲットの一覧を作成
	private void makeTargetList() {
		try {
			if (_type == TYPE_LOGIN) { // ログイン時(死亡時、お化け屋敷のキャンセレーション含む)は使用者のみ
				_targetList.add(new TargetStatus(_user));
				return;
			}
			if (_skill.getTargetTo() == L1Skill.TARGET_TO_ME
					&& (_skill.getType() & L1Skill.TYPE_ATTACK) != L1Skill.TYPE_ATTACK) {
				_targetList.add(new TargetStatus(_user)); // ターゲットは使用者のみ
				return;
			}

			// 射程距離-1の場合は画面内のオブジェクトが対象
			if (_skill.getRanged() != -1) {
				if (_user.getLocation().getTileLineDistance(
						_target.getLocation()) > _skill.getRanged()) {
					return; // 射程範囲外
				}
			} else {
				if (!_user.getLocation().isInScreen(_target.getLocation())) {
					return; // 射程範囲外
				}
			}

			if (isTarget(_target) == false
					&& !(_skill.getTarget().equals("none"))) {
				// 対象が違うのでスキルが発動しない。
				return;
			}

			if (_skillId == LIGHTNING || _skillId == FREEZING_BREATH) { // ライトニング、フリージングブレス直線的に範囲を決める
				ArrayList<L1Object> al1object = L1World.getInstance()
						.getVisibleLineObjects(_user, _target);

				for (L1Object tgobj : al1object) {
					if (tgobj == null) {
						continue;
					}
					if (!(tgobj instanceof L1Character)) { // ターゲットがキャラクター以外の場合何もしない。
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

			if (_skill.getArea() == 0) { // 単体の場合
				if (!_user.glanceCheck(_target.getX(), _target.getY())) { // 直線上に障害物があるか
					if ((_skill.getType() & L1Skill.TYPE_ATTACK) == L1Skill.TYPE_ATTACK
							&& _skillId != 10026
							&& _skillId != 10027
							&& _skillId != 10028 && _skillId != 10029) { // 安息攻撃以外の攻撃スキル
						_targetList.add(new TargetStatus(_target, false)); // ダメージも発生しないし、ダメージモーションも発生しないが、スキルは発動
						return;
					}
				}
				_targetList.add(new TargetStatus(_target));
			} else { // 範囲の場合
				if (!_skill.getTarget().equals("none")) {
					_targetList.add(new TargetStatus(_target));
				}

				if (_skillId != 49
						&& !(_skill.getTarget().equals("attack") || _skill
								.getType() == L1Skill.TYPE_ATTACK)) {
					// 攻撃系以外のスキルとH-A以外はターゲット自身を含める
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
					if (!(tgobj instanceof L1Character)) { // ターゲットがキャラクター以外の場合何もしない。
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

	// メッセージの表示（何か起こったとき）
	private void sendHappenMessage(L1PcInstance pc) {
		int msgID = _skill.getSysmsgIdHappen();
		if (msgID > 0) {
			pc.sendPackets(new S_ServerMessage(msgID));
		}
	}

	// 失敗メッセージ表示のハンドル
	private void sendFailMessageHandle() {
		// 攻撃スキル以外で対象を指定するスキルが失敗した場合は失敗したメッセージをクライアントに送信
		// ※攻撃スキルは障害物があっても成功時と同じアクションであるべき。
		if (_skill.getType() != L1Skill.TYPE_ATTACK
				&& !_skill.getTarget().equals("none")
				&& _targetList.size() == 0) {
			sendFailMessage();
		}
	}

	// メッセージの表示（失敗したとき）
	private void sendFailMessage() {
		int msgID = _skill.getSysmsgIdFail();
		if (msgID > 0 && (_user instanceof L1PcInstance)) {
			_player.sendPackets(new S_ServerMessage(msgID));
		}
	}

	// 精霊魔法の属性と使用者の属性は一致するか？（とりあえずの対処なので、対応できたら消去して下さい)
	private boolean isAttrAgrees() {
		int magicattr = _skill.getAttr();
		if (_user instanceof L1NpcInstance) { // NPCが使った場合なんでもOK
			return true;
		}

		if (_skill.getSkillLevel() >= 17 && _skill.getSkillLevel() <= 22
				&& magicattr != 0 // 精霊魔法で、無属性魔法ではなく、
				&& magicattr != _player.getElfAttr() // 使用者と魔法の属性が一致しない。
				&& !_player.isGm()) { // ただしGMは例外
			return false;
		}
		return true;
	}

	// 必要ＨＰ、ＭＰがあるか？
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

			// MPのINT軽減
			if (_player.getInt() > 12 && _skillId > HOLY_WEAPON
					&& _skillId <= FREEZING_BLIZZARD) { // LV2以上
				_mpConsume--;
			}
			if (_player.getInt() > 13 && _skillId > STALAC
					&& _skillId <= FREEZING_BLIZZARD) { // LV3以上
				_mpConsume--;
			}
			if (_player.getInt() > 14 && _skillId > WEAK_ELEMENTAL
					&& _skillId <= FREEZING_BLIZZARD) { // LV4以上
				_mpConsume--;
			}
			if (_player.getInt() > 15 && _skillId > MEDITATION
					&& _skillId <= FREEZING_BLIZZARD) { // LV5以上
				_mpConsume--;
			}
			if (_player.getInt() > 16 && _skillId > DARKNESS
					&& _skillId <= FREEZING_BLIZZARD) { // LV6以上
				_mpConsume--;
			}
			if (_player.getInt() > 17 && _skillId > BLESS_WEAPON
					&& _skillId <= FREEZING_BLIZZARD) { // LV7以上
				_mpConsume--;
			}
			if (_player.getInt() > 18 && _skillId > DISEASE
					&& _skillId <= FREEZING_BLIZZARD) { // LV8以上
				_mpConsume--;
			}

			if (_player.getInt() > 12 && _skillId >= SHOCK_STUN
					&& _skillId <= COUNTER_BARRIER) {
				_mpConsume -= (_player.getInt() - 12);
			}

			// MPの装備軽減
			if (_skillId == PHYSICAL_ENCHANT_DEX
					&& _player.getInventory().checkEquipped(20013)) { // 迅速ヘルム装備中にPE:DEX
				_mpConsume /= 2;
			}
			if (_skillId == HASTE
					&& _player.getInventory().checkEquipped(20013)) { // 迅速ヘルム装備中にヘイスト
				_mpConsume /= 2;
			}
			if (_skillId == HEAL && _player.getInventory().checkEquipped(20014)) { // 治癒ヘルム装備中にヒール
				_mpConsume /= 2;
			}
			if (_skillId == EXTRA_HEAL
					&& _player.getInventory().checkEquipped(20014)) { // 治癒ヘルム装備中にエキストラヒール
				_mpConsume /= 2;
			}
			if (_skillId == ENCHANT_WEAPON
					&& _player.getInventory().checkEquipped(20015)) { // 力ヘルム装備中にエンチャントウエポン
				_mpConsume /= 2;
			}
			if (_skillId == DETECTION
					&& _player.getInventory().checkEquipped(20015)) { // 力ヘルム装備中にディテクション
				_mpConsume /= 2;
			}
			if (_skillId == PHYSICAL_ENCHANT_STR
					&& _player.getInventory().checkEquipped(20015)) { // 力ヘルム装備中にPE:STR
				_mpConsume /= 2;
			}
			if (_skillId == HASTE
					&& _player.getInventory().checkEquipped(20008)) { // マイナーウィンドヘルム装備中にヘイスト
				_mpConsume /= 2;
			}
			if (_skillId == GREATER_HASTE
					&& _player.getInventory().checkEquipped(20023)) { // ウィンドヘルム装備中にグレーターヘイスト
				_mpConsume /= 2;
			}

			// MPのオリジナルINT軽減
			if (0 < _skill.getMpConsume()
					&& _player.getOriginalMagicConsumeReduction() > 0) {
				_mpConsume -= _player.getOriginalMagicConsumeReduction();
			}

			if (0 < _skill.getMpConsume()) { // MPを消費するスキルであれば
				_mpConsume = Math.max(_mpConsume, 1); // 最低でも1消費する。
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

	// 必要材料があるか？
	private boolean isItemConsume() {

		int itemConsume = _skill.getItemConsumeId();
		int itemConsumeCount = _skill.getItemConsumeCount();

		if (itemConsume == 0) {
			return true; // 材料を必要としない魔法
		}

		if (!_player.getInventory().checkItem(itemConsume, itemConsumeCount)) {
			return false; // 必要材料が足りなかった。
		}

		return true;
	}

	// 使用材料、HP・MP、Lawfulをマイナスする。
	private void useConsume() {
		if (_user instanceof L1NpcInstance) {
			// NPCの場合、HP、MPのみマイナス
			int current_hp = _npc.getCurrentHp() - _hpConsume;
			_npc.setCurrentHp(current_hp);

			int current_mp = _npc.getCurrentMp() - _mpConsume;
			_npc.setCurrentMp(current_mp);
			return;
		}

		// HP・MPをマイナス
		if (isHPMPConsume()) {
			if (_skillId == FINAL_BURN) { // ファイナル バーン
				_player.setCurrentHp(1);
				_player.setCurrentMp(0);
			} else {
				int current_hp = _player.getCurrentHp() - _hpConsume;
				_player.setCurrentHp(current_hp);

				int current_mp = _player.getCurrentMp() - _mpConsume;
				_player.setCurrentMp(current_mp);
			}
		}

		// Lawfulをマイナス
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
			return; // 材料を必要としない魔法
		}

		// 使用材料をマイナス
		_player.getInventory().consumeItem(itemConsume, itemConsumeCount);
	}

	// マジックリストに追加する。
	private void addMagicList(L1Character cha, boolean repetition) {
		int buffDuration;
		if (_skillTime == 0) {
			buffDuration = _skill.getBuffDuration() * 1000; // 効果時間
			if (_skill.getBuffDuration() == 0) {
				if (_skillId == INVISIBILITY) { // インビジビリティ
					cha.setSkillEffect(INVISIBILITY, 0);
				}
				return;
			}
		} else {
			buffDuration = _skillTime * 1000; // パラメータのtimeが0以外なら、効果時間として設定する
		}

		if (_skillId == SHOCK_STUN || _skillId == MASS_SHOCK_STUN) {
			buffDuration = _shockStunDuration;
		}
		if (_skillId == BONE_BREAK) {
			buffDuration = _boneBreakDuration;
		}
		if (_skillId == CONFUSION) {
			buffDuration = _confusionDuration;
		}
		if (_skillId == CURSE_POISON) { // カーズポイズンの効果処理はL1Poisonに移譲。
			return;
		}
		if (_skillId == CURSE_PARALYZE || _skillId == CURSE_PARALYZE2) { // カーズパラライズの効果処理はL1CurseParalysisに移譲。
			return;
		}
		if (_skillId == SHAPE_CHANGE) { // シェイプチェンジの効果処理はL1PolyMorphに移譲。
			return;
		}
		if (_skillId == BLESSED_ARMOR
				|| _skillId == HOLY_WEAPON // 武器・防具に効果がある処理はL1ItemInstanceに移譲。
				|| _skillId == ENCHANT_WEAPON || _skillId == BLESS_WEAPON
				|| _skillId == SHADOW_FANG) {
			return;
		}
		if ((_skillId == ICE_LANCE || _skillId == FREEZING_BLIZZARD || _skillId == FREEZING_BREATH)
				&& !_isFreeze) { // 凍結失敗
			return;
		}
		if (_skillId == AWAKEN_ANTHARAS || _skillId == AWAKEN_FAFURION
				|| _skillId == AWAKEN_VALAKAS) { // 覚醒の効果処理はL1Awakeに移譲。
			return;
		}

		cha.setSkillEffect(_skillId, buffDuration);

		if (cha instanceof L1PcInstance && repetition) { // 対象がPCで既にスキルが重複している場合
			L1PcInstance pc = (L1PcInstance) cha;
			sendIcon(pc);
		}
	}

	// アイコンの送信
	private void sendIcon(L1PcInstance pc) {
		int buffIconDuration = 0;
		if (_skillTime == 0) {
			buffIconDuration = _skill.getBuffDuration(); // 効果時間
		} else {
			buffIconDuration = _skillTime; // パラメータのtimeが0以外なら、効果時間として設定する
		}

		if (_skillId == SHIELD) { // シールド
			pc.sendPackets(new S_SkillIconShield(5, buffIconDuration));
		} else if (_skillId == SHADOW_ARMOR) { // シャドウ アーマー
			pc.sendPackets(new S_SkillIconShield(3, buffIconDuration));
		} else if (_skillId == DRESS_DEXTERITY) { // ドレス デクスタリティー
			pc.sendPackets(new S_Dexup(pc, 2, buffIconDuration));
		} else if (_skillId == DRESS_MIGHTY) { // ドレス マイティー
			pc.sendPackets(new S_Strup(pc, 2, buffIconDuration));
		} else if (_skillId == GLOWING_AURA) { // グローウィング オーラ
			pc.sendPackets(new S_SkillIconAura(113, buffIconDuration));
		} else if (_skillId == SHINING_AURA) { // シャイニング オーラ
			pc.sendPackets(new S_SkillIconAura(114, buffIconDuration));
		} else if (_skillId == BRAVE_AURA) { // ブレイブ オーラ
			pc.sendPackets(new S_SkillIconAura(116, buffIconDuration));
		} else if (_skillId == FIRE_WEAPON) { // ファイアー ウェポン
			pc.sendPackets(new S_SkillIconAura(147, buffIconDuration));
		} else if (_skillId == WIND_SHOT) { // ウィンド ショット
			pc.sendPackets(new S_SkillIconAura(148, buffIconDuration));
		} else if (_skillId == FIRE_BLESS) { // ファイアー ブレス
			pc.sendPackets(new S_SkillIconAura(154, buffIconDuration));
		} else if (_skillId == STORM_EYE) { // ストーム アイ
			pc.sendPackets(new S_SkillIconAura(155, buffIconDuration));
		} else if (_skillId == EARTH_BLESS) { // アース ブレス
			pc.sendPackets(new S_SkillIconShield(7, buffIconDuration));
		} else if (_skillId == BURNING_WEAPON) { // バーニング ウェポン
			pc.sendPackets(new S_SkillIconAura(162, buffIconDuration));
		} else if (_skillId == STORM_SHOT) { // ストーム ショット
			pc.sendPackets(new S_SkillIconAura(165, buffIconDuration));
		} else if (_skillId == IRON_SKIN) { // アイアン スキン
			pc.sendPackets(new S_SkillIconShield(10, buffIconDuration));
		} else if (_skillId == EARTH_SKIN) { // アース スキン
			pc.sendPackets(new S_SkillIconShield(6, buffIconDuration));
		} else if (_skillId == PHYSICAL_ENCHANT_STR) { // フィジカル エンチャント：STR
			pc.sendPackets(new S_Strup(pc, 5, buffIconDuration));
		} else if (_skillId == PHYSICAL_ENCHANT_DEX) { // フィジカル エンチャント：DEX
			pc.sendPackets(new S_Dexup(pc, 5, buffIconDuration));
		} else if (_skillId == HASTE || _skillId == GREATER_HASTE) { // グレーターヘイスト
			pc.sendPackets(new S_SkillHaste(pc.getId(), 1, buffIconDuration));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1, 0));
		} else if (_skillId == HOLY_WALK || _skillId == MOVING_ACCELERATION
				|| _skillId == WIND_WALK) { // ホーリーウォーク、ムービングアクセレーション、ウィンドウォーク
			pc.sendPackets(new S_SkillBrave(pc.getId(), 4, buffIconDuration));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 4, 0));
		} else if (_skillId == BLOODLUST) { // ブラッドラスト
			pc.sendPackets(new S_SkillBrave(pc.getId(), 6, buffIconDuration));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 6, 0));
		} else if (_skillId == SLOW || _skillId == MASS_SLOW
				|| _skillId == ENTANGLE) { // スロー、エンタングル、マススロー
			pc.sendPackets(new S_SkillHaste(pc.getId(), 2, buffIconDuration));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 2, 0));
		} else if (_skillId == IMMUNE_TO_HARM) {
			pc.sendPackets(new S_SkillIconGFX(40, buffIconDuration));
		}
		pc.sendPackets(new S_OwnCharStatus(pc));
	}

	// グラフィックの送信
	private void sendGrfx(boolean isSkillAction) {
		int actionId = _skill.getActionId();
		int castgfx = _skill.getCastGfx();
		int[] data = null;
		if (castgfx == 0) {
			return; // 表示するグラフィックが無い
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
				if (_targetList.size() == 0) { // 失敗
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
				// ターゲット数が０で対象を指定するスキルの場合、魔法使用エフェクトだけ表示して終了
				int tempchargfx = _player.getTempCharGfx();
				if (tempchargfx == 5727 || tempchargfx == 5730) { // シャドウ系変身のモーション対応
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
				if (isPcSummonPet(_target)) { // 対象がPC、サモン、ペット
					if (_player.getZoneType() == 1
							|| _target.getZoneType() == 1 // 攻撃する側または攻撃される側がセーフティーゾーン
							|| _player.checkNonPvP(_player, _target)) { // Non-PvP設定
						_player.sendPackets(new S_UseAttackSkill(_player, 0,
								castgfx, _targetX, _targetY, actionId));
						_player.broadcastPacket(new S_UseAttackSkill(_player,
								0, castgfx, _targetX, _targetY, actionId));
						return;
					}
				}
				if (_skill.getArea() == 0) { // 単体攻撃魔法
					if (_skillId == MIND_BREAK || _skillId == CONFUSION
							|| _skillId == JOY_OF_PAIN) {
						_player
								.sendPackets(new S_SkillSound(targetid, castgfx));
						_player.broadcastPacket(new S_SkillSound(targetid,
								castgfx));
						S_DoActionGFX gfx = new S_DoActionGFX(_player.getId(),
								actionId);
						_player.sendPackets(gfx);
						_player.broadcastPacket(gfx);
					} else {
						_player
								.sendPackets(new S_UseAttackSkill(_player,
										targetid, castgfx, _targetX, _targetY,
										actionId));
						_player
								.broadcastPacket(new S_UseAttackSkill(_player,
										targetid, castgfx, _targetX, _targetY,
										actionId));
						_target.broadcastPacketExceptTargetSight(
								new S_DoActionGFX(targetid,
										ActionCodes.ACTION_Damage), _player);
					}
				} else { // 有方向範囲攻撃魔法
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
					&& _skill.getType() == L1Skill.TYPE_ATTACK) { // 無方向範囲攻撃魔法
				L1Character[] cha = new L1Character[_targetList.size()];
				int i = 0;
				for (TargetStatus ts : _targetList) {
					cha[i] = ts.getTarget();
					cha[i]
							.broadcastPacketExceptTargetSight(
									new S_DoActionGFX(cha[i].getId(),
											ActionCodes.ACTION_Damage), _player);
					i++;
				}
				_player.sendPackets(new S_RangeSkill(_player, cha, castgfx,
						actionId, S_RangeSkill.TYPE_NODIR));
				_player.broadcastPacket(new S_RangeSkill(_player, cha, castgfx,
						actionId, S_RangeSkill.TYPE_NODIR));
			} else { // 補助魔法
				// テレポート、マステレ、テレポートトゥマザー以外
				if (_skillId != 5 && _skillId != 69 && _skillId != 131) {
					// 魔法を使う動作のエフェクトは使用者だけ バーニングスラッシュはモーションなし
					if (isSkillAction && _skillId != BURNING_SLASH) {
						S_DoActionGFX gfx = new S_DoActionGFX(_player.getId(),
								_skill.getActionId());
						_player.sendPackets(gfx);
						_player.broadcastPacket(gfx);
					}
					if (_skillId == COUNTER_MAGIC
							|| _skillId == COUNTER_BARRIER
							|| _skillId == COUNTER_MIRROR) {
						_player
								.sendPackets(new S_SkillSound(targetid, castgfx));
					} else if (_skillId == TRUE_TARGET) { // トゥルーターゲットは個別処理で送信済
						return;
					} else if (_skillId == AWAKEN_ANTHARAS // 覚醒：アンタラス
							|| _skillId == AWAKEN_FAFURION // 覚醒：パプリオン
							|| _skillId == AWAKEN_VALAKAS) { // 覚醒：ヴァラカス
						if (_skillId == _player.getAwakeSkillId()) { // 再詠唱なら解除でエフェクトなし
							_player.sendPackets(new S_SkillSound(targetid,
									castgfx));
							_player.broadcastPacket(new S_SkillSound(targetid,
									castgfx));
						} else {
							return;
						}
					} else {
						_player
								.sendPackets(new S_SkillSound(targetid, castgfx));
						_player.broadcastPacket(new S_SkillSound(targetid,
								castgfx));
					}
				}

				// スキルのエフェクト表示はターゲット全員だが、あまり必要性がないので、ステータスのみ送信
				for (TargetStatus ts : _targetList) {
					L1Character cha = ts.getTarget();
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_OwnCharStatus(pc));
					}
				}
			}
		} else if (_user instanceof L1NpcInstance) { // NPCがスキルを使った場合
			int targetid = _target.getId();

			if (_user instanceof L1MerchantInstance) {
				_user.broadcastPacket(new S_SkillSound(targetid, castgfx));
				return;
			}

			if (_targetList.size() == 0 && !(_skill.getTarget().equals("none"))) {
				// ターゲット数が０で対象を指定するスキルの場合、魔法使用エフェクトだけ表示して終了
				S_DoActionGFX gfx = new S_DoActionGFX(_user.getId(), _skill
						.getActionId());
				_user.broadcastPacket(gfx);
				return;
			}

			if (_skill.getTarget().equals("attack") && _skillId != 18) {
				if (_skill.getArea() == 0) { // 単体攻撃魔法
					_user.broadcastPacket(new S_UseAttackSkill(_user, targetid,
							castgfx, _targetX, _targetY, actionId));
					_target.broadcastPacketExceptTargetSight(new S_DoActionGFX(
							targetid, ActionCodes.ACTION_Damage), _user);
				} else { // 有方向範囲攻撃魔法
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
					&& _skill.getType() == L1Skill.TYPE_ATTACK) { // 無方向範囲攻撃魔法
				L1Character[] cha = new L1Character[_targetList.size()];
				int i = 0;
				for (TargetStatus ts : _targetList) {
					cha[i] = ts.getTarget();
					i++;
				}
				_user.broadcastPacket(new S_RangeSkill(_user, cha, castgfx,
						actionId, S_RangeSkill.TYPE_NODIR));
			} else { // 補助魔法
				// テレポート、マステレ、テレポートトゥマザー以外
				if (_skillId != 5 && _skillId != 69 && _skillId != 131) {
					// 魔法を使う動作のエフェクトは使用者だけ
					S_DoActionGFX gfx = new S_DoActionGFX(_user.getId(), _skill
							.getActionId());
					_user.broadcastPacket(gfx);
					_user.broadcastPacket(new S_SkillSound(targetid, castgfx));
				}
			}
		}
	}

	// 重複できないスキルの削除
	// 例：ファイア ウェポンとバーニングウェポンなど
	private void deleteRepeatedSkills(L1Character cha) {
		final int[][] repeatedSkills = {
		// ホーリー ウェポン、エンチャント ウェポン、ブレス ウェポン, シャドウ ファング
				// これらはL1ItemInstanceで管理
				// { HOLY_WEAPON, ENCHANT_WEAPON, BLESS_WEAPON, SHADOW_FANG },
				// ファイアー ウェポン、ウィンド ショット、ファイアー ブレス、ストーム アイ、バーニング ウェポン、ストーム ショット
				{ FIRE_WEAPON, WIND_SHOT, FIRE_BLESS, STORM_EYE,
						BURNING_WEAPON, STORM_SHOT },
				// シールド、シャドウ アーマー、アース スキン、アースブレス、アイアン スキン
				{ SHIELD, SHADOW_ARMOR, EARTH_SKIN, EARTH_BLESS, IRON_SKIN },
				// ホーリー ウォーク、ムービング アクセレーション、ウィンド ウォーク、BP、ワッフル、ブラッドラスト
				{ HOLY_WALK, MOVING_ACCELERATION, WIND_WALK, STATUS_BRAVE,
						STATUS_ELFBRAVE, BLOODLUST },
				// ヘイスト、グレーター ヘイスト、GP
				{ HASTE, GREATER_HASTE, STATUS_HASTE },
				// フィジカル エンチャント：DEX、ドレス デクスタリティー
				{ PHYSICAL_ENCHANT_DEX, DRESS_DEXTERITY },
				// フィジカル エンチャント：STR、ドレス マイティー
				{ PHYSICAL_ENCHANT_STR, DRESS_MIGHTY },
				// グローウィングオーラ、シャイニングオーラ
				{ GLOWING_AURA, SHINING_AURA } };

		for (int[] skills : repeatedSkills) {
			for (int id : skills) {
				if (id == _skillId) {
					stopSkillList(cha, skills);
				}
			}
		}
	}

	// 重複しているスキルを一旦すべて削除
	private void stopSkillList(L1Character cha, int[] repeat_skill) {
		for (int skillId : repeat_skill) {
			if (skillId != _skillId) {
				cha.removeSkillEffect(skillId);
			}
		}
	}

	// ディレイの設定
	private void setDelay() {
		if (_skill.getReuseDelay() > 0) {
			L1SkillDelay.onSkillUse(_user, _skill.getReuseDelay());
		}
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
			// 向きによってキューブの設置位置を決定
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
			// 目の前が進入不可能なら足元にキューブを作成
			if (!_user.getMap().isPassable(_targetX + xPlus, _targetY + yPlus)) {
				xPlus = 0;
				yPlus = 0;
			}
			if (_skillId == CUBE_IGNITION) {
				L1EffectSpawn.getInstance().spawnEffect(80149,
						_skill.getBuffDuration() * 1000, _targetX + xPlus,
						_targetY + yPlus, _user.getMapId(),
						(L1PcInstance) _user, _skillId);
				return;
			} else if (_skillId == CUBE_QUAKE) {
				L1EffectSpawn.getInstance().spawnEffect(80150,
						_skill.getBuffDuration() * 1000, _targetX + xPlus,
						_targetY + yPlus, _user.getMapId(),
						(L1PcInstance) _user, _skillId);
				return;
			} else if (_skillId == CUBE_SHOCK) {
				L1EffectSpawn.getInstance().spawnEffect(80151,
						_skill.getBuffDuration() * 1000, _targetX + xPlus,
						_targetY + yPlus, _user.getMapId(),
						(L1PcInstance) _user, _skillId);
				return;
			} else if (_skillId == CUBE_BALANCE) {
				L1EffectSpawn.getInstance().spawnEffect(80152,
						_skill.getBuffDuration() * 1000, _targetX + xPlus,
						_targetY + yPlus, _user.getMapId(),
						(L1PcInstance) _user, _skillId);
				return;
			}
		}

		if (_skillId == FIRE_WALL) { // ファイアーウォール
			L1EffectSpawn.getInstance().doSpawnFireWall(_user, _targetX,
					_targetY);
			return;
		}

		for (int skillId : EXCEPT_COUNTER_MAGIC) {
			if (_skillId == skillId) {
				_isCounterMagic = false; 
				break;
			}
		}
		// NPCにショックスタンを使用させるとonActionでNullPointerExceptionが発生するため
		// とりあえずPCが使用した時のみ
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
					continue; // 計算する必要がない。
				}

				L1Magic _magic = new L1Magic(_user, cha);
				_magic.setLeverage(getLeverage());

				if (cha instanceof L1MonsterInstance) { // アンデットの判定
					undeadType = ((L1MonsterInstance) cha).getNpcTemplate()
							.get_undead();
				}

				// 確率系スキルで失敗が確定している場合
				if ((_skill.getType() == L1Skill.TYPE_CURSE || _skill.getType() == L1Skill.TYPE_PROBABILITY)
						&& isTargetFailure(cha)) {
					iter.remove();
					continue;
				}

				int buffIconDuration = 0;
				if (cha instanceof L1PcInstance) { // ターゲットがPCの場合のみアイコンは送信する。
					if (_skillTime == 0) {
						buffIconDuration = _skill.getBuffDuration(); // 効果時間
					} else {
						buffIconDuration = _skillTime; // パラメータのtimeが0以外なら、効果時間として設定する
					}
				}

				deleteRepeatedSkills(cha); // 重複したスキルの削除

				if (_skill.getType() == L1Skill.TYPE_ATTACK
						&& _user.getId() != cha.getId()) { // 攻撃系スキル＆ターゲットが使用者以外であること。
					if (isUseCounterMagic(cha)) { // カウンターマジックが発動した場合、リストから削除
						iter.remove();
						continue;
					}
					dmg = _magic.calcMagicDamage(_skillId);
					_dmg = dmg;
					cha.removeSkillEffect(ERASE_MAGIC); // イレースマジック中なら、攻撃魔法で解除
				} else if (_skill.getType() == L1Skill.TYPE_CURSE
						|| _skill.getType() == L1Skill.TYPE_PROBABILITY) { // 確率系スキル
					isSuccess = _magic.calcProbabilityMagic(_skillId);
					if (_skillId != ERASE_MAGIC) {
						cha.removeSkillEffect(ERASE_MAGIC); // イレースマジック中なら、確率魔法で解除
					}
					if (_skillId != FOG_OF_SLEEPING) {
						cha.removeSkillEffect(FOG_OF_SLEEPING); // フォグオブスリーピング中なら、確率魔法で解除
					}
					if (_skillId != PHANTASM) {
						cha.removeSkillEffect(PHANTASM); // ファンタズム中なら、確率魔法で解除
					}
					if (isSuccess) { // 成功したがカウンターマジックが発動した場合、リストから削除
						if (isUseCounterMagic(cha)) { // カウンターマジックが発動したか
							iter.remove();
							continue;
						}
					} else { // 失敗した場合、リストから削除
						if (_skillId == FOG_OF_SLEEPING
								&& cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							pc.sendPackets(new S_ServerMessage(297)); // 軽いめまいを覚えました。
						}
						iter.remove();
						continue;
					}
				} else if (_skill.getType() == L1Skill.TYPE_HEAL) { // 回復系スキル
					// 回復量はマイナスダメージで表現
					dmg = -1 * _magic.calcHealing(_skillId);
					if (cha.hasSkillEffect(WATER_LIFE)) { // ウォーターライフ中は回復量２倍
						dmg *= 2;
					}
					if (cha.hasSkillEffect(POLLUTE_WATER)) { // ポルートウォーター中は回復量1/2倍
						dmg /= 2;
					}
				}

				// ■■■■ 個別処理のあるスキルのみ書いてください。 ■■■■

				// すでにスキルを使用済みの場合なにもしない
				// ただしショックスタンは重ねがけ出来るため例外
				if (cha.hasSkillEffect(_skillId) && _skillId != SHOCK_STUN
						&& _skillId != BONE_BREAK && _skillId != ARM_BREAKER
						&& _skillId != MASS_SHOCK_STUN) {
					addMagicList(cha, true); // ターゲットに魔法の効果時間を上書き
					if (_skillId != SHAPE_CHANGE) { // シェイプ チェンジは変身を上書き出来るため例外
						continue;
					}
				}

				// ●●●● PC、NPC両方効果のあるスキル ●●●●
				if (_skillId == HASTE) { // ヘイスト
					if (cha.getMoveSpeed() != 2) { // スロー中以外
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							if (pc.getHasteItemEquipped() > 0) {
								continue;
							}
							pc.setDrink(false);
							pc.sendPackets(new S_SkillHaste(pc.getId(), 1,
									buffIconDuration));
						}
						cha
								.broadcastPacket(new S_SkillHaste(cha.getId(),
										1, 0));
						cha.setMoveSpeed(1);
					} else { // スロー中
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
						|| _skillId == GREATER_RESURRECTION) { // リザレクション、グレーターリザレクション
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (_player.getId() != pc.getId()) {
							if (L1World.getInstance().getVisiblePlayer(pc, 0)
									.size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(pc, 0)) {
									if (!visiblePc.isDead()) {
										// \f1その場所に他の人が立っているので復活させることができません。
										_player
												.sendPackets(new S_ServerMessage(
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
									pc.sendPackets(new S_Message_YN(322, "")); // また復活したいですか？（Y/N）
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
									&& L1World.getInstance().getVisiblePlayer(
											npc, 0).size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(npc, 0)) {
									if (!visiblePc.isDead()) {
										// \f1その場所に他の人が立っているので復活させることができません。
										_player
												.sendPackets(new S_ServerMessage(
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
				} else if (_skillId == CALL_OF_NATURE) { // コール オブ ネイチャー
					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;
						if (_player.getId() != pc.getId()) {
							if (L1World.getInstance().getVisiblePlayer(pc, 0)
									.size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(pc, 0)) {
									if (!visiblePc.isDead()) {
										// \f1その場所に他の人が立っているので復活させることができません。
										_player
												.sendPackets(new S_ServerMessage(
														592));
										return;
									}
								}
							}
							if (pc.getCurrentHp() == 0 && pc.isDead()) {
								pc.setTempID(_player.getId());
								pc.sendPackets(new S_Message_YN(322, "")); // また復活したいですか？（Y/N）
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
									&& L1World.getInstance().getVisiblePlayer(
											npc, 0).size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(npc, 0)) {
									if (!visiblePc.isDead()) {
										// \f1その場所に他の人が立っているので復活させることができません。
										_player
												.sendPackets(new S_ServerMessage(
														592));
										return;
									}
								}
							}
							if (npc.getCurrentHp() == 0 && npc.isDead()) {
								npc.resurrect(cha.getMaxHp());// HPを全回復する
								npc.resurrect(cha.getMaxMp() / 100);// MPを0にする
								npc.setResurrect(true);
							}
						}
					}
				} else if (_skillId == DETECTION) { // ディテクション
					if (cha instanceof L1NpcInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						int hiddenStatus = npc.getHiddenStatus();
						if (hiddenStatus == L1NpcInstance.HIDDEN_STATUS_SINK) {
							npc.appearOnGround(_player);
						}
					}
				} else if (_skillId == COUNTER_DETECTION) { // カウンターディテクション
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
				} else if (_skillId == TRUE_TARGET) { // トゥルーターゲット
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
				} else if (_skillId == ELEMENTAL_FALL_DOWN) { // エレメンタルフォールダウン
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				}
				// ★★★ 回復系スキル ★★★
				else if ((_skillId == HEAL || _skillId == EXTRA_HEAL
						|| _skillId == GREATER_HEAL || _skillId == FULL_HEAL
						|| _skillId == HEAL_ALL || _skillId == NATURES_BLESSING)
						&& (_user instanceof L1PcInstance)) {
					cha.removeSkillEffect(WATER_LIFE);
				} else if (_skillId == NATURES_TOUCH) {
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				}
				// ★★★ 攻撃系スキル ★★★
				// チルタッチ、バンパイアリックタッチ
				else if (_skillId == CHILL_TOUCH || _skillId == VAMPIRIC_TOUCH) {
					heal = dmg;
				} else if (_skillId == TRIPLE_ARROW) { // トリプルアロー
					// 1回射出する毎にアロー、ダメージ、命中を計算する
					// アローが残り1でサイハの弓を持ってるとき、
					// 最初は普通の攻撃その後は魔法攻撃
					// アローが残り1で普通の弓を持ってるとき，最初は普通の攻撃，
					// その後はアローの射出を行わず動きだけを行う。

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
					_player
							.sendPackets(new S_SkillSound(_player.getId(), 4394));
					_player.broadcastPacket(new S_SkillSound(_player.getId(),
							4394));
				} else if (_skillId == FOE_SLAYER) {
					for (int i = 3; i > 0; i--) {
						_target.onAction(_player);
					}
					_player.sendPackets(new S_SkillSound(_target.getId(),
 							6509));
 					_player.sendPackets(new S_SkillSound(_player.getId(),
 							7020));
					_player.broadcastPacket(new S_SkillSound(_target.getId(),
							6509));
					_player.broadcastPacket(new S_SkillSound(_player.getId(),
							7020));
				} else if (_skillId == 10026 || _skillId == 10027
						|| _skillId == 10028 || _skillId == 10029) { // 安息攻撃
					if (_user instanceof L1NpcInstance) {
						_user.broadcastPacket(new S_NpcChatPacket(_npc,
								"$3717", 0)); // さあ、おまえに安息を与えよう。
					} else {
						_player.broadcastPacket(new S_ChatPacket(_player,
								"$3717", 0, 0)); // さあ、おまえに安息を与えよう。
					}
				} else if (_skillId == 10057) { // 引き寄せ
					L1Teleport.teleportToTargetFront(cha, _user, 1);
				}

				// ★★★ 確率系スキル ★★★
				else if (_skillId == SLOW || _skillId == MASS_SLOW
						|| _skillId == ENTANGLE) { // スロー、マス
					// スロー、エンタングル
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
				} else if (_skillId == CURSE_BLIND || _skillId == DARKNESS) {
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
				} else if (_skillId == WEAKNESS) { // ウィークネス
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == DISEASE) { // ディジーズ
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == ICE_LANCE // アイスランス
						|| _skillId == FREEZING_BLIZZARD // フリージングブリザード
						|| _skillId == FREEZING_BREATH) { // フリージングブレス
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
				} else if (_skillId == EARTH_BIND) { // アースバインド
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
					RandomGenerator random = RandomGeneratorFactory.getSharedRandom();
					
					int basechance = random.nextInt(99) + 1;
					
					int chance = basechance+(diffLevel*5);
					
					if (chance>90) {
						stunTime = 6000;
					} else if (chance > 85) {
						stunTime = 5500;
					} else if (chance > 80) {
						stunTime = 5000;
					} else if (chance > 75) {
						stunTime = 4500;
					} else if (chance > 70) {
						stunTime = 4000;
					} else if (chance > 65) {
						stunTime = 3500;
					} else if (chance > 60) {
						stunTime = 3000;
					} else if (chance > 55) {
						stunTime = 2500;
					} else if (chance > 50) {
						stunTime = 2000;
					} else if (chance > 45) {
						stunTime = 1500;
					} else {
						stunTime = 1000;
					} 
					
					_shockStunDuration = stunTime;
					/*RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int stunTime = (random.nextInt(21) + 10) * 100;
					_shockStunDuration = stunTime;
					*/
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
				} else if (_skillId == WIND_SHACKLE) { // ウィンド シャックル
					_skill.newBuffSkillExecutor().addEffect(_user, cha,
							buffIconDuration);
				} else if (_skillId == CANCELLATION) {
					if (cha instanceof L1NpcInstance) {
						L1NpcInstance npc = (L1NpcInstance) cha;
						int npcId = npc.getNpcTemplate().get_npcId();
						if (npcId == 71092) { // 調査員
							if (npc.getGfxId() == npc.getTempCharGfx()) {
								npc.setTempCharGfx(1314);
								npc.broadcastPacket(new S_ChangeShape(npc
										.getId(), 1314));
								return;
							} else {
								return;
							}
						}
						if (npcId == 45640) { // ユニコーン
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
						if (npcId == 81209) { // ロイ
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
						npc
								.broadcastPacket(new S_SkillHaste(cha.getId(),
										0, 0));
						npc
								.broadcastPacket(new S_SkillBrave(cha.getId(),
										0, 0));
						npc.setWeaponBreaked(false);
						npc.setParalyzed(false);
						npc.setParalysisTime(0);
					}

					// スキルの解除
					for (int skillNum = SKILLS_BEGIN; skillNum <= SKILLS_END; skillNum++) {
						if (isNotCancelable(skillNum) && !cha.isDead()) {
							continue;
						}
						cha.removeSkillEffect(skillNum);
					}

					// ステータス強化、異常の解除
					cha.curePoison();
					cha.cureParalaysis();
					for (int skillNum = STATUS_BEGIN; skillNum <= STATUS_END; skillNum++) {
						if (skillNum == STATUS_CHAT_PROHIBITED // チャット禁止は解除しない
								|| skillNum == STATUS_CURSE_BARLOG // バルログの呪いは解除しない
								|| skillNum == STATUS_CURSE_YAHEE) { // ヤヒの呪いは解除しない
							continue;
						}
						cha.removeSkillEffect(skillNum);
					}

					if (cha instanceof L1PcInstance) {
					}

					// 料理の解除
					for (int skillNum = COOKING_BEGIN; skillNum <= COOKING_END; skillNum++) {
						if (isNotCancelable(skillNum)) {
							continue;
						}
						cha.removeSkillEffect(skillNum);
					}

					if (cha instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) cha;

						// アイテム装備による変身の解除
						L1PolyMorph.undoPoly(pc);
						pc.sendPackets(new S_CharVisualUpdate(pc));
						pc.broadcastPacket(new S_CharVisualUpdate(pc));

						// ヘイストアイテム装備時はヘイスト関連のスキルが何も掛かっていないはずなのでここで解除
						if (pc.getHasteItemEquipped() > 0) {
							pc.setMoveSpeed(0);
							pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
							pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0,
									0));
						}
					}
					cha.removeSkillEffect(STATUS_FREEZE); // Freeze解除
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
				} else if (_skillId == TURN_UNDEAD // ターン アンデッド
						&& (undeadType == 1 || undeadType == 3)) {
					// ダメージを対象のHPとする。
					dmg = cha.getCurrentHp();
				} else if (_skillId == MANA_DRAIN) { // マナ ドレイン
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int chance = random.nextInt(10) + 5;
					drainMana = chance + (_user.getInt() / 2);
					if (cha.getCurrentMp() < drainMana) {
						drainMana = cha.getCurrentMp();
					}
				} else if (_skillId == WEAPON_BREAK) { // ウェポン ブレイク
					/*
					 * 対NPCの場合、L1Magicのダメージ算出でダメージ1/2としているので
					 * こちらには、対PCの場合しか記入しない。 損傷量は1~(int/3)まで
					 */
					if (_calcType == PC_PC || _calcType == NPC_PC) {
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							L1ItemInstance weapon = pc.getWeapon();
							if (weapon != null) {
								RandomGenerator random = RandomGeneratorFactory
										.getSharedRandom();
								int weaponDamage = random.nextInt(_user
										.getInt() / 3) + 1;
								// \f1あなたの%0が損傷しました。
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
				} else if (_skillId == GUARD_BRAKE) { // ガードブレイク
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == HORROR_OF_DEATH) { // ホラーオブデス
					_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
				} else if (_skillId == THUNDER_GRAB) { // サンダーグラップ
					boolean isFetter = _magic.calcProbabilityMagic(_skillId);
					if (isFetter) {
						int time = _skill.getBuffDuration() * 1000;
						if (cha instanceof L1PcInstance) {
							L1PcInstance targetPc = (L1PcInstance) cha;
							targetPc.setSkillEffect(STATUS_FREEZE, time);
							targetPc.sendPackets(new S_Paralysis(
									S_Paralysis.TYPE_BIND, true));
						} else if (cha instanceof L1MonsterInstance
								|| cha instanceof L1SummonInstance
								|| cha instanceof L1PetInstance) {
							L1NpcInstance npc = (L1NpcInstance) cha;
							npc.setSkillEffect(STATUS_FREEZE, time);
							npc.setParalyzed(true);
						}
					}
				} else if (_skillId == BONE_BREAK) { // ボーンブレイク
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int stunTime = (random.nextInt(14) + 7) * 100;
					_boneBreakDuration = stunTime;
					int intbonus = _user.getInt() - 12;
					//System.out.println(intbonus);
					if (intbonus > 0) {
						_boneBreakDuration = _boneBreakDuration + (intbonus*75);
					}
					if (_boneBreakDuration > 6000) {
						_boneBreakDuration = 6000;
					}
					//L1EffectSpawn.getInstance().spawnEffect(91208,
					//		_boneBreakDuration, cha.getX(), cha.getY(),
					//		cha.getMapId());
					int chance = (random.nextInt(100) + 1);
					int probability = (l1skills.getProbabilityValue() - (2 * cha
							.getRegistStun()));
					// DB ProbabitiyValueからスタン耐性２倍を引く
					if (chance <= probability) {
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
  		                                        L1EffectSpawn.getInstance().spawnEffect(91208,
                                                        _boneBreakDuration, cha.getX(), cha.getY(),
                                                        cha.getMapId());

							pc.sendPackets(new S_Paralysis(
									S_Paralysis.TYPE_STUN, true));
						} else if (cha instanceof L1MonsterInstance
								|| cha instanceof L1SummonInstance
								|| cha instanceof L1PetInstance) {
							L1NpcInstance npc = (L1NpcInstance) cha;
                                        L1EffectSpawn.getInstance().spawnEffect(91208,
                                                        _boneBreakDuration, cha.getX(), cha.getY(),
                                                        cha.getMapId());

							npc.setParalyzed(true);
							npc.setParalysisTime(_boneBreakDuration);
						}
					}
				} else if (_skillId == SMASH) { // スマッシュ
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
						npc
								.broadcastPacket(new S_SkillSound(npc.getId(),
										6526));
					}
				} else if (_skillId == CONFUSION) { // コンフュージョン
					RandomGenerator random = RandomGeneratorFactory
							.getSharedRandom();
					int silenceTime = (random.nextInt(60) + 40) * 100;
					_confusionDuration = silenceTime;
					int chance = (random.nextInt(100) + 1);
					int probability = l1skills.getProbabilityValue();
					if (chance <= probability) {
						if (cha instanceof L1PcInstance) {
							L1PcInstance pc = (L1PcInstance) cha;
							// 本鯖では、メッセージは無いが一応表示させておく
							pc.sendPackets(new S_ServerMessage(697));
							pc.setSkillEffect(SILENCE, _confusionDuration);
						} else if (cha instanceof L1MonsterInstance
								|| cha instanceof L1SummonInstance
								|| cha instanceof L1PetInstance) {
							L1NpcInstance npc = (L1NpcInstance) cha;
							npc.setSkillEffect(SILENCE, _confusionDuration);
						}
					}
				} else if (_skillId == PHANTASM) { // ファンタズム　TODO
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
				} else if (_skillId == ARM_BREAKER) { // アームブレイカ―
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
						npc
								.broadcastPacket(new S_SkillSound(npc.getId(),
										6551));
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

				// ●●●● PCにしか効果のないスキル ●●●●
				if (_calcType == PC_PC || _calcType == NPC_PC) {
					// ★★★ 特殊系スキル★★★
					if (_skillId == TELEPORT || _skillId == MASS_TELEPORT) { // マステレ、テレポート
						L1PcInstance pc = (L1PcInstance) cha;
						L1BookMark bookm = pc.getBookMark(_bookmarkId);
						if (bookm != null) { // ブックマークを取得出来たらテレポート
							if (pc.getMap().isEscapable() || pc.isGm()) {
								int newX = bookm.getLocX();
								int newY = bookm.getLocY();
								short mapId = bookm.getMapId();

								if (_skillId == MASS_TELEPORT) { // マステレポート
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
							} else { // テレポート不可マップへの移動制限
								L1Teleport.teleport(pc, pc.getX(), pc.getY(),
										pc.getMapId(), pc.getHeading(), false);
								pc.sendPackets(new S_ServerMessage(79));
							}
						} else { // ブックマークが取得出来なかった、あるいは「任意の場所」を選択した場合の処理
							if (pc.getMap().isTeleportable() || pc.isGm()) {
								L1Location newLocation = pc.getLocation()
										.randomLocation(200, true);
								int newX = newLocation.getX();
								int newY = newLocation.getY();
								short mapId = (short) newLocation.getMapId();

								if (_skillId == MASS_TELEPORT) { // マステレポート
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
					} else if (_skillId == TELEPORT_TO_MATHER) { // テレポート トゥ マザー
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getMap().isEscapable() || pc.isGm()) {
							L1Teleport.teleport(pc, 33051, 32337, (short) 4, 5,
									true);
						} else {
							pc.sendPackets(new S_ServerMessage(647));
							L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc
									.getMapId(), pc.getHeading(), false);
						}
					} else if (_skillId == CALL_CLAN) { // コールクラン
						L1PcInstance pc = (L1PcInstance) cha;
						L1PcInstance clanPc = (L1PcInstance) L1World
								.getInstance().findObject(_targetID);
						if (clanPc != null) {
							clanPc.setTempID(pc.getId()); // 相手のオブジェクトIDを保存しておく
							clanPc.sendPackets(new S_Message_YN(729, "")); // 君主が呼んでいます。召喚に応じますか？（Y/N）
						}
					} else if (_skillId == RUN_CLAN) { // ランクラン
						L1PcInstance pc = (L1PcInstance) cha;
						L1PcInstance clanPc = (L1PcInstance) L1World
								.getInstance().findObject(_targetID);
						if (clanPc != null) {
							if (pc.getMap().isEscapable() || pc.isGm()) {
								boolean castle_area = L1CastleLocation
										.checkInAllWarArea(
												// いずれかの城エリア
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
									// \f1あなたのパートナーは今あなたが行けない所でプレイ中です。
									pc.sendPackets(new S_ServerMessage(547));
								}
							} else {
								// 周辺のエネルギーがテレポートを妨害しています。そのため、ここでテレポートは使用できません。
								pc.sendPackets(new S_ServerMessage(647));
								L1Teleport.teleport(pc, pc.getX(), pc.getY(),
										pc.getMapId(), pc.getHeading(), false);
							}
						}
					} else if (_skillId == CREATE_MAGICAL_WEAPON) { // クリエイト
						// マジカル ウェポン
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null && item.getItem().getType2() == 1) {
							int item_type = item.getItem().getType2();
							int safe_enchant = item.getItem().get_safeenchant();
							int enchant_level = item.getEnchantLevel();
							String item_name = item.getName();
							if (safe_enchant < 0) { // 強化不可
								pc.sendPackets( // \f1何も起きませんでした。
										new S_ServerMessage(79));
							} else if (safe_enchant == 0) { // 安全圏+0
								pc.sendPackets( // \f1何も起きませんでした。
										new S_ServerMessage(79));
							} else if (item_type == 1 && enchant_level == 0) {
								if (!item.isIdentified()) {// 未鑑定
									pc.sendPackets( // \f1%0が%2%1光ります。
											new S_ServerMessage(161, item_name,
													"$245", "$247"));
								} else {
									item_name = "+0 " + item_name;
									pc.sendPackets( // \f1%0が%2%1光ります。
											new S_ServerMessage(161, "+0 "
													+ item_name, "$245", "$247"));
								}
								item.setEnchantLevel(1);
								pc.getInventory().updateItem(item,
										L1PcInventory.COL_ENCHANTLVL);
							} else {
								pc.sendPackets( // \f1何も起きませんでした。
										new S_ServerMessage(79));
							}
						} else {
							pc.sendPackets( // \f1何も起きませんでした。
									new S_ServerMessage(79));
						}
					} else if (_skillId == BRING_STONE) { // ブリング ストーン
						L1PcInstance pc = (L1PcInstance) cha;
						RandomGenerator random = RandomGeneratorFactory
								.getSharedRandom();
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
											"$2475")); // %0を手に入れました。
								} else {
									pc.sendPackets(new S_ServerMessage(280)); // \f1魔法が失敗しました。
								}
							} else if (item.getItem().getItemId() == 40321) {
								pc.getInventory().removeItem(item, 1);
								if (brave >= chance) {
									pc.getInventory().storeItem(40322, 1);
									pc.sendPackets(new S_ServerMessage(403,
											"$2476")); // %0を手に入れました。
								} else {
									pc.sendPackets(new S_ServerMessage(280)); // \f1魔法が失敗しました。
								}
							} else if (item.getItem().getItemId() == 40322) {
								pc.getInventory().removeItem(item, 1);
								if (wise >= chance) {
									pc.getInventory().storeItem(40323, 1);
									pc.sendPackets(new S_ServerMessage(403,
											"$2477")); // %0を手に入れました。
								} else {
									pc.sendPackets(new S_ServerMessage(280)); // \f1魔法が失敗しました。
								}
							} else if (item.getItem().getItemId() == 40323) {
								pc.getInventory().removeItem(item, 1);
								if (kayser >= chance) {
									pc.getInventory().storeItem(40324, 1);
									pc.sendPackets(new S_ServerMessage(403,
											"$2478")); // %0を手に入れました。
								} else {
									pc.sendPackets(new S_ServerMessage(280)); // \f1魔法が失敗しました。
								}
							}
						}
					} else if (_skillId == SUMMON_MONSTER) { // サモンモンスター
						L1PcInstance pc = (L1PcInstance) cha;
						int level = pc.getLevel();
						int[] summons;
						if (pc.getMap().isRecallPets() || pc.isGm()) {
							if (pc.getInventory().checkEquipped(20284)) {
								pc
										.sendPackets(new S_ShowSummonList(pc
												.getId()));
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
								for (int i = 0; i < summons.length; i++) { // 該当ＬＶ範囲検索
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
									// 現在のペットコスト
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
							// \f1何も起きませんでした。
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else if (_skillId == LESSER_ELEMENTAL
							|| _skillId == GREATER_ELEMENTAL) { // レッサーエレメンタル、グレーターエレメンタル
						L1PcInstance pc = (L1PcInstance) cha;
						int attr = pc.getElfAttr();
						if (attr != 0) { // 無属性でなければ実行
							if (pc.getMap().isRecallPets() || pc.isGm()) {
								int petcost = 0;
								Object[] petlist = pc.getPetList().values()
										.toArray();
								for (Object pet : petlist) {
									// 現在のペットコスト
									petcost += ((L1NpcInstance) pet)
											.getPetcost();
								}

								if (petcost == 0) { // 1匹も所属NPCがいなければ実行
									int summonid = 0;
									int summons[];
									if (_skillId == LESSER_ELEMENTAL) { // レッサーエレメンタル[地,火,水,風]
										summons = new int[] { 45306, 45303,
												45304, 45305 };
									} else {
										// グレーターエレメンタル[地,火,水,風]
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
									// 特殊設定の場合ランダムで出現
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
									summon.setPetcost(pc.getCha() + 7); // 精霊の他にはNPCを所属させられない
								}
							} else {
								// \f1何も起きませんでした。
								pc.sendPackets(new S_ServerMessage(79));
							}
						}
					} else if (_skillId == ABSOLUTE_BARRIER) { // アブソルート バリア
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					}

					// ★★★ 変化系スキル（エンチャント） ★★★
					if (_skillId == GLOWING_AURA) { // グローウィング オーラ
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addHitup(5);
						pc.addBowHitup(5);
						pc.addMr(20);
						pc.sendPackets(new S_SPMR(pc));
						pc.sendPackets(new S_SkillIconAura(113,
								buffIconDuration));
					} else if (_skillId == SHINING_AURA) { // シャイニング オーラ
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-8);
						pc.sendPackets(new S_SkillIconAura(114,
								buffIconDuration));
					} else if (_skillId == BRAVE_AURA) { // ブレイブ オーラ
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(5);
						pc.sendPackets(new S_SkillIconAura(116,
								buffIconDuration));
					} else if (_skillId == SHIELD) { // シールド
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-2);
						pc.sendPackets(new S_SkillIconShield(5,
								buffIconDuration));
					} else if (_skillId == SHADOW_ARMOR) { // シャドウ アーマー
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-3);
						pc.sendPackets(new S_SkillIconShield(3,
								buffIconDuration));
					} else if (_skillId == DRESS_DEXTERITY) { // ドレス デクスタリティー
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDex((byte) 2);
						pc.sendPackets(new S_Dexup(pc, 2, buffIconDuration));
					} else if (_skillId == DRESS_MIGHTY) { // ドレス マイティー
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addStr((byte) 2);
						pc.sendPackets(new S_Strup(pc, 2, buffIconDuration));
					} else if (_skillId == SHADOW_FANG) { // シャドウ ファング
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null && item.getItem().getType2() == 1) {
							item.setSkillWeaponEnchant(pc, _skillId, _skill
									.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else if (_skillId == ENCHANT_WEAPON) { // エンチャント ウェポン
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null && item.getItem().getType2() == 1) {
							pc.sendPackets(new S_ServerMessage(161, item
									.getLogName(), "$245", "$247"));
							item.setSkillWeaponEnchant(pc, _skillId, _skill
									.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else if (_skillId == HOLY_WEAPON // ホーリー ウェポン
							|| _skillId == BLESS_WEAPON) { // ブレス ウェポン
						if (!(cha instanceof L1PcInstance)) {
							return;
						}
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getWeapon() == null) {
							pc.sendPackets(new S_ServerMessage(79));
							return;
						}
						for (L1ItemInstance item : pc.getInventory().getItems()) {
							if (pc.getWeapon().equals(item)) {
								pc.sendPackets(new S_ServerMessage(161, item
										.getLogName(), "$245", "$247"));
								item.setSkillWeaponEnchant(pc, _skillId, _skill
										.getBuffDuration() * 1000);
								return;
							}
						}
					} else if (_skillId == BLESSED_ARMOR) { // ブレスド アーマー
						L1PcInstance pc = (L1PcInstance) cha;
						L1ItemInstance item = pc.getInventory().getItem(
								_itemobjid);
						if (item != null && item.getItem().getType2() == 2
								&& item.getItem().getType() == 2) {
							pc.sendPackets(new S_ServerMessage(161, item
									.getLogName(), "$245", "$247"));
							item.setSkillArmorEnchant(pc, _skillId, _skill
									.getBuffDuration() * 1000);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else if (_skillId == EARTH_BLESS) { // アース ブレス
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-7);
						pc.sendPackets(new S_SkillIconShield(7,
								buffIconDuration));
					} else if (_skillId == RESIST_MAGIC) { // レジスト マジック
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addMr(10);
						pc.sendPackets(new S_SPMR(pc));
					} else if (_skillId == CLEAR_MIND) { // クリアー マインド
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addWis((byte) 3);
						pc.resetBaseMr();
					} else if (_skillId == RESIST_ELEMENTAL) { // レジスト エレメント
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addWind(10);
						pc.addWater(10);
						pc.addFire(10);
						pc.addEarth(10);
						pc.sendPackets(new S_OwnCharAttrDef(pc));
					} else if (_skillId == BODY_TO_MIND) { // ボディ トゥ マインド
						L1PcInstance pc = (L1PcInstance) cha;
						pc.setCurrentMp(pc.getCurrentMp() + 2);
					} else if (_skillId == BLOODY_SOUL) { // ブラッディ ソウル
						L1PcInstance pc = (L1PcInstance) cha;
						pc.setCurrentMp(pc.getCurrentMp() + 16);
					} else if (_skillId == MIND_BREAK) {
						if (cha.getCurrentMp() > 10) {
						cha.setCurrentMp(cha.getCurrentMp() - 10);
						cha.setCurrentHp(cha.getCurrentHp() -20);
						}
					} else if (_skillId == ELEMENTAL_PROTECTION) { // エレメンタルプロテクション
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
							|| _skillId == BLIND_HIDING) { // インビジビリティ、ブラインドハイディング
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_Invis(pc.getId(), 1));
						pc.broadcastPacketForFindInvis(new S_RemoveObject(pc),
								false);
						// pc.broadcastPacket(new S_RemoveObject(pc));
					} else if (_skillId == IRON_SKIN) { // アイアン スキン
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-10);
						pc.sendPackets(new S_SkillIconShield(10,
								buffIconDuration));
					} else if (_skillId == EARTH_SKIN) { // アース スキン
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-6);
						pc.sendPackets(new S_SkillIconShield(6,
								buffIconDuration));
					} else if (_skillId == PHYSICAL_ENCHANT_STR) { // フィジカルエンチャント：STR
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addStr((byte) 5);
						pc.sendPackets(new S_Strup(pc, 5, buffIconDuration));
					} else if (_skillId == PHYSICAL_ENCHANT_DEX) { // フィジカルエンチャント：DEX
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDex((byte) 5);
						pc.sendPackets(new S_Dexup(pc, 5, buffIconDuration));
					} else if (_skillId == FIRE_WEAPON) { // ファイアー ウェポン
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(4);
						pc.sendPackets(new S_SkillIconAura(147,
								buffIconDuration));
					} else if (_skillId == FIRE_BLESS) { // ファイアー ブレス
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(4);
						pc.sendPackets(new S_SkillIconAura(154,
								buffIconDuration));
					} else if (_skillId == BURNING_WEAPON) { // バーニング ウェポン
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(6);
						pc.addHitup(3);
						pc.sendPackets(new S_SkillIconAura(162,
								buffIconDuration));
					} else if (_skillId == WIND_SHOT) { // ウィンド ショット
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowHitup(6);
						pc.sendPackets(new S_SkillIconAura(148,
								buffIconDuration));
					} else if (_skillId == STORM_EYE) { // ストーム アイ
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowHitup(2);
						pc.addBowDmgup(3);
						pc.sendPackets(new S_SkillIconAura(155,
								buffIconDuration));
					} else if (_skillId == STORM_SHOT) { // ストーム ショット
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addBowDmgup(5);
						pc.addBowHitup(-1);
						pc.sendPackets(new S_SkillIconAura(165,
								buffIconDuration));
					} else if (_skillId == BERSERKERS) { // バーサーカー
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					} else if (_skillId == SHAPE_CHANGE) { // シェイプ チェンジ
						L1PcInstance pc = (L1PcInstance) cha;
						pc.sendPackets(new S_ShowPolyList(pc.getId()));
						if (!pc.isShapeChange()) {
							pc.setShapeChange(true);
						}
					} else if (_skillId == ADVANCE_SPIRIT) { // アドバンスド スピリッツ
						L1PcInstance pc = (L1PcInstance) cha;
						pc.setAdvenHp(pc.getBaseMaxHp() / 5);
						pc.setAdvenMp(pc.getBaseMaxMp() / 5);
						pc.addMaxHp(pc.getAdvenHp());
						pc.addMaxMp(pc.getAdvenMp());
						pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc
								.getMaxHp()));
						if (pc.isInParty()) { // パーティー中
							pc.getParty().updateMiniHP(pc);
						}
						pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc
								.getMaxMp()));
					} else if (_skillId == GREATER_HASTE) { // グレーター ヘイスト
						L1PcInstance pc = (L1PcInstance) cha;
						if (pc.getHasteItemEquipped() > 0) {
							continue;
						}
						if (pc.getMoveSpeed() != 2) { // スロー中以外
							pc.setDrink(false);
							pc.setMoveSpeed(1);
							pc.sendPackets(new S_SkillHaste(pc.getId(), 1,
									buffIconDuration));
							pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1,
									0));
						} else { // スロー中
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
							|| _skillId == WIND_WALK) { // ホーリーウォーク、ムービングアクセレーション、ウィンドウォーク
						L1PcInstance pc = (L1PcInstance) cha;
						pc.setBraveSpeed(4);
						pc.sendPackets(new S_SkillBrave(pc.getId(), 4,
								buffIconDuration));
						pc.broadcastPacket(new S_SkillBrave(pc.getId(), 4, 0));
					} else if (_skillId == BLOODLUST) { // ブラッドラスト
						L1PcInstance pc = (L1PcInstance) cha;
						pc.setBraveSpeed(6);
						pc.sendPackets(new S_SkillBrave(pc.getId(), 6,
								buffIconDuration));
						pc.broadcastPacket(new S_SkillBrave(pc.getId(), 6, 0));
					} else if (_skillId == AWAKEN_ANTHARAS) { // 覚醒：アンタラス
						L1PcInstance pc = (L1PcInstance) cha;
						L1Awake.start(pc, _skillId);
					} else if (_skillId == AWAKEN_FAFURION) { // 覚醒：パプリオン
						L1PcInstance pc = (L1PcInstance) cha;
						L1Awake.start(pc, _skillId);
					} else if (_skillId == AWAKEN_VALAKAS) { // 覚醒：ヴァラカス
						L1PcInstance pc = (L1PcInstance) cha;
						L1Awake.start(pc, _skillId);
					} else if (_skillId == ILLUSION_OGRE) { // イリュージョン：オーガ
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					} else if (_skillId == ILLUSION_LICH) { // イリュージョン：リッチ
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addSp(2);
						pc.sendPackets(new S_SPMR(pc));
					} else if (_skillId == ILLUSION_DIA_GOLEM) { // イリュージョン：ダイアモンドゴーレム
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addAc(-20);
					} else if (_skillId == ILLUSION_AVATAR) { // イリュージョン：アバター
						L1PcInstance pc = (L1PcInstance) cha;
						pc.addDmgup(10);
						pc.addBowDmgup(10);
					} else if (_skillId == INSIGHT) { // インサイト
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					} else if (_skillId == PANIC) { // パニック
						_skill.newBuffSkillExecutor().addEffect(_user, cha, 0);
					}
				}

				// ●●●● NPCにしか効果のないスキル ●●●●
				if (_calcType == PC_NPC || _calcType == NPC_NPC) {
					// ★★★ ペット系スキル ★★★
					if (_skillId == TAMING_MONSTER
							&& ((L1MonsterInstance) cha).getNpcTemplate()
									.isTamable()) { // テイミングモンスター
						int petcost = 0;
						Object[] petlist = _user.getPetList().values()
								.toArray();
						for (Object pet : petlist) {
							// 現在のペットコスト
							petcost += ((L1NpcInstance) pet).getPetcost();
						}
						int charisma = _user.getCha();
						if (_player.isElf()) { // エルフ
							if (charisma > 30) { // max count = 7
								charisma = 30;
							}
							charisma += 12;
						} else if (_player.isWizard()) { // ウィザード
							if (charisma > 36) { // max count = 7
								charisma = 36;
							}
							charisma += 6;
						}
						charisma -= petcost;
						if (charisma >= 6) { // ペットコストの確認
							L1SummonInstance summon = new L1SummonInstance(
									_targetNpc, _user, false);
							_target = summon; // ターゲット入替え
						} else {
							_player.sendPackets(new S_ServerMessage(319)); // \f1これ以上のモンスターを操ることはできません。
						}
					} else if (_skillId == CREATE_ZOMBIE) { // クリエイトゾンビ
						int petcost = 0;
						Object[] petlist = _user.getPetList().values()
								.toArray();
						for (Object pet : petlist) {
							// 現在のペットコスト
							petcost += ((L1NpcInstance) pet).getPetcost();
						}
						int charisma = _user.getCha();
						if (_player.isElf()) { // エルフ
							if (charisma > 30) { // max count = 7
								charisma = 30;
							}
							charisma += 12;
						} else if (_player.isWizard()) { // ウィザード
							if (charisma > 36) { // max count = 7
								charisma = 36;
							}
							charisma += 6;
						}
						charisma -= petcost;
						if (charisma >= 6) { // ペットコストの確認
							L1SummonInstance summon = new L1SummonInstance(
									_targetNpc, _user, true);
							_target = summon; // ターゲット入替え
						} else {
							_player.sendPackets(new S_ServerMessage(319)); // \f1これ以上のモンスターを操ることはできません。
						}
					} else if (_skillId == WEAK_ELEMENTAL) { // ウィーク エレメンタル
						if (cha instanceof L1MonsterInstance) {
							L1Npc npcTemp = ((L1MonsterInstance) cha)
									.getNpcTemplate();
							int weakAttr = npcTemp.get_weakAttr();
							if ((weakAttr & 1) == 1) { // 地
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2169));
							}
							if ((weakAttr & 2) == 2) { // 火
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2167));
							}
							if ((weakAttr & 4) == 4) { // 水
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2166));
							}
							if ((weakAttr & 8) == 8) { // 風
								cha.broadcastPacket(new S_SkillSound(cha
										.getId(), 2168));
							}
						}
					} else if (_skillId == RETURN_TO_NATURE) { // リターントゥネイチャー
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

				// ■■■■ 個別処理ここまで ■■■■

				if (_skill.getType() == L1Skill.TYPE_HEAL
						&& _calcType == PC_NPC && undeadType == 1) {
					dmg *= -1; // もし、アンデットで回復系スキルならばダメージになる。
				}

				if (_skill.getType() == L1Skill.TYPE_HEAL
						&& _calcType == PC_NPC && undeadType == 3) {
					dmg = 0; // もし、アンデット系ボスで回復系スキルならば無効
				}

				if ((cha instanceof L1TowerInstance || cha instanceof L1DoorInstance)
						&& dmg < 0) { // ガーディアンタワー、ドアにヒールを使用
					dmg = 0;
				}

				if (dmg != 0 || drainMana != 0) {
					_magic.commit(dmg, drainMana); // ダメージ系、回復系の値をターゲットにコミットする。
				}

				// ヒール系の他に、別途回復した場合（V-Tなど）
				if (heal > 0) {
					if ((heal + _user.getCurrentHp()) > _user.getMaxHp()) {
						_user.setCurrentHp(_user.getMaxHp());
					} else {
						_user.setCurrentHp(heal + _user.getCurrentHp());
					}
				}

				if (cha instanceof L1PcInstance) { // ターゲットがPCならば、ACとステータスを送信
					L1PcInstance pc = (L1PcInstance) cha;
					//pc.updateLight();
					pc.sendPackets(new S_OwnCharAttrDef(pc));
					pc.sendPackets(new S_OwnCharStatus(pc));
					sendHappenMessage(pc); // ターゲットにメッセージを送信
				}

				addMagicList(cha, false); // ターゲットに魔法の効果時間を設定

				if (cha instanceof L1PcInstance) { // ターゲットがPCならば、ライト状態を更新
					L1PcInstance pc = (L1PcInstance) cha;
					//pc.updateLight();
				}
			}

			if (_skillId == DETECTION || _skillId == COUNTER_DETECTION) { // ディテクション、カウンターディテクション
				detection(_player);
			}

		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * キャンセレーションで解除できないスキルかを返す。
	 */
	private boolean isNotCancelable(int skillNum) {
		return skillNum == ENCHANT_WEAPON || skillNum == BLESSED_ARMOR
				|| skillNum == ABSOLUTE_BARRIER || skillNum == ADVANCE_SPIRIT
				|| skillNum == SHOCK_STUN || skillNum == SHADOW_FANG
				|| skillNum == REDUCTION_ARMOR || skillNum == SOLID_CARRIAGE
				|| skillNum == COUNTER_BARRIER || skillNum == AWAKEN_ANTHARAS
				|| skillNum == AWAKEN_FAFURION || skillNum == AWAKEN_VALAKAS
				|| skillNum == BONE_BREAK || skillNum == MASS_SHOCK_STUN
				|| skillNum == CONFUSION;
	}

	private void detection(L1PcInstance pc) {
		if (!pc.isGmInvis() && pc.isInvisble()) { // 自分
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

	// ターゲットについて計算する必要があるか返す
	private boolean isTargetCalc(L1Character cha) {
		// 攻撃魔法のNon－PvP判定
		if (_skill.getTarget().equals("attack") && _skillId != 18) { // 攻撃魔法
			if (isPcSummonPet(cha)) { // 対象がPC、サモン、ペット
				if (_player.getZoneType() == 1 || cha.getZoneType() == 1 // 攻撃する側または攻撃される側がセーフティーゾーン
						|| _player.checkNonPvP(_player, cha)) { // Non-PvP設定
					return false;
				}
			}
		}

		// フォグオブスリーピングは自分自身は対象外
		if (_skillId == FOG_OF_SLEEPING && _user.getId() == cha.getId()) {
			return false;
		}

		// マススローは自分自身と自分のペットは対象外
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

		// マステレポートは自分自身のみ対象（同時にクラン員もテレポートさせる）
		if (_skillId == MASS_TELEPORT) {
			if (_user.getId() != cha.getId()) {
				return false;
			}
		}

		return true;
	}

	// 対象がPC、サモン、ペットかを返す
	private boolean isPcSummonPet(L1Character cha) {
		if (_calcType == PC_PC) { // 対象がPC
			return true;
		}

		if (_calcType == PC_NPC) {
			if (cha instanceof L1SummonInstance) { // 対象がサモン
				L1SummonInstance summon = (L1SummonInstance) cha;
				if (summon.isExsistMaster()) { // マスターが居る
					return true;
				}
			}
			if (cha instanceof L1PetInstance) { // 対象がペット
				return true;
			}
		}
		return false;
	}

	// ターゲットに対して必ず失敗になるか返す
	private boolean isTargetFailure(L1Character cha) {
		boolean isTU = false;
		boolean isErase = false;
		boolean isManaDrain = false;
		int undeadType = 0;

		if (cha instanceof L1TowerInstance || cha instanceof L1DoorInstance) { // ガーディアンタワー、ドアには確率系スキル無効
			return true;
		}

		if (cha instanceof L1PcInstance) { // 対PCの場合
			if (_calcType == PC_PC && _player.checkNonPvP(_player, cha)) { // Non-PvP設定
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

		if (cha instanceof L1MonsterInstance) { // ターンアンデット可能か判定
			isTU = ((L1MonsterInstance) cha).getNpcTemplate().get_IsTU();
		}

		if (cha instanceof L1MonsterInstance) { // イレースマジック可能か判定
			isErase = ((L1MonsterInstance) cha).getNpcTemplate().get_IsErase();
		}

		if (cha instanceof L1MonsterInstance) { // アンデットの判定
			undeadType = ((L1MonsterInstance) cha).getNpcTemplate()
					.get_undead();
		}

		// マナドレインが可能か？
		if (cha instanceof L1MonsterInstance) {
			isManaDrain = true;
		}
		/*
		 * 成功除外条件１：T-Uが成功したが、対象がアンデットではない。 成功除外条件２：T-Uが成功したが、対象にはターンアンデット無効。
		 * 成功除外条件３：スロー、マススロー、マナドレイン、エンタングル、イレースマジック、ウィンドシャックル無効
		 * 成功除外条件４：マナドレインが成功したが、モンスター以外の場合
		 */
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

	// カウンターマジックが発動したか返す
	private boolean isUseCounterMagic(L1Character cha) {
		if (_isCounterMagic && cha.hasSkillEffect(COUNTER_MAGIC)) {
			cha.removeSkillEffect(COUNTER_MAGIC);
			int castgfx = SkillTable.getInstance().findBySkillId(
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
