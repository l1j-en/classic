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
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.templates.L1Skill;
import l1j.server.server.utils.SQLUtil;
import l1j.server.server.utils.collections.Lists;
import l1j.server.server.utils.collections.Maps;

public class SkillTable {

	private static Logger _log = Logger.getLogger(SkillTable.class.getName());

	private static SkillTable _instance;

	private final Map<Integer, L1Skill> _skills = Maps.newHashMap();

	private final List<Integer> _buffSkillIds;

	public static void initialize() {
		if (_instance != null) {
			throw new IllegalStateException(
					"Already SkillTable has been initialized.");
		}
		_instance = new SkillTable();
	}

	public static SkillTable getInstance() {
		return _instance;
	}

	private SkillTable() {
		loadSkills();
		_buffSkillIds = cacheBuffSkillIds();
	}

	private void loadSkills() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM skills");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1Skill skill = L1Skill.fromResultSet(rs);
				_skills.put(skill.getSkillId(), skill);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Unable to load SkillTable.", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private List<Integer> cacheBuffSkillIds() {
		List<Integer> result = Lists.newArrayList();
		for (L1Skill skill : _skills.values()) {
			if (skill.isBuff()) {
				result.add(skill.getSkillId());
			}
		}
		return result;
	}

	public void spellMastery(int playerobjid, int skillid, String skillname,
			int active, int time) {
		if (spellCheck(playerobjid, skillid)) {
			return;
		}
		L1PcInstance pc = (L1PcInstance) L1World.getInstance().findObject(
				playerobjid);
		if (pc != null) {
			pc.setSkillMastery(skillid);
		}

		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO character_skills SET char_obj_id=?, skill_id=?, skill_name=?, is_active=?, activetimeleft=?");
			pstm.setInt(1, playerobjid);
			pstm.setInt(2, skillid);
			pstm.setString(3, skillname);
			pstm.setInt(4, active);
			pstm.setInt(5, time);
			pstm.execute();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);

		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void spellLost(int playerobjid, int skillid) {
		L1PcInstance pc = (L1PcInstance) L1World.getInstance().findObject(
				playerobjid);
		if (pc != null) {
			pc.removeSkillMastery(skillid);
		}

		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM character_skills WHERE char_obj_id=? AND skill_id=?");
			pstm.setInt(1, playerobjid);
			pstm.setInt(2, skillid);
			pstm.execute();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);

		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public boolean spellCheck(int playerobjid, int skillid) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM character_skills WHERE char_obj_id=? AND skill_id=?");
			pstm.setInt(1, playerobjid);
			pstm.setInt(2, skillid);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);

		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return false;
	}

	public L1Skill findBySkillId(int skillId) {
		return _skills.get(skillId);
	}

	public L1Skill findByItemName(String itemName) {
		String skillName = itemName.replaceFirst("^.*\\((.+)\\).*$", "$1");
		for (L1Skill skill : _skills.values()) {
			if (skill.getName().equalsIgnoreCase(skillName)) {
				return skill;
			}
		}
		return null;
	}

	public List<Integer> findBuffSkillIds() {
		return Lists.newArrayList(_buffSkillIds);
	}
}
