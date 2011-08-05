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

import l1j.server.configure.Config;
import l1j.server.server.model.L1Character;

public class L1SkillTimerCreator {
	public static L1SkillTimer create(L1Character cha, int skillId,
			int timeMillis) {
		if (Config.SKILLTIMER_IMPLTYPE == 1) {
			return new L1SkillTimerTimerImpl(cha, skillId, timeMillis);
		} else if (Config.SKILLTIMER_IMPLTYPE == 2) {
			return new L1SkillTimerThreadImpl(cha, skillId, timeMillis);
		}

		// 不正な値の場合は、とりあえずTimer
		return new L1SkillTimerTimerImpl(cha, skillId, timeMillis);
	}
}
