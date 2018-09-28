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

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Buff implements L1CommandExecutor {

	private L1Buff() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Buff();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer tok = new StringTokenizer(arg);
			Collection<L1PcInstance> players = null;
			String s = tok.nextToken();
			if (s.equals("me")) {
				players = new ArrayList<L1PcInstance>();
				players.add(pc);
				s = tok.nextToken();
			} else if (s.equals("all")) {
				players = L1World.getInstance().getAllPlayers();
				s = tok.nextToken();
			} else {
				players = L1World.getInstance().getVisiblePlayer(pc);
			}

			int skillId = Integer.parseInt(s);
			int time = 0;
			if (tok.hasMoreTokens()) {
				time = Integer.parseInt(tok.nextToken());
			}

			for (L1PcInstance player : players) {
				new L1SkillUse().handleCommands(player, skillId,
						player.getId(), player.getX(), player.getY(), null,
						time, L1SkillUse.TYPE_GMBUFF, null, true);
			}

		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(cmdName
					+ " [all|me] skillId time"));
		}
	}
}
