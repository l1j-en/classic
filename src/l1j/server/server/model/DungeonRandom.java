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

import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server.model:
// L1Teleport, L1PcInstance
public class DungeonRandom {
	private static Logger _log = LoggerFactory			.getLogger(DungeonRandom.class.getName());
	private static DungeonRandom _instance = null;

	private static Map<String, NewDungeonRandom> _dungeonMap = new HashMap<String, NewDungeonRandom>();

	public static DungeonRandom getInstance() {
		if (_instance == null) {
			_instance = new DungeonRandom();
		}
		return _instance;
	}

	private DungeonRandom() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM dungeon_random");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int srcMapId = rs.getInt("src_mapid");
				int srcX = rs.getInt("src_x");
				int srcY = rs.getInt("src_y");
				String key = new StringBuilder().append(srcMapId).append(srcX)
						.append(srcY).toString();
				int[] newX = new int[5];
				int[] newY = new int[5];
				short[] newMapId = new short[5];
				newX[0] = rs.getInt("new_x1");
				newY[0] = rs.getInt("new_y1");
				newMapId[0] = rs.getShort("new_mapid1");
				newX[1] = rs.getInt("new_x2");
				newY[1] = rs.getInt("new_y2");
				newMapId[1] = rs.getShort("new_mapid2");
				newX[2] = rs.getInt("new_x3");
				newY[2] = rs.getInt("new_y3");
				newMapId[2] = rs.getShort("new_mapid3");
				newX[3] = rs.getInt("new_x4");
				newY[3] = rs.getInt("new_y4");
				newMapId[3] = rs.getShort("new_mapid4");
				newX[4] = rs.getInt("new_x5");
				newY[4] = rs.getInt("new_y5");
				newMapId[4] = rs.getShort("new_mapid5");
				int heading = rs.getInt("new_heading");
				NewDungeonRandom newDungeonRandom = new NewDungeonRandom(newX,
						newY, newMapId, heading);
				if (_dungeonMap.containsKey(key)) {
					_log.warn(
							"List of dungeons does not contain key: " + key);
				}
				_dungeonMap.put(key, newDungeonRandom);
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private static class NewDungeonRandom {
		int[] _newX = new int[5];
		int[] _newY = new int[5];
		short[] _newMapId = new short[5];
		int _heading;

		private NewDungeonRandom(int[] newX, int[] newY, short[] newMapId,
				int heading) {
			for (int i = 0; i < 5; i++) {
				_newX[i] = newX[i];
				_newY[i] = newY[i];
				_newMapId[i] = newMapId[i];
			}
			_heading = heading;
		}
	}

	public boolean dg(int locX, int locY, int mapId, L1PcInstance pc) {
		String key = new StringBuilder().append(mapId).append(locX)
				.append(locY).toString();
		if (_dungeonMap.containsKey(key)) {
			int rnd = ThreadLocalRandom.current().nextInt(5);
			NewDungeonRandom newDungeonRandom = _dungeonMap.get(key);
			short newMap = newDungeonRandom._newMapId[rnd];
			int newX = newDungeonRandom._newX[rnd];
			int newY = newDungeonRandom._newY[rnd];
			int heading = newDungeonRandom._heading;
			pc.setSkillEffect(ABSOLUTE_BARRIER, 2000);
			pc.stopHpRegeneration();
			pc.stopMpRegeneration();
			pc.stopMpRegenerationByDoll();
			L1Teleport.teleport(pc, newX, newY, newMap, heading, true);
			return true;
		}
		return false;
	}
}