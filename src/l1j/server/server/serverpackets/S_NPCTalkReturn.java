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
import l1j.server.server.model.npc.L1NpcHtml;

public class S_NPCTalkReturn extends ServerBasePacket {
	private static final String _S__25_TalkReturn = "[S] _S__25_TalkReturn";
	private byte[] _byte = null;

	public S_NPCTalkReturn(L1NpcTalkData npc, int objid, int action,
			String[] data) {
		String htmlid = "";
		if (action == 1) {
			htmlid = npc.getNormalAction();
		} else if (action == 2) {
			htmlid = npc.getCaoticAction();
		} else {
			throw new IllegalArgumentException();
		}
		buildPacket(objid, htmlid, data);
	}

	public S_NPCTalkReturn(L1NpcTalkData npc, int objid, int action) {
		this(npc, objid, action, null);
	}

	public S_NPCTalkReturn(int objid, String htmlid, String[] data) {
		buildPacket(objid, htmlid, data);
	}

	public S_NPCTalkReturn(int objid, String htmlid) {
		buildPacket(objid, htmlid, null);
	}

	public S_NPCTalkReturn(int objid, L1NpcHtml html) {
		buildPacket(objid, html.getName(), html.getArgs());
	}

	public S_NPCTalkReturn(int objid, L1NpcHtml html, String[] data) {
		buildPacket(objid, html.getName(), data);
	}

	private void buildPacket(int objid, String htmlid, String[] data) {
		writeC(Opcodes.S_OPCODE_SHOWHTML);
		writeD(objid);
		writeS(htmlid);
		if (data != null && 1 <= data.length) {
			writeH(0x01); // Who fixes bytes of unknown factors
			writeH(data.length); // Number of arguments
			for (String datum : data) {
				writeS(datum);
			}
		} else {
			writeH(0x00);
			writeH(0x00);
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
		return _S__25_TalkReturn;
	}
}