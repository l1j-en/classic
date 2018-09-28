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
package l1j.server.server.command.executor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1NamedSkill;
import l1j.server.server.serverpackets.S_SystemMessage;

public class FindSkill implements L1CommandExecutor {

	private static Logger _log = LoggerFactory.getLogger(FindSkill.class);

	private FindSkill() {
	}

	public static L1CommandExecutor getInstance() {
		return new FindSkill();
	}

	@Override
	public void execute(L1PcInstance user, String commandName, String target) {
		try {
			findSkill(user, target);
		} catch (Exception e) {
			_log.error("",e);
			user.sendPackets(new S_SystemMessage(".findSkill <name|number>."));
		}
	}

	private void findSkill(L1PcInstance gm, String query) {
		if (query.isEmpty()) {
			gm.sendPackets(new S_SystemMessage(".findskill <name|number>."));
			return;
		}
		try {
			Integer id = Integer.valueOf(query);
			gm.sendPackets(new S_SystemMessage(String.valueOf(id) + " is "
					+ L1NamedSkill.getName(id) + "."));
		} catch (NumberFormatException e) {
			List<L1NamedSkill> skills = L1NamedSkill.searchNames(query);
			String message = "Found: ";
			for (L1NamedSkill skill : skills) {
				message += " |" + " " + skill.name() + " " + skill.getId();
			}
			message += ".";
			gm.sendPackets(new S_SystemMessage(message));
		}
	}
}
