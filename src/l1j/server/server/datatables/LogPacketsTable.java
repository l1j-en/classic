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

import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

public class LogPacketsTable {
	private static Logger _log = LoggerFactory.getLogger(LogPacketsTable.class.getName());

	public static void storeLogPacket(int target_id, String target_name, int target_poly, int opCode, String packet, String type, long timestamp) {
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO log_packets SET target_id=?, target_name=?, target_poly=?, opcode=?, packet=?, timestamp=?, type=?");
			pstm.setInt(1, target_id);
			pstm.setString(2, target_name);
			pstm.setInt(3, target_poly);
			pstm.setInt(4, opCode);
			pstm.setString(5, packet);
			pstm.setLong(6, timestamp);
			pstm.setString(7, type);
			pstm.execute();

		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);

		}
	}
}
