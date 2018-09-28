/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */

package l1j.server.server;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.command.L1Commands;
import l1j.server.server.command.executor.L1CommandExecutor;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Command;

// Referenced classes of package l1j.server.server:
// Client, Shutdown, IpTable, MobTable,
// PolyTable, IdFactory
//
public class GMCommands {
	private static Logger _log = LoggerFactory.getLogger(GMCommands.class.getName());

	private static GMCommands _instance;

	private GMCommands() {
	}

	public static GMCommands getInstance() {
		if (_instance == null) {
			_instance = new GMCommands();
		}
		return _instance;
	}

	private String complementClassName(String className) {

		if (className.contains(".")) {
			return className;
		}
		return "l1j.server.server.command.executor." + className;
	}

	private boolean executeDatabaseCommand(L1PcInstance pc, String name,
			String arg) {
		try {
			L1Command command = L1Commands.get(name);
			if (command == null) {
				return false;
			}
			if (pc.getAccessLevel().getLevel() < command.getLevel()) {
				pc.sendPackets(new S_ServerMessage(74, "" + name));
				return true;
			}
			Class<?> cls = Class.forName(complementClassName(command
					.getExecutorClassName()));
			L1CommandExecutor exe = (L1CommandExecutor) cls.getMethod(
					"getInstance").invoke(null);
			exe.execute(pc, name, arg);
			_log.info(pc.getName() + " ran " + name + " " + arg + "");
			return true;
		} catch (Exception e) {
			_log.error("error gm command", e);
		}
		return false;
	}

	public void handleCommands(L1PcInstance gm, String cmdLine) {
		StringTokenizer token = new StringTokenizer(cmdLine);

		String cmd = token.nextToken();
		String param = "";
		while (token.hasMoreTokens()) {
			param = new StringBuilder(param).append(token.nextToken())
					.append(' ').toString();
		}
		param = param.trim();

		if (executeDatabaseCommand(gm, cmd, param)) {
			if (!cmd.equalsIgnoreCase("r")) {
				_lastCommands.put(gm.getId(), cmdLine);
			}
			return;
		}
		if (cmd.equalsIgnoreCase("r")) {
			if (!_lastCommands.containsKey(gm.getId())) {
				gm.sendPackets(new S_ServerMessage(74, "" + cmd));
				return;
			}
			redo(gm, param);
			return;
		}
		gm.sendPackets(new S_SystemMessage("The command " + cmd
				+ " doesn't exist."));
	}

	private static Map<Integer, String> _lastCommands = new HashMap<Integer, String>();

	private void redo(L1PcInstance pc, String arg) {
		try {
			String lastCmd = _lastCommands.get(pc.getId());
			if (arg.isEmpty()) {
				pc.sendPackets(new S_SystemMessage("" + lastCmd + " "));
				handleCommands(pc, lastCmd);
			} else {
				StringTokenizer token = new StringTokenizer(lastCmd);
				String cmd = token.nextToken() + " " + arg;
				pc.sendPackets(new S_SystemMessage("" + cmd + " "));
				handleCommands(pc, cmd);
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
			pc.sendPackets(new S_SystemMessage(""));
		}
	}
}