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

import java.util.List;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.FurnitureSpawnTable;
import l1j.server.server.datatables.LetterTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.model.Instance.L1FurnitureInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
//import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.model:
// L1DeleteItemOnGround

public class L1DeleteItemOnGround {
	private DeleteTimer _deleteTimer;
	private int _time = 0;
	private int _range = 0;

	private static final Logger _log = Logger
			.getLogger(L1DeleteItemOnGround.class.getName());

	public L1DeleteItemOnGround() {
	}

	class DeleteTimer implements Runnable {
		public DeleteTimer() {
		}

		@Override
		public void run() {
			for (;;) {
				try {
					Thread.sleep(_time);
				} catch (Exception exception) {
					_log.warning("L1DeleteItemOnGround error: " + exception);
					break;
				}
				/*L1World.getInstance().broadcastPacketToAll(
						new S_ServerMessage(166, "Item on the world map ",
								" will be removed in 10 seconds."));
								*/
				try {
					Thread.sleep(10000);
				} catch (Exception exception) {
					_log.warning("L1DeleteItemOnGround error: " + exception);
					break;
				}
				deleteItem();
				/* L1World.getInstance().broadcastPacketToAll(
						new S_ServerMessage(166, "Item on the world map ", " will be removed in 10 seconds.")); 
				// %2
				 *
				 */
			}
		}
	}

	public void onAction() {
		_range = Config.ALT_ITEM_DELETION_RANGE;
		if (_range > 5 && _range < 0) {
			_range = 0;
		}

		if (Config.ALT_ITEM_DELETION_TIME > 0
				&& Config.ALT_ITEM_DELETION_TIME <= 35791) {
			_time = Config.ALT_ITEM_DELETION_TIME * 60 * 1000 - 10 * 1000;
			_deleteTimer = new DeleteTimer();
			GeneralThreadPool.getInstance().execute(_deleteTimer); // Start timer
		}
	}

	private void deleteItem() {
		for (L1Object l1object : L1World.getInstance().getObject()) {
			if (l1object instanceof L1ItemInstance) {
				L1ItemInstance item = (L1ItemInstance) l1object;
				if (item.getX() == 0 && item.getY() == 0) { // Items on the ground, rather than someone else's property
					continue;
				}
				if (item.getItem().getItemId() == 40515) { // Spirit's rock
					continue;
				}
				if (L1HouseLocation.isInHouse(item.getX(), item.getY(), item
						.getMapId())) { // Hideout in
					continue;
				}

				List<L1PcInstance> players = L1World.getInstance()
						.getVisiblePlayer(item, _range);
				if (0 == players.size()) {
					L1Inventory groundInventory = L1World.getInstance()
							.getInventory(item.getX(), item.getY(),
									item.getMapId());
					int itemId = item.getItem().getItemId();
					if (itemId == 40314 || itemId == 40316) { // Amulet pets
						PetTable.getInstance().deletePet(item.getId());
					} else if (itemId >= 49016 && itemId <= 49025) { // Stationery
						LetterTable lettertable = new LetterTable();
						lettertable.deleteLetter(item.getId());
					} else if (itemId >= 41383 && itemId <= 41400) { // Furniture
						if (l1object instanceof L1FurnitureInstance) {
							L1FurnitureInstance furniture =
									(L1FurnitureInstance) l1object;
							if (furniture.getItemObjId() == item.getId()) { //
								FurnitureSpawnTable.getInstance()
										.deleteFurniture(furniture);
							}
						}
					}
					groundInventory.deleteItem(item);
				}
			}
		}
	}
}
