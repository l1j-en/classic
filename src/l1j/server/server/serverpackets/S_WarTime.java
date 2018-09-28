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

import java.util.Calendar;

import l1j.server.Config;
import l1j.server.server.encryptions.Opcodes;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket
public class S_WarTime extends ServerBasePacket {
//	private static Logger _log = LoggerFactory.getLogger(S_WarTime.class.getName());
	private static final String S_WAR_TIME = "[S] S_WarTime";

	public S_WarTime(Calendar cal) {
		// 1997/01/01 17:00 Based on the
		Calendar base_cal = Calendar.getInstance();
		base_cal.set(1997, 0, 1, 17, 0);
		long base_millis = base_cal.getTimeInMillis();
		long millis = cal.getTimeInMillis();
		long diff = millis - base_millis;
		diff -= 1200 * 60 * 1000; // Error modification
		diff = diff / 60000; // Truncation minutes or less
		// time 1 and 3:02 summing (182 minutes) forward
		int time = (int) (diff / 182);
		// writeD just before the hour adjustable writeC
		// Dwindle to just 0.7 times the amount of time
		// Adjust the one that spread and the next time?
		writeC(Opcodes.S_OPCODE_WARTIME);
		writeH(6); // List the number (six or more disabled)
		writeS(Config.TIME_ZONE); // Time behind () appear in a string
		writeC(0); // ?
		writeC(0); // ?
		writeC(0);
		writeD(time);
		writeC(0);
		writeD(time - 1);
		writeC(0);
		writeD(time - 2);
		writeC(0);
		writeD(time - 3);
		writeC(0);
		writeD(time - 4);
		writeC(0);
		writeD(time - 5);
		writeC(0);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return S_WAR_TIME;
	}
}