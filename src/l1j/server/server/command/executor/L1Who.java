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
import java.text.NumberFormat;
import java.util.List;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.classes.L1ClassId;
import l1j.server.server.serverpackets.S_CustomBoardRead;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.SQLUtil;

public class L1Who implements L1CommandExecutor {
	private static NumberFormat _currencyFormatter = NumberFormat.getCurrencyInstance();
	
	private L1Who() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Who();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			if (arg.equals("")) {
				who(pc);
			} else {
				who(pc, arg);
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".who [all]"));
		}
	}

	private void who(L1PcInstance gm, String name) {
		try {
			L1PcInstance target = getPcInstance(name.trim());
			if (target == null) {
				whoOffline(gm, name);
			} else {
				int polyId = target.getTempCharGfx();
				
				boolean isPolymorphed = false;
				
				try {
					L1ClassId.getClass(polyId);
				} catch(IllegalStateException ise) { 
					isPolymorphed = true;
				}
				
				L1PolyMorph poly = PolyTable.getInstance().getTemplate(polyId);
				String polyName = "";
				
				if(poly == null) {
					List<L1Npc> npcPoly = NpcTable.getInstance().getTemplateByGfxId(polyId);
					
					if(npcPoly.size() > 0)
						polyName = npcPoly.get(0).get_name();
				} else
					polyName = poly.getName();
					
				String message = String.format(
								"Account: %s\n" + 
								"Level %d %s %s\n" + 
								"Pledge: %s\n" + 
								"Alignment: %s (%d)\n" + 
								"Hp: %d, Mp: %d, Ac: %d\n" + 
								"Mr: %d%%, Dmg: +%d, Hit: +%d\n" + 
								"Hp Regen: %d, Mp Regen: %d\n" +
								"Karma: %d\n" + 
								"Gold: %s\n" +
								"Current Poly: %s\n\n" + 
								"To view %s's items, use:\n" + 
								"\".snoop %s inv\"",
								target.getAccountName(),
								target.getLevel(), 
								L1ClassId.getSex(target.getClassId()),
								L1ClassId.getClass(target.getClassId()),
								target.getClanname(),
								target.getLawful() == 0 ? "Neutral" : target.getLawful() < 0 ? "Chaotic" : "Lawful",
								target.getLawful(),
								target.getMaxHp(),
								target.getMaxMp(),
								target.getAc(),
								target.getMr(),
								target.getDmgup(),
								target.getHitup(),
								target.getHpr() + target.getInventory().hpRegenPerTick(),
								target.getMpr() + target.getInventory().mpRegenPerTick(),
								target.getKarma(),
								_currencyFormatter.format(target.getInventory().countItems(40308)),
								!isPolymorphed ? "None" : (polyName.equals("") ? "Unknown" : polyName)  + " (#" + polyId + ")",
								target.getName(),
								target.getName().toLowerCase());
				
				gm.sendPackets(new S_CustomBoardRead(target.getName(), 
						gm.getName(), message));
			}
		} catch (Exception exception) {
			whoOffline(gm, name);
		}
	}

	private void who(L1PcInstance gm) {
		try {
			String charC = "";
			String charS = "";
			int i = 1;
			for (L1PcInstance player : L1World.getInstance().getAllPlayers()) {
				charC = L1ClassId.getClass(player.getClassId());
				charS = L1ClassId.getSex(player.getClassId());
				gm.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(i).append(". ").append(player.getName())
						.append("(").append(player.getAccountName())
						.append("): L").append(player.getLevel()).append(" ")
						.append(charS).append(" ").append(charC).append(" ")
						.append(player.getMaxHp()).append("/")
						.append(player.getMaxMp()).append(" ")
						.append(player.getMr()).append("MR").toString()));
				i++;
			}
		} catch (Exception exception) {
		}
	}

	private void whoOffline(L1PcInstance gm, String name) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT account_name,char_name,level,MaxHp,MaxMp,Class FROM characters WHERE char_name=?");
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			rs.next();
			
			String message = new StringBuilder()
					.append("Account: ")
					.append(rs.getString("account_name")).append("\n")
					.append("Level ").append(rs.getInt("level")).append(" ")
					.append(L1ClassId.getSex(rs.getInt("Class"))).append(" ")
					.append(L1ClassId.getClass(rs.getInt("Class"))).append("\n")
					.append("Max Hp: ").append(rs.getInt("MaxHp")).append(" ")
					.append("Max Mp: ").append(rs.getInt("MaxMp")).append("\n\n")
					.append("** Currently offline **").toString();
					
			gm.sendPackets(new S_CustomBoardRead(rs.getString("char_name"), 
					gm.getName(), message));
		} catch (Exception exception) {
			gm.sendPackets(new S_SystemMessage("'" + name
					+ "' is not an existing character."));
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private L1PcInstance getPcInstance(String name) {
		L1PcInstance pc = L1World.getInstance().getPlayer(name);
		if (pc == null) {
			for (L1PcInstance player : L1World.getInstance().getAllPlayers()) {
				if (player.getName().toLowerCase().equals(name.toLowerCase())) {
					pc = player;
					break;
				}
			}
		}
		return pc;
	}

}
