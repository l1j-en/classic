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
package l1j.server.server.command.executor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.model.L1Teleport;
public class L1Resolve implements L1CommandExecutor {
	private static Logger _log = Logger.getLogger(L1Resolve.class.getName());

	private L1Resolve() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Resolve();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE bugs SET resolved=1 WHERE id=?");
			pstm.setInt(1, Integer.valueOf(arg).intValue());
			pstm.execute();
			pc.sendPackets(new S_SystemMessage("Bug #"+arg+" has been resolved!"));
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".resolve bugID"));
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}	
	}
}
