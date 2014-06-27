package l1j.server.server.model.Instance;

import static l1j.server.server.model.skill.L1SkillId.BLIND_HIDING;
import static l1j.server.server.model.skill.L1SkillId.BLOODLUST;
import static l1j.server.server.model.skill.L1SkillId.CANCELLATION;
import static l1j.server.server.model.skill.L1SkillId.COUNTER_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.DECREASE_WEIGHT;
import static l1j.server.server.model.skill.L1SkillId.DRESS_EVASION;
import static l1j.server.server.model.skill.L1SkillId.ENTANGLE;
import static l1j.server.server.model.skill.L1SkillId.FOG_OF_SLEEPING;
import static l1j.server.server.model.skill.L1SkillId.GMSTATUS_FINDINVIS;
import static l1j.server.server.model.skill.L1SkillId.GMSTATUS_HPBAR;
import static l1j.server.server.model.skill.L1SkillId.GREATER_HASTE;
import static l1j.server.server.model.skill.L1SkillId.HASTE;
import static l1j.server.server.model.skill.L1SkillId.HOLY_WALK;
import static l1j.server.server.model.skill.L1SkillId.ILLUSION_AVATAR;
import static l1j.server.server.model.skill.L1SkillId.INVISIBILITY;
import static l1j.server.server.model.skill.L1SkillId.MASS_SLOW;
import static l1j.server.server.model.skill.L1SkillId.MORTAL_BODY;
import static l1j.server.server.model.skill.L1SkillId.MOVING_ACCELERATION;
import static l1j.server.server.model.skill.L1SkillId.SHAPE_CHANGE;
import static l1j.server.server.model.skill.L1SkillId.SLOW;
import static l1j.server.server.model.skill.L1SkillId.SOLID_CARRIAGE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_BRAVE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CHAT_PROHIBITED;
import static l1j.server.server.model.skill.L1SkillId.STATUS_ELFBRAVE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HASTE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_RIBRAVE;
import static l1j.server.server.model.skill.L1SkillId.STRIKER_GALE;
import static l1j.server.server.model.skill.L1SkillId.WIND_WALK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.ActionCodes;
import l1j.server.server.ClientThread;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.PacketOutput;
import l1j.server.server.command.executor.L1HpBar;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ExpTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.model.AcceleratorChecker;
import l1j.server.server.model.HpRegeneration;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1ChatParty;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1DeathMatch;
import l1j.server.server.model.L1DwarfForElfInventory;
import l1j.server.server.model.L1DwarfInventory;
import l1j.server.server.model.L1EquipmentSlot;
import l1j.server.server.model.L1ExcludingList;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Karma;
import l1j.server.server.model.L1Magic;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Party;
import l1j.server.server.model.L1PcDeleteTimer;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1PinkName;
import l1j.server.server.model.L1Quest;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1TownLocation;
import l1j.server.server.model.L1War;
import l1j.server.server.model.L1World;
import l1j.server.server.model.MpReductionByAwake;
import l1j.server.server.model.MpRegeneration;
import l1j.server.server.model.MpRegenerationByDoll;
import l1j.server.server.model.ZoneType;
import l1j.server.server.model.classes.L1ClassFeature;
import l1j.server.server.model.classes.L1ClassId;
import l1j.server.server.model.gametime.L1GameTimeCarrier;
import l1j.server.server.model.monitor.L1PcAutoUpdate;
import l1j.server.server.model.monitor.L1PcExpMonitor;
import l1j.server.server.model.monitor.L1PcGhostMonitor;
import l1j.server.server.model.monitor.L1PcHellMonitor;
import l1j.server.server.model.monitor.L1PcInvisDelay;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_BlueMessage;
import l1j.server.server.serverpackets.S_CastleMaster;
import l1j.server.server.serverpackets.S_ChangeShape;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_DoActionShop;
import l1j.server.server.serverpackets.S_Exp;
import l1j.server.server.serverpackets.S_HPMeter;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_Invis;
import l1j.server.server.serverpackets.S_Lawful;
import l1j.server.server.serverpackets.S_Liquor;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_OtherCharPacks;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_Poison;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_bonusstats;
import l1j.server.server.serverpackets.ServerBasePacket;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Pet;
import l1j.server.server.templates.L1PrivateShopBuyList;
import l1j.server.server.templates.L1PrivateShopSellList;
import l1j.server.server.utils.CalcStat;
import l1j.server.server.utils.SQLUtil;

public class L1PcInstance extends L1Character {
	private static final long serialVersionUID = 1L;
	private static final int MP_REGEN_INTERVAL = 1000;
	private static final int HP_REGEN_INTERVAL = 1000;
	private static Random _random = new Random();

	private short _trueHpr = 0;
	private short _hpr = 0;

	public short getHpr() {
		return _hpr;
	}

	public void addHpr(int i) {
		_trueHpr += i;
		_hpr = (short) Math.max(0, _trueHpr);
	}

	private short _mpr = 0;
	private short _trueMpr = 0;

	public short getMpr() {
		return _mpr;
	}

	public void addMpr(int i) {
		_trueMpr += i;
		_mpr = (short) Math.max(0, _trueMpr);
	}

	private int _originalHpr = 0;

	public int getOriginalHpr() {
		return _originalHpr;
	}

	private int _originalMpr = 0;

	public int getOriginalMpr() {
		return _originalMpr;
	}

	public void startHpRegeneration() {
		if (!_hpRegenActive) {
			_hpRegen = new HpRegeneration(this);
			_regenTimer.scheduleAtFixedRate(_hpRegen, HP_REGEN_INTERVAL,
					HP_REGEN_INTERVAL);
			_hpRegenActive = true;
		}
	}

	public void stopHpRegeneration() {
		if (_hpRegenActive) {
			_hpRegen.cancel();
			_hpRegen = null;
			_hpRegenActive = false;
		}
	}

	public void startMpRegeneration() {
		if (!_mpRegenActive) {
			_mpRegen = new MpRegeneration(this);
			_regenTimer.scheduleAtFixedRate(_mpRegen, MP_REGEN_INTERVAL,
					MP_REGEN_INTERVAL);
			_mpRegenActive = true;
		}
	}

	public void startMpRegenerationByDoll() {
		final int INTERVAL_BY_DOLL = 60000;
		boolean isExistMprDoll = false;
		Object[] dollList = getDollList().values().toArray();
		for (Object dollObject : dollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			if (doll.isMpRegeneration()) {
				isExistMprDoll = true;
			}
		}
		if (!_mpRegenActiveByDoll && isExistMprDoll) {
			_mpRegenByDoll = new MpRegenerationByDoll(this);
			_regenTimer.scheduleAtFixedRate(_mpRegenByDoll, INTERVAL_BY_DOLL,
					INTERVAL_BY_DOLL);
			_mpRegenActiveByDoll = true;
		}
	}

	public void startMpReductionByAwake() {
		final int INTERVAL_BY_AWAKE = 4000;
		if (!_mpReductionActiveByAwake) {
			_mpReductionByAwake = new MpReductionByAwake(this);
			_regenTimer.scheduleAtFixedRate(_mpReductionByAwake,
					INTERVAL_BY_AWAKE, INTERVAL_BY_AWAKE);
			_mpReductionActiveByAwake = true;
		}
	}

	public void stopMpRegeneration() {
		if (_mpRegenActive) {
			_mpRegen.cancel();
			_mpRegen = null;
			_mpRegenActive = false;
		}
	}

	public void stopMpRegenerationByDoll() {
		if (_mpRegenActiveByDoll) {
			_mpRegenByDoll.cancel();
			_mpRegenByDoll = null;
			_mpRegenActiveByDoll = false;
		}
	}

	public void stopMpReductionByAwake() {
		if (_mpReductionActiveByAwake) {
			_mpReductionByAwake.cancel();
			_mpReductionByAwake = null;
			_mpReductionActiveByAwake = false;
		}
	}

	public void startObjectAutoUpdate() {
		removeAllKnownObjects();
		_autoUpdateFuture = GeneralThreadPool.getInstance()
				.pcScheduleAtFixedRate(new L1PcAutoUpdate(getId()), 0L,
						INTERVAL_AUTO_UPDATE);
	}

	public void stopEtcMonitor() {
		if (_autoUpdateFuture != null) {
			_autoUpdateFuture.cancel(true);
			_autoUpdateFuture = null;
		}
		if (_expMonitorFuture != null) {
			_expMonitorFuture.cancel(true);
			_expMonitorFuture = null;
		}
		if (_ghostFuture != null) {
			_ghostFuture.cancel(true);
			_ghostFuture = null;
		}
		if (_hellFuture != null) {
			_hellFuture.cancel(true);
			_hellFuture = null;
		}
	}

	private static final long INTERVAL_AUTO_UPDATE = 500;
	private ScheduledFuture<?> _autoUpdateFuture;

	private static final long INTERVAL_EXP_MONITOR = 3000;
	private ScheduledFuture<?> _expMonitorFuture;

	public void onChangeExp() {
		int level = ExpTable.getLevelByExp(getExp());
		int char_level = getLevel();
		int gap = level - char_level;
		if (gap == 0) {
			// sendPackets(new S_OwnCharStatus(this));
			sendPackets(new S_Exp(this));
			return;
		}

		if (gap > 0) {
			levelUp(gap);
		} else if (gap < 0) {
			levelDown(gap);
		}
	}

	@Override
	public void onPerceive(L1PcInstance perceivedFrom) {
		if (isGmInvis() || isGhost()) {
			return;
		}
		if (isInvisble() && !perceivedFrom.hasSkillEffect(GMSTATUS_FINDINVIS)) {
			return;
		}

		perceivedFrom.addKnownObject(this);
		perceivedFrom.sendPackets(new S_OtherCharPacks(this, perceivedFrom
				.hasSkillEffect(GMSTATUS_FINDINVIS)));
		if (isInParty() && getParty().isMember(perceivedFrom)) {
			perceivedFrom.sendPackets(new S_HPMeter(this));
		}

		// TODO Check if these are working, fixes for poison showing up on
		// characters entering your screen
		if (hasSkillEffect(L1SkillId.STATUS_POISON)
				|| hasSkillEffect(L1SkillId.STATUS_POISON_SILENCE)
				|| hasSkillEffect(L1SkillId.STATUS_POISON_PARALYZING)) {
			perceivedFrom.sendPackets(new S_Poison(getId(), 1));
		}
		if (hasSkillEffect(L1SkillId.STATUS_POISON_PARALYZED)) {
			perceivedFrom.sendPackets(new S_Poison(getId(), 2));
		}

		if (isPrivateShop()) {
			perceivedFrom.sendPackets(new S_DoActionShop(getId(),
					ActionCodes.ACTION_Shop, getShopChat()));
		}

		if (isCrown()) {
			L1Clan clan = L1World.getInstance().getClan(getClanname());
			if (clan != null) {
				if (getId() == clan.getLeaderId() && clan.getCastleId() != 0) {
					perceivedFrom.sendPackets(new S_CastleMaster(clan
							.getCastleId(), getId()));
				}
			}
		}
	}

	private void removeOutOfRangeObjects() {
		for (L1Object known : getKnownObjects()) {
			if (known == null) {
				continue;
			}

			if (Config.PC_RECOGNIZE_RANGE == -1) {
				if (!getLocation().isInScreen(known.getLocation())) {
					removeKnownObject(known);
					sendPackets(new S_RemoveObject(known));
				}
			} else {
				if (getLocation().getTileLineDistance(known.getLocation()) > Config.PC_RECOGNIZE_RANGE) {
					removeKnownObject(known);
					sendPackets(new S_RemoveObject(known));
				}
			}
		}
	}

