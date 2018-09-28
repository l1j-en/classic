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

import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1HouseLocation;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1BookMark;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_AddBookmark extends ClientBasePacket {

	private static final String C_ADD_BOOKMARK = "[C] C_AddBookmark";

	public C_AddBookmark(byte[] decrypt, Client client) {
		super(decrypt);
		String s = readS();

		L1PcInstance pc = client.getActiveChar();
		if (pc.isGhost()) {
			return;
		}

		if (pc.getMap().isMarkable() || pc.isGm()) {
			if ((L1CastleLocation.checkInAllWarArea(pc.getX(), pc.getY(),
					pc.getMapId()) || L1HouseLocation.isInHouse(pc.getX(),
					pc.getY(), pc.getMapId()))
					&& !pc.isGm()) {
				pc.sendPackets(new S_ServerMessage(214));
			} else {
				L1BookMark.addBookmark(pc, s);
			}
		} else {
			pc.sendPackets(new S_ServerMessage(214));
		}
	}

	@Override
	public String getType() {
		return C_ADD_BOOKMARK;
	}
}