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

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.controllers.LoginController;
import l1j.server.server.datatables.CharBuffTable;
import l1j.server.server.encryptions.ClientIdExistsException;
import l1j.server.server.encryptions.LineageEncryption;
import l1j.server.server.encryptions.LineageKeys;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.log.LogIP;
import l1j.server.server.model.Getback;
import l1j.server.server.model.L1DeathMatch;
import l1j.server.server.model.L1HauntedHouse;
import l1j.server.server.model.L1PolyRace;
import l1j.server.server.model.L1Trade;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1FollowerInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_SummonPack;
import l1j.server.server.serverpackets.ServerBasePacket;
import l1j.server.server.types.UByte8;
import l1j.server.server.types.UChar8;
import l1j.server.server.utils.StreamUtil;
import l1j.server.server.utils.SystemUtil;

// Referenced classes of package l1j.server.server:
// PacketHandler, Logins, IpTable, LoginController,
// ClanTable, IdFactory
//
public class ClientThread implements Runnable, PacketOutput {
	private static Logger _log = Logger.getLogger(ClientThread.class.getName());
	private InputStream _in;
	private OutputStream _out;
	private PacketHandler _handler;
	private Account _account;
	private L1PcInstance _activeChar;
	private String _ip;
	private String _hostname;
	private Socket _csocket;
	private int _loginStatus = 0;
	private boolean _charRestart = true;
	private long _lastSavedTime = System.currentTimeMillis();
	private long _lastSavedTime_inventory = System.currentTimeMillis();
	private static final int M_CAPACITY = 3;
	private static final int H_CAPACITY = 2;
	private int _kick = 0;
	private LineageKeys _clkey;
	// MP Bug fix - dont remove - tricid
	private boolean stop = false;
	// private static final byte[] FIRST_PACKET = { 10, 0, 38, 58, -37, 112, 46,
	// 90, 120, 0 }; // for Episode5
	// private static final byte[] FIRST_PACKET =
	// { (byte) 0x12, (byte) 0x00, (byte) 0x14, (byte) 0x1D,
	// (byte) 0x82,
	// (byte) 0xF1,
	// (byte) 0x0C, // = 0x0cf1821d
	// (byte) 0x87, (byte) 0x7D, (byte) 0x75, (byte) 0x7D,
	// (byte) 0xA1, (byte) 0x3B, (byte) 0x62, (byte) 0x2C,
	// (byte) 0x5E, (byte) 0x3E, (byte) 0x9F }; // for Episode 6
	// private static final byte[] FIRST_PACKET = { 2.70C
	// (byte) 0xb1, (byte) 0x3c, (byte) 0x2c, (byte) 0x28,
	// (byte) 0xf6, (byte) 0x65, (byte) 0x1d, (byte) 0xdd,
	// (byte) 0x56, (byte) 0xe3, (byte) 0xef };
	private static final byte[] FIRST_PACKET = { // 3.0 English KeyPacket
	(byte) 0x41, (byte) 0x5A, (byte) 0x9B, (byte) 0x01, (byte) 0xB6,
			(byte) 0x81, (byte) 0x01, (byte) 0x09, (byte) 0xBD, (byte) 0xCC,
			(byte) 0xC0 };

	protected static Timer _observerTimer = null;

	protected ClientThread() {
	}

	public ClientThread(Socket socket) throws IOException {
		_csocket = socket;
		_ip = socket.getInetAddress().getHostAddress();
		if (Config.HOSTNAME_LOOKUPS) {
			_hostname = socket.getInetAddress().getHostName();
		} else {
			_hostname = _ip;
		}
		_in = socket.getInputStream();
		_out = new BufferedOutputStream(socket.getOutputStream());
		_handler = new PacketHandler(this);
	}

	public String getIp() {
		return _ip;
	}

	public String getHostname() {
		return _hostname;
	}

	public void CharReStart(boolean flag) {
		_charRestart = flag;
	}

