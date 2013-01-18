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

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.datatables.WeaponSkillTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_EffectLocation;
import l1j.server.server.serverpackets.S_Paralysis;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_UseAttackSkill;
import l1j.server.server.serverpackets.ServerBasePacket;
import l1j.server.server.templates.L1Skill;
import static l1j.server.server.model.skill.L1SkillId.*;
import static l1j.server.server.model.item.L1ItemId.*;

public class L1WeaponSkill {

	private static Random _random = new Random();
	private int _weaponId;
	private int _probability;
	private int _fixDamage;
	private int _randomDamage;
	private int _area;
	private int _skillId;
	private int _skillTime;
	private int _effectId;
	private int _effectTarget;
	private boolean _isArrowType;
	private int _attr;

	private static final int BaphoStaffChance = 14;
	private static final int DiceDaggerChance = 3;
	private static final int LightningEdgeChance = 4;
	private static final int FrozenSpearChance = 5;
	private static final int WindAxeChance = 4;
	private static final int FettersTime = 8000;
	// Basically arbitrary, but default to casting procs like a level 48 mage.
	private static final int DefaultSpellpower = 13;
	private static final int DefaultIntelligence = 18;

	private static final Map<Integer, L1WeaponSkill> ProcMap =
		new HashMap<Integer, L1WeaponSkill>();
	
	static {
		if (Config.USE_INT_PROCS) {
			ProcMap.put(SwordOfDeathKnight,new L1WeaponSkill(
					SwordOfDeathKnight, 7, 0, 0, 0, 0, 0, 1811, 0, false, 2));
			ProcMap.put(SwordOfKurtz, new L1WeaponSkill(
					SwordOfKurtz, 15, 0, 0, 0, 0, 0, 10, 0, false, 8));
			ProcMap.put(EdoryuOfRonde, new L1WeaponSkill(
					EdoryuOfRonde, 15, 0, 0, 0, 0, 0, 1805, 0, false, 1));
			ProcMap.put(StaffOfIceQueen, new L1WeaponSkill(
					StaffOfIceQueen, 25, 0, 0, 0, 0, 0, 1810, 0, false, 4));
			ProcMap.put(ThorsHammer, new L1WeaponSkill(
					ThorsHammer, 16, 0, 0, 0, 0, 0, 3940, 0, false, 0));
			ProcMap.put(PaagriosHatred, new L1WeaponSkill(
					PaagriosHatred, 12, 0, 0, 0, 0, 0, 245, 0, false, 0));
			ProcMap.put(MaphrsRetribution, new L1WeaponSkill(
					MaphrsRetribution, 10, 0, 0, 0, 0, 0, 1812, 0, false, 0));
			ProcMap.put(OrcishBumeSmache, new L1WeaponSkill(
					OrcishBumeSmache, 15, 0, 0, 0, 0, 0, 762, 0, false, 0));
			ProcMap.put(EvasScorn, new L1WeaponSkill(
					EvasScorn, 16, 0, 0, 0, 0, 0, 1714, 0, false, 0));
			ProcMap.put(SwordOfVarlok, new L1WeaponSkill(
					SwordOfVarlok, 15, 0, 0, 0, 0, 0, 762, 0, false, 2));
			ProcMap.put(SwordOfSilence, new L1WeaponSkill(
					SwordOfSilence, 7, 0, 0, 0, 64, 16, 2177, 0, false, 0));
			ProcMap.put(LongbowOfMoon, new L1WeaponSkill(
					LongbowOfMoon, 10, 0, 0, 0, 0, 0, 6288, 0, true, 0));
		}
	}

	public L1WeaponSkill(int weaponId, int probability, int fixDamage,
			int randomDamage, int area, int skillId, int skillTime,
			int effectId, int effectTarget, boolean isArrowType, int attr) {
		_weaponId = weaponId;
		_probability = probability;
		_fixDamage = fixDamage;
		_randomDamage = randomDamage;
		_area = area;
		_skillId = skillId;
		_skillTime = skillTime;
		_effectId = effectId;
		_effectTarget = effectTarget;
		_isArrowType = isArrowType;
		_attr = attr;
	}

