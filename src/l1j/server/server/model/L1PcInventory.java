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

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.serverpackets.S_AddItem;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_DeleteInventoryItem;
import l1j.server.server.serverpackets.S_EquipmentWindow;
import l1j.server.server.serverpackets.S_ItemAmount;
import l1j.server.server.serverpackets.S_ItemColor;
import l1j.server.server.serverpackets.S_ItemName;
import l1j.server.server.serverpackets.S_ItemStatus;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_ServerMessage;
import static l1j.server.server.serverpackets.S_EquipmentWindow.*;
import l1j.server.server.storage.CharactersItemStorage;
import l1j.server.server.templates.L1Item;

public class L1PcInventory extends L1Inventory {

	private static final long serialVersionUID = 1L;

	private static Logger _log = LoggerFactory			.getLogger(L1PcInventory.class.getName());

	private static final int MAX_SIZE = 180;
	private final L1PcInstance _owner;
	private int _arrowId;
	private int _stingId;

	public L1PcInventory(L1PcInstance owner) {
		_owner = owner;
		_arrowId = 0;
		_stingId = 0;
	}

	public L1PcInstance getOwner() {
		return _owner;
	}

	public int getWeight240() {
		return calcWeight240(getWeight());
	}

	public int calcWeight240(int weight) {
		int weight240 = 0;
		if (Config.RATE_WEIGHT_LIMIT != 0) {
			double maxWeight = _owner.getMaxWeight();
			if (weight > maxWeight) {
				weight240 = 240;
			} else {
				double wpTemp = (weight * 100 / maxWeight) * 240.00 / 100.00;
				DecimalFormat df = new DecimalFormat("00.##");
				df.format(wpTemp);
				wpTemp = Math.round(wpTemp);
				weight240 = (int) (wpTemp);
			}
		} else {
			weight240 = 0;
		}
		return weight240;
	}

	@Override
	public int checkAddItem(L1ItemInstance item, int count) {
		return checkAddItem(item, count, true);
	}

	public int checkAddItem(L1ItemInstance item, int count, boolean message) {
		if (item == null) {
			return -1;
		}
		if (getSize() > MAX_SIZE
				|| (getSize() == MAX_SIZE && (!item.isStackable() || !checkItem(item
						.getItem().getItemId())))) {
			if (message) {
				sendOverMessage(263);
			}
			return SIZE_OVER;
		}

		int weight = getWeight() + item.getItem().getWeight() * count / 1000
				+ 1;
		if (weight < 0 || (item.getItem().getWeight() * count / 1000) < 0) {
			if (message) {
				sendOverMessage(82); //
			}
			return WEIGHT_OVER;
		}
		if (calcWeight240(weight) >= 240) {
			if (message) {
				sendOverMessage(82);
			}
			return WEIGHT_OVER;
		}

		L1ItemInstance itemExist = findItemId(item.getItemId());
		if (itemExist != null && (itemExist.getCount() + count) > MAX_AMOUNT) {
			if (message) {
				getOwner().sendPackets(
						new S_ServerMessage(166, "", "2,000,000,000"));
			}
			return AMOUNT_OVER;
		}

		return OK;
	}

	public void sendOverMessage(int message_id) {
		_owner.sendPackets(new S_ServerMessage(message_id));
	}

