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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.utils.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class S_BookmarkLoad extends ServerBasePacket {
    private static final String S_BookMarkLoad = "[S] S_BookmarkLoad";
    private byte[] _byte = null;

    private static Logger _log = LoggerFactory.getLogger(S_BookmarkLoad.class.getName());
    private final int maxBookmarks = 100; //TODO -- pull from config.. but verify a certain # won't crash the client first

    public S_BookmarkLoad(L1PcInstance pc) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			ArrayList<Integer> quicklist = new ArrayList<Integer>();
			
			con = L1DatabaseFactory.getInstance().getConnection();
			// order by the replaced regex name instead of normal name
			// because normal name can have like \f0 \d0, etc for the colours and arrows
			pstm = con.prepareStatement("SELECT * FROM character_teleport WHERE char_id=? ORDER BY REGEXP_REPLACE(name, '\\\\\\\\..', '') ASC");
			pstm.setInt(1, pc.getId());
			rs = pstm.executeQuery();
			
			L1BookMark bookmark = null;
			int x = 0;
			while (rs.next()) {
				bookmark = new L1BookMark();
				bookmark.setId(rs.getInt("id"));
				bookmark.setCharId(rs.getInt("char_id"));
				bookmark.setName(rs.getString("name"));
				bookmark.setLocX(rs.getInt("locx"));
				bookmark.setLocY(rs.getInt("locy"));
				bookmark.setMapId(rs.getShort("mapid"));
				bookmark.setQuick(rs.getBoolean("quicklist"));

				pc.addBookMark(bookmark);
				
				if(bookmark.isQuick()) {
					quicklist.add(x);
				}
				
				x++;
			}
			
			int count = pc.getBookMarkSize();
			writeC(Opcodes.S_OPCODE_CHARRESET);
			writeC(42); // type
			writeC(maxBookmarks);
			writeC(0x00); 
			writeC(0x02);

			for (int i= 0; i < count; i++) {
				writeC(i);
			}
			
			int quicklistCount = quicklist.size();
			for (int i= 0; i < quicklist.size(); i++) {
				writeC(quicklist.get(i));
			}
			
			int blanks = maxBookmarks - 1 - count - quicklistCount;
			for (int i= 0; i < blanks; i++) {
				writeC(0xff);
			}
			
			writeC(maxBookmarks);
			writeC(0);
			writeH(count);
			
			for(L1BookMark bm : pc.getBookMarks()) {
				writeD(bm.getId());
				writeS(bm.getName());
				writeH(bm.getMapId());
				writeH(bm.getLocX());
				writeH(bm.getLocY());
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs, pstm, con);
		}
	}

    @Override

    public byte[] getContent() {
        if (_byte == null) {
            _byte = getBytes();
        }
        return _byte;
    }


    public String getType() {
        return S_BookMarkLoad;

    }

}
