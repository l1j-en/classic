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

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import l1j.server.Config;
import l1j.server.server.datatables.DoorTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_EffectLocation;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_Race;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillBrave;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.collections.Lists;

public class L1PolyRace {
	public static final int[] SKILL_TYPE = { 0, 1, 2, 3, 4 };
	public static final int STATUS_NONE = 0;
	public static final int STATUS_READY = 1;
	public static final int STATUS_PLAYING = 2;
	public static final int STATUS_END = 3;
	private static final int maxLap = Config.PET_RACE_MAX_LAP;
	private static final int maxPlayer = 10; // 1~20
	private static final int minPlayer = Config.PET_RACE_MIN_PLAYER;
	private static int readyTime = 5 * 1000;
	private static int limitTime = 300 * 1000;
	private final List<L1PcInstance> playerList = Lists.newArrayList();
	private final int[] polyList = { 936, 3134, 1642, 931, 96, 4038, 929, 1540,
			3783, 934, 3918, 3199, 3184, 3132, 3107, 3188, 3211, 3143, 3156,
			3154, 3178, 4133, 5089, 945, 4171, 2541, 2001, 1649, 29, };
	private final int[] startpolyList = { 938, 2145, 3182, 5065 };
	private final int[] fragment = { 50515, 50516, 50518, 50519 };
	private static Random _random = new Random();
	private static L1PolyRace instance;

	public static L1PolyRace getInstance() {
		if (instance == null) {
			instance = new L1PolyRace();
		}
		return instance;
	}

	public void addPlayerList(L1PcInstance pc) {
		if (!playerList.contains(pc)) {
			playerList.add(pc);
		}
	}

	public void removePlayerList(L1PcInstance pc) {
		if (playerList.contains(pc)) {
			playerList.remove(pc);
		}
	}

	private final List<L1PcInstance> goalList = Lists.newArrayList();

	public void enterGame(L1PcInstance pc) {
		if (pc.getLevel() < 30) {
			pc.sendPackets(new S_ServerMessage(1273, "30", "99"));
			return;
		}
		if (!pc.getInventory().consumeItem(40308, 1000)) {
			pc.sendPackets(new S_ServerMessage(189));
			return;
		}
		if (playerList.size() + orderList.size() >= maxPlayer) {
			pc.sendPackets(new S_SystemMessage(
					"Max amount of players reached for the polyrace"));
			return;
		}
		if (getGameStatus() == STATUS_PLAYING || getGameStatus() == STATUS_END) {
			pc.sendPackets(new S_ServerMessage(1182));
			return;
		}
		if (getGameStatus() == STATUS_NONE) {
			addOrderList(pc);
			return;
		}

		addPlayerList(pc);
		goalList.add(pc);
		L1Teleport.teleport(pc, 32768, 32849, (short) 5143, 6, true);
		pc.getInventory().takeoffEquip(945);
		removeSkillEffect(pc);
	}

	private final List<L1PcInstance> orderList = Lists.newArrayList();

	public void removeOrderList(L1PcInstance pc) {
		orderList.remove(pc);
	}

	public void addOrderList(L1PcInstance pc) {
		if (orderList.contains(pc)) {
			pc.sendPackets(new S_ServerMessage(1254));
			return;
		}
		orderList.add(pc);
		pc.setInOrderList(true);
		pc.sendPackets(new S_ServerMessage(1253, String.valueOf(orderList
				.size())));
		if (orderList.size() >= minPlayer) {
			for (L1PcInstance player : orderList) {
				player.sendPackets(new S_Message_YN(1256, null));
			}
			setGameStatus(STATUS_READY);
			startReadyTimer();
		}
	}

	private boolean checkPlayersOK() {
		if (getGameStatus() == STATUS_READY) {
			return playerList.size() >= minPlayer;
		}
		return false;
	}

