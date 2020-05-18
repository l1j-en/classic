package l1j.server.server.model.Instance;

import static l1j.server.server.model.skill.L1SkillId.BLIND_HIDING;
import static l1j.server.server.model.skill.L1SkillId.BLOODLUST;
import static l1j.server.server.model.skill.L1SkillId.CANCELLATION;
import static l1j.server.server.model.skill.L1SkillId.COUNTER_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.DECREASE_WEIGHT;
import static l1j.server.server.model.skill.L1SkillId.DRESS_EVASION;
import static l1j.server.server.model.skill.L1SkillId.EARTH_BIND;
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
import static l1j.server.server.serverpackets.S_EquipmentWindow.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.PacketOutput;
import l1j.server.server.command.executor.L1HpBar;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.datatables.AccessLevelTable;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ExpTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.MapTimerTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.AcceleratorChecker;
import l1j.server.server.model.HpRegeneration;
import l1j.server.server.model.L1AccessLevel;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1ChatParty;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1DeathMatch;
import l1j.server.server.model.L1DwarfForElfInventory;
import l1j.server.server.model.L1DwarfInventory;
import l1j.server.server.model.L1EquipmentSlot;
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
import l1j.server.server.model.map.L1MapLimiter;
import l1j.server.server.model.monitor.L1PcAutoUpdate;
import l1j.server.server.model.monitor.L1PcExpMonitor;
import l1j.server.server.model.monitor.L1PcGhostMonitor;
import l1j.server.server.model.monitor.L1PcHellMonitor;
import l1j.server.server.model.monitor.L1PcInvisDelay;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_BlueMessage;
import l1j.server.server.serverpackets.S_CastleMaster;
import l1j.server.server.serverpackets.S_ChangeShape;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_DoActionShop;
import l1j.server.server.serverpackets.S_EquipmentWindow;
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
import l1j.server.server.serverpackets.S_PinkName;
import l1j.server.server.serverpackets.S_Poison;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_Teleport;
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
import l1j.server.server.utils.Teleportation;

public class L1PcInstance extends L1Character {
	public static final int REGENSTATE_ATTACK = 1;
	public static final int REGENSTATE_MOVE = 2;
	public static final int REGENSTATE_NONE = 4;

	private static Logger _log = LoggerFactory.getLogger(L1PcInstance.class.getName());
	private static final long DELAY_INVIS = 3000L;
	private static final int HP_REGEN_INTERVAL = 1000;

	private static final long INTERVAL_AUTO_UPDATE = 300;
	private static final long INTERVAL_EXP_MONITOR = 500;
	private static final int MP_REGEN_INTERVAL = 1000;
	private static final long serialVersionUID = 1L;
	private ScheduledFuture<?> _teleDelayFuture;
	
