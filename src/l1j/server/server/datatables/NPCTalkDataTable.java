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

import java.sql.*;
import java.util.HashMap;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.utils.SQLUtil;

public class NPCTalkDataTable {
	private static Logger _log = Logger.getLogger(NPCTalkDataTable.class.getName());
	private static NPCTalkDataTable _instance;
	private HashMap<Integer, L1NpcTalkData> _datatable = new HashMap<Integer, L1NpcTalkData>();

	public static NPCTalkDataTable getInstance() {
		if (_instance == null) {
			_instance = new NPCTalkDataTable();
		}
		return _instance;
	}

	private NPCTalkDataTable() {
		parseList();
	}

	private void parseList() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM npcaction");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1NpcTalkData l1npctalkdata = new L1NpcTalkData();
				l1npctalkdata.setNpcID(rs.getInt(1));
				l1npctalkdata.setNormalAction(rs.getString(2));
				l1npctalkdata.setCaoticAction(rs.getString(3));
				l1npctalkdata.setTeleportURL(rs.getString(4));
				l1npctalkdata.setTeleportURLA(rs.getString(5));
				_datatable.put(new Integer(l1npctalkdata.getNpcID()), l1npctalkdata);
			}
			_log.config("NPC Action List: " + _datatable.size() + " Loaded");
		} catch (SQLException e) {
			_log.warning("error while creating npc action table " + e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1NpcTalkData getTemplate(int i) {
		return _datatable.get(new Integer(i));
	}
}