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
package l1j.server.IdFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Database.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

public class IdFactory {
	private static Logger _log = Logger.getLogger(IdFactory.class.getName());
	private int _curId;
	private Object _monitor = new Object();
	private static final int FIRST_OID = 0x10000000;
	
	private static IdFactory _instance = new IdFactory();

	protected IdFactory() {
		loadState();
		setAllCharacterOffline(); 
	}

	private void setAllCharacterOffline() 
	     { 
	         java.sql.Connection con2 = null; 
	         try 
	         { 
	             con2 = L1DatabaseFactory.getInstance().getConnection(); 
	             Statement s2 = con2.createStatement(); 
	             s2.executeUpdate("update characters set online=0"); 
	             _log.info("Updated characters online status."); 
	  
	             s2.close(); 
	         } 
	         catch (SQLException e) 
	         { 
	         } 
	         finally 
	         { 
	             try 
	             { 
	                 con2.close(); 
	             } 
	             catch (Exception e) 
	             { 
	           } 
	      } 
	}
	
	public static IdFactory getInstance() {
		return _instance;
	}

	public int nextId() {
		synchronized (_monitor) {
			return _curId++;
		}
	}

	private void loadState() {
		// DB to seek MAXID
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("select max(id)+1 as nextid from (select id from character_items union all select id from character_teleport union all select id from character_warehouse union all select objid as id from characters union all select clan_id as id from clan_data union all select id from clan_warehouse union all select objid as id from pets) t");
			rs = pstm.executeQuery();

			int id = 0;
			if (rs.next()) {
				id = rs.getInt("nextid");
			}
			if (id < FIRST_OID) {
				id = FIRST_OID;
			}
			_curId = id;
			_log.info("IDFactory current max ID: " + _curId);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}
