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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Reload implements L1CommandExecutor {
	private static Logger _log = LoggerFactory.getLogger(L1Reload.class.getName());

	private L1Reload() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Reload();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		long wait = pc.getReloadTime();
		if (wait != 0)
			wait -= System.currentTimeMillis();
		if (!pc.isGm() && wait > 0) {
			pc.sendPackets(new S_SystemMessage("You cannot .reload for another "
					+ (double)Math.round((double)wait / 100.0) / 10.0 + " seconds"));
		} else {
			try {
				L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc.getMapId(), 5,
						false);
				pc.sendPackets(new S_SystemMessage("Your screen has been refreshed"));
				pc.resetReloadTime();
			} catch (Exception e) {
				_log.error(e.getLocalizedMessage(), e);
			}
		}
	}
}
