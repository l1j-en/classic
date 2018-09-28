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

import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Recall implements L1CommandExecutor {

	private L1Recall() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Recall();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			if(arg.trim().equals(""))
				throw new Exception();
			
			Collection<L1PcInstance> targets = null;
			if (arg.equalsIgnoreCase("all")) {
				targets = L1World.getInstance().getAllPlayers();
			} else {
				targets = new ArrayList<L1PcInstance>();
				L1PcInstance tg = L1World.getInstance().getPlayer(arg);
				
				if (tg == null) {
					pc.sendPackets(new S_SystemMessage(arg + "is not online."));
					return;
				}
				
				targets.add(tg);
			}

			for (L1PcInstance target : targets) {
				if (target.isGm())
					continue;

				L1Teleport.teleportToTargetFront(target, pc, 2);
				pc.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(target.getName()).append(", what up!")
						.toString()));
				target.sendPackets(new S_SystemMessage("Hello."));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " [all|player_name]"));
		}
	}
}
