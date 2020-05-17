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
import java.sql.Timestamp;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import l1j.server.Config;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.templates.L1Mail;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;



// Referenced classes of package l1j.server.server:
// IdFactory
public class MailTable {
	private static Logger _log = LoggerFactory.getLogger(MailTable.class.getName());
	private static MailTable _instance;
	private static ArrayList<L1Mail> _allMail = new ArrayList<L1Mail>();

	public static MailTable getInstance() {
		if (_instance == null) {
			_instance = new MailTable();
		}
		return _instance;
	}

	private MailTable() {
		loadMail();
	}

	private void loadMail() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM mail");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1Mail mail = new L1Mail();
				mail.setId(rs.getInt("id"));
				mail.setType(rs.getInt("type"));
				mail.setSenderName(rs.getString("sender"));
				mail.setReceiverName(rs.getString("receiver"));
				mail.setDate(rs.getTimestamp("date"));
				mail.setReadStatus(rs.getInt("read_status"));
				mail.setInBoxId(rs.getInt("inbox_id"));
				mail.setSubject(rs.getBytes("subject"));
				mail.setContent(rs.getBytes("content"));
				_allMail.add(mail);
			}
		} catch (SQLException e) {
			_log.error("error while creating mail table", e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void setReadStatus(int mailId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM mail WHERE id=?");
			pstm.setInt(1,mailId);
			rs = pstm.executeQuery();
			if (rs != null && rs.next()) {
				pstm = con
						.prepareStatement("UPDATE mail SET read_status=? WHERE id=?");
				pstm.setInt(1, 1);
				pstm.setInt(2, mailId);
				pstm.execute();
				changeMailStatus(mailId);
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void setMailType(int mailId, int type) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM mail WHERE id=?");
			pstm.setInt(1,mailId);
			rs = pstm.executeQuery();
			if (rs != null && rs.next()) {
				pstm = con.prepareStatement("UPDATE mail SET type=? WHERE id=?");
				pstm.setInt(1, type);
				pstm.setInt(2, mailId);
				pstm.execute();
				changeMailType(mailId, type);
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void deleteMail(int mailId) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("DELETE FROM mail WHERE id=?");
			pstm.setInt(1,mailId);
			pstm.execute();
			delMail(mailId);
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public int writeMail(int type, String receiver, L1PcInstance writer, byte[] text, int inboxId) {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		int readStatus = 0;
		int id = 0;
		
		int spacePosition1 = 0;
		int spacePosition2 = 0;
		for (int i = 0; i < text.length; i += 2) {
			if (text[i] == 0 && text[i + 1] == 0) {
				if (spacePosition1 == 0) {
					spacePosition1 = i;
				} else if (spacePosition1 != 0 && spacePosition2 == 0) {
					spacePosition2 = i;
					break;
				}
			}
		}

		// maile[u
		int subjectLength = spacePosition1 + 2;
		int contentLength = spacePosition2 - spacePosition1;
		if (contentLength <= 0) {
			contentLength = 1;
		}
		byte[] subject = new byte[subjectLength];
		byte[] content = new byte[contentLength];
		System.arraycopy(text, 0, subject, 0, subjectLength);
		System.arraycopy(text, subjectLength, content, 0, contentLength);
		Connection con = null;
		PreparedStatement pstm2 = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm2 = con.prepareStatement("INSERT INTO mail SET id=?, type=?, sender=?, receiver=?, date=?, read_status=?, inbox_id=?, subject=?, content=?");
			id = IdFactory.getInstance().nextId();
			pstm2.setInt(1, id);
			pstm2.setInt(2, type);
			pstm2.setString(3, writer.getName());
			pstm2.setString(4, receiver);
			pstm2.setTimestamp(5, date);
			pstm2.setInt(6, readStatus);
			pstm2.setInt(7, inboxId);
			pstm2.setBytes(8, subject);
			pstm2.setBytes(9, content);
			pstm2.execute();
			L1Mail mail = new L1Mail();
			mail.setId(id);
			mail.setType(type);
			mail.setSenderName(writer.getName());
			mail.setReceiverName(receiver);
			mail.setDate(date);
			mail.setReadStatus(readStatus);
			mail.setInBoxId(inboxId);
			mail.setSubject(subject);
			mail.setContent(content);
			_allMail.add(mail);
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm2);
			SQLUtil.close(con);
		}
		return id;
	}

	public static ArrayList<L1Mail> getAllMail() {
		return _allMail;
	}

	public static L1Mail getMail(int mailId) {
		for (L1Mail mail : _allMail) {
			if (mail.getId() == mailId) {
				return mail;
			}
		}
		return null;
	}

	private void changeMailStatus(int mailId) {
		for (L1Mail mail : _allMail) {
			if (mail.getId() == mailId) {
				L1Mail newMail = mail;
				newMail.setReadStatus(1);
				_allMail.remove(mail);
				_allMail.add(newMail);
				break;
			}
		}
	}

	private void changeMailType(int mailId, int type) {
		for (L1Mail mail : _allMail) {
			if (mail.getId() == mailId) {
				L1Mail newMail = mail;
				newMail.setType(type);
				_allMail.remove(mail);
				_allMail.add(newMail);
				break;
			}
		}
	}

	private void delMail(int mailId) {
		for (L1Mail mail : _allMail) {
			if(mail.getId() == mailId) {
				_allMail.remove(mail);
				break;
			}
		}
	}
}
