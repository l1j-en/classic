/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class S_Ranking extends ServerBasePacket {

	private static final String S_Ranking = "[C] S_Ranking";

	private static Logger _log = Logger.getLogger(S_Ranking.class.getName());

	private byte[] _byte = null;
	private int j = 0;
	static String[] name;

	public S_Ranking(L1PcInstance pc, int number) {
		name = new String[10];
		buildPacket(pc, number);
	}

	public S_Ranking(L1NpcInstance board) {
		buildPacket(board);
	}

	private void buildPacket(L1NpcInstance board) {
		int count = 0;
		String[][] db = null;
		int[] id = null;
		db = new String[7][3];
		id = new int[7];
		while (count < 7) {
			id[count] = count + 1;
			db[count][0] = "Ranking";
			db[count][1] = "";
			count++;
		}
		db[0][2] = "1. Highest Level (Overall)";
		db[1][2] = "2. Highest Level Royals";
		db[2][2] = "3. Highest Level Knights";
		db[3][2] = "4. Highest Level Elves";
		db[4][2] = "5. Highest Level Mages";
		db[5][2] = "6. Highest Level DE";
		db[6][2] = "7. Your Ranking";

		writeC(Opcodes.S_OPCODE_BOARD);
		writeD(board.getId());
		writeC(0xFF); // ?
		writeC(0xFF); // ?
		writeC(0xFF); // ?
		writeC(0x7F); // ?
		writeH(7);
		writeH(300);
		for (int i = 0; i < 7; ++i) {
			writeD(id[i]);
			writeS(db[i][0]);
			writeS(db[i][1]);
			writeS(db[i][2]);
		}
	}

	private void buildPacket(L1PcInstance pc, int number) {
		String date = time();
		String type = null;
		String title = null;
		writeC(Opcodes.S_OPCODE_BOARDREAD);
		writeD(number);
		writeS("");
		switch (number) {
		case 1:
			title = "Overall";
			break;
		case 2:
			title = "Royals";
			break;
		case 3:
			title = "Knights";
			break;
		case 4:
			title = "Elves";
			break;
		case 5:
			title = "Mages";
			break;
		case 6:
			title = "Dark Elf";
			break;
		case 7:
			title = "Your Rank";
			break;
		}
		writeS(title);
		writeS(date);
		switch (pc.getType()) {
		case 0:
			type = "Royal";
			break;
		case 1:
			type = "Knight";
			break;
		case 2:
			type = "Elf";
			break;
		case 3:
			type = "Mage";
			break;
		case 4:
			type = "Dark Elf";
			break;
		}
		int p = Rank(pc, number);
		if (number == 7) {
			writeS("\n\r\n\r\n\r  Your Rank: " + p + "" + "\n\r\n\r\n\r  Your "
					+ type + " rank: " + j + "" + "\n\r\n\r\n\r" + "        ");
		} else {
			writeS("\n\r" + "  1 " + name[0] + "\n\r" + "  2 " + name[1]
					+ "\n\r" + "  3 " + name[2] + "\n\r" + "  4 " + name[3]
					+ "\n\r" + "  5 " + name[4] + "\n\r" + "  6 " + name[5]
					+ "\n\r" + "  7 " + name[6] + "\n\r" + "  8 " + name[7]
					+ "\n\r" + "  9 " + name[8] + "\n\r" + " 10 " + name[9]
					+ "\n\r" + "             ");

		}
	}

	private int Rank(L1PcInstance pc, int number) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int objid = pc.getId();
		int i = 0;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			switch (number) {
			case 1:
				pstm = con
						.prepareStatement("SELECT char_name FROM characters WHERE AccessLevel = 3 order by Exp desc limit 10");
				break;
			case 2:
				pstm = con
						.prepareStatement("SELECT char_name FROM characters WHERE Type = 0 And AccessLevel = 3 order by Exp desc limit 10");
				break;
			case 3:
				pstm = con
						.prepareStatement("SELECT char_name FROM characters WHERE Type = 1 And AccessLevel = 3 order by Exp desc limit 10");
				break;
			case 4:
				pstm = con
						.prepareStatement("SELECT char_name FROM characters WHERE Type = 2 And AccessLevel = 3 order by Exp desc limit 10");
				break;
			case 5:
				pstm = con
						.prepareStatement("SELECT char_name FROM characters WHERE Type = 3 And AccessLevel = 3 order by Exp desc limit 10");
				break;
			case 6:
				pstm = con
						.prepareStatement("SELECT char_name FROM characters WHERE Type = 4 And AccessLevel = 3 order by Exp desc limit 10");
				break;
			case 7:
				pstm = con
						.prepareStatement("SELECT objid FROM characters WHERE AccessLevel = 3 order by Exp desc");
				break;

			default:
				pstm = con
						.prepareStatement("SELECT char_name FROM characters WHERE AccessLevel = 3 order by Exp desc limit 10");
				break;
			}

			rs = pstm.executeQuery();
			if (number == 7) {
				while (rs.next()) {
					i++;
					if (objid == rs.getInt(1))
						break;
				}
				String sql = "SELECT objid FROM characters WHERE Type = ";
				sql = (new StringBuilder(String.valueOf(sql))).append(
						pc.getType()).toString();
				sql = (new StringBuilder(String.valueOf(sql))).append(
						" And AccessLevel = 3 order by Exp desc").toString();
				pstm = con.prepareStatement(sql);
				rs = pstm.executeQuery();
				j = 0;
				while (rs.next()) {
					j++;
					if (objid == rs.getInt(1))
						break;
				}
			} else {
				while (rs.next()) {
					name[i] = rs.getString(1);
					i++;
				}

				while (i < 10) {
					name[i] = "";
					i++;
				}
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}

		return i;
	}

	private static String time() {
		TimeZone tz = TimeZone.getTimeZone(Config.TIME_ZONE);
		Calendar cal = Calendar.getInstance(tz);
		int year = cal.get(Calendar.YEAR) - 2000;
		String year2;
		if (year < 10) {
			year2 = "0" + year;
		} else {
			year2 = Integer.toString(year);
		}
		int Month = cal.get(Calendar.MONTH) + 1;
		String Month2 = null;
		if (Month < 10) {
			Month2 = "0" + Month;
		} else {
			Month2 = Integer.toString(Month);
		}
		int date = cal.get(Calendar.DATE);
		String date2 = null;
		if (date < 10) {
			date2 = "0" + date;
		} else {
			date2 = Integer.toString(date);
		}
		return year2 + "/" + Month2 + "/" + date2;
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	public String getType() {
		return S_Ranking;
	}

}
