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

import l1j.server.Config;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_WhoAmount;
import l1j.server.server.serverpackets.S_WhoCharinfo;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_Who extends ClientBasePacket {

	private static final String C_WHO = "[C] C_Who";

	public C_Who(byte[] decrypt, Client client) {
		super(decrypt);
		String s = readS();
		L1PcInstance find = L1World.getInstance().getPlayer(s);
		
		if(find != null && (find.getAccessLevel().getLevel() > 0 && find.isGmAppearOffline()))
			find = null;
		
		L1PcInstance pc = client.getActiveChar();

		if (find != null) {
			S_WhoCharinfo s_whocharinfo = new S_WhoCharinfo(find);
			pc.sendPackets(s_whocharinfo);
		} else {
			if (Config.ALT_WHO_COMMAND) {
				String amount = String.valueOf(L1World.getInstance()
						.getAllPlayers().size());
				S_WhoAmount s_whoamount = new S_WhoAmount(amount);
				pc.sendPackets(s_whoamount);
			}
		}
	}

	@Override
	public String getType() {
		return C_WHO;
	}
}