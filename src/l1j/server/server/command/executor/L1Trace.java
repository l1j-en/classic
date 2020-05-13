package l1j.server.server.command.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CustomBoardRead;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Trace implements L1CommandExecutor {

	private static Logger _log = LoggerFactory.getLogger(L1Trace.class);

	private static final Pattern PATTERN = Pattern
			.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	public L1Trace() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Trace();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String ipAddress) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			ipAddress = ipAddress.trim();

			if (!validate(ipAddress)) {
				pc.sendPackets(new S_SystemMessage("Invalid IP address entered."));
				return;
			}

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT a.LoginTime, a.Ip, a.Account, "
					+ "(SELECT Count(*) FROM ban_ip WHERE ip = a.Ip) > 0 As Banned FROM `logip` a "
					+ "LEFT JOIN `logip` b ON a.Ip = b.Ip AND a.Account = b.Account AND "
					+ "a.LoginTime < b.LoginTime WHERE b.LoginTime is NULL AND a.Ip = ? "
					+ "ORDER BY a.LoginTime DESC;");

			pstm.setString(1, ipAddress);
			rs = pstm.executeQuery();

			String message = "";
			while (rs.next()) {
				boolean banned = rs.getInt("Banned") == 1;

				message += rs.getString("Account") + (banned ? " [Banned]" : "") + ":\n\t\t" + rs.getString("LoginTime")
						+ "\n";
			}

			if (message.equals("")) {
				pc.sendPackets(new S_SystemMessage("No accounts associated with IP '" + ipAddress + "'."));
				return;
			}

			message = "  * You may have to scroll *\n\n" + message;
			pc.sendPackets(new S_CustomBoardRead(ipAddress, pc.getName(), message));

		} catch (Exception e) {
			_log.error("", e);
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <ip_address>"));
		} finally {
			try {
				if (con != null && !con.isClosed())
					con.close();

				if (pstm != null && !pstm.isClosed())
					pstm.close();

				if (rs != null && !rs.isClosed())
					rs.close();
			} catch (Exception ex2) {
			}
		}
	}

	public static boolean validate(final String ip) {
		return PATTERN.matcher(ip).matches();
	}
}
