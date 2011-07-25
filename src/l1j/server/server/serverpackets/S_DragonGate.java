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
import l1j.server.server.model.Instance.L1PcInstance;

public class S_DragonGate extends ServerBasePacket {
	private static final String S_DRAGON_GATE = "[S] S_DragonGate";
	private static Logger _log = Logger.getLogger(S_DragonGate.class.getName());

	private byte[] _byte = null;

	public S_DragonGate(L1PcInstance pc ,boolean[] i) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(0x66); // = 102
		writeD(pc.getId());
		writeC(i[0] ? 1 : 0);
		writeC(i[1] ? 1 : 0);
		writeC(i[2] ? 1 : 0);
		writeC(i[3] ? 1 : 0);
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
		return S_DRAGON_GATE;
	}
}