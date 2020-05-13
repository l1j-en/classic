/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class LogStatusUp {
	private static Logger _log = LoggerFactory.getLogger(LogStatusUp.class.getName());

	public void storeLogStatusUp(L1PcInstance pc, int str, int dex, int Con,
			int Int, int wis, int cha) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO logstatusup VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			Date time = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String fm = formatter.format(time.getTime());
			pstm.setString(1, fm);
			pstm.setString(2, pc.getNetConnection().getIp());
			pstm.setString(3, pc.getAccountName());
			pstm.setInt(4, pc.getId());
			pstm.setString(5, pc.getName());
			pstm.setInt(6, pc.getLevel());
			pstm.setInt(7, str);
			pstm.setInt(8, pc.getBaseStr());
			pstm.setInt(9, dex);
			pstm.setInt(10, pc.getBaseDex());
			pstm.setInt(11, Con);
			pstm.setInt(12, pc.getBaseCon());
			pstm.setInt(13, Int);
			pstm.setInt(14, pc.getBaseInt());
			pstm.setInt(15, wis);
			pstm.setInt(16, pc.getBaseWis());
			pstm.setInt(17, cha);
			pstm.setInt(18, pc.getBaseCha());
			int sorcestat = 0;
			if (pc.getLevel() >= 51) {
				sorcestat += pc.getLevel() - 50;
			}
			pstm.setInt(19, sorcestat);
			pstm.setInt(20, pc.getBonusStats());
			int allstat = (pc.getBaseStr() + pc.getBaseDex() + pc.getBaseCon()
					+ pc.getBaseInt() + pc.getBaseWis() + pc.getBaseCha()) - 75;
			pstm.setInt(21, allstat);
			int diffsc = sorcestat - pc.getBonusStats();
			pstm.setInt(22, diffsc);
			int diffsr = sorcestat - allstat;
			pstm.setInt(23, diffsr);
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}
