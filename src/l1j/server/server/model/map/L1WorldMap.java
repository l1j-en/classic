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
package l1j.server.server.model.map;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.utils.PerformanceTimer;

public class L1WorldMap {
	private static Logger _log = Logger.getLogger(L1WorldMap.class.getName());

	private static L1WorldMap _instance;
	private Map<Integer, L1Map> _maps;

	public static L1WorldMap getInstance() {
		if (_instance == null) {
			_instance = new L1WorldMap();
		}
		return _instance;
	}

	private L1WorldMap() {
		PerformanceTimer timer = new PerformanceTimer();
		_log.config("Loading Map...");
		MapReader in = MapReader.getDefaultReader();
		try {
			_maps = in.read();
			if (_maps == null) {
				throw new RuntimeException("Failure to read the maps");
			}
		} catch (Exception e) {
			// No return
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			System.exit(0);
		}
		_log.config("            OK!     " + timer.elapsedTimeMillis() + "ms");
	}

	/**
	 * The map information to hold L1Map returns.
	 */
	public L1Map getMap(short mapId) {
		L1Map map = _maps.get((int) mapId);
		if (map == null) {
			map = L1Map.newNull();
		}
		return map;
	}
}