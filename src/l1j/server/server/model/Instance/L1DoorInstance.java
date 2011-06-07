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
package l1j.server.server.model.Instance;

import java.util.logging.Logger;

import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1World;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_Door;
import l1j.server.server.serverpackets.S_DoorPack;
import l1j.server.server.templates.L1Npc;

public class L1DoorInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;
	public static final int PASS = 0;
	public static final int NOT_PASS = 1;

	private static Logger _log = Logger.getLogger(L1DoorInstance.class
			.getName());

	public L1DoorInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance pc) {
		if (getMaxHp() == 0 || getMaxHp() == 1) { //
			return;
		}

		if (getCurrentHp() > 0 && !isDead()) {
			L1Attack attack = new L1Attack(pc, this);
			if (attack.calcHit()) {
				attack.calcDamage();
				attack.addPcPoisonAttack(pc, this);
				attack.addChaserAttack();
			}
			attack.action();
			attack.commit();
		}
	}

	@Override
	public void onPerceive(L1PcInstance perceivedFrom) {
		perceivedFrom.addKnownObject(this);
		perceivedFrom.sendPackets(new S_DoorPack(this));
		sendDoorPacket(perceivedFrom);
	}

	@Override
	public void deleteMe() {
		setPassable(PASS);
		sendDoorPacket(null);

		_destroyed = true;
		if (getInventory() != null) {
			getInventory().clearItems();
		}
		allTargetClear();
		_master = null;
		L1World.getInstance().removeVisibleObject(this);
		L1World.getInstance().removeObject(this);
		for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(this)) {
			pc.removeKnownObject(this);
			pc.sendPackets(new S_RemoveObject(this));
		}
		removeAllKnownObjects();
	}

	@Override
	public void receiveDamage(L1Character attacker, int damage) {
		if (getMaxHp() == 0 || getMaxHp() == 1) { //
			return;
		}

		if (getCurrentHp() > 0 && !isDead()) {
			int newHp = getCurrentHp() - damage;
			if (newHp <= 0 && !isDead()) {
				setCurrentHpDirect(0);
				setDead(true);
				setStatus(ActionCodes.ACTION_DoorDie);
				Death death = new Death(attacker);
				GeneralThreadPool.getInstance().execute(death);
			}
			if (newHp > 0) {
				setCurrentHp(newHp);
				if ((getMaxHp() * 1 / 6) > getCurrentHp()) {
					if (_crackStatus != 5) {
						broadcastPacket(new S_DoActionGFX(getId(),
								ActionCodes.ACTION_DoorAction5));
						setStatus(ActionCodes.ACTION_DoorAction5);
						_crackStatus = 5;
					}
				} else if ((getMaxHp() * 2 / 6) > getCurrentHp()) {
					if (_crackStatus != 4) {
						broadcastPacket(new S_DoActionGFX(getId(),
								ActionCodes.ACTION_DoorAction4));
						setStatus(ActionCodes.ACTION_DoorAction4);
						_crackStatus = 4;
					}
				} else if ((getMaxHp() * 3 / 6) > getCurrentHp()) {
					if (_crackStatus != 3) {
						broadcastPacket(new S_DoActionGFX(getId(),
								ActionCodes.ACTION_DoorAction3));
						setStatus(ActionCodes.ACTION_DoorAction3);
						_crackStatus = 3;
					}
				} else if ((getMaxHp() * 4 / 6) > getCurrentHp()) {
					if (_crackStatus != 2) {
						broadcastPacket(new S_DoActionGFX(getId(),
								ActionCodes.ACTION_DoorAction2));
						setStatus(ActionCodes.ACTION_DoorAction2);
						_crackStatus = 2;
					}
				} else if ((getMaxHp() * 5 / 6) > getCurrentHp()) {
					if (_crackStatus != 1) {
						broadcastPacket(new S_DoActionGFX(getId(),
								ActionCodes.ACTION_DoorAction1));
						setStatus(ActionCodes.ACTION_DoorAction1);
						_crackStatus = 1;
					}
				}
			}
		} else if (!isDead()) { //
			setDead(true);
			setStatus(ActionCodes.ACTION_DoorDie);
			Death death = new Death(attacker);
			GeneralThreadPool.getInstance().execute(death);
		}
	}

	@Override
	public void setCurrentHp(int i) {
		int currentHp = i;
		if (currentHp >= getMaxHp()) {
			currentHp = getMaxHp();
		}
		setCurrentHpDirect(currentHp);
	}

	class Death implements Runnable {
		L1Character _lastAttacker;

		public Death(L1Character lastAttacker) {
			_lastAttacker = lastAttacker;
		}

		@Override
		public void run() {
			setCurrentHpDirect(0);
			setDead(true);
			setStatus(ActionCodes.ACTION_DoorDie);

			getMap().setPassable(getLocation(), true);

			broadcastPacket(new S_DoActionGFX(getId(), ActionCodes
					.ACTION_DoorDie));
			setPassable(PASS);
			sendDoorPacket(null);
		}
	}

	private void sendDoorPacket(L1PcInstance pc) {
		int entranceX = getEntranceX();
		int entranceY = getEntranceY();
		int leftEdgeLocation = getLeftEdgeLocation();
		int rightEdgeLocation = getRightEdgeLocation();

		int size = rightEdgeLocation - leftEdgeLocation;
		if (size == 0) { //
			sendPacket(pc, entranceX, entranceY);
		} else { //
			if (getDirection() == 0) { //
				for (int x = leftEdgeLocation; x <= rightEdgeLocation; x++) {
					sendPacket(pc, x, entranceY);
				}
			} else { //
				for (int y = leftEdgeLocation; y <= rightEdgeLocation; y++) {
					sendPacket(pc, entranceX, y);
				}
			}
		}
	}

	private void sendPacket(L1PcInstance pc, int x, int y) {
		S_Door packet = new S_Door(x, y, getDirection(), getPassable());
		if (pc != null) { //
			if (getOpenStatus() == ActionCodes.ACTION_Close) {
				pc.sendPackets(packet);
			}
		} else {
			broadcastPacket(packet);
		}
	}

	public void open() {
		if (isDead()) {
			return;
		}
		if (getOpenStatus() == ActionCodes.ACTION_Close) {
			setOpenStatus(ActionCodes.ACTION_Open);
			setPassable(L1DoorInstance.PASS);
			broadcastPacket(new S_DoorPack(this));
			sendDoorPacket(null);
		}
	}

	public void close() {
		if (isDead()) {
			return;
		}
		if (getOpenStatus() == ActionCodes.ACTION_Open) {
			setOpenStatus(ActionCodes.ACTION_Close);
			setPassable(L1DoorInstance.NOT_PASS);
			broadcastPacket(new S_DoorPack(this));
			sendDoorPacket(null);
		}
	}

	public void repairGate() {
		if (getMaxHp() > 1) {
			setDead(false);
			setCurrentHp(getMaxHp());
			setStatus(0);
			setCrackStatus(0);
			setOpenStatus(ActionCodes.ACTION_Open);
			close();
		}
	}

	private int _doorId = 0;

	public int getDoorId() {
		return _doorId;
	}

	public void setDoorId(int i) {
		_doorId = i;
	}

	private int _direction = 0; //

	public int getDirection() {
		return _direction;
	}

	public void setDirection(int i) {
		if (i == 0 || i == 1) {
			_direction = i;
		}
	}

	public int getEntranceX() {
		int entranceX = 0;
		if (getDirection() == 0) { //
			entranceX = getX();
		} else { // _ü«
			entranceX = getX() - 1;
		}
		return entranceX;
	}

	public int getEntranceY() {
		int entranceY = 0;
		if (getDirection() == 0) { //
			entranceY = getY() + 1;
		} else { // _ü«
			entranceY = getY();
		}
		return entranceY;
	}

	private int _leftEdgeLocation = 0; //

	public int getLeftEdgeLocation() {
		return _leftEdgeLocation;
	}

	public void setLeftEdgeLocation(int i) {
		_leftEdgeLocation = i;
	}

	private int _rightEdgeLocation = 0; //

	public int getRightEdgeLocation() {
		return _rightEdgeLocation;
	}

	public void setRightEdgeLocation(int i) {
		_rightEdgeLocation = i;
	}

	private int _openStatus = ActionCodes.ACTION_Close;

	public int getOpenStatus() {
		return _openStatus;
	}

	public void setOpenStatus(int i) {
		if (i == ActionCodes.ACTION_Open || i == ActionCodes.ACTION_Close) {
			_openStatus = i;
		}
	}

	private int _passable = NOT_PASS;

	public int getPassable() {
		return _passable;
	}

	public void setPassable(int i) {
		if (i == PASS || i == NOT_PASS) {
			_passable = i;
		}
	}

	private int _keeperId = 0;

	public int getKeeperId() {
		return _keeperId;
	}

	public void setKeeperId(int i) {
		_keeperId = i;
	}

	private int _crackStatus;

	public int getCrackStatus() {
		return _crackStatus;
	}

	public void setCrackStatus(int i) {
		_crackStatus = i;
	}

}
