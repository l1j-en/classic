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
package l1j.server.server.model.Instance;

//import java.util.ArrayList;
import java.util.logging.Logger;

import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_RetrieveList;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;

public class L1DwarfInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;

	private static Logger _log = Logger.getLogger(L1DwarfInstance.class.getName());

	int objid;
	String s;

	/**
	 * @param template
	 */
	public L1DwarfInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance player) {
		L1Attack attack = new L1Attack(player, this);
		attack.calcHit();
		attack.action();
		attack.addPcPoisonAttack(player, this);
	}

	@Override
	public void onTalkAction(L1PcInstance player) {
		int objid = getId();

		_log.finest("Dwarf activated: " + objid);

		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(getNpcTemplate().get_npcId());
		if (talking != null) {
			_log.finest("sending talk packet (init) for : " + objid);
			S_NPCTalkReturn talk = null;
			if (player.getLevel() < 5) { 
				talk = new S_NPCTalkReturn(talking, objid, 2); 
			} else { 
				talk = new S_NPCTalkReturn(talking, objid, 1); 
			player.sendPackets(talk);
			} 
		} else {
			_log.finest("No actions for Dwarf id : " + objid);
		}
	}

	public void onFinalAction(L1PcInstance player, String Action) {
		if (Action.equalsIgnoreCase("retrieve")) {
			if (player.getLevel() >= 5) {
				player.sendPackets(new S_RetrieveList(objid, player));
			}
		} else if (Action.equalsIgnoreCase("retrieve-pledge")) {
			if (player.getLevel() >= 5) {
				if (player.getClanid() == 0) {
					player.sendPackets(new S_ServerMessage(208));
					return;
				}
			}
		}
	}
}
