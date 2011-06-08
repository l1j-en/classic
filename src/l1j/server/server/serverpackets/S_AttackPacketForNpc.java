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

import l1j.server.server.Opcodes;
import l1j.server.server.model.L1Character;

public class S_AttackPacketForNpc extends ServerBasePacket {
	private static Logger _log = Logger.getLogger(S_AttackPacketForNpc.class
			.getName());
	private static final String S_ATTACK_PACKET_FOR_NPC
			= "[S] S_AttackPacketForNpc";

	private byte[] _byte = null;

	public S_AttackPacketForNpc(L1Character cha, int npcObjectId, int type) {
		buildpacket(cha, npcObjectId, type);
	}

	private void buildpacket(L1Character cha, int npcObjectId, int type) {
		writeC(Opcodes.S_OPCODE_ATTACKPACKET);
		writeC(type);
		writeD(npcObjectId);
		writeD(cha.getId());
		writeC(0x01); // damage
		writeC(cha.getHeading());
		writeH(0x0000); // target x
		writeH(0x0000); // target y
		writeC(0x00); // 0x00:none 0x04:Claw 0x08:CounterMirror
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}

		return _byte;
	}

	@Override
	public String getType() {
		return S_ATTACK_PACKET_FOR_NPC;
	}
}
