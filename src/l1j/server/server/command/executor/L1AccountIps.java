package l1j.server.server.command.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CustomBoardRead;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1AccountIps implements L1CommandExecutor {
	public L1AccountIps() { }
	
	public static L1CommandExecutor getInstance() {
		return new L1AccountIps();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String accountName) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {			
			accountName = accountName.trim();
			
			if(accountName.equals(""))
				throw new Exception();
			
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT a.LoginTime, a.Ip, a.Account, " + 
							"(SELECT Count(*) FROM ban_ip WHERE ip = a.Ip) > 0 As Banned FROM `logip` a " + 
							"LEFT JOIN `logip` b ON a.Ip = b.Ip AND a.Account = b.Account AND " + 
							"a.LoginTime < b.LoginTime WHERE b.LoginTime is NULL AND a.Account = ? " + 
							"ORDER BY a.LoginTime DESC;");
			
			pstm.setString(1, accountName);
			
			rs = pstm.executeQuery();
			
			String message = "";
			while (rs.next()) {
				boolean banned = rs.getBoolean("Banned");
				
				accountName = rs.getString("Account");
				message += rs.getString("Ip") + (banned ? " [Banned]" : "") + 
						"\n" + rs.getString("LoginTime") + "\n\n";
			}
			
			if(message.equals("")) {
				pc.sendPackets(new S_SystemMessage("Account '" + accountName + "' not found."));
				return;
			}
			
			pc.sendPackets(new S_CustomBoardRead("Account: " + accountName, pc.getName(), message));
		} catch (Exception ex) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <account_name>"));
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
}
