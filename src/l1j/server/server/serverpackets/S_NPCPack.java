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

import java.util.logging.Logger;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.Instance.L1FieldObjectInstance;
import l1j.server.server.model.Instance.L1NpcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_NPCPack extends ServerBasePacket {
	private static final String S_NPC_PACK = "[S] S_NPCPack";
	private static Logger _log = Logger.getLogger(S_NPCPack.class.getName());
	private static final int STATUS_POISON = 1;
	private static final int STATUS_INVISIBLE = 2;
	private static final int STATUS_PC = 4;
	private static final int STATUS_FREEZE = 8;
	private static final int STATUS_BRAVE = 16;
	private static final int STATUS_ELFBRAVE = 32;
	private static final int STATUS_FASTMOVABLE = 64;
	private static final int STATUS_GHOST = 128;
	private byte[] _byte = null;

	public S_NPCPack(L1NpcInstance npc) {
		writeC(Opcodes.S_OPCODE_CHARPACK);
		writeH(npc.getX());
		writeH(npc.getY());
		writeD(npc.getId());
		if (npc.getTempCharGfx() == 0) {
			writeH(npc.getGfxId());
		} else {
			writeH(npc.getTempCharGfx());
		}
		if (npc.getNpcTemplate().is_doppel() && npc.getGfxId() != 31) { // Slime
																		// to
																		// see
																		// if
																		// the
																		// Dopper
			writeC(4);
		} else {
			writeC(npc.getStatus());
		}
		writeC(npc.getHeading());
		writeC(npc.getChaLightSize());
		writeC(npc.getMoveSpeed());
		writeD(npc.getExp());
		writeH(npc.getTempLawful());
		writeS(npc.getNameId());
		if (npc instanceof L1FieldObjectInstance) {
			L1NpcTalkData talkdata = NPCTalkDataTable.getInstance()
					.getTemplate(npc.getNpcTemplate().get_npcId());
			if (talkdata != null) {
				writeS(talkdata.getNormalAction()); // HTML title is interpreted
													// as the name
			} else {
				writeS(null);
			}
		} else {
			writeS(npc.getTitle());
		}

		int status = 0;
		if (npc.getPoison() != null) { //
			if (npc.getPoison().getEffectId() == 1) {
				status |= STATUS_POISON;
			}
		}
		if (npc.getNpcTemplate().is_doppel()) {
			// PC's and Eva's blessing to attribute.. Dopper with the exception
			// of the Quest for WIZ
			if (npc.getNpcTemplate().get_npcId() != 81069) {
				status |= STATUS_PC;
			}
		}
		writeC(status);
		writeD(0); // 0 In addition to the flying C_27
		writeS(null);
		writeS(null); // Master name?
		writeC(0);
		writeC(0xFF); // HP
		writeC(0);
		writeC(npc.getLevel());
		writeC(0);
		writeC(0xFF);
		writeC(0xFF);
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
		return S_NPC_PACK;
	}
}