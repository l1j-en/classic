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

import l1j.server.server.Opcodes;
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
			writeS(Integer.toString(pet.get_maxMp())); 
			writeS(Integer.toString(pet.getLevel())); 

			// Character names down more than 8
			// Why? "St. Bernard", "Brave Rabbit" is OK
			// String pet_name = pet.get_name();
			// if (pet_name.equalsIgnoreCase("high doberman")) {
			// pet_name = "High Doberman";
			// }
			// else if (pet_name.equalsIgnoreCase("Saint Bernard High")) {
			// pet_name = "High Saint Bernard";
			// }
			// writeS(pet_name);
			writeS(""); // Pet's name to appear and become unstable, you want to hide
			writeS("$611"); // Too much
			writeS(Integer.toString(exppercet)); // exp
			writeS(Integer.toString(pet.getLawful())); // Alignment
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
			writeS(Integer.toString(summon.get_maxMp()));
			writeS(Integer.toString(summon.getLevel()));
			// writeS(summon.getNpcTemplate().get_nameid());
			// writeS(Integer.toString(0));
			// writeS(Integer.toString(790));
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
