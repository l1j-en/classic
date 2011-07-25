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

import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;

import l1j.server.server.ActionCodes;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.serverpackets.S_DoActionGFX;

public class L1NpcDeleteTimer extends TimerTask {
	private static final Logger _log = Logger.getLogger(L1NpcDeleteTimer.class
			.getName());

	public L1NpcDeleteTimer(L1NpcInstance npc, int timeMillis) {
		_npc = npc;
		_timeMillis = timeMillis;
	}

	@Override
	public void run() {
		if (_npc != null) {
			if (_npc.get_npcId() == 81273 || _npc.get_npcId() == 81274 || _npc.get_npcId() == 81275
					|| _npc.get_npcId() == 81276 || _npc.get_npcId() == 81277) {
				if (_npc.get_npcId() == 81277) {
					L1DragonSlayer.getInstance().setHiddenDragonValleyStstus(0);
				}
				L1DragonSlayer.getInstance().setPortalPack(_npc.getPortalNumber(), null);
				L1DragonSlayer.getInstance().endDragonPortal(_npc.getPortalNumber());
				_npc.setStatus(ActionCodes.ACTION_Die);
				_npc.broadcastPacket(new S_DoActionGFX(_npc.getId(), ActionCodes.ACTION_Die));
			}
			_npc.deleteMe();
			cancel();
		}
	}


	public void begin() {
		Timer timer = new Timer();
		timer.schedule(this, _timeMillis);
	}

	private final L1NpcInstance _npc;
	private final int _timeMillis;
}