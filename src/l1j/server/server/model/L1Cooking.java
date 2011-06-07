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

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SPMR;
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
		int cookingType = 0;
		if (cookingId == COOKING_1_0_N || cookingId == COOKING_1_0_S) {
			cookingType = 0;
			pc.addWind(10);
			pc.addWater(10);
			pc.addFire(10);
			pc.addEarth(10);
			pc.sendPackets(new S_OwnCharAttrDef(pc));
		} else if (cookingId == COOKING_1_1_N || cookingId == COOKING_1_1_S) {
			cookingType = 1;
			pc.addMaxHp(30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) { 
				pc.getParty().updateMiniHP(pc);
			}
		} else if (cookingId == COOKING_1_2_N || cookingId == COOKING_1_2_S) {
			cookingType = 2;
		} else if (cookingId == COOKING_1_3_N || cookingId == COOKING_1_3_S) {
			cookingType = 3;
			pc.addAc(-1);
			pc.sendPackets(new S_OwnCharStatus(pc));
		} else if (cookingId == COOKING_1_4_N || cookingId == COOKING_1_4_S) {
			cookingType = 4;
			pc.addMaxMp(20);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
		} else if (cookingId == COOKING_1_5_N || cookingId == COOKING_1_5_S) {
			cookingType = 5;
		} else if (cookingId == COOKING_1_6_N || cookingId == COOKING_1_6_S) {
			cookingType = 6;
			pc.addMr(5);
			pc.sendPackets(new S_SPMR(pc));
		} else if (cookingId == COOKING_1_7_N || cookingId == COOKING_1_7_S) {
			cookingType = 7;
		} else if (cookingId == COOKING_2_0_N || cookingId == COOKING_2_0_S) { // LrAJiby
			cookingType = 8;
		} else if (cookingId == COOKING_2_1_N || cookingId == COOKING_2_1_S) { // AQ[^[Xe[L
			cookingType = 9;
			pc.addMaxHp(30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) { // p[eB[
				pc.getParty().updateMiniHP(pc);
			}
			pc.addMaxMp(30);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
		} else if (cookingId == COOKING_2_2_N || cookingId == COOKING_2_2_S) { // ^[ghSÌÙq
			cookingType = 10;
			pc.addAc(-2);
			pc.sendPackets(new S_OwnCharStatus(pc));
		} else if (cookingId == COOKING_2_3_N || cookingId == COOKING_2_3_S) { // LEBpbgÄ«
			cookingType = 11;
		} else if (cookingId == COOKING_2_4_N || cookingId == COOKING_2_4_S) { // XR[sIÄ«
			cookingType = 12;
		} else if (cookingId == COOKING_2_5_N || cookingId == COOKING_2_5_S) { // CbJhV`[
			cookingType = 13;
			pc.addMr(10);
			pc.sendPackets(new S_SPMR(pc));
		} else if (cookingId == COOKING_2_6_N || cookingId == COOKING_2_6_S) { // NrÌøÄ«
			cookingType = 14;
			pc.addSp(1);
			pc.sendPackets(new S_SPMR(pc));
		} else if (cookingId == COOKING_2_7_N || cookingId == COOKING_2_7_S) { // NuX[v
			cookingType = 15;
		} else if (cookingId == COOKING_3_0_N || cookingId == COOKING_3_0_S) { // NX^VAÌnT~Ä«
			cookingType = 16;
		} else if (cookingId == COOKING_3_1_N || cookingId == COOKING_3_1_S) { // OtHÄ«
			cookingType = 17;
			pc.addMaxHp(50);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) { // p[eB[
				pc.getParty().updateMiniHP(pc);
			}
			pc.addMaxMp(50);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
		} else if (cookingId == COOKING_3_2_N || cookingId == COOKING_3_2_S) { // RJgXXe[L
			cookingType = 18;
		} else if (cookingId == COOKING_3_3_N || cookingId == COOKING_3_3_S) { // ^[ghSÄ«
			cookingType = 19;
			pc.addAc(-3);
			pc.sendPackets(new S_OwnCharStatus(pc));
		} else if (cookingId == COOKING_3_4_N || cookingId == COOKING_3_4_S) { // bT[hSÌèHæ
			cookingType = 20;
			pc.addMr(15);
			pc.sendPackets(new S_SPMR(pc));
			pc.addWind(10);
			pc.addWater(10);
			pc.addFire(10);
			pc.addEarth(10);
			pc.sendPackets(new S_OwnCharAttrDef(pc));
		} else if (cookingId == COOKING_3_5_N || cookingId == COOKING_3_5_S) { // hCNÄ«
			cookingType = 21;
			pc.addSp(2);
			pc.sendPackets(new S_SPMR(pc));
		} else if (cookingId == COOKING_3_6_N || cookingId == COOKING_3_6_S) { // [CÌV`[
			cookingType = 22;
			pc.addMaxHp(30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) { // p[eB[
				pc.getParty().updateMiniHP(pc);
			}
		} else if (cookingId == COOKING_3_7_N || cookingId == COOKING_3_7_S) { // oVXNÌX[v
			cookingType = 23;
		}
		pc.sendPackets(new S_PacketBox(53, cookingType, time));
		pc.setSkillEffect(cookingId, time * 1000);
		if (cookingId >= COOKING_1_0_N && cookingId <= COOKING_1_6_N
				|| cookingId >= COOKING_1_0_S && cookingId <= COOKING_1_6_S
				|| cookingId >= COOKING_2_0_N && cookingId <= COOKING_2_6_N
				|| cookingId >= COOKING_2_0_S && cookingId <= COOKING_2_6_S
				|| cookingId >= COOKING_3_0_N && cookingId <= COOKING_3_6_N
				|| cookingId >= COOKING_3_0_S && cookingId <= COOKING_3_6_S) {
			pc.setCookingId(cookingId);
		} else if (cookingId == COOKING_1_7_N || cookingId == COOKING_1_7_S
				|| cookingId == COOKING_2_7_N || cookingId == COOKING_2_7_S
				|| cookingId == COOKING_3_7_N || cookingId == COOKING_3_7_S) {
			pc.setDessertId(cookingId);
		}
		pc.sendPackets(new S_OwnCharStatus(pc));
	}

}
