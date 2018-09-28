package l1j.server.server.command.executor;

import java.util.Collection;

import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Pledge;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Pledge implements L1CommandExecutor {
	public L1Pledge() { }
	
	public static L1CommandExecutor getInstance() {
		return new L1Pledge();
	}
	
	public void execute(L1PcInstance pc, String cmdName, String arg) {		
		try {
			String pledgeName = arg.trim().toLowerCase();
			Collection<L1Clan> allClans = L1World.getInstance().getAllClans();
			L1Clan pledge = null;
			
			for(L1Clan clan : allClans) {
				if(clan.getClanName().toLowerCase().equals(pledgeName))
					pledge = clan;
			}
			
			if(pledge == null) {
				pc.sendPackets(new S_SystemMessage("The pledge '" + pledgeName + "' was not found."));
				return;
			}
			
			pc.sendPackets(new S_Pledge("pledgeM", pc.getId(), pledge
					.getClanName(), pledge.getOnlineMembersFPWithRank(), pledge
					.getAllMembersFPWithRank()));
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <pledge_name>"));
		}
	}
}
