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

import static l1j.server.server.model.skill.L1SkillId.CANCELLATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import l1j.server.Config;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillUse;

public class L1HauntedHouse {
	public static final int STATUS_NONE = 0;
	public static final int STATUS_READY = 1;
	public static final int STATUS_PLAYING = 2;

	private static final int HAUNTED_HOUSE_MAP = 5140;

	private final List<L1PcInstance> _members = new ArrayList<L1PcInstance>();
	private int _hauntedHouseStatus = STATUS_NONE;
	private int _winnersCount = 0;
	private int _goalCount = 0;
	// WARNING: TOTAL HACK!
	// Original code has an issue stemming from using a single Haunted House
	// but using new Timers every run. Holding onto the timeout timer doesn't
	// fix the issue, just band-aids over the worst symptoms. Ultimately needs
	// to be rewritten.
	private L1HauntedHouseTimer _hhTimer;

	private static L1HauntedHouse _instance;

	public static L1HauntedHouse getInstance() {
		if (_instance == null) {
			_instance = new L1HauntedHouse();
		}
		return _instance;
	}

	private void readyHauntedHouse() {
		setHauntedHouseStatus(STATUS_READY);
		L1HauntedHouseReadyTimer hhrTimer = new L1HauntedHouseReadyTimer();
		hhrTimer.begin();
	}

	private void startHauntedHouse() {
		setHauntedHouseStatus(STATUS_PLAYING);
		int membersCount = getMembersCount();
		if (membersCount <= 4) {
			setWinnersCount(1);
		} else if (5 >= membersCount && membersCount <= 7) {
			setWinnersCount(2);
		} else if (8 >= membersCount && membersCount <= 10) {
			setWinnersCount(3);
		}
		for (L1PcInstance pc : _members) {
			L1SkillUse l1skilluse = new L1SkillUse();
			l1skilluse.handleCommands(pc, CANCELLATION, pc.getId(), pc.getX(),
					pc.getY(), null, 0, L1SkillUse.TYPE_LOGIN);
			L1PolyMorph.doPoly(pc, 6284, 300, L1PolyMorph.MORPH_BY_NPC);
		}

		changeDoors(true);
	}

	public void endHauntedHouse() {
		// See top comments.
		_hhTimer.cancel();
		setHauntedHouseStatus(STATUS_NONE);
		setWinnersCount(0);
		setGoalCount(0);
		for (L1PcInstance pc : _members) {
			if (pc.getMapId() != HAUNTED_HOUSE_MAP)
				continue;
			L1SkillUse l1skilluse = new L1SkillUse();
			l1skilluse.handleCommands(pc, CANCELLATION, pc.getId(), pc.getX(),
					pc.getY(), null, 0, L1SkillUse.TYPE_LOGIN);
			L1Teleport.teleport(pc, 32624, 32813, (short) 4, 5, true);
		}

		_members.clear();

		changeDoors(false);
	}

	private static void changeDoors(boolean open) {
		for (L1Object object : L1World.getInstance().getObject()) {
			if (!(object instanceof L1DoorInstance))
				continue;
			L1DoorInstance door = (L1DoorInstance) object;
			if (door.getMapId() == HAUNTED_HOUSE_MAP) {
				if (open)
					door.open();
				else
					door.close();
			}
		}
	}

	public void addMember(L1PcInstance pc) {
		if (!_members.contains(pc)) {
			_members.add(pc);
		}
		if (getMembersCount() > 0 && getHauntedHouseStatus() == STATUS_NONE) {
			readyHauntedHouse();
		}
	}

	public void checkLeaveGame(L1PcInstance pc) {
		if (pc.getMapId() == HAUNTED_HOUSE_MAP) {
			removeMember(pc);
			L1PolyMorph.undoPoly(pc);
		}
	}

	public void removeMember(L1PcInstance pc) {
		_members.remove(pc);
	}

	public int getMembersCount() {
		return _members.size();
	}

	private void setHauntedHouseStatus(int i) {
		_hauntedHouseStatus = i;
	}

	public int getHauntedHouseStatus() {
		return _hauntedHouseStatus;
	}

	private void setWinnersCount(int i) {
		_winnersCount = i;
	}

	public int getWinnersCount() {
		return _winnersCount;
	}

	public void setGoalCount(int i) {
		_goalCount = i;
	}

	public int getGoalCount() {
		return _goalCount;
	}

	public class L1HauntedHouseReadyTimer extends TimerTask {

		public L1HauntedHouseReadyTimer() {
		}

		@Override
		public void run() {
			startHauntedHouse();
			// See top comments for overview.
			// We need to cancel the existing timeout timer; otherwise it could
			// go off during this (new) run of the Haunted House.
			if (_hhTimer != null)
				_hhTimer.cancel();
			_hhTimer = new L1HauntedHouseTimer();
			_hhTimer.begin();
		}

		public void begin() {
			Timer timer = new Timer();
			timer.schedule(this, Config.HAUNTEDHOUSETIME);
		}
	}

	public class L1HauntedHouseTimer extends TimerTask {

		public L1HauntedHouseTimer() {
		}

		@Override
		public void run() {
			endHauntedHouse();
			this.cancel();
		}

		public void begin() {
			Timer timer = new Timer();
			timer.schedule(this, 300000);
		}
	}
}
