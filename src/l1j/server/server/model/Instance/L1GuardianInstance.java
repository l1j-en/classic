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

import static l1j.server.server.model.skill.L1SkillId.FOG_OF_SLEEPING;

import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.DropTable;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.serverpackets.S_ChangeHeading;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_NpcChatPacket;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.CalcExp;

public class L1GuardianInstance extends L1NpcInstance {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger _log = LoggerFactory.getLogger(L1GuardianInstance.class.getName());

	private L1GuardianInstance _npc = this;

	private ScheduledFuture<?> _monitorFuture;

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
			if (!pc.isGmInvis() && (!pc.isInvisble() || getNpcTemplate().is_agrocoi())) {
				if (!pc.isElf()) {
					targetPlayer = pc;
					wideBroadcastPacket(new S_NpcChatPacket(this, "$804", 2));
					break;
				} else if (pc.isElf() && pc.isWantedForElf()) {
					targetPlayer = pc;
					wideBroadcastPacket(new S_NpcChatPacket(this, "$815", 1));
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
					int chance = ThreadLocalRandom.current().nextInt(100) + 1;
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
					int chance = ThreadLocalRandom.current().nextInt(100) + 1;
					if (chance <= 30) {
						player.getInventory().storeItem(40519, 5);
						player.sendPackets(new S_ServerMessage(143, "$753", "$760" + " (" + 5 + ")"));
					}
				}
				if (getNpcTemplate().get_npcId() == 70846) {
					int chance = ThreadLocalRandom.current().nextInt(100) + 1;
					if (chance <= 30) {
						player.getInventory().storeItem(40503, 1);
						player.sendPackets(new S_ServerMessage(143, "$752", "$769"));
					}
				}
				attack.calcDamage();
				attack.calcStaffOfMana();
				attack.addPcPoisonAttack(player, this);
				attack.addChaserAttack();
			}
			attack.action();
			attack.commit();
		} else if (getCurrentHp() > 0 && !isDead()) {
			L1Attack attack = new L1Attack(player, this);
			if (attack.calcHit()) {
				attack.calcDamage();
				attack.calcStaffOfMana();
				attack.addPcPoisonAttack(player, this);
				attack.addChaserAttack();
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

			switch (getId()) {
			// ent
			case 70848:
				if (player.isElf()) {
					htmlid = "ente1";
				} else {
					htmlid = "entm1";
				}
				break;

			// pan
			case 70850:
				if (player.isElf()) {
					htmlid = "pane1";
				} else {
					htmlid = "panm1";
				}
				break;
			}
			if (htmlid != null) {

				player.sendPackets(new S_NPCTalkReturn(objid, htmlid));

			} else {
				if (player.getLawful() < -1000) {
					player.sendPackets(new S_NPCTalkReturn(talking, objid, 2));
				} else {
					player.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
				}
			}
			synchronized (this) {
				if (_monitor != null) {
					_monitorFuture.cancel(true);
				}
				setRest(true);
				_monitor = new RestMonitor();
				_monitorFuture = GeneralThreadPool.getInstance().schedule(_monitor, REST_MILLISEC);
			}
		}
	}

	@Override
	public void receiveDamage(L1Character attacker, int damage) {
		if (attacker instanceof L1PcInstance && damage > 0) {
			L1PcInstance pc = (L1PcInstance) attacker;
			
			pc.setLastAggressiveAct();
			if (pc.getType() == 2 && pc.getCurrentWeapon() == 0) {
			} else {
				if (getCurrentHp() > 0 && !isDead()) {
					if (damage >= 0) {
						setHate(attacker, damage);
					}
					if (damage > 0) {
						removeSkillEffect(FOG_OF_SLEEPING);
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
						setStatus(ActionCodes.ACTION_Die);
						_lastattacker = attacker;
						Death death = new Death();
						GeneralThreadPool.getInstance().execute(death);
					}
					if (newHp > 0) {
						setCurrentHp(newHp);
					}
				} else if (!isDead()) {
					setDead(true);
					setStatus(ActionCodes.ACTION_Die);
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
		if (currentMp >= getMaxMp()) {
			currentMp = getMaxMp();
		}
		setCurrentMpDirect(currentMp);

		if (getMaxMp() > getCurrentMp()) {
			startMpRegeneration();
		}
	}

	private L1Character _lastattacker;

	class Death implements Runnable {
		L1Character lastAttacker = _lastattacker;

		public void run() {
			try {
				Thread.currentThread().setName("L1GuardianInstance-Death");
				setDeathProcessing(true);
				setCurrentHpDirect(0);
				setDead(true);
				setStatus(ActionCodes.ACTION_Die);
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
					ArrayList<L1Character> targetList = _hateList.toTargetArrayList();
					ArrayList<Integer> hateList = _hateList.toHateArrayList();
					int exp = getExp();
					CalcExp.calcExp(player, targetobjid, targetList, hateList, exp);

					ArrayList<L1Character> dropTargetList = _dropHateList.toTargetArrayList();
					ArrayList<Integer> dropHateList = _dropHateList.toHateArrayList();
					try {
						DropTable.getInstance().dropShare(_npc, dropTargetList, dropHateList);
					} catch (Exception e) {
						_log.error(e.getLocalizedMessage(), e);
					}
					player.addKarma((int) (getKarma() * Config.RATE_KARMA));
				}
				setDeathProcessing(false);

				setKarma(0);
				setExp(0);
				allTargetClear();

				startDeleteTimer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("",e);
			}
		}
	}

	@Override
	public void onFinalAction(L1PcInstance player, String action) {
	}

	public void doFinalAction(L1PcInstance player) {
	}

	private static final long REST_MILLISEC = 10000;

	private RestMonitor _monitor;

	public class RestMonitor implements Runnable {
		@Override
		public void run() {
			try {
				setRest(false);
			} catch (Exception e) {
				_log.error("",e);
			}
		}
	}
}
