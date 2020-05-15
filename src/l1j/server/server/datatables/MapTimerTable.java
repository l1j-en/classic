package l1j.server.server.datatables;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class MapTimerTable {
	private static Logger _log = LoggerFactory.getLogger(MapsTable.class.getName());
	
	private int _charId;
	private int _mapId;
	private int _areaId;
	private int _enterTime;

	public MapTimerTable() { }

	public MapTimerTable(int charId, int mapId, int areaId, int enterTime) {
		_charId = charId;
		_mapId = mapId;
		_areaId = areaId;
		_enterTime = enterTime;
	}

	public int getCharObjId() {
		return _charId;
	}
	
	public void setCharId(int charObjId) {
		_charId = charObjId;
	}
	
	public int getMapId() {
		return _mapId;
	}
	
	public void setMapId(int mapId) {
		_mapId = mapId;
	}

	public int getAreaId() {
		return _areaId;
	}
	
	public void setAreaId(int areaId) {
		_areaId = areaId;
	}
		
	public int getEnterTime() {
		return _enterTime;
	}
	
	public void setEnterTime(int enterTime) {
		_enterTime = enterTime;
	}

	public static MapTimerTable find(int charId, int areaId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM map_timers WHERE char_id = ? AND area_id = ?");
			pstm.setInt(1, charId);
			pstm.setInt(2, areaId);
			rs = pstm.executeQuery();
			if(rs.next()) {
				return new MapTimerTable(rs.getInt("char_id"), rs.getInt("map_id"), rs.getInt("area_id"), rs.getInt("enter_time"));
			}
			
			return null;
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
			
			return null;
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void store(Connection con) {
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("INSERT INTO map_timers SET char_id=?, map_id=?, area_id=?, enter_time=?");
			pstm.setInt(1, _charId);
			pstm.setInt(2, _mapId);
			pstm.setInt(3, _areaId);
			pstm.setInt(4, _enterTime);
			
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void save() {
		Connection con = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			delete(con, _charId, _areaId);
			store(con);
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(con);
		}
	}

	private static void delete(Connection con, int charId, int areaId) {
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM map_timers WHERE char_id = ? AND area_id = ?");
			pstm.setInt(1, charId);
			pstm.setInt(2, areaId);
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);

		};
	}

	private static void delete(Connection con, int areaId) {
		
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM map_timers WHERE area_id = ?");
			pstm.setInt(1, areaId);
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);

		};
	}

	public static void remove(int areaId) {
		Connection con = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			delete(con, areaId);
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(con);
		}
	}

	public static void reset(int areaId) {
		for(L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
			if (pc.getMapLimiter().getAreaId() == areaId) {
				pc.stopMapLimiter();
			}
		}
		remove(areaId);
		for(L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
			if (pc.getMapLimiter() == null) {
				pc.startMapLimiter();
			}
		}
	}
}
