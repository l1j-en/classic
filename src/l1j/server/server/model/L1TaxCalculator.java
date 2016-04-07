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
		_taxRatesCastle = L1CastleLocation
				.getCastleTaxRateByNpcId(merchantNpcId);
		_taxRatesTown = L1TownLocation.getTownTaxRateByNpcid(merchantNpcId);
	}

	public int calcTotalTaxPrice(int price) {
		int taxCastle = price * _taxRatesCastle / 100;
		int taxTown = price * _taxRatesTown / 100;
		return taxCastle + taxTown;
	}

	public int calcCastleTaxPrice(int price) {
		int taxCastle = price * _taxRatesCastle / 100;
		return taxCastle - calcNationalTaxPrice(price) - calcDiadTaxPrice(price);
	}

	public int calcNationalTaxPrice(int price) {
		int taxCastle = price * _taxRatesCastle / 100;
		return taxCastle / (100 / NATIONAL_TAX_RATES);
	}

	public int calcTownTaxPrice(int price) {
		return (price * _taxRatesTown) / 100;
	}

	public int calcWarTaxPrice(int price) {
		return price * _taxRatesWar / 100;
	}

	public int calcDiadTaxPrice(int price) {
		int taxCastle = price * _taxRatesCastle / 100;
		return taxCastle / (100 / DIAD_TAX_RATES);
	}

	public int layTax(int price) {
		return price + calcTotalTaxPrice(price);
	}
}
