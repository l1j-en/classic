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

public class S_SkillSound extends ServerBasePacket {
	private static final String S_SKILL_SOUND = "[S] S_SkillSound";
	private byte[] _byte = null;

	public S_SkillSound(int objid, int gfxid, int aid) {

		buildPacket(objid, gfxid, aid);
	}

	public S_SkillSound(int objid, int gfxid) {
		buildPacket(objid, gfxid, 0);
	}

	private void buildPacket(int objid, int gfxid, int aid) {
		// aid Is not used
		writeC(Opcodes.S_OPCODE_SKILLSOUNDGFX);
		writeD(objid);
		writeH(gfxid);
		writeH(0);
		writeD(0x00000000);
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
		return S_SKILL_SOUND;
	}
}