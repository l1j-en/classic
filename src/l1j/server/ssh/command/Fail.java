package l1j.server.ssh.command;
class Fail implements Commands {
	@Override
	public String execute(String args) {
		return args + "command doesn't exist.";
	}

	@Override
	public String formatMessage(String args) {
		return "Unknown";
	}
}