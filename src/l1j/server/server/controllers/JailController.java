package l1j.server.server.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.SQLUtil;

public class JailController implements Runnable {
	public class JailInfo {
		private Long _releaseTime;
		private String _message;
		private String _jailer;
		
		public JailInfo(String jailer, String message, Long releaseTime) {
			this._jailer = jailer;
			this._message = message;
			this._releaseTime = releaseTime;
		}
		
		public Long getReleaseTime() {
			return this._releaseTime;
		}
		
		public String getReleaseTimeFormatted() {
			Long diffMinutes = ((this._releaseTime / 1000) - (System.currentTimeMillis() / 1000)) / 60;
			
			int minutesInDay = 60 * 24;
					
			
			int days = (int)(diffMinutes / minutesInDay);
			
			if(days > 0) {
				diffMinutes -= days * minutesInDay;
			} else {
				days = 0;
			}
			
			int hours = (int)(diffMinutes / 60);
			
			if(hours > 0) {
				diffMinutes -= hours * 60;
			} else {
				hours = 0;
			}
			
			int minutes = ((Long)diffMinutes).intValue();
			
			String dayString = days == 1 ? "day" : "days";
			String hourString = hours == 1 ? "hour" : "hours";
			String minuteString = minutes == 1 ? "minute" : "minutes";
			
			return String.format("%d %s, %d %s, %d %s.", days, dayString,
					hours, hourString, minutes, minuteString);
		}
		
		public String getMessage() {
			return this._message;
		}
		
		public String getJailer() {
			return this._jailer;
		}
	}
	
	private static Logger _log = Logger.getLogger(RankingsController.class.getName());
	
	private static JailController _instance;
	private HashMap<String, JailInfo> _jailedUsers = new HashMap<String, JailInfo>();
	private static int[] _unjailLocation = { 33080, 33392, 4 };
	
	private JailController() {
		getJailedUsers(0L);
	}
	
	public static JailController getInstance() {
		if(_instance == null)
			_instance = new JailController();
		
		return _instance;
	}
	
	public JailInfo getJailInfo(String user) {
		return this._jailedUsers.get(user);
	}
	
	
	private void getJailedUsers(Long lastCheck) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM `log_jail` WHERE `status` = 'jailed' AND `modified` >= ?");
			pstm.setLong(1, System.currentTimeMillis());
			
			rs = pstm.executeQuery();
			
			while (rs.next()){
				String username = rs.getString("jailed_char_name");
				// will update if it exists, otherwise will insert it
				this._jailedUsers.put(username, 
						new JailInfo(rs.getString("jailer"), rs.getString("message"), rs.getTimestamp("unjail").getTime()));
			}
		} catch(Exception ex) {
			_log.log(Level.WARNING, "Failed to get jailed users. No users can be unjailed automatically!", ex);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	private void setUnjailStatus(String user) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE `log_jail` SET `status` = ?, modified = NOW() WHERE jailed_char_name = ?");
			pstm.setString(1, "unjailed");
			pstm.setString(2, user);
			
			pstm.execute();
		} catch (Exception ex) {
			_log.log(Level.WARNING, "Failed to update the status of the unjailed user: " + user, ex);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("JailController");
		
		try {
			Long checkTime = System.currentTimeMillis();
			
			while(true) {
				this.getJailedUsers(checkTime);
				
				Iterator<Map.Entry<String,JailInfo>> iter = this._jailedUsers.entrySet().iterator();
				
				while (iter.hasNext()) {
				    Map.Entry<String,JailInfo> entry = iter.next();
				    String user = entry.getKey();
				    Long jailReleaseTime = entry.getValue().getReleaseTime();
				    
				    if(jailReleaseTime <= checkTime) {
				    	L1PcInstance player = L1World.getInstance().getPlayer(user);
				    	
				    	if(player != null) {
				    		// SKT
				    		// only send them to SKT if they haven't already been unjailed
				    		if(player.getMapId() == 99) {
				    			L1Teleport.teleport(player, _unjailLocation[0], _unjailLocation[1],
					    				(short)_unjailLocation[2], 1, false);
					    		player.sendPackets(new S_SystemMessage("You have been unjailed! Behave yourself!"));
				    		}
				    	} else {
				    		player = CharacterTable.getInstance().restoreCharacter(user);
							
							if(player == null) 
								continue;
							
							// SKT
				    		// only send them to SKT if they haven't already been unjailed
							if(player.getMapId() == 99) {
								CharacterTable.getInstance().moveCharacter(player,  _unjailLocation[0], _unjailLocation[1],
					    				(short)_unjailLocation[2]);
							}
				    	}
				    	
				    	this.setUnjailStatus(user);
				    	iter.remove();
				    }
			        
				}
				
				checkTime = System.currentTimeMillis();
				_log.log(Level.FINE, "Unjail controller finished running.");
				Thread.sleep(60000);
			}
		} catch(Exception ex) {
			_log.log(Level.WARNING, "Unjail controller crashed! No users will be auto-unjailed!");
		}
	}
}
