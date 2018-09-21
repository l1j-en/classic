/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.clientpackets;

import java.util.List;

import l1j.server.Config;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1War;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_War extends ClientBasePacket {
	private static final String C_WAR = "[C] C_War";

	public C_War(byte abyte0[], Client client) throws Exception {
		super(abyte0);
		int type = readC();
		String s = readS();

		L1PcInstance player = client.getActiveChar();
		String playerName = player.getName();
		String clanName = player.getClanname();
		int clanId = player.getClanid();

		if (!player.isCrown()) {
			player.sendPackets(new S_ServerMessage(478));
			return;
		}
		if (clanId == 0) {
			player.sendPackets(new S_ServerMessage(272));
			return;
		}
		L1Clan clan = L1World.getInstance().getClan(clanName);
		if (clan == null) {
			return;
		}
		if (player.getId() != clan.getLeaderId()) {
			player.sendPackets(new S_ServerMessage(478));
			return;
		}
		if (clanName.toLowerCase().equals(s.toLowerCase())) {
			return;
		}

		L1Clan enemyClan = null;
		String enemyClanName = null;
		for (L1Clan checkClan : L1World.getInstance().getAllClans()) {
			if (checkClan.getClanName().toLowerCase().equals(s.toLowerCase())) {
				enemyClan = checkClan;
				enemyClanName = checkClan.getClanName();
				break;
			}
		}
		if (enemyClan == null) {
			return;
		}
		boolean inWar = false;
		List<L1War> warList = L1World.getInstance().getWarList();
		for (L1War war : warList) {
			if (war.CheckClanInWar(clanName)) {
				if (type == 0) {
					player.sendPackets(new S_ServerMessage(234));
					return;
				}
				inWar = true;
				break;
			}
		}
		if (!inWar && (type == 2 || type == 3)) {
			return;
		}
		if (clan.getCastleId() != 0) {
			if (type == 0) {
				player.sendPackets(new S_ServerMessage(474));
				return;
			} else if (type == 2 || type == 3) {
				return;
			}
		}
		if (enemyClan.getCastleId() == 0 && player.getLevel() <= 15) {
			player.sendPackets(new S_ServerMessage(232));
			return;
		}
		if (enemyClan.getCastleId() != 0 && player.getLevel() < 25) {
			player.sendPackets(new S_ServerMessage(475));
			return;
		}
		
		if(enemyClan.getCastleId() != 0) {
			L1PcInstance[] clanMembersOnline = player.getClan().getOnlineClanMember();
			
			int onlineMeetingLevelReq = 0;
			
			for(L1PcInstance member : clanMembersOnline) {
				if(member.getLevel() >= Config.CASTLE_WAR_MIN_PRINCE_LEVEL
						&& member.getId() != player.getId()) {
					onlineMeetingLevelReq++;
				}
			}
			
			if(player.getLevel() < Config.CASTLE_WAR_MIN_PRINCE_LEVEL ||
					onlineMeetingLevelReq < Config.CASTLE_WAR_MIN_MEMBERS_ONLINE) {
				player.sendPackets(new S_SystemMessage("\\fYCannot declare war on a castle pledge because: "));
				
				if(player.getLevel() < Config.CASTLE_WAR_MIN_PRINCE_LEVEL) {
					player.sendPackets(new S_SystemMessage(String.format("\\fY  You are not above level %d.",
							Config.CASTLE_WAR_MIN_PRINCE_LEVEL)));
				}
				
				if(onlineMeetingLevelReq < Config.CASTLE_WAR_MIN_MEMBERS_ONLINE) {
					player.sendPackets(new S_SystemMessage(String.format("\\fY  You must have %d " +
							"members online above level %d.", 
							Config.CASTLE_WAR_MIN_MEMBERS_ONLINE,
							Config.CASTLE_WAR_MIN_MEMBERS_LEVEL)));
				}
				
				return;
			}
		}
		
		if (enemyClan.getCastleId() != 0) {
			int castle_id = enemyClan.getCastleId();
			if (WarTimeController.getInstance().isNowWar(castle_id)) {
				L1PcInstance clanMember[] = clan.getOnlineClanMember();
				for (int k = 0; k < clanMember.length; k++) {
					if (L1CastleLocation.checkInWarArea(castle_id,
							clanMember[k])) {
						player.sendPackets(new S_ServerMessage(477));
						return;
					}
				}
				boolean enemyInWar = false;
				for (L1War war : warList) {
					if (war.CheckClanInWar(enemyClanName)) {
						if (type == 0) {
							war.DeclareWar(clanName, enemyClanName);
							war.AddAttackClan(clanName);
						} else if (type == 2 || type == 3) {
							if (!war.CheckClanInSameWar(clanName, enemyClanName)) {
								return;
							}
							if (type == 2) {
								war.SurrenderWar(clanName, enemyClanName);
							} else if (type == 3) {
								war.CeaseWar(clanName, enemyClanName);
							}
						}
						enemyInWar = true;
						break;
					}
				}
				if (!enemyInWar && type == 0) {
					L1War war = new L1War();
					war.handleCommands(1, clanName, enemyClanName);
				}
			} else {
				if (type == 0) {
					player.sendPackets(new S_ServerMessage(476));
				}
			}
		} else {
			boolean enemyInWar = false;
			for (L1War war : warList) {
				if (war.CheckClanInWar(enemyClanName)) {
					if (type == 0) {
						player.sendPackets(new S_ServerMessage(236,
								enemyClanName));
						return;
					} else if (type == 2 || type == 3) {
						if (!war.CheckClanInSameWar(clanName, enemyClanName)) {
							return;
						}
					}
					enemyInWar = true;
					break;
				}
			}
			if (!enemyInWar && (type == 2 || type == 3)) {
				return;
			}

			L1PcInstance enemyLeader = L1World.getInstance().getPlayer(
					enemyClan.getLeaderName());

			if (enemyLeader == null) {
				player.sendPackets(new S_ServerMessage(218, enemyClanName));
				return;
			}
			if (type == 0) {
				enemyLeader.setTempID(player.getId());
				enemyLeader.sendPackets(new S_Message_YN(217, clanName,
						playerName));
			} else if (type == 2) {
				enemyLeader.setTempID(player.getId());
				enemyLeader.sendPackets(new S_Message_YN(221, clanName));
			} else if (type == 3) {
				enemyLeader.setTempID(player.getId());
				enemyLeader.sendPackets(new S_Message_YN(222, clanName));
			}
		}
	}

	@Override
	public String getType() {
		return C_WAR;
	}
}