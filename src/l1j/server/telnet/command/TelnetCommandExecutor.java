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
package l1j.server.telnet.command;

import java.util.StringTokenizer;
import static l1j.server.telnet.command.TelnetCommandResult.*;

public class TelnetCommandExecutor {
	private static TelnetCommandExecutor _instance = new TelnetCommandExecutor();

	public static TelnetCommandExecutor getInstance() {
		return _instance;
	}

	public TelnetCommandResult execute(String cmd) {
		try {
			StringTokenizer tok = new StringTokenizer(cmd, " ");
			String name = tok.nextToken();

			TelnetCommand command = TelnetCommandList.get(name);
			if (command == null) {
				return new TelnetCommandResult(CMD_NOT_FOUND, cmd
						+ " not found");
			}

			String args = "";
			if (name.length() + 1 < cmd.length()) {
				args = cmd.substring(name.length() + 1);
			}
			return command.execute(args);
		} catch (Exception e) {
			return new TelnetCommandResult(CMD_INTERNAL_ERROR, e
					.getLocalizedMessage());
		}
	}
}
