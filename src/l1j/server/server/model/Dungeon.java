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
package l1j.server.server.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server.model:
// L1Teleport, L1PcInstance

public class Dungeon {

	private static Logger _log = Logger.getLogger(Dungeon.class.getName());

	private static Dungeon _instance = null;

	private static Map<String, NewDungeon> _dungeonMap = new HashMap<String, NewDungeon>();

	private enum DungeonType {
		NONE, SHIP_FOR_FI, SHIP_FOR_HEINE, SHIP_FOR_PI, SHIP_FOR_HIDDENDOCK
	};

	public static Dungeon getInstance() {
		if (_instance == null) {
			_instance = new Dungeon();
		}
		return _instance;
	}

	private Dungeon() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();

			pstm = con.prepareStatement("SELECT * FROM dungeon");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int srcMapId = rs.getInt("src_mapid");
				int srcX = rs.getInt("src_x");
				int srcY = rs.getInt("src_y");
				String key = new StringBuilder().append(srcMapId).append(srcX)
						.append(srcY).toString();
				int newX = rs.getInt("new_x");
				int newY = rs.getInt("new_y");
				int newMapId = rs.getInt("new_mapid");
				int heading = rs.getInt("new_heading");
				DungeonType dungeonType = DungeonType.NONE;
				if (srcX == 33423 && srcY == 33502 && srcMapId == 4 // Heine landing -> FI-bound ship
						|| srcX == 32735 && srcY == 32794 && srcMapId == 83) { // FI Steamer -> landing Heine
					dungeonType = DungeonType.SHIP_FOR_FI;
				} else if (srcX == 32936 && srcY == 33058 && srcMapId == 70 // FI Landing -> Heine-bound ship
						|| srcX == 32732 && srcY == 32796 && srcMapId == 84) { // Heine-bound ship -> FI landing
					dungeonType = DungeonType.SHIP_FOR_HEINE;
				} else if (srcX == 32750 && srcY == 32874 && srcMapId == 445 // Hidden landing -> pirate ship bound for the island
						|| srcX == 32732 && srcY == 32796 && srcMapId == 447) { // Pirate ship bound for the island -> hidden landing
					dungeonType = DungeonType.SHIP_FOR_PI;
				} else if (srcX == 32297 && srcY == 33087 && srcMapId == 440 // Pirate Island landing -> hidden in a ship bound for landing
						|| srcX == 32735 && srcY == 32794 && srcMapId == 446) { // Take the hidden landing ship -> pirate island landing
					dungeonType = DungeonType.SHIP_FOR_HIDDENDOCK;
				}
				NewDungeon newDungeon = new NewDungeon(newX, newY,
						(short) newMapId, heading, dungeonType);
				if (_dungeonMap.containsKey(key)) {
					_log.log(Level.WARNING, "Dungeon exists for the same key data. key=" + key);
				}
				_dungeonMap.put(key, newDungeon);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private static class NewDungeon {
		int _newX;
		int _newY;
		short _newMapId;
		int _heading;
		DungeonType _dungeonType;

		private NewDungeon(int newX, int newY, short newMapId, int heading,
				DungeonType dungeonType) {
			_newX = newX;
			_newY = newY;
			_newMapId = newMapId;
			_heading = heading;
			_dungeonType = dungeonType;

		}
	}

