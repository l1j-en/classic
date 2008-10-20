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
package l1j.server.server.model.Instance;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

import l1j.server.ThreadPools.GeneralThreadPool;
import l1j.server.config.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.DropTable;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.serverpackets.S_ChangeHeading;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_NpcChatPacket;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.CalcExp;

public class L1GuardianInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;

	private static Logger _log = Logger.getLogger(L1GuardianInstance.class
			.getName());

	private Random _random = new Random();
	private L1GuardianInstance _npc = this;

	/**
	 * @param template
	 */
	public L1GuardianInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void searchTarget() {
		L1PcInstance targetPlayer = null;

		for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(this)) {
			if (pc.getCurrentHp() <= 0 || pc.isDead() || pc.isGm() || pc.isGhost()) {
				continue;
			}
			if (!pc.isInvisble() || getNpcTemplate().is_agrocoi()) {
				if (!pc.isElf()) {
					targetPlayer = pc;
					broadcastPacket(new S_NpcChatPacket(this, "$804", 2));
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
	public void onAction(L1PcInstance player) {
		if (player.getType() == 2 && player.getCurrentWeapon() == 0 && player.isElf()) {
			L1Attack attack = new L1Attack(player, this);

			if (attack.calcHit()) {
				if (getNpcTemplate().get_npcId() == 70848) {
					int chance = _random.nextInt(100) + 1;
					if (chance <= 10) {
						player.getInventory().storeItem(40506, 1);
						player.sendPackets(new S_ServerMessage(143, "$755", "$794"));
					} else if (chance <= 60 && chance > 10) {
						player.getInventory().storeItem(40507, 1);
						player.sendPackets(new S_ServerMessage(143, "$755", "$763"));
					} else if (chance <= 70 && chance > 60) {
						player.getInventory().storeItem(40505, 1);
						player.sendPackets(new S_ServerMessage(143, "$755", "$770"));
					}
				}
				if (getNpcTemplate().get_npcId() == 70850) {
					int chance = _random.nextInt(100) + 1;
					if (chance <= 30) {
						player.getInventory().storeItem(40519, 5);
						player.sendPackets(new S_ServerMessage(143, "$753", "$760" + " (" + 5 + ")"));
					}
				}
				if (getNpcTemplate().get_npcId() == 70846) {
					int chance = _random.nextInt(100) + 1;
					if (chance <= 30) {
						player.getInventory().storeItem(40503, 1);
						player.sendPackets(new S_ServerMessage(143, "$752", "$769"));
					}
				}
				attack.calcDamage();
				attack.calcStaffOfMana();
				attack.addPcPoisonAttack(player, this);
			}
			attack.action();
			attack.commit();
		} else if (getCurrentHp() > 0 && !isDead()) {
			L1Attack attack = new L1Attack(player, this);
			if (attack.calcHit()) {
				attack.calcDamage();
				attack.calcStaffOfMana();
				attack.addPcPoisonAttack(player, this);
			}
			attack.action();
			attack.commit();
		}
	}

	@Override
	public void onTalkAction(L1PcInstance player) {
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(getNpcTemplate().get_npcId());
		L1Object object = L1World.getInstance().findObject(getId());
		L1NpcInstance target = (L1NpcInstance) object;
		String htmlid = null;
		String[] htmldata = null;
		int npcid = getNpcTemplate().get_npcId();
		boolean hascastle = false;
		String clan_name = "";
		String pri_name = "";
		
		if (talking != null) {
			int pcx = player.getX();
			int pcy = player.getY();
			int npcx = target.getX();
			int npcy = target.getY();

			if (pcx == npcx && pcy < npcy) {
				setHeading(0);
			} else if (pcx > npcx && pcy < npcy) {
				setHeading(1);
			} else if (pcx > npcx && pcy == npcy) {
				setHeading(2);
			} else if (pcx > npcx && pcy > npcy) {
				setHeading(3);
			} else if (pcx == npcx && pcy > npcy) {
				setHeading(4);
			} else if (pcx < npcx && pcy > npcy) {
				setHeading(5);
			} else if (pcx < npcx && pcy == npcy) {
				setHeading(6);
			} else if (pcx < npcx && pcy < npcy) {
				setHeading(7);
			}
			broadcastPacket(new S_ChangeHeading(this));

				switch (npcid)
				{
					case 70549: 
					case 70985: {
					hascastle = checkHasCastle(player,
						L1CastleLocation.KENT_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gateokeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}
					}
					break;
					case 70656: { 
					hascastle = checkHasCastle(player,
							L1CastleLocation.KENT_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gatekeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}	
					}
					break;
					case 70600: 
					case 70986: {
					hascastle = checkHasCastle(player,
							L1CastleLocation.OT_CASTLE_ID);
					if (hascastle) { 
						htmlid = "orckeeper";
					} else {
						htmlid = "orckeeperop";
					}
						
					}
					break;
					case 70687: 
					case 70987: {
					hascastle = checkHasCastle(player,
							L1CastleLocation.WW_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gateokeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}
					}
					break;
					case 70778: { 
					hascastle = checkHasCastle(player,
							L1CastleLocation.WW_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gatekeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}	
					}
					break;
					case 70800: case 70988: case 70989: case 70990: case 70991: {
					hascastle = checkHasCastle(player,
							L1CastleLocation.GIRAN_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gateokeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}
					}
					break;
					case 70817: { 
					hascastle = checkHasCastle(player,
							L1CastleLocation.GIRAN_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gatekeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}	
					}
					break;
					case 70862: 
					case 70992: {
					hascastle = checkHasCastle(player,
							L1CastleLocation.HEINE_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gateokeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}
					}
					break;
					case 70863: { 
					hascastle = checkHasCastle(player,
							L1CastleLocation.HEINE_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gatekeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}	
					}
					break;
					case 70993: case 70994: {
					hascastle = checkHasCastle(player,
							L1CastleLocation.DOWA_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gateokeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}
					}
					break;
					case 70995: { 
					hascastle = checkHasCastle(player,
							L1CastleLocation.DOWA_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gatekeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}	
					}
					break;
					case 70996: { 
					hascastle = checkHasCastle(player,
							L1CastleLocation.ADEN_CASTLE_ID);
					if (hascastle) { 
						htmlid = "gatekeeper";
						htmldata = new String[] { player.getName() };
					} else {
						htmlid = "gatekeeperop";
					}
					}
					break;
					case 60514: { 
					for (L1Clan clan : L1World.getInstance().getAllClans()) {
						if (clan.getCastleId() 
						== L1CastleLocation.KENT_CASTLE_ID) {
							clan_name = clan.getClanName();
							pri_name = clan.getLeaderName();
							break;
						}
					}
					htmlid = "ktguard6";
					htmldata = new String[] { getName(), clan_name, pri_name };
					}
					break;
					case 60560: { 
					for (L1Clan clan : L1World.getInstance().getAllClans()) {
						if (clan.getCastleId() 
						== L1CastleLocation.OT_CASTLE_ID) {
							clan_name = clan.getClanName();
							pri_name = clan.getLeaderName();
							break;
						}
					}
					htmlid = "orcguard6";
					htmldata = new String[] { getName(), clan_name, pri_name };	
					}
					break;
					case 60552: {
					for (L1Clan clan : L1World.getInstance().getAllClans()) {
						if (clan.getCastleId()
						== L1CastleLocation.WW_CASTLE_ID) {
							clan_name = clan.getClanName();
							pri_name = clan.getLeaderName();
							break;
						}
					}
					htmlid = "wdguard6";
					htmldata = new String[] { getName(), clan_name, pri_name };	
					}
					break;
					case 60524:
					case 60525: 
					case 60529: { 
					for (L1Clan clan : L1World.getInstance().getAllClans()) {
						if (clan.getCastleId() 
						== L1CastleLocation.GIRAN_CASTLE_ID) {
							clan_name = clan.getClanName();
							pri_name = clan.getLeaderName();
							break;
						}
					}
					htmlid = "grguard6";
					htmldata = new String[] { getName(), clan_name, pri_name };
					}
					break;
					case 70857: {
					for (L1Clan clan : L1World.getInstance().getAllClans()) {
						if (clan.getCastleId() 
						== L1CastleLocation.HEINE_CASTLE_ID) {
							clan_name = clan.getClanName();
							pri_name = clan.getLeaderName();
							break;
						}
					}
					htmlid = "heguard6";
					htmldata = new String[] { getName(), clan_name, pri_name };
					}
					break;
					case 60530: 
					case 60531: {
					for (L1Clan clan : L1World.getInstance().getAllClans()) {
						if (clan.getCastleId() 
						== L1CastleLocation.DOWA_CASTLE_ID) {
							clan_name = clan.getClanName();
							pri_name = clan.getLeaderName();
							break;
						}
					}
					htmlid = "dcguard6";
					htmldata = new String[] { getName(), clan_name, pri_name };
					}
					break;
					case 60533: 
					case 60534: {
					for (L1Clan clan : L1World.getInstance().getAllClans()) {
						if (clan.getCastleId()
						== L1CastleLocation.ADEN_CASTLE_ID) {
							clan_name = clan.getClanName();
							pri_name = clan.getLeaderName();
							break;
						}
					}
					htmlid = "adguard6";
					htmldata = new String[] { getName(), clan_name, pri_name };
					}
					break;
					case 81156: { 
					for (L1Clan clan : L1World.getInstance().getAllClans()) {
						if (clan.getCastleId() 
						== L1CastleLocation.DIAD_CASTLE_ID) {
							clan_name = clan.getClanName();
							pri_name = clan.getLeaderName();
							break;
						}
					}
					htmlid = "ktguard6";
					htmldata = new String[] { getName(), clan_name, pri_name };
					}
					break;
				}
			if (htmlid != null) {
				if (htmldata != null) {
					player.sendPackets(new S_NPCTalkReturn(objid, htmlid, htmldata));
				} else {
					player.sendPackets(new S_NPCTalkReturn(objid, htmlid));
				}
			} else {
				if (player.getLawful() < -1000) {
					player.sendPackets(new S_NPCTalkReturn(talking, objid, 2));
				} else {
					player.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
				}
			}
			synchronized (this) {
				if (_monitor != null) {
					_monitor.cancel();
				}
				setRest(true);
				_monitor = new RestMonitor();
				_restTimer.schedule(_monitor, REST_MILLISEC);
			}
		}
	}

	@Override
	public void receiveDamage(L1Character attacker, int damage) {
		if (attacker instanceof L1PcInstance && damage > 0) {
			L1PcInstance pc = (L1PcInstance) attacker;
			if (pc.getType() == 2 && pc.getCurrentWeapon() == 0) {
			} else {
				if (getCurrentHp() > 0 && !isDead()) {
					if (damage >= 0) {
						setHate(attacker, damage);
					}
					if (damage > 0) {
						removeSkillEffect(L1SkillId.FOG_OF_SLEEPING);
					}
					onNpcAI();
					serchLink(pc, getNpcTemplate().get_family());
					if (damage > 0) {
						pc.setPetTarget(this);
					}

					int newHp = getCurrentHp() - damage;
					if (newHp <= 0 && !isDead()) {
						setCurrentHpDirect(0);
						setDead(true);
						_lastattacker = attacker;
						Death death = new Death();
						GeneralThreadPool.getInstance().execute(death);
					}
					if (newHp > 0) {
						setCurrentHp(newHp);
					}
				} else if (!isDead()) {
					setDead(true);
					_lastattacker = attacker;
					Death death = new Death();
					GeneralThreadPool.getInstance().execute(death);
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
		if (currentMp >= get_maxMp()) {
			currentMp = get_maxMp();
		}
		setCurrentMpDirect(currentMp);

		if (get_maxMp() > getCurrentMp()) {
			startMpRegeneration();
		}
	}

	private L1Character _lastattacker;

	class Death implements Runnable {
		L1Character lastAttacker = _lastattacker;

		public void run() {
			setDeathProcessing(true);
			setCurrentHpDirect(0);
			setDead(true);
			int targetobjid = getId();
			getMap().setPassable(getLocation(), true);
			broadcastPacket(new S_DoActionGFX(targetobjid, ActionCodes.ACTION_Die));

			L1PcInstance player = null;
			if (lastAttacker instanceof L1PcInstance) {
				player = (L1PcInstance) lastAttacker;
			} else if (lastAttacker instanceof L1PetInstance) {
				player = (L1PcInstance) ((L1PetInstance) lastAttacker).getMaster();
			} else if (lastAttacker instanceof L1SummonInstance) {
				player = (L1PcInstance) ((L1SummonInstance) lastAttacker).getMaster();
			}
			if (player != null) {
				ArrayList<L1Character> targetList = _hateList
						.toTargetArrayList();
				ArrayList<Integer> hateList = _hateList.toHateArrayList();
				int exp = getExp();
				CalcExp.calcExp(player, targetobjid, targetList, hateList, exp);

				ArrayList<L1Character> dropTargetList = _dropHateList
						.toTargetArrayList();
				ArrayList<Integer> dropHateList = _dropHateList
						.toHateArrayList();
				try {
					DropTable.getInstance().dropShare(_npc,
							dropTargetList, dropHateList);
				} catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
				player.addKarma((int) (getKarma() * Config.RATE_KARMA));
			}
			setDeathProcessing(false);

			setKarma(0);
			setExp(0);
			allTargetClear();

			startDeleteTimer();
		}
	}

	@Override
	public void onFinalAction(L1PcInstance player, String action) {
	}

	public void doFinalAction(L1PcInstance player) {
	}

	private static final long REST_MILLISEC = 10000;

	private static final Timer _restTimer = new Timer(true);

	private RestMonitor _monitor;

	public class RestMonitor extends TimerTask {
		@Override
		public void run() {
			setRest(false);
		}
	}

    private boolean checkHasCastle(L1PcInstance pc, int castleId) {
	for (L1Clan clan : L1World.getInstance().getAllClans()) {
		if (castleId == clan.getCastleId()) {
			break;
		}
	}
	
	if (pc.getClanid() != 0) {
		L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
		if (clan != null) {
			if (clan.getCastleId() == castleId) {
				return true;
			}
		}
	}
	return false;
}

}