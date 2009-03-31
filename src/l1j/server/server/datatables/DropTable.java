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

package l1j.server.server.datatables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Drop;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server.templates:
// L1Npc, L1Item, ItemTable

public class DropTable {

	private static Logger _log = Logger.getLogger(DropTable.class.getName());

	private static DropTable _instance;

	private final HashMap<Integer, ArrayList<L1Drop>> _droplists;

	public static DropTable getInstance() {
		if (_instance == null) {
			_instance = new DropTable();
		}
		return _instance;
	}

	private static Map<Integer, String> _questDrops;

	public static final int CLASSID_KNIGHT_MALE = 61;
	public static final int CLASSID_KNIGHT_FEMALE = 48;
	public static final int CLASSID_ELF_MALE = 138;
	public static final int CLASSID_ELF_FEMALE = 37;
	public static final int CLASSID_WIZARD_MALE = 734;
	public static final int CLASSID_WIZARD_FEMALE = 1186;
	public static final int CLASSID_DARK_ELF_MALE = 2786;
	public static final int CLASSID_DARK_ELF_FEMALE = 2796;
	public static final int CLASSID_PRINCE = 0;
	public static final int CLASSID_PRINCESS = 1;

	private DropTable() {
		_droplists = allDropList();
		_questDrops = questDrops();
	}

