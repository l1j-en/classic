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

import l1j.server.server.Opcodes;
import l1j.server.server.model.L1Character;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_AttackMissPacket extends ServerBasePacket {

	private static final String _S__OB_ATTACKMISSPACKET = "[S] S_AttackMissPacket";

	private byte[] _byte = null;

	public S_AttackMissPacket(L1Character attacker, int targetId) {
		writeC(Opcodes.S_OPCODE_ATTACKPACKET);
		writeC(1);
		writeD(attacker.getId());
		writeD(targetId);
		writeC(0);
		writeC(attacker.getHeading());
		writeD(0);
		writeC(0);
	}

	public S_AttackMissPacket(L1Character attacker, int targetId, int actId) {
		writeC(Opcodes.S_OPCODE_ATTACKPACKET);
		writeC(actId);
		writeD(attacker.getId());
		writeD(targetId);
		writeC(0);
		writeC(attacker.getHeading());
		writeD(0);
		writeC(0);
	}

	public S_AttackMissPacket(int attackId, int targetId) {
		writeC(Opcodes.S_OPCODE_ATTACKPACKET);
		writeC(1);
		writeD(attackId);
		writeD(targetId);
		writeC(0);
		writeC(0);
		writeD(0);
	}

	public S_AttackMissPacket(int attackId, int targetId, int actId) {
		writeC(Opcodes.S_OPCODE_ATTACKPACKET);
		writeC(actId);
		writeD(attackId);
		writeD(targetId);
		writeC(0);
		writeC(0);
		writeD(0);
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
		return _S__OB_ATTACKMISSPACKET;
	}
}
