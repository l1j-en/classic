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
package l1j.server.server.datatables;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.trap.L1Trap;
import l1j.server.server.storage.TrapStorage;
import l1j.server.server.utils.SQLUtil;

public class TrapTable {
	private static Logger _log = Logger.getLogger(TrapTable.class.getName());

	private static TrapTable _instance;

	private Map<Integer, L1Trap> _traps = new HashMap<Integer, L1Trap>();

	private TrapTable() {
		initialize();
	}

	private L1Trap createTrapInstance(String name, TrapStorage storage)
			throws Exception {
		final String packageName = "l1j.server.server.model.trap.";

		Constructor con = Class.forName(packageName + name).getConstructor(
				new Class[] { TrapStorage.class });
		return (L1Trap) con.newInstance(storage);
	}

	private void initialize() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();

			pstm = con.prepareStatement("SELECT * FROM trap");

			rs = pstm.executeQuery();

			while (rs.next()) {
				String typeName = rs.getString("type");

				L1Trap trap = createTrapInstance(typeName, new SqlTrapStorage(
						rs));

				_traps.put(trap.getId(), trap);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static TrapTable getInstance() {
		if (_instance == null) {
			_instance = new TrapTable();
		}
		return _instance;
	}

	public static void reload() {
		TrapTable oldInstance = _instance;
		_instance = new TrapTable();

		oldInstance._traps.clear();
	}

	public L1Trap getTemplate(int id) {
		return _traps.get(id);
	}

	private class SqlTrapStorage implements TrapStorage {
		private final ResultSet _rs;

		public SqlTrapStorage(ResultSet rs) {
			_rs = rs;
		}

		@Override
		public String getString(String name) {
			try {
				return _rs.getString(name);
			} catch (SQLException e) {
			}
			return "";
		}

		@Override
		public int getInt(String name) {
			try {
				return _rs.getInt(name);
			} catch (SQLException e) {

			}
			return 0;
		}

		@Override
		public boolean getBoolean(String name) {
			try {
				return _rs.getBoolean(name);
			} catch (SQLException e) {
			}
			return false;
		}
	}
}