	public int getWeaponId() {
		return _weaponId;
	}

	public int getProbability() {
		return _probability;
	}

	public int getFixDamage() {
		return _fixDamage;
	}

	public int getRandomDamage() {
		return _randomDamage;
	}

	public int getArea() {
		return _area;
	}

	public int getSkillId() {
		return _skillId;
	}

	public int getSkillTime() {
		return _skillTime;
	}

	public int getEffectId() {
		return _effectId;
	}

	public int getEffectTarget() {
		return _effectTarget;
	}

	public boolean isArrowType() {
		return _isArrowType;
	}

	public int getAttr() {
		return _attr;
	}

	public static double getWeaponSkillDamage(final L1PcInstance attacker, 
			final L1Character target, final int weaponId) {
		if (attacker == null || target == null)
			return 0;

		switch (weaponId) {
			case 124:
				return getBaphometStaffDamage(attacker, target);
			case 204: case 100204:
				return giveFettersEffect(attacker, target);
			case 264:
				return getLightningEdgeDamage(attacker, target);
			case 260:
				return getWindAxeDamage(attacker, target);
			case 263:
				return getFrozenSpearDamage(attacker, target);
			case 261:
				return giveArkMageDiseaseEffect(attacker, target);
		}

		L1WeaponSkill weaponSkill = Config.USE_INT_PROCS
			? ProcMap.get(weaponId)
			: WeaponSkillTable.getInstance().getTemplate(weaponId);
		if (weaponSkill == null)
			return 0;

		int chance = _random.nextInt(100) + 1;
		if (weaponSkill.getProbability() < chance) {
			return 0;
		}

		int skillId = weaponSkill.getSkillId();
		if (skillId != 0) {
			L1Skill skill = SkillTable.getInstance().findBySkillId(skillId);
			if (skill != null && skill.getTarget().equals("buff")) {
				if (!isImmune(target)) {
					target.setSkillEffect(skillId, 
							weaponSkill.getSkillTime() * 1000);
				}
			}
		}

		// effectId should always be nonzero - if it's 0 you're just modifying
		// damage and there are better ways to do that.
		int effectId = weaponSkill.getEffectId();
		L1Character hub = 
			weaponSkill.getEffectTarget() == 0 ? target : attacker;
		int hubId = hub.getId();
		ServerBasePacket packet = weaponSkill.isArrowType()
			? new S_UseAttackSkill(attacker, target.getId(), effectId, 
					target.getX(), target.getY(), 
					ActionCodes.ACTION_Attack, false)
			: new S_SkillSound(hubId, effectId);

		double damage = Config.USE_INT_PROCS
			? getWeaponDamage(attacker, 1.3) // TODO: Per-weapon.
			: weaponSkill.getFixDamage() +
				_random.nextInt(weaponSkill.getRandomDamage()) + 1;

		int area = weaponSkill.getArea();
		int element = weaponSkill.getAttr();
		if (area > 0)
			return handleAoeProc(attacker, target, damage, element, packet,
					hub, area);
		return handleProc(attacker, target, damage, element, packet);
	}

	public static double getDiceDaggerDamage(L1PcInstance attacker,
			L1Character target, L1ItemInstance weapon) {
		double damage = 0;
		if (DiceDaggerChance >= _random.nextInt(100) + 1) {
			damage = target.getCurrentHp() * 2 / 3;
			if (target.getCurrentHp() - damage < 0) {
				damage = 0;
			}
			attacker.sendPackets(new S_ServerMessage(158, weapon.getLogName()));
			attacker.getInventory().removeItem(weapon, 1);
		}
		return damage;
	}