	public void updateObject() {
		removeOutOfRangeObjects();

		for (L1Object visible : L1World.getInstance().getVisibleObjects(this,
				Config.PC_RECOGNIZE_RANGE)) {
			if (!knownsObject(visible)) {
				visible.onPerceive(this);
			} else {
				if (visible instanceof L1NpcInstance) {
					L1NpcInstance npc = (L1NpcInstance) visible;
					if (getLocation().isInScreen(npc.getLocation())
							&& npc.getHiddenStatus() != 0) {
						npc.approachPlayer(this);
					}
				}
			}
			if (hasSkillEffect(GMSTATUS_HPBAR)
					&& L1HpBar.isHpBarTarget(visible)) {
				sendPackets(new S_HPMeter((L1Character) visible));
			}
		}
	}

	private void sendVisualEffect() {
		int poisonId = 0;
		if (getPoison() != null) {
			poisonId = getPoison().getEffectId();
		}
		if (getParalysis() != null) {
			poisonId = getParalysis().getEffectId();
		}
		if (poisonId != 0) {
			sendAndBroadcast(new S_Poison(getId(), poisonId));
		}
	}

	public void sendVisualEffectAtLogin() {
		if (isCrown() && getClanid() != 0) {
			L1Clan clan = L1World.getInstance().getClan(getClanname());
			if (clan != null) {
				if (getId() == clan.getLeaderId() && clan.getCastleId() != 0) {
					sendPackets(new S_CastleMaster(clan.getCastleId(), getId()));
				}
			}
		}

		sendVisualEffect();
	}

	public void sendVisualEffectAtTeleport() {
		if (isDrink()) { // liquor
			sendPackets(new S_Liquor(getId()));
		}

		sendVisualEffect();
	}

	private ArrayList<Integer> skillList = new ArrayList<Integer>();

	public void setSkillMastery(int skillid) {
		if (!skillList.contains(skillid)) {
			skillList.add(skillid);
		}
	}

	public void removeSkillMastery(int skillid) {
		if (skillList.contains((Object) skillid)) {
			skillList.remove((Object) skillid);
		}
	}

	public boolean isSkillMastery(int skillid) {
		return skillList.contains(skillid);
	}

	public void clearSkillMastery() {
		skillList.clear();
	}

	public L1PcInstance() {
		_accessLevel = 0;
		_currentWeapon = 0;
		_inventory = new L1PcInventory(this);
		_dwarf = new L1DwarfInventory(this);
		_dwarfForElf = new L1DwarfForElfInventory(this);
		_tradewindow = new L1Inventory();
		_bookmarks = new ArrayList<L1BookMark>();
		_quest = new L1Quest(this);
		_equipSlot = new L1EquipmentSlot(this);
	}

	@Override
	public void setCurrentHp(int i) {
		if (getCurrentHp() == i) {
			return;
		}
		int currentHp = i;
		if (currentHp >= getMaxHp()) {
			currentHp = getMaxHp();
		}
		setCurrentHpDirect(currentHp);
		sendPackets(new S_HPUpdate(currentHp, getMaxHp()));
		if (isInParty()) {
			getParty().updateMiniHP(this);
		}
	}

	@Override
	public void setCurrentMp(int i) {
		if (getCurrentMp() == i) {
			return;
		}
		int currentMp = i;
		if (currentMp >= getMaxMp() || isGm()) {
			currentMp = getMaxMp();
		}
		setCurrentMpDirect(currentMp);
		sendPackets(new S_MPUpdate(currentMp, getMaxMp()));
	}

	@Override
	public L1PcInventory getInventory() {
		return _inventory;
	}

	public L1DwarfInventory getDwarfInventory() {
		return _dwarf;
	}

	public L1DwarfForElfInventory getDwarfForElfInventory() {
		return _dwarfForElf;
	}

	public L1Inventory getTradeWindowInventory() {
		return _tradewindow;
	}

	public boolean isGmInvis() {
		return _gmInvis;
	}

	public void setGmInvis(boolean flag) {
		_gmInvis = flag;
	}

	public int getCurrentWeapon() {
		return _currentWeapon;
	}

	public void setCurrentWeapon(int i) {
		_currentWeapon = i;
	}

	public int getType() {
		return _type;
	}

	public void setType(int i) {
		_type = i;
	}

	public short getAccessLevel() {
		return _accessLevel;
	}

	public void setAccessLevel(short i) {
		_accessLevel = i;
	}

	public int getClassId() {
		return _classId;
	}

	public void setClassId(int i) {
		_classId = i;
		_classFeature = L1ClassFeature.newClassFeature(i);
	}

	private L1ClassFeature _classFeature = null;

	public L1ClassFeature getClassFeature() {
		return _classFeature;
	}

	@Override
	public synchronized int getExp() {
		return _exp;
	}

	@Override
	public synchronized void setExp(int i) {
		_exp = i;
	}

	private int _PKcount;

	public int get_PKcount() {
		return _PKcount;
	}

	public void set_PKcount(int i) {
		_PKcount = i;
	}

	private int _PkCountForElf;

	public int getPkCountForElf() {
		return _PkCountForElf;
	}

	public void setPkCountForElf(int i) {
		_PkCountForElf = i;
	}

	private int _clanid;

	public int getClanid() {
		return _clanid;
	}

	public void setClanid(int i) {
		_clanid = i;
	}

	private String clanname;

	public String getClanname() {
		return clanname;
	}

	public void setClanname(String s) {
		clanname = s;
	}

	public L1Clan getClan() {
		return L1World.getInstance().getClan(getClanname());
	}

	private int _clanRank;

	public int getClanRank() {
		return _clanRank;
	}

	public void setClanRank(int i) {
		_clanRank = i;
	}

	private byte _sex;

	public byte get_sex() {
		return _sex;
	}

	public void set_sex(int i) {
		_sex = (byte) i;
	}

	public boolean isGm() {
		return _gm;
	}

	public void setGm(boolean flag) {
		_gm = flag;
	}

	public boolean isMonitor() {
		return _monitor;
	}

	public void setMonitor(boolean flag) {
		_monitor = flag;
	}

	private L1PcInstance getStat() {
		return null;
	}

	public void reduceCurrentHp(double d, L1Character l1character) {
		getStat().reduceCurrentHp(d, l1character);
	}

	private void notifyPlayersLogout(List<L1PcInstance> playersArray) {
		for (L1PcInstance player : playersArray) {
			if (player.knownsObject(this)) {
				player.removeKnownObject(this);
				player.sendPackets(new S_RemoveObject(this));
			}
		}
	}

	public void logout() {
		L1World world = L1World.getInstance();
		if (getClanid() != 0) {
			L1Clan clan = world.getClan(getClanname());
			if (clan != null) {
				if (clan.getWarehouseUsingChar() == getId()) {
					clan.setWarehouseUsingChar(0);
				}
			}
		}
		notifyPlayersLogout(getKnownPlayers());
		world.removeVisibleObject(this);
		world.removeObject(this);
		notifyPlayersLogout(world.getRecognizePlayer(this));
		_inventory.clearItems();
		_dwarf.clearItems();
		_dwarfForElf.clearItems();
		removeAllKnownObjects();
		stopHpRegeneration();
		stopMpRegeneration();
		setDead(true);
		setNetConnection(null);
		setPacketOutput(null);
	}

	public ClientThread getNetConnection() {
		return _netConnection;
	}

	public void setNetConnection(ClientThread clientthread) {
		_netConnection = clientthread;
	}

	public boolean isInParty() {
		return getParty() != null;
	}

	public L1Party getParty() {
		return _party;
	}

	public void setParty(L1Party p) {
		_party = p;
	}

	public boolean isInChatParty() {
		return getChatParty() != null;
	}

	public L1ChatParty getChatParty() {
		return _chatParty;
	}

	public void setChatParty(L1ChatParty cp) {
		_chatParty = cp;
	}

	public int getPartyID() {
		return _partyID;
	}

	public void setPartyID(int partyID) {
		_partyID = partyID;
	}

	public int getTradeID() {
		return _tradeID;
	}

	public void setTradeID(int tradeID) {
		_tradeID = tradeID;
	}

	public void setTradeOk(boolean tradeOk) {
		_tradeOk = tradeOk;
	}

	public boolean getTradeOk() {
		return _tradeOk;
	}

	public int getTempID() {
		return _tempID;
	}

	public void setTempID(int tempID) {
		_tempID = tempID;
	}

	public boolean isTeleport() {
		return _isTeleport;
	}

	public void setTeleport(boolean flag) {
		_isTeleport = flag;
	}

	public boolean isDrink() {
		return _isDrink;
	}

	public void setDrink(boolean flag) {
		_isDrink = flag;
	}

	public boolean isGres() {
		return _isGres;
	}

	public void setGres(boolean flag) {
		_isGres = flag;
	}

	public boolean isPinkName() {
		return _isPinkName;
	}

	public void setPinkName(boolean flag) {
		_isPinkName = flag;
	}

	private List<L1PrivateShopSellList> _sellList = new ArrayList<L1PrivateShopSellList>();

	public List<L1PrivateShopSellList> getSellList() {
		return _sellList;
	}

	private List<L1PrivateShopBuyList> _buyList = new ArrayList<L1PrivateShopBuyList>();

	public List getBuyList() {
		return _buyList;
	}

	private byte[] _shopChat;

	public void setShopChat(byte[] chat) {
		_shopChat = chat;
	}

	public byte[] getShopChat() {
		return _shopChat;
	}

	private boolean _isPrivateShop = false;

	public boolean isPrivateShop() {
		return _isPrivateShop;
	}

	public void setPrivateShop(boolean flag) {
		_isPrivateShop = flag;
	}

	private boolean _isTradingInPrivateShop = false;

	public boolean isTradingInPrivateShop() {
		return _isTradingInPrivateShop;
	}

	public void setTradingInPrivateShop(boolean flag) {
		_isTradingInPrivateShop = flag;
	}

	private int _partnersPrivateShopItemCount = 0;

	public int getPartnersPrivateShopItemCount() {
		return _partnersPrivateShopItemCount;
	}

	public void setPartnersPrivateShopItemCount(int i) {
		_partnersPrivateShopItemCount = i;
	}

	private PacketOutput _out;

	public void setPacketOutput(PacketOutput out) {
		_out = out;
	}

	public void sendPackets(ServerBasePacket serverbasepacket) {
		if (_out == null) {
			return;
		}

		try {
			_out.sendPacket(serverbasepacket);
		} catch (Exception e) {
		}
	}

	public void sendAndBroadcast(ServerBasePacket packet) {
		sendPackets(packet);
		broadcastPacket(packet);
	}

