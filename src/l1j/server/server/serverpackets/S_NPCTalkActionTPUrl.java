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
package l1j.server.server.serverpackets;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.L1NpcTalkData;

public class S_NPCTalkActionTPUrl extends ServerBasePacket {
	private static final String _S__25_TalkReturnAction = "[S] S_NPCTalkActionTPUrl";
	private byte[] _byte = null;

	public S_NPCTalkActionTPUrl(L1NpcTalkData cha, Object[] prices, int objid) {
		buildPacket(cha, prices, objid);
	}

	private void buildPacket(L1NpcTalkData npc, Object[] prices, int objid) {
		String htmlid = "";
		htmlid = npc.getTeleportURL();
		writeC(Opcodes.S_OPCODE_SHOWHTML);
		writeD(objid);
		writeS(htmlid);
		writeH(0x01); // Unknown
		writeH(prices.length); // Number of arguments
		for (Object price : prices) {
			writeS(String.valueOf(((Integer) price).intValue()));
		}
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return _S__25_TalkReturnAction;
	}
}