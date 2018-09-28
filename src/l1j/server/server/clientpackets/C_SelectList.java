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

import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.network.Client;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_SelectList extends ClientBasePacket {

	private static final String C_SELECT_LIST = "[C] C_SelectList";
	private static Logger _log = LoggerFactory.getLogger(C_SelectList.class.getName());

	public C_SelectList(byte abyte0[], Client client) {
		super(abyte0);
		int itemObjectId = readD();
		int npcObjectId = readD();
		L1PcInstance pc = client.getActiveChar();

		if (npcObjectId != 0) {
			L1Object obj = L1World.getInstance().findObject(npcObjectId);
			if (obj != null) {
				if (obj instanceof L1NpcInstance) {
					L1NpcInstance npc = (L1NpcInstance) obj;
					int difflocx = Math.abs(pc.getX() - npc.getX());
					int difflocy = Math.abs(pc.getY() - npc.getY());
					if (difflocx > 3 || difflocy > 3) {
						return;
					}
				}
			}

			L1PcInventory pcInventory = pc.getInventory();
			L1ItemInstance item = pcInventory.getItem(itemObjectId);
			int cost = item.get_durability() * 200;
			if (!pc.getInventory().consumeItem(L1ItemId.ADENA, cost)) {
				return;
			}
			item.set_durability(0);
			pcInventory.updateItem(item, L1PcInventory.COL_DURABILITY);
		} else {
			L1ItemInstance item = pc.getInventory().getItem(itemObjectId);

			if (item == null) {
				_log.info(pc.getName() + " Attempted a Pet Withdrawl Exploit - No Collar (C_SelectList).");
				return;
			}
			
			Object[] petlist = pc.getPetList().values().toArray();
			for (Object petObject : petlist) {
				if (petObject instanceof L1PetInstance) {
					L1PetInstance pet = (L1PetInstance) petObject;
					if (item.getId() == pet.getItemObjId()) {
						_log.info(pc.getName() + " Attempted a Pet Withdrawl Exploit - Pet Already Out (C_SelectList).");
						return;
					}
				}
			}
			
			pc.useDogCollar(itemObjectId);
		}
	}

	@Override
	public String getType() {
		return C_SELECT_LIST;
	}
}