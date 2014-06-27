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

import l1j.server.server.ClientThread;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_OwnCharPack;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_Ship extends ClientBasePacket {

	private static final String C_SHIP = "[C] C_Ship";

	public C_Ship(byte abyte0[], ClientThread client) {
		super(abyte0);

		int shipMapId = readH();
		int locX = readH();
		int locY = readH();

		L1PcInstance pc = client.getActiveChar();
		int mapId = pc.getMapId();

		if (mapId == 5) { // Talking Island Ship to Aden Mainland
			pc.getInventory().consumeItem(40299, 1);
		} else if (mapId == 6) { // Aden Mainland Ship to Talking Island
			pc.getInventory().consumeItem(40298, 1);
		} else if (mapId == 83) { // Forgotten Island Ship to Aden Mainland
			pc.getInventory().consumeItem(40300, 1);
		} else if (mapId == 84) { // Aden Mainland Ship to Forgotten Island
			pc.getInventory().consumeItem(40301, 1);
		} else if (mapId == 446) { // Ship Hidden dock to Pirate island
			pc.getInventory().consumeItem(40303, 1);
		} else if (mapId == 447) { // Ship Pirate island to Hidden dock
			pc.getInventory().consumeItem(40302, 1);
		}
		pc.sendPackets(new S_OwnCharPack(pc));
		L1Teleport.teleport(pc, locX, locY, (short) shipMapId, 0, false);
	}

	@Override
	public String getType() {
		return C_SHIP;
	}
}