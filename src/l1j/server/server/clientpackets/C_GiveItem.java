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

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.log.LogGiveItem;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_ItemName;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1PetType;

public class C_GiveItem extends ClientBasePacket {

	private static Logger _log = LoggerFactory.getLogger(C_GiveItem.class.getName());
	private static final String C_GIVE_ITEM = "[C] C_GiveItem";

	public C_GiveItem(byte decrypt[], Client client) {
		super(decrypt);
		int targetId = readD();
		@SuppressWarnings("unused")
		int x = readH();
		readH(); // y
		int itemId = readD();
		int count = readD();

		L1PcInstance pc = client.getActiveChar();
		// additional dupe checks. Thanks Mike
		if (pc.getOnlineStatus() != 1) {
			if (Config.AUTO_BAN) {
				Account.ban(pc.getAccountName(), "AutoBan", "GiveItem Dupe Check Player Offline");
				IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			}
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_GiveItem).");
			L1World.getInstance().broadcastServerMessage(
					"Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
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
		// TRICIDTODO: set configurable auto ban
		if ((!item.isStackable() && count != 1) || item.getCount() <= 0
				|| count <= 0 || count > 2000000000 || count > item.getCount()) {
			if (Config.AUTO_BAN) {
				Account.ban(pc.getAccountName(), "AutoBan", "GiveItem Dupe Check Count Mixup");
				IpTable.getInstance().banIp(pc.getNetConnection().getIp());
			}
			
			_log.info(pc.getName() + " Attempted Dupe Exploit (C_GiveItem).");
			L1World.getInstance().broadcastServerMessage(
					"Player " + pc.getName() + " Attempted A Dupe exploit!");
			pc.sendPackets(new S_Disconnect());
			return;
		}
		
		if(!pc.isGm() && Config.STOP_DROP) {
			pc.sendPackets(new S_SystemMessage("Dropping items has been temporarily disabled."));
			return;
		} //end if
		
		if (itemId != item.getId()) {
			_log.warn(pc.getName() + " had item " + Integer.toString(itemId)
					+ " not match.");
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
					pc.sendPackets(new S_ServerMessage(210, item.getItem()
							.getName()));
					return;
				}
			}
		}
		if (targetInv.checkAddItem(item, count) != L1Inventory.OK) {
			pc.sendPackets(new S_ServerMessage(942));
			return;
		}
		// wrap in try/catch because we don't want it to crap out the 
		// actual trade
		int before_target_inv = 0;
		int before_inv = pc.getInventory().getItem(item.getId()).getCount();
		
		try {
			before_target_inv = targetInv.countItems(item.getItemId());
		} catch(Exception ex) {
			_log.warn(String.format("%s Dropped item %s. But it failed to get the count from the target inventory!",
					pc.getName(), item.getName(), item.getCount()));
		}
		
		item = inv.tradeItem(item, count, targetInv);
		
		try {
			L1ItemInstance pcitem = pc.getInventory().getItem(itemId);
			int after_inv = 0;
			if (pcitem != null) {
				after_inv = pcitem.getCount();
			}
			
			int after_target_inv = item.getCount();
			
			LogGiveItem giveItemLog = new LogGiveItem();
			giveItemLog.storeLogGiveItem(pc, target, item,
					before_inv, after_inv, before_target_inv, after_target_inv, count);
		} catch(Exception ex) {
			_log.warn(String.format("%s Dropped item %s (%d). But it failed to log!",
					pc.getName(), item.getName(), item.getCount()));
		}
		
		target.onGetItem(item, count);
		target.turnOnOffLight();

		pc.turnOnOffLight();

		L1PetType petType = PetTypeTable.getInstance().get(
				target.getNpcTemplate().get_npcId());
		if (petType == null || target.isDead()) {
			return;
		}

		if (item.getItemId() == petType.getItemIdForTaming()) {
			tamePet(pc, target);
		}
		
		/*
		 * if (item.getItemId() == 40070 && petType.canEvolve()) { evolvePet(pc,
		 * target); } }
		 */

		if (item.getItemId() == 40070 && petType.canEvolve()) {
			if (petType.getBaseNpcId() == 45686
					|| petType.getBaseNpcId() == 45687
					|| petType.getBaseNpcId() == 45688
					|| petType.getBaseNpcId() == 45689
					|| petType.getBaseNpcId() == 45690
					|| petType.getBaseNpcId() == 45691
					|| petType.getBaseNpcId() == 45692
					|| petType.getBaseNpcId() == 45693
					|| petType.getBaseNpcId() == 45694
					|| petType.getBaseNpcId() == 45695
					|| petType.getBaseNpcId() == 45696
					|| petType.getBaseNpcId() == 45697
					|| petType.getBaseNpcId() == 45710
					|| petType.getBaseNpcId() == 45712) {

				return;
			} else {
				evolvePet(pc, target, 40070);
			}
		}
		if (item.getItemId() == 41310 && petType.canEvolve()) { // added for
																// Golden Dragon
			if (petType.getBaseNpcId() == 45034
					|| petType.getBaseNpcId() == 45039
					|| petType.getBaseNpcId() == 45040
					|| petType.getBaseNpcId() == 45042
					|| petType.getBaseNpcId() == 45043
					|| petType.getBaseNpcId() == 45044
					|| petType.getBaseNpcId() == 45046
					|| petType.getBaseNpcId() == 45047
					|| petType.getBaseNpcId() == 45048
					|| petType.getBaseNpcId() == 45049
					|| petType.getBaseNpcId() == 45053
					|| petType.getBaseNpcId() == 45054
					|| petType.getBaseNpcId() == 45313
					|| petType.getBaseNpcId() == 45712) {

				return;
			} else {
				evolvePet(pc, target, 41310);
			}
		}
	}

	private final static String receivableImpls[] = new String[] { "L1Npc",
			"L1Monster", "L1Guardian", "L1Teleporter", "L1Guard" };

	private boolean isNpcItemReceivable(L1Npc npc) {
		for (String impl : receivableImpls) {
			if (npc.getImpl().equals(impl)) {
				return true;
			}
		}
		return false;
	}

	private void tamePet(L1PcInstance pc, L1NpcInstance target) {
		if (target instanceof L1PetInstance
				|| target instanceof L1SummonInstance) {
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

	private void evolvePet(L1PcInstance pc, L1NpcInstance target, int evolveItemId) {
		if (!(target instanceof L1PetInstance)) {
			return;
		}
		L1PcInventory inv = pc.getInventory();
		L1PetInstance pet = (L1PetInstance) target;
		L1ItemInstance petamu = inv.getItem(pet.getItemObjId());
		if (pet.getLevel() >= 30 && pc == pet.getMaster() && petamu != null) {
			L1ItemInstance highpetamu = inv.storeItem(40316, 1);
			if (highpetamu != null) {
				
				L1ItemInstance evolveItem = pet.getInventory().findItemId(evolveItemId);
				if(evolveItem == null) {
					return;
				}
				
				pet.getInventory().removeItem(evolveItem);
				
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
			if (npc.getMaxHp() / 3 > npc.getCurrentHp()
					&& ThreadLocalRandom.current().nextInt(16) == 15) {
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
