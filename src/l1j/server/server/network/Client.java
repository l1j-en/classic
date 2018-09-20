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
package l1j.server.server.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.GameServer;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.PacketHandler;
import l1j.server.server.PacketOutput;
import l1j.server.server.controllers.LoginController;
import l1j.server.server.datatables.CharBuffTable;
import l1j.server.server.datatables.LogPacketsTable;
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
import l1j.server.server.model.Packet;
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
import l1j.server.server.utils.SystemUtil;

// Referenced classes of package l1j.server.server:
// PacketHandler, Logins, IpTable, LoginController,
// ClanTable, IdFactory
//
public class Client implements Runnable, PacketOutput {

	private ConcurrentLinkedQueue<byte[]> queue = new ConcurrentLinkedQueue<byte[]>();
	private static Logger _log = Logger.getLogger(Client.class.getName());
	protected static Timer _observerTimer = null;
	private Account _account;
	private L1PcInstance _activeChar;
	private boolean _charRestart = true;
	// last x # of packets (configurable in server.properties) the client sent to
	// the server
	// used in the -report function to give a bit of historical info
	private List<Packet> _clientPacketsLog = new CopyOnWriteArrayList<Packet>();
	private LineageKeys _clkey;
	private boolean _disconnectNextClick;
	private PacketHandler _handler;
	private String _hostname;
	private String _ip;
	private int _kick = 0;

	// used only for logging purposes
	private String _lastActiveCharName = "--NO CHARACTERS LOGGED IN--";

	private int _lastOpCodeReceviedFromClient = -1;
	private long _lastSavedTime = System.currentTimeMillis();

	private long _lastSavedTime_inventory = System.currentTimeMillis();

	private int _loginStatus = 0;
	private OutputStream _out;
	// stores the last 20 packets, and if the client crashes, it logs those to the
	// DB
	private List<Packet> _serverPacketsLog = new CopyOnWriteArrayList<Packet>();

	public Channel channel;

	protected Client() {
	}

	public Client(Channel channel) throws IOException {
		this.channel = channel;
		_ip = ((InetSocketAddress) channel.remoteAddress()).getAddress().getHostAddress();
		// _ip = channel.getInetAddress().getHostAddress();
		if (Config.HOSTNAME_LOOKUPS) {
			_hostname = ((InetSocketAddress) channel.remoteAddress()).getAddress().getCanonicalHostName();
		} else {
			_hostname = _ip;
		}
		_handler = new PacketHandler(Client.this);
		_log.info(String.format("(%s) Login detected. Current memory:%d MB RAM, CurrentThreads=%d, "
				+ "Players Array Size: %d, Pets Array Size: %d, Summons Array Size: %d, All Objects Array Size: %d, "
				+ "WarList Array Size: %d, Clans Array Size: %d", _hostname, SystemUtil.getUsedMemoryMB(),
				GeneralThreadPool.getInstance().getCurrentThreadCount(), L1World.getInstance().getAllPlayers().size(),
				L1World.getInstance().getAllPets().size(), L1World.getInstance().getAllSummons().size(),
				L1World.getInstance().getAllVisibleObjects().size(), // poorly named.. it actually gets all the
																		// _allobjects object
				L1World.getInstance().getWarList().size(), L1World.getInstance().getAllClans().size()));
	}

	public static void quitGame(L1PcInstance pc, String lastActiveChar) {
		// First cancel trade & save inventory to help avoid duping
		try {
			if (pc.getTradeID() != 0) {
				L1Trade trade = new L1Trade();
				trade.TradeCancel(pc);
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, "Last active char for SEVERE exception below: " + lastActiveChar);
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		if (pc.isDead()) {
			int[] loc = { 33090, 33392, 4 }; // Default to SKT, in case there was an error.
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
			L1PcInstance fightPc = (L1PcInstance) L1World.getInstance().findObject(pc.getFightId());
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
				pet.dropItem(true);
				pc.getPetList().remove(pet.getId());
				pet.deleteMe();
			}

			if (petObject instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) petObject;
				summon.set_currentPetStatus(3); // set it into rest mode
				summon.allTargetClear();
				for (L1PcInstance visiblePc : L1World.getInstance().getVisiblePlayer(summon)) {
					visiblePc.sendPackets(new S_SummonPack(summon, visiblePc, false));
				}
			}
		}

