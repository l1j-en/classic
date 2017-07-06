package l1j.server.server.command.executor;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_SystemMessage;

public class BotCheck implements L1CommandExecutor  {
	public static L1CommandExecutor getInstance() {
		return new BotCheck();
	}
	
	@Override
	public void execute(L1PcInstance user, String commandName, String arg) {
		try {
			String[] args = arg.split(" ");
			String target = args[0];
			int millis = 100;

			if(args.length > 1) {
				millis = Integer.parseInt(args[1]);
			}
					
			
			L1PcInstance player = L1World.getInstance().getPlayer(target);
			player.sendPackets(new S_OwnCharStatus(player, 50, 50));
			
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			player.sendPackets(new S_OwnCharStatus(player));
		} catch (Exception e) {
			e.printStackTrace();
			user.sendPackets(new S_SystemMessage(".botcheck <name> [optional ms]"));
		}
	}
}

