package l1j.server.server.command.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CustomBoardRead;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1ScanArea implements L1CommandExecutor {
	public static L1ScanArea getInstance() {
		return new L1ScanArea();
	}

	@Override
	// right now only does mobs, but may extend it to show visible players
	// or visible items on ground, etc.
	public void execute(L1PcInstance pc, String cmdName, String scanType) {
		scanType = scanType.toLowerCase();
		try {
			if(scanType.equals("-mob")) {
				HashMap<Integer, ArrayList<String>> visibleMobs = new HashMap<Integer, ArrayList<String>>();
				
				// find all unique mobs and add them to the arraylist
				for(L1Object visibleObject : L1World.getInstance().getVisibleObjects(pc)) {
					if(visibleObject instanceof L1MonsterInstance) {
						L1MonsterInstance mobInstance = (L1MonsterInstance)visibleObject;
						
						if(!visibleMobs.containsKey(mobInstance.getNpcTemplate().get_npcId())) {
							visibleMobs.put(mobInstance.getNpcTemplate().get_npcId(), 
									new ArrayList<String>(
											Arrays.asList(mobInstance.getName(),
													"" + mobInstance.getLevel())));
						}
					}
				}
				
				// order the list alphabetically
				Set<Entry<Integer, ArrayList<String>>> set = visibleMobs.entrySet();
		        List<Entry<Integer, ArrayList<String>>> list = new ArrayList<Entry<Integer, ArrayList<String>>>(set);
		        
				Collections.sort(list, new Comparator<Map.Entry<Integer, ArrayList<String>>>()
		        {
					public int compare(Entry<Integer, ArrayList<String>> o1, Entry<Integer, ArrayList<String>> o2) {
						return o1.getValue().get(0).compareTo(o2.getValue().get(0));
					}
		        } );
				
				StringBuilder message = new StringBuilder();
				
				for(Map.Entry<Integer, ArrayList<String>> entry : list){
					message.append(String.format("%s\nLevel: %s, Template Id: %s\n\n",
							entry.getValue().get(0),
							entry.getValue().get(1),
							entry.getKey()));;
		        }
				
				pc.sendPackets(new S_CustomBoardRead("Scan Results", 
						pc.getName(), message.toString()));
				
				return;
			}
			
			throw new Exception();
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage(".scan -mob"));
		}
	}
}
