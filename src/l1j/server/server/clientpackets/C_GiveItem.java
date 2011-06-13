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
import java.util.Random;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.serverpackets.S_ItemName;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1PetType;

public class C_GiveItem extends ClientBasePacket {

	private static Logger _log = Logger.getLogger(C_GiveItem.class.getName());
	private static final String C_GIVE_ITEM = "[C] C_GiveItem";
	private static Random _random = new Random();

	public C_GiveItem(byte decrypt[], ClientThread client) {
		super(decrypt);
		int targetId = readD();
		@SuppressWarnings("unused")
		int x = readH();
		int y = readH();
		int itemId = readD();
		int count = readD();

		L1PcInstance pc = client.getActiveChar();
		//TRICIDTODO: set configurable auto ban
		if (count < 0)
		{
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_GiveItem).");
			return;
		}

		if (pc.isGhost()) {
			return;
		}

		L1Object object = L1World.getInstance().findObject(targetId);
		if (object == null || !(object instanceof L1NpcInstance)) {
			return;
		}
		L1NpcInstance target = (L1NpcInstance) object;
		if (!isNpcItemReceivable(target.getNpcTemplate())) {
			return;
		}
		L1Inventory targetInv = target.getInventory();

		L1Inventory inv = pc.getInventory();
		L1ItemInstance item = inv.getItem(itemId);
		if (item == null) {
			return;
		}
		if (item.isEquipped()) {
			pc.sendPackets(new S_ServerMessage(141)); 
			return;
		}
		if (!item.getItem().isTradable()) {
			pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
			return;
		}
		if (item.getBless() >= 128) {
			pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
			return;
		}
		for (Object petObject : pc.getPetList().values()) {
			if (petObject instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) petObject;
				if (item.getId() == pet.getItemObjId()) {
					pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
					return;
				}
			}
		}
		if (targetInv.checkAddItem(item, count) != L1Inventory.OK) {
			pc.sendPackets(new S_ServerMessage(942)); 
			return;
		}
		item = inv.tradeItem(item, count, targetInv);
		
		target.onGetItem(item);
		target.turnOnOffLight();
		
		pc.turnOnOffLight();
		
		L1PetType petType = PetTypeTable.getInstance().get(target.getNpcTemplate().get_npcId());
		if (petType == null || target.isDead()) {
			return;
		}

		if (item.getItemId() == petType.getItemIdForTaming()) {
			tamePet(pc, target);
		}
		
		if (item.getItemId() == 40070 && petType.canEvolve()) {
			evolvePet(pc, target);
		}
	}

	private final static String receivableImpls[] = new String[] { "L1Npc", "L1Monster", "L1Guardian", "L1Teleporter", "L1Guard" }; 

	private boolean isNpcItemReceivable(L1Npc npc) {
		for (String impl : receivableImpls) {
			if (npc.getImpl().equals(impl)) {
			return true;
			}
		}
		return false;
	}

	private void tamePet(L1PcInstance pc, L1NpcInstance target) {
		if (target instanceof L1PetInstance || target instanceof L1SummonInstance) {
			return;
		}

		int petcost = 0;
		Object[] petlist = pc.getPetList().values().toArray();
		for (Object pet : petlist) {
		petcost += ((L1NpcInstance) pet).getPetcost();
		}
		int charisma = pc.getCha();
		if (pc.isCrown()) {
			charisma += 6;
		} else if (pc.isElf()) {
			charisma += 12;
		} else if (pc.isWizard()) {
			charisma += 6;
		} else if (pc.isDarkelf()) {
			charisma += 6;
		} else if (pc.isDragonKnight()) {
			charisma += 6;
		} else if (pc.isIllusionist()) {
			charisma += 6;
		}
		charisma -= petcost;
		L1PcInventory inv = pc.getInventory();
		
		if (charisma >= 6 && inv.getSize() < 180) {
			if (isTamePet(target)) {
				L1ItemInstance petamu = inv.storeItem(40314, 1);
				if (petamu != null) {
					new L1PetInstance(target, pc, petamu.getId());
					pc.sendPackets(new S_ItemName(petamu));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(324)); 
			}
		}
	}

	private void evolvePet(L1PcInstance pc, L1NpcInstance target) {
		if (!(target instanceof L1PetInstance)) {
		return;
		}
		L1PcInventory inv = pc.getInventory();
		L1PetInstance pet = (L1PetInstance) target;
		L1ItemInstance petamu = inv.getItem(pet.getItemObjId());
		if (pet.getLevel() >= 30 && pc == pet.getMaster() && petamu != null) {
			L1ItemInstance highpetamu = inv.storeItem(40316, 1);
			if (highpetamu != null) {
				pet.evolvePet(highpetamu.getId());
				pc.sendPackets(new S_ItemName(highpetamu));
				inv.removeItem(petamu, 1);
			}
		}
	}

	private boolean isTamePet(L1NpcInstance npc) {
		boolean isSuccess = false;
		int npcId = npc.getNpcTemplate().get_npcId();
		
		if (npcId == 45313) {
			if (npc.getMaxHp() / 3 > npc.getCurrentHp() && _random.nextInt(16) == 15) {
				isSuccess = true;
			}
		} else {
			if (npc.getMaxHp() / 3 > npc.getCurrentHp()) {
				isSuccess = true;
			}
		}

		if (npcId == 45313 || npcId == 45044 || npcId == 45711) {
			if (npc.isResurrect()) { 
				isSuccess = false;
			}
		}
		return isSuccess;
	}

	@Override
	public String getType() {
		return C_GIVE_ITEM;
	}
}