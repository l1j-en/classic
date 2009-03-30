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

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_NPCTalkAction extends ClientBasePacket {

	private static final String C_NPC_TALK_ACTION = "[C] C_NPCTalkAction";
	private static Logger log = Logger.getLogger(C_NPCTalkAction.class
			.getName());

	public C_NPCTalkAction(byte decrypt[], ClientThread client)
			throws FileNotFoundException, Exception {
		super(decrypt);
		int objectId = readD();
		String action = readS();
		L1PcInstance activeChar = client.getActiveChar();

		L1Object obj = L1World.getInstance().findObject(objectId);
		if (obj == null) {
			log.warn("object not found, oid " + objectId);
			return;
		}

		try {
			L1NpcInstance npc = (L1NpcInstance) obj;
			npc.onFinalAction(activeChar, action);
		} catch (ClassCastException e) {
		}
	}

	@Override
	public String getType() {
		return C_NPC_TALK_ACTION;
	}

}