	public void nameThread(String tname) {
		Thread.currentThread().setName(tname);
	}
	private byte[] readPacket() throws Exception {
		try {
			int hiByte = _in.read();
			int loByte = _in.read();
			if (loByte < 0) {
				throw new RuntimeException();
			}
			int dataLength = (loByte * 256 + hiByte) - 2;
			byte data[] = new byte[dataLength];
			int readSize = 0;
			for (int i = 0; i != -1 && readSize < dataLength; readSize += i) {
				i = _in.read(data, readSize, dataLength - readSize);
			}
			if (readSize != dataLength) {
				_log.warning("Incomplete packet is sent to the server, closing connection.");
				throw new RuntimeException();
			}
			return LineageEncryption.decrypt(data, dataLength, _clkey);
		} catch (IOException e) {
			throw e;
		}
	}

	private void doAutoSave() throws Exception {
		if (_activeChar == null || _charRestart) {
			return;
		}
		try {
			if (Config.AUTOSAVE_INTERVAL * 1000 < System.currentTimeMillis()
					- _lastSavedTime) {
				_activeChar.save();
				_lastSavedTime = System.currentTimeMillis();
			}
			if (Config.AUTOSAVE_INTERVAL_INVENTORY * 1000 < System
					.currentTimeMillis() - _lastSavedTime_inventory) {
				_activeChar.saveInventory();
				_lastSavedTime_inventory = System.currentTimeMillis();
			}
		} catch (Exception e) {
			_log.warning("Client autosave failure.");
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			throw e;
		}
	}

	@Override
	public void run() {
		nameThread("ClientThread");
		_log.info("(" + _hostname + ") Login detected. "
				+ " Current memory: " + SystemUtil.getUsedMemoryMB() + "MB RAM CurrentThreads="
				+ GeneralThreadPool.getInstance().getCurrentThreadCount());
		_log.fine("Starting client thread...");
		Socket socket = _csocket;
		HcPacket movePacket = new HcPacket(M_CAPACITY);
		HcPacket hcPacket = new HcPacket(H_CAPACITY);
		GeneralThreadPool.getInstance().execute(movePacket);
		GeneralThreadPool.getInstance().execute(hcPacket);
        ClientThreadObserver observer = null;
		observer = new ClientThreadObserver(
				Config.AUTOMATIC_KICK * 60 * 1000);
		if (Config.AUTOMATIC_KICK > 0) {
			_observerTimer = new Timer("ClientThread-observer-"+_hostname);
			observer.start();
		}
		try {
			// long seed = 0x5cc690ecL; // 2.70C
			long seed = 0x7C98BDFA; // 3.0 English Packet Seed
			byte Bogus = (byte) (FIRST_PACKET.length + 7);
			_out.write(Bogus & 0xFF);
			_out.write(Bogus >> 8 & 0xFF);
			// _out.write(0x20); // 2.70C
			_out.write(0x7D); // 3.0 English Version Check.
			_out.write((byte) (seed & 0xFF));
			_out.write((byte) (seed >> 8 & 0xFF));
			_out.write((byte) (seed >> 16 & 0xFF));
			_out.write((byte) (seed >> 24 & 0xFF));
			_out.write(FIRST_PACKET);
			_out.flush();
			try {
				// long seed = 0x2e70db3aL; // for Episode5
				// long seed = 0x0cf1821dL; // for Episode6
				_clkey = LineageEncryption.initKeys(socket, seed);
			} catch (ClientIdExistsException e) {
			}

			while (!stop) {
				doAutoSave();
				byte data[] = null;
				try {
					data = readPacket();
				} catch (Exception e) {
					break;
				}
				// _log.finest("[C]\n" + new
				// ByteArrayUtil(data).dumpToString());
				int opcode = data[0] & 0xFF;

				if (opcode == Opcodes.C_OPCODE_COMMONCLICK
						|| opcode == Opcodes.C_OPCODE_CHANGECHAR) {
					_loginStatus = 1;
				}
				if (opcode == Opcodes.C_OPCODE_LOGINTOSERVER) {
					if (_loginStatus != 1) {
						continue;
					}
				}
				if (opcode == Opcodes.C_OPCODE_LOGINTOSERVEROK
						|| opcode == Opcodes.C_OPCODE_RETURNTOLOGIN) {
					_loginStatus = 0;
				}

				if (opcode != Opcodes.C_OPCODE_KEEPALIVE &&
						opcode != Opcodes.C_OPCODE_KEEPALIVE2) {
					observer.packetReceived();
				}
				if (_activeChar == null) {
					_handler.handlePacket(data, _activeChar);
					continue;
				}
				if (opcode == Opcodes.C_OPCODE_CHANGECHAR
						|| opcode == Opcodes.C_OPCODE_DROPITEM
						|| opcode == Opcodes.C_OPCODE_DELETEINVENTORYITEM) {
					_handler.handlePacket(data, _activeChar);
				} else if (opcode == Opcodes.C_OPCODE_MOVECHAR) {
					movePacket.requestWork(data);
				} else {
					hcPacket.requestWork(data);
				}
			}
		} catch (Throwable e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			try {
				if (_activeChar != null) {
					// just keep looping until it has been Config.NON_AGGRO_LOGOUT_TIMER
					// milliseconds since the last aggressive act was done to them/taken
					// by the player to stop people from being able to force-quit
					long lastAggressiveAct = _activeChar.getLastAggressiveAct();
					
					while(lastAggressiveAct + Config.NON_AGGRO_LOGOUT_TIMER 
							> System.currentTimeMillis())
					
					quitGame(_activeChar);
					synchronized (_activeChar) {
						_activeChar.logout();
						setActiveChar(null);
					}
				}
				sendPacket(new S_Disconnect());
				StreamUtil.close(_out, _in);
			} catch (Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			} finally {
				LoginController.getInstance().logout(this);
			}
		}
		_csocket = null;
		_log.fine("Server thread[C] stopped");
		if (_kick < 1) {
			Level ll = Level.FINE;
			if (_hostname != null)
				ll = Level.INFO;
			_log.log(ll, "Client thread ended: " + getAccountName() + ":"
					+ _hostname + " Current Memory: " + SystemUtil.getUsedMemoryMB() + "MB RAM"
					+ " CurrentThreads=" + GeneralThreadPool.getInstance().getCurrentThreadCount()
					+ " CharactersOnline=" + (L1World.getInstance().getAllPlayers().size()));
		}
		return;
	}

