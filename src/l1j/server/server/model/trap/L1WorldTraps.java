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
package l1j.server.server.model.trap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.TrapTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1TrapInstance;
import l1j.server.server.types.Point;
import l1j.server.server.utils.SQLUtil;

public class L1WorldTraps {
	private static Logger _log = LoggerFactory.getLogger(L1WorldTraps.class.getName());
	private List<L1TrapInstance> _allTraps = new ArrayList<L1TrapInstance>();
	private List<L1TrapInstance> _allBases = new ArrayList<L1TrapInstance>();
	private static L1WorldTraps _instance;

	private L1WorldTraps() {
		initialize();
	}

	public static L1WorldTraps getInstance() {
		if (_instance == null) {
			_instance = new L1WorldTraps();
		}
		return _instance;
	}

	private void initialize() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM spawnlist_trap");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int trapId = rs.getInt("trapId");
				L1Trap trapTemp = TrapTable.getInstance().getTemplate(trapId);
				L1Location loc = new L1Location();
				loc.setMap(rs.getInt("mapId"));
				loc.setX(rs.getInt("locX"));
				loc.setY(rs.getInt("locY"));
				Point rndPt = new Point();
				rndPt.setX(rs.getInt("locRndX"));
				rndPt.setY(rs.getInt("locRndY"));
				int count = rs.getInt("count");
				int span = rs.getInt("span");
				for (int i = 0; i < count; i++) {
					L1TrapInstance trap = new L1TrapInstance(IdFactory
							.getInstance().nextId(), trapTemp, loc, rndPt, span);
					L1World.getInstance().addVisibleObject(trap);
					_allTraps.add(trap);
				}
				L1TrapInstance base = new L1TrapInstance(IdFactory
						.getInstance().nextId(), loc);
				L1World.getInstance().addVisibleObject(base);
				_allBases.add(base);
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static void reloadTraps() {
		TrapTable.reload();
		L1WorldTraps oldInstance = _instance;
		_instance = new L1WorldTraps();
		oldInstance.resetTimer();
		removeTraps(oldInstance._allTraps);
		removeTraps(oldInstance._allBases);
	}

	private static void removeTraps(List<L1TrapInstance> traps) {
		for (L1TrapInstance trap : traps) {
			trap.disableTrap();
			L1World.getInstance().removeVisibleObject(trap);
		}
	}

	private void resetTimer() {
		synchronized (this) {
			for (L1TrapInstance trap : _allTraps) {
				try {
					trap.get_trapFuture().cancel(true);
				} catch (Exception e) {
					_log.error("",e);
				}
				
				try {
					trap.set_trapFuture(GeneralThreadPool.getInstance().schedule(new TrapSpawnTimer(trap), trap.getSpan()));
				} catch (Exception e) {
					_log.error("",e);
				}
			}
		}
	}

	private void disableTrap(L1TrapInstance trap) {
		trap.disableTrap();
		synchronized (this) {
			trap.set_trapFuture(GeneralThreadPool.getInstance().schedule(new TrapSpawnTimer(trap), trap.getSpan()));
		}
	}

	public void resetAllTraps() {
		for (L1TrapInstance trap : _allTraps) {
			trap.resetLocation();
			trap.enableTrap();
		}
	}

	public void onPlayerMoved(L1PcInstance player) {
		L1Location loc = player.getLocation();
		for (L1TrapInstance trap : _allTraps) {
			if (trap.isEnable() && loc.equals(trap.getLocation())) {
				if (!player.isGmInvis()) {
					trap.onTrod(player);
					disableTrap(trap);
				}
			}
		}
	}

	public void onDetection(L1PcInstance caster) {
		L1Location loc = caster.getLocation();
		for (L1TrapInstance trap : _allTraps) {
			if (trap.isEnable() && loc.isInScreen(trap.getLocation())) {
				trap.onDetection(caster);
				disableTrap(trap);
			}
		}
	}

	private class TrapSpawnTimer implements Runnable {
		private final L1TrapInstance _targetTrap;
		private String originalThreadName;

		public TrapSpawnTimer(L1TrapInstance trap) {
			_targetTrap = trap;
		}

		@Override
		public void run() {
			try {
				originalThreadName = Thread.currentThread().getName();
				Thread.currentThread().setName("L1WorldTrap");
				_targetTrap.resetLocation();
				_targetTrap.enableTrap();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("",e);
			} finally {
				Thread.currentThread().setName(originalThreadName);
			}
		}
	}
}