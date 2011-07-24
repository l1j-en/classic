/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.clientpackets;

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
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.FurnitureSpawnTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.LetterTable;
import l1j.server.server.datatables.LogEnchantTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.ResolventTable;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.model.Getback;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1SpellBook;
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
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.model.item.L1TreasureBox;
import l1j.server.server.model.poison.L1DamagePoison;
import l1j.server.server.model.skill.L1SkillUse;
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
import l1j.server.server.templates.L1Armor;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.templates.L1EtcItem;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Pet;
import l1j.server.server.templates.L1Skills;
import l1j.server.server.utils.L1SpawnUtil;
import static l1j.server.server.model.skill.L1SkillId.*;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
//
public class C_ItemUSe extends ClientBasePacket {
	private static final String C_ITEM_USE = "[C] C_ItemUSe";
	private static Logger _log = Logger.getLogger(C_ItemUSe.class.getName());
	private static Random _random = new Random();
	private int addtime; // used for stacking. do not remove.

	public C_ItemUSe(byte abyte0[], ClientThread client) throws Exception {
		super(abyte0);
		int itemObjid = readD();

		L1PcInstance pc = client.getActiveChar();
		if (pc.isGhost()) {
			return;
		}
		L1ItemInstance l1iteminstance = pc.getInventory().getItem(itemObjid);

		if (l1iteminstance.getItem().getUseType() == -1) { // none
			pc.sendPackets(new S_ServerMessage(74, l1iteminstance.getLogName()));
			return;
		}
		int pcObjid = pc.getId();
		if (pc.isTeleport()) {
			return;
		}
		if (l1iteminstance == null && pc.isDead() == true) {
			return;
		}
		if (!pc.getMap().isUsableItem()) {
			pc.sendPackets(new S_ServerMessage(563));
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
		int bmapid = 0;
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

		int use_type = l1iteminstance.getItem().getUseType();
		if (itemId == 40088 || itemId == 40096 || itemId == 140088) {
			s = readS();
		} else if (itemId == L1ItemId.SCROLL_OF_ENCHANT_ARMOR
				|| itemId == L1ItemId.SCROLL_OF_ENCHANT_WEAPON
				|| itemId == L1ItemId.SCROLL_OF_ENCHANT_QUEST_WEAPON
				|| itemId == 40077
				|| itemId == 40078
				|| itemId == 40126
				|| itemId == 40098
				|| itemId == 40129
				|| itemId == 40130
				|| itemId == 140129
				|| itemId == 140130
				|| itemId == L1ItemId.B_SCROLL_OF_ENCHANT_ARMOR
				|| itemId == L1ItemId.B_SCROLL_OF_ENCHANT_WEAPON
				|| itemId == L1ItemId.C_SCROLL_OF_ENCHANT_ARMOR
				|| itemId == L1ItemId.C_SCROLL_OF_ENCHANT_WEAPON
				|| itemId == 41029 
				|| itemId == 40317
				|| itemId == 41036
				|| itemId == 41245
				|| itemId == 40127
				|| itemId == 40128
				|| itemId == 41048
				|| itemId == 41049
				|| itemId == 41050 
				|| itemId == 41051
				|| itemId == 41052
				|| itemId == 41053 
				|| itemId == 41054
				|| itemId == 41055
				|| itemId == 41056 
				|| itemId == 41057 
				|| itemId == 40925
				|| itemId == 40926
				|| itemId == 40927 
				|| itemId == 40928
				|| itemId == 40929
				|| itemId == 40931
				|| itemId == 40932
				|| itemId == 40933 
				|| itemId == 40934
				|| itemId == 40935
				|| itemId == 40936
				|| itemId == 40937 
				|| itemId == 40938
				|| itemId == 40939
				|| itemId == 40940
				|| itemId == 40941 
				|| itemId == 40942
				|| itemId == 40943
				|| itemId == 40944
				|| itemId == 40945 
				|| itemId == 40946
				|| itemId == 40947
				|| itemId == 40948
				|| itemId == 40949 
				|| itemId == 40950 || itemId == 40951
				|| itemId == 40952
				|| itemId == 40953 
				|| itemId == 40954 || itemId == 40955 || itemId == 40956
				|| itemId == 40957
				|| itemId == 40958 || itemId == 40964
				|| itemId == 49092
				|| itemId == 41426
				|| itemId == 41427
				|| itemId == 40075
				|| itemId == 41429
				|| itemId == 41430
				|| itemId == 41431
				|| itemId == 41432) {
			l = readD();
		} else if (itemId == 140100 || itemId == 40100 || itemId == 40099 || itemId == 40086 || itemId == 40863) {
			bmapid = readH();
			btele = readD();
			pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_TELEPORT_UNLOCK, false));
		} else if (itemId == 40090 || itemId == 40091 || itemId == 40092
				|| itemId == 40093 || itemId == 40094) {
			blanksc_skillid = readC();
		} else if (use_type == 30 || itemId == 40870 || itemId == 40879) { // spell_buff
			spellsc_objid = readD();
		} else if (use_type == 5 || use_type == 17) { // spell_long // spell_short
			spellsc_objid = readD();
			spellsc_x = readH();
			spellsc_y = readH();
		} else if (itemId == 40089 || itemId == 140089) {
			resid = readD();
		} else if (itemId == 40310 || itemId == 40311 || itemId == 40730 || itemId == 40731 || itemId == 40732) { 
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

		if (pc.getCurrentHp() > 0) {
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
				int delayEffect = ((L1EtcItem) l1iteminstance.getItem()).get_delayEffect();
				if (delayEffect > 0) {
					isDelayEffect = true;
					Timestamp lastUsed = l1iteminstance.getLastUsed();
					if (lastUsed != null) {
						Calendar cal = Calendar.getInstance();
						if ((cal.getTimeInMillis() - lastUsed.getTime()) / 1000 <= delayEffect) {
							pc.sendPackets(new S_ServerMessage(79));
							return;
						}
					}
				}
			}

			L1ItemInstance l1iteminstance1 = pc.getInventory().getItem(l);
			_log.finest("request item use (obj) = " + itemObjid + " action = "
					+ l + " value = " + s);
			if (itemId == 40077 || itemId == L1ItemId.SCROLL_OF_ENCHANT_WEAPON
					|| itemId == L1ItemId.SCROLL_OF_ENCHANT_QUEST_WEAPON
					|| itemId == 40130 || itemId == 140130
					|| itemId == L1ItemId.B_SCROLL_OF_ENCHANT_WEAPON
					|| itemId == L1ItemId.C_SCROLL_OF_ENCHANT_WEAPON
					|| itemId == 40128) {
				if (l1iteminstance1 == null
						|| l1iteminstance1.getItem().getType2() != 1) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}

				int safe_enchant = l1iteminstance1.getItem().get_safeenchant();
				if (safe_enchant < 0) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}

