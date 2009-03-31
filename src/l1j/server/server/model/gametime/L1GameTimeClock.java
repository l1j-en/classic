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
package l1j.server.server.model.gametime;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.GeneralThreadPool;

public class L1GameTimeClock {
	private static Logger _log = Logger.getLogger(L1GameTimeClock.class
			.getName());

	private static L1GameTimeClock _instance;
	private volatile L1GameTime _currentTime = L1GameTime
			.fromSystemCurrentTime();
	private L1GameTime _previousTime = null;

	private List<L1GameTimeListener> _listeners = new CopyOnWriteArrayList<L1GameTimeListener>();

	private class TimeUpdater implements Runnable {
		@Override
		public void run() {
			while (true) {
				_previousTime = _currentTime;
				_currentTime = L1GameTime.fromSystemCurrentTime();
				notifyChanged();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
		}
	}

	private boolean isFieldChanged(int field) {
		return _previousTime.get(field) != _currentTime.get(field);
	}

	private void notifyChanged() {
		if (isFieldChanged(Calendar.MONTH)) {
			for (L1GameTimeListener listener : _listeners) {
				listener.onMonthChanged(_currentTime);
			}
		}
		if (isFieldChanged(Calendar.DAY_OF_MONTH)) {
			for (L1GameTimeListener listener : _listeners) {
				listener.onDayChanged(_currentTime);
			}
		}
		if (isFieldChanged(Calendar.HOUR_OF_DAY)) {
			for (L1GameTimeListener listener : _listeners) {
				listener.onHourChanged(_currentTime);
			}
		}
		if (isFieldChanged(Calendar.MINUTE)) {
			for (L1GameTimeListener listener : _listeners) {
				listener.onMinuteChanged(_currentTime);
			}
		}
	}

	private L1GameTimeClock() {
		GeneralThreadPool.getInstance().execute(new TimeUpdater());
	}

	public static void init() {
		_instance = new L1GameTimeClock();
	}

	public static L1GameTimeClock getInstance() {
		return _instance;
	}

	public L1GameTime currentTime() {
		return _currentTime;
	}

	public void addListener(L1GameTimeListener listener) {
		_listeners.add(listener);
	}

	public void removeListener(L1GameTimeListener listener) {
		_listeners.remove(listener);
	}
}
