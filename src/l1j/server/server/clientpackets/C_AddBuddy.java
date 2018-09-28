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
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Buddy;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1CharName;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_AddBuddy extends ClientBasePacket {

	private static final String C_ADD_BUDDY = "[C] C_AddBuddy";

	public C_AddBuddy(byte[] decrypt, Client client) {
		super(decrypt);
		L1PcInstance pc = client.getActiveChar();
		BuddyTable buddyTable = BuddyTable.getInstance();
		L1Buddy buddyList = buddyTable.getBuddyTable(pc.getId());
		String charName = readS();

		if (charName.equalsIgnoreCase(pc.getName())) {
			return;
		} else if (buddyList.containsName(charName)) {
			pc.sendPackets(new S_ServerMessage(1052, charName));
			return;
		//69 is where it seems to crash out, so limit to to fewer than 67 buddies just to be safe
		} else if(buddyList.size() >= 67) {
			pc.sendPackets(new S_SystemMessage("You cannot add any more players to your buddy list."));
			return;
		}

		for (L1CharName cn : CharacterTable.getInstance().getCharNameList()) {
			if (charName.equalsIgnoreCase(cn.getName())) {
				int objId = cn.getId();
				String name = cn.getName();
				buddyList.add(objId, name);
				buddyTable.addBuddy(pc.getId(), objId, name);
				return;
			}
		}
		pc.sendPackets(new S_ServerMessage(109, charName));
	}

	@Override
	public String getType() {
		return C_ADD_BUDDY;
	}
}