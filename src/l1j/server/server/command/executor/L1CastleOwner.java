package l1j.server.server.command.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.ClanTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CastleMaster;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Castle;
import l1j.server.server.utils.SQLUtil;

public class L1CastleOwner implements L1CommandExecutor {
	public static L1CommandExecutor getInstance() {
		return new L1CastleOwner();
	}
	
	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		String[] args = arg.split(" ");
		
		try {
			String lowerCastle = args[0].toLowerCase();
			String append = "";
			
			if(lowerCastle.equals("diad") && lowerCastle.indexOf("fortress") == -1) {
				append = " fortress";
			} else if(lowerCastle.indexOf("castle") == -1) {
				append = " castle";
			}
			
			L1Castle castle = CastleTable.getInstance().getCastle(args[0] + append);
			
			// we only want to see who the current owner is!
			if(castle == null) {
				pc.sendPackets(new S_SystemMessage(String.format("No castle with name %s found. Try:", args[0])));
				pc.sendPackets(new S_SystemMessage("Aden,Diad,Dwarf,Giran,Heine,Kent,Orc,Windawood"));
				return;
			}
			
			if(args.length == 1) {
				L1Clan castleOwnerClan = L1World.getInstance().getClan(getCastleOwner(castle.getId()));
				
				if(castleOwnerClan == null) {
					pc.sendPackets(new S_SystemMessage(String.format("%s has no owner.", castle.getName())));
				} else {
					pc.sendPackets(new S_SystemMessage(String.format("%s's owner is %s.",
							castle.getName(), castleOwnerClan.getClanName())));
				}
			} else if(args.length == 2 && args[1].toLowerCase().equals("-set")) {
				pc.sendPackets(new S_SystemMessage("Use .castleowner <castle> -set -none, to remove a castle owner."));
			} else if(args.length == 3 && args[1].toLowerCase().equals("-set")) {
				String pledgeName = args[2].toLowerCase();
				
				String castleOwnerClanName = getCastleOwner(castle.getId());
				
				// just set the owner and return because a previous owner doesn't exist
				if(castleOwnerClanName == null) {
					// make sure the new clan exists
					String newOwnerClanName = getProperClanName(pledgeName);
					
					if(newOwnerClanName == null && !pledgeName.equals("-none")) {
						pc.sendPackets(new S_SystemMessage(String.format("No clan with name %s found.", pledgeName)));
						return;
					} else if(pledgeName.equals("-none")) {
						pc.sendPackets(new S_SystemMessage(String.format("%s is already vacant!", castle.getName())));
						return;
					}
					
					L1Clan newOwnerClan = L1World.getInstance().getClan(newOwnerClanName);
					newOwnerClan.setCastleId(castle.getId());
					ClanTable.getInstance().updateClan(newOwnerClan);
					
					L1PcInstance newOwner = L1World.getInstance().getPlayer(newOwnerClan.getLeaderName());
					
					if(newOwner != null) {
						newOwner.sendPackets(new S_CastleMaster(castle.getId(), newOwner.getId()));
						newOwner.broadcastPacket(new S_CastleMaster(castle.getId(), newOwner.getId()));
					}
					
					pc.sendPackets(new S_SystemMessage(String.format("%s is now the owner of %s!",
							newOwnerClan.getClanName(), castle.getName())));
					return;
				} else {
					// remove current owner and set the new one
					L1Clan castleOwnerClan = L1World.getInstance().getClan(castleOwnerClanName);
					L1PcInstance currentOwnerChar = L1World.getInstance().getPlayer(castleOwnerClan.getLeaderName());
					
					castleOwnerClan.setCastleId(0);
					ClanTable.getInstance().updateClan(castleOwnerClan);
					
					if(currentOwnerChar != null) {
						currentOwnerChar.sendPackets(new S_CastleMaster(0, currentOwnerChar.getId()));
						currentOwnerChar.broadcastPacket(new S_CastleMaster(0, currentOwnerChar.getId()));
						
						// remove the crown from the player -- need to send to the player that someone else owns the castle
						// or he will just keep the crown
						currentOwnerChar.sendPackets(new S_CastleMaster(castle.getId(), 12345));
						currentOwnerChar.broadcastPacket(new S_CastleMaster(castle.getId(), 12345));
						currentOwnerChar.sendPackets(new S_SystemMessage(String.format("%s has been taken from you by a GM!",
								castle.getName())));
					}
					
					// set new owner 
					String newOwnerClanName = getProperClanName(pledgeName);
					
					if(newOwnerClanName == null) {
						if(!pledgeName.equals("-none")) {
							pc.sendPackets(new S_SystemMessage(String.format("No clan with name %s found. %s is now vacant.",
									pledgeName, castle.getName())));
						} else {
							pc.sendPackets(new S_SystemMessage(String.format("%s is now vacant.", castle.getName())));
						}
						
						return;
					} 
					
					L1Clan newOwnerClan = L1World.getInstance().getClan(newOwnerClanName);
					newOwnerClan.setCastleId(castle.getId());
					ClanTable.getInstance().updateClan(newOwnerClan);
					
					L1PcInstance newOwner = L1World.getInstance().getPlayer(newOwnerClan.getLeaderName());
					
					if(newOwner != null) {
						newOwner.sendPackets(new S_CastleMaster(castle.getId(), newOwner.getId()));
						newOwner.broadcastPacket(new S_CastleMaster(castle.getId(), newOwner.getId()));
					}
					
					pc.sendPackets(new S_SystemMessage(String.format("%s is now the owner of %s!",
							newOwnerClan.getClanName(), castle.getName())));
				}
			} else {
				throw new Exception();
			}
		} catch(Exception ex) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <castle name> [[-set] <pledge name>]"));
		}
	}
	
	private String getProperClanName(String pledgeName) {
		pledgeName = pledgeName.toLowerCase();
		
		Collection<L1Clan> allClans = L1World.getInstance().getAllClans();
		L1Clan pledge = null;
		
		for(L1Clan clan : allClans) {
			if(clan.getClanName().toLowerCase().equals(pledgeName)) {
				pledge = L1World.getInstance().getClan(clan.getClanName());
				break;
			}	
		}
		
		if(pledge == null)
			return null;
		
		return pledge.getClanName();
	}
	
	private String getCastleOwner(int castleId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT clan_name FROM clan_data WHERE hasCastle = ?");
			pstm.setInt(1, castleId);
			rs = pstm.executeQuery();
			while (rs.next()) {		
				return rs.getString(1);
			}
			
			
		} catch(Exception ex) {
			
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		
		return null;
	}
}
