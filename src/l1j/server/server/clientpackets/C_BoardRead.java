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

import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1BoardInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_BoardRead extends ClientBasePacket {

	private static final String C_BOARD_READ = "[C] C_BoardRead";

	/*
	 * public C_BoardRead(byte decrypt[], Client client) { super(decrypt);
	 * int objId = readD(); int topicNumber = readD(); L1Object obj =
	 * L1World.getInstance().findObject(objId); L1BoardInstance board =
	 * (L1BoardInstance) obj; board.onActionRead(client.getActiveChar(),
	 * topicNumber); }
	 */
	public C_BoardRead(byte decrypt[], Client client) {
		super(decrypt);
		int i = readD();
		L1Object l1object = L1World.getInstance().findObject(i);
		L1BoardInstance board = (L1BoardInstance) l1object;
		L1PcInstance l1pcinstance = client.getActiveChar();
		
		if (board.getNpcTemplate().get_npcId() == 81150)
			board.onRankingRead(l1pcinstance, readD());
		else
			board.onActionRead(l1pcinstance, readD());
	}

	@Override
	public String getType() {
		return C_BOARD_READ;
	}
}
