package l1j.server.ssh.command;

import l1j.server.server.GameServer;
import l1j.server.server.utils.IntRange;

class ShutDown implements Commands {
	@Override
	public String execute(String args) {
		int sec = args.isEmpty() ? 0 : Integer.parseInt(args);
		sec = IntRange.ensure(sec, 30, Integer.MAX_VALUE);
		GameServer.getInstance().shutdownWithCountdown(sec);
		return "";
	}

	@Override
        public String formatMessage(String args) {
                return "ShutDown with a countdown of: " + args;
        }
}