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
import java.util.Iterator;
import java.util.TimeZone;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.Opcodes;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;

public class S_PacketBox extends ServerBasePacket {
	private static final String S_PACKETBOX = "[S] S_PacketBox";

	private static Logger _log = Logger.getLogger(S_PacketBox.class.getName());

	private byte[] _byte = null;

	// *** S_107 sub code list ***

	// 1:Kent 2:Orc 3:WW 4:Giran 5:Heine 6:Dwarf 7:Aden 8:Diad 9:Castle name 9 ...
	// C(id): %s The siege warfare began.
	public static final int MSG_WAR_BEGIN = 0;

	// C(id): %s The siege ended war.
	public static final int MSG_WAR_END = 1;

	// C(id): %s The siege warfare in progress.
	public static final int MSG_WAR_GOING = 2;

	// -: Castle xxx initiative. (Music changes)
	public static final int MSG_WAR_INITIATIVE = 3;

	// -: Seized the castle.
	public static final int MSG_WAR_OCCUPY = 4;

	// ?: xxx fight. (Music changes)
	public static final int MSG_DUEL = 5;

	// C(count): SMSSend failed. /% D total of 649 cases have been sent.
	public static final int MSG_SMS_SENT = 6;

	// -: During the blessing, the two joined together as husband and wife. (Music changes)
	public static final int MSG_MARRIED = 9;

	// C(weight): Weight (30 stages)
	public static final int WEIGHT = 10;

	// C(food): Satiety (30 stages)
	public static final int FOOD = 11;

	// C(0) C(level): This item is below the level of% d only. (0 to 49 not only display)
	public static final int MSG_LEVEL_OVER = 12;

	// UB Information HTML
	public static final int HTML_UB = 14;

	// C(id): One had to feel for the spirit of power / fire throughout the body --
	public static final int MSG_ELF = 15;

	// C(count) S(name)...: Multiple blocking list
	public static final int ADD_EXCLUDE2 = 17;

	// S(name): Add blocking list
	public static final int ADD_EXCLUDE = 18;

	// S(name): Blockade lifted
	public static final int REM_EXCLUDE = 19;

	// icon
	public static final int ICONS1 = 20;

	// icon
	public static final int ICONS2 = 21;

	// Aura system icon
	public static final int ICON_AURA = 22;

	// S(name): % S town was chosen as the leader.
	public static final int MSG_TOWN_LEADER = 23;

	// C(id): % S, your rank is not changed.
	public static final int MSG_RANK_CHANGED = 27;

	// D(?) S(name) S(clan):
	public static final int MSG_WIN_LASTAVARD = 30;

	// -: I feel better.
	public static final int MSG_FEEL_GOOD = 31;

	// C_30 Packets flying
	public static final int SOMETHING1 = 33;

	// H(time)
	public static final int ICON_BLUEPOTION = 34;

	public static final int ICON_POLYMORPH = 35;

	public static final int ICON_CHATBAN = 36;

	// C_7 Packets flying
	public static final int SOMETHING2 = 37;

	// Clan information HTML
	public static final int HTML_CLAN1 = 38;

	// H(time): i2h
	public static final int ICON_I2H = 40;

	// Back to the character selection screen
	public static final int LOGOUT = 42;

	// During combat, you can not restart.
	public static final int MSG_CANT_LOGOUT = 43;

	// C(count) D(time) S(name) S(info): [CALL] Button with a window to appear
	public static final int CALL_SOMETHING = 45;

	// C(id): Battle Coliseum, chaos War
	public static final int MSG_COLOSSEUM = 49;

	// Clan information HTML
	public static final int HTML_CLAN2 = 51;

	public static final int COOK_WINDOW = 52;

	// C type, H time
	public static final int ICON_COOKING = 53;

	//Fishing
	public static final int FISHING = 55;

	public S_PacketBox(int subCode) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(subCode);

