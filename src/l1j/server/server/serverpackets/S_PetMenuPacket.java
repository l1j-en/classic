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
package l1j.server.server.serverpackets;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;

public class S_PetMenuPacket extends ServerBasePacket {
	private byte[] _byte = null;

	public S_PetMenuPacket(L1NpcInstance npc, int exppercet) {
		buildpacket(npc, exppercet);
	}

	private void buildpacket(L1NpcInstance npc, int exppercet) {
		writeC(Opcodes.S_OPCODE_SHOWHTML);
		if (npc instanceof L1PetInstance) {
			L1PetInstance pet = (L1PetInstance) npc;
			writeD(pet.getId());
			writeS("anicom");
			writeC(0x00);
			writeH(10);
			switch (pet.getCurrentPetStatus()) {
			case 1:
				writeS("$469"); // Offensive
				break;
			case 2:
				writeS("$470"); // Defensive position
				break;
			case 3:
				writeS("$471"); // Break
				break;
			case 5:
				writeS("$472"); // Warning
				break;
			default:
				writeS("$471"); // Break
				break;
			}
			writeS(Integer.toString(pet.getCurrentHp())); // Current HP
			writeS(Integer.toString(pet.getMaxHp()));
			writeS(Integer.toString(pet.getCurrentMp()));
			writeS(Integer.toString(pet.getMaxMp()));
			writeS(Integer.toString(pet.getLevel()));
			writeS(pet.getName()); 
			
			String message = "$610";
			if (pet.getFood() > 80) {
				message = "$612"; // Very full
			} else if (pet.getFood() > 60) {
				message = "$611"; // A little full
			} else if (pet.getFood() > 30) {
				message = "$610"; // Neither hungry nor full
			} else if (pet.getFood() > 10) {
				message = "$609"; // A little hungry
			} else if (pet.getFood() >= 0) {
				message = "$608"; // Very hungry
			}
			
			writeS(message);
			writeS(Integer.toString(exppercet)); // exp
			writeS(Integer.toString(pet.getLawful())); // Alignment
			writeS("50");
		} else if (npc instanceof L1SummonInstance) { // summon monster
			L1SummonInstance summon = (L1SummonInstance) npc;
			writeD(summon.getId());
			writeS("moncom");
			writeC(0x00);
			writeH(6); // Character design in the number of arguments
			switch (summon.get_currentPetStatus()) {
			case 1:
				writeS("$469"); // Offensive
				break;
			case 2:
				writeS("$470"); // Defensive
				break;
			case 3:
				writeS("$471"); // break
				break;
			case 5:
				writeS("$472"); // warning
				break;
			default:
				writeS("$471"); // break
				break;
			}
			writeS(Integer.toString(summon.getCurrentHp()));
			writeS(Integer.toString(summon.getMaxHp()));
			writeS(Integer.toString(summon.getCurrentMp()));
			writeS(Integer.toString(summon.getMaxMp()));
			writeS(Integer.toString(summon.getLevel()));
		}
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		}

		return _byte;
	}
}