	public void kick() {
		_log.info("Kicked account: " + getAccountName() + ":" + _hostname);
		sendPacket(new S_Disconnect());
		_kick = 1;
		StreamUtil.close(_out, _in);
	}

	class HcPacket implements Runnable {
		private final Queue<byte[]> _queue;

		private PacketHandler _handler;

		public HcPacket() {
			_queue = new ConcurrentLinkedQueue<byte[]>();
			_handler = new PacketHandler(ClientThread.this);
		}

		public HcPacket(int capacity) {
			_queue = new LinkedBlockingQueue<byte[]>(capacity);
			_handler = new PacketHandler(ClientThread.this);
		}

		public void requestWork(byte data[]) {
			_queue.offer(data);
		}

		@Override
		public void run() {
			Thread.currentThread().setName("HcPacket");
			byte[] data;
			while (_csocket != null) {
				data = _queue.poll();
				if (data != null) {
					try {
						_handler.handlePacket(data, _activeChar);
					} catch (Exception e) {
					}
				} else {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
					}
				}
			}
			return;
		}
	}


	class ClientThreadObserver extends TimerTask {
		private int _checkct = 1;

		private final int _disconnectTimeMillis;

		public ClientThreadObserver(int disconnectTimeMillis) {
			_disconnectTimeMillis = disconnectTimeMillis;
		}

		public void start() {
			
			_observerTimer.scheduleAtFixedRate(ClientThreadObserver.this, 0,
					_disconnectTimeMillis);
		}

		@Override
		public void run() {
			try {
				if (_csocket == null) {
					cancel();
					return;
				}

				if (_checkct > 0) {
					_checkct = 0;
					return;
				}

				if (_activeChar == null || _activeChar != null
						&& !_activeChar.isPrivateShop()) {
					kick();
					_log.warning("Kicking character from (" + _hostname + ").");
					cancel();
					return;
				}
			} catch (Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				cancel();
			}
		}

		public void packetReceived() {
			_checkct++;
		}
	}

	@Override
	public void sendPacket(ServerBasePacket packet) {
		synchronized (this) {
			try {
				byte abyte0[] = packet.getContent();
				char ac[] = new char[abyte0.length];
				ac = UChar8.fromArray(abyte0);
				ac = LineageEncryption.encrypt(ac, _clkey);
				abyte0 = UByte8.fromArray(ac);
				int j = abyte0.length + 2;
				_out.write(j & 0xff);
				_out.write(j >> 8 & 0xff);
				_out.write(abyte0);
				// _out.flush();
			} catch (Exception e) {
			}
		}
		try {
			_out.flush();
		} catch (Exception e) {
		}
	}

	// mp bug fix - dont remove - tricid
	public void rescue() {
		try {
			_log.info("* * * Closing socket	* * * ");
			_csocket.close();
		} catch (Exception e) {
			_log.severe("* * * Failed closing socket	* * *");
			_log.severe(e.toString());
		}
		try {
			_log.info("* * * Closing streams	* * *");
			StreamUtil.close(_out, _in);
		} catch (Exception e) {
			_log.severe("* * * Failed to close streams	* * *");
			_log.severe(e.toString());
		}

		try {
			_log.info("* * * Stopping client thread	* * *");
			stop = true;
		} catch (Exception e) {
			_log.severe("* * * Failed stopping thread	* * *");
			_log.severe(e.toString());
		}

	}

	public void close() throws IOException {
		_csocket.close();
	}

	public void setActiveChar(L1PcInstance pc) {
		_activeChar = pc;
	}

	public L1PcInstance getActiveChar() {
		return _activeChar;
	}

	public void setAccount(Account account) {
		_account = account;
	}

	public Account getAccount() {
		return _account;
	}

	public String getAccountName() {
		if (_account == null) {
			return null;
		}
		return _account.getName();
	}

	public static void quitGame(L1PcInstance pc) {
		// First cancel trade & save inventory to help avoid duping
		try {
			if (pc.getTradeID() != 0) {
				L1Trade trade = new L1Trade();
				trade.TradeCancel(pc);
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		try {
			pc.saveInventory();			
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		if (pc.isDead()) {
			int[] loc = {33090, 33392, 4}; // Default to SKT, in case there was an error.
			try {
				loc = Getback.GetBack_Location(pc, true);
			} catch (Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			pc.setX(loc[0]);
			pc.setY(loc[1]);
			pc.setMap((short) loc[2]);
			pc.setCurrentHp(pc.getLevel());
			pc.set_food(40);
		}
		if (pc.getFightId() != 0) {
			pc.setFightId(0);
			L1PcInstance fightPc = (L1PcInstance) L1World.getInstance()
					.findObject(pc.getFightId());
			if (fightPc != null) {
				fightPc.setFightId(0);
				fightPc.sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL, 0, 0));
			}
		}
		if (pc.isInParty()) {
			pc.getParty().leaveMember(pc);
		}

		if (pc.isInChatParty()) {
			pc.getChatParty().leaveMember(pc);
		}
		Object[] petList = pc.getPetList().values().toArray();
		for (Object petObject : petList) {
			if (petObject instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) petObject;
				pet.dropItem();
				pc.getPetList().remove(pet.getId());
				pet.deleteMe();
			}
			if (petObject instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) petObject;
				for (L1PcInstance visiblePc : L1World.getInstance()
						.getVisiblePlayer(summon)) {
					visiblePc.sendPackets(new S_SummonPack(summon, visiblePc,
							false));
				}
			}
		}
		for (L1DollInstance doll : pc.getDollList().values())
			doll.deleteDoll();
		for (L1FollowerInstance follower : pc.getFollowerList().values()) {
			follower.setParalyzed(true);
			follower.spawn(follower.getNpcTemplate().get_npcId(),
					follower.getX(), follower.getY(), follower.getHeading(),
					follower.getMapId());
			follower.deleteMe();
		}
		L1DeathMatch.getInstance().checkLeaveGame(pc);
		L1PolyRace.getInstance().checkLeaveGame(pc);
		L1HauntedHouse.getInstance().checkLeaveGame(pc);
		CharBuffTable.DeleteBuff(pc);
		CharBuffTable.SaveBuff(pc);
		pc.clearSkillEffectTimer();
		pc.stopEtcMonitor();
		pc.setOnlineStatus(0);
		pc.stopHpRegeneration();
		pc.stopMpRegeneration();

		LogIP li = new LogIP();
		li.storeLogout(pc);
		try {
			pc.save();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}
}
