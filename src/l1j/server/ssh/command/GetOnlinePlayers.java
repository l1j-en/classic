package l1j.server.ssh.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.classes.L1ClassId;

class GetOnlinePlayers implements Commands {
	@Override
	public String execute(String args) {
		try{
			boolean separateShops = Boolean.parseBoolean(args);
			
			HashMap<String, Integer> chars = new HashMap<String, Integer>();
			HashMap<String, Integer> shopChars = new HashMap<String, Integer>();
			
			for (L1PcInstance player : L1World.getInstance().getAllPlayers()) {
				String playerClass = L1ClassId.getClass(player.getClassId());
				
				if (player.isPrivateShop() && separateShops) {
					int currentCount = shopChars.get(playerClass) == null ? 0 : shopChars.get(playerClass);
					shopChars.put(playerClass, currentCount + 1);
				} else {
					int currentCount = chars.get(playerClass) == null ? 0 : chars.get(playerClass);
					chars.put(playerClass, currentCount + 1);
				}
			}
			
			// convert it to JSON and return it
			StringBuilder json = new StringBuilder("{\n\"Players\": {\n");
			
			Iterator<Entry<String, Integer>> it = chars.entrySet().iterator();
			String separator = "";
		    while (it.hasNext()) {
		        Map.Entry<String, Integer> gameClass = it.next();
		        json.append(separator + "\"" + gameClass.getKey() + "\":" + gameClass.getValue());
		        it.remove();
		        separator = ",\n";
		    }
		    
		    json.append("\n},\n\"Shops\": {\n");
		    
		    it = shopChars.entrySet().iterator();
		    separator = "";
		    while (it.hasNext()) {
		        Map.Entry<String, Integer> gameClass = it.next();
		        json.append(separator + "\"" + gameClass.getKey() + "\":" + gameClass.getValue());
		        it.remove();
		        separator = ",\n";
		    }
			
			json.append("\n}\n}");
			
			return json.toString();
		} catch(Exception ex) {
			return "getonlineplayers <optional separateShops>";
		}
	}

	public String formatMessage(String args) {
                return "GetOnlinePlayers with separateShops = " + args;
        }
}