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
import org.apache.log4j.Logger;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_WhoAmount;

public class L1Who implements L1CommandExecutor {
	private static Logger log = Logger.getLogger(L1Who.class.getName());

	private L1Who() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Who();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			Collection<L1PcInstance> players = L1World.getInstance()
					.getAllPlayers();
			String amount = String.valueOf(players.size());
			S_WhoAmount s_whoamount = new S_WhoAmount(amount);
			pc.sendPackets(s_whoamount);

			
			if (arg.equalsIgnoreCase("all")) {
				pc.sendPackets(new S_SystemMessage("-- Players --"));
				StringBuffer buf = new StringBuffer();
				for (L1PcInstance each : players) {
					buf.append(each.getName());
					buf.append(" / ");
					if (buf.length() > 50) {
						pc.sendPackets(new S_SystemMessage(buf.toString()));
						buf.delete(0, buf.length() - 1);
					}
				}
				if (buf.length() > 0) {
					pc.sendPackets(new S_SystemMessage(buf.toString()));
				}
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".who [all]"));
		}
	}
}
