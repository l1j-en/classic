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

public class L1SkillId {
	public static final int SKILLS_BEGIN = 1;

	/*
	 * Regular Magic Lv1-10
	 */
	public static final int HEAL = 1; // E: LESSER_HEAL

	public static final int LIGHT = 2;

	public static final int SHIELD = 3;

	public static final int ENERGY_BOLT = 4;

	public static final int TELEPORT = 5;

	public static final int ICE_DAGGER = 6;

	public static final int WIND_CUTTER = 7; // E: WIND_SHURIKEN

	public static final int HOLY_WEAPON = 8;

	public static final int CURE_POISON = 9;

	public static final int CHILL_TOUCH = 10;

	public static final int CURSE_POISON = 11;

	public static final int ENCHANT_WEAPON = 12;

	public static final int DETECTION = 13;

	public static final int DECREASE_WEIGHT = 14;

	public static final int FIRE_ARROW = 15;

	public static final int STALAC = 16;

	public static final int LIGHTNING = 17;

	public static final int TURN_UNDEAD = 18;

	public static final int EXTRA_HEAL = 19; // E: HEAL

	public static final int CURSE_BLIND = 20;

	public static final int BLESSED_ARMOR = 21;

	public static final int FROZEN_CLOUD = 22;

	public static final int WEAK_ELEMENTAL = 23; // E: REVEAL_WEAKNESS

	// none = 24
	public static final int FIREBALL = 25;

	public static final int PHYSICAL_ENCHANT_DEX = 26; // E: ENCHANT_DEXTERITY

	public static final int WEAPON_BREAK = 27;

	public static final int VAMPIRIC_TOUCH = 28;

	public static final int SLOW = 29;

	public static final int EARTH_JAIL = 30;

	public static final int COUNTER_MAGIC = 31;

	public static final int MEDITATION = 32;

	public static final int CURSE_PARALYZE = 33;

	public static final int CALL_LIGHTNING = 34;

	public static final int GREATER_HEAL = 35;

	public static final int TAMING_MONSTER = 36; // E: TAME_MONSTER

	public static final int REMOVE_CURSE = 37;

	public static final int CONE_OF_COLD = 38;

	public static final int MANA_DRAIN = 39;

	public static final int DARKNESS = 40;

	public static final int CREATE_ZOMBIE = 41;

	public static final int PHYSICAL_ENCHANT_STR = 42; // E: ENCHANT_MIGHTY

	public static final int HASTE = 43;

	public static final int CANCELLATION = 44; // E: CANCEL MAGIC

	public static final int ERUPTION = 45;

	public static final int SUNBURST = 46;

	public static final int WEAKNESS = 47;

	public static final int BLESS_WEAPON = 48;

	public static final int HEAL_ALL = 49; // E: HEAL_PLEDGE

	public static final int ICE_LANCE = 50;

	public static final int SUMMON_MONSTER = 51;

	public static final int HOLY_WALK = 52;

	public static final int TORNADO = 53;

	public static final int GREATER_HASTE = 54;

	public static final int BERSERKERS = 55;

	public static final int DISEASE = 56;

	public static final int FULL_HEAL = 57;

	public static final int FIRE_WALL = 58;

	public static final int BLIZZARD = 59;

	public static final int INVISIBILITY = 60;

	public static final int RESURRECTION = 61;

	public static final int EARTHQUAKE = 62;

	public static final int LIFE_STREAM = 63;

	public static final int SILENCE = 64;

	public static final int LIGHTNING_STORM = 65;

	public static final int FOG_OF_SLEEPING = 66;

	public static final int SHAPE_CHANGE = 67; // E: POLYMORPH

	public static final int IMMUNE_TO_HARM = 68;

	public static final int MASS_TELEPORT = 69;

	public static final int FIRE_STORM = 70;

	public static final int DECAY_POTION = 71;

	public static final int COUNTER_DETECTION = 72;

	public static final int CREATE_MAGICAL_WEAPON = 73;

	public static final int METEOR_STRIKE = 74;

	public static final int GREATER_RESURRECTION = 75;

	public static final int MASS_SLOW = 76;

	public static final int DISINTEGRATE = 77; // E: DESTROY

	public static final int ABSOLUTE_BARRIER = 78;

	public static final int ADVANCE_SPIRIT = 79;

	public static final int FREEZING_BLIZZARD = 80;

	// none = 81 - 86
	/*
	 * Knight skills
	 */
	public static final int SHOCK_STUN = 87; // E: STUN_SHOCK

	public static final int REDUCTION_ARMOR = 88;

	public static final int BOUNCE_ATTACK = 89;

	public static final int SOLID_CARRIAGE = 90;

	public static final int COUNTER_BARRIER = 91;

	// none = 92-96
	/*
	 * Dark Spirit Magic
	 */
	public static final int BLIND_HIDING = 97;

	public static final int ENCHANT_VENOM = 98;

	public static final int SHADOW_ARMOR = 99;

	public static final int BRING_STONE = 100; // E: PURIFY_STONE

	public static final int MOVING_ACCELERATION = 101;

	public static final int BURNING_SPIRIT = 102;

	public static final int DARK_BLIND = 103;

	public static final int VENOM_RESIST = 104;

	public static final int DOUBLE_BRAKE = 105;

	public static final int UNCANNY_DODGE = 106;

	public static final int SHADOW_FANG = 107;

	public static final int FINAL_BURN = 108;

	public static final int DRESS_MIGHTY = 109;

	public static final int DRESS_DEXTERITY = 110;

	public static final int DRESS_EVASION = 111;

	// none = 112
	/*
	 * Royal Magic
	 */
	public static final int TRUE_TARGET = 113;

