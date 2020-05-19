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

import java.io.Serializable;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.map.L1Map;
import l1j.server.server.model.map.L1WorldMap;

// Referenced classes of package l1j.server.server.model:
// L1PcInstance, L1Character

/**
 * World exist on the basis of all objects of class
 */
public class L1Object implements Serializable {
	private static final long serialVersionUID = 1L;

	public short getMapId() {
		return (short) _loc.getMap().getId();
	}

	public void setMap(short mapId) {
		_loc.setMap(L1WorldMap.getInstance().getMap(mapId));
	}

	public L1Map getMap() {
		return _loc.getMap();
	}

	public void setMap(L1Map map) {
		if (map == null) {
			throw new NullPointerException();
		}
		_loc.setMap(map);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public int getX() {
		return _loc.getX();
	}

	public void setX(int x) {
		_loc.setX(x);
	}

	public int getY() {
		return _loc.getY();
	}

	public void setY(int y) {
		_loc.setY(y);
	}

	private L1Location _loc = new L1Location();

	public L1Location getLocation() {
		return _loc;
	}

	public void setLocation(L1Location loc) {
		_loc.setX(loc.getX());
		_loc.setY(loc.getY());
		_loc.setMap(loc.getMapId());
	}

	public void setLocation(int x, int y, int mapid) {
		_loc.setX(x);
		_loc.setY(y);
		_loc.setMap(mapid);
	}

	public double getLineDistance(L1Object obj) {
		return this.getLocation().getLineDistance(obj.getLocation());
	}

	public int getTileLineDistance(L1Object obj) {
		return this.getLocation().getTileLineDistance(obj.getLocation());
	}

	public int getTileDistance(L1Object obj) {
		return this.getLocation().getTileDistance(obj.getLocation());
	}

	public void onPerceive(L1PcInstance perceivedFrom) {
	}

	public void onAction(L1PcInstance actionFrom) {
	}

	/**
	* Called when an action on the object occurs
	*
	* @param actionFrom
	* PC that triggered the action
	* @param skillId
	* Skill ID used
	*/
	public void onAction(L1PcInstance actionFrom,int skillId) {
	}
	
	public void onTalkAction(L1PcInstance talkFrom) {
	}

	private int _id = 0;
}
