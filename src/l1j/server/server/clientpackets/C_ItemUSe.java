/**
 * GPLv2. See License.
 */
package l1j.server.server.clientpackets;

import static l1j.server.server.model.item.L1ItemId.B_ELVEN_WAFER;
import static l1j.server.server.model.item.L1ItemId.B_POTION_OF_EMOTION_BRAVERY;
import static l1j.server.server.model.item.L1ItemId.B_POTION_OF_EMOTION_WISDOM;
import static l1j.server.server.model.item.L1ItemId.B_POTION_OF_EXTRA_HEALING;
import static l1j.server.server.model.item.L1ItemId.B_POTION_OF_GREATER_HEALING;
import static l1j.server.server.model.item.L1ItemId.B_POTION_OF_HASTE_SELF;
import static l1j.server.server.model.item.L1ItemId.B_POTION_OF_HEALING;
import static l1j.server.server.model.item.L1ItemId.B_POTION_OF_MANA;
import static l1j.server.server.model.item.L1ItemId.B_SCROLL_OF_ENCHANT_ARMOR;
import static l1j.server.server.model.item.L1ItemId.B_SCROLL_OF_ENCHANT_WEAPON;
import static l1j.server.server.model.item.L1ItemId.B_SCROLL_OF_POLYMORPH;
import static l1j.server.server.model.item.L1ItemId.CONDENSED_POTION_OF_EXTRA_HEALING;
import static l1j.server.server.model.item.L1ItemId.CONDENSED_POTION_OF_GREATER_HEALING;
import static l1j.server.server.model.item.L1ItemId.CONDENSED_POTION_OF_HEALING;
import static l1j.server.server.model.item.L1ItemId.C_POTION_OF_HEALING;
import static l1j.server.server.model.item.L1ItemId.C_SCROLL_OF_ENCHANT_ARMOR;
import static l1j.server.server.model.item.L1ItemId.C_SCROLL_OF_ENCHANT_WEAPON;
import static l1j.server.server.model.item.L1ItemId.DEVILS_BLOOD;
import static l1j.server.server.model.item.L1ItemId.ELVEN_WAFER;
import static l1j.server.server.model.item.L1ItemId.FORBIDDEN_FRUIT;
import static l1j.server.server.model.item.L1ItemId.IT_SCROLL_OF_POLYMORPH;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_BLINDNESS;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_CURE_POISON;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_EMOTION_BRAVERY;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_EMOTION_WISDOM;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_EXTRA_HEALING;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_GREATER_HEALING;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_HASTE_SELF;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_HEALING;
import static l1j.server.server.model.item.L1ItemId.POTION_OF_MANA;
import static l1j.server.server.model.item.L1ItemId.SCROLL_OF_ENCHANT_ARMOR;
import static l1j.server.server.model.item.L1ItemId.SCROLL_OF_ENCHANT_QUEST_WEAPON;
import static l1j.server.server.model.item.L1ItemId.SCROLL_OF_ENCHANT_WEAPON;
import static l1j.server.server.model.item.L1ItemId.SCROLL_OF_POLYMORPH;
import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.AWAKEN_ANTHARAS;
import static l1j.server.server.model.skill.L1SkillId.AWAKEN_FAFURION;
import static l1j.server.server.model.skill.L1SkillId.AWAKEN_VALAKAS;
import static l1j.server.server.model.skill.L1SkillId.BLOODLUST;
import static l1j.server.server.model.skill.L1SkillId.COOKING_NOW;
import static l1j.server.server.model.skill.L1SkillId.CURSE_BLIND;
import static l1j.server.server.model.skill.L1SkillId.DARKNESS;
import static l1j.server.server.model.skill.L1SkillId.DECAY_POTION;
import static l1j.server.server.model.skill.L1SkillId.ENTANGLE;
import static l1j.server.server.model.skill.L1SkillId.GREATER_HASTE;
import static l1j.server.server.model.skill.L1SkillId.HASTE;
import static l1j.server.server.model.skill.L1SkillId.HOLY_WALK;
import static l1j.server.server.model.skill.L1SkillId.MASS_SLOW;
import static l1j.server.server.model.skill.L1SkillId.MOVING_ACCELERATION;
import static l1j.server.server.model.skill.L1SkillId.POLLUTE_WATER;
import static l1j.server.server.model.skill.L1SkillId.SHAPE_CHANGE;
import static l1j.server.server.model.skill.L1SkillId.SLOW;
import static l1j.server.server.model.skill.L1SkillId.SOLID_CARRIAGE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_BLUE_POTION;
import static l1j.server.server.model.skill.L1SkillId.STATUS_BRAVE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_ELFBRAVE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_FLOATING_EYE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HASTE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_MITHRIL_POWDER;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_WATER;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HOLY_WATER_OF_EVA;
import static l1j.server.server.model.skill.L1SkillId.STATUS_RIBRAVE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_UNDERWATER_BREATH;
import static l1j.server.server.model.skill.L1SkillId.STATUS_WISDOM_POTION;
import static l1j.server.server.model.skill.L1SkillId.WIND_WALK;

import java.lang.reflect.Constructor;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.ActionCodes;
import l1j.server.server.ClientThread;
import l1j.server.server.controllers.FishingTimeController;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.FurnitureSpawnTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.LetterTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.ResolventTable;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.Enchant;
import l1j.server.server.model.Getback;
import l1j.server.server.model.L1Attribute;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1Cooking;
import l1j.server.server.model.L1EffectSpawn;
import l1j.server.server.model.L1HouseLocation;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1ItemDelay;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1Quest;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1TownLocation;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1EffectInstance;
import l1j.server.server.model.Instance.L1FurnitureInstance;
import l1j.server.server.model.Instance.L1GuardianInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1TowerInstance;
import l1j.server.server.model.item.L1TreasureBox;
import l1j.server.server.model.poison.L1DamagePoison;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_AddSkill;
import l1j.server.server.serverpackets.S_AttackPacket;
import l1j.server.server.serverpackets.S_CurseBlind;
import l1j.server.server.serverpackets.S_Fishing;
import l1j.server.server.serverpackets.S_IdentifyDesc;
import l1j.server.server.serverpackets.S_ItemName;
import l1j.server.server.serverpackets.S_Letter;
import l1j.server.server.serverpackets.S_Liquor;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_OwnCharStatus2;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_Paralysis;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_ShowPolyList;
import l1j.server.server.serverpackets.S_SkillBrave;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillIconBlessOfEva;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SkillIconWisdomPotion;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_Sound;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_UseAttackSkill;
import l1j.server.server.serverpackets.S_UseMap;
import l1j.server.server.storage.CharactersItemStorage;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.templates.L1EtcItem;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Skill;
import l1j.server.server.types.Point;
import l1j.server.server.utils.L1SpawnUtil;
import l1j.server.server.utils.collections.IntArrays;

public class C_ItemUSe extends ClientBasePacket {
	private static final String C_ITEM_USE = "[C] C_ItemUSe";
	private static Logger _log = Logger.getLogger(C_ItemUSe.class.getName());
	private static Random _random = new Random();

