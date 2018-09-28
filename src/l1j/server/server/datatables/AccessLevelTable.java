package l1j.server.server.datatables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1AccessLevel;
import l1j.server.server.utils.SQLUtil;

public class AccessLevelTable {
	private static Logger _log = LoggerFactory.getLogger(AccessLevelTable.class);
	private static AccessLevelTable _instance;
	private final LinkedHashMap<Short, L1AccessLevel> _accessLevels
			= new LinkedHashMap<Short, L1AccessLevel>();
	public static L1AccessLevel minAccessLevel = null;
	
	public static AccessLevelTable getInstance() {
		if (_instance == null) {
			_instance = new AccessLevelTable();
		}
		return _instance;
	}
	
	private AccessLevelTable() {
		loadAccessLevels();
		
		L1AccessLevel lowestAccessLevel = null;
		
		// find the lowest access level available
		for(Short accessId : _accessLevels.keySet()) {
			L1AccessLevel currentLevel = _accessLevels.get(accessId);
			if(lowestAccessLevel == null || 
					currentLevel.getLevel() < lowestAccessLevel.getLevel())
				lowestAccessLevel = currentLevel;
		}
		
		// should never hit this... but I'm paranoid
		if(lowestAccessLevel == null) {
			_log.error("Unable to set the lowest access level. Setting the id to -1 and level to 0!");
			lowestAccessLevel = new L1AccessLevel((short)-1, "Player", (short)0, null);
		}

		minAccessLevel = lowestAccessLevel;
	}
	
	public Collection<L1AccessLevel> getAllAccessLevels() {
		return _accessLevels.values();
	}
	
	public L1AccessLevel getAccessLevel(short id) {
		L1AccessLevel returnValue = _accessLevels.get(id);
		
		if(returnValue == null)
			returnValue = minAccessLevel;
		
		// should never hit this, but just to be safe and make them not a GM
		if(returnValue == null)
			returnValue = new L1AccessLevel((short)-1, "Player", (short)0, null);
		
		return returnValue;
	}
	
	public short getMaxAccessLevel() {
		short maxAccessLevel = Config.MIN_GM_ACCESS_LEVEL;
		
		// really don't want this to fail and give 0 access level
		// so wrap it in try/catch
		try {
			for(Short id : _accessLevels.keySet()) {
				L1AccessLevel currentLevel = _accessLevels.get(id);
				if(currentLevel.getLevel() > maxAccessLevel)
					maxAccessLevel = currentLevel.getLevel();
			}
		} catch(Exception ex) {}
		
		// just for good measure
		if(maxAccessLevel < Config.MIN_GM_ACCESS_LEVEL)
			maxAccessLevel = Config.MIN_GM_ACCESS_LEVEL;
		
		return maxAccessLevel;
	}
	
	private void loadAccessLevels() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM access_levels ORDER BY access_level DESC");
			rs = pstm.executeQuery();
			fillAccessTable(rs);
		} catch (SQLException e) {
			_log.error("error while creating access levels table", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	private void fillAccessTable(ResultSet rs) throws SQLException {
		while (rs.next()) {
			short id = rs.getShort("id");
			String name = rs.getString("name");
			short accessLevel = rs.getShort("access_level");
			String chatPrefix = rs.getString("chat_prefix");

			_accessLevels.put(id, new L1AccessLevel(id, name, accessLevel, chatPrefix));
		}
		_log.info("Access Levels: " + _accessLevels.size() + " Loaded");
	}
}
