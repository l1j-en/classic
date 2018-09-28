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
public class S_SellHouse extends ServerBasePacket {
//	private static Logger _log = LoggerFactory.getLogger(S_SellHouse.class.getName());
	private static final String S_SELLHOUSE = "[S] S_SellHouse";
	private byte[] _byte = null;

	public S_SellHouse(int objectId, String houseNumber) {
		buildPacket(objectId, houseNumber);
	}

	private void buildPacket(int objectId, String houseNumber) {
		writeC(Opcodes.S_OPCODE_INPUTAMOUNT);
		writeD(objectId);
		writeD(0); // ?
		writeD(100000); // The initial price of spin control
		writeD(100000); // The lower limit price
		writeD(2000000000); // Maximum price
		writeH(0); // ?
		writeS("agsell");
		writeS("agsell " + houseNumber);
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
		return S_SELLHOUSE;
	}
}