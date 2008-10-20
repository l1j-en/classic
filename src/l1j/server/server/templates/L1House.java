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

public class L1House {
	public L1House() {
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

	private String _location;

	public String getLocation() {
		return _location;
	}

	public void setLocation(String s) {
		_location = s;
	}

	private int _keeperId;

	public int getKeeperId() {
		return _keeperId;
	}

	public void setKeeperId(int i) {
		_keeperId = i;
	}

	private boolean _isOnSale;

	public boolean isOnSale() {
		return _isOnSale;
	}

	public void setOnSale(boolean flag) {
		_isOnSale = flag;
	}

	private boolean _isPurchaseBasement;

	public boolean isPurchaseBasement() {
		return _isPurchaseBasement;
	}

	public void setPurchaseBasement(boolean flag) {
		_isPurchaseBasement = flag;
	}

	private Calendar _taxDeadline;

	public Calendar getTaxDeadline() {
		return _taxDeadline;
	}

	public void setTaxDeadline(Calendar i) {
		_taxDeadline = i;
	}

}