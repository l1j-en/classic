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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.templates.L1PetType;
import l1j.server.server.utils.IntRange;
import l1j.server.server.utils.SQLUtil;

public class PetTypeTable {
	private static PetTypeTable _instance;
	private static Logger _log = Logger.getLogger(PetTypeTable.class.getName());
	private Map<Integer, L1PetType> _types = new HashMap<Integer, L1PetType>();
	private Set<String> _defaultNames = new HashSet<String>();

	public static void load() {
		_instance = new PetTypeTable();
	}

	public static PetTypeTable getInstance() {
		return _instance;
	}

	private PetTypeTable() {
		loadTypes();
	}

	private void loadTypes() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM pettypes");

			rs = pstm.executeQuery();

			while (rs.next()) {
				int baseNpcId = rs.getInt("BaseNpcId");
				String name = rs.getString("Name");
				int itemIdForTaming = rs.getInt("ItemIdForTaming");
				int hpUpMin = rs.getInt("HpUpMin");
				int hpUpMax = rs.getInt("HpUpMax");
				int mpUpMin = rs.getInt("MpUpMin");
				int mpUpMax = rs.getInt("MpUpMax");
				int npcIdForEvolving = rs.getInt("NpcIdForEvolving");
				int msgIds[] = new int[5];
				for (int i = 0; i < 5; i++) {
					msgIds[i] = rs.getInt("MessageId" + (i + 1));
				}
				int defyMsgId = rs.getInt("DefyMessageId");
				IntRange hpUpRange = new IntRange(hpUpMin, hpUpMax);
				IntRange mpUpRange = new IntRange(mpUpMin, mpUpMax);
				_types.put(baseNpcId, new L1PetType(baseNpcId, name,
						itemIdForTaming, hpUpRange, mpUpRange,
						npcIdForEvolving, msgIds, defyMsgId));
				_defaultNames.add(name.toLowerCase());
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1PetType get(int baseNpcId) {
		return _types.get(baseNpcId);
	}

	public boolean isNameDefault(String name) {
		return _defaultNames.contains(name.toLowerCase());
	}
}
