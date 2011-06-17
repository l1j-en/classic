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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import l1j.server.server.datatables.BossSpawnTable;
import l1j.server.server.utils.PerformanceTimer;

@XmlAccessorType(XmlAccessType.FIELD)
public class L1BossCycle {
	@XmlAttribute(name = "Name")
	private String _name;
	@XmlElement(name = "Base")
	private Base _base;

	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Base {
		@XmlAttribute(name = "Date")
		private String _date;
		@XmlAttribute(name = "Time")
		private String _time;

		public String getDate() {
			return _date;
		}

		public void setDate(String date) {
			this._date = date;
		}

		public String getTime() {
			return _time;
		}

		public void setTime(String time) {
			this._time = time;
		}
	}

	@XmlElement(name = "Cycle")
	private Cycle _cycle;

	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Cycle {
		@XmlAttribute(name = "Period")
		private String _period;
		@XmlAttribute(name = "Start")
		private String _start;
		@XmlAttribute(name = "End")
		private String _end;

		public String getPeriod() {
			return _period;
		}

		public void setPeriod(String period) {
			this._period = period;
		}

		public String getStart() {
			return _start;
		}

		public void setStart(String start) {
			_start = start;
		}

		public String getEnd() {
			return _end;
		}

		public void setEnd(String end) {
			_end = end;
		}
	}

	private static final Random _rnd = new Random();
	private Calendar _baseDate;
	private int _period; // Portion Exchange
	private int _periodDay;
	private int _periodHour;
	private int _periodMinute;

	private int _startTime; 
	private int _endTime; 
	private static SimpleDateFormat _sdfYmd = new SimpleDateFormat("yyyy/MM/dd");
	private static SimpleDateFormat _sdfTime = new SimpleDateFormat("HH:mm");
	private static SimpleDateFormat _sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	private static Date _initDate = new Date();
	private static String _initTime = "0:00";
	private static final Calendar START_UP = Calendar.getInstance();

