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
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.IdFactory;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// IdFactory

public class ClanTable {

	private static Logger _log = Logger.getLogger(ClanTable.class.getName());

	private static ClanTable _instance;

	public static ClanTable getInstance() {
		if (_instance == null) {
			_instance = new ClanTable();
		}
		return _instance;
	}

	private ClanTable() {
		{
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				con = L1DatabaseFactory.getInstance().getConnection();
				pstm = con
						.prepareStatement("SELECT * FROM clan_data ORDER BY clan_id");

				rs = pstm.executeQuery();
				while (rs.next()) {
					L1Clan clan = new L1Clan();
					// clan.SetClanId(clanData.getInt(1));
					int clan_id = rs.getInt(1);
					clan.setClanId(clan_id);
					clan.setClanName(rs.getString(2));
					clan.setLeaderId(rs.getInt(3));
					clan.setLeaderName(rs.getString(4));
					clan.setCastleId(rs.getInt(5));
					clan.setHouseId(rs.getInt(6));

					L1World.getInstance().storeClan(clan);
				}

			} catch (SQLException e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			} finally {
				SQLUtil.close(rs);
				SQLUtil.close(pstm);
				SQLUtil.close(con);
			}
		}

		Collection<L1Clan> AllClan = L1World.getInstance().getAllClans();
		for (L1Clan clan : AllClan) {
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				con = L1DatabaseFactory.getInstance().getConnection();
				pstm = con
						.prepareStatement("SELECT char_name FROM characters WHERE ClanID = ?");
				pstm.setInt(1, clan.getClanId());
				rs = pstm.executeQuery();

				while (rs.next()) {
					clan.addMemberName(rs.getString(1));
				}
			} catch (SQLException e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			} finally {
				SQLUtil.close(rs);
				SQLUtil.close(pstm);
				SQLUtil.close(con);
			}
		}
		// clan warehouse load
		for (L1Clan clan : AllClan) {
			clan.getDwarfForClanInventory().loadItems();
		}
	}

	public L1Clan createClan(L1PcInstance player, String clan_name) {
		for (L1Clan oldClans : L1World.getInstance().getAllClans()) {
			if (oldClans.getClanName().equalsIgnoreCase(clan_name)) {
				return null;
			}
		}
		L1Clan clan = new L1Clan();
		clan.setClanId(IdFactory.getInstance().nextId());
		clan.setClanName(clan_name);
		clan.setLeaderId(player.getId());
		clan.setLeaderName(player.getName());
		clan.setCastleId(0);
		clan.setHouseId(0);

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO clan_data SET clan_id=?, clan_name=?, leader_id=?, leader_name=?, hascastle=?, hashouse=?");
			pstm.setInt(1, clan.getClanId());
			pstm.setString(2, clan.getClanName());
			pstm.setInt(3, clan.getLeaderId());
			pstm.setString(4, clan.getLeaderName());
			pstm.setInt(5, clan.getCastleId());
			pstm.setInt(6, clan.getHouseId());
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}

		L1World.getInstance().storeClan(clan);

		player.setClanid(clan.getClanId());
		player.setClanname(clan.getClanName());
		player.setClanRank(L1Clan.CLAN_RANK_PRINCE);
		clan.addMemberName(player.getName());
		try {
			// DB
			player.save();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return clan;
	}

	public void updateClan(L1Clan clan) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE clan_data SET clan_id=?, leader_id=?, leader_name=?, hascastle=?, hashouse=? WHERE clan_name=?");
			pstm.setInt(1, clan.getClanId());
			pstm.setInt(2, clan.getLeaderId());
			pstm.setString(3, clan.getLeaderName());
			pstm.setInt(4, clan.getCastleId());
			pstm.setInt(5, clan.getHouseId());
			pstm.setString(6, clan.getClanName());
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void deleteClan(String clan_name) {
		L1Clan clan = L1World.getInstance().getClan(clan_name);
		if (clan == null) {
			return;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM clan_data WHERE clan_name=?");
			pstm.setString(1, clan_name);
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		clan.getDwarfForClanInventory().clearItems();
		clan.getDwarfForClanInventory().deleteAllItems();

		L1World.getInstance().removeClan(clan);
	}

}
