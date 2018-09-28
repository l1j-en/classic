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
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_HireSoldier extends ServerBasePacket {
//	private static Logger _log =LoggerFactory//			.getLogger(S_HireSoldier.class.getName());
	private static final String S_HIRE_SOLDIER = "[S] S_HireSldier";
	private byte[] _byte = null;

	// HTML is open and when to send the packet to appear npcdeloy-j.html
	// OK button and flying C_127
	public S_HireSoldier(L1PcInstance pc) {
		writeC(Opcodes.S_OPCODE_HIRESOLDIER);
		writeH(0); // Included in the packet client returns
		writeH(0); // Included in the packet client returns
		writeH(0); // The total number of employed mercenaries
		writeS(pc.getName());
		writeD(0); // Included in the packet client returns
		writeH(0); // The number of deployable mercenaries
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
		return S_HIRE_SOLDIER;
	}
}