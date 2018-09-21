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
package l1j.server.server.model.trap;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.map.L1Map;
import l1j.server.server.storage.TrapStorage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.types.Point;

public class L1MonsterTrap extends L1Trap {
	private static Logger _log = LoggerFactory			.getLogger(L1MonsterTrap.class.getName());
	private final int _npcId;
	private final int _count;
	private L1Npc _npcTemp = null;
	private Constructor<?> _constructor = null;

	public L1MonsterTrap(TrapStorage storage) {
		super(storage);
		_npcId = storage.getInt("monsterNpcId");
		_count = storage.getInt("monsterCount");
	}

	private void addListIfPassable(List<Point> list, L1Map map, Point pt) {
		if (map.isPassable(pt)) {
			list.add(pt);
		}
	}

	private List<Point> getSpawnablePoints(L1Location loc, int d) {
		List<Point> result = new ArrayList<Point>();
		L1Map m = loc.getMap();
		int x = loc.getX();
		int y = loc.getY();
		for (int i = 0; i < d; i++) {
			addListIfPassable(result, m, new Point(d - i + x, i + y));
			addListIfPassable(result, m, new Point(-(d - i) + x, -i + y));
			addListIfPassable(result, m, new Point(-i + x, d - i + y));
			addListIfPassable(result, m, new Point(i + x, -(d - i) + y));
		}
		return result;
	}

	private Constructor<?> getConstructor(L1Npc npc) throws ClassNotFoundException {
		return Class.forName(
				"l1j.server.server.model.Instance." + npc.getImpl()
						+ "Instance").getConstructors()[0];
	}

	private L1NpcInstance createNpc() throws Exception {
		if (_npcTemp == null) {
			_npcTemp = NpcTable.getInstance().getTemplate(_npcId);
		}
		if (_constructor == null) {
			_constructor = getConstructor(_npcTemp);
		}

		return (L1NpcInstance) _constructor
				.newInstance(new Object[] { _npcTemp });
	}

	private void spawn(L1Location loc) throws Exception {
		L1NpcInstance npc = createNpc();
		npc.setId(IdFactory.getInstance().nextId());
		npc.getLocation().set(loc);
		npc.setHomeX(loc.getX());
		npc.setHomeY(loc.getY());
		L1World.getInstance().storeObject(npc);
		L1World.getInstance().addVisibleObject(npc);
		npc.onNpcAI();
		npc.turnOnOffLight();
		npc.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE);
	}

	@Override
	public void onTrod(L1PcInstance trodFrom, L1Object trapObj) {
		sendEffect(trapObj);
		List<Point> points = getSpawnablePoints(trapObj.getLocation(), 5);

		if (points.isEmpty()) {
			return;
		}
		try {
			int cnt = 0;
			while (true) {
				for (Point pt : points) {
					spawn(new L1Location(pt, trapObj.getMap()));
					cnt++;
					if (_count <= cnt) {
						return;
					}
				}
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}
}