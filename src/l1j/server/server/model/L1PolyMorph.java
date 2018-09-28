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

import static l1j.server.server.model.skill.L1SkillId.SHAPE_CHANGE;

import java.util.HashMap;
import java.util.Map;

import l1j.server.Config;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.serverpackets.S_ChangeShape;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_CloseList;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillIconGFX;

// Referenced classes of package l1j.server.server.model:
// L1PcInstance

public class L1PolyMorph {

	// weapon equip bit
	private static final int DAGGER_EQUIP = 1;

	private static final int SWORD_EQUIP = 2;

	private static final int TWOHANDSWORD_EQUIP = 4;

	private static final int AXE_EQUIP = 8;

	private static final int SPEAR_EQUIP = 16;

	private static final int STAFF_EQUIP = 32;

	private static final int EDORYU_EQUIP = 64;

	private static final int CLAW_EQUIP = 128;

	private static final int BOW_EQUIP = 256;

	private static final int KIRINGKU_EQUIP = 512;

	private static final int CHAINSWORD_EQUIP = 1024;

	// armor equip bit
	private static final int HELM_EQUIP = 1;

	private static final int AMULET_EQUIP = 2;

	private static final int EARRING_EQUIP = 4;

	private static final int TSHIRT_EQUIP = 8;

	private static final int ARMOR_EQUIP = 16;

	private static final int CLOAK_EQUIP = 32;

	private static final int BELT_EQUIP = 64;

	private static final int SHIELD_EQUIP = 128;

	private static final int GLOVE_EQUIP = 256;

	private static final int RING_EQUIP = 512;

	private static final int BOOTS_EQUIP = 1024;

	private static final int GUARDER_EQUIP = 2048;

	public static final int MORPH_BY_ITEMMAGIC = 1;

	public static final int MORPH_BY_GM = 2;

	public static final int MORPH_BY_NPC = 4; //

	public static final int MORPH_BY_KEPLISHA = 8;

	public static final int MORPH_BY_LOGIN = 0;

	private static final Map<Integer, Integer> weaponFlgMap = new HashMap<Integer, Integer>();
	static {
		weaponFlgMap.put(1, SWORD_EQUIP);
		weaponFlgMap.put(2, DAGGER_EQUIP);
		weaponFlgMap.put(3, TWOHANDSWORD_EQUIP);
		weaponFlgMap.put(4, BOW_EQUIP);
		weaponFlgMap.put(5, SPEAR_EQUIP);
		weaponFlgMap.put(6, AXE_EQUIP);
		weaponFlgMap.put(7, STAFF_EQUIP);
		weaponFlgMap.put(8, BOW_EQUIP);
		weaponFlgMap.put(9, BOW_EQUIP);
		weaponFlgMap.put(10, BOW_EQUIP);
		weaponFlgMap.put(11, CLAW_EQUIP);
		weaponFlgMap.put(12, EDORYU_EQUIP);
		weaponFlgMap.put(13, BOW_EQUIP);
		weaponFlgMap.put(14, SPEAR_EQUIP);
		weaponFlgMap.put(15, AXE_EQUIP);
		weaponFlgMap.put(16, STAFF_EQUIP);
		weaponFlgMap.put(17, KIRINGKU_EQUIP);
		weaponFlgMap.put(18, CHAINSWORD_EQUIP);
	}
	private static final Map<Integer, Integer> armorFlgMap = new HashMap<Integer, Integer>();
	static {
		armorFlgMap.put(1, HELM_EQUIP);
		armorFlgMap.put(2, ARMOR_EQUIP);
		armorFlgMap.put(3, TSHIRT_EQUIP);
		armorFlgMap.put(4, CLOAK_EQUIP);
		armorFlgMap.put(5, GLOVE_EQUIP);
		armorFlgMap.put(6, BOOTS_EQUIP);
		armorFlgMap.put(7, SHIELD_EQUIP);
		armorFlgMap.put(8, AMULET_EQUIP);
		armorFlgMap.put(9, RING_EQUIP);
		armorFlgMap.put(10, BELT_EQUIP);
		armorFlgMap.put(12, EARRING_EQUIP);
		armorFlgMap.put(13, GUARDER_EQUIP);
	}

	private int _id;
	private String _name;
	private int _polyId;
	private int _minLevel;
	private int _weaponEquipFlg;
	private int _armorEquipFlg;
	private boolean _canUseSkill;
	private int _causeFlg;

	public L1PolyMorph(int id, String name, int polyId, int minLevel,
			int weaponEquipFlg, int armorEquipFlg, boolean canUseSkill,
			int causeFlg) {
		_id = id;
		_name = name;
		_polyId = polyId;
		_minLevel = minLevel;
		_weaponEquipFlg = weaponEquipFlg;
		_armorEquipFlg = armorEquipFlg;
		_canUseSkill = canUseSkill;
		_causeFlg = causeFlg;
	}

	public int getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	public int getPolyId() {
		return _polyId;
	}

	public int getMinLevel() {
		return _minLevel;
	}

	public int getWeaponEquipFlg() {
		return _weaponEquipFlg;
	}

	public int getArmorEquipFlg() {
		return _armorEquipFlg;
	}

	public boolean canUseSkill() {
		return _canUseSkill;
	}

	public int getCauseFlg() {
		return _causeFlg;
	}

