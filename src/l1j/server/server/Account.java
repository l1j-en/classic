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
package l1j.server.server;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.AccessLevelTable;
import l1j.server.server.encryptions.Base64;
import l1j.server.server.log.LogBan;
import l1j.server.server.model.BanInfo;
import l1j.server.server.utils.SQLUtil;

public class Account {
	private String _name;
	private String _ip;
	private String _password;
	private Timestamp _lastActive;
	private int _accessLevel;
	private String _host;
	private boolean _banned;
	private int _characterSlot;
	private boolean _isValid = false;
	private boolean _restrictIps = false;
	private static Logger _log = LoggerFactory.getLogger(Account.class);

	private Account() {
	}

	private static String encodePassword(final String rawPassword)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] buf = rawPassword.getBytes("UTF-8");
		buf = MessageDigest.getInstance("SHA").digest(buf);
		return Base64.encodeBytes(buf);
	}

	public static Account create(final String name, final String rawPassword,
			final String ip, final String host) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			Account account = new Account();
			account._name = name;
			account._password = makeSHA256(Config.PASSWORD_SALT + rawPassword
					+ makeMD5(name)); // Ssargon change
			account._ip = ip;
			account._host = host;
			account._banned = false;
			account._lastActive = new Timestamp(System.currentTimeMillis());
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "INSERT INTO accounts SET login=?,password=?,lastactive=?,access_level=?,ip=?,host=?,banned=?,character_slot=?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, account._name);
			pstm.setString(2, account._password);
			pstm.setTimestamp(3, account._lastActive);
			pstm.setInt(4, AccessLevelTable.minAccessLevel.getId());
			pstm.setString(5, account._ip);
			pstm.setString(6, account._host);
			pstm.setInt(7, account._banned ? 1 : 0);
			pstm.setInt(8, 0);
			pstm.execute();
			_log.info("New account created for: " + name);
			return account;
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			_log.error(e.getLocalizedMessage(), e);
		} catch (UnsupportedEncodingException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return null;
	}

	public static Account load(final String name) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Account account = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "SELECT * FROM accounts WHERE login=? LIMIT 1";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				return null;
			}
			account = new Account();
			account._name = rs.getString("login");
			account._password = rs.getString("password");
			account._lastActive = rs.getTimestamp("lastactive");
			account._accessLevel = rs.getInt("access_level");
			account._ip = rs.getString("ip");
			account._host = rs.getString("host");
			account._banned = rs.getInt("banned") == 0 ? false : true;
			account._characterSlot = rs.getInt("character_slot");
			account._restrictIps = rs.getBoolean("restrict_ip");
			_log.info("Account already exists.");
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return account;
	}

	public static void updateLastActive(final Account account) {
		Connection con = null;
		PreparedStatement pstm = null;
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "UPDATE accounts SET lastactive=? WHERE login = ?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setTimestamp(1, ts);
			pstm.setString(2, account.getName());
			pstm.execute();
			account._lastActive = ts;
			_log.info("Update lastactive for: " + account.getName());
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static void updateCharacterSlot(final Account account) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "UPDATE accounts SET character_slot=? WHERE login=?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setInt(1, account.getCharacterSlot());
			pstm.setString(2, account.getName());
			pstm.execute();
			account._characterSlot = account.getCharacterSlot();
			_log.info("Update CharacterSlot for: " + account.getName());
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	public static void setIpRestrictionOnAccount(final Account account, final boolean enabled) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "UPDATE accounts SET restrict_ip=? WHERE login = ?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setBoolean(1, enabled);
			pstm.setString(2, account.getName());
			pstm.execute();
			account._restrictIps = enabled;
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	public static boolean addIpRestriction(final String account, final String ip) {
		//Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try (Connection con = L1DatabaseFactory.getInstance().getConnection()){
			//con = L1DatabaseFactory.getInstance().getConnection();
			
			String sqlstr = "SELECT * FROM ip_restrictions WHERE account=? and ip=? AND deleted is NULL LIMIT 1";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, account);
			pstm.setString(2, ip);
			
			rs = pstm.executeQuery();
			if (rs.next()) {
				return false;
			}
			
			sqlstr = "INSERT INTO ip_restrictions (account, ip) VALUES(?,?)";
			pstm.close();
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, account);
			pstm.setString(2, ip);
			pstm.execute();
			_log.info("New IP restriction created for: " + account + ", with IP: " + ip);
			return true;
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
			return false;
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			//SQLUtil.close(con);
		}
	}
	
	public static void deleteIpRestriction(final String account, final String ip) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE `ip_restrictions` SET `deleted` = NOW() WHERE `account`=? AND `ip`=?");
			pstm.setString(1, account);
			pstm.setString(2, ip);
			pstm.execute();
			_log.info("IP restriction deleted for: " + account + ", with IP: " + ip);
			
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	public static void enableIpRestriction(final String account, final boolean enable) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE `accounts` SET `restrict_ip` = ? WHERE login=?");
			pstm.setBoolean(1, enable);
			pstm.setString(2, account);
			pstm.execute();
			_log.info("IP restriction set to: " + enable + " for: " + account);
			
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public int countCharacters() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "SELECT count(*) as cnt FROM characters WHERE account_name=?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, _name);
			rs = pstm.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return result;
	}
	
	public ArrayList<BanInfo> getBanHistory() {
		ArrayList<BanInfo> banHistory = new ArrayList<BanInfo>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "SELECT * FROM log_ban WHERE target_account=? ORDER BY timestamp DESC";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, _name);
			rs = pstm.executeQuery();
			while (rs.next()) {
				banHistory.add(new BanInfo(
						rs.getString("action"), 
						rs.getString("target_account"), 
						rs.getString("actioner_account"), 
						rs.getString("message"), 
						rs.getTimestamp("timestamp")
						));
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
		return banHistory;
	}
	
	public ArrayList<String> getCharacters() {
		ArrayList<String> characters = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "SELECT char_name FROM characters WHERE account_name=?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, _name);
			rs = pstm.executeQuery();
			while (rs.next()) {
				characters.add(rs.getString("char_name"));
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
		return characters;
	}
	
	public static void ban(final String login, final String bannerAccount, final String banMessage) {
		setBanStatus(login, true);
		LogBan.logBan("ban", login, bannerAccount, banMessage);
	}
	
	public static void unban(final String login, final String unbannerAccount, final String unbanMessage) {
		setBanStatus(login, false);
		LogBan.logBan("unban", login, unbannerAccount, unbanMessage);
	}

	private static void setBanStatus(final String login, boolean isBanned) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "UPDATE accounts SET banned=? WHERE login=?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setBoolean(1, isBanned);
			pstm.setString(2, login);
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	/* Convert from Byte[] to String */
	private static String convertToString(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	/* Make SHA256 of input String */
	public static String makeSHA256(String text)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-256");
		byte[] sha256hash = new byte[32];
		md.update(text.getBytes("UTF-8"), 0, text.length());
		sha256hash = md.digest();
		return convertToString(sha256hash);
	}

	/* Make MD5 of input String */
	public static String makeMD5(String text) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		MessageDigest md;
		md = MessageDigest.getInstance("MD5");
		byte[] md5hash = new byte[32];
		md.update(text.getBytes("UTF-8"), 0, text.length());
		md5hash = md.digest();
		return convertToString(md5hash);
	}

	/* Change password for account to input String password */
	public void change_password(String pass) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE accounts SET password=? WHERE login=?");
			pstm.setString(1, pass);
			pstm.setString(2, _name);
			pstm.execute();
			_log.info("Rehashed password for " + _name + ".");
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	/* Ssargon change end */
	/**
	 * 
	 * 
	 * @param rawPassword
	 * 
	 * @return boolean
	 */
	public boolean validatePassword(final String rawPassword) {

		if (_isValid) {
			return false;
		}
		try {
			_isValid = _password.equals(makeSHA256(Config.PASSWORD_SALT
					+ rawPassword + makeMD5(_name)));// Ssargon change
			if (_isValid) {
				_password = null;
			} else { // If password does not match
				_isValid = _password.equals(encodePassword(rawPassword));
				if (_isValid) { // If its old scheme password
					change_password(makeSHA256(Config.PASSWORD_SALT
							+ rawPassword + makeMD5(_name))); // Make new style
																// password
				}
			}
			return _isValid;
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
		return false;
	}
	
	public boolean validateIp(final String ip) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "SELECT * FROM ip_restrictions WHERE account=? AND ip=? AND deleted is NULL";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, _name);
			pstm.setString(2,  ip);
			rs = pstm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
		return false;
	}

	public boolean isValid() {
		return _isValid;
	}
	
	public boolean isIpRestricted() {
		return _restrictIps;
	}

	public boolean isGameMaster() {
		return 0 < _accessLevel;
	}

	public String getName() {
		return _name;
	}

	public String getIp() {
		return _ip;
	}

	public Timestamp getLastActive() {
		return _lastActive;
	}

	public int getAccessLevel() {
		return _accessLevel;
	}

	public String getHost() {
		return _host;
	}

	public boolean isBanned() {
		return _banned;
	}

	public int getCharacterSlot() {
		return _characterSlot;
	}

	public void setCharacterSlot(int i) {
		_characterSlot = i;
	}
}