		switch (subCode) {
		case MSG_WAR_INITIATIVE:
		case MSG_WAR_OCCUPY:
		case MSG_MARRIED:
		case MSG_FEEL_GOOD:
		case MSG_CANT_LOGOUT:
		case LOGOUT:
		case FISHING:
			break;
		case CALL_SOMETHING:
			callSomething();
		default:
			break;
		}
	}

	public S_PacketBox(int subCode, int value) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(subCode);

		switch (subCode) {
		case ICON_BLUEPOTION:
		case ICON_CHATBAN:
		case ICON_I2H:
		case ICON_POLYMORPH:
			writeH(value); // time
			break;
		case MSG_WAR_BEGIN:
		case MSG_WAR_END:
		case MSG_WAR_GOING:
			writeC(value); // castle id
			writeH(0); // ?
			break;
		case MSG_SMS_SENT:
		case WEIGHT:
		case FOOD:
			writeC(value);
			break;
		case MSG_ELF:
		case MSG_RANK_CHANGED:
		case MSG_COLOSSEUM:
			writeC(value); // msg id
			break;
		case MSG_LEVEL_OVER:
			writeC(0); // ?
			writeC(value); // 0-49O\
			break;
		case COOK_WINDOW:
			writeC(0xdb); // ?
			writeC(0x31);
			writeC(0xdf);
			writeC(0x02);
			writeC(0x01);
			writeC(value); // 0-49 Not only display
			break;
		default:
			break;
		}
	}

	public S_PacketBox(int subCode, int type, int time) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(subCode);

		switch (subCode) {
		case ICON_COOKING:
			if (type != 7) {
				writeC(0x0c);
				writeC(0x0c);
				writeC(0x0c);
				writeC(0x12);
				writeC(0x0c);
				writeC(0x09);
				writeC(0x00);
				writeC(0x00);
				writeC(type);
				writeC(0x24);
				writeH(time);
				writeH(0x00);
			} else {
				writeC(0x0c);
				writeC(0x0c);
				writeC(0x0c);
				writeC(0x12);
				writeC(0x0c);
				writeC(0x09);
				writeC(0xc8);
				writeC(0x00);
				writeC(type);
				writeC(0x26);
				writeH(time);
				writeC(0x3e);
				writeC(0x87);
			}
			break;
		case MSG_DUEL:
			writeD(type); // 
			writeD(time); // 
			break;
		default:
			break;
		}
	}

	public S_PacketBox(int subCode, String name) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(subCode);

		switch (subCode) {
		case ADD_EXCLUDE:
		case REM_EXCLUDE:
		case MSG_TOWN_LEADER:
			writeS(name);
			break;
		default:
			break;
		}
	}

	public S_PacketBox(int subCode, int id, String name, String clanName) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(subCode);

		switch (subCode) {
		case MSG_WIN_LASTAVARD:
			writeD(id); // Clan ID or something?
			writeS(name);
			writeS(clanName);
			break;
		default:
			break;
		}
	}

	public S_PacketBox(int subCode, Object[] names) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(subCode);

		switch (subCode) {
		case ADD_EXCLUDE2:
			writeC(names.length);
			for (Object name : names) {
				writeS(name.toString());
			}
			break;
		default:
			break;
		}
	}

	private void callSomething() {
		Iterator<L1PcInstance> itr = L1World.getInstance().getAllPlayers().iterator();

		writeC(L1World.getInstance().getAllPlayers().size());

		while (itr.hasNext()) {
			L1PcInstance pc = itr.next();
			Account acc = Account.load(pc.getAccountName());

			if (acc == null) {
				writeD(0);
			} else {
				Calendar cal = Calendar
						.getInstance(TimeZone.getTimeZone(Config.TIME_ZONE));
				long lastactive = acc.getLastActive().getTime();
				cal.setTimeInMillis(lastactive);
				cal.set(Calendar.YEAR, 1970);
				int time = (int) (cal.getTimeInMillis() / 1000);
				writeD(time); // JST 1970 1/1 09:00
			}

			writeS(pc.getName()); 
			writeS(pc.getClanname()); 
		}
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
		return S_PACKETBOX;
	}
}
