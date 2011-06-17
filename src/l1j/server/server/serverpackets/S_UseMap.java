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

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;

public class S_UseMap extends ServerBasePacket {
	private static Logger _log = Logger.getLogger(S_UseMap.class.getName());
	private static final String S_USE_MAP = "[S] S_UseMap";

	public S_UseMap(L1PcInstance pc, int objid, int itemid) {
		writeC(Opcodes.S_OPCODE_USEMAP);
		writeD(objid);
		switch (itemid) {
		case 40373:
			writeD(16);
			break;
		case 40374:
			writeD(1);
			break;
		case 40375:
			writeD(2);
			break;
		case 40376:
			writeD(3);
			break;
		case 40377:
			writeD(4);
			break;
		case 40378:
			writeD(5);
			break;
		case 40379:
			writeD(6);
			break;
		case 40380:
			writeD(7);
			break;
		case 40381:
			writeD(8);
			break;
		case 40382:
			writeD(9);
			break;
		case 40383:
			writeD(10);
			break;
		case 40384:
			writeD(11);
			break;
		case 40385:
			writeD(12);
			break;
		case 40386:
			writeD(13);
			break;
		case 40387:
			writeD(14);
			break;
		case 40388:
			writeD(15);
			break;
		case 40389:
			writeD(17);
			break;
		case 40390:
			writeD(18);
			break;
		}
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return S_USE_MAP;
	}
}