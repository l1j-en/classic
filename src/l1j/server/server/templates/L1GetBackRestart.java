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

package l1j.server.server.templates;

public class L1GetBackRestart {
	public L1GetBackRestart() {
	}

	private int _id;

	public int get_id() {
		return _id;
	}

	public void set_id(int i) {
		_id = i;
	}

	private int _area;

	public int getArea() {
		return _area;
	}

	public void setArea(int i) {
		_area = i;
	}

	private String _areaname;

	public String get_areaname() {
		return _areaname;
	}

	public void set_areaname(String s) {
		_areaname = s;
	}

	private int _locX;

	public int getLocX() {
		return _locX;
	}

	public void setLocX(int i) {
		_locX = i;
	}

	private int _locY;

	public int getLocY() {
		return _locY;
	}

	public void setLocY(int i) {
		_locY = i;
	}

	private short _MapId;

	public short getMapId() {
		return _MapId;
	}

	public void setMapId(short i) {
		_MapId = i;
	}

}
