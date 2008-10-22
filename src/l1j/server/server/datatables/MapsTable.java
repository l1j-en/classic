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
import l1j.server.server.utils.SQLUtil;

public final class MapsTable {
	private class MapData {
		public int startX = 0;
		public int endX = 0;
		public int startY = 0;
		public int endY = 0;
		public double monster_amount = 1;
		public double dropRate = 1;
		public boolean isUnderwater = false;
		public boolean markable = false;
		public boolean teleportable = false;
		public boolean escapable = false;
		public boolean isUseResurrection = false;
		public boolean isUsePainwand = false;
		public boolean isEnabledDeathPenalty = false;
		public boolean isTakePets = false;
		public boolean isRecallPets = false;
		public boolean isUsableItem = false;   
		public boolean isUsableSkill = false; 
	}

	private static Logger _log = Logger.getLogger(MapsTable.class.getName());

	private static MapsTable _instance;

	/**
	 * Key to map ID, Value teleport to whether the flag is stored in the HashMap
	 */
	private final Map<Integer, MapData> _maps = new HashMap<Integer, MapData>();

	/**
	 * MapsTable new object, whether Teleport flag to read the map.
	 */
	private MapsTable() {
		loadMapsFromDatabase();
	}

	/**
	 * Teleport whether the flag map reading from the database, HashMap _maps stored.
	 */
	private void loadMapsFromDatabase() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM mapids");

			for (rs = pstm.executeQuery(); rs.next();) {
				MapData data = new MapData();
				int mapId = rs.getInt("mapid");
				// rs.getString("locationname");
				data.startX = rs.getInt("startX");
				data.endX = rs.getInt("endX");
				data.startY = rs.getInt("startY");
				data.endY = rs.getInt("endY");
				data.monster_amount = rs.getDouble("monster_amount");
				data.dropRate = rs.getDouble("drop_rate");
				data.isUnderwater = rs.getBoolean("underwater");
				data.markable = rs.getBoolean("markable");
				data.teleportable = rs.getBoolean("teleportable");
				data.escapable = rs.getBoolean("escapable");
				data.isUseResurrection = rs.getBoolean("resurrection");
				data.isUsePainwand = rs.getBoolean("painwand");
				data.isEnabledDeathPenalty = rs.getBoolean("penalty");
				data.isTakePets = rs.getBoolean("take_pets");
				data.isRecallPets = rs.getBoolean("recall_pets");
				data.isUsableItem = rs.getBoolean("usable_item");  
				data.isUsableSkill = rs.getBoolean("usable_skill"); 
				_maps.put(new Integer(mapId), data);
			}

			_log.config("Maps " + _maps.size());
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	/**
	 * MapsTable Instances of return.
	 * 
	 * @return MapsTable Instances
	 */
	public static MapsTable getInstance() {
		if (_instance == null) {
			_instance = new MapsTable();
		}
		return _instance;
	}

	/**
	 * getStartX
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * @return X Coordinate start
	 */
	public int getStartX(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return 0;
		}
		return _maps.get(mapId).startX;
	}

	/**
	 * X ends of the map coordinates are returned.
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * @return X Coordinate quit
	 */
	public int getEndX(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return 0;
		}
		return _maps.get(mapId).endX;
	}

	/**
	 * Y coordinates of the map is starting to return.
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * @return Y Coordinate start
	 */
	public int getStartY(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return 0;
		}
		return _maps.get(mapId).startY;
	}

	/**
	 * Y coordinates to the end of the map is returned.
	 * 
	 * @param mapId
	 *        	Map examine the map ID
	 * @return Y 	Coordinate quit
	 */
	public int getEndY(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return 0;
		}
		return _maps.get(mapId).endY;
	}

	/**
	 * Map of monsters to return the amount of magnification
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * @return Monster amount of magnification
	 */
	public double getMonsterAmount(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return 0;
		}
		return map.monster_amount;
	}

	/**
	 * Map ratio drop to return
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * @return Drop-magnification
	 */
	public double getDropRate(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return 0;
		}
		return map.dropRate;
	}

	/**
	 * Map of the water is going to be returned.
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * 
	 * @return if is underwater true
	 */
	public boolean isUnderwater(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).isUnderwater;
	}

	/**
	 * is map bookmarkable
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * @return if bookmarkable true
	 */
	public boolean isMarkable(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).markable;
	}

	/**
	 * returns if tele true
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * @return if tele true
	 */
	public boolean isTeleportable(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).teleportable;
	}

	/**
	 * returns if escable
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * @return if esc true
	 */
	public boolean isEscapable(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).escapable;
	}

	/**
	 * Map, or returns can be revived.
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * 
	 * @return If possible res true
	 */
	public boolean isUseResurrection(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).isUseResurrection;
	}

	/**
	 * Maps, available pine wand is going to be returned.
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * 
	 * @return If possible, use pine wand true
	 */
	public boolean isUsePainwand(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).isUsePainwand;
	}

	/**
	 * Map, but if you have a death penalty returned.
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * 
	 * @return if death penalty true
	 */
	public boolean isEnabledDeathPenalty(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).isEnabledDeathPenalty;
	}

	/**
	 * Map of the Summon with a pet can go to return.
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * 
	 * @return Summon with a pet can go if true
	 */
	public boolean isTakePets(int mapId) {
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).isTakePets;
	}

	/**
	 * Map is a pet or to call summon returns.
	 * 
	 * @param mapId
	 *            Map examine the map ID
	 * 
	 * @return If the pet to call summon true
	 */
	public boolean isRecallPets(int mapId) 
	{
		MapData map = _maps.get(mapId);
		if (map == null) {
			return false;
		}
		return _maps.get(mapId).isRecallPets;
	}
	
	public boolean isUsableItem(int mapId)  
	{   
		MapData map = _maps.get(mapId);  
		if (map == null) {   
			return false;   
			}   
		return _maps.get(mapId).isUsableItem;   
		}  
	
	public boolean isUsableSkill(int mapId)  
	{  
		MapData map = _maps.get(mapId);   
		if (map == null) {   
			return false;   
			}   
		return _maps.get(mapId).isUsableSkill;   
		}   
	} 
