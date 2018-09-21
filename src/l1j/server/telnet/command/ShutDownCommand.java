package l1j.server.telnet.command;

import l1j.server.server.GameServer;
import l1j.server.server.utils.IntRange;
class ShutDownCommand implements TelnetCommand {
	public static final int CMD_OK = 0;

	@Override
	public TelnetCommandResult execute(String args) {
		int sec = args.isEmpty() ? 0 : Integer.parseInt(args);
		sec = IntRange.ensure(sec, 30, Integer.MAX_VALUE);
		GameServer.getInstance().shutdownWithCountdown(sec);
		return new TelnetCommandResult(CMD_OK, "");
	}
}