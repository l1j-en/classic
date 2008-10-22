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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

public class IpTable {

	public static IpTable getInstance() {
		if (_instance == null) {
			_instance = new IpTable();
		}
		return _instance;
	}

	private IpTable() {
		if (!isInitialized) {
			_banip = new ArrayList<String>();
			getIpTable();
		}
	}

	public void banIp(String ip) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("INSERT INTO ban_ip SET ip=?");
			pstm.setString(1, ip);
			pstm.execute();
			_banip.add(ip);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public boolean isBannedIp(String s) {
		return _banip.contains(s);
	}

	public void getIpTable() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM ban_ip");

			rs = pstm.executeQuery();

			while (rs.next()) {
				_banip.add(rs.getString(1));
			}

			isInitialized = true;

		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public boolean liftBanIp(String ip) {
		boolean ret = false;
		Connection con = null;
		PreparedStatement pstm = null;

		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("DELETE FROM ban_ip WHERE ip=?");
			pstm.setString(1, ip);
			pstm.execute();
			ret = _banip.remove(ip);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return ret;
	}

	private static Logger _log = Logger.getLogger(IpTable.class.getName());

	private static ArrayList<String> _banip;

	public static boolean isInitialized;

	private static IpTable _instance;

}
