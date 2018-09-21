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

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket
public class S_Sound extends ServerBasePacket {
//	private static Logger _log = LoggerFactory.getLogger(S_Sound.class.getName());
	private static final String S_SOUND = "[S] S_Sound";
	private byte[] _byte = null;

	/**
	 * Play a sound effect (sound wav file folders).
	 * 
	 * @param sound
	 */
	public S_Sound(int sound) {
		buildPacket(sound);
	}

	private void buildPacket(int sound) {
		writeC(Opcodes.S_OPCODE_SOUND);
		writeC(0); // repeat
		writeH(sound);
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
		return S_SOUND;
	}
}