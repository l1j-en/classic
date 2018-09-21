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
import l1j.server.server.model.Instance.L1MonsterInstance;

public class S_MoveNpcPacket extends ServerBasePacket {
	private static final String _S__1F_S_MOVENPCPACKET = "[S] S_MoveNpcPacket";
//	private static Logger _log = LoggerFactory.getLogger(S_MoveNpcPacket.class
//			.getName());

	public S_MoveNpcPacket(L1MonsterInstance npc, int x, int y, int heading) {
		writeC(Opcodes.S_OPCODE_MOVEOBJECT);
		writeD(npc.getId());
		writeH(x);
		writeH(y);
		writeC(heading);
		writeC(0x81);
		writeD(0x00000000);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return _S__1F_S_MOVENPCPACKET;
	}
}