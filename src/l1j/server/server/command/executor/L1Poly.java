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

import l1j.server.server.datatables.PolyTable;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_RawStringDialog;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Poly implements L1CommandExecutor {

	private L1Poly() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Poly();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			List<String> args = new ArrayList<String>();
			Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(arg);
			
			while (m.find())
				args.add(m.group(1).replace("\"", ""));

			L1PcInstance target = pc;
			String char_name = pc.getName();
			
			//if they passed both values, get the user they passed
			if (args.size() == 2){
				char_name = args.get(0);
				target = L1World.getInstance().getPlayer(char_name);
			}
			
			String polyIdOrName = args.get(args.size() == 2 ? 1 : 0);

			if (target == null) {
				pc.sendPackets(new S_ServerMessage(73, char_name));
			} else {
				try {
					try{
						// if this succeeds, they entered a number and we should try to
						// morph them
						int polyId = Integer.parseInt(polyIdOrName);
						L1PolyMorph.doPoly(target, polyId, 7200,
								L1PolyMorph.MORPH_BY_GM);
					} catch(NumberFormatException nfe){
						// if it fails, it wasn't a number, so lets assume it is a name
						// look up the name and see if we can morph them
						TreeMap<String, L1PolyMorph> polymorphs
						= new TreeMap<String, L1PolyMorph>(String.CASE_INSENSITIVE_ORDER);
						polymorphs.putAll(PolyTable.getInstance().getAllPolymorphs());
						
						// if it is an exact match, then we don't need to do anything else
						if(polymorphs.containsKey(polyIdOrName)){
							L1PolyMorph.doPoly(target, polymorphs.get(polyIdOrName).getId(), 7200,
									L1PolyMorph.MORPH_BY_GM);
						} else {
							// if it isn't, then display any matches that are close
							List<String> possibleMorphs = new ArrayList<String>();
							
							// split based on spaces and search for each word
							// this also allows them to enter "dea" for death knight and it 
							// will give all possible morphs
							String[] splitMorphName = polyIdOrName.split(" ");
							
							if(splitMorphName.length > 0){
								for(String name : splitMorphName){
									for(Map.Entry<String,L1PolyMorph> entry : polymorphs.entrySet()) {
										String key = entry.getKey();
									    if(key.toLowerCase().contains(name.toLowerCase())){
										  possibleMorphs.add(key);
									    }
									}
								}
							}
							
							if(possibleMorphs.isEmpty())
								possibleMorphs.add(
										String.format("No morphs found matching \"%s\". "
												+ "Try searching on just the first few characters or wrapping multi-word morphs in quotes.",
												polyIdOrName));
							
							pc.sendPackets(new S_RawStringDialog(pc.getId(), 
									"Polymorph not found. Did you mean?", Joiner.on(", ").join(possibleMorphs)));
						}
					}
				} catch (Exception exception) {
					pc.sendPackets(new S_SystemMessage(
							String.format(".%1$s <player> <poldId or \"name\"> or .%1$s <poldId or \"name\">", cmdName)));
				}
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <player> <poldId or \"name\"> or .%1$s <poldId or \"name\">", cmdName)));
		}
	}
}
