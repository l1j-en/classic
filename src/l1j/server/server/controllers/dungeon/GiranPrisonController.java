package l1j.server.server.controllers.dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;

public class GiranPrisonController implements TimedDungeonInstance {
	private static GiranPrisonController _instance;
	private static ConcurrentHashMap<String, Long> _users = new ConcurrentHashMap<String, Long>();
	private static long _3Hours = 10800 * 1000;
	private static ArrayList<Short> _prisonMaps = new ArrayList<Short>(Arrays.asList(new Short[] { 53, 54, 55, 56 }));
	private long _lastRun = 0;
	
	public static GiranPrisonController getInstance() {
		if (_instance == null) {
			_instance = new GiranPrisonController();
		}
		
		return _instance;
	}
	
	@Override public String getName() {
		return "GiranPrisonController";
	}
	
	@Override
	public void run() {		
		for (Map.Entry<String, Long> entry : _users.entrySet()) {
			Long timeDiff = System.currentTimeMillis() - this._lastRun;
			
	        String user = entry.getKey();
	        L1PcInstance player = L1World.getInstance().getPlayer(user);

	        if(player != null && _prisonMaps.contains(player.getMapId())) {
	        	Long expiration = entry.getValue() - timeDiff;
		        _users.put(user, expiration);
		        
	        	if(expiration <= 0) {
	        		L1Teleport.teleport(player, 33426, 32823, (short) 4, 5, true);
	        	}
	        }
	    }
		
		// probably just being paranoid, but also loop through all players in the game
        // if they are not in the _users list but are on a Giran Prison map, then kick them
        for(L1PcInstance playerCheck : L1World.getInstance().getAllPlayers()) {
        	if(playerCheck.isGm()) {
        		continue;
        	}
        	
        	if(_prisonMaps.contains(playerCheck.getMapId()) && !_users.keySet().contains(playerCheck.getName())) {
        		playerCheck.sendPackets(new S_SystemMessage("You accessed Giran Prison through invalid means. Use the NPC in Giran!"));
        		L1Teleport.teleport(playerCheck, 33426, 32823, (short) 4, 5, true);
        	}
        }
        
        this._lastRun = System.currentTimeMillis();
	}
	
	@Override
	public void reset() {
		_users.clear();
		
		// find all players currently on the map and re-add them to the users list with
		// their time restarted
		for(L1PcInstance playerCheck : L1World.getInstance().getAllPlayers()) {
        	if(playerCheck.isGm()) {
        		continue;
        	}
        	
        	if(_prisonMaps.contains(playerCheck.getMapId())) {
        		_users.put(playerCheck.getName(), _3Hours);
        	}
        }
	}
	
	@Override
	public void enter(L1PcInstance playerInstance) {
		String player = playerInstance.getName();
		
		if(!_users.keySet().contains(player)) {
			_users.put(player, _3Hours);
		}

		Long timeLeft = _users.get(player);
		
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
}
