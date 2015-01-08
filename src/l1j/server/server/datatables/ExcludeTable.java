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
 * Author: ChrisLiu.2007.07.20
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
import l1j.server.server.model.L1ExcludingList;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// IdFactory
public class ExcludeTable {
	private static Logger _log = Logger.getLogger(ExcludeTable.class.getName());
	private static ExcludeTable _instance;
	private final Map<Integer, L1ExcludingList> _excludes = new HashMap<Integer, L1ExcludingList>();

	public static ExcludeTable getInstance() {
		if (_instance == null) {
			_instance = new ExcludeTable();
		}
		return _instance;
	}

	private ExcludeTable() {
		Connection con = null;
		PreparedStatement charIdPS = null;
		ResultSet charIdRS = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			charIdPS = con
					.prepareStatement("SELECT distinct(char_id) as char_id FROM character_excludes");
			charIdRS = charIdPS.executeQuery();
			while (charIdRS.next()) {
				PreparedStatement excludesPS = null;
				ResultSet excludesRS = null;
				try {
					excludesPS = con
							.prepareStatement("SELECT exclude_id, exclude_name FROM character_excludes WHERE char_id = ?");
					int charId = charIdRS.getInt("char_id");
					excludesPS.setInt(1, charId);
					L1ExcludingList exclude = new L1ExcludingList(charId);
					excludesRS = excludesPS.executeQuery();
					while (excludesRS.next()) {
						exclude.add(excludesRS.getInt("exclude_id"),
								excludesRS.getString("exclude_name"));
					}
					_excludes.put(exclude.getCharId(), exclude);
				} catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				} finally {
					SQLUtil.close(excludesRS);
					SQLUtil.close(excludesPS);
				}
			}
			_log.config("loaded " + _excludes.size() + " character's excludelists");
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(charIdRS);
			SQLUtil.close(charIdPS);
			SQLUtil.close(con);
		}
	}

	public L1ExcludingList getExcludeList(int charId) {
		L1ExcludingList exclude = _excludes.get(charId);
		if (exclude == null) {
			exclude = new L1ExcludingList(charId);
			_excludes.put(charId, exclude);
		}
		return exclude;
	}

	public void addExclude(int charId, int objId, String name) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO character_excludes SET char_id=?, exclude_id=?, exclude_name=?");
			pstm.setInt(1, charId);
			pstm.setInt(2, objId);
			pstm.setString(3, name);
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void removeExclude(int charId, String excludeName) {
		Connection con = null;
		PreparedStatement pstm = null;
		L1ExcludingList exclude = getExcludeList(charId);
		if (!exclude.containsName(excludeName)) {
			return;
		}
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM character_excludes WHERE char_id=? AND exclude_name=?");
			pstm.setInt(1, charId);
			pstm.setString(2, excludeName);
			pstm.execute();
			exclude.remove(excludeName);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}
