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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.map.L1Map;
import l1j.server.server.model.map.L1WorldMap;
import l1j.server.server.storage.CharacterStorage;
import l1j.server.server.storage.mysql.MySqlCharacterStorage;
import l1j.server.server.templates.L1CharName;
import l1j.server.server.utils.SQLUtil;

public class CharacterTable {
	private CharacterStorage _charStorage;
	private static CharacterTable _instance;
	private static Logger _log = LoggerFactory.getLogger(CharacterTable.class
			.getName());

	private final Map<String, L1CharName> _charNameList = new ConcurrentHashMap<String, L1CharName>();

	private CharacterTable() {
		_charStorage = new MySqlCharacterStorage();
	}

	public static CharacterTable getInstance() {
		if (_instance == null) {
			_instance = new CharacterTable();
		}
		return _instance;
	}

	public void storeNewCharacter(L1PcInstance pc) throws Exception {
		synchronized (pc) {
			_charStorage.createCharacter(pc);
			String name = pc.getName();
			if (!_charNameList.containsKey(name)) {
				L1CharName cn = new L1CharName();
				cn.setName(name);
				cn.setId(pc.getId());
				_charNameList.put(name, cn);
			}
			_log.trace("storeNewCharacter");
		}
	}

	public void storeCharacter(L1PcInstance pc) throws Exception {
		synchronized (pc) {
			_charStorage.storeCharacter(pc);
			_log.trace("storeCharacter: " + pc.getName());
		}
	}

	public void deleteCharacter(String accountName, String charName)
			throws Exception {
		// We probably do not need synchronization
		_charStorage.deleteCharacter(accountName, charName);
		if (_charNameList.containsKey(charName)) {
			_charNameList.remove(charName);
		}
		_log.trace("deleteCharacter");
	}

	public L1PcInstance restoreCharacter(String charName) throws Exception {
		L1PcInstance pc = _charStorage.loadCharacter(charName);
		return pc;
	}

	public L1PcInstance loadCharacter(String charName) {
		L1PcInstance pc = null;
		try {
			pc = restoreCharacter(charName);

			// SKT is beyond the scope of the map move
			L1Map map = L1WorldMap.getInstance().getMap(pc.getMapId());

			if (!map.isInMap(pc.getX(), pc.getY())) {
				pc.setX(33087);
				pc.setY(33396);
				pc.setMap((short) 4);
			}
			_log.trace("loadCharacter: " + pc.getName());
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
		return pc;

	}

	public static void clearOnlineStatus() {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE characters SET OnlineStatus=0");
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static void updateOnlineStatus(L1PcInstance pc) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE characters SET OnlineStatus=? WHERE objid=?");
			pstm.setInt(1, pc.getOnlineStatus());
			pstm.setInt(2, pc.getId());
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static void updatePartnerId(int targetId) {
		updatePartnerId(targetId, 0);
	}

	public static void updatePartnerId(int targetId, int partnerId) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE characters SET PartnerID=? WHERE objid=?");
			pstm.setInt(1, partnerId);
			pstm.setInt(2, targetId);
			pstm.execute();
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static void saveCharStatus(L1PcInstance pc) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE characters SET OriginalStr= ?"
					+ ", OriginalCon= ?, OriginalDex= ?, OriginalCha= ?"
					+ ", OriginalInt= ?, OriginalWis= ?" + " WHERE objid=?");
			pstm.setInt(1, pc.getOriginalStr());
			pstm.setInt(2, pc.getOriginalCon());
			pstm.setInt(3, pc.getOriginalDex());
			pstm.setInt(4, pc.getOriginalCha());
			pstm.setInt(5, pc.getOriginalInt());
			pstm.setInt(6, pc.getOriginalWis());
			pstm.setInt(7, pc.getId());
			pstm.execute();
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void restoreInventory(L1PcInstance pc) {
		pc.getInventory().loadItems();
		pc.getDwarfInventory().loadItems();
		pc.getDwarfForElfInventory().loadItems();
	}

	public static boolean doesCharNameExist(String name) {
		boolean result = true;
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT account_name FROM characters WHERE char_name=?");
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			_log.warn("could not check existing charname:" + e.getMessage());
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return result;
	}

	public void loadAllCharName() {
		L1CharName cn = null;
		String name = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM characters");
			rs = pstm.executeQuery();
			while (rs.next()) {
				cn = new L1CharName();
				name = rs.getString("char_name");
				cn.setName(name);
				cn.setId(rs.getInt("objid"));
				_charNameList.put(name, cn);
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1CharName[] getCharNameList() {
		return _charNameList.values().toArray(
				new L1CharName[_charNameList.size()]);
	}
	
	public Collection<L1PcInstance> getOfflineInZone(int castleId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Collection<L1PcInstance> offlineInZone = new ArrayList<L1PcInstance>();
		
		try {
			int[] warArea = L1CastleLocation.getWarArea(castleId);
			con = L1DatabaseFactory.getInstance().getConnection();
			int innerCastleId = L1CastleLocation.getCastleLoc(castleId)[2];
			
			pstm = con.prepareStatement("SELECT char_name FROM characters where OnlineStatus = '0' "
					+ "AND (MapId = ? OR (MapId = ? AND LocX >= ? AND LocX <= ? AND LocY >= ? AND LocY <= ?))");
			
			pstm.setInt(1, innerCastleId);
			pstm.setInt(2, warArea[4]);
			pstm.setInt(3, warArea[0]);
			pstm.setInt(4, warArea[1]);
			pstm.setInt(5, warArea[2]);
			pstm.setInt(6, warArea[3]);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				try {
					offlineInZone.add(loadCharacter(rs.getString("char_name")));
				} catch (SQLException e) {
					_log.warn(
							"Unable to get offline characters name: " + 
					e.getLocalizedMessage(), e);
				}
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
		return offlineInZone;
	}
	
	public void moveCharacter(L1PcInstance pc, int x, int y, short mapId) {
		pc.setLocation(x, y, mapId);
		
		try {
			_charStorage.storeCharacter(pc);
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	} 
}