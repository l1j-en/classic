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
import l1j.server.Config;

public class S_ServerVersion extends ServerBasePacket {
	private static final String S_SERVER_VERSION = "[S] ServerVersion";
	private static final int SERVER_VERSION = 120913203;
	private static final int CACHE_VERSION = 120913200;
	private static final int AUTH_VERSION = 2010083002;
	private static final int NPC_VERSION = 120913201;
	private static final int SERVER_TYPE = 490882;
	private static final int UPTIME = 1327204035; //TODO -- set uptime
	private static final int CLIENT_LANGUAGE = Config.CLIENT_LANGUAGE;

	public S_ServerVersion() {
		writeC(Opcodes.S_OPCODE_SERVERVERSION);
		// Auth Check client Version
		// 1 = Check
		// 0 = no check
		// > 1 no check
		// type : boolean
		writeC(0x00);
		// your server id, first id = 2
		// id = 0, ????
		// id = 1, ????
		writeC(0x01);
		// all version
		// If the user level is a administrator,
		// inputs /ver to be able to print out all version in game
		// If the user level isn't a administrator
		// inputs /ver to be able to print out client version in game
		writeD(SERVER_VERSION);
		writeD(CACHE_VERSION);
		writeD(AUTH_VERSION);
		writeD(NPC_VERSION);

		writeD(0x00);
		writeC(0x00); // unknown
		writeC(0x00); // unknown
		// Country
		// 0.US 3.Taiwan 4.Janpan 5.China
		writeC(CLIENT_LANGUAGE);
		writeD(SERVER_TYPE);
		writeD(UPTIME);
		writeH(0x01);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return S_SERVER_VERSION;
	}
}
