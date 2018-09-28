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
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger _log = LoggerFactory			.getLogger(L1DeleteItemOnGround.class.getName());

	public L1DeleteItemOnGround() {
	}

	private class DeleteTimer implements Runnable {
		public DeleteTimer() {
		}

		@Override
		public void run() {
			try {
				Thread.currentThread().setName("L1DeleteItemOnGround");
				int time = Config.ALT_ITEM_DELETION_TIME * 60 * 1000 - 10 * 1000;
				for (;;) {
					try {
						Thread.sleep(time);
					} catch (Exception exception) {
						_log.warn("L1DeleteItemOnGround error: " + exception);
						break;
					}
					// L1World.getInstance().broadcastPacketToAll(
					// new S_ServerMessage(166, "Item on the world map ",
					// " will be removed in 10 seconds."));

					try {
						Thread.sleep(10000);
					} catch (Exception exception) {
						_log.warn("L1DeleteItemOnGround error: " + exception);
						break;
					}
					deleteItem();
					// L1World.getInstance().broadcastPacketToAll(
					// new S_ServerMessage(166, "Item on the world map ",
					// " will be removed in 10 seconds."));
					//
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("",e);
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

		// compare stored items to world itemss
		for (Iterator<L1Object> iterator = checkeditems.iterator(); iterator.hasNext(); ) {
		//for (L1Object previouslycheckeditem : checkeditems) {
			L1Object previouslycheckeditem = iterator.next();
			// see if item is still laying around the world
			if (L1World.getInstance().getObject()
					.contains(previouslycheckeditem)) {

				L1ItemInstance item = (L1ItemInstance) previouslycheckeditem;

				// break this iteration if any of the following happen

				// Items on the ground, rather than someone else's property
				// remove item from checked list
				if (item.getX() == 0 && item.getY() == 0) {
					//checkeditems.remove(item);
					iterator.remove();
					continue;
				}

				// Hideout in
				// remove item from checked list
				if (L1HouseLocation.isInHouse(item.getX(), item.getY(),
						item.getMapId())) {
					//checkeditems.remove(item);
					iterator.remove();
					continue;
				}

				// check if item is still even in the world, if not, remove from
				// checkeditems
				// the first check above might already cover this case, but just
				// in case...
				if (L1World.getInstance().getInventory(item.getX(),
						item.getY(), item.getMapId()) == null) {
					//checkeditems.remove(item);
					iterator.remove();
					continue;

				}
				// grab the players and make sure the item isn't visible to
				// anyone
				List<L1PcInstance> players = L1World.getInstance()
						.getVisiblePlayer(item, Config.ALT_ITEM_DELETION_RANGE);

				if (players.isEmpty()) { //
					L1Inventory groundInventory = L1World.getInstance()
							.getInventory(item.getX(), item.getY(),
									item.getMapId());
					try {
					groundInventory.removeItem(item);
					//checkeditems.remove(item);
					iterator.remove();
					numOfDeleted++;
					} catch (Exception e) {
						_log.info("Ground delete prob :" + e);
					}

				}
			}
			// sleep a tiny amount each iteration just to make sure this thread
			// doesn't
			// hog too much cpu power when ran
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				_log.error("",e);
			}

		}

		for (L1Object obj : L1World.getInstance().getObject()) {
			if (!(obj instanceof L1ItemInstance)) {
				continue;
			}

			L1ItemInstance item = (L1ItemInstance) obj;
			if (item.getX() == 0 && item.getY() == 0) { // Items on the ground,
														// rather than someone
														// else's property
				continue;
			}
			if (item.getItem().getItemId() == 40515) { // Spirit's rock
				continue;
			}
			if (L1HouseLocation.isInHouse(item.getX(), item.getY(),
					item.getMapId())) { // Hideout in
				continue;
			}

			List<L1PcInstance> players = L1World.getInstance()
					.getVisiblePlayer(item, Config.ALT_ITEM_DELETION_RANGE);
			if (players.isEmpty()) { //
				checkeditems.add(item);
			}
			// sleep a tiny amount each iteration just to make sure this thread
			// doesn't
			// hog too much cpu power when ran
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				_log.error("",e);
			}
		}
		_log.trace("Deleted ground items: " + numOfDeleted);
		// temporary output to test this
		_log.trace("Checked items size: " + checkeditems.size());

	}
}
