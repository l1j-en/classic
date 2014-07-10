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
package l1j.server.server.clientpackets;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.TownTable;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.templates.L1Castle;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_TaxRate extends ClientBasePacket {

	private static final String C_TAX_RATE = "[C] C_TaxRate";

	public C_TaxRate(byte abyte0[], ClientThread clientthread) throws Exception {
		super(abyte0);
		int i = readD();
		int j = readC();

		L1PcInstance player = clientthread.getActiveChar();
		if (i == player.getId()) {
			if (!setCastleTax(player, j)) {
				setTownTax(player, j);
			}
		}
	}

	private boolean setCastleTax(L1PcInstance player, int rate) {
		L1Clan clan = L1World.getInstance().getClan(player.getClanname());
		if (clan != null) {
			int castle_id = clan.getCastleId();
			if (castle_id != 0) {
				if (L1CastleLocation.checkInWarArea(castle_id, player)) {
					L1Castle l1castle = CastleTable.getInstance()
							.getCastleTable(castle_id);
					if (rate >= 10 && rate <= 50) {
						l1castle.setTaxRate(rate);
						CastleTable.getInstance().updateCastle(l1castle);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private void setTownTax(L1PcInstance player, int rate) {
		int town_id = player.getHomeTownId();
		if (town_id == 0)
			return;

		TownTable town = TownTable.getInstance();
		if (town == null)
			return;
		
		if (town.isLeader(player, town_id)
				&& rate >= 2 && rate <= 5) {
			town.changeTaxRate(town_id, rate - 2); // 2% fixed town tax rate
		}
	}
	
	@Override
	public String getType() {
		return C_TAX_RATE;
	}
}