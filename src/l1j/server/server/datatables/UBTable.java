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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1UltimateBattle;
import l1j.server.server.utils.SQLUtil;

public class UBTable {
	private static Logger _log = LoggerFactory.getLogger(UBTable.class.getName());
	private static UBTable _instance = new UBTable();
	private HashMap<Integer, L1UltimateBattle> _ub = new HashMap<Integer, L1UltimateBattle>();

	public static UBTable getInstance() {
		return _instance;
	}

	private UBTable() {
		loadTable();
	}

	private void loadTable() {
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM ub_settings");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1UltimateBattle ub = new L1UltimateBattle();
				ub.setUbId(rs.getInt("ub_id"));
				ub.setMapId(rs.getShort("ub_mapid"));
				ub.setUbName(rs.getString("ub_name"));
				ub.setLocX1(rs.getInt("ub_area_x1"));
				ub.setLocY1(rs.getInt("ub_area_y1"));
				ub.setLocX2(rs.getInt("ub_area_x2"));
				ub.setLocY2(rs.getInt("ub_area_y2"));
				ub.setMinLevel(rs.getInt("min_lvl"));
				ub.setMaxLevel(rs.getInt("max_lvl"));
				ub.setMaxPlayer(rs.getInt("max_player"));
				ub.setEnterRoyal(rs.getBoolean("enter_royal"));
				ub.setEnterKnight(rs.getBoolean("enter_knight"));
				ub.setEnterMage(rs.getBoolean("enter_mage"));
				ub.setEnterElf(rs.getBoolean("enter_elf"));
				ub.setEnterDarkelf(rs.getBoolean("enter_darkelf"));
				ub.setEnterDragonKnight(rs.getBoolean("enter_dragonknight"));
				ub.setEnterIllusionist(rs.getBoolean("enter_illusionist"));
				ub.setEnterMale(rs.getBoolean("enter_male"));
				ub.setEnterFemale(rs.getBoolean("enter_female"));
				ub.setUsePot(rs.getBoolean("use_pot"));
				ub.setHpr(rs.getInt("hpr_bonus"));
				ub.setMpr(rs.getInt("mpr_bonus"));
				ub.resetLoc();
				_ub.put(ub.getUbId(), ub);
			}
		} catch (SQLException e) {
			_log.warn("ubsettings couldnt be initialized:" + e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
		}
		// ub_managers load
		try {
			pstm = con.prepareStatement("SELECT * FROM ub_managers");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1UltimateBattle ub = getUb(rs.getInt("ub_id"));
				if (ub != null) {
					ub.addManager(rs.getInt("ub_manager_npc_id"));
				}
			}
		} catch (SQLException e) {
			_log.warn("ub_managers couldnt be initialized:" + e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
		}
		// ub_times load
		try {
			pstm = con.prepareStatement("SELECT * FROM ub_times");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1UltimateBattle ub = getUb(rs.getInt("ub_id"));
				if (ub != null) {
					ub.addUbTime(rs.getInt("ub_time"));
				}
			}
		} catch (SQLException e) {
			_log.warn("ub_times couldnt be initialized:" + e);
		} finally {
			SQLUtil.close(rs, pstm, con);
		}
		_log.info("UB List: " + _ub.size() + " Loaded");
	}

	public L1UltimateBattle getUb(int ubId) {
		return _ub.get(ubId);
	}

	public Collection<L1UltimateBattle> getAllUb() {
		return Collections.unmodifiableCollection(_ub.values());
	}

	public L1UltimateBattle getUbForNpcId(int npcId) {
		for (L1UltimateBattle ub : _ub.values()) {
			if (ub.containsManager(npcId)) {
				return ub;
			}
		}
		return null;
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
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return n;
	}
}