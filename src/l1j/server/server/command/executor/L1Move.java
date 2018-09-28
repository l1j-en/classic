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
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;

import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_RawStringDialog;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Move implements L1CommandExecutor {

	private TreeMap<String, TreeMap<String, int[]>> _teleportLocations 
	= new TreeMap<String, TreeMap<String, int[]>>(String.CASE_INSENSITIVE_ORDER);
	
	private L1Move() {
		TreeMap<String, int[]> _towns = new TreeMap<String, int[]>(String.CASE_INSENSITIVE_ORDER);
		TreeMap<String, int[]> _castles = new TreeMap<String, int[]>(String.CASE_INSENSITIVE_ORDER);

		// 2nd parameter format is:
		// { x, y, mapid }
		// where spacing is used to make it look pretty inside the html window
		
		// all of the towns
		_towns.put("Aden", new int[] { 33964, 33244, 4 });
		_towns.put("Diad", new int[] { 32814, 32914, 320 });
		_towns.put("Cave of Silence", new int[] { 32859, 32898, 304 });
		_towns.put("Giran", new int[] { 33432, 32811, 4 });
		_towns.put("Gludio", new int[] { 32619, 32801, 4 });
		_towns.put("Heine", new int[] { 33603, 33235, 4 });
		_towns.put("Kent", new int[] { 33072, 32797, 4 });
		_towns.put("Orc", new int[] { 32745, 32446, 4 });
		_towns.put("Oren", new int[] { 34054, 32283, 4 });
		_towns.put("SI", new int[] { 32791, 32772, 68 });
		_towns.put("Singing Island", new int[] { 32791, 32772, 68 });
		_towns.put("SKT", new int[] { 33080, 33392, 4 });
		_towns.put("Silver Knight Town", new int[] { 33080, 33392, 4 });
		_towns.put("TI", new int[] { 32574, 32944, 0 });
		_towns.put("Talking Island", new int[] { 32574, 32944, 0 });
		_towns.put("Weldern", new int[] { 33720, 32489, 4 });
		_towns.put("Windawood", new int[] { 32608, 33183, 4 });
		_towns.put("Woodbec", new int[] { 32608, 33183, 4 });
		
		// all of the castles
		_castles.put("Aden", new int[] { 34089, 33292, 4 });
		_castles.put("Aden Inner", new int[] { 32895, 32529, 300 });
		_castles.put("Dwarf", new int[] { 33627, 32371, 4 });
		_castles.put("Dwarf Inner", new int[] { 32681, 32805, 66 });
		_castles.put("Giran", new int[] { 33632, 32672, 4 });
		_castles.put("Giran Inner", new int[] { 32729, 32794, 52 });
		_castles.put("Heine", new int[] { 33520, 33415, 4 });
		_castles.put("Heine Inner", new int[] { 32573, 32816, 64 });
		_castles.put("Kent", new int[] { 33149, 32775, 4 });
		_castles.put("Kent Inner", new int[] { 32736, 32788, 15 });
		_castles.put("Orc", new int[] { 32799, 32288, 4 });
		_castles.put("Windawood", new int[] { 32651, 33416, 4 });
		_castles.put("Windawood Inner", new int[] { 32734, 32788, 29 });
		
		// TODO -- add major hunting zones as well
		
		_teleportLocations.put("Town", _towns);
		_teleportLocations.put("Castle", _castles);
	}

	public static L1CommandExecutor getInstance() {
		return new L1Move();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			List<String> args = new ArrayList<String>();
			Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(arg);
			
			while (m.find())
				args.add(m.group(1).replace("\"", ""));
			
			int locx = pc.getX();
			int locy = pc.getY();
			short mapid = pc.getMapId();
			
			if(args.size() == 3){
				locx = Integer.parseInt(args.get(0));
				locy = Integer.parseInt(args.get(1));
				mapid = Short.parseShort(args.get(2));
			} else {
				String type = args.get(0).toUpperCase();
				String inputName = args.get(1);
				
				// if it is an exact match, lets just move them there
				if(_teleportLocations.get(type).containsKey(inputName)){
					int[] location = _teleportLocations.get(type).get(inputName);
					locx = location[0];
					locy = location[1];
					mapid = (short)location[2];
				} else {
					// if it isn't, then display any matches that are close
					List<String> possibleLocations = new ArrayList<String>();
					
					// split based on spaces and search for each word
					// this also allows them to enter "Or" for oren or orc
					// will give all possible towns
					String[] splitLocationName = inputName.split(" ");
					
					if(splitLocationName.length > 0){
						for(String name : splitLocationName){
							for(Map.Entry<String, int[]> entry : _teleportLocations.get(type).entrySet()) {
								String key = entry.getKey();
							    if(key.toLowerCase().contains(name.toLowerCase())){
							    	possibleLocations.add(key);
							    }
							}
						}
					}
					
					if(possibleLocations.isEmpty())
						possibleLocations.add(
								String.format("Locations (%s) found matching \"%s\". "
										+ "Try searching on just the first few characters or wrapping multi-word locations in quotes.",
										type, inputName));
					
					pc.sendPackets(new S_RawStringDialog(pc.getId(), 
							String.format("Teleport Locations (%s)", type), 
							Joiner.on(", ").join(possibleLocations)));
				}
			}
			
			// will they move?
			if(locx != pc.getX() || locy != pc.getY() || mapid != pc.getMapId()){
				L1Teleport.teleport(pc, locx, locy, mapid, 5, false);
				pc.sendPackets(new S_SystemMessage("Moved: " + locx + ", " + locy
						+ ", " + mapid + ""));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <x> <y> <mapid> or .%1$s TOWN|CASTLE \"<location name>\"", cmdName)));
		}
	}
}
