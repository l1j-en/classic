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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

public final class DropItemTable {
	private class dropItemData {
		public double dropRate = 1;
		public double dropAmount = 1;
	}

	private static Logger _log = Logger.getLogger(DropItemTable.class
			.getName());

	private static DropItemTable _instance;

	private final Map<Integer, dropItemData> _dropItem
			= new HashMap<Integer, dropItemData>();

	public static DropItemTable getInstance() {
		if (_instance == null) {
			_instance = new DropItemTable();
		}
		return _instance;
	}

	private DropItemTable() {
		loadMapsFromDatabase();
	}

	private void loadMapsFromDatabase() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM drop_item");

			for (rs = pstm.executeQuery(); rs.next();) {
				dropItemData data = new dropItemData();
				int itemId = rs.getInt("item_id");
				data.dropRate = rs.getDouble("drop_rate");
				data.dropAmount = rs.getDouble("drop_amount");

				_dropItem.put(new Integer(itemId), data);
			}

			_log.config("drop_item " + _dropItem.size());
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public double getDropRate(int itemId) {
		dropItemData data = _dropItem.get(itemId);
		if (data == null) {
			return 1;
		}
		return data.dropRate;
	}

	public double getDropAmount(int itemId) {
		dropItemData data = _dropItem.get(itemId);
		if (data == null) {
			return 1;
		}
		return data.dropAmount;
	}

}
