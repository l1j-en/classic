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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.utils.SQLUtil;

public class PolyTable {
	private static Logger _log = LoggerFactory.getLogger(PolyTable.class.getName());
	private static PolyTable _instance;
	private final HashMap<String, L1PolyMorph> _polymorphs = new HashMap<String, L1PolyMorph>();
	private final HashMap<Integer, L1PolyMorph> _polyIdIndex = new HashMap<Integer, L1PolyMorph>();

	public static PolyTable getInstance() {
		if (_instance == null) {
			_instance = new PolyTable();
		}
		return _instance;
	}

	private PolyTable() {
		loadPolymorphs();
	}

	private void loadPolymorphs() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM polymorphs");
			rs = pstm.executeQuery();
			fillPolyTable(rs);
		} catch (SQLException e) {
			_log.error("error while creating polymorph table", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void fillPolyTable(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int gfxId = rs.getInt("gfx_id");
			int minLevel = rs.getInt("min_level");
			int weaponEquipFlg = rs.getInt("weapon_equip");
			int armorEquipFlg = rs.getInt("armor_equip");
			boolean canUseSkill = rs.getBoolean("can_use_skill");
			int causeFlg = rs.getInt("cause");
			L1PolyMorph poly = new L1PolyMorph(id, name, gfxId, minLevel,
					weaponEquipFlg, armorEquipFlg, canUseSkill, causeFlg);

			_polymorphs.put(name, poly);
			_polyIdIndex.put(gfxId, poly);
		}
		_log.info("Polymorphs List: " + _polymorphs.size() + " Loaded");
	}
	
	public HashMap<String, L1PolyMorph> getAllPolymorphs() {
		return _polymorphs;
	}

	public L1PolyMorph getTemplate(String name) {
		return _polymorphs.get(name);
	}

	public L1PolyMorph getTemplate(int polyId) {
		return _polyIdIndex.get(polyId);
	}
}