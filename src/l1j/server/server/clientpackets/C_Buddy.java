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
 * Author: ChrisLiu.2007.07.20
 */
package l1j.server.server.clientpackets;

import l1j.server.server.datatables.BuddyTable;
import l1j.server.server.model.L1Buddy;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_Buddy;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_Buddy extends ClientBasePacket {

	private static final String C_BUDDY = "[C] C_Buddy";

	public C_Buddy(byte abyte0[], Client client) {
		super(abyte0);
		L1PcInstance pc = client.getActiveChar();
		L1Buddy buddy = BuddyTable.getInstance().getBuddyTable(pc.getId());
		pc.sendPackets(new S_Buddy(pc.getId(), buddy));
	}

	@Override
	public String getType() {
		return C_BUDDY;
	}
}