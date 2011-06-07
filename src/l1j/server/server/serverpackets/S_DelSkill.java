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

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_DelSkill extends ServerBasePacket {

	public S_DelSkill(int i, int j, int k, int l, int i1, int j1, int k1,
			int l1, int i2, int j2, int k2, int l2, int i3, int j3, int k3,
			int l3, int i4, int j4, int k4, int l4, int i5, int j5, int k5,
			int l5, int m5, int n5, int o5, int p5) {
		int i6 = i1 + j1 + k1 + l1;
		int j6 = i2 + j2;
		writeC(Opcodes.S_OPCODE_DELSKILL);
		if (i6 > 0 && j6 == 0) {
			writeC(50);
		} else if (j6 > 0) {
			writeC(100);
		} else {
			writeC(32);
		}
		writeC(i);
		writeC(j);
		writeC(k);
		writeC(l);
		writeC(i1);
		writeC(j1);
		writeC(k1);
		writeC(l1);
		writeC(i2);
		writeC(j2);
		writeC(k2);
		writeC(l2);
		writeC(i3);
		writeC(j3);
		writeC(k3);
		writeC(l3);
		writeC(i4);
		writeC(j4);
		writeC(k4);
		writeC(l4);
		writeC(i5);
		writeC(j5);
		writeC(k5);
		writeC(l5);
		writeC(m5);
		writeC(n5);
		writeC(o5);
		writeC(p5);
		writeD(0);
		writeD(0);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return "[S] S_DelSkill";
	}

	private static final String _S__OB_DelSKILL = "[S] S_DelSkill";

	private static Logger _log = Logger.getLogger(S_DelSkill.class.getName());

}
