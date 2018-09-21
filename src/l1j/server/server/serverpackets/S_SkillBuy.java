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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_SkillBuy extends ServerBasePacket {
	private static Logger _log = LoggerFactory.getLogger(S_SkillBuy.class.getName());
	private static final String _S_SKILL_BUY = "[S] S_SkillBuy";
	private byte[] _byte = null;

	public S_SkillBuy(int o, L1PcInstance pc) {
		int count = Scount(pc);
		int inCount = 0;
		for (int k = 0; k < count; k++) {
			if (!pc.isSkillMastery((k + 1))) {
				inCount++;
			}
		}
		try {
			writeC(Opcodes.S_OPCODE_SKILLBUY);
			writeD(100);
			writeH(inCount);
			for (int k = 0; k < count; k++) {
				if (!pc.isSkillMastery((k + 1))) {
					writeD(k);
				}
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	public int Scount(L1PcInstance pc) {
		int RC = 0;
		switch (pc.getType()) {
		case 0:
			if (pc.getLevel() > 20 || pc.isGm()) {
				RC = 16;
			} else if (pc.getLevel() > 10) {
				RC = 8;
			}
			break;
		case 1: // Knight
			if (pc.getLevel() >= 50 || pc.isGm()) {
				RC = 8;
			}
			break;
		case 2: // Elf
			if (pc.getLevel() >= 24 || pc.isGm()) {
				RC = 23;
			} else if (pc.getLevel() >= 16) {
				RC = 16;
			} else if (pc.getLevel() >= 8) {
				RC = 8;
			}
			break;
		case 3: // WIZ
			if (pc.getLevel() >= 12 || pc.isGm()) {
				RC = 23;
			} else if (pc.getLevel() >= 8) {
				RC = 16;
			} else if (pc.getLevel() >= 4) {
				RC = 8;
			}
			break;
		case 4: // DE
			if (pc.getLevel() >= 24 || pc.isGm()) {
				RC = 16;
			} else if (pc.getLevel() >= 12) {
				RC = 8;
			}
			break;
		default:
			break;
		}
		return RC;
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
		return _S_SKILL_BUY;
	}
}