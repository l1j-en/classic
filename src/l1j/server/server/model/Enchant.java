package l1j.server.server.model;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.datatables.AccessLevelTable;
import l1j.server.server.datatables.LogEnchantTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.serverpackets.S_ItemStatus;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Item;
import l1j.server.server.utils.collections.IntArrays;

public class Enchant {
	private static final Random _random = new Random();
	private static Logger _log = Logger.getLogger(Enchant.class.getName());
	private static final S_ServerMessage CantEnchant = new S_ServerMessage(79);
	private static final int FULL_GM = AccessLevelTable.getInstance().getMaxAccessLevel();

	private static final int[] IvoryTowerWeapons = new int[] { 7, 35, 48, 73,
			105, 120, 147, 156, 174, 175, 224 };

	private static final int[] IvoryTowerArmor = new int[] { 20028, 20082,
			20126, 20173, 20206, 20232, 21138, 21140, 21141 };

	static {
		Arrays.sort(IvoryTowerWeapons);
		Arrays.sort(IvoryTowerArmor);
	}

	private enum Result {
		Success, Unchanged, Failure
	}

	public static void elementEnchant(final L1PcInstance player,
			final L1ItemInstance scroll, final L1ItemInstance weapon) {
		if (!Config.ELEMENTAL_ENCHANTING) {
			player.sendPackets(new S_SystemMessage(
					"Elemental enchanting is disabled on this server."));
			return;
		}

		if (weapon == null || weapon.getItem().getType2() != 1
				|| weapon.getBless() >= 128
				|| weapon.getItem().get_safeenchant() < 0) {
			player.sendPackets(CantEnchant);
			return;
		}

		int newElement = 0;
		switch (scroll.getItem().getItemId()) {
		case 41429:
			newElement = Element.Wind;
			break;
		case 41430:
			newElement = Element.Earth;
			break;
		case 41431:
			newElement = Element.Water;
			break;
		case 41432:
			newElement = Element.Fire;
			break;
		default:
			_log.log(Level.WARNING, "Enchant: bad elemental scroll id.");
			return;
		}

		boolean sameElement = newElement == weapon.getAttrEnchantKind();
		int currentLevel = weapon.getAttrEnchantLevel();

		if (sameElement && currentLevel >= Config.ELEMENTAL_ENCHANT_LIMIT) {
			player.sendPackets(new S_ServerMessage(1453));
			return;
		}

		final L1PcInventory inventory = player.getInventory();
		if (player.isGm() && player.getAccessLevel().getLevel() >= FULL_GM
				|| Config.ATTR_ENCHANT_CHANCE >= _random.nextInt(100) + 1) {
			player.sendPackets(new S_ServerMessage(161, weapon.getLogName(),
					"$245", "$247"));
			int newLevel = sameElement ? currentLevel + 1 : 1;
			weapon.setAttrEnchantKind(newElement);
			inventory.updateItem(weapon, L1PcInventory.COL_ATTR_ENCHANT_KIND);
			inventory.saveItem(weapon, L1PcInventory.COL_ATTR_ENCHANT_KIND);
			weapon.setAttrEnchantLevel(newLevel);
			inventory.updateItem(weapon, L1PcInventory.COL_ATTR_ENCHANT_LEVEL);
			inventory.saveItem(weapon, L1PcInventory.COL_ATTR_ENCHANT_LEVEL);
		} else {
			player.sendPackets(CantEnchant);
		}
		inventory.removeItem(scroll, 1);
	}

