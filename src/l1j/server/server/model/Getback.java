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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class Getback {

	private static Logger _log = Logger.getLogger(Getback.class.getName());

	private static Random _random = new Random();

	private static HashMap<Integer, ArrayList<Getback>> _getback = new HashMap<Integer, ArrayList<Getback>>();

	private int _areaX1;
	private int _areaY1;
	private int _areaX2;
	private int _areaY2;
	private int _areaMapId;
	private int _getbackX1;
	private int _getbackY1;
	private int _getbackX2;
	private int _getbackY2;
	private int _getbackX3;
	private int _getbackY3;
	private int _getbackMapId;
	private int _getbackTownId;
	private int _getbackTownIdForElf;
	private int _getbackTownIdForDarkelf;
	//TODO Not used
	//private boolean _escapable; // Unused (mapids to have here, before coming to check on it)

	private Getback() {
	}

	private boolean isSpecifyArea() {
		return (_areaX1 != 0 && _areaY1 != 0 && _areaX2 != 0 && _areaY2 != 0);
	}

	public static void loadGetBack() {
		_getback.clear();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			String sSQL = "SELECT * FROM getback ORDER BY area_mapid,area_x1 DESC ";
			pstm = con.prepareStatement(sSQL);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Getback getback = new Getback();
				getback._areaX1 = rs.getInt("area_x1");
				getback._areaY1 = rs.getInt("area_y1");
				getback._areaX2 = rs.getInt("area_x2");
				getback._areaY2 = rs.getInt("area_y2");
				getback._areaMapId = rs.getInt("area_mapid");
				getback._getbackX1 = rs.getInt("getback_x1");
				getback._getbackY1 = rs.getInt("getback_y1");
				getback._getbackX2 = rs.getInt("getback_x2");
				getback._getbackY2 = rs.getInt("getback_y2");
				getback._getbackX3 = rs.getInt("getback_x3");
				getback._getbackY3 = rs.getInt("getback_y3");
				getback._getbackMapId = rs.getInt("getback_mapid");
				getback._getbackTownId = rs.getInt("getback_townid");
				getback._getbackTownIdForElf = rs.getInt("getback_townid_elf");
				getback._getbackTownIdForDarkelf = rs
						.getInt("getback_townid_darkelf");
				//TODO Not used
				//getback._escapable = rs.getBoolean("scrollescape");
				ArrayList<Getback> getbackList = _getback
						.get(getback._areaMapId);
				if (getbackList == null) {
					getbackList = new ArrayList<Getback>();
					_getback.put(getback._areaMapId, getbackList);
				}
				getbackList.add(getback);
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, "could not Get Getback data", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	/**
	 * pc points to get feedback from the current position.
	 * 
	 * @param pc
	 * @param bScroll_Escape
	 * @return locx,locy,mapid
	 */
	public static int[] GetBack_Location(L1PcInstance pc, boolean bScroll_Escape) {

		int[] loc = new int[3];

		int nPosition = _random.nextInt(3);

		int pcLocX = pc.getX();
		int pcLocY = pc.getY();
		int pcMapId = pc.getMapId();
		ArrayList<Getback> getbackList = _getback.get(pcMapId);

		if (getbackList != null) {
			Getback getback = null;
			for (Getback gb : getbackList) {
				if (gb.isSpecifyArea()) {
					if (gb._areaX1 <= pcLocX && pcLocX <= gb._areaX2
							&& gb._areaY1 <= pcLocY && pcLocY <= gb._areaY2) {
						getback = gb;
						break;
					}
				} else {
					getback = gb;
					break;
				}
			}

			loc = ReadGetbackInfo(getback, nPosition);

			// town_id
			if (pc.isElf() && getback._getbackTownIdForElf > 0) {
				loc = L1TownLocation
						.getGetBackLoc(getback._getbackTownIdForElf);
			} else if (pc.isDarkelf() && getback._getbackTownIdForDarkelf > 0) {
				loc = L1TownLocation
						.getGetBackLoc(getback._getbackTownIdForDarkelf);
			} else if (getback._getbackTownId > 0) {
				loc = L1TownLocation.getGetBackLoc(getback._getbackTownId);
			}
		}
		// getback
		else {
			loc[0] = 33089;
			loc[1] = 33397;
			loc[2] = 4;
		}
		return loc;
	}

	private static int[] ReadGetbackInfo(Getback getback, int nPosition) {
		int[] loc = new int[3];
		switch (nPosition) {
		case 0:
			loc[0] = getback._getbackX1;
			loc[1] = getback._getbackY1;
			break;

		case 1:
			loc[0] = getback._getbackX2;
			loc[1] = getback._getbackY2;
			break;

		case 2:
			loc[0] = getback._getbackX3;
			loc[1] = getback._getbackY3;
			break;
		}
		loc[2] = getback._getbackMapId;

		return loc;
	}
}
