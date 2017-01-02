package l1j.server.server.command.executor;

import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1GuardInstance;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1WipeOut implements L1CommandExecutor {
	private L1WipeOut() { }
	
	public static L1CommandExecutor getInstance() {
		return new L1WipeOut();
	}
	
	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		boolean includePlayers = arg.toLowerCase().equals("-players");
		
		for(L1Object object : L1World.getInstance().getVisibleObjects(pc)) {
			boolean killObject = object instanceof L1MonsterInstance ||
					object instanceof L1GuardInstance || 
					(includePlayers && object instanceof L1PcInstance && !((L1PcInstance)object).isGm());
			
			if(killObject) {
				if(object instanceof L1NpcInstance) {
					L1NpcInstance target = (L1NpcInstance)object;
					target.receiveDamage(null,  999999);
				} else if(object instanceof L1PcInstance) {
					L1PcInstance target = (L1PcInstance)object;
					target.setCurrentHp(0);
					target.death(null);
				}
				
			}
		}
		
		pc.sendPackets(new S_SystemMessage("The screen has been wiped!"));
	}
}