	private void setGameStart() {
		setGameStatus(STATUS_PLAYING);
		int startpoly = _random.nextInt(startpolyList.length);
		int basepoly = startpolyList[startpoly];

		for (L1PcInstance pc : playerList) {
			L1PolyMorph.doPoly(pc, basepoly, 3600, L1PolyMorph.MORPH_BY_NPC);
			pc.setBasePoly(basepoly); // poly id
			pc.sendPackets(new S_ServerMessage(1257));
			pc.sendPackets(new S_Race(S_Race.GameStart));// 5.4.3.2.1.GO!
			pc.sendPackets(new S_Race(maxLap, pc.getLap()));
			pc.sendPackets(new S_Race(playerList, pc));
		}
		startCompareTimer();
		startClockTimer();
	}

	private void setGameWinner(L1PcInstance pc) {
		if (get1stWinner() == null) {
			set1stWinner(pc);
			startWaitTimer();
		} else if (get2ndWinner() == null) {
			set2ndWinner(pc);

		} else if (get3rdWinner() == null) {
			set3rdWinner(pc);
		}
		setWinner(pc);
		L1PcInstance winner = getWinner();
		for (L1PcInstance pc1 : goalList) {
			pc1.sendPackets(new S_Race(winner.getName(), _time * 2));
		}
		goalList.remove(pc);
	}

	private static final int END_STATUS_WINNER = 1;
	private static final int END_STATUS_NOWINNER = 2;
	private static final int END_STATUS_NOPLAYER = 3;

	private void setGameEnd(int type) {
		setGameStatus(STATUS_END);
		switch (type) {
		case END_STATUS_WINNER:
			stopCompareTimer();
			stopGameTimeLimitTimer();
			sendEndMessage();
			break;
		case END_STATUS_NOWINNER:
			stopCompareTimer();
			sendEndMessage();
			for (L1PcInstance pc : playerList) {
				continue;
			}
			break;
		case END_STATUS_NOPLAYER:
			for (L1PcInstance pc : playerList) {
				pc.sendPackets(new S_SystemMessage(Config.PET_RACE_MIN_PLAYER
						+ " players " + "get ready for the petrace"));
				pc.getInventory().storeItem(40308, 1000);
			}
			break;
		}
		startEndTimer();
	}

	private void giftWinner() {
		L1PcInstance winner1 = get1stWinner();
		L1PcInstance winner2 = get2ndWinner();
		L1PcInstance winner3 = get3rdWinner();
		L1ItemInstance item1 = ItemTable.getInstance().createItem(49278);
		L1ItemInstance item2 = ItemTable.getInstance().createItem(49279);
		L1ItemInstance item3 = ItemTable.getInstance().createItem(49280);

		if (playerList.size() <= 4) {
			if (winner1 == null || item1 == null) {
				return;
			}
			if (winner1.getInventory().checkAddItem(item1, 1) == L1Inventory.OK) {
				item1.setCount(1);
				winner1.getInventory().storeItem(item1);
				winner1.sendPackets(new S_ServerMessage(403, item1.getLogName()));
			}
		} else if (playerList.size() <= 5 && playerList.size() >= 7) {
			if (winner1 == null || item1 == null) {
				return;
			}
			if (winner1.getInventory().checkAddItem(item1, 1) == L1Inventory.OK) {
				item1.setCount(1);
				winner1.getInventory().storeItem(item1);
				winner1.sendPackets(new S_ServerMessage(403, item1.getLogName()));
			} else if (winner2.getInventory().checkAddItem(item2, 1) == L1Inventory.OK) {
				item2.setCount(1);
				winner2.getInventory().storeItem(item2);
				winner2.sendPackets(new S_ServerMessage(403, item2.getLogName()));
			}
		} else if (playerList.size() >= 8) {
			if (winner1 == null || item1 == null) {
				return;
			}
			if (winner1.getInventory().checkAddItem(item1, 1) == L1Inventory.OK) {
				item1.setCount(1);
				winner1.getInventory().storeItem(item1);
				winner1.sendPackets(new S_ServerMessage(403, item1.getLogName()));
			} else if (winner2.getInventory().checkAddItem(item2, 1) == L1Inventory.OK) {
				item2.setCount(1);
				winner2.getInventory().storeItem(item2);
				winner2.sendPackets(new S_ServerMessage(403, item2.getLogName()));
			} else if (winner3.getInventory().checkAddItem(item3, 1) == L1Inventory.OK) {
				item3.setCount(1);
				winner3.getInventory().storeItem(item3);
				winner3.sendPackets(new S_ServerMessage(403, item3.getLogName()));
			}
		}

		int rnd1 = _random.nextInt(100) + 1;
		int rnd2 = _random.nextInt(100) + 1;
		int rnd3 = _random.nextInt(100) + 1;
		L1ItemInstance item4 = ItemTable.getInstance().createItem(50517);
		if (rnd1 >= 1 && rnd1 <= 100) {
			if (rnd2 >= 1 && rnd2 <= 100) {
				winner2 = null;
				winner3 = null;
				fragment(rnd3, winner1, winner2, winner3, item4);
			} else if (rnd2 >= 51 && rnd2 <= 80) {
				winner3 = null;
				fragment(rnd3, winner1, winner2, winner3, item4);
			} else if (rnd2 >= 81 && rnd2 <= 100) {
				fragment(rnd3, winner1, winner2, winner3, item4);
			}
		}
	}

