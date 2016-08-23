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

import l1j.server.Config;
import l1j.server.server.model.shop.L1ShopBuyOrder;
import l1j.server.server.model.shop.L1ShopBuyOrderList;
import l1j.server.server.templates.L1ShopItem;

public class L1TaxCalculator {
	/**
	 * 15 percent war tax - (when Lastabad army controls diad fortress)
	 */
	private static final int WAR_TAX_RATES = 15;

	/**
	 * 10 percent of local taxes given to Aden
	 */
	private static final int NATIONAL_TAX_RATES = 10;

	/**
	 * 10 percent of local taxes given to Diad
	 */
	private static final int DIAD_TAX_RATES = 10;

	private final int _taxRatesCastle;
	private final int _taxRatesTown;
	private final int _taxRatesWar = WAR_TAX_RATES;

	/**
	 * @param merchantNpcId
	 *            target stores calculation NPCID
	 */
	public L1TaxCalculator(int merchantNpcId) {
		_taxRatesCastle = 50;
		_taxRatesTown = 10;
	}

	public int calcTotalTaxPrice(L1ShopItem item, int count) {
		int taxCastle = calcCastleTaxPrice(item, count, false);
		int taxTown = calcTownTaxPrice(item, count);

		return taxCastle + taxTown;
	}	
	
	public int calcCastleTaxPrice(L1ShopBuyOrderList orderList) {
		return calcCastleTaxPrice(orderList, true);
	}
	
	public int calcCastleTaxPrice(L1ShopBuyOrderList orderList, boolean subtractOtherTaxes) {
		int castleTaxPrice = 0;

		for(L1ShopBuyOrder item : orderList.getBoughtItems())
			castleTaxPrice += calcCastleTaxPrice(item.getItem(), item.getCount(), subtractOtherTaxes);
		
		return castleTaxPrice;
	}
	
	public int calcCastleTaxPrice(L1ShopItem item, int count) {
		return calcCastleTaxPrice(item, count, true);
	}
	
	public int calcCastleTaxPrice(L1ShopItem item, int count, boolean subtractOtherTaxes) {
		int castleTaxPrice = 0;
		
		for(int i = 0; i < count; i++) {
			castleTaxPrice += (int)((item.getPrice() * Config.RATE_SHOP_SELLING_PRICE) * 
					_taxRatesCastle / 100);
		}
		
		if(!subtractOtherTaxes) {
			return castleTaxPrice;
		}
		
		return castleTaxPrice - calcNationalTaxPrice(item, count)
			- calcDiadTaxPrice(item, count);
	}
	
	
	public int calcNationalTaxPrice(L1ShopBuyOrderList orderList) {
		int taxCastle = 0;
		
		for(L1ShopBuyOrder item : orderList.getBoughtItems())
			taxCastle += calcNationalTaxPrice(item.getItem(), item.getCount());
		
		return taxCastle;
	}
	
	public int calcNationalTaxPrice(L1ShopItem item, int count) {
		int taxCastle = 0;
			
		for(int i = 0; i < count; i++) {
			taxCastle +=  (int)((item.getPrice() * Config.RATE_SHOP_SELLING_PRICE) * 
					_taxRatesCastle / 100);
		}
		
		return taxCastle / (100 / NATIONAL_TAX_RATES);
	}

	public int calcTownTaxPrice(L1ShopItem item, int count) {
		
		int townTaxPrice = 0;
		
		for(int i = 0; i < count; i++) {
			townTaxPrice +=  (int)((item.getPrice() * Config.RATE_SHOP_SELLING_PRICE) * 
					_taxRatesTown / 100);
		}
		
		return townTaxPrice;
	}

	public int calcWarTaxPrice(L1ShopItem item, int count) {
		int warTaxPrice = 0;
		
		for(int i = 0; i < count; i++) {
			warTaxPrice +=  (int)((item.getPrice() * Config.RATE_SHOP_SELLING_PRICE) * 
					_taxRatesWar / 100);
		}
		
		return warTaxPrice;
	}
	
	public int calcDiadTaxPrice(L1ShopBuyOrderList orderList) {
		int diadCastleTaxPrice = 0;
		
		for(L1ShopBuyOrder item : orderList.getBoughtItems())
			diadCastleTaxPrice += calcDiadTaxPrice(item.getItem(), item.getCount());
		
		return diadCastleTaxPrice;
	}

	public int calcDiadTaxPrice(L1ShopItem item, int count) {
		int diadCastleTaxPrice = 0;
		
		for(int i = 0; i < count; i++) {
			diadCastleTaxPrice +=  (int)((item.getPrice() * Config.RATE_SHOP_SELLING_PRICE) * 
					_taxRatesCastle / 100);
		}
		
		return diadCastleTaxPrice / (100 / DIAD_TAX_RATES);
	}

	public int layTax(L1ShopItem item, int count) {
		return calcTotalTaxPrice(item, count);
	}
}