	public void init() throws Exception {
		// Date set standards
		Base base = getBase();
		// If there is no criteria, standards for today's 0:00
		if (base == null) {
			setBase(new Base());
			getBase().setDate(_sdfYmd.format(_initDate));
			getBase().setTime(_initTime);
			base = getBase();
		} else {
			try {
				_sdfYmd.parse(base.getDate());
			} catch (Exception e) {
				base.setDate(_sdfYmd.format(_initDate));
			}
			try {
				_sdfTime.parse(base.getTime());
			} catch (Exception e) {
				base.setTime(_initTime);
			}
		}
		// Criteria to determine the date and time
		Calendar baseCal = Calendar.getInstance();
		baseCal.setTime(_sdf.parse(base.getDate() + " " + base.getTime()));
		// the initial period of emergence, check
		Cycle spawn = getCycle();
		if (spawn == null || spawn.getPeriod() == null) {
			throw new Exception("Cycle Period(");
		}
		String period = spawn.getPeriod();
		_periodDay = getTimeParse(period, "d");
		_periodHour = getTimeParse(period, "h");
		_periodMinute = getTimeParse(period, "m");
		String start = spawn.getStart();
		int sDay = getTimeParse(start, "d");
		int sHour = getTimeParse(start, "h");
		int sMinute = getTimeParse(start, "m");
		String end = spawn.getEnd();
		int eDay = getTimeParse(end, "d");
		int eHour = getTimeParse(end, "h");
		int eMinute = getTimeParse(end, "m");
		// Portion Exchange
		_period = (_periodDay * 24 * 60) + (_periodHour * 60) + _periodMinute;
		_startTime = (sDay * 24 * 60) + (sHour * 60) + sMinute;
		_endTime = (eDay * 24 * 60) + (eHour * 60) + eMinute;
		if (_period <= 0) {
			throw new Exception("must be Period > 0");
		}
		// start 
		if (_startTime < 0 || _period < _startTime) { 
			_startTime = 0;
		}
		// end
		if (_endTime < 0 || _period < _endTime || end == null) { 
			_endTime = _period;
		}
		if (_startTime > _endTime) {
			_startTime = _endTime;
		}
		// start,end Correction of the correlation (at least 1 out minutes)
		// start==end Specified by the emergence of the next period of time so that
		if (_startTime == _endTime) {
			if (_endTime == _period) {
				_startTime--;
			} else {
				_endTime++;
			}
		}
		// Recent period of correction 
		// (re-calculated to calculate exactly when, where only close to the appropriate correction)
		while (!(baseCal.after(START_UP))) {
			baseCal.add(Calendar.DAY_OF_MONTH, _periodDay);
			baseCal.add(Calendar.HOUR_OF_DAY, _periodHour);
			baseCal.add(Calendar.MINUTE, _periodMinute);
		}
		_baseDate = baseCal;
	}
	/*
	 * Including the specified time period (start time) to return
	 * Ex. If the period is 2 hours
	 * Target base Returns
	 *   4:59  7:00 3:00
	 *   5:00  7:00 5:00
	 *   5:01  7:00 5:00
	 *   6:00  7:00 5:00
	 *   6:59  7:00 5:00
	 *   7:00  7:00 7:00
	 *   7:01  7:00 7:00
	 *   9:00  7:00 9:00
	 *   9:01  7:00 9:00
	 */
	private Calendar getBaseCycleOnTarget(Calendar target) {
		// Date acquisition criteria
		Calendar base = (Calendar) _baseDate.clone();
		if (target.after(base)) {
			// target <= base Repeat until
			while (target.after(base)) {
				base.add(Calendar.DAY_OF_MONTH, _periodDay);
				base.add(Calendar.HOUR_OF_DAY, _periodHour);
				base.add(Calendar.MINUTE, _periodMinute);
			}
		}
		if (target.before(base)) {
			while (target.before(base)) {
				base.add(Calendar.DAY_OF_MONTH, -_periodDay);
				base.add(Calendar.HOUR_OF_DAY, -_periodHour);
				base.add(Calendar.MINUTE, -_periodMinute);
			}
		}
		Calendar end = (Calendar) base.clone();
		end.add(Calendar.MINUTE, _endTime);
		if (end.before(target)) {
			base.add(Calendar.DAY_OF_MONTH, _periodDay);
			base.add(Calendar.HOUR_OF_DAY, _periodHour);
			base.add(Calendar.MINUTE, _periodMinute);
		}
		return base;
	}

	/**
	 * A specified time period, including the emergence of a calculated timing.
	 * @Return emergence of time
	 */
	public Calendar calcSpawnTime(Calendar now) {
		// Date acquisition criteria
		Calendar base = getBaseCycleOnTarget(now);
		// Calculations emergence period
		base.add(Calendar.MINUTE, _startTime);
		// Appearance time decision until the start ~ end of the second set at random
		int diff = (_endTime - _startTime) * 60;
		int random = diff > 0 ? _rnd.nextInt(diff) : 0;
		base.add(Calendar.SECOND, random);
		return base;
	}

	/**
	 * Including the specified time period for calculating the emergence of the time to start.
	 * @return The emergence of the start time period
	 */
	public Calendar getSpawnStartTime(Calendar now) {
		// Date acquisition criteria
		Calendar startDate = getBaseCycleOnTarget(now);
		// Calculations emergence period
		startDate.add(Calendar.MINUTE, _startTime);
		return startDate;
	}

	/**
	 * A specified time period, including the emergence of the end time to calculate.
	 * @return The emergence time period ends
	 */
	public Calendar getSpawnEndTime(Calendar now) {
		// Date acquisition criteria
		Calendar endDate = getBaseCycleOnTarget(now);
		// Calculations emergence period
		endDate.add(Calendar.MINUTE, _endTime);
		return endDate;
	}

