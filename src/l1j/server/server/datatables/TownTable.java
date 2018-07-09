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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.shop.L1ShopBuyOrder;
import l1j.server.server.model.shop.L1ShopBuyOrderList;
import l1j.server.server.templates.L1Town;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// IdFactory
public class TownTable {
	private static final int _minTaxRate = 2;
	private static Logger _log = Logger.getLogger(TownTable.class.getName());
	private static TownTable _instance;
	private final Map<Integer, L1Town> _towns = new ConcurrentHashMap<Integer, L1Town>();

	public static TownTable getInstance() {
		if (_instance == null) {
			_instance = new TownTable();
		}
		return _instance;
	}

	private TownTable() {
		load();
	}

	public void load() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		_towns.clear();
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM town");
			int townid;
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1Town town = new L1Town();
				townid = rs.getInt("town_id");
				town.set_townid(townid);
				town.set_name(rs.getString("name"));
				town.set_leader_id(rs.getInt("leader_id"));
				town.set_leader_name(rs.getString("leader_name"));
				town.set_tax_rate(rs.getInt("tax_rate"));
				town.set_tax_rate_reserved(rs.getInt("tax_rate_reserved"));
				town.set_sales_money(rs.getInt("sales_money"));
				town.set_sales_money_yesterday(rs
						.getInt("sales_money_yesterday"));
				town.set_town_tax(rs.getInt("town_tax"));
				town.set_town_fix_tax(rs.getInt("town_fix_tax"));
				_towns.put(new Integer(townid), town);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1Town[] getTownTableList() {
		return _towns.values().toArray(new L1Town[_towns.size()]);
	}

	public L1Town getTownTable(int id) {
		return _towns.get(id);
	}

	public boolean isLeader(L1PcInstance pc, int town_id) {
		L1Town town = getTownTable(town_id);
		return (town.get_leader_id() == pc.getId());
	}

	public synchronized void addSalesMoney(int town_id, L1ShopBuyOrderList orderList) {
		Connection con = null;
		PreparedStatement pstm = null;

		L1Town town = TownTable.getInstance().getTownTable(town_id);
		int townTaxRate = town.get_tax_rate();
		
		int salesMoney = 0;
		int townTaxEarned = 0; // all tax income above the 2%
		int townFixTaxEarned = 0; // the min 2% towns always earn
			
		for(L1ShopBuyOrder item : orderList.getBoughtItems()) {
			salesMoney += item.getItem().getPrice() * item.getCount();
					
			for(int i = 0; i < item.getCount(); i++) {
				townTaxEarned += item.getItem().getPrice() * townTaxRate / 100;
				townFixTaxEarned += item.getItem().getPrice() * _minTaxRate / 100;
			}	
		}
		
		if (townTaxEarned <= 0 && townTaxRate > 0) {
			townTaxEarned = 1;
		}
		
		if (townFixTaxEarned <= 0 && townTaxRate > 0) {
			townFixTaxEarned = 1;
		}
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE town SET sales_money = sales_money + ?, " +
							"town_tax = town_tax + ?, town_fix_tax = town_fix_tax + ? WHERE town_id = ?");
			pstm.setInt(1, salesMoney);
			pstm.setInt(2, townTaxEarned);
			pstm.setInt(3, townFixTaxEarned);
			pstm.setInt(4, town_id);
			pstm.execute();
			town.set_sales_money(town.get_sales_money() + salesMoney);
			town.set_town_tax(town.get_town_tax() + townTaxEarned);
			town.set_town_fix_tax(town.get_town_fix_tax() + townFixTaxEarned);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void removeTaxes(int town_id) {
		Connection con = null;
		PreparedStatement pstm = null;
		L1Town town = TownTable.getInstance().getTownTable(town_id);
		town.set_town_tax(0);
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE town SET town_tax = 0 WHERE town_id = ?");
			pstm.setInt(1, town_id);
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void changeTaxRate(int town_id, int tax_rate) {
		Connection con = null;
		PreparedStatement pstm = null;
		L1Town town = TownTable.getInstance().getTownTable(town_id);
		town.set_tax_rate_reserved(tax_rate);
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE town SET tax_rate_reserved = ? WHERE town_id = ?");
			pstm.setInt(1, tax_rate);
			pstm.setInt(2, town_id);
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public int recieveFixTax(int town_id) {
		return TownTable.getInstance().getTownTable(town_id).get_town_fix_tax();
	}

	public int recieveTax(int town_id) {
		return TownTable.getInstance().getTownTable(town_id).get_town_tax();
	}

	public int getTodaySales(int town_id) {
		return TownTable.getInstance().getTownTable(town_id).get_sales_money();
	}

	public int getYesterdaySales(int town_id) {
		return TownTable.getInstance().getTownTable(town_id)
				.get_sales_money_yesterday();
	}

	public int recieveTaxRate(int town_id) {
		return TownTable.getInstance().getTownTable(town_id).get_tax_rate();
	}

	public void updateTaxRate() {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE town SET tax_rate = tax_rate_reserved");
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void updateSalesMoneyYesterday() {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE town SET sales_money_yesterday = sales_money, sales_money = 0");
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}