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

import java.util.ArrayList;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_AddSkill;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.templates.L1Skills;
import l1j.server.server.types.Point;
import l1j.server.server.utils.ArrayUtil;
import l1j.server.server.utils.IntRange;

public class L1SpellBook {
	private static L1Alignment getSpellAlignment(int itemId) {
		int lawfuls[] = { 45000, 45008, 45018, 45021, 40171, 40179, 40180,
				40182, 40194, 40197, 40202, 40206, 40213, 40220, 40222 };
		int chaotics[] = { 45009, 45010, 45019, 40172, 40173, 40178, 40185,
				40186, 40192, 40196, 40201, 40204, 40211, 40221, 40225 };

		if (ArrayUtil.contains(lawfuls, itemId)) {
			return L1Alignment.LAWFUL;
		}
		if (ArrayUtil.contains(chaotics, itemId)) {
			return L1Alignment.CHAOTIC;
		}
		return L1Alignment.NEUTRAL;
	}

	private static L1MapArea LAWFUL_TEMPLE1 = new L1MapArea(33117, 32931,
			33127, 32941, 4);
	private static L1MapArea LAWFUL_TEMPLE2 = new L1MapArea(33136, 32236,
			33146, 32246, 4);
	private static L1MapArea LAWFUL_TEMPLE3 = new L1MapArea(32783, 32831,
			32803, 32851, 77);

	private static L1MapArea CHAOTIC_TEMPLE1 = new L1MapArea(32881, 32647,
			32891, 32657, 4);
	private static L1MapArea CHAOTIC_TEMPLE2 = new L1MapArea(32663, 32298,
			32673, 32308, 4);

	private static L1Alignment getTempleAlignment(L1Location loc) {
		L1MapArea lawfuls[] = { LAWFUL_TEMPLE1, LAWFUL_TEMPLE2, LAWFUL_TEMPLE3 };
		L1MapArea chaotics[] = { CHAOTIC_TEMPLE1, CHAOTIC_TEMPLE2 };
		for (L1MapArea area : lawfuls) {
			if (area.contains(loc)) {
				return L1Alignment.LAWFUL;
			}
		}
		for (L1MapArea area : chaotics) {
			if (area.contains(loc)) {
				return L1Alignment.CHAOTIC;
			}
		}
		return null;
	}

	private static final ArrayList<IntRange> ITEMID_LEVEL_RANGES = new ArrayList<IntRange>();

	static {
		ITEMID_LEVEL_RANGES.add(new IntRange(45000, 45007)); // Lv1
		ITEMID_LEVEL_RANGES.add(new IntRange(45008, 45015)); // Lv2
		ITEMID_LEVEL_RANGES.add(new IntRange(45016, 45022)); // Lv3
		ITEMID_LEVEL_RANGES.add(new IntRange(40170, 40177)); // Lv4
		ITEMID_LEVEL_RANGES.add(new IntRange(40178, 40185)); // Lv5
		ITEMID_LEVEL_RANGES.add(new IntRange(40186, 40193)); // Lv6
		ITEMID_LEVEL_RANGES.add(new IntRange(40194, 40201)); // Lv7
		ITEMID_LEVEL_RANGES.add(new IntRange(40202, 40209)); // Lv8
		ITEMID_LEVEL_RANGES.add(new IntRange(40210, 40217)); // Lv9
		ITEMID_LEVEL_RANGES.add(new IntRange(40218, 40225)); // Lv10
	}

	private static int getSpellLevel(int itemId) {
		for (int i = 0; i < ITEMID_LEVEL_RANGES.size(); i++) {
			if (ITEMID_LEVEL_RANGES.get(i).includes(itemId)) {
				return i + 1;
			}
		}
		throw new IllegalArgumentException("itemId is not spell's one.");
	}

	private static boolean isValidAlignment(L1Alignment spell,
			L1Alignment temple) {
		return spell == temple || spell == L1Alignment.NEUTRAL;
	}

	private static void sendLearningEffect(L1PcInstance pc, L1Alignment temple) {
		if (temple == null || temple == L1Alignment.NEUTRAL) {
			throw new IllegalArgumentException("Invalid alignment");
		}
		int effectId = (temple == L1Alignment.LAWFUL) ? 224 : 231;
		S_SkillSound effect = new S_SkillSound(pc.getId(), effectId);
		pc.sendPackets(effect);
		pc.broadcastPacket(effect);
	}

	private static boolean tryToLearnSpell(L1PcInstance pc, L1ItemInstance item) {
		int itemId = item.getItem().getItemId();
		int spellLevel = getSpellLevel(itemId);
		if (pc.getClassFeature().getMaxSpellLevel() < spellLevel) {
			pc.sendPackets(new S_ServerMessage(79));
			return false;
		}
		if (pc.getLevel() < spellLevel
				* pc.getClassFeature().getSpellLearningInterval()) {
			pc.sendPackets(new S_ServerMessage(312));
			return false;
		}
		learnSpell(pc, item);
		return true;
	}

