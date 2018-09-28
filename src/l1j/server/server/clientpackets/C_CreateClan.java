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

import l1j.server.server.datatables.ClanTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_CreateClan extends ClientBasePacket {

	private static final String C_CREATE_CLAN = "[C] C_CreateClan";

	public C_CreateClan(byte abyte0[], Client client)
			throws Exception {
		super(abyte0);
		String s = readS().replace(" ","");
		// TODO Never used
		// int i = s.length();

		L1PcInstance l1pcinstance = client.getActiveChar();
		if (l1pcinstance.isCrown()) {
			if (l1pcinstance.getClanid() == 0) {

				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getClanName().toLowerCase()
							.equals(s.toLowerCase())) {
						l1pcinstance.sendPackets(new S_ServerMessage(99));
						return;
					}
				}
				L1Clan clan = ClanTable.getInstance().createClan(l1pcinstance,
						s);
				if (clan != null) {
					l1pcinstance.sendPackets(new S_ServerMessage(84, s));
				}
			} else {
				l1pcinstance.sendPackets(new S_ServerMessage(86));
			}
		} else {
			l1pcinstance.sendPackets(new S_ServerMessage(85));
		}
	}

	@Override
	public String getType() {
		return C_CREATE_CLAN;
	}
}