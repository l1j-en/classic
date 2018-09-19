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
// L1PrivateShopSellList

public class L1PrivateShopSellList {
	public L1PrivateShopSellList() {
	}

	private int _itemObjectId;

	public void setItemObjectId(int i) {
		_itemObjectId = i;
	}

	public int getItemObjectId() {
		return _itemObjectId;
	}

	private int _sellTotalCount; // The number of planned sell

	public void setSellTotalCount(int i) {
		_sellTotalCount = i;
	}

	public int getSellTotalCount() {
		return _sellTotalCount;
	}

	private int _sellPrice;

	public void setSellPrice(int i) {
		_sellPrice = i;
	}

	public int getSellPrice() {
		return _sellPrice;
	}

	private int _sellCount; // Total sold

	public void setSellCount(int i) {
		_sellCount = i;
	}

	public int getSellCount() {
		return _sellCount;
	}
}
