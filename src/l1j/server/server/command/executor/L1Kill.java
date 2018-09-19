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

import java.util.Collection;

import l1j.server.server.command.L1Commands;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Kill implements L1CommandExecutor {
	private static boolean broadcast = false;
	
	private L1Kill() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Kill();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			String command = arg.trim().toLowerCase();
			
			if(command.equals(""))
				throw new Exception();
			
			if(command.equals("-broadcast")) {
				broadcast = !broadcast;
				L1World world = L1World.getInstance();
				Collection<L1PcInstance> players = world.getAllPlayers();
				int killAccessLevel = L1Commands.get(cmdName).getLevel();
				
				for(L1PcInstance player : players) {
					// notify everyone with the kill command that
					// broadcast has been enabled/disabled
					if(player.getAccessLevel().getLevel() >= killAccessLevel)
						player.sendPackets(
								new S_SystemMessage("GM .kill broadcast "
										+ (broadcast ? "enabled" : "disabled") + "."));
				} //end for
				
				return;
			}
				
			L1PcInstance target = L1World.getInstance().getPlayer(arg);
			
			// don't allow people with the .kill command to use it on people with
			// a higher access level
			if (target != null
					&& target.getAccessLevel().getLevel() < pc.getAccessLevel().getLevel()) {
				target.setCurrentHp(0);
				target.death(null);
				
				if(broadcast) {
					L1World world = L1World.getInstance();
					
					world.broadcastServerMessage(
							String.format("A GM has just slaughtered %s.", target.getName()));
				}
					
					
			} else {
				pc.sendPackets(new S_SystemMessage(arg + " is not online."));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <player_name> or .%1$s -broadcast", cmdName)));
		}
	}
}
