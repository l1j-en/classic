package l1j.server.server.command.executor;

import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1SpoofName implements L1CommandExecutor {
	private L1SpoofName() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1SpoofName();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			
			if(arg.toLowerCase().equals("-revert")) {
				pc.setSpoofName(null);
				pc.sendPackets(new S_SystemMessage("Spoofing stopped"));
				
				L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc.getMapId(), 5,
						false);
				return;
			}
			
			L1PcInstance playerToSpoof = L1World.getInstance().getPlayer(arg);
			
			if(playerToSpoof == null) {
				playerToSpoof = CharacterTable.getInstance().restoreCharacter(arg);
			}
			
			if(playerToSpoof == null ||
					playerToSpoof.getAccessLevel().getLevel() < pc.getAccessLevel().getLevel()) {
				pc.setSpoofName(arg);
				
				L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc.getMapId(), 5,
						false);
			} else {
				pc.sendPackets(new S_SystemMessage("You cannot spoof someone with a higher access level than yourself!"));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".spoof <name>"));
		}
	}
}
