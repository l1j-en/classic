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

import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.model:
// L1DeleteItemOnGround

/*
 * Tricid edit to change behavior to tagging items first, then deleting tagged items on next check.
 * The way its meant to work is:  
 * 
 * First check any stored/checked items for their continued existence, and 
 * delete them if so, or remove them from the checkeditems collection otherwise (we dont want this
 * to be a source of memory leaks). (This will be empty on the first run, obviously)
 * 
 * Second check all existing ground items that it used to delete, and add them to the checkeditems collection instead.
 * 
 * Fix for issue: https://github.com/l1j/en/issues/119
 */
public class L1DeleteItemOnGround {
	private DeleteTimer _deleteTimer;
	private HashSet<L1Object> checkeditems = new HashSet<L1Object>();
	private static final Logger _log = Logger
			.getLogger(L1DeleteItemOnGround.class.getName());

	public L1DeleteItemOnGround() {
	}

	private class DeleteTimer implements Runnable {
		public DeleteTimer() {
		}

		@Override
		public void run() {
			int time = Config.ALT_ITEM_DELETION_TIME * 60 * 1000 - 10 * 1000;
			for (;;) {
				try {
					Thread.sleep(time);
				} catch (Exception exception) {
					_log.warning("L1DeleteItemOnGround error: " + exception);
					break;
				}
//				L1World.getInstance().broadcastPacketToAll(
//						new S_ServerMessage(166, "Item on the world map ",
//								" will be removed in 10 seconds."));
								
				try {
					Thread.sleep(10000);
				} catch (Exception exception) {
					_log.warning("L1DeleteItemOnGround error: " + exception);
					break;
				}
				deleteItem();
//				L1World.getInstance().broadcastPacketToAll(
//						new S_ServerMessage(166, "Item on the world map ", " will be removed in 10 seconds.")); 
//				
			}
		}
	}

	public void initialize() {
		if (!Config.ALT_ITEM_DELETION_TYPE.equalsIgnoreCase("auto")) {
			return;
		}

		_deleteTimer = new DeleteTimer();
		GeneralThreadPool.getInstance().execute(_deleteTimer); // start timer
	}

	private void deleteItem() {
		int numOfDeleted = 0;
		
		//compare stored items to world items
		for (L1Object previouslycheckeditem : checkeditems) {
		
			//see if item is still laying around the world
			if (L1World.getInstance().getObject().contains(previouslycheckeditem)) {
				
				if (!(previouslycheckeditem instanceof L1ItemInstance)) {
					checkeditems.remove(previouslycheckeditem);
					continue;
				}

				L1ItemInstance item = (L1ItemInstance) previouslycheckeditem;
				
				//break this iteration if any of the following happen
				
				// Items on the ground, rather than someone else's property
				// remove item from checked list
				if (item.getX() == 0 && item.getY() == 0) { 
					checkeditems.remove(item);
					continue;
				}
				// Spirit's rock
				//remove item from checked list
				if (item.getItem().getItemId() == 40515) { 
					checkeditems.remove(item);
					continue;
				}
				// Hideout in
				//remove item from checked list
				if (L1HouseLocation.isInHouse(item.getX(), item.getY(), item
						.getMapId())) { 
					checkeditems.remove(item);
					continue;
				}
				
				//grab the players and make sure the item isn't visible to anyone
				List<L1PcInstance> players = L1World.getInstance()
						.getVisiblePlayer(item, Config.ALT_ITEM_DELETION_RANGE);
				
				if (players.isEmpty()) { // 
					L1Inventory groundInventory = L1World
							.getInstance()
							.getInventory(item.getX(), item.getY(), item.getMapId());
					groundInventory.removeItem(item);
					checkeditems.remove(item);
					numOfDeleted++;
				}
			}
			//sleep a tiny amount each iteration just to make sure this thread doesn't
			//hog too much cpu power when ran
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		for (L1Object obj : L1World.getInstance().getObject()) {
			if (!(obj instanceof L1ItemInstance)) {
				continue;
			}

			L1ItemInstance item = (L1ItemInstance) obj;
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
					.getVisiblePlayer(item, Config.ALT_ITEM_DELETION_RANGE);
			if (players.isEmpty()) { // 
				checkeditems.add(item);
			}
			//sleep a tiny amount each iteration just to make sure this thread doesn't
			//hog too much cpu power when ran
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		_log.fine("Deleted ground items: " + numOfDeleted);
		//temporary output to test this
		_log.fine("Checked items size: " + checkeditems.size());

	}
}
