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
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_SendInvOnLogin

public class S_OwnCharStatus2 extends ServerBasePacket {

	public S_OwnCharStatus2(L1PcInstance l1pcinstance) {
		if (l1pcinstance == null) {
			return;
		}

		cha = l1pcinstance;

		writeC(Opcodes.S_OPCODE_OWNCHARSTATUS2);
		writeC(cha.getStr());
		writeC(cha.getInt());
		writeC(cha.getWis());
		writeC(cha.getDex());
		writeC(cha.getCon());
		writeC(cha.getCha());
		writeC(cha.getInventory().getWeight240());
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return "[C] S_OwnCharStatus2";
	}

	private static final String _S__4F_S_OwnChraStatus2 = "[C] S_OwnCharStatus2";
	private static Logger _log = Logger.getLogger(S_OwnCharStatus2.class
			.getName());
	private L1PcInstance cha = null;
}
