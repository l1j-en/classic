package l1j.server.server.model.Instance;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.DropTable;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.datatables.UBTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1UltimateBattle;
import l1j.server.server.model.L1World;
import l1j.server.server.model.ZoneType;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_NPCPack;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillBrave;
import l1j.server.server.serverpackets.ServerBasePacket;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.CalcExp;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1MonsterInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;

	private static Logger _log = Logger.getLogger(L1MonsterInstance.class
			.getName());

	private static Random _random = new Random();

	private boolean _storeDroped;

	@Override
	public void onItemUse() {
		if (!isActived() && _target != null) {
			useItem(USEITEM_HASTE, 40);

			if (getNpcTemplate().is_doppel() && _target instanceof L1PcInstance) {
				L1PcInstance targetPc = (L1PcInstance) _target;
				setName(_target.getName());
				setNameId(_target.getName());
				setTitle(_target.getTitle());
				setTempLawful(_target.getLawful());
				setTempCharGfx(targetPc.getClassId());
				setGfxId(targetPc.getClassId());
				setPassispeed(640);
				setAtkspeed(900);
				for (L1PcInstance pc : L1World.getInstance()
						.getRecognizePlayer(this)) {
					pc.sendPackets(new S_RemoveObject(this));
					pc.removeKnownObject(this);
					pc.updateObject();
				}
			}
		}
		if (getCurrentHp() * 100 / getMaxHp() < 40) {
			if (this.getInt() > Config.MONSTERPOTIONINTUSE) {
				useItem(USEITEM_HEAL, 30);
			}
		}
	}

	@Override
	public void onPerceive(L1PcInstance perceivedFrom) {
		// TRICIDTODO: wont compile after merge
		// perceivedFrom.sendPackets(new S_Light(this.getId(), getLightSize()));
		perceivedFrom.addKnownObject(this);
		if (0 < getCurrentHp()) {
			if (getHiddenStatus() == HIDDEN_STATUS_SINK
					|| getHiddenStatus() == HIDDEN_STATUS_ICE) {
				perceivedFrom.sendPackets(new S_DoActionGFX(getId(),
						ActionCodes.ACTION_Hide));
			} else if (getHiddenStatus() == HIDDEN_STATUS_FLY) {
				perceivedFrom.sendPackets(new S_DoActionGFX(getId(),
						ActionCodes.ACTION_Moveup));
			}
			perceivedFrom.sendPackets(new S_NPCPack(this));
			onNpcAI();
			if (getBraveSpeed() == 1) {
				perceivedFrom.sendPackets(new S_SkillBrave(getId(), 1, 600000));
			}
		} else {
			perceivedFrom.sendPackets(new S_NPCPack(this));
		}
	}

	public static int[][] _classGfxId = { { 0, 1 }, { 48, 61 }, { 37, 138 },
			{ 734, 1186 }, { 2786, 2796 } };

	@Override
	public void searchTarget() {
		L1PcInstance targetPlayer = null;
		L1Npc base = getNpcTemplate();
		int id = getNpcId();
		int mapId = getMapId();

		if (!base.is_agro() && !base.is_agrososc() && !base.is_agrochao()
				&& base.is_agrogfxid1() < 0 && base.is_agrogfxid2() < 0)
			return;

		for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(this)) {

			// NOTE: Don't remove non-aggro to shopmode
			if (pc.getCurrentHp() <= 0 || pc.isDead() || pc.isGm()
					|| pc.isMonitor() || pc.isGhost() || pc.isPrivateShop()) {
				continue;
			}

			if (mapId == 88 || mapId == 98 || mapId == 92 || mapId == 91
					|| mapId == 95) {
				if (!pc.isInvisble() || base.is_agrocoi()) {
					targetPlayer = pc;
					break;
				}
			}

			int playerGfx = pc.getTempCharGfx();
			if (id == 45600) {
				if (pc.isCrown() || pc.isDarkelf()
						|| playerGfx != pc.getClassId()) {
					targetPlayer = pc;
					break;
				}
			}

			if ((base.getKarma() < 0 && pc.getKarmaLevel() >= 1)
					|| (base.getKarma() > 0 && pc.getKarmaLevel() <= -1)) {
				continue;
			}

			if (playerGfx == 6034 && base.getKarma() < 0 || playerGfx == 6035
					&& (base.getKarma() > 0 || id == 46070 || id == 46072)) {
				continue;
			}

			if (!base.is_agro() && !base.is_agrososc()
					&& base.is_agrogfxid1() < 0 && base.is_agrogfxid2() < 0) {
				if (pc.getLawful() < -1000) {
					targetPlayer = pc;
					break;
				}
				continue;
			}

			if (!pc.isInvisble() || base.is_agrocoi()) {
				if (pc.hasSkillEffect(67)) {
					if (base.is_agrososc()) {
						targetPlayer = pc;
						break;
					}
				} else if (base.is_agro()) {
					targetPlayer = pc;
					break;
				}
				if (base.is_agrogfxid1() >= 0 && base.is_agrogfxid1() <= 4) {
					if (_classGfxId[base.is_agrogfxid1()][0] == playerGfx
							|| _classGfxId[base.is_agrogfxid1()][1] == playerGfx) {
						targetPlayer = pc;
						break;
					}
				} else if (playerGfx == base.is_agrogfxid1()) {
					targetPlayer = pc;
					break;
				}
				if (base.is_agrogfxid2() >= 0 && base.is_agrogfxid2() <= 4) {
					if (_classGfxId[base.is_agrogfxid2()][0] == playerGfx
							|| _classGfxId[base.is_agrogfxid2()][1] == playerGfx) {
						targetPlayer = pc;
						break;
					}
				} else if (playerGfx == base.is_agrogfxid2()) {
					targetPlayer = pc;
					break;
				}
			}
		}
		if (targetPlayer != null) {
			_hateList.add(targetPlayer, 0);
			_target = targetPlayer;
		}
	}

	@Override
	public void setLink(L1Character cha) {
		if (cha != null && _hateList.isEmpty()) {
			_hateList.add(cha, 0);
			checkTarget();
		}
	}

	public L1MonsterInstance(L1Npc template) {
		super(template);
		_storeDroped = false;
	}

	@Override
	public void onNpcAI() {
		if (isAiRunning()) {
			return;
		}
		if (!_storeDroped) {
			DropTable.getInstance().setDrop(this, getInventory());
			getInventory().shuffle();
			_storeDroped = true;
		}
		setActived(false);
		startAI();
	}

	@Override
	public void onTalkAction(L1PcInstance pc) {
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
				getNpcTemplate().get_npcId());
		pc.sendPackets(new S_NPCTalkReturn(talking, getId(),
				pc.getLawful() < -1000 ? 2 : 1));
	}

	@Override
	public ZoneType getZoneType() {
		return ZoneType.Combat;
	}

	@Override
	public void onAction(L1PcInstance pc) {
		if (getCurrentHp() > 0 && !isDead()) {
			L1Attack attack = new L1Attack(pc, this);
			if (attack.calcHit()) {
				attack.calcDamage();
				attack.calcStaffOfMana();
				attack.addPcPoisonAttack(pc, this);
				attack.addChaserAttack();
			}
			attack.action();
			attack.commit();
		}
	}

	@Override
	public void ReceiveManaDamage(L1Character attacker, int mpDamage) {
		if (mpDamage > 0 && !isDead()) {
			setHate(attacker, mpDamage);

			onNpcAI();

			if (attacker instanceof L1PcInstance) {
				serchLink((L1PcInstance) attacker, getNpcTemplate()
						.get_family());
			}

			int newMp = getCurrentMp() - mpDamage;
			if (newMp < 0) {
				newMp = 0;
			}
			setCurrentMp(newMp);
		}
	}

	@Override
	public void receiveDamage(L1Character attacker, int damage) {
		if (getCurrentHp() > 0 && !isDead()) {
			if (getHiddenStatus() == HIDDEN_STATUS_SINK
					|| getHiddenStatus() == HIDDEN_STATUS_FLY) {
				return;
			}
			if (damage >= 0) {
				if (attacker instanceof L1EffectInstance) {
					setHate(((L1EffectInstance) attacker).getUser(), damage);
				} else {
					setHate(attacker, damage);
				}
			}
			if (damage > 0) {
				removeSkillEffect(FOG_OF_SLEEPING);
			}

			onNpcAI();

			L1Npc template = getNpcTemplate();
			if (attacker instanceof L1PcInstance) {
				serchLink((L1PcInstance) attacker, template.get_family());
			}

			int id = getNpcId();
			if (attacker instanceof L1PcInstance && damage > 0) {
				L1PcInstance player = (L1PcInstance) attacker;
				player.setPetTarget(this);

				if (id >= 45681 && id <= 45684)
					recall(player);
			}

			int newHp = getCurrentHp() - damage;
			if (newHp <= 0 && !isDead()) {
				int transformId = template.getTransformId();
				if (transformId == -1) {
					setCurrentHpDirect(0);
					setDead(true);
					setStatus(ActionCodes.ACTION_Die);
					openDoorWhenNpcDied(this);
					Death death = new Death(attacker);
					GeneralThreadPool.getInstance().execute(death);
					// Death(attacker);
				} else {
					// distributeExpDropKarma(attacker);
					transform(transformId);
				}
			}
			if (newHp > 0) {
				setCurrentHp(newHp);
				hide();
			}
		} else if (!isDead()) {
			setDead(true);
			setStatus(ActionCodes.ACTION_Die);
			Death death = new Death(attacker);
			GeneralThreadPool.getInstance().execute(death);
			// Death(attacker);
		}
	}

	private static void openDoorWhenNpcDied(L1NpcInstance npc) {
		int[] npcId = { 46143, 46144, 46145, 46146, 46147, 46148, 46149, 46150,
				46151, 46152 };
		int[] doorId = { 5001, 5002, 5003, 5004, 5005, 5006, 5007, 5008, 5009,
				5010 };

		for (int i = 0; i < npcId.length; i++) {
			if (npc.getNpcTemplate().get_npcId() == npcId[i]) {
				openDoorInCrystalCave(doorId[i]);
			}
		}
	}

	private static void openDoorInCrystalCave(int doorId) {
		for (L1Object object : L1World.getInstance().getObject()) {
			if (object instanceof L1DoorInstance) {
				L1DoorInstance door = (L1DoorInstance) object;
				if (door.getDoorId() == doorId) {
					door.open();
				}
			}
		}
	}

	private void recall(L1PcInstance pc) {
		if (getMapId() != pc.getMapId())
			return;

		if (getLocation().getTileLineDistance(pc.getLocation()) > 4) {
			for (int count = 0; count < 10; count++) {
				L1Location newLoc = getLocation().randomLocation(3, 4, false);
				if (glanceCheck(newLoc.getX(), newLoc.getY())) {
					L1Teleport.teleport(pc, newLoc.getX(), newLoc.getY(),
							getMapId(), 5, true);
					break;
				}
			}
		}
	}

	@Override
	public void setCurrentHp(int i) {
		int currentHp = i;
		if (currentHp >= getMaxHp()) {
			currentHp = getMaxHp();
		}
		setCurrentHpDirect(currentHp);

		if (getMaxHp() > getCurrentHp()) {
			startHpRegeneration();
		}
	}

	@Override
	public void setCurrentMp(int i) {
		int currentMp = i;
		if (currentMp >= getMaxMp()) {
			currentMp = getMaxMp();
		}
		setCurrentMpDirect(currentMp);

		if (getMaxMp() > getCurrentMp()) {
			startMpRegeneration();
		}
	}

	class Death implements Runnable {
		L1Character _lastAttacker;

		public Death(L1Character lastAttacker) {
			_lastAttacker = lastAttacker;
		}

		@Override
		public void run() {
			setDeathProcessing(true);
			setCurrentHpDirect(0);
			setDead(true);
			setStatus(ActionCodes.ACTION_Die);

			getMap().setPassable(getLocation(), true);

			broadcastPacket(new S_DoActionGFX(getId(), ActionCodes.ACTION_Die));

			startChat(CHAT_TIMING_DEAD);

			distributeExpDropKarma(_lastAttacker);
			giveUbSeal();

			setDeathProcessing(false);

			setExp(0);
			setKarma(0);
			allTargetClear();

			startDeleteTimer();
		}
	}

	private void distributeExpDropKarma(L1Character lastAttacker) {
		if (lastAttacker == null) {
			return;
		}
		L1PcInstance pc = null;
		if (lastAttacker instanceof L1PcInstance) {
			pc = (L1PcInstance) lastAttacker;
		} else if (lastAttacker instanceof L1PetInstance) {
			pc = (L1PcInstance) ((L1PetInstance) lastAttacker).getMaster();
		} else if (lastAttacker instanceof L1SummonInstance) {
			pc = (L1PcInstance) ((L1SummonInstance) lastAttacker).getMaster();
		}

		if (pc != null) {
			ArrayList<L1Character> targetList = _hateList.toTargetArrayList();
			ArrayList<Integer> hateList = _hateList.toHateArrayList();
			int exp = getExp();
			CalcExp.calcExp(pc, getId(), targetList, hateList, exp);
			if (isDead()) {
				distributeDrop();
				giveKarma(pc);
			}
		} else if (lastAttacker instanceof L1EffectInstance) {
			ArrayList<L1Character> targetList = _hateList.toTargetArrayList();
			ArrayList<Integer> hateList = _hateList.toHateArrayList();
			if (hateList.size() != 0) {
				int maxHate = 0;
				for (int i = hateList.size() - 1; i >= 0; i--) {
					if (maxHate < hateList.get(i)) {
						maxHate = (hateList.get(i));
						lastAttacker = targetList.get(i);
					}
				}
				if (lastAttacker instanceof L1PcInstance) {
					pc = (L1PcInstance) lastAttacker;
				} else if (lastAttacker instanceof L1PetInstance) {
					pc = (L1PcInstance) ((L1PetInstance) lastAttacker)
							.getMaster();
				} else if (lastAttacker instanceof L1SummonInstance) {
					pc = (L1PcInstance) ((L1SummonInstance) lastAttacker)
							.getMaster();
				}
				if (pc != null) {
					int exp = getExp();
					CalcExp.calcExp(pc, getId(), targetList, hateList, exp);

					if (isDead()) {
						distributeDrop();
						giveKarma(pc);
					}
				}
			}
		}
	}

	private void distributeDrop() {
		ArrayList<L1Character> dropTargetList = _dropHateList
				.toTargetArrayList();
		ArrayList<Integer> dropHateList = _dropHateList.toHateArrayList();
		try {
			int npcId = getNpcTemplate().get_npcId();
			if (npcId != 45640 || (npcId == 45640 && getTempCharGfx() == 2332)) {
				DropTable.getInstance().dropShare(L1MonsterInstance.this,
						dropTargetList, dropHateList);
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	private void giveKarma(final L1PcInstance pc) {
		int karma = getKarma();

		if (karma == 0)
			return;

		int karmaSign = Integer.signum(karma);
		int pcKarmaLevel = pc.getKarmaLevel();
		int pcKarmaLevelSign = Integer.signum(pcKarmaLevel);
		if (pcKarmaLevelSign != 0 && karmaSign != pcKarmaLevelSign) {
			karma *= 5;
		}
		pc.addKarma((int) (karma * Config.RATE_KARMA));
	}

	private void giveUbSeal() {
		if (getUbSealCount() == 0)
			return;

		L1UltimateBattle ub = UBTable.getInstance().getUb(getUbId());
		if (ub == null)
			return;

		for (L1PcInstance pc : ub.getMembersArray()) {
			if (pc != null && !pc.isDead() && !pc.isGhost()) {
				L1ItemInstance item = pc.getInventory().storeItem(41402,
						getUbSealCount());
				pc.sendPackets(new S_ServerMessage(403, item.getLogName()));
			}
		}
	}

	public boolean is_storeDroped() {
		return _storeDroped;
	}

	public void set_storeDroped(boolean flag) {
		_storeDroped = flag;
	}

	private int _ubSealCount = 0;

	public int getUbSealCount() {
		return _ubSealCount;
	}

	public void setUbSealCount(int i) {
		_ubSealCount = i;
	}

	private int _ubId = 0;

	public int getUbId() {
		return _ubId;
	}

	public void setUbId(int i) {
		_ubId = i;
	}

	private void hide() {
		switch (getNpcTemplate().get_npcId()) {
		case 45061:
		case 45161:
		case 45181:
		case 45455:
			hideHelper(3, 10, 13, HIDDEN_STATUS_SINK, new S_DoActionGFX(
					getId(), ActionCodes.ACTION_Hide));
			break;
		case 45682:
			hideHelper(3, 50, 20, HIDDEN_STATUS_SINK, new S_DoActionGFX(
					getId(), ActionCodes.ACTION_AntharasHide));
			break;
		case 45067:
		case 45264:
		case 45452:
		case 45090:
		case 4532:
		case 45445:
			hideHelper(3, 10, 4, HIDDEN_STATUS_FLY, new S_DoActionGFX(getId(),
					ActionCodes.ACTION_Moveup));
			break;
		case 45681:
			hideHelper(3, 50, 11, HIDDEN_STATUS_FLY, new S_DoActionGFX(getId(),
					ActionCodes.ACTION_Moveup));
			break;
		case 46107:
		case 46108:
			hideHelper(4, 10, 13, HIDDEN_STATUS_SINK, new S_DoActionGFX(
					getId(), ActionCodes.ACTION_Hide));
			break;
		default:
		}
	}

	private void hideHelper(int hpFraction, int range, int status,
			int hiddenStatus, final ServerBasePacket action) {
		if (getMaxHp() / hpFraction > getCurrentHp()
				&& 1 > _random.nextInt(range)) {
			allTargetClear();
			setStatusAndHiddenStatus(status, hiddenStatus);
			broadcastPacket(action);
			broadcastPacket(new S_NPCPack(this));
		}
	}

	public void initHide() {
		initHideHelper(true);
	}

	public void initHideForMinion(final L1NpcInstance leader) {
		int npcid = getNpcTemplate().get_npcId();
		if (leader.getHiddenStatus() == HIDDEN_STATUS_SINK
				|| leader.getHiddenStatus() == HIDDEN_STATUS_FLY
				|| (npcid >= 46125 && npcid <= 46128))
			initHideHelper(false);
	}

	private void initHideHelper(boolean random) {
		switch (getNpcTemplate().get_npcId()) {
		case 45061:
		case 45161:
		case 45181:
		case 45455:
		case 46107:
		case 46108:
			if (!random || 1 > _random.nextInt(3))
				setStatusAndHiddenStatus(13, HIDDEN_STATUS_SINK);
			break;
		case 45045:
		case 45126:
		case 45134:
		case 45281:
			if (!random || 1 > _random.nextInt(3))
				setStatusAndHiddenStatus(4, HIDDEN_STATUS_SINK);
			break;
		case 45067:
		case 45264:
		case 45452:
		case 45090:
		case 45321:
		case 45445:
			setStatusAndHiddenStatus(4, HIDDEN_STATUS_FLY);
			break;
		case 45681:
			setStatusAndHiddenStatus(11, HIDDEN_STATUS_FLY);
			break;
		case 46125:
		case 46126:
		case 46127:
		case 46128:
			setStatusAndHiddenStatus(4, HIDDEN_STATUS_ICE);
			break;
		default:
		}
	}

	private void setStatusAndHiddenStatus(int status, int hiddenStatus) {
		setHiddenStatus(hiddenStatus);
		setStatus(status);
	}

	@Override
	protected void transform(int transformId) {
		super.transform(transformId);
		getInventory().clearItems();
		DropTable.getInstance().setDrop(this, getInventory());
		getInventory().shuffle();
	}
}
