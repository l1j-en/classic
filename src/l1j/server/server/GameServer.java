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
package l1j.server.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ChatLogTable;
import l1j.server.server.datatables.ClanTable;
import l1j.server.server.datatables.DoorSpawnTable;
import l1j.server.server.datatables.DropTable;
import l1j.server.server.datatables.DropItemTable;
import l1j.server.server.datatables.GetBackRestartTable;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.MapsTable;
import l1j.server.server.datatables.MobGroupTable;
import l1j.server.server.datatables.NpcActionTable;
import l1j.server.server.datatables.NpcSpawnTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.ResolventTable;
import l1j.server.server.datatables.ShopTable;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.datatables.SpawnTable;
import l1j.server.server.datatables.SprTable;
import l1j.server.server.datatables.UBSpawnTable;
import l1j.server.server.datatables.WeaponSkillTable;
import l1j.server.server.model.Dungeon;
import l1j.server.server.model.ElementalStoneGenerator;
import l1j.server.server.model.Getback;
import l1j.server.server.model.L1BossCycle;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1DeleteItemOnGround;
import l1j.server.server.model.L1NpcRegenerationTimer;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.item.L1TreasureBox;
import l1j.server.server.model.map.L1WorldMap;
import l1j.server.server.model.trap.L1WorldTraps;
import l1j.server.server.utils.DeadLockDetector;
import l1j.server.server.utils.FloodProtector;
import l1j.server.server.utils.SystemUtil;

// Referenced classes of package l1j.server.server:
// ClientThread, Logins, RateTable, IdFactory,
// LoginController, GameTimeController, Announcements,
// MobTable, SpawnTable, SkillsTable, PolyTable,
// TeleportLocations, ShopTable, NPCTalkDataTable, NpcSpawnTable,
// IpTable, Shutdown, NpcTable, MobGroupTable, NpcShoutTable

public class GameServer extends Thread {
	private ServerSocket _serverSocket;
	String _external;
	String _internal;
	private static Logger _log = Logger.getLogger(GameServer.class.getName());
	private int _port;
	private LoginController _loginController;
	private int chatlvl;
	private DeadLockDetector _deadDetectThread;
	
	@Override
	public void run() {
		System.out.println("Server Started. Memory Used: " + SystemUtil.getUsedMemoryMB() + " MB");
		System.out.println("Waiting for Connections!");
		while (true) {
			try {
				Socket socket = _serverSocket.accept();
				System.out.println("Connection accepted from IP: "+ socket.getInetAddress());
				String host = socket.getInetAddress().getHostAddress();
				if (IpTable.getInstance().isBannedIp(host)) {
					_log.info("Banned IP(" + host + ")");
				} else {
					ClientThread client = new ClientThread(socket);
					GeneralThreadPool.getInstance().execute(client);
				}
			} catch (IOException ioexception) {
			}
		}
	}

	private static GameServer _instance;

	public GameServer() {
		super("GameServer");
	}

	public static GameServer getInstance() {
		if (_instance == null) {
			_instance = new GameServer();
		}
		return _instance;
	}

