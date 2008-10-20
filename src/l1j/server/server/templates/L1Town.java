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

public class L1Town {
	public L1Town() {
	}

	private int _townid;

	public int get_townid() {
		return _townid;
	}

	public void set_townid(int i) {
		_townid = i;
	}

	private String _name;

	public String get_name() {
		return _name;
	}

	public void set_name(String s) {
		_name = s;
	}

	private int _leader_id;

	public int get_leader_id() {
		return _leader_id;
	}

	public void set_leader_id(int i) {
		_leader_id = i;
	}

	private String _leader_name;

	public String get_leader_name() {
		return _leader_name;
	}

	public void set_leader_name(String s) {
		_leader_name = s;
	}

	private int _tax_rate;

	public int get_tax_rate() {
		return _tax_rate;
	}

	public void set_tax_rate(int i) {
		_tax_rate = i;
	}

	private int _tax_rate_reserved;

	public int get_tax_rate_reserved() {
		return _tax_rate_reserved;
	}

	public void set_tax_rate_reserved(int i) {
		_tax_rate_reserved = i;
	}

	private int _sales_money;

	public int get_sales_money() {
		return _sales_money;
	}

	public void set_sales_money(int i) {
		_sales_money = i;
	}

	private int _sales_money_yesterday;

	public int get_sales_money_yesterday() {
		return _sales_money_yesterday;
	}

	public void set_sales_money_yesterday(int i) {
		_sales_money_yesterday = i;
	}

	private int _town_tax;

	public int get_town_tax() {
		return _town_tax;
	}

	public void set_town_tax(int i) {
		_town_tax = i;
	}

	private int _town_fix_tax;

	public int get_town_fix_tax() {
		return _town_fix_tax;
	}

	public void set_town_fix_tax(int i) {
		_town_fix_tax = i;
	}
}
