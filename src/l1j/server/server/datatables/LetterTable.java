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
package l1j.server.server.datatables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// IdFactory
public class LetterTable {
	private static Logger _log = LoggerFactory.getLogger(LetterTable.class.getName());
	private static LetterTable _instance;

	public LetterTable() {
	}

	public static LetterTable getInstance() {
		if (_instance == null) {
			_instance = new LetterTable();
		}
		return _instance;
	}

	// ID templates list
	// 16: Character does not exist
	// 32: Too much baggage
	// 48: there is no clan
	// 64: contents are missing (white)
	// 80: not see the contents of (surplus)
	// 96: not see the contents of (surplus)
	// 112: Congratulations. %n You are joining in the final auction price %0
	// Adena bid price.
	// 128: You are presented with a higher amount than the amount it appeared
	// to offer, but unfortunately failed bid.
	// 144: You took part in the auction was a success and is now ready to home
	// ownership.
	// 160: Your house was owned by the Adena 1 percent in the final bid price.
	// 176: did you apply for your auction, the auction period, more than the
	// amount offered to pay for it is expressed, in the end cancelled.
	// 192: did you apply for your auction, the auction period, more than the
	// amount offered to pay for it is expressed, in the end cancelled.
	// 208: Your blood in the house was owned by the manor belonging to the
	// territory for the future if you want to use our taxes must.
	// 224: You have your house 0% tax imposed by the Adena not yet paid.
	// 240: You will end up in your home to a 0 percent tax imposed on, your
	// house as a warning against deprivation of property rights.

	public void writeLetter(int itemObjectId, int code, String sender,
			String receiver, String date, int templateId, byte[] subject,
			byte[] content) {

		Connection con = null;
		PreparedStatement pstm1 = null;
		ResultSet rs = null;
		PreparedStatement pstm2 = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm1 = con
					.prepareStatement("SELECT * FROM letter ORDER BY item_object_id");
			rs = pstm1.executeQuery();
			pstm2 = con
					.prepareStatement("INSERT INTO letter SET item_object_id=?, code=?, sender=?, receiver=?, date=?, template_id=?, subject=?, content=?");
			pstm2.setInt(1, itemObjectId);
			pstm2.setInt(2, code);
			pstm2.setString(3, sender);
			pstm2.setString(4, receiver);
			pstm2.setString(5, date);
			pstm2.setInt(6, templateId);
			pstm2.setBytes(7, subject);
			pstm2.setBytes(8, content);
			pstm2.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm1);
			SQLUtil.close(pstm2);
			SQLUtil.close(con);
		}
	}

	public void deleteLetter(int itemObjectId) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("DELETE FROM letter WHERE item_object_id=?");
			pstm.setInt(1, itemObjectId);
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}