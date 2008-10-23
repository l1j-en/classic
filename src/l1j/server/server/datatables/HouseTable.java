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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.templates.L1House;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// IdFactory

public class HouseTable {

	private static Logger _log = Logger.getLogger(HouseTable.class.getName());

	private static HouseTable _instance;

	private final Map<Integer, L1House> _house = new ConcurrentHashMap<Integer, L1House>();

	public static HouseTable getInstance() {
		if (_instance == null) {
			_instance = new HouseTable();
		}
		return _instance;
	}

	private Calendar timestampToCalendar(Timestamp ts) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ts.getTime());
		return cal;
	}


	public HouseTable() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM house ORDER BY house_id");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1House house = new L1House();
				house.setHouseId(rs.getInt(1));
				house.setHouseName(rs.getString(2));
				house.setHouseArea(rs.getInt(3));
				house.setLocation(rs.getString(4));
				house.setKeeperId(rs.getInt(5));
				house.setOnSale(rs.getInt(6) == 1 ? true : false);
				house.setPurchaseBasement(rs.getInt(7) == 1 ? true : false);
				house.setTaxDeadline(timestampToCalendar((Timestamp) rs
						.getObject(8)));
				_house.put(house.getHouseId(), house);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1House[] getHouseTableList() {
		return _house.values().toArray(new L1House[_house.size()]);
	}

	public L1House getHouseTable(int houseId) {
		return _house.get(houseId);
	}

	public void updateHouse(L1House house) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE house SET house_name=?, house_area=?, location=?, keeper_id=?, is_on_sale=?, is_purchase_basement=?, tax_deadline=? WHERE house_id=?");
			pstm.setString(1, house.getHouseName());
			pstm.setInt(2, house.getHouseArea());
			pstm.setString(3, house.getLocation());
			pstm.setInt(4, house.getKeeperId());
			pstm.setInt(5, house.isOnSale() == true ? 1 : 0);
			pstm.setInt(6, house.isPurchaseBasement() == true ? 1 : 0);
			String fm = DateFormat.getDateTimeInstance().format(
					house.getTaxDeadline().getTime());
			pstm.setString(7, fm);
			pstm.setInt(8, house.getHouseId());
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static List<Integer> getHouseIdList() {
		List<Integer> houseIdList = new ArrayList<Integer>();

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT house_id FROM house ORDER BY house_id");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int houseId = rs.getInt("house_id");
				houseIdList.add(Integer.valueOf(houseId));
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}

		return houseIdList;
	}
}
