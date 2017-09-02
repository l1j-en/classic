package l1j.server.server.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.controllers.dungeon.TimedDungeonInstance;

public class TimedDungeonController  extends TimerTask {
	private static Logger _log = Logger.getLogger(TimedDungeonController.class.getName());
	private static TimedDungeonController _instance;
	
	private Timer _timeHandler = new Timer("TimedDungeonController",true);
	private ArrayList<TimedDungeonInstance> _timedDungeons = new ArrayList<TimedDungeonInstance>();
	
	private TimedDungeonController() {
		_timeHandler.schedule(this, 5000, 5000);
		GeneralThreadPool.getInstance().execute(this);
	}
	
	public void registerDungeon(TimedDungeonInstance dungeon) {
		this._timedDungeons.add(dungeon);
	}
	
	public static TimedDungeonController getInstance() {
		if (_instance == null) {
			_instance = new TimedDungeonController();
		}
		
		return _instance;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("TimedDungeonController");	
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss") ;
		
		for(TimedDungeonInstance dungeon : this._timedDungeons) {
			dungeon.run();
			
			// if admins have their server reset daily, they may want to disable the timed reset
			if(Config.RESET_DUNGEONS_DAILY) {
				try {
					if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(Config.DUNGEON_RESET_TIME + ":00")) &&
							dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse(Config.DUNGEON_RESET_TIME + ":06")))
					{
						dungeon.reset();
					}
				} catch (Exception e) {
					// reset failed!
					_log.warning(dungeon.getName() + " daily reset failed to run! Error: " + e.getMessage());
				}
			}
		}
	}
}
