package l1j.server.server.command.executor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Npc;

// this command disables the buy/sell option for all shops or specific shops if
// the npc name is specified
public class L1ToggleShop implements L1CommandExecutor {
	class ShopStatus {
		public boolean DisableBuy = false;
		public boolean DisableSell = false;
		
		public ShopStatus(boolean disableBuy, boolean disableSell) {
			this.DisableBuy = disableBuy;
			this.DisableSell = disableSell;
		}
		
		public ShopStatus(String type, boolean disabled) {
			SetShopStatus(type, disabled);
		}
		
		public void SetShopStatus(String type, boolean disabled) {
			if(type.toLowerCase().equals("buy"))
				this.DisableBuy = disabled;
			else
				this.DisableSell = disabled;
		}
	}
	
	private static HashMap<Integer, ShopStatus> disabledNpcs = new HashMap<Integer, ShopStatus>();
	private static boolean allBuyDisabled = false;
	private static boolean allSellDisabled = false;
	
	private static String[] commandMessage = {
			".toggleshop <npcid> <buy/sell> <on/off> or ",
			".toggleshop <buy/sell> <on/off> or ",
			".toggleshop status"
	};
	
	private L1ToggleShop() { }

	public static L1CommandExecutor getInstance() {
		return new L1ToggleShop();
	}
	
	public static boolean IsBuyDisabled(int npcId){
		if(allBuyDisabled)
			return true;
		
		return disabledNpcs.containsKey(npcId) && disabledNpcs.get(npcId).DisableBuy;
	}
	
	public static boolean IsSellDisabled(int npcId){
		if(allSellDisabled)
			return true;
		
		return disabledNpcs.containsKey(npcId) && disabledNpcs.get(npcId).DisableSell;
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			String[] args = arg.split(" ");
			
			String buySell = "";
			String onOff = "";
			String npcName = "";
			
			if(args.length == 1 && args[0].toLowerCase().equals("status")) {
				if(allBuyDisabled)
					pc.sendPackets(new S_SystemMessage("\\fYAll buy shops currently disabled."));
				
				if(allSellDisabled)
					pc.sendPackets(new S_SystemMessage("\\fYAll sell shops currently disabled."));
				
				if(!allBuyDisabled && !allSellDisabled) {
					if(disabledNpcs.isEmpty()) {
						pc.sendPackets(new S_SystemMessage("\\fTAll shops are actively buying and selling."));
					} else {
						Iterator<Entry<Integer, ShopStatus>> shops = disabledNpcs.entrySet().iterator();
					    while (shops.hasNext()) {
					        Entry<Integer, ShopStatus> shop = shops.next();
					        
					        L1Npc npc = NpcTable.getInstance().getTemplate(shop.getKey());
					        pc.sendPackets(new S_SystemMessage(String.format("%s: %s. %s.",
					        		npc.get_name(), 
					        		shop.getValue().DisableBuy ? "\\fYB: Disabled" : "\\fTB: Enabled",
					        				shop.getValue().DisableSell ? "\\fYS: Disabled" : "\\fTS: Enabled")));
					    } //end while
					} //end if disabledNpc is empty
				} //end if buy/sell all disabled
			    
			    return;
			}
			else if(args.length == 2) { //disable/enable all shops
				buySell = args[0].toLowerCase();
				onOff = args[1].toLowerCase();
			} else {
				npcName = args[0];
				buySell = args[1].toLowerCase();
				onOff = args[2].toLowerCase();
			}
			
			if((!buySell.equals("buy") && !buySell.equals("sell")) || (!onOff.equals("on") && !onOff.equals("off")))
				throw new Exception();
			
			boolean disabled = onOff.equals("off");
			
			if(!npcName.equals("")) {
				int npcId = NpcTable.getInstance().findNpcIdByNameCaseInsensitiveWithoutSpace(npcName.replace(" ", ""));
				L1Npc npc = NpcTable.getInstance().getTemplate(npcId);

				if(npc == null) {
					pc.sendPackets(new S_SystemMessage("No Npc with the name '" + npcName + "' found."));
					return;
				}
				
				if(disabledNpcs.containsKey(npcId))
					disabledNpcs.get(npcId).SetShopStatus(buySell, disabled);
				else if(disabled) //if they're enabling something that is already enabled, ignore
					disabledNpcs.put(npcId, new ShopStatus(buySell, disabled));
				
				ShopStatus shop = disabledNpcs.get(npcId);
				if(!shop.DisableBuy && !shop.DisableSell)
					disabledNpcs.remove(npcId);
				
				pc.sendPackets(new S_SystemMessage(
						String.format("NPC '%s' %s shop %s.",
								npc.get_name(), buySell,
								disabled ? "\\fYdisabled" : "\\fTenabled")));
			} else {
				if(buySell.equals("buy"))
					allBuyDisabled = disabled;
				else
					allSellDisabled = disabled;
				
				// if we have set all shops to enabled or disabled, then make sure we switch all
				// the npcs we set intially, and clear them out if they are no longer disabled at all
				Iterator<Entry<Integer, ShopStatus>> shops = disabledNpcs.entrySet().iterator();
			    while (shops.hasNext()) {
			        Entry<Integer, ShopStatus> shop = shops.next();
			        shop.getValue().SetShopStatus(buySell, disabled);
			        
			        if(!shop.getValue().DisableBuy && !shop.getValue().DisableSell)
			        	shops.remove();
			    } //end while
				
				pc.sendPackets(new S_SystemMessage(String.format("All %s shops have been %s.",
						buySell,
						disabled ? "disabled" : "enabled")));
			} //end if
		} catch (Exception e) {
			for(int i = 0; i < commandMessage.length; i++)
				pc.sendPackets(new S_SystemMessage(commandMessage[i]));
		}
	}
}
