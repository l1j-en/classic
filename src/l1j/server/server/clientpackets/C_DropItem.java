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

import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_Disconnect;

public class C_DropItem extends ClientBasePacket {
	private static Logger _log = Logger.getLogger(C_DropItem.class.getName());
	private static final String C_DROP_ITEM = "[C] C_DropItem";

	public C_DropItem(byte[] decrypt, ClientThread client)
			throws Exception {
		super(decrypt);
		int x = readH();
		int y = readH();
		int objectId = readD();
		int count = readD();

		L1PcInstance pc = client.getActiveChar();
		
		if (count < 0)
		{
			_log.info(pc.getName() + " attempted dupe exploit (C_DropItem).");
			
			L1World world = L1World.getInstance();

			//TODO Not used
			//IpTable iptable = IpTable.getInstance();

			world.broadcastServerMessage("Player " + pc.getName() + " attempted a dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			
			return;
		}
		
		if (pc.isGhost()) {
			return;
		}

		L1ItemInstance item = pc.getInventory().getItem(objectId);
		if (item != null) {
			if (!item.getItem().isTradable()) {
				pc.sendPackets(new S_ServerMessage(210, item.getItem()
						.getName()));
				return;
			}

			Object[] petlist = pc.getPetList().values().toArray();
			for (Object petObject : petlist) {
				if (petObject instanceof L1PetInstance) {
					L1PetInstance pet = (L1PetInstance) petObject;
					if (item.getId() == pet.getItemObjId()) {
						pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
						return;
					}
				}
			}

			if (item.isEquipped()) {
				pc.sendPackets(new S_ServerMessage(125));
				return;
			}

			pc.getInventory().tradeItem(item, count,
					L1World.getInstance().getInventory(x, y, pc.getMapId()));
		}
	}

	@Override
	public String getType() {
		return C_DROP_ITEM;
	}
}
