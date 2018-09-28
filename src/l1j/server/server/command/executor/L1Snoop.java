package l1j.server.server.command.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_DeleteInventoryItem;
import l1j.server.server.serverpackets.S_InvList;
import l1j.server.server.serverpackets.S_RetrieveElfList;
import l1j.server.server.serverpackets.S_RetrieveList;
import l1j.server.server.serverpackets.S_RetrievePledgeList;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Snoop implements L1CommandExecutor {
	private static ArrayList<String> _types
		= new ArrayList<String>(Arrays.asList("inv", "storage", "estorage", "pstorage"));
	
	private static HashMap<L1PcInstance, List<L1ItemInstance>> _currentInventoryItems
		= new HashMap<L1PcInstance, List<L1ItemInstance>>();
	
	public L1Snoop() { }
	
	public static L1CommandExecutor getInstance() {
		return new L1Snoop();
	}
	
	public void execute(L1PcInstance pc, String cmdName, String arg) {		
		try {
			String args[] = arg.split(" ");
			
			if(args.length == 1 && args[0].trim().toLowerCase().equals("-revert")) {
				if(!_currentInventoryItems.containsKey(pc)) {
					pc.sendPackets(new S_SystemMessage("Hmm.. no revert info found. You'll have to restart."));
					return;
				}
				
				for(L1ItemInstance item : _currentInventoryItems.get(pc))
					pc.sendPackets(new S_DeleteInventoryItem(item));
				
				pc.sendPackets(new S_InvList(pc.getInventory().getItems()));
				_currentInventoryItems.remove(pc);
				pc.sendPackets(new S_SystemMessage("Inventory reverted."));
				
				return;
			} else if(args.length == 2) {
				String player = args[0].trim();
				String type = args[1].trim().toLowerCase();
				L1PcInstance playerInstance = L1World.getInstance().getPlayer(player);
				
				if(playerInstance == null) {
					pc.sendPackets(new S_SystemMessage(player + " is not online."));
					return;
				}
				
				if(!_types.contains(type))
					throw new Exception();
				
				if(type.equals("inv")) {
					// remove my own items from the inventory window
					List<L1ItemInstance> myItems = pc.getInventory().getItems();
					
					for(L1ItemInstance item : myItems)
						pc.sendPackets(new S_DeleteInventoryItem(item));
					
					pc.sendPackets(new S_InvList(playerInstance.getInventory().getItems()));
					
					// if they already snooped an inventory, clear that out before loading the new one
					if(_currentInventoryItems.containsKey(pc)) {
						for(L1ItemInstance item : _currentInventoryItems.get(pc))
							pc.sendPackets(new S_DeleteInventoryItem(item));
					}
					
					pc.sendPackets(new S_SystemMessage(String.format("Snooping %s's inventory.",
							playerInstance.getName())));
					
					// initialize/re-initialize the inventory list
					_currentInventoryItems.put(pc, new ArrayList<L1ItemInstance>());
					_currentInventoryItems.get(pc).addAll(playerInstance.getInventory().getItems());
				} else if (type.equals("storage")) {
					pc.sendPackets(new S_RetrieveList(pc.getId(), playerInstance));
					pc.sendPackets(new S_SystemMessage(String.format("Snooping %s's storage.",
							playerInstance.getName())));
				}  else if (type.equals("estorage")) {
					pc.sendPackets(new S_RetrieveElfList(pc.getId(), playerInstance));
					pc.sendPackets(new S_SystemMessage(String.format("Snooping %s's elven storage.",
							playerInstance.getName())));
				} else if (type.equals("pstorage")) {
					pc.sendPackets(new S_RetrievePledgeList(pc.getId(), playerInstance));
					pc.sendPackets(new S_SystemMessage(String.format("Snooping %s's pledge storage.",
							playerInstance.getName())));
				}	
				
				return;
			}
			
			throw new Exception();
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <player_name> <%2$s> or .%1$s -revert.", cmdName, join(_types,"/"))));
		}
	}
	
	private String join(List<String> list, String with) {
		StringBuilder result = new StringBuilder();
		for (String item : list) {
			if (result.length() > 0)
				result.append(with);

			result.append(item);
		}
		return result.toString();
	}
}
