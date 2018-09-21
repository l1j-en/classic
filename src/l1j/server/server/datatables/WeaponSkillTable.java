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
import l1j.server.server.model.L1WeaponSkill;
import l1j.server.server.utils.SQLUtil;

public class WeaponSkillTable {
	private static Logger _log = LoggerFactory.getLogger(WeaponSkillTable.class
			.getName());
	private static WeaponSkillTable _instance;
	private final HashMap<Integer, L1WeaponSkill> _weaponIdIndex = new HashMap<Integer, L1WeaponSkill>();

	public static WeaponSkillTable getInstance() {
		if (_instance == null) {
			_instance = new WeaponSkillTable();
		}
		return _instance;
	}

	private WeaponSkillTable() {
		loadWeaponSkill();
	}

	private void loadWeaponSkill() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM weapon_skill");
			rs = pstm.executeQuery();
			fillWeaponSkillTable(rs);
		} catch (SQLException e) {
			_log.error("error while creating weapon_skill table", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void fillWeaponSkillTable(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int weaponId = rs.getInt("weapon_id");
			int probability = rs.getInt("probability");
			int fixDamage = rs.getInt("fix_damage");
			int randomDamage = rs.getInt("random_damage");
			int area = rs.getInt("area");
			int skillId = rs.getInt("skill_id");
			int skillTime = rs.getInt("skill_time");
			int effectId = rs.getInt("effect_id");
			int effectTarget = rs.getInt("effect_target");
			boolean isArrowType = rs.getBoolean("arrow_type");
			int attr = rs.getInt("attr");
			L1WeaponSkill weaponSkill = new L1WeaponSkill(weaponId,
					probability, fixDamage, randomDamage, area, skillId,
					skillTime, effectId, effectTarget, isArrowType, attr);
			_weaponIdIndex.put(weaponId, weaponSkill);
		}
		_log.info("List of weapons skills: " + _weaponIdIndex.size()
				+ " Loaded");
	}

	public L1WeaponSkill getTemplate(int weaponId) {
		return _weaponIdIndex.get(weaponId);
	}
}