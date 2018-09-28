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

package l1j.server.server.templates;

import l1j.server.server.model.L1Object;

public class L1Npc extends L1Object implements Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public L1Npc clone() {
		try {
			return (L1Npc) (super.clone());
		} catch (CloneNotSupportedException e) {
			throw (new InternalError(e.getMessage()));
		}
	}

	public L1Npc() {
	}

	private int _npcid;

	public int get_npcId() {
		return _npcid;
	}

	public void set_npcId(int i) {
		_npcid = i;
	}

	private String _name;

	public String get_name() {
		return _name;
	}

	public void set_name(String s) {
		_name = s;
	}

	private String _impl;

	public String getImpl() {
		return _impl;
	}

	public void setImpl(String s) {
		_impl = s;
	}

	private int _level;

	public int get_level() {
		return _level;
	}

	public void set_level(int i) {
		_level = i;
	}

	private int _hp;

	public int get_hp() {
		return _hp;
	}

	public void set_hp(int i) {
		_hp = i;
	}

	private int _mp;

	public int get_mp() {
		return _mp;
	}

	public void set_mp(int i) {
		_mp = i;
	}

	private int _ac;

	public int get_ac() {
		return _ac;
	}

	public void set_ac(int i) {
		_ac = i;
	}

	private byte _str;

	public byte get_str() {
		return _str;
	}

	public void set_str(byte i) {
		_str = i;
	}

	private byte _con;

	public byte get_con() {
		return _con;
	}

	public void set_con(byte i) {
		_con = i;
	}

	private byte _dex;

	public byte get_dex() {
		return _dex;
	}

	public void set_dex(byte i) {
		_dex = i;
	}

	private byte _wis;

	public byte get_wis() {
		return _wis;
	}

	public void set_wis(byte i) {
		_wis = i;
	}

	private byte _int;

	public byte get_int() {
		return _int;
	}

	public void set_int(byte i) {
		_int = i;
	}

	private int _mr;

	public int get_mr() {
		return _mr;
	}

	public void set_mr(int i) {
		_mr = i;
	}

	private int _exp;

	public int get_exp() {
		return _exp;
	}

	public void set_exp(int i) {
		_exp = i;
	}

	private int _lawful;

	public int get_lawful() {
		return _lawful;
	}

	public void set_lawful(int i) {
		_lawful = i;
	}

	private String _size;

	public String get_size() {
		return _size;
	}

	public void set_size(String s) {
		_size = s;
	}

	private int _weakAttr;

	public int get_weakAttr() {
		return _weakAttr;
	}

	public void set_weakAttr(int i) {
		_weakAttr = i;
	}

	private int _ranged;

	public int get_ranged() {
		return _ranged;
	}

	public void set_ranged(int i) {
		_ranged = i;
	}

	private boolean _agrososc;

	public boolean is_agrososc() {
		return _agrososc;
	}

	public void set_agrososc(boolean flag) {
		_agrososc = flag;
	}

	private boolean _agrocoi;

	public boolean is_agrocoi() {
		return _agrocoi;
	}

	public void set_agrocoi(boolean flag) {
		_agrocoi = flag;
	}

	private boolean _tameable;

	public boolean isTamable() {
		return _tameable;
	}

	public void setTamable(boolean flag) {
		_tameable = flag;
	}

	private int _passispeed;

	public int get_passispeed() {
		return _passispeed;
	}

	public void set_passispeed(int i) {
		_passispeed = i;
	}

	private int _atkspeed;

	public int get_atkspeed() {
		return _atkspeed;
	}

	public void set_atkspeed(int i) {
		_atkspeed = i;
	}

	private boolean _agro;

	public boolean is_agro() {
		return _agro;
	}

	public void set_agro(boolean flag) {
		_agro = flag;
	}

	private boolean _agrochao;

	public boolean is_agrochao() {
		return _agrochao;
	}

	public void set_agrochao(boolean flag) {
		_agrochao = flag;
	}

	private int _gfxid;

	public int get_gfxid() {
		return _gfxid;
	}

	public void set_gfxid(int i) {
		_gfxid = i;
	}

	private String _nameid;

	public String get_nameid() {
		return _nameid;
	}

	public void set_nameid(String s) {
		_nameid = s;
	}

	private int _undead;

	public int get_undead() {
		return _undead;
	}

	public void set_undead(int i) {
		_undead = i;
	}

	private int _poisonatk;

	public int get_poisonatk() {
		return _poisonatk;
	}

	public void set_poisonatk(int i) {
		_poisonatk = i;
	}

	private int _paralysisatk;

	public int get_paralysisatk() {
		return _paralysisatk;
	}

	public void set_paralysisatk(int i) {
		_paralysisatk = i;
	}

	private int _family;

	public int get_family() {
		return _family;
	}

	public void set_family(int i) {
		_family = i;
	}

	private int _agrofamily;

	public int get_agrofamily() {
		return _agrofamily;
	}

	public void set_agrofamily(int i) {
		_agrofamily = i;
	}

	private int _agrogfxid1;

	public int is_agrogfxid1() {
		return _agrogfxid1;
	}

	public void set_agrogfxid1(int i) {
		_agrogfxid1 = i;
	}

	private int _agrogfxid2;

	public int is_agrogfxid2() {
		return _agrogfxid2;
	}

	public void set_agrogfxid2(int i) {
		_agrogfxid2 = i;
	}

	private boolean _picupitem;

	public boolean is_picupitem() {
		return _picupitem;
	}

	public void set_picupitem(boolean flag) {
		_picupitem = flag;
	}

	private int _digestitem;

	public int get_digestitem() {
		return _digestitem;
	}

	public void set_digestitem(int i) {
		_digestitem = i;
	}

	private boolean _bravespeed;

	public boolean is_bravespeed() {
		return _bravespeed;
	}

	public void set_bravespeed(boolean flag) {
		_bravespeed = flag;
	}

	private int _hprinterval;

	public int get_hprinterval() {
		return _hprinterval;
	}

	public void set_hprinterval(int i) {
		_hprinterval = i;
	}

	private int _hpr;

	public int get_hpr() {
		return _hpr;
	}

	public void set_hpr(int i) {
		_hpr = i;
	}

	private int _mprinterval;

	public int get_mprinterval() {
		return _mprinterval;
	}

	public void set_mprinterval(int i) {
		_mprinterval = i;
	}

	private int _mpr;

	public int get_mpr() {
		return _mpr;
	}

	public void set_mpr(int i) {
		_mpr = i;
	}

	private boolean _teleport;

	public boolean is_teleport() {
		return _teleport;
	}

	public void set_teleport(boolean flag) {
		_teleport = flag;
	}

	private int _randomlevel;

	public int get_randomlevel() {
		return _randomlevel;
	}

	public void set_randomlevel(int i) {
		_randomlevel = i;
	}

	private int _randomhp;

	public int get_randomhp() {
		return _randomhp;
	}

	public void set_randomhp(int i) {
		_randomhp = i;
	}

	private int _randommp;

	public int get_randommp() {
		return _randommp;
	}

	public void set_randommp(int i) {
		_randommp = i;
	}

	private int _randomac;

	public int get_randomac() {
		return _randomac;
	}

	public void set_randomac(int i) {
		_randomac = i;
	}

	private int _randomexp;

	public int get_randomexp() {
		return _randomexp;
	}

	public void set_randomexp(int i) {
		_randomexp = i;
	}

	private int _randomlawful;

	public int get_randomlawful() {
		return _randomlawful;
	}

	public void set_randomlawful(int i) {
		_randomlawful = i;
	}

	private int _damagereduction;

	public int get_damagereduction() {
		return _damagereduction;
	}

	public void set_damagereduction(int i) {
		_damagereduction = i;
	}

	private boolean _hard;

	public boolean is_hard() {
		return _hard;
	}

	public void set_hard(boolean flag) {
		_hard = flag;
	}

	private boolean _doppel;

	public boolean is_doppel() {
		return _doppel;
	}

	public void set_doppel(boolean flag) {
		_doppel = flag;
	}

	private boolean _tu;

	public void set_IsTU(boolean i) {
		_tu = i;
	}

	public boolean get_IsTU() {
		return _tu;
	}

	private boolean _erase;

	public void set_IsErase(boolean i) {
		_erase = i;
	}

	public boolean get_IsErase() {
		return _erase;
	}

	private int bowActId = 0;

	public int getBowActId() {
		return bowActId;
	}

	public void setBowActId(int i) {
		bowActId = i;
	}

	private int _karma;

	public int getKarma() {
		return _karma;
	}

	public void setKarma(int i) {
		_karma = i;
	}

	private int _transformId;

	public int getTransformId() {
		return _transformId;
	}

	public void setTransformId(int transformId) {
		_transformId = transformId;
	}

	private int _transformGfxId;

	public int getTransformGfxId() {
		return _transformGfxId;
	}

	public void setTransformGfxId(int i) {
		_transformGfxId = i;
	}

	private int _altAtkSpeed;

	public int getAltAtkSpeed() {
		return _altAtkSpeed;
	}

	public void setAltAtkSpeed(int altAtkSpeed) {
		_altAtkSpeed = altAtkSpeed;
	}

	private int _atkMagicSpeed;

	public int getAtkMagicSpeed() {
		return _atkMagicSpeed;
	}

	public void setAtkMagicSpeed(int atkMagicSpeed) {
		_atkMagicSpeed = atkMagicSpeed;
	}

	private int _subMagicSpeed;

	public int getSubMagicSpeed() {
		return _subMagicSpeed;
	}

	public void setSubMagicSpeed(int subMagicSpeed) {
		_subMagicSpeed = subMagicSpeed;
	}

	private int _lightSize;

	public int getLightSize() {
		return _lightSize;
	}

	public void setLightSize(int lightSize) {
		_lightSize = lightSize;
	}

	private boolean _amountFixed;

	public boolean isAmountFixed() {
		return _amountFixed;
	}

	public void setAmountFixed(boolean fixed) {
		_amountFixed = fixed;
	}

	private boolean _changeHead;

	public boolean getChangeHead() {
		return _changeHead;
	}

	public void setChangeHead(boolean changeHead) {
		_changeHead = changeHead;
	}

	private boolean _isCantResurrect;

	public boolean isCantResurrect() {
		return _isCantResurrect;
	}

	public void setCantResurrect(boolean isCantResurrect) {
		_isCantResurrect = isCantResurrect;
	}
}
