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

import java.util.logging.Logger;

import java.lang.reflect.Constructor;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Quest;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.serverpackets.S_FollowerPack;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;

public class L1FollowerInstance extends L1NpcInstance {
	private static final long serialVersionUID = 1L;
	private static Logger _log =
		Logger.getLogger(L1FollowerInstance.class.getName());
	private final L1PcInstance _pc;

	@Override
	public boolean noTarget(int depth) {
		L1NpcInstance targetNpc = null;
		for (L1Object object : L1World.getInstance().getVisibleObjects(this)) {
			if (object instanceof L1NpcInstance) {
				L1NpcInstance npc = (L1NpcInstance) object;
				if (npc.getNpcTemplate().get_npcId() == 70740 
						&& getNpcTemplate().get_npcId() == 71093) { 
					setParalyzed(true);
					if (!_pc.getInventory().checkItem(40593)) {
						createNewItem(_pc, 40593, 1);
					}
					deleteMe();
					return true;
				} else if (npc.getNpcTemplate().get_npcId() == 70811 
						&& getNpcTemplate().get_npcId() == 71094) { 
					setParalyzed(true);
					if (!_pc.getInventory().checkItem(40582)) {
						createNewItem(_pc, 40582, 1);
					}
					deleteMe();
					return true;
				} else if (npc.getNpcTemplate().get_npcId() == 71061
						&& getNpcTemplate().get_npcId() == 71062) {
					if (getLocation().getTileLineDistance(_pc.getLocation()) < 3) {
						if((_pc.getX() >= 32448 && _pc.getX() <= 32452)
								&& (_pc.getY() >= 33048 && _pc.getY() <= 33052)
								&& (_pc.getMapId() == 440)) {						
							setParalyzed(true);
							if (!_pc.getInventory().checkItem(40711)) {
								createNewItem(_pc, 40711, 1);
								_pc.getQuest().set_step(L1Quest.QUEST_CADMUS, 3);
							}
							deleteMe();
							return true;
						}
					}
				} else if (npc.getNpcTemplate().get_npcId() == 71074
						&& getNpcTemplate().get_npcId() == 71075) {
					if (getLocation().getTileLineDistance(_pc.getLocation()) < 3) {
						if((_pc.getX() >= 32731 && _pc.getX() <= 32735) // 
								&& (_pc.getY() >= 32854 && _pc.getY() <= 32858)
								&& (_pc.getMapId() == 480)) {
							setParalyzed(true);
							if (!_pc.getInventory().checkItem(40633)) {
								createNewItem(_pc, 40633, 1);
								_pc.getQuest().set_step(L1Quest.QUEST_LIZARD, 2);
							}
							deleteMe();
							return true;
						}
					}
				} else if (npc.getNpcTemplate().get_npcId() == 70964 // 
						&& getNpcTemplate().get_npcId() == 70957) { // 
					if (getLocation().getTileLineDistance(_pc.getLocation()) < 3){
						if((_pc.getX() >= 32917 && _pc.getX() <= 32921) // 
								&& (_pc.getY() >= 32974 && _pc.getY() <= 32978)
								&& (_pc.getMapId() == 410)) {
							setParalyzed(true);
							createNewItem(_pc, 41003, 1);
							_pc.getQuest().set_step(L1Quest.QUEST_ROI, 0);					
							deleteMe();
							return true;
						}
					}
				}
			}
		}

		if (_pc.isDead() || 
				getLocation().getTileLineDistance(_pc.getLocation()) > 10) {
			setParalyzed(true);
			spawn(getNpcTemplate().get_npcId(), getX(), getY(), getHeading(),
					getMapId());
			deleteMe();
			return true;
		} else if (_pc != null && _pc.getMapId() == getMapId()) {
			if (getLocation().getTileLineDistance(_pc.getLocation()) > 2) {
				setDirectionMove(moveDirection(_pc.getX(), _pc.getY()));
				setSleepTime(calcSleepTime(getPassispeed(), MOVE_SPEED));
			}
		}
		return false;
	}

	public L1FollowerInstance(L1Npc template, L1NpcInstance target,
			L1Character master) {
		super(template);
		_master = master;
		_pc = (L1PcInstance) master;
		setId(IdFactory.getInstance().nextId());
		setMaster(master);
		setX(target.getX());
		setY(target.getY());
		setMap(target.getMapId());
		setHeading(target.getHeading());
		setLightSize(target.getLightSize());
		target.setParalyzed(true);
		target.deleteMe();
		L1World.getInstance().storeObject(this);
		L1World.getInstance().addVisibleObject(this);
		for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(this)) {
			onPerceive(pc);
		}
		startAI();
		_pc.addFollower(this);
	}

	@Override
	public synchronized void deleteMe() {
		_pc.getFollowerList().remove(getId());
		getMap().setPassable(getLocation(), true);
		super.deleteMe();
	}

	@Override
	public void onAction(L1PcInstance pc) {
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

	@Override
	public void onTalkAction(L1PcInstance player) {
		if (isDead())
			return;
		
		int template = getNpcTemplate().get_npcId();
		String message = null;
		if (template == 71093) {
			message = _pc.equals(player) ? "searcherk2" : "searcherk4";
		} else if (template == 71094) {
			message = _pc.equals(player) ? "endiaq2" : "endiaq4";
		} else if (template == 71062) {
			message = _pc.equals(player) ? "kamit2" : "kamit1";
		} else if (template == 71075) {
			message = _pc.equals(player) ? "llizard2" : "llizard1a";
		} else if (template == 70957) {
			// TODO: Look into this - should probably be like others.
			message = "roi2";
		}
		if (message != null)
			player.sendPackets(new S_NPCTalkReturn(getId(), message));
	}

	@Override
	public void onPerceive(L1PcInstance perceivedFrom) {
		perceivedFrom.addKnownObject(this);
		perceivedFrom.sendPackets(new S_FollowerPack(this, perceivedFrom));
	}

	private void createNewItem(L1PcInstance pc, int item_id, int count) {
		L1ItemInstance item = ItemTable.getInstance().createItem(item_id);
		item.setCount(count);
		if (item != null) {
			if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
				pc.getInventory().storeItem(item);
			} else {
				L1World.getInstance().getInventory(pc.getX(), pc.getY(),
						pc.getMapId()).storeItem(item);
			}
			pc.sendPackets(new S_ServerMessage(403, item.getLogName()));
		}
	}

	public void spawn(int npcId, int X, int Y, int H, short Map) {
		L1Npc template = NpcTable.getInstance().getTemplate(npcId);
	
		if (template == null)
			return;

		L1NpcInstance mob = null;
		try {
			String implementationName = template.getImpl();
			Constructor _constructor = Class.forName((new StringBuilder())
					.append("l1j.server.server.model.Instance.")
					.append(implementationName).append("Instance")
					.toString()).getConstructors()[0];
			mob = (L1NpcInstance) _constructor.newInstance(new Object[] { template });
			mob.setId(IdFactory.getInstance().nextId());
			mob.setX(X);
			mob.setY(Y);
			mob.setHomeX(X);
			mob.setHomeY(Y);
			mob.setMap(Map);
			mob.setHeading(H);
			L1World.getInstance().storeObject(mob);
			L1World.getInstance().addVisibleObject(mob);
			L1Object object = L1World.getInstance().findObject(mob.getId());
			L1QuestInstance newnpc = (L1QuestInstance) object;
			newnpc.onNpcAI();
			newnpc.turnOnOffLight();
			newnpc.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
