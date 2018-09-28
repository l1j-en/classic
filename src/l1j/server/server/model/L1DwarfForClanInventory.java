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
package l1j.server.server.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.templates.L1Item;
import l1j.server.server.utils.SQLUtil;

public class L1DwarfForClanInventory extends L1Inventory {

	private static final long serialVersionUID = 1L;
	private static Logger _log = LoggerFactory.getLogger(L1DwarfForClanInventory.class
			.getName());
	private final L1Clan _clan;

	public L1DwarfForClanInventory(L1Clan clan) {
		_clan = clan;
	}

	@Override
	public synchronized void loadItems() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM clan_warehouse WHERE clan_name = ? ORDER BY item_name");
			pstm.setString(1, _clan.getClanName());
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1ItemInstance item = new L1ItemInstance();
				int objectId = rs.getInt("id");
				item.setId(objectId);
				int itemId = rs.getInt("item_id");
				L1Item itemTemplate = ItemTable.getInstance().getTemplate(
						itemId);
				if (itemTemplate == null) {
					throw new NullPointerException("item_id=" + itemId
							+ " not found");
				}
				item.setItem(itemTemplate);
				item.setCount(rs.getInt("count"));
				item.setEquipped(false);
				item.setEnchantLevel(rs.getInt("enchantlvl"));
				item.setIdentified(rs.getInt("is_id") != 0 ? true : false);
				item.set_durability(rs.getInt("durability"));
				item.setChargeCount(rs.getInt("charge_count"));
				item.setRemainingTime(rs.getInt("remaining_time"));
				item.setLastUsed(rs.getTimestamp("last_used"));
				item.setBless(rs.getInt("bless"));
				item.setAttrEnchantKind(rs.getInt("attr_enchant_kind"));
				item.setAttrEnchantLevel(rs.getInt("attr_enchant_level"));
				item.setMagicResist(rs.getInt("m_def"));
				item.setAddHp(rs.getInt("add_hp"));
				item.setAddMp(rs.getInt("add_mp"));
				item.setAddHpRegen(rs.getInt("add_hpr"));
				item.setAddMpRegen(rs.getInt("add_mpr"));
				item.setAddSpellpower(rs.getInt("add_sp"));
				item.setWaterResist(rs.getInt("defense_water"));
				item.setWindResist(rs.getInt("defense_wind"));
				item.setFireResist(rs.getInt("defense_fire"));
				item.setEarthResist(rs.getInt("defense_earth"));
				_items.add(item);
				L1World.getInstance().storeObject(item);
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	@Override
	public synchronized void insertItem(L1ItemInstance item) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO clan_warehouse SET id = ?, clan_name = ?, item_id = ?, item_name = ?, count = ?, is_equipped=0, enchantlvl = ?, is_id= ?, durability = ?, charge_count = ?, remaining_time = ?, last_used = ?, bless = ?, attr_enchant_kind = ?, attr_enchant_level = ?, m_def = ?, add_hp = ?, add_mp = ?, add_hpr = ?, add_mpr = ?, add_sp = ?, defense_water = ?, defense_wind = ?, defense_fire = ?, defense_earth = ?");
			pstm.setInt(1, item.getId());
			pstm.setString(2, _clan.getClanName());
			pstm.setInt(3, item.getItemId());
			pstm.setString(4, item.getName());
			pstm.setInt(5, item.getCount());
			pstm.setInt(6, item.getEnchantLevel());
			pstm.setInt(7, item.isIdentified() ? 1 : 0);
			pstm.setInt(8, item.get_durability());
			pstm.setInt(9, item.getChargeCount());
			pstm.setInt(10, item.getRemainingTime());
			pstm.setTimestamp(11, item.getLastUsed());
			pstm.setInt(12, item.getBless());
			pstm.setInt(13, item.getAttrEnchantKind());
			pstm.setInt(14, item.getAttrEnchantLevel());
			pstm.setInt(15, item.getMagicResist());
			pstm.setInt(16, item.getAddHp());
			pstm.setInt(17, item.getAddMp());
			pstm.setInt(18, item.getAddHpRegen());
			pstm.setInt(19, item.getAddMpRegen());
			pstm.setInt(20, item.getAddSpellpower());
			pstm.setInt(21, item.getWaterResist());
			pstm.setInt(22, item.getWindResist());
			pstm.setInt(23, item.getFireResist());
			pstm.setInt(24, item.getEarthResist());
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	@Override
	public synchronized void updateItem(L1ItemInstance item) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE clan_warehouse SET count = ? WHERE id = ?");
			pstm.setInt(1, item.getCount());
			pstm.setInt(2, item.getId());
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	@Override
	public synchronized void deleteItem(L1ItemInstance item) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM clan_warehouse WHERE id = ?");
			pstm.setInt(1, item.getId());
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		_items.remove(_items.indexOf(item));
	}

	public synchronized void deleteAllItems() {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM clan_warehouse WHERE clan_name = ?");
			pstm.setString(1, _clan.getClanName());
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}
