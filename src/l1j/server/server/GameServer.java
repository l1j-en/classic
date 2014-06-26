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

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

import l1j.server.Config;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.model.MpBugTest;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SystemUtil;

public class GameServer extends Thread {
	private ServerSocket _serverSocket;
	private static Logger _log = Logger.getLogger(GameServer.class.getName());
	private int _port;

	// Naive denial of service defense.
	private static final int CONNECTION_LIMIT = 6;
	private static final int CACHE_REFRESH = 1000 * 60 * 4;
	// Might be overkill, but hard to test. =\
	private static final ConcurrentMap<String, Integer> connectionCache = new ConcurrentHashMap<String, Integer>();

	static {
		GeneralThreadPool.getInstance().scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				connectionCache.clear();
			}
		}, CACHE_REFRESH, CACHE_REFRESH);
	}

	@Override
	public void run() {
		System.out.println("Server started. Memory used: "
				+ SystemUtil.getUsedMemoryMB() + "MB");
		System.out.println("Waiting for connections!");
		while (true) {
			try {
				Socket socket = _serverSocket.accept();
				System.out.println("Accepted connection from IP: "
						+ socket.getInetAddress());
				String host = socket.getInetAddress().getHostAddress();

				connectionCache.putIfAbsent(host, 1);
				if (connectionCache.get(host) > CONNECTION_LIMIT) {
					// Don't log in production, since that effectively
					// recreates the DOS.
					// _log.log(Level.WARNING,
					// "GameServer::run: " + host + " hit connection limit.");
				} else if (IpTable.getInstance().isBannedIp(host)) {
					_log.info("Banned IP(" + host + ")");
				} else {
					ClientThread client = new ClientThread(socket);
					GeneralThreadPool.getInstance().execute(client);
					connectionCache
							.replace(host, connectionCache.get(host) + 1);
				}
			} catch (IOException ioexception) {
			}
		}
	}

	private static GameServer _instance;

	private GameServer() {
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

		System.out.println("=================================================");
		System.out.println("               L1J-En Server Starting");
		System.out.println("=================================================");

		_port = Config.GAME_SERVER_PORT;
		if (!"*".equals(s)) {
			InetAddress inetaddress = InetAddress.getByName(s);
			inetaddress.getHostAddress();
			_serverSocket = new ServerSocket(_port, 50, inetaddress);
			System.out.println("Login Server ready on "
					+ (inetaddress == null ? "Port" : inetaddress
							.getHostAddress()) + ":" + _port);
		} else {
			_serverSocket = new ServerSocket(_port);
			System.out.println("Port " + _port + " opened");
		}
		MpBugTest mpbug = new MpBugTest();
		mpbug.initialize();
		SkillTable.initialize();
		GameServerThread.getInstance();
		Runtime.getRuntime().addShutdownHook(Shutdown.getInstance());
		this.start();
	}

	/**
	 * All players online to kick, character and preservation of information.
	 */
	public void disconnectAllCharacters() {
		Collection<L1PcInstance> players = L1World.getInstance()
				.getAllPlayers();
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
				world.broadcastServerMessage("Get to a safe spot. The server will restart soon!");
				world.broadcastServerMessage("Repeat, the server is going down for maintenance soon!");
				while (0 < secondsCount) {
					if (secondsCount <= 10) {
						world.broadcastServerMessage("Server will shutdown in "
								+ secondsCount
								+ " seconds.  Please get to a safe area and logout.");
					} else {
						if (secondsCount % 60 == 0) {
							world.broadcastServerMessage("Server will shutdown in "
									+ secondsCount / 60 + " minutes.");
						}
					}
					Thread.sleep(1000);
					secondsCount--;
				}
				shutdown();
			} catch (InterruptedException e) {
				world.broadcastServerMessage("Server shutdown aborted!  You may continue playing!");
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