		for (L1DollInstance doll : pc.getDollList().values())
			doll.deleteDoll();
		for (L1FollowerInstance follower : pc.getFollowerList().values()) {
			follower.setParalyzed(true);
			follower.spawn(follower.getNpcTemplate().get_npcId(), follower.getX(), follower.getY(),
					follower.getHeading(), follower.getMapId());
			follower.deleteMe();
		}

		try {
			pc.saveInventory();
		} catch (Exception e) {
			_log.log(Level.SEVERE, "Last active char for SEVERE exception below: " + lastActiveChar);
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
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
			_log.log(Level.SEVERE, "Last active char for SEVERE exception below: " + lastActiveChar);
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	public void addToClientPacketLog(int opCode, String packet) {
		this._clientPacketsLog.add(new Packet(opCode, packet));

		Iterator<Packet> packetIterator = this._clientPacketsLog.iterator();
		while (packetIterator.hasNext()) {
			Packet p = packetIterator.next();

			if (this._clientPacketsLog.size() > Config.CLIENT_HISTORICAL_PACKETS) {
				this._clientPacketsLog.remove(p);
			}
		}
	}

	public void addToServerPacketLog(String packet) {
		this._serverPacketsLog.add(new Packet(packet));

		Iterator<Packet> packetIterator = this._serverPacketsLog.iterator();

		while (packetIterator.hasNext()) {
			Packet p = packetIterator.next();

			if (this._serverPacketsLog.size() > 20) {
				this._serverPacketsLog.remove(p);
			}
		}
	}

	public void CharReStart(boolean flag) {
		_charRestart = flag;
	}

	public void clearClientPacketLog() {
		this._clientPacketsLog.clear();
	}

	public void close() throws IOException {
		// _csocket.close();
	}

	private void doAutoSave() throws Exception {
		if (_activeChar == null || _charRestart) {
			return;
		}
		try {
			if (Config.AUTOSAVE_INTERVAL * 1000 < System.currentTimeMillis() - _lastSavedTime) {
				_activeChar.save();
				_lastSavedTime = System.currentTimeMillis();
			}
			if (Config.AUTOSAVE_INTERVAL_INVENTORY * 1000 < System.currentTimeMillis() - _lastSavedTime_inventory) {
				_activeChar.saveInventory();
				_lastSavedTime_inventory = System.currentTimeMillis();
			}
		} catch (Exception e) {
			_log.warning("Client autosave failure. Last active char: " + getLastActiveCharName());
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			throw e;
		}
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

	public L1PcInstance getActiveChar() {
		return _activeChar;
	}

	public boolean getDisconnectNextClick() {
		return _disconnectNextClick;
	}

	public String getHostname() {
		return _hostname;
	}

	public String getIp() {
		return _ip;
	}

	public String getLastActiveCharName() {
		return this._lastActiveCharName;
	}

	public List<Packet> getLastClientPackets() {
		return this._clientPacketsLog;
	}

	public List<Packet> getLastServerPackets() {
		return this._serverPacketsLog;
	}

	public void kick() {
		_log.info("Kicked account: " + getAccountName() + ":" + _hostname);
		sendPacket(new S_Disconnect());
		_kick = 1;
		// StreamUtil.close(_out, _in);
	}

	public void handleDisconnect() {
		try {
			// don't log if getAccountName is null because we will assume it was a crash
			// before login
			if (_lastOpCodeReceviedFromClient != Opcodes.C_OPCODE_QUITGAME && getAccountName() != null
					&& !GameServer.getInstance().isShuttingDown()) {
				for (Packet packet : _serverPacketsLog) {
					LogPacketsTable.storeLogPacket(-1, getAccountName(), -1, packet.getOpCode(), packet.getPacket(),
							"client crash", packet.getTimestamp());
				}

				_serverPacketsLog.clear();
			}

			if (_activeChar != null) {
				// just keep looping until it has been Config.NON_AGGRO_LOGOUT_TIMER
				// milliseconds since the last aggressive act was done to them/taken
				// by the player to stop people from being able to force-quit
				long lastAggressiveAct = _activeChar.getLastAggressiveAct();

				while (lastAggressiveAct + Config.NON_AGGRO_LOGOUT_TIMER > System.currentTimeMillis()) {
					Thread.sleep(50); // to stop 100% cpu spike
				}

				quitGame(_activeChar, this.getLastActiveCharName());

				synchronized (_activeChar) {
					_activeChar.logout();
					setActiveChar(null);
				}
			}
			sendPacket(new S_Disconnect());
			// StreamUtil.close(_out, _in);
		} catch (Exception e) {
			_log.log(Level.SEVERE, "Last active char for SEVERE exception below: " + getLastActiveCharName());
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			LoginController.getInstance().logout(this);
		}

		_log.fine("Server thread[C] stopped");
		if (_kick < 1) {
			Level ll = Level.FINE;
			if (_hostname != null)
				ll = Level.INFO;
			_log.log(ll,
					"Client thread ended: " + getAccountName() + ":" + _hostname + " Current Memory: "
							+ SystemUtil.getUsedMemoryMB() + "MB RAM" + " CurrentThreads="
							+ GeneralThreadPool.getInstance().getCurrentThreadCount() + " CharactersOnline="
							+ (L1World.getInstance().getAllPlayers().size()));
		}

	}

	@Override
	public synchronized void run() {
		try {
			doAutoSave();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] data;
		data = queue.poll();
		if (data != null) {
			int opcode = data[0] & 0xFF;

			// if they're clicking "OK" on the common news sent for a ban or ip restriction,
			// then kick them
			if (opcode == Opcodes.C_OPCODE_COMMONCLICK && this.getDisconnectNextClick()) {
				sendPacket(new S_Disconnect());
			}

			if (opcode == Opcodes.C_OPCODE_COMMONCLICK || opcode == Opcodes.C_OPCODE_CHANGECHAR) {
				_loginStatus = 1;
			}
			if (opcode == Opcodes.C_OPCODE_LOGINTOSERVER) {
				if (_loginStatus != 1) {
					return;
				}
			}
			if (opcode == Opcodes.C_OPCODE_LOGINTOSERVEROK || opcode == Opcodes.C_OPCODE_RETURNTOLOGIN) {
				_loginStatus = 0;
			}

//				if (opcode != Opcodes.C_OPCODE_KEEPALIVE && opcode != Opcodes.C_OPCODE_KEEPALIVE2) {
//					observer.packetReceived();
//				}

			// be wary of making other opcodes run on another thread!
			// we initially removed everything because people were sending 2 packets
			// at the same time to duplicate items!!

			try {
				System.out.println("Giving to handler");
				_handler.handlePacket(data, _activeChar);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

		}

		return;
	}

	@Override
	public void sendPacket(ServerBasePacket packet) {
		synchronized (this) {
			try {
				byte abyte0[] = packet.getContent();
				char ac[] = new char[abyte0.length];
				ac = UChar8.fromArray(abyte0);
				ac = LineageEncryption.encrypt(ac, get_clkey());
				abyte0 = UByte8.fromArray(ac);
				int j = abyte0.length + 2;
				ByteBuf buffer = channel.alloc().buffer(j);
				buffer.writeByte(j & 0xff);
				buffer.writeByte(j >> 8 & 0xff);
				buffer.writeBytes(abyte0);
				channel.writeAndFlush(buffer);
				// _out.flush();
			} catch (Exception e) {
			}
		}
		try {
			_out.flush();
		} catch (Exception e) {
		}
	}

	public void setAccount(Account account) {
		_account = account;
	}

	public void setActiveChar(L1PcInstance pc) {
		_activeChar = pc;
	}

	public void setDisconnectNextClick(boolean disconnect) {
		_disconnectNextClick = disconnect;
	}

	public void setLastActiveCharName(String charName) {
		this._lastActiveCharName = charName;
	}

	public void setLastClientPacket(int opCode) {
		_lastOpCodeReceviedFromClient = opCode;
	}

	public ConcurrentLinkedQueue<byte[]> getQueue() {
		return queue;
	}

	public void setQueue(ConcurrentLinkedQueue<byte[]> queue) {
		this.queue = queue;
	}

	public LineageKeys get_clkey() {
		return _clkey;
	}

	public void set_clkey(LineageKeys _clkey) {
		this._clkey = _clkey;
	}
}