	public void initialize() throws Exception {
		String s = Config.GAME_SERVER_HOST_NAME;
		double rateXp = Config.RATE_XP;
		double Lawful = Config.RATE_LA;
		double rateKarma = Config.RATE_KARMA;
		double rateDropItems = Config.RATE_DROP_ITEMS;
		double rateDropAdena = Config.RATE_DROP_ADENA;

		System.out.println("=================================================");
		System.out.println("               L1J-En Server Starting");
		System.out.println("=================================================");
		chatlvl = Config.GLOBAL_CHAT_LEVEL;
		_port = Config.GAME_SERVER_PORT;
		_internal = Config.INTERNAL_HOSTNAME;
		_external = Config.EXTERNAL_HOSTNAME;
		if (!"*".equals(s)) {
			InetAddress inetaddress = InetAddress.getByName(s);
			inetaddress.getHostAddress();
		    System.out.println("Login Server ready on "+(inetaddress == null ? "Port" : inetaddress.getHostAddress())+":"+Config.PORT_LOGIN); 
			_serverSocket = new ServerSocket(_port);
			System.out.println("Port = "+_port + " opened");
		} else {
			_serverSocket = new ServerSocket(_port);
			System.out.println("Port = "+ _port+ " opened");
		
			System.out.println("Ip internal = "+ _internal +" ready");
			System.out.println("Ip external = "+ _external +" ready");
			System.out.println("XP = " + rateXp);
			System.out.println("Lawful = " + Lawful); 
			System.out.println("Karma = "+ rateKarma); 
			System.out.println("Drop = " + rateDropItems);
			System.out.println("Adena = "+ rateDropAdena);
			System.out.println("Global Chat Lvl = " + (chatlvl));
			
			if (Config.ALT_NONPVP) { // Non-PvP Setting
				System.out.println("PvP = On");
			} else {
				System.out.println("PvP = Off");
			}
			
			Announcecycle.getInstance();  
			
			if (Config.Use_Show_INGAMENEWS_Time) {  
				System.out.println("IngameNews = On");  
				} else {  
					System.out.println("InGameNews = Off"); 
				} 
			
			if (Config.DEADLOCK_DETECTOR) 
			{ 
				_deadDetectThread = new DeadLockDetector(); 
				_deadDetectThread.setDaemon(true); 
				_deadDetectThread.start(); 
			} 
			else 
				_deadDetectThread = null; 
			 System.gc(); 	
			 
			int maxOnlineUsers = Config.MAX_ONLINE_USERS;
			System.out.println("Max Online Users : " + (maxOnlineUsers));
			IdFactory.getInstance();
			FloodProtector.getInstance();
			L1WorldMap.getInstance();
			_loginController = LoginController.getInstance();
			_loginController.setMaxAllowedOnlinePlayers(maxOnlineUsers);
	
			// Reset status online
			CharacterTable.clearOnlineStatus();
			
			// Game Time Clock
			L1GameTimeClock.init();
	
			// UB Time Controllers
			UbTimeController ubTimeContoroller = UbTimeController.getInstance();
			GeneralThreadPool.getInstance().execute(ubTimeContoroller);
	
			// Controllers time of war
			WarTimeController warTimeController = WarTimeController.getInstance();
			GeneralThreadPool.getInstance().execute(warTimeController);
	
			// Controllers ship time
			ShipTimeController shipTimeController = ShipTimeController
					.getInstance();
			GeneralThreadPool.getInstance().execute(shipTimeController);
	
			// Spirit's rock formation
			if (Config.ELEMENTAL_STONE_AMOUNT > 0) {
				ElementalStoneGenerator elementalStoneGenerator
						= ElementalStoneGenerator.getInstance();
				GeneralThreadPool.getInstance().execute(elementalStoneGenerator);
			}
	
			// Hometown
			HomeTownTimeController.getInstance();
	
			// Controllers auction time Hideout
			AuctionTimeController auctionTimeController = AuctionTimeController.getInstance();
			GeneralThreadPool.getInstance().execute(auctionTimeController);
	
			HouseTaxTimeController houseTaxTimeController = HouseTaxTimeController
					.getInstance();
			GeneralThreadPool.getInstance().execute(houseTaxTimeController);
	
			FishingTimeController fishingTimeController = FishingTimeController
					.getInstance();
			GeneralThreadPool.getInstance().execute(fishingTimeController);
	
			Announcements.getInstance();
			NpcTable.getInstance();
			L1DeleteItemOnGround deleteitem = new L1DeleteItemOnGround();
			deleteitem.onAction();
	
			if (!NpcTable.getInstance().isInitialized()) {
				throw new Exception("Could not initialize the npc table");
			}
			MobGroupTable.getInstance(); 
			SpawnTable.getInstance(); 
			SkillsTable.getInstance(); 
			PolyTable.getInstance(); 
			ItemTable.getInstance(); 
			DropTable.getInstance(); 
			DropItemTable.getInstance(); 
			ShopTable.getInstance(); 
			NPCTalkDataTable.getInstance(); 
			L1World.getInstance(); 
			L1WorldTraps.getInstance(); 
			Dungeon.getInstance(); 
			NpcSpawnTable.getInstance(); 
			IpTable.getInstance(); 
			MapsTable.getInstance(); 
			UBSpawnTable.getInstance(); 
			PetTable.getInstance(); 
			ClanTable.getInstance(); 
			CastleTable.getInstance(); 
			L1CastleLocation.setCastleTaxRate(); // This must be after the initial CastleTable 
			GetBackRestartTable.getInstance(); 
			DoorSpawnTable.getInstance(); 
			GeneralThreadPool.getInstance();
			L1NpcRegenerationTimer.getInstance(); 
			ChatLogTable.getInstance(); 
			WeaponSkillTable.getInstance(); 
			NpcActionTable.load(); 
			GMCommandsConfig.load(); 
			Getback.loadGetBack(); 
			PetTypeTable.load(); 
			L1BossCycle.load(); 
			L1TreasureBox.load(); 
			SprTable.getInstance(); 
			ResolventTable.getInstance(); 
	
			System.out.println("Database Tables Loaded Successfully!");
			Runtime.getRuntime().addShutdownHook(Shutdown.getInstance());
	
			this.start();
		}
	}

