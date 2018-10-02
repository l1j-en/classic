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
package l1j.server.server.clientpackets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.AccountAlreadyLoginException;
import l1j.server.server.GameServerFullException;
import l1j.server.server.controllers.LoginController;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_CommonNews;
import l1j.server.server.serverpackets.S_LoginResult;
import l1j.server.server.utils.SystemUtil;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_AuthLogin extends ClientBasePacket {
	private static final String C_AUTH_LOGIN = "[C] C_AuthLogin";
	private static Logger _log = LoggerFactory.getLogger(C_AuthLogin.class.getName());

	public C_AuthLogin(byte[] decrypt, Client client) {
		super(decrypt);
		String accountName = readS().toLowerCase();
		String password = readS();
		String ip = client.getIp();
		String host = client.getHostname();

		_log.trace("Request AuthLogin From User : " + accountName);

//		if (!Config.ALLOW_2PC) {
//			for (Client tempClient : LoginController.getInstance()
//					.getAllAccounts()) {
//				if (ip.equalsIgnoreCase(tempClient.getIp())) {
//					_log.info("2nd PC Login On Account = " + accountName
//							+ " Host = " + host);
//					client.sendPacket(new S_LoginResult(
//							S_LoginResult.REASON_USER_OR_PASS_WRONG));
//					return;
//				}
//			}
//		}

		Account account = Account.load(accountName);
		if (account == null) {
			if (Config.AUTO_CREATE_ACCOUNTS) {
				account = Account.create(accountName, password, ip, host);
			} else {
				_log.info("Account Missing For User " + accountName);
			}
		}
		
		if (account == null || !account.validatePassword(password)) {
			client.sendPacket(new S_LoginResult(
					S_LoginResult.REASON_USER_OR_PASS_WRONG));
			
			String tmpAccountName = "--NoAccountAvail--";
			
			if(account != null) {
				tmpAccountName = account.getName();
			}
			
			_log.info("Wrong password - account: " + tmpAccountName + ", IP: " + client.getIp());
			return;
		}

		if (account.isBanned()) { // BAN
			_log.info("Banned Account Attempted Login: Account = "
					+ accountName + " Host = " + host);
			client.sendPacket(new S_CommonNews("Your account has been banned."));
			client.setDisconnectNextClick(true);
			return;
		}

		if(Config.RESTRICT_ACCOUNT_IPS && account.isIpRestricted() && !account.validateIp(ip)) {
			client.sendPacket(new S_CommonNews(Config.RESTRICT_ACCOUNT_IPS_MESSAGE));
			_log.info("Invalid IP to login - account: " + account.getName() + ", IP: " + client.getIp());
			client.setDisconnectNextClick(true);
			return;
		}

		try {
			LoginController.getInstance().login(client, account);
			Account.updateLastActive(account);
			client.setAccount(account);
			client.setDisconnectNextClick(false); // ensure the disconnect flag isn't set when they login
			client.sendPacket(new S_LoginResult(S_LoginResult.REASON_LOGIN_OK));
			client.sendPacket(new S_CommonNews());
			_log.info("Account login: account=" + account.getName()
					+ " host=" + client.getHostname() + " Current Memory: "
					+ SystemUtil.getUsedMemoryMB() + "MB RAM");
		} catch (GameServerFullException e) {
			client.kick();
			_log.info("Connection Terminated (" + client.getHostname()
					+ ") Server Is Full.");
			return;
		} catch (AccountAlreadyLoginException e) {
			client.kick();
			_log.info("Account Allready Loggedin (" + client.getHostname()
					+ ") Connection Refused.");
			return;
		}
	}

	@Override
	public String getType() {
		return C_AUTH_LOGIN;
	}
}