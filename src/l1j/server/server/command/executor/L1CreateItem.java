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
package l1j.server.server.command.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.ShopTable;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.shop.L1Shop;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_ShopSellList;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1ShopItem;

public class L1CreateItem implements L1CommandExecutor {
	private static Logger _log = LoggerFactory.getLogger(L1CreateItem.class.getName());

	private L1CreateItem() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1CreateItem();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			List<String> args = new ArrayList<String>();
			Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(arg);
			
			while (m.find())
				args.add(m.group(1).replace("\"", ""));
			
			// initialize this to blank if it is empty just so we don't have to add more
			// logic to display the help message
			if(args.size() == 0)
				args.add("");
			
			String nameOrId = args.get(0);
			
			L1Item itemToCreate = null;
			
			// they've chosen to enter all parameters, so don't display the shop window
			if(args.size() == 4){
				try {
					itemToCreate = ItemTable.getInstance().getTemplate(Integer.parseInt(nameOrId));
				} catch(NumberFormatException nfe) {
					int itemId = ItemTable.getInstance().findItemIdByNameWithoutSpace(
							nameOrId, true);
					
					if(itemId > 0)
						itemToCreate = ItemTable.getInstance().getTemplate(itemId);
				}
			}
				
			// if the user entered the long version and we were able to find the
			// item based on the name or id, just pop it into their inventory without
			// bringing up the shop window
			if (itemToCreate != null) {
				int count = Integer.parseInt(args.get(1));
				int enchant = Integer.parseInt(args.get(2));
				int isId = Integer.parseInt(args.get(3));
				int itemId = itemToCreate.getItemId();
				
				if (itemToCreate.isStackable()) {
					L1ItemInstance item = ItemTable.getInstance().createItem(
							itemId);
					item.setEnchantLevel(0);
					item.setCount(count);
					if (isId == 1) {
						item.setIdentified(true);
					}
					if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
						pc.getInventory().storeItem(item);
						pc.sendPackets(new S_ServerMessage(403, item
								.getLogName() + " ID: " + itemId + " "));
					}
				} else {
					L1ItemInstance item = null;
					int createCount;
					for (createCount = 0; createCount < count; createCount++) {
						item = ItemTable.getInstance().createItem(itemId);
						item.setEnchantLevel(enchant);
						if (isId == 1) {
							item.setIdentified(true);
						}
						if (pc.getInventory().checkAddItem(item, 1) == L1Inventory.OK) {
							pc.getInventory().storeItem(item);
						} else {
							break;
						}
					}
					if (createCount > 0) {
						pc.sendPackets(new S_ServerMessage(403, item
								.getLogName() + " ID: " + itemId + " "));
					}
				}
			} else if(args.size() == 2) {
				// if they chose to use the shorted format then lets bring up a,
				// window containing similar matches for them to select
				int enchantLevel = Integer.parseInt(args.get(1));
				List<L1ShopItem> shopItems = new ArrayList<L1ShopItem>();
				List<L1Item> items = ItemTable.getInstance().findItemsByName(nameOrId, true);
				
				for(L1Item item : items) {
					L1ShopItem itemToAdd = new L1ShopItem(item.getItemId(), 0, 1, enchantLevel);
					shopItems.add(itemToAdd);
				}
				
				if(shopItems.size() <= 50) {
					L1Shop gmShop = new L1Shop(pc.getId(), shopItems, new ArrayList<L1ShopItem>());
					ShopTable.getInstance().addGMShop(pc.getId(), gmShop);
					
					pc.sendPackets(new S_ShopSellList(pc));
					pc.sendPackets(
							new S_SystemMessage(String.format("All items in the shop window have been set to +%d "
									+ "and will be identified after purchase.", enchantLevel)));
				} else {
					pc.sendPackets(new S_SystemMessage("Too many items returned. Please refine your search."));
				}
			} else {
				pc.sendPackets(new S_SystemMessage(
						String.format(".%1$s <itemid or name> <amount> <enchant> <isID> or .%1$s <name> <enchant>",
								cmdName)));
			}
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <itemid or name> <amount> <enchant> <isID> or .%1$s <name> <enchant>",
							cmdName)));
		}
	}
}