	/**
	 * @param rnd3
	 * @param winner1
	 * @param winner2
	 * @param winner3
	 * @param item4
	 */
	private void fragment(int rnd3, L1PcInstance winner1, L1PcInstance winner2,
			L1PcInstance winner3, L1ItemInstance item4) {
		if (winner1.getInventory().checkAddItem(item4, 1) == L1Inventory.OK) {
			item4.setCount(1);
			winner1.getInventory().storeItem(item4);
			winner1.sendPackets(new S_ServerMessage(403, item4.getLogName()));
		}
		if (rnd3 >= 1 && rnd3 <= 40) {
			int i = _random.nextInt(fragment.length);
			L1ItemInstance item5 = ItemTable.getInstance().createItem(
					fragment[i]);
			if (winner1.getInventory().checkAddItem(item5, 1) == L1Inventory.OK) {
				item4.setCount(1);
				winner1.getInventory().storeItem(item5);
				winner1.sendPackets(new S_ServerMessage(403, item5.getLogName()));
			}
		}
		if (winner2 == null) {
			return;
		} else {
			if (winner2.getInventory().checkAddItem(item4, 1) == L1Inventory.OK) {
				item4.setCount(1);
				winner2.getInventory().storeItem(item4);
				winner2.sendPackets(new S_ServerMessage(403, item4.getLogName()));
			}
			if (rnd3 >= 1 && rnd3 <= 40) {
				int i = _random.nextInt(fragment.length);
				L1ItemInstance item5 = ItemTable.getInstance().createItem(
						fragment[i]);
				if (winner2.getInventory().checkAddItem(item5, 1) == L1Inventory.OK) {
					item4.setCount(1);
					winner2.getInventory().storeItem(item5);
					winner2.sendPackets(new S_ServerMessage(403, item5
							.getLogName()));
				}
			}
		}
		if (winner3 == null) {
			return;
		} else {
			if (winner3.getInventory().checkAddItem(item4, 1) == L1Inventory.OK) {
				item4.setCount(1);
				winner3.getInventory().storeItem(item4);
				winner3.sendPackets(new S_ServerMessage(403, item4.getLogName()));
			}
			if (rnd3 >= 1 && rnd3 <= 40) {
				int i = _random.nextInt(fragment.length);
				L1ItemInstance item5 = ItemTable.getInstance().createItem(
						fragment[i]);
				if (winner3.getInventory().checkAddItem(item5, 1) == L1Inventory.OK) {
					item4.setCount(1);
					winner3.getInventory().storeItem(item5);
					winner3.sendPackets(new S_ServerMessage(403, item5
							.getLogName()));
				}
			}
		}
	}

