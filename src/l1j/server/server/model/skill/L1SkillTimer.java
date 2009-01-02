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

import java.util.Timer;
import java.util.TimerTask;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.serverpackets.S_CurseBlind;
import l1j.server.server.serverpackets.S_Dexup;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_Light;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_Paralysis;
import l1j.server.server.serverpackets.S_Poison;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillBrave;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillIconAura;
import l1j.server.server.serverpackets.S_SkillIconBlessOfEva;
import l1j.server.server.serverpackets.S_SkillIconShield;
import l1j.server.server.serverpackets.S_SkillIconWindShackle;
import l1j.server.server.serverpackets.S_SkillIconWisdomPotion;
import l1j.server.server.serverpackets.S_Strup;
import l1j.server.server.templates.L1Skills;
import static l1j.server.server.model.skill.L1SkillId.*;

public interface L1SkillTimer {
	public int getRemainingTime();

	public void begin();

	public void end();

	public void kill();
}

/*
 * XXX 2008/02/13 vala
 */
class L1SkillStop {
	public static void stopSkill(L1Character cha, int skillId) {
		if (skillId == LIGHT) {
			if (cha instanceof L1PcInstance) {
				if (!cha.isInvisble()) {
					L1PcInstance pc = (L1PcInstance) cha;
					pc.turnOnOffLight();
				}
			}
		} else if (skillId == GLOWING_AURA) {
			cha.addHitup(-5);
			cha.addBowHitup(-5);
			cha.addMr(-20);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SPMR(pc));
				pc.sendPackets(new S_SkillIconAura(113, 0));
			}
		} else if (skillId == SHINING_AURA) {
			cha.addAc(8);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconAura(114, 0));
			}
		} else if (skillId == BRAVE_AURA) {
			cha.addDmgup(-5);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconAura(116, 0));
			}
		} else if (skillId == SHIELD) {
			cha.addAc(2);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconShield(5, 0));
			}
		} else if (skillId == BLIND_HIDING) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.delBlindHiding();
			}
		} else if (skillId == SHADOW_ARMOR) {
			cha.addAc(3);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconShield(3, 0));
			}
		} else if (skillId == DRESS_DEXTERITY) {
			cha.addDex((byte) -2);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Dexup(pc, 2, 0));
			}
		} else if (skillId == DRESS_MIGHTY) {
			cha.addStr((byte) -2);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Strup(pc, 2, 0));
			}
		} else if (skillId == SHADOW_FANG) {
			cha.addDmgup(-5);
		} else if (skillId == ENCHANT_WEAPON) {
			cha.addDmgup(-2);
		} else if (skillId == BLESSED_ARMOR) {
			cha.addAc(3);
		} else if (skillId == EARTH_BLESS) {
			cha.addAc(7);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconShield(7, 0));
			}
		} else if (skillId == RESIST_MAGIC) {
			cha.addMr(-10);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SPMR(pc));
			}
		} else if (skillId == CLEAR_MIND) {
			cha.addWis((byte) -3);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.resetBaseMr();
			}
		} else if (skillId == RESIST_ELEMENTAL) {
			cha.addWind(-10);
			cha.addWater(-10);
			cha.addFire(-10);
			cha.addEarth(-10);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_OwnCharAttrDef(pc));
			}
		} else if (skillId == ELEMENTAL_PROTECTION) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				int attr = pc.getElfAttr();
				if (attr == 1) {
					cha.addEarth(-50);
				} else if (attr == 2) {
					cha.addFire(-50);
				} else if (attr == 4) {
					cha.addWater(-50);
				} else if (attr == 8) {
					cha.addWind(-50);
				}
				pc.sendPackets(new S_OwnCharAttrDef(pc));
			}
		} else if (skillId == ELEMENTAL_FALL_DOWN) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				int attr = pc.getAddAttrKind();
				int i = 50;
				switch (attr) {
				case 1:
					pc.addEarth(i);
					break;
				case 2:
					pc.addFire(i);
					break;
				case 4:
					pc.addWater(i);
					break;
				case 8:
					pc.addWind(i);
					break;
				default:
					break;
				}
				pc.setAddAttrKind(0);
				pc.sendPackets(new S_OwnCharAttrDef(pc));
			} else if (cha instanceof L1NpcInstance) {
				L1NpcInstance npc = (L1NpcInstance) cha;
				int attr = npc.getAddAttrKind();
				int i = 50;
				switch (attr) {
				case 1:
					npc.addEarth(i);
					break;
				case 2:
					npc.addFire(i);
					break;
				case 4:
					npc.addWater(i);
					break;
				case 8:
					npc.addWind(i);
					break;
				default:
					break;
				}
				npc.setAddAttrKind(0);
			}
		} else if (skillId == IRON_SKIN) { //
			cha.addAc(10);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconShield(10, 0));
			}
		} else if (skillId == EARTH_SKIN) {
			cha.addAc(6);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconShield(6, 0));
			}
		} else if (skillId == PHYSICAL_ENCHANT_STR) {
			cha.addStr((byte) -5);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Strup(pc, 5, 0));
			}
		} else if (skillId == PHYSICAL_ENCHANT_DEX) {
			cha.addDex((byte) -5);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Dexup(pc, 5, 0));
			}
		} else if (skillId == FIRE_WEAPON) {
			cha.addDmgup(-4);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconAura(147, 0));
			}
		} else if (skillId == FIRE_BLESS) {
			cha.addDmgup(-4);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconAura(154, 0));
			}
		} else if (skillId == BURNING_WEAPON) {
			cha.addDmgup(-6);
			cha.addHitup(-3);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconAura(162, 0));
			}
		} else if (skillId == BLESS_WEAPON) {
			cha.addDmgup(-2);
			cha.addHitup(-2);
			cha.addBowHitup(-2);
		} else if (skillId == WIND_SHOT) { 
			cha.addBowHitup(-6);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconAura(148, 0));
			}
		} else if (skillId == STORM_EYE) {
			cha.addBowHitup(-2);
			cha.addBowDmgup(-3);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconAura(155, 0));
			}
		} else if (skillId == STORM_SHOT) { 
			cha.addBowDmgup(-5);
			cha.addBowHitup(3);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconAura(165, 0));
			}
		} else if (skillId == BERSERKERS) {
			cha.addAc(-10);
			cha.addDmgup(-5);
			cha.addHitup(-2);
		} else if (skillId == SHAPE_CHANGE) { 
			L1PolyMorph.undoPoly(cha);
		} else if (skillId == ADVANCE_SPIRIT) { 
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.addMaxHp(-pc.getAdvenHp());
				pc.addMaxMp(-pc.getAdvenMp());
				pc.setAdvenHp(0);
				pc.setAdvenMp(0);
				pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc
						.getMaxHp()));
				if (pc.isInParty()) { // During Party
					pc.getParty().updateMiniHP(pc);
				}
				pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc
						.getMaxMp()));
			}
		} else if (skillId == HASTE || skillId == GREATER_HASTE) {
			cha.setMoveSpeed(0);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
				pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0, 0));
			}
		} else if (skillId == HOLY_WALK || skillId == MOVING_ACCELERATION
				|| skillId == WIND_WALK) {
			cha.setBraveSpeed(0);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
			}
		}
		// ****** If changes in state-melted
		else if (skillId == CURSE_BLIND || skillId == DARKNESS) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_CurseBlind(0));
			}
		} else if (skillId == CURSE_PARALYZE) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Poison(pc.getId(), 0));
				pc.broadcastPacket(new S_Poison(pc.getId(), 0));
				pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_PARALYSIS,
						false));
			}
		} else if (skillId == WEAKNESS) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.addDmgup(5);
				pc.addHitup(1);
			}
		} else if (skillId == DISEASE) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.addDmgup(6);
				pc.addAc(-12);
			}
		} else if (skillId == ICE_LANCE || skillId == FREEZING_BLIZZARD) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Poison(pc.getId(), 0));
				pc.broadcastPacket(new S_Poison(pc.getId(), 0));
				pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_FREEZE, false));
			} else if (cha instanceof L1MonsterInstance
					|| cha instanceof L1SummonInstance
					|| cha instanceof L1PetInstance) {
				L1NpcInstance npc = (L1NpcInstance) cha;
				npc.broadcastPacket(new S_Poison(npc.getId(), 0));
				npc.setParalyzed(false);
			}
		} else if (skillId == EARTH_BIND) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Poison(pc.getId(), 0));
				pc.broadcastPacket(new S_Poison(pc.getId(), 0));
				pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_FREEZE, false));
			} else if (cha instanceof L1MonsterInstance
					|| cha instanceof L1SummonInstance
					|| cha instanceof L1PetInstance) {
				L1NpcInstance npc = (L1NpcInstance) cha;
				npc.broadcastPacket(new S_Poison(npc.getId(), 0));
				npc.setParalyzed(false);
			}
		} else if (skillId == SHOCK_STUN) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_STUN, false));
			} else if (cha instanceof L1MonsterInstance
					|| cha instanceof L1SummonInstance
					|| cha instanceof L1PetInstance) {
				L1NpcInstance npc = (L1NpcInstance) cha;
				npc.setParalyzed(false);
			}
		} else if (skillId == FOG_OF_SLEEPING) {
			cha.setSleeped(false);
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_SLEEP, false));
				pc.sendPackets(new S_OwnCharStatus(pc));
			}
		} else if (skillId == ABSOLUTE_BARRIER) { 
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.startHpRegeneration();
				pc.startMpRegeneration();
				pc.startMpRegenerationByDoll();
			}
		} else if (skillId == WIND_SHACKLE) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconWindShackle(pc.getId(), 0));
			}
		} else if (skillId == SLOW || skillId == ENTANGLE
				|| skillId == MASS_SLOW) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
				pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0, 0));
			}
			cha.setMoveSpeed(0);
		} else if (skillId == STATUS_FREEZE) { // Freeze
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_BIND, false));
			} else if (cha instanceof L1MonsterInstance
					|| cha instanceof L1SummonInstance
					|| cha instanceof L1PetInstance) {
				L1NpcInstance npc = (L1NpcInstance) cha;
				npc.setParalyzed(false);
 			}
		}

		// ****** Status IDs
		else if (skillId == STATUS_BRAVE) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
			}
			cha.setBraveSpeed(0);
		} else if (skillId == STATUS_HASTE) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
			}
			cha.setMoveSpeed(0);
		} else if (skillId == STATUS_BLUE_POTION) {
		} else if (skillId == STATUS_UNDERWATER_BREATH) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_SkillIconBlessOfEva(pc.getId(), 0));
			}
		} else if (skillId == STATUS_WISDOM_POTION) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				cha.addSp(-2);
				pc.sendPackets(new S_SkillIconWisdomPotion(0));
			}
		} else if (skillId == STATUS_CHAT_PROHIBITED) { 
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_ServerMessage(288)); 
			}
		}

		// ****** ÅÖW
		else if (skillId == STATUS_POISON) { //
			cha.curePoison();
		}

		else if (skillId == COOKING_1_0_N || skillId == COOKING_1_0_S) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.addWind(-10);
				pc.addWater(-10);
				pc.addFire(-10);
				pc.addEarth(-10);
				pc.sendPackets(new S_OwnCharAttrDef(pc));
				pc.sendPackets(new S_PacketBox(53, 0, 0));
				pc.setCookingId(0);
			}
		} else if (skillId == COOKING_1_1_N || skillId == COOKING_1_1_S) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.addMaxHp(-30);
				pc.sendPackets(new S_HPUpdate(pc.getCurrentHp(), pc
						.getMaxHp()));
				if (pc.isInParty()) { 
					pc.getParty().updateMiniHP(pc);
				}
				pc.sendPackets(new S_PacketBox(53, 1, 0));
				pc.setCookingId(0);
			}
		} else if (skillId == COOKING_1_2_N || skillId == COOKING_1_2_S) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_PacketBox(53, 2, 0));
				pc.setCookingId(0);
			}
		} else if (skillId == COOKING_1_3_N || skillId == COOKING_1_3_S) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.addAc(1);
				pc.sendPackets(new S_PacketBox(53, 3, 0));
				pc.setCookingId(0);
			}
		} else if (skillId == COOKING_1_4_N || skillId == COOKING_1_4_S) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.addMaxMp(-20);
				pc.sendPackets(new S_MPUpdate(pc.getCurrentMp(), pc
						.getMaxMp()));
				pc.sendPackets(new S_PacketBox(53, 4, 0));
				pc.setCookingId(0);
			}
		} else if (skillId == COOKING_1_5_N || skillId == COOKING_1_5_S) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_PacketBox(53, 5, 0));
				pc.setCookingId(0);
			}
		} else if (skillId == COOKING_1_6_N || skillId == COOKING_1_6_S) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.addMr(-5);
				pc.sendPackets(new S_SPMR(pc));
				pc.sendPackets(new S_PacketBox(53, 6, 0));
				pc.setCookingId(0);
			}
		} else if (skillId == COOKING_1_7_N || skillId == COOKING_1_7_S) {
			if (cha instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) cha;
				pc.sendPackets(new S_PacketBox(53, 7, 0));
				pc.setDessertId(0);
			}
		}

		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			sendStopMessage(pc, skillId);
			pc.sendPackets(new S_OwnCharStatus(pc));
		}
	}

	// Message (when finished)
	private static void sendStopMessage(L1PcInstance charaPc, int skillid) {
		L1Skills l1skills = SkillsTable.getInstance().getTemplate(skillid);
		if (l1skills == null || charaPc == null) {
			return;
		}

		int msgID = l1skills.getSysmsgIdStop();
		if (msgID > 0) {
			charaPc.sendPackets(new S_ServerMessage(msgID));
		}
	}
}

