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
package l1j.server.telnet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import l1j.server.Config;

public class TelnetServer {
	private static TelnetServer _instance;

	private class ServerThread extends Thread {
		ServerSocket _sock;

		@Override
		public void run() {
			try {
				_sock = new ServerSocket(Config.TELNET_SERVER_PORT);

				while (true) {
					Socket sock = _sock.accept();
					new TelnetConnection(sock);
				}
			} catch (IOException e) {
			}
			try {
				_sock.close();
			} catch (IOException e) {
			}
		}
	}

	private TelnetServer() {
	}

	public void start() {
		new ServerThread().start();
	}

	public static TelnetServer getInstance() {
		if (_instance == null) {
			_instance = new TelnetServer();
		}
		return _instance;
	}
}