	public static void enchantAccessory(final L1PcInstance player,
			final L1ItemInstance scroll, final L1ItemInstance accessory) {
		if (!Config.ACCESSORY_ENCHANTING) {
			player.sendPackets(new S_SystemMessage(
					"Accessory enchanting is disabled on this server."));
			return;
		}

		if (accessory == null) {
			player.sendPackets(CantEnchant);
			return;
		}
		L1Item accessoryBase = accessory.getItem();

		if (accessory.getBless() >= 128 || accessoryBase.getType2() != 2
				|| accessoryBase.getType() < 8 || accessoryBase.getType() > 12
				|| accessoryBase.getGrade() == -1) {
			player.sendPackets(CantEnchant);
			return;
		}

		int level = accessory.getEnchantLevel();

		if (level < 0 || level >= Config.ACCESSORY_ENCHANT_LIMIT) {
			player.sendPackets(CantEnchant);
			return;
		}

		// Roughly +0-85% ~ +9-40%
		int chance = (50 + level) / (level + 1) + 35;

		if (!(player.isGm() && player.getAccessLevel().getLevel() >= FULL_GM)
				&& _random.nextInt(100) + 1 > chance) {
			failureEnchant(player, accessory);
			player.getInventory().removeItem(scroll, 1);
			return;
		}

		int itemStatus = 0;
		boolean award = level > 0 && level % 5 == 0;

		switch (accessoryBase.getGrade()) {
		case 0:
			accessory.setEarthResist(accessory.getEarthResist() + 2);
			itemStatus += L1PcInventory.COL_EARTHMR;
			accessory.setFireResist(accessory.getFireResist() + 2);
			itemStatus += L1PcInventory.COL_FIREMR;
			accessory.setWaterResist(accessory.getWaterResist() + 2);
			itemStatus += L1PcInventory.COL_WATERMR;
			accessory.setWindResist(accessory.getWindResist() + 2);
			itemStatus += L1PcInventory.COL_WINDMR;
			if (award) {
				accessory.setAddHpRegen(accessory.getAddHpRegen() + 3);
				itemStatus += L1PcInventory.COL_HPR;
				accessory.setAddMpRegen(accessory.getAddMpRegen() + 3);
				itemStatus += L1PcInventory.COL_MPR;
			}
			if (accessory.isEquipped()) {
				player.addFire(2);
				player.addWater(2);
				player.addEarth(2);
				player.addWind(2);
			}
			break;
		case 1:
			accessory.setAddHp(accessory.getAddHp() + 5);
			itemStatus += L1PcInventory.COL_ADDHP;
			if (award) {
				accessory.setMagicResist(accessory.getMagicResist() + 5);
				itemStatus += L1PcInventory.COL_M_DEF;
			}
			if (accessory.isEquipped()) {
				player.addMaxHp(5);
				if (award) {
					player.addMr(5);
					player.sendPackets(new S_SPMR(player));
				}
			}
			break;
		case 2:
			accessory.setAddMp(accessory.getAddMp() + 5);
			itemStatus += L1PcInventory.COL_ADDMP;
			if (award) {
				accessory.setAddSpellpower(accessory.getAddSpellpower() + 1);
				itemStatus += L1PcInventory.COL_ADDSP;
			}
			if (accessory.isEquipped()) {
				player.addMaxMp(5);
				if (award) {
					player.addSp(1);
					player.sendPackets(new S_SPMR(player));
				}
			}
			break;
		default:
			player.sendPackets(CantEnchant);
			return;
		}
		successEnchant(player, accessory, 1);
		player.sendPackets(new S_ItemStatus(accessory));
		player.getInventory().saveEnchantAccessory(accessory, itemStatus);
		player.getInventory().removeItem(scroll, 1);
	}

	private static void failureEnchant(final L1PcInstance player,
			final L1ItemInstance item) {
		String name = item.getName();
		int enchantLevel = item.getEnchantLevel();
		String pm = enchantLevel > 0 ? "+" : "";
		String s = (!item.isIdentified() || enchantLevel == 0) ? name : pm
				+ enchantLevel + " " + name;
		int itemType = item.getItem().getType2();
		String sa = itemType == 1 ? "$245" : itemType == 2 ? " $252" : "";
		player.sendPackets(new S_ServerMessage(164, s, sa));
		player.getInventory().removeItem(item, item.getCount());
	}

	private static void successEnchant(final L1PcInstance player,
			final L1ItemInstance item, final int change) {
		L1Item baseItem = item.getItem();
		boolean isWeapon = baseItem.getType2() == 1;
		boolean isArmor = baseItem.getType2() == 2;

		if (!isArmor && !isWeapon) {
			_log.log(Level.WARNING, "Enchant: trying to enchant something"
					+ " besides a weapon or piece of armor.");
			return;
		}

		String itemName = item.getName();
		int enchantLevel = item.getEnchantLevel();
		String pm = enchantLevel > 0 ? "+" : "";
		String s = (!item.isIdentified() || item.getEnchantLevel() == 0) ? itemName
				: pm + item.getEnchantLevel() + " " + itemName;
		String sa = "";
		String sb = "";
		switch (change) {
		case -1:
			sa = "$246";
			sb = "$247";
			break;
		case 1:
			sa = isWeapon ? "$245" : "$252";
			sb = "$247";
			break;
		case 2:
		case 3:
			sa = isWeapon ? "$245" : "$252";
			sb = "$248";
		}
		player.sendPackets(new S_ServerMessage(161, s, sa, sb));

		int newEnchantLevel = enchantLevel + change;
		int safeEnchant = baseItem.get_safeenchant();
		item.setEnchantLevel(newEnchantLevel);
		final L1PcInventory inventory = player.getInventory();
		inventory.updateItem(item, L1PcInventory.COL_ENCHANTLVL);
		if (newEnchantLevel > safeEnchant) {
			inventory.saveItem(item, L1PcInventory.COL_ENCHANTLVL);
		}
		if (isWeapon && Config.LOGGING_WEAPON_ENCHANT != 0) {
			if (safeEnchant == 0
					|| newEnchantLevel >= Config.LOGGING_WEAPON_ENCHANT) {
				LogEnchantTable logenchant = new LogEnchantTable();
				logenchant.storeLogEnchant(player.getId(), item.getId(),
						enchantLevel, newEnchantLevel);
			}
		}
		if (isArmor && Config.LOGGING_ARMOR_ENCHANT != 0) {
			if (safeEnchant == 0
					|| newEnchantLevel >= Config.LOGGING_ARMOR_ENCHANT) {
				LogEnchantTable logenchant = new LogEnchantTable();
				logenchant.storeLogEnchant(player.getId(), item.getId(),
						enchantLevel, newEnchantLevel);
			}
		}

		if (isArmor && item.isEquipped()) {
			player.addAc(-change);
			int i2 = item.getItem().getItemId();
			if (i2 == 20011 || i2 == 20110 || i2 == 21108 || i2 == 120011) {
				player.addMr(change);
				player.sendPackets(new S_SPMR(player));
			}
			if (i2 == 20056 || i2 == 120056 || i2 == 220056) {
				player.addMr(change * 2);
				player.sendPackets(new S_SPMR(player));
			}
			player.sendPackets(new S_OwnCharStatus(player));
		}
	}

