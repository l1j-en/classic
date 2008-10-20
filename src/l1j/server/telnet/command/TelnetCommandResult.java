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

import java.util.HashMap;
import java.util.Map;

public class TelnetCommandResult {
	private final int _code;
	private final String _codeMessage;
	private final String _result;

	private static final Map<Integer, String> _codeMessages = new HashMap<Integer, String>();

	public static final int CMD_OK = 0;
	public static final int CMD_NOT_FOUND = 1;
	public static final int CMD_INTERNAL_ERROR = 2;

	static {
		_codeMessages.put(CMD_OK, "OK");
		_codeMessages.put(CMD_NOT_FOUND, "Not Found");
		_codeMessages.put(CMD_INTERNAL_ERROR, "Internal Error");
	}

	public TelnetCommandResult(int code, String result) {
		_code = code;
		_result = result;
		_codeMessage = _codeMessages.get(code);
	}

	public int getCode() {
		return _code;
	}

	public String getCodeMessage() {
		return _codeMessage;
	}

	public String getResult() {
		return _result;
	}
}
