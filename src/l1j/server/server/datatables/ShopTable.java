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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.shop.L1Shop;
import l1j.server.server.templates.L1ShopItem;
import l1j.server.server.utils.SQLUtil;

public class ShopTable {
	private static final long serialVersionUID = 1L;
	private static Logger _log = Logger.getLogger(ShopTable.class.getName());
	private static ShopTable _instance;
	private final Map<Integer, L1Shop> _allShops = new HashMap<Integer, L1Shop>();

	public static ShopTable getInstance() {
		if (_instance == null) {
			_instance = new ShopTable();
		}
		return _instance;
	}

	private ShopTable() {
		loadShops();
	}

	private ArrayList<Integer> enumNpcIds() {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT DISTINCT npc_id FROM shop");
			rs = pstm.executeQuery();
			while (rs.next()) {
				ids.add(rs.getInt("npc_id"));
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs, pstm, con);
		}
		return ids;
	}

	private L1Shop loadShop(int npcId, ResultSet rs) throws SQLException {
		List<L1ShopItem> sellingList = new ArrayList<L1ShopItem>();
		List<L1ShopItem> purchasingList = new ArrayList<L1ShopItem>();
		while (rs.next()) {
			int itemId = rs.getInt("item_id");
			int sellingPrice = rs.getInt("selling_price");
			int purchasingPrice = rs.getInt("purchasing_price");
			int packCount = rs.getInt("pack_count");
			packCount = packCount == 0 ? 1 : packCount;
			if (0 <= sellingPrice) {
				L1ShopItem item = new L1ShopItem(itemId, sellingPrice, packCount);
				sellingList.add(item);
			}
			if (0 <= purchasingPrice) {
				L1ShopItem item = new L1ShopItem(itemId, purchasingPrice, packCount);
				purchasingList.add(item);
			}
		}
		return new L1Shop(npcId, sellingList, purchasingList);
	}

	public void loadShops() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM shop WHERE npc_id=? ORDER BY order_id");
			for (int npcId : enumNpcIds()) {
				pstm.setInt(1, npcId);
				rs = pstm.executeQuery();
				L1Shop shop = loadShop(npcId, rs);
				_allShops.put(npcId, shop);
				rs.close();
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs, pstm, con);
		}
	}

	public void updOrder(int npc_id, int item_id, int order_id) {
		try {
			Connection connection = null;
			connection = L1DatabaseFactory.getInstance().getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement("UPDATE `shop` SET `order_id`=? WHERE `npc_id`=? AND `item_id`=?");
			preparedstatement.setInt(1, order_id);
			preparedstatement.setInt(2, npc_id);
			preparedstatement.setInt(3, item_id);
			preparedstatement.execute();		
			preparedstatement.close();
			connection.close();
		    }catch(Exception e){
			System.out.println("ShopTable cannot be updated correctly.");
		}
	}

	public void InsertItem(int npcid, int itemid, int order) {
		int maxorder = 0;
		L1Shop target_shop = get(npcid);
		for (int i = 0; i <target_shop.getSellingItems().size(); i++){
			if(order == -1){
				if((target_shop.getSellingItems().size() -1) > maxorder)
					maxorder = target_shop.getSellingItems().size();
			} else {
				maxorder = order;
				if((target_shop.getSellingItems().size() -1) >= order){
					updOrder(npcid,target_shop.getSellingItems().get(i).getItemId(), i);
				}
			}
		}
		
		try {
			Connection con = L1DatabaseFactory.getInstance().getConnection();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO `shop` (`npc_id`,`item_id`,`order_id`,`pack_count`,`purchasing_price`) VALUES(?,?,?,?,?)");
			pstmt.setInt(1, npcid);
			pstmt.setInt(2, itemid);
			pstmt.setInt(3, maxorder);
			pstmt.setInt(4, 1);
			pstmt.execute();
			con.close();
			pstmt.close();
		}catch(Exception e){
			_log.warning("Can't insert item into the shop" + e);
		}
	}

	public L1Shop get(int npcId) {
		return _allShops.get(npcId);
	}
}