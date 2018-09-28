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
public class S_CharReset extends ServerBasePacket {
	private static final String S_CHAR_RESET = "[S] S_CharReset";
	private byte[] _byte = null;

	public S_CharReset(L1PcInstance pc, int lv, int hp, int mp, int ac,
			int str, int intel, int wis, int dex, int con, int cha) {
		writeC(Opcodes.S_OPCODE_CHARRESET);
		writeC(0x02);
		writeC(lv);
		writeC(pc.getTempMaxLevel()); // max lv
		writeH(hp);
		writeH(mp);
		writeH(ac);
		writeC(str);
		writeC(intel);
		writeC(wis);
		writeC(dex);
		writeC(con);
		writeC(cha);
	}

	public S_CharReset(int point) {
		writeC(Opcodes.S_OPCODE_CHARRESET);
		writeC(0x03);
		writeC(point);
	}

	public S_CharReset(L1PcInstance pc) {
		writeC(Opcodes.S_OPCODE_CHARRESET);
		writeC(0x01);
		if (pc.isCrown()) {
			writeH(14);
			writeH(2);
		} else if (pc.isKnight()) {
			writeH(16);
			writeH(1);
		} else if (pc.isElf()) {
			writeH(15);
			writeH(4);
		} else if (pc.isWizard()) {
			writeH(12);
			writeH(6);
		} else if (pc.isDarkelf()) {
			writeH(12);
			writeH(3);
		} else if (pc.isDragonKnight()) {
			writeH(15);
			writeH(4);
		} else if (pc.isIllusionist()) {
			writeH(15);
			writeH(4);
		}
		writeC(0x0a); // AC
		writeC(pc.getTempMaxLevel());
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
		return S_CHAR_RESET;
	}
}