	public boolean dg(int locX, int locY, int mapId, L1PcInstance pc) {
		int servertime = L1GameTimeClock.getInstance().getGameTime()
				.getSeconds();
		int nowtime = servertime % 86400;
		String key = new StringBuilder().append(mapId).append(locX)
				.append(locY).toString();
		if (_dungeonMap.containsKey(key)) {
			NewDungeon newDungeon = _dungeonMap.get(key);
			short newMap = newDungeon._newMapId;
			int newX = newDungeon._newX;
			int newY = newDungeon._newY;
			int heading = newDungeon._heading;
			DungeonType dungeonType = newDungeon._dungeonType;
			boolean teleportable = false;

			if (dungeonType == DungeonType.NONE) {
				teleportable = true;
			} else if (dungeonType == DungeonType.SHIP_FOR_FI) { 
				if ((nowtime >= 0 && nowtime < 60 * 60 // 0~1 
						|| nowtime >= 180 * 60 && nowtime < 240 * 60 // 3~4 
						|| nowtime >= 360 * 60 && nowtime < 420 * 60 // 6~7 
						|| nowtime >= 540 * 60 && nowtime < 600 * 60 // 9~10 
						|| nowtime >= 720 * 60 && nowtime < 780 * 60 // 12~13 
						|| nowtime >= 900 * 60 && nowtime < 960 * 60 // 15~16 
						|| nowtime >= 1080 * 60 && nowtime < 1140 * 60 // 18~19 
						|| nowtime >= 1260 * 60 && nowtime < 1320 * 60 // 21~22 
						) && pc.getInventory().checkItem(40300, 1)) {
					teleportable = true;
				}
			} else if (dungeonType == DungeonType.SHIP_FOR_HEINE) {
				if ((nowtime >= 90 * 60 && nowtime < 150 * 60 // 1.30~2.30 
						|| nowtime >= 270 * 60 && nowtime < 330 * 60 // 4.30~5.30 
						|| nowtime >= 450 * 60 && nowtime < 510 * 60 // 7.30~8.30 
						|| nowtime >= 630 * 60 && nowtime < 690 * 60 // 10.30~11.30 
						|| nowtime >= 810 * 60 && nowtime < 870 * 60 // 13.30~14.30 
						|| nowtime >= 990 * 60 && nowtime < 1050 * 60 // 16.30~17.30 
						|| nowtime >= 1170 * 60 && nowtime < 1230 * 60 // 19.30~20.30 
						|| nowtime >= 1350 * 60 && nowtime < 1410 * 60 // 22.30~23.30 
						) && pc.getInventory().checkItem(40301, 1)) {
					teleportable = true;
				}
			} else if (dungeonType == DungeonType.SHIP_FOR_PI) {
				if ((nowtime >= 90 * 60 && nowtime < 150 * 60 // 1.30~2.30 
						|| nowtime >= 270 * 60 && nowtime < 330 * 60 // 4.30~5.30 
						|| nowtime >= 450 * 60 && nowtime < 510 * 60 // 7.30~8.30 
						|| nowtime >= 630 * 60 && nowtime < 690 * 60 // 10.30~11.30 
						|| nowtime >= 810 * 60 && nowtime < 870 * 60 // 13.30~14.30 
						|| nowtime >= 990 * 60 && nowtime < 1050 * 60 // 16.30~17.30 
						|| nowtime >= 1170 * 60 && nowtime < 1230 * 60 // 19.30~20.30 
						|| nowtime >= 1350 * 60 && nowtime < 1410 * 60 // 22.30~23.30 
						) && pc.getInventory().checkItem(40302, 1)) {
					teleportable = true;
				}
			} else if (dungeonType == DungeonType.SHIP_FOR_HIDDENDOCK) { 
				if ((nowtime >= 0 && nowtime < 60 * 60 // 0~1 
						|| nowtime >= 180 * 60 && nowtime < 240 * 60 // 3~4 
						|| nowtime >= 360 * 60 && nowtime < 420 * 60 // 6~7 
						|| nowtime >= 540 * 60 && nowtime < 600 * 60 // 9~10 
						|| nowtime >= 720 * 60 && nowtime < 780 * 60 // 12~13 
						|| nowtime >= 900 * 60 && nowtime < 960 * 60 // 15~16 
						|| nowtime >= 1080 * 60 && nowtime < 1140 * 60 // 18~19 
						|| nowtime >= 1260 * 60 && nowtime < 1320 * 60 // 21~22 
						) && pc.getInventory().checkItem(40303, 1)) {
					teleportable = true;
				}
			}
			if (teleportable) {
				// 2 seconds of invincibility
				pc.setSkillEffect(L1SkillId.ABSOLUTE_BARRIER, 2000);
				pc.stopHpRegeneration();
				pc.stopMpRegeneration();
				pc.stopMpRegenerationByDoll();
				L1Teleport.teleport(pc, newX, newY, newMap, heading, true);
				return true;
			}
		}
		return false;
	}
}
