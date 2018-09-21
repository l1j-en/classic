package l1j.server.telnet.command;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;

class PlayerIdCommand implements TelnetCommand {
	public static final int CMD_OK = 0;
	@Override
	public TelnetCommandResult execute(String args) {
		L1PcInstance pc = L1World.getInstance().getPlayer(args);
		String result = pc == null ? "0" : String.valueOf(pc.getId());
		return new TelnetCommandResult(CMD_OK, result);
	}
}