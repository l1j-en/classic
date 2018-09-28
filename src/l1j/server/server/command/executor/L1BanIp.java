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

import java.util.StringTokenizer;

import l1j.server.server.datatables.IpTable;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1BanIp implements L1CommandExecutor {

	private L1BanIp() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1BanIp();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(arg);
			String ip = stringtokenizer.nextToken();
			String reason = "";
			IpTable iptable = IpTable.getInstance();
			boolean isBanned = iptable.isBannedIp(ip);
			
			for (L1PcInstance tg : L1World.getInstance().getAllPlayers()) {
				if (ip.equals(tg.getNetConnection().getIp())) {
					String msg = new StringBuilder().append(" IP: ").append(ip)
							.append(" Player: ").append(tg.getName())
							.toString();
					pc.sendPackets(new S_SystemMessage(msg));
				}
			}
			
			String action = stringtokenizer.nextToken().toLowerCase();			
			
			while(stringtokenizer.hasMoreTokens())
				reason += stringtokenizer.nextToken() + " ";
			
			reason = reason.trim();

			if ("add".equals(action)) {
				String msg = String.format("IP: %s is already banned.", ip);
				
				if(!isBanned) {
					iptable.banIp(ip, reason);
					msg = String.format("IP: %s has been banned.", ip);
				}
				
				pc.sendPackets(new S_SystemMessage(msg));
			} else if ("del".equals(action)) {
				String msg = String.format("IP: %s is not currently banned.", ip);
				if(isBanned) {
					if (iptable.liftBanIp(ip)) {
						msg = String.format("IP: %s has been unbanned.", ip);
					} else {
						msg = String.format("Failed to ban IP: %s.", ip);
					}
				}
				
				pc.sendPackets(new S_SystemMessage(msg));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(cmdName + " IP [ add | del ] [reason]"));
		}
	}
}
