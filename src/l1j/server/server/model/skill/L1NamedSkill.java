package l1j.server.server.model.skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public enum L1NamedSkill {
	LesserHeal(1, "Lesser Heal"), Light(2, "Light"), Shield(3, "Shield"), EnergyBolt(
			4, "EnergyBolt"), Teleport(5, "Teleport"), IceDagger(6,
			"Ice Dagger"), WindShuriken(7, "Wind Shuriken"), HolyWeapon(8,
			"Holy Weapon"), CurePoison(9, "Cure Poison"), ChillTouch(10,
			"Chill Touch"), CursePoison(11, "Curse - Poison"), EnchantWeapon(
			12, "Enchant Weapon"), Detection(13, "Detection"), DecreaseWeight(
			14, "Decrease Weight"), FireArrow(15, "Fire Arrow"), Stalactite(16,
			"Stalactite"), Lightning(17, "Lightning"), TurnUndead(18,
			"Turn Undead"), Heal(19, "Heal"), CurseBlindess(20,
			"Curse - Blindness"), BlessedArmor(21, "Blessed Armor"), FrozenCloud(
			22, "Frozen Cloud"), RevealWeakness(23, "Reveal Weakness"), Fireball(
			25, "Fireball"), EnchantDex(26, "Enchant Dexterity"), WeaponBreak(
			27, "Weapon Break"), VampiricTouch(28, "Vampiric Touch"), Slow(29,
			"Slow"), EarthJail(30, "Earth Jail"), CounterMagic(31,
			"Counter Magic"), Meditation(32, "Meditation"), CurseParalyze(33,
			"Curse - Paralyze"), CallLightning(34, "Call Lightning"), GreaterHeal(
			35, "Greater Heal"), TameMonster(36, "Tame Monster"), RemoveCurse(
			37, "Remove Curse"), ConeOfCold(38, "Cone of Cold"), ManaDrain(39,
			"Mana Drain"), Darkness(40, "Darkness"), CreateZombie(41,
			"Create Zombie"), EnchantStr(42, "Enchant Strength"), Haste(43,
			"Haste"), CancelMagic(44, "Cancel Magic"), Eruption(45, "Eruption"), Sunburst(
			46, "Sunburst"), Weakness(47, "Weakness"), BlessedWeapon(48,
			"Blessed Weapon"), HealPledge(49, "Heal Pledge"), IceLance(50,
			"Ice Lance"), SummonMonster(51, "Summon Monster"), HolyWalk(52,
			"Holy Walk"), Tornado(53, "Tornado"), GreaterHaste(54,
			"Greater Haste"), Berserkers(55, "Berserkers"), Disease(56,
			"Disease"), Fullheal(57, "Full Heal"), Firewall(58, "Firewall"), Blizzard(
			59, "Blizzard"), Invisibility(60, "Invisibility"), Resurrection(61,
			"Resurrection"), Earthquake(62, "Earthquake"), LifeStream(63,
			"Life Stream"), Silence(64, "Silence"), LightningStorm(65,
			"Lightning Storm"), FogOfSleeping(66, "Fog of Sleeping"), Polymorph(
			67, "Polymorph"), ImmuneToHarm(68, "Immune to Harm"), MassTeleport(
			69, "Mass Teleport"), Firestorm(70, "Firestorm"), DecayPotion(71,
			"Decay Potion"), CounterDetection(72, "Counter Detection"), CreateMagicalWeapon(
			73, "Create Magic Weapon"), MeteorStrike(74, "Meteor Strike"), GreaterResurrection(
			75, "Greater Resurrection"), MassSlow(76, "Mass Slow"), Destroy(77,
			"Destroy"), AbsoluteBarrier(78, "Absolute Barrier"), AdvanceSpirit(
			79, "Advance Spirit"), FreezingBlizzard(80, "Freezing Blizzard"), ShockStun(
			87, "Shock Stun"), ReductionArmor(88, "Reduction Armor"), BounceAttack(
			89, "Bounce Attack"), SolidCarriage(90, "Solid Carriage"), CounterBarrier(
			91, "Counter Barrier"), BlindHiding(97, "Blind Hiding"), EnchantVenom(
			98, "Enchant Venom"), ShadowArmor(99, "Shadow Armor"), BringStone(
			100, "Bring Stone"), MovingAcceleration(101, "Moving Acceleration"), BurningSpirit(
			102, "Burning Spirit"), DarkBlind(103, "Dark Blind"), VenomResist(
			104, "Venom Resist"), DoubleBreak(105, "Double Break"), UncannyDodge(
			106, "Uncanny Dodge"), ShadowFang(107, "Shadow Fang"), FinalBurn(
			108, "Final Burn"), DressMighty(109, "Dress Mighty"), DressDexterity(
			110, "Dress Dexterity"), DressEvasion(111, "Dress Evasion"), TrueTarget(
			113, "True Target"), GlowingAura(114, "Glowing Aura"), ShiningAura(
			115, "Shining Aura"), CallPledgeMember(116, "Call Pledge Member"), BraveAura(
			117, "Brave Aura"), RunClan(118, "Run Clan"), ResistMagic(129,
			"Resist Magic"), BodyToMind(130, "Body to Mind"), TeleportToMother(
			131, "Teleport to Mother"), TripleArrow(132, "Triple Arrow"), ElementalFalldown(
			133, "Elemental Falldown"), CounterMirror(134, "Counter Mirror"), ClearMind(
			137, "Clear Mind"), ResistElemental(138, "Resist Elemental"), ReturnToNature(
			145, "Return to Nature"), BloodToSoul(146, "Blood to Soul"), ElementalProtection(
			147, "Elemental Protection"), FireWeapon(148, "Fire Weapon"), WindShot(
			149, "Wind Shot"), WindWalk(150, "Wind Walk"), EarthSkin(151,
			"Earth Skin"), Entangle(152, "Entangle"), EraseMagic(153,
			"Erase Magic"), LesserElemental(154, "Summon Lesser Elemental"), BlessOfFire(
			155, "Bless of Fire"), EyeOfStorm(156, "Eye of Storm"), EarthBind(
			157, "Earth Bind"), NaturesTouch(158, "Nature's Touch"), BlessOfEarth(
			159, "Bless of Earth"), AquaProtecter(160, "Aqua Protector"), // TODO:
																			// look
																			// up
																			// real
																			// name.
	AreaOfSilence(161, "Area of Silence"), GreaterElemental(162,
			"Summon Greater Elemental"), BurningWeapon(163, "Burning Weapon"), NaturesBlessing(
			164, "Nature's Blessing"), CallOfNature(165, "Call of Nature"), StormShot(
			166, "Storm Shot"), WindShackle(167, "Wind Shackle"), IronSkin(168,
			"Iron Skin"), ExoticVitalize(169, "Exotic Vitalize"), WaterLife(
			170, "Water Life"), ElementalFire(171, "Elemental Fire"), StormWalk(
			172, "Storm Walk"), PolluteWater(173, "Pollute Water"), StrikersGale(
			174, "Strikers' Gale"), SoulOfFlame(175, "Soul of Flame"), AdditionalFire(
			176, "Additional Fire"), DragonSkin(181, "Dragon Skin"), BurningSlash(
			182, "Burning Slash"), GuardBreak(183, "Guard Break"), MagmaBreath(
			184, "Magma Breath"), AwakenAntharas(185, "Awaken - Antharas"), Bloodlust(
			186, "Bloodlust"), FoeSlayer(187, "Foe Slayer"), ResistFear(188,
			"Resist Fear"), ShockSkin(189, "Shock Skin"), AwakenFafurion(190,
			"Awaken - Fafurion"), MortalBody(191, "Mortal Body"), ThunderGrab(
			192, "Thunder Grab"), HorrorOfDeath(193, "Horror of Death"), FreezingBreath(
			194, "Freezing Breath"), AwakenValakas(195, "Awaken - Valakas"), MirrorImage(
			201, "Mirror Image"), Confusion(202, "Confusion"), Smash(203,
			"Confusion"), IllusionOgre(204, "Illusion - Ogre"), CubeIgnition(
			205, "Cube - Ignition"), Concentration(206, "Concentration"), MindBreak(
			207, "Mind Break"), BoneBreak(208, "Bone Break"), IllusionLich(209,
			"Illusion - Lich"), CubeQuake(210, "Cube - Quake"), Patience(211,
			"Patience"), Phantasm(212, "Phantasm"), ArmBreaker(213,
			"Arm Breaker"), IllusionGolem(214, "Illusion - Diamond Golem"), CubeShock(
			215, "Cube - Shock"), Insight(216, "Insight"), Panic(217, "Panic"), JoyOfPain(
			218, "Joy of Pain"), IllusionAvatar(219, "Illusion - Avatar"), CubeBalance(
			220, "Cube - Balance"), StatusBravery(1000, "Brave"), StatusHaste(
			1001, "Haste"), StatusManaRegen(1002, "Potion of Mana Regeneration"), StatusBreathWater(
			1003, "Underwater Breath"), StatusWisdom(1004, "Potion of Wisdom"), StatusPoison(
			1006, "Poisoned"), StatusSilenced(1007, "Poisoned - Silenced"), StatusPartialParalyzed(
			1008, "Poisoned - Partially Paralyzed"), StatusParalyzed(1009,
			"Poisoned - Paralyzed"), StatusWafer(1016, "Elven Wafer"),
	// Why do I feel compelled to keep the spelling error?
	StatusBarlog(1015, "Status - Balrog Blessing"), StatusYahee(1014,
			"Status - Yahee Blessing");

	/*
	 * public static final int STATUS_CHAT_PROHIBITED = 1005;
	 * 
	 * public static final int STATUS_CURSE_PARALYZING = 1010; public static
	 * final int STATUS_CURSE_PARALYZED = 1011; public static final int
	 * STATUS_FLOATING_EYE = 1012; public static final int STATUS_HOLY_WATER =
	 * 1013; public static final int STATUS_HOLY_MITHRIL_POWDER = 1014; public
	 * static final int STATUS_HOLY_WATER_OF_EVA = 1015; public static final int
	 * STATUS_RIBRAVE = 1017; public static final int
	 * STATUS_CUBE_IGNITION_TO_ALLY = 1018; public static final int
	 * STATUS_CUBE_IGNITION_TO_ENEMY = 1019; public static final int
	 * STATUS_CUBE_QUAKE_TO_ALLY = 1020; public static final int
	 * STATUS_CUBE_QUAKE_TO_ENEMY = 1021; public static final int
	 * STATUS_CUBE_SHOCK_TO_ALLY = 1022; public static final int
	 * STATUS_CUBE_SHOCK_TO_ENEMY = 1023; public static final int
	 * STATUS_MR_REDUCTION_BY_CUBE_SHOCK = 1024; public static final int
	 * STATUS_CUBE_BALANCE = 1025; public static final int STATUS_END = 1025;
	 * public static final int GMSTATUS_BEGIN = 2000; public static final int
	 * GMSTATUS_INVISIBLE = 2000; public static final int GMSTATUS_HPBAR = 2001;
	 * public static final int GMSTATUS_SHOWTRAPS = 2002; public static final
	 * int GMSTATUS_FINDINVIS = 2003; public static final int GMSTATUS_END =
	 * 2003; SKILLS_END = 220; MASS_SHOCK_STUN = 500;
	 * 
	 * public static final int COOKING_NOW = 2999; public static final int
	 * COOKING_BEGIN = 3000; public static final int COOKING_1_0_N = 3000;
	 * public static final int COOKING_1_1_N = 3001; public static final int
	 * COOKING_1_2_N = 3002; public static final int COOKING_1_3_N = 3003;
	 * public static final int COOKING_1_4_N = 3004; public static final int
	 * COOKING_1_5_N = 3005; public static final int COOKING_1_6_N = 3006;
	 * public static final int COOKING_1_7_N = 3007; public static final int
	 * COOKING_1_0_S = 3008; public static final int COOKING_1_1_S = 3009;
	 * public static final int COOKING_1_2_S = 3010; public static final int
	 * COOKING_1_3_S = 3011; public static final int COOKING_1_4_S = 3012;
	 * public static final int COOKING_1_5_S = 3013; public static final int
	 * COOKING_1_6_S = 3014; public static final int COOKING_1_7_S = 3015;
	 * public static final int COOKING_2_0_N = 3016; public static final int
	 * COOKING_2_1_N = 3017; public static final int COOKING_2_2_N = 3018;
	 * public static final int COOKING_2_3_N = 3019; public static final int
	 * COOKING_2_4_N = 3020; public static final int COOKING_2_5_N = 3021;
	 * public static final int COOKING_2_6_N = 3022; public static final int
	 * COOKING_2_7_N = 3023; public static final int COOKING_2_0_S = 3024;
	 * public static final int COOKING_2_1_S = 3025; public static final int
	 * COOKING_2_2_S = 3026; public static final int COOKING_2_3_S = 3027;
	 * public static final int COOKING_2_4_S = 3028; public static final int
	 * COOKING_2_5_S = 3029; public static final int COOKING_2_6_S = 3030;
	 * public static final int COOKING_2_7_S = 3031; public static final int
	 * COOKING_3_0_N = 3032; public static final int COOKING_3_1_N = 3033;
	 * public static final int COOKING_3_2_N = 3034; public static final int
	 * COOKING_3_3_N = 3035; public static final int COOKING_3_4_N = 3036;
	 * public static final int COOKING_3_5_N = 3037; public static final int
	 * COOKING_3_6_N = 3038; public static final int COOKING_3_7_N = 3039;
	 * public static final int COOKING_3_0_S = 3040; public static final int
	 * COOKING_3_1_S = 3041; public static final int COOKING_3_2_S = 3042;
	 * public static final int COOKING_3_3_S = 3043; public static final int
	 * COOKING_3_4_S = 3044; public static final int COOKING_3_5_S = 3045;
	 * public static final int COOKING_3_6_S = 3046; public static final int
	 * COOKING_3_7_S = 3047; public static final int COOKING_END = 3047; public
	 * static final int STATUS_FREEZE = 10071; public static final int
	 * CURSE_PARALYZE2 = 10101; public static final int
	 * STATUS_WEAKNESS_EXPOSURE_LV1 = 1026; public static final int
	 * STATUS_WEAKNESS_EXPOSURE_LV2 = 1027; public static final int
	 * STATUS_WEAKNESS_EXPOSURE_LV3 = 1028; public static final int
	 * STATUS_DESTRUCTION_NOSTRUM = 1029; public static final int STATUS_BRAVE2
	 * = 20001;
	 */

	private final int id;
	private final String name;
	private static final Map<Integer, L1NamedSkill> idsToSkills = new HashMap<Integer, L1NamedSkill>();

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
	 * @return the name of the skill, given by id.
	 */
	public static String getName(int id) {
		final L1NamedSkill skill = idsToSkills.get(id);
		return skill != null ? skill.toString() : "Id: "
				+ ((Integer) id).toString();
	}

	/**
	 * @return get a list of skills matching the given search string.
	 */
	public static List<L1NamedSkill> searchNames(String query) {
		List<L1NamedSkill> results = new ArrayList<L1NamedSkill>(4);
		Pattern pattern = Pattern.compile(".*" + query + ".*");
		for (L1NamedSkill skill : L1NamedSkill.values()) {
			if (pattern.matcher(skill.name.toLowerCase()).matches())
				results.add(skill);
		}
		return results;
	}
}
