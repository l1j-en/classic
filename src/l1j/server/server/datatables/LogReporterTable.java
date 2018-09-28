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
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class LogReporterTable {
	private static Logger _log = LoggerFactory.getLogger(LogReporterTable.class.getName());

	public static int storeLogReport(int reporter_id, String reporter_account, String reporter_ip, 
			int target_id, String target_name, String reason) {
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet keys = null;
		int insertedId = -1;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO log_report SET reporter_id=?, reporter_account=?, reporter_ip=?, target_id=?, target_name=?, timestamp=?, reason=?",
							Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, reporter_id);
			pstm.setString(2, reporter_account);
			pstm.setString(3, reporter_ip);
			pstm.setInt(4, target_id);
			pstm.setString(5, target_name);
			pstm.setLong(6, System.currentTimeMillis());
			pstm.setString(7, reason);
			pstm.execute();
			
			keys = pstm.getGeneratedKeys();
			keys.next();
			insertedId = keys.getInt(1);
			keys.close();
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(keys);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
		return insertedId;
	}
	
	public static void updatePacketStartTimestamp(int id, long firstPacketTimestamp) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE log_report SET first_packet_of_log=? WHERE id=?");
			
			pstm.setLong(1, firstPacketTimestamp);
			pstm.setInt(2, id);
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	public static long getLastSuspicion(int objid) {
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM log_report WHERE target_id=? ORDER BY id DESC");
			pstm.setInt(1, objid);
			
			rs = pstm.executeQuery();
			if (!rs.next()) {
				return 0;
			}
			
			return rs.getLong("timestamp");

		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
			return 0;
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	public static long getLastReport(L1PcInstance player) {
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM log_report WHERE reporter_account=? OR reporter_ip = ? ORDER BY id DESC");
			pstm.setString(1, player.getAccountName());
			pstm.setString(2, player.getNetConnection().getIp());
			
			rs = pstm.executeQuery();
			if (!rs.next()) {
				return 0;
			}
			
			return rs.getLong("timestamp");

		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
			return 0;
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}