	private void sendEndMessage() {
		L1PcInstance winner = get1stWinner();
		for (L1PcInstance pc : playerList) {
			if (winner != null) {
				pc.sendPackets(new S_ServerMessage(1259));
				continue;
			}
			pc.sendPackets(new S_Race(S_Race.GameOver));
		}
	}

	private void setGameInit() {
		for (L1PcInstance pc : playerList) {
			pc.sendPackets(new S_Race(S_Race.GameEnd));
			pc.setLap(1);
			pc.setLapCheck(0);
			L1Teleport.teleport(pc, 32616, 32782, (short) 4, 5, true);
			pc.setBasePoly(0);
			removeSkillEffect(pc);
		}
		setDoorClose(true);
		setGameStatus(STATUS_NONE);
		setWinner(null);
		set1stWinner(null);
		set2ndWinner(null);
		set3rdWinner(null);
		playerList.clear();
		goalList.clear();
		clearTime();
	}

	public void checkLeaveGame(L1PcInstance pc) {
		if (pc.getMapId() == 5143) {
			removePlayerList(pc);
			L1PolyMorph.undoPoly(pc);
		}
		if (pc.isInOrderList()) {
			removeOrderList(pc);
		}
	}

	public void requsetAttr(L1PcInstance pc, int c) {
		if (c == 0) { // NO
			removeOrderList(pc);
			pc.setInOrderList(false);
			pc.sendPackets(new S_ServerMessage(1255));
		} else { // YES
			addPlayerList(pc);
			goalList.add(pc);
			L1Teleport.teleport(pc, 32768, 32849, (short) 5143, 6, true);
			pc.getInventory().takeoffEquip(945);
			removeSkillEffect(pc);
			removeOrderList(pc);
			pc.setInOrderList(false);
		}
	}

	private final List<L1PcInstance> position = Lists.newArrayList();

	private void comparePosition() {
		List<L1PcInstance> temp = Lists.newArrayList();
		int size = playerList.size();
		int count = 0;
		while (size > count) {
			int maxLapScore = 0;
			for (L1PcInstance pc : playerList) {
				if (temp.contains(pc)) {
					continue;
				}
				if (pc.getLapScore() >= maxLapScore) {
					maxLapScore = pc.getLapScore();
				}
			}
			for (L1PcInstance player : playerList) {
				if (player.getLapScore() == maxLapScore) {
					temp.add(player);
				}
			}
			count++;
		}
		if (!position.equals(temp)) {
			position.clear();
			position.addAll(temp);
			for (L1PcInstance pc : playerList) {
				pc.sendPackets(new S_Race(position, pc));
			}
		}
	}

	private void setDoorClose(boolean isClose) {
		L1DoorInstance[] list = DoorTable.getInstance().getDoorList();
		for (L1DoorInstance door : list) {
			if (door.getMapId() == 5143) {
				if (isClose) {
					door.close();
				} else {
					door.open();
				}
			}
		}
	}

	public void removeSkillEffect(L1PcInstance pc) {
		L1SkillUse skill = new L1SkillUse();
		skill.handleCommands(pc, L1SkillId.CANCELLATION, pc.getId(), pc.getX(),
				pc.getY(), null, 0, SKILL_TYPE[1]);
	}

