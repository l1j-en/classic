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

import l1j.server.server.Account;

import l1j.server.server.datatables.IpTable;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.ClientThread;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.serverpackets.S_ServerMessage;


public class C_DropItem extends ClientBasePacket {
	private static Logger _log = Logger.getLogger(C_DropItem.class.getName());
	private static final String C_DROP_ITEM = "[C] C_DropItem";

	public C_DropItem(byte[] decrypt, ClientThread client) throws Exception {
		super(decrypt);
		int x = readH();
		int y = readH();
		int objectId = readD();
		int count = readD();

		L1PcInstance pc = client.getActiveChar();
		
		//additional dupe checks.  Thanks Mike
		if (pc.getOnlineStatus() != 1) {
			Account.ban(pc.getAccountName());
			IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_DropItem).");
			L1World.getInstance().broadcastServerMessage("Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}
		//TRICIDTODO: set configurable auto ban
		if (count < 0)
		{
			Account.ban(pc.getAccountName());
			IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_DropItem).");
			L1World.getInstance().broadcastServerMessage("Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}
		
		if (pc.isGhost()) {
			return;
	    } else if (pc.getMapId() > 10000) { 
		pc.sendPackets(new S_ServerMessage(76)); 
		return;
	    }
		
		L1ItemInstance item = pc.getInventory().getItem(objectId);
		
		if (item != null) {
			if (!item.getItem().isTradable()) {
				pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
				return;
			}
						
			if (objectId != item.getId() || (!item.isStackable() && count != 1) || item.getCount() <= 0 || count <= 0 || count > 2000000000 || count > item.getCount()) {
			Account.ban(pc.getAccountName());
			IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_DropItem).");
			L1World.getInstance().broadcastServerMessage("Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
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
			Object[] dollList = pc.getDollList().values().toArray();
			for (Object dollObject : dollList) {
				if (dollObject instanceof L1DollInstance) {
					L1DollInstance doll = (L1DollInstance) dollObject;
					if (doll.getItemObjId() == item.getId()) {
						pc.sendPackets(new S_ServerMessage(1181));
						return;
					}
				}
			}
			if (item.isEquipped()) {
				pc.sendPackets(new S_ServerMessage(125));
				return;
			}
			if (item.getBless() >= 128) {
				pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
				return;
			}
			pc.getInventory().tradeItem(item, count, L1World.getInstance().getInventory(x, y, pc.getMapId()));
			pc.turnOnOffLight();
		}
	}

	@Override
	public String getType() {
		return C_DROP_ITEM;
	}
}