	private static int getEnchantChange(final L1ItemInstance item,
			final int scrollId) {
		if (scrollId == L1ItemId.C_SCROLL_OF_ENCHANT_ARMOR
				|| scrollId == L1ItemId.C_SCROLL_OF_ENCHANT_WEAPON)
			return -1;
		if (scrollId == L1ItemId.B_SCROLL_OF_ENCHANT_ARMOR
				|| scrollId == L1ItemId.B_SCROLL_OF_ENCHANT_WEAPON
				|| scrollId == 140129 || scrollId == 140130) {
			int enchantLevel = item.getEnchantLevel();
			int roll = _random.nextInt(100) + 1;
			if (enchantLevel <= 2) {
				return roll >= 77 ? 3 : roll >= 33 ? 2 : 1;
			} else if (enchantLevel >= 3 && enchantLevel <= 5) {
				return roll < 50 ? 2 : 1;
			}
		}
		return 1;
	}

	public static void enchantIvoryTowerWeapon(final L1PcInstance player,
			final L1ItemInstance scroll, final L1ItemInstance weapon) {
		if (weapon == null || weapon.getItem().getType2() != 1
				|| weapon.getBless() >= 128) {
			player.sendPackets(CantEnchant);
			return;
		}

		int weaponId = weapon.getItem().getItemId();

		if (!IntArrays.sContains(IvoryTowerWeapons, weaponId)) {
			player.sendPackets(CantEnchant);
			return;
		}

		int safeEnchant = weapon.getItem().get_safeenchant();
		if (weapon.getEnchantLevel() < safeEnchant) {
			player.getInventory().removeItem(scroll, 1);
			successEnchant(player, weapon, 1);
		} else {
			player.sendPackets(CantEnchant);
		}
	}

	public static void enchantIvoryTowerArmor(final L1PcInstance player,
			final L1ItemInstance scroll, final L1ItemInstance armor) {
		
		if (armor == null) {
			player.sendPackets(CantEnchant);
			return;
		}
		int armorId = armor.getItem().getItemId();
		if (armor.getItem().getType2() != 2
				|| armor.getBless() >= 128) {
			player.sendPackets(CantEnchant);
			return;
		}

		if (!IntArrays.sContains(IvoryTowerArmor, armorId)) {
			player.sendPackets(CantEnchant);
			return;
		}

		int safeEnchant = armor.getItem().get_safeenchant();
		if (armor.getEnchantLevel() < safeEnchant) {
			player.getInventory().removeItem(scroll, 1);
			successEnchant(player, armor, 1);
		} else {
			player.sendPackets(CantEnchant);
		}
	}

	private static boolean scrollMatchesWeapon(final int weaponId,
			final int scrollId) {
		if (IntArrays.sContains(IvoryTowerWeapons, weaponId))
			return false;

		if (weaponId >= 246 && weaponId <= 249)
			return scrollId == L1ItemId.SCROLL_OF_ENCHANT_QUEST_WEAPON;

		if (scrollId == L1ItemId.SCROLL_OF_ENCHANT_QUEST_WEAPON)
			return weaponId >= 246 && weaponId <= 249;

		if (weaponId == 183 || (weaponId >= 250 && weaponId <= 255))
			return scrollId == L1ItemId.SCROLL_OF_ENCHANT_WEAPON_ILLUSION;

		if (scrollId == L1ItemId.SCROLL_OF_ENCHANT_WEAPON_ILLUSION)
			return weaponId == 183 || (weaponId >= 150 && weaponId <= 255);

		return true;
	}

