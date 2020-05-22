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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.SQLUtil;

public class L1Search implements L1CommandExecutor {
	private static Logger _log = LoggerFactory.getLogger(L1Search.class.getName());

	private L1Search() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Search();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer st = new StringTokenizer(arg);
			String type = "";
			String name = "";
			String add = "";
			boolean simpleS = true;
			int itCount = 0;
			while (st.hasMoreTokens()) {
				if (itCount == 1) {
					add = "%";
				}
				String tempVar = st.nextToken();
				if (itCount == 0
						&& (tempVar.equals("armor") || tempVar.equals("weapon")
								|| tempVar.equals("misci")
								|| tempVar.equals("npc") || tempVar
									.equals("map"))) {
					simpleS = false;
					type = tempVar;
				} else {
					name = name + add + tempVar;
				}
				itCount++;
			}
			
			// don't allow a blank
			if(itCount == 0)
				return;
			
			// set the db lookup to run on another thread
			final boolean passableSimpleS = simpleS;
			final String passableType = type;
			final String passableName = name;
			
			GeneralThreadPool.getInstance().execute(new Runnable() {
				@Override
	            public void run() {
					if (passableSimpleS == false) {
						find_object(pc, passableType, passableName);
					} else {
						find_object(pc, passableName);
					}
				}
			});
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					".find (type[armor,misci,weapon,npc,map]) searchText"));
		}
	}

	// TODO: rewrite this to use the cached datatables rather than hitting the
	// database.
	private void find_object(L1PcInstance pc, String type, String name) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String str1 = null;
			String str2 = null;
			int bless = 0;
			int count = 0;
			con = L1DatabaseFactory.getInstance().getConnection();
			boolean error = false;

			pc.sendPackets(new S_SystemMessage(" "));

			if (type.equals("misci")) {
				statement = con
						.prepareStatement("select item_id,name,bless from etcitem where name Like concat('%',?,'%')");
			} else if (type.equals("weapon")) {
				statement = con
						.prepareStatement("select item_id,name,bless from weapon where name Like concat('%',?,'%')");
			} else if (type.equals("armor")) {
				statement = con
						.prepareStatement("select item_id,name,bless from armor where name Like concat('%',?,'%')");
			} else if (type.equals("poly")) {
				statement = con
						.prepareStatement("select polyid,name from polymorphs where name Like concat('%',?,'%')");
			} else if (type.equals("npc")) {
				statement = con
						.prepareStatement("select npcid,name from npc where name Like concat('%',?,'%')");
			} else if (type.equals("map")) {
				statement = con
						.prepareStatement("select mapid,locationname,startx,endx,starty,endy from mapids where locationname Like concat('%',?,'%')");
			} else {
				error = true;
				pc.sendPackets(new S_SystemMessage(
						".find type[armor,misci,weapon,npc] searchText"));
			}
			if (error == false) {
				statement.setString(1, name);
				rs = statement.executeQuery();
				pc.sendPackets(new S_SystemMessage("Searching " + type
						+ " for '" + name.replace("%", " ") + "'"));
				while (rs.next()) {
					str1 = rs.getString(1);
					str2 = rs.getString(2);
					if (type.equals("misci") || type.equals("weapon")
							|| type.equals("armor")) {
						bless = rs.getInt(3);
						pc.sendPackets(new S_SystemMessage(getBlessColor(bless)
								+ "ID: " + str1 + ", " + str2));
					} else {
						pc.sendPackets(new S_SystemMessage("ID: " + str1 + ", "
								+ str2));
					}
					count++;
				}
				pc.sendPackets(new S_SystemMessage("Found " + count
						+ " instance(s) that matched " + type + "."));
			}
		} catch (Exception e) {
			_log.error("",e);
		} finally {
			SQLUtil.close(rs, statement, con);
		}
	}

	private void find_object(L1PcInstance pc, String name) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String str1 = null;
			String str2 = null;
			int bless = 0;

			con = L1DatabaseFactory.getInstance().getConnection();
			pc.sendPackets(new S_SystemMessage(" "));
			pc.sendPackets(new S_SystemMessage("Searching for '"
					+ name.replace("%", " ") + "' in all places:"));

			statement = con
					.prepareStatement("select item_id,name,bless from armor where name Like concat('%',?,'%')");
			statement.setString(1, name);

			int armorCount = 0;
			rs = statement.executeQuery();
			while (rs.next()) {
				if (armorCount == 0)
					pc.sendPackets(new S_SystemMessage("Armors:"));
				str1 = rs.getString(1);
				str2 = rs.getString(2);
				bless = rs.getInt(3);
				pc.sendPackets(new S_SystemMessage(getBlessColor(bless)
						+ "ID: " + str1 + ", " + str2));
				armorCount++;
			}
			rs.close();
			statement.close();

			statement = con
					.prepareStatement("select item_id,name,bless from weapon where name Like concat('%',?,'%')");
			statement.setString(1, name);
			int weaponCount = 0;
			rs = statement.executeQuery();
			while (rs.next()) {
				if (weaponCount == 0)
					pc.sendPackets(new S_SystemMessage("Weapons:"));
				str1 = rs.getString(1);
				str2 = rs.getString(2);
				bless = rs.getInt(3);
				pc.sendPackets(new S_SystemMessage(getBlessColor(bless)
						+ "ID: " + str1 + ", " + str2));
				weaponCount++;
			}
			rs.close();
			statement.close();

			statement = con
					.prepareStatement("select item_id,name,bless from etcitem where name Like concat('%',?,'%')");
			statement.setString(1, name);
			int etcCount = 0;
			rs = statement.executeQuery();
			while (rs.next()) {
				if (etcCount == 0)
					pc.sendPackets(new S_SystemMessage("Etcitems:"));
				str1 = rs.getString(1);
				str2 = rs.getString(2);
				bless = rs.getInt(3);
				pc.sendPackets(new S_SystemMessage(getBlessColor(bless)
						+ "ID: " + str1 + ", " + str2));
				etcCount++;
			}
			rs.close();
			statement.close();

			statement = con
					.prepareStatement("select gfx_id,name from polymorphs where name Like concat('%',?,'%')");
			statement.setString(1, name);
			int polyCount = 0;
			rs = statement.executeQuery();
			while (rs.next()) {
				if (polyCount == 0)
					pc.sendPackets(new S_SystemMessage("Polymorphs:"));
				str1 = rs.getString(1);
				str2 = rs.getString(2);
				pc.sendPackets(new S_SystemMessage("ID: " + str1 + ", " + str2));
				polyCount++;
			}
			rs.close();
			statement.close();

			statement = con
					.prepareStatement("select npcid,name from npc where name Like concat('%',?,'%')");
			statement.setString(1, name);
			int npcCount = 0;
			rs = statement.executeQuery();
			while (rs.next()) {
				if (npcCount == 0)
					pc.sendPackets(new S_SystemMessage("NPCs:"));
				str1 = rs.getString(1);
				str2 = rs.getString(2);
				pc.sendPackets(new S_SystemMessage("ID: " + str1 + ", " + str2));
				npcCount++;
			}
			rs.close();
			statement.close();

			statement = con
					.prepareStatement("select mapid,locationname,startx,endx,starty,endy from mapids where locationname Like concat('%',?,'%')");
			statement.setString(1, name);
			int mapCount = 0;
			rs = statement.executeQuery();
			while (rs.next()) {
				if (mapCount == 0)
					pc.sendPackets(new S_SystemMessage("Maps:"));
				pc.sendPackets(new S_SystemMessage(
						String.format(
								"mapid: %s name: %s, startx: %s endx: %s, starty: %s endy: %s",
								rs.getString(1), rs.getString(2),
								rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6))));
				mapCount++;
			}

			pc.sendPackets(new S_SystemMessage("Found:"));
			String found = "";
			if (armorCount > 0)
				found += armorCount + " Armors,";
			if (weaponCount > 0)
				found += weaponCount + " Weapons,";
			if (etcCount > 0)
				found += etcCount + " Etcitems,";
			if (polyCount > 0)
				found += polyCount + " Polymorphs,";
			if (npcCount > 0)
				found += npcCount + " NPCs,";
			if (mapCount > 0)
				found += mapCount + " maps.";
			found = found.length() > 0 ? found.substring(0, found.length() - 1)
					+ "." : " Nothing";
			pc.sendPackets(new S_SystemMessage(found));
		} catch (Exception e) {
			_log.error("",e);
		} finally {
			SQLUtil.close(rs, statement, con);
		}
	}

	/**
	 * Get the appropriate color string based on the item's blessed status.
	 */
	private String getBlessColor(int bless) {
		switch (bless) {
		case 0:
			return "\\fR";
		case 1:
			return "";
		case 2:
			return "\\fY";
		default:
			_log.warn("L1Search: unrecognized bless status.");
			return "";
		}
	}
}
