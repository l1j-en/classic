package l1j.server.ssh.command;

import java.util.HashMap;
import java.util.Map;

public class CommandList {
	private static Map<String, Commands> _cmds = new HashMap<String, Commands>();
	
	static {
		_cmds.put("echo", new Echo());
		_cmds.put("playerid", new PlayerId());
		_cmds.put("charstatus", new CharStatus());
		_cmds.put("globalchat", new GlobalChat());
		_cmds.put("shutdown", new ShutDown());
		_cmds.put("createaccount", new CreateAccount());
		_cmds.put("changepassword", new ChangePassword());
		_cmds.put("getonlineplayers", new GetOnlinePlayers());
		_cmds.put("getsiegetimes", new GetSiegeTimes());
		_cmds.put("iprestriction", new ManageIpRestrictions());
		_cmds.put("enable-ip-restriction", new ToggleIpRestriction());
	}
	
	public static Commands get(String name) {
		return _cmds.get(name.toLowerCase());
	}
}
