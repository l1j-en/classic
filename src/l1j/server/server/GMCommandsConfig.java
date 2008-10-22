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
package l1j.server.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import l1j.server.server.model.L1Location;
import l1j.server.server.utils.IterableElementList;

class ItemSetItem {
	private final int id;
	private final int amount;
	private final int enchant;

	public ItemSetItem(int id, int amount, int enchant) {
		super();
		this.id = id;
		this.amount = amount;
		this.enchant = enchant;
	}

	public int getId() {
		return id;
	}

	public int getAmount() {
		return amount;
	}

	public int getEnchant() {
		return enchant;
	}
}

public class GMCommandsConfig {
	private static Logger _log = Logger.getLogger(GMCommandsConfig.class
			.getName());

	private interface ConfigLoader {
		public void load(Element element);
	}

	private abstract class ListLoaderAdapter implements ConfigLoader {
		private final String _listName;

		public ListLoaderAdapter(String listName) {
			_listName = listName;
		}

		@Override
		public final void load(Element element) {
			NodeList nodes = element.getChildNodes();
			for (Element elem : new IterableElementList(nodes)) {
				if (elem.getNodeName().equalsIgnoreCase(_listName)) {
					loadElement(elem);
				}
			}
		}

		public abstract void loadElement(Element element);
	}

	private class RoomLoader extends ListLoaderAdapter {
		public RoomLoader() {
			super("Room");
		}

		@Override
		public void loadElement(Element element) {
			String name = element.getAttribute("Name");
			int locX = Integer.valueOf(element.getAttribute("LocX"));
			int locY = Integer.valueOf(element.getAttribute("LocY"));
			int mapId = Integer.valueOf(element.getAttribute("MapId"));
			ROOMS.put(name.toLowerCase(), new L1Location(locX, locY, mapId));
		}
	}

	private class ItemSetLoader extends ListLoaderAdapter {
		public ItemSetLoader() {
			super("ItemSet");
		}

		public ItemSetItem loadItem(Element element) {
			int id = Integer.valueOf(element.getAttribute("Id"));
			int amount = Integer.valueOf(element.getAttribute("Amount"));
			int enchant = Integer.valueOf(element.getAttribute("Enchant"));
			return new ItemSetItem(id, amount, enchant);
		}

		@Override
		public void loadElement(Element element) {
			List<ItemSetItem> list = new ArrayList<ItemSetItem>();
			NodeList nodes = element.getChildNodes();
			for (Element elem : new IterableElementList(nodes)) {
				if (elem.getNodeName().equalsIgnoreCase("Item")) {
					list.add(loadItem(elem));
				}
			}
			String name = element.getAttribute("Name");
			ITEM_SETS.put(name.toLowerCase(), list);
		}
	}

	private static HashMap<String, ConfigLoader> _loaders = new HashMap<String, ConfigLoader>();
	static {
		GMCommandsConfig instance = new GMCommandsConfig();
		_loaders.put("roomlist", instance.new RoomLoader());
		_loaders.put("itemsetlist", instance.new ItemSetLoader());
	}

	public static HashMap<String, L1Location> ROOMS = new HashMap<String, L1Location>();
	public static HashMap<String, List<ItemSetItem>> ITEM_SETS = new HashMap<String, List<ItemSetItem>>();

	private static Document loadXml(String file)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		return builder.parse(file);
	}

	public static void load() {
		try {
			Document doc = loadXml("./data/xml/GmCommands/GMCommands.xml");
			NodeList nodes = doc.getDocumentElement().getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				ConfigLoader loader = _loaders.get(nodes.item(i).getNodeName()
						.toLowerCase());
				if (loader != null) {
					loader.load((Element) nodes.item(i));
				}
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, "GMCommands.xml Failure to load", e);
		}
	}
}
