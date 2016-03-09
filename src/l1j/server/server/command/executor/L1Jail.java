package l1j.server.server.command.executor;

import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Jail implements L1CommandExecutor {

	private L1Jail() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Jail();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			if(arg.trim().equals(""))
				throw new Exception();
			
			L1PcInstance convict = L1World.getInstance().getPlayer(arg);

			if (convict != null) {
				L1Teleport.teleport(convict, 32737, 32796, (short) 99, 5, true);
				convict.sendPackets(new S_SystemMessage(pc.getName()
						+ " jailed you for bad behavior."));
				pc.sendPackets(new S_SystemMessage(arg + " has been jailed."));
			} else {
				convict = CharacterTable.getInstance().restoreCharacter(arg);
				
				if(convict == null) {
					pc.sendPackets(new S_SystemMessage("A character with the name '" + arg + "' does not exist."));
					return;
				}
				
				CharacterTable.getInstance().moveCharacter(convict, 32737, 32796, (short) 99);
				
				pc.sendPackets(new S_SystemMessage(convict.getName() + " has been jailed."));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <player_name>"));
		}
	}
}
