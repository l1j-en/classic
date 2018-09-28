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
package l1j.server.server.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;

import l1j.server.Config;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.CheckWarTime;
import l1j.server.server.datatables.DoorTable;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1WarSpawn;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1CrownInstance;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1FieldObjectInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1TowerInstance;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.templates.L1Castle;

public class WarTimeController implements Runnable {
	private static WarTimeController _instance;
	private static L1Castle[] _l1castle = new L1Castle[8];
	private static Calendar[] _war_start_time = new Calendar[8];
	private static Calendar[] _war_end_time = new Calendar[8];
	private boolean[] _is_now_war = new boolean[8];

	private WarTimeController() {
		for (int i = 0; i < _l1castle.length; i++) {
			_l1castle[i] = CastleTable.getInstance().getCastleTable(i + 1);
			Calendar nowTime = getRealTime();
			Calendar oldTime = getRealTime();
			oldTime.setTime(_l1castle[i].getWarTime().getTime());
			_war_start_time[i] = _l1castle[i].getWarTime();
			oldTime.add(Config.ALT_WAR_TIME_UNIT, Config.ALT_WAR_TIME);

			if (CheckWarTime.getInstance().isActive(_l1castle[i].getId())
					&& nowTime.after(oldTime)) {
				nowTime.add(Config.ALT_WAR_INTERVAL_UNIT,
						Config.ALT_WAR_INTERVAL);
				_l1castle[i].setWarTime(nowTime);
				CastleTable.getInstance().updateCastle(_l1castle[i]);
			}

			_war_start_time[i] = _l1castle[i].getWarTime();
			_war_end_time[i] = oldTime;
		}
	}

	public static WarTimeController getInstance() {
		if (_instance == null) {
			_instance = new WarTimeController();
		}
		return _instance;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("WarTimeController");
		try {
			while (true) {
				checkWarTime();
				Thread.sleep(1000);
			}
		} catch (Exception e1) {
		}
	}

	public static L1Castle getCastle(int id) {
		return _l1castle[id];
	}

	public static void setCastle(int id, L1Castle castle) {
		_l1castle[id] = castle;
	}

	public static Calendar getWarStartTime(int id) {
		return _war_start_time[id];
	}

	public static void setWarStartTime(int id, Calendar time) {
		_war_start_time[id] = time;
	}

	public static Calendar getWarEndTime(int id) {
		return _war_end_time[id];
	}

	public static void setWarEndTime(int id, Calendar time) {
		_war_end_time[id] = time;
	}

	public static Calendar getRealTime() {
		TimeZone _tz = TimeZone.getTimeZone(Config.TIME_ZONE);
		Calendar cal = Calendar.getInstance(_tz);
		return cal;
	}

	public boolean isNowWar(int castle_id) {
		return _is_now_war[castle_id - 1];
	}

	public void checkCastleWar(L1PcInstance player) {
		for (int i = 0; i < 8; i++) {
			if (_is_now_war[i]) {
				player.sendPackets(new S_PacketBox(S_PacketBox.MSG_WAR_GOING,
						i + 1));
			}
		}
	}
	
	private void clearCastle(int castleId) {
		int[] loc = new int[3];
		
		Collection<L1PcInstance> onlineAndOfflinePlayers = new ArrayList<L1PcInstance>();
		onlineAndOfflinePlayers.addAll(L1World.getInstance().getAllPlayers());
		onlineAndOfflinePlayers.addAll(CharacterTable.getInstance().getOfflineInZone(castleId));
		
		for (L1PcInstance pc
				: onlineAndOfflinePlayers) {
			if (L1CastleLocation.checkInWarArea(castleId, pc)
					&& !pc.isGm()) {
				L1Clan clan = L1World.getInstance().getClan(
						pc.getClanname());
				if (clan != null) {
					if (clan.getCastleId() == castleId) {
						continue;
					}
				}
				loc = L1CastleLocation.getGetBackLoc(castleId);
				
				// if the character is online, teleport them
				// otherwise update their location in the DB
				if(pc.getOnlineStatus() == 1)
					L1Teleport.teleport(pc, loc[0], loc[1],
							(short) loc[2], 5, true);
				else
					CharacterTable.getInstance().moveCharacter(pc, loc[0], loc[1], (short)loc[2]);
			}
		}
	}

	private void checkWarTime() {
		for (int i = 0; i < 8; i++) {
			int castleId = i + 1;
			if (_war_start_time[i].before(getRealTime())
					&& _war_end_time[i].after(getRealTime())) {
				if (_is_now_war[i] == false) {
					_is_now_war[i] = true;
					L1WarSpawn warspawn = new L1WarSpawn();
					warspawn.SpawnFlag(castleId);
					for (L1DoorInstance door : DoorTable.getInstance()
							.getDoorList()) {
						if (L1CastleLocation.checkInWarArea(castleId, door)) {
							door.repairGate();
						}
					}

					L1World.getInstance().broadcastPacketToAll(
							new S_PacketBox(S_PacketBox.MSG_WAR_BEGIN, castleId));
					
					clearCastle(castleId);
				}
			} else if (_war_end_time[i].before(getRealTime())) {
				if (_is_now_war[i] == true) {
					//clear the players in the castle before the war ends
					clearCastle(castleId);
					_is_now_war[i] = false;
					L1World.getInstance().broadcastPacketToAll(
							new S_PacketBox(S_PacketBox.MSG_WAR_END, castleId));
					_war_start_time[i].add(Config.ALT_WAR_INTERVAL_UNIT,
							Config.ALT_WAR_INTERVAL);
					_war_end_time[i].add(Config.ALT_WAR_INTERVAL_UNIT,
							Config.ALT_WAR_INTERVAL);
					_l1castle[i].setTaxRate(10);
					_l1castle[i].setPublicMoney(0);
					CastleTable.getInstance().updateCastle(_l1castle[i]);
					
					for (L1Object l1object : L1World.getInstance().getObject()) {
						if (l1object instanceof L1FieldObjectInstance) {
							L1FieldObjectInstance flag = (L1FieldObjectInstance) l1object;
							if (L1CastleLocation
									.checkInWarArea(castleId, flag)) {
								flag.deleteMe();
							}
						}
						if (l1object instanceof L1CrownInstance) {
							L1CrownInstance crown = (L1CrownInstance) l1object;
							if (L1CastleLocation.checkInWarArea(castleId,
									crown)) {
								crown.deleteMe();
							}
						}
						if (l1object instanceof L1TowerInstance) {
							L1TowerInstance tower = (L1TowerInstance) l1object;
							if (L1CastleLocation.checkInWarArea(castleId,
									tower)) {
								tower.deleteMe();
							}
						}
					}
					
					L1WarSpawn warspawn = new L1WarSpawn();
					warspawn.SpawnTower(castleId);
					for (L1DoorInstance door : DoorTable.getInstance()
							.getDoorList()) {
						if (L1CastleLocation.checkInWarArea(castleId, door)) {
							door.repairGate();
						}
					}
				}
			}
		}
	}
}