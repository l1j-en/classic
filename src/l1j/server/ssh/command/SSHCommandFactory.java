package l1j.server.ssh.command;

import java.util.StringTokenizer;

import org.apache.sshd.common.Factory;
import org.apache.sshd.server.Command;
import org.apache.sshd.server.CommandFactory;

public class SSHCommandFactory implements CommandFactory, Factory<Command> {
	public Command createCommand(String cmd)
	  {
		try {
			StringTokenizer tok = new StringTokenizer(cmd, " ");
			String name = tok.nextToken();

			Commands command = CommandList.get(name);
			
			if (command == null) {
				return new FailCommand(name);
			}

			String args = "";
			if (name.length() + 1 < cmd.length()) {
				args = cmd.substring(name.length() + 1);
			}
			
			return new SSHCommand(command, args);
			
		} catch (Exception e) {
			e.getLocalizedMessage();
			return new FailCommand(cmd);
		}
	  }

	  public Command create()
	  {
	    return createCommand("none");
	  }
}
