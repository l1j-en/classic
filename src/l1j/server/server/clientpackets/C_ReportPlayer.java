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
package l1j.server.server.clientpackets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.ClientThread;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.SQLUtil;

public class C_ReportPlayer extends ClientBasePacket {
	private static final String C_ReportPlayer = "[C] C_ReportPlayer";
	private static Logger _log = Logger.getLogger(C_ReportPlayer.class.getName());
	int objid = readD();
	
	public C_ReportPlayer(byte abyte0[], ClientThread clientthread) throws Exception {
		super(abyte0);
		L1PcInstance pc = clientthread.getActiveChar();
		
		Connection con = null;
		PreparedStatement pstm = null;
			
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("INSERT INTO BotReport (id, date, charname, ip) VALUES (?, ?, ?, ?);");
			Date time = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fm = formatter.format(time.getTime());
			pstm.setInt(1, pc.getId());
			pstm.setString(2, fm);
			pstm.setString(3, pc.getName());
			pstm.setString(4, pc.getNetConnection().getIp());
			pstm.execute();
			pc.sendPackets(new S_SystemMessage("Bot Reported. Thank you for your help!"));
			} catch (Exception e) {
				pc.sendPackets(new S_SystemMessage("Could not Report : ('" + pc.getName() + ");"));
				e.printStackTrace();
			} finally {
				SQLUtil.close(pstm);
				SQLUtil.close(con);
			}
	}
	
	@Override
	public String getType() {
		return C_ReportPlayer;
	}
}