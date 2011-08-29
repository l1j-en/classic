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
package l1j.server.server.model;

import java.util.logging.Logger;

import l1j.server.server.datatables.SkillTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.executor.L1BuffSkillExecutor;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.templates.L1Skill;
import static l1j.server.server.model.skill.L1SkillId.*;

// Referenced classes of package l1j.server.server.model:
// L1Cooking

public class L1Cooking {
	private static final Logger _log = Logger.getLogger(L1Cooking.class
			.getName());

	private L1Cooking() {
	}

	public static void useCookingItem(L1PcInstance pc, L1ItemInstance item) {
		int itemId = item.getItem().getItemId();
		if (itemId == 41284 || itemId == 41292
				|| itemId == 49056 || itemId == 49064
				|| itemId == 49251 || itemId == 49259) { 
			if (pc.get_food() != 225) {
				pc.sendPackets(new S_ServerMessage(74, item
						.getNumberedName(1)));
				return;
			}
		}

		if (itemId >= 41277 && itemId <= 41283 
				|| itemId >= 41285 && itemId <= 41291 
				|| itemId >= 49049 && itemId <= 49055 
				|| itemId >= 49057 && itemId <= 49063 
				|| itemId >= 49244 && itemId <= 49250 
				|| itemId >= 49252 && itemId <= 49258) { 
			int cookingId = pc.getCookingId();
			if (cookingId != 0) {
				pc.removeSkillEffect(cookingId);
			}
		}

		if (itemId == 41284 || itemId == 41292
				|| itemId == 49056 || itemId == 49064
				|| itemId == 49251 || itemId == 49259) { 
			int dessertId = pc.getDessertId();
			if (dessertId != 0) {
				pc.removeSkillEffect(dessertId);
			}
		}

		int cookingId;
		int time = 900;
		if (itemId == 41277 || itemId == 41285) { 
			if (itemId == 41277) {
				cookingId = COOKING_1_0_N;
			} else {
				cookingId = COOKING_1_0_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41278 || itemId == 41286) { 
			if (itemId == 41278) {
				cookingId = COOKING_1_1_N;
			} else {
				cookingId = COOKING_1_1_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41279 || itemId == 41287) { 
			if (itemId == 41279) {
				cookingId = COOKING_1_2_N;
			} else {
				cookingId = COOKING_1_2_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41280 || itemId == 41288) { 
			if (itemId == 41280) {
				cookingId = COOKING_1_3_N;
			} else {
				cookingId = COOKING_1_3_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41281 || itemId == 41289) { 
			if (itemId == 41281) {
				cookingId = COOKING_1_4_N;
			} else {
				cookingId = COOKING_1_4_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41282 || itemId == 41290) { 
			if (itemId == 41282) {
				cookingId = COOKING_1_5_N;
			} else {
				cookingId = COOKING_1_5_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41283 || itemId == 41291) { 
			if (itemId == 41283) {
				cookingId = COOKING_1_6_N;
			} else {
				cookingId = COOKING_1_6_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41284 || itemId == 41292) { 
			if (itemId == 41284) {
				cookingId = COOKING_1_7_N;
			} else {
				cookingId = COOKING_1_7_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49049 || itemId == 49057) { 
			if (itemId == 49049) {
				cookingId = COOKING_2_0_N;
			} else {
				cookingId = COOKING_2_0_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49050 || itemId == 49058) { 
			if (itemId == 49050) {
				cookingId = COOKING_2_1_N;
			} else {
				cookingId = COOKING_2_1_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49051 || itemId == 49059) { 
			if (itemId == 49051) {
				cookingId = COOKING_2_2_N;
			} else {
				cookingId = COOKING_2_2_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49052 || itemId == 49060) {
			if (itemId == 49052) {
				cookingId = COOKING_2_3_N;
			} else {
				cookingId = COOKING_2_3_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49053 || itemId == 49061) { 
			if (itemId == 49053) {
				cookingId = COOKING_2_4_N;
			} else {
				cookingId = COOKING_2_4_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49054 || itemId == 49062) { 
			if (itemId == 49054) {
				cookingId = COOKING_2_5_N;
			} else {
				cookingId = COOKING_2_5_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49055 || itemId == 49063) {
			if (itemId == 49055) {
				cookingId = COOKING_2_6_N;
			} else {
				cookingId = COOKING_2_6_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49056 || itemId == 49064) {
			if (itemId == 49056) {
				cookingId = COOKING_2_7_N;
			} else {
				cookingId = COOKING_2_7_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49244 || itemId == 49252) { 
			if (itemId == 49244) {
				cookingId = COOKING_3_0_N;
			} else {
				cookingId = COOKING_3_0_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49245 || itemId == 49253) { 
			if (itemId == 49245) {
				cookingId = COOKING_3_1_N;
			} else {
				cookingId = COOKING_3_1_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49246 || itemId == 49254) { 
			if (itemId == 49246) {
				cookingId = COOKING_3_2_N;
			} else {
				cookingId = COOKING_3_2_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49247 || itemId == 49255) { 
			if (itemId == 49247) {
				cookingId = COOKING_3_3_N;
			} else {
				cookingId = COOKING_3_3_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49248 || itemId == 49256) {
			if (itemId == 49248) {
				cookingId = COOKING_3_4_N;
			} else {
				cookingId = COOKING_3_4_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49249 || itemId == 49257) { 
			if (itemId == 49249) {
				cookingId = COOKING_3_5_N;
			} else {
				cookingId = COOKING_3_5_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49250 || itemId == 49258) { 
			if (itemId == 49250) {
				cookingId = COOKING_3_6_N;
			} else {
				cookingId = COOKING_3_6_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 49251 || itemId == 49259) {
			if (itemId == 49251) {
				cookingId = COOKING_3_7_N;
			} else {
				cookingId = COOKING_3_7_S;
			}
			eatCooking(pc, cookingId, time);
		}
		pc.sendPackets(new S_ServerMessage(76, item.getNumberedName(1))); 
		pc.getInventory().removeItem(item , 1);
	}

	public static void eatCooking(L1PcInstance pc, int cookingId, int time) {
		L1Skill skill = SkillTable.getInstance().findBySkillId(cookingId);
		if (skill == null) {
			return;
		}
		L1BuffSkillExecutor exe = skill.newBuffSkillExecutor();
		if (exe == null) {
			return;
		}

		int durationSeconds = skill.getBuffDuration();
		exe.addEffect(null, pc, durationSeconds);
		pc.setSkillEffect(cookingId, durationSeconds * 1000);
	}

}