	@Override
	public void onAction(L1PcInstance attacker) {
		if (attacker == null) {
			return;
		}
		if (isTeleport()) {
			return;
		}
		if (getZoneType() == ZoneType.Safety
				|| attacker.getZoneType() == ZoneType.Safety) {
			L1Attack attack_mortion = new L1Attack(attacker, this);
			attack_mortion.action();
			return;
		}

		if (checkNonPvP(this, attacker) == true) {
			L1Attack attack_mortion = new L1Attack(attacker, this);
			attack_mortion.action();
			return;
		}

		if (getCurrentHp() > 0 && !isDead()) {
			attacker.delInvis();

			L1Attack attack = new L1Attack(attacker, this);

			if (hasSkillEffect(COUNTER_BARRIER)) {
				L1Magic magic = new L1Magic(this, attacker);
				if (magic.calcProbabilityMagic(COUNTER_BARRIER)
						&& attack.isShortDistance() && !attacker.isFoeSlayer()) {
					attack.actionCounterBarrier();
					attack.commitCounterBarrier();
					return;
				}
			}
			if (attack.calcHit()) {
				attacker.setPetTarget(this);
				attack.calcDamage();
				attack.calcStaffOfMana();
				attack.addPcPoisonAttack(attacker, this);
				attack.addChaserAttack();
			}
			attack.action();
			attack.commit();
		}
	}

