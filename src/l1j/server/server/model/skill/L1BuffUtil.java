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
package l1j.server.server.model.skill;

import java.util.logging.Logger;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SkillBrave;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_HPUpdate; 
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_SkillIconAura;
import l1j.server.server.serverpackets.S_SkillIconBloodstain;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1BuffUtil {
	private static Logger _log = Logger.getLogger(L1BuffUtil.class.getName());

	public static void haste(L1PcInstance pc, int timeMillis) {
		pc.setSkillEffect(STATUS_HASTE, timeMillis);

		int objId = pc.getId();
		pc.sendPackets(new S_SkillHaste(objId, 1, timeMillis / 1000));
		pc.broadcastPacket(new S_SkillHaste(objId, 1, 0));
		pc.sendPackets(new S_SkillSound(objId, 191));
		pc.broadcastPacket(new S_SkillSound(objId, 191));
		pc.setMoveSpeed(1);
	}

	public static void brave(L1PcInstance pc, int timeMillis) {
		if (pc.hasSkillEffect(STATUS_ELFBRAVE)) { 
			pc.killSkillEffectTimer(STATUS_ELFBRAVE);
			pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 0, 0));
			pc.setBraveSpeed(0);
		}
		if (pc.hasSkillEffect(HOLY_WALK)) { 
			pc.killSkillEffectTimer(HOLY_WALK);
			pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 0, 0));
			pc.setBraveSpeed(0);
		}
		if (pc.hasSkillEffect(MOVING_ACCELERATION)) { 
			pc.killSkillEffectTimer(MOVING_ACCELERATION);
			pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 0, 0));
			pc.setBraveSpeed(0);
		}
		if (pc.hasSkillEffect(WIND_WALK)) { 
			pc.killSkillEffectTimer(WIND_WALK);
			pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 0, 0));
			pc.setBraveSpeed(0);
		}
		if (pc.hasSkillEffect(STATUS_RIBRAVE)) { 
			pc.killSkillEffectTimer(STATUS_RIBRAVE);

			pc.setBraveSpeed(0);
		}
		if (pc.hasSkillEffect(BLOODLUST)) { 
			pc.killSkillEffectTimer(BLOODLUST);
			pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 0, 0));
			pc.setBraveSpeed(0);
		}

		pc.setSkillEffect(STATUS_BRAVE, timeMillis);

		int objId = pc.getId();
		pc.sendPackets(new S_SkillBrave(objId, 1, timeMillis / 1000));
		pc.broadcastPacket(new S_SkillBrave(objId, 1, 0));
		pc.sendPackets(new S_SkillSound(objId, 751));
		pc.broadcastPacket(new S_SkillSound(objId, 751));
		pc.setBraveSpeed(1);
	}

	public static void bloodstain(L1PcInstance pc, byte type, int time, boolean showGfx) {
		if (showGfx) {
			pc.sendPackets(new S_SkillSound(pc.getId(), 7783));
			pc.broadcastPacket(new S_SkillSound(pc.getId(), 7783));
}

		int skillId = EFFECT_BLOODSTAIN_OF_ANTHARAS;
		int iconType = 0;
		if (type == 0) {
			if (!pc.hasSkillEffect(skillId)) {
				pc.addAc(-2);
				pc.addWater(50);
			}
			iconType = 82;
		}
		pc.sendPackets(new S_OwnCharAttrDef(pc));
		pc.sendPackets(new S_SkillIconBloodstain(iconType, time));
		pc.setSkillEffect(skillId, (time * 60 * 1000));
	}

	public static void effectBlessOfDragonSlayer(L1PcInstance pc, int skillId, int time, int showGfx) {
		if (showGfx != 0) {
			pc.sendPackets(new S_SkillSound(pc.getId(), showGfx));
			pc.broadcastPacket(new S_SkillSound(pc.getId(), showGfx));
		}

		if (!pc.hasSkillEffect(skillId)) {
			switch (skillId) {
				case EFFECT_BLESS_OF_CRAY:
					if (pc.hasSkillEffect(EFFECT_BLESS_OF_SAELL)) {
						pc.removeSkillEffect(EFFECT_BLESS_OF_SAELL);
					}
					pc.addMaxHp(100);
					pc.addMaxMp(50);
					pc.addHpr(3);
					pc.addMpr(3);
					pc.addEarth(30);
					pc.addDmgup(1);
					pc.addHitup(5);
					pc.addWeightReduction(40);
					break;
				case EFFECT_BLESS_OF_SAELL:
					if (pc.hasSkillEffect(EFFECT_BLESS_OF_CRAY)) {
						pc.removeSkillEffect(EFFECT_BLESS_OF_CRAY);
					}
					pc.addMaxHp(80);
					pc.addMaxMp(10);
					pc.addWater(30);
					pc.addAc(-8);
					break;
			}
			pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc.getMaxHp()));
			if (pc.isInParty()) {
				pc.getParty().updateMiniHP(pc);
			}
			pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc.getMaxMp()));
			pc.sendPackets(new S_OwnCharStatus(pc));
			pc.sendPackets(new S_OwnCharAttrDef(pc));
		}
		pc.setSkillEffect(skillId, (time * 1000));
	}
}