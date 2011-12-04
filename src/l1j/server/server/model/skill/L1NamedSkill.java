package l1j.server.server.model.skill;

import java.util.HashMap;
import java.util.Map;

public enum L1NamedSkill {
	Heal(1, "Lesser Heal"),
	Light(2, "Light"),
	Shield(3, "Shield"),
	EnergyBolt(4, "EnergyBolt"),
	Teleport(5, "Teleport"),
	HolyWeapon(8, "Holy Weapon"),
	EnchantWeapon(12, "Enchant Weapon"),
	DecreaseWeight(14, "Decrease Weight"),
	CurseBlindess(20, "Curse - Blindness"),
	BlessedArmor(21, "Blessed Armor"),
	EnchantDex(26, "Enchant Dexterity"),
	WeaponBreak(27, "Weapon Break"),
	Slow(29, "Slow"),
	EarthJail(30, "Earth Jail"),
	CounterMagic(31, "Counter Magic"),
	Meditation(32, "Meditation"),
	CurseParalyze(33, "Curse - Paralyze"),
	Darkness(40, "Darkness"),
	EnchantStr(42, "Enchant Strength"),
	Haste(43, "Haste"),
	Weakness(47, "Weakness"),
	BlessedWeapon(48, "Blessed Weapon"),
	HolyWalk(52, "Holy Walk"),
	GreaterHaste(54, "Greater Haste"),
	Berserkers(55, "Berserkers"),
	Disease(56, "Disease"),
	Invisibility(60, "Invisibility"),
	Polymorph(67, "Polymorph"),
	ImmuneToHarm(68, "Immune to Harm"),
	MassSlow(76, "Mass Slow"),
	AbsoluteBarrier(78, "Absolute Barrier"),
	AdvanceSpirit(79, "Advance Spirit"),
	ShockStun(87, "Shock Stun"),
	ReductionArmor(88, "Reduction Armor"),
	BounceAttack(89, "Bounce Attack"),
	SolidCarriage(90, "Solid Carriage"),
	CounterBarrier(91, "Counter Barrier"),
	BlindHiding(97, "Blind Hiding"),
	EnchantVenom(98, "Enchant Venom"),
	ShadowArmor(99, "Shadow Armor"),
	MovingAcceleration(101, "Moving Acceleration"),
	VenomResist(104, "Venom Resist"),
	DoubleBreak(105, "Double Break"),
	UncannyDodge(106, "Uncanny Dodge"),
	ShadowFang(107, "Shadow Fang"),
	DressMighty(109, "Dress Mighty"),
	DressDexterity(110, "Dress Dexterity"),
	DressEvasion(111, "Dress Evasion"),
	GlowingAura(114, "Glowing Aura"),
	ShiningAura(115, "Shining Aura"),
	BraveAura(117, "Brave Aura"),
	ResistMagic(129, "Resist Magic"),
	CounterMirror(134, "Counter Mirror"),
	ResistElemental(138, "Resist Elemental"),
	ElementalProtection(147, "Elemental Protection"),
	FireWeapon(148, "Fire Weapon"),
	WindShot(149, "Wind Shot"),
	WindWalk(150, "Wind Walk"),
	EarthSkin(151, "Earth Skin"),
	Entangle(152, "Entangle"),
	EraseMagic(153, "Erase Magic"),
	BlessOfFire(155, "Bless of Fire"),
	EyeOfStorm(156, "Eye of Storm"),
	EarthBind(157, "Earth Bind"),
	BlessOfEarth(159, "Bless of Earth"),
	NaturesTouch(158, "Nature's Touch"),
	BurningWeapon(163, "Burning Weapon"),
	NaturesBlessing(164, "Nature's Blessing"),
	StormShot(166, "Storm Shot"),
	WindShackle(167, "Wind Shackle"),
	IronSkin(168, "Iron Skin"),
	ExoticVitalize(169, "Exotic Vitalize"),
	WaterLife(170, "Water Life"),
	ElementalFire(171, "Elemental Fire"),
	StormWalk(172, "Storm Walk"),
	PolluteWater(173, "Pollute Water"),
	StrikersGale(174, "Strikers' Gale"),
	SoulOfFlame(175, "Soul of Flame"),
	AdditionalFire(176, "Additional Fire"),
	StatusBravery(1000, "Brave"),
	StatusHaste(1001, "Haste"),
	StatusManaRegen(1002, "Potion of Mana Regeneration"),
	StatusBreathWater(1003, "Underwater Breath"),
	StatusWisdom(1004, "Potion of Wisdom"),
	StatusPoison(1006, "Poisoned"),
	StatusSilenced(1007, "Poisoned - Silenced"),
	StatusPartialParalyzed(1008, "Poisoned - Partially Paralyzed"),
	StatusParalyzed(1009, "Poisoned - Paralyzed"),
	StatusWafer(1016, "Elven Wafer");
	
