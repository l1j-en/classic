package l1j.server.server.controllers;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.L1SpawnUtil;

public class BossEventController implements Runnable {
	private static Logger _log = Logger.getLogger(BossEventController.class.getName());
	SecureRandom rand;
	ArrayList<Integer> bossIds = new ArrayList<Integer>();
	
	private static BossEventController _instance;
	
	private BossEventController() {
		rand = new SecureRandom();
		
		String[] tmpBossIds = Config.ALT_BOSS_EVENT_BOSSES.split(",");
		
		for(String bossId : tmpBossIds) {
			bossIds.add(Integer.parseInt(bossId));
		}
	}
	
	public static BossEventController getInstance() {
		if(_instance == null)
			_instance = new BossEventController();
		
		return _instance;
	}
	
	private int lastHourRun = -1;
	private boolean spawnBoss = true;
		
	@Override
	public void run() {
		Thread.currentThread().setName("BossEventController");
		
		try {		
			while(true) {
				// by default sleep 5 minutes - 300000
				int sleepTime = 60000;
				
				Calendar rightNow = Calendar.getInstance();
				int hour = rightNow.get(Calendar.HOUR_OF_DAY);
				
				// if we haven't spawned a boss this hour, set the sleep time to some random interval 
				// that will cause them to spawn within this hour
				/*if(lastHourRun != hour && !spawnBoss) {
					int minute = 63 - rightNow.get(Calendar.MINUTE); // don't spawn within the last 3 minutes of the hour
					
					if(minute < 0) {
						minute = 0;
					}
					
					sleepTime = rand.nextInt(minute * 60000);
					spawnBoss = true;
				}*/
				spawnBoss = true;
				ArrayList<L1PcInstance> players = new ArrayList<L1PcInstance>(L1World.getInstance().getAllPlayers());
				if(spawnBoss && players.size() > 0) {
					spawnBoss = false;
					
					L1World world = L1World.getInstance();
					world.broadcastServerMessage("\\fR[******] A boss is about to spawn! [******]");
					Thread.sleep(rand.nextInt(300000)); // wait ~ 5 minutes for players to get to the correct map
					
					// 30% chance 2 bosses will spawn
					int spawnRate = rand.nextInt(10000);
					
					int numBossesToSpawn = 3;
					
					if(spawnRate < 3000) {
						numBossesToSpawn = 3;
					}
					
					int spawnedBosses = 0;
					
					while(spawnedBosses < numBossesToSpawn) {
						int playerToGet = rand.nextInt(players.size());
						L1PcInstance player = players.get(playerToGet);
						
						// non GMs on the aden map, on a normal (non safety/combat) zone
						if(player == null || player.getMapId() != 4 || !player.getMap().isNormalZone(player.getLocation())
								|| player.getLevel() < 65 || player.isGm() || player.isDead()) {
							continue;
						}
						
						int bossToGet = bossIds.get(rand.nextInt(bossIds.size()));
						L1Npc boss = NpcTable.getInstance().getTemplate(bossToGet);
						// spawn the boss but have it auto despawn after 15 minutes
						L1SpawnUtil.spawn(player, boss.get_npcId(), 15, 900000);
						spawnedBosses++;
					}
				}

				_log.log(Level.FINE, "Boss Event Controller Finished run, sleeping.");
				Thread.sleep(sleepTime);
			}
		} catch(Exception ex) {
			_log.log(Level.WARNING, "Boss Event Controller Crashed! No bosses for event will spawn!");
		}
	}
}
