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

import java.util.Calendar;

public class L1AuctionBoard {
	public L1AuctionBoard() {
	}

	private int _houseId;

	public int getHouseId() {
		return _houseId;
	}

	public void setHouseId(int i) {
		_houseId = i;
	}

	private String _houseName;

	public String getHouseName() {
		return _houseName;
	}

	public void setHouseName(String s) {
		_houseName = s;
	}

	private int _houseArea;

	public int getHouseArea() {
		return _houseArea;
	}

	public void setHouseArea(int i) {
		_houseArea = i;
	}

	private Calendar _deadline;

	public Calendar getDeadline() {
		return _deadline;
	}

	public void setDeadline(Calendar i) {
		_deadline = i;
	}

	private int _price;

	public int getPrice() {
		return _price;
	}

	public void setPrice(int i) {
		_price = i;
	}

	private String _location;

	public String getLocation() {
		return _location;
	}

	public void setLocation(String s) {
		_location = s;
	}

	private String _oldOwner;

	public String getOldOwner() {
		return _oldOwner;
	}

	public void setOldOwner(String s) {
		_oldOwner = s;
	}

	private int _oldOwnerId;

	public int getOldOwnerId() {
		return _oldOwnerId;
	}

	public void setOldOwnerId(int i) {
		_oldOwnerId = i;
	}

	private String _bidder;

	public String getBidder() {
		return _bidder;
	}

	public void setBidder(String s) {
		_bidder = s;
	}

	private int _bidderId;

	public int getBidderId() {
		return _bidderId;
	}

	public void setBidderId(int i) {
		_bidderId = i;
	}

}