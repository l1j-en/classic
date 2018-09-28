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
package l1j.server.server.templates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1Location;
import l1j.server.server.utils.SQLUtil;
import l1j.server.server.utils.collections.Lists;

public class L1DoorSpawn {
	private static Logger _log = LoggerFactory.getLogger(L1DoorSpawn.class.getName());
	private final int _id;
	private final L1DoorGfx _gfx;
	private final int _x;
	private final int _y;
	private final int _mapId;
	private final L1Location _loc;
	private final int _hp;
	private final int _keeper;

	public L1DoorSpawn(int id, L1DoorGfx gfx, int x, int y, int mapId, int hp,
			int keeper) {
		super();
		_id = id;
		_gfx = gfx;
		_x = x;
		_y = y;
		_mapId = mapId;
		_loc = new L1Location(_x, _y, _mapId);
		_hp = hp;
		_keeper = keeper;
	}

	public int getId() {
		return _id;
	}

	public L1DoorGfx getGfx() {
		return _gfx;
	}

	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	public int getMapId() {
		return _mapId;
	}

	public L1Location getLocation() {
		return _loc;
	}

	public int getHp() {
		return _hp;
	}

	public int getKeeper() {
		return _keeper;
	}

	public static List<L1DoorSpawn> all() {
		List<L1DoorSpawn> result = Lists.newArrayList();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM spawnlist_door");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int gfxId = rs.getInt("gfxid");
				int x = rs.getInt("locx");
				int y = rs.getInt("locy");
				int mapId = rs.getInt("mapid");
				int hp = rs.getInt("hp");
				int keeper = rs.getInt("keeper");
				L1DoorGfx gfx = L1DoorGfx.findByGfxId(gfxId);
				L1DoorSpawn spawn = new L1DoorSpawn(id, gfx, x, y, mapId, hp,
						keeper);
				result.add(spawn);
			}

		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return result;
	}
}