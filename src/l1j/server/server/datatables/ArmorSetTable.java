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
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.templates.L1ArmorSets;
import l1j.server.server.utils.SQLUtil;

public class ArmorSetTable {
	private static Logger _log = Logger.getLogger(ArmorSetTable.class
			.getName());

	private static ArmorSetTable _instance;

	private final ArrayList<L1ArmorSets> _armorSetList
			= new ArrayList<L1ArmorSets>();

	public static ArmorSetTable getInstance() {
		if (_instance == null) {
			_instance = new ArmorSetTable();
		}
		return _instance;
	}

	private ArmorSetTable() {
		load();
	}

	private void load() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM armor_set");
			rs = pstm.executeQuery();
			fillTable(rs);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, "error while creating armor_set table",
					e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void fillTable(ResultSet rs) throws SQLException {
		while (rs.next()) {
			L1ArmorSets as = new L1ArmorSets();
			as.setId(rs.getInt("id"));
			as.setSets(rs.getString("sets"));
			as.setPolyId(rs.getInt("polyid"));
			as.setAc(rs.getInt("ac"));
			as.setHp(rs.getInt("hp"));
			as.setMp(rs.getInt("mp"));
			as.setHpr(rs.getInt("hpr"));
			as.setMpr(rs.getInt("mpr"));
			as.setMr(rs.getInt("mr"));
			as.setStr(rs.getInt("str"));
			as.setDex(rs.getInt("dex"));
			as.setCon(rs.getInt("con"));
			as.setWis(rs.getInt("wis"));
			as.setCha(rs.getInt("cha"));
			as.setIntl(rs.getInt("intl"));
			as.setDefenseWater(rs.getInt("defense_water"));
			as.setDefenseWind(rs.getInt("defense_wind"));
			as.setDefenseFire(rs.getInt("defense_fire"));
			as.setDefenseEarth(rs.getInt("defense_earth"));

			_armorSetList.add(as);
		}
	}

	public L1ArmorSets[] getAllList() {
		return _armorSetList.toArray(new L1ArmorSets[_armorSetList.size()]);
	}

}
