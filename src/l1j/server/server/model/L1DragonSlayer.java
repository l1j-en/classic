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
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.ActionCodes;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.Getback;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1NpcDeleteTimer;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_MapID;
import l1j.server.server.serverpackets.S_OtherCharPacks;
import l1j.server.server.serverpackets.S_OwnCharPack;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_Weather;
import l1j.server.server.utils.collections.Maps;

public class L1DragonSlayer {
	private static Logger _log = Logger.getLogger(L1DragonSlayer.class.getName());
	private static L1DragonSlayer _instance;
	public static final int STATUS_DRAGONSLAYER_NONE = 0;
	public static final int STATUS_DRAGONSLAYER_READY_1RD = 1;
	public static final int STATUS_DRAGONSLAYER_READY_2RD = 2;
	public static final int STATUS_DRAGONSLAYER_READY_3RD = 3;
	public static final int STATUS_DRAGONSLAYER_READY_4RD = 4;
	public static final int STATUS_DRAGONSLAYER_START_1RD = 5;
	public static final int STATUS_DRAGONSLAYER_START_2RD = 6;
	public static final int STATUS_DRAGONSLAYER_START_2RD_1 = 7;
	public static final int STATUS_DRAGONSLAYER_START_2RD_2 = 8;
	public static final int STATUS_DRAGONSLAYER_START_2RD_3 = 9;
	public static final int STATUS_DRAGONSLAYER_START_2RD_4 = 10;
	public static final int STATUS_DRAGONSLAYER_START_3RD = 11;
	public static final int STATUS_DRAGONSLAYER_START_3RD_1 = 12;
	public static final int STATUS_DRAGONSLAYER_START_3RD_2 = 13;
	public static final int STATUS_DRAGONSLAYER_START_3RD_3 = 14;
	public static final int STATUS_DRAGONSLAYER_END_1 = 15;
	public static final int STATUS_DRAGONSLAYER_END_2 = 16;
	public static final int STATUS_DRAGONSLAYER_END_3 = 17;
	public static final int STATUS_DRAGONSLAYER_END_4 = 18;
	public static final int STATUS_DRAGONSLAYER_END_5 = 19;
	public static final int STATUS_DRAGONSLAYER_END = 20;
	public static final int STATUS_NONE = 0;
	public static final int STATUS_READY_SPAWN = 1;
	public static final int STATUS_SPAWN = 2;
	private static Random _random = new Random();
	
	private static class DragonSlayer {
		private ArrayList<L1PcInstance> _members = new ArrayList<L1PcInstance>();
	}

	private static final Map<Integer, DragonSlayer> _dataMap = Maps.newMap();

	public static L1DragonSlayer getInstance() {
		if (_instance == null) {
			_instance = new L1DragonSlayer();
		}
		return _instance;
	}

	private boolean[] _portalNumber = new boolean[12];

	public boolean[] getPortalNumber() {
		return _portalNumber;
	}

	public void setPortalNumber(int number, boolean i) {
		_portalNumber[number] = i;
	}

	private boolean[] _checkDragonPortal = new boolean[4];

	public boolean[] checkDragonPortal() {
		_checkDragonPortal[0] = false;
		_checkDragonPortal[1] = false;
		_checkDragonPortal[2] = false;
		_checkDragonPortal[3] = false;

		for (int i = 0; i < 12; i++) {
			if (!getPortalNumber()[i]) {
				if (i < 6) {
					_checkDragonPortal[0] = true;
				} else {
					_checkDragonPortal[1] = true;
				}
			}
		}
		return _checkDragonPortal;
	}

	private L1NpcInstance[] _portal = new L1NpcInstance[12];

	public L1NpcInstance[] portalPack() {
		return _portal;
	}

	public void setPortalPack(int number, L1NpcInstance portal) {
		_portal[number] = portal;
	}

	private int[] _DragonSlayerStatus = new int[12];

	public int[] getDragonSlayerStatus() {
		return _DragonSlayerStatus;
	}

