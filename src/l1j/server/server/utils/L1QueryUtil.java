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
package l1j.server.server.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.collections.Lists;

public class L1QueryUtil {
	public interface EntityFactory<T> {
		public T fromResultSet(ResultSet rs) throws SQLException;
	}

	private static void setupPrepareStatement(PreparedStatement pstm,
			Object[] args) throws SQLException {
		for (int i = 0; i < args.length; i++) {
			pstm.setObject(i + 1, args[i]);
		}
	}

	public static <T> T selectFirst(EntityFactory<T> factory, 
			String sql, Object... args) {
		List<T> result = selectAll(factory, sql, args);
		return result.isEmpty() ? null : result.get(0);
	}

	public static <T> List<T> selectAll(EntityFactory<T> factory, 
			String sql, Object... args) {
		List<T> result = Lists.newArrayList();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement(sql);
			setupPrepareStatement(pstm, args);
			rs = pstm.executeQuery();
			while (rs.next()) {
				T entity = factory.fromResultSet(rs);
				if (entity == null) {
					throw new NullPointerException(factory.getClass()
							.getSimpleName()
							+ " returned null.");
				}
				result.add(entity);
			}
		} catch (SQLException e) {
			throw new L1SQLException(e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return result;
	}

	public static boolean execute(Connection con, 
			String sql, Object... args) {
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			setupPrepareStatement(pstm, args);
			return pstm.execute();
		} catch (SQLException e) {
			throw new L1SQLException(e);
		} finally {
			SQLUtil.close(pstm);
		}
	}

	public static boolean execute(String sql, Object... args) {
		Connection con = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			return execute(con, sql, args);
		} catch (SQLException e) {
			throw new L1SQLException(e);
		} finally {
			SQLUtil.close(con);
		}
	}
}