	/**
	 * All players online to kick, character and preservation of information.
	 */
	public void disconnectAllCharacters() {
		Collection<L1PcInstance> players = L1World.getInstance().getAllPlayers();
		for (L1PcInstance pc : players) {
			pc.getNetConnection().setActiveChar(null);
			pc.getNetConnection().kick();
		}
		// Kick save after all, make
		for (L1PcInstance pc : players) {
			ClientThread.quitGame(pc);
			L1World.getInstance().removeObject(pc);
		}
	}

	private class ServerShutdownThread extends Thread {
		private final int _secondsCount;

		public ServerShutdownThread(int secondsCount) {
			_secondsCount = secondsCount;
		}

		@Override
		public void run() {
			L1World world = L1World.getInstance();
			try {
				int secondsCount = _secondsCount;
				world.broadcastServerMessage("Get to a Safe Spot, Server will Restart Shortly!");
				world.broadcastServerMessage("Repeat, Server is going down for Maintanence Shortly!");
				while (0 < secondsCount) {
					if (secondsCount <= 10) {
						world.broadcastServerMessage("Server will Shut down in " + secondsCount
								+ "Seconds.  Please get to a safe area and log out");
					} else {
						if (secondsCount % 60 == 0) {
							world.broadcastServerMessage("Server will shutdown in " + secondsCount
									/ 60 + " minutes.");
						}
					}
					Thread.sleep(1000);
					secondsCount--;
				}
				shutdown();
			} catch (InterruptedException e) {
				world.broadcastServerMessage("Server Shutdown Aborted!  You may continue Playing!");
				return;
			}
		}
	}

	private ServerShutdownThread _shutdownThread = null;

	public synchronized void shutdownWithCountdown(int secondsCount) {
		if (_shutdownThread != null) {
			// Shutting down the request is already being done
			// TODO error may need to be notified
			return;
		}
		_shutdownThread = new ServerShutdownThread(secondsCount);
		GeneralThreadPool.getInstance().execute(_shutdownThread);
	}

	public void shutdown() {
		disconnectAllCharacters();
		System.exit(0);
	}

	public synchronized void abortShutdown() {
		if (_shutdownThread == null) {
			// Shutting down the request has not been
			// TODO error may need to be notified
			return;
		}

		_shutdownThread.interrupt();
		_shutdownThread = null;
	}
}
