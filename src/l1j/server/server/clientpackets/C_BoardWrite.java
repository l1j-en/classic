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
import java.util.Calendar;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.BoardTable;
import l1j.server.server.datatables.NpcSpawnTable;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_BoardWrite extends ClientBasePacket {

	private static final String C_BOARD_WRITE = "[C] C_BoardWrite";
	private static Logger _log = LoggerFactory.getLogger(C_BoardWrite.class.getName());

	public C_BoardWrite(byte decrypt[], Client client) {
		super(decrypt);
		int id = readD();
		String date = currentTime();
		String title = readS();
		String content = readS();

		L1Object tg = L1World.getInstance().findObject(id);

		if (tg != null) {
			L1PcInstance pc = client.getActiveChar();
			
			if(tg instanceof L1NpcInstance
					&& ((L1NpcInstance)tg).getSpawn() == NpcSpawnTable.getBugBoard()) {
				Connection con = null;
				PreparedStatement pstm = null;

				try {
					con = L1DatabaseFactory.getInstance().getConnection();
					pstm = con
							.prepareStatement("INSERT INTO bugs (bugtext, charname, mapID, mapX, mapY, resolved, title, submitted) VALUES (?, ?, ?, ?, ?, 0, ?, NOW());");
					pstm.setString(1, content);
					pstm.setString(2, pc.getName());
					pstm.setInt(3, pc.getMapId());
					pstm.setInt(4, pc.getX());
					pstm.setInt(5, pc.getY());
					pstm.setString(6, title);
					pstm.execute();
					pc.sendPackets(new S_SystemMessage("Thank you for the bug report!"));
					
					for(L1PcInstance player : L1World.getInstance().getAllPlayers()) {
						if(player.isGm())
							player.sendPackets(new S_SystemMessage(pc.getName() + " has submitted a bug!"));
					}
				} catch (Exception e) {
					_log.warn(
							String.format("%s submitted a bug report, but an error occurred! Bug Text: %s",
									pc.getName(), content));
				} finally {
					SQLUtil.close(pstm);
					SQLUtil.close(con);
				}
			} else if(((L1NpcInstance)tg).getSpawn() == NpcSpawnTable.getRankingBoard()) {
				pc.sendPackets(new S_SystemMessage("Cannot write to this board."));
			} else {
				pc.getInventory().consumeItem(L1ItemId.ADENA, 300);
				BoardTable.getInstance().writeTopic(pc, date, title, content);
			}
		} else {
			_log.warn("C_BoardWrite: Illegal NPCID : " + id);
		}
	}

	private static String currentTime() {
		TimeZone tz = TimeZone.getTimeZone(Config.TIME_ZONE);
		Calendar cal = Calendar.getInstance(tz);
		int year = cal.get(Calendar.YEAR) - 2000;
		String year2;
		if (year < 10) {
			year2 = "0" + year;
		} else {
			year2 = Integer.toString(year);
		}
		int Month = cal.get(Calendar.MONTH) + 1;
		String Month2 = null;
		if (Month < 10) {
			Month2 = "0" + Month;
		} else {
			Month2 = Integer.toString(Month);
		}
		int date = cal.get(Calendar.DATE);
		String date2 = null;
		if (date < 10) {
			date2 = "0" + date;
		} else {
			date2 = Integer.toString(date);
		}
		return year2 + "/" + Month2 + "/" + date2;
	}

	@Override
	public String getType() {
		return C_BOARD_WRITE;
	}
}