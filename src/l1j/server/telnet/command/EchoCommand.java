package l1j.server.telnet.command;
class EchoCommand implements TelnetCommand {
	public static final int CMD_OK = 0;
	@Override
	public TelnetCommandResult execute(String args) {
		return new TelnetCommandResult(CMD_OK, args);
	}
}