	public boolean checkNonPvP(L1PcInstance pc, L1Character target) {
		L1PcInstance targetpc = null;
		if (target instanceof L1PcInstance) {
			targetpc = (L1PcInstance) target;
		} else if (target instanceof L1PetInstance) {
			targetpc = (L1PcInstance) ((L1PetInstance) target).getMaster();
		} else if (target instanceof L1SummonInstance) {
			targetpc = (L1PcInstance) ((L1SummonInstance) target).getMaster();
		}
		if (targetpc == null) {
			return false;
		}
		if (!Config.ALT_NONPVP) { // Non-PvP
			if (getMap().isCombatZone(getLocation())) {
				return false;
			}
			for (L1War war : L1World.getInstance().getWarList()) {
				if (pc.getClanid() != 0 && targetpc.getClanid() != 0) {
					boolean same_war = war.CheckClanInSameWar(pc.getClanname(),
							targetpc.getClanname());
					if (same_war == true) {
						return false;
					}
				}
			}
			if (target instanceof L1PcInstance) {
				L1PcInstance targetPc = (L1PcInstance) target;
				if (isInWarAreaAndWarTime(pc, targetPc)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	private boolean isInWarAreaAndWarTime(L1PcInstance pc, L1PcInstance target) {
		int castleId = L1CastleLocation.getCastleIdByArea(pc);
		int targetCastleId = L1CastleLocation.getCastleIdByArea(target);
		if (castleId != 0 && targetCastleId != 0 && castleId == targetCastleId) {
			if (WarTimeController.getInstance().isNowWar(castleId)) {
				return true;
			}
		}
		return false;
	}

	public void setPetTarget(L1Character target) {
		Object[] petList = getPetList().values().toArray();
		for (Object pet : petList) {
			if (pet instanceof L1PetInstance) {
				L1PetInstance pets = (L1PetInstance) pet;
				pets.setMasterTarget(target);
			} else if (pet instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) pet;
				summon.setMasterTarget(target);
			}
		}
	}

	public void delInvis() {
		if (hasSkillEffect(INVISIBILITY)) {
			killSkillEffectTimer(INVISIBILITY);
			sendPackets(new S_Invis(getId(), 0));
			broadcastPacket(new S_OtherCharPacks(this));
		}
		if (hasSkillEffect(BLIND_HIDING)) {
			killSkillEffectTimer(BLIND_HIDING);
			sendPackets(new S_Invis(getId(), 0));
			broadcastPacket(new S_OtherCharPacks(this));
		}
	}

	public void delBlindHiding() {
		killSkillEffectTimer(BLIND_HIDING);
		sendPackets(new S_Invis(getId(), 0));
		broadcastPacket(new S_OtherCharPacks(this));
	}

	public void receiveDamage(L1Character attacker, int damage, int attr) {
		int player_mr = getMr();
		int rnd = _random.nextInt(100) + 1;
		if (player_mr >= rnd) {
			damage /= 2;
		}
		receiveDamage(attacker, damage, false);
	}

	public void receiveManaDamage(L1Character attacker, int mpDamage) {
		if (mpDamage > 0 && !isDead()) {
			delInvis();
			if (attacker instanceof L1PcInstance) {
				L1PinkName.onAction(this, attacker);
			}
			if (attacker instanceof L1PcInstance
					&& ((L1PcInstance) attacker).isPinkName()) {

				for (L1Object object : L1World.getInstance().getVisibleObjects(
						attacker)) {
					if (object instanceof L1GuardInstance) {
						L1GuardInstance guard = (L1GuardInstance) object;
						guard.setTarget(((L1PcInstance) attacker));
					}
				}
			}

			int newMp = getCurrentMp() - mpDamage;
			if (newMp > getMaxMp()) {
				newMp = getMaxMp();
			}

			if (newMp <= 0) {
				newMp = 0;
			}
			setCurrentMp(newMp);
		}
	}

	public long _oldTime = 0;

	public void receiveDamage(L1Character attacker, double damage,
			boolean isMagicDamage) { //
		if (getCurrentHp() > 0 && !isDead()) {
			if (attacker != this) {
				if (!(attacker instanceof L1EffectInstance)
						&& !knownsObject(attacker)
						&& attacker.getMapId() == this.getMapId()) {
					attacker.onPerceive(this);
				}
			}

			if (isMagicDamage == true) { //
				long nowTime = System.currentTimeMillis();
				long interval = nowTime - _oldTime;

				if (damage < 0) {
					damage = 0;
				} else {
					if (2000 > interval && interval >= 1900) {
						damage = (damage * (100 - (10 / 3))) / 100;
					} else if (1900 > interval && interval >= 1800) {
						damage = (damage * (100 - 2 * (10 / 3))) / 100;
					} else if (1800 > interval && interval >= 1700) {
						damage = (damage * (100 - 3 * (10 / 3))) / 100;
					} else if (1700 > interval && interval >= 1600) {
						damage = (damage * (100 - 4 * (10 / 3))) / 100;
					} else if (1600 > interval && interval >= 1500) {
						damage = (damage * (100 - 5 * (10 / 3))) / 100;
					} else if (1500 > interval && interval >= 1400) {
						damage = (damage * (100 - 6 * (10 / 3))) / 100;
					} else if (1400 > interval && interval >= 1300) {
						damage = (damage * (100 - 7 * (10 / 3))) / 100;
					} else if (1300 > interval && interval >= 1200) {
						damage = (damage * (100 - 8 * (10 / 3))) / 100;
					} else if (1200 > interval && interval >= 1100) {
						damage = (damage * (100 - 9 * (10 / 3))) / 100;
					} else if (1100 > interval && interval >= 1000) {
						damage = (damage * (100 - 10 * (10 / 3))) / 100;
					} else if (1000 > interval && interval >= 900) {
						damage = (damage * (100 - 11 * (10 / 3))) / 100;
					} else if (900 > interval && interval >= 800) {
						damage = (damage * (100 - 12 * (10 / 3))) / 100;
					} else if (800 > interval && interval >= 700) {
						damage = (damage * (100 - 13 * (10 / 3))) / 100;
					} else if (700 > interval && interval >= 600) {
						damage = (damage * (100 - 14 * (10 / 3))) / 100;
					} else if (600 > interval && interval >= 500) {
						damage = (damage * (100 - 15 * (10 / 3))) / 100;
					} else if (500 > interval && interval >= 400) {
						damage = (damage * (100 - 16 * (10 / 3))) / 100;
					} else if (400 > interval && interval >= 300) {
						damage = (damage * (100 - 17 * (10 / 3))) / 100;
					} else if (300 > interval && interval >= 200) {
						damage = (damage * (100 - 18 * (10 / 3))) / 100;
					} else if (200 > interval && interval >= 100) {
						damage = (damage * (100 - 19 * (10 / 3))) / 100;
					} else if (100 > interval && interval >= 0) {
						damage = (damage * (100 - 20 * (10 / 3))) / 100;
					} 

					if (damage < 1) {
						damage = 0;
					}

					_oldTime = nowTime; //
				}
			}
			if (damage > 0) {
				delInvis();
				if (attacker instanceof L1PcInstance) {
					L1PinkName.onAction(this, attacker);
				}
				if (attacker instanceof L1PcInstance
						&& ((L1PcInstance) attacker).isPinkName()) {
					for (L1Object object : L1World.getInstance()
							.getVisibleObjects(attacker)) {
						if (object instanceof L1GuardInstance) {
							L1GuardInstance guard = (L1GuardInstance) object;
							guard.setTarget(((L1PcInstance) attacker));
						}
					}
				}
				removeSkillEffect(FOG_OF_SLEEPING);
			}

			if (hasSkillEffect(MORTAL_BODY) && getId() != attacker.getId()) {
				int rnd = _random.nextInt(100) + 1;
				if (damage > 0 && rnd <= 23) {
					if (attacker instanceof L1PcInstance) {
						L1PcInstance attackPc = (L1PcInstance) attacker;
						attackPc.sendAndBroadcast(new S_DoActionGFX(attackPc
								.getId(), ActionCodes.ACTION_Damage));
						attackPc.receiveDamage(this, 30, false);
					} else if (attacker instanceof L1NpcInstance) {
						L1NpcInstance attackNpc = (L1NpcInstance) attacker;
						attackNpc.broadcastPacket(new S_DoActionGFX(attackNpc
								.getId(), ActionCodes.ACTION_Damage));
						attackNpc.receiveDamage(this, 30);
					}
				}
			} /*
			 * expected to be deleted after experimental implementation if
			 * (attacker.hasSkillEffect(JOY_OF_PAIN) && getId() !=
			 * attacker.getId()) { int nowDamage = getMaxHp() - getCurrentHp();
			 * if (nowDamage > 0) { if (attacker instanceof L1PcInstance) {
			 * L1PcInstance attackPc = (L1PcInstance) attacker;
			 * attackPc.sendAndBroadcast(new S_DoActionGFX( attackPc.getId(),
			 * ActionCodes.ACTION_Damage)); attackPc.receiveDamage(this,
			 * nowDamage / 5, false); } else if (attacker instanceof
			 * L1NpcInstance) { L1NpcInstance attackNpc = (L1NpcInstance)
			 * attacker; attackNpc.broadcastPacket(new S_DoActionGFX(attackNpc
			 * .getId(), ActionCodes.ACTION_Damage));
			 * attackNpc.receiveDamage(this, nowDamage / 5); } } }
			 */
			if (getInventory().checkEquipped(145)
					|| getInventory().checkEquipped(149)) {
				damage *= 1.5;
			}
			if (hasSkillEffect(ILLUSION_AVATAR)) {
				damage *= 1.2;
			}
			int newHp = getCurrentHp() - (int) (damage);
			if (newHp > getMaxHp()) {
				newHp = getMaxHp();
			}
			if (newHp <= 0) {
				if (isGm()) {
					setCurrentHp(getMaxHp());
				} else {
					death(attacker);
				}
			}
			if (newHp > 0) {
				setCurrentHp(newHp);
			}
		} else if (!isDead()) {
			// System.out
			// .println("xFvC[gosBgoO");
			death(attacker);
		}
	}

	public void death(L1Character lastAttacker) {
		synchronized (this) {
			if (isDead()) {
				return;
			}
			setDead(true);
			setStatus(ActionCodes.ACTION_Die);
		}
		GeneralThreadPool.getInstance().execute(new Death(lastAttacker));

	}

	private class Death implements Runnable {
		L1Character _lastAttacker;

		Death(L1Character cha) {
			_lastAttacker = cha;
		}

		public void run() {
			L1Character lastAttacker = _lastAttacker;
			_lastAttacker = null;
			setCurrentHp(0);
			setGresValid(false);

			while (isTeleport()) {
				try {
					Thread.sleep(300);
				} catch (Exception e) {
				}
			}

			stopHpRegeneration();
			stopMpRegeneration();

			int targetobjid = getId();
			getMap().setPassable(getLocation(), true);

			int tempchargfx = 0;
			if (hasSkillEffect(SHAPE_CHANGE)) {
				tempchargfx = getTempCharGfx();
				setTempCharGfxAtDead(tempchargfx);
			} else {
				setTempCharGfxAtDead(getClassId());
			}

			L1SkillUse l1skilluse = new L1SkillUse();
			l1skilluse.handleCommands(L1PcInstance.this, CANCELLATION, getId(),
					getX(), getY(), null, 0, L1SkillUse.TYPE_LOGIN);

			if (tempchargfx == 5727 || tempchargfx == 5730
					|| tempchargfx == 5733 || tempchargfx == 5736) {
				tempchargfx = 0;
			}
			if (tempchargfx != 0) {
				sendAndBroadcast(new S_ChangeShape(getId(), tempchargfx));
			} else {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}

			sendAndBroadcast(new S_DoActionGFX(targetobjid,
					ActionCodes.ACTION_Die));

			if (lastAttacker.getMapId() != 509) {
				try {
					if (lastAttacker != L1PcInstance.this) {
						L1PcInstance player = null;
						if (lastAttacker instanceof L1PcInstance) {
							player = (L1PcInstance) lastAttacker;
							L1World.getInstance().broadcastServerMessage(
									player.getName() + " just owned "
											+ getName() + " in battle!");
						} else if (lastAttacker instanceof L1PetInstance) {
							player = (L1PcInstance) ((L1PetInstance) lastAttacker)
									.getMaster();
							L1World.getInstance().broadcastServerMessage(
									player.getName() + " just ate " + getName()
											+ "'s face with uber pets!");
						} else if (lastAttacker instanceof L1SummonInstance) {
							player = (L1PcInstance) ((L1SummonInstance) lastAttacker)
									.getMaster();
							L1World.getInstance()
									.broadcastServerMessage(
											player.getName() + " just tore up "
													+ getName()
													+ " with evil summons!");
						}
						if (player != null) {
							if (player instanceof L1PcInstance) {

								try {

									Timestamp ts = new Timestamp(
											System.currentTimeMillis());
									Connection con = null;
									PreparedStatement pstm = null;
									con = L1DatabaseFactory.getInstance()
											.getConnection();
									pstm = con
											.prepareStatement("INSERT INTO character_pvp (killer_char_obj_id, killer_char_name, killer_lvl, victim_char_obj_id, victim_char_name, victim_lvl, date, locx, locy, mapid, penalty) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
									pstm.setInt(1, player.getId());
									pstm.setString(2, player.getName());
									pstm.setInt(3, player.getLevel());
									pstm.setInt(4, getId());
									pstm.setString(5, getName());
									pstm.setInt(6, getLevel());
									pstm.setTimestamp(7, ts);
									pstm.setInt(8, getX());
									pstm.setInt(9, getY());
									pstm.setInt(10, getMapId());
									if (isInWarAreaAndWarTime(
											L1PcInstance.this, player)
											&& getZoneType() != ZoneType.Normal
											&& getMap().isEnabledDeathPenalty()) {
										pstm.setInt(11, 1);
									} else if (!isInWarAreaAndWarTime(
											L1PcInstance.this, player)
											&& getZoneType() != ZoneType.Normal
											&& !getMap()
													.isEnabledDeathPenalty()) {
										pstm.setInt(11, 2);
									} else if (isInWarAreaAndWarTime(
											L1PcInstance.this, player)
											&& getZoneType() != ZoneType.Normal
											&& !getMap()
													.isEnabledDeathPenalty()) {
										pstm.setInt(11, 3);
										// doorway
									} else if (!isInWarAreaAndWarTime(
											L1PcInstance.this, player)
											&& getZoneType() != ZoneType.Normal
											&& getMap().isEnabledDeathPenalty()) {
										pstm.setInt(11, 4);
									} else if (isInWarAreaAndWarTime(
											L1PcInstance.this, player)
											&& getZoneType() == ZoneType.Normal
											&& getMap().isEnabledDeathPenalty()) {
										pstm.setInt(11, 5);
									} else if (!isInWarAreaAndWarTime(
											L1PcInstance.this, player)
											&& getZoneType() == ZoneType.Normal
											&& !getMap()
													.isEnabledDeathPenalty()) {
										pstm.setInt(11, 6);
									} else if (isInWarAreaAndWarTime(
											L1PcInstance.this, player)
											&& getZoneType() == ZoneType.Normal
											&& !getMap()
													.isEnabledDeathPenalty()) {
										pstm.setInt(11, 7);
										// normal zone
									} else if (!isInWarAreaAndWarTime(
											L1PcInstance.this, player)
											&& getZoneType() == ZoneType.Normal
											&& getMap().isEnabledDeathPenalty()) {
										pstm.setInt(11, 8);
									} else {
										pstm.setInt(11, 9);
									}
									pstm.execute();
									SQLUtil.close(pstm);
									SQLUtil.close(con);
								} catch (Exception e) {
									_log.log(Level.SEVERE,
											e.getLocalizedMessage(), e);
								}

							}
						}
					}
				} catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
			if (getMapId() == 5153) {
				L1DeathMatch.getInstance().sendRemainder(L1PcInstance.this);
			}
			if (lastAttacker != L1PcInstance.this) {
				if (getZoneType() != ZoneType.Normal) {
					L1PcInstance player = null;
					if (lastAttacker instanceof L1PcInstance) {
						player = (L1PcInstance) lastAttacker;
					} else if (lastAttacker instanceof L1PetInstance) {
						player = (L1PcInstance) ((L1PetInstance) lastAttacker)
								.getMaster();
					} else if (lastAttacker instanceof L1SummonInstance) {
						player = (L1PcInstance) ((L1SummonInstance) lastAttacker)
								.getMaster();
					}
					if (player != null) {
						if (!isInWarAreaAndWarTime(L1PcInstance.this, player)) {
							return;
						}
					}
				}

				boolean sim_ret = simWarResult(lastAttacker);
				if (sim_ret == true) {
					return;
				}
			}

			if (!getMap().isEnabledDeathPenalty()) {
				return;
			}

			L1PcInstance fightPc = null;
			if (lastAttacker instanceof L1PcInstance) {
				fightPc = (L1PcInstance) lastAttacker;
			}
			if (fightPc != null) {
				if (getFightId() == fightPc.getId()
						&& fightPc.getFightId() == getId()) { //
					setFightId(0);
					sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL, 0, 0));
					fightPc.setFightId(0);
					fightPc.sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL,
							0, 0));
					return;
				}
			}

			deathPenalty(); //

			setGresValid(true);

			if (getExpRes() == 0) {
				setExpRes(1);
			}

			if (lastAttacker instanceof L1GuardInstance) {
				if (get_PKcount() > 0) {
					set_PKcount(get_PKcount() - 1);
				}
				setLastPk(null);
			}
			if (lastAttacker instanceof L1GuardianInstance) {
				if (getPkCountForElf() > 0) {
					setPkCountForElf(getPkCountForElf() - 1);
				}
				setLastPkForElf(null);
			}

			int lostRate = (int) (((getLawful() + 32768D) / 1000D - 65D) * 4D);
			if (lostRate < 0) {
				lostRate *= -1;
				if (getLawful() < 0) {
					lostRate *= 2;
				}
				int rnd = _random.nextInt(1000) + 1;
				if (rnd <= lostRate) {
					int count = 1;
					if (getLawful() <= -30000) {
						count = _random.nextInt(4) + 1;
					} else if (getLawful() <= -20000) {
						count = _random.nextInt(3) + 1;
					} else if (getLawful() <= -10000) {
						count = _random.nextInt(2) + 1;
					} else if (getLawful() < 0) {
						count = _random.nextInt(1) + 1;
					}
					caoPenaltyResult(count);
				}
			}

			boolean castle_ret = castleWarResult();
			if (castle_ret == true) {
				return;
			}

			L1PcInstance player = null;
			if (lastAttacker instanceof L1PcInstance) {
				player = (L1PcInstance) lastAttacker;
			}
			if (player != null) {
				if (getLawful() >= 0 && isPinkName() == false) {
					boolean isChangePkCount = false;
					boolean isChangePkCountForElf = false;
					if (player.getLawful() < 30000) {
						player.set_PKcount(player.get_PKcount() + 1);
						isChangePkCount = true;
						if (player.isElf() && isElf()) {
							player.setPkCountForElf(player.getPkCountForElf() + 1);
							isChangePkCountForElf = true;
						}
					}
					player.setLastPk();
					if (player.isElf() && isElf()) {
						player.setLastPkForElf();
					}

					int lawful;

					if (player.getLevel() < 50) {
						lawful = -1
								* (int) ((Math.pow(player.getLevel(), 2) * 4));
					} else {
						lawful = -1
								* (int) ((Math.pow(player.getLevel(), 3) * 0.08));
					}
					if ((player.getLawful() - 1000) < lawful) {
						lawful = player.getLawful() - 1000;
					}

					if (lawful <= -32768) {
						lawful = -32768;
					}
					player.setLawful(lawful);

					sendAndBroadcast(new S_Lawful(player.getId(),
							player.getLawful()));

					if (isChangePkCount && player.get_PKcount() >= 5
							&& player.get_PKcount() < 10) {
						player.sendPackets(new S_BlueMessage(551, String
								.valueOf(player.get_PKcount()), "10"));
					} else if (isChangePkCount && player.get_PKcount() >= 10) {
						player.beginHell(true);
					}
				} else {
					setPinkName(false);
				}
			}
			_pcDeleteTimer = new L1PcDeleteTimer(L1PcInstance.this);
			_pcDeleteTimer.begin();
		}
	}

	public void stopPcDeleteTimer() {
		if (_pcDeleteTimer != null) {
			_pcDeleteTimer.cancel();
			_pcDeleteTimer = null;
		}
	}

	private void caoPenaltyResult(int count) {
		for (int i = 0; i < count; i++) {
			L1ItemInstance item = getInventory().CaoPenalty();

			if (item != null) {
				getInventory().tradeItem(
						item,
						item.isStackable() ? item.getCount() : 1,
						L1World.getInstance().getInventory(getX(), getY(),
								getMapId()));
				sendPackets(new S_ServerMessage(638, item.getLogName()));
			} else {
			}
		}
	}

	public boolean castleWarResult() {
		if (getClanid() != 0 && isCrown()) {
			L1Clan clan = L1World.getInstance().getClan(getClanname());
			for (L1War war : L1World.getInstance().getWarList()) {
				int warType = war.GetWarType();
				boolean isInWar = war.CheckClanInWar(getClanname());
				boolean isAttackClan = war.CheckAttackClan(getClanname());
				if (getId() == clan.getLeaderId() && warType == 1 && isInWar
						&& isAttackClan) {
					String enemyClanName = war.GetEnemyClanName(getClanname());
					if (enemyClanName != null) {
						war.CeaseWar(getClanname(), enemyClanName);
					}
					break;
				}
			}
		}

		int castleId = 0;
		boolean isNowWar = false;
		castleId = L1CastleLocation.getCastleIdByArea(this);
		if (castleId != 0) {
			isNowWar = WarTimeController.getInstance().isNowWar(castleId);
		}
		return isNowWar;
	}

	public boolean simWarResult(L1Character lastAttacker) {
		if (getClanid() == 0) {
			return false;
		}
		if (Config.SIM_WAR_PENALTY) {
			return false;
		}
		L1PcInstance attacker = null;
		String enemyClanName = null;
		boolean sameWar = false;

		if (lastAttacker instanceof L1PcInstance) {
			attacker = (L1PcInstance) lastAttacker;
		} else if (lastAttacker instanceof L1PetInstance) {
			attacker = (L1PcInstance) ((L1PetInstance) lastAttacker)
					.getMaster();
		} else if (lastAttacker instanceof L1SummonInstance) {
			attacker = (L1PcInstance) ((L1SummonInstance) lastAttacker)
					.getMaster();
		} else {
			return false;
		}

		for (L1War war : L1World.getInstance().getWarList()) {
			L1Clan clan = L1World.getInstance().getClan(getClanname());

			int warType = war.GetWarType();
			boolean isInWar = war.CheckClanInWar(getClanname());
			if (attacker != null && attacker.getClanid() != 0) {
				sameWar = war.CheckClanInSameWar(getClanname(),
						attacker.getClanname());
			}

			if (getId() == clan.getLeaderId() && warType == 2
					&& isInWar == true) {
				enemyClanName = war.GetEnemyClanName(getClanname());
				if (enemyClanName != null) {
					war.CeaseWar(getClanname(), enemyClanName); //
				}
			}

			if (warType == 2 && sameWar) {
				return true;
			}
		}
		return false;
	}

	public void resExp() {
		int oldLevel = getLevel();
		int needExp = ExpTable.getNeedExpNextLevel(oldLevel);
		int exp = 0;
		if (oldLevel < 45) {
			exp = (int) (needExp * 0.05);
		} else if (oldLevel == 45) {
			exp = (int) (needExp * 0.045);
		} else if (oldLevel == 46) {
			exp = (int) (needExp * 0.04);
		} else if (oldLevel == 47) {
			exp = (int) (needExp * 0.035);
		} else if (oldLevel == 48) {
			exp = (int) (needExp * 0.03);
			// Modified to scale down the XP death loss % at higher lvls.
		} else if (oldLevel >= 49 && oldLevel < 65) {
			exp = (int) (needExp * 0.025);
		} else if (oldLevel >= 65 && oldLevel < 70) {
			exp = (int) (needExp * 0.0125);
		} else if (oldLevel >= 65 && oldLevel < 75) {
			exp = (int) (needExp * 0.00625);
		} else if (oldLevel >= 75 && oldLevel < 79) {
			exp = (int) (needExp * 0.003125);
		} else if (oldLevel >= 79 && oldLevel < 80) {
			exp = (int) (needExp * 0.0015625);
		} else if (oldLevel >= 80) {
			exp = (int) (needExp * 0.00078125);
		}

		if (exp == 0) {
			return;
		}
		addExp(exp);
	}

	public void deathPenalty() {
		int oldLevel = getLevel();
		int needExp = ExpTable.getNeedExpNextLevel(oldLevel);
		int exp = 0;
		if (oldLevel >= 1 && oldLevel < 11) {
			exp = 0;
		} else if (oldLevel >= 11 && oldLevel < 45) {
			exp = (int) (needExp * 0.1);
		} else if (oldLevel == 45) {
			exp = (int) (needExp * 0.09);
		} else if (oldLevel == 46) {
			exp = (int) (needExp * 0.08);
		} else if (oldLevel == 47) {
			exp = (int) (needExp * 0.07);
		} else if (oldLevel == 48) {
			exp = (int) (needExp * 0.06);
			// Modified to scale down the XP death loss % at higher lvls.
		} else if (oldLevel >= 49 && oldLevel < 65) {
			exp = (int) (needExp * 0.05);
		} else if (oldLevel >= 65 && oldLevel < 70) {
			exp = (int) (needExp * 0.025);
		} else if (oldLevel >= 65 && oldLevel < 75) {
			exp = (int) (needExp * 0.0125);
		} else if (oldLevel >= 75 && oldLevel < 79) {
			exp = (int) (needExp * 0.00625);
		} else if (oldLevel >= 79 && oldLevel < 80) {
			exp = (int) (needExp * 0.003125);
		} else if (oldLevel >= 80) {
			exp = (int) (needExp * 0.0015625);
		}

		if (exp == 0) {
			return;
		}
		addExp(-exp);
		// Explicitly checking to close an abusable delvling bug. If a
		// player dies but disconnects before the exp monitor runs again
		// characters can effectively delevel (because his or here level will
		// be recalculated based on experience as part of the next login)
		// without
		// going through the delevel code, allowing them to repeatedly gain
		// hitpoints/manapoints from leveling.
		onChangeExp();
	}

	private int _originalEr = 0; // ER

	public int getOriginalEr() {
		return _originalEr;
	}

	public int getEr() {
		if (hasSkillEffect(STRIKER_GALE)) {
			return 0;
		}

		int er = getClassFeature().getER(getLevel());

		er += (getDex() - 8) / 2;

		er += getOriginalEr();

		if (hasSkillEffect(DRESS_EVASION)) {
			er += 12;
		}
		if (hasSkillEffect(SOLID_CARRIAGE)) {
			er += 15;
		}
		return er;
	}

	public L1BookMark getBookMark(String name) {
		for (int i = 0; i < _bookmarks.size(); i++) {
			L1BookMark element = _bookmarks.get(i);
			if (element.getName().equalsIgnoreCase(name)) {
				return element;
			}

		}
		return null;
	}

	public L1BookMark getBookMark(int id) {
		for (int i = 0; i < _bookmarks.size(); i++) {
			L1BookMark element = _bookmarks.get(i);
			if (element.getId() == id) {
				return element;
			}

		}
		return null;
	}

	public int getBookMarkSize() {
		return _bookmarks.size();
	}

	public void addBookMark(L1BookMark book) {
		_bookmarks.add(book);
	}

	public void removeBookMark(L1BookMark book) {
		_bookmarks.remove(book);
	}

	public L1ItemInstance getWeapon() {
		return _weapon;
	}

	public void setWeapon(L1ItemInstance weapon) {
		_weapon = weapon;
	}

	public L1Quest getQuest() {
		return _quest;
	}

	public boolean isCrown() {
		return L1ClassId.isRoyal(getClassId());
	}

	public boolean isKnight() {
		return L1ClassId.isKnight(getClassId());
	}

	public boolean isElf() {
		return L1ClassId.isElf(getClassId());
	}

	public boolean isWizard() {
		return L1ClassId.isMage(getClassId());
	}

	public boolean isDarkelf() {
		return L1ClassId.isDarkElf(getClassId());
	}

	public boolean isDragonKnight() {
		return L1ClassId.isDragonKnight(getClassId());
	}

	public boolean isIllusionist() {
		return L1ClassId.isIllusionist(getClassId());
	}

	private static Logger _log = Logger.getLogger(L1PcInstance.class.getName());
	private ClientThread _netConnection;
	private int _classId;
	private int _type;
	private int _exp;
	private final L1Karma _karma = new L1Karma();
	private boolean _gm;
	private boolean _monitor;
	private boolean _gmInvis;
	private short _accessLevel;
	private int _currentWeapon;
	private final L1PcInventory _inventory;
	private final L1DwarfInventory _dwarf;
	private final L1DwarfForElfInventory _dwarfForElf;
	private final L1Inventory _tradewindow;
	private L1ItemInstance _weapon;
	private L1Party _party;
	private L1ChatParty _chatParty;
	private int _partyID;
	private int _tradeID;
	private boolean _tradeOk;
	private int _tempID;
	private boolean _isTeleport = false;
	private boolean _isDrink = false;
	private boolean _isGres = false;
	private boolean _isPinkName = false;
	private final ArrayList<L1BookMark> _bookmarks;
	private L1Quest _quest;
	private MpRegeneration _mpRegen;
	private MpRegenerationByDoll _mpRegenByDoll;
	private MpReductionByAwake _mpReductionByAwake;
	private HpRegeneration _hpRegen;
	private static Timer _regenTimer = new Timer(true);
	private boolean _mpRegenActive;
	private boolean _mpRegenActiveByDoll;
	private boolean _mpReductionActiveByAwake;
	private boolean _hpRegenActive;
	private L1EquipmentSlot _equipSlot;
	private L1PcDeleteTimer _pcDeleteTimer;

	private String _accountName;

	public String getAccountName() {
		return _accountName;
	}

	public void setAccountName(String s) {
		_accountName = s;
	}

	private short _baseMaxHp = 0;

	public short getBaseMaxHp() {
		return _baseMaxHp;
	}

	public void addBaseMaxHp(short i) {
		i += _baseMaxHp;
		if (i >= 32767) {
			i = 32767;
		} else if (i < 1) {
			i = 1;
		}
		addMaxHp(i - _baseMaxHp);
		_baseMaxHp = i;
	}

	private short _baseMaxMp = 0;

	public short getBaseMaxMp() {
		return _baseMaxMp;
	}

	public void addBaseMaxMp(short i) {
		i += _baseMaxMp;
		if (i >= 32767) {
			i = 32767;
		} else if (i < 0) {
			i = 0;
		}
		addMaxMp(i - _baseMaxMp);
		_baseMaxMp = i;
	}

	private int _baseAc = 0;

	public int getBaseAc() {
		return _baseAc;
	}

	private int _originalAc = 0;

	public int getOriginalAc() {
		return _originalAc;
	}

	private byte _baseStr = 0;

	public byte getBaseStr() {
		return _baseStr;
	}

	public void setBaseStr(byte i) {
		_baseStr = i;
		setStr(i);
	}

	public void addBaseStr(byte i) {
		i += _baseStr;
		if (i >= 127) {
			i = 127;
		} else if (i < 1) {
			i = 1;
		}
		addStr((byte) (i - _baseStr));
		_baseStr = i;
	}

	private byte _baseCon = 0;

	public byte getBaseCon() {
		return _baseCon;
	}

	public void setBaseCon(byte i) {
		_baseCon = i;
		setCon(i);
	}

	public void addBaseCon(byte i) {
		i += _baseCon;
		if (i >= 127) {
			i = 127;
		} else if (i < 1) {
			i = 1;
		}
		addCon((byte) (i - _baseCon));
		_baseCon = i;
	}

	private byte _baseDex = 0;

	public byte getBaseDex() {
		return _baseDex;
	}

	public void setBaseDex(byte i) {
		_baseDex = i;
		setDex(i);
	}

	public void addBaseDex(byte i) {
		i += _baseDex;
		if (i >= 127) {
			i = 127;
		} else if (i < 1) {
			i = 1;
		}
		addDex((byte) (i - _baseDex));
		_baseDex = i;
	}

	private byte _baseCha = 0;

	public byte getBaseCha() {
		return _baseCha;
	}

	public void setBaseCha(byte i) {
		_baseCha = i;
		setCha(i);
	}

	public void addBaseCha(byte i) {
		i += _baseCha;
		if (i >= 127) {
			i = 127;
		} else if (i < 1) {
			i = 1;
		}
		addCha((byte) (i - _baseCha));
		_baseCha = i;
	}

	private byte _baseInt = 0;

	public byte getBaseInt() {
		return _baseInt;
	}

	public void setBaseInt(byte i) {
		_baseInt = i;
		setInt(i);
	}

	public void addBaseInt(byte i) {
		i += _baseInt;
		if (i >= 127) {
			i = 127;
		} else if (i < 1) {
			i = 1;
		}
		addInt((byte) (i - _baseInt));
		_baseInt = i;
	}

	private byte _baseWis = 0;

	public byte getBaseWis() {
		return _baseWis;
	}

	public void setBaseWis(byte i) {
		_baseWis = i;
		setWis(i);
	}

	public void addBaseWis(byte i) {
		i += _baseWis;
		if (i >= 127) {
			i = 127;
		} else if (i < 1) {
			i = 1;
		}
		addWis((byte) (i - _baseWis));
		_baseWis = i;
	}

	private int _originalStr = 0;

	public int getOriginalStr() {
		return _originalStr;
	}

	public void setOriginalStr(int i) {
		_originalStr = i;
	}

	private int _originalCon = 0;

	public int getOriginalCon() {
		return _originalCon;
	}

	public void setOriginalCon(int i) {
		_originalCon = i;
	}

	private int _originalDex = 0;

	public int getOriginalDex() {
		return _originalDex;
	}

	public void setOriginalDex(int i) {
		_originalDex = i;
	}

	private int _originalCha = 0;

	public int getOriginalCha() {
		return _originalCha;
	}

	public void setOriginalCha(int i) {
		_originalCha = i;
	}

	private int _originalInt = 0;

	public int getOriginalInt() {
		return _originalInt;
	}

	public void setOriginalInt(int i) {
		_originalInt = i;
	}

	private int _originalWis = 0;

	public int getOriginalWis() {
		return _originalWis;
	}

	public void setOriginalWis(int i) {
		_originalWis = i;
	}

	private int _originalDmgup = 0;

	public int getOriginalDmgup() {
		return _originalDmgup;
	}

	private int _originalBowDmgup = 0;

	public int getOriginalBowDmgup() {
		return _originalBowDmgup;
	}

	private int _originalHitup = 0;

	public int getOriginalHitup() {
		return _originalHitup;
	}

	private int _originalBowHitup = 0;

	public int getOriginalBowHitup() {
		return _originalHitup;
	}

	private int _originalMr = 0;

	public int getOriginalMr() {
		return _originalMr;
	}

	private int _originalMagicHit = 0;

	public int getOriginalMagicHit() {
		return _originalMagicHit;
	}

	private int _originalMagicCritical = 0;

	public int getOriginalMagicCritical() {
		return _originalMagicCritical;
	}

	private int _originalMagicConsumeReduction = 0;

	public int getOriginalMagicConsumeReduction() {
		return _originalMagicConsumeReduction;
	}

	private int _originalMagicDamage = 0;

	public int getOriginalMagicDamage() {
		return _originalMagicDamage;
	}

	private int _originalHpup = 0;

	public int getOriginalHpup() {
		return _originalHpup;
	}

	private int _originalMpup = 0;

	public int getOriginalMpup() {
		return _originalMpup;
	}

	private int _baseDmgup = 0;

	public int getBaseDmgup() {
		return _baseDmgup;
	}

	private int _baseBowDmgup = 0;

	public int getBaseBowDmgup() {
		return _baseBowDmgup;
	}

	private int _baseHitup = 0;

	public int getBaseHitup() {
		return _baseHitup;
	}

	private int _baseBowHitup = 0;

	public int getBaseBowHitup() {
		return _baseBowHitup;
	}

	private int _baseMr = 0;

	public int getBaseMr() {
		return _baseMr;
	}

	private int _advenHp;

	public int getAdvenHp() {
		return _advenHp;
	}

	public void setAdvenHp(int i) {
		_advenHp = i;
	}

	private int _advenMp;

	public int getAdvenMp() {
		return _advenMp;
	}

	public void setAdvenMp(int i) {
		_advenMp = i;
	}

	private int _highLevel;

	public int getHighLevel() {
		return _highLevel;
	}

	public void setHighLevel(int i) {
		_highLevel = i;
	}

	private int _bonusStats;

	public synchronized int getBonusStats() {
		return _bonusStats;
	}

	public synchronized void setBonusStats(int i) {
		_bonusStats = i;
	}

	private int _elixirStats;

	public int getElixirStats() {
		return _elixirStats;
	}

	public void setElixirStats(int i) {
		_elixirStats = i;
	}

	private int _elfAttr;

	public int getElfAttr() {
		return _elfAttr;
	}

	public void setElfAttr(int i) {
		_elfAttr = i;
	}

	private int _expRes;

	public int getExpRes() {
		return _expRes;
	}

	public void setExpRes(int i) {
		_expRes = i;
	}

	private int _partnerId;

	public int getPartnerId() {
		return _partnerId;
	}

	public void setPartnerId(int i) {
		_partnerId = i;
	}

	private int _onlineStatus;

	public int getOnlineStatus() {
		return _onlineStatus;
	}

	public void setOnlineStatus(int i) {
		_onlineStatus = i;
	}

	private int _homeTownId;

	public int getHomeTownId() {
		return _homeTownId;
	}

	public void setHomeTownId(int i) {
		_homeTownId = i;
	}

	private int _contribution;

	public int getContribution() {
		return _contribution;
	}

	public void setContribution(int i) {
		_contribution = i;
	}

	private int _hellTime;

	public int getHellTime() {
		return _hellTime;
	}

	public void setHellTime(int i) {
		_hellTime = i;
	}

	private boolean _banned;

	public boolean isBanned() {
		return _banned;
	}

	public void setBanned(boolean flag) {
		_banned = flag;
	}

	private int _food;

	public int get_food() {
		return _food;
	}

	public void set_food(int i) {
		_food = i;
	}

	public L1EquipmentSlot getEquipSlot() {
		return _equipSlot;
	}

	public static L1PcInstance load(String charName) {
		L1PcInstance result = null;
		try {
			result = CharacterTable.getInstance().loadCharacter(charName);
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return result;
	}

	public void save() throws Exception {
		if (isGhost()) {
			return;
		}
		if (isInCharReset()) {
			return;
		}

		CharacterTable.getInstance().storeCharacter(this);
		// added Pets saving here
		for (L1PetInstance pet : L1World.getInstance().getAllPets()) {
			if (getName().toLowerCase().equals(
					pet.getMaster().getName().toLowerCase())) {
				pet.save();
			}
		}
	}

	public void saveInventory() {
		for (L1ItemInstance item : getInventory().getItems()) {
			getInventory().saveItem(item, item.getRecordingColumns());
		}
	}

	public static final int REGENSTATE_NONE = 4;
	public static final int REGENSTATE_MOVE = 2;
	public static final int REGENSTATE_ATTACK = 1;

	public void setRegenState(int state) {
		_mpRegen.setState(state);
		_hpRegen.setState(state);
	}

	public double getMaxWeight() {
		int str = getStr();
		int con = getCon();
		double maxWeight = 150 * (Math.floor(0.6 * str + 0.4 * con + 1));

		double weightReductionByArmor = getWeightReduction();
		weightReductionByArmor /= 100;

		double weightReductionByDoll = 0;
		Object[] dollList = getDollList().values().toArray();
		for (Object dollObject : dollList) {
			L1DollInstance doll = (L1DollInstance) dollObject;
			weightReductionByDoll += doll.getWeightReductionByDoll();
		}
		weightReductionByDoll /= 100;

		int weightReductionByMagic = hasSkillEffect(DECREASE_WEIGHT) ? 180 : 0;

		double originalWeightReduction = 0.04 * (getOriginalStrWeightReduction() + getOriginalConWeightReduction());

		double weightReduction = 1 + weightReductionByArmor
				+ weightReductionByDoll + originalWeightReduction;

		maxWeight *= weightReduction;

		maxWeight += weightReductionByMagic;

		maxWeight *= Config.RATE_WEIGHT_LIMIT;

		return maxWeight;
	}

	public boolean isFastMovable() {
		return (hasSkillEffect(HOLY_WALK)
				|| hasSkillEffect(MOVING_ACCELERATION)
				|| hasSkillEffect(WIND_WALK) || hasSkillEffect(STATUS_RIBRAVE));
	}

	public boolean isFastAttackable() {
		return hasSkillEffect(BLOODLUST);
	}

	public boolean isBrave() {
		return hasSkillEffect(STATUS_BRAVE);
	}

	public boolean isElfBrave() {
		return hasSkillEffect(STATUS_ELFBRAVE);
	}

	public boolean isHaste() {
		return (hasSkillEffect(STATUS_HASTE) || hasSkillEffect(HASTE)
				|| hasSkillEffect(GREATER_HASTE) || getMoveSpeed() == 1);
	}

	private int invisDelayCounter = 0;

	public boolean isInvisDelay() {
		return (invisDelayCounter > 0);
	}

	private Object _invisTimerMonitor = new Object();

	public void addInvisDelayCounter(int counter) {
		synchronized (_invisTimerMonitor) {
			invisDelayCounter += counter;
		}
	}

	private static final long DELAY_INVIS = 3000L;

	public void beginInvisTimer() {
		addInvisDelayCounter(1);
		GeneralThreadPool.getInstance().pcSchedule(new L1PcInvisDelay(getId()),
				DELAY_INVIS);
	}

	public synchronized void addExp(int exp) {
		_exp += exp;
		if (_exp > ExpTable.MAX_EXP) {
			_exp = ExpTable.MAX_EXP;
		}
	}

	public synchronized void addContribution(int contribution) {
		_contribution += contribution;
	}

	public void beginExpMonitor() {
		_expMonitorFuture = GeneralThreadPool.getInstance()
				.pcScheduleAtFixedRate(new L1PcExpMonitor(getId()), 0L,
						INTERVAL_EXP_MONITOR);
	}

	private void levelUp(int gap) {
		resetLevel();

		if (getLevel() == 99 && Config.ALT_REVIVAL_POTION) {
			try {
				L1Item l1item = ItemTable.getInstance().getTemplate(43000);
				if (l1item != null) {
					getInventory().storeItem(43000, 1);
					sendPackets(new S_ServerMessage(403, l1item.getName()));
				} else {
					sendPackets(new S_SystemMessage(
							"You use Revival Potion and have returned to level 1."));
				}
			} catch (Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				sendPackets(new S_SystemMessage("Use of Revival Potion failed!"));
			}
		}

		for (int i = 0; i < gap; i++) {
			short randomHp = CalcStat.calcStatHp(getType(), getBaseMaxHp(),
					getBaseCon(), getOriginalHpup());
			short randomMp = CalcStat.calcStatMp(getType(), getBaseMaxMp(),
					getBaseWis(), getOriginalMpup());
			addBaseMaxHp(randomHp);
			addBaseMaxMp(randomMp);
		}
		resetBaseHitup();
		resetBaseDmgup();
		resetBaseAc();
		resetBaseMr();
		if (getLevel() > getHighLevel()) {
			setHighLevel(getLevel());
		}

		try {
			save();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		if (getLevel() >= 51 && getLevel() - 50 > getBonusStats()) {
			if ((getBaseStr() + getBaseDex() + getBaseCon() + getBaseInt()
					+ getBaseWis() + getBaseCha()) < 210) {
				sendPackets(new S_bonusstats(getId(), 1));
			}
		}
		// added hp/mp refill on lvl up
		setCurrentHp(getMaxHp());
		setCurrentMp(getMaxMp());

		sendPackets(new S_OwnCharStatus(this));

		if (getLevel() >= Config.NEWBIEMAPLEVELS) {
			if ((getMapId() == 68 || getMapId() == 69 || getMapId() == 2005
					|| getMapId() == 85 || getMapId() == 86)) {
				L1Teleport.teleport(this, 32580, 32931, (short) 0, 3, true); // Talking
																				// Island
			}
			if (getLevel() >= 52) {
				if (getMapId() == 777) {
					L1Teleport.teleport(this, 34043, 32184, (short) 4, 5, true);
				} else if (getMapId() == 778 || getMapId() == 779) {
					L1Teleport.teleport(this, 32608, 33178, (short) 4, 5, true);
				}
			}
		}
	}

	private void levelDown(int gap) {
		resetLevel();

		for (int i = 0; i > gap; i--) {
			short randomHp = CalcStat.calcStatHp(getType(), 0, getBaseCon(),
					getOriginalHpup());
			short randomMp = CalcStat.calcStatMp(getType(), 0, getBaseWis(),
					getOriginalMpup());
			addBaseMaxHp((short) -randomHp);
			addBaseMaxMp((short) -randomMp);
		}
		resetBaseHitup();
		resetBaseDmgup();
		resetBaseAc();
		resetBaseMr();
		if (Config.LEVEL_DOWN_RANGE != 0) {
			if (getHighLevel() - getLevel() >= Config.LEVEL_DOWN_RANGE) {
				sendPackets(new S_ServerMessage(64));
				sendPackets(new S_Disconnect());
				_log.info("levelDown error:"
						+ String.format("x_Ee%sfB", getName()));
			}
		}

		try {
			save();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		sendPackets(new S_OwnCharStatus(this));
	}

	public void beginGameTimeCarrier() {
		new L1GameTimeCarrier(this).start();
	}

	private boolean _ghost = false;

	public boolean isGhost() {
		return _ghost;
	}

	private void setGhost(boolean flag) {
		_ghost = flag;
	}

	private boolean _ghostCanTalk = true;

	public boolean isGhostCanTalk() {
		return _ghostCanTalk;
	}

	private void setGhostCanTalk(boolean flag) {
		_ghostCanTalk = flag;
	}

	private boolean _isReserveGhost = false; //

	public boolean isReserveGhost() {
		return _isReserveGhost;
	}

	private void setReserveGhost(boolean flag) {
		_isReserveGhost = flag;
	}

	public void beginGhost(int locx, int locy, short mapid, boolean canTalk) {
		beginGhost(locx, locy, mapid, canTalk, 0);
	}

	public void beginGhost(int locx, int locy, short mapid, boolean canTalk,
			int sec) {
		if (isGhost()) {
			return;
		}
		setGhost(true);
		_ghostSaveLocX = getX();
		_ghostSaveLocY = getY();
		_ghostSaveMapId = getMapId();
		_ghostSaveHeading = getHeading();
		setGhostCanTalk(canTalk);
		L1Teleport.teleport(this, locx, locy, mapid, 5, true);
		if (sec > 0) {
			_ghostFuture = GeneralThreadPool.getInstance().pcSchedule(
					new L1PcGhostMonitor(getId()), sec * 1000);
		}
	}

	public void makeReadyEndGhost() {
		setReserveGhost(true);
		L1Teleport.teleport(this, _ghostSaveLocX, _ghostSaveLocY,
				_ghostSaveMapId, _ghostSaveHeading, true);
	}

	public void endGhost() {
		setGhost(false);
		setGhostCanTalk(true);
		setReserveGhost(false);
	}

	private ScheduledFuture<?> _ghostFuture;

	private int _ghostSaveLocX = 0;
	private int _ghostSaveLocY = 0;
	private short _ghostSaveMapId = 0;
	private int _ghostSaveHeading = 0;

	private ScheduledFuture<?> _hellFuture;

	public void beginHell(boolean isFirst) {
		if (getMapId() != 666) {
			int locx = 32701;
			int locy = 32777;
			short mapid = 666;
			L1Teleport.teleport(this, locx, locy, mapid, 5, false);
		}

		if (isFirst) {
			if (get_PKcount() <= 10) {
				setHellTime(300);
			} else {
				setHellTime(300 * (get_PKcount() - 10) + 300);
			}
			sendPackets(new S_BlueMessage(552, String.valueOf(get_PKcount()),
					String.valueOf(getHellTime() / 60)));
		} else {
			sendPackets(new S_BlueMessage(637, String.valueOf(getHellTime())));
		}
		if (_hellFuture == null) {
			_hellFuture = GeneralThreadPool.getInstance()
					.pcScheduleAtFixedRate(new L1PcHellMonitor(getId()), 0L,
							1000L);
		}
	}

	public void endHell() {
		if (_hellFuture != null) {
			_hellFuture.cancel(false);
			_hellFuture = null;
		}
		int[] loc = L1TownLocation
				.getGetBackLoc(L1TownLocation.TOWNID_ORCISH_FOREST);
		L1Teleport.teleport(this, loc[0], loc[1], (short) loc[2], 5, true);
		try {
			save();
		} catch (Exception ignore) {
			// ignore
		}
	}

	@Override
	public void setPoisonEffect(int effectId) {
		sendPackets(new S_Poison(getId(), effectId));

		if (!isGmInvis() && !isGhost() && !isInvisble()) {
			broadcastPacket(new S_Poison(getId(), effectId));
		}
		if (isGmInvis() || isGhost()) {
		} else if (isInvisble()) {
			broadcastPacketForFindInvis(new S_Poison(getId(), effectId), true);
		} else {
			broadcastPacket(new S_Poison(getId(), effectId));
		}
	}

	@Override
	public void healHp(int pt) {
		super.healHp(pt);

		sendPackets(new S_HPUpdate(this));
	}

	@Override
	public int getKarma() {
		return _karma.get();
	}

	@Override
	public void setKarma(int i) {
		_karma.set(i);
	}

	public void addKarma(int i) {
		synchronized (_karma) {
			_karma.add(i);
		}
	}

	public int getKarmaLevel() {
		return _karma.getLevel();
	}

	public int getKarmaPercent() {
		return _karma.getPercent();
	}

	private Timestamp _lastPk;

	public Timestamp getLastPk() {
		return _lastPk;
	}

	public void setLastPk(Timestamp time) {
		_lastPk = time;
	}

	public void setLastPk() {
		_lastPk = new Timestamp(System.currentTimeMillis());
	}

	public boolean isWanted() {
		if (_lastPk == null) {
			return false;
		} else if (System.currentTimeMillis() - _lastPk.getTime() > 24 * 3600 * 1000) {
			setLastPk(null);
			return false;
		}
		return true;
	}

	private Timestamp _lastPkForElf;

	public Timestamp getLastPkForElf() {
		return _lastPkForElf;
	}

	public void setLastPkForElf(Timestamp time) {
		_lastPkForElf = time;
	}

	public void setLastPkForElf() {
		_lastPkForElf = new Timestamp(System.currentTimeMillis());
	}

	public boolean isWantedForElf() {
		if (_lastPkForElf == null) {
			return false;
		} else if (System.currentTimeMillis() - _lastPkForElf.getTime() > 24 * 3600 * 1000) {
			setLastPkForElf(null);
			return false;
		}
		return true;
	}

	private Timestamp _deleteTime;

	public Timestamp getDeleteTime() {
		return _deleteTime;
	}

	public void setDeleteTime(Timestamp time) {
		_deleteTime = time;
	}

	@Override
	public int getMagicLevel() {
		return getClassFeature().getMagicLevel(getLevel());
	}

	private int _weightReduction = 0;

	public int getWeightReduction() {
		return _weightReduction;
	}

	public void addWeightReduction(int i) {
		_weightReduction += i;
	}

	private int _originalStrWeightReduction = 0;

	public int getOriginalStrWeightReduction() {
		return _originalStrWeightReduction;
	}

	private int _originalConWeightReduction = 0;

	public int getOriginalConWeightReduction() {
		return _originalConWeightReduction;
	}

	private int _hasteItemEquipped = 0;

	public int getHasteItemEquipped() {
		return _hasteItemEquipped;
	}

	public void addHasteItemEquipped(int i) {
		_hasteItemEquipped += i;
	}

	public void removeHasteSkillEffect() {
		if (hasSkillEffect(SLOW)) {
			removeSkillEffect(SLOW);
		}
		if (hasSkillEffect(MASS_SLOW)) {
			removeSkillEffect(MASS_SLOW);
		}
		if (hasSkillEffect(ENTANGLE)) {
			removeSkillEffect(ENTANGLE);
		}
		if (hasSkillEffect(HASTE)) {
			removeSkillEffect(HASTE);
		}
		if (hasSkillEffect(GREATER_HASTE)) {
			removeSkillEffect(GREATER_HASTE);
		}
		if (hasSkillEffect(STATUS_HASTE)) {
			removeSkillEffect(STATUS_HASTE);
		}
	}

	private int _damageReductionByArmor = 0;

	public int getDamageReductionByArmor() {
		return _damageReductionByArmor;
	}

	public void addDamageReductionByArmor(int i) {
		_damageReductionByArmor += i;
	}

	private int _hitModifierByArmor = 0;

	public int getHitModifierByArmor() {
		return _hitModifierByArmor;
	}

	public void addHitModifierByArmor(int i) {
		_hitModifierByArmor += i;
	}

	private int _dmgModifierByArmor = 0;

	public int getDmgModifierByArmor() {
		return _dmgModifierByArmor;
	}

	public void addDmgModifierByArmor(int i) {
		_dmgModifierByArmor += i;
	}

	private int _bowHitModifierByArmor = 0;

	public int getBowHitModifierByArmor() {
		return _bowHitModifierByArmor;
	}

	public void addBowHitModifierByArmor(int i) {
		_bowHitModifierByArmor += i;
	}

	private int _bowDmgModifierByArmor = 0;

	public int getBowDmgModifierByArmor() {
		return _bowDmgModifierByArmor;
	}

	public void addBowDmgModifierByArmor(int i) {
		_bowDmgModifierByArmor += i;
	}

	private boolean _gresValid;

	private void setGresValid(boolean valid) {
		_gresValid = valid;
	}

	public boolean isGresValid() {
		return _gresValid;
	}

	private long _fishingTime = 0;

	public long getFishingTime() {
		return _fishingTime;
	}

	public void setFishingTime(long i) {
		_fishingTime = i;
	}

	private boolean _isFishing = false;

	public boolean isFishing() {
		return _isFishing;
	}

	public void setFishing(boolean flag) {
		_isFishing = flag;
	}

	private boolean _isFishingReady = false;

	public boolean isFishingReady() {
		return _isFishingReady;
	}

	public void setFishingReady(boolean flag) {
		_isFishingReady = flag;
	}

	private int _cookingId = 0;

	public int getCookingId() {
		return _cookingId;
	}

	public void setCookingId(int i) {
		_cookingId = i;
	}

	private int _dessertId = 0;

	public int getDessertId() {
		return _dessertId;
	}

	public void setDessertId(int i) {
		_dessertId = i;
	}

	public void resetBaseDmgup() {
		int newBaseDmgup = 0;
		int newBaseBowDmgup = 0;
		if (isKnight() || isDarkelf() || isDragonKnight()) {
			newBaseDmgup = getLevel() / 10;
			newBaseBowDmgup = 0;
		} else if (isCrown() && Config.ROYAL_LEVEL_DAMAGE) {
			newBaseDmgup = getLevel() / 10;
			newBaseBowDmgup = 0;
		} else if (isElf()) {
			newBaseDmgup = 0;
			newBaseBowDmgup = getLevel() / 10;
		}
		addDmgup(newBaseDmgup - _baseDmgup);
		addBowDmgup(newBaseBowDmgup - _baseBowDmgup);
		_baseDmgup = newBaseDmgup;
		_baseBowDmgup = newBaseBowDmgup;
	}

	public void resetBaseHitup() {
		int newBaseHitup = 0;
		int newBaseBowHitup = 0;
		if (isCrown() || isElf() || isIllusionist()) {
			newBaseHitup = getLevel() / 5;
			newBaseBowHitup = getLevel() / 5;
		} else if (isKnight() || isDarkelf() || isDragonKnight()) {
			newBaseHitup = getLevel() / 3;
			newBaseBowHitup = getLevel() / 3;
		}
		addHitup(newBaseHitup - _baseHitup);
		addBowHitup(newBaseBowHitup - _baseBowHitup);
		_baseHitup = newBaseHitup;
		_baseBowHitup = newBaseBowHitup;
	}

	public void resetBaseAc() {
		int newAc = CalcStat.calcAc(getLevel(), getBaseDex());
		addAc(newAc - _baseAc);
		_baseAc = newAc;
	}

	public void resetBaseMr() {
		int newMr = getClassFeature().getBaseMR()
				+ CalcStat.calcStatMr(getWis()) + getLevel() / 2;
		addMr(newMr - _baseMr);
		_baseMr = newMr;
	}

	public void resetLevel() {
		setLevel(ExpTable.getLevelByExp(_exp));

		if (_hpRegen != null) {
			_hpRegen.updateLevel();
		}
	}

	public void refresh() {
		resetLevel();
		resetBaseHitup();
		resetBaseDmgup();
		resetBaseAc();
		resetBaseMr();

		L1ClassFeature features = getClassFeature();
		_originalBowHitup = features.getOriginalRangedHit(getOriginalDex());
		_originalBowDmgup = features.getOriginalRangedDamage(getOriginalDex());
		_originalHpr = features.getOriginalHpRegen(getOriginalCon());
		_originalMpr = features.getOriginalMpRegen(getOriginalWis());
		_originalStrWeightReduction = features
				.getOriginalStrWeightReduction(getOriginalStr());
		_originalConWeightReduction = features
				.getOriginalConWeightReduction(getOriginalCon());
		_originalMagicHit = features.getOriginalMagicHit(getOriginalInt());
		_originalMagicDamage = features
				.getOriginalMagicDamage(getOriginalInt());
		_originalMagicConsumeReduction = features
				.getOriginalMpReduction(getOriginalInt());
		_originalMagicCritical = features
				.getOriginalMagicCrit(getOriginalInt());
		_originalEr = features.getOriginalER(getOriginalDex());
		_originalAc = features.getOriginalAC(getOriginalDex());
		addAc(0 - _originalAc);
		_originalMr = features.getOriginalMR(getOriginalWis());
		addMr(_originalMr);
		_originalHitup = features.getOriginalMeleeHit(getOriginalStr());
		_originalDmgup = features.getOriginalMeleeDamage(getOriginalStr());
		_originalHpup = features.getOriginalHpBonus(getOriginalCon());
		_originalMpup = features.getOriginalMpBonus(getOriginalWis());
	}

	private final L1ExcludingList _excludingList = new L1ExcludingList();

	public L1ExcludingList getExcludingList() {
		return _excludingList;
	}

	private final AcceleratorChecker _acceleratorChecker = new AcceleratorChecker(
			this);

	public AcceleratorChecker getAcceleratorChecker() {
		return _acceleratorChecker;
	}

	private int _teleportX = 0;

	public int getTeleportX() {
		return _teleportX;
	}

	public void setTeleportX(int i) {
		_teleportX = i;
	}

	private int _teleportY = 0;

	public int getTeleportY() {
		return _teleportY;
	}

	public void setTeleportY(int i) {
		_teleportY = i;
	}

	private short _teleportMapId = 0;

	public short getTeleportMapId() {
		return _teleportMapId;
	}

	public void setTeleportMapId(short i) {
		_teleportMapId = i;
	}

	private int _teleportHeading = 0;

	public int getTeleportHeading() {
		return _teleportHeading;
	}

	public void setTeleportHeading(int i) {
		_teleportHeading = i;
	}

	private int _tempCharGfxAtDead;

	public int getTempCharGfxAtDead() {
		return _tempCharGfxAtDead;
	}

	public void setTempCharGfxAtDead(int i) {
		_tempCharGfxAtDead = i;
	}

	private boolean _isCanWhisper = true;

	public boolean isCanWhisper() {
		return _isCanWhisper;
	}

	public void setCanWhisper(boolean flag) {
		_isCanWhisper = flag;
	}

	private boolean _showTradeChat = true;

	public boolean showTradeChat() {
		return _showTradeChat;
	}

	public void setShowTradeChat(boolean flag) {
		_showTradeChat = flag;
	}

	private boolean _showWorldChat = true;

	public boolean showWorldChat() {
		return _showWorldChat;
	}

	public void setShowWorldChat(boolean flag) {
		_showWorldChat = flag;
	}

	private int _fightId;

	public int getFightId() {
		return _fightId;
	}

	public void setFightId(int i) {
		_fightId = i;
	}

	private byte _chatCount = 0;
	private long _oldChatTimeInMillis = 0L;

	public void checkChatInterval() {
		long nowChatTimeInMillis = System.currentTimeMillis();
		if (_chatCount == 0) {
			_chatCount++;
			_oldChatTimeInMillis = nowChatTimeInMillis;
			return;
		}

		long chatInterval = nowChatTimeInMillis - _oldChatTimeInMillis;
		if (chatInterval > 2000) {
			_chatCount = 0;
			_oldChatTimeInMillis = 0;
		} else {
			if (_chatCount >= 3) {
				setSkillEffect(STATUS_CHAT_PROHIBITED, 120 * 1000);
				sendPackets(new S_SkillIconGFX(36, 120));
				sendPackets(new S_ServerMessage(153)); //
				_chatCount = 0;
				_oldChatTimeInMillis = 0;
			}
			_chatCount++;
		}
	}

	private int _callClanId;

	public int getCallClanId() {
		return _callClanId;
	}

	public void setCallClanId(int i) {
		_callClanId = i;
	}

	private int _callClanHeading;

	public int getCallClanHeading() {
		return _callClanHeading;
	}

	public void setCallClanHeading(int i) {
		_callClanHeading = i;
	}

	private boolean _isInCharReset = false;

	public boolean isInCharReset() {
		return _isInCharReset;
	}

	public void setInCharReset(boolean flag) {
		_isInCharReset = flag;
	}

	private int _tempLevel = 1;

	public int getTempLevel() {
		return _tempLevel;
	}

	public void setTempLevel(int i) {
		_tempLevel = i;
	}

	private int _tempMaxLevel = 1;

	public int getTempMaxLevel() {
		return _tempMaxLevel;
	}

	public void setTempMaxLevel(int i) {
		_tempMaxLevel = i;
	}

	private int _awakeSkillId = 0;

	public int getAwakeSkillId() {
		return _awakeSkillId;
	}

	public void setAwakeSkillId(int i) {
		_awakeSkillId = i;
	}

	private int _lap = 1;

	public void setLap(int lap) {
		_lap = lap;
	}

	public int getLap() {
		return _lap;
	}

	private int _lapCheck = 0;

	public void setLapCheck(int i) {
		_lapCheck = i;
	}

	public int getLapCheck() {
		return _lapCheck;
	}

	public int getLapScore() {
		return _lap * 29 + _lapCheck;
	}

	private boolean _order_list = false;

	public boolean isInOrderList() {
		return _order_list;
	}

	public void setInOrderList(boolean bool) {
		_order_list = bool;
	}

	private int _basepoly = 0;

	public void setBasePoly(int i) {
		_basepoly = i;
	}

	public int getBasePoly() {
		return _basepoly;
	}

	private boolean _isSummonMonster = false;

	public void setSummonMonster(boolean summoned) {
		_isSummonMonster = summoned;
	}

	public boolean isSummonMonster() {
		return _isSummonMonster;
	}

	private boolean _isShapeChange = false;

	public void setShapeChange(boolean polyed) {
		_isShapeChange = polyed;
	}

	public boolean isShapeChange() {
		return _isShapeChange;
	}

	private boolean _dropMessages = true;

	public void setDropMessages(final boolean dropMessages) {
		_dropMessages = dropMessages;
	}

	public boolean getDropMessages() {
		return _dropMessages;
	}

	private boolean _partyDropMessages = true;

	public void setPartyDropMessages(final boolean partyDropMessages) {
		_partyDropMessages = partyDropMessages;
	}

	public boolean getPartyDropMessages() {
		return _partyDropMessages;
	}

	private boolean _dmgMessages = false;

	public boolean getDmgMessages() {
		return _dmgMessages;
	}

	public void setDmgMessages(final boolean dmgMessages) {
		_dmgMessages = dmgMessages;
	}

	private boolean _potionMessages = false;

	public boolean getPotionMessages() {
		return _potionMessages;
	}

	public void setPotionMessages(final boolean potionMessages) {
		_potionMessages = potionMessages;
	}

	// check if FoeSlayer is in use
	private boolean _FoeSlayer = false;

	public void setFoeSlayer(boolean FoeSlayer) {
		_FoeSlayer = FoeSlayer;
	}

	public boolean isFoeSlayer() {
		return _FoeSlayer;
	}

	// check if FoeSlayer landed successfully
	private boolean _FoeSlayerSuccess = false;

	public void setFoeSlayerSuccess(boolean FoeSlayerSuccess) {
		_FoeSlayerSuccess = FoeSlayerSuccess;
	}

	public boolean isFoeSlayerSuccess() {
		return _FoeSlayerSuccess;
	}

	public void useDogCollar(int itemObjectId) {
		int petCost = 0;
		int petCount = 0;
		int divisor = 6;
		Object[] petList = getPetList().values().toArray();
		for (Object pet : petList) {
			petCost += ((L1NpcInstance) pet).getPetcost();
		}
		int charisma = getCha();
		if (isCrown()) {
			charisma += 6;
		} else if (isElf()) {
			charisma += 12;
		} else if (isWizard()) {
			charisma += 6;
		} else if (isDarkelf()) {
			charisma += 6;
		} else if (isDragonKnight()) {
			charisma += 6;
		} else if (isIllusionist()) {
			charisma += 6;
		}

		L1Pet l1pet = PetTable.getInstance().getTemplate(itemObjectId);
		if (l1pet != null) {
			int npcId = l1pet.get_npcid();
			charisma -= petCost;
			if (npcId == 45313 || npcId == 45710 || npcId == 45711
					|| npcId == 45712 || npcId == 46046) {
				divisor = 12;
			} else {
				divisor = 6;
			}
			petCount = charisma / divisor;
			if (petCount <= 0) {
				sendPackets(new S_ServerMessage(489));
				return;
			}
			L1Npc npcTemp = NpcTable.getInstance().getTemplate(npcId);
			L1PetInstance pet = new L1PetInstance(npcTemp, this, l1pet);
			pet.setPetcost(divisor);
		}
	}
}
