package l1j.server.ssh.command;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;

class PlayerId implements Commands {
	@Override
	public String execute(String args) {
		L1PcInstance pc = L1World.getInstance().getPlayer(args);
		String result = pc == null ? "0" : String.valueOf(pc.getId());
		return result;
	}

	@Override
        public String formatMessage(String args) {
                return "PlayerId with objectid: " + args;
        }
}