package l1j.server.server.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1FollowerInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.map.L1Map;
import l1j.server.server.model.poison.L1Poison;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.model.skill.L1SkillTimer;
import l1j.server.server.model.skill.L1SkillTimerCreator;
import l1j.server.server.serverpackets.S_Light;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_Poison;
import l1j.server.server.serverpackets.ServerBasePacket;
import l1j.server.server.types.Point;
import l1j.server.server.utils.IntRange;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1Character extends L1Object {

	private static final long serialVersionUID = 1L;

	private static final Logger _log = Logger.getLogger(L1Character.class
			.getName());

	private L1Poison _poison = null;
	private boolean _paralyzed;
	private boolean _sleeped;

	private final Map<Integer, L1NpcInstance> _petlist = 
		new HashMap<Integer, L1NpcInstance>();
	private final Map<Integer, L1DollInstance> _dolllist = 
		new HashMap<Integer, L1DollInstance>();
	private final Map<Integer, L1SkillTimer> _skillEffect = 
		new HashMap<Integer, L1SkillTimer>();
	private final Map<Integer, L1ItemDelay.ItemDelayTimer> _itemdelay = 
		new HashMap<Integer, L1ItemDelay.ItemDelayTimer>();
	private final Map<Integer, L1FollowerInstance> _followerlist = 
		new HashMap<Integer, L1FollowerInstance>();

	public L1Character() {
		_level = 1;
	}

	public void resurrect(int hp) {
		if (!isDead()) {
			return;
		}
		if (hp <= 0) {
			hp = 1;
		}
		setCurrentHp(hp);
		setDead(false);
		setStatus(0);
		L1PolyMorph.undoPoly(this);
		for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(this)) {
			pc.sendPackets(new S_RemoveObject(this));
			pc.removeKnownObject(this);
			pc.updateObject();
		}
	}

	private int _currentHp;

	public int getCurrentHp() {
		return _currentHp;
	}

	public void setCurrentHp(int i) {
		_currentHp = i;
		if (_currentHp >= getMaxHp()) {
			_currentHp = getMaxHp();
		}
	}

	public void setCurrentHpDirect(int i) {
		_currentHp = i;
	}

	private int _currentMp;

	public int getCurrentMp() {
		return _currentMp;
	}

	public void setCurrentMp(int i) {
		_currentMp = i;
		if (_currentMp >= getMaxMp()) {
			_currentMp = getMaxMp();
		}
	}

	public void setCurrentMpDirect(int i) {
		_currentMp = i;
	}

	public boolean isSleeped() { return _sleeped; }
	public void setSleeped(boolean sleeped) { _sleeped = sleeped; }

	public boolean isParalyzed() { return _paralyzed; }
	public void setParalyzed(boolean paralyzed) { _paralyzed = paralyzed; }

	L1Paralysis _paralysis;
	public L1Paralysis getParalysis() { return _paralysis; }
	public void setParalaysis(L1Paralysis p) { _paralysis = p; }

	public void cureParalaysis() {
		if (_paralysis != null) {
			_paralysis.cure();
		}
	}

	public void broadcastPacket(ServerBasePacket packet) {
		for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(this)) {
			pc.sendPackets(packet);
		}
	}

	public void broadcastPacketExceptTargetSight(ServerBasePacket packet,
			L1Character target) {
		for (L1PcInstance pc : L1World.getInstance()
				.getVisiblePlayerExceptTargetSight(this, target)) {
			pc.sendPackets(packet);
				}
	}

	public void broadcastPacketForFindInvis(ServerBasePacket packet,
			boolean isFindInvis) {
		for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(this)) {
			if (isFindInvis) {
				if(pc.hasSkillEffect(GMSTATUS_FINDINVIS))
					pc.sendPackets(packet);
			} else if (!pc.hasSkillEffect(GMSTATUS_FINDINVIS)) {
				pc.sendPackets(packet);
			}
		}
	}

	public void wideBroadcastPacket(ServerBasePacket packet) {
		for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(this,
					50)) {
			pc.sendPackets(packet);
		}
	}

	public int[] getFrontLoc() {
		int[] loc = new int[2];
		int x = getX();
		int y = getY();
		int heading = getHeading();
		if (heading == 0) {
			y--;
		} else if (heading == 1) {
			x++;
			y--;
		} else if (heading == 2) {
			x++;
		} else if (heading == 3) {
			x++;
			y++;
		} else if (heading == 4) {
			y++;
		} else if (heading == 5) {
			x--;
			y++;
		} else if (heading == 6) {
			x--;
		} else if (heading == 7) {
			x--;
			y--;
		}
		loc[0] = x;
		loc[1] = y;
		return loc;
	}

	public int targetDirection(int tx, int ty) {
		float dis_x = Math.abs(getX() - tx); 
		float dis_y = Math.abs(getY() - ty); 
		float dis = Math.max(dis_x, dis_y);
		if (dis == 0) {
			return getHeading(); 
		}
		int avg_x = (int) Math.floor((dis_x / dis) + 0.59f); 
		int avg_y = (int) Math.floor((dis_y / dis) + 0.59f); 

		int dir_x = 0;
		int dir_y = 0;
		if (getX() < tx) {
			dir_x = 1;
		}
		if (getX() > tx) {
			dir_x = -1;
		}
		if (getY() < ty) {
			dir_y = 1;
		}
		if (getY() > ty) {
			dir_y = -1;
		}

		if (avg_x == 0) {
			dir_x = 0;
		}
		if (avg_y == 0) {
			dir_y = 0;
		}

		if (dir_x == 1 && dir_y == -1) {
			return 1; 
		}
		if (dir_x == 1 && dir_y == 0) {
			return 2;
		}
		if (dir_x == 1 && dir_y == 1) {
			return 3; 
		}
		if (dir_x == 0 && dir_y == 1) {
			return 4; 
		}
		if (dir_x == -1 && dir_y == 1) {
			return 5; 
		}
		if (dir_x == -1 && dir_y == 0) {
			return 6;
		}
		if (dir_x == -1 && dir_y == -1) {
			return 7; 
		}
		if (dir_x == 0 && dir_y == -1) {
			return 0; 
		}
		return getHeading(); 
	}

	public boolean glanceCheck(int tx, int ty) {
		L1Map map = getMap();
		int chx = getX();
		int chy = getY();
		int arw = 0;
		for (int i = 0; i < 15; i++) {
			if ((chx == tx && chy == ty) || (chx + 1 == tx && chy - 1 == ty)
					|| (chx + 1 == tx && chy == ty)
					|| (chx + 1 == tx && chy + 1 == ty)
					|| (chx == tx && chy + 1 == ty)
					|| (chx - 1 == tx && chy + 1 == ty)
					|| (chx - 1 == tx && chy == ty)
					|| (chx - 1 == tx && chy - 1 == ty)
					|| (chx == tx && chy - 1 == ty)) {
				break;

			} else if (chx < tx && chy == ty) {
				// if (!map.isArrowPassable(chx, chy, 2)) {
				if (!map.isArrowPassable(chx, chy, targetDirection(tx, ty))) {
					return false;
				}
				chx++;
			} else if (chx == tx && chy < ty) {
				// if (!map.isArrowPassable(chx, chy, 4)) {
				if (!map.isArrowPassable(chx, chy, targetDirection(tx, ty))) {
					return false;
				}
				chy++;
			} else if (chx > tx && chy == ty) {
				// if (!map.isArrowPassable(chx, chy, 6)) {
				if (!map.isArrowPassable(chx, chy, targetDirection(tx, ty))) {
					return false;
				}
				chx--;
			} else if (chx == tx && chy > ty) {
				// if (!map.isArrowPassable(chx, chy, 0)) {
				if (!map.isArrowPassable(chx, chy, targetDirection(tx, ty))) {
					return false;
				}
				chy--;
			} else if (chx < tx && chy > ty) {
				// if (!map.isArrowPassable(chx, chy, 1)) {
				if (!map.isArrowPassable(chx, chy, targetDirection(tx, ty))) {
					return false;
				}
				chx++;
				chy--;
			} else if (chx < tx && chy < ty) {
				// if (!map.isArrowPassable(chx, chy, 3)) {
				if (!map.isArrowPassable(chx, chy, targetDirection(tx, ty))) {
					return false;
				}
				chx++;
				chy++;
			} else if (chx > tx && chy < ty) {
				// if (!map.isArrowPassable(chx, chy, 5)) {
				if (!map.isArrowPassable(chx, chy, targetDirection(tx, ty))) {
					return false;
				}
				chx--;
				chy++;
			} else if (chx > tx && chy > ty) {
				// if (!map.isArrowPassable(chx, chy, 7)) {
				if (!map.isArrowPassable(chx, chy, targetDirection(tx, ty))) {
					return false;
				}
				chx--;
				chy--;
				}
		}
		
		return arw == 0;
	}

	public boolean isAttackPosition(int x, int y, int range) {
		if (range >= 7) {
			if (getLocation().getTileDistance(new Point(x, y)) > range) {
				return false;
			}
		} else if (getLocation().getTileLineDistance(new Point(x, y)) > range) {
			return false;
		}
		return glanceCheck(x, y);
	}

	public L1Inventory getInventory() {
		return null;
	}

	private void addSkillEffect(int skillId, int timeMillis) {
		L1SkillTimer timer = null;
		if (0 < timeMillis) {
			timer = L1SkillTimerCreator.create(this, skillId, timeMillis);
			timer.begin();
		}
		_skillEffect.put(skillId, timer);
	}

	public void setSkillEffect(int skillId, int timeMillis) {
		if (hasSkillEffect(skillId)) {
			int remainingTimeMills = getSkillEffectTimeSec(skillId) * 1000;

			if (remainingTimeMills >= 0
					&& (remainingTimeMills < timeMillis || timeMillis == 0)) {
				killSkillEffectTimer(skillId);
				addSkillEffect(skillId, timeMillis);
					}
		} else {
			addSkillEffect(skillId, timeMillis);
		}
	}

	public void removeSkillEffect(int skillId) {
		L1SkillTimer timer = _skillEffect.remove(skillId);
		if (timer != null) {
			timer.end();
		}
	}

	/**
	 * @return a copy of the skill effects active on the character.
	 */
	public Map<Integer, L1SkillTimer> getBuffs() {
		return new HashMap<Integer, L1SkillTimer>(_skillEffect);
	}

	public void killSkillEffectTimer(int skillId) {
		L1SkillTimer timer = _skillEffect.remove(skillId);
		if (timer != null) {
			timer.kill();
		}
	}

	public void clearSkillEffectTimer() {
		for (L1SkillTimer timer : _skillEffect.values()) {
			if (timer != null) {
				timer.kill();
			}
		}
		_skillEffect.clear();
	}

	public boolean hasSkillEffect(int skillId) {
		return _skillEffect.containsKey(skillId);
	}

	public int getSkillEffectTimeSec(int skillId) {
		L1SkillTimer timer = _skillEffect.get(skillId);
		if (timer == null) {
			return -1;
		}
		return timer.getRemainingTime();
	}

	private boolean _isSkillDelay = false;
	public void setSkillDelay(boolean flag) { _isSkillDelay = flag; }
	public boolean isSkillDelay() { return _isSkillDelay; }

	public void addItemDelay(int delayId, L1ItemDelay.ItemDelayTimer timer) {
		_itemdelay.put(delayId, timer);
	}

	public void removeItemDelay(int delayId) {
		_itemdelay.remove(delayId);
	}

	public boolean hasItemDelay(int delayId) {
		return _itemdelay.containsKey(delayId);
	}

	public L1ItemDelay.ItemDelayTimer getItemDelayTimer(int delayId) {
		return _itemdelay.get(delayId);
	}

	public void addPet(L1NpcInstance npc) {
		_petlist.put(npc.getId(), npc);
	}

	public void removePet(L1NpcInstance npc) {
		_petlist.remove(npc.getId());
	}

	public Map<Integer, L1NpcInstance> getPetList() {
		return _petlist;
	}

	public void addDoll(L1DollInstance doll) {
		_dolllist.put(doll.getId(), doll);
	}

	public void removeDoll(L1DollInstance doll) {
		_dolllist.remove(doll.getId());
	}

	public Map<Integer, L1DollInstance> getDollList() {
		return _dolllist;
	}

	public void addFollower(L1FollowerInstance follower) {
		_followerlist.put(follower.getId(), follower);
	}

	public void removeFollower(L1FollowerInstance follower) {
		_followerlist.remove(follower.getId());
	}

	public Map<Integer, L1FollowerInstance> getFollowerList() {
		return _followerlist;
	}

	public void setPoison(L1Poison poison) {
		_poison = poison;
	}

	public void curePoison() {
		if (_poison == null) {
			return;
		}
		_poison.cure();
	}

	public L1Poison getPoison() {
		return _poison;
	}

	public void setPoisonEffect(int effectId) {
		broadcastPacket(new S_Poison(getId(), effectId));
	}

	public ZoneType getZoneType() {
		if (getMap().isSafetyZone(getLocation())) {
			return ZoneType.Safety;
		} else if (getMap().isCombatZone(getLocation())) {
			return ZoneType.Combat;
		} else { 
			return ZoneType.Normal;
		}
	}

	private int _exp;

	public int getExp() {
		return _exp;
	}

	public void setExp(int exp) {
		if(!(isDead() && exp > 0)){ //TODO Fix for exp while dead in party
			_exp = exp;
		}
	}

	private final List<L1Object> _knownObjects = 
		new CopyOnWriteArrayList<L1Object>();
	private final List<L1PcInstance> _knownPlayer =
		new CopyOnWriteArrayList<L1PcInstance>();

	public boolean knownsObject(L1Object obj) {
		return _knownObjects.contains(obj);
	}

	public List<L1Object> getKnownObjects() {
		return _knownObjects;
	}

	public List<L1PcInstance> getKnownPlayers() {
		return _knownPlayer;
	}

	public void addKnownObject(L1Object obj) {
		if (!_knownObjects.contains(obj)) {
			_knownObjects.add(obj);
			if (obj instanceof L1PcInstance) {
				_knownPlayer.add((L1PcInstance) obj);
			}
		}
	}

	public void removeKnownObject(L1Object obj) {
		_knownObjects.remove(obj);
		if (obj instanceof L1PcInstance) {
			_knownPlayer.remove(obj);
		}
	}

	public void removeAllKnownObjects() {
		_knownObjects.clear();
		_knownPlayer.clear();
	}

	private String _name; 
	public String getName() { return _name; }
	public void setName(String s) { _name = s; }

	private int _level; 
	public synchronized int getLevel() { return _level; }
	public synchronized void setLevel(long level) { _level = (int) level; }

	private short _maxHp = 0; 
	private int _trueMaxHp = 0;

	public short getMaxHp() {
		return _maxHp;
	}

	public void setMaxHp(int hp) {
		_trueMaxHp = hp;
		_maxHp = (short) IntRange.ensure(_trueMaxHp, 1, 32767);
		_currentHp = Math.min(_currentHp, _maxHp);
	}

	public void addMaxHp(int i) {
		setMaxHp(_trueMaxHp + i);
	}

	private short _maxMp = 0;
	private int _trueMaxMp = 0; 

	public short getMaxMp() {
		return _maxMp;
	}

	public void setMaxMp(int mp) {
		_trueMaxMp = mp;
		_maxMp = (short) IntRange.ensure(_trueMaxMp, 0, 32767);
		_currentMp = Math.min(_currentMp, _maxMp);
	}

	public void addMaxMp(int i) {
		setMaxMp(_trueMaxMp + i);
	}

	private int _ac = 0;
	private int _trueAc = 0;

	public int getAc() {
		return _ac;
	}

	public void setAc(int i) {
		_trueAc = i;
		_ac = IntRange.ensure(i, -128, 127);
	}

	public void addAc(int i) {
		setAc(_trueAc + i);
	}

	private byte _str = 0; 
	private short _trueStr = 0; 

	public byte getStr() {
		return _str;
	}

	public void setStr(int i) {
		_trueStr = (short) i;
		_str = (byte) IntRange.ensure(i, 1, 127);
	}

	public void addStr(int i) {
		setStr(_trueStr + i);
	}

	private byte _con = 0; 
	private short _trueCon = 0;

	public byte getCon() {
		return _con;
	}

	public void setCon(int i) {
		_trueCon = (short) i;
		_con = (byte) IntRange.ensure(i, 1, 127);
	}

	public void addCon(int i) {
		setCon(_trueCon + i);
	}

	private byte _dex = 0; 
	private short _trueDex = 0;

	public byte getDex() {
		return _dex;
	}

	public void setDex(int i) {
		_trueDex = (short) i;
		_dex = (byte) IntRange.ensure(i, 1, 127);
	}

	public void addDex(int i) {
		setDex(_trueDex + i);
	}

	private byte _cha = 0; 
	private short _trueCha = 0; 

	public byte getCha() {
		return _cha;
	}

	public void setCha(int i) {
		_trueCha = (short) i;
		_cha = (byte) IntRange.ensure(i, 1, 127);
	}

	public void addCha(int i) {
		setCha(_trueCha + i);
	}

	private byte _int = 0; 
	private short _trueInt = 0; 

	public byte getInt() {
		return _int;
	}

	public void setInt(int i) {
		_trueInt = (short) i;
		_int = (byte) IntRange.ensure(i, 1, 127);
	}

	public void addInt(int i) {
		setInt(_trueInt + i);
	}

	private byte _wis = 0; 
	private short _trueWis = 0; 

	public byte getWis() {
		return _wis;
	}

	public void setWis(int i) {
		_trueWis = (short) i;
		_wis = (byte) IntRange.ensure(i, 1, 127);
	}

	public void addWis(int i) {
		setWis(_trueWis + i);
	}

	private int _wind = 0;
	private int _trueWind = 0; 

	public int getWind() {
		return _wind;
	} 

	public void addWind(int i) {
		_trueWind += i;
		_wind = IntRange.ensure(_trueWind, -128, 127);
	}

	private int _water = 0; 
	private int _trueWater = 0; 

	public int getWater() {
		return _water;
	} 

	public void addWater(int i) {
		_trueWater += i;
		_water = IntRange.ensure(_trueWater, -128, 127);
	}

	private int _fire = 0; 
	private int _trueFire = 0;

	public int getFire() {
		return _fire;
	} 

	public void addFire(int i) {
		_trueFire += i;
		_fire = IntRange.ensure(_trueFire, -128, 127);
	}

	private int _earth = 0; 
	private int _trueEarth = 0;

	public int getEarth() {
		return _earth;
	} 

	public void addEarth(int i) {
		_trueEarth += i;
		_earth = IntRange.ensure(_trueEarth, -128, 127);
	}

	private int _addAttrKind; 
	public int getAddAttrKind() { return _addAttrKind; }
	public void setAddAttrKind(int i) { _addAttrKind = i; }

	private int _resistStun = 0;
	private int _trueResistStun = 0;

	public int getResistStun() {
		return _resistStun;
	}

	public void addResistStun(int i) {
		_trueResistStun += i;
		_resistStun = IntRange.ensure(_trueResistStun, -128, 127);
	}

	private int _resistStone = 0;
	private int _trueResistStone = 0;

	public int getResistStone() {
		return _resistStone;
	} 

	public void addResistStone(int i) {
		_trueResistStone += i;
		_resistStone = IntRange.ensure(_trueResistStun, -128, 127);
	}

	private int _resistSleep = 0;
	private int _trueResistSleep = 0;

	public int getResistSleep() {
		return _resistSleep;
	} 

	public void addResistSleep(int i) {
		_trueResistSleep += i;
		_resistSleep = IntRange.ensure(_trueResistSleep, -128, 127);
	}

	private int _resistFreeze = 0;
	private int _trueResistFreeze = 0;

	public int getResistFreeze() {
		return _resistFreeze;
	} 

	public void addResistFreeze(int i) {
		_trueResistFreeze += i;
		_resistFreeze = IntRange.ensure(_trueResistFreeze, -128, 127);
	}

	private int _resistSustain = 0;
	private int _trueResistSustain = 0;

	public int getResistSustain() {
		return _resistSustain;
	}

	public void addResistSustain(int i) {
		_trueResistSustain += i;
		_resistSustain = IntRange.ensure(_trueResistSustain, -128, 127);
	}

	private int _resistBlind = 0;
	private int _trueResistBlind = 0;

	public int getResistBlind() {
		return _resistBlind;
	}

	public void addResistBlind(int i) {
		_trueResistBlind += i;
		_resistBlind = IntRange.ensure(_trueResistBlind, -128, 127);
	}

	private int _dmgup = 0;
	private int _trueDmgup = 0;

	public int getDmgup() {
		return _dmgup;
	}

	public void addDmgup(int i) {
		_trueDmgup += i;
		_dmgup = IntRange.ensure(_trueDmgup, -128, 127);
	}

	private int _bowDmgup = 0;
	private int _trueBowDmgup = 0; 

	public int getBowDmgup() {
		return _bowDmgup;
	} 

	public void addBowDmgup(int i) {
		_trueBowDmgup += i;
		_bowDmgup = IntRange.ensure(_trueBowDmgup, -128, 127);
	}

	private int _hitup = 0; 
	private int _trueHitup = 0; 

	public int getHitup() {
		return _hitup;
	} 

	public void addHitup(int i) {
		_trueHitup += i;
		_hitup = IntRange.ensure(_trueHitup, -128, 127);
	}

	private int _bowHitup = 0; 
	private int _trueBowHitup = 0; 

	public int getBowHitup() {
		return _bowHitup;
	} 

	public void addBowHitup(int i) {
		_trueBowHitup += i;
		_bowHitup = IntRange.ensure(_trueBowHitup, -128, 127);
	}

	private int _mr = 0; 
	private int _trueMr = 0; 

	public int getMr() {
		return hasSkillEffect(ERASE_MAGIC) ? _mr / 4 : _mr;
	} 

	public int getTrueMr() {
		return _trueMr;
	}

	public void addMr(int i) {
		_trueMr += i;
		if (_trueMr <= 0) {
			_mr = 0;
		} else {
			_mr = _trueMr;
		}
	}

	private int _sp = 0; 

	public int getSp() {
		return getTrueSp() + _sp;
	}

	public int getTrueSp() {
		return getMagicLevel() + getMagicBonus();
	}

	public void addSp(int i) {
		_sp += i;
	}

	private boolean _isDead;
	public boolean isDead() { return _isDead; }
	public void setDead(boolean flag) { _isDead = flag; }

	private int _status; 
	public int getStatus() { return _status; }
	public void setStatus(int i) { _status = i; }

	private String _title;
	public String getTitle() { return _title; }
	public void setTitle(String s) { _title = s; }

	private int _lawful; 
	public int getLawful() { return _lawful; }
	public void setLawful(int i) { _lawful = i; }

	public synchronized void addLawful(int i) {
		_lawful += i;
		_lawful = IntRange.ensure(_lawful, -32768, 32767);
	}

	private int _heading; 
	public int getHeading() { return _heading; }
	public void setHeading(int i) { _heading = i; }

	private int _moveSpeed; 
	public int getMoveSpeed() { return _moveSpeed; }
	public void setMoveSpeed(int i) { _moveSpeed = i; }

	private int _braveSpeed;
	public int getBraveSpeed() { return _braveSpeed; }
	public void setBraveSpeed(int i) { _braveSpeed = i; }

	private int _tempCharGfx; 
	public int getTempCharGfx() { return _tempCharGfx; }
	public void setTempCharGfx(int i) { _tempCharGfx = i; }

	private int _gfxid; 
	public int getGfxId() { return _gfxid; }
	public void setGfxId(int i) { _gfxid = i; }

	public int getMagicLevel() {
		return getLevel() / 4;
	}

	private static final int[] magicBonus =
		{ -2, -2, -2, -2, -2, -2, -1, -1, -1, 0, 0, 0, 1, 1, 1, // 0-14
			2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, // 15-30
			10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 12, // 31-43
			12, 12, 12, 12, 12, 12, 13 }; // 44-50

	public int getMagicBonus() {
		int i = getInt();
		return i <= 50 ? magicBonus[i] : i - 25;
	}

	public boolean isInvisble() {
		return (hasSkillEffect(INVISIBILITY)
				|| hasSkillEffect(BLIND_HIDING));
	}

	public void healHp(int pt) {
		setCurrentHp(getCurrentHp() + pt);
	}

	private int _karma;
	public int getKarma() { return _karma; }
	public void setKarma(int karma) { _karma = karma; }

	public void setMr(int i) {
		_trueMr = i;
		if (_trueMr <= 0) {
			_mr = 0;
		} else {
			_mr = _trueMr;
		}
	}

	public void turnOnOffLight() {
		int lightSize = 0;
		if (this instanceof L1NpcInstance) {
			L1NpcInstance npc = (L1NpcInstance) this;
			lightSize = npc.getLightSize(); // 
		}
		if (hasSkillEffect(L1SkillId.LIGHT)) {
			lightSize = 14;
		}

		for (L1ItemInstance item : getInventory().getItems()) {
			if (item.getItem().getType2() == 0 && item.getItem()
					.getType() == 2) { // 
				int itemlightSize = item.getItem().getLightRange();
				if (itemlightSize != 0 && item.isNowLighting()) {
					if (itemlightSize > lightSize) {
						lightSize = itemlightSize;
					}
				}
					}
		}

		if (this instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) this;
			pc.sendPackets(new S_Light(pc.getId(), lightSize));
		}
		if (!isInvisble()) {
			broadcastPacket(new S_Light(getId(), lightSize));
		}

		setOwnLightSize(lightSize); // 
		setChaLightSize(lightSize); // 
	}

	private int _chaLightSize; // 

	public int getChaLightSize() {
		if (isInvisble()) {
			return 0;
		}
		return _chaLightSize;
	}

	public void setChaLightSize(int i) {
		_chaLightSize = i;
	}

	private int _ownLightSize;
	public int getOwnLightSize() { return _ownLightSize; }
	public void setOwnLightSize(int i) { _ownLightSize = i; }
}