	public void teleWithDelay(int delay, int x, int y, short mapid, int head, boolean ignorePets) {
		
		if (_teleDelayFuture != null) {
			try {
				_teleDelayFuture.cancel(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		_teleDelayFuture = GeneralThreadPool.getInstance().schedule(new TeleDelay(this,x,y,mapid,head,ignorePets), delay);
	}
	private class TeleDelay implements Runnable {

		private int y;
		private int x;
		private int head;
		private boolean ignorePets;
		private short mapId;
		private L1PcInstance pc;
		
		public TeleDelay(L1PcInstance pc, int x, int y, short mapId, int head, boolean ignorePets) {
			this.pc = pc;
			this.x = x;
			this.y = y;
			this.mapId = mapId;
			this.head = head;
			this.ignorePets = ignorePets;
		}
		@Override
		public void run() {
			setTeleportX(x);
			setTeleportY(y);
			setTeleportMapId(mapId);
			setTeleportHeading(head);
			if (Config.SEND_PACKET_BEFORE_TELEPORT) {
				sendPackets(new S_Teleport(pc));
			} else {
				Teleportation.teleport(pc, ignorePets);
			}			
		}
		
	}
	private class Death implements Runnable {
		L1Character _lastAttacker;
		private String originalThreadName;

		Death(L1Character cha) {
			_lastAttacker = cha;
		}

		public void run() {
			try {
				originalThreadName = Thread.currentThread().getName();
				Thread.currentThread().setName("L1PcInstance-Death");
				L1Character lastAttacker = _lastAttacker;
				_lastAttacker = null;
				setCurrentHp(0);
				setGresValid(false);

				if (isTeleport()) {
					GeneralThreadPool.getInstance().schedule(this, 300);
					return;
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
				l1skilluse.handleCommands(L1PcInstance.this, CANCELLATION, getId(), getX(), getY(), null, 0,
						L1SkillUse.TYPE_LOGIN);

				if (tempchargfx == 5727 || tempchargfx == 5730 || tempchargfx == 5733 || tempchargfx == 5736) {
					tempchargfx = 0;
				}
				if (tempchargfx != 0) {
					sendAndBroadcast(new S_ChangeShape(getId(), tempchargfx));
					GeneralThreadPool.getInstance().schedule(this, 100);
					return;
				} 

				sendAndBroadcast(new S_DoActionGFX(targetobjid, ActionCodes.ACTION_Die));

				// right now if lastAttacker is null, it crashes on the next line after this if
				// statement
				// it should only happen with the .kill/.wipeout commands.
				// It has the unintended consequence of not applying death penalties
				// IE person killed loses Exp, items, etc.
				// Leaving it as-is for now
				if (lastAttacker == null) {
					return;
				}

				if (lastAttacker.getMapId() != 509) {
					try {
						if (lastAttacker != L1PcInstance.this) {
							L1PcInstance player = null;
							if (lastAttacker instanceof L1PcInstance) {
								player = (L1PcInstance) lastAttacker;
								L1World.getInstance()
										.broadcastServerMessage(String.format("%s%s just owned %s%s in battle!",
												player.getName(),
												(player.getClan() == null ? "" : " [" + player.getClanname() + "]"),
												getName(), getClan() == null ? "" : " [" + getClanname() + "]"));
							} else if (lastAttacker instanceof L1PetInstance) {
								player = (L1PcInstance) ((L1PetInstance) lastAttacker).getMaster();
								L1World.getInstance()
										.broadcastServerMessage(String.format(
												"%s%s just ate %s's%s face with uber pets!", player.getName(),
												(player.getClan() == null ? "" : " [" + player.getClanname() + "]"),
												getName(), getClan() == null ? "" : " [" + getClanname() + "]"));
							} else if (lastAttacker instanceof L1SummonInstance) {
								player = (L1PcInstance) ((L1SummonInstance) lastAttacker).getMaster();
								L1World.getInstance()
										.broadcastServerMessage(String.format(
												"%s%s just tore up %s%s with evil summons!", player.getName(),
												(player.getClan() == null ? "" : " [" + player.getClanname() + "]"),
												getName(), getClan() == null ? "" : " [" + getClanname() + "]"));
							}
							if (player != null) {
								if (player instanceof L1PcInstance) {

									try {

										Timestamp ts = new Timestamp(System.currentTimeMillis());
										Connection con = null;
										PreparedStatement pstm = null;
										con = L1DatabaseFactory.getInstance().getConnection();
										pstm = con.prepareStatement(
												"INSERT INTO character_pvp (killer_char_obj_id, killer_char_name, killer_lvl, victim_char_obj_id, victim_char_name, victim_lvl, date, locx, locy, mapid, penalty, killer_pledge, victim_pledge) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
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
										if (isInWarAreaAndWarTime(L1PcInstance.this, player)
												&& getZoneType() != ZoneType.Normal
												&& getMap().isEnabledDeathPenalty()) {
											pstm.setInt(11, 1);
										} else if (!isInWarAreaAndWarTime(L1PcInstance.this, player)
												&& getZoneType() != ZoneType.Normal
												&& !getMap().isEnabledDeathPenalty()) {
											pstm.setInt(11, 2);
										} else if (isInWarAreaAndWarTime(L1PcInstance.this, player)
												&& getZoneType() != ZoneType.Normal
												&& !getMap().isEnabledDeathPenalty()) {
											pstm.setInt(11, 3);
											// doorway
										} else if (!isInWarAreaAndWarTime(L1PcInstance.this, player)
												&& getZoneType() != ZoneType.Normal
												&& getMap().isEnabledDeathPenalty()) {
											pstm.setInt(11, 4);
										} else if (isInWarAreaAndWarTime(L1PcInstance.this, player)
												&& getZoneType() == ZoneType.Normal
												&& getMap().isEnabledDeathPenalty()) {
											pstm.setInt(11, 5);
										} else if (!isInWarAreaAndWarTime(L1PcInstance.this, player)
												&& getZoneType() == ZoneType.Normal
												&& !getMap().isEnabledDeathPenalty()) {
											pstm.setInt(11, 6);
										} else if (isInWarAreaAndWarTime(L1PcInstance.this, player)
												&& getZoneType() == ZoneType.Normal
												&& !getMap().isEnabledDeathPenalty()) {
											pstm.setInt(11, 7);
											// normal zone
										} else if (!isInWarAreaAndWarTime(L1PcInstance.this, player)
												&& getZoneType() == ZoneType.Normal
												&& getMap().isEnabledDeathPenalty()) {
											pstm.setInt(11, 8);
										} else {
											pstm.setInt(11, 9);
										}
										pstm.setString(12, player.getClanname());
										pstm.setString(13, getClanname());
										pstm.execute();
										SQLUtil.close(pstm);
										SQLUtil.close(con);
									} catch (Exception e) {
										_log.error(e.getLocalizedMessage(), e);
									}

								}
							}
						}
					} catch (Exception e) {
						_log.error(e.getLocalizedMessage(), e);
					}
				}
				if (getMapId() == 5153) {
					L1DeathMatch.getInstance().sendRemainder(L1PcInstance.this);
				}
				if (lastAttacker != L1PcInstance.this) {
					if (getZoneType() != ZoneType.Normal) {
						L1PcInstance player = getAttackingPlayer(lastAttacker);

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
					if (getFightId() == fightPc.getId() && fightPc.getFightId() == getId()) { //
						setFightId(0);
						sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL, 0, 0));
						fightPc.setFightId(0);
						fightPc.sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL, 0, 0));
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
					int rnd = ThreadLocalRandom.current().nextInt(1000) + 1;
					if (rnd <= lostRate) {
						int count = 1;
						if (getLawful() <= -30000) {
							count = ThreadLocalRandom.current().nextInt(4) + 1;
						} else if (getLawful() <= -20000) {
							count = ThreadLocalRandom.current().nextInt(3) + 1;
						} else if (getLawful() <= -10000) {
							count = ThreadLocalRandom.current().nextInt(2) + 1;
						} else if (getLawful() < 0) {
							count = ThreadLocalRandom.current().nextInt(1) + 1;
						}
						caoPenaltyResult(count);
					}
				}

				boolean castle_ret = castleWarResult();
				if (castle_ret == true) {
					return;
				}

				L1PcInstance player = getAttackingPlayer(lastAttacker);

				if (player != null) {
					if (getLawful() >= 0 && isPinkName() == false) {
						boolean isChangePkCount = false;
						if (player.getLawful() < 30000) {
							player.set_PKcount(player.get_PKcount() + 1);
							isChangePkCount = true;
							if (player.isElf() && isElf()) {
								player.setPkCountForElf(player.getPkCountForElf() + 1);
							}

							player.setLastPk();
						}

						if (player.isElf() && isElf()) {
							player.setLastPkForElf();
						}

						int lawful;

						if (player.getLevel() < 50) {
							lawful = -1 * (int) ((Math.pow(player.getLevel(), 2) * 4));
						} else {
							lawful = -1 * (int) ((Math.pow(player.getLevel(), 3) * 0.08));
						}
						if ((player.getLawful() - 1000) < lawful) {
							lawful = player.getLawful() - 1000;
						}

						if (lawful <= -32768) {
							lawful = -32768;
						}
						player.setLawful(lawful);

						sendAndBroadcast(new S_Lawful(player.getId(), player.getLawful()));

						if (isChangePkCount && player.get_PKcount() >= Config.NUM_PKS_HELL_WARNING
								&& player.get_PKcount() < Config.NUM_PKS_HELL) {
							player.sendPackets(new S_BlueMessage(551, String.valueOf(player.get_PKcount()),
									Config.NUM_PKS_HELL + ""));
						} else if (isChangePkCount && player.get_PKcount() >= Config.NUM_PKS_HELL) {
							player.beginHell(true);
						}
					} else {
						setPinkName(false);
					}
				}
				_pcDeleteTimer = new L1PcDeleteTimer(L1PcInstance.this);
				_pcDeleteTimer.begin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("", e);
			} finally {
				Thread.currentThread().setName(originalThreadName);
			}
		}
	}

	public long _oldTime = 0;
	public L1PinkName _pinkName = null;
	private final AcceleratorChecker _acceleratorChecker = new AcceleratorChecker(this);
	private L1AccessLevel _accessLevel;

	private String _accountName;

	private int _advenHp;

	private int _advenMp;

	private ScheduledFuture<?> _autoUpdateFuture;

	private int _awakeSkillId = 0;

	private boolean _banned;

	private int _baseAc = 0;

	private int _baseBowDmgup = 0;

	private int _baseBowHitup = 0;

	private byte _baseCha = 0;

	private byte _baseCon = 0;

	private byte _baseDex = 0;

	private int _baseDmgup = 0;

	private int _baseHitup = 0;

	private byte _baseInt = 0;

	private short _baseMaxHp = 0;

	private short _baseMaxMp = 0;

	private int _baseMr = 0;

	private int _basepoly = 0;

	private byte _baseStr = 0;
	private byte _baseWis = 0;

	private int _bonusStats;

	private final ArrayList<L1BookMark> _bookmarks;

	private int _bowDmgModifierByArmor = 0;

	private int _bowHitModifierByArmor = 0;

	private List<L1PrivateShopBuyList> _buyList = new ArrayList<L1PrivateShopBuyList>();

	private int _callClanHeading;

	private int _callClanId;

	private byte _chatCount = 0;

	private L1ChatParty _chatParty;

	private int _clanid;

	private int _clanRank;

	private L1ClassFeature _classFeature = null;

	private int _classId;

	private int _contribution;

	private int _cookingId = 0;

	private int _currentWeapon;

	private int _damageReductionByArmor = 0;
	private Timestamp _deleteTime;

	private int _dessertId = 0;
	private boolean _dmgMessages = false;

	private int _dmgModifierByArmor = 0;

	private long _dotReloadTime = 0;

	private boolean _dropMessages = true;

	private final L1DwarfInventory _dwarf;

	private final L1DwarfForElfInventory _dwarfForElf;

	private int _elfAttr;

	private int _elixirStats;

	private L1EquipmentSlot _equipSlot;

	private int _exp;

	private ScheduledFuture<?> _expMonitorFuture;

	private int _expRes;

	private int _fightId;

	private long _fishingTime = 0;

	// check if FoeSlayer is in use
	private boolean _FoeSlayer = false;

	// check if FoeSlayer landed successfully
	private boolean _FoeSlayerSuccess = false;

	private int _food;

	private boolean _ghost = false;

	private boolean _ghostCanTalk = true;

	private ScheduledFuture<?> _ghostFuture;

	private int _ghostSaveHeading = 0;

	private int _ghostSaveLocX = 0;

	private int _ghostSaveLocY = 0;

	private short _ghostSaveMapId = 0;

	private boolean _gm;

	private boolean _gmAppearOffline;

	private boolean _gmInvis;

	private boolean _gmInvul;

	private boolean _gresValid;

	private int _hasteItemEquipped = 0;

	private ScheduledFuture<?> _hellFuture;

	private int _hellTime;

	private int _highLevel;

	private int _hitModifierByArmor = 0;

	private int _homeTownId;

	private short _hpr = 0;

	private HpRegeneration _hpRegen;

	private boolean _hpRegenActive;

	private ScheduledFuture<?> _hpRegenFuture;

	private final L1PcInventory _inventory;

	private Object _invisTimerMonitor = new Object();

	private boolean _isCanWhisper = true;

	private boolean _isDrink = false;

	private boolean _isFishing = false;

	private boolean _isFishingReady = false;

	private boolean _isGres = false;

	private boolean _isInCharReset = false;

	private boolean _isPinkName = false;

	private boolean _isPrivateShop = false;

	private boolean _isReserveGhost = false; //

	private boolean _isShapeChange = false;

	private boolean _isSummonMonster = false;

	private boolean _isTeleport = false;

	private boolean _isTradingInPrivateShop = false;

	private final L1Karma _karma = new L1Karma();

	private int _lap = 1;

	private int _lapCheck = 0;

	private long _lastAggressiveAct = 0;

	private long _lastJoinedPledge = -1;

	private Timestamp _lastPk;

	private Timestamp _lastPkForElf;

	private long _lastWeaponSwitch = -1;

	private long _logPackets = -1;

	private short _mpr = 0;

	private boolean _mpReductionActiveByAwake;

	private MpReductionByAwake _mpReductionByAwake;

	private ScheduledFuture<?> _mpReductionByAwakeFuture;

	private MpRegeneration _mpRegen;

	private boolean _mpRegenActive;

	private boolean _mpRegenActiveByDoll;
	private MpRegenerationByDoll _mpRegenByDoll;

	private ScheduledFuture<?> _mpRegenByDollFuture;

	private ScheduledFuture<?> _mpRegenFuture;

	private Client _netConnection;

	private long _oldChatTimeInMillis = 0L;

	private int _onlineStatus;

	private boolean _order_list = false;

	private int _originalAc = 0;

	private int _originalBowDmgup = 0;

	private int _originalBowHitup = 0;

	private int _originalCha = 0;

	private int _originalCon = 0;

	private int _originalConWeightReduction = 0;

	private int _originalDex = 0;

	private int _originalDmgup = 0;

	private int _originalEr = 0; // ER

	private int _originalHitup = 0;

	private int _originalHpr = 0;

	private int _originalHpup = 0;

	private int _originalInt = 0;

	private int _originalMagicConsumeReduction = 0;

	private int _originalMagicCritical = 0;

	private int _originalMagicDamage = 0;

	private int _originalMagicHit = 0;

	private int _originalMpr = 0;

	private int _originalMpup = 0;

	private int _originalMr = 0;

	private int _originalStr = 0;

	private int _originalStrWeightReduction = 0;

	private int _originalWis = 0;

	private PacketOutput _out;

	private int _partnerId;

	private int _partnersPrivateShopItemCount = 0;

	private L1Party _party;

	private boolean _partyDropMessages = true;

	private int _partyID;

	private L1PcDeleteTimer _pcDeleteTimer;

	private int _PKcount;

	private int _PkCountForElf;

	private boolean _potionMessages = false;

	private L1Quest _quest;

	private List<L1PrivateShopSellList> _sellList = new ArrayList<L1PrivateShopSellList>();

	private byte _sex;

	private byte[] _shopChat;

	private boolean _showTradeChat = true;

	private boolean _showWorldChat = true;

	private int _teleportHeading = 0;

	private short _teleportMapId = 0;

	private int _teleportX = 0;

	private int _teleportY = 0;

	private int _tempCharGfxAtDead;

	private int _tempID;

	private int _tempLevel = 1;

	private int _tempMaxLevel = 1;

	private int _tradeID;

	private boolean _tradeOk;

	private final L1Inventory _tradewindow;

	private short _trueHpr = 0;

	private short _trueMpr = 0;

	private int _type;

	private L1ItemInstance _weapon;

	private int _weaponSwitchCount = 0;

	private int _weightReduction = 0;

	private String clanname;

	private String followingGm = null;

	private int invisDelayCounter = 0;
	
	private boolean _excludeInitialized = false;
	
	public boolean isExcludeInitialized() {
		return _excludeInitialized;
	}
	
	public void setExcludeInitialised() {
		_excludeInitialized = true;
	}

	private ArrayList<Integer> skillList = new ArrayList<Integer>();
	private L1NpcInstance spoofMob = null;
	private String spoofName = null;

	public L1PcInstance() {
		_accessLevel = AccessLevelTable.getInstance().getAccessLevel((short) -1);
		_currentWeapon = 0;
		_inventory = new L1PcInventory(this);
		_dwarf = new L1DwarfInventory(this);
		_dwarfForElf = new L1DwarfForElfInventory(this);
		_tradewindow = new L1Inventory();
		_bookmarks = new ArrayList<L1BookMark>();
		_quest = new L1Quest(this);
		_equipSlot = new L1EquipmentSlot(this);
		_pinkName = new L1PinkName(this);
	}

	public static L1PcInstance load(String charName) {
		L1PcInstance result = null;
		try {
			result = CharacterTable.getInstance().loadCharacter(charName);
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
		return result;
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

	public void addBookMark(L1BookMark book) {
		_bookmarks.add(book);
	}

	public void addBowDmgModifierByArmor(int i) {
		_bowDmgModifierByArmor += i;
	}

	public void addBowHitModifierByArmor(int i) {
		_bowHitModifierByArmor += i;
	}

	public synchronized void addContribution(int contribution) {
		_contribution += contribution;
	}

	public void addDamageReductionByArmor(int i) {
		_damageReductionByArmor += i;
	}

	public void addDmgModifierByArmor(int i) {
		_dmgModifierByArmor += i;
	}

	public synchronized void addExp(int exp) {
		_exp += exp;
		if (_exp > ExpTable.MAX_EXP) {
			_exp = ExpTable.MAX_EXP;
		}
	}

	public void addHasteItemEquipped(int i) {
		_hasteItemEquipped += i;
	}

	public void addHitModifierByArmor(int i) {
		_hitModifierByArmor += i;
	}

	public void addHpr(int i) {
		_trueHpr += i;
		_hpr = (short) Math.max(0, _trueHpr);
	}

	public void addInvisDelayCounter(int counter) {
		synchronized (_invisTimerMonitor) {
			invisDelayCounter += counter;
		}
	}

	public void addKarma(int i) {
		synchronized (_karma) {
			_karma.add(i);
		}
	}

	public void addMpr(int i) {
		_trueMpr += i;
		_mpr = (short) Math.max(0, _trueMpr);
	}

	public void addWeightReduction(int i) {
		_weightReduction += i;
	}

	public void beginExpMonitor() {
		_expMonitorFuture = GeneralThreadPool.getInstance().pcScheduleAtFixedRate(new L1PcExpMonitor(getId()), 0L,
				INTERVAL_EXP_MONITOR);
	}

	public void beginGameTimeCarrier() {
		new L1GameTimeCarrier(this).start();
	}

	public void beginGhost(int locx, int locy, short mapid, boolean canTalk) {
		beginGhost(locx, locy, mapid, canTalk, 0);
	}

	public void beginGhost(int locx, int locy, short mapid, boolean canTalk, int sec) {
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
			_ghostFuture = GeneralThreadPool.getInstance().pcSchedule(new L1PcGhostMonitor(getId()), sec * 1000);
		}
	}

	public void beginHell(boolean isFirst) {
		if (getMapId() != 666) {
			int locx = 32701;
			int locy = 32777;
			short mapid = 666;
			L1Teleport.teleport(this, locx, locy, mapid, 5, false);
		}

		if (isFirst) {
			if (get_PKcount() <= Config.NUM_PKS_HELL) {
				setHellTime(300);
			} else {
				setHellTime(300 * (get_PKcount() - Config.NUM_PKS_HELL) + 300);
			}
			sendPackets(new S_BlueMessage(552, String.valueOf(get_PKcount()), String.valueOf(getHellTime() / 60)));
		} else {
			sendPackets(new S_BlueMessage(637, String.valueOf(getHellTime())));
		}
		if (_hellFuture == null) {
			_hellFuture = GeneralThreadPool.getInstance().pcScheduleAtFixedRate(new L1PcHellMonitor(getId()), 0L,
					1000L);
		}
	}

	public void beginInvisTimer() {
		addInvisDelayCounter(1);
		GeneralThreadPool.getInstance().pcSchedule(new L1PcInvisDelay(getId()), DELAY_INVIS);
	}

	public boolean canSwitchWeapon() {
		if (!Config.LIMIT_WEAPON_SWITCHING) {
			return true;
		}

		if (System.currentTimeMillis() - this._lastWeaponSwitch >= 3000) {
			this._weaponSwitchCount = 0;
		}

		this._weaponSwitchCount++;

		if (this._weaponSwitchCount > 4) {
			return false;
		}

		this._lastWeaponSwitch = System.currentTimeMillis();
		return true;
	}

	public boolean castleWarResult() {
		if (getClanid() != 0 && isCrown()) {
			L1Clan clan = L1World.getInstance().getClan(getClanname());
			for (L1War war : L1World.getInstance().getWarList()) {
				int warType = war.GetWarType();
				boolean isInWar = war.CheckClanInWar(getClanname());
				boolean isAttackClan = war.CheckAttackClan(getClanname());
				if (getId() == clan.getLeaderId() && warType == 1 && isInWar && isAttackClan) {
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
					boolean same_war = war.CheckClanInSameWar(pc.getClanname(), targetpc.getClanname());
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

	public void clearSkillMastery() {
		skillList.clear();
	}

	public void death(L1Character lastAttacker) {
		synchronized (this) {
			if (isDead()) {
				return;
			}
			setDead(true);
			this.setLastAggressiveAct(0);
			setStatus(ActionCodes.ACTION_Die);
		}
		
		GeneralThreadPool.getInstance().execute(new Death(lastAttacker));

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
		} else if (oldLevel == 49) {
			exp = (int) (needExp * 0.05);
		} else if (oldLevel >= 50) {
			exp = (int) (needExp * 0.05 * ExpTable.getPenaltyRate(oldLevel));
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

	public void delBlindHiding() {
		killSkillEffectTimer(BLIND_HIDING);
		sendPackets(new S_Invis(getId(), 0));
		broadcastPacket(new S_OtherCharPacks(this));
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

	public void disableLogPackets() {
		this._logPackets = -1;
	}

	public void enableLogPackets() {
		this._logPackets = System.currentTimeMillis() + (Config.REPORT_TIME_MINUTES * 60000);
	}

	public void enableLogPackets(long time) {
		this._logPackets = time;
	}

	public void endGhost() {
		setGhost(false);
		setGhostCanTalk(true);
		setReserveGhost(false);
	}

	public void endHell() {
		if (_hellFuture != null) {
			_hellFuture.cancel(false);
			_hellFuture = null;
		}
		int[] loc = L1TownLocation.getGetBackLoc(L1TownLocation.TOWNID_ORCISH_FOREST);
		L1Teleport.teleport(this, loc[0], loc[1], (short) loc[2], 5, true);
		try {
			save();
		} catch (Exception ignore) {
			// ignore
		}
	}

	public int get_food() {
		return _food;
	}

	public int get_PKcount() {
		return _PKcount;
	}

	public byte get_sex() {
		return _sex;
	}

	public AcceleratorChecker getAcceleratorChecker() {
		return _acceleratorChecker;
	}

	public L1AccessLevel getAccessLevel() {
		return _accessLevel;
	}

	public String getAccountName() {
		return _accountName;
	}

	public int getAdvenHp() {
		return _advenHp;
	}

	public int getAdvenMp() {
		return _advenMp;
	}

	public int getAwakeSkillId() {
		return _awakeSkillId;
	}

	public int getBaseAc() {
		return _baseAc;
	}

	public int getBaseBowDmgup() {
		return _baseBowDmgup;
	}

	public int getBaseBowHitup() {
		return _baseBowHitup;
	}

	public byte getBaseCha() {
		return _baseCha;
	}

	public byte getBaseCon() {
		return _baseCon;
	}

	public byte getBaseDex() {
		return _baseDex;
	}

	public int getBaseDmgup() {
		return _baseDmgup;
	}

	public int getBaseHitup() {
		return _baseHitup;
	}

	public byte getBaseInt() {
		return _baseInt;
	}

	public short getBaseMaxHp() {
		return _baseMaxHp;
	}

	public short getBaseMaxMp() {
		return _baseMaxMp;
	}

	public int getBaseMr() {
		return _baseMr;
	}

	public int getBasePoly() {
		return _basepoly;
	}

	public byte getBaseStr() {
		return _baseStr;
	}

	public byte getBaseWis() {
		return _baseWis;
	}

	public synchronized int getBonusStats() {
		return _bonusStats;
	}
	
	public ArrayList<L1BookMark> getBookMarks() {
		return _bookmarks;
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
	
	public L1BookMark getBookMarkByIndex(int index) {
		if(index > _bookmarks.size())
			return null ;
		
		return _bookmarks.get(index);
	}
	
	public L1BookMark getBookMarkByCoords(int x, int y, int mapId) {
		for (int i = 0; i < _bookmarks.size(); i++) {
			L1BookMark element = _bookmarks.get(i);
			
			if (element.getLocX() == x && element.getLocY() == y && element.getMapId() == mapId) {
				return element;
			}
		}
		return null;
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

	public int getBookMarkSize() {
		return _bookmarks.size();
	}

	public int getBowDmgModifierByArmor() {
		return _bowDmgModifierByArmor;
	}

	public int getBowHitModifierByArmor() {
		return _bowHitModifierByArmor;
	}

	public List<L1PrivateShopBuyList> getBuyList() {
		return _buyList;
	}

	public int getCallClanHeading() {
		return _callClanHeading;
	}

	public int getCallClanId() {
		return _callClanId;
	}

	public L1ChatParty getChatParty() {
		return _chatParty;
	}

	public L1Clan getClan() {
		return L1World.getInstance().getClan(getClanname());
	}

	public int getClanid() {
		return _clanid;
	}

	public String getClanname() {
		return clanname.replace(" ", "");
	}

	public int getClanRank() {
		return _clanRank;
	}

	public L1ClassFeature getClassFeature() {
		return _classFeature;
	}

	public int getClassId() {
		return _classId;
	}

	public int getContribution() {
		return _contribution;
	}

	public int getCookingId() {
		return _cookingId;
	}

	public int getCurrentWeapon() {
		return _currentWeapon;
	}

	public int getDamageReductionByArmor() {
		return _damageReductionByArmor;
	}

	public Timestamp getDeleteTime() {
		return _deleteTime;
	}

	public int getDessertId() {
		return _dessertId;
	}

	public boolean getDmgMessages() {
		return _dmgMessages;
	}

	public int getDmgModifierByArmor() {
		return _dmgModifierByArmor;
	}

	public boolean getDropMessages() {
		return _dropMessages;
	}

	public L1DwarfForElfInventory getDwarfForElfInventory() {
		return _dwarfForElf;
	}

	public L1DwarfInventory getDwarfInventory() {
		return _dwarf;
	}

	public int getElfAttr() {
		return _elfAttr;
	}

	public int getElixirStats() {
		return _elixirStats;
	}

	public L1EquipmentSlot getEquipSlot() {
		return _equipSlot;
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

	@Override
	public synchronized int getExp() {
		return _exp;
	}

	public int getExpRes() {
		return _expRes;
	}

	public int getFightId() {
		return _fightId;
	}

	public long getFishingTime() {
		return _fishingTime;
	}

	public L1PcInstance getFollowingGm() {
		if (followingGm == null)
			return null;

		L1PcInstance player = L1World.getInstance().getPlayer(followingGm);

		// if the gm has gone offline, they're obviously not following anymore
		if (player == null)
			followingGm = null;

		return player;
	}

	public int getHasteItemEquipped() {
		return _hasteItemEquipped;
	}

	public int getHellTime() {
		return _hellTime;
	}

	public int getHighLevel() {
		return _highLevel;
	}

	public int getHitModifierByArmor() {
		return _hitModifierByArmor;
	}

	public int getHomeTownId() {
		return _homeTownId;
	}

	public short getHpr() {
		return _hpr;
	}

	@Override
	public L1PcInventory getInventory() {
		return _inventory;
	}

	@Override
	public int getKarma() {
		return _karma.get();
	}

	public int getKarmaLevel() {
		return _karma.getLevel();
	}

	public int getKarmaPercent() {
		return _karma.getPercent();
	}

	public int getLap() {
		return _lap;
	}

	public int getLapCheck() {
		return _lapCheck;
	}

	public int getLapScore() {
		return _lap * 29 + _lapCheck;
	}

	public long getLastAggressiveAct() {
		return _lastAggressiveAct;
	}

	public long getLastJoinedPledge() {
		return _lastJoinedPledge;
	}

	public Timestamp getLastPk() {
		return _lastPk;
	}

	public Timestamp getLastPkForElf() {
		return _lastPkForElf;
	}

	@Override
	public int getMagicLevel() {
		return getClassFeature().getMagicLevel(getLevel());
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

		double weightReduction = 1 + weightReductionByArmor + weightReductionByDoll + originalWeightReduction;

		maxWeight *= weightReduction;

		maxWeight += weightReductionByMagic;

		maxWeight *= Config.RATE_WEIGHT_LIMIT;

		return maxWeight;
	}

	public short getMpr() {
		return _mpr;
	}

	public Client getNetConnection() {
		return _netConnection;
	}

	public int getOnlineStatus() {
		return _onlineStatus;
	}

	public int getOriginalAc() {
		return _originalAc;
	}

	public int getOriginalBowDmgup() {
		return _originalBowDmgup;
	}

	public int getOriginalBowHitup() {
		return _originalBowHitup;
	}

	public int getOriginalCha() {
		return _originalCha;
	}

	public int getOriginalCon() {
		return _originalCon;
	}

	public int getOriginalConWeightReduction() {
		return _originalConWeightReduction;
	}

	public int getOriginalDex() {
		return _originalDex;
	}

	public int getOriginalDmgup() {
		return _originalDmgup;
	}

	public int getOriginalEr() {
		return _originalEr;
	}

	public int getOriginalHitup() {
		return _originalHitup;
	}

	public int getOriginalHpr() {
		return _originalHpr;
	}

	public int getOriginalHpup() {
		return _originalHpup;
	}

	public int getOriginalInt() {
		return _originalInt;
	}

	public int getOriginalMagicConsumeReduction() {
		return _originalMagicConsumeReduction;
	}

	public int getOriginalMagicCritical() {
		return _originalMagicCritical;
	}

	public int getOriginalMagicDamage() {
		return _originalMagicDamage;
	}

	public int getOriginalMagicHit() {
		return _originalMagicHit;
	}

	public int getOriginalMpr() {
		return _originalMpr;
	}

	public int getOriginalMpup() {
		return _originalMpup;
	}

	public int getOriginalMr() {
		return _originalMr;
	}

	public int getOriginalStr() {
		return _originalStr;
	}

	public int getOriginalStrWeightReduction() {
		return _originalStrWeightReduction;
	}

	public int getOriginalWis() {
		return _originalWis;
	}

	public int getPartnerId() {
		return _partnerId;
	}

	public int getPartnersPrivateShopItemCount() {
		return _partnersPrivateShopItemCount;
	}

	public L1Party getParty() {
		return _party;
	}

	public boolean getPartyDropMessages() {
		return _partyDropMessages;
	}

	public int getPartyID() {
		return _partyID;
	}

	public int getPkCountForElf() {
		return _PkCountForElf;
	}

	public boolean getPotionMessages() {
		return _potionMessages;
	}

	public L1Quest getQuest() {
		return _quest;
	}

	public long getReloadTime() {
		return _dotReloadTime;
	}

	public List<L1PrivateShopSellList> getSellList() {
		return _sellList;
	}

	public byte[] getShopChat() {
		return _shopChat;
	}

	public L1NpcInstance getSpoofMob() {
		return spoofMob;
	}

	public String getSpoofName() {
		return spoofName;
	}

	public int getTeleportHeading() {
		return _teleportHeading;
	}

	public short getTeleportMapId() {
		return _teleportMapId;
	}

	public int getTeleportX() {
		return _teleportX;
	}

	public int getTeleportY() {
		return _teleportY;
	}

	public int getTempCharGfxAtDead() {
		return _tempCharGfxAtDead;
	}

	public int getTempID() {
		return _tempID;
	}

	public int getTempLevel() {
		return _tempLevel;
	}

	public int getTempMaxLevel() {
		return _tempMaxLevel;
	}

	public int getTradeID() {
		return _tradeID;
	}

	public boolean getTradeOk() {
		return _tradeOk;
	}

	public L1Inventory getTradeWindowInventory() {
		return _tradewindow;
	}

	public int getType() {
		return _type;
	}

	public L1ItemInstance getWeapon() {
		return _weapon;
	}

	public int getWeightReduction() {
		return _weightReduction;
	}

	@Override
	public void healHp(int pt) {
		super.healHp(pt);

		sendPackets(new S_HPUpdate(this));
	}

	public boolean isBanned() {
		return _banned;
	}

	public boolean isBrave() {
		return hasSkillEffect(STATUS_BRAVE);
	}

	public boolean isCanWhisper() {
		return _isCanWhisper;
	}

	public boolean isCrown() {
		return L1ClassId.isRoyal(getClassId());
	}

	public boolean isDarkelf() {
		return L1ClassId.isDarkElf(getClassId());
	}

	public boolean isDragonKnight() {
		return L1ClassId.isDragonKnight(getClassId());
	}

	public boolean isDrink() {
		return _isDrink;
	}

	public boolean isElf() {
		return L1ClassId.isElf(getClassId());
	}

	public boolean isElfBrave() {
		return hasSkillEffect(STATUS_ELFBRAVE);
	}

	public boolean isFastAttackable() {
		return hasSkillEffect(BLOODLUST);
	}

	public boolean isFastMovable() {
		return (hasSkillEffect(HOLY_WALK) || hasSkillEffect(MOVING_ACCELERATION) || hasSkillEffect(WIND_WALK)
				|| hasSkillEffect(STATUS_RIBRAVE) || hasSkillEffect(BLOODLUST));
	}

	public boolean isFishing() {
		return _isFishing;
	}

	public boolean isFishingReady() {
		return _isFishingReady;
	}

	public boolean isFoeSlayer() {
		return _FoeSlayer;
	}

	public boolean isFoeSlayerSuccess() {
		return _FoeSlayerSuccess;
	}

	public boolean isGhost() {
		return _ghost;
	}

	public boolean isGhostCanTalk() {
		return _ghostCanTalk;
	}

	public boolean isGm() {
		return _gm;
	}

	public boolean isGmAppearOffline() {
		return _gmAppearOffline;
	}

	public boolean isGmInvis() {
		return _gmInvis;
	}

	public boolean isGmInvul() {
		return _gmInvul;
	}

	public boolean isGres() {
		return _isGres;
	}

	public boolean isGresValid() {
		return _gresValid;
	}

	public boolean isHaste() {
		return (hasSkillEffect(STATUS_HASTE) || hasSkillEffect(HASTE) || hasSkillEffect(GREATER_HASTE)
				|| getMoveSpeed() == 1);
	}

	public boolean isIllusionist() {
		return L1ClassId.isIllusionist(getClassId());
	}

	public boolean isInCharReset() {
		return _isInCharReset;
	}

	public boolean isInChatParty() {
		return getChatParty() != null;
	}

	public boolean isInOrderList() {
		return _order_list;
	}

	public boolean isInParty() {
		return getParty() != null;
	}

	public boolean isInvisDelay() {
		return (invisDelayCounter > 0);
	}

	public boolean isKnight() {
		return L1ClassId.isKnight(getClassId());
	}

	public boolean isLoggingPackets() {
		if (this._logPackets > 0 && this._logPackets < System.currentTimeMillis()) {
			this.disableLogPackets();
		}

		return this._logPackets > 0;
	}

	public boolean isPinkName() {
		return _isPinkName;
	}

	public boolean isPrivateShop() {
		return _isPrivateShop;
	}

	public boolean isReserveGhost() {
		return _isReserveGhost;
	}

	public boolean isShapeChange() {
		return _isShapeChange;
	}

	public boolean isSkillMastery(int skillid) {
		return skillList.contains(skillid);
	}

	public boolean isSummonMonster() {
		return _isSummonMonster;
	}

	public boolean isTeleport() {
		return _isTeleport;
	}

	public boolean isTradingInPrivateShop() {
		return _isTradingInPrivateShop;
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

	public boolean isWantedForElf() {
		if (_lastPkForElf == null) {
			return false;
		} else if (System.currentTimeMillis() - _lastPkForElf.getTime() > 24 * 3600 * 1000) {
			setLastPkForElf(null);
			return false;
		}
		return true;
	}

	public boolean isWizard() {
		return L1ClassId.isMage(getClassId());
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

	public void makeReadyEndGhost() {
		setReserveGhost(true);
		L1Teleport.teleport(this, _ghostSaveLocX, _ghostSaveLocY, _ghostSaveMapId, _ghostSaveHeading, true);
	}

	@Override
	public void onAction(L1PcInstance attacker) {
		if (attacker == null) {
			return;
		}
		if (isTeleport()) {
			return;
		}
		if (getZoneType() == ZoneType.Safety || attacker.getZoneType() == ZoneType.Safety) {
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

			if (attack.calcHit()) {
				if (hasSkillEffect(COUNTER_BARRIER) && !hasSkillEffect(EARTH_BIND)) {
					L1Magic magic = new L1Magic(this, attacker);
					if (magic.calcProbabilityMagic(COUNTER_BARRIER) && attack.isShortDistance()
							&& !attacker.isFoeSlayer()) {
						attack.actionCounterBarrier();
						attack.commitCounterBarrier();
						return;
					}
				}

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
	
	private static ScheduledFuture<?> _mapLimiterFuture;
	private static L1MapLimiter _mapLimiter = null;
	public L1MapLimiter getMapLimiter() {
		return _mapLimiter;
	}

	public void setMapLimiter(L1MapLimiter mapLimiter) {
		_mapLimiter = mapLimiter;
	}

	public void startMapLimiter() {
		if (getMapLimiter() != null) {
			stopMapLimiter();
		}

		setMapLimiter(L1MapLimiter.get(getMapId()));
		if (!isGm() && getMapLimiter() != null) {
			getMapLimiter().execute(this);
			ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
			_mapLimiterFuture = schedule.scheduleAtFixedRate(getMapLimiter(), 0, 1000, TimeUnit.MILLISECONDS);
		}
	}

	public void stopMapLimiter() {
		if (getMapLimiter() != null) {
			getMapLimiter().save();
			setMapLimiter(null);
			if (_mapLimiterFuture != null) {
				_mapLimiterFuture.cancel(true);
				_mapLimiterFuture = null;
			}
		}
	}
	
	public int getEnterTime(int areaId) {
		int time = 0;
		L1MapLimiter limiter = getMapLimiter();
		
		if (limiter != null && limiter.getAreaId() == areaId) {
			time = limiter.getEnterTime() / 60;
		} else {
			limiter = L1MapLimiter.get(areaId);
			
			if (limiter != null) {
				MapTimerTable timer = MapTimerTable.find(getId(), limiter.getAreaId());
				
				if (timer != null) {
					time = timer.getEnterTime() / 60;
				} else {
					time = limiter.getEffect().getTime() / 60;
				}
			}
		}
		return time;
	}

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
		perceivedFrom.sendPackets(new S_OtherCharPacks(this, perceivedFrom.hasSkillEffect(GMSTATUS_FINDINVIS)));
		if (isInParty() && getParty().isMember(perceivedFrom)) {
			perceivedFrom.sendPackets(new S_HPMeter(this));
		}

		if (isPinkName()) {
			perceivedFrom.sendPackets(new S_PinkName(getId(), _pinkName.getSecondsLeft()));
		}

		// TODO Check if these are working, fixes for poison showing up on
		// characters entering your screen
		if (hasSkillEffect(L1SkillId.STATUS_POISON) || hasSkillEffect(L1SkillId.STATUS_POISON_SILENCE)
				|| hasSkillEffect(L1SkillId.STATUS_POISON_PARALYZING)) {
			perceivedFrom.sendPackets(new S_Poison(getId(), 1));
		}
		if (hasSkillEffect(L1SkillId.STATUS_POISON_PARALYZED)) {
			perceivedFrom.sendPackets(new S_Poison(getId(), 2));
		}

		if (isPrivateShop()) {
			perceivedFrom.sendPackets(new S_DoActionShop(getId(), ActionCodes.ACTION_Shop, getShopChat()));
		}

		if (isCrown()) {
			L1Clan clan = L1World.getInstance().getClan(getClanname());
			if (clan != null) {
				if (getId() == clan.getLeaderId() && clan.getCastleId() != 0) {
					perceivedFrom.sendPackets(new S_CastleMaster(clan.getCastleId(), getId()));
				}
			}
		}
	}

	public void receiveDamage(L1Character attacker, double damage, boolean isMagicDamage) { //
		this.setLastAggressiveAct();

		if (attacker instanceof L1PcInstance) {
			((L1PcInstance) attacker).setLastAggressiveAct();
		}

		if (getCurrentHp() > 0 && !isDead()) {
			if (attacker != this) {
				if (!(attacker instanceof L1EffectInstance) && !knownsObject(attacker)
						&& attacker.getMapId() == this.getMapId()) {
					attacker.onPerceive(this);
				}
			}

			if (isMagicDamage == true) { //
				long nowTime = System.currentTimeMillis();
				long interval = nowTime - _oldTime;

				if (damage >= 0) {
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
					((L1PcInstance) attacker)._pinkName.onAction(this);
				}
				if (attacker instanceof L1PcInstance && ((L1PcInstance) attacker).isPinkName()) {
					for (L1Object object : L1World.getInstance().getVisibleObjects(attacker)) {
						if (object instanceof L1GuardInstance) {
							L1GuardInstance guard = (L1GuardInstance) object;
							guard.setTarget(((L1PcInstance) attacker));
						}
					}
				}
				removeSkillEffect(FOG_OF_SLEEPING);
			}

			if (hasSkillEffect(MORTAL_BODY) && getId() != attacker.getId()) {
				int rnd = ThreadLocalRandom.current().nextInt(100) + 1;
				if (damage > 0 && rnd <= 23) {
					if (attacker instanceof L1PcInstance) {
						L1PcInstance attackPc = (L1PcInstance) attacker;
						attackPc.sendAndBroadcast(new S_DoActionGFX(attackPc.getId(), ActionCodes.ACTION_Damage));

						int mbDamage = (this.getAc() * -1) / 2;
						if (mbDamage < 35) {
							mbDamage = 35;
						}

						attackPc.receiveDamage(this, mbDamage, false);
					} else if (attacker instanceof L1NpcInstance) {
						L1NpcInstance attackNpc = (L1NpcInstance) attacker;
						attackNpc.broadcastPacket(new S_DoActionGFX(attackNpc.getId(), ActionCodes.ACTION_Damage));
						attackNpc.receiveDamage(this, 30);
					}
				}
			} /*
				 * expected to be deleted after experimental implementation if
				 * (attacker.hasSkillEffect(JOY_OF_PAIN) && getId() != attacker.getId()) { int
				 * nowDamage = getMaxHp() - getCurrentHp(); if (nowDamage > 0) { if (attacker
				 * instanceof L1PcInstance) { L1PcInstance attackPc = (L1PcInstance) attacker;
				 * attackPc.sendAndBroadcast(new S_DoActionGFX( attackPc.getId(),
				 * ActionCodes.ACTION_Damage)); attackPc.receiveDamage(this, nowDamage / 5,
				 * false); } else if (attacker instanceof L1NpcInstance) { L1NpcInstance
				 * attackNpc = (L1NpcInstance) attacker; attackNpc.broadcastPacket(new
				 * S_DoActionGFX(attackNpc .getId(), ActionCodes.ACTION_Damage));
				 * attackNpc.receiveDamage(this, nowDamage / 5); } } }
				 */
			if (getInventory().checkEquipped(145) || getInventory().checkEquipped(149)) {
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

	public void receiveDamage(L1Character attacker, int damage, int attr) {
		int player_mr = getMr();
		int rnd = ThreadLocalRandom.current().nextInt(100) + 1;
		if (player_mr >= rnd) {
			damage /= 2;
		}

		receiveDamage(attacker, damage, false);
	}

	public void receiveManaDamage(L1Character attacker, int mpDamage) {
		this.setLastAggressiveAct();

		if (attacker instanceof L1PcInstance) {
			((L1PcInstance) attacker).setLastAggressiveAct();
		}

		if (mpDamage > 0 && !isDead()) {
			delInvis();
			if (attacker instanceof L1PcInstance) {
				((L1PcInstance) attacker)._pinkName.onAction(this);
			}
			if (attacker instanceof L1PcInstance && ((L1PcInstance) attacker).isPinkName()) {

				for (L1Object object : L1World.getInstance().getVisibleObjects(attacker)) {
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
	
	public void setEquipped(L1PcInstance pc, boolean isEq) {
		for (L1ItemInstance item : pc.getInventory().getItems()) {
			if ((item.getItem().getType2() == 2) && (item.isEquipped())) {
				int items = 0;
				if ((item.getItem().getType() == 1)) {
					items = EQUIPMENT_INDEX_HELM;
				} else if ((item.getItem().getType() == 2)) {
					items = EQUIPMENT_INDEX_T;
				} else if ((item.getItem().getType() == 3)) {
					items = EQUIPMENT_INDEX_ARMOR;
				} else if ((item.getItem().getType() == 4)) {
					items = EQUIPMENT_INDEX_CLOAK;
				} else if ((item.getItem().getType() == 5)) {
					items = EQUIPMENT_INDEX_GLOVE;
				} else if ((item.getItem().getType() == 6)) {
					items = EQUIPMENT_INDEX_BOOTS;
				} else if ((item.getItem().getType() == 7)) {
					// shield
					items = EQUIPMENT_INDEX_SHIELD;
				} else if ((item.getItem().getType() == 8)) {
					// guarder
					items = EQUIPMENT_INDEX_SHIELD;
				} else if ((item.getItem().getType() == 10)) {
					items = EQUIPMENT_INDEX_AMULET;
				} else if ((item.getItem().getType() == 11) && item.getRingID() == 18) {
					items = EQUIPMENT_INDEX_RING1;
				} else if ((item.getItem().getType() == 11) && item.getRingID() == 19) {
					items = EQUIPMENT_INDEX_RING2;	
				} else if ((item.getItem().getType() == 11) && item.getRingID() == 20) {
					items = EQUIPMENT_INDEX_RING3;
				} else if ((item.getItem().getType() == 11) && item.getRingID() == 21) {
					items = EQUIPMENT_INDEX_RING4;
				} else if ((item.getItem().getType() == 12)) {
					items = EQUIPMENT_INDEX_EARRING;
				} else if ((item.getItem().getType() == 13)) {
					items = EQUIPMENT_INDEX_BELT;	
				} else if ((item.getItem().getType() == 14)) {
					items = EQUIPMENT_INDEX_RUNE1;
				} else if ((item.getItem().getType() == 15)) {
					items = EQUIPMENT_INDEX_RUNE2;
				} else if ((item.getItem().getType() == 16)) {
					items = EQUIPMENT_INDEX_RUNE3;
				} else if ((item.getItem().getType() == 17)) {
					items = EQUIPMENT_INDEX_RUNE4;
				} else if ((item.getItem().getType() == 18)) {
					items = EQUIPMENT_INDEX_RUNE5;
				}
				pc.sendPackets(new S_EquipmentWindow(pc, item.getId(),items,isEq)); 
			}
			if ((item.getItem().getType2() == 1) && (item.isEquipped())) {
				int items = EQUIPMENT_INDEX_WEAPON;
				pc.sendPackets(new S_EquipmentWindow(pc, item.getId(),items,isEq)); 
			}
		}
	}


	public void reduceCurrentHp(double d, L1Character l1character) {
		getStat().reduceCurrentHp(d, l1character);
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
		_originalStrWeightReduction = features.getOriginalStrWeightReduction(getOriginalStr());
		_originalConWeightReduction = features.getOriginalConWeightReduction(getOriginalCon());
		_originalMagicHit = features.getOriginalMagicHit(getOriginalInt());
		_originalMagicDamage = features.getOriginalMagicDamage(getOriginalInt());
		_originalMagicConsumeReduction = features.getOriginalMpReduction(getOriginalInt());
		_originalMagicCritical = features.getOriginalMagicCrit(getOriginalInt());
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

	public void removeBookMark(L1BookMark book) {
		_bookmarks.remove(book);
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

	public void removeSkillMastery(int skillid) {
		if (skillList.contains((Object) skillid)) {
			skillList.remove((Object) skillid);
		}
	}

	public void resetBaseAc() {
		int newAc = CalcStat.calcAc(getLevel(), getBaseDex());
		addAc(newAc - _baseAc);
		_baseAc = newAc;
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

	public void resetBaseMr() {
		int newMr = getClassFeature().getBaseMR() + CalcStat.calcStatMr(getWis()) + getLevel() / 2;
		addMr(newMr - _baseMr);
		_baseMr = newMr;
	}

	public void resetLevel() {
		setLevel(ExpTable.getLevelByExp(_exp));

		if (_hpRegen != null) {
			_hpRegen.updateLevel();
		}
	}

	public void resetReloadTime() {
		if (!Config.CHAO_PINK && getLawful() < 0) {
			_dotReloadTime = System.currentTimeMillis() + Config.DOT_RELOAD_PINK_WAIT_TIME * 1000;
		} else {
			_dotReloadTime = System.currentTimeMillis()
					+ (isPinkName() ? Config.DOT_RELOAD_PINK_WAIT_TIME : Config.DOT_RELOAD_WAIT_TIME) * 1000;
		}
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
		} else if (oldLevel == 49) {
			exp = (int) (needExp * 0.025);
		} else if (oldLevel >= 50) {
			exp = (int) (needExp * 0.025 * ExpTable.getPenaltyRate(oldLevel));
		}

		if (exp == 0) {
			return;
		}
		addExp(exp);
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
			if (getName().toLowerCase().equals(pet.getMaster().getName().toLowerCase())) {
				pet.save();
			}
		}
	}

	public void saveInventory() {
		for (L1ItemInstance item : getInventory().getItems()) {
			getInventory().saveItem(item, item.getRecordingColumns());
		}
	}

	public void sendAndBroadcast(ServerBasePacket packet) {
		sendPackets(packet);
		broadcastPacket(packet);
	}

	public void sendPackets(ServerBasePacket serverbasepacket) {
		if (_out == null) {
			return;
		}

		try {
			byte[] logPacket = serverbasepacket.getContent();

			if (logPacket.length > 0) {
				int packetOpCode = (int) logPacket[0];

				if (packetOpCode != Opcodes.S_OPCODE_GAMETIME && packetOpCode != Opcodes.S_OPCODE_GLOBALCHAT
						&& packetOpCode != Opcodes.S_OPCODE_NORMALCHAT
						&& packetOpCode != Opcodes.S_OPCODE_WHISPERCHAT) {
					// this.getNetConnection().addToServerPacketLog(IntArrayUtil.toCsv(ByteArrayUtil.convertToInt(logPacket)));
				}
			}

			_out.sendPacket(serverbasepacket);
		} catch (Exception e) {
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

	public void set_food(int i) {
		_food = i;
	}

	public void set_PKcount(int i) {
		_PKcount = i;
	}

	public void set_sex(int i) {
		_sex = (byte) i;
	}

	public void setAccessLevel(L1AccessLevel accessLevel) {
		_accessLevel = accessLevel;

		if (accessLevel.getLevel() < Config.MIN_GM_ACCESS_LEVEL)
			setGm(false);
	}

	public void setAccountName(String s) {
		_accountName = s;
	}

	public void setAdvenHp(int i) {
		_advenHp = i;
	}

	public void setAdvenMp(int i) {
		_advenMp = i;
	}

	public void setAwakeSkillId(int i) {
		_awakeSkillId = i;
	}

	public void setBanned(boolean flag) {
		_banned = flag;
	}

	public void setBaseCha(byte i) {
		_baseCha = i;
		setCha(i);
	}

	public void setBaseCon(byte i) {
		_baseCon = i;
		setCon(i);
	}

	public void setBaseDex(byte i) {
		_baseDex = i;
		setDex(i);
	}

	public void setBaseInt(byte i) {
		_baseInt = i;
		setInt(i);
	}

	public void setBasePoly(int i) {
		_basepoly = i;
	}

	public void setBaseStr(byte i) {
		_baseStr = i;
		setStr(i);
	}

	public void setBaseWis(byte i) {
		_baseWis = i;
		setWis(i);
	}

	public synchronized void setBonusStats(int i) {
		_bonusStats = i;
	}

	public void setCallClanHeading(int i) {
		_callClanHeading = i;
	}

	public void setCallClanId(int i) {
		_callClanId = i;
	}

	public void setCanWhisper(boolean flag) {
		_isCanWhisper = flag;
	}

	public void setChatParty(L1ChatParty cp) {
		_chatParty = cp;
	}

	public void setClanid(int i) {
		_clanid = i;
	}

	public void setClanname(String s) {
		clanname = s.replace(" ", "");
	}

	public void setClanRank(int i) {
		_clanRank = i;
	}
	
	private Timestamp _birthday;

	public Timestamp getBirthday() {
		return _birthday;
	}

	public int getSimpleBirthday() {
		if (_birthday !=null) {
			SimpleDateFormat SimpleDate = new SimpleDateFormat("yyyyMMdd");
			int BornTime = Integer.parseInt(SimpleDate.format(_birthday.getTime()));
			return BornTime;
		} else {
			return 0;
		}
	}

	public void setBirthday(Timestamp time) {
		_birthday = time;
	}

	public void setBirthday(){
		_birthday = new Timestamp(System.currentTimeMillis());
	}


	public void setClassId(int i) {
		_classId = i;
		_classFeature = L1ClassFeature.newClassFeature(i);
	}

	public void setContribution(int i) {
		_contribution = i;
	}

	public void setCookingId(int i) {
		_cookingId = i;
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

	public void setCurrentWeapon(int i) {
		_currentWeapon = i;
	}

	public void setDeleteTime(Timestamp time) {
		_deleteTime = time;
	}

	public void setDessertId(int i) {
		_dessertId = i;
	}

	public void setDmgMessages(final boolean dmgMessages) {
		_dmgMessages = dmgMessages;
	}

	public void setDrink(boolean flag) {
		_isDrink = flag;
	}

	public void setDropMessages(final boolean dropMessages) {
		_dropMessages = dropMessages;
	}

	public void setElfAttr(int i) {
		_elfAttr = i;
	}

	public void setElixirStats(int i) {
		_elixirStats = i;
	}

	@Override
	public synchronized void setExp(int i) {
		_exp = i;
	}

	public void setExpRes(int i) {
		_expRes = i;
	}

	public void setFightId(int i) {
		_fightId = i;
	}

	public void setFishing(boolean flag) {
		_isFishing = flag;
	}

	public void setFishingReady(boolean flag) {
		_isFishingReady = flag;
	}

	public void setFishingTime(long i) {
		_fishingTime = i;
	}

	public void setFoeSlayer(boolean FoeSlayer) {
		_FoeSlayer = FoeSlayer;
	}

	public void setFoeSlayerSuccess(boolean FoeSlayerSuccess) {
		_FoeSlayerSuccess = FoeSlayerSuccess;
	}

	public void setFollowingGm(L1PcInstance pc) {
		if (pc != null) {
			// ensure this PcInstance isn't tied to anyone else
			for (L1PcInstance player : L1World.getInstance().getAllPlayers()) {
				if (player.getFollowingGm() == pc)
					player.setFollowingGm(null);
			}
		}

		followingGm = pc == null ? null : pc.getName();
	}

	public void setGm(boolean flag) {
		_gm = flag;
	}

	public void setGmAppearOffline(boolean flag) {
		_gmAppearOffline = flag;
	}

	public void setGmInvis(boolean flag) {
		_gmInvis = flag;
	}

	public void setGmInvul(boolean flag) {
		_gmInvul = flag;
	}

	public void setGres(boolean flag) {
		_isGres = flag;
	}

	public void setHellTime(int i) {
		_hellTime = i;
	}

	public void setHighLevel(int i) {
		_highLevel = i;
	}

	public void setHomeTownId(int i) {
		_homeTownId = i;
	}

	public void setInCharReset(boolean flag) {
		_isInCharReset = flag;
	}

	public void setInOrderList(boolean bool) {
		_order_list = bool;
	}

	@Override
	public void setKarma(int i) {
		_karma.set(i);
	}

	public void setLap(int lap) {
		_lap = lap;
	}

	public void setLapCheck(int i) {
		_lapCheck = i;
	}

	public void setLastAggressiveAct() {
		setLastAggressiveAct(System.currentTimeMillis());
	}

	public void setLastAggressiveAct(long millis) {
		// if they're not in a safety zone or we're attempting
		// to reset the counter
		if (this.getZoneType() != ZoneType.Safety || millis == 0) {
			_lastAggressiveAct = millis;
		}
	}

	public void setLastJoinedPledge() {
		_lastJoinedPledge = System.currentTimeMillis();
	}

	public void setLastJoinedPledge(long lastJoined) {
		_lastJoinedPledge = lastJoined;
	}

	public void setLastPk() {
		_lastPk = new Timestamp(System.currentTimeMillis());
	}

	public void setLastPk(Timestamp time) {
		_lastPk = time;
	}

	public void setLastPkForElf() {
		_lastPkForElf = new Timestamp(System.currentTimeMillis());
	}

	public void setLastPkForElf(Timestamp time) {
		_lastPkForElf = time;
	}

	public void setNetConnection(Client client) {
		_netConnection = client;
	}

	public void setOnlineStatus(int i) {
		_onlineStatus = i;
	}

	public void setOriginalCha(int i) {
		_originalCha = i;
	}

	public void setOriginalCon(int i) {
		_originalCon = i;
	}

	public void setOriginalDex(int i) {
		_originalDex = i;
	}

	public void setOriginalInt(int i) {
		_originalInt = i;
	}

	public void setOriginalStr(int i) {
		_originalStr = i;
	}

	public void setOriginalWis(int i) {
		_originalWis = i;
	}

	public void setPacketOutput(PacketOutput out) {
		_out = out;
	}

	public void setPartnerId(int i) {
		_partnerId = i;
	}

	public void setPartnersPrivateShopItemCount(int i) {
		_partnersPrivateShopItemCount = i;
	}

	public void setParty(L1Party p) {
		_party = p;
	}

	public void setPartyDropMessages(final boolean partyDropMessages) {
		_partyDropMessages = partyDropMessages;
	}

	public void setPartyID(int partyID) {
		_partyID = partyID;
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

	public void setPinkName(boolean flag) {
		_isPinkName = flag;
	}

	public void setPkCountForElf(int i) {
		_PkCountForElf = i;
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

	public void setPotionMessages(final boolean potionMessages) {
		_potionMessages = potionMessages;
	}

	public void setPrivateShop(boolean flag) {
		_isPrivateShop = flag;
	}

	public void setRegenState(int state) {
		_mpRegen.setState(state);
		_hpRegen.setState(state);
	}

	public void setShapeChange(boolean polyed) {
		_isShapeChange = polyed;
	}

	public void setShopChat(byte[] chat) {
		_shopChat = chat;
	}

	public void setShowTradeChat(boolean flag) {
		_showTradeChat = flag;
	}

	public void setShowWorldChat(boolean flag) {
		_showWorldChat = flag;
	}

	public void setSkillMastery(int skillid) {
		if (!skillList.contains(skillid)) {
			skillList.add(skillid);
		}
	}

	public void setSpoofMob(L1MonsterInstance mobToSpoof) {
		spoofMob = mobToSpoof;
	}

	public void setSpoofName(String name) {
		if (name != null && name.trim().equals("")) {
			throw new IllegalArgumentException("Spoof name cannot be blank.");
		}

		spoofName = name;
	}

	public void setSummonMonster(boolean summoned) {
		_isSummonMonster = summoned;
	}

	public void setTeleport(boolean flag) {
		_isTeleport = flag;
	}

	public void setTeleportHeading(int i) {
		_teleportHeading = i;
	}

	public void setTeleportMapId(short i) {
		_teleportMapId = i;
	}

	public void setTeleportX(int i) {
		_teleportX = i;
	}

	public void setTeleportY(int i) {
		_teleportY = i;
	}

	public void setTempCharGfxAtDead(int i) {
		_tempCharGfxAtDead = i;
	}

	public void setTempID(int tempID) {
		_tempID = tempID;
	}

	public void setTempLevel(int i) {
		_tempLevel = i;
	}

	public void setTempMaxLevel(int i) {
		_tempMaxLevel = i;
	}

	public void setTradeID(int tradeID) {
		_tradeID = tradeID;
	}

	public void setTradeOk(boolean tradeOk) {
		_tradeOk = tradeOk;
	}

	public void setTradingInPrivateShop(boolean flag) {
		_isTradingInPrivateShop = flag;
	}

	public void setType(int i) {
		_type = i;
	}

	public void setWeapon(L1ItemInstance weapon) {
		_weapon = weapon;
	}

	public boolean showTradeChat() {
		return _showTradeChat;
	}

	public boolean showWorldChat() {
		return _showWorldChat;
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
			attacker = (L1PcInstance) ((L1PetInstance) lastAttacker).getMaster();
		} else if (lastAttacker instanceof L1SummonInstance) {
			attacker = (L1PcInstance) ((L1SummonInstance) lastAttacker).getMaster();
		} else {
			return false;
		}

		for (L1War war : L1World.getInstance().getWarList()) {
			L1Clan clan = L1World.getInstance().getClan(getClanname());

			int warType = war.GetWarType();
			boolean isInWar = war.CheckClanInWar(getClanname());
			if (attacker != null && attacker.getClanid() != 0) {
				sameWar = war.CheckClanInSameWar(getClanname(), attacker.getClanname());
			}

			if (getId() == clan.getLeaderId() && warType == 2 && isInWar == true) {
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

	public void startHpRegeneration() {
		if (!_hpRegenActive) {
			_hpRegen = new HpRegeneration(this);
			_hpRegenFuture = GeneralThreadPool.getInstance().scheduleAtFixedRate(_hpRegen, HP_REGEN_INTERVAL,
					HP_REGEN_INTERVAL);
			_hpRegenActive = true;
		}
	}

	public void startMpReductionByAwake() {
		final int INTERVAL_BY_AWAKE = 4000;
		if (!_mpReductionActiveByAwake) {
			_mpReductionByAwake = new MpReductionByAwake(this);
			_mpReductionByAwakeFuture = GeneralThreadPool.getInstance().scheduleAtFixedRate(_mpReductionByAwake,
					INTERVAL_BY_AWAKE, INTERVAL_BY_AWAKE);
			_mpReductionActiveByAwake = true;
		}
	}

	public void startMpRegeneration() {
		if (!_mpRegenActive) {
			_mpRegen = new MpRegeneration(this);
			_mpRegenFuture = GeneralThreadPool.getInstance().scheduleAtFixedRate(_mpRegen, MP_REGEN_INTERVAL,
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
			_mpRegenByDollFuture = GeneralThreadPool.getInstance().scheduleAtFixedRate(_mpRegenByDoll, INTERVAL_BY_DOLL,
					INTERVAL_BY_DOLL);
			_mpRegenActiveByDoll = true;
		}
	}

	public void startObjectAutoUpdate() {
		removeAllKnownObjects();
		_autoUpdateFuture = GeneralThreadPool.getInstance().pcScheduleAtFixedRate(new L1PcAutoUpdate(getId()), 0L,
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

	public void stopHpRegeneration() {
		if (_hpRegenActive) {
			try {
				_hpRegenFuture.cancel(true);
				_hpRegen = null;
				_hpRegenActive = false;
			} catch (Exception e) {
				_log.error("", e);
			}
		}
	}

	public void stopMpReductionByAwake() {
		if (_mpReductionActiveByAwake) {
			try {
				_mpReductionByAwakeFuture.cancel(true);
				_mpReductionByAwake = null;
				_mpReductionActiveByAwake = false;
			} catch (Exception e) {
				_log.error("", e);
			}
		}
	}

	public void stopMpRegeneration() {
		if (_mpRegenActive) {
			try {
				_mpRegenFuture.cancel(true);
				_mpRegen = null;
				_mpRegenActive = false;
			} catch (Exception e) {
				_log.error("", e);
			}
		}
	}

	public void stopMpRegenerationByDoll() {
		if (_mpRegenActiveByDoll) {
			try {
				_mpRegenByDollFuture.cancel(true);
				_mpRegenByDoll = null;
				_mpRegenActiveByDoll = false;
			} catch (Exception e) {
				_log.error("", e);
			}
		}
	}

	public void stopPcDeleteTimer() {
		if (_pcDeleteTimer != null) {
			_pcDeleteTimer.cancel();
			_pcDeleteTimer = null;
		}
	}

	public void updateObject() {
		removeOutOfRangeObjects();

		for (L1Object visible : L1World.getInstance().getVisibleObjects(this, Config.PC_RECOGNIZE_RANGE)) {
			if (!knownsObject(visible)) {
				visible.onPerceive(this);
			} else {
				if (visible instanceof L1NpcInstance) {
					L1NpcInstance npc = (L1NpcInstance) visible;
					if (getLocation().isInScreen(npc.getLocation()) && npc.getHiddenStatus() != 0) {
						npc.approachPlayer(this);
					}
				}
			}
			if (hasSkillEffect(GMSTATUS_HPBAR) && L1HpBar.isHpBarTarget(visible)) {
				sendPackets(new S_HPMeter((L1Character) visible));
			}
		}
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
		} else if (isKnight()) {
		} else if (isElf()) {
			charisma += 12;
		} else if (isWizard()) {
			charisma += 6;
		} else if (isDarkelf()) {
		} else if (isDragonKnight()) {
		} else if (isIllusionist()) {
		}

		L1Pet l1pet = PetTable.getInstance().getTemplate(itemObjectId);
		if (l1pet != null) {
			int npcId = l1pet.get_npcid();
			charisma -= petCost;
			if (npcId == 45313 || npcId == 45710 || npcId == 45711 || npcId == 45712 || npcId == 46046) {
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

	private void caoPenaltyResult(int count) {
		for (int i = 0; i < count; i++) {
			L1ItemInstance item = getInventory().CaoPenalty();

			if (item != null) {
				getInventory().tradeItem(item, item.isStackable() ? item.getCount() : 1,
						L1World.getInstance().getInventory(getX(), getY(), getMapId()));
				sendPackets(new S_ServerMessage(638, item.getLogName()));
			} else {
			}
		}
	}

	private L1PcInstance getAttackingPlayer(L1Character lastAttacker) {
		L1PcInstance attackingPlayer = null;

		if (lastAttacker instanceof L1PcInstance) {
			attackingPlayer = (L1PcInstance) lastAttacker;
		} else if (lastAttacker instanceof L1PetInstance) {
			attackingPlayer = (L1PcInstance) ((L1PetInstance) lastAttacker).getMaster();
		} else if (lastAttacker instanceof L1SummonInstance) {
			attackingPlayer = (L1PcInstance) ((L1SummonInstance) lastAttacker).getMaster();
		}

		return attackingPlayer;
	}

	private L1PcInstance getStat() {
		return null;
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

	private void levelDown(int gap) {
		resetLevel();

		for (int i = 0; i > gap; i--) {
			short randomHp = CalcStat.calcStatHp(getType(), 0, getBaseCon(), getOriginalHpup());
			short randomMp = CalcStat.calcStatMp(getType(), 0, getBaseWis(), getOriginalMpup());
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
				_log.info("levelDown error:" + String.format("x_Ee%sfB", getName()));
			}
		}

		try {
			save();
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
		sendPackets(new S_OwnCharStatus(this));
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
					sendPackets(new S_SystemMessage("You use Revival Potion and have returned to level 1."));
				}
			} catch (Exception e) {
				_log.error(e.getLocalizedMessage(), e);
				sendPackets(new S_SystemMessage("Use of Revival Potion failed!"));
			}
		}

		for (int i = 0; i < gap; i++) {
			short randomHp = CalcStat.calcStatHp(getType(), getBaseMaxHp(), getBaseCon(), getOriginalHpup());
			short randomMp = CalcStat.calcStatMp(getType(), getBaseMaxMp(), getBaseWis(), getOriginalMpup());
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
			_log.error(e.getLocalizedMessage(), e);
		}
		if (getLevel() >= 51 && getLevel() - 50 > getBonusStats()) {
			if ((getBaseStr() + getBaseDex() + getBaseCon() + getBaseInt() + getBaseWis() + getBaseCha()) < 210) {
				sendPackets(new S_bonusstats(getId(), 1));
			}
		}
		// added hp/mp refill on lvl up
		setCurrentHp(getMaxHp());
		setCurrentMp(getMaxMp());

		sendPackets(new S_OwnCharStatus(this));

		if (getLevel() >= Config.NEWBIEMAPLEVELS) {
			if ((getMapId() == 68 || getMapId() == 69 || getMapId() == 2005 || getMapId() == 85 || getMapId() == 86)) {
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

	private void notifyPlayersLogout(List<L1PcInstance> playersArray) {
		for (L1PcInstance player : playersArray) {
			if (player.knownsObject(this)) {
				player.removeKnownObject(this);
				player.sendPackets(new S_RemoveObject(this));
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

	private void setGhost(boolean flag) {
		_ghost = flag;
	}

	private void setGhostCanTalk(boolean flag) {
		_ghostCanTalk = flag;
	}

	private void setGresValid(boolean valid) {
		_gresValid = valid;
	}

	private void setReserveGhost(boolean flag) {
		_isReserveGhost = flag;
	}
	
	private int _blessOfAin;

	public void setBlessOfAin(int i) {
		_blessOfAin = i;
	}

	public void calcBlessOfAin(int i) {
		int calc = _blessOfAin + i;
		if (calc >= 2000000) {
			calc = 2000000;
		}
		_blessOfAin = calc;
	}

	public int getBlessOfAin() {
		return _blessOfAin;
	}
	
	private Timestamp _logoutTime;

	public void setLogoutTime(Timestamp time) {
		_logoutTime = time;
	}

	public void setLogoutTime() {
		_logoutTime = new Timestamp(System.currentTimeMillis());
	}

	public Timestamp getLogoutTime() {
		return _logoutTime;
	}
	
	private int _monsterKill = 0; // number of mobs killed

	public int getMonsterKill() {
		return _monsterKill;
	}

	public void setMonsterKill(int i) {
		_monsterKill = i;
		sendPackets(new S_OwnCharStatus(this));
	}

	public void addMonsterKill(int i) {
		_monsterKill += i;
		sendPackets(new S_OwnCharStatus(this));
	}
}
