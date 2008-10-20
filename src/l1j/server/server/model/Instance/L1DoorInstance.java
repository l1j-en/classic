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

import l1j.server.ThreadPools.GeneralThreadPool;
import l1j.server.server.ActionCodes;

import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1War;
import l1j.server.server.model.L1WarSpawn;
import l1j.server.server.model.L1World;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_Door;
import l1j.server.server.serverpackets.S_Doors;
import l1j.server.server.serverpackets.S_DoorPack;
import l1j.server.server.templates.L1Npc;

public class L1DoorInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;
	public static final int PASS = 0;
	public static final int NOT_PASS = 1;
	
	
	private L1Character _lastattacker;
	private int _crackStatus;
	

	private static Logger _log = Logger.getLogger(L1DoorInstance.class
			.getName());

	public L1DoorInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance player) {
	
		if (getCurrentHp() > 0 && !isDead()) {
			L1Attack attack = new L1Attack(player, this);
			if (attack.calcHit()) {
				attack.calcDamage();
				attack.calcStaffOfMana();
				attack.addPcPoisonAttack(player, this);
			}
			attack.action();
			attack.commit();
		}
	}

	@Override
	public void onPerceive(L1PcInstance perceivedFrom) {
		perceivedFrom.addKnownObject(this);
		perceivedFrom.sendPackets(new S_DoorPack(this));
		perceivedFrom.sendPackets(new S_Door(this));
	
		int X = getEntranceX();
		int Y = getEntranceY();
		int S = getSize() - 1;
		if (S > 0) {
			switch(getDirection())
			{
				case 0: {
					for(int i = 0; i < S; i++)
					{
						X--;	
						perceivedFrom.sendPackets(new S_Doors(X, Y, getDirection(), getPassable()));
					}
				}
				break;
				case 1: {
					for(int i = 0; i < S; i++)
					{
						Y--;	
						perceivedFrom.sendPackets(new S_Doors(X, Y, getDirection(), getPassable()));
					}
				}
				break;
			}
		}

		if (isDead()) {
			perceivedFrom.sendPackets(new S_DoActionGFX(getId(),
					37));
		} else {
			if ((getMaxHp() * 1 / 8) > getCurrentHp()) {
				perceivedFrom.sendPackets(new S_DoActionGFX(getId(),
						36));
			} else if ((getMaxHp() * 1 / 4) > getCurrentHp()) {
				perceivedFrom.sendPackets(new S_DoActionGFX(getId(),
						35));
			} else if ((getMaxHp() * 2 / 4) > getCurrentHp()) {
				perceivedFrom.sendPackets(new S_DoActionGFX(getId(),
						34));
			} else if ((getMaxHp() * 3 / 4) > getCurrentHp()) {
				perceivedFrom.sendPackets(new S_DoActionGFX(getId(),
						33));
			}
		}
	}

	@Override
	public void receiveDamage(L1Character attacker, int damage) { 
		if (getCurrentHp() > 0 && !isDead()) {
			int newHp = getCurrentHp() - damage;
			if (newHp <= 0 && !isDead()) {
				setCurrentHpDirect(0);
				setDead(true);
				_lastattacker = attacker;
				_crackStatus = 0;
				Death death = new Death();
				GeneralThreadPool.getInstance().execute(death);
				// Death(attacker);
			}
			if (newHp > 0) {
				setCurrentHp(newHp);
				if ((getMaxHp() * 1 / 8) > getCurrentHp()) {
					if (_crackStatus != 3) {
						broadcastPacket(new S_DoActionGFX(getId(),
								36));
						_crackStatus = 3;
					}
				} else if ((getMaxHp() * 1 / 4) > getCurrentHp()) {
					if (_crackStatus != 3) {
						broadcastPacket(new S_DoActionGFX(getId(),
								35));
						_crackStatus = 3;
					}
				} else if ((getMaxHp() * 2 / 4) > getCurrentHp()) {
					if (_crackStatus != 2) {
						broadcastPacket(new S_DoActionGFX(getId(),
								34));
						_crackStatus = 2;
					}
				} else if ((getMaxHp() * 3 / 4) > getCurrentHp()) {
					if (_crackStatus != 1) {
						broadcastPacket(new S_DoActionGFX(getId(),
								33));
						_crackStatus = 1;
					}
				}
			}
		} else if (!isDead()) {
			setDead(true);
			_lastattacker = attacker;
			Death death = new Death();
			GeneralThreadPool.getInstance().execute(death);
			// Death(attacker);
		}
	}

	@Override
	public void setCurrentHp(int i) {
		int currentHp = i;
		if (currentHp >= getMaxHp()) {
			currentHp = getMaxHp();
		}
		setCurrentHpDirect(currentHp);
		
		if (getMaxHp() > getCurrentHp()) {
			startHpRegeneration();
		}
	}

	class Death implements Runnable {
		L1Character lastAttacker = _lastattacker;
		L1Object object = L1World.getInstance().findObject(getId());
		L1DoorInstance npc = (L1DoorInstance) object;

		@Override
		public void run() {
			setCurrentHpDirect(0);
			setDead(true);
			int targetobjid = npc.getId();

			npc.getMap().setPassable(npc.getLocation(), true);

			npc.broadcastPacket(new S_DoActionGFX(targetobjid,
					37));
			deleteMe();
		}
	}
	
	@Override
	public void deleteMe() {
		setPassable(PASS);
		broadcastPacket(new S_Door(this));

		setOpenStatus(ActionCodes.ACTION_Open);
		int X = getEntranceX();
		int Y = getEntranceY();
		int S = getSize() - 1;
		if (S > 0) {
			switch(getDirection())
			{
				case 0: {
					for(int i = 0; i < S; i++)
					{
						X--;	
						broadcastPacket(new S_Doors(X, Y, getDirection(), getPassable()));
					}
				}
				break;
				case 1: {
					for(int i = 0; i < S; i++)
					{
						Y--;	
						broadcastPacket(new S_Doors(X, Y, getDirection(), getPassable()));
					}
				}
				break;
			}
		}
		//  end
		
		/*_destroyed = true;
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
		removeAllKnownObjects();*/
	}
	public void open(boolean isInvisible) {
		if (getOpenStatus() == ActionCodes.ACTION_Close) {
		setOpenStatus(ActionCodes.ACTION_Open);
		setPassable(L1DoorInstance.PASS);
		if (isInvisible) {
		setInvisible(true);
		broadcastPacket(new S_DoorPack(this));
		}
		broadcastPacket(new S_DoActionGFX(getId(), getOpenStatus()));
		broadcastPacket(new S_Door(this));
		}
		}

		public void close(boolean isInvisible) {
		if (getOpenStatus() == ActionCodes.ACTION_Open) {
		setOpenStatus(ActionCodes.ACTION_Close);
		setPassable(L1DoorInstance.NOT_PASS);
		if (isInvisible) {
		setInvisible(false);
		broadcastPacket(new S_DoorPack(this));
		}
		broadcastPacket(new S_DoActionGFX(getId(), getOpenStatus()));
		broadcastPacket(new S_Door(this));
		}
		}

	private int _doorId = 0;

	public int getDoorId() {
		return _doorId;
	}

	public void setDoorId(int i) {
		_doorId = i;
	}

	private int _direction = 0;
	
	public int getDirection() {
		return _direction;
	}

	public void setDirection(int i) {
		if (i == 0 || i == 1) {
			_direction = i;
		}
	}

	private int _entranceX = 0;

	public int getEntranceX() {
		return _entranceX;
	}

	public void setEntranceX(int i) {
		_entranceX = i;
	}

	private int _entranceY = 0;

	public int getEntranceY() {
		return _entranceY;
	}

	public void setEntranceY(int i) {
		_entranceY = i;
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

	private int _size = 1;

	public int getSize() {
		return _size;
	}

	public void setSize(int i) {
		_size = i;
	}

	private int _castle = 0;

	public int getCastleId() {
		return _castle;
	}

	public void setCastleId(int i) {
		_castle = i;
	}

	private int _order = 0;

	public int getOrder() {
		return _order;
	}

	public void setOrder(int i) {
		_order = i;
	}

	private int _keyId = 0;

	public int getKeyId() {
		return _keyId;
	}

	public void setKeyId(int i) {
		_keyId = i;
	}
	
	private boolean _isInvisible = false;

	public boolean isInvisible() {
		return _isInvisible;
	}

	public void setInvisible(boolean flag) {
		_isInvisible = flag;
	}

}
