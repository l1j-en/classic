package l1j.server.server.model;

import java.util.ArrayList;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;

public abstract class L1ArmorSet {
	public abstract void giveEffect(L1PcInstance pc);

	public abstract void cancelEffect(L1PcInstance pc);

	public abstract boolean isValid(L1PcInstance pc);

	public abstract boolean isPartOfSet(int id);

	public static ArrayList<L1ArmorSet> getAllSet() {
		return _allSet;
	}

	private static ArrayList<L1ArmorSet> _allSet = new ArrayList<L1ArmorSet>();

	/*
	 * The initialization of the whole thing is something you feel unattractive
	 */
	static {
		L1ArmorSetImpl impl;

		// Metamorphosis and status bonuses
		// Daemon set
		impl = new L1ArmorSetImpl(new int[] { 20009, 20099, 20165, 20197 });
		impl.addEffect(new PolymorphEffect(3889));
		impl.addEffect(new AcHpMpBonusEffect(-2, 0, 0, 5, 0, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20010, 20100, 20166, 20198 });
		impl.addEffect(new PolymorphEffect(6137));
		impl.addEffect(new AcHpMpBonusEffect(-4, 0, 0, -7, 0, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20024, 20118, 20170, 20203 });
		impl.addEffect(new PolymorphEffect(3903));
		impl.addEffect(new AcHpMpBonusEffect(-3, 0, 0, 12, 0, 0));
		_allSet.add(impl);
		// Kurtz set
		impl = new L1ArmorSetImpl(new int[] { 20041, 20150, 20184, 20214 });
		impl.addEffect(new PolymorphEffect(3101));
		impl.addEffect(new AcHpMpBonusEffect(-4, 0, 0, -7, 0, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20042, 20151, 20185, 20215 });
		impl.addEffect(new PolymorphEffect(3902));
		impl.addEffect(new AcHpMpBonusEffect(-2, 0, 100, 0, 12, 0));
		_allSet.add(impl);

		// Only Metamorphosis
		// Pumpkin
		impl = new L1ArmorSetImpl(new int[] { 20047 });
		impl.addEffect(new PolymorphEffect(2501));
		_allSet.add(impl);
		// Vampire
		impl = new L1ArmorSetImpl(new int[] { 20079 });
		impl.addEffect(new PolymorphEffect(3952));
		_allSet.add(impl);
		// Death
		impl = new L1ArmorSetImpl(new int[] { 20342 });
		impl.addEffect(new PolymorphEffect(2388));
		_allSet.add(impl);
		// Rabbit
		impl = new L1ArmorSetImpl(new int[] { 20343 });
		impl.addEffect(new PolymorphEffect(4767));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20344 });
		impl.addEffect(new PolymorphEffect(4769));
		_allSet.add(impl);
		// Skeleton
		impl = new L1ArmorSetImpl(new int[] { 20278 });
		impl.addEffect(new PolymorphEffect(2374));
		_allSet.add(impl);
		// orc fighter
		impl = new L1ArmorSetImpl(new int[] { 20277 });
		impl.addEffect(new PolymorphEffect(3864));
		_allSet.add(impl);
		// ww
		impl = new L1ArmorSetImpl(new int[] { 20250 });
		impl.addEffect(new PolymorphEffect(3865));
		_allSet.add(impl);
		// High collie
		impl = new L1ArmorSetImpl(new int[] { 20345 });
		impl.addEffect(new PolymorphEffect(4928));
		_allSet.add(impl);
		// Raccoon high
		impl = new L1ArmorSetImpl(new int[] { 20346 });
		impl.addEffect(new PolymorphEffect(4929));
		_allSet.add(impl);
		// Hakama
		impl = new L1ArmorSetImpl(new int[] { 20347 });
		impl.addEffect(new PolymorphEffect(4227));
		_allSet.add(impl);
		// Holiday attire
		impl = new L1ArmorSetImpl(new int[] { 20348 });
		impl.addEffect(new PolymorphEffect(3750));
		_allSet.add(impl);
		// Collie
		impl = new L1ArmorSetImpl(new int[] { 20349 });
		impl.addEffect(new PolymorphEffect(938));
		_allSet.add(impl);
		// Snowman
		impl = new L1ArmorSetImpl(new int[] { 20350 });
		impl.addEffect(new PolymorphEffect(2064));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20351, 20352 });
		impl.addEffect(new PolymorphEffect(2064));
		_allSet.add(impl);
		// MANEKI cat
		impl = new L1ArmorSetImpl(new int[] { 20420 });
		impl.addEffect(new PolymorphEffect(5719));
		_allSet.add(impl);
		// Red Orc
		impl = new L1ArmorSetImpl(new int[] { 20382 });
		impl.addEffect(new PolymorphEffect(6010));
		_allSet.add(impl);
		// Drake captain
		impl = new L1ArmorSetImpl(new int[] { 20452 });
		impl.addEffect(new PolymorphEffect(6089));
		_allSet.add(impl);
		// Iris
		impl = new L1ArmorSetImpl(new int[] { 20453 });
		impl.addEffect(new PolymorphEffect(4001));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20454 });
		impl.addEffect(new PolymorphEffect(4000));
		_allSet.add(impl);
		// Queen Succubus
		impl = new L1ArmorSetImpl(new int[] { 20455 });
		impl.addEffect(new PolymorphEffect(4004));
		_allSet.add(impl);
		// Red Jersey
		impl = new L1ArmorSetImpl(new int[] { 20456 });
		impl.addEffect(new PolymorphEffect(5184));
		_allSet.add(impl);
		// Blue uniform
		impl = new L1ArmorSetImpl(new int[] { 20457 });
		impl.addEffect(new PolymorphEffect(5186));
		_allSet.add(impl);
		// The red orc (red orc mask)
		impl = new L1ArmorSetImpl(new int[] { 20458 });
		impl.addEffect(new PolymorphEffect(6010));
		_allSet.add(impl);
		// Helmet for Horse Riding
		impl = new L1ArmorSetImpl(new int[] { 20383 });
		impl.addEffect(new PolymorphEffect(6080));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20380 });
		impl.addEffect(new PolymorphEffect(5645));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20419 });
		impl.addEffect(new PolymorphEffect(5976));
		_allSet.add(impl); 

		// Only status bonus
		// Leather set
		impl = new L1ArmorSetImpl(new int[] { 20001, 20090, 20193, 20219 });
		impl.addEffect(new AcHpMpBonusEffect(-3, 0, 0, 0, 0, 0));
		_allSet.add(impl);
		// orc set
		impl = new L1ArmorSetImpl(new int[] { 20034, 20072, 20135, 20237 });
		impl.addEffect(new AcHpMpBonusEffect(-3, 0, 0, 0, 0, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20007, 20052, 20223 });
		impl.addEffect(new AcHpMpBonusEffect(-1, 5, 0, 0, 0, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20038, 20148, 20241, 20212 });
		impl.addEffect(new AcHpMpBonusEffect(-3, 0, 0, 0, 0, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20045, 20124, 20221 });
		impl.addEffect(new AcHpMpBonusEffect(-2, 10, 0, 0, 0, 0));
		_allSet.add(impl);
		// The members of the expedition set relic
		impl = new L1ArmorSetImpl(
				new int[] { 20389, 20393, 20401, 20409, 20406 });
		impl.addEffect(new AcHpMpBonusEffect(-5, 15, 10, 0, 0, 10));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20012, 20111 });
		impl.addEffect(new AcHpMpBonusEffect(0, 0, 50, 0, 0, 0));
		_allSet.add(impl);
		// iron set
		impl = new L1ArmorSetImpl(
				new int[] { 20003, 20091, 20163, 20194, 20220 });
		impl.addEffect(new AcHpMpBonusEffect(-7, 30, 0, 0, 0, 0)); // was just -3 ac
		impl.addEffect(new StatBonusEffect(1, 0, 0, 0, 0, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20044, 20155, 20188, 20217 });
		impl.addEffect(new AcHpMpBonusEffect(-1, 10, 0, 0, 0, 0));
		impl.addEffect(new StatBonusEffect(0, 0, 0, 0, 0, 1));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20031, 20069, 20083, 20131,
				20179, 20209, 20290, 20261 });
		impl.addEffect(new AcHpMpBonusEffect(-88, 100, 100, 15, 15, 0));
		impl.addEffect(new StatBonusEffect(1, 1, 1, 1, 1, 1));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(new int[] { 20057, 20109, 20178, 20200 });
		impl.addEffect(new AcHpMpBonusEffect(0, 30, 30, 10, 10, 0));
		impl.addEffect(new StatBonusEffect(0, 0, 0, 0, 3, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(
				new int[] { 20390, 20395, 20402, 20410, 20408 });
		impl.addEffect(new AcHpMpBonusEffect(-20, 100, 20, 10, 0, 0));
		_allSet.add(impl);
		// 
		impl = new L1ArmorSetImpl(
				new int[] { 21051, 21052, 21053, 21054, 21055, 21056 });
		impl.addEffect(new AcHpMpBonusEffect(-10, 100, 0, 0, 0, 0));
		_allSet.add(impl);		
		// Set hope
		impl = new L1ArmorSetImpl(new int[] { 20413, 20428 });
		impl.addEffect(new AcHpMpBonusEffect(0, 0, 5, 0, 0, 0));
		_allSet.add(impl);
		// Set luck 
		impl = new L1ArmorSetImpl(new int[] { 20414, 20430 });
		impl.addEffect(new AcHpMpBonusEffect(0, 0, 10, 0, 0, 0));
		_allSet.add(impl);
		// Set passion 
		impl = new L1ArmorSetImpl(new int[] { 20415, 20429 });
		impl.addEffect(new AcHpMpBonusEffect(0, 10, 0, 0, 0, 0));
		_allSet.add(impl);
		// Set the truth 
		impl = new L1ArmorSetImpl(new int[] { 20416, 20431 });
		impl.addEffect(new AcHpMpBonusEffect(0, 15, 0, 0, 0, 0));
		_allSet.add(impl);
		// Set miracle 
		impl = new L1ArmorSetImpl(new int[] { 20417, 20432 });
		impl.addEffect(new AcHpMpBonusEffect(0, 15, 10, 0, 0, 0));
		_allSet.add(impl);
		// Set courage kindness 
		impl = new L1ArmorSetImpl(new int[] { 20418, 20433 });
		impl.addEffect(new AcHpMpBonusEffect(0, 0, 0, 2, 2, 0));
		_allSet.add(impl);
		// Amulet cleansing of the Red Earring
		impl = new L1ArmorSetImpl(new int[] { 20423, 21019 });
		impl.addEffect(new StatBonusEffect(2, 0, -2, 0, 0, 0));
		_allSet.add(impl);
		// Amulet cleansing of the blue Earring
		impl = new L1ArmorSetImpl(new int[] { 20424, 21019 });
		impl.addEffect(new StatBonusEffect(0, 0, 0, -2, 0, 2));
		_allSet.add(impl);
		// Amulet of cleansing green earring
		impl = new L1ArmorSetImpl(new int[] { 20425, 21019 });
		impl.addEffect(new StatBonusEffect(0, 2, 0, 0, -2, 0));
		_allSet.add(impl);
		// red knight set
		impl = new L1ArmorSetImpl(new int[] { 20230, 20027 });
		impl.addEffect(new AcHpMpBonusEffect(-2, 10, 0, 0, 0, 10));
		_allSet.add(impl);
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

class PolymorphEffect implements L1ArmorSetEffect {
	private int _gfxId;

	public PolymorphEffect(int gfxId) {
		_gfxId = gfxId;
	}

	@Override
	public void giveEffect(L1PcInstance pc) {
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
		L1PolyMorph.doPoly(pc, _gfxId, 0);
	}

	@Override
	public void cancelEffect(L1PcInstance pc) {
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
					isRemainderOfCharge =true;
				}
			}
		}
		return isRemainderOfCharge;
	}

}
