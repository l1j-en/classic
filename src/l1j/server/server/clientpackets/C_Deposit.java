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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.templates.L1Castle;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_Deposit extends ClientBasePacket {

	private static final String C_DEPOSIT = "[C] C_Deposit";
	private static Logger _log = LoggerFactory.getLogger(C_Deposit.class.getName());

	public C_Deposit(byte abyte0[], Client client) throws Exception {
		super(abyte0);
		int i = readD();
		int j = readD();

		L1PcInstance player = client.getActiveChar();
		// additional dupe checks. Thanks Mike
		// not sure if this is even needed here, but why not
		if (player.getOnlineStatus() != 1) {
			if (Config.AUTO_BAN) {
				Account.ban(player.getAccountName(), "AutoBan", "Deposit Dupe Check Player Offline");
				IpTable.getInstance().banIp(player.getNetConnection().getIp());
			}
			_log.info(player.getName() + " Attempted Dupe Exploit (C_Deposit).");
			L1World.getInstance()
					.broadcastServerMessage(
							"Player " + player.getName()
									+ " Attempted A Dupe exploit!");
			player.sendPackets(new S_Disconnect());
			return;
		}
		// TRICIDTODO: set configurable auto ban
		if (j < 0) {
			if (Config.AUTO_BAN) {
				Account.ban(player.getAccountName(), "AutoBan", "Deposit Dupe Check Overflow Attempt");
				IpTable.getInstance().banIp(player.getNetConnection().getIp());
			}
			_log.info(player.getName() + " Attempted Dupe Exploit (C_Deposit).");
			L1World.getInstance()
					.broadcastServerMessage(
							"Player " + player.getName()
									+ " Attempted A Dupe exploit!");
			player.sendPackets(new S_Disconnect());
			return;
		}

		if (i == player.getId()) {
			L1Clan clan = L1World.getInstance().getClan(player.getClanname());
			if (clan != null) {
				int castle_id = clan.getCastleId();
				if (castle_id != 0) {
					L1Castle l1castle = CastleTable.getInstance()
							.getCastleTable(castle_id);
					synchronized (l1castle) {
						int money = l1castle.getPublicMoney();
						if (player.getInventory()
								.consumeItem(L1ItemId.ADENA, j)) {
							money += j;
							l1castle.setPublicMoney(money);
							CastleTable.getInstance().updateCastle(l1castle);
						}
					}
				}
			}
		}
	}

	@Override
	public String getType() {
		return C_DEPOSIT;
	}
}