	public static double getKiringkuDamage(final L1PcInstance attacker, 
			final L1Character target) {
		L1ItemInstance weapon = attacker.getWeapon();
		int weaponId = weapon.getItem().getItemId();
		int damage = weaponId == 270 ? 16 : 14;
		int dice = 5;
		int diceCount = 2;

		for (int i = 0; i < diceCount; i++) {
			damage += (_random.nextInt(dice) + 1);
		}

		int spByItem = attacker.getSp() - attacker.getTrueSp(); 
		int charaIntelligence = attacker.getInt() + spByItem - 12;
		if (charaIntelligence < 1) {
			charaIntelligence = 1;
		}
		double kiringkuCoefficientA = (1.0 + charaIntelligence * 3.0 / 32.0);

		damage = (int) (damage * kiringkuCoefficientA) +
			weapon.getEnchantLevel() + attacker.getOriginalMagicDamage();

		if (attacker.hasSkillEffect(ILLUSION_AVATAR)) {
			damage += 10;
		}

		S_SkillSound packet = new S_SkillSound(attacker.getId(),
				weaponId == 270 ? 6983 : 7049);
		attacker.sendPackets(packet);
		attacker.broadcastPacket(packet);

		return calcDamageReduction(attacker, target, damage, 0);
	}

	private static double getFrozenSpearDamage(final L1PcInstance attacker,
			final L1Character target) {
		return FrozenSpearChance >= _random.nextInt(100) + 1
			? handleAoeProc(attacker, target, getWeaponDamage(attacker, 1.4),
					Element.Water,
					new S_SkillSound(target.getId(), 1804), target, 3)
			: 0;
	}

	private static double getWindAxeDamage(final L1PcInstance attacker,
			final L1Character target) {
		return WindAxeChance >= _random.nextInt(100) + 1
			? handleAoeProc(attacker, target, getWeaponDamage(attacker, 1.5), 
					Element.Wind, 
					new S_SkillSound(attacker.getId(), 758), attacker, 4)
			: 0;
	}

	private static double handleAoeProc(final L1PcInstance attacker,
			final L1Character target, final double baseDamage,
			final int element, final ServerBasePacket packet,
			final L1Character hub, final int radius) {

		boolean playerTarget = target instanceof L1PcInstance;
		boolean monsterTarget = target instanceof L1MonsterInstance;
		boolean minionTarget = target instanceof L1PetInstance ||
								target instanceof L1SummonInstance;

		for (L1Object object : 
				L1World.getInstance().getVisibleObjects(hub, radius)) {
			
			if (object == null ||
				!(object instanceof L1Character) ||
				object.getId() == attacker.getId() ||
				object.getId() == target.getId())
				continue;

			boolean isMonster = object instanceof L1MonsterInstance;
			boolean isPlayer = object instanceof L1PcInstance;
			boolean isMinion = object instanceof L1PetInstance ||
								object instanceof L1SummonInstance;
			
			if (monsterTarget && !isMonster)
				continue;

			if ((playerTarget || minionTarget) &&
				!(isMonster || isPlayer || isMinion))
				continue;

			double damage = calcDamageReduction(attacker, (L1Character) object,
				baseDamage, element);

			if (damage <= 0)
				continue;

			if (isPlayer) {
				L1PcInstance pc = (L1PcInstance) object;
				ServerBasePacket effect = new S_DoActionGFX(pc.getId(),
						ActionCodes.ACTION_Damage);
				pc.sendPackets(effect);
				pc.broadcastPacket(effect);
				pc.receiveDamage(attacker, (int) damage, false);
			} else if (isMonster || isMinion) {
				L1NpcInstance npc = (L1NpcInstance) object;
				npc.broadcastPacket(new S_DoActionGFX(npc.getId(),
							ActionCodes.ACTION_Damage));
				npc.receiveDamage(attacker, (int) damage);
			}
		}

		return handleProc(attacker, target, baseDamage, element, packet);
	}

	private static double getWeaponDamage(final L1Character attacker, 
			final double multiplier) {
		int spellpower = Math.max(attacker.getSp(), DefaultSpellpower);
		int intel = Math.max(attacker.getInt(), DefaultIntelligence);
		double berserk = attacker.hasSkillEffect(BERSERKERS) ? .2 : 0;	
		return (intel + spellpower) * (multiplier + berserk) +
			_random.nextInt(intel + spellpower) * multiplier;
	}

	private static double handleProc(final L1PcInstance attacker,
			final L1Character target, final double damage,
			final int element, final ServerBasePacket packet) {
		attacker.sendPackets(packet);
		attacker.broadcastPacket(packet);
		return calcDamageReduction(attacker, target, damage, element);
	}

