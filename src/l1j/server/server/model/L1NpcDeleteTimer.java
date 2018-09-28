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

import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1NpcInstance;

public class L1NpcDeleteTimer implements Runnable {

	private static Logger _log = LoggerFactory.getLogger(L1NpcDeleteTimer.class);

	ScheduledFuture<?> future;
	private String originalThreadName;
	public L1NpcDeleteTimer(L1NpcInstance npc, int timeMillis) {
		_npc = npc;
		_timeMillis = timeMillis;
	}

	@Override
	public void run() {
		try {
			originalThreadName = Thread.currentThread().getName();
			Thread.currentThread().setName("NpcDeleteTimer-" + _npc.getId() + ':' + _npc.getName());
			_npc.deleteMe();
			future.cancel(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("",e);
		} finally {
			Thread.currentThread().setName(originalThreadName);
		}
	}

	public void begin() {
		future = GeneralThreadPool.getInstance().schedule(this, _timeMillis);
	}

	private final L1NpcInstance _npc;
	private final int _timeMillis;
}
