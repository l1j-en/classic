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
package l1j.server.server.model.map;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import l1j.server.server.datatables.MapsTable;
import l1j.server.server.model.map.L1Map;
import l1j.server.server.model.map.L1V1Map;
import l1j.server.server.utils.FileUtil;

public class CachedMapReader extends MapReader {
	private static final String MAP_DIR = "./maps/";
	private static final String CACHE_DIR = "./data/mapcache/";

	private ArrayList<Integer> listMapIds() {
		ArrayList<Integer> ids = new ArrayList<Integer>();

		File mapDir = new File(MAP_DIR);
		for (String name : mapDir.list()) {
			File mapFile = new File(mapDir, name);
			if (!mapFile.exists()) {
				continue;
			}
			if (!FileUtil.getExtension(mapFile).toLowerCase().equals("txt")) {
				continue;
			}
			int id = 0;
			try {
				String idStr = FileUtil.getNameWithoutExtension(mapFile);
				id = Integer.parseInt(idStr);
			} catch (NumberFormatException e) {
				continue;
			}
			ids.add(id);
		}
		return ids;
	}

	private L1V1Map cacheMap(final int mapId) throws IOException {
		File file = new File(CACHE_DIR);
		if (!file.exists()) {
			file.mkdir();
		}
		L1V1Map map = (L1V1Map) new TextMapReader().read(mapId);
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(CACHE_DIR + mapId + ".map")));
		out.writeInt(map.getId());
		out.writeInt(map.getX());
		out.writeInt(map.getY());
		out.writeInt(map.getWidth());
		out.writeInt(map.getHeight());
		for (byte[] line : map.getRawTiles()) {
			for (byte tile : line) {
				out.writeByte(tile);
			}
		}
		out.flush();
		out.close();
		return map;
	}

	@Override
	public L1Map read(final int mapId) throws IOException {
		File file = new File(CACHE_DIR + mapId + ".map");
		if (!file.exists()) {
			return cacheMap(mapId);
		}
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(CACHE_DIR + mapId + ".map")));
		int id = in.readInt();
		if (mapId != id) {
			throw new FileNotFoundException();
		}
		int xLoc = in.readInt();
		int yLoc = in.readInt();
		int width = in.readInt();
		int height = in.readInt();
		byte[][] tiles = new byte[width][height];
		for (byte[] line : tiles) {
			in.read(line);
		}
		in.close();
		L1V1Map map = new L1V1Map(id, tiles, xLoc, yLoc,
		MapsTable.getInstance().isUnderwater(mapId),
		MapsTable.getInstance().isMarkable(mapId),
		MapsTable.getInstance().isTeleportable(mapId),
		MapsTable.getInstance().isEscapable(mapId),
		MapsTable.getInstance().isUseResurrection(mapId),
		MapsTable.getInstance().isUsePainwand(mapId),
		MapsTable.getInstance().isEnabledDeathPenalty(mapId),
		MapsTable.getInstance().isTakePets(mapId),
		MapsTable.getInstance().isRecallPets(mapId),
		MapsTable.getInstance().isUsableItem(mapId),
		MapsTable.getInstance().isUsableSkill(mapId));
		return map;
	}

	@Override
	public Map<Integer, L1Map> read() throws IOException {
		Map<Integer, L1Map> maps = new HashMap<Integer, L1Map>();
		for (int id : listMapIds()) {
			maps.put(id, read(id));
		}
		return maps;
	}
}