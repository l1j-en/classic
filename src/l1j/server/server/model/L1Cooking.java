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

import static l1j.server.server.model.skill.L1SkillId.COOKING_1_0_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_1_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_2_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_3_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_4_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_5_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_6_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_7_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_1_7_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_0_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_1_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_2_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_3_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_4_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_5_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_6_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_7_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_2_7_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_0_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_0_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_1_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_1_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_2_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_2_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_3_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_3_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_4_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_4_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_5_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_5_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_6_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_6_S;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_7_N;
import static l1j.server.server.model.skill.L1SkillId.COOKING_3_7_S;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.SkillTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.executor.L1BuffSkillExecutor;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Skill;

public class L1Cooking {
	private static final Logger _log = LoggerFactory.getLogger(L1Cooking.class
			.getName());

	private L1Cooking() {
	}

	private static final int FOOD_TIME = 900;

	public static void useCookingItem(L1PcInstance pc, L1ItemInstance item) {
		int itemId = item.getItem().getItemId();
		if (itemId == 41284 || itemId == 41292 || itemId == 49056
				|| itemId == 49064 || itemId == 49251 || itemId == 49259) {
			if (pc.get_food() != 225) {
				pc.sendPackets(new S_ServerMessage(74, item.getNumberedName(1)));
				return;
			}
		}

		if (itemId >= 41277 && itemId <= 41283 || itemId >= 41285
				&& itemId <= 41291 || itemId >= 49049 && itemId <= 49055
				|| itemId >= 49057 && itemId <= 49063 || itemId >= 49244
				&& itemId <= 49250 || itemId >= 49252 && itemId <= 49258) {
			int cookingId = pc.getCookingId();
			if (cookingId != 0) {
				pc.removeSkillEffect(cookingId);
			}
		}

		if (itemId == 41284 || itemId == 41292 || itemId == 49056
				|| itemId == 49064 || itemId == 49251 || itemId == 49259) {
			int dessertId = pc.getDessertId();
			if (dessertId != 0) {
				pc.removeSkillEffect(dessertId);
			}
		}

		int cookingId;

		// TODO: good candidate for int-map.
		switch (itemId) {
		case 41277:
			cookingId = COOKING_1_0_N;
			break;
		case 41285:
			cookingId = COOKING_1_0_S;
			break;
		case 41278:
			cookingId = COOKING_1_1_N;
			break;
		case 41286:
			cookingId = COOKING_1_1_S;
			break;
		case 41279:
			cookingId = COOKING_1_2_N;
			break;
		case 41287:
			cookingId = COOKING_1_2_S;
			break;
		case 41280:
			cookingId = COOKING_1_3_N;
			break;
		case 41288:
			cookingId = COOKING_1_3_S;
			break;
		case 41281:
			cookingId = COOKING_1_4_N;
			break;
		case 41289:
			cookingId = COOKING_1_4_S;
			break;
		case 41282:
			cookingId = COOKING_1_5_N;
			break;
		case 41290:
			cookingId = COOKING_1_5_S;
			break;
		case 41283:
			cookingId = COOKING_1_6_N;
			break;
		case 41291:
			cookingId = COOKING_1_6_S;
			break;
		case 41284:
			cookingId = COOKING_1_7_N;
			break;
		case 41292:
			cookingId = COOKING_1_7_S;
			break;
		case 49049:
			cookingId = COOKING_2_0_N;
			break;
		case 49057:
			cookingId = COOKING_2_0_S;
			break;
		case 49050:
			cookingId = COOKING_2_1_N;
			break;
		case 49058:
			cookingId = COOKING_2_1_S;
			break;
		case 49051:
			cookingId = COOKING_2_2_N;
			break;
		case 49059:
			cookingId = COOKING_2_2_S;
			break;
		case 49052:
			cookingId = COOKING_2_3_N;
			break;
		case 49060:
			cookingId = COOKING_2_3_S;
			break;
		case 49053:
			cookingId = COOKING_2_4_N;
			break;
		case 49061:
			cookingId = COOKING_2_4_S;
			break;
		case 49054:
			cookingId = COOKING_2_5_N;
			break;
		case 49062:
			cookingId = COOKING_2_5_S;
			break;
		case 49055:
			cookingId = COOKING_2_6_N;
			break;
		case 49063:
			cookingId = COOKING_2_6_S;
			break;
		case 49056:
			cookingId = COOKING_2_7_N;
			break;
		case 49064:
			cookingId = COOKING_2_7_S;
			break;
		case 49244:
			cookingId = COOKING_3_0_N;
			break;
		case 49252:
			cookingId = COOKING_3_0_S;
			break;
		case 49245:
			cookingId = COOKING_3_1_N;
			break;
		case 49253:
			cookingId = COOKING_3_1_S;
			break;
		case 49246:
			cookingId = COOKING_3_2_N;
			break;
		case 49254:
			cookingId = COOKING_3_2_S;
			break;
		case 49247:
			cookingId = COOKING_3_3_N;
			break;
		case 49255:
			cookingId = COOKING_3_3_S;
			break;
		case 49248:
			cookingId = COOKING_3_4_N;
			break;
		case 49256:
			cookingId = COOKING_3_4_S;
			break;
		case 49249:
			cookingId = COOKING_3_5_N;
			break;
		case 49257:
			cookingId = COOKING_3_5_S;
			break;
		case 49250:
			cookingId = COOKING_3_6_N;
			break;
		case 49258:
			cookingId = COOKING_3_6_S;
			break;
		case 49251:
			cookingId = COOKING_3_7_N;
			break;
		case 49259:
			cookingId = COOKING_3_7_S;
			break;
		default:
			_log.warn("Attempted to eat non-food item.");
			return;
		}

		eatCooking(pc, cookingId, FOOD_TIME);
		pc.sendPackets(new S_ServerMessage(76, item.getNumberedName(1)));
		pc.getInventory().removeItem(item, 1);
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

		exe.addEffect(null, pc, time);
		pc.setSkillEffect(cookingId, time * 1000);
	}
}