				if (l1iteminstance1.getBless() >= 128) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}

				int quest_weapon = l1iteminstance1.getItem().getItemId();
				if (quest_weapon >= 246 && quest_weapon <= 249) {
					if (itemId == L1ItemId.SCROLL_OF_ENCHANT_QUEST_WEAPON) {
					} else {
						pc.sendPackets(new S_ServerMessage(79));
						return;
					}
				}
				if (itemId == L1ItemId.SCROLL_OF_ENCHANT_QUEST_WEAPON) { 
					if (quest_weapon >= 246 && quest_weapon <= 249) { 
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
						return;
					}
				}
				int weaponId = l1iteminstance1.getItem().getItemId();
				if (weaponId == 36 || weaponId == 183 || weaponId >= 250
						&& weaponId <= 255) { 
					if (itemId == 40128) { 
					} else {
						pc.sendPackets(new S_ServerMessage(79));
						return;
					}
				}
				if (itemId == 40128) {
					if (weaponId == 36 || weaponId == 183 || weaponId >= 250
							&& weaponId <= 255) { 
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
						return;
					}
				}

				int enchant_level = l1iteminstance1.getEnchantLevel();

				if (itemId == L1ItemId.C_SCROLL_OF_ENCHANT_WEAPON) { // c-dai
					pc.getInventory().removeItem(l1iteminstance, 1);
					if (enchant_level < -6) {
						FailureEnchant(pc, l1iteminstance1, client);
					} else {
						SuccessEnchant(pc, l1iteminstance1, client, -1);
					}
				} else if (enchant_level < safe_enchant) {
					pc.getInventory().removeItem(l1iteminstance, 1);
					SuccessEnchant(pc, l1iteminstance1, client, RandomELevel(
							l1iteminstance1, itemId));
				} else {
					pc.getInventory().removeItem(l1iteminstance, 1);

					int rnd = _random.nextInt(100) + 1;
					int enchant_chance_wepon;
					if (enchant_level >= 9) {
						enchant_chance_wepon = (100 + 3 * Config.ENCHANT_CHANCE_WEAPON) / 6;
					} else {
						enchant_chance_wepon = (100 + 3 * Config.ENCHANT_CHANCE_WEAPON) / 3;
					}

					if (rnd < enchant_chance_wepon) {
						int randomEnchantLevel = RandomELevel(l1iteminstance1,
								itemId);
						SuccessEnchant(pc, l1iteminstance1, client,
								randomEnchantLevel);
					} else if (enchant_level >= 9
							&& rnd < (enchant_chance_wepon * 2)) {
						pc.sendPackets(new S_ServerMessage(160, l1iteminstance1
								.getLogName(), "$245", "$248"));
					} else {
						FailureEnchant(pc, l1iteminstance1, client);
					}
				}
			} else if (itemId == 41429 || itemId == 41430
					|| itemId == 41431 || itemId == 41432) {
				if (l1iteminstance1 == null
						|| l1iteminstance1.getItem().getType2() != 1) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}
				int safeEnchant = l1iteminstance1.getItem().get_safeenchant();
				if (safeEnchant < 0) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}

				if (l1iteminstance1.getBless() >= 128) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}

				// 0: 1:n 2: 4: 8:
				int oldAttrEnchantKind = l1iteminstance1.getAttrEnchantKind();
				int oldAttrEnchantLevel = l1iteminstance1.getAttrEnchantLevel();

				boolean isSameAttr = false;
				if (itemId == 41429 && oldAttrEnchantKind == 8
						|| itemId == 41430 && oldAttrEnchantKind == 1
						|| itemId == 41431 && oldAttrEnchantKind == 4
						|| itemId == 41432 && oldAttrEnchantKind == 2) {
					isSameAttr = true;
				}
				if (isSameAttr && oldAttrEnchantLevel >= 3) {
					pc.sendPackets(new S_ServerMessage(1453));
					return;
				}

				int rnd = _random.nextInt(100) + 1;
				if (Config.ATTR_ENCHANT_CHANCE >= rnd) {
					pc.sendPackets(new S_ServerMessage(161, l1iteminstance1
							.getLogName(), "$245", "$247"));
					int newAttrEnchantKind = 0;
					int newAttrEnchantLevel = 0;
					if (isSameAttr) { // +1
						newAttrEnchantLevel = oldAttrEnchantLevel + 1;
					} else { // 1
						newAttrEnchantLevel = 1;
					}
					if (itemId == 41429) {
						newAttrEnchantKind = 8;
					} else if (itemId == 41430) {
						newAttrEnchantKind = 1;
					} else if (itemId == 41431) {
						newAttrEnchantKind = 4;
					} else if (itemId == 41432) {
						newAttrEnchantKind = 2;
					}
					l1iteminstance1.setAttrEnchantKind(newAttrEnchantKind);
					pc.getInventory().updateItem(l1iteminstance1,
							L1PcInventory.COL_ATTR_ENCHANT_KIND);
					pc.getInventory().saveItem(l1iteminstance1,
							L1PcInventory.COL_ATTR_ENCHANT_KIND);
					l1iteminstance1.setAttrEnchantLevel(newAttrEnchantLevel);
					pc.getInventory().updateItem(l1iteminstance1,
							L1PcInventory.COL_ATTR_ENCHANT_LEVEL);
					pc.getInventory().saveItem(l1iteminstance1,
							L1PcInventory.COL_ATTR_ENCHANT_LEVEL);
				} else {
					pc.sendPackets(new S_ServerMessage(79));
				}
				pc.getInventory().removeItem(l1iteminstance, 1);
			} else if (itemId == 40078
					|| itemId == L1ItemId.SCROLL_OF_ENCHANT_ARMOR
					|| itemId == 40129 || itemId == 140129
					|| itemId == L1ItemId.B_SCROLL_OF_ENCHANT_ARMOR
					|| itemId == L1ItemId.C_SCROLL_OF_ENCHANT_ARMOR
					|| itemId == 40127) {
				if (l1iteminstance1 == null
						 || l1iteminstance1.getItem().getType2() != 2) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}

				int safe_enchant = ((L1Armor) l1iteminstance1.getItem())
						.get_safeenchant();
				if (safe_enchant < 0) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}

				if (l1iteminstance1.getBless() >= 128) {
					pc.sendPackets(new S_ServerMessage(79));
					return;
				}

				int armorId = l1iteminstance1.getItem().getItemId();
				if (armorId == 20161 || armorId >= 21035 && armorId <= 21038) { 
					if (itemId == 40127) { 
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
						return;
					}
				}
				if (itemId == 40127) {
					if (armorId == 20161 || armorId >= 21035
							&& armorId <= 21038) { 
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
						return;
					}
				}

				int enchant_level = l1iteminstance1.getEnchantLevel();
				if (itemId == L1ItemId.C_SCROLL_OF_ENCHANT_ARMOR) { // c-zel
					pc.getInventory().removeItem(l1iteminstance, 1);
					if (enchant_level < -6) {
						FailureEnchant(pc, l1iteminstance1, client);
					} else {
						SuccessEnchant(pc, l1iteminstance1, client, -1);
					}
				} else if (enchant_level < safe_enchant) {
					pc.getInventory().removeItem(l1iteminstance, 1);
					SuccessEnchant(pc, l1iteminstance1, client, RandomELevel(
							l1iteminstance1, itemId));
				} else {
					pc.getInventory().removeItem(l1iteminstance, 1);
					int rnd = _random.nextInt(100) + 1;
					int enchant_chance_armor;
					int enchant_level_tmp;
					if (safe_enchant == 0) {
						enchant_level_tmp = enchant_level + 2;
					} else {
						enchant_level_tmp = enchant_level;
					}
					if (enchant_level >= 9) {
						enchant_chance_armor = (100 + enchant_level_tmp
								* Config.ENCHANT_CHANCE_ARMOR)
								/ (enchant_level_tmp * 2);
					} else {
						enchant_chance_armor = (100 + enchant_level_tmp
								* Config.ENCHANT_CHANCE_ARMOR)
								/ enchant_level_tmp;
					}

					if (rnd < enchant_chance_armor) {
						int randomEnchantLevel = RandomELevel(l1iteminstance1,
								itemId);
						SuccessEnchant(pc, l1iteminstance1, client,
								randomEnchantLevel);
					} else if (enchant_level >= 9
							&& rnd < (enchant_chance_armor * 2)) {
						String item_name_id = l1iteminstance1.getName();
						String pm = "";
						String msg = "";
						if (enchant_level > 0) {
							pm = "+";
						}
						msg = (new StringBuilder()).append(pm + enchant_level)
								.append(" ").append(item_name_id).toString();
						// 
						pc.sendPackets(new S_ServerMessage(160, msg, "$252",
								"$248"));
					} else {
						FailureEnchant(pc, l1iteminstance1, client);
					}
				}
			} else if (l1iteminstance.getItem().getType2() == 0) {
				int item_minlvl = ((L1EtcItem) l1iteminstance.getItem())
						.getMinLevel();
				int item_maxlvl = ((L1EtcItem) l1iteminstance.getItem())
						.getMaxLevel();
				if (item_minlvl != 0 && item_minlvl > pc.getLevel()
						&& !pc.isGm()) {
					pc.sendPackets(new S_ServerMessage(318, String
							.valueOf(item_minlvl))); //
					return;
				} else if (item_maxlvl != 0 && item_maxlvl < pc.getLevel()
						&& !pc.isGm()) {
					pc.sendPackets(new S_ServerMessage(673, String
							.valueOf(item_maxlvl))); //
					return;
				}

				if ((itemId == 40576 && !pc.isElf())
						|| (itemId == 40577 && !pc.isWizard())
						|| (itemId == 40578 && !pc.isKnight())) {
					pc.sendPackets(new S_ServerMessage(264));
					return;
				}

				if (l1iteminstance.getItem().getType() == 0) {
					pc.getInventory().setArrow(
							l1iteminstance.getItem().getItemId());
					pc.sendPackets(new S_ServerMessage(452, l1iteminstance
							.getLogName())); //
				} else if (l1iteminstance.getItem().getType() == 15) { //
					pc.getInventory().setSting(
							l1iteminstance.getItem().getItemId());
					pc.sendPackets(new S_ServerMessage(452, 
							l1iteminstance.getLogName()));
				} else if (l1iteminstance.getItem().getType() == 16) { // treasure_box
					L1TreasureBox box = L1TreasureBox.get(itemId);

					if (box != null) {
						if (box.open(pc)) {
							L1EtcItem temp = (L1EtcItem) l1iteminstance
									.getItem();
							if (temp.get_delayEffect() > 0) {
								isDelayEffect = true;
							} else {
								pc.getInventory().removeItem(
										l1iteminstance.getId(), 1);
							}
						}
					}
				} else if (l1iteminstance.getItem().getType() == 2) { //
					if (l1iteminstance.getRemainingTime() <= 0
							&& itemId != 40004) {
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
					for (L1ItemInstance lightItem : pc.getInventory()
							.getItems()) {
						if (lightItem.getItem().getItemId() == 40002) {
							lightItem.setRemainingTime(l1iteminstance.getItem()
									.getLightFuel());
							pc.sendPackets(new S_ItemName(lightItem));
							pc.sendPackets(new S_ServerMessage(230)); //
							break;
						}
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 43000) { //
					pc.setExp(1);
					pc.resetLevel();
					pc.setBonusStats(0);
					pc.sendPackets(new S_SkillSound(pcObjid, 191));
					pc.broadcastPacket(new S_SkillSound(pcObjid, 191));
					pc.sendPackets(new S_OwnCharStatus(pc));
					pc.getInventory().removeItem(l1iteminstance, 1);
					pc.sendPackets(new S_ServerMessage(822));
					pc.save();
				} else if (itemId == 40033) {
					if (pc.getBaseStr() < 35 && pc.getElixirStats() < 5) {
						pc.addBaseStr((byte) 1);
						pc.setElixirStats(pc.getElixirStats() + 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.save();
                        // db save
					} else {
						pc.sendPackets(new S_ServerMessage(481));
					}
				} else if (itemId == 40034) {
					if (pc.getBaseCon() < 35 && pc.getElixirStats() < 5) {
						pc.addBaseCon((byte) 1);
						pc.setElixirStats(pc.getElixirStats() + 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.save();
                        // db save
					} else {
						pc.sendPackets(new S_ServerMessage(481));
					}
				} else if (itemId == 40035) {
					if (pc.getBaseDex() < 35 && pc.getElixirStats() < 5) {
						pc.addBaseDex((byte) 1);
						pc.resetBaseAc();
						pc.setElixirStats(pc.getElixirStats() + 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.save();
                        // db save
					} else {
						pc.sendPackets(new S_ServerMessage(481));
					}
				} else if (itemId == 40036) {
					if (pc.getBaseInt() < 35 && pc.getElixirStats() < 5) {
						pc.addBaseInt((byte) 1);
						pc.setElixirStats(pc.getElixirStats() + 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.save();
                        // db save
					} else {
						pc.sendPackets(new S_ServerMessage(481));
					}
				} else if (itemId == 40037) {
					if (pc.getBaseWis() < 35 && pc.getElixirStats() < 5) {
						pc.addBaseWis((byte) 1);
						pc.resetBaseMr();
						pc.setElixirStats(pc.getElixirStats() + 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.save();
                        // db save
					} else {
						pc.sendPackets(new S_ServerMessage(481));
					}
				} else if (itemId == 40038) {
					if (pc.getBaseCha() < 35 && pc.getElixirStats() < 5) {
						pc.addBaseCha((byte) 1);
						pc.setElixirStats(pc.getElixirStats() + 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
						pc.sendPackets(new S_OwnCharStatus2(pc));
						pc.save();
                        // db save
					} else {
						pc.sendPackets(new S_ServerMessage(481));
					}
				}
				else if (itemId == L1ItemId.POTION_OF_HEALING
						|| itemId == L1ItemId.CONDENSED_POTION_OF_HEALING
						|| itemId == 40029) {
					UseHeallingPotion(pc, 15, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40022) {
					UseHeallingPotion(pc, 20, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.POTION_OF_EXTRA_HEALING
						|| itemId == L1ItemId.CONDENSED_POTION_OF_EXTRA_HEALING) {
					UseHeallingPotion(pc, 45, 194);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40023) {
					UseHeallingPotion(pc, 30, 194);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.POTION_OF_GREATER_HEALING
						|| itemId == L1ItemId.CONDENSED_POTION_OF_GREATER_HEALING) {
					UseHeallingPotion(pc, 75, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40024) {
					UseHeallingPotion(pc, 55, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40506) {
					UseHeallingPotion(pc, 70, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40026 || itemId == 40027
						|| itemId == 40028) {
					UseHeallingPotion(pc, 25, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40058) {
					UseHeallingPotion(pc, 30, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40071) {
					UseHeallingPotion(pc, 70, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40734) {
					UseHeallingPotion(pc, 50, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.B_POTION_OF_HEALING) {
					UseHeallingPotion(pc, 25, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.C_POTION_OF_HEALING) {
					UseHeallingPotion(pc, 10, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.B_POTION_OF_EXTRA_HEALING) {
					UseHeallingPotion(pc, 55, 194);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.B_POTION_OF_GREATER_HEALING) {
					UseHeallingPotion(pc, 85, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 140506) {
					UseHeallingPotion(pc, 80, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40043) {
					UseHeallingPotion(pc, 600, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41403) {
					UseHeallingPotion(pc, 300, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId >= 41417 && itemId <= 41421) { //
					UseHeallingPotion(pc, 90, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41337) { // jp
					UseHeallingPotion(pc, 85, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40858) { // liquor
					pc.setDrink(true);
					pc.sendPackets(new S_Liquor(pc.getId()));
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.POTION_OF_CURE_POISON
						|| itemId == 40507) {
					if (pc.hasSkillEffect(71) == true) {
						pc.sendPackets(new S_ServerMessage(698));
					} else {
						cancelAbsoluteBarrier(pc);
						pc.sendPackets(new S_SkillSound(pc.getId(), 192));
						pc.broadcastPacket(new S_SkillSound(pc.getId(), 192));
						if (itemId == L1ItemId.POTION_OF_CURE_POISON) {
							pc.getInventory().removeItem(l1iteminstance, 1);
						} else if (itemId == 40507) {
							pc.getInventory().removeItem(l1iteminstance, 1);
						}

						pc.curePoison();
					}
				} else if (itemId == L1ItemId.POTION_OF_HASTE_SELF
						|| itemId == L1ItemId.B_POTION_OF_HASTE_SELF
						|| itemId == 40018 
						|| itemId == 140018
						|| itemId == 40039
						|| itemId == 40040
						|| itemId == 40030
						|| itemId == 41338
						|| itemId == 41261 
						|| itemId == 41262 
						|| itemId == 41268 
						|| itemId == 41269 
						|| itemId == 41271 
						|| itemId == 41272 
						|| itemId == 41273
						|| itemId == 41342) {
					useGreenPotion(pc, itemId);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.POTION_OF_EMOTION_BRAVERY 
						|| itemId == L1ItemId.B_POTION_OF_EMOTION_BRAVERY 
						|| itemId == 41415) {
					if (pc.isKnight()) {
						useBravePotion(pc, itemId);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 49158) {
					if (pc.isDragonKnight() || pc.isIllusionist()) {
						useBravePotion(pc, itemId);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
					pc.getInventory().removeItem(l1iteminstance, 1); 
				} else if (itemId == 40068
						|| itemId == 140068) {
					if (pc.isElf()) {
						useBravePotion(pc, itemId);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40031) {
					if (pc.isCrown()) {
						useBravePotion(pc, itemId);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40733) {
					useBravePotion(pc, itemId);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40066 || itemId == 41413) {
					pc.sendPackets(new S_ServerMessage(338, "$1084"));
					pc.setCurrentMp(pc.getCurrentMp()
							+ (7 + _random.nextInt(6))); // 7~12
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40067 || itemId == 41414) {
					pc.sendPackets(new S_ServerMessage(338, "$1084"));
					pc.setCurrentMp(pc.getCurrentMp()
							+ (15 + _random.nextInt(16))); // 15~30
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40735) {
					pc.sendPackets(new S_ServerMessage(338, "$1084"));
					pc.setCurrentMp(pc.getCurrentMp() + 60);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40042) {
					pc.sendPackets(new S_ServerMessage(338, "$1084"));
					pc.setCurrentMp(pc.getCurrentMp() + 50);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41404) { 
					pc.sendPackets(new S_ServerMessage(338, "$1084")); 
					pc.setCurrentMp(pc.getCurrentMp()
							+ (80 + _random.nextInt(21))); // 80~100
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41412) { 
					pc.sendPackets(new S_ServerMessage(338, "$1084")); 
					pc.setCurrentMp(pc.getCurrentMp()
							+ (5 + _random.nextInt(16))); // 5~20
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40032 || itemId == 40041
						|| itemId == 41344) {
					useBlessOfEva(pc, itemId);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.POTION_OF_MANA 
						|| itemId == L1ItemId.B_POTION_OF_MANA
						|| itemId == 40736) {
					useBluePotion(pc, itemId);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.POTION_OF_EMOTION_WISDOM 
						|| itemId == L1ItemId.B_POTION_OF_EMOTION_WISDOM) {
					if (pc.isWizard()) {
						useWisdomPotion(pc, itemId);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.POTION_OF_BLINDNESS) {
					useBlindPotion(pc);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == L1ItemId.SCROLL_OF_POLYMORPH
						|| itemId == L1ItemId.IT_SCROLL_OF_POLYMORPH
						|| itemId == L1ItemId.B_SCROLL_OF_POLYMORPH) { 
					if (usePolyScroll(pc, itemId, s)) {
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(181));
					}
				} else if (itemId == 41154
						|| itemId == 41155
						|| itemId == 41156
						|| itemId == 41157
						|| itemId == 49220) {
					usePolyScale(pc, itemId);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 240101){ //SuperDk
					useSuperDKScroll (pc, itemId);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41143
						|| itemId == 41144
						|| itemId == 41145
						|| itemId == 49149
						|| itemId == 49150
						|| itemId == 49151
						|| itemId == 49152
						|| itemId == 49153
						|| itemId == 49154
						|| itemId == 49155) {
					usePolyPotion(pc, itemId);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40317) {
					if (l1iteminstance1.getItem().getType2() != 0
							&& l1iteminstance1.get_durability() > 0) {
						String msg0;
						pc.getInventory().recoveryDamage(l1iteminstance1);
						msg0 = l1iteminstance1.getLogName();
						if (l1iteminstance1.get_durability() == 0) {
							pc.sendPackets(new S_ServerMessage(464, msg0));
						} else {
							pc.sendPackets(new S_ServerMessage(463, msg0));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40097 || itemId == 40119
						|| itemId == 140119 || itemId == 140329) {
					for (L1ItemInstance eachItem : pc.getInventory().getItems()) {
						if (eachItem.getItem().getBless() != 2
								&& eachItem.getItem().getBless() != 130) {
							continue;
						}
						if (!eachItem.isEquipped()
								&& (itemId == 40119 || itemId == 40097)) {
							continue;
						}
						int id_normal = eachItem.getItemId() - 200000;
						L1Item template = ItemTable.getInstance().getTemplate(
								id_normal);
						if (template == null) {
							continue;
						}
						if (pc.getInventory().checkItem(id_normal)
								&& template.isStackable()) {
							pc.getInventory().storeItem(id_normal,
									eachItem.getCount());
							pc.getInventory().removeItem(eachItem,
									eachItem.getCount());
						} else {
							eachItem.setItem(template);
							pc.getInventory().updateItem(eachItem,
									L1PcInventory.COL_ITEMID);
							pc.getInventory().saveItem(eachItem,
									L1PcInventory.COL_ITEMID);
						}
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
					pc.sendPackets(new S_ServerMessage(155));
				} else if (itemId == 40126 || itemId == 40098) {
					if (!l1iteminstance1.isIdentified()) {
						l1iteminstance1.setIdentified(true);
						pc.getInventory().updateItem(l1iteminstance1,
								L1PcInventory.COL_IS_ID);
					}
					pc.sendPackets(new S_IdentifyDesc(l1iteminstance1));
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41036) {
					int diaryId = l1iteminstance1.getItem().getItemId();
					if (diaryId >= 41038 && 41047 >= diaryId) {
						if ((_random.nextInt(99) + 1) <= Config.CREATE_CHANCE_DIARY) {
							createNewItem(pc, diaryId + 10, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(158,
									l1iteminstance1.getName())); 
						}
						pc.getInventory().removeItem(l1iteminstance1, 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
					}
				} else if (itemId >= 41048 && 41055 >= itemId) {

					int logbookId = l1iteminstance1.getItem().getItemId();
					if (logbookId == (itemId + 8034)) {
						createNewItem(pc, logbookId + 2, 1);
						pc.getInventory().removeItem(l1iteminstance1, 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
					}
				} else if (itemId == 41056 || itemId == 41057) {
					// tqCy[WFXCPOy[W
					int logbookId = l1iteminstance1.getItem().getItemId();
					if (logbookId == (itemId + 8034)) {
						createNewItem(pc, 41058, 1);
						pc.getInventory().removeItem(l1iteminstance1, 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
					}
				} else if (itemId == 40925) { 
					int earingId = l1iteminstance1.getItem().getItemId();
					if (earingId >= 40987 && 40989 >= earingId) { 
						if (_random.nextInt(100) < Config.CREATE_CHANCE_RECOLLECTION) {
							createNewItem(pc, earingId + 186, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(158,
									l1iteminstance1.getName())); 
						}
						pc.getInventory().removeItem(l1iteminstance1, 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
					}
				} else if (itemId >= 40926 && 40929 >= itemId) {
					int earing2Id = l1iteminstance1.getItem().getItemId();
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
								pc.getInventory()
										.removeItem(l1iteminstance1, 1);
								pc.getInventory().removeItem(l1iteminstance, 1);
							} else {
								pc.sendPackets(new S_ServerMessage(160,
										l1iteminstance1.getName()));
								pc.getInventory().removeItem(l1iteminstance, 1);
							}
						} else {
							pc.sendPackets(new S_ServerMessage(79)); 
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
					}
				} else if (itemId >= 40931 && 40942 >= itemId) {
					int earing3Id = l1iteminstance1.getItem().getItemId();
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
										l1iteminstance1.getName()));
							}
							pc.getInventory().removeItem(l1iteminstance1, 1);
							pc.getInventory().removeItem(l1iteminstance, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId >= 40943 && 40958 >= itemId) {
					int ringId = l1iteminstance1.getItem().getItemId();
					int ringlevel = 0;
					int gmas = 0;
					int gmam = 0;
					if (ringId >= 41185 && 41200 >= ringId) {
						if (itemId == 40943 || itemId == 40947
								|| itemId == 40951 || itemId == 40955) {
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
								pc.getInventory()
										.removeItem(l1iteminstance1, 1);
								pc.getInventory().removeItem(l1iteminstance, 1);
							} else {
								pc.sendPackets(new S_ServerMessage(gmam,
										l1iteminstance.getName()));
								pc.getInventory().removeItem(l1iteminstance, 1);
							}
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 41029) {
					int dantesId = l1iteminstance1.getItem().getItemId();
					if (dantesId >= 41030 && 41034 >= dantesId) {
						if ((_random.nextInt(99) + 1) < Config.CREATE_CHANCE_DANTES) {
							createNewItem(pc, dantesId + 1, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(158,
									l1iteminstance1.getName()));
						}
						pc.getInventory().removeItem(l1iteminstance1, 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40964) {
					int historybookId = l1iteminstance1.getItem().getItemId();
					if (historybookId >= 41011 && 41018 >= historybookId) {
						if ((_random.nextInt(99) + 1) <= Config.CREATE_CHANCE_HISTORY_BOOK) {
							createNewItem(pc, historybookId + 8, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(158,
									l1iteminstance1.getName()));
						}
						pc.getInventory().removeItem(l1iteminstance1, 1);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40090 || itemId == 40091
						|| itemId == 40092 || itemId == 40093
						|| itemId == 40094) {

					if (pc.isWizard()) {
						if (itemId == 40090 && blanksc_skillid <= 7 ||
								//
								itemId == 40091 && blanksc_skillid <= 15 ||
								//
								itemId == 40092 && blanksc_skillid <= 22 ||
								//
								itemId == 40093 && blanksc_skillid <= 31 ||
								//
								itemId == 40094 && blanksc_skillid <= 39) {

							L1ItemInstance spellsc = ItemTable.getInstance()
									.createItem(40859 + blanksc_skillid);
							if (spellsc != null) {
								if (pc.getInventory().checkAddItem(spellsc, 1) == L1Inventory.OK) {
									L1Skills l1skills = SkillsTable
											.getInstance().getTemplate(
													blanksc_skillid + 1); // blanksc_skillid0n
									if (pc.getCurrentHp() + 1 < l1skills
											.getHpConsume() + 1) {
										pc
												.sendPackets(new S_ServerMessage(
														279));
										return;
									}
									if (pc.getCurrentMp() < l1skills
											.getMpConsume()) {
										pc
												.sendPackets(new S_ServerMessage(
														278));
										return;
									}
									if (l1skills.getItemConsumeId() != 0) {
										if (!pc.getInventory().checkItem(
												l1skills.getItemConsumeId(),
												l1skills.getItemConsumeCount())) {
											pc.sendPackets(new S_ServerMessage(
													299));
											return;
										}
									}
									pc.setCurrentHp(pc.getCurrentHp()
											- l1skills.getHpConsume());
									pc.setCurrentMp(pc.getCurrentMp()
											- l1skills.getMpConsume());
									int lawful = pc.getLawful()
											+ l1skills.getLawful();
									if (lawful > 32767) {
										lawful = 32767;
									}
									if (lawful < -32767) {
										lawful = -32767;
									}
									pc.setLawful(lawful);
									if (l1skills.getItemConsumeId() != 0) { //
										pc.getInventory().consumeItem(
												l1skills.getItemConsumeId(),
												l1skills.getItemConsumeCount());
									}
									pc.getInventory().removeItem(
											l1iteminstance, 1);
									pc.getInventory().storeItem(spellsc);
								}
							}
						} else {
							pc.sendPackets(new S_ServerMessage(591));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(264));
					}

				} else if ((itemId >= 40859 && itemId <= 40898)
						&& itemId != 40863
						|| itemId >= 49281 && itemId <= 49286) { // 40863
					if (spellsc_objid == pc.getId()
							&& l1iteminstance.getItem().getUseType() != 30) { // spell_buff
						pc.sendPackets(new S_ServerMessage(281));
						return;
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
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
				
				} else if (itemId >= 40373 && itemId <= 40382
						|| itemId >= 40385 && itemId <= 40390) {
					pc.sendPackets(new S_UseMap(pc, l1iteminstance.getId(),
							l1iteminstance.getItem().getItemId()));
				} else if (itemId == 40310 || itemId == 40730
						|| itemId == 40731 || itemId == 40732) {
					if (writeLetter(itemId, pc, letterCode, letterReceiver,
							letterText)) {
						pc.getInventory().removeItem(l1iteminstance, 1);
					}
				} else if (itemId == 40311) {
					if (writeClanLetter(itemId, pc, letterCode, letterReceiver,
							letterText)) {
						pc.getInventory().removeItem(l1iteminstance, 1);
					}
				} else if (itemId == 49016 || itemId == 49018
						|| itemId == 49020 || itemId == 49022
						|| itemId == 49024) {
					pc.sendPackets(new S_Letter(l1iteminstance));
					l1iteminstance.setItemId(itemId + 1);
					pc.getInventory().updateItem(l1iteminstance,
							L1PcInventory.COL_ITEMID);
					pc.getInventory().saveItem(l1iteminstance,
							L1PcInventory.COL_ITEMID);
				} else if (itemId == 49017 || itemId == 49019
						|| itemId == 49021 || itemId == 49023
						|| itemId == 49025) {
					pc.sendPackets(new S_Letter(l1iteminstance));
				} else if (itemId == 40314 || itemId == 40316) {
					if (pc.getInventory().checkItem(41160)) {
						if (withdrawPet(pc, itemObjid)) {
							pc.getInventory().consumeItem(41160, 1);
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
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
									pc.getInventory().removeItem(
											l1iteminstance, 1);
								}
							}
						}
					}
				} else if (itemId == 40325) { // 2 Faced Dice
					if (pc.getInventory().checkItem(40318, 1)) {
						int gfxid = 3237 + _random.nextInt(2);
						pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
						pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
						pc.getInventory().consumeItem(40318, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40326) {
					if (pc.getInventory().checkItem(40318, 1)) {
						int gfxid = 3229 + _random.nextInt(3);
						pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
						pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
						pc.getInventory().consumeItem(40318, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40327) {
					if (pc.getInventory().checkItem(40318, 1)) {
						int gfxid = 3241 + _random.nextInt(4);
						pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
						pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
						pc.getInventory().consumeItem(40318, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40328) {
					if (pc.getInventory().checkItem(40318, 1)) {
						int gfxid = 3204 + _random.nextInt(6);
						pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
						pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
						pc.getInventory().consumeItem(40318, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
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
							if (L1World.getInstance().getVisiblePlayer(target,
									0).size() > 0) {
								for (L1PcInstance visiblePc : L1World
										.getInstance().getVisiblePlayer(target,
												0)) {
									if (!visiblePc.isDead()) {

										pc
												.sendPackets(new S_ServerMessage(
														592));
										return;
									}
								}
							}
							if (target.getCurrentHp() == 0
									&& target.isDead() == true) {
								if (pc.getMap().isUseResurrection()) {
									target.setTempID(pc.getId());
									if (itemId == 40089) {
										target.sendPackets(new S_Message_YN(
												321, ""));
									} else if (itemId == 140089) {
										target.sendPackets(new S_Message_YN(
												322, ""));
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
									pc.getInventory().removeItem(l1iteminstance,
											1);
									return;
								}
								if (npc instanceof L1PetInstance
										&& L1World.getInstance()
												.getVisiblePlayer(npc, 0)
												.size() > 0) {
									for (L1PcInstance visiblePc : L1World
											.getInstance().getVisiblePlayer(
													npc, 0)) {
										if (!visiblePc.isDead()) {
											pc.sendPackets(new S_ServerMessage(
													592));
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
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId > 40169 && itemId < 40226 || itemId >= 45000
						&& itemId <= 45022) {
					L1SpellBook.useSpellBook(pc, l1iteminstance);
					pc.sendPackets(new S_ServerMessage(79));
				} else if (itemId > 40225 && itemId < 40232) {
					if (pc.isCrown() || pc.isGm()) {
						if (itemId == 40226 && pc.getLevel() >= 15) {
							L1SpellBook.SpellBook4(pc, l1iteminstance, client);
						} else if (itemId == 40228 && pc.getLevel() >= 30) {
							L1SpellBook.SpellBook4(pc, l1iteminstance, client);
						} else if (itemId == 40227 && pc.getLevel() >= 40) {
							L1SpellBook.SpellBook4(pc, l1iteminstance, client);
						} else if ((itemId == 40231 || itemId == 40232)
								&& pc.getLevel() >= 45) {
							L1SpellBook.SpellBook4(pc, l1iteminstance, client);
						} else if (itemId == 40230 && pc.getLevel() >= 50) {
							L1SpellBook.SpellBook4(pc, l1iteminstance, client);
						} else if (itemId == 40229 && pc.getLevel() >= 55) {
							L1SpellBook.SpellBook4(pc, l1iteminstance, client);
						} else {
							pc.sendPackets(new S_ServerMessage(312));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId >= 40232 && itemId <= 40264
						|| itemId >= 41149 && itemId <= 41153
						|| itemId == 50001) { // Added NM elf crystal. Do not remove.
					L1SpellBook.useElfSpellBook(pc, l1iteminstance, itemId);
				} else if (itemId > 40264 && itemId < 40280) {
					if (pc.isDarkelf() || pc.isGm()) {
						if (itemId >= 40265 && itemId <= 40269 
								&& pc.getLevel() >= 15) {
							L1SpellBook.SpellBook1(pc, l1iteminstance, client);
						} else if (itemId >= 40270 && itemId <= 40274 
								&& pc.getLevel() >= 30) {
							L1SpellBook.SpellBook1(pc, l1iteminstance, client);
						} else if (itemId >= 40275 && itemId <= 40279
								&& pc.getLevel() >= 45) {
							L1SpellBook.SpellBook1(pc, l1iteminstance, client);
						} else {
							pc.sendPackets(new S_ServerMessage(312));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId >= 40164 && itemId <= 40166
						|| itemId >= 41147 && itemId <= 41148) {
					if (pc.isKnight() || pc.isGm()) {
						if (itemId >= 40164 && itemId <= 40165
								&& pc.getLevel() >= 50) {
							L1SpellBook.SpellBook3(pc, l1iteminstance, client);
						} else if (itemId >= 41147 && itemId <= 41148 
								&& pc.getLevel() >= 50) {
							L1SpellBook.SpellBook3(pc, l1iteminstance, client);
						} else if (itemId == 40166 && pc.getLevel() >= 60) {
							L1SpellBook.SpellBook3(pc, l1iteminstance, client);
						} else {
							pc.sendPackets(new S_ServerMessage(312));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId >= 49102 && itemId <= 49116) {
					if (pc.isDragonKnight() || pc.isGm()) {
						if (itemId >= 49102 && itemId <= 49106
								&& pc.getLevel() >= 15) {
							L1SpellBook.SpellBook5(pc, l1iteminstance, client);
						} else if (itemId >= 49107 && itemId <= 49111
								&& pc.getLevel() >= 30) {
							L1SpellBook.SpellBook5(pc, l1iteminstance, client);
						} else if (itemId >= 49112 && itemId <= 49116
								&& pc.getLevel() >= 45) {
							L1SpellBook.SpellBook5(pc, l1iteminstance, client);
						} else {
							pc.sendPackets(new S_ServerMessage(312));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId >= 49117 && itemId <= 49136) {
					if (pc.isIllusionist() || pc.isGm()) {
						if (itemId >= 49117 && itemId <= 49121
								&& pc.getLevel() >= 10) {
							L1SpellBook.SpellBook6(pc, l1iteminstance, client);
						} else if (itemId >= 49122 && itemId <= 49126
								&& pc.getLevel() >= 20) {
							L1SpellBook.SpellBook6(pc, l1iteminstance, client);
						} else if (itemId >= 49127 && itemId <= 49131
								&& pc.getLevel() >= 30) {
							L1SpellBook.SpellBook6(pc, l1iteminstance, client);
						} else if (itemId >= 49132 && itemId <= 49136
								&& pc.getLevel() >= 40) {
							L1SpellBook.SpellBook6(pc, l1iteminstance, client);
						} else {
							pc.sendPackets(new S_ServerMessage(312));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40079 || itemId == 40095) {
					if (pc.getMap().isEscapable() || pc.isGm()) {
						int[] loc = Getback.GetBack_Location(pc, true);
						L1Teleport.teleport(pc, loc[0], loc[1], (short) loc[2],
								5, true);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(647));
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
								L1Teleport.teleport(pc, locx, locy, mapid, 5,
										true);
								pc.getInventory().removeItem(l1iteminstance, 1);
							} else {
								pc.sendPackets(new S_ServerMessage(647));
							}
						} else if (house_id != 0) {
							if (pc.getMap().isEscapable() || pc.isGm()) {
								int[] loc = new int[3];
								loc = L1HouseLocation.getHouseLoc(house_id);
								int locx = loc[0];
								int locy = loc[1];
								short mapid = (short) (loc[2]);
								L1Teleport.teleport(pc, locx, locy, mapid, 5,
										true);
								pc.getInventory().removeItem(l1iteminstance, 1);
							} else {
								pc.sendPackets(new S_ServerMessage(647));
							}
						} else {
							if (pc.getHomeTownId() > 0) {
								int[] loc = L1TownLocation.getGetBackLoc(pc
										.getHomeTownId());
								int locx = loc[0];
								int locy = loc[1];
								short mapid = (short) (loc[2]);
								L1Teleport.teleport(pc, locx, locy, mapid, 5,
										true);
								pc.getInventory().removeItem(l1iteminstance, 1);
							} else {
								int[] loc = Getback.GetBack_Location(pc, true);
								L1Teleport.teleport(pc, loc[0], loc[1],
										(short) loc[2], 5, true);
								pc.getInventory().removeItem(l1iteminstance, 1);
							}
						}
					} else {
						pc.sendPackets(new S_ServerMessage(647));
					}
					cancelAbsoluteBarrier(pc);
				} else if (itemId == 140100 || itemId == 40100 // btele, ntele
						|| itemId == 40099 // it tele scroll
						|| itemId == 40086 || itemId == 40863) { // mass tele scroll, lasta scroll?
					L1BookMark bookm = pc.getBookMark(btele);
					if (bookm != null) {
						if (pc.getMap().isEscapable() || pc.isGm()) {
							int newX = bookm.getLocX();
							int newY = bookm.getLocY();
							short mapId = bookm.getMapId();

							if (itemId == 40086) {
								for (L1PcInstance member : L1World.getInstance()
										.getVisiblePlayer(pc)) {
									if (pc.getLocation()
											.getTileLineDistance(member
													.getLocation()) <= 3
											&& member.getClanid() == pc
													.getClanid()
											&& pc.getClanid() != 0
											&& member.getId() != pc.getId()) {
										L1Teleport.teleport(member, newX,
												newY, mapId, 5, true);
									}
								}
							}
							L1Teleport.teleport(pc, newX, newY, mapId, 5, true);
							pc.getInventory().removeItem(l1iteminstance, 1);
						} else {
							L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc
									.getMapId(), pc.getHeading(), false);
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else {
						if (pc.getMap().isTeleportable() || pc.isGm()) {
							L1Location newLocation = pc.getLocation()
									.randomLocation(200, true);
							int newX = newLocation.getX();
							int newY = newLocation.getY();
							short mapId = (short) newLocation.getMapId();

							if (itemId == 40086) { // }Xe|[gXN[
								for (L1PcInstance member : L1World.getInstance()
										.getVisiblePlayer(pc)) {
									if (pc.getLocation()
											.getTileLineDistance(member
													.getLocation()) <= 3
											&& member.getClanid() == pc
													.getClanid()
											&& pc.getClanid() != 0
											&& member.getId() != pc.getId()) {
										L1Teleport.teleport(member, newX,
												newY, mapId, 5, true);
									}
								}
							}
							L1Teleport.teleport(pc, newX, newY, mapId, 5, true);
							pc.getInventory().removeItem(l1iteminstance, 1);
						} else {
							L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc
									.getMapId(), pc.getHeading(), false);
							pc.sendPackets(new S_ServerMessage(276));
						}
					}
					cancelAbsoluteBarrier(pc);
				} else if (itemId == 240100) {
					L1Teleport.teleport(pc, pc.getX(), pc.getY(),
							pc.getMapId(), pc.getHeading(), true);
					pc.getInventory().removeItem(l1iteminstance, 1);
					cancelAbsoluteBarrier(pc);
				} else if (itemId >= 40080 && itemId <= 40085
						|| itemId >= 40101 && itemId <= 40118
						|| itemId >= 40120 && itemId <= 40123
						|| itemId == 40125 || itemId >= 40801
						&& itemId <= 40898 || itemId >= 42001
						&& itemId <= 42033 || itemId >= 42035
						&& itemId <= 42100) { // various return scrolls
					if (pc.getMap().isEscapable() || pc.isGm()) {
						L1Teleport.teleport(pc, ((L1EtcItem) l1iteminstance.getItem()).get_locx(),
								((L1EtcItem) l1iteminstance.getItem()).get_locy(),
								((L1EtcItem) l1iteminstance.getItem()).get_mapid(), 5, true);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(647));
					}
					cancelAbsoluteBarrier(pc);
				} else if (itemId >= 40901 && itemId <= 40908) { // silver ring, wedding ring
					L1PcInstance partner = null;
					boolean partner_stat = false;
					if (pc.getPartnerId() != 0) {
						partner = (L1PcInstance) L1World.getInstance()
								.findObject(pc.getPartnerId());
						if (partner != null && partner.getPartnerId() != 0
								&& pc.getPartnerId() == partner.getId()
								&& partner.getPartnerId() == pc.getId()) {
							partner_stat = true;
						}
					} else {
						pc.sendPackets(new S_ServerMessage(662));
						return;
					}

					if (partner_stat) {
						boolean castle_area = L1CastleLocation
								.checkInAllWarArea(
								partner.getX(), partner.getY(), partner.getMapId());
						if ((partner.getMapId() == 0 || partner.getMapId() == 4 || partner
								.getMapId() == 304)
								&& castle_area == false) {
							L1Teleport.teleport(pc, partner.getX(), partner
									.getY(), partner.getMapId(), 5, true);
						} else {
							pc.sendPackets(new S_ServerMessage(547));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(546));
					}
				} else if (itemId == 40555) {// Secret Room Key
					if (pc.isKnight()
							&& (pc.getX() >= 32806 &&
							pc.getX() <= 32814)
							&& (pc.getY() >= 32798 && pc.getY() <= 32807)
							&& pc.getMapId() == 13) {
						short mapid = 13;
						L1Teleport.teleport(pc, 32815, 32810, mapid, 5, false);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40417) {// pi crystal
					if ((pc.getX() >= 32665 &&
					pc.getX() <= 32674)
							&& (pc.getY() >= 32976 && pc.getY() <= 32985)
							&& pc.getMapId() == 440) {
						short mapid = 430;
						L1Teleport.teleport(pc, 32922, 32812, mapid, 5, true);
					} else { 
						pc.sendPackets(new S_ServerMessage(79)); 
					    } 
					} 
				else if (itemId == 49202) { 
					if ((pc.getMapId() != 2004) && (pc.getQuest().get_step(L1Quest.QUEST_LEVEL50) > 1 )) { 
						short mapid = 2004; 
						L1Teleport.teleport(pc, 32723, 32834, mapid, 5, true); 
						pc.getInventory().removeItem(l1iteminstance, 1); 
					} else { 
						pc.sendPackets(new S_ServerMessage(79)); 
						} 
					} 
				else if (itemId == 49178) { 
					if ((pc.isIllusionist()) && (pc.getMapId() == 2004) 
							&& (pc.getQuest().get_step(L1Quest.QUEST_LEVEL50) > 1 )) { 
						short mapid = 1000; 
						L1Teleport.teleport(pc, 32772, 32812, mapid, 5, true); 
						pc.getInventory().removeItem(l1iteminstance, 1); 
					} else { 
						pc.sendPackets(new S_ServerMessage(79)); 
						} 
					} 
				else if (itemId == 49216) { 
					if ((pc.isDragonKnight()) && (pc.getMapId() == 2004) 
							&& (pc.getQuest().get_step(L1Quest.QUEST_LEVEL50) > 1 )) { 
						short mapid = 1001; 
						L1Teleport.teleport(pc, 32817, 32832, mapid, 5, true); 
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40566) {
					if (pc.isElf()
							&& (pc.getX() >= 33971 && 
							pc.getX() <= 33975)
							&& (pc.getY() >= 32324 && pc.getY() <= 32328)
							&& pc.getMapId() == 4
							&& !pc.getInventory().checkItem(40548)) {
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
							pc.sendPackets(new S_ServerMessage(79));
						} else {
							L1SpawnUtil.spawn(pc, 45300, 0, 0);// lS
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
					}
				} else if (itemId == 40557) {
					if (pc.getX() == 32620 && pc.getY() == 32641
							&& pc.getMapId() == 4) {
						for (L1Object object : L1World.getInstance()
								.getObject()) {
							if (object instanceof L1NpcInstance) {
								L1NpcInstance npc = (L1NpcInstance) object;
								if (npc.getNpcTemplate().get_npcId() == 45883) {
									pc.sendPackets(new S_ServerMessage(79));
									return;
								}
							}
						}
						L1SpawnUtil.spawn(pc, 45883, 0, 300000);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40563) {
					if (pc.getX() == 32730 && pc.getY() == 32426
							&& pc.getMapId() == 4) {
						for (L1Object object : L1World.getInstance()
								.getObject()) {
							if (object instanceof L1NpcInstance) {
								L1NpcInstance npc = (L1NpcInstance) object;
								if (npc.getNpcTemplate().get_npcId() == 45884) {
									pc.sendPackets(new S_ServerMessage(79));
									return;
								}
							}
						}
						L1SpawnUtil.spawn(pc, 45884, 0, 300000);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40561) {
					if (pc.getX() == 33046 && pc.getY() == 32806
							&& pc.getMapId() == 4) {
						for (L1Object object : L1World.getInstance()
								.getObject()) {
							if (object instanceof L1NpcInstance) {
								L1NpcInstance npc = (L1NpcInstance) object;
								if (npc.getNpcTemplate().get_npcId() == 45885) {
									pc.sendPackets(new S_ServerMessage(79));
									return;
								}
							}
						}
						L1SpawnUtil.spawn(pc, 45885, 0, 300000);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40560) {
					if (pc.getX() == 32580 && pc.getY() == 33260
							&& pc.getMapId() == 4) {
						for (L1Object object : L1World.getInstance()
								.getObject()) {
							if (object instanceof L1NpcInstance) {
								L1NpcInstance npc = (L1NpcInstance) object;
								if (npc.getNpcTemplate().get_npcId() == 45886) {
									pc.sendPackets(new S_ServerMessage(79));
									return;
								}
							}
						}
						L1SpawnUtil.spawn(pc, 45886, 0, 300000);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40562) {
					if (pc.getX() == 33447 && pc.getY() == 33476
							&& pc.getMapId() == 4) {
						for (L1Object object : L1World.getInstance()
								.getObject()) {
							if (object instanceof L1NpcInstance) {
								L1NpcInstance npc = (L1NpcInstance) object;
								if (npc.getNpcTemplate().get_npcId() == 45887) {
									pc.sendPackets(new S_ServerMessage(79));
									return;
								}
							}
						}
						L1SpawnUtil.spawn(pc, 45887, 0, 300000);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40559) {
					if (pc.getX() == 34215 && pc.getY() == 33195
							&& pc.getMapId() == 4) {
						for (L1Object object : L1World.getInstance()
								.getObject()) {
							if (object instanceof L1NpcInstance) {
								L1NpcInstance npc = (L1NpcInstance) object;
								if (npc.getNpcTemplate().get_npcId() == 45888) {
									pc.sendPackets(new S_ServerMessage(79));
									return;
								}
							}
						}
						L1SpawnUtil.spawn(pc, 45888, 0, 300000);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40558) {
					if (pc.getX() == 33513 && pc.getY() == 32890
							&& pc.getMapId() == 4) {
						for (L1Object object : L1World.getInstance()
								.getObject()) {
							if (object instanceof L1NpcInstance) {
								L1NpcInstance npc = (L1NpcInstance) object;
								if (npc.getNpcTemplate().get_npcId() == 45889) {
									pc.sendPackets(new S_ServerMessage(79));
									return;
								}
							}
						}
						L1SpawnUtil.spawn(pc, 45889, 0, 300000);
					} else {
						pc.sendPackets(new S_ServerMessage(79)); 
					}
				} else if (itemId == 40572) { //
					if (pc.getX() == 32778 && pc.getY() == 32738
							&& pc.getMapId() == 21) {
						L1Teleport.teleport(pc, 32781, 32728, (short) 21, 5,
								true);
					} else if (pc.getX() == 32781 && pc.getY() == 32728
							&& pc.getMapId() == 21) {
						L1Teleport.teleport(pc, 32778, 32738, (short) 21, 5,
								true);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40006 || itemId == 40412
						|| itemId == 140006) {
					if (pc.getMap().isUsePainwand()) {
						S_AttackPacket s_attackPacket = new S_AttackPacket(pc,
								0, ActionCodes.ACTION_Wand);
						pc.sendPackets(s_attackPacket);
						pc.broadcastPacket(s_attackPacket);
						int chargeCount = l1iteminstance.getChargeCount();
						if (chargeCount <= 0 && itemId != 40412) {
							pc.sendPackets(new S_ServerMessage(79));
							return;
						}
						int[] mobArray = { 45008, 45140, 45016, 45021, 45025,
								45033, 45099, 45147, 45123, 45130, 45046,
								45092, 45138, 45098, 45127, 45143, 45149,
								45171, 45040, 45155, 45192, 45173, 45213,
								45079, 45144 };
						/*
						 * 45005, 45008, 45009, 45016, 45019, 45043, 45060,
						 * 45066, 45068, 45082, 45093, 45101, 45107, 45126,
						 * 45129, 45136, 45144, 45157, 45161, 45173, 45184,
						 * 45223 };
						 */
						int rnd = _random.nextInt(mobArray.length);
						L1SpawnUtil.spawn(pc, mobArray[rnd], 0, 300000);
						if (itemId == 40006 || itemId == 140006) {
							l1iteminstance.setChargeCount(l1iteminstance
									.getChargeCount() - 1);
							pc.getInventory().updateItem(l1iteminstance,
									L1PcInventory.COL_CHARGE_COUNT);
						} else {
							pc.getInventory().removeItem(l1iteminstance, 1);
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40007) {
					cancelAbsoluteBarrier(pc);
					int chargeCount = l1iteminstance.getChargeCount();
					if (chargeCount <= 0) {
						pc.sendPackets(new S_ServerMessage(79));
						return;
					}
					L1Object target = L1World.getInstance().findObject(
							spellsc_objid);
					pc.sendPackets(new S_UseAttackSkill(pc, spellsc_objid,
							10, spellsc_x, spellsc_y, ActionCodes.ACTION_Wand));
					pc.broadcastPacket(new S_UseAttackSkill(pc, spellsc_objid,
							10, spellsc_x, spellsc_y, ActionCodes.ACTION_Wand));
					if (target != null) {
						doWandAction(pc, target);
					}
					l1iteminstance.setChargeCount(l1iteminstance
							.getChargeCount() - 1);
					pc.getInventory().updateItem(l1iteminstance,
							L1PcInventory.COL_CHARGE_COUNT);
				} else if (itemId == 40008 || itemId == 40410
						|| itemId == 140008) {
					if (pc.getMapId() == 63 || pc.getMapId() == 552
							|| pc.getMapId() == 555 || pc.getMapId() == 557
							|| pc.getMapId() == 558
							|| pc.getMapId() == 779) {
						pc.sendPackets(new S_ServerMessage(563));
					} else {
						pc.sendPackets(new S_AttackPacket(pc, 0,
								ActionCodes.ACTION_Wand));
						pc.broadcastPacket(new S_AttackPacket(pc, 0,
								ActionCodes.ACTION_Wand));
						int chargeCount = l1iteminstance.getChargeCount();
						if (chargeCount <= 0 && itemId != 40410
								|| pc.getTempCharGfx() == 6034
								|| pc.getTempCharGfx() == 6035) {
							pc.sendPackets(new S_ServerMessage(79));
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
								pc.getInventory().updateItem(l1iteminstance,
										L1PcInventory.COL_CHARGE_COUNT);
							} else {
								pc.getInventory().removeItem(l1iteminstance, 1);
							}
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					}
					// if (pc.getId() == target.getId()) { 
					// ;
					// } else if (target instanceof L1PcInstance) {
					// L1PcInstance targetpc = (L1PcInstance) target;
					// if (pc.getClanid() != 0
					// && pc.getClanid() == targetpc.getClanid()) {
					// ;
					// }
					// } else {
					// }
				} else if (itemId >= 40289 && itemId <= 40297) { // toi charms
					useToiTeleportAmulet(pc, itemId, l1iteminstance);
				} else if (itemId >= 40280 && itemId <= 40288) { // sealed toi charms
					pc.getInventory().removeItem(l1iteminstance, 1);
					L1ItemInstance item = pc.getInventory().storeItem(
							itemId + 9, 1);
					if (item != null) {
						pc.sendPackets(new S_ServerMessage(403, item
								.getLogName()));
					}
				} else if (itemId == 40056 || itemId == 40057
						|| itemId == 40059 || itemId == 40060
						|| itemId == 40061 || itemId == 40062
						|| itemId == 40063 || itemId == 40064
						|| itemId == 40065 || itemId == 40069
						|| itemId == 40072 || itemId == 40073
						|| itemId == 140061 || itemId == 140062
						|| itemId == 140065 || itemId == 140069
						|| itemId == 140072 || itemId == 41296
						|| itemId == 41297 || itemId == 41266
						|| itemId == 41267 || itemId == 41274
						|| itemId == 41275 || itemId == 41276
						|| itemId == 41252 || itemId == 49040
						|| itemId == 49041 || itemId == 49042
						|| itemId == 49043 || itemId == 49044
						|| itemId == 49045 || itemId == 49046
						|| itemId == 49047) {
					pc.getInventory().removeItem(l1iteminstance, 1);
					short foodvolume1 = (short)(l1iteminstance.getItem().getFoodVolume() / 10);
					short foodvolume2 = 0;
					if (foodvolume1 <= 0) {
						foodvolume1 = 5;
					}
					if (pc.get_food() >= 225) {
						pc.sendPackets(new S_PacketBox(
								S_PacketBox.FOOD, (short)pc.get_food()));
					} else {
						foodvolume2 = (short)(pc.get_food() + foodvolume1);
						if (foodvolume2 <= 225) {
							pc.set_food(foodvolume2);
							pc.sendPackets(new S_PacketBox(
									S_PacketBox.FOOD, (short)pc.get_food()));
						} else {
							pc.set_food((short)225);
							pc.sendPackets(new S_PacketBox(
									S_PacketBox.FOOD, (short)pc.get_food()));
						}
					}
					if (itemId == 40057) { // Floating Eye Meat
						pc.setSkillEffect(STATUS_FLOATING_EYE, 0);
					}
					pc.sendPackets(new S_ServerMessage(76, l1iteminstance
							.getItem().getIdentifiedNameId()));
				} else if (itemId == 40070) { 
					pc.sendPackets(new S_ServerMessage(76, l1iteminstance
							.getLogName()));
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41298) {
					UseHeallingPotion(pc, 4, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41299) {
					UseHeallingPotion(pc, 15, 194);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41300) {
					UseHeallingPotion(pc, 35, 197);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41301) {
					int chance = _random.nextInt(10);
					if (chance >= 0 && chance < 5) {
						UseHeallingPotion(pc, 15, 189);
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
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41302) {
					int chance = _random.nextInt(3);
					if (chance >= 0 && chance < 5) {
						UseHeallingPotion(pc, 15, 189);
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
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41303) {
					int chance = _random.nextInt(3);
					if (chance >= 0 && chance < 5) {
						UseHeallingPotion(pc, 15, 189);
					} else if (chance >= 5 && chance < 9) {
						createNewItem(pc, 40015, 1);
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
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41304) {
					int chance = _random.nextInt(3);
					if (chance >= 0 && chance < 5) {
						UseHeallingPotion(pc, 15, 189);
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
					pc.getInventory().removeItem(l1iteminstance, 1);
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
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId >= 41357 && itemId <= 41382) {
					int soundid = itemId - 34946;
					S_SkillSound s_skillsound = new S_SkillSound(pc.getId(),
							soundid);
					pc.sendPackets(s_skillsound);
					pc.broadcastPacket(s_skillsound);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 40615) { // Key of Shadow Temple 2F
					if ((pc.getX() >= 32701 && pc.getX() <= 32705)
							&& (pc.getY() >= 32894 && pc.getY() <= 32898)
							&& pc.getMapId() == 522) { //
						L1Teleport.teleport(pc, ((L1EtcItem) l1iteminstance
								.getItem()).get_locx(),
								((L1EtcItem) l1iteminstance.getItem())
										.get_locy(),
								((L1EtcItem) l1iteminstance.getItem())
										.get_mapid(), 5, true);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40616 || itemId == 40782
						|| itemId == 40783) { // Key of Shadow Temple 3F
					if ((pc.getX() >= 32698 && pc.getX() <= 32702)
							&& (pc.getY() >= 32894 && pc.getY() <= 32898)
							&& pc.getMapId() == 523) { 
						L1Teleport.teleport(pc, ((L1EtcItem) l1iteminstance
								.getItem()).get_locx(),
								((L1EtcItem) l1iteminstance.getItem())
										.get_locy(),
								((L1EtcItem) l1iteminstance.getItem())
										.get_mapid(), 5, true);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 40692) { // item 436?
					if (pc.getInventory().checkItem(40621)) {
						pc.sendPackets(new S_ServerMessage(79));
					} else if ((pc.getX() >= 32856 && pc.getX() <= 32858)
							&& (pc.getY() >= 32857 && pc.getY() <= 32858)
							&& pc.getMapId() == 443) { 
						L1Teleport.teleport(pc, ((L1EtcItem) l1iteminstance
								.getItem()).get_locx(),
								((L1EtcItem) l1iteminstance.getItem())
										.get_locy(),
								((L1EtcItem) l1iteminstance.getItem())
										.get_mapid(), 5, true);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 41146) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "ei001"));
				} else if (itemId == 40641) { // Talking Scroll
					if (Config.ALT_TALKINGSCROLLQUEST == true) {
						if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL) == 0) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrolla"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 1) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollb"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 2) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollc"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 3) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrolld"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 4) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrolle"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 5) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollf"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 6) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollg"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 7) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollh"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 8) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrolli"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 9) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollj"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 10) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollk"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 11) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrolll"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 12) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollm"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 13) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrolln"));
						} else if (pc.getQuest().get_step(L1Quest.QUEST_TOSCROLL)
								== 255) {
							pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"tscrollo"));
						}
					} else {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
						"tscrollp"));	
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
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"firsttmap"));
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
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"thirdtmapd"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 6) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"thirdtmape"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 7) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"thirdtmapf"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 8) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"thirdtmapg"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 9) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"thirdtmaph"));
					} else if (pc.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 10) {
						pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
								"thirdtmapi"));
					}
				} else if (itemId == 40663) { //
					pc
							.sendPackets(new S_NPCTalkReturn(pc.getId(),
									"sonsletter"));
				} else if (itemId == 40630) { //
					pc
							.sendPackets(new S_NPCTalkReturn(pc.getId(),
									"diegodiary"));
				} else if (itemId == 41340) { //
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "tion"));
				} else if (itemId == 41317) { 
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "rarson"));
				} else if (itemId == 41318) { 
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(), "kuen"));
				} else if (itemId == 41329) { //
					pc
							.sendPackets(new S_NPCTalkReturn(pc.getId(),
									"anirequest"));
				} else if (itemId == 41346) { //
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"robinscroll"));
				} else if (itemId == 41347) { //
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"robinscroll2"));
				} else if (itemId == 41348) { //
					pc
							.sendPackets(new S_NPCTalkReturn(pc.getId(),
									"robinhood"));
				} else if (itemId == 41007) {
					pc
							.sendPackets(new S_NPCTalkReturn(pc.getId(),
									"erisscroll"));
				} else if (itemId == 41009) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"erisscroll2"));
				} else if (itemId == 41019) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"lashistory1"));
				} else if (itemId == 41020) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"lashistory2"));
				} else if (itemId == 41021) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"lashistory3"));
				} else if (itemId == 41022) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"lashistory4"));
				} else if (itemId == 41023) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"lashistory5"));
				} else if (itemId == 41024) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"lashistory6"));
				} else if (itemId == 41025) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"lashistory7"));
				} else if (itemId == 41026) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"lashistory8"));
				} else if (itemId == 41208) { //
					if ((pc.getX() >= 32844 && pc.getX() <= 32845)
							&& (pc.getY() >= 32693 && pc.getY() <= 32694)
							&& pc.getMapId() == 550) { //
						L1Teleport.teleport(pc, ((L1EtcItem) l1iteminstance
								.getItem()).get_locx(),
								((L1EtcItem) l1iteminstance.getItem())
										.get_locy(),
								((L1EtcItem) l1iteminstance.getItem())
										.get_mapid(), 5, true);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
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
					if (pc.getQuest().get_step(L1Quest.QUEST_SHADOWS)
							== L1Quest.QUEST_END
							|| pc.getInventory().checkItem(41122, 1)) {
						pc.sendPackets(new S_ServerMessage(79));
					} else {
						createNewItem(pc, 41122, 1);
					}
				} else if (itemId == 41130) {
					if (pc.getQuest().get_step(L1Quest.QUEST_DESIRE)
							== L1Quest.QUEST_END
							|| pc.getInventory().checkItem(41131, 1)) {
						pc.sendPackets(new S_ServerMessage(79));
					} else {
						createNewItem(pc, 41131, 1);
					}
				} else if (itemId == 42501) {
					if (pc.getCurrentMp() < 10) {
						pc.sendPackets(new S_ServerMessage(278));
						return;
					}
					pc.setCurrentMp(pc.getCurrentMp() - 10);
					// pc.sendPackets(new S_CantMove()); 
					L1Teleport.teleport(pc, spellsc_x, spellsc_y,
							pc.getMapId(), pc.getHeading(), true,
							L1Teleport.CHANGE_POSITION);
				} else if (itemId == 41293 || itemId == 41294) { //
					startFishing(pc, itemId, fishX, fishY);
				} else if (itemId == 41245) {
					useResolvent(pc, l1iteminstance1, l1iteminstance);
				} else if (itemId == 41248 || itemId == 41249
						|| itemId == 41250 || itemId == 49037
						|| itemId == 49038 || itemId == 49039) {
					useMagicDoll(pc, itemId, itemObjid);
				} else if (itemId >= 41255 && itemId <= 41259) {
					if (cookStatus == 0) {
						pc.sendPackets(new S_PacketBox(S_PacketBox.COOK_WINDOW,
								(itemId - 41255)));
					} else {
						makeCooking(pc, cookNo);
					}
				} else if (itemId == 41260) { // Firewood
					for (L1Object object : L1World.getInstance()
							.getVisibleObjects(pc, 3)) {
						if (object instanceof L1EffectInstance) {
							if (((L1NpcInstance) object).getNpcTemplate()
									.get_npcId() == 81170) {
								pc.sendPackets(new S_ServerMessage(1162));
								return;
							}
						}
					}
					int[] loc = new int[2];
					loc = pc.getFrontLoc();
					L1EffectSpawn.getInstance().spawnEffect(81170, 600000,
							loc[0], loc[1], pc.getMapId());
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId >= 41277 && itemId <= 41292
						|| itemId >= 49049 && itemId <= 49064
						|| itemId >= 49244 && itemId <= 49259) {
					L1Cooking.useCookingItem(pc, l1iteminstance);
				} else if (itemId >= 41383 && itemId <= 41400) {
					useFurnitureItem(pc, itemId, itemObjid);
				} else if (itemId == 41401) {
					useFurnitureRemovalWand(pc, spellsc_objid, l1iteminstance);
				} else if (itemId == 41411) {
					UseHeallingPotion(pc, 10, 189);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41345) {
					L1DamagePoison.doInfection(pc, pc, 3000, 5);
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41315) {
					if (pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA)) {
						pc.sendPackets(new S_ServerMessage(79));
						return;
					}
					if (pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER)) {
						pc.removeSkillEffect(STATUS_HOLY_MITHRIL_POWDER);
					}
					pc.setSkillEffect(STATUS_HOLY_WATER, 900 * 1000);
					pc.sendPackets(new S_SkillSound(pc.getId(), 190));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 190));
					pc.sendPackets(new S_ServerMessage(1141));
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41316) { 
					if (pc.hasSkillEffect(STATUS_HOLY_WATER_OF_EVA)) {
						pc.sendPackets(new S_ServerMessage(79));
						return;
					}
					if (pc.hasSkillEffect(STATUS_HOLY_WATER)) {
						pc.removeSkillEffect(STATUS_HOLY_WATER);
					}
					pc.setSkillEffect(STATUS_HOLY_MITHRIL_POWDER, 900 * 1000);
					pc.sendPackets(new S_SkillSound(pc.getId(), 190));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 190));
					pc.sendPackets(new S_ServerMessage(1142));
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 41354) {
					if (pc.hasSkillEffect(STATUS_HOLY_WATER)
							|| pc.hasSkillEffect(STATUS_HOLY_MITHRIL_POWDER)) {
						pc.sendPackets(new S_ServerMessage(79));
						return;
					}
					pc.setSkillEffect(STATUS_HOLY_WATER_OF_EVA, 900 * 1000);
					pc.sendPackets(new S_SkillSound(pc.getId(), 190));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 190));
					pc.sendPackets(new S_ServerMessage(1140));
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 49092) {
					int targetItemId = l1iteminstance1.getItem().getItemId();
					if (targetItemId == 49095 || targetItemId == 49099) {
						createNewItem(pc, targetItemId + 1, 1);
						pc.getInventory().consumeItem(targetItemId, 1);
						pc.getInventory().consumeItem(49092, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
						return;
					}
				} else if (itemId == 49093) {
					if (pc.getInventory().checkItem(49094, 1)) {
						pc.getInventory().consumeItem(49093, 1);
						pc.getInventory().consumeItem(49094, 1);
						createNewItem(pc, 49095, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 49094) {
					if (pc.getInventory().checkItem(49093, 1)) {
						pc.getInventory().consumeItem(49093, 1);
						pc.getInventory().consumeItem(49094, 1);
						createNewItem(pc, 49095, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 49097) {
					if (pc.getInventory().checkItem(49098, 1)) {
						pc.getInventory().consumeItem(49097, 1);
						pc.getInventory().consumeItem(49098, 1);
						createNewItem(pc, 49099, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 49098) {
					if (pc.getInventory().checkItem(49097, 1)) {
						pc.getInventory().consumeItem(49097, 1);
						pc.getInventory().consumeItem(49098, 1);
						createNewItem(pc, 49099, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 41426) {
					L1ItemInstance lockItem = pc.getInventory().getItem(l);
					int lockItemId = lockItem.getItem().getItemId();
					if (lockItem != null && lockItem.getItem().getType2() == 1
							|| lockItem.getItem().getType2() == 2
							|| lockItem.getItem().getType2() == 0
							&& lockItem.getItem().isCanSeal()) {
						if (lockItem.getBless() == 0
								|| lockItem.getBless() == 1
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
							pc.getInventory().updateItem(lockItem,
									L1PcInventory.COL_BLESS);
							pc.getInventory().saveItem(lockItem,
									L1PcInventory.COL_BLESS);
							pc.getInventory().removeItem(l1iteminstance, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 41427) {
					L1ItemInstance lockItem = pc.getInventory().getItem(l);
					int lockItemId = lockItem.getItem().getItemId();
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
							pc.getInventory().updateItem(lockItem,
									L1PcInventory.COL_BLESS);
							pc.getInventory().saveItem(lockItem,
									L1PcInventory.COL_BLESS);
							pc.getInventory().removeItem(l1iteminstance, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(79));
						}
					} else {
						pc.sendPackets(new S_ServerMessage(79));
					}
				} else if (itemId == 41428) {
					if (pc != null && l1iteminstance != null) {
						Account account = Account.load(pc.getAccountName());
						if (account == null) {
							pc.sendPackets(new S_ServerMessage(79));
							return;
						}
						int characterSlot = account.getCharacterSlot();
						int maxAmount = Config.DEFAULT_CHARACTER_SLOT
								+ characterSlot;
						if (maxAmount >= 8) {
							pc.sendPackets(new S_ServerMessage(79));
							return;
						}
						if (characterSlot < 0) {
							characterSlot = 0;
						} else {
							characterSlot += 1;
						}
						account.setCharacterSlot(characterSlot);
						Account.updateCharacterSlot(account);
						pc.getInventory().removeItem(l1iteminstance, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(79));
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
						pc.getInventory().removeItem(l1iteminstance1, 1);
					} else {
						pc.sendPackets(new S_ServerMessage(154)); 
					}
					pc.getInventory().removeItem(l1iteminstance, 1);
				} else if (itemId == 49210) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"first_p"));
				} else if (itemId == 49211) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"second_p"));
				} else if (itemId == 49212) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"third_p"));
				} else if (itemId == 49287) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"fourth_p"));
				} else if (itemId == 49288) {
					pc.sendPackets(new S_NPCTalkReturn(pc.getId(),
							"fifth_p"));
				} else if (itemId == 49222) {
					if (pc.isDragonKnight()
							&& pc.getMapId() == 61) {
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
							pc.sendPackets(new S_ServerMessage(79));
						} else {
							L1SpawnUtil.spawn(pc, 46161, 0, 0);
						}
						pc.getInventory().consumeItem(49222, 1);
					}
				
				} else {
					int locX = ((L1EtcItem) l1iteminstance.getItem())
							.get_locx();
					int locY = ((L1EtcItem) l1iteminstance.getItem())
							.get_locy();
					short mapId = ((L1EtcItem) l1iteminstance.getItem())
							.get_mapid();
					if (locX != 0 && locY != 0) {
						if (pc.getMap().isEscapable() || pc.isGm()) {
							L1Teleport.teleport(pc, locX, locY, mapId, pc
									.getHeading(), true);
							pc.getInventory().removeItem(l1iteminstance, 1);
						} else {
							pc.sendPackets(new S_ServerMessage(647));
						}
						cancelAbsoluteBarrier(pc);
					} else {
						if (l1iteminstance.getCount() < 1) {
							pc.sendPackets(new S_ServerMessage(329,
									l1iteminstance.getLogName()));
						} else {
							pc.sendPackets(new S_ServerMessage(74,
									l1iteminstance.getLogName()));
						}
					}
				}

			} else if (l1iteminstance.getItem().getType2() == 1) {
				int min = l1iteminstance.getItem().getMinLevel();
				int max = l1iteminstance.getItem().getMaxLevel();
				if (min != 0 && min > pc.getLevel()) {
					pc
							.sendPackets(new S_ServerMessage(318, String
									.valueOf(min)));
				} else if (max != 0 && max < pc.getLevel()) {
					if (max < 50) {
						pc.sendPackets(new S_PacketBox(
								S_PacketBox.MSG_LEVEL_OVER, max));
					} else {
						pc.sendPackets(new S_SystemMessage("You must be at or below level " + max
								+ "to use this item"));
					}
				} else {
					if (pc.isCrown() && l1iteminstance.getItem().isUseRoyal()
							|| pc.isKnight()
							&& l1iteminstance.getItem().isUseKnight()
							|| pc.isElf()
							&& l1iteminstance.getItem().isUseElf()
							|| pc.isWizard()
							&& l1iteminstance.getItem().isUseMage()
							|| pc.isDarkelf()
							&& l1iteminstance.getItem().isUseDarkelf()
							|| pc.isDragonKnight()
							&& l1iteminstance.getItem().isUseDragonknight()
							|| pc.isIllusionist()
							&& l1iteminstance.getItem().isUseIllusionist()) {
						UseWeapon(pc, l1iteminstance);
					} else {
						pc.sendPackets(new S_ServerMessage(264));
					}
				}
			} else if (l1iteminstance.getItem().getType2() == 2) {
				if (pc.isCrown() && l1iteminstance.getItem().isUseRoyal()
						|| pc.isKnight()
						&& l1iteminstance.getItem().isUseKnight() || pc.isElf()
						&& l1iteminstance.getItem().isUseElf() || pc.isWizard()
						&& l1iteminstance.getItem().isUseMage()
						|| pc.isDarkelf()
						&& l1iteminstance.getItem().isUseDarkelf()
						|| pc.isDragonKnight()
						&& l1iteminstance.getItem().isUseDragonknight()
						|| pc.isIllusionist()
						&& l1iteminstance.getItem().isUseIllusionist()) {

					int min = ((L1Armor) l1iteminstance.getItem())
							.getMinLevel();
					int max = ((L1Armor) l1iteminstance.getItem())
							.getMaxLevel();
					if (min != 0 && min > pc.getLevel()) {
						pc.sendPackets(new S_ServerMessage(318, String
								.valueOf(min)));
					} else if (max != 0 && max < pc.getLevel()) {
						if (max < 50) {
							pc.sendPackets(new S_PacketBox(
									S_PacketBox.MSG_LEVEL_OVER, max));
						} else {
							pc.sendPackets(new S_SystemMessage("You must be at or below level " + max + " to use this item."));
						}
					} else {
						UseArmor(pc, l1iteminstance);
					}
				} else {
					pc.sendPackets(new S_ServerMessage(264));
				}
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
	}

	private void SuccessEnchant(L1PcInstance pc, L1ItemInstance item,
			ClientThread client, int i) {
		String s = "";
		String sa = "";
		String sb = "";
		String s1 = item.getName();
		String pm = "";
		if (item.getEnchantLevel() > 0) {
			pm = "+";
		}
		if (item.getItem().getType2() == 1) {
			if (!item.isIdentified() || item.getEnchantLevel() == 0) {
				switch (i) {
				case -1:
					s = s1;
					sa = "$246";
					sb = "$247";
					break;

				case 1: // '\001'
					s = s1;
					sa = "$245";
					sb = "$247";
					break;

				case 2: // '\002'
					s = s1;
					sa = "$245";
					sb = "$248";
					break;

				case 3: // '\003'
					s = s1;
					sa = "$245";
					sb = "$248";
					break;
				}
			} else {
				switch (i) {
				case -1:
					s = (new StringBuilder()).append(
							pm + item.getEnchantLevel()).append(" ").append(s1)
							.toString();
					sa = "$246";
					sb = "$247";
					break;

				case 1: // '\001'
					s = (new StringBuilder()).append(
							pm + item.getEnchantLevel()).append(" ").append(s1)
							.toString();
					sa = "$245";
					sb = "$247";
					break;

				case 2: // '\002'
					s = (new StringBuilder()).append(
							pm + item.getEnchantLevel()).append(" ").append(s1)
							.toString(); //
					sa = "$245";
					sb = "$248";
					break;

				case 3: // '\003'
					s = (new StringBuilder()).append(
							pm + item.getEnchantLevel()).append(" ").append(s1)
							.toString(); //
					sa = "$245";
					sb = "$248";
					break;
				}
			}
		} else if (item.getItem().getType2() == 2) {
			if (!item.isIdentified() || item.getEnchantLevel() == 0) {
				switch (i) {
				case -1:
					s = s1;
					sa = "$246";
					sb = "$247";
					break;

				case 1: // '\001'
					s = s1;
					sa = "$252";
					sb = "$247 ";
					break;

				case 2: // '\002'
					s = s1;
					sa = "$252";
					sb = "$248 ";
					break;

				case 3: // '\003'
					s = s1;
					sa = "$252";
					sb = "$248 ";
					break;
				}
			} else {
				switch (i) {
				case -1:
					s = (new StringBuilder()).append(
							pm + item.getEnchantLevel()).append(" ").append(s1)
							.toString(); //
					sa = "$246";
					sb = "$247";
					break;

				case 1: // '\001'
					s = (new StringBuilder()).append(
							pm + item.getEnchantLevel()).append(" ").append(s1)
							.toString(); //
					sa = "$252";
					sb = "$247 ";
					break;

				case 2: // '\002'
					s = (new StringBuilder()).append(
							pm + item.getEnchantLevel()).append(" ").append(s1)
							.toString(); //
					sa = "$252";
					sb = "$248 ";
					break;

				case 3: // '\003'
					s = (new StringBuilder()).append(
							pm + item.getEnchantLevel()).append(" ").append(s1)
							.toString(); //
					sa = "$252";
					sb = "$248 ";
					break;
				}
			}
		}
		pc.sendPackets(new S_ServerMessage(161, s, sa, sb));
		int oldEnchantLvl = item.getEnchantLevel();
		int newEnchantLvl = item.getEnchantLevel() + i;
		int safe_enchant = item.getItem().get_safeenchant();
		item.setEnchantLevel(newEnchantLvl);
		client.getActiveChar().getInventory().updateItem(item,
				L1PcInventory.COL_ENCHANTLVL);
		if (newEnchantLvl > safe_enchant) {
			client.getActiveChar().getInventory().saveItem(item,
					L1PcInventory.COL_ENCHANTLVL);
		}
		if (item.getItem().getType2() == 1
				&& Config.LOGGING_WEAPON_ENCHANT != 0) {
			if (safe_enchant == 0
					|| newEnchantLvl >= Config.LOGGING_WEAPON_ENCHANT) {
				LogEnchantTable logenchant = new LogEnchantTable();
				logenchant.storeLogEnchant(pc.getId(), item.getId(),
						oldEnchantLvl, newEnchantLvl);
			}
		}
		if (item.getItem().getType2() == 2 && Config.LOGGING_ARMOR_ENCHANT != 0) {
			if (safe_enchant == 0
					|| newEnchantLvl >= Config.LOGGING_ARMOR_ENCHANT) {
				LogEnchantTable logenchant = new LogEnchantTable();
				logenchant.storeLogEnchant(pc.getId(), item.getId(),
						oldEnchantLvl, newEnchantLvl);
			}
		}

		if (item.getItem().getType2() == 2) {
			if (item.isEquipped()) {
				pc.addAc(-i);
				int i2 = item.getItem().getItemId();
				if (i2 == 20011 || i2 == 20110 || i2 == 21108 || i2 == 120011) {
					pc.addMr(i);
					pc.sendPackets(new S_SPMR(pc));
				}
				if (i2 == 20056 || i2 == 120056 || i2 == 220056) {
					pc.addMr(i * 2);
					pc.sendPackets(new S_SPMR(pc));
				}
			}
			pc.sendPackets(new S_OwnCharStatus(pc));
		}
	}

	private void FailureEnchant(L1PcInstance pc, L1ItemInstance item,
			ClientThread client) {
		String s = "";
		String sa = "";
		int itemType = item.getItem().getType2();
		String nameId = item.getName();
		String pm = "";
		if (itemType == 1) {
			if (!item.isIdentified() || item.getEnchantLevel() == 0) {
				s = nameId;
				sa = "$245";
			} else {
				if (item.getEnchantLevel() > 0) {
					pm = "+";
				}
				s = (new StringBuilder()).append(pm + item.getEnchantLevel())
						.append(" ").append(nameId).toString();
				sa = "$245";
			}
		} else if (itemType == 2) {
			if (!item.isIdentified() || item.getEnchantLevel() == 0) {
				s = nameId;
				sa = " $252";
			} else {
				if (item.getEnchantLevel() > 0) {
					pm = "+";
				}
				s = (new StringBuilder()).append(pm + item.getEnchantLevel())
						.append(" ").append(nameId).toString();
				sa = " $252";
			}
		}
		pc.sendPackets(new S_ServerMessage(164, s, sa));
		pc.getInventory().removeItem(item, item.getCount());
	}

	private int EnchantChance(L1ItemInstance l1iteminstance) {
		byte byte0 = 0;
		int i = l1iteminstance.getEnchantLevel();
		if (l1iteminstance.getItem().getType2() == 1) {
			switch (i) {
			case 0: // '\0'
				byte0 = 50;
				break;

			case 1: // '\001'
				byte0 = 33;
				break;

			case 2: // '\002'
				byte0 = 25;
				break;

			case 3: // '\003'
				byte0 = 25;
				break;

			case 4: // '\004'
				byte0 = 25;
				break;

			case 5: // '\005'
				byte0 = 20;
				break;

			case 6: // '\006'
				byte0 = 33;
				break;

			case 7: // '\007'
				byte0 = 33;
				break;

			case 8: // '\b'
				byte0 = 33;
				break;

			case 9: // '\t'
				byte0 = 25;
				break;

			case 10: // '\n'
				byte0 = 20;
				break;
			}
		} else if (l1iteminstance.getItem().getType2() == 2) {
			switch (i) {
			case 0: // '\0'
				byte0 = 50;
				break;

			case 1: // '\001'
				byte0 = 33;
				break;

			case 2: // '\002'
				byte0 = 25;
				break;

			case 3: // '\003'
				byte0 = 25;
				break;

			case 4: // '\004'
				byte0 = 25;
				break;

			case 5: // '\005'
				byte0 = 20;
				break;

			case 6: // '\006'
				byte0 = 17;
				break;

			case 7: // '\007'
				byte0 = 14;
				break;

			case 8: // '\b'
				byte0 = 12;
				break;

			case 9: // '\t'
				byte0 = 11;
				break;
			}
		}
		return byte0;
	}

	private void UseHeallingPotion(L1PcInstance pc, int healHp, int gfxid) {
		if (pc.hasSkillEffect(71) == true) {
			pc.sendPackets(new S_ServerMessage(698));
			return;
		}

		cancelAbsoluteBarrier(pc);

		pc.sendPackets(new S_SkillSound(pc.getId(), gfxid));
		pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid));
		pc.sendPackets(new S_ServerMessage(77));
		healHp *= (_random.nextGaussian() / 5.0D) + 1.0D;
		if (pc.hasSkillEffect(POLLUTE_WATER)) {
			healHp /= 2;
		}
		pc.setCurrentHp(pc.getCurrentHp() + healHp);
	}

	// NOTE: do not remove stacking code
	private void useGreenPotion(L1PcInstance pc, int itemId) {
		if (pc.hasSkillEffect(71) == true) {
			pc.sendPackets(new S_ServerMessage(698));
			return;
		}

		cancelAbsoluteBarrier(pc);

		int time = 0;

		// flag for using b-ghaste
		boolean usedBGHaste = false;

		// grab current haste time
		if (pc.hasSkillEffect(STATUS_HASTE)) {
			time = pc.getSkillEffectTimeSec(STATUS_HASTE);
		}

		int addtime = 0;
		if (itemId == L1ItemId.POTION_OF_HASTE_SELF) {
			addtime = 300;
		} else if (itemId == L1ItemId.B_POTION_OF_HASTE_SELF) {
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
		//check if we should stack or not
		if(Config.STACKING){
			time += addtime;
		} else {
			time = addtime;
		}

		pc.sendPackets(new S_SkillSound(pc.getId(), 191));
		pc.broadcastPacket(new S_SkillSound(pc.getId(), 191));
		if (pc.getHasteItemEquipped() > 0) {
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
		if (pc.hasSkillEffect(SLOW)) { //
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
		if (pc.hasSkillEffect(71) == true) {
			pc.sendPackets(new S_ServerMessage(698));
			return;
		}

		cancelAbsoluteBarrier(pc);

		int time = 0;

		// grab the current brave time
		if (pc.hasSkillEffect(STATUS_BRAVE)) {
			time = pc.getSkillEffectTimeSec(STATUS_BRAVE);
		}
		else if (pc.hasSkillEffect(STATUS_ELFBRAVE)) {
			time = pc.getSkillEffectTimeSec(STATUS_ELFBRAVE);
		}

		int addtime = 0;
		if (item_id == L1ItemId.POTION_OF_EMOTION_BRAVERY) {
			addtime = 300;
		} else if (item_id == L1ItemId.B_POTION_OF_EMOTION_BRAVERY) {
			addtime = 350;
		} else if (item_id == 49158) {
			addtime = 480;
			if (pc.hasSkillEffect(STATUS_BRAVE)) {
				pc.killSkillEffectTimer(STATUS_BRAVE);
				pc.sendPackets(new S_SkillBrave(pc.getId(), 0, 0));
				pc.broadcastPacket(new S_SkillBrave(pc.getId(), 0, 0));
				pc.setBraveSpeed(0);
			}
		} else if (item_id == 41415) {
			addtime = 1800;
		} else if (item_id == 40068) {
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
		} else if (item_id == 140068) {
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
		} else if (item_id == 40031) {
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

		//check if we should stack or not
		if(Config.STACKING){
			time += addtime;
		} else {
			time = addtime;
		}

		// max bound the brave time to 1800 (30min)
		if (time > 1800) {
			time = 1800;
		}

		if (item_id == 40068 || item_id == 140068) {
			pc.sendPackets(new S_SkillBrave(pc.getId(), 3, time));
			pc.broadcastPacket(new S_SkillBrave(pc.getId(), 3, 0));
			pc.sendPackets(new S_SkillSound(pc.getId(), 751));
			pc.broadcastPacket(new S_SkillSound(pc.getId(), 751));
			pc.setSkillEffect(STATUS_ELFBRAVE, time * 1000);
		} else if (item_id == 49158) {
			pc.sendPackets(new S_SkillSound(pc.getId(), 7110));
			pc.broadcastPacket(new S_SkillSound(pc.getId(), 7110));
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
		if (pc.hasSkillEffect(DECAY_POTION)) {
			pc.sendPackets(new S_ServerMessage(698));
			return;
		}

		cancelAbsoluteBarrier(pc);

		int time = 0;
		if (item_id == 40015 || item_id == 40736) {
			time = 600;
		} else if (item_id == 140015) {
			time = 700;
		} else {
			return;
		}

		pc.sendPackets(new S_SkillIconGFX(34, time));
		pc.sendPackets(new S_SkillSound(pc.getId(), 190));
		pc.broadcastPacket(new S_SkillSound(pc.getId(), 190));

		pc.setSkillEffect(STATUS_BLUE_POTION, time * 1000);

		pc.sendPackets(new S_ServerMessage(1007));
	}

	private void useWisdomPotion(L1PcInstance pc, int item_id) {
		if (pc.hasSkillEffect(71) == true) {
			pc.sendPackets(new S_ServerMessage(698));
			return;
		}

		cancelAbsoluteBarrier(pc);

		int time = 0;

		// grab the current wis time
		if (pc.hasSkillEffect(STATUS_WISDOM_POTION)) {
			time = pc.getSkillEffectTimeSec(STATUS_WISDOM_POTION);
		}

		int addtime = 0;
		if (item_id == L1ItemId.POTION_OF_EMOTION_WISDOM) {
			addtime = 300;
		} else if (item_id == L1ItemId.B_POTION_OF_EMOTION_WISDOM) {
			addtime = 360;
		}

		//check if we should stack or not
		if(Config.STACKING){
			time += addtime;
		} else {
			time = addtime;
		}

		if (!pc.hasSkillEffect(STATUS_WISDOM_POTION)) {
			pc.addSp(2);
		}

		// max bound the wis time to 900 (15min)
		if (time > 900) {
			time = 900;
		}

		pc.sendPackets(new S_SkillIconWisdomPotion((int) (time / 4)));
		pc.sendPackets(new S_SkillSound(pc.getId(), 750));
		pc.broadcastPacket(new S_SkillSound(pc.getId(), 750));

		pc.setSkillEffect(STATUS_WISDOM_POTION, time * 1000);
	}

	private void useBlessOfEva(L1PcInstance pc, int item_id) {
		if (pc.hasSkillEffect(71) == true) {
			pc.sendPackets(new S_ServerMessage(698));
			return;
		}

		cancelAbsoluteBarrier(pc);

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
			int timeSec = pc.getSkillEffectTimeSec(STATUS_UNDERWATER_BREATH);
			time += timeSec;
			if (time > 3600) {
				time = 3600;
			}
		}
		pc.sendPackets(new S_SkillIconBlessOfEva(pc.getId(), time));
		pc.sendPackets(new S_SkillSound(pc.getId(), 190));
		pc.broadcastPacket(new S_SkillSound(pc.getId(), 190));
		pc.setSkillEffect(STATUS_UNDERWATER_BREATH, time * 1000);
	}

	private void useBlindPotion(L1PcInstance pc) {
		if (pc.hasSkillEffect(DECAY_POTION)) {
			pc.sendPackets(new S_ServerMessage(698));
			return;
		}

		cancelAbsoluteBarrier(pc);

		int time = 16;
		if (pc.hasSkillEffect(CURSE_BLIND)) {
			pc.killSkillEffectTimer(CURSE_BLIND);
		} else if (pc.hasSkillEffect(DARKNESS)) {
			pc.killSkillEffectTimer(DARKNESS);
		}

		if (pc.hasSkillEffect(STATUS_FLOATING_EYE)) {
			pc.sendPackets(new S_CurseBlind(2));
		} else {
			pc.sendPackets(new S_CurseBlind(1));
		}

		pc.setSkillEffect(CURSE_BLIND, time * 1000);
	}

	private boolean usePolyScroll(L1PcInstance pc, int item_id, String s) {
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS
				|| awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384));
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
				if (pc.getTempCharGfx() == 6034
						|| pc.getTempCharGfx() == 6035) {
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
		if (awakeSkillId == AWAKEN_ANTHARAS
				|| awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384));
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
	private void useSuperDKScroll (L1PcInstance pc, int itemId) {
		int polyId = 0;
		if (itemId == 240101){
			polyId = 5641; //SuperDK
		} else {	
		}
		L1PolyMorph.doPoly(pc, polyId, 6000, L1PolyMorph.MORPH_BY_ITEMMAGIC);
	}

	private void usePolyPotion(L1PcInstance pc, int itemId) {
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS
				|| awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384));
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

	private void UseArmor(L1PcInstance activeChar, L1ItemInstance armor) {
		//never used
		//int itemid = armor.getItem().getItemId();
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
				activeChar.sendPackets(new S_ServerMessage(124));
				return;
			}
			if (type == 7 && activeChar.getWeapon() != null) {
				if (activeChar.getWeapon().getItem().isTwohandedWeapon()) {
					activeChar.sendPackets(new S_ServerMessage(129));
					return;
				}
			}

			if (type == 3 && pcInventory.getTypeEquipped(2, 4) >= 1) {
				activeChar
						.sendPackets(new S_ServerMessage(126, "$224", "$225"));
				return;
			} else if ((type == 3) && pcInventory.getTypeEquipped(2, 2) >= 1) {
				activeChar
						.sendPackets(new S_ServerMessage(126, "$224", "$226"));
				return;
			} else if ((type == 2) && pcInventory.getTypeEquipped(2, 4) >= 1) {
				activeChar
						.sendPackets(new S_ServerMessage(126, "$226", "$225"));
				return;
			}

			cancelAbsoluteBarrier(activeChar);

			pcInventory.setEquipped(armor, true);
		} else if (armor.isEquipped()) {
			if (armor.getItem().getBless() == 2) {
				activeChar.sendPackets(new S_ServerMessage(150));
				return;
			}
			if (type == 3 && pcInventory.getTypeEquipped(2, 2) >= 1) {
				activeChar.sendPackets(new S_ServerMessage(127));
				return;
			} else if ((type == 2 || type == 3)
					&& pcInventory.getTypeEquipped(2, 4) >= 1) {
				activeChar.sendPackets(new S_ServerMessage(127));
				return;
			}
			if (type == 7) {
				if (activeChar.hasSkillEffect(SOLID_CARRIAGE)) {
					activeChar.removeSkillEffect(SOLID_CARRIAGE);
				}
			}
			pcInventory.setEquipped(armor, false);
		} else {
			activeChar.sendPackets(new S_ServerMessage(124));
		}
		activeChar.setCurrentHp(activeChar.getCurrentHp());
		activeChar.setCurrentMp(activeChar.getCurrentMp());
		activeChar.sendPackets(new S_OwnCharAttrDef(activeChar));
		activeChar.sendPackets(new S_OwnCharStatus(activeChar));
		activeChar.sendPackets(new S_SPMR(activeChar));
	}

	private void UseWeapon(L1PcInstance activeChar, L1ItemInstance weapon) {
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
				activeChar.sendPackets(new S_ServerMessage(128));
				return;
			}
		}

		cancelAbsoluteBarrier(activeChar);

		if (activeChar.getWeapon() != null) {
			if (activeChar.getWeapon().getItem().getBless() == 2) {
				activeChar.sendPackets(new S_ServerMessage(150));
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
					.sendPackets(new S_ServerMessage(149, weapon.getLogName()));
		}
		pcInventory.setEquipped(weapon, true, false, false);
	}

	private int RandomELevel(L1ItemInstance item, int itemId) {
		if (itemId == L1ItemId.B_SCROLL_OF_ENCHANT_ARMOR
				|| itemId == L1ItemId.B_SCROLL_OF_ENCHANT_WEAPON
				|| itemId == 140129 || itemId == 140130) {
			if (item.getEnchantLevel() <= 2) {
				int j = _random.nextInt(100) + 1;
				if (j < 32) {
					return 1;
				} else if (j >= 33 && j <= 76) {
					return 2;
				} else if (j >= 77 && j <= 100) {
					return 3;
				}
			} else if (item.getEnchantLevel() >= 3
					&& item.getEnchantLevel() <= 5) {
				int j = _random.nextInt(100) + 1;
				if (j < 50) {
					return 2;
				} else {
					return 1;
				}
			}
			{
				return 1;
			}
		}
		return 1;
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
			L1NpcInstance npc = (L1NpcInstance) target;
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
				pc.sendPackets(new S_ServerMessage(1384));
				return;
			}

			if (pc.getInventory().checkEquipped(20281)) {
				pc.sendPackets(new S_ShowPolyList(pc.getId()));
				if (!pc.isShapeChange()) {
					pc.setShapeChange(true);
				}
				pc.sendPackets(new S_ServerMessage(966));
			} else {
				L1Skills skillTemp = SkillsTable.getInstance().getTemplate(
						SHAPE_CHANGE);

				L1PolyMorph.doPoly(pc, polyId, skillTemp.getBuffDuration(),
						L1PolyMorph.MORPH_BY_ITEMMAGIC);
				if (attacker.getId() != pc.getId()) {
					pc
							.sendPackets(new S_ServerMessage(241, attacker
									.getName()));
				}
			}
		} else if (cha instanceof L1MonsterInstance) {
			L1MonsterInstance mob = (L1MonsterInstance) cha;
			if (mob.getLevel() < 50) {
				int npcId = mob.getNpcTemplate().get_npcId();
				if (npcId != 45338 && npcId != 45370 && npcId != 45456
						&& npcId != 45464 && npcId != 45473 && npcId != 45488
						&& npcId != 45497 && npcId != 45516 && npcId != 45529
						&& npcId != 45458) {
					L1Skills skillTemp = SkillsTable.getInstance().getTemplate(
							SHAPE_CHANGE);
					L1PolyMorph.doPoly(mob, polyId,
							skillTemp.getBuffDuration(),
							L1PolyMorph.MORPH_BY_ITEMMAGIC);
				}
			}
		}
	}

	private void cancelAbsoluteBarrier(L1PcInstance pc) {
		if (pc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			pc.killSkillEffectTimer(ABSOLUTE_BARRIER);
			pc.startHpRegeneration();
			pc.startMpRegeneration();
			pc.startMpRegenerationByDoll();
		}
	}

	private boolean createNewItem(L1PcInstance pc, int item_id, int count) {
		L1ItemInstance item = ItemTable.getInstance().createItem(item_id);
		item.setCount(count);
		if (item != null) {
			if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
				pc.getInventory().storeItem(item);
			} else {
				L1World.getInstance().getInventory(pc.getX(), pc.getY(),
						pc.getMapId()).storeItem(item);
			}
			pc.sendPackets(new S_ServerMessage(403, item.getLogName()));
			return true;
		} else {
			return false;
		}
	}

	private void useToiTeleportAmulet(L1PcInstance pc, int itemId,
			L1ItemInstance item) {
		boolean isTeleport = false;
		if (itemId == 40289 || itemId == 40293) { // 11,51F amulet
			if (pc.getX() >= 32816 && pc.getX() <= 32821 && pc.getY() >= 32778
					&& pc.getY() <= 32783 && pc.getMapId() == 101) {
				isTeleport = true;
			}
		} else if (itemId == 40290 || itemId == 40294) { // 21,61F amulet
			if (pc.getX() >= 32815 && pc.getX() <= 32820 && pc.getY() >= 32815
					&& pc.getY() <= 32820 && pc.getMapId() == 101) {
				isTeleport = true;
			}
		} else if (itemId == 40291 || itemId == 40295) { // 31,71F amulet
			if (pc.getX() >= 32779 && pc.getX() <= 32784 && pc.getY() >= 32778
					&& pc.getY() <= 32783 && pc.getMapId() == 101) {
				isTeleport = true;
			}
		} else if (itemId == 40292 || itemId == 40296) { // 41,81F amulet
			if (pc.getX() >= 32779 && pc.getX() <= 32784 && pc.getY() >= 32815
					&& pc.getY() <= 32820 && pc.getMapId() == 101) {
				isTeleport = true;
			}
		} else if (itemId == 40297) { // 91F amulet
			if (pc.getX() >= 32706 && pc.getX() <= 32710 && pc.getY() >= 32909
					&& pc.getY() <= 32913 && pc.getMapId() == 190) {
				isTeleport = true;
			}
		}

		if (isTeleport || Config.USE_TOI_CHARM_ANYWHERE) {
			L1Teleport.teleport(pc, item.getItem().get_locx(), item.getItem()
					.get_locy(), item.getItem().get_mapid(), 5, true);
		} else {
			pc.sendPackets(new S_ServerMessage(79));
		}
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
		item.setCount(1);
		if (item == null) {
			return false;
		}

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
			if (clan.getClanName().toLowerCase().equals(
					letterReceiver.toLowerCase())) {
				targetClan = clan;
				break;
			}
		}
		if (targetClan == null) {
			pc.sendPackets(new S_ServerMessage(434));
			return false;
		}

		String memberName[] = targetClan.getAllMembers();
		for (int i = 0; i < memberName.length; i++) {
			L1ItemInstance item = ItemTable.getInstance().createItem(49016);
			item.setCount(1);
			if (item == null) {
				return false;
			}
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
				target.sendPackets(new S_ServerMessage(428));
			} else {
				if (isFailureMessage) {
					pc.sendPackets(new S_ServerMessage(942));
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
							pc.sendPackets(new S_ServerMessage(942));
						}
						return false;
					}
				} catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			} else {
				if (isFailureMessage) {
					pc.sendPackets(new S_ServerMessage(109, name));
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
			pc.sendPackets(new S_ServerMessage(563));
			return false;
		}

		int petCost = 0;
		Object[] petList = pc.getPetList().values().toArray();
		for (Object pet : petList) {
			if (pet instanceof L1PetInstance) {
				if (((L1PetInstance) pet).getItemObjId() == itemObjectId) {
					return false;
				}
			}
			petCost += ((L1NpcInstance) pet).getPetcost();
		}
		int charisma = pc.getCha();
		if (pc.isCrown()) {
			charisma += 6;
		} else if (pc.isElf()) {
			charisma += 12;
		} else if (pc.isWizard()) { // WIZ
			charisma += 6;
		} else if (pc.isDarkelf()) { // DE
			charisma += 6;
		} else if (pc.isDragonKnight()) {
			charisma += 6;
		} else if (pc.isIllusionist()) {
			charisma += 6;
		}
		charisma -= petCost;
		int petCount = charisma / 6;
		if (petCount <= 0) {
			pc.sendPackets(new S_ServerMessage(489));
			return false;
		}

		L1Pet l1pet = PetTable.getInstance().getTemplate(itemObjectId);
		if (l1pet != null) {
			L1Npc npcTemp = NpcTable.getInstance().getTemplate(
					l1pet.get_npcId());
			L1PetInstance pet = new L1PetInstance(npcTemp, pc, l1pet);
			pet.setPetcost(6);
		}
		return true;
	}

	private void startFishing(L1PcInstance pc, int itemId, int fishX, int fishY) {
		if (pc.getMapId() != 5124 || fishX <= 32789 || fishX >= 32813
				|| fishY <= 32786 || fishY >= 32812) {
			pc.sendPackets(new S_ServerMessage(1138));
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
					pc.sendPackets(new S_ServerMessage(1138));
				} else if (fishY > pc.getY() + rodLength
						|| fishY < pc.getY() - rodLength) {
					pc.sendPackets(new S_ServerMessage(1138));
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
					pc.sendPackets(new S_ServerMessage(1137));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1138));
			}
		} else {
			pc.sendPackets(new S_ServerMessage(1138));
		}
	}

	private void useResolvent(L1PcInstance pc, L1ItemInstance item,
			L1ItemInstance resolvent) {
		if (item == null || resolvent == null) {
			pc.sendPackets(new S_ServerMessage(79));
			return;
		}
		if (item.getItem().getType2() == 1 || item.getItem().getType2() == 2) {
			if (item.getEnchantLevel() != 0) {
				pc.sendPackets(new S_ServerMessage(1161));
				return;
			}
			if (item.isEquipped()) {
				pc.sendPackets(new S_ServerMessage(1161));
				return;
			}
		}
		int crystalCount = ResolventTable.getInstance().getCrystalCount(
				item.getItem().getItemId());
		if (crystalCount == 0) {
			pc.sendPackets(new S_ServerMessage(1161));
			return;
		}

		int rnd = _random.nextInt(100) + 1;
		if (rnd >= 1 && rnd <= 50) {
			crystalCount = 0;
			pc.sendPackets(new S_ServerMessage(158, item.getName()));
		} else if (rnd >= 51 && rnd <= 90) {
			crystalCount *= 1;
		} else if (rnd >= 91 && rnd <= 100) {
			crystalCount *= 1.5;
			pc.getInventory().storeItem(41246, (int) (crystalCount * 1.5));
		}
		if (crystalCount != 0) {
			L1ItemInstance crystal = ItemTable.getInstance().createItem(41246);
			crystal.setCount(crystalCount);
			if (pc.getInventory().checkAddItem(crystal, 1) == L1Inventory.OK) {
				pc.getInventory().storeItem(crystal);
				pc.sendPackets(new S_ServerMessage(403, crystal.getLogName()));
			} else {
				L1World.getInstance().getInventory(pc.getX(), pc.getY(),
						pc.getMapId()).storeItem(crystal);
			}
		} 
		pc.getInventory().removeItem(item, 1);
		pc.getInventory().removeItem(resolvent, 1);
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
				pc.sendPackets(new S_ServerMessage(337, "$5240"));
				return;
			}
			if (dollList.length >= Config.MAX_DOLL_COUNT) {
				pc.sendPackets(new S_ServerMessage(319));
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
			pc.sendPackets(new S_ServerMessage(1160));
			return;
		}
		if (pc.getMaxWeight() <= pc.getInventory().getWeight()) {
			pc.sendPackets(new S_ServerMessage(1103));
			return;
		}
		if (pc.hasSkillEffect(COOKING_NOW)) {
			return;
		}
		pc.setSkillEffect(COOKING_NOW, 3 * 1000);

		int chance = _random.nextInt(100) + 1;
		if (cookNo == 0) {
			if (pc.getInventory().checkItem(40057, 1)) {
				pc.getInventory().consumeItem(40057, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 41277, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 41285, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 1) {
			if (pc.getInventory().checkItem(41275, 1)) {
				pc.getInventory().consumeItem(41275, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 41278, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 41286, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 2) {
			if (pc.getInventory().checkItem(41263, 1)
					&& pc.getInventory().checkItem(41265, 1)) {
				pc.getInventory().consumeItem(41263, 1);
				pc.getInventory().consumeItem(41265, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 41279, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 41287, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 3) {
			if (pc.getInventory().checkItem(41274, 1)
					&& pc.getInventory().checkItem(41267, 1)) {
				pc.getInventory().consumeItem(41274, 1);
				pc.getInventory().consumeItem(41267, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 41280, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 41288, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 4) {
			if (pc.getInventory().checkItem(40062, 1)
					&& pc.getInventory().checkItem(40069, 1)
					&& pc.getInventory().checkItem(40064, 1)) {
				pc.getInventory().consumeItem(40062, 1);
				pc.getInventory().consumeItem(40069, 1);
				pc.getInventory().consumeItem(40064, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 41281, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 41289, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101)); 
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 5) {
			if (pc.getInventory().checkItem(40056, 1)
					&& pc.getInventory().checkItem(40060, 1)
					&& pc.getInventory().checkItem(40061, 1)) {
				pc.getInventory().consumeItem(40056, 1);
				pc.getInventory().consumeItem(40060, 1);
				pc.getInventory().consumeItem(40061, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 41282, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 41290, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 6) {
			if (pc.getInventory().checkItem(41276, 1)) {
				pc.getInventory().consumeItem(41276, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 41283, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 41291, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 7) {
			if (pc.getInventory().checkItem(40499, 1)
					&& pc.getInventory().checkItem(40060, 1)) {
				pc.getInventory().consumeItem(40499, 1);
				pc.getInventory().consumeItem(40060, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 41284, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 41292, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 8) {
			if (pc.getInventory().checkItem(49040, 1)
					&& pc.getInventory().checkItem(49048, 1)) {
				pc.getInventory().consumeItem(49040, 1);
				pc.getInventory().consumeItem(49048, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49049, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49057, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 9) {
			if (pc.getInventory().checkItem(49041, 1)
					&& pc.getInventory().checkItem(49048, 1)) {
				pc.getInventory().consumeItem(49041, 1);
				pc.getInventory().consumeItem(49048, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49050, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49058, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 10) { 
			if (pc.getInventory().checkItem(49042, 1)
					&& pc.getInventory().checkItem(41265, 1)
					&& pc.getInventory().checkItem(49048, 1)) {
				pc.getInventory().consumeItem(49042, 1);
				pc.getInventory().consumeItem(41265, 1);
				pc.getInventory().consumeItem(49048, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49051, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49059, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 11) {
			if (pc.getInventory().checkItem(49043, 1)
					&& pc.getInventory().checkItem(49048, 1)) {
				pc.getInventory().consumeItem(49043, 1);
				pc.getInventory().consumeItem(49048, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49052, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49060, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 12) {
			if (pc.getInventory().checkItem(49044, 1)
					&& pc.getInventory().checkItem(49048, 1)) {
				pc.getInventory().consumeItem(49044, 1);
				pc.getInventory().consumeItem(49048, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49053, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49061, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102)); 
			}
		} else if (cookNo == 13) {
			if (pc.getInventory().checkItem(49045, 1)
					&& pc.getInventory().checkItem(49048, 1)) {
				pc.getInventory().consumeItem(49045, 1);
				pc.getInventory().consumeItem(49048, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49054, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49062, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 14) {
			if (pc.getInventory().checkItem(49046, 1)
					&& pc.getInventory().checkItem(49048, 1)) {
				pc.getInventory().consumeItem(49046, 1);
				pc.getInventory().consumeItem(49048, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49055, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49063, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 15) {
			if (pc.getInventory().checkItem(49047, 1)
					&& pc.getInventory().checkItem(40499, 1)
					&& pc.getInventory().checkItem(49048, 1)) {
				pc.getInventory().consumeItem(49047, 1);
				pc.getInventory().consumeItem(40499, 1);
				pc.getInventory().consumeItem(49048, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49056, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49064, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 16) {
			if (pc.getInventory().checkItem(49048, 1)
					&& pc.getInventory().checkItem(49243, 1)
					&& pc.getInventory().checkItem(49260, 1)) {
				pc.getInventory().consumeItem(49048, 1);
				pc.getInventory().consumeItem(49243, 1);
				pc.getInventory().consumeItem(49260, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49244, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49252, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 17) {
			if (pc.getInventory().checkItem(49048, 1)
					&& pc.getInventory().checkItem(49243, 1)
					&& pc.getInventory().checkItem(49261, 1)) {
				pc.getInventory().consumeItem(49048, 1);
				pc.getInventory().consumeItem(49243, 1);
				pc.getInventory().consumeItem(49261, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49245, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49253, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 18) {
			if (pc.getInventory().checkItem(49048, 1)
					&& pc.getInventory().checkItem(49243, 1)
					&& pc.getInventory().checkItem(49262, 1)) {
				pc.getInventory().consumeItem(49048, 1);
				pc.getInventory().consumeItem(49243, 1);
				pc.getInventory().consumeItem(49262, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49246, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49254, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 19) {
			if (pc.getInventory().checkItem(49048, 1)
					&& pc.getInventory().checkItem(49243, 1)
					&& pc.getInventory().checkItem(49263, 1)) {
				pc.getInventory().consumeItem(49048, 1);
				pc.getInventory().consumeItem(49243, 1);
				pc.getInventory().consumeItem(49263, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49247, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49255, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 20) {
			if (pc.getInventory().checkItem(49048, 1)
					&& pc.getInventory().checkItem(49243, 1)
					&& pc.getInventory().checkItem(49264, 1)) {
				pc.getInventory().consumeItem(49048, 1);
				pc.getInventory().consumeItem(49243, 1);
				pc.getInventory().consumeItem(49264, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49248, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49256, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 21) {
			if (pc.getInventory().checkItem(49048, 1)
					&& pc.getInventory().checkItem(49243, 1)
					&& pc.getInventory().checkItem(49265, 1)) {
				pc.getInventory().consumeItem(49048, 1);
				pc.getInventory().consumeItem(49243, 1);
				pc.getInventory().consumeItem(49265, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49249, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49257, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 22) {
			if (pc.getInventory().checkItem(49048, 1)
					&& pc.getInventory().checkItem(49243, 1)
					&& pc.getInventory().checkItem(49266, 1)) {
				pc.getInventory().consumeItem(49048, 1);
				pc.getInventory().consumeItem(49243, 1);
				pc.getInventory().consumeItem(49266, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49250, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49258, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		} else if (cookNo == 23) {
			if (pc.getInventory().checkItem(49048, 1)
					&& pc.getInventory().checkItem(49243, 1)
					&& pc.getInventory().checkItem(49267, 1)) {
				pc.getInventory().consumeItem(49048, 1);
				pc.getInventory().consumeItem(49243, 1);
				pc.getInventory().consumeItem(49267, 1);
				if (chance >= 1 && chance <= 90) {
					createNewItem(pc, 49251, 1);
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6392));
				} else if (chance >= 91 && chance <= 95) {
					createNewItem(pc, 49259, 1);
					pc.sendPackets(new S_SkillSound(pc.getId(), 6390));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6390));
				} else if (chance >= 96 && chance <= 100) {
					pc.sendPackets(new S_ServerMessage(1101));
					pc.broadcastPacket(new S_SkillSound(pc.getId(), 6394));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(1102));
			}
		}
	}

	private void useFurnitureItem(L1PcInstance pc, int itemId, int itemObjectId) {
		if (!L1HouseLocation.isInHouse(pc.getX(), pc.getY(), pc.getMapId())) {
			pc.sendPackets(new S_ServerMessage(563));
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
			if (itemId == 41383) {
				npcId = 80109;
			} else if (itemId == 41384) {
				npcId = 80110;
			} else if (itemId == 41385) {
				npcId = 80113;
			} else if (itemId == 41386) {
				npcId = 80114;
			} else if (itemId == 41387) {
				npcId = 80115;
			} else if (itemId == 41388) {
				npcId = 80124;
			} else if (itemId == 41389) {
				npcId = 80118;
			} else if (itemId == 41390) {
				npcId = 80119;
			} else if (itemId == 41391) {
				npcId = 80120;
			} else if (itemId == 41392) {
				npcId = 80121;
			} else if (itemId == 41393) {
				npcId = 80126;
			} else if (itemId == 41394) {
				npcId = 80125;
			} else if (itemId == 41395) {
				npcId = 80111;
			} else if (itemId == 41396) {
				npcId = 80112;
			} else if (itemId == 41397) {
				npcId = 80116;
			} else if (itemId == 41398) {
				npcId = 80117;
			} else if (itemId == 41399) {
				npcId = 80122;
			} else if (itemId == 41400) {
				npcId = 80123;
			}

			try {
				L1Npc l1npc = NpcTable.getInstance().getTemplate(npcId);
				if (l1npc != null) {
					// unused
					//Object obj = null;
					try {
						String s = l1npc.getImpl();
						Constructor constructor = Class.forName("l1j.server.server.model.Instance." + s + "Instance").getConstructors()[0];
						Object aobj[] = { l1npc };
						furniture = (L1FurnitureInstance) constructor.newInstance(aobj);
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
						FurnitureSpawnTable.getInstance().insertFurniture(furniture);
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

	private void useFurnitureRemovalWand(L1PcInstance pc, int targetId, L1ItemInstance item) {
		S_AttackPacket s_attackPacket = new S_AttackPacket(pc, 0, ActionCodes.ACTION_Wand);
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

	@Override
	public String getType() {
		return C_ITEM_USE;
	}
}
