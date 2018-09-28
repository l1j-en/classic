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
package l1j.server.server.model;

import static l1j.server.server.model.skill.L1SkillId.COUNTER_BARRIER;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.MobSkillTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_NPCPack;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.templates.L1MobSkill;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Skill;

public class L1MobSkillUse {
	private static Logger _log = LoggerFactory			.getLogger(L1MobSkillUse.class.getName());

	private L1MobSkill _mobSkillTemplate = null;
	private L1NpcInstance _attacker = null;

	private L1Character _target = null;

	private Random _rnd = new Random();
	private int _sleepTime = 0;
	private int _skillUseCount[];

	public L1MobSkillUse(L1NpcInstance npc) {
		_mobSkillTemplate = MobSkillTable.getInstance().getTemplate(
				npc.getNpcTemplate().get_npcId());
		if (_mobSkillTemplate == null) {
			return;
		}
		_attacker = npc;
		_skillUseCount = new int[getMobSkillTemplate().getSkillSize()];
	}

	private int getSkillUseCount(int idx) {
		return _skillUseCount[idx];
	}

	private void skillUseCountUp(int idx) {
		_skillUseCount[idx]++;
	}

	public void resetAllSkillUseCount() {
		if (getMobSkillTemplate() == null) {
			return;
		}

		for (int i = 0; i < getMobSkillTemplate().getSkillSize(); i++) {
			_skillUseCount[i] = 0;
		}
	}

	public int getSleepTime() {
		return _sleepTime;
	}

	public void setSleepTime(int i) {
		_sleepTime = i;
	}

	public L1MobSkill getMobSkillTemplate() {
		return _mobSkillTemplate;
	}

	public boolean skillUse(L1Character tg) {
		if (_mobSkillTemplate == null) {
			return false;
		}
		_target = tg;

		int type;
		type = getMobSkillTemplate().getType(0);

		if (type == L1MobSkill.TYPE_NONE) {
			return false;
		}

		for (int i = 0; i < getMobSkillTemplate().getSkillSize()
				&& getMobSkillTemplate().getType(i) != L1MobSkill.TYPE_NONE; i++) {

			int changeType = getMobSkillTemplate().getChangeTarget(i);
			if (changeType > 0) {
				_target = changeTarget(changeType, i);
			} else {
				_target = tg;
			}

			if (isSkillUsable(i) == false) {
				continue;
			}

			type = getMobSkillTemplate().getType(i);
			if (type == L1MobSkill.TYPE_PHYSICAL_ATTACK) {
				if (physicalAttack(i) == true) {
					skillUseCountUp(i);
					return true;
				}
			} else if (type == L1MobSkill.TYPE_MAGIC_ATTACK) {
				if (magicAttack(i) == true) {
					skillUseCountUp(i);
					return true;

				}	
			} else if (type == L1MobSkill.TYPE_SUMMON) {
				if (Config.MAX_SERVANT_SUMMONS > -1 
						&& this._attacker.getServantSummonCount() > Config.MAX_SERVANT_SUMMONS) {
					skillUseCountUp(i);
					return true;
				}

				if (summon(i)) {
					skillUseCountUp(i);
					return true;
				}
			} else if (type == L1MobSkill.TYPE_POLY) {
				if (poly(i)) {
					skillUseCountUp(i);
					return true;
				}
			}
		}

		return false;
	}

	private boolean summon(int idx) {
		int summonId = getMobSkillTemplate().getSummon(idx);
		int min = getMobSkillTemplate().getSummonMin(idx);
		int max = getMobSkillTemplate().getSummonMax(idx);

		if (summonId == 0) {
			return false;
		}

		int count = _rnd.nextInt(max) + min;
		this._attacker.addServantSummon(count);
		mobspawn(summonId, count);

		_attacker.broadcastPacket(new S_SkillSound(_attacker.getId(), 761));

		S_DoActionGFX gfx = new S_DoActionGFX(_attacker.getId(),
				ActionCodes.ACTION_SkillBuff);
		_attacker.broadcastPacket(gfx);

		_sleepTime = _attacker.getNpcTemplate().getSubMagicSpeed();
		return true;
	}

