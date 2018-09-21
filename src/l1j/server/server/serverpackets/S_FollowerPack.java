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
import l1j.server.server.model.Instance.L1FollowerInstance;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_NPCPack
public class S_FollowerPack extends ServerBasePacket {
//	private static Logger _log = LoggerFactory.getLogger(S_FollowerPack.class
//			.getName());
	private static final String S_FOLLOWER_PACK = "[S] S_FollowerPack";
	private static final int STATUS_POISON = 1;
//	private static final int STATUS_INVISIBLE = 2;
//	private static final int STATUS_PC = 4;
//	private static final int STATUS_FREEZE = 8;
//	private static final int STATUS_BRAVE = 16;
//	private static final int STATUS_ELFBRAVE = 32;
//	private static final int STATUS_FASTMOVABLE = 64;
//	private static final int STATUS_GHOST = 128;
	private byte[] _byte = null;

	public S_FollowerPack(L1FollowerInstance follower, L1PcInstance pc) {
		writeC(Opcodes.S_OPCODE_CHARPACK);
		writeH(follower.getX());
		writeH(follower.getY());
		writeD(follower.getId());
		writeH(follower.getGfxId());
		writeC(follower.getStatus());
		writeC(follower.getHeading());
		writeC(follower.getChaLightSize());
		writeC(follower.getMoveSpeed());
		writeD(0);
		writeH(0);
		writeS(follower.getNameId());
		writeS(follower.getTitle());
		int status = 0;
		if (follower.getPoison() != null) {
			if (follower.getPoison().getEffectId() == 1) {
				status |= STATUS_POISON;
			}
		}
		writeC(status);
		writeD(0);
		writeS(null);
		writeS(null);
		writeC(0);
		writeC(0xFF);
		writeC(0);
		writeC(follower.getLevel());
		writeC(0);
		writeC(0xFF);
		writeC(0xFF);
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
		return S_FOLLOWER_PACK;
	}
}