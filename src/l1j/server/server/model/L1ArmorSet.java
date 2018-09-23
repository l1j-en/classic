package l1j.server.server.model;

import static l1j.server.server.model.skill.L1SkillId.AWAKEN_ANTHARAS;
import static l1j.server.server.model.skill.L1SkillId.AWAKEN_FAFURION;
import static l1j.server.server.model.skill.L1SkillId.AWAKEN_VALAKAS;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.ArmorSetTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1ArmorSets;

public abstract class L1ArmorSet {
	
	private static Logger _log = LoggerFactory.getLogger(L1ArmorSet.class);

	public abstract void giveEffect(L1PcInstance pc);

	public abstract void cancelEffect(L1PcInstance pc);

	public abstract boolean isValid(L1PcInstance pc);

	public abstract boolean isPartOfSet(int id);

	public abstract boolean isEquippedRingOfArmorSet(L1PcInstance pc);

	public static ArrayList<L1ArmorSet> getAllSet() {
		return _allSet;
	}

	private static ArrayList<L1ArmorSet> _allSet = new ArrayList<L1ArmorSet>();

	/*
	 * The initialization of the whole thing is something you feel unattractive
	 */
	static {
		L1ArmorSetImpl impl;

		for (L1ArmorSets armorSets : ArmorSetTable.getInstance().getAllList()) {
			try {

				impl = new L1ArmorSetImpl(getArray(armorSets.getSets(), ","));
				if (armorSets.getPolyId() != -1) {
					impl.addEffect(new PolymorphEffect(armorSets.getPolyId()));
				}
				impl.addEffect(new AcHpMpBonusEffect(armorSets.getAc(),
						armorSets.getHp(), armorSets.getMp(), armorSets
								.getHpr(), armorSets.getMpr(), armorSets
								.getMr()));
				impl.addEffect(new StatBonusEffect(armorSets.getStr(),
						armorSets.getDex(), armorSets.getCon(), armorSets
								.getWis(), armorSets.getCha(), armorSets
								.getIntl()));
				impl.addEffect(new DefenseBonusEffect(armorSets
						.getDefenseWater(), armorSets.getDefenseWind(),
						armorSets.getDefenseFire(), armorSets.getDefenseWind()));
				_allSet.add(impl);
			} catch (Exception e) {
				_log.error("",e);
			}
		}
	}

	private static int[] getArray(String s, String sToken) {
		StringTokenizer st = new StringTokenizer(s, sToken);
		int size = st.countTokens();
		String temp = null;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			temp = st.nextToken();
			array[i] = Integer.parseInt(temp);
		}
		return array;
	}
}

interface L1ArmorSetEffect {
	public void giveEffect(L1PcInstance pc);

	public void cancelEffect(L1PcInstance pc);
}

class L1ArmorSetImpl extends L1ArmorSet {
	private final int _ids[];
	private final ArrayList<L1ArmorSetEffect> _effects;

	protected L1ArmorSetImpl(int ids[]) {
		_ids = ids;
		_effects = new ArrayList<L1ArmorSetEffect>();
	}

	public void addEffect(L1ArmorSetEffect effect) {
		_effects.add(effect);
	}

	public void removeEffect(L1ArmorSetEffect effect) {
		_effects.remove(effect);
	}

	@Override
	public void cancelEffect(L1PcInstance pc) {
		for (L1ArmorSetEffect effect : _effects) {
			effect.cancelEffect(pc);
		}
	}

	@Override
	public void giveEffect(L1PcInstance pc) {
		for (L1ArmorSetEffect effect : _effects) {
			effect.giveEffect(pc);
		}
	}

	@Override
	public final boolean isValid(L1PcInstance pc) {
		return pc.getInventory().checkEquipped(_ids);
	}

