/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import l1j.server.Config;
import l1j.server.server.datatables.FurnitureSpawnTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.LetterTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.Instance.L1FurnitureInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.templates.L1Item;

public class L1Inventory extends L1Object {
	private static final long serialVersionUID = 1L;
	protected List<L1ItemInstance> _items = new CopyOnWriteArrayList<L1ItemInstance>();
	public static final int MAX_AMOUNT = 2000000000; // 2G
	public static final int MAX_WEIGHT = 1500;
	public static final int OK = 0;
	public static final int SIZE_OVER = 1;
	public static final int WEIGHT_OVER = 2;
	public static final int AMOUNT_OVER = 3;
	public static final int WAREHOUSE_TYPE_PERSONAL = 0;
	public static final int WAREHOUSE_TYPE_CLAN = 1;

	public L1Inventory() {
	}

	public int getSize() {
		return _items.size();
	}

	public List<L1ItemInstance> getItems() {
		return _items;
	}

	public int getWeight() {
		int weight = 0;
		for (L1ItemInstance item : _items) {
			weight += item.getWeight();
		}
		return weight;
	}

	public int checkAddItem(L1ItemInstance item, int count) {
		if (item == null) {
			return -1;
		}
		if (item.getCount() <= 0 || count <= 0) {
			return -1;
		}
		if (getSize() > Config.MAX_NPC_ITEM
				|| (getSize() == Config.MAX_NPC_ITEM && (!item.isStackable() || !checkItem(item
						.getItem().getItemId())))) {
			return SIZE_OVER;
		}
		int weight = getWeight() + item.getItem().getWeight() * count / 1000
				+ 1;
		if (weight < 0 || (item.getItem().getWeight() * count / 1000) < 0) {
			return WEIGHT_OVER;
		}
		if (weight > (MAX_WEIGHT * Config.RATE_WEIGHT_LIMIT_PET)) {
			return WEIGHT_OVER;
		}
		L1ItemInstance itemExist = findItemId(item.getItemId());
		if (itemExist != null && (itemExist.getCount() + count) > MAX_AMOUNT) {
			return AMOUNT_OVER;
		}
		return OK;
	}

	public int checkAddItemToWarehouse(L1ItemInstance item, int count, int type) {
		if (item == null) {
			return -1;
		}
		if (item.getCount() <= 0 || count <= 0) {
			return -1;
		}
		int maxSize = 100;
		if (type == WAREHOUSE_TYPE_PERSONAL) {
			maxSize = Config.MAX_PERSONAL_WAREHOUSE_ITEM;
		} else if (type == WAREHOUSE_TYPE_CLAN) {
			maxSize = Config.MAX_CLAN_WAREHOUSE_ITEM;
		}
		if (getSize() > maxSize
				|| (getSize() == maxSize && (!item.isStackable() || !checkItem(item
						.getItem().getItemId())))) { //
			return SIZE_OVER;
		}
		return OK;
	}

	public synchronized L1ItemInstance storeItem(int id, int count) {
		if (count <= 0) {
			return null;
		}
		L1Item temp = ItemTable.getInstance().getTemplate(id);
		if (temp == null) {
			return null;
		}

		if (temp.isStackable()) {
			L1ItemInstance item = new L1ItemInstance(temp, count);
			if (findItemId(id) == null) {
				item.setId(IdFactory.getInstance().nextId());
				L1World.getInstance().storeObject(item);
			}
			return storeItem(item);
		}
		L1ItemInstance result = null;
		for (int i = 0; i < count; i++) {
			L1ItemInstance item = new L1ItemInstance(temp, 1);
			item.setId(IdFactory.getInstance().nextId());
			L1World.getInstance().storeObject(item);
			storeItem(item);
			result = item;
		}
		return result;
	}

	public synchronized L1ItemInstance storeItem(L1ItemInstance item) {
		if (item.getCount() <= 0) {
			return null;
		}
		int itemId = item.getItem().getItemId();
		if (item.isStackable()) {
			L1ItemInstance findItem = findItemId(itemId);
			if (findItem != null) {
				findItem.setCount(findItem.getCount() + item.getCount());
				updateItem(findItem);
				return findItem;
			}
		}
		item.setX(getX());
		item.setY(getY());
		item.setMap(getMapId());
		int chargeCount = item.getItem().getMaxChargeCount();
		if (itemId == 40006 || itemId == 40007 || itemId == 40008
				|| itemId == 140006 || itemId == 140008 || itemId == 41401) {
			Random random = new Random();
			chargeCount -= random.nextInt(5);
		}
		if (itemId == 20383) {
			chargeCount = 50;
		}
		item.setChargeCount(chargeCount);
		if (item.getItem().getType2() == 0 && item.getItem().getType() == 2) {
			item.setRemainingTime(item.getItem().getLightFuel());
		} else {
			item.setRemainingTime(item.getItem().getMaxUseTime());
		}
		item.setBless(item.getItem().getBless());

		addSorted(item);
		insertItem(item);
		return item;
	}

