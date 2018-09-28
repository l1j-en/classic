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
package l1j.server.server.command.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.SQLUtil;

public class L1ViewBug implements L1CommandExecutor {

	private L1ViewBug() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1ViewBug();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();

			int bugid = Integer.valueOf(arg).intValue();
			pstm = con.prepareStatement("select * from bugs where id = ?");
			pstm.setInt(1, bugid);
			rs = pstm.executeQuery();
			rs.next();
			if (rs.getInt("resolved") == 1) {
				pc.sendPackets(new S_SystemMessage(rs.getInt("id")
						+ "(Resolved). " + rs.getString("charname")
						+ " (on Map:" + rs.getInt("mapID") + ", X:"
						+ rs.getInt("mapX") + ", Y:" + rs.getInt("mapY")
						+ ") wrote: " + rs.getString("bugtext") + "."));
			} else {
				pc.sendPackets(new S_SystemMessage(rs.getInt("id") + ". "
						+ rs.getString("charname") + " (on Map:"
						+ rs.getInt("mapID") + ", X:" + rs.getInt("mapX")
						+ ", Y:" + rs.getInt("mapY") + ") wrote: "
						+ rs.getString("bugtext") + "."));
			}
			rs.close();
		} catch (Exception e) {
			listBugs(pc);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	// List all unresolved bugs
	private void listBugs(L1PcInstance pc) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("select * from bugs where resolved = 0");// ORDER
																				// BY
																				// id
			rs = pstm.executeQuery();
			while (rs.next()) {
				String str1 = rs.getString("bugtext");
				int str1length = str1.length();
				if (str1length > 45) {
					str1length = 45;
				}
				pc.sendPackets(new S_SystemMessage(rs.getInt("id") + ": "
						+ rs.getString("bugtext").substring(0, str1length)));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("Could not access the buglist!"));
			pc.sendPackets(new S_SystemMessage(".viewbug (bugID)"));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}