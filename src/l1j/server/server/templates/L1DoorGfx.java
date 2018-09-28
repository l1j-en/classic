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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

public class L1DoorGfx {
	private static Logger _log = LoggerFactory.getLogger(L1DoorGfx.class.getName());
	private final int _gfxId;
	private final int _direction;
	private final int _rightEdgeOffset;
	private final int _leftEdgeOffset;

	private L1DoorGfx(int gfxId, int direction, int rightEdgeOffset,
			int leftEdgeOffset) {
		_gfxId = gfxId;
		_direction = direction;
		_rightEdgeOffset = rightEdgeOffset;
		_leftEdgeOffset = leftEdgeOffset;
	}

	public int getGfxId() {
		return _gfxId;
	}

	public int getDirection() {
		return _direction;
	}

	public int getRightEdgeOffset() {
		return _rightEdgeOffset;
	}

	public int getLeftEdgeOffset() {
		return _leftEdgeOffset;
	}

	/**
	 * @param gfxId
	 * @return
	 */
	public static L1DoorGfx findByGfxId(int gfxId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM door_gfxs WHERE gfxid = ?");
			pstm.setInt(1, gfxId);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				return null;
			}
			int id = rs.getInt("gfxid");
			int dir = rs.getInt("direction");
			int rEdge = rs.getInt("right_edge_offset");
			int lEdge = rs.getInt("left_edge_offset");
			return new L1DoorGfx(id, dir, rEdge, lEdge);
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return null;
	}
}