	private static void failInLearningSpell(L1PcInstance pc, L1ItemInstance item) {
		pc.getInventory().removeItem(item, 1);
		pc.sendPackets(new S_ServerMessage(79));
		S_SkillSound effect = new S_SkillSound(pc.getId(), 10);
		pc.sendPackets(effect);
		pc.broadcastPacket(effect);
		pc.setCurrentHp(Math.max(pc.getCurrentHp() - 45, 0));
		if (pc.getCurrentHp() <= 0) {
			pc.death(null);
		}
	}

	public static void useSpellBook(L1PcInstance pc, L1ItemInstance item) {
		int itemId = item.getItem().getItemId();
		L1Alignment spellAlignment = getSpellAlignment(itemId);
		L1Alignment templeAlignment = getTempleAlignment(pc.getLocation());
		if (pc.isGm()) {
			learnSpell(pc, item);
			sendLearningEffect(pc, templeAlignment);
			return;
		}
		if (templeAlignment == null) {
			pc.sendPackets(new S_ServerMessage(79));
			return;
		}
		if (isValidAlignment(spellAlignment, templeAlignment)) {
			if (tryToLearnSpell(pc, item)) {
				sendLearningEffect(pc, templeAlignment);
			}
		} else {
			failInLearningSpell(pc, item);
		}
	}

	private static void learnSpell(L1PcInstance pc, L1ItemInstance item) {
		pc.getInventory().removeItem(item, 1);
		L1Skills skill = SkillsTable.getInstance().findByItemName(
				item.getItem().getName());
		pc.sendPackets(new S_AddSkill(skill));
		SkillsTable.getInstance().spellMastery(pc.getId(), skill.getSkillId(),
				skill.getName(), 0, 0);
	}

	public static void useElfSpellBook(L1PcInstance pc, L1ItemInstance item,
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
			}
		} else {
			pc.sendPackets(new S_ServerMessage(79));
		}
	}

	public static boolean isLearnElfMagic(L1PcInstance pc) {
		int pcX = pc.getX();
		int pcY = pc.getY();
		int pcMapId = pc.getMapId();
		if (pcX >= 32786 && pcX <= 32797 && pcY >= 32842
			&& pcY <= 32859
			&& pcMapId == 75
			|| pc.getLocation().isInScreen(new Point(33055, 32336))
			&& pcMapId == 4) {
			return true;
		}
		return false;
	}

	public static void SpellBook1(L1PcInstance pc,
			L1ItemInstance l1iteminstance, ClientThread clientthread) {
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
			L1Skills l1skills = SkillsTable.getInstance().findBySkillId(j6);
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
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2,
		k2, l2, i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5,
		i6, 0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 231);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillsTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	public static void SpellBook2(L1PcInstance pc, L1ItemInstance l1iteminstance) {
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
			L1Skills l1skills = SkillsTable.getInstance().findBySkillId(j6);
			String s1 = "Spellbook(" + l1skills.getName() + ")";
			if (l1iteminstance.getItem().getName().equalsIgnoreCase(s1)) {
				if (!pc.isGm() && l1skills.getAttr() != 0
						&& pc.getElfAttr() != l1skills.getAttr()) {
					if (pc.getElfAttr() == 0 || pc.getElfAttr() == 1
						|| pc.getElfAttr() == 2 || pc.getElfAttr() == 4
						|| pc.getElfAttr() == 8) {
						pc.sendPackets(new S_ServerMessage(79));
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
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2,
		k2, l2, i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5,
		i6, 0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillsTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	public static void SpellBook3(L1PcInstance pc,
			L1ItemInstance l1iteminstance, ClientThread clientthread) {
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
            L1Skills l1skills = SkillsTable.getInstance().findBySkillId(j6);
			String s1 = (new StringBuilder()).append("Spellbook(").append(
					l1skills.getName()).append(")").toString();
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
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2,
		k2, l2, i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5,
		i6, 0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillsTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	public static void SpellBook4(L1PcInstance pc,
			L1ItemInstance l1iteminstance, ClientThread clientthread) {
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
			L1Skills l1skills = SkillsTable.getInstance().findBySkillId(j6);
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
		pc.sendPackets(new S_AddSkill(j, k, l, i1, j1, k1, l1, i2, j2,
		k2, l2, i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5,
		i6, 0, 0, 0, 0));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillsTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	public static void SpellBook5(L1PcInstance pc,
			L1ItemInstance l1iteminstance, ClientThread clientthread) {
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
			L1Skills l1skills = SkillsTable.getInstance().findBySkillId(j6);
			String s1 = "DragonKnight Tablets" + l1skills.getName() + ")";
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
		i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6, j8, k8, l8, i8));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillsTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}

	public static void SpellBook6(L1PcInstance pc,
			L1ItemInstance l1iteminstance, ClientThread clientthread) {
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
			L1Skills l1skills = SkillsTable.getInstance().findBySkillId(j6);
			String s1 = "Illusionist Crystal" + l1skills.getName() + ")";
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
		i3, j3, k3, l3, i4, j4, k4, l4, i5, j5, k5, l5, i6, j8, k8, l8, i8));
		S_SkillSound s_skillSound = new S_SkillSound(k6, 224);
		pc.sendPackets(s_skillSound);
		pc.broadcastPacket(s_skillSound);
		SkillsTable.getInstance().spellMastery(k6, i, s, 0, 0);
		pc.getInventory().removeItem(l1iteminstance, 1);
	}
}