	public static final int GLOWING_AURA = 114;

	public static final int SHINING_AURA = 115;

	public static final int CALL_CLAN = 116; // E: CALL_PLEDGE_MEMBER

	public static final int BRAVE_AURA = 117;

	public static final int RUN_CLAN = 118;

	// unknown = 119 - 120
	// none = 121 - 128
	/*
	 * Spirit Magic
	 */
	public static final int RESIST_MAGIC = 129;

	public static final int BODY_TO_MIND = 130;

	public static final int TELEPORT_TO_MOTHER = 131;

	public static final int TRIPLE_ARROW = 132;

	public static final int ELEMENTAL_FALL_DOWN = 133;

	public static final int COUNTER_MIRROR = 134;

	// none = 135 - 136
	public static final int CLEAR_MIND = 137;

	public static final int RESIST_ELEMENTAL = 138;

	// none = 139 - 144
	public static final int RETURN_TO_NATURE = 145;

	public static final int BLOODY_SOUL = 146; // E: BLOOD_TO_SOUL

	public static final int ELEMENTAL_PROTECTION = 147; // E:PROTECTION_FROM_ELEMENTAL

	public static final int FIRE_WEAPON = 148;

	public static final int WIND_SHOT = 149;

	public static final int WIND_WALK = 150;

	public static final int EARTH_SKIN = 151;

	public static final int ENTANGLE = 152;

	public static final int ERASE_MAGIC = 153;

	public static final int LESSER_ELEMENTAL = 154; // E:SUMMON_LESSER_ELEMENTAL

	public static final int FIRE_BLESS = 155; // E: BLESS_OF_FIRE

	public static final int STORM_EYE = 156; // E: EYE_OF_STORM

	public static final int EARTH_BIND = 157;

	public static final int NATURES_TOUCH = 158;

	public static final int EARTH_BLESS = 159; // E: BLESS_OF_EARTH

	public static final int AQUA_PROTECTER = 160;

	public static final int AREA_OF_SILENCE = 161;

	public static final int GREATER_ELEMENTAL = 162; // E:SUMMON_GREATER_ELEMENTAL

	public static final int BURNING_WEAPON = 163;

	public static final int NATURES_BLESSING = 164;

	public static final int CALL_OF_NATURE = 165; // E: NATURES_MIRACLE

	public static final int STORM_SHOT = 166;

	public static final int WIND_SHACKLE = 167;

	public static final int IRON_SKIN = 168;

	public static final int EXOTIC_VITALIZE = 169;

	public static final int WATER_LIFE = 170;

	public static final int ELEMENTAL_FIRE = 171;

	public static final int STORM_WALK = 172;

	public static final int POLLUTE_WATER = 173;

	public static final int STRIKER_GALE = 174;

	public static final int SOUL_OF_FLAME = 175;

	public static final int ADDITIONAL_FIRE = 176;

	public static final int SKILLS_END = 176;

	/*
	 * Status
	 */
	public static final int STATUS_BEGIN = 1000;

	public static final int STATUS_BRAVE = 1000;

	public static final int STATUS_HASTE = 1001;

	public static final int STATUS_BLUE_POTION = 1002;

	public static final int STATUS_UNDERWATER_BREATH = 1003;

	public static final int STATUS_WISDOM_POTION = 1004;

	public static final int STATUS_CHAT_PROHIBITED = 1005;

	public static final int STATUS_POISON = 1006;

	public static final int STATUS_POISON_SILENCE = 1007;

	public static final int STATUS_POISON_PARALYZING = 1008;

	public static final int STATUS_POISON_PARALYZED = 1009;

	public static final int STATUS_CURSE_PARALYZING = 1010;

	public static final int STATUS_CURSE_PARALYZED = 1011;

	public static final int STATUS_FLOATING_EYE = 1012;

	public static final int STATUS_HOLY_WATER = 1013;

	public static final int STATUS_HOLY_MITHRIL_POWDER = 1014;

	public static final int STATUS_HOLY_WATER_OF_EVA = 1015;

	public static final int STATUS_ELFBRAVE = 1016;

	public static final int STATUS_END = 1016;

	public static final int GMSTATUS_BEGIN = 2000;

	public static final int GMSTATUS_INVISIBLE = 2000;

	public static final int GMSTATUS_HPBAR = 2001;

	public static final int GMSTATUS_SHOWTRAPS = 2002;

	public static final int GMSTATUS_END = 2002;

	public static final int COOKING_BEGIN = 3000;

	public static final int COOKING_1_0_N = 3000;

	public static final int COOKING_1_1_N = 3001;

	public static final int COOKING_1_2_N = 3002;

	public static final int COOKING_1_3_N = 3003;

	public static final int COOKING_1_4_N = 3004;

	public static final int COOKING_1_5_N = 3005;

	public static final int COOKING_1_6_N = 3006;

	public static final int COOKING_1_7_N = 3007;

	public static final int COOKING_1_0_S = 3050;

	public static final int COOKING_1_1_S = 3051;

	public static final int COOKING_1_2_S = 3052;

	public static final int COOKING_1_3_S = 3053;

	public static final int COOKING_1_4_S = 3054;

	public static final int COOKING_1_5_S = 3055;

	public static final int COOKING_1_6_S = 3056;

	public static final int COOKING_1_7_S = 3057;

	public static final int COOKING_END = 3057;

	public static final int STATUS_FREEZE = 10071;

	public static final int CURSE_PARALYZE2 = 10101;

	public static final int STATUS_CURSE_BARLOG = 1015;

	public static final int STATUS_CURSE_YAHEE = 1014;

}
