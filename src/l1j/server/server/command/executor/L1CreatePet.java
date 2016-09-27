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

import java.util.Map;

import l1j.server.server.datatables.ExpTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ItemName;
import l1j.server.server.serverpackets.S_RawStringDialog;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1PetType;

public class L1CreatePet implements L1CommandExecutor {
	public static L1CommandExecutor getInstance() {
		return new L1CreatePet();
	}
	
	@Override
	public void execute(L1PcInstance pc, String commandName, String arg) {
		try {
			String petTypeName = "";
			int level = -1;
			String[] args = arg.split(" ");
			
			for(int i = 0; i < args.length - 1; i++) {
				petTypeName += args[i] + " ";
			}
			petTypeName = petTypeName.trim();
			level = Integer.parseInt(args[args.length - 1]);
			
			int templateId = -1;
			
			for (Map.Entry<Integer, L1PetType> entry : PetTypeTable.getInstance().GetPetTypes().entrySet())
			{
				if(petTypeName.toLowerCase().equals(entry.getValue().getName().toLowerCase())) {
					templateId = entry.getKey();
				}
			}
			
			// means nothing was found, so lets help them out by giving them a list
			if(templateId == -1) {
				String list = "";
				
				for (Map.Entry<Integer, L1PetType> entry : PetTypeTable.getInstance().GetPetTypes().entrySet())
				{
					list += entry.getValue().getName() + ", ";
				}
				
				list = list.substring(0, list.length() - 2);
				
				pc.sendPackets(new S_SystemMessage(String.format("No match found for '%s'.", petTypeName)));
				pc.sendPackets(new S_RawStringDialog(pc.getId(), "Try one of the following", list));
				return;
			} 
			
			L1PcInventory inv = pc.getInventory();
			L1ItemInstance petamu = inv.storeItem(40314, 1);
			PetTable.getInstance().buyNewPet(templateId, petamu.getId() + 1, petamu.getId(), level, ExpTable.getExpByLevel(level));
			pc.sendPackets(new S_ItemName(petamu));
			pc.sendPackets(new S_SystemMessage(String.format("Created a %s at level %d", petTypeName, level)));
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage(".createpet <pet_type_name> <level>"));
		}
	}
}
