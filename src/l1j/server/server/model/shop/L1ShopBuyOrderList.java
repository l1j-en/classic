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
package l1j.server.server.model.shop;

import java.util.ArrayList;
import java.util.List;

import l1j.server.Config;
import l1j.server.server.model.L1TaxCalculator;
import l1j.server.server.templates.L1ShopItem;


public class L1ShopBuyOrderList {

	private final L1Shop _shop;
	private final List<L1ShopBuyOrder> _list = new ArrayList<L1ShopBuyOrder>();
	private final L1TaxCalculator _taxCalc;

	private int _totalWeight = 0;
	private int _totalPriceTaxIncluded = 0;
	private int _npcid = 0;

	L1ShopBuyOrderList(L1Shop shop) {
		_shop = shop;
		_taxCalc = new L1TaxCalculator(shop.getNpcId());
		_npcid = shop.getNpcId();
	}
	
	public List<L1ShopBuyOrder> getBoughtItems() {
		return _list;
	}

	public void add(int orderNumber, int count) {
		if (_shop.getSellingItems().size() < orderNumber) {
			return;
		}
		
		L1ShopItem shopItem = _shop.getSellingItems().get(orderNumber);
		int price = (int) (shopItem.getPrice() * Config.RATE_SHOP_SELLING_PRICE);
		
		for (int j = 0; j <= count; j++) {
			if (price * j < 0) {
				return;
			}
		}
		
		if (_totalPriceTaxIncluded < 0) {
			return;
		}
		int addTotal = price * count;
		
		if (addTotal < 0) {
			return;
		}

		if (_npcid != 70017 && _npcid != 70049) { // Exclude Orim and Rozen from
													// taxes
			int taxGenerated = _taxCalc.layTax(shopItem, count);
			
			if (addTotal + taxGenerated < 0) {
				return;
			}
			
			_totalPriceTaxIncluded += addTotal + taxGenerated;
		} else {
			addTotal = price * count;
			
			if (addTotal < 0) {
				return;
			}
			
			_totalPriceTaxIncluded += addTotal;
		}
		
		_totalWeight += shopItem.getItem().getWeight() * count
				* shopItem.getPackCount();

		if (shopItem.getItem().isStackable()) {
			_list.add(new L1ShopBuyOrder(shopItem, count
					* shopItem.getPackCount()));
			return;
		}

		for (int i = 0; i < (count * shopItem.getPackCount()); i++) {
			_list.add(new L1ShopBuyOrder(shopItem, 1));
		}
	}

	List<L1ShopBuyOrder> getList() {
		return _list;
	}

	public int getTotalWeight() {
		return _totalWeight;
	}

	public int getTotalPriceTaxIncluded() {
		return _totalPriceTaxIncluded;
	}

	L1TaxCalculator getTaxCalculator() {
		return _taxCalc;
	}
}