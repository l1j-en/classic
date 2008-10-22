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

import l1j.server.server.Opcodes;
import l1j.server.server.model.Instance.L1DoorInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_DoorPack

public class S_DoorPack extends ServerBasePacket {

	private static final String S_DOOR_PACK = "[S] S_DoorPack";
	private byte[] _byte = null;

	private static final int STATUS_INVISIBLE = 2;

	public S_DoorPack(L1DoorInstance door) {
		buildPacket(door);
	}

	private void buildPacket(L1DoorInstance door) {

		writeC(Opcodes.S_OPCODE_CHARPACK);
		writeH(door.getX());
		writeH(door.getY());
		writeD(door.getId());
		writeH(door.getGfxId());
		writeC(door.getOpenStatus());
		writeC(0);
		writeC(0);
		writeC(0);
		writeD(1);
		writeH(0);
		writeS(null);
		writeS(null);
		if (door.isInvisible()) {
			writeC(STATUS_INVISIBLE);
		} else {
			writeC(0);
		}
		writeD(0);
		writeS(null);
		writeS(null);
		writeC(0);
		writeC(0xFF);
		writeC(0);
		writeC(0);
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

	public String getType() {
		return S_DOOR_PACK;
	}

}
