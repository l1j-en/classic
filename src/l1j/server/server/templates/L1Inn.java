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

import java.sql.Timestamp;

/** L1Inn */
public class L1Inn {

	private int _npcId;
	private int _roomNumber;
	private int _keyId;
	private int _lodgerId;
	private boolean _hall;
	private Timestamp _dueTime;

	public int getKeyId() {
		return _keyId;
	}

	public void setKeyId(int i) {
		_keyId = i;
	}

	public int getInnNpcId() {
		return _npcId;
	}

	public void setInnNpcId(int i) {
		_npcId = i;
	}

	public int getRoomNumber() {
		return _roomNumber;
	}

	public void setRoomNumber(int i) {
		_roomNumber = i;
	}

	public int getLodgerId() {
		return _lodgerId;
	}

	public void setLodgerId(int i) {
		_lodgerId = i;
	}

	public boolean isHall() {
		return _hall;
	}

	public void setHall(boolean hall) {
		_hall = hall;
	}

	public Timestamp getDueTime() {
		return _dueTime;
	}

	public void setDueTime(Timestamp i) {
		_dueTime = i;
	}
}