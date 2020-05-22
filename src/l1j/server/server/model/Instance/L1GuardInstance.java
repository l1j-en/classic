package l1j.server.server.model.Instance;

import java.util.HashMap;
import java.util.Map;

import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1World;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.types.Point;

public class L1GuardInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;

	private static final Map<Integer, Integer> guardsToCastles = new HashMap<Integer, Integer>();

	private static final Map<Integer, String> guardsToText = new HashMap<Integer, String>();

	static {
		guardsToCastles.put(70549, L1CastleLocation.KENT_CASTLE_ID);
		guardsToCastles.put(70985, L1CastleLocation.KENT_CASTLE_ID);
		guardsToCastles.put(70656, L1CastleLocation.KENT_CASTLE_ID);
		guardsToCastles.put(60514, L1CastleLocation.KENT_CASTLE_ID);
		guardsToCastles.put(60513, L1CastleLocation.KENT_CASTLE_ID);
		guardsToCastles.put(70600, L1CastleLocation.OT_CASTLE_ID);
		guardsToCastles.put(70986, L1CastleLocation.OT_CASTLE_ID);
		guardsToCastles.put(60560, L1CastleLocation.OT_CASTLE_ID);
		guardsToCastles.put(70687, L1CastleLocation.WW_CASTLE_ID);
		guardsToCastles.put(70987, L1CastleLocation.WW_CASTLE_ID);
		guardsToCastles.put(70778, L1CastleLocation.WW_CASTLE_ID);
		guardsToCastles.put(60552, L1CastleLocation.WW_CASTLE_ID);
		guardsToCastles.put(70800, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(70988, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(70989, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(70990, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(70991, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(70817, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(60524, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(60525, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(60529, L1CastleLocation.GIRAN_CASTLE_ID);
		guardsToCastles.put(70862, L1CastleLocation.HEINE_CASTLE_ID);
		guardsToCastles.put(70992, L1CastleLocation.HEINE_CASTLE_ID);
		guardsToCastles.put(70863, L1CastleLocation.HEINE_CASTLE_ID);
		guardsToCastles.put(70857, L1CastleLocation.HEINE_CASTLE_ID);
		guardsToCastles.put(71273, L1CastleLocation.HEINE_CASTLE_ID);
		guardsToCastles.put(70993, L1CastleLocation.DOWA_CASTLE_ID);
		guardsToCastles.put(70994, L1CastleLocation.DOWA_CASTLE_ID);
		guardsToCastles.put(70995, L1CastleLocation.DOWA_CASTLE_ID);
		guardsToCastles.put(60530, L1CastleLocation.DOWA_CASTLE_ID);
		guardsToCastles.put(60531, L1CastleLocation.DOWA_CASTLE_ID);
		guardsToCastles.put(70996, L1CastleLocation.ADEN_CASTLE_ID);
		guardsToCastles.put(60533, L1CastleLocation.ADEN_CASTLE_ID);
		guardsToCastles.put(60534, L1CastleLocation.ADEN_CASTLE_ID);
		guardsToCastles.put(81156, L1CastleLocation.DIAD_CASTLE_ID);

		guardsToText.put(60514, "ktguard6");
		guardsToText.put(60560, "orcguard6");
		guardsToText.put(60552, "wdguard6");
		guardsToText.put(60524, "grguard6");
		guardsToText.put(60525, "grguard6");
		guardsToText.put(60529, "grguard6");
		guardsToText.put(70857, "heguard6");
		guardsToText.put(60530, "dcguard6");
		guardsToText.put(60531, "dcguard6");
		guardsToText.put(60533, "adguard6");
		guardsToText.put(60534, "adguard6");
		guardsToText.put(81156, "ktguard6");
	}

	@Override
	public void searchTarget() {
		int npcid = getNpcTemplate().get_npcId();
		for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(this)) {
			if (pc.getCurrentHp() <= 0 || pc.isDead() || pc.isGm()
					|| pc.isGhost() || pc.isGmInvis()) {
				continue;
			}
			if (!pc.isInvisble() || getNpcTemplate().is_agrocoi()) {
				// target pk'ers if not castle owners
				// custom, do not remove in merges
				// if the pc is wanted and it isn't a castle guard -- then attack
				// if the pc is wanted and it is a castle guard and they don't
				// own the castle -- attack
				if (pc.isWanted()
						&& (!guardsToCastles.containsKey(npcid)
								|| (guardsToCastles.containsKey(npcid) 
								&& !checkHasCastle(pc, guardsToCastles.get(npcid))))) {
					_hateList.add(pc, 0);
					_target = pc;
					return;
				}
			}
		}
	}

	public void setTarget(final L1PcInstance targetPlayer) {
		if (targetPlayer != null) {
			_hateList.add(targetPlayer, 0);
			_target = targetPlayer;
		}
	}

	public boolean noTarget(int depth) {
		if (getLocation()
				.getTileLineDistance(new Point(getHomeX(), getHomeY())) > 0) {
			int dir = moveDirection(getHomeX(), getHomeY());
			if (dir != -1) {
				setDirectionMove(dir);
				setSleepTime(calcSleepTime(getPassispeed(), MOVE_SPEED));
			} else {
				teleport(getHomeX(), getHomeY(), 1);
			}
		} else if (L1World.getInstance().getRecognizePlayer(this).size() == 0) {
			return true;
		}
		return false;
	}

	public L1GuardInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onNpcAI() {
		if (isAiRunning()) {
			return;
		}
		setActived(false);
		startAI();
		startChat(CHAT_TIMING_APPEARANCE);
	}

	@Override
	public void onAction(L1PcInstance pc) {
		if (isDead())
			return;

		if (getCurrentHp() > 0) {
			L1Attack attack = new L1Attack(pc, this);
			if (attack.calcHit()) {
				attack.calcDamage();
				attack.calcStaffOfMana();
				attack.addPcPoisonAttack(pc, this);
				attack.addChaserAttack();
			}
			attack.action();
			attack.commit();
		} else {
			L1Attack attack = new L1Attack(pc, this);
			attack.calcHit();
			attack.action();
		}
	}

	@Override
	public void onTalkAction(L1PcInstance player) {
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
				getNpcTemplate().get_npcId());
		int npcid = getNpcTemplate().get_npcId();
		String htmlid = null;
		String[] htmldata = null;

		if (talking == null)
			return;

		switch (npcid) {
		case 70993:
		case 70994:
		case 70862:
		case 70992:
		case 70800:
		case 70988:
		case 70989:
		case 70990:
		case 70991:
		case 70687:
		case 70987:
		case 70549:
		case 70985:
			if (checkHasCastle(player, guardsToCastles.get(npcid))) {
				htmlid = "gateokeeper";
				htmldata = new String[] { player.getName() };
			} else
				htmlid = "gatekeeperop";
			break;
		case 70995:
		case 70996:
		case 70778:
		case 70817:
		case 70656:
		case 71273:
		case 70863:
			if (checkHasCastle(player, guardsToCastles.get(npcid))) {
				htmlid = "gatekeeper";
				htmldata = new String[] { player.getName() };
			} else
				htmlid = "gatekeeperop";
			break;
		case 70600:
		case 70986:
			htmlid = checkHasCastle(player, guardsToCastles.get(npcid)) ? "orckeeper"
					: "orckeeperop";
			break;
		case 60514:
		case 60560:
		case 60552:
		case 60524:
		case 60525:
		case 60529:
		case 70857:
		case 60530:
		case 60531:
		case 60533:
		case 60534:
		case 81156:
			String[] owner = getCastleOwner(guardsToCastles.get(npcid));
			htmlid = guardsToText.get(npcid);
			htmldata = new String[] { getName(), owner[0], owner[1] };
			break;
		default:
			// Can't actually get here.
		}

		// html
		if (htmlid != null)
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, htmldata));
		else
			player.sendPackets(new S_NPCTalkReturn(talking, objid, player
					.getLawful() < -1000 ? 2 : 1));
	}

	private static String[] getCastleOwner(final int castleId) {
		for (L1Clan clan : L1World.getInstance().getAllClans())
			if (clan.getCastleId() == castleId)
				return new String[] { clan.getClanName(), clan.getLeaderName() };
		return new String[] { "", "" };
	}

	public void onFinalAction() {

	}

	public void doFinalAction() {

	}

	@Override
	public void receiveDamage(final L1Character attacker, int damage) {
		if (attacker instanceof L1PcInstance) {
			((L1PcInstance) attacker).setLastAggressiveAct();
		}
		
		if (getCurrentHp() > 0 && !isDead()) {
			if (damage >= 0) {
				if (!(attacker instanceof L1EffectInstance)) {
					setHate(attacker, damage);
				}
			}
			if (damage > 0) {
				removeSkillEffect(L1SkillId.FOG_OF_SLEEPING);
			}

			onNpcAI();

			if (attacker instanceof L1PcInstance && damage > 0) {
				L1PcInstance pc = (L1PcInstance) attacker;
				pc.setPetTarget(this);
			}

			int newHp = getCurrentHp() - damage;
			if (newHp <= 0 && !isDead()) {
				setCurrentHpDirect(0);
				setDead(true);
				setStatus(ActionCodes.ACTION_Die);
				Death death = new Death(attacker);
				GeneralThreadPool.getInstance().execute(death);
			}
			if (newHp > 0) {
				setCurrentHp(newHp);
			}
		} else if (getCurrentHp() == 0 && !isDead()) {
		} else if (!isDead()) {
			setDead(true);
			setStatus(ActionCodes.ACTION_Die);
			Death death = new Death(attacker);
			GeneralThreadPool.getInstance().execute(death);
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

	class Death implements Runnable {
		L1Character _lastAttacker;

		public Death(L1Character lastAttacker) {
			_lastAttacker = lastAttacker;
		}

		@Override
		public void run() {
			try {
				Thread.currentThread().setName("L1GuardInstance-Death");
				setDeathProcessing(true);
				setCurrentHpDirect(0);
				setDead(true);
				setStatus(ActionCodes.ACTION_Die);

				getMap().setPassable(getLocation(), true);

				broadcastPacket(new S_DoActionGFX(getId(), ActionCodes.ACTION_Die));

				startChat(CHAT_TIMING_DEAD);

				setDeathProcessing(false);

				allTargetClear();

				startDeleteTimer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("",e);
			}
		}
	}

	private static boolean isCastleOwned(int castleId) {
		for (L1Clan clan : L1World.getInstance().getAllClans())
			if (clan.getCastleId() == castleId)
				return true;
		return false;
	}

	private boolean checkHasCastle(final L1PcInstance pc, int castleId) {
		// TODO: double check this. It doesn't really make sense that unowned
		// castles should respond this way.
		if (!isCastleOwned(castleId))
			return true;

		if (pc.getClanid() != 0) {
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null)
				return clan.getCastleId() == castleId;
		}
		return false;
	}
}