	public void setDragonSlayerStatus(int portalNum, int i) {
		_DragonSlayerStatus[portalNum] = i;
	}

	private int _hiddenDragonValleyStstus = 0;

	public int checkHiddenDragonValleyStstus() {
		return _hiddenDragonValleyStstus;
	}

	public void setHiddenDragonValleyStstus(int i) {
		_hiddenDragonValleyStstus = i;
	}

	public void addPlayerList(L1PcInstance pc, int portalNum) {
		if (_dataMap.containsKey(portalNum)) {
			if (!_dataMap.get(portalNum)._members.contains(pc)) {
				_dataMap.get(portalNum)._members.add(pc);
			}
		}
	}

	public void removePlayer(L1PcInstance pc, int portalNum) {
		if (_dataMap.containsKey(portalNum)) {
			if (_dataMap.get(portalNum)._members.contains(pc)) {
				_dataMap.get(portalNum)._members.remove(pc);
			}
		}
	}

	private void clearPlayerList(int portalNum) {
		if (_dataMap.containsKey(portalNum)) {
			_dataMap.get(portalNum)._members.clear();
		}
	}

	public int getPlayersCount(int num) {
		DragonSlayer _DragonSlayer = null;
		if (!_dataMap.containsKey(num)) {
			_DragonSlayer = new DragonSlayer();
			_dataMap.put(num, _DragonSlayer);
		}
		return _dataMap.get(num)._members.size();
	}

	private L1PcInstance[] getPlayersArray(int num) {
		return _dataMap.get(num)._members.toArray(new L1PcInstance[_dataMap.get(num)._members.size()]);
	}

	public void startDragonSlayer(int portalNum) {
		if (getDragonSlayerStatus()[portalNum] == STATUS_DRAGONSLAYER_NONE) {
			setDragonSlayerStatus(portalNum, STATUS_DRAGONSLAYER_READY_1RD);
			DragonSlayerTimer timer = new DragonSlayerTimer(portalNum, STATUS_DRAGONSLAYER_READY_1RD, 150000);
			timer.begin();
		}
	}

	public void startDragonSlayer2rd(int portalNum) {
		if (getDragonSlayerStatus()[portalNum] == STATUS_DRAGONSLAYER_START_1RD) {
			if (portalNum >= 6 && portalNum <= 11) {
				sendMessage(portalNum, 1661, null);
			} else {
				sendMessage(portalNum, 1573, null);
			}
			setDragonSlayerStatus(portalNum, STATUS_DRAGONSLAYER_START_2RD);
			DragonSlayerTimer timer = new DragonSlayerTimer(portalNum, STATUS_DRAGONSLAYER_START_2RD, 10000);
			timer.begin();
		}
	}

	public void startDragonSlayer3rd(int portalNum) {
		if (getDragonSlayerStatus()[portalNum] == STATUS_DRAGONSLAYER_START_2RD_4) {
			if (portalNum >= 6 && portalNum <= 11) {
				sendMessage(portalNum, 1665, null);
			} else {
				sendMessage(portalNum, 1577, null);
			}
			setDragonSlayerStatus(portalNum, STATUS_DRAGONSLAYER_START_3RD);
			DragonSlayerTimer timer = new DragonSlayerTimer(portalNum, STATUS_DRAGONSLAYER_START_3RD, 10000);
			timer.begin();
		}
	}

	public void endDragonSlayer(int portalNum) {
		if (getDragonSlayerStatus()[portalNum] == STATUS_DRAGONSLAYER_START_3RD_3) {
			setDragonSlayerStatus(portalNum, STATUS_DRAGONSLAYER_END_1);
			DragonSlayerTimer timer = new DragonSlayerTimer(portalNum, STATUS_DRAGONSLAYER_END_1, 10000);
			timer.begin();
		}
	}

	public void endDragonPortal(int portalNum) {
		if (getDragonSlayerStatus()[portalNum] != STATUS_DRAGONSLAYER_END_5) {
			setDragonSlayerStatus(portalNum, STATUS_DRAGONSLAYER_END_5);
			DragonSlayerTimer timer = new DragonSlayerTimer(portalNum, STATUS_DRAGONSLAYER_END_5, 5000);
			timer.begin();
		}
	}

