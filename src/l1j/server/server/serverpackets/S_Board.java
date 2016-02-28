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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.NpcSpawnTable;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class S_Board extends ServerBasePacket {
	private static final String S_BOARD = "[S] S_Board";
	private static Logger _log = Logger.getLogger(S_Board.class.getName());
	private byte[] _byte = null;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");

	public S_Board(L1NpcInstance board, L1PcInstance pc) {
		buildPacket(board, 0, pc);
	}

	public S_Board(L1NpcInstance board, int number, L1PcInstance pc) {
		buildPacket(board, number, pc);
	}
	
	private void buildPacket(L1NpcInstance board, int number, L1PcInstance pc) {
		boolean bugBoard = board.getSpawn() == NpcSpawnTable.bugBoard;
		int count = 0;
		String[][] db = new String[8][3];
		int[] id = new int[8];
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			if(!bugBoard || pc == null) {
				pstm = con.prepareStatement("SELECT * FROM board order by id desc");
				rs = pstm.executeQuery();
				while (rs.next() && count < 8) {
					if (rs.getInt("id") <= number || number == 0) {
						id[count] = rs.getInt(1);
						db[count][0] = rs.getString(2);
						db[count][1] = rs.getString(3);
						db[count][2] = rs.getString(4);
						count++;
					}
				}
			} else {
				if(pc.isGm())
					pstm = con.prepareStatement("SELECT * FROM bugs WHERE resolved != 1 order by id desc");
				else {
					pstm = con.prepareStatement("SELECT * FROM bugs where charname = ?  AND resolved != 1 order by id desc");
					pstm.setString(1, pc.getName());
				}
					
				rs = pstm.executeQuery();
				while (rs.next() && count < 8) {
					if (rs.getInt("id") <= number || number == 0) {
						id[count] = rs.getInt(1);
						db[count][0] = rs.getString(3);
						db[count][1] = dateFormat.format(rs.getDate(9));
						db[count][2] = rs.getString(8);
						count++;
					}
				}
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		// TODO: this enables the back button
		// but does some funky stuff on pages with < 8 posts
		// need to look into how to fix it
		/*writeC(Opcodes.S_OPCODE_BOARD);
		writeD(board.getId());
		if (number == 0) {
			writeD(0x7FFFFFFF);
		} else {
			writeD(number);
		}

		writeC(count);
		
		if (number == 0) {
			writeC(0);
			writeH(300);
		}*/
		
		writeC(Opcodes.S_OPCODE_BOARD);
		writeD(board.getId());
		writeC(0xFF); // ?
		writeC(0xFF); // ?
		writeC(0xFF); // ?
		writeC(0x7F); // ?
		writeH(count); 	
		writeH(bugBoard ? 0 : 300);
		
		for (int i = 0; i < count; ++i) {
			writeD(id[i]);
			writeS(db[i][0]);
			writeS(db[i][1]);
			writeS(db[i][2]);
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
		return S_BOARD;
	}
}