	private void onEffectTrap(L1PcInstance pc) {
		int x = pc.getX();
		int y = pc.getY();
		if (x == 32748 && (y == 32845 || y == 32846)) {
			speedUp(pc, 32748, 32845);
		} else if (x == 32748 && (y == 32847 || y == 32848)) {
			speedUp(pc, 32748, 32847);
		} else if (x == 32748 && (y == 32849 || y == 32850)) {
			speedUp(pc, 32748, 32849);
		} else if (x == 32748 && y == 32851) {
			speedUp(pc, 32748, 32851);
		} else if (x == 32762 && (y == 32811 || y == 32812)) {
			speedUp(pc, 32762, 32811);
		} else if ((x == 32799 || x == 32800) && y == 32830) {
			speedUp(pc, 32800, 32830);
		} else if ((x == 32736 || x == 32737) && y == 32840) {
			randomPoly(pc, 32737, 32840);
			speedUp2(pc, 32737, 32840);
		} else if ((x == 32738 || x == 32739) && y == 32840) {
			randomPoly(pc, 32739, 32840);
			speedUp2(pc, 32739, 32840);
		} else if ((x == 32740 || x == 32741) && y == 32840) {
			randomPoly(pc, 32741, 32840);
			speedUp2(pc, 32741, 32840);
		} else if (x == 32749 && (y == 32818 || y == 32817)) {
			randomPoly(pc, 32749, 32817);
		} else if (x == 32749 && (y == 32816 || y == 32815)) {
			randomPoly(pc, 32749, 32815);
		} else if (x == 32749 && (y == 32814 || y == 32813)) {
			randomPoly(pc, 32749, 32813);
		} else if (x == 32749 && (y == 32812 || y == 32811)) {
			randomPoly(pc, 32749, 32811);
		} else if (x == 32790 && (y == 32812 || y == 32813)) {
			randomPoly(pc, 32790, 32812);
			speedUp2(pc, 32790, 32812);
		} else if ((x == 32793 || x == 32794) && y == 32831) {
			randomPoly(pc, 32794, 32831);
			speedUp2(pc, 32794, 32831);
		}
	}

	private static int POLY_EFFECT = 15566;
	private static int SPEED_EFFECT = 18333;
	private static int SPEED_EFFECT2 = 18333;

	private void randomPoly(L1PcInstance pc, int x, int y) {
		if (pc.hasSkillEffect(POLY_EFFECT)) {
			return;
		}
		pc.setSkillEffect(POLY_EFFECT, 4 * 1000);

		int i = _random.nextInt(polyList.length);
		L1PolyMorph.doPoly(pc, polyList[i], 30, L1PolyMorph.MORPH_BY_NPC);

		for (L1PcInstance player : playerList) {
			player.sendPackets(new S_EffectLocation(x, y, 6675));
		}
	}

	private void speedUp(L1PcInstance pc, int x, int y) {
		pc.setSkillEffect(SPEED_EFFECT, 15 * 1000);
		int time = 15;
		int objectId = pc.getId();
		pc.sendPackets(new S_SkillBrave(objectId, 5, time));
		pc.setSkillEffect(L1SkillId.STATUS_BRAVE, time * 1000);
		pc.setSkillEffect(L1SkillId.STATUS_BRAVE2, time * 1000);
		pc.setBraveSpeed(1);
		/**
		 * XXX pc.broadcastPacket(new S_SkillBrave(objectId, 5, time))!!!
		 */
		pc.broadcastPacket(new S_SkillBrave(objectId, 5, time));
		for (L1PcInstance player : playerList) {
			player.sendPackets(new S_EffectLocation(x, y, 6674));
		}
	}

	private void speedUp2(L1PcInstance pc, int x, int y) {
		pc.setSkillEffect(SPEED_EFFECT2, 15 * 1000);
		int time = 30;
		int objectId = pc.getId();
		pc.sendPackets(new S_SkillHaste(objectId, 1, time));
		pc.setSkillEffect(L1SkillId.STATUS_HASTE, time * 1000);
		pc.setMoveSpeed(1);
	}

