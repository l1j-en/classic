package l1j.server.server.command.executor;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1AppearOffline implements L1CommandExecutor {

	private L1AppearOffline() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1AppearOffline();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			pc.setGmAppearOffline(!pc.isGmAppearOffline());
			
			pc.sendPackets(new S_SystemMessage(
					String.format("You now appear %s.", pc.isGmAppearOffline() ? "offline" : "online")));

		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(cmdName + " "));
		}
	}
}