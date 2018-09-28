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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.templates.L1MobGroup;
import l1j.server.server.templates.L1NpcCount;
import l1j.server.server.utils.SQLUtil;
import l1j.server.server.utils.collections.Lists;

public class MobGroupTable {
	private static Logger _log = LoggerFactory			.getLogger(MobGroupTable.class.getName());
	private static MobGroupTable _instance;
	private final HashMap<Integer, L1MobGroup> _mobGroupIndex = new HashMap<Integer, L1MobGroup>();

	public static MobGroupTable getInstance() {
		if (_instance == null) {
			_instance = new MobGroupTable();
		}
		return _instance;
	}

	private MobGroupTable() {
		loadMobGroup();
	}

	private void loadMobGroup() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM mobgroup");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int mobGroupId = rs.getInt("id");
				boolean isRemoveGroup = (rs
						.getBoolean("remove_group_if_leader_die"));
				int leaderId = rs.getInt("leader_id");
				List<L1NpcCount> minions = Lists.newArrayList();
				for (int i = 1; i <= 7; i++) {
					int id = rs.getInt("minion" + i + "_id");
					int count = rs.getInt("minion" + i + "_count");
					minions.add(new L1NpcCount(id, count));
				}
				L1MobGroup mobGroup = new L1MobGroup(mobGroupId, leaderId,
						minions, isRemoveGroup);
				_mobGroupIndex.put(mobGroupId, mobGroup);
			}
			_log.info("Mob Group Lists: " + _mobGroupIndex.size()
					+ " loaded.");
		} catch (SQLException e) {
			_log.error("error while creating mobgroup table", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1MobGroup getTemplate(int mobGroupId) {
		return _mobGroupIndex.get(mobGroupId);
	}
}