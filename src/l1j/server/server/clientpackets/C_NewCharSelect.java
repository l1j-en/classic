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
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.utils.SystemUtil;

public class C_NewCharSelect extends ClientBasePacket {

	private static final String C_NEW_CHAR_SELECT = "[C] C_NewCharSelect";
	private static Logger _log = LoggerFactory.getLogger(C_NewCharSelect.class.getName());
	private boolean _expectClick;
	
	public boolean isExpectingClick() {
		return _expectClick;
	}

	public C_NewCharSelect(byte[] decrypt, Client client) {
		super(decrypt);
		
		L1PcInstance player = client.getActiveChar();
		
		if(player != null) {
			long lastAggressiveAct = player.getLastAggressiveAct();
			long delayAmount = Config.NON_AGGRO_LOGOUT_TIMER - (System.currentTimeMillis() - lastAggressiveAct);
			
			if(delayAmount > 0) {
				return;
			}
		}
		
		client.sendPacket(new S_PacketBox(S_PacketBox.LOGOUT)); // 2.70C->3.0
		_expectClick = true;
		client.CharReStart(true);

		if (client.getActiveChar() != null) {
			L1PcInstance pc = client.getActiveChar();
			_log.info("Logout from: char=" + pc.getName() + " account="
			+ pc.getAccountName() + " host=" + client.getHostname()
			+ " Current Memory: " + SystemUtil.getUsedMemoryMB() + "MB RAM");
			Client.quitGame(pc, client.getLastActiveCharName());
			synchronized (pc) {
				pc.logout();
				client.setActiveChar(null);
			}
		} else {
			_log.info("Disconnect Request From Account : "
					+ client.getAccountName());
		}
	}

	@Override
	public String getType() {
		return C_NEW_CHAR_SELECT;
	}
}