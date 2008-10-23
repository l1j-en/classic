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
	public void onAction(L1PcInstance player) {
	}

	@Override
	public void onPerceive(L1PcInstance perceivedFrom) {
		perceivedFrom.addKnownObject(this);
		perceivedFrom.sendPackets(new S_DoorPack(this));
		perceivedFrom.sendPackets(new S_Door(this));

// int x = getEntranceX();
// int y = getEntranceY();
// int size = getSize() - 1;
// if (size > 0) {
// switch(getDirection()) {
// case 0: //
// for (int i = 0; i < size; i++) {
// x--; // 
// perceivedFrom.sendPackets(new S_Door(x, y, getDirection(),
// getPassable()));
// }
// break;
// case 1: //
// for (int i = 0; i < size; i++) {
// y--; //
// perceivedFrom.sendPackets(new S_Door(x, y, getDirection(),
// getPassable()));
// }
// break;
// }
// }
	}

	@Override
	public void deleteMe() {
		setPassable(PASS);
		broadcastPacket(new S_Door(this));

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

	private int _direction = 0; //

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

	private boolean _isInvisible = false;

	public boolean isInvisible() {
		return _isInvisible;
	}

	public void setInvisible(boolean flag) {
		_isInvisible = flag;
	}

}
