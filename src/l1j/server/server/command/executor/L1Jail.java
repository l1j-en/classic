package l1j.server.server.command.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.controllers.RankingsController;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.SQLUtil;

public class L1Jail implements L1CommandExecutor {
	private static Logger _log = Logger.getLogger(RankingsController.class.getName());
	
	private L1Jail() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Jail();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			String[] args = arg.split(" ");
			
			if(args.length < 4)
				throw new Exception();
			
			String player = args[0];
			String durationType = args[1].toLowerCase();
			int duration = Integer.parseInt(args[2]);
			String message = "";
			
			for(int i = 3; i < args.length; i++) {
				message += args[i] + " ";
			}
			
			message = message.trim();
			
			L1PcInstance convict = L1World.getInstance().getPlayer(player);
			
			Calendar cal = Calendar.getInstance(); 
		    cal.setTime(new Date()); 
		    
			if(durationType.equals("hours")) {
				cal.add(Calendar.HOUR_OF_DAY, duration); 
			} else if(durationType.equals("days")) {
				cal.add(Calendar.DAY_OF_YEAR, duration); 
			} else {
				throw new Exception();
			}

			if (convict != null) {
				L1Teleport.teleport(convict, 32737, 32796, (short) 99, 5, true);
				convict.sendPackets(new S_SystemMessage(
						String.format("%s jailed you for %d %s.",
								pc.getName(),
								duration,
								durationType)));
				convict.sendPackets(new S_SystemMessage("Reason: " + message));
			} else {
				convict = CharacterTable.getInstance().restoreCharacter(player);
				
				if(convict == null) {
					pc.sendPackets(new S_SystemMessage("A character with the name '" + player + "' does not exist."));
					return;
				}
				
				CharacterTable.getInstance().moveCharacter(convict, 32737, 32796, (short) 99);
			}
			
			pc.sendPackets(new S_SystemMessage(String.format("%s has been jailed for %d %s.",
					convict.getName(), duration, durationType)));			
			logJail(convict.getName(), pc.getName(), message, cal.getTimeInMillis());
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <player_name> [hours|days] <number> <reason>"));
		}
	}
	
	private static int getExistingJailId(String user) {
		int existingId = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM `log_jail` WHERE `status` = 'jailed' AND `jailed_char_name` = ?");
			pstm.setString(1, user);
			
			rs = pstm.executeQuery();
			
			if(rs.next()){
				existingId = rs.getInt("id");
			}
		} catch(Exception ex) {
			_log.log(Level.WARNING, 
					"Failed to look up existing user ban. Could lead to duplicate entries in the log_jail table!", ex);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
		return existingId;
	}
	
	private static void logJail(String user, String jailer, String message, Long releaseTime) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int existingJailId = getExistingJailId(user);
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			
			if(existingJailId == -1) {
				pstm = con.prepareStatement("INSERT INTO `log_jail` " + 
						"(`jailed_char_name`, `jailer`, `message`, `unjail`, `status`, `modified`) VALUES(?,?,?,?,?,NOW())");
				pstm.setString(1, user);
				pstm.setString(2, jailer);
				pstm.setString(3, message);
				pstm.setTimestamp(4, new Timestamp(releaseTime));
				pstm.setString(5, "jailed");
			} else {
				pstm = con.prepareStatement("UPDATE `log_jail` SET `jailer` = ?, message = ?, unjail = ?, modified = NOW()");
				pstm.setString(1, jailer);
				pstm.setString(2, message);
				pstm.setTimestamp(3, new Timestamp(releaseTime));
			}
			
			pstm.execute();
		} catch (Exception ex) {
			_log.log(Level.WARNING, "Failed to add jail log for user: " + user, ex);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
	}
}
