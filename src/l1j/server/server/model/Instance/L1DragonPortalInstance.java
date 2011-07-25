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

import static l1j.server.server.model.skill.L1SkillId.EFFECT_BLOODSTAIN_OF_ANTHARAS;

import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1DragonSlayer;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;

public class L1DragonPortalInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;
	/**
	 * @param template
	 */
	public L1DragonPortalInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onTalkAction(L1PcInstance player) {
		int npcid = getNpcTemplate().get_npcId();
		int portalNumber = getPortalNumber();
		int X = 32599;
		int Y = 32742;
		short mapId = 1005;
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(npcid);
		String htmlid = null;
		String[] htmldata = null;
		if ((npcid >= 81273 && npcid <= 81276)) {
			if (portalNumber == -1) {
				return;
			}
			mapId = (short) (1005 + portalNumber);
			if (L1DragonSlayer.getInstance().getPlayersCount(portalNumber) >= 32) {
				player.sendPackets(new S_ServerMessage(1536));
			} else if (L1DragonSlayer.getInstance().getDragonSlayerStatus()[portalNumber] >= 5) {
				player.sendPackets(new S_ServerMessage(1537));
			} else {
				if (portalNumber >= 0 && portalNumber <= 5) {
					if (player.hasSkillEffect(EFFECT_BLOODSTAIN_OF_ANTHARAS)) {
						player.sendPackets(new S_ServerMessage(1626));
						return;
					}
					X = 32927;
					Y = 32741;
				}
				player.setPortalNumber(portalNumber);
				L1DragonSlayer.getInstance().addPlayerList(player, portalNumber);
				L1Teleport.teleport(player, X, Y, mapId, 2, true);
			}
		}
		else if (npcid == 81301) {
			L1DragonSlayer.getInstance().startDragonSlayer(player.getPortalNumber());
			L1Teleport.teleport(player, 32795, 32665, player.getMapId(), 4, true);
		}
		else if (npcid == 81302) {
			L1Teleport.teleport(player, 32700, 32671, player.getMapId(), 6, true);
		}
		else if (npcid == 81303) {
			L1DragonSlayer.getInstance().startDragonSlayer(player.getPortalNumber());
			L1Teleport.teleport(player, 32988, 32843, player.getMapId(), 6, true);
		}
		else if (npcid == 81304) {
			L1Teleport.teleport(player, 32937, 32672, player.getMapId(), 6, true);
		}
		else if (npcid == 81305) {
		}
		else if (npcid == 81306) {
			L1Teleport.teleport(player, 32677, 32746, player.getMapId(), 6, true);
		}
		else if (npcid == 81277) {
			int playerLv = player.getLevel();
			if (playerLv >= 30 && playerLv <= 51) {
				htmlid = "dsecret1";
			} else if (playerLv >= 52) {
				htmlid = "dsecret2";
			} else {
				htmlid = "dsecret3";
			}
		}
		if (htmlid != null) {
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, htmldata));
		} else {
			player.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
		}
	}
}