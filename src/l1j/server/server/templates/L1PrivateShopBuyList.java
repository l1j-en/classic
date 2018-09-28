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

// Referenced classes of package l1j.server.server.templates:
// L1PrivateShopBuyList

public class L1PrivateShopBuyList {
	public L1PrivateShopBuyList() {
	}

	private int _itemObjectId;

	public void setItemObjectId(int i) {
		_itemObjectId = i;
	}

	public int getItemObjectId() {
		return _itemObjectId;
	}
	
	private int _itemId;
	
	public void setItemId(int i) {
		_itemId = i;
	}
	
	public int getItemId() {
		return _itemId;
	}
	
	private int _itemEnchantLevel;
	
	public void setItemEnchantLevel(int i) {
		_itemEnchantLevel = i;
	}
	
	public int getItemEnchantLevel() {
		return _itemEnchantLevel;
	}

	private int _buyTotalCount; // Buy a number of plans

	public void setBuyTotalCount(int i) {
		_buyTotalCount = i;
	}

	public int getBuyTotalCount() {
		return _buyTotalCount;
	}

	private int _buyPrice;

	public void setBuyPrice(int i) {
		_buyPrice = i;
	}

	public int getBuyPrice() {
		return _buyPrice;
	}

	private int _buyCount; // Total bought

	public void setBuyCount(int i) {
		_buyCount = i;
	}

	public int getBuyCount() {
		return _buyCount;
	}
}
