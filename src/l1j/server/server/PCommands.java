package l1j.server.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Database.L1DatabaseFactory;
import l1j.server.config.Config;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Skills;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// ClientThread, Shutdown, IpTable, MobTable,
// PolyTable, IdFactory
//

public class PCommands {
	private static Logger _log = Logger.getLogger(PCommands.class.getName());
	boolean spawnTF = false;
	private static PCommands _instance;

	private PCommands() {
	}

	public static PCommands getInstance() {
		if (_instance == null) {
			_instance = new PCommands();
		}
		return _instance;
	}

	public void handleCommands(L1PcInstance _player, String cmd2) {
		
		try {
			if (cmd2.equalsIgnoreCase("help")) {
				showPHelp(_player);
			} else if (cmd2.startsWith("buff")) {
				pbuff(_player);
			} else if (cmd2.startsWith("warp")) {
				warp(_player, cmd2);
			} else if (cmd2.startsWith("pbuff")){
				powerBuff(_player);
			} else if(cmd2.startsWith("bug")){
				reportBug(_player, cmd2);
			} else if(cmd2.startsWith("karma")){
				checkKarma(_player);
			}
			_log.info(_player.getName() + " used " + cmd2);
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

public void showPHelp(L1PcInstance _player){
	if (Config.PLAYER_BUFF == true && Config.PLAYER_COMMANDS == true)
		_player.sendPackets(new S_SystemMessage("-warp 1-7, -karma, -buff, -bug, -help"));
	else
		_player.sendPackets(new S_SystemMessage("-warp 1-7, -karma, -bug, -help"));
		
}

public void pbuff(L1PcInstance _player){
	int[] skillZ = {2, 3, 8, 14, 26, 42, 48, 34, 78};
	int time = 0;
	int a = 0;
	int skillId = 0;
	
	if (Config.PLAYER_BUFF == true && Config.PLAYER_COMMANDS == true){
		if(_player.getLevel() >= 45){
			for (a = 0; a <= 2; a++){
				skillId = skillZ[a]; 
	 
				L1Skills skill = SkillsTable.getInstance().getTemplate(skillId);
				if (skill.getTarget().equals("buff")) {
					new L1SkillUse().handleCommands(_player, skillId, _player.getId(), _player.getX(), _player.getY(), null, time, L1SkillUse.TYPE_SPELLSC);
				}
			}
		}
		if (_player.getLevel() >= 50){
			for (a = 0; a <= 5; a++){
				skillId = skillZ[a];
				L1Skills skill = SkillsTable.getInstance().getTemplate(skillId);
				if (skill.getTarget().equals("buff")) {
					new L1SkillUse().handleCommands(_player, skillId, _player.getId(), _player.getX(), _player.getY(), null, time,
							L1SkillUse.TYPE_SPELLSC);
				}
			}
		}
		if (_player.getLevel() >= 55){
			for (a = 0; a <= 7; a++){
				skillId = skillZ[a];
				L1Skills skill = SkillsTable.getInstance().getTemplate(skillId);
				if (skill.getTarget().equals("buff")) {
					new L1SkillUse().handleCommands(_player, skillId, _player.getId(), _player.getX(), _player.getY(), null, time,
							L1SkillUse.TYPE_SPELLSC);
				}
			}
		}
		if (_player.getLevel() >= 60){
			for (a = 0; a <= 9; a++){
				skillId = skillZ[a]; 
		 
				L1Skills skill = SkillsTable.getInstance().getTemplate(skillId);
				if (skill.getTarget().equals("buff")) {
					new L1SkillUse().handleCommands(_player, skillId, _player.getId(), _player.getX(), _player.getY(), null, time,
							L1SkillUse.TYPE_SPELLSC);
				}
			}
		}
	} else{
		_player.sendPackets(new S_SystemMessage("You must be lvl 45 to use this command."));
	}	
}

public void powerBuff(L1PcInstance _player){
	int[] skillZ = {2, 14, 26, 42, 43, 48, 54, 55, 68, 78, 79, 149, 151, 155, 158};
	int time = 0;
	int a = 0;
	int skillId = 0;
	if (Config.POWER_BUFF == true && Config.PLAYER_COMMANDS == true){
		for (a = 0; a <= 14; a++){
			skillId = skillZ[a]; 
			L1Skills skill = SkillsTable.getInstance().getTemplate(skillId);
			if (skill.getTarget().equals("buff")) {
				new L1SkillUse().handleCommands(_player, skillId, _player.getId(), _player.getX(), _player.getY(), null, time,
				L1SkillUse.TYPE_SPELLSC);
			}
		}
	}else if (Config.PLAYER_COMMANDS == true && !Config.POWER_BUFF == true){
		_player.sendPackets(new S_SystemMessage("Power Buff is currently disabled!"));
	}
}

public void warp(L1PcInstance _player, String cmd2) {
	if(!Config.WARP) {
		_player.sendPackets(new S_SystemMessage("The -warp command is not avaliable on this server."));
		return;
	}
	
	if (!_player.getLocation().getMap().isEscapable())
	{
		_player.sendPackets(new S_SystemMessage("The -warp command is not avaliable in this area."));
		return;
	}
	
	if (_player.isParalyzed() == false && _player.isPinkName() == false && _player.isSleeped() == false
			&& _player.isDead() == false && _player.getMapId() != 99) {
		try {
			String s1 = cmd2.substring(5);
			int i = Integer.parseInt(s1);
			int delaytimer = 30; 
			if (i >= 1 && i <= 7 ) {
				delaytimer *= 100;
				switch (i){
				//Pandora	
					case 1: 
							Thread.sleep(delaytimer);
							L1Teleport.teleport(_player, 32644, 32955, (short) 0, 5, false);
							break;
							//Pandora
					case 2:
							Thread.sleep(delaytimer);
							L1Teleport.teleport(_player, 33080, 33392, (short) 4, 5, false);
							break;
							//SKT
					case 3:
							Thread.sleep(delaytimer);
							L1Teleport.teleport(_player, 33442, 32797, (short) 4, 5, false);
							break;
							//Giran
					case 4:
							Thread.sleep(delaytimer);
							L1Teleport.teleport(_player, 33705, 32504, (short) 4, 5, false);
							break;
							//Weldern
					case 5:
							Thread.sleep(delaytimer);
							L1Teleport.teleport(_player, 34061, 32276, (short) 4, 5, false);
							break;
							//Oren
					case 6:
							Thread.sleep(delaytimer);
							L1Teleport.teleport(_player, 32715, 32448, (short) 4, 5, false);
							break;
							//Orc Town
					case 7:
							Thread.sleep(delaytimer);
							L1Teleport.teleport(_player, 32857, 32898, (short) 304, 5, false);
							//Silent Cave
					}
			} else {
					_player.sendPackets(new S_SystemMessage("Warp 1-7 only."));
			}
		} catch (Exception exception) {
				_player.sendPackets(new S_SystemMessage("-warp 1-Pandora, 2-SKT, 3-Giran, 4-Werldern, 5-Oren, 6-Orc Town, 7-Silent Cavern"));
		}
	} else{
		_player.sendPackets(new S_SystemMessage("You cannot warp in your current state."));
	}
}

private void reportBug(L1PcInstance pc, String bug){
	Connection con = null;
	PreparedStatement pstm = null;
	try {
		bug = bug.substring(3).trim();
		if(bug.equals("")) {
			pc.sendPackets(new S_SystemMessage(".bug bugReport"));
			return;
		}
		con = L1DatabaseFactory.getInstance().getConnection();
		pstm = con.prepareStatement("INSERT INTO bugs (bugtext, charname, mapID, mapX, mapY, resolved) VALUES (?, ?, ?, ?, ?, 0);");
		pstm.setString(1, bug);
		pstm.setString(2, pc.getName());
		pstm.setInt(3, pc.getMapId());
		pstm.setInt(4, pc.getX());
		pstm.setInt(5, pc.getY());
		pstm.execute();
		pc.sendPackets(new S_SystemMessage("Bug reported. Thank you for your help!"));
	} catch (Exception e) {
		pc.sendPackets(new S_SystemMessage("Could not report bug: ('"+bug+"', '"+pc.getName()+"', "+pc.getMapId()+", "+pc.getX()+", "+pc.getY()+");"));
		e.printStackTrace();
	} finally {
		SQLUtil.close(pstm);
		SQLUtil.close(con);
	}
}

private void checkKarma(L1PcInstance pc){
	pc.sendPackets(new S_SystemMessage("Your karma is currently: " + pc.getKarma()));

}
}