	public class DragonSlayerTimer extends TimerTask {

		private final int _num;
		private final int _status;
		private final int _time;

		public DragonSlayerTimer(int num, int status, int time) {
			_num = num;
			_status = status;
			_time = time;
		}

		@Override
		public void run() {
			short mapId = (short) (1005 + _num);
			int[] msg = { 1570, 1571, 1572, 1574, 1575, 1576, 1578, 1579, 1581 };
			if (_num >= 6 && _num <= 11) {
				msg = new int[] { 1657, 1658, 1659, 1662, 1663, 1664, 1666, 1667, 1669};
			}
			switch (_status) {
				case STATUS_DRAGONSLAYER_READY_1RD:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_READY_2RD);
					sendMessage(_num, msg[0], null);
					DragonSlayerTimer timer_1rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_READY_2RD, 10000);
					timer_1rd.begin();
					break;
				case STATUS_DRAGONSLAYER_READY_2RD:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_READY_3RD);
					sendMessage(_num, msg[1], null);
					DragonSlayerTimer timer_2rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_READY_3RD, 10000);
					timer_2rd.begin();
					break;
				case STATUS_DRAGONSLAYER_READY_3RD:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_READY_4RD);
					sendMessage(_num, msg[2], null);
					DragonSlayerTimer timer_3rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_READY_4RD, 10000);
					timer_3rd.begin();
					break;
				case STATUS_DRAGONSLAYER_READY_4RD:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_START_1RD);
					if (_num >= 0 && _num <= 5) {
						spawn(97006, _num, 32783, 32693, mapId, 10, 0);
					} else {
						spawn(97044, _num, 32955, 32839, mapId, 10, 0);
					}
					break;
				// 階段二
				case STATUS_DRAGONSLAYER_START_2RD:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_START_2RD_1);
					sendMessage(_num, msg[3], null);
					DragonSlayerTimer timer_4rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_START_2RD_1, 10000);
					timer_4rd.begin();
					break;
				case STATUS_DRAGONSLAYER_START_2RD_1:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_START_2RD_2);
					sendMessage(_num, msg[4], null);
					DragonSlayerTimer timer_5rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_START_2RD_2, 30000);
					timer_5rd.begin();
					break;
				case STATUS_DRAGONSLAYER_START_2RD_2:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_START_2RD_3);
					sendMessage(_num, msg[5], null);
					DragonSlayerTimer timer_6rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_START_2RD_3, 10000);
					timer_6rd.begin();
					break;
				case STATUS_DRAGONSLAYER_START_2RD_3:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_START_2RD_4);
					if (_num >= 0 && _num <= 5) {
						spawn(97007, _num, 32783, 32693, mapId, 10, 0);
					} else {
						spawn(97045, _num, 32955, 32839, mapId, 10, 0);
					}
					break;
				// 階段三
				case STATUS_DRAGONSLAYER_START_3RD:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_START_3RD_1);
					sendMessage(_num, msg[6], null);
					DragonSlayerTimer timer_7rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_START_3RD_1, 40000);
					timer_7rd.begin();
					break;
				case STATUS_DRAGONSLAYER_START_3RD_1:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_START_3RD_2);
					sendMessage(_num, msg[7], null);
					DragonSlayerTimer timer_8rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_START_3RD_2, 10000);
					timer_8rd.begin();
					break;
				case STATUS_DRAGONSLAYER_START_3RD_2:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_START_3RD_3);
					if (_num >= 0 && _num <= 5) {
						spawn(97008, _num, 32783, 32693, mapId, 10, 0);
					} else {
						spawn(97046, _num, 32955, 32839, mapId, 10, 0);
					}
					break;
				case STATUS_DRAGONSLAYER_END_1:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_END_2);
					sendMessage(_num, msg[8], null);
					if (checkHiddenDragonValleyStstus() == STATUS_NONE) {
						setHiddenDragonValleyStstus(STATUS_READY_SPAWN);
						DragonSlayerTimer timer_9rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_END_2, 10000);
						timer_9rd.begin();
					} else {
						if (getDragonSlayerStatus()[_num] != STATUS_DRAGONSLAYER_END_5) {
							setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_END_5);
							DragonSlayerTimer timer = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_END_5, 5000);
							timer.begin();
						}
					}
					break;
				case STATUS_DRAGONSLAYER_END_2:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_END_3);
					sendMessage(_num, 1582, null);
					if (checkHiddenDragonValleyStstus() == STATUS_READY_SPAWN) {
						setHiddenDragonValleyStstus(STATUS_SPAWN);
						spawn(81277, -1, 33726, 32506, (short) 4, 0, 86400000);
					}
					DragonSlayerTimer timer_10rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_END_3, 5000);
					timer_10rd.begin();
					break;
				case STATUS_DRAGONSLAYER_END_3:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_END_4);
					sendMessage(_num, 1583, null);
					DragonSlayerTimer timer_11rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_END_4, 5000);
					timer_11rd.begin();
					break;
				case STATUS_DRAGONSLAYER_END_4:
					setDragonSlayerStatus(_num, STATUS_DRAGONSLAYER_END_5);
					sendMessage(_num, 1584, null);
					DragonSlayerTimer timer_12rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_END_5, 5000);
					timer_12rd.begin();
					break;
				case STATUS_DRAGONSLAYER_END_5:
					if (portalPack()[_num] != null) {
						portalPack()[_num].setStatus(ActionCodes.ACTION_Die);
						portalPack()[_num].broadcastPacket(new S_DoActionGFX(portalPack()[_num].getId(), ActionCodes.ACTION_Die));
						portalPack()[_num].deleteMe();
					}
					resetDragonSlayer(_num);
					DragonSlayerTimer timer_13rd = new DragonSlayerTimer(_num, STATUS_DRAGONSLAYER_END, 300000);
					timer_13rd.begin();
					break;
				case STATUS_DRAGONSLAYER_END:
					setPortalNumber(_num, false);
					break;
			}
			cancel();
		}

		public void begin() {
			Timer timer = new Timer();
			timer.schedule(this, _time);
		}
	}

	public void sendMessage(int portalNum, int type, String msg) {
		short mapId = (short) (1005 + portalNum);
		L1PcInstance[] temp = getPlayersArray(portalNum);
		for (L1PcInstance element : temp) {
			if ((element.getMapId() == mapId)
					&& (element.getX() >= 32740 && element.getX() <= 32827)
					&& (element.getY() >= 32652 && element.getY() <= 32727)
					&& (portalNum >= 0 && portalNum <= 5)) {
				element.sendPackets(new S_ServerMessage(type, msg));
			} else if ((element.getMapId() == mapId)
					&& (element.getX() >= 32921 && element.getX() <= 33009)
					&& (element.getY() >= 32799 && element.getY() <= 32869)
					&& (portalNum >= 6 && portalNum <= 11)) {
				element.sendPackets(new S_ServerMessage(type, msg));
			}
		}
	}

	public void resetDragonSlayer(int portalNumber) {
		short mapId = (short) (1005 + portalNumber);

		for (Object obj : L1World.getInstance().getVisibleObjects(mapId).values()) {
			if (obj instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) obj;
				if (pc != null) {
					if (pc.isDead()) {
						reStartPlayer(pc);
					} else {
						pc.setPortalNumber(-1);
						L1Teleport.teleport(pc, 33710, 32521, (short) 4, pc.getHeading(), true);
					}
				}
			}
			else if (obj instanceof L1DoorInstance) {
				L1DoorInstance door = (L1DoorInstance) obj;
				door.close();
			}
			else if (obj instanceof L1NpcInstance) {
				L1NpcInstance npc = (L1NpcInstance) obj;
				if ((npc.getMaster() == null)
						&& (npc.getNpcTemplate().get_npcId() < 81301 && npc.getNpcTemplate().get_npcId() > 81306)) {
					npc.deleteMe();
				}
			}
			else if (obj instanceof L1Inventory) {
				L1Inventory inventory = (L1Inventory) obj;
				inventory.clearItems();
			}
		}
		setPortalPack(portalNumber, null);
		setDragonSlayerStatus(portalNumber, STATUS_DRAGONSLAYER_NONE);
		clearPlayerList(portalNumber);
	}

	private void reStartPlayer(L1PcInstance pc) {
		pc.stopPcDeleteTimer();

		int[] loc = Getback.GetBack_Location(pc, true);

		pc.removeAllKnownObjects();
		pc.broadcastPacket(new S_RemoveObject(pc));
		pc.setCurrentHp(pc.getLevel());
		pc.set_food(40);
		pc.setDead(false);
		pc.setStatus(0);
		L1World.getInstance().moveVisibleObject(pc, loc[2]);
		pc.setX(loc[0]);
		pc.setY(loc[1]);
		pc.setMap((short) loc[2]);
		pc.sendPackets(new S_MapID(pc.getMapId(), 
		pc.getMap().isUnderwater()));
		pc.broadcastPacket(new S_OtherCharPacks(pc));
		pc.sendPackets(new S_OwnCharPack(pc));
		pc.sendPackets(new S_CharVisualUpdate(pc));
		pc.startHpRegeneration();
		pc.startMpRegeneration();
		pc.sendPackets(new S_Weather(L1World.getInstance().getWeather()));
		if (pc.getHellTime() > 0) {
			pc.beginHell(false);
		}
	}

	public void spawn(int npcId, int portalNumber, int X, int Y, short mapId, int randomRange,
			int timeMillisToDelete) {
		try {
			L1NpcInstance npc = NpcTable.getInstance().newNpcInstance(npcId);
			npc.setId(IdFactory.getInstance().nextId());
			npc.setMap(mapId);

			if (randomRange == 0) {
				npc.setX(X);
				npc.setY(Y);
			} else {
				int tryCount = 0;
				do {
					tryCount++;
					npc.setX(X + _random.nextInt(randomRange) - _random.nextInt(randomRange));
					npc.setY(Y + _random.nextInt(randomRange) - _random.nextInt(randomRange));
					if (npc.getMap().isInMap(npc.getLocation())
							&& npc.getMap().isPassable(npc.getLocation())) {
						break;
					}
					Thread.sleep(1);
				} while (tryCount < 50);

				if (tryCount >= 50) {
					npc.setX(X);
					npc.setY(Y);
				}
			}

			npc.setHomeX(npc.getX());
			npc.setHomeY(npc.getY());
			npc.setHeading(_random.nextInt(8));
			npc.setPortalNumber(portalNumber);

			L1World.getInstance().storeObject(npc);
			L1World.getInstance().addVisibleObject(npc);

			if (npc.getGfxId() == 7548 || npc.getGfxId() == 7550 || npc.getGfxId() == 7552
					|| npc.getGfxId() == 7554 || npc.getGfxId() == 7585
					|| npc.getGfxId() == 7539 || npc.getGfxId() == 7557 || npc.getGfxId() == 7558
					|| npc.getGfxId() == 7864 || npc.getGfxId() == 7869 || npc.getGfxId() == 7870) {
				npc.npcSleepTime(ActionCodes.ACTION_AxeWalk, L1NpcInstance.ATTACK_SPEED);
				for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(npc)) {
					npc.onPerceive(pc);
					S_DoActionGFX gfx = new S_DoActionGFX(npc.getId(), ActionCodes.ACTION_AxeWalk);
					pc.sendPackets(gfx);
				}
			}

			npc.turnOnOffLight();
			npc.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE);
			
			if (0 < timeMillisToDelete) {
				L1NpcDeleteTimer timer = new L1NpcDeleteTimer(npc,
						timeMillisToDelete);
				timer.begin();
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}
}
