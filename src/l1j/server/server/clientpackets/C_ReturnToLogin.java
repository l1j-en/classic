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

import l1j.server.server.controllers.LoginController;
import l1j.server.server.network.Client;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_ReturnToLogin extends ClientBasePacket {

	private static Logger _log = LoggerFactory.getLogger(C_ReturnToLogin.class
			.getName());

	public C_ReturnToLogin(byte decrypt[], Client client)
			throws Exception {
		super(decrypt);
		String account = client.getAccountName();
		_log.trace((new StringBuilder()).append("Account: ").append(account)
				.toString());
		LoginController.getInstance().logout(client);
		client.setAccount(null);
	}

	@Override
	public String getType() {
		return "[C] C_ReturnToLogin";
	}
}