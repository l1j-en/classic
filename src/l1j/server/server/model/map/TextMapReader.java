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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.datatables.MapsTable;

/**
 * Text map (maps/*.txt) to read.
 */
public class TextMapReader extends MapReader {

	/** For the message log. */
	private static Logger _log = Logger
			.getLogger(TextMapReader.class.getName());

	/** Map holder. */
	private static final String MAP_DIR = "./maps/";

	/** MAP_INFO Map number for the position. */
	public static final int MAPINFO_MAP_NO = 0;

	/** MAP_INFO X coordinate positions for the start. */
	public static final int MAPINFO_START_X = 1;

	/** MAP_INFO X coordinate positions for the final. */
	public static final int MAPINFO_END_X = 2;

	/** MAP_INFO Y coordinates for the starting position. */
	public static final int MAPINFO_START_Y = 3;

	/** MAP_INFO Y coordinates for the starting position. */
	public static final int MAPINFO_END_Y = 4;

	/**
	 * Map specified number of text to read the map.
	 *
	 * @param mapId
	 *            Map No.
	 * @param xSize
	 *            X Coordinate size
	 * @param ySize
	 *            Y Coordinate size
	 * @return byte[][]
	 * @throws IOException
	 */
	public byte[][] read(final int mapId, final int xSize, final int ySize)
									throws IOException {
		byte[][] map = new byte[xSize][ySize];
		LineNumberReader in = new LineNumberReader(new BufferedReader(
										new FileReader(MAP_DIR + mapId + ".txt")));
		int y = 0;
		String line;
		while ((line = in.readLine()) != null) {
			if (line.trim().length() == 0 || line.startsWith("#")) {
				continue; // Skip blank lines and comments
			}
			int x = 0;
			StringTokenizer tok = new StringTokenizer(line, ",");
			while (tok.hasMoreTokens()) {
				byte tile = Byte.parseByte(tok.nextToken());
				map[x][y] = tile;
				x++;
			}
			y++;
		}
		in.close();
		return map;
	}

	/**
	 * Map specified number of text to read the map.
	 *
	 * @param id
	 *            Map No.
	 * @return L1Map
	 * @throws IOException
	 */
	@Override
	public L1Map read(final int id) {
		L1V1Map map = null;

		int xSize = MapsTable.getInstance().getEndX(id) - MapsTable.getInstance().getStartX(id) + 1;
		int ySize = MapsTable.getInstance().getEndY(id) - MapsTable.getInstance().getStartY(id) + 1;

		try {
			map = new L1V1Map(id,
												this.read(id,xSize,ySize),
												MapsTable.getInstance().getStartX(id),
												MapsTable.getInstance().getStartY(id),
												MapsTable.getInstance().isUnderwater(id),
												MapsTable.getInstance().isMarkable(id),
												MapsTable.getInstance().isTeleportable(id),
												MapsTable.getInstance().isEscapable(id),
												MapsTable.getInstance().isUseResurrection(id),
												MapsTable.getInstance().isUsePainwand(id),
												MapsTable.getInstance().isEnabledDeathPenalty(id),
												MapsTable.getInstance().isTakePets(id),
												MapsTable.getInstance().isRecallPets(id),
												MapsTable.getInstance().isUsableItem(id),
												MapsTable.getInstance().isUsableSkill(id)
												);

		} catch (IOException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return map;
	}

	/**
	 * All text to read the map.
	 *
	 * @return Map
	 * @throws IOException
	 */
	@Override
	public Map<Integer, L1Map> read() throws IOException {
		Map<Integer, L1Map> maps = new HashMap<Integer, L1Map>();

		// Instead of using a hard coded MAP_INFO, let's pull the data from
		// The mapstable data
		for (int mapid : MapsTable.getInstance().getMapIds() ) {
			// try {
				maps.put(mapid, this.read(mapid));
			// } catch (IOException e) {
			// 	_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			// }
		}
		return maps;
	}

}
