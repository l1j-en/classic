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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

public final class CheckWarTime {
	public int _castle_id = 0;
	public String _name = "";
	private static Logger _log = Logger.getLogger(CheckWarTime.class.getName());
	private static CheckWarTime _instance;
	private final Map<Integer, Data> _check = new HashMap<Integer, Data>();

	private class Data {
		public boolean _isActive = true;
	}

	private CheckWarTime() {
		loadCheckWarTimeFromDatabase();
	}

	private void loadCheckWarTimeFromDatabase() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM checkwartime");
			rs = pstm.executeQuery();
			while (rs.next()) {
				Data data = new Data();
				int id = rs.getInt("castle_id");
				_castle_id = id;
				_name = rs.getString("name");
				data._isActive = rs.getBoolean("isActive");
				_check.put(new Integer(id), data);
			}
			_log.config("CheckWarTime " + _check.size());
		} catch (SQLException e) {
			e.printStackTrace();
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static CheckWarTime getInstance() {
		if (_instance == null) {
			_instance = new CheckWarTime();
		}
		return _instance;
	}

	public boolean isActive(int castleId) {
		Data data = _check.get(castleId);
		if (data == null) {
			return true;
		}
		return _check.get(castleId)._isActive;
	}
}