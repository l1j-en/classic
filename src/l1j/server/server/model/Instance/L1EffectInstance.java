package l1j.server.server.model.Instance;

import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_BALANCE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_IGNITION_TO_ALLY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_IGNITION_TO_ENEMY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_QUAKE_TO_ALLY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_QUAKE_TO_ENEMY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_SHOCK_TO_ALLY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_SHOCK_TO_ENEMY;

import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Cube;
import l1j.server.server.model.L1Magic;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.ZoneType;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.templates.L1Npc;

public class L1EffectInstance extends L1NpcInstance {
	private static final long serialVersionUID = 1L;
//	private ScheduledFuture<?> _effectFuture;
	private static final int FW_DAMAGE_INTERVAL = 1000;
	private static final int CUBE_INTERVAL = 500;
	private static final int CUBE_TIME = 8000;
	private L1PcInstance _pc;
	private int _skillId;

	public L1EffectInstance(L1Npc template) {
		super(template);

		int npcId = getNpcTemplate().get_npcId();
		if (npcId == 81157) {
			GeneralThreadPool.getInstance().schedule(new FwDamageTimer(this), 0);
		} else if (npcId == 80149 || npcId == 80150 || npcId == 80151 || npcId == 80152) {
			GeneralThreadPool.getInstance().schedule(new CubeTimer(this), 0);
		}
	}

	public void setUser(L1PcInstance pc) {
		_pc = pc;
	}

	public L1PcInstance getUser() {
		return _pc;
	}

	public void setSkillId(int i) {
		_skillId = i;
	}

	public int getSkillId() {
		return _skillId;
	}

	@Override
	public void onAction(L1PcInstance pc) {
	}

