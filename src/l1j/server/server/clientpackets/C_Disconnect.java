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

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.utils.SystemUtil;

public class C_Disconnect extends ClientBasePacket {
	private static final String C_DISCONNECT = "[C] C_Disconnect";
	private static Logger _log = LoggerFactory.getLogger(C_Disconnect.class.getName());

	public C_Disconnect(byte[] decrypt, Client client) {
		super(decrypt);
		client.CharReStart(true);
		L1PcInstance pc = client.getActiveChar();

		if (pc != null) {
			_log.info("Disconnect From: char=" + pc.getName() + " account="
					+ pc.getAccountName() + " host=" + client.getHostname()
					+ " Current Memory: " + SystemUtil.getUsedMemoryMB() + "MB RAM");

			Client.quitGame(pc, client.getLastActiveCharName());
			synchronized (pc) {
				pc.logout();
				client.setActiveChar(null);
			}
		} else {
			_log.info("Disconnect From: account=" + client.getAccountName()
					+ " host=" + client.getHostname()
					+ " Current Memory: " + SystemUtil.getUsedMemoryMB() + "MB RAM");
		}
	}

	@Override
	public String getType() {
		return C_DISCONNECT;
	}
}