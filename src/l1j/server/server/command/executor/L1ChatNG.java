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

import static l1j.server.server.model.skill.L1SkillId.STATUS_CHAT_PROHIBITED;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1ChatNG implements L1CommandExecutor {

	private L1ChatNG() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1ChatNG();
	}
	
	public String getHelpText() {
		return "";
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			String args[] = arg.split(" ");
			
			String name = args[0];
			int time = Integer.parseInt(args[1]);
			
			if(time > 250)
				time = 250;

			L1PcInstance tg = L1World.getInstance().getPlayer(name);

			if (tg != null) {
				if(time == 0) {
					tg.removeSkillEffect(STATUS_CHAT_PROHIBITED);
					tg.sendPackets(new S_SkillIconGFX(36, 0));
					
					pc.sendPackets(
							new S_SystemMessage(
									String.format("You have given %s back their voice.",
											name)));
				} else {
					tg.setSkillEffect(STATUS_CHAT_PROHIBITED, time * 60 * 1000);
					tg.sendPackets(new S_ServerMessage(286, String.valueOf(time)));
					
					pc.sendPackets(
							new S_SystemMessage(
									String.format("You have prohibited %s from chatting for %d minutes.",
											name, time)));
				}
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <player_name> <minutes> (max value 250)"));
		}
	}
}
