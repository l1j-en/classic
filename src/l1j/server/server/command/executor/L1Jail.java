package l1j.server.server.command.executor;

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
			L1PcInstance convict = L1World.getInstance().getPlayer(arg);

			if (convict != null) {
				L1Teleport.teleport(convict, 32737, 32796, (short) 99, 5, true);
				convict.sendPackets(new S_SystemMessage(pc.getName()
						+ " jailed you for bad behavior."));
				pc.sendPackets(new S_SystemMessage(arg + " has been jailed."));
			} else {
				pc.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(arg).append(" is not online.").toString()));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(cmdName + " char_name"));
		}
	}
}
