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

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.BuddyTable;
import l1j.server.server.model.L1Buddy;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_AddBuddy extends ClientBasePacket {

	private static final String C_ADD_BUDDY = "[C] C_AddBuddy";

	public C_AddBuddy(byte[] decrypt, ClientThread clientthread) {
		super(decrypt);
		L1PcInstance srcPc = clientthread.getActiveChar();
		BuddyTable buddyTable = BuddyTable.getInstance();
		L1Buddy buddyList = buddyTable.getBuddyTable(srcPc.getId());
		String charName = readS();

		if (charName.equalsIgnoreCase(srcPc.getName())) {
			// l1pcinstance.sendPackets(new S_ServerMessage("you can't add
			// yourself to buddylist."));
			return;
		} else if (buddyList.containsName(charName)) {
			// l1pcinstance.sendPackets(new S_ServerMessage("you can't add this
			// id again."));
			return;
		}

		for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
			if (charName.equalsIgnoreCase(pc.getName())) {
				int objId = pc.getId();
				String name = pc.getName();

				buddyList.add(objId, name);
				buddyTable.addBuddy(srcPc.getId(), objId, name);
				break;
			}
		}
	}

	@Override
	public String getType() {
		return C_ADD_BUDDY;
	}
}
