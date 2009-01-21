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
import java.util.logging.Level;
import java.util.logging.Logger;
import l1j.server.Base64;
import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

/**
 *
 */
public class Account {
	private String _name;

	private String _ip;

	private String _password;

	private Timestamp _lastActive;

	private int _accessLevel;

	private String _host;

	private boolean _banned;

	private boolean _isValid = false;
	
	private static Logger _log = Logger.getLogger(Account.class.getName());

	/**
	 *
	 */
	private Account() {
	}

	/**
	 *
	 *
	 * @param rawPassword
	 *
	 * @return String
	 * @throws NoSuchAlgorithmException
	 *
	 * @throws UnsupportedEncodingException
	 *
	 */
	private static String encodePassword(final String rawPassword)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] buf = rawPassword.getBytes("UTF-8");
		buf = MessageDigest.getInstance("SHA").digest(buf);

		return Base64.encodeBytes(buf);
	}

	/**
	 *
	 *
	 * @param name
	 *
	 * @param rawPassword
	 *
	 * @param ip
	 *
	 * @param host
	 *
	 * @return Account
	 */
	public static Account create(final String name, final String rawPassword,
			final String ip, final String host) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			Account account = new Account();
			account._name = name;
			account._password=makeSHA256(Config.PASSWORD_SALT+rawPassword+makeMD5(name)); //Ssargon change
			account._ip = ip;
			account._host = host;
			account._banned = false;
			account._lastActive = new Timestamp(System.currentTimeMillis());

			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "INSERT INTO accounts SET login=?,password=?,lastactive=?,access_level=?,ip=?,host=?,banned=?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, account._name);
			pstm.setString(2, account._password);
			pstm.setTimestamp(3, account._lastActive);
			pstm.setInt(4, 0);
			pstm.setString(5, account._ip);
			pstm.setString(6, account._host);
			pstm.setInt(7, account._banned ? 1 : 0);
			pstm.execute();
			_log.info("Created new account for " + name + ".");

			return account;
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (UnsupportedEncodingException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return null;
	}

	/**
	 *
	 *
	 * @param name
	 *
	 * @return Account
	 */
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

			_log.fine("account exists");
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}

		return account;
	}

	/**
	 *
	 *
	 * @param account
	 *
	 */
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
			_log.fine("update lastactive for " + account.getName());
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	/**
	 *
	 *
	 * @return int
	 */
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
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return result;
	}

	/**
	 *
	 *
	 * @param login
	 *
	 */
	public static void ban(final String login) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sqlstr = "UPDATE accounts SET banned=1 WHERE login=?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, login);
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	/* Ssargon changes */
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
        	} while(two_halfs++ < 1);
        }
        return buf.toString();
    }
	/* Make SHA256 of input String */
	public static String makeSHA256(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-256");
		byte[] sha256hash = new byte[32];
		md.update(text.getBytes("UTF-8"), 0, text.length());
		sha256hash = md.digest();
		return convertToString(sha256hash);
	}
	/* Make MD5 of input String */
	public static String makeMD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		MessageDigest md;
		md = MessageDigest.getInstance("MD5");
		byte[] md5hash = new byte[32];
		md.update(text.getBytes("UTF-8"), 0, text.length());
		md5hash = md.digest();
		return convertToString(md5hash);
	}
	/* Change password for account to input String password */
	public void change_password(String pass){
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE accounts SET password=? WHERE login=?");
			pstm.setString(1, pass);
			pstm.setString(2, _name);
			pstm.execute();
			_log.info("Rehashed password for " + _name + ".");
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	/*Ssargon change end*/
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
			_isValid = _password.equals(makeSHA256(Config.PASSWORD_SALT+rawPassword+makeMD5(_name)));//Ssargon change
			if (_isValid) {
				_password = null;
			} else { // If password does not match
				_isValid = _password.equals(encodePassword(rawPassword));
				if(_isValid){ //If its old scheme password
					change_password(makeSHA256(Config.PASSWORD_SALT+rawPassword+makeMD5(_name))); //Make new style password
				}
			}
			return _isValid;
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return false;
	}

	/**
	 *
	 *
	 * @return boolean
	 */
	public boolean isValid() {
		return _isValid;
	}

	/**
	 *
	 *
	 * @return boolean
	 */
	public boolean isGameMaster() {
		return 0 < _accessLevel;
	}

	/**
	 *
	 *
	 * @return String
	 */
	public String getName() {
		return _name;
	}

	/**
	 *
	 *
	 * @return String
	 */
	public String getIp() {
		return _ip;
	}

	/**
	 *
	 *
	 * @return String
	 */
	public Timestamp getLastActive() {
		return _lastActive;
	}

	/**
	 * 
	 *
	 * @return int
	 */
	public int getAccessLevel() {
		return _accessLevel;
	}

	/**
	 *
	 *
	 * @return String
	 */
	public String getHost() {
		return _host;
	}

	/**
	 *
	 *
	 * @return boolean
	 */
	public boolean isBanned() {
		return _banned;
	}
}