class L1SkillTimerThreadImpl extends Thread implements L1SkillTimer {
	public L1SkillTimerThreadImpl(L1Character cha, int skillId, int timeMillis) {
		_cha = cha;
		_skillId = skillId;
		_timeMillis = timeMillis;
	}

	@Override
	public void run() {
		for (int timeCount = _timeMillis / 1000; timeCount > 0; timeCount--) {
			try {
				Thread.sleep(1000);
				_remainingTime = timeCount;
			} catch (InterruptedException e) {
				return;
			}
		}
		_cha.removeSkillEffect(_skillId);
	}

	public int getRemainingTime() {
		return _remainingTime;
	}

	public void begin() {
		GeneralThreadPool.getInstance().execute(this);
	}

	public void end() {
		super.interrupt();
		L1SkillStop.stopSkill(_cha, _skillId);
	}

	public void kill() {
		if (Thread.currentThread().getId() == super.getId()) {
			return; // If the caller not stop their conversations
		}
		super.stop();
	}

	private final L1Character _cha;
	private final int _timeMillis;
	private final int _skillId;
	private int _remainingTime;
}

class L1SkillTimerTimerImpl extends TimerTask implements L1SkillTimer {
	private static final Timer _timer = new Timer();

	public L1SkillTimerTimerImpl(L1Character cha, int skillId, int timeMillis) {
		_cha = cha;
		_skillId = skillId;
		_timeMillis = timeMillis;

		_remainingTime = _timeMillis / 1000;
	}

	@Override
	public void run() {
		_remainingTime--;
		if (_remainingTime <= 0) {
			_cha.removeSkillEffect(_skillId);
		}
	}

	@Override
	public void begin() {
		_timer.scheduleAtFixedRate(this, 1000, 1000);
	}

	@Override
	public void end() {
		this.cancel();
		L1SkillStop.stopSkill(_cha, _skillId);
	}

	@Override
	public void kill() {
		this.cancel();
	}

	@Override
	public int getRemainingTime() {
		return _remainingTime;
	}

	private final L1Character _cha;
	private final int _timeMillis;
	private final int _skillId;
	private int _remainingTime;
}
