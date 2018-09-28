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

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.utils.SQLUtil;

public class L1CheckPcItem {

	private int itemId;
	private boolean isStackable = false;

	public L1CheckPcItem() {
	}

	public boolean checkPcItem(L1ItemInstance item, L1PcInstance pc) {
		itemId = item.getItem().getItemId();
		int itemCount = item.getCount();
		boolean isCheat = false;

		if ((findWeapon() || findArmor()) && itemCount != 1) {
			isCheat = true;
		} else if (findEtcitem()) {
			if (!isStackable && itemCount != 1) {
				isCheat = true;
			} else if ((itemId == L1ItemId.ADENA)
					&& (itemCount > 2000000000 || itemCount <= 0)) {
				isCheat = true;
			} else if (isStackable && itemId != 40308
					&& (itemCount > 1000000000 || itemCount <= 0)) {
				isCheat = true;
			}
		}
		if (isCheat) {
			pc.getInventory().removeItem(item, itemCount);
		}
		return isCheat;
	}

	private boolean findWeapon() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean inWeapon = false;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM weapon WHERE item_id = ?");
			pstm.setInt(1, itemId);
			rs = pstm.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					inWeapon = true;
				}
			}
		} catch (Exception e) {
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return inWeapon;
	}

	private boolean findArmor() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean inArmor = false;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM armor WHERE item_id = ?");
			pstm.setInt(1, itemId);
			rs = pstm.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					inArmor = true;
				}
			}
		} catch (Exception e) {
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return inArmor;
	}

	private boolean findEtcitem() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean inEtcitem = false;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM etcitem WHERE item_id = ?");
			pstm.setInt(1, itemId);
			rs = pstm.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					inEtcitem = true;
					isStackable = rs.getInt("stackable") == 1 ? true : false;
				}
			}
		} catch (Exception e) {
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return inEtcitem;
	}
}