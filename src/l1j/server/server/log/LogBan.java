package l1j.server.server.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

public class LogBan {
	private static Logger _log = LoggerFactory.getLogger(LogBan.class
			.getName());

	public static void logBan(String action, String actionedAccount, String actionerAccount, String message) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "INSERT INTO log_ban (action, target_account, actioner_account, message, timestamp)" + 
					" VALUES(?, ?, ?, ?, ?)";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, action);
			pstm.setString(2, actionedAccount);
			pstm.setString(3, actionerAccount);
			pstm.setString(4, message);
			pstm.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}
