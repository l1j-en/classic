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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_ApplyAuction extends ServerBasePacket {
	private static Logger _log = LoggerFactory.getLogger(S_ApplyAuction.class
			.getName());
	private static final String S_APPLYAUCTION = "[S] S_ApplyAuction";
	private byte[] _byte = null;

	public S_ApplyAuction(int objectId, String houseNumber) {
		buildPacket(objectId, houseNumber);
	}

	private void buildPacket(int objectId, String houseNumber) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM board_auction WHERE house_id=?");
			int number = Integer.valueOf(houseNumber);
			pstm.setInt(1, number);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int nowPrice = rs.getInt(5);
				int bidderId = rs.getInt(10);
				writeC(Opcodes.S_OPCODE_INPUTAMOUNT);
				writeD(objectId);
				writeD(0); // ?
				if (bidderId == 0) { // No bidders
					writeD(nowPrice); // The initial price of spin control
					writeD(nowPrice); // The lower limit price
				} else { // With bidders
					writeD(nowPrice + 1); // The initial price of spin control
					writeD(nowPrice + 1); // The lower limit price
				}
				writeD(2000000000); // Maximum price
				writeH(0); // ?
				writeS("agapply");
				writeS("agapply " + houseNumber);
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
		return S_APPLYAUCTION;
	}
}