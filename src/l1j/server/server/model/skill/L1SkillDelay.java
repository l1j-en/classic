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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.L1Character;

// Referenced classes of package l1j.server.server.model:
// L1SkillDelay

public class L1SkillDelay {


	private L1SkillDelay() {
	}

	static class SkillDelayTimer implements Runnable {
		private static Logger _log = LoggerFactory.getLogger(SkillDelayTimer.class);

		//private int _delayTime;
		private L1Character _cha;
		private String originalThreadName;

		public SkillDelayTimer(L1Character cha, int time) {
			_cha = cha;
			//_delayTime = time;
		}

		@Override
		public void run() {
			try {
			originalThreadName = Thread.currentThread().getName();
			Thread.currentThread().setName("L1SkillDelay-DelayTimer");
			stopDelayTimer();
			} catch (Exception e) {
				_log.error("",e);
			} finally {
				Thread.currentThread().setName(originalThreadName);
			}
		}

		public void stopDelayTimer() {
			_cha.setSkillDelay(false);
		}
	}

	public static void onSkillUse(L1Character cha, int time) {
		cha.setSkillDelay(true);
		GeneralThreadPool.getInstance().schedule(
				new SkillDelayTimer(cha, time), time);
	}

}
