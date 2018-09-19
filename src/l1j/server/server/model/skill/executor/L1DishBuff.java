package l1j.server.server.model.skill.executor;

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

import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_SPMR;

public class L1DishBuff extends L1BuffSkillExecutorImpl {

	@Override
	public void addEffect(L1Character user, L1Character target,
			int durationSeconds) {
		if (!(target instanceof L1PcInstance)) {
			return;
		}
		L1PcInstance pc = (L1PcInstance) target;
		int cookingId = _skill.getSkillId();
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
		} else if (cookingId == COOKING_2_0_N || cookingId == COOKING_2_0_S) {
			cookingType = 8;
		} else if (cookingId == COOKING_2_1_N || cookingId == COOKING_2_1_S) {
			cookingType = 9;
			pc.addMaxHp(30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) {
				pc.getParty().updateMiniHP(pc);
			}
			pc.addMaxMp(30);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
		} else if (cookingId == COOKING_2_2_N || cookingId == COOKING_2_2_S) {
			cookingType = 10;
			pc.addAc(-2);
			pc.sendPackets(new S_OwnCharStatus(pc));
		} else if (cookingId == COOKING_2_3_N || cookingId == COOKING_2_3_S) {
			cookingType = 11;
		} else if (cookingId == COOKING_2_4_N || cookingId == COOKING_2_4_S) {
			cookingType = 12;
		} else if (cookingId == COOKING_2_5_N || cookingId == COOKING_2_5_S) {
			cookingType = 13;
			pc.addMr(10);
			pc.sendPackets(new S_SPMR(pc));
		} else if (cookingId == COOKING_2_6_N || cookingId == COOKING_2_6_S) {
			cookingType = 14;
			pc.addSp(1);
			pc.sendPackets(new S_SPMR(pc));
		} else if (cookingId == COOKING_2_7_N || cookingId == COOKING_2_7_S) {
			cookingType = 15;
		} else if (cookingId == COOKING_3_0_N || cookingId == COOKING_3_0_S) {
			cookingType = 16;
		} else if (cookingId == COOKING_3_1_N || cookingId == COOKING_3_1_S) {
			cookingType = 17;
			pc.addMaxHp(50);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) {
				pc.getParty().updateMiniHP(pc);
			}
			pc.addMaxMp(50);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
		} else if (cookingId == COOKING_3_2_N || cookingId == COOKING_3_2_S) {
			cookingType = 18;
		} else if (cookingId == COOKING_3_3_N || cookingId == COOKING_3_3_S) {
			cookingType = 19;
			pc.addAc(-3);
			pc.sendPackets(new S_OwnCharStatus(pc));
		} else if (cookingId == COOKING_3_4_N || cookingId == COOKING_3_4_S) {
			cookingType = 20;
			pc.addMr(15);
			pc.sendPackets(new S_SPMR(pc));
			pc.addWind(10);
			pc.addWater(10);
			pc.addFire(10);
			pc.addEarth(10);
			pc.sendPackets(new S_OwnCharAttrDef(pc));
		} else if (cookingId == COOKING_3_5_N || cookingId == COOKING_3_5_S) {
			cookingType = 21;
			pc.addSp(2);
			pc.sendPackets(new S_SPMR(pc));
		} else if (cookingId == COOKING_3_6_N || cookingId == COOKING_3_6_S) {
			cookingType = 22;
			pc.addMaxHp(30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) {
				pc.getParty().updateMiniHP(pc);
			}
		} else if (cookingId == COOKING_3_7_N || cookingId == COOKING_3_7_S) {
			cookingType = 23;
		}
		pc.sendPackets(new S_PacketBox(53, cookingType, durationSeconds));
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

	@Override
	public void removeEffect(L1Character target) {
		if (!(target instanceof L1PcInstance)) {
			return;
		}
		L1PcInstance pc = (L1PcInstance) target;
		int skillId = _skill.getSkillId();
		if (skillId == COOKING_1_0_N || skillId == COOKING_1_0_S) {
			pc.addWind(-10);
			pc.addWater(-10);
			pc.addFire(-10);
			pc.addEarth(-10);
			pc.sendPackets(new S_OwnCharAttrDef(pc));
			pc.sendPackets(new S_PacketBox(53, 0, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_1_1_N || skillId == COOKING_1_1_S) {
			pc.addMaxHp(-30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) {
				pc.getParty().updateMiniHP(pc);
			}
			pc.sendPackets(new S_PacketBox(53, 1, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_1_2_N || skillId == COOKING_1_2_S) {
			pc.sendPackets(new S_PacketBox(53, 2, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_1_3_N || skillId == COOKING_1_3_S) {
			pc.addAc(1);
			pc.sendPackets(new S_PacketBox(53, 3, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_1_4_N || skillId == COOKING_1_4_S) {
			pc.addMaxMp(-20);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
			pc.sendPackets(new S_PacketBox(53, 4, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_1_5_N || skillId == COOKING_1_5_S) {
			pc.sendPackets(new S_PacketBox(53, 5, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_1_6_N || skillId == COOKING_1_6_S) {
			pc.addMr(-5);
			pc.sendPackets(new S_SPMR(pc));
			pc.sendPackets(new S_PacketBox(53, 6, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_1_7_N || skillId == COOKING_1_7_S) {
			pc.sendPackets(new S_PacketBox(53, 7, 0));
			pc.setDessertId(0);
		} else if (skillId == COOKING_2_0_N || skillId == COOKING_2_0_S) {
			pc.sendPackets(new S_PacketBox(53, 8, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_2_1_N || skillId == COOKING_2_1_S) {
			pc.addMaxHp(-30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) {
				pc.getParty().updateMiniHP(pc);
			}
			pc.addMaxMp(-30);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
			pc.sendPackets(new S_PacketBox(53, 9, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_2_2_N || skillId == COOKING_2_2_S) {
			pc.addAc(2);
			pc.sendPackets(new S_PacketBox(53, 10, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_2_3_N || skillId == COOKING_2_3_S) {
			pc.sendPackets(new S_PacketBox(53, 11, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_2_4_N || skillId == COOKING_2_4_S) {
			pc.sendPackets(new S_PacketBox(53, 12, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_2_5_N || skillId == COOKING_2_5_S) {
			pc.addMr(-10);
			pc.sendPackets(new S_SPMR(pc));
			pc.sendPackets(new S_PacketBox(53, 13, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_2_6_N || skillId == COOKING_2_6_S) {
			pc.addSp(-1);
			pc.sendPackets(new S_SPMR(pc));
			pc.sendPackets(new S_PacketBox(53, 14, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_2_7_N || skillId == COOKING_2_7_S) {
			pc.sendPackets(new S_PacketBox(53, 15, 0));
			pc.setDessertId(0);
		} else if (skillId == COOKING_3_0_N || skillId == COOKING_3_0_S) {
			pc.sendPackets(new S_PacketBox(53, 16, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_3_1_N || skillId == COOKING_3_1_S) {
			pc.addMaxHp(-50);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) {
				pc.getParty().updateMiniHP(pc);
			}
			pc.addMaxMp(-50);
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
			pc.sendPackets(new S_PacketBox(53, 17, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_3_2_N || skillId == COOKING_3_2_S) {
			pc.sendPackets(new S_PacketBox(53, 18, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_3_3_N || skillId == COOKING_3_3_S) {
			pc.addAc(3);
			pc.sendPackets(new S_PacketBox(53, 19, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_3_4_N || skillId == COOKING_3_4_S) {
			pc.addMr(-15);
			pc.sendPackets(new S_SPMR(pc));
			pc.addWind(-10);
			pc.addWater(-10);
			pc.addFire(-10);
			pc.addEarth(-10);
			pc.sendPackets(new S_OwnCharAttrDef(pc));
			pc.sendPackets(new S_PacketBox(53, 20, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_3_5_N || skillId == COOKING_3_5_S) {
			pc.addSp(-2);
			pc.sendPackets(new S_SPMR(pc));
			pc.sendPackets(new S_PacketBox(53, 21, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_3_6_N || skillId == COOKING_3_6_S) {
			pc.addMaxHp(-30);
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) {
				pc.getParty().updateMiniHP(pc);
			}
			pc.sendPackets(new S_PacketBox(53, 22, 0));
			pc.setCookingId(0);
		} else if (skillId == COOKING_3_7_N || skillId == COOKING_3_7_S) {
			pc.sendPackets(new S_PacketBox(53, 23, 0));
			pc.setDessertId(0);
		}
	}
}
