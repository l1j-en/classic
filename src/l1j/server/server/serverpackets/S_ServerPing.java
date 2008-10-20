/* This program is free software; you can redistribute it and/or modify
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
package l1j.server.server.serverpackets;

import l1j.server.server.ClientThread;
import l1j.server.server.clientpackets.ClientBasePacket;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_PingPacket;

// Referenced classes of package l1j.server.server.serverpackets:
// ClientBasePacket

public class S_ServerPing extends ClientBasePacket {
	private static final String S_ServerPing = "[S] S_ServerPing";

	public S_ServerPing(byte encrypt[], ClientThread server) {
		super(encrypt);
		// XXX:ServerPingTime Send)
		L1PcInstance pc = server.getActiveChar();
		pc.sendPackets(new S_PingPacket());
	}

	@Override
	public String getType() {
		return S_ServerPing;
	}
}