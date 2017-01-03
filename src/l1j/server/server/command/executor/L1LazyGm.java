package l1j.server.server.command.executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1LazyGm implements L1CommandExecutor {
	private static HashMap<Integer, LazyGmTimer> _lazyGmTimers
				= new HashMap<Integer, LazyGmTimer>();
	private static Random _random = new Random();
	
	protected static class LazyGmTimer implements Runnable {
		private L1PcInstance _gm = null;
		private int _interval;
		private boolean _stop = false;

		public LazyGmTimer(L1PcInstance gm, int interval) {
			_gm = gm;
			_interval = interval;
		}

		@Override
		public void run() {
			Thread.currentThread().setName("L1LazyGm");
			int lastVisitedId = 0;
			
			while (!_stop && _lazyGmTimers.size() > 0) {
				try {
					ArrayList<L1PcInstance> onlinePlayers
							= new ArrayList<L1PcInstance>(L1World.getInstance().getAllPlayers());
					
					if(onlinePlayers.size() < 3) {
						_gm.sendPackets(new S_SystemMessage("Not enough players online to continue. Stopping lazygm."));
						break;
					}
					
					L1PcInstance personToWatch = null;
					boolean timerInitiaterStillOnline = false;
					
					// limit of 10 just in case something funky goes wrong and it can never find someone
					// who wasn't the last person we visited
					for(int x = 0; x < 10 && 
							(personToWatch == null || personToWatch.getId() == lastVisitedId
							|| personToWatch.isPrivateShop()); x++) {
						int numberToWatch = _random.nextInt(onlinePlayers.size());
						
						for(int i = 0; i < onlinePlayers.size(); i++) {
							if(onlinePlayers.get(i).getId() == _gm.getId())
								timerInitiaterStillOnline = true;
							else if(i == numberToWatch)
								personToWatch = onlinePlayers.get(i);
						}
					}
					
					// something happened that didn't clean up the thread properly
					// so lets kill it
					if(!timerInitiaterStillOnline)
						break;
					
					if(personToWatch != null) {
						lastVisitedId = personToWatch.getId();
						L1Teleport.teleport(_gm, personToWatch.getX(), personToWatch.getY(),
								personToWatch.getMapId(), 5, false);
						
						personToWatch.setFollowingGm(_gm);
						_gm.sendPackets(new S_SystemMessage("Moved on to " + personToWatch.getName()));
						
						Thread.sleep(_interval * 1000);
					}
				} catch (Exception exception) {
					break;
				}
			} //end while
			
			stopTeleport(_gm);
		}

		private void stopTeleport(L1PcInstance gm) {
			_lazyGmTimers.remove(gm.getId());
		}
		
		private void stopFollow(L1PcInstance gm) {
			// find all other people the Gm is following and ensure we remove ourselves
			for(L1PcInstance player : L1World.getInstance().getAllPlayers()) {
				if(player.getFollowingGm() == gm)
					player.setFollowingGm(null);
			}
		}
		
		private void stop() {
			_stop = true;
			stopFollow(_gm);
		}
	}
	
	public L1LazyGm() { }
	
	public static L1CommandExecutor getInstance() {
		return new L1LazyGm();
	}
	
	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			if(arg.trim().toLowerCase().equals("-stop")) {
				if(_lazyGmTimers.containsKey(pc.getId())) {
					_lazyGmTimers.get(pc.getId()).stop();
					pc.sendPackets(new S_SystemMessage("LazyGm has been stopped."));
					return;
				}

				pc.sendPackets(new S_SystemMessage("LazyGm is not running."));
				return;
			}
			
			int playersOnline = L1World.getInstance().getAllPlayers().size();
			
			if(playersOnline < 3) {
				pc.sendPackets(new S_SystemMessage("There has to be more than 1 person to watch!"));
				return;
			}
			
			if(!pc.isGmInvis()) {
				pc.sendPackets(new S_SystemMessage("You must be invisible to run this command!"));
				return;
			}
			
			int seconds = Integer.parseInt(arg);
			LazyGmTimer timer = new LazyGmTimer(pc, seconds);
			GeneralThreadPool.getInstance().execute(timer);
			_lazyGmTimers.put(pc.getId(), timer);
			
			pc.sendPackets(new S_SystemMessage("LazyGm has been started. You will move every " + seconds + " seconds."));
			
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <seconds> or -stop"));
		}
	}
}