	private Map<Integer, String> questDrops() {
		Map<Integer, String> questDropsMap = new HashMap<Integer, String>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("select * from quest_drops");
			rs = pstm.executeQuery();
			while (rs.next()) {
				questDropsMap.put(rs.getInt("item_id"), rs.getString("class"));
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return questDropsMap;
	}

	private String classCode(L1PcInstance pc) {
		int i = pc.getClassId();
		if(i == CLASSID_KNIGHT_MALE || i == CLASSID_KNIGHT_FEMALE) {
			return "K";
		} else if(i == CLASSID_ELF_MALE || i == CLASSID_ELF_FEMALE) {
			return "E";
		} else if(i == CLASSID_WIZARD_MALE || i == CLASSID_WIZARD_FEMALE) {
			return "W";
		} else if(i == CLASSID_DARK_ELF_MALE || i == CLASSID_DARK_ELF_FEMALE) {
			return "D";
		} else if(i == CLASSID_PRINCE || i == CLASSID_PRINCESS) {
			return "P";
		} else {
			return null;
		}
	}

	private HashMap<Integer, ArrayList<L1Drop>> allDropList() {
		HashMap<Integer, ArrayList<L1Drop>> droplistMap = new HashMap<Integer, ArrayList<L1Drop>>();

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("select * from droplist");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int mobId = rs.getInt("mobId");
				int itemId = rs.getInt("itemId");
				int min = rs.getInt("min");
				int max = rs.getInt("max");
				int chance = rs.getInt("chance");

				L1Drop drop = new L1Drop(mobId, itemId, min, max, chance);

				ArrayList<L1Drop> dropList = droplistMap.get(drop.getMobid());
				if (dropList == null) {
					dropList = new ArrayList<L1Drop>();
					droplistMap.put(new Integer(drop.getMobid()), dropList);
				}
				dropList.add(drop);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return droplistMap;
	}

	public void setDrop(L1NpcInstance npc, L1Inventory inventory) {
		int mobId = npc.getNpcTemplate().get_npcId();
		ArrayList<L1Drop> dropList = _droplists.get(mobId);
		if (dropList == null) {
			return;
		}

		double droprate = Config.RATE_DROP_ITEMS;
		if (droprate <= 0) {
			droprate = 0;
		}
		double adenarate = Config.RATE_DROP_ADENA;
		if (adenarate <= 0) {
			adenarate = 0;
		}
		if (droprate <= 0 && adenarate <= 0) {
			return;
		}

		int itemId;
		int itemCount;
		int addCount;
		int randomChance;
		L1ItemInstance item;
		Random random = new Random();

		for (L1Drop drop : dropList) {
			itemId = drop.getItemid();
			if (adenarate == 0 && itemId == L1ItemId.ADENA) {
				continue;
			}

			randomChance = random.nextInt(0xf4240) + 1;
			double rateOfMapId = MapsTable.getInstance().getDropRate(
					npc.getMapId());
			double rateOfItem = DropItemTable.getInstance().getDropRate(itemId);
			if (droprate == 0
					|| drop.getChance() * droprate * rateOfMapId * rateOfItem < randomChance) {
				continue;
			}
		
			// Changed to prevent adena rates of >1 to always result in even numbers
			double amount = DropItemTable.getInstance().getDropAmount(itemId);
			int min;
			int max;
			if(itemId == L1ItemId.ADENA) {
				min = (int)(drop.getMin() * amount * adenarate);
				max = (int)(drop.getMax() * amount * adenarate);
			} else {
				min = (int)(drop.getMin() * amount);
				max = (int)(drop.getMax() * amount);
			}

			itemCount = min;
			addCount = max - min + 1;
			if (addCount > 1) {
				itemCount += random.nextInt(addCount);
			}
			// intentionally removed
			//if (itemId == L1ItemId.ADENA) { // 
			//	itemCount *= adenarate;
			//}
			if (itemCount < 0) {
				itemCount = 0;
			}
			if (itemCount > 2000000000) {
				itemCount = 2000000000;
			}

			item = ItemTable.getInstance().createItem(itemId);
			item.setCount(itemCount);

			inventory.storeItem(item);
		}
	}

	public void dropShare(L1NpcInstance npc, ArrayList<L1Character> acquisitorList, 
			ArrayList<Integer> hateList) {
		L1Inventory inventory = npc.getInventory();
		if (inventory.getSize() == 0) {
			return;
		}
		if (acquisitorList.size() != hateList.size()) {
			return;
		}
		int totalHate = 0;
		L1Character acquisitor;
		for (int i = hateList.size() - 1; i >= 0; i--) {
			acquisitor = (L1Character) acquisitorList.get(i);
			if ((Config.AUTO_LOOT == 2) 
					&& (acquisitor instanceof L1SummonInstance || acquisitor instanceof L1PetInstance)) {
				acquisitorList.remove(i);
				hateList.remove(i);
			} else if (acquisitor != null
					&& !acquisitor.isDead() // added
					&& acquisitor.getMapId() == npc.getMapId()
					&& acquisitor.getLocation().getTileLineDistance(
							npc.getLocation()) <= Config.LOOTING_RANGE) {
				totalHate += (Integer) hateList.get(i);
			} else {
				acquisitorList.remove(i);
				hateList.remove(i);
			}
		}

		L1ItemInstance item;
		L1Inventory targetInventory = null;
		L1PcInstance player;
		L1PcInstance[] partyMember;
		Random random = new Random();
		int randomInt;
		int chanceHate;
		for (int i = inventory.getSize(); i > 0; i--) {
			item = inventory.getItems().get(0);
			if (item.getItem().getType2() == 0 && item.getItem().getType() == 2) { // 
				item.setNowLighting(false);
			}
			item.setIdentified(false); // changed
			if (((Config.AUTO_LOOT != 0) || item.getItem().getItemId() == L1ItemId.ADENA)
					&& totalHate > 0) {
				randomInt = random.nextInt(totalHate);
				chanceHate = 0;
				for (int j = hateList.size() - 1; j >= 0; j--) {
					chanceHate += (Integer) hateList.get(j);
					if (chanceHate > randomInt) {
						acquisitor = (L1Character) acquisitorList.get(j);
						if (acquisitor.getInventory().checkAddItem(item,
								item.getCount()) == L1Inventory.OK) {
							targetInventory = acquisitor.getInventory();
							if (acquisitor instanceof L1PcInstance) {
								player = (L1PcInstance) acquisitor;
								// added to exclude quest drops from invalid classes
								if(_questDrops.containsKey(item.getItemId())) {
									if(!classCode(player).equals(_questDrops.get(item.getItemId()))) {
										inventory.deleteItem(item);
										break;
									}
								}
								L1ItemInstance l1iteminstance = player
										.getInventory().findItemId(
												L1ItemId.ADENA);
								if (l1iteminstance != null
										&& l1iteminstance.getCount() > 2000000000) {
									targetInventory = L1World.getInstance()
											.getInventory(acquisitor.getX(),
													acquisitor.getY(),
													acquisitor.getMapId());
									player.sendPackets(new S_SystemMessage("The limit of the itemcount is 2000000000"));
								} else {
									if (player.isInParty()) {
										partyMember = player.getParty()
												.getMembers();
										for (int p = 0; p < partyMember.length; p++) {
											partyMember[p]
													.sendPackets(new S_ServerMessage(
															813, npc.getName(),
															item.getLogName(),
															player.getName()));
										}
									} else {
										
										player.sendPackets(new S_ServerMessage(
												143, npc.getName(), item
														.getLogName()));
									}
								}
							}
						} else {
							targetInventory = L1World.getInstance()
									.getInventory(acquisitor.getX(),
											acquisitor.getY(),
											acquisitor.getMapId());
						}
						break;
					}
				}
			} else {
				List<Integer> dirList = new ArrayList<Integer>();
				for (int j = 0; j < 8; j++) {
					dirList.add(j);
				}
				int x = 0;
				int y = 0;
				int dir = 0;
				do {
					if (dirList.size() == 0) {
						x = 0;
						y = 0;
						break;
					}
					randomInt = random.nextInt(dirList.size());
					dir = dirList.get(randomInt);
					dirList.remove(randomInt);
					switch (dir) {
					case 0:
						x = 0;
						y = -1;
						break;
					case 1:
						x = 1;
						y = -1;
						break;
					case 2:
						x = 1;
						y = 0;
						break;
					case 3:
						x = 1;
						y = 1;
						break;
					case 4:
						x = 0;
						y = 1;
						break;
					case 5:
						x = -1;
						y = 1;
						break;
					case 6:
						x = -1;
						y = 0;
						break;
					case 7:
						x = -1;
						y = -1;
						break;
					}
				} while (!npc.getMap().isPassable(npc.getX(), npc.getY(), dir));
				targetInventory = L1World.getInstance().getInventory(
						npc.getX() + x, npc.getY() + y, npc.getMapId());
			}
			if(item != null){
				inventory.tradeItem(item, item.getCount(), targetInventory);
			}
			npc.turnOnOffLight();
		}
	}

	public ArrayList<L1Drop> getDrops(int mobID) {//New for GMCommands
		return _droplists.get(mobID);
	}
}
