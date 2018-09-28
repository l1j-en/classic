package l1j.server.ssh.command;
class Echo implements Commands {
	@Override
	public String execute(String args) {
		return args;
	}

	@Override
        public String formatMessage(String args) {
                return "Echo with argument: " + args;
        }
}