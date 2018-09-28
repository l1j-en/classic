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

import l1j.server.server.GameServer;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Shutdown implements L1CommandExecutor {

	private L1Shutdown() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Shutdown();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			if (arg.equalsIgnoreCase("now")) {
				GameServer.getInstance().shutdown();
				return;
			}
			if (arg.equalsIgnoreCase("abort")) {
				GameServer.getInstance().abortShutdown();
				return;
			}
			int sec = Math.max(5, Integer.parseInt(arg));
			GameServer.getInstance().shutdownWithCountdown(sec);
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".shutdown sec|abort"));
		}
	}
}
