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

import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.Instance.L1FieldObjectInstance;
import l1j.server.server.model.Instance.L1NpcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_NPCPack extends ServerBasePacket {
	private static final String S_NPC_PACK = "[S] S_NPCPack";
//	private static Logger _log = LoggerFactory.getLogger(S_NPCPack.class.getName());
	private static final int STATUS_POISON = 1;
//	private static final int STATUS_INVISIBLE = 2;
	private static final int STATUS_PC = 4;
//	private static final int STATUS_FREEZE = 8;
//	private static final int STATUS_BRAVE = 16;
//	private static final int STATUS_ELFBRAVE = 32;
//	private static final int STATUS_FASTMOVABLE = 64;
//	private static final int STATUS_GHOST = 128;
	private byte[] _byte = null;
	
	public S_NPCPack(L1NpcInstance npc, ServerBasePacket basePacket) {
		if(basePacket == null) {
			basePacket = this;
		}
		
		basePacket.writeC(Opcodes.S_OPCODE_CHARPACK);
		basePacket.writeH(npc.getX());
		basePacket.writeH(npc.getY());
		basePacket.writeD(npc.getId());
		
		if (npc.getTempCharGfx() == 0) {
			basePacket.writeH(npc.getGfxId());
		} else {
			basePacket.writeH(npc.getTempCharGfx());
		}
		
		if (npc.getNpcTemplate().is_doppel() && npc.getGfxId() != 31) { // Slime
																		// to
																		// see
																		// if
																		// the
																		// Dopper
			basePacket.writeC(4);
		} else {
			basePacket.writeC(npc.getStatus());
		}
		
		basePacket.writeC(npc.getHeading());
		basePacket.writeC(npc.getChaLightSize());
		basePacket.writeC(npc.getMoveSpeed());
		basePacket.writeD(npc.getExp());
		basePacket.writeH(npc.getTempLawful());
		basePacket.writeS(npc.getNameId());
		if (npc instanceof L1FieldObjectInstance) {
			L1NpcTalkData talkdata = NPCTalkDataTable.getInstance()
					.getTemplate(npc.getNpcTemplate().get_npcId());
			if (talkdata != null) {
				basePacket.writeS(talkdata.getNormalAction()); // HTML title is interpreted
													// as the name
			} else {
				basePacket.writeS(null);
			}
		} else {
			basePacket.writeS(npc.getTitle());
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
		
		basePacket.writeC(status);
		basePacket.writeD(0); // 0 In addition to the flying C_27
		basePacket.writeS(null);
		basePacket.writeS(null); // Master name?
		basePacket.writeC(0);
		basePacket.writeC(0xFF); // HP
		basePacket.writeC(0);
		// don't show mob level on dream island
		basePacket.writeC(npc.getMapId() == 303 ? 0 : npc.getLevel());
		basePacket.writeC(0);
		basePacket.writeC(0xFF);
		basePacket.writeC(0xFF);
	}

	public S_NPCPack(L1NpcInstance npc) {
		this(npc, null);
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