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

import java.util.ArrayList;
import java.util.logging.Logger;

import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;

public class L1DwarfInstance extends L1NpcInstance {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger _log = Logger.getLogger(L1DwarfInstance.class
			.getName());

	/**
	 * @param template
	 */
	public L1DwarfInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance pc) {
		L1Attack attack = new L1Attack(pc, this);
	    attack.calcHit();
		attack.addPcPoisonAttack(pc, this);
		attack.action();
	}

	@Override
	public void onTalkAction(L1PcInstance pc) {
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
				getNpcTemplate().get_npcId());
		int npcId = getNpcTemplate().get_npcId();
		String htmlid = null;

		if (talking != null) {
			if (npcId == 60028) { //
				if (!pc.isElf()) {
					htmlid = "elCE1";
				}
			}

			if (htmlid != null) { //
				pc.sendPackets(new S_NPCTalkReturn(objid, htmlid));
			} else {
				if (pc.getLevel() < 5) {
					pc.sendPackets(new S_NPCTalkReturn(talking, objid, 2));
				} else {
					pc.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
				}
			}
		}
	}

	private int getTemplateid() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onFinalAction(L1PcInstance pc, String Action) {
		getTemplateid();
		int price = 30;
		
		for (L1ItemInstance item : pc.getInventory().getItems()) {
		if (Action.equalsIgnoreCase("retrieve")) {
			price += 0 * item.getCount();
			item.getItemId();
			pc.getInventory().consumeItem(L1ItemId.ADENA, price);
			_log.finest("Retrieve items in storage");
		} else if (Action.equalsIgnoreCase("retrieve-pledge")) {
			price += 0 * item.getCount();
			item.getItemId();
			pc.getInventory().consumeItem(L1ItemId.ADENA, price);
			_log.finest("Retrieve items in pledge storage");

			if (pc.getClanname().equalsIgnoreCase(" ")) {
				_log.finest("pc isnt in a pledge");
				S_ServerMessage talk = new S_ServerMessage(
						(S_ServerMessage.NO_PLEDGE), Action);
				pc.sendPackets(talk);
			} else {
				_log.finest("pc is in a pledge");
			}
		}
	}
}}
