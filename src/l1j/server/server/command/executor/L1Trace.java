package l1j.server.server.command.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CustomBoardRead;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Trace implements L1CommandExecutor {
	private static final Pattern PATTERN = Pattern.compile(
	        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	
	public L1Trace() { }
	
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
			
			if(!validate(ipAddress)) {
				pc.sendPackets(new S_SystemMessage("Invalid IP address entered."));
				return;
			}
			
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT a.Account, a.LoginTime, c.Banned FROM LogIP as a " +
							" JOIN accounts as c on a.account = c.login " +
							"WHERE a.LoginTime > DATE(NOW()-INTERVAL 1 YEAR) AND " + 
							"CONCAT(a.Ip, a.Account, a.LoginTime) = " + 
							"(SELECT CONCAT(b.Ip, b.Account, b.LoginTime) FROM LogIP as b " +
							"WHERE b.Account = a.Account and b.Ip = a.Ip " + 
							"ORDER BY LoginTime DESC LIMIT 1) AND a.Ip = ? " + 
							"ORDER BY a.LoginTime DESC;");
			
			pstm.setString(1, ipAddress);
			rs = pstm.executeQuery();
			
			String message = "";
			for(int i = 0; i < 8 && rs.next(); i++) {
				boolean banned = rs.getInt("Banned") == 1;
				
				message += rs.getString("Account") + (banned ? " [Banned]" : "") +
						":\n\t\t" + rs.getString("LoginTime") + "\n";
			}
			
			if(message.equals("")) {
				pc.sendPackets(new S_SystemMessage("No accounts associated with IP '" + ipAddress + "'."));
				return;
			}
			
			message = "* Only 8 accts can be shown *\n\n" + message;
			pc.sendPackets(new S_CustomBoardRead(ipAddress, pc.getName(), message));
			
		} catch (Exception ex) {
			ex.printStackTrace();
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <ip_address>"));
		} finally {
			try {
				if(con != null && !con.isClosed())
					con.close();
				
				if(pstm != null && !pstm.isClosed())
					pstm.close();
				
				if(rs != null && !rs.isClosed())
					rs.close();
			} catch(Exception ex2) { }
		}
	}
	
	public static boolean validate(final String ip) {
	    return PATTERN.matcher(ip).matches();
	}
}
