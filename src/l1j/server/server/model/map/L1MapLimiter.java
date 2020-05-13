package l1j.server.server.model.map;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
import l1j.server.server.datatables.MapsTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.utils.PerformanceTimer;

@XmlAccessorType(XmlAccessType.FIELD)
public class L1MapLimiter implements Runnable {
	private static Logger _log = LoggerFactory.getLogger(L1PcInstance.class.getName());

	private static L1PcInstance _pc = null;
	private static MapTimerTable _mapTimerTable = null;
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "MapLimiterList")
	private static class MapLimiterList implements Iterable<L1MapLimiter> {
		@XmlElement(name = "MapLimiter")
		private List<L1MapLimiter> _list;

		public Iterator<L1MapLimiter> iterator() {
			return _list.iterator();
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Effect {
		@XmlAttribute(name = "Time")
		private int _time;

		public int getTime() {
			return _time;
		}

		@XmlAttribute(name = "MinLevel")
		private int _minLevel;
		
		public int getMinLevel() {
			return _minLevel;
		}

		@XmlAttribute(name = "MaxLevel")
		private int _maxLevel;
		
		public int getMaxLevel() {
			return _maxLevel;
		}
		
		@XmlAttribute(name = "Delay")
		private int _delay;

		public int getDelay() {
			return _delay;
		}

		@XmlAttribute(name = "X")
		private int _x;

		public int getX() {
			return _x;
		}

		@XmlAttribute(name = "Y")
		private int _y;

		public int getY() {
			return _y;
		}

		@XmlAttribute(name = "BackMapId")
		private short _backmapid;

		public short getBackMapId() {
			return _backmapid;
		}
	}

	private static final String PATH = "./data/xml/etc/MapLimiter.xml";

	private static HashMap<Integer, L1MapLimiter> _dataMap = new HashMap<Integer, L1MapLimiter>();

	public static L1MapLimiter get(int _mapId) {
		return _dataMap.get(_mapId);
	}

	@XmlAttribute(name = "MapId")
	private Integer _mapId;

	public Integer getMapId() {
		return _mapId;
	}

	@XmlAttribute(name = "AreaId")
	private Integer _areaId;

	public Integer getAreaId() {
		return _areaId;
	}

	@XmlElement(name = "Effect")
	private Effect _effect;

	public Effect getEffect() {
		return _effect;
	}

	public int getEnterTime() {
		return _mapTimerTable == null ? 0 : _mapTimerTable.getEnterTime();
	}
	
	public static void loadXml(HashMap<Integer, L1MapLimiter> dataMap) {
		PerformanceTimer timer = new PerformanceTimer();
		
		try {
			JAXBContext context = JAXBContext.newInstance(L1MapLimiter.MapLimiterList.class);

			Unmarshaller um = context.createUnmarshaller();

			File file = new File(PATH);
			MapLimiterList list = (MapLimiterList) um.unmarshal(file);

			for (L1MapLimiter each : list) {
				if (MapsTable.getInstance().locationname(each.getMapId()) == null) {
					System.out.println(String.format("Unable to find map: %d", each.getMapId()));
				} else {
					dataMap.put(each.getMapId(), each);
				}
			}
		} catch (Exception e) {
			_log.error(PATH + "load failed.", e);
			System.exit(0);
		}
		
		_log.info("loading map limiter...OK! " + timer.elapsedTimeMillis() + "ms");
	}

	public static void load() {
		loadXml(_dataMap);
	}
	
	public static void reload() {
		HashMap<Integer, L1MapLimiter> dataMap = new HashMap<Integer, L1MapLimiter>();
		loadXml(dataMap);
		_dataMap = dataMap;
	}

	public void execute(L1PcInstance pc) {
		_pc = pc;
		_mapTimerTable = MapTimerTable.find(pc.getId(), getAreaId());
		
		if (_mapTimerTable == null) {
			int time = pc.getMapLimiter().getEffect().getTime();
			_mapTimerTable = new MapTimerTable(pc.getId(), getMapId(), getAreaId(), time);
		}
	}
	
	@Override
	public void run() {
		try {
			Effect effect = getEffect();
			int enterTime = _mapTimerTable.getEnterTime();
			if ((effect.getTime() > 0 && (enterTime - 1) >= 0) || effect.getTime() <= 0){
				if (effect.getMinLevel() > 0 && _pc.getLevel() < effect.getMinLevel()) {
					_pc.sendPackets(new S_ServerMessage(1287)); // Do not meet level requirements
					teleport();
				}
				
				if (effect.getMaxLevel() > 0 && _pc.getLevel() > effect.getMaxLevel()) {
					_pc.sendPackets(new S_ServerMessage(1287)); // Do not meet level requirements
					teleport();
				}
				
				if (effect.getTime() > 0) {
					int h = enterTime / 3600;
					int m = (enterTime % 3600) / 60;
					if (enterTime <= effect.getDelay()) {
						_pc.sendPackets(new S_ServerMessage(1528, String.valueOf(enterTime)));
						// Remaining time is x seconds
					} else if ((enterTime == effect.getTime()) // On first entry
						|| (enterTime % 1800 == 0) // every 30 minutes
						|| ((enterTime <= 600) && (enterTime % 60 == 0))) { //every 10 minutes, or 10 minutes or less
						if (h > 0) {
							if (m > 0) {
								// x hours and m minutes remaining
								_pc.sendPackets(new S_ServerMessage(1525, String.valueOf(h), String.valueOf(m)));
							} else {
								// x hours remaining
								_pc.sendPackets(new S_ServerMessage(1526, String.valueOf(h)));
							}
						} else {
							// x minutes remaining
							_pc.sendPackets(new S_ServerMessage(1527, String.valueOf(m)));
						}
					}
					_mapTimerTable.setEnterTime(enterTime - 1);
				}
			} else {
				int h = effect.getTime() / 3600;
				int m = (effect.getTime() % 3600) / 60;
				if (h > 0) {
					if (m > 0) {
						// x hours and m minutes have passed
						_pc.sendPackets(new S_ServerMessage(1524, String.valueOf(h), String.valueOf(m)));
					} else {
						// x hours has passed
						_pc.sendPackets(new S_ServerMessage(1522, String.valueOf(h)));
					}
				} else {
					// x time has passed
					_pc.sendPackets(new S_ServerMessage(1523, String.valueOf(m)));
				}
				
				teleport();
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	private void teleport() {
		Effect effect = getEffect();
		
		int rndx = ThreadLocalRandom.current().nextInt(3);
		int rndy = ThreadLocalRandom.current().nextInt(3);
		int locx = effect.getX() + rndx;
		int locy = effect.getY() + rndy;
		short mapid = effect.getBackMapId();
		L1Teleport.teleport(_pc, locx, locy, mapid, 5, true);
	}
	
	public void save() {
		if (_mapTimerTable != null) {
			_mapTimerTable.save();
		}
	}
}
