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

import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_RawStringDialog;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1MoveChar implements L1CommandExecutor {

	private TreeMap<String, int[]> _moveLocations
	= new TreeMap<String, int[]>(String.CASE_INSENSITIVE_ORDER);
	
	private L1MoveChar() {
		// 2nd parameter format is:
		// { x, y, mapid }
		// where spacing is used to make it look pretty inside the html window
		
		// all of the towns
		_moveLocations.put("Aden", new int[] { 33964, 33244, 4 });
		_moveLocations.put("Diad", new int[] { 32814, 32914, 320 });
		_moveLocations.put("Cave of Silence", new int[] { 32859, 32898, 304 });
		_moveLocations.put("Elf", new int[] { 33054, 32323, 4 });
		_moveLocations.put("Elven Forest", new int[] { 33054, 32323, 4 });
		_moveLocations.put("EF", new int[] { 33054, 32323, 4 });
		_moveLocations.put("Giran", new int[] { 33432, 32811, 4 });
		_moveLocations.put("Gludio", new int[] { 32619, 32801, 4 });
		_moveLocations.put("Heine", new int[] { 33603, 33235, 4 });
		_moveLocations.put("Hidden Valley", new int[] { 32671, 32836, 69 });
		_moveLocations.put("Kent", new int[] { 33072, 32797, 4 });
		_moveLocations.put("Orc", new int[] { 32745, 32446, 4 });
		_moveLocations.put("Oren", new int[] { 34054, 32283, 4 });
		_moveLocations.put("SI", new int[] { 32791, 32772, 68 });
		_moveLocations.put("Singing Island", new int[] { 32791, 32772, 68 });
		_moveLocations.put("SKT", new int[] { 33080, 33392, 4 });
		_moveLocations.put("Silver Knight Town", new int[] { 33080, 33392, 4 });
		_moveLocations.put("TI", new int[] { 32574, 32944, 0 });
		_moveLocations.put("Talking Island", new int[] { 32574, 32944, 0 });
		_moveLocations.put("Weldern", new int[] { 33720, 32489, 4 });
		_moveLocations.put("Windawood", new int[] { 32608, 33183, 4 });
		_moveLocations.put("Woodbec", new int[] { 32608, 33183, 4 });
	}

	public static L1CommandExecutor getInstance() {
		return new L1MoveChar();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			List<String> args = new ArrayList<String>();
			Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(arg);
			
			while (m.find())
				args.add(m.group(1).replace("\"", ""));
			
			int[] defaultLocation = _moveLocations.get("skt");
			
			int locx = defaultLocation[0];
			int locy = defaultLocation[1];
			short mapid = (short)defaultLocation[2];
			
			String characterName = args.get(0);
			L1PcInstance target = L1World.getInstance().getPlayer(characterName);
			
			if(args.size() == 4){
				locx = Integer.parseInt(args.get(1));
				locy = Integer.parseInt(args.get(2));
				mapid = Short.parseShort(args.get(3));
			} else {
				String inputName = args.get(1);
				
				// if it is an exact match, lets just move them there
				if(_moveLocations.containsKey(inputName)){
					int[] location = _moveLocations.get(inputName);
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
							for(Map.Entry<String, int[]> entry : _moveLocations.entrySet()) {
								String key = entry.getKey();
							    if(key.toLowerCase().contains(name.toLowerCase())){
							    	possibleLocations.add(key);
							    }
							}
						}
					}
					
					if(possibleLocations.isEmpty())
						possibleLocations.add(
								String.format("Locations found matching \"%s\". "
										+ "Try searching on just the first few characters or wrapping multi-word locations in quotes.",
										 inputName));
					
					pc.sendPackets(new S_RawStringDialog(pc.getId(), 
							String.format("Offline Move Locations"), 
							Joiner.on(", ").join(possibleLocations)));
					return;
				}
			}
			
			if(target != null) {
				L1Teleport.teleport(target, locx, locy, mapid, 1, false);
				pc.sendPackets(new S_SystemMessage(String.format("Character '%s' Moved To: %s, %d, %d.",
						target.getName(), locx, locy, mapid)));
				target.sendPackets(new S_SystemMessage("A GM Has Teleported you."));
			} else {
				target = CharacterTable.getInstance().restoreCharacter(characterName);
				
				if(target == null) {
					pc.sendPackets(new S_SystemMessage("A character with the name '" + characterName + "' does not exist."));
					return;
				}
				
				CharacterTable.getInstance().moveCharacter(target, locx, locy, mapid);
				
				pc.sendPackets(new S_SystemMessage(String.format("Offline Character '%s' Moved To: %s, %d, %d.",
								target.getName(), locx, locy, mapid)));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <player> <x> <y> <mapid> or .%1$s <player> \"<location name>\"", cmdName)));
		}
	}
}
