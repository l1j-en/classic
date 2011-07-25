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
package l1j.server.server.command.executor;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.CalcExp;
import l1j.server.server.utils.IntRange;
import l1j.server.server.serverpackets.S_ItemName;

public class L1AddPet implements L1CommandExecutor {
	private static Logger _log = Logger.getLogger(L1AddPet.class.getName());

	private L1AddPet() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1AddPet();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
			boolean done = false;
			
			try {
				StringTokenizer tok = new StringTokenizer(arg);
				int petId = Integer.parseInt(tok.nextToken());
				int level = 0;
				int number = 1;
				if(tok.hasMoreTokens()) {
					level = Integer.parseInt(tok.nextToken());
				}
				if(tok.hasMoreTokens()) {
					number = Integer.parseInt(tok.nextToken());
				}
				L1PcInventory inv = pc.getInventory();

				for (int i = 0; i < number; i++) {
					L1NpcInstance target = new L1NpcInstance(NpcTable.getInstance().getTemplate(petId));
					L1ItemInstance petamu;
					if(target.getName().startsWith("High")) {
						petamu = inv.storeItem(40316, 1);
					} else {
						petamu = inv.storeItem(40314, 1);
					}
					
					L1PetInstance pet;
					
					if (petamu != null) {
						pet = new L1PetInstance(target, pc, petamu.getId());
						pc.sendPackets(new S_ItemName(petamu));
						done = true;
					if(level != 0 && !(pet.getLevel() >= level)) {
							if (!IntRange.includes(level, 1, 99)) {
								pc.sendPackets(new S_SystemMessage(cmdName + "Level should be between 1 and 99"));
								pc.sendPackets(new S_SystemMessage(cmdName + ".pet npcId (level) (count)"));
								return;
							} else {
								CalcExp.AddExpPet(pet, level);
							}
						}
					}
				}
			} catch (Exception e) {
			}
			if(!done) {
				pc.sendPackets(new S_SystemMessage("That is not an npc that can be made into a Pet."));
				pc.sendPackets(new S_SystemMessage(".pet npcId (level) (count)"));
			}
		}
}