	/**
	 * Including the time period specified that the next cycle to calculate the timing of emergence.
	 * @return The emergence of the next period of time
	 */
	public Calendar nextSpawnTime(Calendar now) {
		// Date acquisition criteria
		Calendar next = (Calendar) now.clone();
		next.add(Calendar.DAY_OF_MONTH, _periodDay);
		next.add(Calendar.HOUR_OF_DAY, _periodHour);
		next.add(Calendar.MINUTE, _periodMinute);
		return calcSpawnTime(next);
	}

	/**
	 * Date and time specified for the recent emergence of a return to the start time.
	 * @return The recent emergence of the start time
	 */
	public Calendar getLatestStartTime(Calendar now) {
		// Date acquisition criteria
		Calendar latestStart = getSpawnStartTime(now);
		if (!now.before(latestStart)) { // now >= latestStart
		} else {
			// now < latestStart If you are the latest period before 1
			latestStart.add(Calendar.DAY_OF_MONTH, -_periodDay);
			latestStart.add(Calendar.HOUR_OF_DAY, -_periodHour);
			latestStart.add(Calendar.MINUTE, -_periodMinute);
		}

		return latestStart;
	}

	private static int getTimeParse(String target, String search) {
		if (target == null) {
			return 0;
		}
		int n = 0;
		Matcher matcher = Pattern.compile("\\d+" + search).matcher(target);
		if (matcher.find()) {
			String match = matcher.group();
			n = Integer.parseInt(match.replace(search, ""));
		}
		return n;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "BossCycleList")
	static class L1BossCycleList {
		@XmlElement(name = "BossCycle")
		private List<L1BossCycle> bossCycles;

		public List<L1BossCycle> getBossCycles() {
			return bossCycles;
		}

		public void setBossCycles(List<L1BossCycle> bossCycles) {
			this.bossCycles = bossCycles;
		}
	}

	public static void load() {
		PerformanceTimer timer = new PerformanceTimer();
		System.out.print("Loading Boss Cycle...");
		try {
			// BookOrder To generate the context of a binding class
			JAXBContext context = JAXBContext.newInstance(L1BossCycle.L1BossCycleList.class);
			// XML -> POJO Conversion of the generating xml
			Unmarshaller um = context.createUnmarshaller();
			// XML -> POJO Conversion
			File file = new File("./data/xml/Cycle/BossCycle.xml");
			L1BossCycleList bossList = (L1BossCycleList) um.unmarshal(file);

			for (L1BossCycle cycle : bossList.getBossCycles()) {
				cycle.init();
				_cycleMap.put(cycle.getName(), cycle);
			}
			// user If the data is overwritten
			File userFile = new File("./data/xml/Cycle/users/BossCycle.xml");
			if (userFile.exists()) {
				bossList = (L1BossCycleList) um.unmarshal(userFile);
				for (L1BossCycle cycle : bossList.getBossCycles()) {
					cycle.init();
					_cycleMap.put(cycle.getName(), cycle);
				}
			}
			// spawnlist_boss From the loading place
			BossSpawnTable.fillSpawnTable();
		} catch (Exception e) {
			_log.log(Level.SEVERE, "BossCycle Could not load", e);
			System.exit(0);
		}
		System.out.println("     OK!     " + timer.elapsedTimeMillis() + "ms");
	}

	/**
	 * Name and appearance period specified period of time, the emergence of time to console output
	 * @param now The period of time
	 */
	public void showData(Calendar now) {
		System.out.println("[Type]" + getName());
		System.out.print("  [Emergence period]");
		System.out.print(_sdf.format(getSpawnStartTime(now).getTime()) + " - ");
		System.out.println(_sdf.format(getSpawnEndTime(now).getTime()));
	}

	private static HashMap<String, L1BossCycle> _cycleMap = new HashMap<String, L1BossCycle>();

	public static L1BossCycle getBossCycle(String type) {
		return _cycleMap.get(type);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public Base getBase() {
		return _base;
	}

	public void setBase(Base base) {
		this._base = base;
	}

	public Cycle getCycle() {
		return _cycle;
	}

	public void setCycle(Cycle cycle) {
		this._cycle = cycle;
	}

	private static Logger _log = Logger.getLogger(L1BossCycle.class.getName());
}