	public void checkLapFinish(L1PcInstance pc) {
		if (pc.getMapId() != 5143 || getGameStatus() != STATUS_PLAYING) {
			return;
		}
		onEffectTrap(pc);
		int x = pc.getX();
		int y = pc.getY();
		int check = pc.getLapCheck();

		if (x == 32760 && y >= 32845 && check == 0) {
			pc.setLapCheck(check + 1);
		} else if (x == 32754 && y >= 32845 && check == 1) {
			pc.setLapCheck(check + 1);
		} else if (x == 32748 && y >= 32845 && check == 2) {
			pc.setLapCheck(check + 1);
		} else if (x <= 32743 && y == 32844 && check == 3) {
			pc.setLapCheck(check + 1);
		} else if (x <= 32742 && y == 32840 && check == 4) {
			pc.setLapCheck(check + 1);
		} else if (x <= 32742 && y == 32835 && check == 5) {
			pc.setLapCheck(check + 1);
		} else if (x <= 32742 && y == 32830 && check == 6) {
			pc.setLapCheck(check + 1);
		} else if (x <= 32742 && y == 32826 && check == 7) {
			pc.setLapCheck(check + 1);
		} else if (x <= 32742 && y == 32822 && check == 8) {
			pc.setLapCheck(check + 1);
		} else if (x == 32749 && y <= 32818 && check == 9) {
			pc.setLapCheck(check + 1);
		} else if (x == 32755 && y <= 32818 && check == 10) {
			pc.setLapCheck(check + 1);
		} else if (x == 32760 && y <= 32818 && check == 11) {
			pc.setLapCheck(check + 1);
		} else if (x == 32765 && y <= 32818 && check == 12) {
			pc.setLapCheck(check + 1);
		} else if (x == 32770 && y <= 32818 && check == 13) {
			pc.setLapCheck(check + 1);
		} else if (x == 32775 && y <= 32818 && check == 14) {
			pc.setLapCheck(check + 1);
		} else if (x == 32780 && y <= 32818 && check == 15) {
			pc.setLapCheck(check + 1);
		} else if (x == 32785 && y <= 32818 && check == 16) {
			pc.setLapCheck(check + 1);
		} else if (x == 32789 && y <= 32818 && check == 17) {
			pc.setLapCheck(check + 1);
		} else if (x >= 32792 && y == 32821 && check == 18) {
			pc.setLapCheck(check + 1);
		} else if (x >= 32793 && y == 32826 && check == 19) {
			pc.setLapCheck(check + 1);
		} else if (x >= 32793 && y == 32831 && check == 20) {
			pc.setLapCheck(check + 1);
		} else if (x >= 32793 && y == 32836 && check == 21) {
			pc.setLapCheck(check + 1);
		} else if (x >= 32793 && y == 32842 && check == 22) {
			pc.setLapCheck(check + 1);
		} else if (x == 32790 && y >= 32845 && check == 23) {
			pc.setLapCheck(check + 1);
		} else if (x == 32785 && y >= 32845 && check == 24) {
			pc.setLapCheck(check + 1);
		} else if (x == 32780 && y >= 32845 && check == 25) {
			pc.setLapCheck(check + 1);
		} else if (x == 32775 && y >= 32845 && check == 26) {
			pc.setLapCheck(check + 1);
		} else if (x == 32770 && y >= 32845 && check == 27) {
			pc.setLapCheck(check + 1);
		} else if (x == 32764 && y >= 32845 && check == 28) {
			if (pc.getLap() == maxLap) {
				setGameWinner(pc);
			}
			pc.setLapCheck(0);
			pc.setLap(pc.getLap() + 1);
			pc.sendPackets(new S_Race(maxLap, pc.getLap()));// lap
		}
	}

	private int _status = 0;

	public void setGameStatus(int i) {
		_status = i;
	}

	public int getGameStatus() {
		return _status;
	}

	private int _time = 0;

	private void clearTime() {
		_time = 0;
	}

	private void addTime() {
		_time++;
	}

	private L1PcInstance _winner = null;

	public void setWinner(L1PcInstance pc) {
		_winner = pc;
	}

	public L1PcInstance getWinner() {
		return _winner;
	}

	private L1PcInstance _1stwinner = null;

	public void set1stWinner(L1PcInstance pc) {
		_1stwinner = pc;
	}

	public L1PcInstance get1stWinner() {
		return _1stwinner;
	}

