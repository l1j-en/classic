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

/*
 * Rewritten by tricid to use netty (java nio).  This should make the server more performant 
 * and handle more client connections before it craps out.  We will no longer have x threads per client. 
 * Instead there will be a static amount of threads in a producer/consumer model.
 * 
 * Example:  old way with 100 players, you'd have:  client thread, two hcpacket threads, 1+ observers (because I think this is broken)
 * so 100 players = 400+ threads.  New way:  10 consumer threads, 2ish network threads (producers) (netty will run more per server core count I think), 
 * and that's it.  
 */
package l1j.server.server.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import l1j.server.server.encryptions.L1JEncryption;
import l1j.server.server.encryptions.L1JKeys;
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
import l1j.server.server.utils.SystemUtil;

public class Client implements Runnable, PacketOutput {

	private static Logger _log = LoggerFactory.getLogger(Client.class);
	private Account _account;
	private L1PcInstance _activeChar;
	private boolean _charRestart = true;
	private L1JKeys _clkey;
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
	public Channel channel;

	private ConcurrentLinkedQueue<byte[]> queue = new ConcurrentLinkedQueue<byte[]>();
	private long longest;

	private class LogoutDelay implements Runnable {
		private Client client;

		LogoutDelay(Client client) {
			this.client = client;
		}

		@Override
		public void run() {
			try {
				// TODO Auto-generated method stub
				quitGame(_activeChar, client.getLastActiveCharName());

				synchronized (_activeChar) {
					_activeChar.logout();
					setActiveChar(null);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("", e);
			}

		}
	}

	protected Client() {
	}

	public Client(Channel channel) throws IOException {
		this.channel = channel;
		_ip = ((InetSocketAddress) channel.remoteAddress()).getAddress().getHostAddress();
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
			_log.error("Last active char for SEVERE exception below: " + lastActiveChar);
			_log.error(e.getLocalizedMessage(), e);
		}

		if (pc.isDead()) {
			int[] loc = { 33090, 33392, 4 }; // Default to SKT, in case there was an error.
			try {
				loc = Getback.GetBack_Location(pc, true);
			} catch (Exception e) {
				_log.error(e.getLocalizedMessage(), e);
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
			_log.error("Last active char for SEVERE exception below: " + lastActiveChar);
			_log.error(e.getLocalizedMessage(), e);
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
			_log.error("Last active char for SEVERE exception below: " + lastActiveChar);
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	public void CharReStart(boolean flag) {
		_charRestart = flag;
	}

	public void close() throws IOException {
		channel.close();
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
			_log.error("Client autosave failure. Last active char: " + getLastActiveCharName());
			_log.error(e.getLocalizedMessage(), e);
			throw e;
		}
	}

	public L1JKeys get_clkey() {
		return _clkey;
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

	public ConcurrentLinkedQueue<byte[]> getQueue() {
		return queue;
	}

	public void handleDisconnect() {
		try {
			// don't log if getAccountName is null because we will assume it was a crash
			// before login
			if (_lastOpCodeReceviedFromClient != Opcodes.C_OPCODE_QUITGAME && getAccountName() != null
					&& !GameServer.getInstance().isShuttingDown()) {
			}

			if (_activeChar != null) {
				// just keep looping until it has been Config.NON_AGGRO_LOGOUT_TIMER
				// milliseconds since the last aggressive act was done to them/taken
				// by the player to stop people from being able to force-quit
				long lastAggressiveAct = _activeChar.getLastAggressiveAct();

				if (lastAggressiveAct + Config.NON_AGGRO_LOGOUT_TIMER > System.currentTimeMillis()) {
					LogoutDelay delay = new LogoutDelay(this);
					GeneralThreadPool.getInstance().schedule(delay,
							System.currentTimeMillis() - (lastAggressiveAct + Config.NON_AGGRO_LOGOUT_TIMER));
				}

			}
			sendPacket(new S_Disconnect());
		} catch (Exception e) {
			_log.error("Last active char for SEVERE exception below: " + getLastActiveCharName());
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			LoginController.getInstance().logout(this);
		}

		_log.trace("Server thread[C] stopped");
		if (_kick < 1) {

			_log.info("Client thread ended: " + getAccountName() + ":" + _hostname + " Current Memory: "
					+ SystemUtil.getUsedMemoryMB() + "MB RAM" + " CurrentThreads="
					+ GeneralThreadPool.getInstance().getCurrentThreadCount() + " CharactersOnline="
					+ (L1World.getInstance().getAllPlayers().size()));
		}

	}

	public void kick() {
		_log.info("Kicked account: " + getAccountName() + ":" + _hostname);
		sendPacket(new S_Disconnect());
		_kick = 1;
	}

	@Override
	public synchronized void run() {
		long start = System.currentTimeMillis();
		int opcode = 0;
		try {
			doAutoSave();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			_log.error("", e1);
		}
		byte[] data;
		data = queue.poll();
		if (data != null) {
			opcode = data[0] & 0xFF;

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

			try {
				_handler.handlePacket(data, _activeChar);
			} catch (Exception e) {
				_log.error("", e);
			}
		} else {

		}
		long elapse = System.currentTimeMillis() - start;
		if (elapse > longest) {
			_log.error("Longest processing time reached");
			if (_activeChar != null) {
				_log.error("Character: " + _activeChar.getName());
			}
			_log.error("Opcode: " + opcode);
			_log.error("Elapse: " + elapse);

			longest = elapse;
		} else if (elapse > 100) {
			_log.warn("Potentially slow packet detected");
			if (_activeChar != null) {
				_log.error("Character: " + _activeChar.getName());
			}
			_log.error("Opcode: " + opcode);
			_log.error("Elapse: " + elapse);
		}
		return;
	}

	@Override
	public void sendPacket(ServerBasePacket packet) {
		try {
			byte abyte0[] = packet.getContent();
			if (abyte0.length < 4) {
				_log.info("Something tried to send a bad/empty packet");
				_log.info("Packet type: " + packet.getClass().getName());
				_log.info("Packet Length: " + abyte0.length);
				return;
			}
			char ac[] = new char[abyte0.length];
			ac = UChar8.fromArray(abyte0);
			ac = L1JEncryption.encrypt(ac, get_clkey());
			abyte0 = UByte8.fromArray(ac);
			int j = abyte0.length + 2;
			ByteBuf buffer = channel.alloc().buffer(j);
			buffer.writeByte(j & 0xff);
			buffer.writeByte(j >> 8 & 0xff);
			buffer.writeBytes(abyte0);
			channel.writeAndFlush(buffer);
		} catch (Exception e) {
			_log.error("",e);
			_log.error("Packet type: " + packet.getClass().getName());
		}

	}

	public void set_clkey(L1JKeys _clkey) {
		this._clkey = _clkey;
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

	public void setQueue(ConcurrentLinkedQueue<byte[]> queue) {
		this.queue = queue;
	}
}
