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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.templates.L1AuctionBoard;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// IdFactory
public class AuctionBoardTable {
	private static Logger _log = Logger.getLogger(AuctionBoardTable.class
			.getName());
	private static AuctionBoardTable _instance;
	private final Map<Integer, L1AuctionBoard> _boards = new ConcurrentHashMap<Integer, L1AuctionBoard>();

	private Calendar timestampToCalendar(Timestamp ts) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ts.getTime());
		return cal;
	}

	public AuctionBoardTable() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM board_auction ORDER BY house_id");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1AuctionBoard board = new L1AuctionBoard();
				board.setHouseId(rs.getInt(1));
				board.setHouseName(rs.getString(2));
				board.setHouseArea(rs.getInt(3));
				board.setDeadline(timestampToCalendar((Timestamp) rs
						.getObject(4)));
				board.setPrice(rs.getInt(5));
				board.setLocation(rs.getString(6));
				board.setOldOwner(rs.getString(7));
				board.setOldOwnerId(rs.getInt(8));
				board.setBidder(rs.getString(9));
				board.setBidderId(rs.getInt(10));
				_boards.put(board.getHouseId(), board);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1AuctionBoard[] getAuctionBoardTableList() {
		return _boards.values().toArray(new L1AuctionBoard[_boards.size()]);
	}

	public L1AuctionBoard getAuctionBoardTable(int houseId) {
		return _boards.get(houseId);
	}

	public void insertAuctionBoard(L1AuctionBoard board) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO board_auction SET house_id=?, house_name=?, house_area=?, deadline=?, price=?, location=?, old_owner=?, old_owner_id=?, bidder=?, bidder_id=?");
			pstm.setInt(1, board.getHouseId());
			pstm.setString(2, board.getHouseName());
			pstm.setInt(3, board.getHouseArea());
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss"); // this format saves and updates the
											// time of your system for
											// auctiontable
			String dateString = format.format(board.getDeadline().getTime());
			pstm.setString(4, dateString);
			pstm.setInt(5, board.getPrice());
			pstm.setString(6, board.getLocation());
			pstm.setString(7, board.getOldOwner());
			pstm.setInt(8, board.getOldOwnerId());
			pstm.setString(9, board.getBidder());
			pstm.setInt(10, board.getBidderId());
			pstm.execute();
			_boards.put(board.getHouseId(), board);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void updateAuctionBoard(L1AuctionBoard board) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE board_auction SET house_name=?, house_area=?, deadline=?, price=?, location=?, old_owner=?, old_owner_id=?, bidder=?, bidder_id=? WHERE house_id=?");
			pstm.setString(1, board.getHouseName());
			pstm.setInt(2, board.getHouseArea());
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss"); // this format saves and updates the
											// time of your system for
											// auctiontable
			String dateString = format.format(board.getDeadline().getTime());
			pstm.setString(3, dateString);
			pstm.setInt(4, board.getPrice());
			pstm.setString(5, board.getLocation());
			pstm.setString(6, board.getOldOwner());
			pstm.setInt(7, board.getOldOwnerId());
			pstm.setString(8, board.getBidder());
			pstm.setInt(9, board.getBidderId());
			pstm.setInt(10, board.getHouseId());
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void deleteAuctionBoard(int houseId) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM board_auction WHERE house_id=?");
			pstm.setInt(1, houseId);
			pstm.execute();
			_boards.remove(houseId);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}