	private static boolean scrollMatchesArmor(final int armorId,
			final int scrollId) {
		if (IntArrays.sContains(IvoryTowerArmor, armorId))
			return false;

		if (armorId == 20161 || (armorId >= 21035 && armorId <= 21038)) {
			return scrollId == L1ItemId.SCROLL_OF_ENCHANT_ARMOR_ILLUSION;
		}
		if (scrollId == L1ItemId.SCROLL_OF_ENCHANT_ARMOR_ILLUSION) {
			return armorId == 20161 || (armorId >= 21035 && armorId <= 21038);
		}

		return true;
	}

	public static void enchantWeapon(final L1PcInstance player,
			final L1ItemInstance scroll, final L1ItemInstance weapon) {
		
		if (weapon == null) {
			player.sendPackets(CantEnchant);
			return;
		}
		int scrollId = scroll.getItem().getItemId();
		int safeEnchant = weapon.getItem().get_safeenchant();
		int weaponId = weapon.getItem().getItemId();

		if (weapon.getItem().getType2() != 1
				|| safeEnchant < 0 || weapon.getBless() >= 128) {
			player.sendPackets(CantEnchant);
			return;
		}

		if (!scrollMatchesWeapon(weaponId, scrollId)) {
			player.sendPackets(CantEnchant);
			return;
		}

		int enchantLevel = weapon.getEnchantLevel();

		Result result = player.isGm() && player.getAccessLevel().getLevel() >= FULL_GM
				? Result.Success
				: enchantWeapon(scrollId, enchantLevel, safeEnchant);
		player.getInventory().removeItem(scroll, 1);
		switch (result) {
		case Success:
			successEnchant(player, weapon, getEnchantChange(weapon, scrollId));
			break;
		case Unchanged:
			player.sendPackets(new S_ServerMessage(160, weapon.getLogName(),
					"$245", "$248"));
			break;
		case Failure:
			failureEnchant(player, weapon);
			break;
		default:
			// Not actually possible.
		}
	}

	private static Result enchantWeapon(final int scrollId,
			final int enchantLevel, final int safeEnchant) {
		if (scrollId == L1ItemId.C_SCROLL_OF_ENCHANT_WEAPON)
			return enchantLevel > -7 ? Result.Success : Result.Failure;
		if (enchantLevel < safeEnchant)
			return Result.Success;
		int roll = _random.nextInt(100) + 1;
		int divisor = enchantLevel >= 9 ? 6 : 3;
		int enchantChance = (100 + 3 + Config.ENCHANT_CHANCE_WEAPON) / divisor;
		return roll < enchantChance ? Result.Success : roll < enchantChance * 2
				&& enchantLevel >= 9 ? Result.Unchanged : Result.Failure;
	}

	public static void enchantArmor(final L1PcInstance player,
			final L1ItemInstance scroll, final L1ItemInstance armor) {
		int scrollId = scroll.getItem().getItemId();
		if (armor == null) {
			player.sendPackets(CantEnchant);
			return;
		}
		int safeEnchant = armor.getItem().get_safeenchant();
		int armorId = armor.getItem().getItemId();
		if (armor.getItem().getType2() != 2 || safeEnchant < 0
				|| armor.getBless() >= 128) {
			player.sendPackets(CantEnchant);
			return;
		}

		if (!scrollMatchesArmor(armorId, scrollId)) {
			player.sendPackets(CantEnchant);
			return;
		}

		int enchantLevel = armor.getEnchantLevel();
		Result result = player.isGm() && player.getAccessLevel().getLevel() >= FULL_GM
				? Result.Success
				: enchantArmor(scrollId, enchantLevel, safeEnchant);
		player.getInventory().removeItem(scroll, 1);
		switch (result) {
		case Success:
			successEnchant(player, armor, getEnchantChange(armor, scrollId));
			break;
		case Unchanged:
			player.sendPackets(new S_ServerMessage(160, armor.getLogName(),
					"$252", "$248"));
			break;
		case Failure:
			failureEnchant(player, armor);
			break;
		default:
			// Can't actually get here.
		}
	}

	private static Result enchantArmor(final int scrollId,
			final int enchantLevel, final int safeEnchant) {
		if (scrollId == L1ItemId.C_SCROLL_OF_ENCHANT_ARMOR)
			return enchantLevel > -7 ? Result.Success : Result.Failure;
		if (enchantLevel < safeEnchant)
			return Result.Success;
		int roll = _random.nextInt(100) + 1;
		int divisor = safeEnchant == 0 ? enchantLevel + 2 : enchantLevel;
		int enchantChance = (100 + divisor * Config.ENCHANT_CHANCE_ARMOR)
				/ (enchantLevel >= 9 ? divisor * 2 : divisor);
		return roll < enchantChance ? Result.Success : roll < enchantChance * 2
				&& enchantLevel >= 9 ? Result.Unchanged : Result.Failure;
	}
}
