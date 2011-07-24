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
package l1j.server.server.model;

import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.InnTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.templates.L1Inn;
import l1j.server.server.utils.SQLUtil;
import l1j.server.server.utils.collections.Maps;


// Referenced classes of package l1j.server.server.model:
// L1Teleport, L1PcInstance
public class Dungeon {

	private static Logger _log = Logger.getLogger(Dungeon.class.getName());

	private static Dungeon _instance = null;

	private static Map<String, NewDungeon> _dungeonMap = new HashMap<String, NewDungeon>();

	private enum DungeonType {
		NONE, SHIP_FOR_FI, SHIP_FOR_HEINE, SHIP_FOR_PI, SHIP_FOR_HIDDENDOCK, SHIP_FOR_GLUDIN, 
		SHIP_FOR_TI, TALKING_ISLAND_HOTEL, GLUDIO_HOTEL, SILVER_KNIGHT_HOTEL, WINDAWOOD_HOTEL, 
		HEINE_HOTEL, GIRAN_HOTEL, OREN_HOTEL, ADEN_HOTEL, PIRATE_HOTEL
	}

	public static Dungeon getInstance() {
		if (_instance == null) {
			_instance = new Dungeon();
		}
		return _instance;
	}

	private Dungeon() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = L1DatabaseFactory.getInstance().getConnection();

			pstm = con.prepareStatement("SELECT * FROM dungeon");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int srcMapId = rs.getInt("src_mapid");
				int srcX = rs.getInt("src_x");
				int srcY = rs.getInt("src_y");
				String key = new StringBuilder().append(srcMapId).append(srcX).append(srcY).toString();
				int newX = rs.getInt("new_x");
				int newY = rs.getInt("new_y");
				int newMapId = rs.getInt("new_mapid");
				int heading = rs.getInt("new_heading");
				DungeonType dungeonType = DungeonType.NONE;
				if ((((srcX == 33423) || (srcX == 33424) || (srcX == 33425) || 
						(srcX == 33426)) && (srcY == 33502) && (srcMapId == 4))// nClD->FIsD
						|| (((srcX == 32733) || (srcX == 32734) || (srcX == 32735) 
						|| (srcX == 32736)) && (srcY == 32794) && (srcMapId == 83))) {// FIsD->nClD
					dungeonType = DungeonType.SHIP_FOR_FI;
				}
				else if ((((srcX == 32935) || (srcX == 32936) || 
						(srcX == 32937)) && (srcY == 33058) && (srcMapId == 7))
						|| (((srcX == 32732) || (srcX == 32733) || (srcX == 32734) 
						|| (srcX == 32735)) && (srcY == 32796) && (srcMapId == 84))) {// nClsD->FID
					dungeonType = DungeonType.SHIP_FOR_HEINE;
				}
				else if ((((srcX == 32750) || (srcX == 32751) || (srcX == 32752)) && 
						(srcY == 32874) && (srcMapId == 445))
						|| (((srcX == 32731) || (srcX == 32732) || (srcX == 32733)) && 
						(srcY == 32796) && (srcMapId == 447))) {
					dungeonType = DungeonType.SHIP_FOR_PI;
				}
				else if ((((srcX == 32296) || (srcX == 32297) || (srcX == 32298)) && 
						(srcY == 33087) && (srcMapId == 440))
						|| (((srcX == 32735) || (srcX == 32736) || (srcX == 32737)) && 
						(srcY == 32794) && (srcMapId == 446))) {
					dungeonType = DungeonType.SHIP_FOR_HIDDENDOCK;
				}
				else if ((((srcX == 32630) || (srcX == 32631) || (srcX == 32632)) && 
						(srcY == 32983) && (srcMapId == 0)) // TalkingIsland->TalkingIslandShiptoAdenMainland
						|| (((srcX == 32733) || (srcX == 32734) || (srcX == 32735)) && 
						(srcY == 32796) && (srcMapId == 5))) { // TalkingIslandShiptoAdenMainland->TalkingIsland
					dungeonType = DungeonType.SHIP_FOR_GLUDIN;
				}
				else if ((((srcX == 32540) || (srcX == 32542) || (srcX == 32543) || 
						(srcX == 32544) || (srcX == 32545)) && (srcY == 32728) && (srcMapId == 4)) // AdenMainland->AdenMainlandShiptoTalkingIsland
						|| (((srcX == 32734) || (srcX == 32735) || (srcX == 32736) || 
						(srcX == 32737)) && (srcY == 32794) && (srcMapId == 6))) { // AdenMainlandShiptoTalkingIsland->AdenMainland
					dungeonType = DungeonType.SHIP_FOR_TI;
				}
				else if ((srcX == 32600) && (srcY == 32931) && (srcMapId == 0)) {
					dungeonType = DungeonType.TALKING_ISLAND_HOTEL;
				}
				else if ((srcX == 32632) && (srcY == 32761) && (srcMapId == 4)) {
					dungeonType = DungeonType.GLUDIO_HOTEL;
				}
				else if ((srcX == 33116) && (srcY == 33379) && (srcMapId == 4)) {
					dungeonType = DungeonType.SILVER_KNIGHT_HOTEL;
				}
				else if ((srcX == 32628) && (srcY == 33167) && (srcMapId == 4)) {
					dungeonType = DungeonType.WINDAWOOD_HOTEL;
				}
				else if ((srcX == 33605) && (srcY == 33275) && (srcMapId == 4)) {
					dungeonType = DungeonType.HEINE_HOTEL;
				}
				else if ((srcX == 33437) && (srcY == 32789) && (srcMapId == 4)) {
					dungeonType = DungeonType.GIRAN_HOTEL;
				}
				else if ((srcX == 34068) && (srcY == 32254) && (srcMapId == 4)) {
					dungeonType = DungeonType.OREN_HOTEL;
				}
				else if ((srcX == 33985) && (srcY == 33312) && (srcMapId == 4)) {
					dungeonType = DungeonType.ADEN_HOTEL;
				}
				else if ((srcX == 32745) && (srcY == 32803) && (srcMapId == 440)) {
					dungeonType = DungeonType.PIRATE_HOTEL;
				}
				