	@Override
	public void loadItems() {
		try {
			CharactersItemStorage storage = CharactersItemStorage.create();

			boolean weaponEquipped = false;

			for (L1ItemInstance item : storage.loadItems(_owner.getId())) {
				_items.add(item);

				if (item.isEquipped()) {
					// Quick patch to deal with equipping multiple weapons. Not
					// the right thing to do, but should deal with the problem
					// in the short term.
					if (item.getItem().getType2() == 1) {
						if (weaponEquipped) {
							_log.warn(
									"Trying to equip extra weapon during load.");
							item.setEquipped(false);
							continue;
						} else {
							weaponEquipped = true;
						}
					}

					item.setEquipped(false);
					setEquipped(item, true, true, false);
				}
				if (item.getItem().getType2() == 0
						&& item.getItem().getType() == 2) {
					item.setRemainingTime(item.getItem().getLightFuel());
				}
				L1World.getInstance().storeObject(item);
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void insertItem(L1ItemInstance item) {
		_owner.sendPackets(new S_AddItem(item));
		if (item.getItem().getWeight() != 0) {
			_owner.sendPackets(new S_PacketBox(S_PacketBox.WEIGHT,
					getWeight240()));
		}
		try {
			CharactersItemStorage storage = CharactersItemStorage.create();
			storage.storeItem(_owner.getId(), item);
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	public static final int COL_ATTR_ENCHANT_LEVEL = 2048;
	public static final int COL_ATTR_ENCHANT_KIND = 1024;
	public static final int COL_BLESS = 512;
	public static final int COL_REMAINING_TIME = 256;
	public static final int COL_CHARGE_COUNT = 128;
	public static final int COL_ITEMID = 64;
	public static final int COL_DELAY_EFFECT = 32;
	public static final int COL_COUNT = 16;
	public static final int COL_EQUIPPED = 8;
	public static final int COL_ENCHANTLVL = 4;
	public static final int COL_IS_ID = 2;
	public static final int COL_DURABILITY = 1;

	@Override
	public void updateItem(L1ItemInstance item) {
		updateItem(item, COL_COUNT);
		if (item.getItem().isToBeSavedAtOnce()) {
			saveItem(item, COL_COUNT);
		}
	}

	@Override
	public void updateItem(L1ItemInstance item, int column) {
		if (column >= COL_ATTR_ENCHANT_LEVEL) { //
			_owner.sendPackets(new S_ItemStatus(item));
			column -= COL_ATTR_ENCHANT_LEVEL;
		}
		if (column >= COL_ATTR_ENCHANT_KIND) { //
			_owner.sendPackets(new S_ItemStatus(item));
			column -= COL_ATTR_ENCHANT_KIND;
		}
		if (column >= COL_BLESS) {
			_owner.sendPackets(new S_ItemColor(item));
			column -= COL_BLESS;
		}
		if (column >= COL_REMAINING_TIME) {
			_owner.sendPackets(new S_ItemName(item));
			column -= COL_REMAINING_TIME;
		}
		if (column >= COL_CHARGE_COUNT) {
			_owner.sendPackets(new S_ItemName(item));
			column -= COL_CHARGE_COUNT;
		}
		if (column >= COL_ITEMID) {
			_owner.sendPackets(new S_ItemStatus(item));
			_owner.sendPackets(new S_ItemColor(item));
			_owner.sendPackets(new S_PacketBox(S_PacketBox.WEIGHT,
					getWeight240()));
			column -= COL_ITEMID;
		}
		if (column >= COL_DELAY_EFFECT) {
			column -= COL_DELAY_EFFECT;
		}
		if (column >= COL_COUNT) {
			_owner.sendPackets(new S_ItemAmount(item));

			int weight = item.getWeight();
			if (weight != item.getLastWeight()) {
				item.setLastWeight(weight);
				_owner.sendPackets(new S_ItemStatus(item));
			} else {
				_owner.sendPackets(new S_ItemName(item));
			}
			if (item.getItem().getWeight() != 0) {
				_owner.sendPackets(new S_PacketBox(S_PacketBox.WEIGHT,
						getWeight240()));
			}
			column -= COL_COUNT;
		}
		if (column >= COL_EQUIPPED) {
			_owner.sendPackets(new S_ItemName(item));
			column -= COL_EQUIPPED;
		}
		if (column >= COL_ENCHANTLVL) {
			_owner.sendPackets(new S_ItemStatus(item));
			column -= COL_ENCHANTLVL;
		}
		if (column >= COL_IS_ID) {
			_owner.sendPackets(new S_ItemStatus(item));
			_owner.sendPackets(new S_ItemColor(item));
			column -= COL_IS_ID;
		}
		if (column >= COL_DURABILITY) {
			_owner.sendPackets(new S_ItemStatus(item));
			column -= COL_DURABILITY;
		}
	}

	public static final int COL_ADDHP = 1;
	public static final int COL_ADDMP = 2;
	public static final int COL_HPR = 4;
	public static final int COL_MPR = 8;
	public static final int COL_ADDSP = 16;
	public static final int COL_M_DEF = 32;
	public static final int COL_EARTHMR = 64;
	public static final int COL_FIREMR = 128;
	public static final int COL_WATERMR = 256;
	public static final int COL_WINDMR = 512;

	public void saveEnchantAccessory(L1ItemInstance item, int column) {
		if (column == 0)
			return;

		try {
			CharactersItemStorage storage = CharactersItemStorage.create();
			if (column >= COL_WINDMR) {
				storage.updateWindResist(item);
				column -= COL_WINDMR;
			}
			if (column >= COL_WATERMR) {
				storage.updateWaterResist(item);
				column -= COL_WATERMR;
			}
			if (column >= COL_FIREMR) {
				storage.updateFireResist(item);
				column -= COL_FIREMR;
			}
			if (column >= COL_EARTHMR) {
				storage.updateEarthResist(item);
				column -= COL_EARTHMR;
			}
			if (column >= COL_M_DEF) {
				storage.updateMagicResist(item);
				column -= COL_M_DEF;
			}
			if (column >= COL_ADDSP) {
				storage.updateSpellpower(item);
				column -= COL_ADDSP;
			}
			if (column >= COL_MPR) {
				storage.updateMpRegen(item);
				column -= COL_MPR;
			}
			if (column >= COL_HPR) {
				storage.updateHpRegen(item);
				column -= COL_HPR;
			}
			if (column >= COL_ADDMP) {
				storage.updateAddMp(item);
				column -= COL_ADDMP;
			}
			if (column >= COL_ADDHP) {
				storage.updateAddHp(item);
				column -= COL_ADDHP;
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	public void saveItem(L1ItemInstance item, int column) {
		if (column == 0) {
			return;
		}

		try {
			CharactersItemStorage storage = CharactersItemStorage.create();
			if (column >= COL_ATTR_ENCHANT_LEVEL) { //
				storage.updateItemAttrEnchantLevel(item);
				column -= COL_ATTR_ENCHANT_LEVEL;
			}
			if (column >= COL_ATTR_ENCHANT_KIND) { //
				storage.updateItemAttrEnchantKind(item);
				column -= COL_ATTR_ENCHANT_KIND;
			}
			if (column >= COL_BLESS) {
				storage.updateItemBless(item);
				column -= COL_BLESS;
			}
			if (column >= COL_REMAINING_TIME) {
				storage.updateItemRemainingTime(item);
				column -= COL_REMAINING_TIME;
			}
			if (column >= COL_CHARGE_COUNT) {
				storage.updateItemChargeCount(item);
				column -= COL_CHARGE_COUNT;
			}
			if (column >= COL_ITEMID) {
				storage.updateItemId(item);
				column -= COL_ITEMID;
			}
			if (column >= COL_DELAY_EFFECT) {
				storage.updateItemDelayEffect(item);
				column -= COL_DELAY_EFFECT;
			}
			if (column >= COL_COUNT) {
				storage.updateItemCount(item);
				column -= COL_COUNT;
			}
			if (column >= COL_EQUIPPED) {
				storage.updateItemEquipped(item);
				column -= COL_EQUIPPED;
			}
			if (column >= COL_ENCHANTLVL) {
				storage.updateItemEnchantLevel(item);
				column -= COL_ENCHANTLVL;
			}
			if (column >= COL_IS_ID) {
				storage.updateItemIdentified(item);
				column -= COL_IS_ID;
			}
			if (column >= COL_DURABILITY) {
				storage.updateItemDurability(item);
				column -= COL_DURABILITY;
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void deleteItem(L1ItemInstance item) {
		try {
			CharactersItemStorage storage = CharactersItemStorage.create();

			storage.deleteItem(item);
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		}
		if (item.isEquipped()) {
			setEquipped(item, false);
		}
		_owner.sendPackets(new S_DeleteInventoryItem(item));
		_items.remove(item);
		if (item.getItem().getWeight() != 0) {
			_owner.sendPackets(new S_PacketBox(S_PacketBox.WEIGHT,
					getWeight240()));
		}
	}

	public void setEquipped(L1ItemInstance item, boolean equipped) {
		setEquipped(item, equipped, false, false);
	}

	public void setEquipped(L1ItemInstance item, boolean equipped,
			boolean loaded, boolean changeWeapon) {
		if (item.isEquipped() != equipped) {
			L1Item temp = item.getItem();
			if (equipped) {
				item.setEquipped(true);
				_owner.getEquipSlot().set(item);
				Equipped(item, true);
			} else {
				if (!loaded) {

					if (temp.getItemId() == 20077 || temp.getItemId() == 20062
							|| temp.getItemId() == 120077) {
						if (_owner.isInvisDelay() || _owner.isInvisble()) {
							_owner.delInvis();
							return;
						}
					}
				}
				
				Equipped(item, false);
				item.setEquipped(false);
				_owner.getEquipSlot().remove(item);
			}
			if (!loaded) {
				_owner.setCurrentHp(_owner.getCurrentHp());
				_owner.setCurrentMp(_owner.getCurrentMp());
				updateItem(item, COL_EQUIPPED);
				_owner.sendPackets(new S_OwnCharStatus(_owner));
				if (temp.getType2() == 1 && changeWeapon == false) {
					_owner.sendPackets(new S_CharVisualUpdate(_owner));
					_owner.broadcastPacket(new S_CharVisualUpdate(_owner));
				}
			}
		}
	}
	
	public boolean checkRingEquipped(int id) {
		for (Object itemObject : _items) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.getRingID() == id && item.isEquipped()) {
				return true;
			}
		}
		return false;
	}

	public void Equipped(L1ItemInstance item, boolean isEq) {
		int RingID = item.getRingID();
		if ((item.getItem().getType2() == 2) && (item.isEquipped())) {
			int items = 0;
			if ((item.getItem().getType() == 1)) {
				items = EQUIPMENT_INDEX_HELM;
			} else if ((item.getItem().getType() == 2)) {
				items = EQUIPMENT_INDEX_T;
			} else if ((item.getItem().getType() == 3)) {
				items = EQUIPMENT_INDEX_ARMOR;
			} else if ((item.getItem().getType() == 4)) {
				items = EQUIPMENT_INDEX_CLOAK;
			} else if ((item.getItem().getType() == 5)) {
				items = EQUIPMENT_INDEX_GLOVE;
			} else if ((item.getItem().getType() == 6)) {
				items = EQUIPMENT_INDEX_BOOTS;
			} else if ((item.getItem().getType() == 7)) {
				// sheild
				items = EQUIPMENT_INDEX_SHIELD;
			} else if ((item.getItem().getType() == 13)) {
				// guarder
				items = EQUIPMENT_INDEX_SHIELD;
			} else if ((item.getItem().getType() == 9)) {
				if (isEq == true){
					if (checkRingEquipped(EQUIPMENT_INDEX_RING1)){
						items = EQUIPMENT_INDEX_RING2;	
						item.setRingID(items);
					} else {
						items = EQUIPMENT_INDEX_RING1;
						item.setRingID(items);
					}

					if(getTypeEquipped(2, 11) == 3){ 
						if(!checkRingEquipped(EQUIPMENT_INDEX_RING1)){  
							items = EQUIPMENT_INDEX_RING1;
							item.setRingID(items);
						} else if (!checkRingEquipped(EQUIPMENT_INDEX_RING2)){ 
							items = EQUIPMENT_INDEX_RING2;
							item.setRingID(items);
						} else if (!checkRingEquipped(EQUIPMENT_INDEX_RING3)){ 
							items = EQUIPMENT_INDEX_RING3;
							item.setRingID(items);
						}
					}

					if(getTypeEquipped(2, 11) == 4){
						if(!checkRingEquipped(EQUIPMENT_INDEX_RING1)){  
							items = EQUIPMENT_INDEX_RING1;
							item.setRingID(items);
						} else if (!checkRingEquipped(EQUIPMENT_INDEX_RING2)){ 
							items = EQUIPMENT_INDEX_RING2;
							item.setRingID(items);
						} else if (!checkRingEquipped(EQUIPMENT_INDEX_RING3)){ 
							items = EQUIPMENT_INDEX_RING3;
							item.setRingID(items);
						}else if (!checkRingEquipped(EQUIPMENT_INDEX_RING4)){ 
							items = EQUIPMENT_INDEX_RING4;
							item.setRingID(items);
						}
					}
				} else {
					if (RingID == EQUIPMENT_INDEX_RING1){
						items = EQUIPMENT_INDEX_RING1;
						item.setRingID(0);
					} else if  (RingID == EQUIPMENT_INDEX_RING2){
						items = EQUIPMENT_INDEX_RING2;
						item.setRingID(0);
					} else if (RingID == EQUIPMENT_INDEX_RING3){      
						items = EQUIPMENT_INDEX_RING3;
						item.setRingID(0);
					} else if  (RingID == EQUIPMENT_INDEX_RING4){
						items = EQUIPMENT_INDEX_RING4;
						item.setRingID(0);
					}                             
				}
			} else if ((item.getItem().getType() == 8)) {
				items = EQUIPMENT_INDEX_AMULET;
			} else if ((item.getItem().getType() == 12)) {
				items = EQUIPMENT_INDEX_EARRING;
			} else if ((item.getItem().getType() == 10)) {
				items = EQUIPMENT_INDEX_BELT;	
			} else if ((item.getItem().getType() == 14)) {
				items = EQUIPMENT_INDEX_RUNE1;
			} else if ((item.getItem().getType() == 15)) {
				items = EQUIPMENT_INDEX_RUNE2;
			} else if ((item.getItem().getType() == 16)) {
				items = EQUIPMENT_INDEX_RUNE3;
			} else if ((item.getItem().getType() == 17)) {
				items = EQUIPMENT_INDEX_RUNE4;
			} else if ((item.getItem().getType() == 18)) {
				items = EQUIPMENT_INDEX_RUNE5;
			}
			
			_owner.sendPackets(new S_EquipmentWindow(_owner, item.getId(),items,isEq)); 
		}
		if ((item.getItem().getType2() == 1) && (item.isEquipped())) {
			int items = EQUIPMENT_INDEX_WEAPON;
			_owner.sendPackets(new S_EquipmentWindow(_owner, item.getId(),items,isEq)); 
		}
	}


	public boolean checkEquipped(int id) {
		for (Object itemObject : _items) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.getItem().getItemId() == id && item.isEquipped()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkEquipped(int[] ids) {
		for (int id : ids) {
			if (!checkEquipped(id)) {
				return false;
			}
		}
		return true;
	}

	public int getTypeEquipped(int type2, int type) {
		int equipeCount = 0;
		for (Object itemObject : _items) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.getItem().getType2() == type2
					&& item.getItem().getType() == type && item.isEquipped()) {
				equipeCount++;
			}
		}
		return equipeCount;
	}

	public L1ItemInstance getItemEquipped(int type2, int type) {
		L1ItemInstance equipeitem = null;
		for (Object itemObject : _items) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.getItem().getType2() == type2
					&& item.getItem().getType() == type && item.isEquipped()) {
				equipeitem = item;
				break;
			}
		}
		return equipeitem;
	}

	public L1ItemInstance[] getRingEquipped() {
		L1ItemInstance equipeItem[] = new L1ItemInstance[2];
		int equipeCount = 0;
		for (Object itemObject : _items) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.getItem().getType2() == 2 && item.getItem().getType() == 9
					&& item.isEquipped()) {
				equipeItem[equipeCount] = item;
				equipeCount++;
				if (equipeCount == 2) {
					break;
				}
			}
		}
		return equipeItem;
	}

	public void takeoffEquip(int polyid) {
		takeoffWeapon(polyid);
		takeoffArmor(polyid);
	}

	private void takeoffWeapon(int polyid) {
		if (_owner.getWeapon() == null) {
			return;
		}

		boolean takeoff = false;
		int weapon_type = _owner.getWeapon().getItem().getType();
		takeoff = !L1PolyMorph.isEquipableWeapon(polyid, weapon_type);

		if (takeoff) {
			setEquipped(_owner.getWeapon(), false, false, false);
		}
	}

	private void takeoffArmor(int polyid) {
		L1ItemInstance armor = null;

		for (int type = 0; type <= 13; type++) {
			if (getTypeEquipped(2, type) != 0
					&& !L1PolyMorph.isEquipableArmor(polyid, type)) {
				if (type == 9) {
					armor = getItemEquipped(2, type);
					if (armor != null) {
						setEquipped(armor, false, false, false);
					}
					armor = getItemEquipped(2, type);
					if (armor != null) {
						setEquipped(armor, false, false, false);
					}
				} else {
					armor = getItemEquipped(2, type);
					if (armor != null) {
						setEquipped(armor, false, false, false);
					}
				}
			}
		}
	}

	public L1ItemInstance getArrow() {
		return getBullet(0);
	}

	public L1ItemInstance getSting() {
		return getBullet(15);
	}

	private L1ItemInstance getBullet(int type) {
		L1ItemInstance bullet;
		int priorityId = 0;
		if (type == 0) {
			priorityId = _arrowId;
		}
		if (type == 15) {
			priorityId = _stingId;
		}
		if (priorityId > 0) {
			bullet = findItemId(priorityId);
			if (bullet != null) {
				return bullet;
			} else {
				if (type == 0) {
					_arrowId = 0;
				}
				if (type == 15) {
					_stingId = 0;
				}
			}
		}

		for (Object itemObject : _items) {
			bullet = (L1ItemInstance) itemObject;
			if (bullet.getItem().getType() == type) {
				if (type == 0) {
					_arrowId = bullet.getItem().getItemId();
				}
				if (type == 15) {
					_stingId = bullet.getItem().getItemId();
				}
				return bullet;
			}
		}
		return null;
	}

	public void setArrow(int id) {
		_arrowId = id;
	}

	public void setSting(int id) {
		_stingId = id;
	}

	public int hpRegenPerTick() {
		int hpr = 0;
		for (Object itemObject : _items) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.isEquipped()) {
				hpr += item.getItem().get_addhpr() + item.getAddHpRegen();
			}
		}
		return hpr;
	}

	public int mpRegenPerTick() {
		int mpr = 0;
		for (Object itemObject : _items) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.isEquipped()) {
				mpr += item.getItem().get_addmpr() + item.getAddMpRegen();
			}
		}
		return mpr;
	}

	public L1ItemInstance CaoPenalty() {
		new Random();
		int rnd = ThreadLocalRandom.current().nextInt(_items.size());
		L1ItemInstance penaltyItem = _items.get(rnd);
		if (penaltyItem.getItem().getItemId() == L1ItemId.ADENA
				|| !penaltyItem.getItem().isTradable()) {
			return null;
		}
		Object[] petlist = _owner.getPetList().values().toArray();
		for (Object petObject : petlist) {
			if (petObject instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) petObject;
				if (penaltyItem.getId() == pet.getItemObjId()) {
					return null;
				}
			}
		}
		setEquipped(penaltyItem, false);
		return penaltyItem;
	}
}