	public static void handleCommands(L1PcInstance pc, String s) {
		if (pc == null || pc.isDead()) {
			return;
		}
		L1PolyMorph poly = PolyTable.getInstance().getTemplate(s);
		if (poly != null || s.equals("none")) {
			if (s.equals("none")) {
				if (pc.getTempCharGfx() == 6034 || pc.getTempCharGfx() == 6035) {
				} else {
					pc.removeSkillEffect(SHAPE_CHANGE);
					pc.sendPackets(new S_CloseList(pc.getId()));
				}
			} else if (pc.getLevel() >= poly.getMinLevel() || pc.isGm() || Config.ALT_POLYEVENT) {
				if (pc.getTempCharGfx() == 6034 || pc.getTempCharGfx() == 6035) {
					pc.sendPackets(new S_ServerMessage(181));
					//
				} else {
					doPoly(pc, poly.getPolyId(), 7200, MORPH_BY_ITEMMAGIC);
					pc.sendPackets(new S_CloseList(pc.getId()));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(181));
			}
		}
	}

	public static void doPoly(L1Character cha, int polyId, int timeSecs,
			int cause) {
		if (cha == null || cha.isDead()) {
			return;
		}
		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			if (pc.getMapId() == 5124) {
				pc.sendPackets(new S_ServerMessage(1170));
				return;
			}
			if (pc.getTempCharGfx() == 6034 || pc.getTempCharGfx() == 6035) {
				pc.sendPackets(new S_ServerMessage(181)); //
				return;
			}
			if (!isMatchCause(polyId, cause)) {
				pc.sendPackets(new S_ServerMessage(181)); //
				return;
			}

			pc.killSkillEffectTimer(L1SkillId.SHAPE_CHANGE);
			pc.setSkillEffect(L1SkillId.SHAPE_CHANGE, timeSecs * 1000);
			if (pc.getTempCharGfx() != polyId) {
				L1ItemInstance weapon = pc.getWeapon();
				boolean weaponTakeoff = (weapon != null && !isEquipableWeapon(
						polyId, weapon.getItem().getType()));
				pc.setTempCharGfx(polyId);
				pc.sendPackets(new S_ChangeShape(pc.getId(), polyId,
						weaponTakeoff));
				if (!pc.isGmInvis() && !pc.isInvisble()) {
					pc.broadcastPacket(new S_ChangeShape(pc.getId(), polyId));
				}
				if (pc.isGmInvis()) {
				} else if (pc.isInvisble()) {
					pc.broadcastPacketForFindInvis(new S_ChangeShape(
							pc.getId(), polyId), true);
				} else {
					pc.broadcastPacket(new S_ChangeShape(pc.getId(), polyId));
				}
				pc.getInventory().takeoffEquip(polyId);
				weapon = pc.getWeapon();
				if (weapon != null) {
					S_CharVisualUpdate charVisual = new S_CharVisualUpdate(pc);
					pc.sendPackets(charVisual);
					pc.broadcastPacket(charVisual);
				}
			}
			pc.sendPackets(new S_SkillIconGFX(35, timeSecs));
		} else if (cha instanceof L1MonsterInstance) {
			L1MonsterInstance mob = (L1MonsterInstance) cha;
			mob.killSkillEffectTimer(SHAPE_CHANGE);
			mob.setSkillEffect(SHAPE_CHANGE, timeSecs * 1000);
			if (mob.getTempCharGfx() != polyId) {
				mob.setTempCharGfx(polyId);
				mob.broadcastPacket(new S_ChangeShape(mob.getId(), polyId));
			}
		}
	}

	public static void undoPoly(L1Character cha) {
		if (cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) cha;
			int classId = pc.getClassId();
			pc.setTempCharGfx(classId);
			pc.sendPackets(new S_ChangeShape(pc.getId(), classId));
			pc.broadcastPacket(new S_ChangeShape(pc.getId(), classId));
			L1ItemInstance weapon = pc.getWeapon();
			if (weapon != null) {
				S_CharVisualUpdate charVisual = new S_CharVisualUpdate(pc);
				pc.sendPackets(charVisual);
				pc.broadcastPacket(charVisual);
			}
		} else if (cha instanceof L1MonsterInstance) {
			L1MonsterInstance mob = (L1MonsterInstance) cha;
			mob.setTempCharGfx(0);
			mob.broadcastPacket(new S_ChangeShape(mob.getId(), mob.getGfxId()));
		}
	}

	public static boolean isEquipableWeapon(int polyId, int weaponType) {
		L1PolyMorph poly = PolyTable.getInstance().getTemplate(polyId);
		if (poly == null) {
			return true;
		}

		Integer flg = weaponFlgMap.get(weaponType);
		if (flg != null) {
			return 0 != (poly.getWeaponEquipFlg() & flg);
		}
		return true;
	}

	public static boolean isEquipableArmor(int polyId, int armorType) {
		L1PolyMorph poly = PolyTable.getInstance().getTemplate(polyId);
		if (poly == null) {
			return true;
		}

		Integer flg = armorFlgMap.get(armorType);
		if (flg != null) {
			return 0 != (poly.getArmorEquipFlg() & flg);
		}
		return true;
	}

	public static boolean isMatchCause(int polyId, int cause) {
		L1PolyMorph poly = PolyTable.getInstance().getTemplate(polyId);
		if (poly == null) {
			return true;
		}
		if (cause == MORPH_BY_LOGIN) {
			return true;
		}

		return 0 != (poly.getCauseFlg() & cause);
	}
}