	private L1PcInstance _2ndwinner = null;

	public void set2ndWinner(L1PcInstance pc) {
		_2ndwinner = pc;
	}

	public L1PcInstance get2ndWinner() {
		return _2ndwinner;
	}

	private L1PcInstance _3rdwinner = null;

	public void set3rdWinner(L1PcInstance pc) {
		_3rdwinner = pc;
	}

	public L1PcInstance get3rdWinner() {
		return _3rdwinner;
	}

	private void startReadyTimer() {
		new ReadyTimer().begin();
	}

	private void startCheckTimer() {
		new CheckTimer().begin();
	}

	private void startClockTimer() {
		new ClockTimer().begin();
	}

	private GameTimeLimitTimer limitTimer;

	private void startGameTimeLimitTimer() {
		Timer timer = new Timer("L1PolyRace-GameLimit");
		limitTimer = new GameTimeLimitTimer();
		timer.schedule(limitTimer, limitTime);
	}

	private void stopGameTimeLimitTimer() {
		limitTimer.stopTimer();
	}

	private void startWaitTimer() {
		new WaitTimer().begin();
	}

	private void startEndTimer() {
		new EndTimer().begin();
	}

	private CompareTimer compareTimer;

	private void startCompareTimer() {
		Timer timer = new Timer("L1PolyRace-CompareTimer");
		compareTimer = new CompareTimer();
		timer.schedule(compareTimer, 2000, 2000);
	}

	private void stopCompareTimer() {
		compareTimer.stopTimer();
	}

	private class ReadyTimer extends TimerTask {
		@Override
		public void run() {
			for (L1PcInstance pc : playerList) {
				pc.sendPackets(new S_SystemMessage(Config.PET_RACE_MIN_PLAYER
						+ " players " + "get ready for the petrace"));
			}
			startCheckTimer();
			this.cancel();
		}

		public void begin() {
			Timer timer = new Timer("L1PolyRace-ReadyTimer");
			timer.schedule(this, readyTime);
		}
	}

	private class CheckTimer extends TimerTask {
		@Override
		public void run() {
			if (checkPlayersOK()) {
				setGameStart();
			} else {
				setGameEnd(END_STATUS_NOPLAYER);
			}
			this.cancel();
		}

		public void begin() {
			Timer timer = new Timer("L1PolyRace-CheckTimer");
			timer.schedule(this, 30 * 1000); // 60s
		}
	}

	private class ClockTimer extends TimerTask {
		@Override
		public void run() {
			for (L1PcInstance pc : playerList) {
				pc.sendPackets(new S_Race(S_Race.CountDown));
			}
			setDoorClose(false);
			startGameTimeLimitTimer();
			this.cancel();
		}

		public void begin() {
			Timer timer = new Timer("L1PolyRace-ClockTimer");
			timer.schedule(this, 5000); // 5s
		}
	}

	private class GameTimeLimitTimer extends TimerTask {
		@Override
		public void run() {
			setGameEnd(END_STATUS_NOWINNER);
			this.cancel();
		}

		public void stopTimer() {
			this.cancel();
		}
	}

	private class WaitTimer extends TimerTask {
		@Override
		public void run() {
			setGameEnd(END_STATUS_WINNER);
			this.cancel();
		}

		public void begin() {
			Timer timer = new Timer("L1PolyRace-WaitTimer");
			timer.schedule(this, 10000); // 10s- 10000
		}
	}

	private class EndTimer extends TimerTask {
		@Override
		public void run() {
			giftWinner();
			setGameInit();
			this.cancel();
		}

		public void begin() {
			Timer timer = new Timer("L1PolyRace-EndTimer");
			timer.schedule(this, 5000); // 5s- 5000
		}
	}

	private class CompareTimer extends TimerTask {
		@Override
		public void run() {
			comparePosition();
			addTime();
		}

		public void stopTimer() {
			this.cancel();
		}
	}
}