	@Override
	public boolean isPartOfSet(int id) {
		for (int i : _ids) {
			if (id == i) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEquippedRingOfArmorSet(L1PcInstance pc) {
		L1PcInventory pcInventory = pc.getInventory();
		L1ItemInstance armor = null;
		boolean isSetContainRing = false;

		for (int id : _ids) {
			armor = pcInventory.findItemId(id);
			if (armor.getItem().getType2() == 2
					&& armor.getItem().getType() == 9) { // ring
				isSetContainRing = true;
				break;
			}
		}

		if (armor != null && isSetContainRing) {
			int itemId = armor.getItem().getItemId();
			if (pcInventory.getTypeEquipped(2, 9) == 2) {
				L1ItemInstance ring[] = new L1ItemInstance[2];
				ring = pcInventory.getRingEquipped();
				if (ring[0].getItem().getItemId() == itemId
						&& ring[1].getItem().getItemId() == itemId) {
					return true;
				}
			}
		}
		return false;
	}

}

class AcHpMpBonusEffect implements L1ArmorSetEffect {
	private final int _ac;
	private final int _addHp;
	private final int _addMp;
	private final int _regenHp;
	private final int _regenMp;
	private final int _addMr;

	public AcHpMpBonusEffect(int ac, int addHp, int addMp, int regenHp,
			int regenMp, int addMr) {
		_ac = ac;
		_addHp = addHp;
		_addMp = addMp;
		_regenHp = regenHp;
		_regenMp = regenMp;
		_addMr = addMr;
	}

	@Override
	public void giveEffect(L1PcInstance pc) {
		pc.addAc(_ac);
		pc.addMaxHp(_addHp);
		pc.addMaxMp(_addMp);
		pc.addHpr(_regenHp);
		pc.addMpr(_regenMp);
		pc.addMr(_addMr);
	}

	@Override
	public void cancelEffect(L1PcInstance pc) {
		pc.addAc(-_ac);
		pc.addMaxHp(-_addHp);
		pc.addMaxMp(-_addMp);
		pc.addHpr(-_regenHp);
		pc.addMpr(-_regenMp);
		pc.addMr(-_addMr);
	}
}

class StatBonusEffect implements L1ArmorSetEffect {
	private final int _str;
	private final int _dex;
	private final int _con;
	private final int _wis;
	private final int _cha;
	private final int _intl;

	public StatBonusEffect(int str, int dex, int con, int wis, int cha, int intl) {
		_str = str;
		_dex = dex;
		_con = con;
		_wis = wis;
		_cha = cha;
		_intl = intl;
	}

	@Override
	public void giveEffect(L1PcInstance pc) {
		pc.addStr((byte) _str);
		pc.addDex((byte) _dex);
		pc.addCon((byte) _con);
		pc.addWis((byte) _wis);
		pc.addCha((byte) _cha);
		pc.addInt((byte) _intl);
	}

	@Override
	public void cancelEffect(L1PcInstance pc) {
		pc.addStr((byte) -_str);
		pc.addDex((byte) -_dex);
		pc.addCon((byte) -_con);
		pc.addWis((byte) -_wis);
		pc.addCha((byte) -_cha);
		pc.addInt((byte) -_intl);
	}
}

class DefenseBonusEffect implements L1ArmorSetEffect {
	private final int _defenseWater;
	private final int _defenseWind;
	private final int _defenseFire;
	private final int _defenseEarth;

	public DefenseBonusEffect(int defenseWater, int defenseWind,
			int defenseFire, int defenseEarth) {
		_defenseWater = defenseWater;
		_defenseWind = defenseWind;
		_defenseFire = defenseFire;
		_defenseEarth = defenseEarth;
	}

	// @Override
	public void giveEffect(L1PcInstance pc) {
		pc.addWater(_defenseWater);
		pc.addWind(_defenseWind);
		pc.addFire(_defenseFire);
		pc.addEarth(_defenseEarth);
	}

	// @Override
	public void cancelEffect(L1PcInstance pc) {
		pc.addWater(-_defenseWater);
		pc.addWind(-_defenseWind);
		pc.addFire(-_defenseFire);
		pc.addEarth(-_defenseEarth);
	}
}

class PolymorphEffect implements L1ArmorSetEffect {
	private int _gfxId;

	public PolymorphEffect(int gfxId) {
		_gfxId = gfxId;
	}

	@Override
	public void giveEffect(L1PcInstance pc) {
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS || awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384));
			return;
		}
		if (_gfxId == 6080 || _gfxId == 6094) {
			if (pc.get_sex() == 0) {
				_gfxId = 6094;
			} else {
				_gfxId = 6080;
			}
			if (!isRemainderOfCharge(pc)) {
				return;
			}
		}
		L1PolyMorph.doPoly(pc, _gfxId, 0, L1PolyMorph.MORPH_BY_ITEMMAGIC);
	}

	@Override
	public void cancelEffect(L1PcInstance pc) {
		int awakeSkillId = pc.getAwakeSkillId();
		if (awakeSkillId == AWAKEN_ANTHARAS || awakeSkillId == AWAKEN_FAFURION
				|| awakeSkillId == AWAKEN_VALAKAS) {
			pc.sendPackets(new S_ServerMessage(1384));
			return;
		}
		if (_gfxId == 6080) {
			if (pc.get_sex() == 0) {
				_gfxId = 6094;
			}
		}
		if (pc.getTempCharGfx() != _gfxId) {
			return;
		}
		L1PolyMorph.undoPoly(pc);
	}

	private boolean isRemainderOfCharge(L1PcInstance pc) {
		boolean isRemainderOfCharge = false;
		if (pc.getInventory().checkItem(20383, 1)) {
			L1ItemInstance item = pc.getInventory().findItemId(20383);
			if (item != null) {
				if (item.getChargeCount() != 0) {
					isRemainderOfCharge = true;
				}
			}
		}
		return isRemainderOfCharge;
	}

}