	private boolean poly(int idx) {
		int polyId = getMobSkillTemplate().getPolyId(idx);
		boolean usePoly = false;

		if (polyId == 0) {
			return false;
		}

		for (L1PcInstance pc : L1World.getInstance()
				.getVisiblePlayer(_attacker)) {
			if (pc.isDead() || pc.isGhost() || pc.isGmInvis()) {
				continue;
			}
			if (_attacker.glanceCheck(pc.getX(), pc.getY()) == false) {
				continue;
			}

			int npcId = _attacker.getNpcTemplate().get_npcId();
			switch (npcId) {
			case 81082:
				pc.getInventory().takeoffEquip(945);
				break;
			default:
				break;
			}
			L1PolyMorph.doPoly(pc, polyId, 1800, L1PolyMorph.MORPH_BY_NPC);
			usePoly = true;
		}
		if (usePoly) {
			for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(
					_attacker)) {
				pc.sendPackets(new S_SkillSound(pc.getId(), 230));
				pc.broadcastPacket(new S_SkillSound(pc.getId(), 230));
				break;
			}
			S_DoActionGFX gfx = new S_DoActionGFX(_attacker.getId(),
					ActionCodes.ACTION_SkillBuff);
			_attacker.broadcastPacket(gfx);
			_sleepTime = _attacker.getNpcTemplate().getSubMagicSpeed();
		}