	/*
	public static final int STATUS_CHAT_PROHIBITED = 1005;
	
	public static final int STATUS_CURSE_PARALYZING = 1010;
	public static final int STATUS_CURSE_PARALYZED = 1011;
	public static final int STATUS_FLOATING_EYE = 1012;
	public static final int STATUS_HOLY_WATER = 1013;
	public static final int STATUS_HOLY_MITHRIL_POWDER = 1014;
	public static final int STATUS_HOLY_WATER_OF_EVA = 1015;
	public static final int STATUS_RIBRAVE = 1017;
	public static final int STATUS_CUBE_IGNITION_TO_ALLY = 1018;
	public static final int STATUS_CUBE_IGNITION_TO_ENEMY = 1019;
	public static final int STATUS_CUBE_QUAKE_TO_ALLY = 1020;
	public static final int STATUS_CUBE_QUAKE_TO_ENEMY = 1021;
	public static final int STATUS_CUBE_SHOCK_TO_ALLY = 1022;
	public static final int STATUS_CUBE_SHOCK_TO_ENEMY = 1023;
	public static final int STATUS_MR_REDUCTION_BY_CUBE_SHOCK = 1024;
	public static final int STATUS_CUBE_BALANCE = 1025;
	public static final int STATUS_END = 1025;
	public static final int GMSTATUS_BEGIN = 2000;
	public static final int GMSTATUS_INVISIBLE = 2000;
	public static final int GMSTATUS_HPBAR = 2001;
	public static final int GMSTATUS_SHOWTRAPS = 2002;
	public static final int GMSTATUS_FINDINVIS = 2003;
	public static final int GMSTATUS_END = 2003;
	public static final int BODY_TO_MIND = 130;
	public static final int TELEPORT_TO_MATHER = 131;
	public static final int TRIPLE_ARROW = 132;
	public static final int ELEMENTAL_FALL_DOWN = 133;
	public static final int CLEAR_MIND = 137;
	public static final int RETURN_TO_NATURE = 145;
	public static final int BLOODY_SOUL = 146; // E: BLOOD_TO_SOUL
	public static final int LESSER_ELEMENTAL = 154; // E:SUMMON_LESSER_ELEMENTAL
	public static final int AQUA_PROTECTER = 160;
	public static final int AREA_OF_SILENCE = 161;
	public static final int GREATER_ELEMENTAL = 162; // E:SUMMON_GREATER_ELEMENTAL
	public static final int CALL_OF_NATURE = 165; // E: NATURES_MIRACLE
	public static final int DRAGON_SKIN = 181;
	public static final int BURNING_SLASH = 182;
	public static final int GUARD_BRAKE = 183;
	public static final int MAGMA_BREATH = 184;
	public static final int AWAKEN_ANTHARAS = 185;
	public static final int BLOODLUST = 186;
	public static final int FOE_SLAYER = 187;
	public static final int RESIST_FEAR = 188;
	public static final int SHOCK_SKIN = 189;
	public static final int AWAKEN_FAFURION = 190;
	public static final int MORTAL_BODY = 191;
	public static final int THUNDER_GRAB = 192;
	public static final int HORROR_OF_DEATH = 193;
	public static final int FREEZING_BREATH = 194;
	public static final int AWAKEN_VALAKAS = 195;

	public static final int MIRROR_IMAGE = 201;
	public static final int CONFUSION = 202;
	public static final int SMASH = 203;
	public static final int ILLUSION_OGRE = 204;
	public static final int CUBE_IGNITION = 205;
	public static final int CONCENTRATION = 206;
	public static final int MIND_BREAK = 207;
	public static final int BONE_BREAK = 208;
	public static final int ILLUSION_LICH = 209;
	public static final int CUBE_QUAKE = 210;
	public static final int PATIENCE = 211;
	public static final int PHANTASM = 212;
	public static final int ARM_BREAKER = 213;
	public static final int ILLUSION_DIA_GOLEM = 214;
	public static final int CUBE_SHOCK = 215;
	public static final int INSIGHT = 216;
	public static final int PANIC = 217;
	public static final int JOY_OF_PAIN = 218;
	public static final int ILLUSION_AVATAR = 219;
	public static final int CUBE_BALANCE = 220;
	public static final int SKILLS_END = 220;
	public static final int MASS_SHOCK_STUN = 500; // 範囲スタン

	public static final int BRING_STONE = 100;
	public static final int BURNING_SPIRIT = 102;
	public static final int DARK_BLIND = 103;
	public static final int FINAL_BURN = 108;
	
	public static final int TRUE_TARGET = 113;
	public static final int CALL_CLAN = 116; // E: CALL_PLEDGE_MEMBER
	public static final int RUN_CLAN = 118;
	public static final int CANCELLATION = 44; // E: CANCEL MAGIC
	public static final int ERUPTION = 45;
	public static final int SUNBURST = 46;
	public static final int WEAKNESS = 47;
	public static final int HEAL_ALL = 49; // E: HEAL_PLEDGE
	public static final int ICE_LANCE = 50;
	public static final int SUMMON_MONSTER = 51;
	public static final int TORNADO = 53;
	public static final int FULL_HEAL = 57;
	public static final int FIRE_WALL = 58;
	public static final int BLIZZARD = 59;
	public static final int RESURRECTION = 61;
	public static final int EARTHQUAKE = 62;
	public static final int LIFE_STREAM = 63;
	public static final int SILENCE = 64;
	public static final int LIGHTNING_STORM = 65;
	public static final int FOG_OF_SLEEPING = 66;
	public static final int MASS_TELEPORT = 69;
	public static final int FIRE_STORM = 70;
	public static final int DECAY_POTION = 71;
	public static final int COUNTER_DETECTION = 72;
	public static final int CREATE_MAGICAL_WEAPON = 73;
	public static final int METEOR_STRIKE = 74;
	public static final int GREATER_RESURRECTION = 75;
	public static final int DISINTEGRATE = 77; // E: DESTROY
	public static final int FREEZING_BLIZZARD = 80;
	public static final int ICE_DAGGER = 6;
	public static final int WIND_CUTTER = 7; // E: WIND_SHURIKEN
	public static final int CURE_POISON = 9;
	public static final int CHILL_TOUCH = 10;
	public static final int CURSE_POISON = 11;
	public static final int DETECTION = 13;
	public static final int FIRE_ARROW = 15;
	public static final int STALAC = 16;
	public static final int LIGHTNING = 17;
	public static final int TURN_UNDEAD = 18;
	public static final int EXTRA_HEAL = 19; // E: HEAL
	public static final int FROZEN_CLOUD = 22;
	public static final int WEAK_ELEMENTAL = 23; // E: REVEAL_WEAKNESS
	// none = 24
	public static final int FIREBALL = 25;

	public static final int WEAPON_BREAK = 27;
	public static final int VAMPIRIC_TOUCH = 28;
	
	public static final int CALL_LIGHTNING = 34;
	public static final int GREATER_HEAL = 35;
	public static final int TAMING_MONSTER = 36; // E: TAME_MONSTER
	public static final int REMOVE_CURSE = 37;
	public static final int CONE_OF_COLD = 38;
	public static final int MANA_DRAIN = 39;
	public static final int CREATE_ZOMBIE = 41;
	public static final int COOKING_NOW = 2999;
	public static final int COOKING_BEGIN = 3000;
	public static final int COOKING_1_0_N = 3000;
	public static final int COOKING_1_1_N = 3001;
	public static final int COOKING_1_2_N = 3002;
	public static final int COOKING_1_3_N = 3003;
	public static final int COOKING_1_4_N = 3004;
	public static final int COOKING_1_5_N = 3005;
	public static final int COOKING_1_6_N = 3006;
	public static final int COOKING_1_7_N = 3007;
	public static final int COOKING_1_0_S = 3008;
	public static final int COOKING_1_1_S = 3009;
	public static final int COOKING_1_2_S = 3010;
	public static final int COOKING_1_3_S = 3011;
	public static final int COOKING_1_4_S = 3012;
	public static final int COOKING_1_5_S = 3013;
	public static final int COOKING_1_6_S = 3014;
	public static final int COOKING_1_7_S = 3015;
	public static final int COOKING_2_0_N = 3016;
	public static final int COOKING_2_1_N = 3017;
	public static final int COOKING_2_2_N = 3018;
	public static final int COOKING_2_3_N = 3019;
	public static final int COOKING_2_4_N = 3020;
	public static final int COOKING_2_5_N = 3021;
	public static final int COOKING_2_6_N = 3022;
	public static final int COOKING_2_7_N = 3023;
	public static final int COOKING_2_0_S = 3024;
	public static final int COOKING_2_1_S = 3025;
	public static final int COOKING_2_2_S = 3026;
	public static final int COOKING_2_3_S = 3027;
	public static final int COOKING_2_4_S = 3028;
	public static final int COOKING_2_5_S = 3029;
	public static final int COOKING_2_6_S = 3030;
	public static final int COOKING_2_7_S = 3031;
	public static final int COOKING_3_0_N = 3032;
	public static final int COOKING_3_1_N = 3033;
	public static final int COOKING_3_2_N = 3034;
	public static final int COOKING_3_3_N = 3035;
	public static final int COOKING_3_4_N = 3036;
	public static final int COOKING_3_5_N = 3037;
	public static final int COOKING_3_6_N = 3038;
	public static final int COOKING_3_7_N = 3039;
	public static final int COOKING_3_0_S = 3040;
	public static final int COOKING_3_1_S = 3041;
	public static final int COOKING_3_2_S = 3042;
	public static final int COOKING_3_3_S = 3043;
	public static final int COOKING_3_4_S = 3044;
	public static final int COOKING_3_5_S = 3045;
	public static final int COOKING_3_6_S = 3046;
	public static final int COOKING_3_7_S = 3047;
	public static final int COOKING_END = 3047;
	public static final int STATUS_FREEZE = 10071;
	public static final int CURSE_PARALYZE2 = 10101;
	public static final int STATUS_CURSE_BARLOG = 1015;
	public static final int STATUS_CURSE_YAHEE = 1014;
	public static final int STATUS_WEAKNESS_EXPOSURE_LV1 = 1026;
	public static final int STATUS_WEAKNESS_EXPOSURE_LV2 = 1027;
	public static final int STATUS_WEAKNESS_EXPOSURE_LV3 = 1028;
	public static final int STATUS_DESTRUCTION_NOSTRUM = 1029;
	public static final int STATUS_BRAVE2 = 20001;
	*/
	
	private final int id;
	private final String name;
	private final static Map<Integer, L1NamedSkill> idsToSkills = 
			new HashMap<Integer, L1NamedSkill>();
	
	static {
		for (L1NamedSkill skill : L1NamedSkill.values())
			idsToSkills.put(skill.getId(), skill);
	}
	
	L1NamedSkill(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the number identifying this skill in the database.
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * @return The name of the skill, given by id.
	 */
	public static String getName(int id) {
		L1NamedSkill skill = idsToSkills.get(id);
		return skill != null 
				? skill.toString() 
				: ((Integer) skill.getId()).toString();
	}
}