	public C_ItemUSe(byte abyte0[], ClientThread client) throws Exception {
		super(abyte0);
		int itemObjid = readD();

		L1PcInstance pc = client.getActiveChar();
		if (pc.isGhost()) {
			return;
		}
		L1ItemInstance l1iteminstance = pc.getInventory().getItem(itemObjid);

		if (l1iteminstance == null && pc.isDead()) {
			return;
		}
		if (l1iteminstance.getItem().getUseType() == -1) { // none
			pc.sendPackets(new S_ServerMessage(74, l1iteminstance.getLogName())); // You cannot use 'item'.
			return;
		}
		int pcObjid = pc.getId();
		if (pc.isTeleport()) {
			return;
		}

		if (!pc.getMap().isUsableItem()) {
			pc.sendPackets(new S_ServerMessage(563)); // You can't use it here.
			return;
		}
		int itemId;
		try {
			itemId = l1iteminstance.getItem().getItemId();
		} catch (Exception e) {
			return;
		}
		int l = 0;

		String s = "";
		//unused
		//int bmapid = 0;
		int btele = 0;
		int blanksc_skillid = 0;
		int spellsc_objid = 0;
		int spellsc_x = 0;
		int spellsc_y = 0;
		int resid = 0;
		int letterCode = 0;
		String letterReceiver = "";
		byte[] letterText = null;
		int cookStatus = 0;
		int cookNo = 0;
		int fishX = 0;
		int fishY = 0;

		L1PcInventory inventory = pc.getInventory();

		int use_type = l1iteminstance.getItem().getUseType();
		if (itemId == 40088 || itemId == 40096 || itemId == 140088) {
			s = readS();
		} else if (itemId == SCROLL_OF_ENCHANT_ARMOR
				|| itemId == SCROLL_OF_ENCHANT_WEAPON
				|| itemId == SCROLL_OF_ENCHANT_QUEST_WEAPON || itemId == 40077
				|| itemId == 40078 || itemId == 40126 || itemId == 40098
				|| itemId == 40129 || itemId == 40130 || itemId == 140129
				|| itemId == 140130 || itemId == B_SCROLL_OF_ENCHANT_ARMOR
				|| itemId == B_SCROLL_OF_ENCHANT_WEAPON
				|| itemId == C_SCROLL_OF_ENCHANT_ARMOR
				|| itemId == C_SCROLL_OF_ENCHANT_WEAPON || itemId == 41029
				|| itemId == 40317 || itemId == 41036 || itemId == 41245
				|| itemId == 40127 || itemId == 40128 || itemId == 41048
				|| itemId == 41049 || itemId == 41050 || itemId == 41051
				|| itemId == 41052 || itemId == 41053 || itemId == 41054
				|| itemId == 41055 || itemId == 41056 || itemId == 41057
				|| itemId == 40925 || itemId == 40926 || itemId == 40927
				|| itemId == 40928 || itemId == 40929 || itemId == 40931
				|| itemId == 40932 || itemId == 40933 || itemId == 40934
				|| itemId == 40935 || itemId == 40936 || itemId == 40937
				|| itemId == 40938 || itemId == 40939 || itemId == 40940
				|| itemId == 40941 || itemId == 40942 || itemId == 40943
				|| itemId == 40944 || itemId == 40945 || itemId == 40946
				|| itemId == 40947 || itemId == 40948 || itemId == 40949
				|| itemId == 40950 || itemId == 40951 || itemId == 40952
				|| itemId == 40953 || itemId == 40954 || itemId == 40955
				|| itemId == 40956 || itemId == 40957 || itemId == 40958
				|| itemId == 40964 || itemId == 49092 || itemId == 41426
				|| itemId == 41427 || itemId == 40075 || itemId == 41429
				|| itemId == 41430 || itemId == 41431 || itemId == 41432
				|| itemId == 49148) {
			l = readD();
		} else if (itemId == 140100 || itemId == 40100 || itemId == 40099
				|| itemId == 40086 || itemId == 40863) {
			/*
			 * Unused, but leaving the readH() because I think this needs to be
			 * ran to process the packet.  I could be wrong.
			 */
			//bmapid = readH();
			readH();
			btele = readD();
			pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_TELEPORT_UNLOCK,
					false));
		} else if (itemId == 40090 || itemId == 40091 || itemId == 40092
				|| itemId == 40093 || itemId == 40094) {
			blanksc_skillid = readC();
		} else if (use_type == 30 || itemId == 40870 || itemId == 40879) { // spell_buff
			spellsc_objid = readD();
		} else if (use_type == 5 || use_type == 17) { // spell_long //
														// spell_short
			spellsc_objid = readD();
			spellsc_x = readH();
			spellsc_y = readH();
		} else if (itemId == 40089 || itemId == 140089) {
			resid = readD();
		} else if (itemId == 40310 || itemId == 40311 || itemId == 40730
				|| itemId == 40731 || itemId == 40732) {
			letterCode = readH();
			letterReceiver = readS();
			letterText = readByte();
		} else if (itemId >= 41255 && itemId <= 41259) {
			cookStatus = readC();
			cookNo = readC();
		} else if (itemId == 41293 || itemId == 41294) {
			fishX = readH();
			fishY = readH();
		} else {
			l = readC();
		}

		if (pc.getCurrentHp() <= 0)
			return;

		int delay_id = 0;
		if (l1iteminstance.getItem().getType2() == 0) {
			delay_id = ((L1EtcItem) l1iteminstance.getItem()).get_delayid();
		}
		if (delay_id != 0) {
			if (pc.hasItemDelay(delay_id) == true) {
				return;
			}
		}

		boolean isDelayEffect = false;
		if (l1iteminstance.getItem().getType2() == 0) {
			int delayEffect = ((L1EtcItem) l1iteminstance.getItem())
					.get_delayEffect();
			if (delayEffect > 0) {
				isDelayEffect = true;
				Timestamp lastUsed = l1iteminstance.getLastUsed();
				if (lastUsed != null) {
					Calendar cal = Calendar.getInstance();
					if ((cal.getTimeInMillis() - lastUsed.getTime()) / 1000 <= delayEffect) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						return;
					}
				}
			}
		}

		L1ItemInstance l1iteminstance1 = inventory.getItem(l);
		_log.finest("request item use (obj) = " + itemObjid + " action = " + l
				+ " value = " + s);
		if (itemId == 40077 || itemId == SCROLL_OF_ENCHANT_WEAPON
				|| itemId == SCROLL_OF_ENCHANT_QUEST_WEAPON || itemId == 40130
				|| itemId == 140130 || itemId == B_SCROLL_OF_ENCHANT_WEAPON
				|| itemId == C_SCROLL_OF_ENCHANT_WEAPON || itemId == 40128) {
			Enchant.enchantWeapon(pc, l1iteminstance, l1iteminstance1);
		} else if (itemId == 41429 || itemId == 41430 || itemId == 41431
				|| itemId == 41432) {
			Enchant.elementEnchant(pc, l1iteminstance, l1iteminstance1);
		} else if (itemId == 40078 || itemId == SCROLL_OF_ENCHANT_ARMOR
				|| itemId == 40129 || itemId == 140129
				|| itemId == B_SCROLL_OF_ENCHANT_ARMOR
				|| itemId == C_SCROLL_OF_ENCHANT_ARMOR || itemId == 40127) {
			Enchant.enchantArmor(pc, l1iteminstance, l1iteminstance1);
		} else if (itemId == 49311) {
			Enchant.enchantIvoryTowerArmor(pc, l1iteminstance, l1iteminstance1);
		} else if (itemId == 49312) {
			Enchant.enchantIvoryTowerWeapon(pc, l1iteminstance, l1iteminstance1);
		} else if (itemId == 49148) {
			Enchant.enchantAccessory(pc, l1iteminstance, l1iteminstance1);
		} else if (l1iteminstance.getItem().getType2() == 0) {
			L1Item template = l1iteminstance.getItem();

			int minLvl = template.getMinLevel();
			int maxLvl = template.getMaxLevel();
			if (minLvl != 0 && minLvl > pc.getLevel() && !pc.isGm()) {
				pc.sendPackets(new S_ServerMessage(318, String.valueOf(minLvl))); // You have to be at least level 'x' to use this item.
				return;
			} else if (maxLvl != 0 && maxLvl < pc.getLevel() && !pc.isGm()) {
				pc.sendPackets(new S_ServerMessage(673, String.valueOf(maxLvl))); // You have to be level 'x' or less to use this item.
				return;
			}

			if ((itemId == 40576 && !pc.isElf())
					|| (itemId == 40577 && !pc.isWizard())
					|| (itemId == 40578 && !pc.isKnight())) {
				pc.sendPackets(new S_ServerMessage(264)); // Your class can't use this item.
				return;
			}

			if (template.getType() == 0) {
				inventory.setArrow(template.getItemId());
				pc.sendPackets(new S_ServerMessage(452, l1iteminstance
						.getLogName())); // 'item' was selected.
			} else if (template.getType() == 15) {
				inventory.setSting(template.getItemId());
				pc.sendPackets(new S_ServerMessage(452, l1iteminstance
						.getLogName())); // 'item' was selected.
			} else if (template.getType() == 16) { // treasure_box
				L1TreasureBox box = L1TreasureBox.get(itemId);

				if (box != null) {
					if (box.open(pc)) {
						L1EtcItem temp = (L1EtcItem) l1iteminstance.getItem();
						if (temp.get_delayEffect() > 0) {
							isDelayEffect = true;
						} else {
							inventory.removeItem(l1iteminstance.getId(), 1);
						}
					}
				}
			} else if (template.getType() == 2) { //
				if (l1iteminstance.getRemainingTime() <= 0 && itemId != 40004) {
					return;
				}
				if (l1iteminstance.isNowLighting()) {
					l1iteminstance.setNowLighting(false);
					pc.turnOnOffLight();
				} else {
					l1iteminstance.setNowLighting(true);
					pc.turnOnOffLight();
				}
				pc.sendPackets(new S_ItemName(l1iteminstance));
			} else if (itemId == 40003) { //
				for (L1ItemInstance lightItem : inventory.getItems()) {
					if (lightItem.getItem().getItemId() == 40002) {
						lightItem.setRemainingTime(l1iteminstance.getItem()
								.getLightFuel());
						pc.sendPackets(new S_ItemName(lightItem));
						pc.sendPackets(new S_ServerMessage(230)); // You refilled your lantern with the oil.
						break;
					}
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 43000) { //
				pc.setExp(1);
				pc.resetLevel();
				pc.setBonusStats(0);
				pc.sendPackets(new S_SkillSound(pcObjid, 191));
				pc.broadcastPacket(new S_SkillSound(pcObjid, 191));
				pc.sendPackets(new S_OwnCharStatus(pc));
				inventory.removeItem(l1iteminstance, 1);
				pc.sendPackets(new S_ServerMessage(822)); // You feel an unknown energy appear from a deep place in your body.
				pc.save();
			} else if (itemId == 40033 || itemId == 40034 || itemId == 40035
					|| itemId == 40036 || itemId == 40037 || itemId == 40038) {
				useElixir(pc, itemId, l1iteminstance);
			} else if (itemId == POTION_OF_HEALING
					|| itemId == CONDENSED_POTION_OF_HEALING || itemId == 40029) {
				UseHealingPotion(pc, 15, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40022) {
				UseHealingPotion(pc, 20, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == POTION_OF_EXTRA_HEALING
					|| itemId == CONDENSED_POTION_OF_EXTRA_HEALING) {
				UseHealingPotion(pc, 45, 194);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40023) {
				UseHealingPotion(pc, 30, 194);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == POTION_OF_GREATER_HEALING
					|| itemId == CONDENSED_POTION_OF_GREATER_HEALING) {
				UseHealingPotion(pc, 75, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40024) {
				UseHealingPotion(pc, 55, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40506) {
				UseHealingPotion(pc, 70, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40026 || itemId == 40027 || itemId == 40028) {
				UseHealingPotion(pc, 25, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40058) {
				UseHealingPotion(pc, 30, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40071) {
				UseHealingPotion(pc, 70, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40734) {
				UseHealingPotion(pc, 50, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == B_POTION_OF_HEALING) {
				UseHealingPotion(pc, 25, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == C_POTION_OF_HEALING) {
				UseHealingPotion(pc, 10, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == B_POTION_OF_EXTRA_HEALING) {
				UseHealingPotion(pc, 55, 194);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == B_POTION_OF_GREATER_HEALING) {
				UseHealingPotion(pc, 85, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 140506) {
				UseHealingPotion(pc, 80, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40043) {
				UseHealingPotion(pc, 600, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41403) {
				UseHealingPotion(pc, 300, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId >= 41417 && itemId <= 41421) { //
				UseHealingPotion(pc, 90, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41337) { // jp
				UseHealingPotion(pc, 85, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40858) { // liquor
				pc.setDrink(true);
				pc.sendPackets(new S_Liquor(pc.getId()));
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == POTION_OF_CURE_POISON || itemId == 40507) {
				if (pc.hasSkillEffect(DECAY_POTION) == true) {
					pc.sendPackets(new S_ServerMessage(698)); // Are you sure you want to delete 'item'?  (Y/N)
				} else {
					cancelAbsoluteBarrier(pc);
					pc.sendPackets(new S_SkillSound(pc.getId(), 192));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 192));
					if (itemId == POTION_OF_CURE_POISON) {
						inventory.removeItem(l1iteminstance, 1);
					} else if (itemId == 40507) {
						inventory.removeItem(l1iteminstance, 1);
					}

					pc.curePoison();
				}
			} else if (itemId == POTION_OF_HASTE_SELF
					|| itemId == B_POTION_OF_HASTE_SELF || itemId == 40018
					|| itemId == 140018 || itemId == 40039 || itemId == 40040
					|| itemId == 40030 || itemId == 41338 || itemId == 41261
					|| itemId == 41262 || itemId == 41268 || itemId == 41269
					|| itemId == 41271 || itemId == 41272 || itemId == 41273
					|| itemId == 41342) {
				useGreenPotion(pc, itemId);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == POTION_OF_EMOTION_BRAVERY
					|| itemId == B_POTION_OF_EMOTION_BRAVERY || itemId == 41415) {
				if (pc.isKnight()) {
					useBravePotion(pc, itemId);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == FORBIDDEN_FRUIT) {
				if (pc.isDragonKnight() || pc.isIllusionist()) {
					useBravePotion(pc, itemId);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == ELVEN_WAFER || itemId == B_ELVEN_WAFER) {
				if (pc.isElf()) {
					useBravePotion(pc, itemId);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == DEVILS_BLOOD) {
				if (pc.isCrown()) {
					useBravePotion(pc, itemId);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40733) {
				useBravePotion(pc, itemId);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40066 || itemId == 41413) {
				pc.sendPackets(new S_ServerMessage(338, "$1084")); // Your 'MP' is recovering.
				pc.setCurrentMp(pc.getCurrentMp() + (7 + _random.nextInt(6))); // 7~12
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40067 || itemId == 41414) {
				pc.sendPackets(new S_ServerMessage(338, "$1084")); // Your 'MP' is recovering.
				pc.setCurrentMp(pc.getCurrentMp() + (15 + _random.nextInt(16))); // 15~30
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40735) {
				pc.sendPackets(new S_ServerMessage(338, "$1084")); // Your 'MP' is recovering.
				pc.setCurrentMp(pc.getCurrentMp() + 60);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40042) {
				pc.sendPackets(new S_ServerMessage(338, "$1084")); // Your 'MP' is recovering.
				pc.setCurrentMp(pc.getCurrentMp() + 50);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41404) {
				pc.sendPackets(new S_ServerMessage(338, "$1084")); // Your 'MP' is recovering.
				pc.setCurrentMp(pc.getCurrentMp() + (80 + _random.nextInt(21))); // 80~100
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41412) {
				pc.sendPackets(new S_ServerMessage(338, "$1084")); // Your 'MP' is recovering.
				pc.setCurrentMp(pc.getCurrentMp() + (5 + _random.nextInt(16))); // 5~20
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40032 || itemId == 40041 || itemId == 41344) {
				useBlessOfEva(pc, itemId);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == POTION_OF_MANA || itemId == B_POTION_OF_MANA
					|| itemId == 40736) {
				useBluePotion(pc, itemId);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == POTION_OF_EMOTION_WISDOM
					|| itemId == B_POTION_OF_EMOTION_WISDOM) {
				if (pc.isWizard()) {
					useWisdomPotion(pc, itemId);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happaned.
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == POTION_OF_BLINDNESS) {
				useBlindPotion(pc);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == SCROLL_OF_POLYMORPH
					|| itemId == IT_SCROLL_OF_POLYMORPH
					|| itemId == B_SCROLL_OF_POLYMORPH) {
				if (usePolyScroll(pc, itemId, s)) {
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(181)); // You cannot polymorph into that monster.
				}
			} else if (itemId == 41154 || itemId == 41155 || itemId == 41156
					|| itemId == 41157 || itemId == 49220) {
				usePolyScale(pc, itemId);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 240101) { // SuperDk
				useSuperDKScroll(pc, itemId);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41143 || itemId == 41144 || itemId == 41145
					|| itemId == 49149 || itemId == 49150 || itemId == 49151
					|| itemId == 49152 || itemId == 49153 || itemId == 49154
					|| itemId == 49155) {
				usePolyPotion(pc, itemId);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40317) {
				if (l1iteminstance1.getItem().getType2() != 0
						&& l1iteminstance1.get_durability() > 0) {
					String msg0;
					inventory.recoveryDamage(l1iteminstance1);
					msg0 = l1iteminstance1.getLogName();
					if (l1iteminstance1.get_durability() == 0) {
						pc.sendPackets(new S_ServerMessage(464, msg0)); // 'item' is as good as new now.
					} else {
						pc.sendPackets(new S_ServerMessage(463, msg0)); //'item`s' condition got better.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40097 || itemId == 40119 || itemId == 140119
					|| itemId == 140329) {
				for (L1ItemInstance eachItem : inventory.getItems()) {
					if (eachItem.getItem().getBless() != 2
							&& eachItem.getItem().getBless() != 130) {
						continue;
					}
					if (!eachItem.isEquipped()
							&& (itemId == 40119 || itemId == 40097)) {
						continue;
					}
					int id_normal = eachItem.getItemId() - 200000;
					L1Item normal = ItemTable.getInstance().getTemplate(
							id_normal);
					if (template == null) {
						continue;
					}
					if (inventory.checkItem(id_normal) && normal.isStackable()) {
						inventory.storeItem(id_normal, eachItem.getCount());
						inventory.removeItem(eachItem, eachItem.getCount());
					} else {
						eachItem.setItem(normal);
						eachItem.setBless(normal.getBless());
						inventory
								.updateItem(eachItem, L1PcInventory.COL_ITEMID);
						inventory.saveItem(eachItem, L1PcInventory.COL_ITEMID);
					}
				}
				inventory.removeItem(l1iteminstance, 1);
				pc.sendPackets(new S_ServerMessage(155)); // You feel like someone is helping you.
			} else if (itemId == 40126 || itemId == 40098) {
				if (!l1iteminstance1.isIdentified()) {
					l1iteminstance1.setIdentified(true);
					inventory.updateItem(l1iteminstance1,
							L1PcInventory.COL_IS_ID);
				}
				pc.sendPackets(new S_IdentifyDesc(l1iteminstance1));
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41036) {
				int diaryId = l1iteminstance1.getItem().getItemId();
				if (diaryId >= 41038 && 41047 >= diaryId) {
					if ((_random.nextInt(99) + 1) <= Config.CREATE_CHANCE_DIARY) {
						createNewItem(pc, diaryId + 10, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(158, l1iteminstance1
								.getName())); // Your 'item' evaporates.
					}
					inventory.removeItem(l1iteminstance1, 1);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId >= 41048 && 41055 >= itemId) {
				int logbookId = l1iteminstance1.getItem().getItemId();
				if (logbookId == (itemId + 8034)) {
					createNewItem(pc, logbookId + 2, 1);
					inventory.removeItem(l1iteminstance1, 1);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 41056 || itemId == 41057) {
				int logbookId = l1iteminstance1.getItem().getItemId();
				if (logbookId == (itemId + 8034)) {
					createNewItem(pc, 41058, 1);
					inventory.removeItem(l1iteminstance1, 1);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40925) {
				int earingId = l1iteminstance1.getItem().getItemId();
				;
				if (earingId >= 40987 && 40989 >= earingId) {
					if (_random.nextInt(100) < Config.CREATE_CHANCE_RECOLLECTION) {
						createNewItem(pc, earingId + 186, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(158, l1iteminstance1
								.getName())); // Your 'item' evaporates.
					}
					inventory.removeItem(l1iteminstance1, 1);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId >= 40926 && 40929 >= itemId) {
				int earing2Id = l1iteminstance1.getItem().getItemId();
				;
				int potion1 = 0;
				int potion2 = 0;
				if (earing2Id >= 41173 && 41184 >= earing2Id) {
					if (itemId == 40926) {
						potion1 = 247;
						potion2 = 249;
					} else if (itemId == 40927) {
						potion1 = 249;
						potion2 = 251;
					} else if (itemId == 40928) {
						potion1 = 251;
						potion2 = 253;
					} else if (itemId == 40929) {
						potion1 = 253;
						potion2 = 255;
					}
					if (earing2Id >= (itemId + potion1)
							&& (itemId + potion2) >= earing2Id) {
						if ((_random.nextInt(99) + 1) < Config.CREATE_CHANCE_MYSTERIOUS) {
							createNewItem(pc, (earing2Id - 12), 1);
							inventory.removeItem(l1iteminstance1, 1);
							inventory.removeItem(l1iteminstance, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(160, // Your 'item' violently glows %1 for %2 and nothing happens.
									l1iteminstance1.getName()));
							inventory.removeItem(l1iteminstance, 1);
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId >= 40931 && 40942 >= itemId) {
				int earing3Id = l1iteminstance1.getItem().getItemId();
				;
				int earinglevel = 0;
				if (earing3Id >= 41161 && 41172 >= earing3Id) {
					if (earing3Id == (itemId + 230)) {
						if ((_random.nextInt(99) + 1) < Config.CREATE_CHANCE_PROCESSING) {
							if (earing3Id == 41161) {
								earinglevel = 21014;
							} else if (earing3Id == 41162) {
								earinglevel = 21006;
							} else if (earing3Id == 41163) {
								earinglevel = 21007;
							} else if (earing3Id == 41164) {
								earinglevel = 21015;
							} else if (earing3Id == 41165) {
								earinglevel = 21009;
							} else if (earing3Id == 41166) {
								earinglevel = 21008;
							} else if (earing3Id == 41167) {
								earinglevel = 21016;
							} else if (earing3Id == 41168) {
								earinglevel = 21012;
							} else if (earing3Id == 41169) {
								earinglevel = 21010;
							} else if (earing3Id == 41170) {
								earinglevel = 21017;
							} else if (earing3Id == 41171) {
								earinglevel = 21013;
							} else if (earing3Id == 41172) {
								earinglevel = 21011;
							}
							createNewItem(pc, earinglevel, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(158,
									l1iteminstance1.getName())); // Your 'item' evaporates.
						}
						inventory.removeItem(l1iteminstance1, 1);
						inventory.removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId >= 40943 && 40958 >= itemId) {
				int ringId = l1iteminstance1.getItem().getItemId();
				int ringlevel = 0;
				int gmas = 0;
				int gmam = 0;
				if (ringId >= 41185 && 41200 >= ringId) {
					if (itemId == 40943 || itemId == 40947 || itemId == 40951
							|| itemId == 40955) {
						gmas = 443;
						gmam = 447;
					} else if (itemId == 40944 || itemId == 40948
							|| itemId == 40952 || itemId == 40956) {
						gmas = 442;
						gmam = 446;
					} else if (itemId == 40945 || itemId == 40949
							|| itemId == 40953 || itemId == 40957) {
						gmas = 441;
						gmam = 445;
					} else if (itemId == 40946 || itemId == 40950
							|| itemId == 40954 || itemId == 40958) {
						gmas = 444;
						gmam = 448;
					}
					if (ringId == (itemId + 242)) {
						if ((_random.nextInt(99) + 1) < Config.CREATE_CHANCE_PROCESSING_DIAMOND) {
							if (ringId == 41185) {
								ringlevel = 20435;
							} else if (ringId == 41186) {
								ringlevel = 20436;
							} else if (ringId == 41187) {
								ringlevel = 20437;
							} else if (ringId == 41188) {
								ringlevel = 20438;
							} else if (ringId == 41189) {
								ringlevel = 20439;
							} else if (ringId == 41190) {
								ringlevel = 20440;
							} else if (ringId == 41191) {
								ringlevel = 20441;
							} else if (ringId == 41192) {
								ringlevel = 20442;
							} else if (ringId == 41193) {
								ringlevel = 20443;
							} else if (ringId == 41194) {
								ringlevel = 20444;
							} else if (ringId == 41195) {
								ringlevel = 20445;
							} else if (ringId == 41196) {
								ringlevel = 20446;
							} else if (ringId == 41197) {
								ringlevel = 20447;
							} else if (ringId == 41198) {
								ringlevel = 20448;
							} else if (ringId == 41199) {
								ringlevel = 20449;
							} else if (ringId == 411200) {
								ringlevel = 20450;
							}
							pc.sendPackets(new S_ServerMessage(gmas,
									l1iteminstance1.getName()));
							createNewItem(pc, ringlevel, 1);
							inventory.removeItem(l1iteminstance1, 1);
							inventory.removeItem(l1iteminstance, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(gmam,
									l1iteminstance.getName()));
							inventory.removeItem(l1iteminstance, 1);
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 41029) {
				int dantesId = l1iteminstance1.getItem().getItemId();
				if (dantesId >= 41030 && 41034 >= dantesId) {
					if ((_random.nextInt(99) + 1) < Config.CREATE_CHANCE_DANTES) {
						createNewItem(pc, dantesId + 1, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(158, l1iteminstance1
								.getName())); // Your 'item' evaporates.
					}
					inventory.removeItem(l1iteminstance1, 1);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40964) {
				int historybookId = l1iteminstance1.getItem().getItemId();
				if (historybookId >= 41011 && 41018 >= historybookId) {
					if ((_random.nextInt(99) + 1) <= Config.CREATE_CHANCE_HISTORY_BOOK) {
						createNewItem(pc, historybookId + 8, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(158, l1iteminstance1
								.getName()));
					}
					inventory.removeItem(l1iteminstance1, 1);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40090 || itemId == 40091 || itemId == 40092
					|| itemId == 40093 || itemId == 40094) {
				if (pc.isWizard()) {
					writeScroll(pc, itemId, blanksc_skillid);
				} else {
					pc.sendPackets(new S_ServerMessage(264)); // Your class can't use this item.
				}
			} else if ((itemId >= 40859 && itemId <= 40898) && itemId != 40863
					|| itemId >= 49281 && itemId <= 49286) { // 40863
				if (spellsc_objid == pc.getId() && template.getUseType() != 30) { // spell_buff
					pc.sendPackets(new S_ServerMessage(281)); // The spell failed.
					return;
				}
				inventory.removeItem(l1iteminstance, 1);
				if (spellsc_objid == 0
						&& l1iteminstance.getItem().getUseType() != 0
						&& l1iteminstance.getItem().getUseType() != 26
						&& l1iteminstance.getItem().getUseType() != 27) {
					return;
				}
				cancelAbsoluteBarrier(pc);
				int skillid = itemId - 40858;
				if (itemId == 49281) {
					skillid = 42;
				} else if (itemId == 49282) {
					skillid = 48;
				} else if (itemId == 49283) {
					skillid = 49;
				} else if (itemId == 49284) {
					skillid = 52;
					return;
				} else if (itemId == 49285) {
					skillid = 54;
				} else if (itemId == 49286) {
					skillid = 57;
				}
				L1SkillUse l1skilluse = new L1SkillUse();
				l1skilluse.handleCommands(client.getActiveChar(), skillid,
						spellsc_objid, spellsc_x, spellsc_y, null, 0,
						L1SkillUse.TYPE_SPELLSC);
			} else if (itemId >= 40373 && itemId <= 40382 || itemId >= 40385
					&& itemId <= 40390) {
				pc.sendPackets(new S_UseMap(pc, l1iteminstance.getId(),
						template.getItemId()));
			} else if (itemId == 40310 || itemId == 40730 || itemId == 40731
					|| itemId == 40732) {
				if (writeLetter(itemId, pc, letterCode, letterReceiver,
						letterText)) {
					inventory.removeItem(l1iteminstance, 1);
				}
			} else if (itemId == 40311) {
				if (writeClanLetter(itemId, pc, letterCode, letterReceiver,
						letterText)) {
					inventory.removeItem(l1iteminstance, 1);
				}
			} else if (itemId == 49016 || itemId == 49018 || itemId == 49020
					|| itemId == 49022 || itemId == 49024) {
				pc.sendPackets(new S_Letter(l1iteminstance));
				l1iteminstance.setItemId(itemId + 1);
				inventory.updateItem(l1iteminstance, L1PcInventory.COL_ITEMID);
				inventory.saveItem(l1iteminstance, L1PcInventory.COL_ITEMID);
			} else if (itemId == 49017 || itemId == 49019 || itemId == 49021
					|| itemId == 49023 || itemId == 49025) {
				pc.sendPackets(new S_Letter(l1iteminstance));
			} else if (itemId == 40314 || itemId == 40316) {
				if (inventory.checkItem(41160)) {
					if (withdrawPet(pc, itemObjid)) {
						inventory.consumeItem(41160, 1);
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40315) {
				pc.sendPackets(new S_Sound(437));
				pc.broadcastPacket(new S_Sound(437));
				Object[] petList = pc.getPetList().values().toArray();
				for (Object petObject : petList) {
					if (petObject instanceof L1PetInstance) {
						L1PetInstance pet = (L1PetInstance) petObject;
						pet.call();
					}
				}
			} else if (itemId == 40493) { // Magic Flute
				pc.sendPackets(new S_Sound(165));
				pc.broadcastPacket(new S_Sound(165));
				for (L1Object visible : pc.getKnownObjects()) {
					if (visible instanceof L1GuardianInstance) {
						L1GuardianInstance guardian = (L1GuardianInstance) visible;
						if (guardian.getNpcTemplate().get_npcId() == 70850) {
							if (createNewItem(pc, 88, 1)) {
								inventory.removeItem(l1iteminstance, 1);
							}
						}
					}
				}
			} else if (itemId == 40325) { // 2 Faced Dice
				if (inventory.checkItem(40318, 1)) {
					int gfxid = 3237 + _random.nextInt(2);
					pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
					inventory.consumeItem(40318, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40326) {
				if (inventory.checkItem(40318, 1)) {
					int gfxid = 3229 + _random.nextInt(3);
					pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
					inventory.consumeItem(40318, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40327) {
				if (inventory.checkItem(40318, 1)) {
					int gfxid = 3241 + _random.nextInt(4);
					pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
					inventory.consumeItem(40318, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40328) {
				if (inventory.checkItem(40318, 1)) {
					int gfxid = 3204 + _random.nextInt(6);
					pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
					inventory.consumeItem(40318, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40089 || itemId == 140089) {
				L1Character resobject = (L1Character) L1World.getInstance()
						.findObject(resid);
				if (resobject != null) {
					if (resobject instanceof L1PcInstance) {
						L1PcInstance target = (L1PcInstance) resobject;
						if (pc.getId() == target.getId()) {
							return;
						}
						if (L1World.getInstance().getVisiblePlayer(target, 0)
								.size() > 0) {
							for (L1PcInstance visiblePc : L1World.getInstance()
									.getVisiblePlayer(target, 0)) {
								if (!visiblePc.isDead()) {
									pc.sendPackets(new S_ServerMessage(592)); // Your attempt at resurrection has failed because the location is occupied by someone else.
									return;
								}
							}
						}
						if (target.getCurrentHp() == 0
								&& target.isDead() == true) {
							if (pc.getMap().isUseResurrection()) {
								target.setTempID(pc.getId());
								if (itemId == 40089) {
									target.sendPackets(new S_Message_YN(321, ""));
								} else if (itemId == 140089) {
									target.sendPackets(new S_Message_YN(322, ""));
								}
							} else {
								return;
							}
						}
					} else if (resobject instanceof L1NpcInstance) {
						if (!(resobject instanceof L1TowerInstance)) {
							L1NpcInstance npc = (L1NpcInstance) resobject;
							if (npc.getNpcTemplate().isCantResurrect()
									&& !(npc instanceof L1PetInstance)) {
								inventory.removeItem(l1iteminstance, 1);
								return;
							}
							if (npc instanceof L1PetInstance
									&& L1World.getInstance()
											.getVisiblePlayer(npc, 0).size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(npc, 0)) {
									if (!visiblePc.isDead()) {
										pc.sendPackets(new S_ServerMessage(592)); // Your attempt at resurrection has failed because the location is occupied by someone else.
										return;
									}
								}
							}
							if (npc.getCurrentHp() == 0 && npc.isDead()) {
								npc.resurrect(npc.getMaxHp() / 4);
								npc.setResurrect(true);
							}
						}
					}
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId > 40169 && itemId < 40226 || itemId >= 45000
					&& itemId <= 45022) {
				useSpellBook(pc, l1iteminstance, itemId);
			} else if (itemId > 40225 && itemId < 40232) {
				if (pc.isCrown() || pc.isGm()) {
					if (itemId == 40226 && pc.getLevel() >= 15) {
						SpellBook4(pc, l1iteminstance, client);
					} else if (itemId == 40228 && pc.getLevel() >= 30) {
						SpellBook4(pc, l1iteminstance, client);
					} else if (itemId == 40227 && pc.getLevel() >= 40) {
						SpellBook4(pc, l1iteminstance, client);
					} else if ((itemId == 40231 || itemId == 40232)
							&& pc.getLevel() >= 45) {
						SpellBook4(pc, l1iteminstance, client);
					} else if (itemId == 40230 && pc.getLevel() >= 50) {
						SpellBook4(pc, l1iteminstance, client);
					} else if (itemId == 40229 && pc.getLevel() >= 55) {
						SpellBook4(pc, l1iteminstance, client);
					} else {
						pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId >= 40232 && itemId <= 40264 //
					|| itemId >= 41149 && itemId <= 41153 || itemId == 50001) { // Added
																				// NM
																				// elf
																				// crystal.
																				// Do
																				// not
																				// remove.
				useElfSpellBook(pc, l1iteminstance, itemId);
			} else if (itemId > 40264 && itemId < 40280) {
				if (pc.isDarkelf() || pc.isGm()) {
					if (itemId >= 40265 && itemId <= 40269
							&& pc.getLevel() >= 15) {
						SpellBook1(pc, l1iteminstance, client);
					} else if (itemId >= 40270 && itemId <= 40274
							&& pc.getLevel() >= 30) {
						SpellBook1(pc, l1iteminstance, client);
					} else if (itemId >= 40275 && itemId <= 40279
							&& pc.getLevel() >= 45) {
						SpellBook1(pc, l1iteminstance, client);
					} else {
						pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId >= 40164 && itemId <= 40166 || itemId >= 41147
					&& itemId <= 41148) {
				if (pc.isKnight() || pc.isGm()) {
					if (itemId >= 40164 && itemId <= 40165
							&& pc.getLevel() >= 50) {
						SpellBook3(pc, l1iteminstance, client);
					} else if (itemId >= 41147 && itemId <= 41148
							&& pc.getLevel() >= 50) {
						SpellBook3(pc, l1iteminstance, client);
					} else if (itemId == 40166 && pc.getLevel() >= 60) {
						SpellBook3(pc, l1iteminstance, client);
					} else {
						pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId >= 49102 && itemId <= 49116) {
				if (pc.isDragonKnight() || pc.isGm()) {
					if (itemId >= 49102 && itemId <= 49106
							&& pc.getLevel() >= 15) {
						SpellBook5(pc, l1iteminstance, client);
					} else if (itemId >= 49107 && itemId <= 49111
							&& pc.getLevel() >= 30) {
						SpellBook5(pc, l1iteminstance, client);
					} else if (itemId >= 49112 && itemId <= 49116
							&& pc.getLevel() >= 45) {
						SpellBook5(pc, l1iteminstance, client);
					} else {
						pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId >= 49117 && itemId <= 49136) {
				if (pc.isIllusionist() || pc.isGm()) {
					if (itemId >= 49117 && itemId <= 49121
							&& pc.getLevel() >= 10) {
						SpellBook6(pc, l1iteminstance, client);
					} else if (itemId >= 49122 && itemId <= 49126
							&& pc.getLevel() >= 20) {
						SpellBook6(pc, l1iteminstance, client);
					} else if (itemId >= 49127 && itemId <= 49131
							&& pc.getLevel() >= 30) {
						SpellBook6(pc, l1iteminstance, client);
					} else if (itemId >= 49132 && itemId <= 49136
							&& pc.getLevel() >= 40) {
						SpellBook6(pc, l1iteminstance, client);
					} else {
						pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40079 || itemId == 40095) {
				if (pc.getMap().isEscapable() || pc.isGm()) {
					int[] loc = Getback.GetBack_Location(pc, true);
					L1Teleport.teleport(pc, loc[0], loc[1], (short) loc[2], 5,
							true);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(647)); // You cannot teleport in this location.
					// pc.sendPackets(new
					// S_CharVisualUpdate(pc));
				}
				cancelAbsoluteBarrier(pc);
			} else if (itemId == 40124) { // bp return scroll
				if (pc.getMap().isEscapable() || pc.isGm()) {
					int castle_id = 0;
					int house_id = 0;
					if (pc.getClanid() != 0) {
						L1Clan clan = L1World.getInstance().getClan(
								pc.getClanname());
						if (clan != null) {
							castle_id = clan.getCastleId();
							house_id = clan.getHouseId();
						}
					}
					if (castle_id != 0) {
						if (pc.getMap().isEscapable() || pc.isGm()) {
							int[] loc = new int[3];
							loc = L1CastleLocation.getCastleLoc(castle_id);
							int locx = loc[0];
							int locy = loc[1];
							short mapid = (short) (loc[2]);
							L1Teleport.teleport(pc, locx, locy, mapid, 5, true);
							inventory.removeItem(l1iteminstance, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(647)); // You cannot teleport in this location.
						}
					} else if (house_id != 0) {
						if (pc.getMap().isEscapable() || pc.isGm()) {
							int[] loc = new int[3];
							loc = L1HouseLocation.getHouseLoc(house_id);
							int locx = loc[0];
							int locy = loc[1];
							short mapid = (short) (loc[2]);
							L1Teleport.teleport(pc, locx, locy, mapid, 5, true);
							inventory.removeItem(l1iteminstance, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(647)); // You cannot teleport in this location.
						}
					} else {
						if (pc.getHomeTownId() > 0) {
							int[] loc = L1TownLocation.getGetBackLoc(pc
									.getHomeTownId());
							int locx = loc[0];
							int locy = loc[1];
							short mapid = (short) (loc[2]);
							L1Teleport.teleport(pc, locx, locy, mapid, 5, true);
							inventory.removeItem(l1iteminstance, 1);
						} else {
							int[] loc = Getback.GetBack_Location(pc, true);
							L1Teleport.teleport(pc, loc[0], loc[1],
									(short) loc[2], 5, true);
							inventory.removeItem(l1iteminstance, 1);
						}
					}
				} else {
					pc.sendPackets(new S_ServerMessage(647)); // You cannot teleport in this location.
				}
				cancelAbsoluteBarrier(pc);
			} else if (itemId == 140100 || itemId == 40100 // btele, ntele
					|| itemId == 40099 // it tele scroll
					|| itemId == 40086 || itemId == 40863) { // mass tele
																// scroll, lasta
																// scroll?
				L1BookMark bookm = pc.getBookMark(btele);
				if (bookm != null) {
					if (pc.getMap().isEscapable() || pc.isGm()) {
						int newX = bookm.getLocX();
						int newY = bookm.getLocY();
						short mapId = bookm.getMapId();

						if (itemId == 40086) {
							for (L1PcInstance member : L1World.getInstance()
									.getVisiblePlayer(pc)) {
								if (pc.getLocation().getTileLineDistance(
										member.getLocation()) <= 3
										&& member.getClanid() == pc.getClanid()
										&& pc.getClanid() != 0
										&& member.getId() != pc.getId()) {
									L1Teleport.teleport(member, newX, newY,
											mapId, 5, true);
								}
							}
						}
						L1Teleport.teleport(pc, newX, newY, mapId, 5, true);
						inventory.removeItem(l1iteminstance, 1);
					} else {
						L1Teleport.teleport(pc, pc.getX(), pc.getY(),
								pc.getMapId(), pc.getHeading(), false);
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					}
				} else {
					if (pc.getMap().isTeleportable() || pc.isGm()) {
						L1Location newLocation = pc.getLocation()
								.randomLocation(200, true);
						int newX = newLocation.getX();
						int newY = newLocation.getY();
						short mapId = (short) newLocation.getMapId();

						if (itemId == 40086) {
							for (L1PcInstance member : L1World.getInstance()
									.getVisiblePlayer(pc)) {
								if (pc.getLocation().getTileLineDistance(
										member.getLocation()) <= 3
										&& member.getClanid() == pc.getClanid()
										&& pc.getClanid() != 0
										&& member.getId() != pc.getId()) {
									L1Teleport.teleport(member, newX, newY,
											mapId, 5, true);
								}
							}
						}
						L1Teleport.teleport(pc, newX, newY, mapId, 5, true);
						inventory.removeItem(l1iteminstance, 1);
					} else {
						L1Teleport.teleport(pc, pc.getX(), pc.getY(),
								pc.getMapId(), pc.getHeading(), false);
						pc.sendPackets(new S_ServerMessage(276)); // You can't randomly teleport here.
					}
					cancelAbsoluteBarrier(pc);
				}
			} else if (itemId == 240100) {
				L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc.getMapId(),
						pc.getHeading(), true);
				inventory.removeItem(l1iteminstance, 1);
				cancelAbsoluteBarrier(pc);
			} else if (itemId >= 40080 && itemId <= 40085 || itemId >= 40101
					&& itemId <= 40118 || itemId >= 40120 && itemId <= 40123
					|| itemId == 40125 || itemId >= 40801 && itemId <= 40898
					|| itemId >= 42001 && itemId <= 42033 || itemId >= 42035
					&& itemId <= 42100) { // various return scrolls
				if (pc.getMap().isEscapable() || pc.isGm()) {
					L1Teleport.teleport(pc,
							((L1EtcItem) l1iteminstance.getItem()).get_locx(),
							((L1EtcItem) template).get_locy(),
							((L1EtcItem) template).get_mapid(), 5, true);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(647)); // You cannot teleport in this location.
				}
				cancelAbsoluteBarrier(pc);
			} else if (itemId >= 40901 && itemId <= 40908) { // silver ring,
																// wedding ring
				L1PcInstance partner = null;
				boolean partner_stat = false;
				if (pc.getPartnerId() != 0) {
					partner = (L1PcInstance) L1World.getInstance().findObject(
							pc.getPartnerId());
					if (partner != null && partner.getPartnerId() != 0
							&& pc.getPartnerId() == partner.getId()
							&& partner.getPartnerId() == pc.getId()) {
						partner_stat = true;
					}
				} else {
					pc.sendPackets(new S_ServerMessage(662)); // You are not married.
					return;
				}

				if (partner_stat) {
					boolean castle_area = L1CastleLocation.checkInAllWarArea(
							partner.getX(), partner.getY(), partner.getMapId());
					// TODO: original would work if players' map locations
					// were updated properly.
					if ((partner.getMapId() == 0 || partner.getMapId() == 4 || partner
							.getMapId() == 304)
							&& castle_area == false
							&& pc.getMap().isEscapable()) {
						L1Teleport.teleport(pc, partner.getX(), partner.getY(),
								partner.getMapId(), 5, true);
					} else {
						pc.sendPackets(new S_ServerMessage(547)); // Your partner is playing in an area that you can't go.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(546)); // Your partner is not playing the game now.
				}
			} else if (itemId == 40555) { // Secret Room Key
				if (pc.isKnight() && (pc.getX() >= 32806 && pc.getX() <= 32814)
						&& (pc.getY() >= 32798 && pc.getY() <= 32807)
						&& pc.getMapId() == 13) {
					short mapid = 13;
					L1Teleport.teleport(pc, 32815, 32810, mapid, 5, false);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40417) { // pi crystal
				if ((pc.getX() >= 32665 && pc.getX() <= 32674)
						&& (pc.getY() >= 32976 && pc.getY() <= 32985)
						&& pc.getMapId() == 440) {
					short mapid = 430;
					L1Teleport.teleport(pc, 32922, 32812, mapid, 5, true);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40566) {
				if (pc.isElf() && (pc.getX() >= 33971 && pc.getX() <= 33975)
						&& (pc.getY() >= 32324 && pc.getY() <= 32328)
						&& pc.getMapId() == 4 && !inventory.checkItem(40548)) {
					boolean found = false;
					for (L1Object obj : L1World.getInstance().getObject()) {
						if (obj instanceof L1MonsterInstance) {
							L1MonsterInstance mob = (L1MonsterInstance) obj;
							if (mob != null) {
								if (mob.getNpcTemplate().get_npcId() == 45300) {
									found = true;
									break;
								}
							}
						}
					}
					if (found) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					} else {
						L1SpawnUtil.spawn(pc, 45300, 0, 0);
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40557) {
				if (pc.getX() == 32620 && pc.getY() == 32641
						&& pc.getMapId() == 4) {
					for (L1Object object : L1World.getInstance().getObject()) {
						if (object instanceof L1NpcInstance) {
							L1NpcInstance npc = (L1NpcInstance) object;
							if (npc.getNpcTemplate().get_npcId() == 45883) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
								return;
							}
						}
					}
					L1SpawnUtil.spawn(pc, 45883, 0, 300000);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40563) { //
				if (pc.getX() == 32730 && pc.getY() == 32426
						&& pc.getMapId() == 4) {
					for (L1Object object : L1World.getInstance().getObject()) {
						if (object instanceof L1NpcInstance) {
							L1NpcInstance npc = (L1NpcInstance) object;
							if (npc.getNpcTemplate().get_npcId() == 45884) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
								return;
							}
						}
					}
					L1SpawnUtil.spawn(pc, 45884, 0, 300000);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40561) { //
				if (pc.getX() == 33046 && pc.getY() == 32806
						&& pc.getMapId() == 4) {
					for (L1Object object : L1World.getInstance().getObject()) {
						if (object instanceof L1NpcInstance) {
							L1NpcInstance npc = (L1NpcInstance) object;
							if (npc.getNpcTemplate().get_npcId() == 45885) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
								return;
							}
						}
					}
					L1SpawnUtil.spawn(pc, 45885, 0, 300000);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40560) { //
				if (pc.getX() == 32580 && pc.getY() == 33260
						&& pc.getMapId() == 4) {
					for (L1Object object : L1World.getInstance().getObject()) {
						if (object instanceof L1NpcInstance) {
							L1NpcInstance npc = (L1NpcInstance) object;
							if (npc.getNpcTemplate().get_npcId() == 45886) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
								return;
							}
						}
					}
					L1SpawnUtil.spawn(pc, 45886, 0, 300000);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40562) { //
				if (pc.getX() == 33447 && pc.getY() == 33476
						&& pc.getMapId() == 4) {
					for (L1Object object : L1World.getInstance().getObject()) {
						if (object instanceof L1NpcInstance) {
							L1NpcInstance npc = (L1NpcInstance) object;
							if (npc.getNpcTemplate().get_npcId() == 45887) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
								return;
							}
						}
					}
					L1SpawnUtil.spawn(pc, 45887, 0, 300000);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40559) { //
				if (pc.getX() == 34215 && pc.getY() == 33195
						&& pc.getMapId() == 4) {
					for (L1Object object : L1World.getInstance().getObject()) {
						if (object instanceof L1NpcInstance) {
							L1NpcInstance npc = (L1NpcInstance) object;
							if (npc.getNpcTemplate().get_npcId() == 45888) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
								return;
							}
						}
					}
					L1SpawnUtil.spawn(pc, 45888, 0, 300000);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40558) {
				if (pc.getX() == 33513 && pc.getY() == 32890
						&& pc.getMapId() == 4) {
					for (L1Object object : L1World.getInstance().getObject()) {
						if (object instanceof L1NpcInstance) {
							L1NpcInstance npc = (L1NpcInstance) object;
							if (npc.getNpcTemplate().get_npcId() == 45889) {
								pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
								return;
							}
						}
					}
					L1SpawnUtil.spawn(pc, 45889, 0, 300000);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40572) { //
				if (pc.getX() == 32778 && pc.getY() == 32738
						&& pc.getMapId() == 21) {
					L1Teleport.teleport(pc, 32781, 32728, (short) 21, 5, true);
				} else if (pc.getX() == 32781 && pc.getY() == 32728
						&& pc.getMapId() == 21) {
					L1Teleport.teleport(pc, 32778, 32738, (short) 21, 5, true);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40006 || itemId == 40412 || itemId == 140006) {
				if (pc.getMap().isUsePainwand()) {
					S_AttackPacket s_attackPacket = new S_AttackPacket(pc, 0,
							ActionCodes.ACTION_Wand);
					pc.sendPackets(s_attackPacket);
					pc.broadcastPacket(s_attackPacket);
					int chargeCount = l1iteminstance.getChargeCount();
					if (chargeCount <= 0 && itemId != 40412) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						return;
					}
					int[] mobArray = { 45008, 45140, 45016, 45021, 45025,
							45033, 45099, 45147, 45123, 45130, 45046, 45092,
							45138, 45098, 45127, 45143, 45149, 45171, 45040,
							45155, 45192, 45173, 45213, 45079, 45144 };
					int rnd = _random.nextInt(mobArray.length);
					L1SpawnUtil.spawn(pc, mobArray[rnd], 0, 300000);
					if (itemId == 40006 || itemId == 140006) {
						l1iteminstance.setChargeCount(l1iteminstance
								.getChargeCount() - 1);
						inventory.updateItem(l1iteminstance,
								L1PcInventory.COL_CHARGE_COUNT);
					} else {
						inventory.removeItem(l1iteminstance, 1);
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40007) {
				cancelAbsoluteBarrier(pc);
				int chargeCount = l1iteminstance.getChargeCount();
				if (chargeCount <= 0) {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					return;
				}
				L1Object target = L1World.getInstance().findObject(
						spellsc_objid);
				pc.sendPackets(new S_UseAttackSkill(pc, spellsc_objid, 10,
						spellsc_x, spellsc_y, ActionCodes.ACTION_Wand));
				pc.broadcastPacket(new S_UseAttackSkill(pc, spellsc_objid, 10,
						spellsc_x, spellsc_y, ActionCodes.ACTION_Wand));
				if (target != null) {
					doWandAction(pc, target);
				}
				l1iteminstance
						.setChargeCount(l1iteminstance.getChargeCount() - 1);
				inventory.updateItem(l1iteminstance,
						L1PcInventory.COL_CHARGE_COUNT);
			} else if (itemId == 40008 || itemId == 40410 || itemId == 140008) {
				if (pc.getMapId() == 63 || pc.getMapId() == 552
						|| pc.getMapId() == 555 || pc.getMapId() == 557
						|| pc.getMapId() == 558 || pc.getMapId() == 779) {
					pc.sendPackets(new S_ServerMessage(563)); // You can't use it here.
				} else {
					pc.sendPackets(new S_AttackPacket(pc, 0,
							ActionCodes.ACTION_Wand));
					pc.broadcastPacket(new S_AttackPacket(pc, 0,
							ActionCodes.ACTION_Wand));
					int chargeCount = l1iteminstance.getChargeCount();
					if (chargeCount <= 0 && itemId != 40410
							|| pc.getTempCharGfx() == 6034
							|| pc.getTempCharGfx() == 6035) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						return;
					}
					L1Object target = L1World.getInstance().findObject(
							spellsc_objid);
					if (target != null) {
						L1Character cha = (L1Character) target;
						polyAction(pc, cha);
						cancelAbsoluteBarrier(pc);
						if (itemId == 40008 || itemId == 140008) {
							l1iteminstance.setChargeCount(l1iteminstance
									.getChargeCount() - 1);
							inventory.updateItem(l1iteminstance,
									L1PcInventory.COL_CHARGE_COUNT);
						} else {
							inventory.removeItem(l1iteminstance, 1);
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					}
				}
			} else if (itemId >= 40289 && itemId <= 40297) { // toi charms
				useToiTeleportAmulet(pc, itemId, l1iteminstance);
			} else if (itemId >= 40280 && itemId <= 40288) { // sealed toi
																// charms
				inventory.removeItem(l1iteminstance, 1);
				L1ItemInstance item = inventory.storeItem(itemId + 9, 1);
				if (item != null) {
					pc.sendPackets(new S_ServerMessage(403, item.getLogName())); // obtained 'item'.
				}
			} else if (itemId == 40056 || itemId == 40057 || itemId == 40059
					|| itemId == 40060 || itemId == 40061 || itemId == 40062
					|| itemId == 40063 || itemId == 40064 || itemId == 40065
					|| itemId == 40069 || itemId == 40072 || itemId == 40073
					|| itemId == 140061 || itemId == 140062 || itemId == 140065
					|| itemId == 140069 || itemId == 140072 || itemId == 41296
					|| itemId == 41297 || itemId == 41266 || itemId == 41267
					|| itemId == 41274 || itemId == 41275 || itemId == 41276
					|| itemId == 41252 || itemId == 49040 || itemId == 49041
					|| itemId == 49042 || itemId == 49043 || itemId == 49044
					|| itemId == 49045 || itemId == 49046 || itemId == 49047) {
				inventory.removeItem(l1iteminstance, 1);
				short foodvolume1 = (short) (l1iteminstance.getItem()
						.getFoodVolume() / 10);
				short foodvolume2 = 0;
				if (foodvolume1 <= 0) {
					foodvolume1 = 5;
				}
				if (pc.get_food() >= 225) {
					pc.sendPackets(new S_PacketBox(S_PacketBox.FOOD, (short) pc
							.get_food()));
				} else {
					foodvolume2 = (short) (pc.get_food() + foodvolume1);
					if (foodvolume2 <= 225) {
						pc.set_food(foodvolume2);
						pc.sendPackets(new S_PacketBox(S_PacketBox.FOOD,
								(short) pc.get_food()));
					} else {
						pc.set_food((short) 225);
						pc.sendPackets(new S_PacketBox(S_PacketBox.FOOD,
								(short) pc.get_food()));
					}
				}
				if (itemId == 40057) { // Floating Eye Meat
					pc.setSkillEffect(STATUS_FLOATING_EYE, 0);
				}
				pc.sendPackets(new S_ServerMessage(76, l1iteminstance.getItem()
						.getIdentifiedNameId())); // You ate 'item'.
			} else if (itemId == 40070) {
				pc.sendPackets(new S_ServerMessage(76, l1iteminstance
						.getLogName())); // You ate 'item'.
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41310) { // added for gold dragon
				pc.sendPackets(new S_ServerMessage(76, l1iteminstance
						.getLogName())); // You ate 'item'.
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41298) {
				UseHealingPotion(pc, 4, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41299) {
				UseHealingPotion(pc, 15, 194);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41300) {
				UseHealingPotion(pc, 35, 197);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41301) {
				int chance = _random.nextInt(10);
				if (chance >= 0 && chance < 5) {
					UseHealingPotion(pc, 15, 189);
				} else if (chance >= 5 && chance < 9) {
					createNewItem(pc, 40019, 1);
				} else if (chance >= 9) {
					int gemChance = _random.nextInt(3);
					if (gemChance == 0) {
						createNewItem(pc, 40045, 1);
					} else if (gemChance == 1) {
						createNewItem(pc, 40049, 1);
					} else if (gemChance == 2) {
						createNewItem(pc, 40053, 1);
					}
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41302) {
				int chance = _random.nextInt(3);
				if (chance >= 0 && chance < 5) {
					UseHealingPotion(pc, 15, 189);
				} else if (chance >= 5 && chance < 9) {
					createNewItem(pc, 40018, 1);
				} else if (chance >= 9) {
					int gemChance = _random.nextInt(3);
					if (gemChance == 0) {
						createNewItem(pc, 40047, 1);
					} else if (gemChance == 1) {
						createNewItem(pc, 40051, 1);
					} else if (gemChance == 2) {
						createNewItem(pc, 40055, 1);
					}
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41303) {
				int chance = _random.nextInt(3);
				if (chance >= 0 && chance < 5) {
					UseHealingPotion(pc, 15, 189);
				} else if (chance >= 5 && chance < 9) {
					createNewItem(pc, POTION_OF_MANA, 1);
				} else if (chance >= 9) {
					int gemChance = _random.nextInt(3);
					if (gemChance == 0) {
						createNewItem(pc, 40046, 1);
					} else if (gemChance == 1) {
						createNewItem(pc, 40050, 1);
					} else if (gemChance == 2) {
						createNewItem(pc, 40054, 1);
					}
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41304) {
				int chance = _random.nextInt(3);
				if (chance >= 0 && chance < 5) {
					UseHealingPotion(pc, 15, 189);
				} else if (chance >= 5 && chance < 9) {
					createNewItem(pc, 40021, 1);
				} else if (chance >= 9) {
					int gemChance = _random.nextInt(3);
					if (gemChance == 0) {
						createNewItem(pc, 40044, 1);
					} else if (gemChance == 1) {
						createNewItem(pc, 40048, 1);
					} else if (gemChance == 2) {
						createNewItem(pc, 40052, 1);
					}
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId >= 40136 && itemId <= 40161) {
				int soundid = 3198;
				if (itemId == 40154) {
					soundid = 3198;
				} else if (itemId == 40152) {
					soundid = 2031;
				} else if (itemId == 40141) {
					soundid = 2028;
				} else if (itemId == 40160) {
					soundid = 2030;
				} else if (itemId == 40145) {
					soundid = 2029;
				} else if (itemId == 40159) {
					soundid = 2033;
				} else if (itemId == 40151) {
					soundid = 2032;
				} else if (itemId == 40161) {
					soundid = 2037;
				} else if (itemId == 40142) {
					soundid = 2036;
				} else if (itemId == 40146) {
					soundid = 2039;
				} else if (itemId == 40148) {
					soundid = 2043;
				} else if (itemId == 40143) {
					soundid = 2041;
				} else if (itemId == 40156) {
					soundid = 2042;
				} else if (itemId == 40139) {
					soundid = 2040;
				} else if (itemId == 40137) {
					soundid = 2047;
				} else if (itemId == 40136) {
					soundid = 2046;
				} else if (itemId == 40138) {
					soundid = 2048;
				} else if (itemId == 40140) {
					soundid = 2051;
				} else if (itemId == 40144) {
					soundid = 2053;
				} else if (itemId == 40147) {
					soundid = 2045;
				} else if (itemId == 40149) {
					soundid = 2034;
				} else if (itemId == 40150) {
					soundid = 2055;
				} else if (itemId == 40153) {
					soundid = 2038;
				} else if (itemId == 40155) {
					soundid = 2044;
				} else if (itemId == 40157) {
					soundid = 2035;
				} else if (itemId == 40158) {
					soundid = 2049;
				} else {
					soundid = 3198;
				}
				S_SkillSound s_skillsound = new S_SkillSound(pc.getId(),
						soundid);
				pc.sendPackets(s_skillsound);
				pc.broadcastPacket(s_skillsound);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId >= 41357 && itemId <= 41382) {
				int soundid = itemId - 34946;
				S_SkillSound s_skillsound = new S_SkillSound(pc.getId(),
						soundid);
				pc.sendPackets(s_skillsound);
				pc.broadcastPacket(s_skillsound);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 40615) { // Key of Shadow Temple 2F
				if ((pc.getX() >= 32701 && pc.getX() <= 32705)
						&& (pc.getY() >= 32894 && pc.getY() <= 32898)
						&& pc.getMapId() == 522) { //
					L1Teleport.teleport(pc,
							((L1EtcItem) l1iteminstance.getItem()).get_locx(),
							((L1EtcItem) l1iteminstance.getItem()).get_locy(),
							((L1EtcItem) l1iteminstance.getItem()).get_mapid(),
							5, true);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40616 || itemId == 40782 || itemId == 40783) { // Key
																				// of
																				// Shadow
																				// Temple
																				// 3F
				if ((pc.getX() >= 32698 && pc.getX() <= 32702)
						&& (pc.getY() >= 32894 && pc.getY() <= 32898)
						&& pc.getMapId() == 523) {
					L1Teleport.teleport(pc,
							((L1EtcItem) l1iteminstance.getItem()).get_locx(),
							((L1EtcItem) l1iteminstance.getItem()).get_locy(),
							((L1EtcItem) l1iteminstance.getItem()).get_mapid(),
							5, true);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40692) { // item 436?
				if (inventory.checkItem(40621)) {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				} else if ((pc.getX() >= 32856 && pc.getX() <= 32858)
						&& (pc.getY() >= 32857 && pc.getY() <= 32858)
						&& pc.getMapId() == 443) {
					L1Teleport.teleport(pc,
							((L1EtcItem) l1iteminstance.getItem()).get_locx(),
							((L1EtcItem) l1iteminstance.getItem()).get_locy(),
							((L1EtcItem) l1iteminstance.getItem()).get_mapid(),
							5, true);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 41146) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei001"));
			} else if (itemId == 40641) { // Talking Scroll
				if (Config.ALT_TALKINGSCROLLQUEST == true) {
					if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 0) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrolla"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 1) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollb"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 2) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollc"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 3) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrolld"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 4) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrolle"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 5) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollf"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 6) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollg"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 7) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollh"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 8) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrolli"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 9) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollj"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 10) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollk"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 11) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrolll"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 12) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollm"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 13) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrolln"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 255) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"tscrollo"));
					}
				} else {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "tscrollp"));
				}
			} else if (itemId == 40383) { // Map: Singing Island
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei035"));
			} else if (itemId == 40384) { // Map: Hidden Valley
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei036"));
			} else if (itemId == 40101) { // Scroll of Return: Hidden Valley
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei037"));
			} else if (itemId == 41209) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei002"));
			} else if (itemId == 41210) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei003"));
			} else if (itemId == 41211) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei004"));
			} else if (itemId == 41212) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei005"));
			} else if (itemId == 41213) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei006"));
			} else if (itemId == 41214) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei012"));
			} else if (itemId == 41215) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei010"));
			} else if (itemId == 41216) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei011"));
			} else if (itemId == 41222) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei008"));
			} else if (itemId == 41223) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei007"));
			} else if (itemId == 41224) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei009"));
			} else if (itemId == 41225) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei013"));
			} else if (itemId == 41226) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei014"));
			} else if (itemId == 41227) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei033"));
			} else if (itemId == 41228) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei034"));
			} else if (itemId == 41229) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei025"));
			} else if (itemId == 41230) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei020"));
			} else if (itemId == 41231) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei021"));
			} else if (itemId == 41233) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei019"));
			} else if (itemId == 41234) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei023"));
			} else if (itemId == 41235) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei024"));
			} else if (itemId == 41236) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei026"));
			} else if (itemId == 41237) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei027"));
			} else if (itemId == 41239) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei018"));
			} else if (itemId == 41240) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei022"));
			} else if (itemId == 41060) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "nonames"));
			} else if (itemId == 41061) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "kames"));
			} else if (itemId == 41062) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "bakumos"));
			} else if (itemId == 41063) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "bukas"));
			} else if (itemId == 41064) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "huwoomos"));
			} else if (itemId == 41065) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "noas"));
			} else if (itemId == 41356) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "rparum3"));
			} else if (itemId == 40701) { //
				if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 1) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "firsttmap"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 2) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"secondtmapa"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 3) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"secondtmapb"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 4) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"secondtmapc"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 5) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "thirdtmapd"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 6) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "thirdtmape"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 7) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "thirdtmapf"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 8) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "thirdtmapg"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 9) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "thirdtmaph"));
				} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 10) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "thirdtmapi"));
				}
			} else if (itemId == 40663) { //
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "sonsletter"));
			} else if (itemId == 40630) { //
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "diegodiary"));
			} else if (itemId == 41340) { //
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "tion"));
			} else if (itemId == 41317) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "rarson"));
			} else if (itemId == 41318) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "kuen"));
			} else if (itemId == 41329) { //
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "anirequest"));
			} else if (itemId == 41346) { //
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "robinscroll"));
			} else if (itemId == 41347) { //
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "robinscroll2"));
			} else if (itemId == 41348) { //
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "robinhood"));
			} else if (itemId == 41007) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "erisscroll"));
			} else if (itemId == 41009) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "erisscroll2"));
			} else if (itemId == 41019) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "lashistory1"));
			} else if (itemId == 41020) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "lashistory2"));
			} else if (itemId == 41021) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "lashistory3"));
			} else if (itemId == 41022) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "lashistory4"));
			} else if (itemId == 41023) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "lashistory5"));
			} else if (itemId == 41024) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "lashistory6"));
			} else if (itemId == 41025) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "lashistory7"));
			} else if (itemId == 41026) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "lashistory8"));
			} else if (itemId == 41208) { //
				if ((pc.getX() >= 32844 && pc.getX() <= 32845)
						&& (pc.getY() >= 32693 && pc.getY() <= 32694)
						&& pc.getMapId() == 550) { //
					L1Teleport.teleport(pc,
							((L1EtcItem) l1iteminstance.getItem()).get_locx(),
							((L1EtcItem) l1iteminstance.getItem()).get_locy(),
							((L1EtcItem) l1iteminstance.getItem()).get_mapid(),
							5, true);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40700) { // Magic Flute
				pc.sendPackets(new S_Sound(10));
				pc.broadcastPacket(new S_Sound(10));
				if ((pc.getX() >= 32619 && pc.getX() <= 32623)
						&& (pc.getY() >= 33120 && pc.getY() <= 33124)
						&& pc.getMapId() == 440) {
					boolean found = false;
					for (L1Object obj : L1World.getInstance().getObject()) {
						if (obj instanceof L1MonsterInstance) {
							L1MonsterInstance mob = (L1MonsterInstance) obj;
							if (mob != null) {
								if (mob.getNpcTemplate().get_npcId() == 45875) {
									found = true;
									break;
								}
							}
						}
					}
					if (found) {
					} else {
						L1SpawnUtil.spawn(pc, 45875, 0, 0);
					}
				}
			} else if (itemId == 41121) {
				if (pc.getQuest().get_step(L1Quest.QUEST_SHADOWS) == L1Quest.QUEST_END
						|| inventory.checkItem(41122, 1)) {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				} else {
					createNewItem(pc, 41122, 1);
				}
			} else if (itemId == 41130) {
				if (pc.getQuest().get_step(L1Quest.QUEST_DESIRE) == L1Quest.QUEST_END
						|| inventory.checkItem(41131, 1)) {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				} else {
					createNewItem(pc, 41131, 1);
				}
			} else if (itemId == 42501) {
				if (pc.getCurrentMp() < 10) {
					pc.sendPackets(new S_ServerMessage(278)); // You don't have enough MP to use the spell.
					return;
				}
				pc.setCurrentMp(pc.getCurrentMp() - 10);
				// pc.sendPackets(new S_CantMove());
				L1Teleport.teleport(pc, spellsc_x, spellsc_y, pc.getMapId(),
						pc.getHeading(), true, L1Teleport.CHANGE_POSITION);
			} else if (itemId == 41293 || itemId == 41294) { //
				startFishing(pc, itemId, fishX, fishY);
			} else if (itemId == 41245) {
				useResolvent(pc, l1iteminstance1, l1iteminstance);
			} else if (itemId == 41248 || itemId == 41249 || itemId == 41250
					|| itemId == 49037 || itemId == 49038 || itemId == 49039) {
				useMagicDoll(pc, itemId, itemObjid);
			} else if (itemId >= 41255 && itemId <= 41259) {
				if (cookStatus == 0) {
					pc.sendPackets(new S_PacketBox(S_PacketBox.COOK_WINDOW,
							(itemId - 41255)));
				} else {
					makeCooking(pc, cookNo);
				}
			} else if (itemId == 41260) { // Firewood
				for (L1Object object : L1World.getInstance().getVisibleObjects(
						pc, 3)) {
					if (object instanceof L1EffectInstance) {
						if (((L1NpcInstance) object).getNpcTemplate()
								.get_npcId() == 81170) {
							pc.sendPackets(new S_ServerMessage(1162)); // There is a bonfire nearby already.
							return;
						}
					}
				}
				int[] loc = new int[2];
				loc = pc.getFrontLoc();
				L1EffectSpawn.getInstance().spawnEffect(81170, 600000, loc[0],
						loc[1], pc.getMapId());
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId >= 41277 && itemId <= 41292 || itemId >= 49049
					&& itemId <= 49064 || itemId >= 49244 && itemId <= 49259) {
				L1Cooking.useCookingItem(pc, l1iteminstance);
			} else if (itemId >= 41383 && itemId <= 41400) {
				useFurnitureItem(pc, itemId, itemObjid);
			} else if (itemId == 41401) {
				useFurnitureRemovalWand(pc, spellsc_objid, l1iteminstance);
			} else if (itemId == 41411) {
				UseHealingPotion(pc, 10, 189);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41345) {
				L1DamagePoison.doInfection(pc, pc, 3000, 5);
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41315) {
				if (pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA)) {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					return;
				}
				if (pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER)) {
					pc.removeSkillEffect(STATUS_HOLY_MITHRIL_POWDER);
				}
				pc.setSkillEffect(STATUS_HOLY_WATER, 900 * 1000);
				pc.sendPackets(new S_SkillSound(pc.getId(), 190));
				pc.broadcastPacket(new S_SkillSound(pc.getId(), 190));
				pc.sendPackets(new S_ServerMessage(1141)); // We have been given the strength to attack the ghost full of resentment.
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41316) {
				if (pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA)) {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					return;
				}
				if (pc.hasSkillEffect(STATUS_HOLY_WATER)) {
					pc.removeSkillEffect(STATUS_HOLY_WATER);
				}
				pc.setSkillEffect(STATUS_HOLY_MITHRIL_POWDER, 900 * 1000);
				pc.sendPackets(new S_SkillSound(pc.getId(), 190));
				pc.broadcastPacket(new S_SkillSound(pc.getId(), 190));
				pc.sendPackets(new S_ServerMessage(1142)); // We have been given the strength to attack General Hamel full of resentment.
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 41354) {
				if (pc.hasSkillEffect(STATUS_HOLY_WATER)
						|| pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER)) {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					return;
				}
				pc.setSkillEffect(STATUS_HOLY_WATER_OF_EVA, 900 * 1000);
				pc.sendPackets(new S_SkillSound(pc.getId(), 190));
				pc.broadcastPacket(new S_SkillSound(pc.getId(), 190));
				pc.sendPackets(new S_ServerMessage(1140)); // We have been given the strength to attack the cursed Exorcist Saell.
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 49092) {
				int targetItemId = l1iteminstance1.getItem().getItemId();
				if (targetItemId == 49095 || targetItemId == 49099) {
					createNewItem(pc, targetItemId + 1, 1);
					inventory.consumeItem(targetItemId, 1);
					inventory.consumeItem(49092, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					return;
				}
			} else if (itemId == 49093) {
				if (inventory.checkItem(49094, 1)) {
					inventory.consumeItem(49093, 1);
					inventory.consumeItem(49094, 1);
					createNewItem(pc, 49095, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 49094) {
				if (inventory.checkItem(49093, 1)) {
					inventory.consumeItem(49093, 1);
					inventory.consumeItem(49094, 1);
					createNewItem(pc, 49095, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 49097) {
				if (inventory.checkItem(49098, 1)) {
					inventory.consumeItem(49097, 1);
					inventory.consumeItem(49098, 1);
					createNewItem(pc, 49099, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 49098) {
				if (inventory.checkItem(49097, 1)) {
					inventory.consumeItem(49097, 1);
					inventory.consumeItem(49098, 1);
					createNewItem(pc, 49099, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 41426) {
				L1ItemInstance lockItem = inventory.getItem(l);
				//unused
				//int lockItemId = lockItem.getItem().getItemId();
				if (lockItem != null && lockItem.getItem().getType2() == 1
						|| lockItem.getItem().getType2() == 2
						|| lockItem.getItem().getType2() == 0
						&& lockItem.getItem().isCanSeal()) {
					if (lockItem.getBless() == 0 || lockItem.getBless() == 1
							|| lockItem.getBless() == 2
							|| lockItem.getBless() == 3) {
						int bless = 1;
						switch (lockItem.getBless()) {
						case 0:
							bless = 128;
							break;
						case 1:
							bless = 129;
							break;
						case 2:
							bless = 130;
							break;
						case 3:
							bless = 131;
							break;
						}
						lockItem.setBless(bless);
						inventory.updateItem(lockItem, L1PcInventory.COL_BLESS);
						inventory.saveItem(lockItem, L1PcInventory.COL_BLESS);
						inventory.removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 41427) {
				L1ItemInstance lockItem = inventory.getItem(l);
				//unused
				//int lockItemId = lockItem.getItem().getItemId();
				if (lockItem != null && lockItem.getItem().getType2() == 1
						|| lockItem.getItem().getType2() == 2
						|| lockItem.getItem().getType2() == 0
						&& lockItem.getItem().isCanSeal()) {
					if (lockItem.getBless() == 128
							|| lockItem.getBless() == 129
							|| lockItem.getBless() == 130
							|| lockItem.getBless() == 131) {
						int bless = 1;
						switch (lockItem.getBless()) {
						case 128:
							bless = 0;
							break;
						case 129:
							bless = 1;
							break;
						case 130:
							bless = 2;
							break;
						case 131:
							bless = 3;
							break;
						}
						lockItem.setBless(bless);
						inventory.updateItem(lockItem, L1PcInventory.COL_BLESS);
						inventory.saveItem(lockItem, L1PcInventory.COL_BLESS);
						inventory.removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					}
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 41428) {
				if (pc != null && l1iteminstance != null) {
					Account account = Account.load(pc.getAccountName());
					if (account == null) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						return;
					}
					int characterSlot = account.getCharacterSlot();
					int maxAmount = Config.DEFAULT_CHARACTER_SLOT
							+ characterSlot;
					if (maxAmount >= 8) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						return;
					}
					if (characterSlot < 0) {
						characterSlot = 0;
					} else {
						characterSlot += 1;
					}
					account.setCharacterSlot(characterSlot);
					Account.updateCharacterSlot(account);
					inventory.removeItem(l1iteminstance, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (itemId == 40075) {
				if (l1iteminstance1.getItem().getType2() == 2) {
					int msg = 0;
					switch (l1iteminstance1.getItem().getType()) {
					case 1: // helm
						msg = 171;
						break;
					case 2: // armor
						msg = 169;
						break;
					case 3: // T
						msg = 170;
						break;
					case 4: // cloak
						msg = 168;
						break;
					case 5: // glove
						msg = 172;
						break;
					case 6: // boots
						msg = 173;
						break;
					case 7: // shield
						msg = 174;
						break;
					default:
						msg = 167;
						break;
					}
					pc.sendPackets(new S_ServerMessage(msg));
					inventory.removeItem(l1iteminstance1, 1);
				} else {
					pc.sendPackets(new S_ServerMessage(154)); // The scroll disintegrates.
				}
				inventory.removeItem(l1iteminstance, 1);
			} else if (itemId == 49210) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "first_p"));
			} else if (itemId == 49211) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "second_p"));
			} else if (itemId == 49212) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "third_p"));
			} else if (itemId == 49287) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "fourth_p"));
			} else if (itemId == 49288) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "fifth_p"));
			} else if (itemId == 49172) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "silrein1lt"));
			} else if (itemId == 49173) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "silrein2lt"));
			} else if (itemId == 49174) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "silrein3lt"));
			} else if (itemId == 49175) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "silrein4lt"));
			} else if (itemId == 49176) {
				pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "silrein5lt"));
			} else if (itemId == 49222) {
				if (pc.isDragonKnight() && pc.getMapId() == 61) {
					boolean found = false;
					for (L1Object obj : L1World.getInstance().getObject()) {
						if (obj instanceof L1MonsterInstance) {
							L1MonsterInstance mob = (L1MonsterInstance) obj;
							if (mob != null) {
								if (mob.getNpcTemplate().get_npcId() == 46161) {
									found = true;
									break;
								}
							}
						}
					}
					if (found) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					} else {
						L1SpawnUtil.spawn(pc, 46161, 0, 0);
					}
					inventory.consumeItem(49222, 1);
				}
			} else if (itemId == 49189) {
				if (pc.isIllusionist() && pc.getMapId() == 4) {
					boolean found = false;
					for (L1Object obj : L1World.getInstance().getObject()) {
						if (obj instanceof L1MonsterInstance) {
							L1MonsterInstance mob = (L1MonsterInstance) obj;
							if (mob != null) {
								if (mob.getNpcTemplate().get_npcId() == 46163) {
									found = true;
									break;
								}
							}
						}
					}
					if (found) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
					} else {
						L1SpawnUtil.spawn(pc, 46163, 0, 0);
					}
					inventory.consumeItem(49189, 1);
				}
			} else {
				int locX = ((L1EtcItem) l1iteminstance.getItem()).get_locx();
				int locY = ((L1EtcItem) l1iteminstance.getItem()).get_locy();
				short mapId = ((L1EtcItem) l1iteminstance.getItem())
						.get_mapid();
				if (locX != 0 && locY != 0) {
					if (pc.getMap().isEscapable() || pc.isGm()) {
						L1Teleport.teleport(pc, locX, locY, mapId,
								pc.getHeading(), true);
						inventory.removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(647)); // You cannot teleport in this location.
					}
					cancelAbsoluteBarrier(pc);
				} else {
					if (l1iteminstance.getCount() < 1) {
						pc.sendPackets(new S_ServerMessage(329, l1iteminstance
								.getLogName())); // You do not have 'item'.
					} else {
						pc.sendPackets(new S_ServerMessage(74, l1iteminstance
								.getLogName())); // You cannot use 'item'.
					}
				}
			}
		} else if (l1iteminstance.getItem().getType2() == 1) {
			L1Item template = l1iteminstance.getItem();
			if (!validClass(pc, template))
				pc.sendPackets(new S_ServerMessage(264)); // Your class can't use this item.
			else if (validLevel(pc, template))
				useWeapon(pc, l1iteminstance);
		} else if (l1iteminstance.getItem().getType2() == 2) {
			L1Item template = l1iteminstance.getItem();
			if (!validClass(pc, template))
				pc.sendPackets(new S_ServerMessage(264)); // Your class can't use this item.
			else if (validLevel(pc, template))
				useArmor(pc, l1iteminstance);
		}

		if (isDelayEffect) {
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			l1iteminstance.setLastUsed(ts);
			pc.getInventory().updateItem(l1iteminstance,
					L1PcInventory.COL_DELAY_EFFECT);
			pc.getInventory().saveItem(l1iteminstance,
					L1PcInventory.COL_DELAY_EFFECT);
		}

		L1ItemDelay.onItemUse(client, l1iteminstance);
	}

	// TODO: Move to L1PcInstance.
	private static byte getBaseStat(final L1PcInstance pc, L1Attribute stat) {
		switch (stat) {
		case Str:
			return pc.getBaseStr();
		case Dex:
			return pc.getBaseDex();
		case Con:
			return pc.getBaseCon();
		case Wis:
			return pc.getBaseWis();
		case Int:
			return pc.getBaseInt();
		case Cha:
			return pc.getBaseCha();
		default:
			return 0; // Can't get here.
		}
	}

	// TODO: Move to L1PcInstance.
	private static void addStat(final L1PcInstance pc, L1Attribute stat,
			byte amount) {
		switch (stat) {
		case Str:
			pc.addBaseStr(amount);
			break;
		case Dex:
			pc.addBaseDex(amount);
			break;
		case Con:
			pc.addBaseCon(amount);
			break;
		case Wis:
			pc.addBaseWis(amount);
			break;
		case Int:
			pc.addBaseInt(amount);
			break;
		case Cha:
			pc.addBaseCha(amount);
			break;
		default: // Can't get here.
		}
	}

	private static L1Attribute[] elixirs = { L1Attribute.Str, L1Attribute.Con,
			L1Attribute.Dex, L1Attribute.Int, L1Attribute.Wis, L1Attribute.Cha };
	private static final int FirstElixirId = 40033;

	// TODO: deal with throws bs.
	private static void useElixir(final L1PcInstance pc, final int itemId,
			final L1ItemInstance elixir) throws Exception {
		L1Attribute attribute = elixirs[itemId - FirstElixirId];
		if (pc.getElixirStats() >= 5 || getBaseStat(pc, attribute) >= 35) {
			pc.sendPackets(new S_ServerMessage(481)); // The maximum value you can get for one attribute is 35. Please choose another attribute.
			return;
		}

		addStat(pc, attribute, (byte) 1);
		pc.setElixirStats(pc.getElixirStats() + 1);
		pc.getInventory().removeItem(elixir, 1);
		pc.sendPackets(new S_OwnCharStatus2(pc));
		pc.save();
	}

	private static boolean validClass(final L1PcInstance pc, final L1Item item) {
		return pc.isGm() || pc.isCrown() && item.isUseRoyal() || pc.isKnight()
				&& item.isUseKnight() || pc.isElf() && item.isUseElf()
				|| pc.isWizard() && item.isUseMage() || pc.isDarkelf()
				&& item.isUseDarkelf() || pc.isDragonKnight()
				&& item.isUseDragonknight() || pc.isIllusionist()
				&& item.isUseIllusionist();
	}

	private static boolean validLevel(final L1PcInstance pc, final L1Item item) {
		if (pc.isGm())
			return true;
		int min = item.getMinLevel();
		int max = item.getMaxLevel();
		if (min != 0 && min > pc.getLevel()) {
			pc.sendPackets(new S_ServerMessage(318, String.valueOf(min))); // You have to be at least level 'x' to use this item.
			return false;
		}
		if (max != 0 && max < pc.getLevel()) {
			pc.sendPackets(max < 50 ? new S_PacketBox(
					S_PacketBox.MSG_LEVEL_OVER, max) : new S_SystemMessage(
					"You must be at or below level " + max
							+ " to use this item."));
			return false;
		}
		return true;
	}

	// Kludgy - needs a better name.
	private static boolean potionCheck(final L1PcInstance player) {
		if (player.hasSkillEffect(DECAY_POTION)) {
			player.sendPackets(new S_ServerMessage(698)); // Your throat is blocked and you can't drink anything.
			return false;
		}
		cancelAbsoluteBarrier(player);
		return true;
	}

	private void UseHealingPotion(L1PcInstance pc, int healHp, int gfxid) {
		if (!potionCheck(pc))
			return;

		pc.sendAndBroadcast(new S_SkillSound(pc.getId(), gfxid));
		if (pc.getPotionMessages())
			pc.sendPackets(new S_ServerMessage(77)); // You feel better.
		healHp *= (_random.nextGaussian() / 5.0D) + 1.0D;
		if (pc.hasSkillEffect(POLLUTE_WATER))
			healHp /= 2;
		pc.setCurrentHp(pc.getCurrentHp() + healHp);
	}

	// NOTE: do not remove stacking code
	private void useGreenPotion(L1PcInstance pc, int itemId) {
		if (!potionCheck(pc))
			return;

		// flag for using b-ghaste
		boolean usedBGHaste = false;

		int time = pc.getSkillEffectTimeSec(STATUS_HASTE);
		time = time < 0 ? 0 : time;

		int addtime = 0;
		if (itemId == POTION_OF_HASTE_SELF) {
			addtime = 300;
		} else if (itemId == B_POTION_OF_HASTE_SELF) {
			addtime = 350;
		} else if (itemId == 40018 || itemId == 41338 || itemId == 41342) {
			addtime = 1800;
		} else if (itemId == 140018) {
			addtime = 0;
			time = 2100;
		} else if (itemId == 40039) {
			addtime = 600;
		} else if (itemId == 40040) {
			addtime = 900;
		} else if (itemId == 40030) {
			addtime = 300;
		} else if (itemId == 41261 || itemId == 41262 || itemId == 41268
				|| itemId == 41269 || itemId == 41271 || itemId == 41272
				|| itemId == 41273) {
			addtime = 30;
		}

		time = Config.STACKING ? time + addtime : addtime;

		pc.sendPackets(new S_SkillSound(pc.getId(), 191));
		pc.broadcastPacket(new S_SkillSound(pc.getId(), 191));

		if (pc.getHasteItemEquipped() > 0) {
			// We need this check for times when a player wearing a haste item
			// gets Canceled.
			pc.removeHasteSkillEffect();
			if (pc.getMoveSpeed() != 1) {
				pc.setMoveSpeed(1);
				pc.sendPackets(new S_SkillHaste(pc.getId(), 1, -1));
				pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1, 0));
			}
			return;
		}

		pc.setDrink(false);

		if (pc.hasSkillEffect(HASTE)) {
			pc.killSkillEffectTimer(HASTE);
			pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0, 0));
			pc.setMoveSpeed(0);
		} else if (pc.hasSkillEffect(GREATER_HASTE)) {
			pc.killSkillEffectTimer(GREATER_HASTE);
			pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0, 0));
			pc.setMoveSpeed(0);
		} else if (pc.hasSkillEffect(STATUS_HASTE)) {
			pc.killSkillEffectTimer(STATUS_HASTE);
			pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0, 0));
			pc.setMoveSpeed(0);
		}

		//
		if (pc.hasSkillEffect(SLOW)) {
			pc.killSkillEffectTimer(SLOW);
			pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0, 0));
		} else if (pc.hasSkillEffect(MASS_SLOW)) {
			pc.killSkillEffectTimer(MASS_SLOW);
			pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0, 0));
		} else if (pc.hasSkillEffect(ENTANGLE)) {
			pc.killSkillEffectTimer(ENTANGLE);
			pc.sendPackets(new S_SkillHaste(pc.getId(), 0, 0));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 0, 0));
		} else {
			// max bound the haste time to 1800 (30min)
			if (time > 1800 && !usedBGHaste) {
				time = 1800;
			}
			pc.sendPackets(new S_SkillHaste(pc.getId(), 1, time));
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1, 0));
			pc.setMoveSpeed(1);
			pc.setSkillEffect(STATUS_HASTE, time * 1000);
		}
	}

	private void useBravePotion(L1PcInstance pc, int item_id) {
		if (!potionCheck(pc))
			return;

		int time = 0;

		// grab the current brave time
		if (pc.hasSkillEffect(STATUS_BRAVE)) {
			time = pc.getSkillEffectTimeSec(STATUS_BRAVE);
		} else if (pc.hasSkillEffect(STATUS_ELFBRAVE)) {
			time = pc.getSkillEffectTimeSec(STATUS_ELFBRAVE);
		} else if (pc.hasSkillEffect(STATUS_RIBRAVE)) {
			time = pc.getSkillEffectTimeSec(STATUS_RIBRAVE);
		}

		int addtime = 0;
		if (item_id == POTION_OF_EMOTION_BRAVERY) {
			addtime = 300;
		} else if (item_id == B_POTION_OF_EMOTION_BRAVERY) {
			addtime = 350;
		} else if (item_id == FORBIDDEN_FRUIT) {
			addtime = 480;
			if (pc.hasSkillEffect(STATUS_BRAVE)) {
				pc.killSkillEffectTimer(STATUS_BRAVE);
				pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
				pc.broadcastPacket(new S_SkillBrave(pc.getId(), 0, 0));
				pc.setBraveSpeed(0);
			}
		} else if (item_id == 41415) {
			addtime = 1800;
		} else if (item_id == ELVEN_WAFER) {
			addtime = 600;
			if (pc.hasSkillEffect(STATUS_BRAVE)) {
				pc.killSkillEffectTimer(STATUS_BRAVE);
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
		} else if (item_id == B_ELVEN_WAFER) {
			addtime = 700;
			if (pc.hasSkillEffect(STATUS_BRAVE)) {
				pc.killSkillEffectTimer(STATUS_BRAVE);
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
		} else if (item_id == DEVILS_BLOOD) {
			addtime = 600;
		} else if (item_id == 40733) {
			addtime = 600;
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
		}

		time = Config.STACKING ? Math.min(time + addtime, 1800) : addtime;

		if (item_id == ELVEN_WAFER || item_id == B_ELVEN_WAFER) {
			pc.sendPackets(new S_SkillBrave(pc.getId(), 3, time));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 3, 0));
			pc.sendPackets(new S_SkillSound(pc.getId(), 751));
			pc.broadcastPacket(new S_SkillSound(pc.getId(), 751));
			pc.setSkillEffect(STATUS_ELFBRAVE, time * 1000);
		} else if (item_id == FORBIDDEN_FRUIT) {
			// Remove bloodlust first
			pc.removeSkillEffect(BLOODLUST);
			pc.sendPackets(new S_SkillBrave(pc.getId(), 6, 0));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 6, 0));

			pc.sendPackets(new S_SkillBrave(pc.getId(), 4, time));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 4, 0));
			pc.setBraveSpeed(4);

			// This S_SkillSound packet actually sends ForbiddenFruit buff to
			// client
			// not known how to update buff duration / remove buff so moving
			// acceleration
			// buff is used instead above
			// pc.sendPackets(new S_SkillSound(pc.getId(), 7110));
			// pc.broadcastPacket(new S_SkillSound(pc.getId(), 7110));
			pc.setSkillEffect(STATUS_RIBRAVE, time * 1000);
		} else {
			pc.sendPackets(new S_SkillBrave(pc.getId(), 1, time));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 1, 0));
			pc.sendPackets(new S_SkillSound(pc.getId(), 751));
			pc.broadcastPacket(new S_SkillSound(pc.getId(), 751));
			pc.setSkillEffect(STATUS_BRAVE, time * 1000);
		}
		// pc.sendPackets(new S_SkillSound(pc.getId(), 751));
		// pc.broadcastPacket(new S_SkillSound(pc.getId(), 751));
		pc.setBraveSpeed(1);
	}

	private void useBluePotion(L1PcInstance pc, int item_id) {
		if (!potionCheck(pc))
			return;

		int time = pc.getSkillEffectTimeSec(STATUS_BLUE_POTION);
		time = time < 0 ? 0 : time;

		int addtime = 0;
		if (item_id == POTION_OF_MANA || item_id == 40736) {
			addtime = 600;
		} else if (item_id == 140015) {
			addtime = 700;
		} else {
			return;
		}

		time = Config.STACKING ? Math.min(time + addtime, 1200) : addtime;

		pc.sendPackets(new S_SkillIconGFX(34, time));
		pc.sendAndBroadcast(new S_SkillSound(pc.getId(), 190));

		pc.setSkillEffect(STATUS_BLUE_POTION, time * 1000);

		pc.sendPackets(new S_ServerMessage(1007)); // You feel the speed of magic recovery getting faster.
	}

	private void useWisdomPotion(L1PcInstance pc, int item_id) {
		if (!potionCheck(pc))
			return;

		int time = pc.getSkillEffectTimeSec(STATUS_WISDOM_POTION);
		time = time < 0 ? 0 : time;

		int addtime = 0;
		if (item_id == POTION_OF_EMOTION_WISDOM) {
			addtime = 300;
		} else if (item_id == B_POTION_OF_EMOTION_WISDOM) {
			addtime = 360;
		}

		time = Config.STACKING ? Math.min(time + addtime, 900) : addtime;

		if (!pc.hasSkillEffect(STATUS_WISDOM_POTION)) {
			pc.addSp(2);
		}

		pc.sendPackets(new S_SkillIconWisdomPotion(time / 4));
		pc.sendAndBroadcast(new S_SkillSound(pc.getId(), 750));

		pc.setSkillEffect(STATUS_WISDOM_POTION, time * 1000);
	}

	private void useBlessOfEva(L1PcInstance pc, int item_id) {
		if (!potionCheck(pc))
			return;

		int time = 0;
		if (item_id == 40032) {
			time = 1800;
		} else if (item_id == 40041) {
			time = 300;
		} else if (item_id == 41344) {
			time = 2100;
		} else {
			return;
		}

		if (pc.hasSkillEffect(STATUS_UNDERWATER_BREATH)) {
			time += pc.getSkillEffectTimeSec(STATUS_UNDERWATER_BREATH);
			if (time > 3600) {
				time = 3600;
			}
		}
		pc.sendPackets(new S_SkillIconBlessOfEva(pc.getId(), time));
		pc.sendAndBroadcast(new S_SkillSound(pc.getId(), 190));
		pc.setSkillEffect(STATUS_UNDERWATER_BREATH, time * 1000);
	}

	private void useBlindPotion(L1PcInstance pc) {
		if (!potionCheck(pc))
			return;

		pc.killSkillEffectTimer(CURSE_BLIND);
		pc.killSkillEffectTimer(DARKNESS);

		pc.sendPackets(new S_CurseBlind(
				pc.hasSkillEffect(STATUS_FLOATING_EYE) ? 2 : 1));

		pc.setSkillEffect(CURSE_BLIND, 16 * 1000);
	}

	private boolean usePolyScroll(L1PcInstance pc, int item_id, String s) {
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS || awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384)); // You cannot transform in the current condition.
			return false;
		}

		int time = 0;
		if (item_id == 40088 || item_id == 40096) {
			time = 1800;
		} else if (item_id == 140088) {
			time = 2100;
		}

		L1PolyMorph poly = PolyTable.getInstance().getTemplate(s);
		if (poly != null || s.equals("")) {
			if (s.equals("")) {
				if (pc.getTempCharGfx() == 6034 || pc.getTempCharGfx() == 6035) {
					return true;
				} else {
					pc.removeSkillEffect(SHAPE_CHANGE);
					return true;
				}
			} else if (poly.getMinLevel() <= pc.getLevel() || pc.isGm()) {
				L1PolyMorph.doPoly(pc, poly.getPolyId(), time,
						L1PolyMorph.MORPH_BY_ITEMMAGIC);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private void usePolyScale(L1PcInstance pc, int itemId) {
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS || awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384)); // You cannot transform in the current condition.
			return;
		}

		int polyId = 0;
		if (itemId == 41154) {
			polyId = 3101;
		} else if (itemId == 41155) {
			polyId = 3126;
		} else if (itemId == 41156) {
			polyId = 3888;
		} else if (itemId == 41157) {
			polyId = 3784;
		} else if (itemId == 49220) {
			polyId = 6984;
		}
		L1PolyMorph.doPoly(pc, polyId, 600, L1PolyMorph.MORPH_BY_ITEMMAGIC);
	}

	private void useSuperDKScroll(L1PcInstance pc, int itemId) {
		if (itemId != 240101)
			return;

		L1PolyMorph.doPoly(pc, 5641, 6000, L1PolyMorph.MORPH_BY_ITEMMAGIC);
	}

	private void usePolyPotion(L1PcInstance pc, int itemId) {
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS || awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384)); // You cannot transform in the current condition.
			return;
		}

		int polyId = 0;
		if (itemId == 41143) {
			polyId = 6086;
		} else if (itemId == 41144) {
			polyId = 6087;
		} else if (itemId == 41145) {
			polyId = 6088;
		} else if (itemId == 49149 && pc.get_sex() == 0 && pc.isCrown()) {
			polyId = 6822;
		} else if (itemId == 49149 && pc.get_sex() == 1 && pc.isCrown()) {
			polyId = 6823;
		} else if (itemId == 49149 && pc.get_sex() == 0 && pc.isKnight()) {
			polyId = 6824;
		} else if (itemId == 49149 && pc.get_sex() == 1 && pc.isKnight()) {
			polyId = 6825;
		} else if (itemId == 49149 && pc.get_sex() == 0 && pc.isElf()) {
			polyId = 6826;
		} else if (itemId == 49149 && pc.get_sex() == 1 && pc.isElf()) {
			polyId = 6827;
		} else if (itemId == 49149 && pc.get_sex() == 0 && pc.isWizard()) {
			polyId = 6828;
		} else if (itemId == 49149 && pc.get_sex() == 1 && pc.isWizard()) {
			polyId = 6829;
		} else if (itemId == 49149 && pc.get_sex() == 0 && pc.isDarkelf()) {
			polyId = 6830;
		} else if (itemId == 49149 && pc.get_sex() == 1 && pc.isDarkelf()) {
			polyId = 6831;
		} else if (itemId == 49149 && pc.get_sex() == 0 && pc.isDragonKnight()) {
			polyId = 7139;
		} else if (itemId == 49149 && pc.get_sex() == 1 && pc.isDragonKnight()) {
			polyId = 7140;
		} else if (itemId == 49149 && pc.get_sex() == 0 && pc.isIllusionist()) {
			polyId = 7141;
		} else if (itemId == 49149 && pc.get_sex() == 1 && pc.isIllusionist()) {
			polyId = 7142;
		} else if (itemId == 49150 && pc.get_sex() == 0 && pc.isCrown()) {
			polyId = 6832;
		} else if (itemId == 49150 && pc.get_sex() == 1 && pc.isCrown()) {
			polyId = 6833;
		} else if (itemId == 49150 && pc.get_sex() == 0 && pc.isKnight()) {
			polyId = 6834;
		} else if (itemId == 49150 && pc.get_sex() == 1 && pc.isKnight()) {
			polyId = 6835;
		} else if (itemId == 49150 && pc.get_sex() == 0 && pc.isElf()) {
			polyId = 6836;
		} else if (itemId == 49150 && pc.get_sex() == 1 && pc.isElf()) {
			polyId = 6837;
		} else if (itemId == 49150 && pc.get_sex() == 0 && pc.isWizard()) {
			polyId = 6838;
		} else if (itemId == 49150 && pc.get_sex() == 1 && pc.isWizard()) {
			polyId = 6839;
		} else if (itemId == 49150 && pc.get_sex() == 0 && pc.isDarkelf()) {
			polyId = 6840;
		} else if (itemId == 49150 && pc.get_sex() == 1 && pc.isDarkelf()) {
			polyId = 6841;
		} else if (itemId == 49150 && pc.get_sex() == 0 && pc.isDragonKnight()) {
			polyId = 7143;
		} else if (itemId == 49150 && pc.get_sex() == 1 && pc.isDragonKnight()) {
			polyId = 7144;
		} else if (itemId == 49150 && pc.get_sex() == 0 && pc.isIllusionist()) {
			polyId = 7145;
		} else if (itemId == 49150 && pc.get_sex() == 1 && pc.isIllusionist()) {
			polyId = 7146;
		} else if (itemId == 49151 && pc.get_sex() == 0 && pc.isCrown()) {
			polyId = 6842;
		} else if (itemId == 49151 && pc.get_sex() == 1 && pc.isCrown()) {
			polyId = 6843;
		} else if (itemId == 49151 && pc.get_sex() == 0 && pc.isKnight()) {
			polyId = 6844;
		} else if (itemId == 49151 && pc.get_sex() == 1 && pc.isKnight()) {
			polyId = 6845;
		} else if (itemId == 49151 && pc.get_sex() == 0 && pc.isElf()) {
			polyId = 6846;
		} else if (itemId == 49151 && pc.get_sex() == 1 && pc.isElf()) {
			polyId = 6847;
		} else if (itemId == 49151 && pc.get_sex() == 0 && pc.isWizard()) {
			polyId = 6848;
		} else if (itemId == 49151 && pc.get_sex() == 1 && pc.isWizard()) {
			polyId = 6849;
		} else if (itemId == 49151 && pc.get_sex() == 0 && pc.isDarkelf()) {
			polyId = 6850;
		} else if (itemId == 49151 && pc.get_sex() == 1 && pc.isDarkelf()) {
			polyId = 6851;
		} else if (itemId == 49151 && pc.get_sex() == 0 && pc.isDragonKnight()) {
			polyId = 7147;
		} else if (itemId == 49151 && pc.get_sex() == 1 && pc.isDragonKnight()) {
			polyId = 7148;
		} else if (itemId == 49151 && pc.get_sex() == 0 && pc.isIllusionist()) {
			polyId = 7149;
		} else if (itemId == 49151 && pc.get_sex() == 1 && pc.isIllusionist()) {
			polyId = 7150;
		} else if (itemId == 49152 && pc.get_sex() == 0 && pc.isCrown()) {
			polyId = 6852;
		} else if (itemId == 49152 && pc.get_sex() == 1 && pc.isCrown()) {
			polyId = 6853;
		} else if (itemId == 49152 && pc.get_sex() == 0 && pc.isKnight()) {
			polyId = 6854;
		} else if (itemId == 49152 && pc.get_sex() == 1 && pc.isKnight()) {
			polyId = 6855;
		} else if (itemId == 49152 && pc.get_sex() == 0 && pc.isElf()) {
			polyId = 6856;
		} else if (itemId == 49152 && pc.get_sex() == 1 && pc.isElf()) {
			polyId = 6857;
		} else if (itemId == 49152 && pc.get_sex() == 0 && pc.isWizard()) {
			polyId = 6858;
		} else if (itemId == 49152 && pc.get_sex() == 1 && pc.isWizard()) {
			polyId = 6859;
		} else if (itemId == 49152 && pc.get_sex() == 0 && pc.isDarkelf()) {
			polyId = 6860;
		} else if (itemId == 49152 && pc.get_sex() == 1 && pc.isDarkelf()) {
			polyId = 6861;
		} else if (itemId == 49152 && pc.get_sex() == 0 && pc.isDragonKnight()) {
			polyId = 7151;
		} else if (itemId == 49152 && pc.get_sex() == 1 && pc.isDragonKnight()) {
			polyId = 7152;
		} else if (itemId == 49152 && pc.get_sex() == 0 && pc.isIllusionist()) {
			polyId = 7153;
		} else if (itemId == 49152 && pc.get_sex() == 1 && pc.isIllusionist()) {
			polyId = 7154;
		} else if (itemId == 49153 && pc.get_sex() == 0 && pc.isCrown()) {
			polyId = 6862;
		} else if (itemId == 49153 && pc.get_sex() == 1 && pc.isCrown()) {
			polyId = 6863;
		} else if (itemId == 49153 && pc.get_sex() == 0 && pc.isKnight()) {
			polyId = 6864;
		} else if (itemId == 49153 && pc.get_sex() == 1 && pc.isKnight()) {
			polyId = 6865;
		} else if (itemId == 49153 && pc.get_sex() == 0 && pc.isElf()) {
			polyId = 6866;
		} else if (itemId == 49153 && pc.get_sex() == 1 && pc.isElf()) {
			polyId = 6867;
		} else if (itemId == 49153 && pc.get_sex() == 0 && pc.isWizard()) {
			polyId = 6868;
		} else if (itemId == 49153 && pc.get_sex() == 1 && pc.isWizard()) {
			polyId = 6869;
		} else if (itemId == 49153 && pc.get_sex() == 0 && pc.isDarkelf()) {
			polyId = 6870;
		} else if (itemId == 49153 && pc.get_sex() == 1 && pc.isDarkelf()) {
			polyId = 6871;
		} else if (itemId == 49153 && pc.get_sex() == 0 && pc.isDragonKnight()) {
			polyId = 7155;
		} else if (itemId == 49153 && pc.get_sex() == 1 && pc.isDragonKnight()) {
			polyId = 7156;
		} else if (itemId == 49153 && pc.get_sex() == 0 && pc.isIllusionist()) {
			polyId = 7157;
		} else if (itemId == 49153 && pc.get_sex() == 1 && pc.isIllusionist()) {
			polyId = 7158;
		} else if (itemId == 49154 && pc.get_sex() == 0 && pc.isCrown()) {
			polyId = 6872;
		} else if (itemId == 49154 && pc.get_sex() == 1 && pc.isCrown()) {
			polyId = 6873;
		} else if (itemId == 49154 && pc.get_sex() == 0 && pc.isKnight()) {
			polyId = 6874;
		} else if (itemId == 49154 && pc.get_sex() == 1 && pc.isKnight()) {
			polyId = 6875;
		} else if (itemId == 49154 && pc.get_sex() == 0 && pc.isElf()) {
			polyId = 6876;
		} else if (itemId == 49154 && pc.get_sex() == 1 && pc.isElf()) {
			polyId = 6877;
		} else if (itemId == 49154 && pc.get_sex() == 0 && pc.isWizard()) {
			polyId = 6878;
		} else if (itemId == 49154 && pc.get_sex() == 1 && pc.isWizard()) {
			polyId = 6879;
		} else if (itemId == 49154 && pc.get_sex() == 0 && pc.isDarkelf()) {
			polyId = 6880;
		} else if (itemId == 49154 && pc.get_sex() == 1 && pc.isDarkelf()) {
			polyId = 6881;
		} else if (itemId == 49154 && pc.get_sex() == 0 && pc.isDragonKnight()) {
			polyId = 7159;
		} else if (itemId == 49154 && pc.get_sex() == 1 && pc.isDragonKnight()) {
			polyId = 7160;
		} else if (itemId == 49154 && pc.get_sex() == 0 && pc.isIllusionist()) {
			polyId = 7161;
		} else if (itemId == 49154 && pc.get_sex() == 1 && pc.isIllusionist()) {
			polyId = 7162;
		} else if (itemId == 49155 && pc.get_sex() == 0 && pc.isCrown()) {
			polyId = 6882;
		} else if (itemId == 49155 && pc.get_sex() == 1 && pc.isCrown()) {
			polyId = 6883;
		} else if (itemId == 49155 && pc.get_sex() == 0 && pc.isKnight()) {
			polyId = 6884;
		} else if (itemId == 49155 && pc.get_sex() == 1 && pc.isKnight()) {
			polyId = 6885;
		} else if (itemId == 49155 && pc.get_sex() == 0 && pc.isElf()) {
			polyId = 6886;
		} else if (itemId == 49155 && pc.get_sex() == 1 && pc.isElf()) {
			polyId = 6887;
		} else if (itemId == 49155 && pc.get_sex() == 0 && pc.isWizard()) {
			polyId = 6888;
		} else if (itemId == 49155 && pc.get_sex() == 1 && pc.isWizard()) {
			polyId = 6889;
		} else if (itemId == 49155 && pc.get_sex() == 0 && pc.isDarkelf()) {
			polyId = 6890;
		} else if (itemId == 49155 && pc.get_sex() == 1 && pc.isDarkelf()) {
			polyId = 6891;
		} else if (itemId == 49155 && pc.get_sex() == 0 && pc.isDragonKnight()) {
			polyId = 7163;
		} else if (itemId == 49155 && pc.get_sex() == 1 && pc.isDragonKnight()) {
			polyId = 7164;
		} else if (itemId == 49155 && pc.get_sex() == 0 && pc.isIllusionist()) {
			polyId = 7165;
		} else if (itemId == 49155 && pc.get_sex() == 1 && pc.isIllusionist()) {
			polyId = 7166;
		}
		L1PolyMorph.doPoly(pc, polyId, 1800, L1PolyMorph.MORPH_BY_ITEMMAGIC);
	}

	private void useArmor(L1PcInstance activeChar, L1ItemInstance armor) {
		// never used
		// int itemid = armor.getItem().getItemId();
		int type = armor.getItem().getType();
		L1PcInventory pcInventory = activeChar.getInventory();
		boolean equipeSpace;
		if (type == 9) {
			equipeSpace = pcInventory.getTypeEquipped(2, 9) <= 1;
		} else {
			equipeSpace = pcInventory.getTypeEquipped(2, type) <= 0;
		}

		if (equipeSpace && !armor.isEquipped()) {
			int polyid = activeChar.getTempCharGfx();

			if (!L1PolyMorph.isEquipableArmor(polyid, type)) {
				return;
			}

			if (type == 13 && pcInventory.getTypeEquipped(2, 7) >= 1
					|| type == 7 && pcInventory.getTypeEquipped(2, 13) >= 1) {
				activeChar.sendPackets(new S_ServerMessage(124)); // You are already wearing some armor.
				return;
			}
			if (type == 7 && activeChar.getWeapon() != null) {
				if (activeChar.getWeapon().getItem().isTwohandedWeapon()) {
					activeChar.sendPackets(new S_ServerMessage(129)); // You cannot wear a shield while wielding a two-handed weapon.
					return;
				}
			}

			if (type == 3 && pcInventory.getTypeEquipped(2, 4) >= 1) {
				activeChar
						.sendPackets(new S_ServerMessage(126, "$224", "$225")); // You cannot wear Shirt over Cloak.
				return;
			} else if ((type == 3) && pcInventory.getTypeEquipped(2, 2) >= 1) {
				activeChar
						.sendPackets(new S_ServerMessage(126, "$224", "$226")); // You cannot wear Shirt over Armor.
				return;
			} else if ((type == 2) && pcInventory.getTypeEquipped(2, 4) >= 1) {
				activeChar
						.sendPackets(new S_ServerMessage(126, "$226", "$225")); // You cannot wear Armor over Cloak.
				return;
			}

			cancelAbsoluteBarrier(activeChar);

			pcInventory.setEquipped(armor, true);
		} else if (armor.isEquipped()) {
			if (armor.getItem().getBless() == 2) {
				activeChar.sendPackets(new S_ServerMessage(150)); // You can't do that. It seems to be cursed.
				return;
			}
			if (type == 3 && pcInventory.getTypeEquipped(2, 2) >= 1) {
				activeChar.sendPackets(new S_ServerMessage(127)); // You cannot take that off.
				return;
			} else if ((type == 2 || type == 3)
					&& pcInventory.getTypeEquipped(2, 4) >= 1) {
				activeChar.sendPackets(new S_ServerMessage(127)); // You cannot take that off.
				return;
			}
			if (type == 7) {
				if (activeChar.hasSkillEffect(SOLID_CARRIAGE)) {
					activeChar.removeSkillEffect(SOLID_CARRIAGE);
				}
			}
			pcInventory.setEquipped(armor, false);
		} else {
			activeChar.sendPackets(new S_ServerMessage(124)); // You are already wearing some armor.
		}
		activeChar.setCurrentHp(activeChar.getCurrentHp());
		activeChar.setCurrentMp(activeChar.getCurrentMp());
		activeChar.sendPackets(new S_OwnCharAttrDef(activeChar));
		activeChar.sendPackets(new S_OwnCharStatus(activeChar));
		activeChar.sendPackets(new S_SPMR(activeChar));
	}

	private void useWeapon(L1PcInstance activeChar, L1ItemInstance weapon) {
		L1PcInventory pcInventory = activeChar.getInventory();
		if (activeChar.getWeapon() == null
				|| !activeChar.getWeapon().equals(weapon)) {
			int weapon_type = weapon.getItem().getType();
			int polyid = activeChar.getTempCharGfx();

			if (!L1PolyMorph.isEquipableWeapon(polyid, weapon_type)) {
				return;
			}
			if (weapon.getItem().isTwohandedWeapon()
					&& pcInventory.getTypeEquipped(2, 7) >= 1) {
				activeChar.sendPackets(new S_ServerMessage(128)); // You cannot wield a two-handed weapon while holding a shield.
				return;
			}
		}

		cancelAbsoluteBarrier(activeChar);

		if (activeChar.getWeapon() != null) {
			if (activeChar.getWeapon().getItem().getBless() == 2) {
				activeChar.sendPackets(new S_ServerMessage(150)); // You can't do that. It seems to be cursed.
				return;
			}
			if (activeChar.getWeapon().equals(weapon)) {
				pcInventory.setEquipped(activeChar.getWeapon(), false, false,
						false);
				return;
			} else {
				pcInventory.setEquipped(activeChar.getWeapon(), false, false,
						true);
			}
		}

		if (weapon.getItemId() == 200002) {
			activeChar
					.sendPackets(new S_ServerMessage(149, weapon.getLogName())); // The 'item' is stuck to your hand!
		}
		pcInventory.setEquipped(weapon, true, false, false);
	}

	private void useSpellBook(L1PcInstance pc, L1ItemInstance item, int itemId) {
		int itemAttr = 0;
		int locAttr = 0; // 0:other 1:law 2:chaos
		boolean isLawful = true;
		int pcX = pc.getX();
		int pcY = pc.getY();
		int mapId = pc.getMapId();
		int level = pc.getLevel();
		if (itemId == 45000 || itemId == 45008 || itemId == 45018
				|| itemId == 45021 || itemId == 40171 || itemId == 40179
				|| itemId == 40180 || itemId == 40182 || itemId == 40194
				|| itemId == 40197 || itemId == 40202 || itemId == 40206
				|| itemId == 40213 || itemId == 40220 || itemId == 40222) {
			itemAttr = 1;
		}
		if (itemId == 45009 || itemId == 45010 || itemId == 45019
				|| itemId == 40172 || itemId == 40173 || itemId == 40178
				|| itemId == 40185 || itemId == 40186 || itemId == 40192
				|| itemId == 40196 || itemId == 40201 || itemId == 40204
				|| itemId == 40211 || itemId == 40221 || itemId == 40225) {
			itemAttr = 2;
		}
		if (pcX > 33116 && pcX < 33128 && pcY > 32930 && pcY < 32942
				&& mapId == 4 || pcX > 33135 && pcX < 33147 && pcY > 32235
				&& pcY < 32247 && mapId == 4 || pcX >= 32783 && pcX <= 32803
				&& pcY >= 32831 && pcY <= 32851 && mapId == 77) {
			locAttr = 1;
			isLawful = true;
		}
		if (pcX > 32880 && pcX < 32892 && pcY > 32646 && pcY < 32658
				&& mapId == 4 || pcX > 32662 && pcX < 32674 && pcY > 32297
				&& pcY < 32309 && mapId == 4) {
			locAttr = 2;
			isLawful = false;
		}
		if (pc.isGm()) {
			SpellBook(pc, item, isLawful);
		} else if ((itemAttr == locAttr || itemAttr == 0) && locAttr != 0) {
			if (pc.isKnight()) {
				if (itemId >= 45000 && itemId <= 45007 && level >= 50) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 45000 && itemId <= 45007) {
					pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (pc.isCrown() || pc.isDarkelf()) {
				if (itemId >= 45000 && itemId <= 45007 && level >= 10) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 45008 && itemId <= 45015 && level >= 20) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 45008 && itemId <= 45015
						|| itemId >= 45000 && itemId <= 45007) {
					pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (pc.isElf()) {
				if (itemId >= 45000 && itemId <= 45007 && level >= 8) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 45008 && itemId <= 45015 && level >= 16) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 45016 && itemId <= 45022 && level >= 24) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40170 && itemId <= 40177 && level >= 32) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40178 && itemId <= 40185 && level >= 40) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40186 && itemId <= 40193 && level >= 48) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 45000 && itemId <= 45022
						|| itemId >= 40170 && itemId <= 40193) {
					pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
				} else {
					pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
				}
			} else if (pc.isWizard()) {
				if (itemId >= 45000 && itemId <= 45007 && level >= 4) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 45008 && itemId <= 45015 && level >= 8) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 45016 && itemId <= 45022 && level >= 12) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40170 && itemId <= 40177 && level >= 16) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40178 && itemId <= 40185 && level >= 20) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40186 && itemId <= 40193 && level >= 24) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40194 && itemId <= 40201 && level >= 28) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40202 && itemId <= 40209 && level >= 32) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40210 && itemId <= 40217 && level >= 36) {
					SpellBook(pc, item, isLawful);
				} else if (itemId >= 40218 && itemId <= 40225 && level >= 40) {
					SpellBook(pc, item, isLawful);
				} else {
					pc.sendPackets(new S_ServerMessage(312)); // You can't learn that spell yet because your magic level is too low.
				}
			}
		} else if (itemAttr != locAttr && itemAttr != 0 && locAttr != 0) {
			pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
			S_SkillSound effect = new S_SkillSound(pc.getId(), 10);
			pc.sendPackets(effect);
			pc.broadcastPacket(effect);
			pc.setCurrentHp(Math.max(pc.getCurrentHp() - 45, 0));
			if (pc.getCurrentHp() <= 0) {
				pc.death(null);
			}
			pc.getInventory().removeItem(item, 1);
		} else {
			pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
		}
	}

	private void useElfSpellBook(L1PcInstance pc, L1ItemInstance item,
			int itemId) {
		int level = pc.getLevel();
		if ((pc.isElf() || pc.isGm()) && isLearnElfMagic(pc)) {
			if (itemId >= 40232 && itemId <= 40234 && level >= 10) {
				SpellBook2(pc, item);
			} else if (itemId >= 40235 && itemId <= 40236 && level >= 20) {
				SpellBook2(pc, item);
			}
			if (itemId >= 40237 && itemId <= 40240 && level >= 30) {
				SpellBook2(pc, item);
			} else if (itemId >= 40241 && itemId <= 40243 && level >= 40) {
				SpellBook2(pc, item);
			} else if (itemId >= 40244 && itemId <= 40246 && level >= 50) {
				SpellBook2(pc, item);
			} else if (itemId >= 40247 && itemId <= 40248 && level >= 30) {
				SpellBook2(pc, item);
			} else if (itemId >= 40249 && itemId <= 40250 && level >= 40) {
				SpellBook2(pc, item);
			} else if (itemId >= 40251 && itemId <= 40252 && level >= 50) {
				SpellBook2(pc, item);
			} else if (itemId == 40253 && level >= 30) {
				SpellBook2(pc, item);
			} else if (itemId == 40254 && level >= 40) {
				SpellBook2(pc, item);
			} else if (itemId == 40255 && level >= 50) {
				SpellBook2(pc, item);
			} else if (itemId == 40256 && level >= 30) {
				SpellBook2(pc, item);
			} else if (itemId == 40257 && level >= 40) {
				SpellBook2(pc, item);
			} else if (itemId >= 40258 && itemId <= 40259 && level >= 50) {
				SpellBook2(pc, item);
			} else if (itemId >= 40260 && itemId <= 40261 && level >= 30) {
				SpellBook2(pc, item);
			} else if (itemId == 40262 && level >= 40) {
				SpellBook2(pc, item);
			} else if (itemId >= 40263 && itemId <= 40264 && level >= 50) {
				SpellBook2(pc, item);
			} else if (itemId >= 41149 && itemId <= 41150 && level >= 50) {
				SpellBook2(pc, item);
			} else if (itemId == 41151 && level >= 40) {
				SpellBook2(pc, item);
			} else if (itemId >= 41152 && itemId <= 41153 && level >= 50) {
				SpellBook2(pc, item);
			} else if (itemId == 50001 && pc.getLevel() >= 50) { // Added NM elf
																	// crystal.
																	// Do not
																	// remove.
				SpellBook2(pc, item);
			}
		} else {
			pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
		}
	}

	private boolean isLearnElfMagic(L1PcInstance pc) {
		int x = pc.getX();
		int y = pc.getY();
		int map = pc.getMapId();
		return x >= 32786 && x <= 32797 && y >= 32842 && y <= 32859
				&& map == 75
				|| pc.getLocation().isInScreen(new Point(33055, 32336))
				&& map == 4;
	}

	private void SpellBook(L1PcInstance pc, L1ItemInstance item,
			boolean isLawful) {
		String s = "";
		int i = 0;
		int level1 = 0;
		int level2 = 0;
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		int j2 = 0;
		int k2 = 0;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		int i4 = 0;
		int j4 = 0;
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int j5 = 0;
		int k5 = 0;
		int l5 = 0;
		int i6 = 0;
		for (int skillId = 1; skillId < 81; skillId++) {
			L1Skill l1skills = SkillTable.getInstance().findBySkillId(skillId);
			String s1 = "Spellbook(" + l1skills.getName() + ")";
			if (item.getItem().getName().equalsIgnoreCase(s1)) {
				int skillLevel = l1skills.getSkillLevel();
				int i7 = l1skills.getId();
				s = l1skills.getName();
				i = l1skills.getSkillId();
				switch (skillLevel) {
				case 1: // '\001'
					level1 = i7;
					break;

				case 2: // '\002'
					level2 = i7;
					break;

				case 3: // '\003'
					l = i7;
					break;

				case 4: // '\004'
					i1 = i7;
					break;

				case 5: // '\005'
					j1 = i7;
					break;

				case 6: // '\006'
					k1 = i7;
					break;

				case 7: // '\007'
					l1 = i7;
					break;

				case 8: // '\b'
					i2 = i7;
					break;

				case 9: // '\t'
					j2 = i7;
					break;

				case 10: // '\n'
					k2 = i7;
					break;

				case 11: // '\013'
					l2 = i7;
					break;

				case 12: // '\f'
					i3 = i7;
					break;

				case 13: // '\r'
					j3 = i7;
					break;

				case 14: // '\016'
					k3 = i7;
					break;

				case 15: // '\017'
					l3 = i7;
					break;

				case 16: // '\020'
					i4 = i7;
					break;

				case 17: // '\021'
					j4 = i7;
					break;

				case 18: // '\022'
					k4 = i7;
					break;

				case 19: // '\023'
					l4 = i7;
					break;

				case 20: // '\024'
					i5 = i7;
					break;

				case 21: // '\025'
					j5 = i7;
					break;

				case 22: // '\026'
					k5 = i7;
					break;

				case 23: // '\027'
					l5 = i7;
					break;

				case 24: // '\030'
					i6 = i7;
					break;
				}
			}
		}

		int objid = pc.getId();
		pc.sendPackets(new S_AddSkill(level1, level2, l, i1, j1, k1, l1, i2,
				j2, k2, l2, i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6,
				0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(objid, isLawful ? 224
				: 231);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillTable.getInstance().spellMastery(objid, i, s, 0, 0);
		pc.getInventory().removeItem(item, 1);
	}

	private void SpellBook1(L1PcInstance pc, L1ItemInstance l1iteminstance,
			ClientThread clientthread) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		int j2 = 0;
		int k2 = 0;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		int i4 = 0;
		int j4 = 0;
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int j5 = 0;
		int k5 = 0;
		int l5 = 0;
		int i6 = 0;
		for (int j6 = 97; j6 < 112; j6++) {
			L1Skill l1skills = SkillTable.getInstance().findBySkillId(j6);
			String s1 = "Dark Spirit Crystal(" + l1skills.getName() + ")";
			if (l1iteminstance.getItem().getName().equalsIgnoreCase(s1)) {
				int l6 = l1skills.getSkillLevel();
				int i7 = l1skills.getId();
				s = l1skills.getName();
				i = l1skills.getSkillId();
				switch (l6) {
				case 1: // '\001'
					j = i7;
					break;

				case 2: // '\002'
					k = i7;
					break;

				case 3: // '\003'
					l = i7;
					break;

				case 4: // '\004'
					i1 = i7;
					break;

				case 5: // '\005'
					j1 = i7;
					break;

				case 6: // '\006'
					k1 = i7;
					break;

				case 7: // '\007'
					l1 = i7;
					break;

				case 8: // '\b'
					i2 = i7;
					break;

				case 9: // '\t'
					j2 = i7;
					break;

				case 10: // '\n'
					k2 = i7;
					break;

				case 11: // '\013'
					l2 = i7;
					break;

				case 12: // '\f'
					i3 = i7;
					break;

				case 13: // '\r'
					j3 = i7;
					break;

				case 14: // '\016'
					k3 = i7;
					break;

				case 15: // '\017'
					l3 = i7;
					break;

				case 16: // '\020'
					i4 = i7;
					break;

				case 17: // '\021'
					j4 = i7;
					break;

				case 18: // '\022'
					k4 = i7;
					break;

				case 19: // '\023'
					l4 = i7;
					break;

				case 20: // '\024'
					i5 = i7;
					break;

				case 21: // '\025'
					j5 = i7;
					break;

				case 22: // '\026'
					k5 = i7;
					break;

				case 23: // '\027'
					l5 = i7;
					break;

				case 24: // '\030'
					i6 = i7;
					break;
				}
			}
		}

		int k6 = pc.getId();
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2, k2, l2,
				i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6, 0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 231);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	private void SpellBook2(L1PcInstance pc, L1ItemInstance l1iteminstance) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		int j2 = 0;
		int k2 = 0;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		int i4 = 0;
		int j4 = 0;
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int j5 = 0;
		int k5 = 0;
		int l5 = 0;
		int i6 = 0;
		for (int j6 = 129; j6 <= 176; j6++) {
			L1Skill l1skills = SkillTable.getInstance().findBySkillId(j6);
			String s1 = "Spirit Crystal(" + l1skills.getName() + ")";
			if (l1iteminstance.getItem().getName().equalsIgnoreCase(s1)) {
				if (!pc.isGm() && l1skills.getAttr() != 0
						&& pc.getElfAttr() != l1skills.getAttr()) {
					if (pc.getElfAttr() == 0 || pc.getElfAttr() == 1
							|| pc.getElfAttr() == 2 || pc.getElfAttr() == 4
							|| pc.getElfAttr() == 8) {
						pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
						return;
					}
				}
				int l6 = l1skills.getSkillLevel();
				int i7 = l1skills.getId();
				s = l1skills.getName();
				i = l1skills.getSkillId();
				switch (l6) {
				case 1: // '\001'
					j = i7;
					break;

				case 2: // '\002'
					k = i7;
					break;

				case 3: // '\003'
					l = i7;
					break;

				case 4: // '\004'
					i1 = i7;
					break;

				case 5: // '\005'
					j1 = i7;
					break;

				case 6: // '\006'
					k1 = i7;
					break;

				case 7: // '\007'
					l1 = i7;
					break;

				case 8: // '\b'
					i2 = i7;
					break;

				case 9: // '\t'
					j2 = i7;
					break;

				case 10: // '\n'
					k2 = i7;
					break;

				case 11: // '\013'
					l2 = i7;
					break;

				case 12: // '\f'
					i3 = i7;
					break;

				case 13: // '\r'
					j3 = i7;
					break;

				case 14: // '\016'
					k3 = i7;
					break;

				case 15: // '\017'
					l3 = i7;
					break;

				case 16: // '\020'
					i4 = i7;
					break;

				case 17: // '\021'
					j4 = i7;
					break;

				case 18: // '\022'
					k4 = i7;
					break;

				case 19: // '\023'
					l4 = i7;
					break;

				case 20: // '\024'
					i5 = i7;
					break;

				case 21: // '\025'
					j5 = i7;
					break;

				case 22: // '\026'
					k5 = i7;
					break;

				case 23: // '\027'
					l5 = i7;
					break;

				case 24: // '\030'
					i6 = i7;
					break;
				}
			}
		}

		int k6 = pc.getId();
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2, k2, l2,
				i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6, 0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	private void SpellBook3(L1PcInstance pc, L1ItemInstance l1iteminstance,
			ClientThread clientthread) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		int j2 = 0;
		int k2 = 0;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		int i4 = 0;
		int j4 = 0;
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int j5 = 0;
		int k5 = 0;
		int l5 = 0;
		int i6 = 0;
		for (int j6 = 87; j6 <= 91; j6++) {
			L1Skill l1skills = SkillTable.getInstance().findBySkillId(j6);
			String s1 = (new StringBuilder()).append("TechnicalDocument(")
					.append(l1skills.getName()).append(")").toString();
			if (l1iteminstance.getItem().getName().equalsIgnoreCase(s1)) {
				int l6 = l1skills.getSkillLevel();
				int i7 = l1skills.getId();
				s = l1skills.getName();
				i = l1skills.getSkillId();
				switch (l6) {
				case 1: // '\001'
					j = i7;
					break;

				case 2: // '\002'
					k = i7;
					break;

				case 3: // '\003'
					l = i7;
					break;

				case 4: // '\004'
					i1 = i7;
					break;

				case 5: // '\005'
					j1 = i7;
					break;

				case 6: // '\006'
					k1 = i7;
					break;

				case 7: // '\007'
					l1 = i7;
					break;

				case 8: // '\b'
					i2 = i7;
					break;

				case 9: // '\t'
					j2 = i7;
					break;

				case 10: // '\n'
					k2 = i7;
					break;

				case 11: // '\013'
					l2 = i7;
					break;

				case 12: // '\f'
					i3 = i7;
					break;

				case 13: // '\r'
					j3 = i7;
					break;

				case 14: // '\016'
					k3 = i7;
					break;

				case 15: // '\017'
					l3 = i7;
					break;

				case 16: // '\020'
					i4 = i7;
					break;

				case 17: // '\021'
					j4 = i7;
					break;

				case 18: // '\022'
					k4 = i7;
					break;

				case 19: // '\023'
					l4 = i7;
					break;

				case 20: // '\024'
					i5 = i7;
					break;

				case 21: // '\025'
					j5 = i7;
					break;

				case 22: // '\026'
					k5 = i7;
					break;

				case 23: // '\027'
					l5 = i7;
					break;

				case 24: // '\030'
					i6 = i7;
					break;
				}
			}
		}

		int k6 = pc.getId();
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2, k2, l2,
				i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6, 0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	private void SpellBook4(L1PcInstance pc, L1ItemInstance l1iteminstance,
			ClientThread clientthread) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		int j2 = 0;
		int k2 = 0;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		int i4 = 0;
		int j4 = 0;
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int j5 = 0;
		int k5 = 0;
		int l5 = 0;
		int i6 = 0;
		for (int j6 = 113; j6 < 121; j6++) {
			L1Skill l1skills = SkillTable.getInstance().findBySkillId(j6);
			String s1 = "Spellbook(" + l1skills.getName() + ")";
			if (l1iteminstance.getItem().getName().equalsIgnoreCase(s1)) {
				int l6 = l1skills.getSkillLevel();
				int i7 = l1skills.getId();
				s = l1skills.getName();
				i = l1skills.getSkillId();
				switch (l6) {
				case 1: // '\001'
					j = i7;
					break;

				case 2: // '\002'
					k = i7;
					break;

				case 3: // '\003'
					l = i7;
					break;

				case 4: // '\004'
					i1 = i7;
					break;

				case 5: // '\005'
					j1 = i7;
					break;

				case 6: // '\006'
					k1 = i7;
					break;

				case 7: // '\007'
					l1 = i7;
					break;

				case 8: // '\b'
					i2 = i7;
					break;

				case 9: // '\t'
					j2 = i7;
					break;

				case 10: // '\n'
					k2 = i7;
					break;

				case 11: // '\013'
					l2 = i7;
					break;

				case 12: // '\f'
					i3 = i7;
					break;

				case 13: // '\r'
					j3 = i7;
					break;

				case 14: // '\016'
					k3 = i7;
					break;

				case 15: // '\017'
					l3 = i7;
					break;

				case 16: // '\020'
					i4 = i7;
					break;

				case 17: // '\021'
					j4 = i7;
					break;

				case 18: // '\022'
					k4 = i7;
					break;

				case 19: // '\023'
					l4 = i7;
					break;

				case 20: // '\024'
					i5 = i7;
					break;

				case 21: // '\025'
					j5 = i7;
					break;

				case 22: // '\026'
					k5 = i7;
					break;

				case 23: // '\027'
					l5 = i7;
					break;

				case 24: // '\030'
					i6 = i7;
					break;
				}
			}
		}

		int k6 = pc.getId();
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2, k2, l2,
				i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6, 0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	private void SpellBook5(L1PcInstance pc, L1ItemInstance l1iteminstance,
			ClientThread clientthread) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		int j2 = 0;
		int k2 = 0;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		int i4 = 0;
		int j4 = 0;
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int j5 = 0;
		int k5 = 0;
		int l5 = 0;
		int i6 = 0;
		int i8 = 0;
		int j8 = 0;
		int k8 = 0;
		int l8 = 0;
		for (int j6 = 181; j6 <= 195; j6++) {
			L1Skill l1skills = SkillTable.getInstance().findBySkillId(j6);
			String s1 = "Dragon Tablet(" + l1skills.getName() + ")";
			if (l1iteminstance.getItem().getName().equalsIgnoreCase(s1)) {
				int l6 = l1skills.getSkillLevel();
				int i7 = l1skills.getId();
				s = l1skills.getName();
				i = l1skills.getSkillId();
				switch (l6) {
				case 1: // '\001'
					j = i7;
					break;

				case 2: // '\002'
					k = i7;
					break;

				case 3: // '\003'
					l = i7;
					break;

				case 4: // '\004'
					i1 = i7;
					break;

				case 5: // '\005'
					j1 = i7;
					break;

				case 6: // '\006'
					k1 = i7;
					break;

				case 7: // '\007'
					l1 = i7;
					break;

				case 8: // '\b'
					i2 = i7;
					break;

				case 9: // '\t'
					j2 = i7;
					break;

				case 10: // '\n'
					k2 = i7;
					break;

				case 11: // '\013'
					l2 = i7;
					break;

				case 12: // '\f'
					i3 = i7;
					break;

				case 13: // '\r'
					j3 = i7;
					break;

				case 14: // '\016'
					k3 = i7;
					break;

				case 15: // '\017'
					l3 = i7;
					break;

				case 16: // '\020'
					i4 = i7;
					break;

				case 17: // '\021'
					j4 = i7;
					break;

				case 18: // '\022'
					k4 = i7;
					break;

				case 19: // '\023'
					l4 = i7;
					break;

				case 20: // '\024'
					i5 = i7;
					break;

				case 21: // '\025'
					j5 = i7;
					break;

				case 22: // '\026'
					k5 = i7;
					break;

				case 23: // '\027'
					l5 = i7;
					break;

				case 24: // '\030'
					i6 = i7;
					break;

				case 25: // '\031'
					j8 = i7;
					break;

				case 26: // '\032'
					k8 = i7;
					break;

				case 27: // '\033'
					l8 = i7;
					break;
				case 28: // '\034'
					i8 = i7;
					break;
				}
			}
		}

		int k6 = pc.getId();
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2, k2, l2,
				i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6, j8, k8, l8,
				i8));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	private void SpellBook6(L1PcInstance pc, L1ItemInstance l1iteminstance,
			ClientThread clientthread) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		int j2 = 0;
		int k2 = 0;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		int i4 = 0;
		int j4 = 0;
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int j5 = 0;
		int k5 = 0;
		int l5 = 0;
		int i6 = 0;
		int i8 = 0;
		int j8 = 0;
		int k8 = 0;
		int l8 = 0;
		for (int j6 = 201; j6 <= 220; j6++) {
			L1Skill l1skills = SkillTable.getInstance().findBySkillId(j6);
			String s1 = "Memory Crystal(" + l1skills.getName() + ")";
			if (l1iteminstance.getItem().getName().equalsIgnoreCase(s1)) {
				int l6 = l1skills.getSkillLevel();
				int i7 = l1skills.getId();
				s = l1skills.getName();
				i = l1skills.getSkillId();
				switch (l6) {
				case 1: // '\001'
					j = i7;
					break;

				case 2: // '\002'
					k = i7;
					break;

				case 3: // '\003'
					l = i7;
					break;

				case 4: // '\004'
					i1 = i7;
					break;

				case 5: // '\005'
					j1 = i7;
					break;

				case 6: // '\006'
					k1 = i7;
					break;

				case 7: // '\007'
					l1 = i7;
					break;

				case 8: // '\b'
					i2 = i7;
					break;

				case 9: // '\t'
					j2 = i7;
					break;

				case 10: // '\n'
					k2 = i7;
					break;

				case 11: // '\013'
					l2 = i7;
					break;

				case 12: // '\f'
					i3 = i7;
					break;

				case 13: // '\r'
					j3 = i7;
					break;

				case 14: // '\016'
					k3 = i7;
					break;

				case 15: // '\017'
					l3 = i7;
					break;

				case 16: // '\020'
					i4 = i7;
					break;

				case 17: // '\021'
					j4 = i7;
					break;

				case 18: // '\022'
					k4 = i7;
					break;

				case 19: // '\023'
					l4 = i7;
					break;

				case 20: // '\024'
					i5 = i7;
					break;

				case 21: // '\025'
					j5 = i7;
					break;

				case 22: // '\026'
					k5 = i7;
					break;

				case 23: // '\027'
					l5 = i7;
					break;

				case 24: // '\030'
					i6 = i7;
					break;

				case 25: // '\031'
					j8 = i7;
					break;

				case 26: // '\032'
					k8 = i7;
					break;

				case 27: // '\033'
					l8 = i7;
					break;
				case 28: // '\034'
					i8 = i7;
					break;
				}
			}
		}

		int k6 = pc.getId();
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2, k2, l2,
				i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6, j8, k8, l8,
				i8));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	private void doWandAction(L1PcInstance user, L1Object target) {
		if (user.getId() == target.getId()) {
			return;
		}
		if (user.glanceCheck(target.getX(), target.getY()) == false) {
			return;
		}

		int dmg = (_random.nextInt(11) - 5) + user.getStr();
		dmg = Math.max(1, dmg);

		if (target instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) target;
			if (pc.getMap().isSafetyZone(pc.getLocation())
					|| user.checkNonPvP(user, pc)) {
				return;
			}
			if (pc.hasSkillEffect(50) == true || pc.hasSkillEffect(78) == true
					|| pc.hasSkillEffect(157) == true) {
				return;
			}

			int newHp = pc.getCurrentHp() - dmg;
			if (newHp > 0) {
				pc.setCurrentHp(newHp);
			} else if (newHp <= 0 && pc.isGm()) {
				pc.setCurrentHp(pc.getMaxHp());
			} else if (newHp <= 0 && !pc.isGm()) {
				pc.death(user);
			}
		} else if (target instanceof L1MonsterInstance) {
			L1MonsterInstance mob = (L1MonsterInstance) target;
			mob.receiveDamage(user, dmg);
		} else if (target instanceof L1NpcInstance) {
			//this isn't used best I can tell
			//L1NpcInstance npc = (L1NpcInstance) target;
		}
	}

	private void polyAction(L1PcInstance attacker, L1Character cha) {
		boolean isSameClan = false;
		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			if (pc.getClanid() != 0 && attacker.getClanid() == pc.getClanid()) {
				isSameClan = true;
			}
		}
		if (attacker.getId() != cha.getId() && !isSameClan) {
			int probability = 3 * (attacker.getLevel() - cha.getLevel()) + 100
					- cha.getMr();
			int rnd = _random.nextInt(100) + 1;
			if (rnd > probability) {
				return;
			}
		}

		int[] polyArray = { 29, 945, 947, 979, 1037, 1039, 3860, 3861, 3862,
				3863, 3864, 3865, 3904, 3906, 95, 146, 2374, 2376, 2377, 2378,
				3866, 3867, 3868, 3869, 3870, 3871, 3872, 3873, 3874, 3875,
				3876 };

		int pid = _random.nextInt(polyArray.length);
		int polyId = polyArray[pid];

		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			int awakeSkillId = pc.getAwakeSkillId();
			if (awakeSkillId == AWAKEN_ANTHARAS
					|| awakeSkillId == AWAKEN_FAFURION
					|| awakeSkillId == AWAKEN_VALAKAS) {
				pc.sendPackets(new S_ServerMessage(1384)); // You cannot transform in the current condition.
				return;
			}

			if (pc.getInventory().checkEquipped(20281)) {
				pc.sendPackets(new S_ShowPolyList(pc.getId()));
				if (!pc.isShapeChange()) {
					pc.setShapeChange(true);
				}
				pc.sendPackets(new S_ServerMessage(966)); // Are protected by magical power.
			} else {
				L1Skill skillTemp = SkillTable.getInstance().findBySkillId(
						SHAPE_CHANGE);

				L1PolyMorph.doPoly(pc, polyId, skillTemp.getBuffDuration(),
						L1PolyMorph.MORPH_BY_ITEMMAGIC);
				if (attacker.getId() != pc.getId()) {
					pc.sendPackets(new S_ServerMessage(241, attacker.getName())); // 'player' polymorphed you.
				}
			}
		} else if (cha instanceof L1MonsterInstance) {
			L1MonsterInstance mob = (L1MonsterInstance) cha;
			if (mob.getLevel() < 50) {
				int npcId = mob.getNpcTemplate().get_npcId();
				if (npcId != 45338 && npcId != 45370 && npcId != 45456 //
						&& npcId != 45464 && npcId != 45473 && npcId != 45488 //
						&& npcId != 45497 && npcId != 45516 && npcId != 45529 //
						&& npcId != 45458) { //
					L1Skill skillTemp = SkillTable.getInstance().findBySkillId(
							SHAPE_CHANGE);
					L1PolyMorph.doPoly(mob, polyId,
							skillTemp.getBuffDuration(),
							L1PolyMorph.MORPH_BY_ITEMMAGIC);
				}
			}
		}
	}

	private static void cancelAbsoluteBarrier(L1PcInstance pc) {
		if (pc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			pc.killSkillEffectTimer(ABSOLUTE_BARRIER);
			pc.startHpRegeneration();
			pc.startMpRegeneration();
			pc.startMpRegenerationByDoll();
		}
	}

	private boolean createNewItem(L1PcInstance pc, int item_id, int count) {
		L1ItemInstance item = ItemTable.getInstance().createItem(item_id);
		if (item != null) {
			item.setCount(count);
			if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
				pc.getInventory().storeItem(item);
			} else {
				L1World.getInstance()
						.getInventory(pc.getX(), pc.getY(), pc.getMapId())
						.storeItem(item);
			}
			pc.sendPackets(new S_ServerMessage(403, item.getLogName())); // obtained 'item'.
			return true;
		} else {
			return false;
		}
	}

	private static boolean properPlaceForToiCharm(final L1PcInstance pc,
			int charmId) {
		if (Config.USE_TOI_CHARM_ANYWHERE && pc.getMap().isEscapable())
			return true;

		int x = pc.getX();
		int y = pc.getY();
		int map = pc.getMapId();
		switch (charmId) {
		case 40289:
		case 40293: // 11,51F amulet
			return x >= 32816 && x <= 32821 && y >= 32778 && y <= 32783
					&& map == 101;
		case 40290:
		case 40294: // 21,61F amulet
			return x >= 32815 && x <= 32820 && y >= 32815 && y <= 32820
					&& map == 101;
		case 40291:
		case 40295: // 31,71F amulet
			return x >= 32779 && x <= 32784 && y >= 32778 && y <= 32783
					&& map == 101;
		case 40292:
		case 40296: // 41,81F amulet
			return x >= 32779 && x <= 32784 && y >= 32815 && y <= 32820
					&& map == 101;
		case 40297: // 91F amulet
			return x >= 32706 && x <= 32710 && y >= 32909 && y <= 32913
					&& map == 190;
		default:
			return false;
		}
	}

	private static void useToiTeleportAmulet(L1PcInstance pc, int itemId,
			L1ItemInstance item) {
		if (properPlaceForToiCharm(pc, itemId)) {
			L1Item template = item.getItem();
			L1Teleport.teleport(pc, template.get_locx(), template.get_locy(),
					template.get_mapid(), 5, true);
		} else
			pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
	}

	private boolean writeLetter(int itemId, L1PcInstance pc, int letterCode,
			String letterReceiver, byte[] letterText) {

		int newItemId = 0;
		if (itemId == 40310) {
			newItemId = 49016;
		} else if (itemId == 40730) {
			newItemId = 49020;
		} else if (itemId == 40731) {
			newItemId = 49022;
		} else if (itemId == 40732) {
			newItemId = 49024;
		}
		L1ItemInstance item = ItemTable.getInstance().createItem(newItemId);
		if (item == null) {
			return false;
		}
		item.setCount(1);

		if (sendLetter(pc, letterReceiver, item, true)) {
			saveLetter(item.getId(), letterCode, pc.getName(), letterReceiver,
					letterText);
		} else {
			return false;
		}
		return true;
	}

	private boolean writeClanLetter(int itemId, L1PcInstance pc,
			int letterCode, String letterReceiver, byte[] letterText) {
		L1Clan targetClan = null;
		for (L1Clan clan : L1World.getInstance().getAllClans()) {
			if (clan.getClanName().toLowerCase()
					.equals(letterReceiver.toLowerCase())) {
				targetClan = clan;
				break;
			}
		}
		if (targetClan == null) {
			pc.sendPackets(new S_ServerMessage(434)); // There are no recipients.
			return false;
		}

		String memberName[] = targetClan.getAllMembers();
		for (int i = 0; i < memberName.length; i++) {
			L1ItemInstance item = ItemTable.getInstance().createItem(49016);
			if (item == null) {
				return false;
			}
			item.setCount(1);

			if (sendLetter(pc, memberName[i], item, false)) {
				saveLetter(item.getId(), letterCode, pc.getName(),
						memberName[i], letterText);
			}
		}
		return true;
	}

	private boolean sendLetter(L1PcInstance pc, String name,
			L1ItemInstance item, boolean isFailureMessage) {
		L1PcInstance target = L1World.getInstance().getPlayer(name);
		if (target != null) {
			if (target.getInventory().checkAddItem(item, 1) == L1Inventory.OK) {
				target.getInventory().storeItem(item);
				target.sendPackets(new S_SkillSound(target.getId(), 1091));
				target.sendPackets(new S_ServerMessage(428)); // You have a new letter.
			} else {
				if (isFailureMessage) {
					pc.sendPackets(new S_ServerMessage(942)); // The other party's belongings are too heavy for you to give anymore.
				}
				return false;
			}
		} else {
			if (CharacterTable.doesCharNameExist(name)) {
				try {
					int targetId = CharacterTable.getInstance()
							.restoreCharacter(name).getId();
					CharactersItemStorage storage = CharactersItemStorage
							.create();
					if (storage.getItemCount(targetId) < 180) {
						storage.storeItem(targetId, item);
					} else {
						if (isFailureMessage) {
							pc.sendPackets(new S_ServerMessage(942)); // The other party's belongings are too heavy for you to give anymore.
						}
						return false;
					}
				} catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			} else {
				if (isFailureMessage) {
					pc.sendPackets(new S_ServerMessage(109, name)); // There is no player named 'player'.
				}
				return false;
			}
		}
		return true;
	}

	private void saveLetter(int itemObjectId, int code, String sender,
			String receiver, byte[] text) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		TimeZone tz = TimeZone.getTimeZone(Config.TIME_ZONE);
		String date = sdf.format(Calendar.getInstance(tz).getTime());
		// subject, content
		int spacePosition1 = 0;
		int spacePosition2 = 0;
		for (int i = 0; i < text.length; i += 2) {
			if (text[i] == 0 && text[i + 1] == 0) {
				if (spacePosition1 == 0) {
					spacePosition1 = i;
				} else if (spacePosition1 != 0 && spacePosition2 == 0) {
					spacePosition2 = i;
					break;
				}
			}
		}
		// letter
		int subjectLength = spacePosition1 + 2;
		int contentLength = spacePosition2 - spacePosition1;
		if (contentLength <= 0) {
			contentLength = 1;
		}
		byte[] subject = new byte[subjectLength];
		byte[] content = new byte[contentLength];
		System.arraycopy(text, 0, subject, 0, subjectLength);
		System.arraycopy(text, subjectLength, content, 0, contentLength);
		LetterTable.getInstance().writeLetter(itemObjectId, code, sender,
				receiver, date, 0, subject, content);
	}

	private boolean withdrawPet(L1PcInstance pc, int itemObjectId) {
		if (!pc.getMap().isTakePets()) {
			pc.sendPackets(new S_ServerMessage(563)); // You can't use it here.
			return false;
		}
		pc.useDogCollar(itemObjectId);
		return true;
	}

	private void startFishing(L1PcInstance pc, int itemId, int fishX, int fishY) {
		if (pc.getMapId() != 5124 || fishX <= 32789 || fishX >= 32813
				|| fishY <= 32786 || fishY >= 32812) {
			pc.sendPackets(new S_ServerMessage(1138)); // You can't throw the fishing pole here.
			return;
		}

		int rodLength = 0;
		if (itemId == 41293) {
			rodLength = 5;
		} else if (itemId == 41294) {
			rodLength = 3;
		}
		if (pc.getMap().isFishingZone(fishX, fishY)) {
			if (pc.getMap().isFishingZone(fishX + 1, fishY)
					&& pc.getMap().isFishingZone(fishX - 1, fishY)
					&& pc.getMap().isFishingZone(fishX, fishY + 1)
					&& pc.getMap().isFishingZone(fishX, fishY - 1)) {
				if (fishX > pc.getX() + rodLength
						|| fishX < pc.getX() - rodLength) {
					pc.sendPackets(new S_ServerMessage(1138)); // You can't throw the fishing pole here.
				} else if (fishY > pc.getY() + rodLength
						|| fishY < pc.getY() - rodLength) {
					pc.sendPackets(new S_ServerMessage(1138)); // You can't throw the fishing pole here.
				} else if (pc.getInventory().consumeItem(41295, 1)) { //
					pc.sendPackets(new S_Fishing(pc.getId(),
							ActionCodes.ACTION_Fishing, fishX, fishY));
					pc.broadcastPacket(new S_Fishing(pc.getId(),
							ActionCodes.ACTION_Fishing, fishX, fishY));
					pc.setFishing(true);
					long time = System.currentTimeMillis() + 10000
							+ _random.nextInt(5) * 1000;
					pc.setFishingTime(time);
					FishingTimeController.getInstance().addMember(pc);
				} else {
					pc.sendPackets(new S_ServerMessage(1137)); // You need a bait in order to fish.
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1138)); // You can't throw the fishing pole here.
			}
		} else {
			pc.sendPackets(new S_ServerMessage(1138)); // You can't throw the fishing pole here.
		}
	}

	private void useResolvent(L1PcInstance pc, L1ItemInstance item,
			L1ItemInstance resolvent) {
		if (item == null || resolvent == null) {
			pc.sendPackets(new S_ServerMessage(79)); // Nothing happened.
			return;
		}

		L1Item template = item.getItem();
		int crystalCount = ResolventTable.getInstance().getCrystalCount(
				template.getItemId());
		if (crystalCount == 0
				|| (template.getType2() == 1 || template.getType2() == 2)
				&& (item.getEnchantLevel() != 0 || item.isEquipped())) {
			pc.sendPackets(new S_ServerMessage(1161)); // It can't be dissolved.
			return;
		}

		int chance = _random.nextInt(100) + 1;
		if (chance >= 1 && chance <= 50) {
			crystalCount = 0;
			pc.sendPackets(new S_ServerMessage(158, item.getName())); // Your 'item' evaporates.
		} else if (chance >= 91 && chance <= 100) {
			crystalCount *= 1.5;
		}

		L1Inventory inventory = pc.getInventory();
		if (crystalCount != 0) {
			L1ItemInstance crystal = ItemTable.getInstance().createItem(41246);
			crystal.setCount(crystalCount);
			if (inventory.checkAddItem(crystal, 1) == L1Inventory.OK) {
				inventory.storeItem(crystal);
				pc.sendPackets(new S_ServerMessage(403, crystal.getLogName())); // obtained 'item'.
			} else {
				L1World.getInstance()
						.getInventory(pc.getX(), pc.getY(), pc.getMapId())
						.storeItem(crystal);
			}
		}
		inventory.removeItem(item, 1);
		inventory.removeItem(resolvent, 1);
	}

	private void useMagicDoll(L1PcInstance pc, int itemId, int itemObjectId) {
		boolean isAppear = true;
		L1DollInstance doll = null;
		Object[] dollList = pc.getDollList().values().toArray();
		for (Object dollObject : dollList) {
			doll = (L1DollInstance) dollObject;
			if (doll.getItemObjId() == itemObjectId) {
				isAppear = false;
				break;
			}
		}

		if (isAppear) {
			if (!pc.getInventory().checkItem(41246, 50)) {
				pc.sendPackets(new S_ServerMessage(337, "$5240")); // Not enough 'Crystal'.
				return;
			}
			if (dollList.length >= Config.MAX_DOLL_COUNT) {
				pc.sendPackets(new S_ServerMessage(319)); // You can't control more monsters.
				return;
			}
			int npcId = 0;
			int dollType = 0;
			if (itemId == 41248) {
				npcId = 80106;
				dollType = L1DollInstance.DOLLTYPE_BUGBEAR;
			} else if (itemId == 41249) {
				npcId = 80107;
				dollType = L1DollInstance.DOLLTYPE_SUCCUBUS;
			} else if (itemId == 41250) {
				npcId = 80108;
				dollType = L1DollInstance.DOLLTYPE_WAREWOLF;
			} else if (itemId == 49037) {
				npcId = 80129;
				dollType = L1DollInstance.DOLLTYPE_ELDER;
			} else if (itemId == 49038) {
				npcId = 80130;
				dollType = L1DollInstance.DOLLTYPE_CRUSTANCEAN;
			} else if (itemId == 49039) {
				npcId = 80131;
				dollType = L1DollInstance.DOLLTYPE_GOLEM;
			}
			L1Npc template = NpcTable.getInstance().getTemplate(npcId);
			doll = new L1DollInstance(template, pc, dollType, itemObjectId);
			pc.sendPackets(new S_SkillSound(doll.getId(), 5935));
			pc.broadcastPacket(new S_SkillSound(doll.getId(), 5935));
			pc.sendPackets(new S_SkillIconGFX(56, 1800));
			pc.sendPackets(new S_OwnCharStatus(pc));
			pc.getInventory().consumeItem(41246, 50);
		} else {
			pc.sendPackets(new S_SkillSound(doll.getId(), 5936));
			pc.broadcastPacket(new S_SkillSound(doll.getId(), 5936));
			doll.deleteDoll();
			pc.sendPackets(new S_SkillIconGFX(56, 0));
			pc.sendPackets(new S_OwnCharStatus(pc));
		}
	}

	private static class Recipe {
		int[] ingredients;
		int usual;
		int special;

		public Recipe(int[] ingredients, int usual, int special) {
			this.ingredients = ingredients;
			this.usual = usual;
			this.special = special;
		}
	}

	// Keep these in order!
	private static final Recipe[] recipes = new Recipe[] {
			new Recipe(new int[] { 40057 }, 41277, 41285),
			new Recipe(new int[] { 41275 }, 41278, 41286),
			new Recipe(new int[] { 41263, 41265 }, 41279, 41287),
			new Recipe(new int[] { 41274, 41267 }, 41280, 41288),
			new Recipe(new int[] { 40062, 40069, 40064 }, 41281, 41289),
			new Recipe(new int[] { 40056, 40060, 40061 }, 41282, 41290),
			new Recipe(new int[] { 41276 }, 41283, 41291),
			new Recipe(new int[] { 40499, 40060 }, 41284, 41292),
			new Recipe(new int[] { 49040, 49048 }, 49049, 49057),
			new Recipe(new int[] { 49041, 49048 }, 49050, 49058),
			new Recipe(new int[] { 49042, 41265, 49048 }, 49051, 49059),
			new Recipe(new int[] { 49043, 49048 }, 49052, 49060),
			new Recipe(new int[] { 49044, 49048 }, 49053, 49061),
			new Recipe(new int[] { 49045, 49048 }, 49054, 49062),
			new Recipe(new int[] { 49046, 49048 }, 49055, 49063),
			new Recipe(new int[] { 49047, 40499, 49048 }, 49056, 49064),
			new Recipe(new int[] { 49048, 49243, 49260 }, 49244, 49252),
			new Recipe(new int[] { 49048, 49243, 49261 }, 49245, 49253),
			new Recipe(new int[] { 49048, 49243, 49262 }, 49246, 49254),
			new Recipe(new int[] { 49048, 49243, 49263 }, 49247, 49255),
			new Recipe(new int[] { 49048, 49243, 49264 }, 49248, 49256),
			new Recipe(new int[] { 49048, 49243, 49265 }, 49249, 49257),
			new Recipe(new int[] { 49048, 49243, 49266 }, 49250, 49258),
			new Recipe(new int[] { 49048, 49243, 49267 }, 49251, 49259), };

	private void makeCooking(L1PcInstance pc, int cookNo) {
		boolean isNearFire = false;
		for (L1Object obj : L1World.getInstance().getVisibleObjects(pc, 3)) {
			if (obj instanceof L1EffectInstance) {
				L1EffectInstance effect = (L1EffectInstance) obj;
				if (effect.getGfxId() == 5943) {
					isNearFire = true;
					break;
				}
			}
		}
		if (!isNearFire) {
			pc.sendPackets(new S_ServerMessage(1160)); // You need a bonfire in order to cook.
			return;
		}
		if (pc.getMaxWeight() <= pc.getInventory().getWeight()) {
			pc.sendPackets(new S_ServerMessage(1103)); // Your personal belongings are too heavy to make the dish.
			return;
		}
		if (pc.hasSkillEffect(COOKING_NOW)) {
			return;
		}
		pc.setSkillEffect(COOKING_NOW, Config.COOKING_TIME * 1000);

		Recipe recipe = recipes[cookNo];
		L1PcInventory inventory = pc.getInventory();
		for (int ingredient : recipe.ingredients)
			if (!inventory.checkItem(ingredient, 1)) {
				pc.sendPackets(new S_ServerMessage(1102)); // You don't have enough ingredients to make the dish.
				return;
			}
		for (int ingredient : recipe.ingredients)
			inventory.consumeItem(ingredient, 1);
		int chance = _random.nextInt(100) + 1;
		if (chance >= 1 && chance <= 90) {
			createNewItem(pc, recipe.usual, 1);
			pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
		} else if (chance >= 91 && chance <= 95) {
			createNewItem(pc, recipe.special, 1);
			pc.sendAndBroadcast(new S_SkillSound(pc.getId(), 6390));
		} else {
			pc.sendPackets(new S_ServerMessage(1101)); // You failed at cooking the dish.
			pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
		}
	}

	private void useFurnitureItem(L1PcInstance pc, int itemId, int itemObjectId) {
		if (!L1HouseLocation.isInHouse(pc.getX(), pc.getY(), pc.getMapId())) {
			pc.sendPackets(new S_ServerMessage(563)); // You can't use it here.
			return;
		}

		boolean isAppear = true;
		L1FurnitureInstance furniture = null;
		for (L1Object l1object : L1World.getInstance().getObject()) {
			if (l1object instanceof L1FurnitureInstance) {
				furniture = (L1FurnitureInstance) l1object;
				if (furniture.getItemObjId() == itemObjectId) {
					isAppear = false;
					break;
				}
			}
		}

		if (isAppear) {
			if (pc.getHeading() != 0 && pc.getHeading() != 2) {
				return;
			}
			int npcId = 0;
			switch (npcId) {
			case 41383:
				npcId = 80109;
				break;
			case 41384:
				npcId = 80110;
				break;
			case 41385:
				npcId = 80113;
				break;
			case 41386:
				npcId = 80114;
				break;
			case 41387:
				npcId = 80115;
				break;
			case 41388:
				npcId = 80124;
				break;
			case 41389:
				npcId = 80118;
				break;
			case 41390:
				npcId = 80119;
				break;
			case 41391:
				npcId = 80120;
				break;
			case 41392:
				npcId = 80121;
				break;
			case 41393:
				npcId = 80126;
				break;
			case 41394:
				npcId = 80125;
				break;
			case 41395:
				npcId = 80111;
				break;
			case 41396:
				npcId = 80112;
				break;
			case 41397:
				npcId = 80116;
				break;
			case 41398:
				npcId = 80117;
				break;
			case 41399:
				npcId = 80122;
				break;
			case 41400:
				npcId = 80123;
				break;
			}

			try {
				L1Npc l1npc = NpcTable.getInstance().getTemplate(npcId);
				if (l1npc != null) {
					// unused
					// Object obj = null;
					try {
						String s = l1npc.getImpl();
						Constructor<?> constructor = Class.forName(
								"l1j.server.server.model.Instance." + s
										+ "Instance").getConstructors()[0];
						Object aobj[] = { l1npc };
						furniture = (L1FurnitureInstance) constructor
								.newInstance(aobj);
						furniture.setId(IdFactory.getInstance().nextId());
						furniture.setMap(pc.getMapId());
						if (pc.getHeading() == 0) {
							furniture.setX(pc.getX());
							furniture.setY(pc.getY() - 1);
						} else if (pc.getHeading() == 2) {
							furniture.setX(pc.getX() + 1);
							furniture.setY(pc.getY());
						}
						furniture.setHomeX(furniture.getX());
						furniture.setHomeY(furniture.getY());
						furniture.setHeading(0);
						furniture.setItemObjId(itemObjectId);

						L1World.getInstance().storeObject(furniture);
						L1World.getInstance().addVisibleObject(furniture);
						FurnitureSpawnTable.getInstance().insertFurniture(
								furniture);
					} catch (Exception e) {
						_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
			} catch (Exception exception) {
			}
		} else {
			furniture.deleteMe();
			FurnitureSpawnTable.getInstance().deleteFurniture(furniture);
		}
	}

	private void useFurnitureRemovalWand(L1PcInstance pc, int targetId,
			L1ItemInstance item) {
		S_AttackPacket s_attackPacket = new S_AttackPacket(pc, 0,
				ActionCodes.ACTION_Wand);
		pc.sendPackets(s_attackPacket);
		pc.broadcastPacket(s_attackPacket);
		int chargeCount = item.getChargeCount();
		if (chargeCount <= 0) {
			return;
		}

		L1Object target = L1World.getInstance().findObject(targetId);
		if (target != null && target instanceof L1FurnitureInstance) {
			L1FurnitureInstance furniture = (L1FurnitureInstance) target;
			furniture.deleteMe();
			FurnitureSpawnTable.getInstance().deleteFurniture(furniture);
			item.setChargeCount(item.getChargeCount() - 1);
			pc.getInventory().updateItem(item, L1PcInventory.COL_CHARGE_COUNT);
		}
	}

	private static final int[] scrollIds = { 40090, 40091, 40092, 40093, 40094 };
	private static final int[] scrollLimits = { 7, 15, 22, 31, 39 };

	private void writeScroll(final L1PcInstance pc, int scrollId, int spellId) {
		if (!IntArrays.contains(scrollIds, scrollId)
				|| spellId > scrollLimits[scrollId - scrollIds[0]]) {
			pc.sendPackets(new S_ServerMessage(591)); // The scroll is too weak to record that strong of a spell.
			return;
		}

		L1ItemInstance scroll = ItemTable.getInstance().createItem(
				40859 + spellId);
		if (scroll == null)
			return;
		final L1PcInventory inventory = pc.getInventory();
		if (inventory.checkAddItem(scroll, 1) == L1Inventory.OK) {
			L1Skill skill = SkillTable.getInstance().findBySkillId(spellId + 1);
			if (pc.getCurrentHp() + 1 < skill.getHpConsume() + 1) {
				pc.sendPackets(new S_ServerMessage(279)); // You don't have enough HP to use the spell.
				return;
			}
			if (pc.getCurrentMp() < skill.getMpConsume()) {
				pc.sendPackets(new S_ServerMessage(278)); // You don't have enough MP to use the spell.
				return;
			}
			if (skill.getItemConsumeId() != 0) {
				if (!pc.getInventory().checkItem(skill.getItemConsumeId(),
						skill.getItemConsumeCount())) {
					pc.sendPackets(new S_ServerMessage(299)); // There are not enough ingredients to use the spell.
					return;
				}
			}
			pc.setCurrentHp(pc.getCurrentHp() - skill.getHpConsume());
			pc.setCurrentMp(pc.getCurrentMp() - skill.getMpConsume());
			int lawful = pc.getLawful() + skill.getLawful();
			if (lawful > 32767) {
				lawful = 32767;
			}
			if (lawful < -32767) {
				lawful = -32767;
			}
			pc.setLawful(lawful);
			if (skill.getItemConsumeId() != 0) {
				inventory.consumeItem(skill.getItemConsumeId(),
						skill.getItemConsumeCount());
			}
			inventory.removeItem(inventory.findItemId(scrollId), 1);
			inventory.storeItem(scroll);
		}
	}

	@Override
	public String getType() {
		return C_ITEM_USE;
	}
}
