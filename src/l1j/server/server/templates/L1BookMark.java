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

package l1j.server.server.templates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Bookmarks;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.utils.SQLUtil;

public class L1BookMark {
	private static Logger _log = LoggerFactory.getLogger(L1BookMark.class.getName());
	private int _charId;
	private int _id;
	private String _name;
	private int _locX;
	private int _locY;
	private short _mapId;
	private boolean _isQuick;

	public L1BookMark() {
	}

	public static void deleteBookmark(L1PcInstance player, String s) {
		L1BookMark book = player.getBookMark(s);
		if (book != null) {
			Connection con = null;
			PreparedStatement pstm = null;
			try {
				con = L1DatabaseFactory.getInstance().getConnection();
				pstm = con
						.prepareStatement("DELETE FROM character_teleport WHERE id=?");
				pstm.setInt(1, book.getId());
				pstm.execute();
				player.removeBookMark(book);
			} catch (SQLException e) {
				_log.error(
						"Bookmark to remove the error occurred.", e);
			} finally {
				SQLUtil.close(pstm);
				SQLUtil.close(con);
			}
		}
	}
	
	public static void updateBookmark(L1PcInstance pc, int objId, String bookmarkName) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE character_teleport SET name = ? WHERE id = ?");
			pstm.setString(1, bookmarkName);
			pstm.setInt(2, objId);
			pstm.execute();
			
			L1BookMark bookmark = pc.getBookMark(objId);
			bookmark.setName(bookmarkName);
		} catch (SQLException e) {
			_log.error("Add Bookmark error has occurred.", e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	public static void setQuickList(L1PcInstance pc, ArrayList<Integer> quicklistIds) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE character_teleport SET quicklist = false WHERE char_id = ?");
			pstm.setInt(1, pc.getId());
			pstm.execute();
			
			if(quicklistIds.size() > 0) {
				SQLUtil.close(pstm);
				
				StringBuilder builder = new StringBuilder();

				for( int i = 0 ; i < quicklistIds.size(); i++ ) {
				    builder.append("?,");
				}
				
				pstm = con.prepareStatement("UPDATE character_teleport SET quicklist = true WHERE char_id = ? AND id IN (" 
						+ builder.deleteCharAt( builder.length() -1 ).toString() + ")" ); 
				pstm.setInt(1, pc.getId());
				
				for( int i = 0 ; i < quicklistIds.size(); i++ ) {
				    pstm.setInt(i + 2, quicklistIds.get(i));
				}
				pstm.execute();
			}
		} catch (SQLException e) {
			_log.error("Add Bookmark error has occurred.", e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public static void addBookmark(L1PcInstance pc, String s) {
		// Because client-side checks required
		// if (s.length() > 12) {
		// pc.sendPackets(new S_ServerMessage(204));
		// return;
		// }
		if (!pc.getMap().isMarkable() && !pc.isGm()) {
			pc.sendPackets(new S_ServerMessage(214)); // Remember, you can not
														// here.
			return;
		}
		int size = pc.getBookMarkSize();
		if (size > 99) {
			pc.sendPackets(new S_ServerMessage(676)); // too many bookmarks
			return;
		}
		if (pc.getBookMark(s) == null) {
			L1BookMark bookmark = new L1BookMark();
			bookmark.setId(IdFactory.getInstance().nextId());
			bookmark.setCharId(pc.getId());
			bookmark.setName(s);
			bookmark.setLocX(pc.getX());
			bookmark.setLocY(pc.getY());
			bookmark.setMapId(pc.getMapId());
			Connection con = null;
			PreparedStatement pstm = null;
			try {
				con = L1DatabaseFactory.getInstance().getConnection();
				pstm = con
						.prepareStatement("INSERT INTO character_teleport SET id = ?, char_id = ?, name = ?, locx = ?, locy = ?, mapid = ?");
				pstm.setInt(1, bookmark.getId());
				pstm.setInt(2, bookmark.getCharId());
				pstm.setString(3, bookmark.getName());
				pstm.setInt(4, bookmark.getLocX());
				pstm.setInt(5, bookmark.getLocY());
				pstm.setInt(6, bookmark.getMapId());
				pstm.execute();
			} catch (SQLException e) {
				_log.error("Add Bookmark error has occurred.", e);
			} finally {
				SQLUtil.close(pstm);
				SQLUtil.close(con);
			}
			pc.addBookMark(bookmark);
			pc.sendPackets(new S_Bookmarks(s, bookmark.getMapId(), bookmark
					.getId(), bookmark.getLocX(), bookmark.getLocY()));
		} else {
			pc.sendPackets(new S_ServerMessage(327)); // The same name already
														// exists.
		}
	}

	public int getId() {
		return _id;
	}

	public void setId(int i) {
		_id = i;
	}

	public int getCharId() {
		return _charId;
	}

	public void setCharId(int i) {
		_charId = i;
	}

	public String getName() {
		return _name;
	}

	public void setName(String s) {
		_name = s;
	}

	public int getLocX() {
		return _locX;
	}

	public void setLocX(int i) {
		_locX = i;
	}

	public int getLocY() {
		return _locY;
	}

	public void setLocY(int i) {
		_locY = i;
	}

	public short getMapId() {
		return _mapId;
	}

	public void setMapId(short i) {
		_mapId = i;
	}
	
	public boolean isQuick() {
		return _isQuick;
	}
	
	public void setQuick(boolean quick) {
		_isQuick = quick;
	}
}