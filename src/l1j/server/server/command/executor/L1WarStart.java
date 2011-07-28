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

import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Castle;

public class L1WarStart implements L1CommandExecutor {
	private static Logger _log = Logger.getLogger(L1WarStart.class.getName());

	private L1WarStart() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1WarStart();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer st = new StringTokenizer(arg);
			int time = Integer.parseInt(st.nextToken());
			int castle = Integer.parseInt(st.nextToken());

			L1Castle _l1castle = WarTimeController.getCastle(castle);
			L1World.getInstance().broadcastPacketToAll(new S_SystemMessage(time + " siege " + _l1castle.getName() + " will start !"));
			Calendar nowTime = WarTimeController.getRealTime();
			nowTime.add(Calendar.MINUTE, time);
			_l1castle.setWarTime(nowTime);
			CastleTable.getInstance().updateCastle(_l1castle);
			WarTimeController.setWarStartTime(castle, nowTime);
			nowTime = WarTimeController.getRealTime();
			nowTime.add(Config.ALT_WAR_TIME_UNIT, Config.ALT_WAR_TIME);
			WarTimeController.setWarEndTime(castle, nowTime);
		} catch (Exception exception) {
			pc.sendPackets(new S_SystemMessage(cmdName + " .war starttime + id 1 = kent 2 = orcfortress 3 = windawood 4 = giran 5 = heine " +
					"6 = dwarfcastle 7 = aden 8 = diad "));
			_log.log(Level.SEVERE, exception.getLocalizedMessage(), exception);
		}
	}
}