	private static double getBaphometStaffDamage(final L1PcInstance attacker,
			final L1Character target) {
		return BaphoStaffChance >= _random.nextInt(100) + 1
			? handleProc(attacker, target, getWeaponDamage(attacker, 1.8),
					Element.Earth,
					new S_EffectLocation(target.getX(), target.getY(), 129))
			: 0;
	}

	private static double getLightningEdgeDamage(final L1PcInstance attacker,
			final L1Character target) {
		return LightningEdgeChance >= _random.nextInt(100) + 1
			? handleProc(attacker, target, getWeaponDamage(attacker, 2),
					Element.Wind, new S_SkillSound(target.getId(), 10))
			: 0;
	}

	// TODO: see if we can pull up info from live - this will basically never
	// trigger.
	private static double giveArkMageDiseaseEffect(final L1PcInstance attacker,
			final L1Character target) {
		int probability = (5 - ((target.getMr() / 10) * 5)) * 10;
		if (probability == 0) {
			probability = 10;
		}
		if (probability >= _random.nextInt(1000) + 1) {
			L1SkillUse l1skilluse = new L1SkillUse();
			l1skilluse.handleCommands(attacker, 56,
					target.getId(), target.getX(), target.getY(), null, 0,
					L1SkillUse.TYPE_GMBUFF);
	   }
	   return 0;
	}

	private static double giveFettersEffect(L1PcInstance pc, L1Character target) {
		if (isImmune(target)) { 
			return 0;
		}
		if ((_random.nextInt(100) + 1) <= 2) {
			L1EffectSpawn.getInstance().spawnEffect(81182, FettersTime,
					target.getX(), target.getY(), target.getMapId());
			target.setSkillEffect(STATUS_FREEZE, FettersTime);
			target.broadcastPacket(new S_SkillSound(target.getId(), 4184));
			if (target instanceof L1PcInstance) {
				L1PcInstance targetPc = (L1PcInstance) target;
				targetPc.sendPackets(new S_SkillSound(targetPc.getId(), 4184));
				targetPc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_BIND,
						true));
			} else if (target instanceof L1MonsterInstance
					|| target instanceof L1SummonInstance
					|| target instanceof L1PetInstance) {
				L1NpcInstance npc = (L1NpcInstance) target;
				npc.setParalyzed(true);
			}
		}
		return 0;
	}

	public static double calcDamageReduction(final L1PcInstance attacker, 
			final L1Character target, double damage, int element) {
		if (isImmune(target)) {
			return 0;
		}

		int mr = target.getMr();
		double mrFloor = 0;
		if (mr <= 100) {
			mrFloor = Math.floor((mr - attacker.getOriginalMagicHit()) / 2);
		} else if (mr >= 100) {
			mrFloor = Math.floor((mr - attacker.getOriginalMagicHit()) / 10);
		}
		double mrCoefficient = 0;
		if (mr <= 100) {
			mrCoefficient = 1 - 0.01 * mrFloor;
		} else if (mr >= 100) {
			mrCoefficient = 0.6 - 0.01 * mrFloor;
		}
		damage *= mrCoefficient;

		int resist = 0;
		if (element == Element.Earth) {
			resist = target.getEarth();
		} else if (element == Element.Fire) {
			resist = target.getFire();
		} else if (element == Element.Water) {
			resist = target.getWater();
		} else if (element == Element.Wind) {
			resist = target.getWind();
		}

		return damage * (1 - resist / 100.0);
	}

	private static boolean checkCounterMagic(final L1Character character) {
		if (!character.hasSkillEffect(COUNTER_MAGIC))
			return false;

		character.removeSkillEffect(COUNTER_MAGIC);
		int castgfx = SkillTable.getInstance().findBySkillId(
				COUNTER_MAGIC).getCastGfx();
		S_SkillSound packet = new S_SkillSound(character.getId(), castgfx);
		character.broadcastPacket(packet);
		if (character instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) character;
			pc.sendPackets(packet);
		}
		return true;
	}

	private static boolean isImmune(L1Character character) {
		if (L1Attack.isImmune(character) || 
				character.hasSkillEffect(STATUS_FREEZE)) {
			return true;
		}

		return checkCounterMagic(character);
	}
}
