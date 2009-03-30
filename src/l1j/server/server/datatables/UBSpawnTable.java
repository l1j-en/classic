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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1UbPattern;
import l1j.server.server.model.L1UbSpawn;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.SQLUtil;

public class UBSpawnTable {
	private static Logger _log = Logger.getLogger(UBSpawnTable.class.getName());

	private static UBSpawnTable _instance;

	private HashMap<Integer, L1UbSpawn> _spawnTable = new HashMap<Integer, L1UbSpawn>();;

	public static UBSpawnTable getInstance() {
		if (_instance == null) {
			_instance = new UBSpawnTable();
		}
		return _instance;
	}

	private UBSpawnTable() {
		loadSpawnTable();
	}

	private void loadSpawnTable() {

		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM spawnlist_ub");
			rs = pstm.executeQuery();

			while (rs.next()) {
				L1Npc npcTemp = NpcTable.getInstance()
						.getTemplate(rs.getInt(6));
				if (npcTemp == null) {
					continue;
				}

				L1UbSpawn spawnDat = new L1UbSpawn();
				spawnDat.setId(rs.getInt(1));
				spawnDat.setUbId(rs.getInt(2));
				spawnDat.setPattern(rs.getInt(3));
				spawnDat.setGroup(rs.getInt(4));
				spawnDat.setName(npcTemp.get_name());
				spawnDat.setNpcTemplateId(rs.getInt(6));
				spawnDat.setAmount(rs.getInt(7));
				spawnDat.setSpawnDelay(rs.getInt(8));
				spawnDat.setSealCount(rs.getInt(9));

				_spawnTable.put(spawnDat.getId(), spawnDat);
			}
		} catch (SQLException e) {
			// problem with initializing spawn, go to next one
			_log.warn("spawn couldnt be initialized:" + e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		_log.info("UB Spawn list: " + _spawnTable.size() + " Loaded");
	}

	public L1UbSpawn getSpawn(int spawnId) {
		return _spawnTable.get(spawnId);
	}

	/**
	 * UBID pattern specified by the maximum number of returns.
	 * 
	 * @param ubId
	 *            Check UBID
	 * @return The maximum number of patterns.
	 */
	public int getMaxPattern(int ubId) {
		int n = 0;
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT MAX(pattern) FROM spawnlist_ub WHERE ub_id=?");
			pstm.setInt(1, ubId);
			rs = pstm.executeQuery();
			if (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			_log.log(Level.ERROR, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return n;
	}

	public L1UbPattern getPattern(int ubId, int patternNumer) {
		L1UbPattern pattern = new L1UbPattern();
		for (L1UbSpawn spawn : _spawnTable.values()) {
			if (spawn.getUbId() == ubId && spawn.getPattern() == patternNumer) {
				pattern.addSpawn(spawn.getGroup(), spawn);
			}
		}
		pattern.freeze();

		return pattern;
	}
}
