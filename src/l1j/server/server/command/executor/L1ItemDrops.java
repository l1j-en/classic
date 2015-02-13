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

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Item;
import l1j.server.server.utils.SQLUtil;

public class L1ItemDrops implements L1CommandExecutor {

	private L1ItemDrops() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1ItemDrops();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {

		int dropID = 0;
		try {
			dropID = Integer.parseInt(arg);
		} catch (NumberFormatException e) {
			pc.sendPackets(new S_SystemMessage(".item itemID"));
		}
		if (dropID == 40308) {
			pc.sendPackets(new S_SystemMessage(
					"Adena(40308) drops from almost everything"));
		} else {
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			int[] mobID;
			int[] min;
			int[] max;
			double[] chance;
			String[] name;
			try {
				L1Item item = ItemTable.getInstance().getTemplate(dropID);
				String blessed;
				if (item.getBless() == 1) {
					blessed = "";
				} else if (item.getBless() == 0) {
					blessed = "\\fR";
				} else {
					blessed = "\\fY";
				}
				con = L1DatabaseFactory.getInstance().getConnection();
				pstm = con
						.prepareStatement("SELECT mobId,min,max,chance FROM droplist WHERE itemId=?");
				pstm.setInt(1, dropID);
				rs = pstm.executeQuery();
				rs.last();
				int rows = rs.getRow();
				mobID = new int[rows];
				min = new int[rows];
				max = new int[rows];
				chance = new double[rows];
				name = new String[rows];
				rs.beforeFirst();
				int i = 0;
				while (rs.next()) {
					mobID[i] = rs.getInt("mobId");
					min[i] = rs.getInt("min");
					max[i] = rs.getInt("max");
					chance[i]=rs.getInt("chance")/(double)10000 * Config.RATE_DROP_ITEMS;
					i++;
				}
				rs.close();
				pstm.close();
				pc.sendPackets(new S_SystemMessage(blessed + item.getName()
						+ "(" + dropID + ") drops from:"));
				for (int j = 0; j < mobID.length; j++) {
					pstm = con
							.prepareStatement("SELECT name FROM npc WHERE npcid=?");
					pstm.setInt(1, mobID[j]);
					rs = pstm.executeQuery();
					while (rs.next()) {
						name[j] = rs.getString("name");
					}
					rs.close();
					pstm.close();
					pc.sendPackets(new S_SystemMessage(min[j] + "-" + max[j]
							+ " " + mobID[j] + " " + name[j] + " " + chance[j]
							+ "%"));
				}
			} catch (Exception e) {
				pc.sendPackets(new S_SystemMessage(".item itemID"));
			} finally {
				SQLUtil.close(rs);
				SQLUtil.close(pstm);
				SQLUtil.close(con);
			}
		}
	}
}