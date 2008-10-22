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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.IdFactory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.SQLUtil;

public class DoorSpawnTable {
	private static Logger _log = Logger.getLogger(DoorSpawnTable.class.getName());

	private static DoorSpawnTable _instance;

	private final ArrayList<L1DoorInstance> _doorList =
		new ArrayList<L1DoorInstance>();

    private final ArrayList<L1DoorInstance> _castleList =
		new ArrayList<L1DoorInstance>();

    private final ArrayList<L1DoorInstance> _keyList =
		new ArrayList<L1DoorInstance>();

    private final ArrayList<L1DoorInstance> _orderList =
		new ArrayList<L1DoorInstance>();

	public static DoorSpawnTable getInstance() {
		if (_instance == null) {
			_instance = new DoorSpawnTable();
		}
		return _instance;
	}

	private DoorSpawnTable() {
		FillDoorSpawnTable();
	}

	private void FillDoorSpawnTable() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM spawnlist_door");
			rs = pstm.executeQuery();
			do {
				if (!rs.next()) {
					break;
				}

				L1Npc l1npc = NpcTable.getInstance().getTemplate(81158);
				if (l1npc != null) {
					String s = l1npc.getImpl();
					Constructor<?> constructor = Class.forName("l1j.server.server.model.Instance." + s	+ "Instance").getConstructors()[0];
					Object parameters[] = { l1npc };
					L1DoorInstance door = (L1DoorInstance) constructor.newInstance(parameters);
					door = (L1DoorInstance) constructor.newInstance(parameters);
					door.setId(IdFactory.getInstance().nextId());

					door.setDoorId(rs.getInt(1));
					door.setGfxId(rs.getInt(3));
					door.setX(rs.getInt(4));
					door.setY(rs.getInt(5));
					door.setMap((short) rs.getInt(6));
					door.setHomeX(rs.getInt(4));
					door.setHomeY(rs.getInt(5));
					door.setDirection(rs.getInt(7));
					door.setEntranceX(rs.getInt(8));
					door.setEntranceY(rs.getInt(9));
					door.setMaxHp(rs.getInt(10));
					door.setCurrentHp(rs.getInt(10));
					door.setKeeperId(rs.getInt(11));
					door.setSize(rs.getInt(12));

					L1World.getInstance().storeObject(door);
					L1World.getInstance().addVisibleObject(door);

					if (door.getKeeperId() != 0) {
						_doorList.add(door);
					}
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

	public L1DoorInstance[] getDoorList() {
		return _doorList.toArray(new L1DoorInstance[_doorList.size()]);
	}

	public L1DoorInstance[] getCastleList() {
		return _castleList.toArray(new L1DoorInstance[_castleList.size()]);
	}

	public L1DoorInstance[] getKeyList() {
		return _keyList.toArray(new L1DoorInstance[_keyList.size()]);
	}

	public L1DoorInstance[] getOrderList() {
		return _orderList.toArray(new L1DoorInstance[_orderList.size()]);
	}
}