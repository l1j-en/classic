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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.LoginController;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_ReturnToLogin extends ClientBasePacket {

	private static final String C_RETURN_TO_LOGIN = "[C] C_ReturnToLogin";
	private static Logger log = Logger.getLogger(C_ReturnToLogin.class
			.getName());

	public C_ReturnToLogin(byte decrypt[], ClientThread client)
			throws Exception {
		super(decrypt);
		String account = client.getAccountName();
		log.log(Level.DEBUG, (new StringBuilder()).append("account : ").append(account)
				.toString());

	}

	@Override
	public String getType() {
		return "[C] C_ReturnToLogin";
	}

}
