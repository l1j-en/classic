package l1j.server.server.command.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import l1j.server.server.datatables.AccessLevelTable;
import l1j.server.server.model.L1AccessLevel;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CustomBoardRead;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Promote implements L1CommandExecutor {
	private static final int FULL_GM = AccessLevelTable.getInstance().getMaxAccessLevel();
	
	public L1Promote() { }
	
	public static L1CommandExecutor getInstance() {
		return new L1Promote();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			arg = arg.trim().toLowerCase();
			
			if (arg.equals(""))
				throw new Exception();
			
			List<String> args = new ArrayList<String>();
			Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(arg);
			
			while (m.find())
				args.add(m.group(1).replace("\"", "").toLowerCase().trim());
			
			String playerName = args.get(0);
			
			// only give them access to access levels below their own
			ArrayList<L1AccessLevel> availableLevels = new ArrayList<L1AccessLevel>();
			for(L1AccessLevel level : AccessLevelTable.getInstance().getAllAccessLevels()) {
				if(level.getLevel() < pc.getAccessLevel().getLevel() || 
						pc.getAccessLevel().getLevel() == FULL_GM)
					availableLevels.add(level);
			}
			
			if(playerName.equals("-list")) {
				StringBuilder message = new StringBuilder();
				
				for(L1AccessLevel level : availableLevels)
					message.append(String.format("ID#: %d, %s (%d)\n",
							level.getId(), level.getName(), level.getLevel()));
					
				pc.sendPackets(new S_CustomBoardRead("Access Levels", 
						pc.getName(), message.toString()));
				
				return;
			}
			
			L1PcInstance target = L1World.getInstance().getPlayer(playerName);
			
			if(target == null) {
				pc.sendPackets(new S_SystemMessage(playerName + " is not online."));
				return;
			}
			
			if(target == pc) {
				pc.sendPackets(new S_SystemMessage("You cannot run ." + cmdName + " on yourself."));
				return;
			}
			
			String accessLevelIdOrName = args.get(1);
			L1AccessLevel levelToChangeTo = null;
			
			for(L1AccessLevel level : availableLevels) {
				if(Short.toString(level.getId()).equals(accessLevelIdOrName)
						|| level.getName().toLowerCase().equals(accessLevelIdOrName)) {
					levelToChangeTo = level;
					break;
				}
			}
			
			if(levelToChangeTo == null)
				throw new Exception();
			
			String promoteDemote = target.getAccessLevel().getLevel() > levelToChangeTo.getLevel() 
					? "demoted" : "promoted";
			
			target.setAccessLevel(levelToChangeTo);
			target.sendPackets(new S_SystemMessage(String.format("You have been %s to %s.",
					promoteDemote, levelToChangeTo.getName())));
			
			pc.sendPackets(new S_SystemMessage(String.format("%s has been %s to %s.",
					target.getName(), promoteDemote, levelToChangeTo.getName())));
			
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <player> \"<accesslevel id or name>\" [-list]"));
		}
	}
}
