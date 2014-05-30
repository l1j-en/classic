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

import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_PacketBox;

public class C_NewCharSelect extends ClientBasePacket {
	
	private static final String C_NEW_CHAR_SELECT = "[C] C_NewCharSelect";
	private static Logger _log = Logger.getLogger(C_NewCharSelect.class.getName());

	public C_NewCharSelect(byte[] decrypt, ClientThread client) {
		super(decrypt);
		client.sendPacket(new S_PacketBox(S_PacketBox.LOGOUT)); // 2.70C->3.0
		client.CharReStart(true);
		
		if (client.getActiveChar() != null) {
			L1PcInstance pc = client.getActiveChar();
			_log.info("Disconnect from: " + pc.getName());
			ClientThread.quitGame(pc);
			synchronized (pc) {
				pc.logout();
				client.setActiveChar(null);
			}
		} else {
			_log.info("Disconnect Request From Account : " + client.getAccountName());
		}
	}

	@Override
	public String getType() {
		return C_NEW_CHAR_SELECT;
	}
}