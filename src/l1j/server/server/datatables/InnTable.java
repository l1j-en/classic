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
import l1j.server.server.templates.L1Inn;
import l1j.server.server.templates.L1Pet;
import l1j.server.server.utils.SQLUtil;

public class InnTable {
	
	private static Logger _log = Logger.getLogger(InnTable.class.getName());
	private static final Map<Integer, Inn> _dataMap =new HashMap<Integer, Inn>();
	private static InnTable _instance;
	
	private static class Inn {
		private final Map<Integer, L1Inn> _inn = new HashMap<Integer, L1Inn>();
	}

	public static InnTable getInstance() {
		if (_instance == null) {
			_instance = new InnTable();
		}
		return _instance;
	}

	private InnTable() {
		load();
	}

	private void load() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Inn inn = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM inn");
			rs = pstm.executeQuery();
			L1Inn l1inn;
			int roomNumber;
			while (rs.next()) {
				int key = rs.getInt("npcid");
				if (!_dataMap.containsKey(key)) {
					inn = new Inn();
					_dataMap.put(key, inn);
				} else {
					inn = _dataMap.get(key);
				}
				
				l1inn = new L1Inn();
				l1inn.setInnNpcId(rs.getInt("npcid"));
				roomNumber = rs.getInt("room_number");
				l1inn.setRoomNumber(roomNumber);
				l1inn.setKeyId(rs.getInt("key_id"));
				l1inn.setLodgerId(rs.getInt("lodger_id"));
				l1inn.setHall(rs.getBoolean("hall"));
				l1inn.setDueTime(rs.getTimestamp("due_time"));
				inn._inn.put(Integer.valueOf(roomNumber), l1inn);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);

		}
	}

	public void updateInn(L1Inn inn) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE inn SET key_id=?,lodger_id=?,hall=?,due_time=? WHERE npcid=? and room_number=?");
			pstm.setInt(1, inn.getKeyId());
			pstm.setInt(2, inn.getLodgerId());
			pstm.setBoolean(3, inn.isHall());
			pstm.setTimestamp(4, inn.getDueTime());
			pstm.setInt(5, inn.getInnNpcId());
			pstm.setInt(6, inn.getRoomNumber());
			pstm.execute();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1Inn getTemplate(int npcid, int roomNumber) {
		if (_dataMap.containsKey(npcid)) {
			return _dataMap.get(npcid)._inn.get(roomNumber);
		}
		return null;
	}
}