		return usePoly;
	}

	private boolean magicAttack(int idx) {
		L1SkillUse skillUse = new L1SkillUse();
		int skillid = getMobSkillTemplate().getSkillId(idx);
		boolean canUseSkill = false;

		if (skillid > 0) {
			canUseSkill = skillUse.checkUseSkill(null, skillid,
					_target.getId(), _target.getX(), _target.getY(), null, 0,
					L1SkillUse.TYPE_NORMAL, _attacker);
		}

		if (canUseSkill == true) {
			if (getMobSkillTemplate().getLeverage(idx) > 0) {
				skillUse.setLeverage(getMobSkillTemplate().getLeverage(idx));
			}
			skillUse.handleCommands(null, skillid, _target.getId(),
					_target.getX(), _target.getX(), null, 0,
					L1SkillUse.TYPE_NORMAL, _attacker);
			L1Skill skill = SkillTable.getInstance().findBySkillId(skillid);
			if (skill.getTarget().equals("attack") && skillid != 18) {
				_sleepTime = _attacker.getNpcTemplate().getAtkMagicSpeed();
			} else {
				_sleepTime = _attacker.getNpcTemplate().getSubMagicSpeed();
			}

			return true;
		}
		return false;
	}

	private boolean physicalAttack(int idx) {
		Map<Integer, Integer> targetList = new ConcurrentHashMap<Integer, Integer>();
		int areaWidth = getMobSkillTemplate().getAreaWidth(idx);
		int areaHeight = getMobSkillTemplate().getAreaHeight(idx);
		int range = getMobSkillTemplate().getRange(idx);
		int actId = getMobSkillTemplate().getActid(idx);
		int gfxId = getMobSkillTemplate().getGfxid(idx);
		
		int skillid = getMobSkillTemplate().getSkillId(idx);
		boolean canUseSkill = false;

		if (_attacker.getLocation().getTileLineDistance(_target.getLocation()) > range) {
			return false;
		}

		if (!_attacker.glanceCheck(_target.getX(), _target.getY())) {
			return false;
		}

		_attacker.setHeading(_attacker.targetDirection(_target.getX(),
				_target.getY()));

		if (areaHeight > 0) {
			ArrayList<L1Object> objs = L1World.getInstance()
					.getVisibleBoxObjects(_attacker, _attacker.getHeading(),
							areaWidth, areaHeight);

			for (L1Object obj : objs) {
				if (L1World.getInstance().findObject(obj.getId()) == null) {
					_log.error("L1MobSkillUse:physicalAttack: visibleBoxObject obj missing from L1World._allObjects!\n"
							+ obj.toString()
							+ " Id: "
							+ obj.getId()
							+ " Map: "
							+ obj.getMapId());

					// TODO: remove this stop-gap fix once a root cause has been
					// found
					L1World.getInstance().removeVisibleObject(obj);
					continue;
				}

				if (!(obj instanceof L1Character)) {
					continue;
				}

				L1Character cha = (L1Character) obj;
				if (cha.isDead()) {
					continue;
				}

				if (cha instanceof L1PcInstance) {
					if (((L1PcInstance) cha).isGhost()) {
						continue;
					}
				}

				if (!_attacker.glanceCheck(cha.getX(), cha.getY())) {
					continue;
				}

				if (_target instanceof L1PcInstance
						|| _target instanceof L1SummonInstance
						|| _target instanceof L1PetInstance) {
					//
					if (obj instanceof L1PcInstance
							&& !((L1PcInstance) obj).isGhost()
							&& !((L1PcInstance) obj).isGmInvis()
							|| obj instanceof L1SummonInstance
							|| obj instanceof L1PetInstance) {
						targetList.put(obj.getId(), 0);
					}
				} else {
					if (obj instanceof L1MonsterInstance) {
						targetList.put(obj.getId(), 0);
					}
				}
			}
		} else {
			targetList.put(_target.getId(), 0);
		}

		if (targetList.size() == 0) {
			return false;
		}

		Iterator<Integer> ite = targetList.keySet().iterator();
		while (ite.hasNext()) {
			int targetId = ite.next();
			L1Attack attack = new L1Attack(_attacker, (L1Character) L1World
					.getInstance().findObject(targetId));
			if (_target.hasSkillEffect(COUNTER_BARRIER)) {
				L1Magic magic = new L1Magic(_target, _attacker);
				if (magic.calcProbabilityMagic(COUNTER_BARRIER)
						&& _attacker.getLocation().getTileLineDistance(
								_target.getLocation()) <= 2 && gfxId == 0) {
					attack.actionCounterBarrier();
					attack.commitCounterBarrier();
					continue;
				}
			}
			if (attack.calcHit()) {
				if (getMobSkillTemplate().getLeverage(idx) > 0) {
					attack.setLeverage(getMobSkillTemplate().getLeverage(idx));
				}
				attack.calcDamage();
			}
			if (actId > 0) {
				attack.setActId(actId);
			}
			if (targetId == _target.getId()) {
				if (gfxId > 0) {
					_attacker.broadcastPacket(new S_SkillSound(_attacker
							.getId(), gfxId));
				}
				attack.action();
			}
			
			attack.commit();
			
			if (skillid > 0) {
				L1SkillUse skillUse = new L1SkillUse();
				canUseSkill = skillUse.checkUseSkill(null, skillid,
						_target.getId(), _target.getX(), _target.getY(), null, 0,
						L1SkillUse.TYPE_NORMAL, _attacker);
				
				
				if (canUseSkill == true) {
					if (getMobSkillTemplate().getLeverage(idx) > 0) {
						skillUse.setLeverage(getMobSkillTemplate().getLeverage(idx));
					}
					
					skillUse.handleCommands(null, skillid, _target.getId(),
							_target.getX(), _target.getX(), null, 0,
							L1SkillUse.TYPE_NORMAL, _attacker);
				}
			}
		}

		_sleepTime = _attacker.getAtkspeed();
		return true;
	}

	private boolean isSkillUsable(int skillIdx) {
		boolean usable = false;

		if (getMobSkillTemplate().getTriggerRandom(skillIdx) > 0) {
			int chance = _rnd.nextInt(100) + 1;
			if (chance < getMobSkillTemplate().getTriggerRandom(skillIdx)) {
				usable = true;
			} else {
				return false;
			}
		}

		if (getMobSkillTemplate().getTriggerHp(skillIdx) > 0) {
			int hpRatio = (_attacker.getCurrentHp() * 100)
					/ _attacker.getMaxHp();
			if (hpRatio <= getMobSkillTemplate().getTriggerHp(skillIdx)) {
				usable = true;
			} else {
				return false;
			}
		}

		if (getMobSkillTemplate().getTriggerCompanionHp(skillIdx) > 0) {
			L1NpcInstance companionNpc = searchMinCompanionHp();
			if (companionNpc == null) {
				return false;
			}

			int hpRatio = (companionNpc.getCurrentHp() * 100)
					/ companionNpc.getMaxHp();
			if (hpRatio <= getMobSkillTemplate()
					.getTriggerCompanionHp(skillIdx)) {
				usable = true;
				_target = companionNpc;
			} else {
				return false;
			}
		}

		if (getMobSkillTemplate().getTriggerRange(skillIdx) != 0) {
			int distance = _attacker.getLocation().getTileLineDistance(
					_target.getLocation());

			if (getMobSkillTemplate().isTriggerDistance(skillIdx, distance)) {
				usable = true;
			} else {
				return false;
			}
		}

		if (getMobSkillTemplate().getTriggerCount(skillIdx) > 0) {
			if (getSkillUseCount(skillIdx) < getMobSkillTemplate()
					.getTriggerCount(skillIdx)) {
				usable = true;
			} else {
				return false;
			}
		}
		return usable;
	}

	private L1NpcInstance searchMinCompanionHp() {
		L1NpcInstance npc;
		L1NpcInstance minHpNpc = null;
		int hpRatio = 100;
		int companionHpRatio;
		int family = _attacker.getNpcTemplate().get_family();

		for (L1Object object : L1World.getInstance().getVisibleObjects(
				_attacker)) {
			if (object instanceof L1NpcInstance) {
				npc = (L1NpcInstance) object;
				if (npc.getNpcTemplate().get_family() == family) {
					companionHpRatio = (npc.getCurrentHp() * 100)
							/ npc.getMaxHp();
					if (companionHpRatio < hpRatio) {
						hpRatio = companionHpRatio;
						minHpNpc = npc;
					}
				}
			}
		}
		return minHpNpc;
	}

	private void mobspawn(int summonId, int count) {
		for (int i = 0; i < count; i++)
			mobspawn(summonId);
	}

	private void mobspawn(int summonId) {
		try {
			L1Npc spawnmonster = NpcTable.getInstance().getTemplate(summonId);
			if (spawnmonster != null) {
				L1NpcInstance mob = null;
				try {
					String implementationName = spawnmonster.getImpl();
					Constructor<?> _constructor = Class
							.forName(
									(new StringBuilder())
											.append("l1j.server.server.model.Instance.")
											.append(implementationName)
											.append("Instance").toString())
							.getConstructors()[0];
					mob = (L1NpcInstance) _constructor
							.newInstance(new Object[] { spawnmonster });
					mob.setId(IdFactory.getInstance().nextId());
					L1Location loc = _attacker.getLocation().randomLocation(8,
							false);
					int heading = _rnd.nextInt(8);
					mob.setX(loc.getX());
					mob.setY(loc.getY());
					mob.setHomeX(loc.getX());
					mob.setHomeY(loc.getY());
					
					short mapid = _attacker.getMapId();
					mob.setMap(mapid);
					mob.setHeading(heading);
					L1World.getInstance().storeObject(mob);
					L1World.getInstance().addVisibleObject(mob);
					L1Object object = L1World.getInstance().findObject(
							mob.getId());
					L1MonsterInstance newnpc = (L1MonsterInstance) object;
					newnpc.setServantMaster(_attacker);
					newnpc.set_storeDroped(true);
					if (summonId == 45061 || summonId == 45161
							|| summonId == 45181 || summonId == 45455) {
						newnpc.broadcastPacket(new S_DoActionGFX(
								newnpc.getId(), ActionCodes.ACTION_Hide));
						newnpc.setStatus(13);
						newnpc.broadcastPacket(new S_NPCPack(newnpc));
						newnpc.broadcastPacket(new S_DoActionGFX(
								newnpc.getId(), ActionCodes.ACTION_Appear));
						newnpc.setStatus(0);
						newnpc.broadcastPacket(new S_NPCPack(newnpc));
					}
					newnpc.onNpcAI();
					newnpc.turnOnOffLight();
					newnpc.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE);
				} catch (Exception e) {
					_log.error(e.getLocalizedMessage(), e);
				}
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	private L1Character changeTarget(int type, int idx) {
		L1Character target;

		switch (type) {
		case L1MobSkill.CHANGE_TARGET_ME:
			target = _attacker;
			break;
		case L1MobSkill.CHANGE_TARGET_RANDOM:
			List<L1Character> targetList = new ArrayList<L1Character>();
			for (L1Object obj : L1World.getInstance().getVisibleObjects(
					_attacker)) {
				if (obj instanceof L1PcInstance || obj instanceof L1PetInstance
						|| obj instanceof L1SummonInstance) {
					L1Character cha = (L1Character) obj;

					int distance = _attacker.getLocation().getTileLineDistance(
							cha.getLocation());

					if (!getMobSkillTemplate().isTriggerDistance(idx, distance)) {
						continue;
					}

					if (!_attacker.glanceCheck(cha.getX(), cha.getY())) {
						continue;
					}

					if (!_attacker.getHateList().containsKey(cha)) {
						continue;
					}

					if (cha.isDead()) {
						continue;
					}

					if (cha instanceof L1PcInstance) {
						if (((L1PcInstance) cha).isGhost()) {
							continue;
						}
					}
					targetList.add((L1Character) obj);
				}
			}

			if (targetList.size() == 0) {
				target = _target;
			} else {
				int randomSize = targetList.size() * 100;
				int targetIndex = _rnd.nextInt(randomSize) / 100;
				target = targetList.get(targetIndex);
			}
			break;

		default:
			target = _target;
			break;
		}
		return target;
	}
}
