/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package l1j.server.server.model.Instance;

import l1j.server.server.datatables.NPCTalkDataTable;
//import l1j.server.server.model.L1DragonSlayer;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1Teleport;
import static l1j.server.server.model.skill.L1SkillId.*;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;

public class L1DragonPortalInstance extends L1NpcInstance {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param template
	 */
	public L1DragonPortalInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onTalkAction(L1PcInstance pc) {
		int npcid = getNpcTemplate().get_npcId();
// TODO: Implement
//		int portalNumber = getPortalNumber();
//		int X = 0;
//		int Y = 0;
//		short mapid = (short) (1005 + portalNumber);
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(npcid);
		String htmlid = null;
		String[] htmldata = null;
		if ((npcid >= 91051 && npcid <= 91054)) {
//			if (portalNumber == -1) {
//				return;
//			}
//			if (L1DragonSlayer.getInstance().getPlayersCount(portalNumber) >= 32) {
//				pc.sendPackets(new S_ServerMessage(1536)); // å®šå“¡ã�«é�”ã�—ã�Ÿã�Ÿã‚�ã€�å…¥å ´ã�§ã��ã�¾ã�›ã‚“ã€‚
//			} else if (L1DragonSlayer.getInstance().getDragonSlayerStatus()[portalNumber] >= 5) {
//				pc.sendPackets(new S_ServerMessage(1537)); // ãƒ‰ãƒ©ã‚´ãƒ³ã�Œç›®è¦šã‚�ã�Ÿã�Ÿã‚�ã€�ä»Šã�¯å…¥å ´ã�§ã��ã�¾ã�›ã‚“ã€‚
//			} else {
//				if (portalNumber < 6) { // ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«(åœ°)
//					if (pc.hasSkillEffect(BLOODSTAIN_OF_ANTHARAS)) {
//						pc.sendPackets(new S_ServerMessage(1626));
//						// å…¨èº«ã�‹ã‚‰ãƒ‰ãƒ©ã‚´ãƒ³ã�®è¡€ã�®åŒ‚ã�„ã�Œæ¼‚ã�£ã�¦ã�„ã�¾ã�™ã€‚ã��ã‚Œã�Œæ¶ˆã�ˆã‚‹ã�¾ã�§ã�¯ã€�ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«ã�«å…¥å ´ã�§ã��ã�¾ã�›ã‚“ã€‚
//						return;
//					}
//					X = 32599;
//					Y = 32742;
//				} else if (portalNumber < 12) { // ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«(æ°´)
//					if (pc.hasSkillEffect(BLOODSTAIN_OF_FAFURION)) {
//						pc.sendPackets(new S_ServerMessage(1626));
//						// å…¨èº«ã�‹ã‚‰ãƒ‰ãƒ©ã‚´ãƒ³ã�®è¡€ã�®åŒ‚ã�„ã�Œæ¼‚ã�£ã�¦ã�„ã�¾ã�™ã€‚ã��ã‚Œã�Œæ¶ˆã�ˆã‚‹ã�¾ã�§ã�¯ã€�ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«ã�«å…¥å ´ã�§ã��ã�¾ã�›ã‚“ã€‚
//						return;
//					}
//					X = 32927;
//					Y = 32741;
//				} else if (portalNumber < 18) { // ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«(é¢¨)
//					if (pc.hasSkillEffect(BLOODSTAIN_OF_LINDVIOR)) {
//						pc.sendPackets(new S_ServerMessage(1626));
//						// å…¨èº«ã�‹ã‚‰ãƒ‰ãƒ©ã‚´ãƒ³ã�®è¡€ã�®åŒ‚ã�„ã�Œæ¼‚ã�£ã�¦ã�„ã�¾ã�™ã€‚ã��ã‚Œã�Œæ¶ˆã�ˆã‚‹ã�¾ã�§ã�¯ã€�ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«ã�«å…¥å ´ã�§ã��ã�¾ã�›ã‚“ã€‚
//						return;
//					}
//					X = 32673;
//					Y = 32926;
//				//} else if (portalNumber < 24) { // ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«(ç�«)(æœªå®Ÿè£…)
//				//	if (pc.hasSkillEffect(BLOODSTAIN_OF_VALAKAS)) {
//				//		pc.sendPackets(new S_ServerMessage(1626));
//				//		// å…¨èº«ã�‹ã‚‰ãƒ‰ãƒ©ã‚´ãƒ³ã�®è¡€ã�®åŒ‚ã�„ã�Œæ¼‚ã�£ã�¦ã�„ã�¾ã�™ã€‚ã��ã‚Œã�Œæ¶ˆã�ˆã‚‹ã�¾ã�§ã�¯ã€�ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«ã�«å…¥å ´ã�§ã��ã�¾ã�›ã‚“ã€‚
//				//		return;
//				//	}
//				//	X = ;
//				//	Y = ;
//				}
//				pc.setPortalNumber(portalNumber);
//				L1DragonSlayer.getInstance().addPlayerList(pc, portalNumber);
//				L1Teleport.teleport(pc, X, Y, mapid, 2, true);
//			}
		} else if (npcid == 91066) { // ãƒ‰ãƒ©ã‚´ãƒ³ãƒ�ãƒ¼ã‚¿ãƒ«(éš ã�•ã‚Œã�Ÿç«œã�®åœ°)
			int level = pc.getLevel();
			if (level >= 30 && level <= 51) {
				htmlid = "dsecret1";
			} else if (level >= 52) {
				htmlid = "dsecret2";
			} else {
				htmlid = "dsecret3";
			}
		}

		if (htmlid != null) {
			pc.sendPackets(new S_NPCTalkReturn(objid, htmlid, htmldata));
		} else {
			pc.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
		}
	}
}
