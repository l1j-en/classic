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

public class L1Castle {
	public L1Castle(int id, String name) {
		_id = id;
		_name = name;
	}

	private int _id;

	public int getId() {
		return _id;
	}

	private String _name;

	public String getName() {
		return _name;
	}

	private Calendar _warTime;

	public Calendar getWarTime() {
		return _warTime;
	}

	public void setWarTime(Calendar i) {
		_warTime = i;
	}

	private int _taxRate;

	public int getTaxRate() {
		return _taxRate;
	}

	public void setTaxRate(int i) {
		_taxRate = i;
	}

	private int _publicMoney;

	public int getPublicMoney() {
		return _publicMoney;
	}

	public void setPublicMoney(int i) {
		_publicMoney = i;
	}

}