	@Override
	public void deleteMe() {
		_destroyed = true;
		if (getInventory() != null) {
			getInventory().clearItems();
		}
		allTargetClear();
		_master = null;
		_pc = null;
		L1World.getInstance().removeVisibleObject(this);
		L1World.getInstance().removeObject(this);
		for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(this)) {
			pc.removeKnownObject(this);
			pc.sendPackets(new S_RemoveObject(this));
		}
		removeAllKnownObjects();
	}

	class FwDamageTimer implements Runnable {
		private L1EffectInstance _effect;

		public FwDamageTimer(L1EffectInstance effect) {
			_effect = effect;
		}

		@Override
		public void run() {
			try {
				Thread.currentThread().setName("L1EffectInstance-FwDmgTmer");
				while (!_destroyed) {
					try {
						for (L1Object object : L1World.getInstance().getVisibleObjects(_effect, 0)) {
							if (!(object instanceof L1PcInstance) && !(object instanceof L1MonsterInstance))
								continue;
							L1Character target = (L1Character) object;
							if (target.isDead())
								continue;
							L1Magic magic = new L1Magic(_effect, target);
							int damage = magic.calcFireWallDamage();
							if (damage == 0)
								continue;
							S_DoActionGFX packet = new S_DoActionGFX(target.getId(), ActionCodes.ACTION_Damage);
							if (object instanceof L1PcInstance) {
								L1PcInstance pc = (L1PcInstance) object;
								if (pc.getZoneType() == ZoneType.Safety && !atSiege(pc))
									continue;
								pc.sendPackets(packet);
								pc.receiveDamage(_effect, damage, false);
							} else
								((L1MonsterInstance) object).receiveDamage(_effect, damage);
							target.broadcastPacket(packet);
						}
						Thread.sleep(FW_DAMAGE_INTERVAL);
					} catch (InterruptedException ignore) {
						// ignore
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("",e);
			}
		}
	}

	private static boolean atSiege(L1Character character) {
		int castle = L1CastleLocation.getCastleIdByArea(character);
		return castle > 0 && WarTimeController.getInstance().isNowWar(castle);
	}

	private static boolean friendlyCube(L1PcInstance user, L1PcInstance other) {
		if (user.getId() == other.getId())
			return true;
		if (other.getClanid() != 0 && user.getClanid() == other.getClanid())
			return true;
		return other.isInParty() && other.getParty().isMember(user);
	}

	class CubeTimer implements Runnable {
		private L1EffectInstance _effect;
		private String originalThreadName;

		public CubeTimer(L1EffectInstance effect) {
			_effect = effect;
		}

		@Override
		public void run() {
			try {
				originalThreadName = Thread.currentThread().getName();
				Thread.currentThread().setName("L1EffectInstance-CubeTimer");
				while (!_destroyed) {
					try {
						for (L1Object object : L1World.getInstance().getVisibleObjects(_effect, 3)) {
							if (object instanceof L1PcInstance) {
								L1PcInstance pc = (L1PcInstance) object;
								if (pc.isDead()) {
									continue;
								}
								L1PcInstance user = getUser();
								if (friendlyCube(user, pc)) {
									cubeToAlly(pc, _effect);
									continue;
								}
								if (pc.getZoneType() == ZoneType.Safety && !atSiege(pc))
									continue;
								cubeToEnemy(pc, _effect);
							} else if (object instanceof L1MonsterInstance) {
								L1MonsterInstance mob = (L1MonsterInstance) object;
								if (mob.isDead()) {
									continue;
								}
								cubeToEnemy(mob, _effect);
							}
						}
						Thread.sleep(CUBE_INTERVAL);
					} catch (InterruptedException ignore) {
						// ignore
					}
				}
			} catch (Exception e) {
				_log.error("",e);
			} finally {
				Thread.currentThread().setName(originalThreadName);
			}
		}
	}

	private void cubeToAlly(L1Character cha, L1Character effect) {
		int npcId = getNpcTemplate().get_npcId();
		int castGfx = SkillTable.getInstance().findBySkillId(getSkillId()).getCastGfx();
		int skillEffect;
		switch (npcId) {
		case 80149:
			if (cha.hasSkillEffect(STATUS_CUBE_IGNITION_TO_ALLY))
				return;
			cha.addFire(30);
			skillEffect = STATUS_CUBE_IGNITION_TO_ALLY;
			break;
		case 80150:
			if (cha.hasSkillEffect(STATUS_CUBE_QUAKE_TO_ALLY))
				return;
			cha.addEarth(30);
			skillEffect = STATUS_CUBE_QUAKE_TO_ALLY;
			break;
		case 80151:
			if (cha.hasSkillEffect(STATUS_CUBE_SHOCK_TO_ALLY))
				return;
			cha.addWind(30);
			skillEffect = STATUS_CUBE_SHOCK_TO_ALLY;
			break;
		case 80152:
			if (cha.hasSkillEffect(STATUS_CUBE_BALANCE))
				return;
			skillEffect = STATUS_CUBE_BALANCE;
			break;
		default:
			return;
		}
		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			pc.sendPackets(new S_SkillSound(pc.getId(), castGfx));
			pc.sendPackets(new S_OwnCharAttrDef(pc));
		}
		cha.broadcastPacket(new S_SkillSound(cha.getId(), castGfx));
		cha.setSkillEffect(skillEffect, CUBE_TIME);
		if (npcId == 80152) {
			L1Cube cube = new L1Cube(effect, cha, STATUS_CUBE_BALANCE);
			cube.begin();
		}
	}

	private void cubeToEnemy(L1Character cha, L1Character effect) {
		int npcId = getNpcTemplate().get_npcId();
		int castGfx2 = SkillTable.getInstance().findBySkillId(getSkillId()).getCastGfx2();
		int skillEffect;
		switch (npcId) {
		case 80149:
			if (cha.hasSkillEffect(STATUS_CUBE_IGNITION_TO_ENEMY))
				return;
			skillEffect = STATUS_CUBE_IGNITION_TO_ENEMY;
			break;
		case 80150:
			if (cha.hasSkillEffect(STATUS_CUBE_QUAKE_TO_ENEMY))
				return;
			skillEffect = STATUS_CUBE_QUAKE_TO_ENEMY;
			break;
		case 80151:
			if (cha.hasSkillEffect(STATUS_CUBE_SHOCK_TO_ENEMY))
				return;
			skillEffect = STATUS_CUBE_SHOCK_TO_ENEMY;
			break;
		case 80152:
			if (cha.hasSkillEffect(STATUS_CUBE_BALANCE))
				return;
			skillEffect = STATUS_CUBE_BALANCE;
			break;
		default:
			return;
		}
		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			pc.sendPackets(new S_SkillSound(pc.getId(), castGfx2));
		}
		cha.broadcastPacket(new S_SkillSound(cha.getId(), castGfx2));
		cha.setSkillEffect(skillEffect, CUBE_TIME);
		L1Cube cube = new L1Cube(effect, cha, skillEffect);
		cube.begin();
	}
}
