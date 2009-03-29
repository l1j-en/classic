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

import java.util.ArrayList;

public class L1ExcludingList {

	private ArrayList<String> _nameList = new ArrayList<String>();

	public void add(String name) {
		_nameList.add(name);
	}

	/**
	 * wOLN^[fXg
	 * 
	 * @param name
	 *            LN^[
	 * @return ANCAgfXgLN^[B wOXgnullB
	 */
	public String remove(String name) {
		for (String each : _nameList) {
			if (each.equalsIgnoreCase(name)) {
				_nameList.remove(each);
				return each;
			}
		}
		return null;
	}

	/**
	 * wOLN^[ftrue
	 */
	public boolean contains(String name) {
		for (String each : _nameList) {
			if (each.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * fXg16B
	 */
	public boolean isFull() {
		return (_nameList.size() >= 16) ? true : false;
	}
}
