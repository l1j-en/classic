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
import l1j.server.server.model.Instance.L1ItemInstance;

public class L1ItemOwnerTimer implements Runnable {

	private static Logger _log = LoggerFactory.getLogger(L1ItemOwnerTimer.class);

	private ScheduledFuture<?> future;

	public L1ItemOwnerTimer(L1ItemInstance item, int timeMillis) {
		_item = item;
		_timeMillis = timeMillis;
	}

	@Override
	public void run() {
		try {
			_item.setItemOwnerId(0);
			future.cancel(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("",e);
		}
	}

	public void begin() {
		future = GeneralThreadPool.getInstance().schedule(this, _timeMillis);
	}

	private final L1ItemInstance _item;
	private final int _timeMillis;
}
