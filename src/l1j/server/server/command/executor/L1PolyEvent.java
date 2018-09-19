package l1j.server.server.command.executor;

import l1j.server.Config;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1PolyEvent implements L1CommandExecutor {
	private static String commandMessage = ".polyevent [on|off] [optional \"broadcast\"].";
	private L1PolyEvent() { }

	public static L1CommandExecutor getInstance() {
		return new L1PolyEvent();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		boolean currentlyEnabled = Config.ALT_POLYEVENT;
		String currentStatusMessage = "Current Status is: "
				+ (currentlyEnabled ? "Enabled" : "Disabled");
		
		try {
			String[] args = arg.split(" ");
			
			String argumentValue = args[0].toLowerCase();
			boolean broadcast = args.length == 2 && args[1].equalsIgnoreCase("broadcast");
			
			if(!argumentValue.equals("on") && !argumentValue.equals("off")
					|| (args.length == 2 && !args[1].equalsIgnoreCase("broadcast"))) {
				pc.sendPackets(new S_SystemMessage(commandMessage));
				pc.sendPackets(new S_SystemMessage(currentStatusMessage));
				
				return;
			}	
			
			boolean enabled = argumentValue.equalsIgnoreCase("on");
			
			// if it has already been set, don't set it again.
			if((enabled && currentlyEnabled) || (!enabled && !currentlyEnabled)) {
				pc.sendPackets(new S_SystemMessage("\\fRPolymorph Event Already " + 
						(enabled ? "Enabled" : "Disabled") + "!"));
				
				return;
			}
			
			Config.setParameterValue("PolyEvent", Boolean.toString(enabled));
			
			pc.sendPackets(new S_SystemMessage("\\fRPolymorph Event " + 
						(enabled ? "Enabled" : "Disabled") + "!"));
			pc.sendPackets(new S_SystemMessage("\\fYIf you want this change to persist after"));
			pc.sendPackets(new S_SystemMessage("\\fYserver restart, be sure to update altsettings!"));
			
			// let everyone know about it?
			if(broadcast) {
				L1World world = L1World.getInstance();
				
				world.broadcastServerMessage("\\fR[******] Polymorph Event " +
				(enabled ? "Has Started. Enjoy!" : "Has Ended. Hope you had"));
				
				// couldn't think of a cleaner way to put this. Oh well.
				if(!enabled) {
					world.broadcastServerMessage("\\fR[******] fun!");
				}
			}

		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(commandMessage));
			pc.sendPackets(new S_SystemMessage(currentStatusMessage));
		}
	}
}
