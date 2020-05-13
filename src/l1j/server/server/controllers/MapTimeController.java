package l1j.server.server.controllers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.MapTimerTable;
import l1j.server.server.utils.PerformanceTimer;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapTimeController implements Runnable {
	private static Logger _log = LoggerFactory.getLogger(MapTimeController.class.getName());
	private static final String _path = "./data/xml/Cycle/ResetMapTimeCycle.xml";

	private static HashMap<String, MapTimeController> _dataMap = new HashMap<String, MapTimeController>();

	private static MapTimeController _instance;

	public static MapTimeController getInstance() {
		if (_instance == null) {
			_instance = new MapTimeController();
		}
		
		return _instance;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "ResetCycleList")
	private static class ResetCycleList implements Iterable<MapTimeController> {
		@XmlElement(name = "ResetCycle")
		private List<MapTimeController> _list;

		public Iterator<MapTimeController> iterator() {
			return _list.iterator();
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Area {
		@XmlAttribute(name = "AreaId")
		private int _areaId;
		
		private int getAreaId() {
			return _areaId;
		}

		@XmlAttribute(name = "Week")
		private int _week;
		
		private int getWeek() {
			return _week;
		}
	}

	@XmlAttribute(name = "Time")
	private String _time;

	public String getTime() {
		return _time;
	}

	@XmlElement(name = "Area")
	private CopyOnWriteArrayList<Area> _areas;

	private List<Area> getAreas() {
		return _areas;
	}
	
	public static MapTimeController get(String time) {
		return _dataMap.get(time);
	}

	private static void loadMapTimers(HashMap<String, MapTimeController> dataMap) {
		try {
			PerformanceTimer timer = new PerformanceTimer();
			JAXBContext context = JAXBContext.newInstance(MapTimeController.ResetCycleList.class);
			Unmarshaller um = context.createUnmarshaller();
			
			File file = new File(_path);
			MapTimeController.ResetCycleList list = (MapTimeController.ResetCycleList) um.unmarshal(file);
			for (MapTimeController each : list) {
				dataMap.put(each.getTime(), each);
			}
			
			_log.info("loading map timers...OK! " + timer.elapsedTimeMillis() + "ms");
		} catch (Exception e) {
			_log.error("Load " + _path + "failed!", e);
			System.exit(0);
		}
	}

	public void load() {
		loadMapTimers(_dataMap);
	}
	
	public void reload() {
		HashMap<String, MapTimeController> dataMap = new HashMap<String, MapTimeController>();
		loadMapTimers(dataMap);
		_dataMap = dataMap;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				checkResetTime();
				Thread.sleep(60000);
			}
		} catch (Exception e1) {
			_log.warn(e1.getMessage());
		}
	}

	private void checkResetTime() {
		Calendar cal = Calendar.getInstance();
		MapTimeController timer = get(String.format("%1$TH:%1$TM",cal));
		
		if (timer != null) {
			for(Area each : timer.getAreas()) {
				if (each.getWeek() > 0 & each.getWeek() != cal.get(Calendar.DAY_OF_WEEK)) {
					continue;
				}
				
				MapTimerTable.reset(each.getAreaId());
			}
		}
	}
}
