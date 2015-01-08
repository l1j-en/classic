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

import java.util.LinkedHashMap;
import java.util.Map;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_PacketBox;

public class L1ExcludingList {
	private final int _charId;

	private final LinkedHashMap<Integer, String> _excludes = new LinkedHashMap<Integer, String>();

	public L1ExcludingList(int charId) {
		_charId = charId;
	}

	public int getCharId() {
		return _charId;
	}

	public boolean add(int objId, String name) {
		if (_excludes.containsKey(objId)) {
			return false;
		}
		_excludes.put(objId, name);
		return true;
	}

	/**
	 * wOLN^[fXg
	 * 
	 * @param name
	 *            LN^[
	 * @return ANCAgfXgLN^[B wOXgnullB
	 */
	public boolean remove(int objId) {
		String result = _excludes.remove(objId);
		return (result != null ? true : false);
	}

	public boolean remove(String name) {
		int id = 0;
		for (Map.Entry<Integer, String> exclude : _excludes.entrySet()) {
			if (name.equalsIgnoreCase(exclude.getValue())) {
				id = exclude.getKey();
				break;
			}
		}
		if (id == 0) {
			return false;
		}
		_excludes.remove(id);
		return true;
	}


	/**
	 * wOLN^[ftrue
	 */

	public void sendExcludeList() {
		L1PcInstance pc = (L1PcInstance) L1World.getInstance().findObject(_charId);
		if(pc == null) {
			return;
		}
		for (String name : _excludes.values()) {
			pc.sendPackets(new S_PacketBox(S_PacketBox.ADD_EXCLUDE, name));
		}
	}

	public boolean containsId(int objId) {
		return _excludes.containsKey(objId);
	}

	public boolean containsName(String name) {
		for (String excludeName : _excludes.values()) {
			if (name.equalsIgnoreCase(excludeName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * fXg16B
	 */
	public boolean isFull() {
		return (_excludes.size() >= 16) ? true : false;
	}
}