	private synchronized L1ItemInstance storeTradeItem(L1ItemInstance item) {
		if (item.isStackable()) {
			L1ItemInstance findItem = findItemId(item.getItem().getItemId());
			if (findItem != null) {
				findItem.setCount(findItem.getCount() + item.getCount());
				updateItem(findItem);
				// TODO: test me!
				L1World.getInstance().removeObject(item);
				return findItem;
			}
		}
		item.setX(getX());
		item.setY(getY());
		item.setMap(getMapId());

		addSorted(item);
		insertItem(item);
		return item;
	}
	
	private void addSorted(L1ItemInstance item) {
		final int insertAt;
	    final int index = Collections.binarySearch(_items, item);
	    if (index < 0) {
	      insertAt = -(index + 1);
	    } else {
	      insertAt = index + 1;
	    }
	    _items.add(insertAt, item);
	}

	public boolean consumeItem(int itemid, int count) {
		if (count <= 0) {
			return false;
		}
		
		//If stackable- they are not enchantable
		if (ItemTable.getInstance().getTemplate(itemid).isStackable()) {
			L1ItemInstance item = findItemId(itemid);
			if (item != null && item.getCount() >= count) {
				removeItem(item, count);
				return true;
			}
		} else {
			//First count the items that are unenchanted to see if there are enough
			List<L1ItemInstance> itemList = findItemsId(itemid);
			int listSize = itemList.size();
			int totalUnenchantedItems = 0;
			for (int i = 0; i < listSize; i++) {
				if (itemList.get(i).getEnchantLevel() == 0) {
					totalUnenchantedItems++;
				}
			}
			//If there are enough, walk through the list and remove them.
			if (totalUnenchantedItems >= count) {
				for (int i = 0; i < listSize; i++) {
					if (itemList.get(i).getEnchantLevel() == 0) {
						removeItem(itemList.get(i), 1);
					}
				}
			return true;
			}
		}
		//Catchall false
		return false;
	}

	private class EnchantComparator implements Comparator<L1ItemInstance> {
		public int compare(L1ItemInstance first, L1ItemInstance second) {
			return first.getEnchantLevel() - second.getEnchantLevel();
		}
	}

	public int removeItem(int objectId, int count) {
		L1ItemInstance item = getItem(objectId);
		return removeItem(item, count);
	}

	public int removeItem(L1ItemInstance item) {
		return removeItem(item, item.getCount());
	}

	public int removeItem(L1ItemInstance item, int count) {
		if (item == null) {
			return 0;
		}
		if (item.getCount() <= 0 || count <= 0) {
			return 0;
		}
		if (item.getCount() < count) {
			count = item.getCount();
		}
		if (item.getCount() == count) {
			int itemId = item.getItem().getItemId();
			if (itemId == 40314 || itemId == 40316) {
				PetTable.getInstance().deletePet(item.getId());
			} else if (itemId >= 49016 && itemId <= 49025) {
				LetterTable lettertable = new LetterTable();
				lettertable.deleteLetter(item.getId());
			} else if (itemId >= 41383 && itemId <= 41400) {
				for (L1Object l1object : L1World.getInstance().getObject()) {
					if (l1object instanceof L1FurnitureInstance) {
						L1FurnitureInstance furniture = (L1FurnitureInstance) l1object;
						if (furniture.getItemObjId() == item.getId()) {
							FurnitureSpawnTable.getInstance().deleteFurniture(
									furniture);
						}
					}
				}
			}
			deleteItem(item);
			L1World.getInstance().removeObject(item);
		} else {
			item.setCount(item.getCount() - count);
			updateItem(item);
		}
		return count;
	}

	public void deleteItem(L1ItemInstance item) {
		_items.remove(item);
	}

	public synchronized L1ItemInstance tradeItem(int objectId, int count,
			L1Inventory inventory) {
		L1ItemInstance item = getItem(objectId);
		return tradeItem(item, count, inventory);
	}

	public synchronized L1ItemInstance tradeItem(L1ItemInstance item,
			int count, L1Inventory inventory) {
		if (item == null) {
			return null;
		}
		if (item.getCount() <= 0 || count <= 0) {
			return null;
		}
		if (item.isEquipped()) {
			return null;
		}
		if (!checkItem(item.getItem().getItemId(), count)) {
			return null;
		}
		L1ItemInstance carryItem;
		if (item.getCount() <= count) {
			deleteItem(item);
			carryItem = item;
		} else {
			item.setCount(item.getCount() - count);
			updateItem(item);
			carryItem = ItemTable.getInstance().createItem(
					item.getItem().getItemId());
			carryItem.setCount(count);
			carryItem.setEnchantLevel(item.getEnchantLevel());
			carryItem.setIdentified(item.isIdentified());
			carryItem.set_durability(item.get_durability());
			carryItem.setChargeCount(item.getChargeCount());
			carryItem.setRemainingTime(item.getRemainingTime());
			carryItem.setLastUsed(item.getLastUsed());
			carryItem.setBless(item.getBless());
		}
		return inventory.storeTradeItem(carryItem);
	}

