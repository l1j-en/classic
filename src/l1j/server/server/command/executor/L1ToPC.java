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
import java.util.concurrent.ThreadLocalRandom;

import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1ToPC implements L1CommandExecutor {
	
 	
	private L1ToPC() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1ToPC();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			L1PcInstance target = L1World.getInstance().getPlayer(arg);
			
			if(arg.trim().equals(""))
				throw new Exception();
			
			if(target == null && arg.toLowerCase().equals("-rand")) {
				ArrayList<L1PcInstance> players
					= new ArrayList<L1PcInstance>(L1World.getInstance().getAllPlayers());
				
				if(players.size() < 2) {
					pc.sendPackets(new S_SystemMessage("-rand only works with more than 1 player."));
					return;
				} 
				
				for(int i = 0; i < 10 && (target == null || target.getId() == pc.getId()); i++) {
					int findPlayer = ThreadLocalRandom.current().nextInt(players.size());
					target = players.get(findPlayer);
				}
			}

			if (target != null) {
				L1Teleport.teleport(pc, target.getX(), target.getY(),
						target.getMapId(), 5, false);
				pc.sendPackets(new S_SystemMessage((new StringBuilder())
						.append("You appear next to ").append(target.getName()).toString()
						+ "."));
			} else {
				pc.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(arg).append(" is not online.").toString()));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <player_name> or -rand"));
		}
	}
}
