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
package l1j.server.server.model;

import l1j.server.Config;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.serverpackets.S_NpcChatPacket;
import l1j.server.server.templates.L1PetType;
import l1j.server.server.utils.IntRange;

public class L1PetFoodTimer implements Runnable {
	
	private static final IntRange _petFoodRange = new IntRange(0, 100);
	private final L1PetInstance _pet;
	
	public L1PetFoodTimer(L1PetInstance pet) throws IllegalArgumentException {
		if (pet == null) {
			throw new IllegalArgumentException("pet is null");
		}
		
		_pet = pet;
	}

	@Override
	public void run() {
		if (_pet.isDead() || _pet.getMaster() == null) {
			return;
		}

		int food = _petFoodRange.ensure(_pet.getFood() - 2);
		_pet.setFood(food);

		if (food == 0 && Config.ALT_PET_HUNGER_STATUS_CHANGE) {
			_pet.setCurrentPetStatus(3);

			L1PetType type = PetTypeTable.getInstance().get(_pet.getNpcTemplate().get_npcId());
			int id = type.getDefyMessageId();
			if (id != 0) {
				_pet.broadcastPacket(new S_NpcChatPacket(_pet, "$" + id, 0));
			}
		}
		
		GeneralThreadPool.getInstance().schedule(this, 200000);
	}
}
