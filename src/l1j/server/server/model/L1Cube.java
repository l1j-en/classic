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

import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.EARTH_BIND;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BLIZZARD;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BREATH;
import static l1j.server.server.model.skill.L1SkillId.ICE_LANCE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_BALANCE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_IGNITION_TO_ENEMY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_QUAKE_TO_ENEMY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_SHOCK_TO_ENEMY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_FREEZE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_MR_REDUCTION_BY_CUBE_SHOCK;

import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_Paralysis;

public class L1Cube implements Runnable {
	private static Logger _log = LoggerFactory.getLogger(L1Cube.class.getName());

	private ScheduledFuture<?> _future = null;
	private int _timeCounter = 0;
	private final L1Character _effect;
	private final L1Character _cha;
	private final int _skillId;

	private String originalThreadName;

	public L1Cube(L1Character effect, L1Character cha, int skillId) {
		_effect = effect;
		_cha = cha;
		_skillId = skillId;
	}

	@Override
	public void run() {
		try {
			originalThreadName = Thread.currentThread().getName();
			Thread.currentThread().setName("L1Cube");
			if (_cha.isDead()) {
				stop();
				return;
			}
			if (!_cha.hasSkillEffect(_skillId)) {
				stop();
				return;
			}
			_timeCounter++;
			giveEffect();
		} catch (Throwable e) {
			_log.warn(e.getLocalizedMessage(), e);
		} finally {
			Thread.currentThread().setName(originalThreadName);
		}
	}

	public void begin() {
		// 8bA4bXLl1
		// Jn0.9b
		_future = GeneralThreadPool.getInstance().scheduleAtFixedRate(this,
				900, 1000);
	}

	public void stop() {
		if (_future != null) {
			_future.cancel(false);
		}
	}

	public void giveEffect() {
		if (_skillId == STATUS_CUBE_IGNITION_TO_ENEMY) {
			if (_timeCounter % 4 != 0) {
				return;
			}
			if (_cha.hasSkillEffect(STATUS_FREEZE)) {
				return;
			}
			if (_cha.hasSkillEffect(ABSOLUTE_BARRIER)) {
				return;
			}
			if (_cha.hasSkillEffect(ICE_LANCE)) {
				return;
			}
			if (_cha.hasSkillEffect(FREEZING_BLIZZARD)) {
				return;
			}
			if (_cha.hasSkillEffect(FREEZING_BREATH)) {
				return;
			}
			if (_cha.hasSkillEffect(EARTH_BIND)) {
				return;
			}

			if (_cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) _cha;
				pc.sendPackets(new S_DoActionGFX(pc.getId(),
						ActionCodes.ACTION_Damage));
				pc.broadcastPacket(new S_DoActionGFX(pc.getId(),
						ActionCodes.ACTION_Damage));
				pc.receiveDamage(_effect, 10, false);
			} else if (_cha instanceof L1MonsterInstance) {
				L1MonsterInstance mob = (L1MonsterInstance) _cha;
				mob.broadcastPacket(new S_DoActionGFX(mob.getId(),
						ActionCodes.ACTION_Damage));
				mob.receiveDamage(_effect, 10);
			}
		} else if (_skillId == STATUS_CUBE_QUAKE_TO_ENEMY) {
			if (_timeCounter % 4 != 0) {
				return;
			}
			if (_cha.hasSkillEffect(STATUS_FREEZE)) {
				return;
			}
			if (_cha.hasSkillEffect(ABSOLUTE_BARRIER)) {
				return;
			}
			if (_cha.hasSkillEffect(ICE_LANCE)) {
				return;
			}
			if (_cha.hasSkillEffect(FREEZING_BLIZZARD)) {
				return;
			}
			if (_cha.hasSkillEffect(FREEZING_BREATH)) {
				return;
			}
			if (_cha.hasSkillEffect(EARTH_BIND)) {
				return;
			}

			if (_cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) _cha;
				pc.setSkillEffect(STATUS_FREEZE, 1000);
				pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_BIND, true));
			} else if (_cha instanceof L1MonsterInstance) {
				L1MonsterInstance mob = (L1MonsterInstance) _cha;
				mob.setSkillEffect(STATUS_FREEZE, 1000);
				mob.setParalyzed(true);
			}
		} else if (_skillId == STATUS_CUBE_SHOCK_TO_ENEMY) {
			// if (_timeCounter % 5 != 0) {
			// return;
			// }
			// _cha.addMr(-10);
			// if (_cha instanceof L1PcInstance) {
			// L1PcInstance pc = (L1PcInstance) _cha;
			// pc.sendPackets(new S_SPMR(pc));
			// }
			_cha.setSkillEffect(STATUS_MR_REDUCTION_BY_CUBE_SHOCK, 4000);
		} else if (_skillId == STATUS_CUBE_BALANCE) {
			if (_timeCounter % 4 == 0) {
				int newMp = _cha.getCurrentMp() + 5;
				if (newMp < 0) {
					newMp = 0;
				}
				_cha.setCurrentMp(newMp);
			}
			if (_timeCounter % 5 == 0) {
				if (_cha instanceof L1PcInstance) {
					L1PcInstance pc = (L1PcInstance) _cha;
					pc.receiveDamage(_effect, 25, false);
				} else if (_cha instanceof L1MonsterInstance) {
					L1MonsterInstance mob = (L1MonsterInstance) _cha;
					mob.receiveDamage(_effect, 25);
				}
			}
		}
	}

}
