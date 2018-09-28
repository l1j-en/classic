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

import l1j.server.server.datatables.IpTable;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1PowerKick implements L1CommandExecutor {

	private L1PowerKick() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1PowerKick();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			if(arg.trim().equals(""))
				throw new Exception();
			
			L1PcInstance target = L1World.getInstance().getPlayer(arg);

			IpTable iptable = IpTable.getInstance();
			if (target != null) {
				iptable.banIp(target.getNetConnection().getIp());
				pc.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(target.getName())
						.append(" has been kicked and banned.").toString()));
				target.sendPackets(new S_Disconnect());
			} else {
				pc.sendPackets(new S_SystemMessage(arg + " is not online."));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <player_name>"));
		}
	}
}
