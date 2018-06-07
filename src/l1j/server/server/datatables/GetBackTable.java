package l1j.server.server.datatables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.templates.L1GetBack;
import l1j.server.server.utils.SQLUtil;

public class GetBackTable {
	private static Logger _log = Logger.getLogger(GetBackTable.class
			.getName());
	private static GetBackTable _instance;
	private final HashMap<Integer, L1GetBack> _getback = new HashMap<Integer, L1GetBack>();

	public static GetBackTable getInstance() {
		if (_instance == null) {
			_instance = new GetBackTable();
		}
		return _instance;
	}

	public GetBackTable() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM getback");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1GetBack gb = new L1GetBack();
				int area_mapid = rs.getInt("area_mapid");
				
				gb.setArea_x1(rs.getInt("area_x1"));
				gb.setArea_y1(rs.getInt("area_y1"));
				gb.setArea_x2(rs.getInt("area_x2"));
				gb.setArea_y2(rs.getInt("area_y2"));
				gb.setArea_mapid(area_mapid);
				gb.setGetback_x1(rs.getInt("getback_x1"));
				gb.setGetback_y1(rs.getInt("getback_y1"));
				gb.setGetback_x2(rs.getInt("getback_x2"));
				gb.setGetback_y2(rs.getInt("getback_y2"));
				gb.setGetback_x3(rs.getInt("getback_x3"));
				gb.setGetback_y3(rs.getInt("getback_y3"));
				gb.setGetback_mapid(rs.getInt("getback_mapid"));
				gb.setGetback_townid(rs.getInt("getback_townid"));
				gb.setGetback_townid_elf(rs.getInt("getback_townid_elf"));
				gb.setGetback_townid_darkelf(rs.getInt("getback_townid_darkelf"));
				gb.setScrollescape(rs.getInt("scrollescape"));
				gb.setNote(rs.getString("note"));
				
				_getback.put(new Integer(area_mapid), gb);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	public L1GetBack getBackByMapId(int mapid) {
		if(_getback.containsKey(mapid)) {
			return _getback.get(mapid);
		}
		
		return null;
	}

	public L1GetBack[] getGetBackRestartTableList() {
		return _getback.values().toArray(
				new L1GetBack[_getback.size()]);
	}
}
