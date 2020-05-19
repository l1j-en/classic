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

import java.util.logging.Logger;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.templates.L1Npc;

public class L1AddWarehouseInstance extends L1NpcInstance {
	/**
	 * 
	 */
	private static Logger _log = Logger.getLogger(L1AddWarehouseInstance.class.getName());

	/**
	 * @param template
	 */
	public L1AddWarehouseInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance pc) {
		onAction(pc, 0);
	}
	
	@Override
	public void onAction(L1PcInstance pc, int skillId) {
		L1Attack attack = new L1Attack(pc, this, skillId);
		attack.calcHit();
		attack.action();
		attack.addChaserAttack();
		attack.addEvilAttack();
		attack.calcDamage();
		attack.calcStaffOfMana();
		attack.addPcPoisonAttack(pc, this);
		attack.commit();
	}

	@Override
	public void onTalkAction(L1PcInstance pc) {
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
				getNpcTemplate().get_npcId());
		int npcId = getNpcTemplate().get_npcId();
		String htmlid = null;
//     TODO: Implement this later.
//		if (talking != null) {
//			
//			if (htmlid != null) {
//				pc.sendPackets(new S_NPCTalkReturn(objid, htmlid));
//			} else {
//				if (pc.getUseAdditionalWarehouse()) {
//					pc.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
//				} else {
//					pc.sendPackets(new S_NPCTalkReturn(talking, objid, 2));
//				}
//			}
//		}
	}

	@Override
	public void onFinalAction(L1PcInstance pc, String Action) {
		if (Action.equalsIgnoreCase("retrieve-char")) {
			_log.finest("Retrive items in " + pc.getName() + "'s storage");
		}
	}
}
