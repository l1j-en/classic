package l1j.server.server.command.executor;

import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Follow implements L1CommandExecutor {
	public L1Follow() { }
	
	public static L1CommandExecutor getInstance() {
		return new L1Follow();
	}
	
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			String charName = arg.trim();
			
			if(charName.equals(""))
				throw new Exception();
			
			if(charName.toLowerCase().equals("-stop")) {
				// find all people the Gm is following and ensure we remove ourselves
				for(L1PcInstance player : L1World.getInstance().getAllPlayers()) {
					L1PcInstance followingGm = player.getFollowingGm();
					if(followingGm != null && followingGm == pc)
						player.setFollowingGm(null);
				}
				
				pc.sendPackets(new S_SystemMessage("Follow has been stopped."));
				return;
			}
			
			L1PcInstance target = L1World.getInstance().getPlayer(charName);
			if(target == null) {
				pc.sendPackets(new S_SystemMessage(charName + " is not online."));
				return;
			}
			
			L1PcInstance currentFollower = target.getFollowingGm();
			
			// find all other people the Gm is following and ensure we remove ourselves
			for(L1PcInstance player : L1World.getInstance().getAllPlayers()) {
				L1PcInstance followingGm = player.getFollowingGm();
				if(followingGm != null && followingGm == pc)
					player.setFollowingGm(null);
			}
			
			//TODO: if this gets used more, should probably allow more than 1 person to follow
			if(currentFollower != null) {
				currentFollower.sendPackets(new S_SystemMessage(
						String.format("%s has started following %s. That means you are not anymore.",
								pc.getName(), target.getName())));
			}
			
			target.setFollowingGm(pc);
			
			moveChar(target, pc);
			pc.sendPackets(new S_SystemMessage("You are now following " + target.getName() + "."));
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <player_name> or -stop"));
		}
	}
	
	public static void moveChar(L1PcInstance target, L1PcInstance gm) {
		boolean gapTooBig = !betweenExclusive(gm.getX(), target.getX() - 5, target.getX() + 5)
				|| !betweenExclusive(gm.getY(), target.getY() - 5, target.getY() + 5);
		
		if(target.getMapId() != gm.getMapId() || gapTooBig) {
			L1Teleport.teleport(gm, target.getX(), target.getY(),
					target.getMapId(), 5, false);
			return;
		} 
	}
	
	private static boolean betweenExclusive(int x, int min, int max)
    {
       return x > min && x < max;    
    }
}