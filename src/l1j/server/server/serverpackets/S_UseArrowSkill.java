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

import java.util.concurrent.atomic.AtomicInteger;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.L1Character;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_UseArrowSkill extends ServerBasePacket {
	private static final String S_USE_ARROW_SKILL = "[S] S_UseArrowSkill";
//	private static Logger _log = LoggerFactory.getLogger(S_UseArrowSkill.class
//			.getName());
	private static AtomicInteger _sequentialNumber = new AtomicInteger(0);
	private byte[] _byte = null;

	public S_UseArrowSkill(L1Character cha, int targetobj, int spellgfx, int x,
			int y, boolean isHit) {

		int aid = 1;
		if (cha.getTempCharGfx() == 3860) {
			aid = 21;
		}
		writeC(Opcodes.S_OPCODE_ATTACKPACKET);
		writeC(aid);
		writeD(cha.getId());
		writeD(targetobj);
		writeH(isHit ? 6 : 0);
		writeC(cha.getHeading());
		writeD(_sequentialNumber.incrementAndGet());
		writeH(spellgfx);
		writeC(127); // Using the skills of space in the light source?
		writeH(cha.getX());
		writeH(cha.getY());
		writeH(x);
		writeH(y);
		writeC(0);
		writeC(0);
		writeC(0);
		writeC(0);
		writeC(0);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		} else {
			int seq = _sequentialNumber.incrementAndGet();
			_byte[13] = (byte) (seq & 0xff);
			_byte[14] = (byte) (seq >> 8 & 0xff);
			_byte[15] = (byte) (seq >> 16 & 0xff);
			_byte[16] = (byte) (seq >> 24 & 0xff);
		}
		return _byte;
	}

	@Override
	public String getType() {
		return S_USE_ARROW_SKILL;
	}
}