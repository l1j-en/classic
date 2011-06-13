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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.TownTable;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTime;
import l1j.server.server.model.gametime.L1GameTimeAdapter;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.utils.SQLUtil;

public class HomeTownTimeController {
	private static Logger _log = Logger.getLogger(HomeTownTimeController.class.getName());

	private static HomeTownTimeController _instance;

	public static HomeTownTimeController getInstance() {
		if (_instance == null) {
			_instance = new HomeTownTimeController();
		}
		return _instance;
	}

	private HomeTownTimeController() {
		startListener();
	}

	private static L1TownFixedProcListener _listener;

	private void startListener() {
		if (_listener == null) {
			_listener = new L1TownFixedProcListener();
			L1GameTimeClock.getInstance().addListener(_listener);
		}
	}

	private class L1TownFixedProcListener extends L1GameTimeAdapter {
		@Override
		public void onDayChanged(L1GameTime time) {
			fixedProc(time);
		}
	}

	private void fixedProc(L1GameTime time) {
		Calendar cal = time.getCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);

		if (day == 25) {
			monthlyProc();
		} else {
			dailyProc();
		}
	}

	public void dailyProc() {
		_log.info("Running Daily Update For Tax And Sales Money.");
		TownTable.getInstance().updateTaxRate();
		TownTable.getInstance().updateSalesMoneyYesterday();
		TownTable.getInstance().load();
	}

	public void monthlyProc() {
		_log.info("Running monthly update for tax and sales money.");
		L1World.getInstance().setProcessingContributionTotal(true);
		Collection<L1PcInstance> players = L1World.getInstance().getAllPlayers();
		
		for (L1PcInstance pc : players) {
			try {
				pc.save();
			} catch (Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}

		for (int townId = 1; townId <= 10; townId++) {
			String leaderName = totalContribution(townId);
			if (leaderName != null) {
				S_PacketBox packet = new S_PacketBox(S_PacketBox.MSG_TOWN_LEADER, leaderName);
				for (L1PcInstance pc : players) {
					if (pc.getHomeTownId() == townId) {
						pc.setContribution(0);
						pc.sendPackets(packet);
					}
				}
			}
		}
		TownTable.getInstance().load();

		for (L1PcInstance pc : players) {
			if (pc.getHomeTownId() == -1) {
				pc.setHomeTownId(0);
			}
			pc.setContribution(0);
			try {
				pc.save();
			} catch (Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}
		clearHomeTownID();
		L1World.getInstance().setProcessingContributionTotal(false);
	}

	private static String totalContribution(int townId) {
		Connection con = null;
		PreparedStatement pstm1 = null;
		ResultSet rs1 = null;
		PreparedStatement pstm2 = null;
		ResultSet rs2 = null;
		PreparedStatement pstm3 = null;
		ResultSet rs3 = null;
		PreparedStatement pstm4 = null;
		PreparedStatement pstm5 = null;

		int leaderId = 0;
		String leaderName = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm1 = con.prepareStatement("SELECT objid, char_name FROM characters WHERE HomeTownID = ? ORDER BY Contribution DESC");
			pstm1.setInt(1, townId);
			rs1 = pstm1.executeQuery();

			if (rs1.next()) {
				leaderId = rs1.getInt("objid");
				leaderName = rs1.getString("char_name");
			}

			double totalContribution = 0;
			pstm2 = con.prepareStatement("SELECT SUM(Contribution) AS TotalContribution FROM characters WHERE HomeTownID = ?");
			pstm2.setInt(1, townId);
			rs2 = pstm2.executeQuery();
			if (rs2.next()) {
				totalContribution = rs2.getInt("TotalContribution");
			}

			double townFixTax = 0;
			pstm3 = con.prepareStatement("SELECT town_fix_tax FROM town WHERE town_id = ?");
			pstm3.setInt(1, townId);
			rs3 = pstm3.executeQuery();
			if (rs3.next()) {
				townFixTax = rs3.getInt("town_fix_tax");
			}

			double contributionUnit = 0;
			if (totalContribution != 0) {
				contributionUnit = Math.floor(townFixTax / totalContribution * 100) / 100;
			}
			pstm4 = con.prepareStatement("UPDATE characters SET Contribution = 0, Pay = Contribution * ? WHERE HomeTownID = ?");
			pstm4.setDouble(1, contributionUnit);
			pstm4.setInt(2, townId);
			pstm4.execute();

			pstm5 = con.prepareStatement("UPDATE town SET leader_id = ?, leader_name = ?, tax_rate = 0, tax_rate_reserved = 0, sales_money = 0, sales_money_yesterday = sales_money, town_tax = 0, town_fix_tax = 0 WHERE town_id = ?");
			pstm5.setInt(1, leaderId);
			pstm5.setString(2, leaderName);
			pstm5.setInt(3, townId);
			pstm5.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs1);
			SQLUtil.close(rs2);
			SQLUtil.close(rs3);
			SQLUtil.close(pstm1);
			SQLUtil.close(pstm2);
			SQLUtil.close(pstm3);
			SQLUtil.close(pstm4);
			SQLUtil.close(pstm5);
			SQLUtil.close(con);
		}
		return leaderName;
	}

	private static void clearHomeTownID() {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE characters SET HomeTownID = 0 WHERE HomeTownID = -1");
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static int getPay(int objid) {
		Connection con = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		ResultSet rs1 = null;
		int pay = 0;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm1 = con.prepareStatement("SELECT Pay FROM characters WHERE objid = ? FOR UPDATE");
			pstm1.setInt(1, objid);
			rs1 = pstm1.executeQuery();

			if (rs1.next()) {
				pay = rs1.getInt("Pay");
			}

			pstm2 = con.prepareStatement("UPDATE characters SET Pay = 0 WHERE objid = ?");
			pstm2.setInt(1, objid);
			pstm2.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs1);
			SQLUtil.close(pstm1);
			SQLUtil.close(pstm2);
			SQLUtil.close(con);
		}
		return pay;
	}
}