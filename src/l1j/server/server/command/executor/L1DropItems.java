package l1j.server.server.command.executor;

import l1j.server.Config;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

// this command toggles whether users can drop items on the ground or not.
// it does NOT affect if they can drop items when they die
public class L1DropItems implements L1CommandExecutor {
	private static String commandMessage = ".dropitems [on|off].";
	private L1DropItems() { }

	public static L1CommandExecutor getInstance() {
		return new L1DropItems();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		boolean currentlyStopped = Config.STOP_DROP;
		String currentStatusMessage = "Currently Drops are: "
				+ (currentlyStopped ? "Disabled" : "Enabled");
		
		try {
			String[] args = arg.split(" ");
			
			String argumentValue = args[0].toLowerCase();
			
			if(!argumentValue.equals("on") && !argumentValue.equals("off")
					|| (args.length == 2 && !args[1].equalsIgnoreCase("broadcast"))) {
				pc.sendPackets(new S_SystemMessage(commandMessage));
				pc.sendPackets(new S_SystemMessage(currentStatusMessage));
				
				return;
			}	
			
			boolean stopDrop = argumentValue.equalsIgnoreCase("off");
			
			// if it has already been set, don't set it again.
			if((stopDrop && currentlyStopped) || (!stopDrop && !currentlyStopped)) {
				pc.sendPackets(new S_SystemMessage("\\fRDropping Items Is Already " + 
						(stopDrop ? "Disabled" : "Enabled") + "!"));
				
				return;
			}
			
			Config.setParameterValue("DropItems", Boolean.toString(stopDrop));
			
			pc.sendPackets(new S_SystemMessage("Dropping items has been " + (stopDrop ? "Disabled" : "Enabled")));

		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(commandMessage));
			pc.sendPackets(new S_SystemMessage(currentStatusMessage));
		}
	}
}
