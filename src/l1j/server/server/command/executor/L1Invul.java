package l1j.server.server.command.executor;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Invul implements L1CommandExecutor {
	
	public L1Invul() { }
	
	public static L1CommandExecutor getInstance() {
		return new L1Invul();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			if(arg.trim().toLowerCase().equals("-status")) {				
				pc.sendPackets(new S_SystemMessage("You are currently "
						+ (pc.isGmInvul() ? "invulnerable" : "vulnerable") + "."));
				return;
			}
			
			pc.setGmInvul(!pc.isGmInvul());
			pc.sendPackets(new S_SystemMessage("You are now "
					+ (pc.isGmInvul() ? "invulnerable" : "vulnerable") + "."));
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " [-status]"));
		}
	}
}
