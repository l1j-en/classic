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
package l1j.server.server.model.poison;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Paralysis;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1ParalysisPoison extends L1Poison {

	private final L1Character _target;
	private Thread _timer;
	private final int _delay;
	private final int _time;
	private int _effectId = 1;

	private class ParalysisPoisonTimer extends Thread {
		@Override
		public void run() {
			_target.setSkillEffect(STATUS_POISON_PARALYZING, 0);

			try {
				Thread.sleep(_delay); 
			} catch (InterruptedException e) {
				_target
						.killSkillEffectTimer(STATUS_POISON_PARALYZING);
				return;
			}

			_effectId = 2;
			_target.setPoisonEffect(2);

			if (_target instanceof L1PcInstance) {
				L1PcInstance player = (L1PcInstance) _target;
				if (player.isDead() == false) {
					player.sendPackets(new S_Paralysis(1, true));
					_timer = new ParalysisTimer();
					GeneralThreadPool.getInstance().execute(_timer); 
					if (isInterrupted()) {
						_timer.interrupt();
					}
				}
			}
		}
	}

	private class ParalysisTimer extends Thread {
		@Override
		public void run() {
			_target.killSkillEffectTimer(STATUS_POISON_PARALYZING);
			_target.setSkillEffect(STATUS_POISON_PARALYZED, 0);
			try {
				Thread.sleep(_time);
			} catch (InterruptedException e) {
			}

			_target.killSkillEffectTimer(STATUS_POISON_PARALYZED);
			if (_target instanceof L1PcInstance) {
				L1PcInstance player = (L1PcInstance) _target;
				if (!player.isDead()) {
					player.sendPackets(new S_Paralysis(1, false));
					cure();
				}
			}
		}
	}

	private L1ParalysisPoison(L1Character cha, int delay, int time) {
		_target = cha;
		_delay = delay;
		_time = time;

		doInfection();
	}

	public static boolean doInfection(L1Character cha, int delay, int time) {
		if (!L1Poison.isValidTarget(cha)) {
			return false;
		}

		cha.setPoison(new L1ParalysisPoison(cha, delay, time));
		return true;
	}

	private void doInfection() {
		sendMessageIfPlayer(_target, 212);
		_target.setPoisonEffect(1);

		if (_target instanceof L1PcInstance) {
			_timer = new ParalysisPoisonTimer();
			GeneralThreadPool.getInstance().execute(_timer);
		}
	}

	@Override
	public int getEffectId() {
		return _effectId;
	}

	@Override
	public void cure() {
		if (_timer != null) {
			_timer.interrupt();
		}

		_target.setPoisonEffect(0);
		_target.setPoison(null);
	}
}
