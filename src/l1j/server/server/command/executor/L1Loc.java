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

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.map.L1WorldMap;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Loc implements L1CommandExecutor {
	private static Logger _log = LoggerFactory.getLogger(L1Loc.class.getName());

	private L1Loc() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Loc();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			int locx = pc.getX();
			int locy = pc.getY();
			short mapid = pc.getMapId();
			int gab = L1WorldMap.getInstance().getMap(mapid)
					.getOriginalTile(locx, locy);
			String msg = String.format("Loc: (%d, %d, %d) %d", locx, locy,
					mapid, gab);
			pc.sendPackets(new S_SystemMessage(msg));
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}
}
