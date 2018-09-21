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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class S_BoardRead extends ServerBasePacket {
	private static final String S_BoardRead = "[C] S_BoardRead";
	private static Logger _log = LoggerFactory.getLogger(S_BoardRead.class.getName());
	private byte[] _byte = null;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a z");

	public S_BoardRead(int number) {
		buildPacket(number);
	}
	
	// should only be called to display the bug board!!
	public S_BoardRead(L1PcInstance pc, int number) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM bugs WHERE id=? AND (charname=? OR 1 = ?) AND resolved != 1");
			pstm.setInt(1, number);
			pstm.setString(2, pc.getName());
			pstm.setInt(3, pc.isGm() ? 1 : 0);
			rs = pstm.executeQuery();
			while (rs.next()) {
				writeC(Opcodes.S_OPCODE_BOARDREAD);
				writeD(number);
				writeS(rs.getString(3));
				writeS(rs.getString(8));
				writeS(dateFormat.format(rs.getDate(9)));
				String body = String.format("%s\n\nLocation: %d, %d, %d\nSubmission Time: %s",
						rs.getString(2),
						rs.getInt(5), rs.getInt(6), rs.getInt(4), timeFormat.format(rs.getTime(9)));
				writeS(body);
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void buildPacket(int number) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM board WHERE id=?");
			pstm.setInt(1, number);
			rs = pstm.executeQuery();
			while (rs.next()) {
				writeC(Opcodes.S_OPCODE_BOARDREAD);
				writeD(number);
				writeS(rs.getString(2));
				writeS(rs.getString(4));
				writeS(rs.getString(3));
				writeS(rs.getString(5));
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
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
		return S_BoardRead;
	}
}