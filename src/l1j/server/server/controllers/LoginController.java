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
package l1j.server.server.controllers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.Account;
import l1j.server.server.AccountAlreadyLoginException;
import l1j.server.server.GameServerFullException;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_ServerMessage;

public class LoginController {
	
	private static Logger _log = LoggerFactory.getLogger(LoginController.class);

	private static LoginController _instance;
	private Map<String, Client> _accounts = new ConcurrentHashMap<String, Client>();
	private int _maxAllowedOnlinePlayers;

	private LoginController() {
	}

	public static LoginController getInstance() {
		if (_instance == null) {
			_instance = new LoginController();
		}
		return _instance;
	}

	public Client[] getAllAccounts() {
		return _accounts.values().toArray(new Client[_accounts.size()]);
	}

	public int getOnlinePlayerCount() {
		return _accounts.size();
	}

	public int getMaxAllowedOnlinePlayers() {
		return _maxAllowedOnlinePlayers;
	}

	public void setMaxAllowedOnlinePlayers(int maxAllowedOnlinePlayers) {
		_maxAllowedOnlinePlayers = maxAllowedOnlinePlayers;
	}

	private void kickClient(final Client client) {
		if (client == null) {
			return;
		}

		GeneralThreadPool.getInstance().execute(new Runnable() {
			@Override
			public void run() {

				try {
					if (client.getActiveChar() != null) {
						client.getActiveChar().sendPackets(new S_ServerMessage(357));
					}
				} catch (Exception e) {
					_log.error("",e);
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				client.kick();
			}
		});
	}

	public synchronized void login(Client client, Account account)
			throws GameServerFullException, AccountAlreadyLoginException {
		if (!account.isValid()) {
			throw new IllegalArgumentException("Invalid account encountered in LoginController.login.");
		}
		if ((getMaxAllowedOnlinePlayers() <= getOnlinePlayerCount()) && !account.isGameMaster()) {
			throw new GameServerFullException();
		}
		if (_accounts.containsKey(account.getName())) {
			kickClient(_accounts.remove(account.getName()));
			throw new AccountAlreadyLoginException();
		}
		_accounts.put(account.getName(), client);
	}

	public synchronized boolean logout(Client client) {
		if (client.getAccountName() == null) {
			return false;
		}
		return _accounts.remove(client.getAccountName()) != null;
	}
}