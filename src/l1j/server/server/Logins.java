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
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.database.L1DatabaseFactory;
import l1j.server.server.encryptions.Base64;
import l1j.server.server.utils.SQLUtil;

public class Logins {
	private static Logger _log = Logger.getLogger(Logins.class.getName());

	public static boolean loginValid(String account, String password, String ip, String host) {
		boolean flag1 = false;
		_log.info("Connection from: " + account);
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			byte abyte1[];
			byte abyte2[];
			MessageDigest messagedigest = MessageDigest.getInstance("SHA");
			byte abyte0[] = password.getBytes("UTF-8");
			abyte1 = messagedigest.digest(abyte0);
			abyte2 = null;
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT password FROM accounts WHERE login=? LIMIT 1");
			pstm.setString(1, account);
			rs = pstm.executeQuery();
			if (rs.next()) {
				abyte2 = Base64.decode(rs.getString(1));
				_log.fine("Account exists");
			}
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);

			if (abyte2 == null) {
				if (Config.AUTO_CREATE_ACCOUNTS) {
					con = L1DatabaseFactory.getInstance().getConnection();
					pstm = con.prepareStatement("INSERT INTO accounts SET login=?,password=?,lastactive=?,access_level=?,ip=?,host=?");
					pstm.setString(1, account);
					pstm.setString(2, Base64.encodeBytes(abyte1));
					pstm.setLong(3, 0L);
					pstm.setInt(4, 0);
					pstm.setString(5, ip);
					pstm.setString(6, host);
					pstm.execute();
					_log.info("Created new account for " + account);
					return true;
				} else {
					_log.warning("Account missing for user " + account);
					return false;
				}
			}
			try {
				flag1 = true;
				int i = 0;
				do {
					if (i >= abyte2.length) {
						break;
					}
					if (abyte1[i] != abyte2[i]) {
						flag1 = false;
						break;
					}
					i++;
				} while (true);
			} catch (Exception e) {
				_log.warning("Could not check password: " + e);
				flag1 = false;
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (UnsupportedEncodingException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return flag1;
	}
}