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

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_PetEquipment;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Item;

public class C_UsePetItem extends ClientBasePacket {

	private static final String C_USE_PET_ITEM = "[C] C_UsePetItem";

	private static final S_ServerMessage CantMessage = new S_ServerMessage(79);

	public C_UsePetItem(byte abyte0[], Client client)
			throws Exception {
		super(abyte0);

		int data = readC();
		int petId = readD();
		int listNo = readC();

		L1PetInstance pet = (L1PetInstance) L1World.getInstance().findObject(
				petId);
		L1PcInstance pc = client.getActiveChar();

		if (pet == null || pc == null) {
			return;
		}
		L1ItemInstance item = pet.getInventory().getItems().get(listNo);
		if (item == null) {
			return;
		}

		L1Item template = item.getItem();
		if (template.getType2() == 0 && template.getType() == 11) { // petitem
			int itemId = template.getItemId();
			if (itemId >= 40749 && itemId <= 40752 || itemId >= 40756
					&& itemId <= 40758) {
				usePetWeapon(pc, pet, item);
				pc.sendPackets(new S_PetEquipment(data, pet, listNo));
			} else if (itemId >= 40761 && itemId <= 40766) {
				usePetArmor(pc, pet, item);
				pc.sendPackets(new S_PetEquipment(data, pet, listNo));
			} else {
				pc.sendPackets(CantMessage);
			}
		} else {
			pc.sendPackets(CantMessage);
		}
	}

	private void usePetWeapon(L1PcInstance pc, L1PetInstance pet,
			L1ItemInstance weapon) {
		if (pet.getWeapon() == null) {

			setPetWeapon(pc, pet, weapon);
		} else {
			if (pet.getWeapon().equals(weapon)) {
				pet.removeWeapon(weapon);
			} else {
				pet.removeWeapon(pet.getWeapon());
				setPetWeapon(pc, pet, weapon);
			}
		}
	}

	private void usePetArmor(L1PcInstance pc, L1PetInstance pet,
			L1ItemInstance armor) {
		if (pet.getArmor() == null) {
			setPetArmor(pc, pet, armor);
		} else {
			if (pet.getArmor().equals(armor)) {
				pet.removeArmor(armor);
			} else {
				pet.removeArmor(pet.getArmor());
				setPetArmor(pc, pet, armor);
			}
		}
	}

	private void setPetWeapon(L1PcInstance pc, L1PetInstance pet,
			L1ItemInstance weapon) {
		pet.setWeapon(weapon);

	}

	private void setPetArmor(L1PcInstance pc, L1PetInstance pet,
			L1ItemInstance armor) {
		pet.setArmor(armor);

	}

	@Override
	public String getType() {
		return C_USE_PET_ITEM;
	}
}
