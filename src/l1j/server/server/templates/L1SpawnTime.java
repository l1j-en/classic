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
package l1j.server.server.templates;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.logging.Logger;

import l1j.server.server.utils.TimePeriod;

public class L1SpawnTime {
	private static Logger _log = Logger.getLogger(L1SpawnTime.class.getName());

	private final int _spawnId;
	private final Time _timeStart;
	private final Time _timeEnd;
	private final TimePeriod _timePeriod;
	private final Timestamp _periodStart;
	private final Timestamp _periodEnd;
	private boolean _isDeleteAtEndTime;

	public boolean isDeleteAtEndTime() {
		return _isDeleteAtEndTime;
	}

	private L1SpawnTime(L1SpawnTimeBuilder builder) {
		_spawnId = builder._spawnId;
		_timeStart = builder._timeStart;
		_timeEnd = builder._timeEnd;
		_timePeriod = new TimePeriod(_timeStart, _timeEnd);
		_periodStart = builder._periodStart;
		_periodEnd = builder._periodEnd;
		_isDeleteAtEndTime = builder._isDeleteAtEndTime;
	}

	public int getSpawnId() {
		return _spawnId;
	}

	public Time getTimeStart() {
		return _timeStart;
	}

	public Time getTimeEnd() {
		return _timeEnd;
	}

	public Timestamp getPeriodStart() {
		return _periodStart;
	}

	public Timestamp getPeriodEnd() {
		return _periodEnd;
	}

	public static class L1SpawnTimeBuilder {
		private final int _spawnId;
		private Time _timeStart;
		private Time _timeEnd;
		private Timestamp _periodStart;
		private Timestamp _periodEnd;
		private boolean _isDeleteAtEndTime;

		public L1SpawnTimeBuilder(int spawnId) {
			_spawnId = spawnId;
		}

		public L1SpawnTime build() {
			return new L1SpawnTime(this);
		}

		public void setTimeStart(Time timeStart) {
			_timeStart = timeStart;
		}

		public void setTimeEnd(Time timeEnd) {
			_timeEnd = timeEnd;
		}

		public void setPeriodStart(Timestamp periodStart) {
			_periodStart = periodStart;
		}

		public void setPeriodEnd(Timestamp periodEnd) {
			_periodEnd = periodEnd;
		}

		public void setDeleteAtEndTime(boolean f) {
			_isDeleteAtEndTime = f;
		}

	}

	public TimePeriod getTimePeriod() {
		return _timePeriod;
	}
}