	public L1ItemInstance receiveDamage(int objectId) {
		L1ItemInstance item = getItem(objectId);
		return receiveDamage(item);
	}

	public L1ItemInstance receiveDamage(L1ItemInstance item) {
		return receiveDamage(item, 1);
	}

	public L1ItemInstance receiveDamage(L1ItemInstance item, int count) {

		if (item == null) {
			return null;
		}

		int itemType = item.getItem().getType2();
		int currentDurability = item.get_durability();

		if ((currentDurability == 0 && itemType == 0) || currentDurability < 0) {
			item.set_durability(0);
			return null;
		}

		if (itemType == 0) {
			int minDurability = (item.getEnchantLevel() + 5) * -1;
			int durability = currentDurability - count;
			if (durability < minDurability) {
				durability = minDurability;
			}
			if (currentDurability > durability) {
				item.set_durability(durability);
			}
		} else {
			int maxDurability = item.getEnchantLevel() + 5;
			int durability = currentDurability + count;
			if (durability > maxDurability) {
				durability = maxDurability;
			}
			if (currentDurability < durability) {
				item.set_durability(durability);
			}
		}
		updateItem(item, L1PcInventory.COL_DURABILITY);
		return item;
	}

	public L1ItemInstance recoveryDamage(L1ItemInstance item) {

		if (item == null) {
			return null;
		}

		int itemType = item.getItem().getType2();
		int durability = item.get_durability();

		if ((durability == 0 && itemType != 0) || durability < 0) {
			item.set_durability(0);
			return null;
		}

		if (itemType == 0) {
			item.set_durability(durability + 1);
		} else {
			item.set_durability(durability - 1);
		}
		updateItem(item, L1PcInventory.COL_DURABILITY);
		return item;
	}

	public L1ItemInstance findItemId(int id) {
		for (L1ItemInstance item : _items) {
			if (item.getItem().getItemId() == id) {
				return item;
			}
		}
		return null;
	}

	public List<L1ItemInstance> findItemsId(int id) {
		List<L1ItemInstance> itemList = new ArrayList<L1ItemInstance>();
		for (L1ItemInstance item : _items) {
			if (item.getItemId() == id) {
				itemList.add(item);
			}
		}
		return itemList;
	}

	private List<L1ItemInstance> findItemsIdNotEquipped(int id) {
		List<L1ItemInstance> itemList = new ArrayList<L1ItemInstance>();
		for (L1ItemInstance item : _items) {
			if (item.getItemId() == id && !item.isEquipped()) {
				itemList.add(item);
			}
		}
		return itemList;
	}

	public L1ItemInstance getItem(int objectId) {
		for (Object itemObject : _items) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.getId() == objectId) {
				return item;
			}
		}
		return null;
	}

	public boolean checkItem(int id) {
		return checkItem(id, 1);
	}

	public boolean checkItem(int id, int count) {
		if (count == 0) {
			return true;
		}
		if (ItemTable.getInstance().getTemplate(id).isStackable()) {
			L1ItemInstance item = findItemId(id);
			if (item != null && item.getCount() >= count) {
				return true;
			}
		} else {
			if (findItemsId(id).size() >= count) {
				return true;
			}
		}
		return false;
	}

	public boolean checkEnchantItem(int id, int enchant, int count) {
		int num = 0;
		for (L1ItemInstance item : _items) {
			if (item.isEquipped()) {
				continue;
			}
			if (item.getItemId() == id && item.getEnchantLevel() == enchant) {
				num++;
				if (num == count) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean consumeEnchantItem(int id, int enchant, int count) {
		for (L1ItemInstance item : _items) {
			if (item.isEquipped()) {
				continue;
			}
			if (item.getItemId() == id && item.getEnchantLevel() == enchant) {
				removeItem(item);
				return true;
			}
		}
		return false;
	}

	public boolean checkItemNotEquipped(int id, int count) {
		if (count == 0) {
			return true;
		}
		return count <= countItems(id);
	}

	public boolean checkItem(int[] ids) {
		int len = ids.length;
		int[] counts = new int[len];
		for (int i = 0; i < len; i++) {
			counts[i] = 1;
		}
		return checkItem(ids, counts);
	}

	public boolean checkItem(int[] ids, int[] counts) {
		for (int i = 0; i < ids.length; i++) {
			if (!checkItem(ids[i], counts[i])) {
				return false;
			}
		}
		return true;
	}

	public int countItems(int id) {
		if (ItemTable.getInstance().getTemplate(id).isStackable()) {
			L1ItemInstance item = findItemId(id);
			if (item != null) {
				return item.getCount();
			}
		} else {
			return findItemsIdNotEquipped(id).size();
		}
		return 0;
	}

	public void shuffle() {
		Collections.shuffle(_items);
	}

	public void clearItems() {
		for (L1ItemInstance item : _items) {
			L1World.getInstance().removeObject(item);
		}
		_items.clear();
	}

	public void loadItems() {
	}

	public void insertItem(L1ItemInstance item) {
	}

	public void updateItem(L1ItemInstance item) {
	}

	public void updateItem(L1ItemInstance item, int colmn) {
	}
}
