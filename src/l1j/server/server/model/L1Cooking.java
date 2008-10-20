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

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SPMR;

// Referenced classes of package l1j.server.server.model:
// L1Cooking

public class L1Cooking {
	
	private L1Cooking() {
	}

	public static void useCookingItem(L1PcInstance pc, L1ItemInstance item) {
		int itemId = item.getItem().getItemId();
		if (itemId == 41284 || itemId == 41292) {
			if (pc.get_food() != 29) {
				pc.sendPackets(new S_ServerMessage(74, item
						.getNumberedName(1)));
				return;
			}
		}

		if (itemId >= 41277 && itemId <= 41283 
				|| itemId >= 41285 && itemId <= 41291) { 
			int cookingId = pc.getCookingId();
			if (cookingId != 0) {
				pc.removeSkillEffect(cookingId);
			}
		}

		if (itemId == 41284 || itemId == 41292) { 
			int dessertId = pc.getDessertId();
			if (dessertId != 0) {
				pc.removeSkillEffect(dessertId);
			}
		}

		int cookingId;
		int time = 900;
		if (itemId == 41277 || itemId == 41285) { 
			if (itemId == 41277) {
				cookingId = L1SkillId.COOKING_1_0_N;
			} else {
				cookingId = L1SkillId.COOKING_1_0_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41278 || itemId == 41286) { 
			if (itemId == 41278) {
				cookingId = L1SkillId.COOKING_1_1_N;
			} else {
				cookingId = L1SkillId.COOKING_1_1_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41279 || itemId == 41287) { 
			if (itemId == 41279) {
				cookingId = L1SkillId.COOKING_1_2_N;
			} else {
				cookingId = L1SkillId.COOKING_1_2_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41280 || itemId == 41288) { 
			if (itemId == 41280) {
				cookingId = L1SkillId.COOKING_1_3_N;
			} else {
				cookingId = L1SkillId.COOKING_1_3_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41281 || itemId == 41289) { 
			if (itemId == 41281) {
				cookingId = L1SkillId.COOKING_1_4_N;
			} else {
				cookingId = L1SkillId.COOKING_1_4_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41282 || itemId == 41290) { 
			if (itemId == 41282) {
				cookingId = L1SkillId.COOKING_1_5_N;
			} else {
				cookingId = L1SkillId.COOKING_1_5_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41283 || itemId == 41291) { 
			if (itemId == 41283) {
				cookingId = L1SkillId.COOKING_1_6_N;
			} else {
				cookingId = L1SkillId.COOKING_1_6_S;
			}
			eatCooking(pc, cookingId, time);
		} else if (itemId == 41284 || itemId == 41292) { 
			if (itemId == 41284) {
				cookingId = L1SkillId.COOKING_1_7_N;
			} else {
				cookingId = L1SkillId.COOKING_1_7_S;
			}
			eatCooking(pc, cookingId, time);
		}
		pc.sendPackets(new S_ServerMessage(76, item.getNumberedName(1))); 
		pc.getInventory().removeItem(item , 1);
	}

	public static void eatCooking(L1PcInstance pc, int cookingId, int time) {
		int cookingType = 0;
		if (cookingId == L1SkillId.COOKING_1_0_N || cookingId == L1SkillId.COOKING_1_0_S) {
			cookingType = 0;
			pc.addWind(10);
			pc.addWater(10);
			pc.addFire(10);
			pc.addEarth(10);
			pc.sendPackets(new S_OwnCharAttrDef(pc));
		} else if (cookingId == L1SkillId.COOKING_1_1_N || cookingId == L1SkillId.COOKING_1_1_S) {
			cookingType = 1;
			pc.addMaxHp(30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) { 
				pc.getParty().updateMiniHP(pc);
			}
		} else if (cookingId == L1SkillId.COOKING_1_2_N || cookingId == L1SkillId.COOKING_1_2_S) {
			cookingType = 2;
		} else if (cookingId == L1SkillId.COOKING_1_3_N || cookingId == L1SkillId.COOKING_1_3_S) {
			cookingType = 3;
			pc.addAc(-1);
			pc.sendPackets(new S_OwnCharStatus(pc));
		} else if (cookingId == L1SkillId.COOKING_1_4_N || cookingId == L1SkillId.COOKING_1_4_S) {
			cookingType = 4;
			pc.add_maxMp(20);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.get_maxMp()));
		} else if (cookingId == L1SkillId.COOKING_1_5_N || cookingId == L1SkillId.COOKING_1_5_S) {
			cookingType = 5;
		} else if (cookingId == L1SkillId.COOKING_1_6_N || cookingId == L1SkillId.COOKING_1_6_S) {
			cookingType = 6;
			pc.addMr(5);
			pc.sendPackets(new S_SPMR(pc));
		} else if (cookingId == L1SkillId.COOKING_1_7_N || cookingId == L1SkillId.COOKING_1_7_S) {
			cookingType = 7;
		}
		pc.sendPackets(new S_PacketBox(53, cookingType, time));
		pc.setSkillEffect(cookingId, time * 1000);
		 if (cookingId >= L1SkillId.COOKING_1_0_N && cookingId <= L1SkillId.COOKING_1_6_N  || cookingId >= L1SkillId.COOKING_1_0_S  
				 && cookingId <= L1SkillId.COOKING_1_6_S) {  
			 pc.setCookingId(cookingId);   
			 } else if (cookingId == L1SkillId.COOKING_1_7_N || cookingId == L1SkillId.COOKING_1_7_S) {   
				 pc.setDessertId(cookingId);   
				 } 
		pc.sendPackets(new S_OwnCharStatus(pc));
	}

}

