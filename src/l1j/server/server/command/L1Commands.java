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
package l1j.server.server.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.templates.L1Command;
import l1j.server.server.utils.SQLUtil;

public class L1Commands {
	private static Logger _log = LoggerFactory.getLogger(L1Commands.class.getName());

	private static L1Command fromResultSet(ResultSet rs) throws SQLException {
		String helpText = "";
		boolean runOnLogin = false;
		
		if(hasColumn(rs, "help_text"))
			helpText = rs.getString("help_text");
		
		if(hasColumn(rs, "run_on_login"))
			runOnLogin = rs.getBoolean("run_on_login");
		
		return new L1Command(rs.getString("name"), rs.getInt("access_level"),
				rs.getString("class_name"), helpText, runOnLogin);
	}

	public static L1Command get(String name) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM commands WHERE name=?");
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				return null;
			}
			return fromResultSet(rs);
		} catch (SQLException e) {
			_log.error("Commands", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return null;
	}

	public static List<L1Command> availableCommandList(int accessLevel) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<L1Command> result = new ArrayList<L1Command>();

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM commands WHERE access_level <= ? ORDER BY name");
			pstm.setInt(1, accessLevel);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(fromResultSet(rs));
			}
		} catch (SQLException e) {
			_log.error("Commands", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return result;
	}
	
	public static boolean hasColumn(ResultSet rs, String columnName) {
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
		    int columns = rsmd.getColumnCount();
		    for (int x = 1; x <= columns; x++) {
		        if (columnName.equals(rsmd.getColumnName(x)) && rs.getString(x) != null) {
		            return true;
		        }
		    }
		    return false;
		} catch(Exception ex) {
			return false;
		}
	}
}