				NewDungeon newDungeon = new NewDungeon(newX, newY, (short) newMapId, heading, dungeonType);
				if (_dungeonMap.containsKey(key)) {
					_log.log(Level.WARNING, "Dungeon exists for the same key data. key=" + key);
				}
				_dungeonMap.put(key, newDungeon);
			}
		}
		catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private static class NewDungeon {
		int _newX;
		int _newY;
		short _newMapId;
		int _heading;

		DungeonType _dungeonType;

		private NewDungeon(int newX, int newY, short newMapId, int heading, DungeonType dungeonType) {
			_newX = newX;
			_newY = newY;
			_newMapId = newMapId;
			_heading = heading;
			_dungeonType = dungeonType;

		}
	}

	public boolean dg(int locX, int locY, int mapId, L1PcInstance pc) {
		int servertime = L1GameTimeClock.getInstance().currentTime().getSeconds();
		int nowtime = servertime % 86400;
		String key = new StringBuilder().append(mapId).append(locX).append(locY).toString();
		if (_dungeonMap.containsKey(key)) {
			NewDungeon newDungeon = _dungeonMap.get(key);
			short newMap = newDungeon._newMapId;
			int newX = newDungeon._newX;
			int newY = newDungeon._newY;
			int heading = newDungeon._heading;
			DungeonType dungeonType = newDungeon._dungeonType;
			boolean teleportable = false;

			if (dungeonType == DungeonType.NONE) {
				teleportable = true;
			} else {
				if (dungeonType == DungeonType.TALKING_ISLAND_HOTEL 
						|| dungeonType == DungeonType.GLUDIO_HOTEL
						|| dungeonType == DungeonType.WINDAWOOD_HOTEL 
						|| dungeonType == DungeonType.SILVER_KNIGHT_HOTEL
						|| dungeonType == DungeonType.HEINE_HOTEL 
						|| dungeonType == DungeonType.GIRAN_HOTEL
						|| dungeonType == DungeonType.OREN_HOTEL
						|| dungeonType == DungeonType.ADEN_HOTEL
						|| dungeonType == DungeonType.PIRATE_HOTEL) {
					int npcid = 0;
					int[] data = null;
					if (dungeonType == DungeonType.TALKING_ISLAND_HOTEL) {
						npcid = 70012;
						data = new int[] {32745, 32803, 16384, 32743, 32808, 16896};
					} else if (dungeonType == DungeonType.GLUDIO_HOTEL) {
						npcid = 70019;
						data = new int[] {32743, 32803, 17408, 32744, 32807, 17920};
					} else if (dungeonType == DungeonType.GIRAN_HOTEL) {
						npcid = 70031;
						data = new int[] {32744, 32803, 18432, 32744, 32807, 18944};
					} else if (dungeonType == DungeonType.OREN_HOTEL) {
						npcid = 70065;
						data = new int[] {32744, 32803, 19456, 32744, 32807, 19968};
					} else if (dungeonType == DungeonType.WINDAWOOD_HOTEL) {
						npcid = 70070;
						data = new int[] {32744, 32803, 20480, 32744, 32807, 20992};
					} else if (dungeonType == DungeonType.SILVER_KNIGHT_HOTEL) {
						npcid = 70075;
						data = new int[] {32744, 32803, 21504, 32744, 32807, 22016};
					} else if (dungeonType == DungeonType.HEINE_HOTEL) {
						npcid = 70084;
						data = new int[] {32744, 32803, 22528, 32744, 32807, 23040};
				    } else if (dungeonType == DungeonType.ADEN_HOTEL) {
					    npcid = 70054;
					    data = new int[] {32744, 32803, 24576, 32746, 32807, 24064};
			        } else if (dungeonType == DungeonType.PIRATE_HOTEL) {
				        npcid = 70096;
				        data = new int[] {32744, 32803, 23552, 32745, 32807, 25088};
			        }
					
					int type = checkInnKey(pc, npcid);

					if (type == 1) {
						newX = data[0];
						newY = data[1];
						newMap = (short) data[2];
						heading = 6;
						teleportable = true;
					} else if (type == 2) {
						newX = data[3];
						newY = data[4];
						newMap = (short) data[5];
						heading = 6;
						teleportable = true;
					}
			} else if (nowtime >= 15 * 360 && nowtime < 25 * 360 // 1.30~2.30
						|| nowtime >= 45 * 360 && nowtime < 55 * 360 // 4.30~5.30
						|| nowtime >= 75 * 360 && nowtime < 85 * 360 // 7.30~8.30
						|| nowtime >= 105 * 360 && nowtime < 115 * 360 // 10.30~11.30
						|| nowtime >= 135 * 360 && nowtime < 145 * 360
						|| nowtime >= 165 * 360 && nowtime < 175 * 360
						|| nowtime >= 195 * 360 && nowtime < 205 * 360
						|| nowtime >= 225 * 360 && nowtime < 235  * 360) {
					if ((pc.getInventory().checkItem(40299, 1)
							&& dungeonType == DungeonType.SHIP_FOR_GLUDIN) // TalkingIslandShiptoAdenMainland
							|| (pc.getInventory().checkItem(40301, 1)
							&& dungeonType == DungeonType.SHIP_FOR_HEINE) // AdenMainlandShiptoForgottenIsland
							|| (pc.getInventory().checkItem(40302, 1)
							&& dungeonType == DungeonType.SHIP_FOR_PI)) { // ShipPirateislandtoHiddendock
						teleportable = true;
					}
				} else if ( nowtime >= 0  && nowtime < 360
						|| nowtime >= 30 * 360 && nowtime < 40 * 360
						|| nowtime >= 60 * 360 && nowtime < 70 * 360
						|| nowtime >= 90 * 360 && nowtime < 100 * 360
						|| nowtime >= 120 * 360 && nowtime < 130 * 360
						|| nowtime >= 150 * 360 && nowtime < 160 * 360
						|| nowtime >= 180 * 360 && nowtime < 190 * 360
						|| nowtime >= 210 * 360 && nowtime < 220 * 360) {
					if ((pc.getInventory().checkItem(40298, 1)
							&& dungeonType == DungeonType.SHIP_FOR_TI) // AdenMainlandShiptoTalkingIsland
							|| (pc.getInventory().checkItem(40300, 1)
							&& dungeonType == DungeonType.SHIP_FOR_FI) // ForgottenIslandShiptoAdenMainland
							|| (pc.getInventory().checkItem(40303, 1)
							&& dungeonType == DungeonType.SHIP_FOR_HIDDENDOCK)) { // ShipHiddendocktoPirateisland
						teleportable = true;
				    }
				}
			}
			if (teleportable) {
				// 2 seconds of invincibility
				pc.setSkillEffect(L1SkillId.ABSOLUTE_BARRIER, 2000);
				pc.stopHpRegeneration();
				pc.stopMpRegeneration();
				pc.stopMpRegenerationByDoll();
				L1Teleport.teleport(pc, newX, newY, newMap, heading, false);
				return true;
			}
		}
		return false;
	}

	private int checkInnKey(L1PcInstance pc, int npcid) {
		for (L1ItemInstance item : pc.getInventory().getItems()) {
			if (item.getInnNpcId() == npcid) {
				for (int i = 0; i < 16; i++) {
					L1Inn inn = InnTable.getInstance().getTemplate(npcid, i);
					if (inn.getKeyId() == item.getKeyId()) {
						Timestamp dueTime = item.getDueTime();
						if (dueTime != null) {
							Calendar cal = Calendar.getInstance();
							if (((cal.getTimeInMillis() - dueTime.getTime()) / 1000) < 0) {
								pc.setInnKeyId(item.getKeyId());
								return item.checkRoomOrHall()? 2 : 1;
							}
						}
					}
				}
			}
		}
		return 0;
	}
}