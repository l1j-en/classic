package l1j.server.server.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;

public class GiranPrisonController extends TimerTask  {
	private static GiranPrisonController _instance;
	private Timer _timeHandler = new Timer("GiranPrisonTimerr",true);
	private static ConcurrentHashMap<String, Long> _users = new ConcurrentHashMap<String, Long>();
	private static long _3Hours = 10800 * 1000;
	private static ArrayList<Short> _prisonMaps = new ArrayList<Short>(Arrays.asList(new Short[] { 53, 54, 55, 56 }));

	private GiranPrisonController() {
		_timeHandler.schedule(this, 5000, 5000);
		GeneralThreadPool.getInstance().execute(this);
	}
	
	public static void Reset() {
		_users.clear();
		
		// find all players currently on the map and re-add them to the users list with
		// their time restarted
		for(L1PcInstance playerCheck : L1World.getInstance().getAllPlayers()) {
        	if(playerCheck.isGm()) {
        		continue;
        	}
        	
        	if(_prisonMaps.contains(playerCheck.getMapId())) {
        		_users.put(playerCheck.getName(), System.currentTimeMillis() + _3Hours);
        	}
        }
	}
	
	public static void EnterPrison(String player) {
		if(!_users.keySet().contains(player)) {
			_users.put(player, System.currentTimeMillis() + _3Hours);
		}

		L1PcInstance playerInstance = L1World.getInstance().getPlayer(player);
		Long timeLeft = _users.get(player) - System.currentTimeMillis();
		
		if(timeLeft <= 0) {
			playerInstance.sendPackets(new S_ServerMessage(1522, "3"));
			return;
		}
		
		L1Teleport.teleport(playerInstance, 32810, 32731, (short) 53, 6, true);
		
		String hoursLeft = String.format("%02d", TimeUnit.MILLISECONDS.toHours(timeLeft));
		String minutesLeft = String.format("%02d", TimeUnit.MILLISECONDS.toMinutes(timeLeft)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeLeft)));
		
		playerInstance.sendPackets(new S_ServerMessage(1525, hoursLeft, minutesLeft));		
	}
	
	public static GiranPrisonController getInstance() {
		if (_instance == null) {
			_instance = new GiranPrisonController();
		}
		
		return _instance;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("GiranPrisonController");		
		
		for (Map.Entry<String, Long> entry : _users.entrySet()) {
	        String user = entry.getKey();
	        Long expiration = entry.getValue();
	        
	        L1PcInstance player = L1World.getInstance().getPlayer(user);

	        if(player != null && _prisonMaps.contains(player.getMapId())
	        		&& expiration <= System.currentTimeMillis()) {
	        	L1Teleport.teleport(player, 33426, 32823, (short) 4, 5, true);
	        }
	    }
		
		// probably just being paranoid, but also loop through all players in the game
        // if they are not in the _users list but are on a Giran Prison map, then kick them
        for(L1PcInstance playerCheck : L1World.getInstance().getAllPlayers()) {
        	if(playerCheck.isGm()) {
        		continue;
        	}
        	
        	if(_prisonMaps.contains(playerCheck.getMapId()) && !_users.keySet().contains(playerCheck.getName())) {
        		playerCheck.getNetConnection().kick();
        	}
        }
	}

}
