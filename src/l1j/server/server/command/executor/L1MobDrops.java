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

import java.util.logging.Logger;

import java.util.ArrayList;

import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import l1j.server.server.utils.SQLUtil;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.templates.L1Item;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.templates.L1Drop;
import l1j.server.server.datatables.DropTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.templates.L1Npc;

public class L1MobDrops implements L1CommandExecutor {
	private static Logger _log = Logger.getLogger(L1MobDrops.class.getName());

	private L1MobDrops() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1MobDrops();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {

		int mobID=Integer.parseInt(arg);
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT gfxid FROM npc WHERE npcid=?");
			pstm.setInt(1, mobID);
			rs = pstm.executeQuery();

			int gfxID;
			rs.next();
			gfxID=rs.getInt("gfxid");
			rs.close();
			pstm.close();
			con.close();

			ArrayList<L1Drop> mobDrops = DropTable.getInstance().getDrops(mobID);
			L1Item item;
			String blessed;
			L1Npc theMob = NpcTable.getInstance().getTemplate(mobID);
			pc.sendPackets(new S_SystemMessage(theMob.get_name()+"("+mobID+") | gfxID: "+gfxID+" | drops:"));
			for (L1Drop drop : mobDrops) {
				item = ItemTable.getInstance().getTemplate(drop.getItemid());
				if(item.getBless() == 1){
					blessed = "";
				}
				else if(item.getBless() == 0){
					blessed = "\\fR";
				}
				else{
					blessed = "\\fY";
				}
				double chance = drop.getChance()/(double)10000;
				pc.sendPackets(new S_SystemMessage(blessed+drop.getMin()+"-"+drop.getMax()+" "+drop.getItemid()+" "+item.getName()+" "+chance+"%"));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".mob npcID"));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}
