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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.IdFactory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1FurnitureInstance;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.SQLUtil;

public class FurnitureSpawnTable {
	private static Logger _log = Logger.getLogger(FurnitureSpawnTable.class
			.getName());

	private static FurnitureSpawnTable _instance;

	public static FurnitureSpawnTable getInstance() {
		if (_instance == null) {
			_instance = new FurnitureSpawnTable();
		}
		return _instance;
	}

	private FurnitureSpawnTable() {
		FillFurnitureSpawnTable();
	}

	private void FillFurnitureSpawnTable() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM spawnlist_furniture");
			rs = pstm.executeQuery();
			do {
				if (!rs.next()) {
					break;
				}

				L1Npc l1npc = NpcTable.getInstance().getTemplate(rs.getInt(2));
				if (l1npc != null) {
					String s = l1npc.getImpl();
					Constructor constructor = Class.forName(
							"l1j.server.server.model.Instance." + s
									+ "Instance").getConstructors()[0];
					Object parameters[] = { l1npc };
					L1FurnitureInstance furniture = (L1FurnitureInstance) constructor
							.newInstance(parameters);
					furniture = (L1FurnitureInstance) constructor
							.newInstance(parameters);
					furniture.setId(IdFactory.getInstance().nextId());

					furniture.setItemObjId(rs.getInt(1));
					furniture.setX(rs.getInt(3));
					furniture.setY(rs.getInt(4));
					furniture.setMap((short) rs.getInt(5));
					furniture.setHomeX(furniture.getX());
					furniture.setHomeY(furniture.getY());
					furniture.setHeading(0);

					L1World.getInstance().storeObject(furniture);
					L1World.getInstance().addVisibleObject(furniture);
				}
			} while (true);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (SecurityException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (ClassNotFoundException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (IllegalArgumentException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (InstantiationException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (IllegalAccessException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (InvocationTargetException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void insertFurniture(L1FurnitureInstance furniture) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO spawnlist_furniture SET item_obj_id=?, npcid=?, locx=?, locy=?, mapid=?");
			pstm.setInt(1, furniture.getItemObjId());
			pstm.setInt(2, furniture.getNpcTemplate().get_npcId());
			pstm.setInt(3, furniture.getX());
			pstm.setInt(4, furniture.getY());
			pstm.setInt(5, furniture.getMapId());
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void deleteFurniture(L1FurnitureInstance furniture) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM spawnlist_furniture WHERE item_obj_id=?");
			pstm.setInt(1, furniture.getItemObjId());
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

}
