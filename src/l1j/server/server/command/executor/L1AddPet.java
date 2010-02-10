package l1j.server.server.command.executor;

import java.util.StringTokenizer;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.serverpackets.S_ItemName;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Pet;
import l1j.server.server.utils.CalcExp;
import l1j.server.server.utils.IntRange;

public class L1AddPet implements L1CommandExecutor {
	private L1AddPet() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1AddPet();
	}
	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		
		//}
		//private void pet(L1PcInstance pc, String param) {//TODO
		boolean done=false;
		try {
			StringTokenizer tok = new StringTokenizer(arg);
			int petId = Integer.parseInt(tok.nextToken());
			int level=0;
			int number=1;
			if(tok.hasMoreTokens()) {
				level = Integer.parseInt(tok.nextToken());
			}
			if(tok.hasMoreTokens()) {
				number = Integer.parseInt(tok.nextToken());
			}
			L1PcInventory inv = pc.getInventory();

			for(int i=0; i<number; i++) {
				L1NpcInstance target = new L1NpcInstance(NpcTable.getInstance().getTemplate(petId));
				L1ItemInstance petamu;
				if(target.getName().startsWith("High ")) {
					petamu = inv.storeItem(40316, 1);
				}
				else if (target.getName().startsWith("Battle ")){
					petamu = inv.storeItem(40316, 1);
				}
				else if (target.getName().endsWith(" Dog")){
					petamu = inv.storeItem(40316, 1);
				} else {
					petamu = inv.storeItem(40314, 1);
				}
				
				if (petamu != null) {
					L1PetInstance pet = new L1PetInstance(target, pc, petamu.getId());
					pc.getPetList().remove(pet.getId());
					withdrawPet( pc, pet, pet.getItemObjId(), level);
					L1ItemInstance item = pc.getInventory().getItem(pet.getItemObjId());
					pc.getInventory().updateItem(item);
					pc.sendPackets(new S_ItemName(petamu));
					done=true;
				}
			}
		} catch (Exception e) {
			
		}
		if(!done) {
			pc.sendPackets(new S_SystemMessage("That is not an npc that can be made into a Pet."));
			pc.sendPackets(new S_SystemMessage(".pet npcId (level) (count)"));
		}
	}
	  
	private void withdrawPet(L1PcInstance pc, L1PetInstance newpet, int itemObjectId, int petlevel) {
		if(petlevel != 0 && !(newpet.getLevel()>=petlevel)) {
			if (!IntRange.includes(petlevel, 1, 99)) {
				pc.sendPackets(new S_SystemMessage("Level should be between 1 and 99"));
				pc.sendPackets(new S_SystemMessage(".pet npcId (level) (count)"));
				return;
			} else {
				CalcExp.LevelPet(newpet, petlevel);
			}
		}
		L1Pet l1pet = PetTable.getInstance().getTemplate(itemObjectId);
		if (l1pet != null) {
			L1Npc npcTemp = NpcTable.getInstance().getTemplate(l1pet.get_npcid());
			L1PetInstance pet = new L1PetInstance(npcTemp, pc, l1pet);
		}
	}
}
