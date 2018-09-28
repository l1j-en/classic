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

import l1j.server.Config;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_Message_YN;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.FaceToFace;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_JoinClan extends ClientBasePacket {

	private static final String C_JOIN_CLAN = "[C] C_JoinClan";

	public C_JoinClan(byte abyte0[], Client client)
			throws Exception {
		super(abyte0);

		L1PcInstance pc = client.getActiveChar();
		if (pc.isGhost()) {
			return;
		}

		L1PcInstance target = FaceToFace.faceToFace(pc);
		if (target != null) {
			JoinClan(pc, target);
		}
	}

	private void JoinClan(L1PcInstance player, L1PcInstance target) {
		if (!target.isCrown()) {
			player.sendPackets(new S_ServerMessage(92, target.getName()));
			return;
		}

		int clan_id = target.getClanid();
		String clan_name = target.getClanname();
		if (clan_id == 0) {
			player.sendPackets(new S_ServerMessage(90, target.getName()));
			return;
		}

		L1Clan clan = L1World.getInstance().getClan(clan_name);
		if (clan == null) {
			return;
		}

		if (target.getId() != clan.getLeaderId()) {
			player.sendPackets(new S_ServerMessage(92, target.getName()));
			return;
		}
		
		if(player.getLastJoinedPledge() != -1) {
			long timeSince = System.currentTimeMillis() - player.getLastJoinedPledge();
			
			if(timeSince < Config.ALT_DAYS_LIMIT_PLEDGE_JOIN) {
				double timeLeft = Config.ALT_DAYS_LIMIT_PLEDGE_JOIN - timeSince;
				int days = (int) (Math.ceil(timeLeft / (1000*60*60*24)));
				player.sendPackets(new S_SystemMessage(String.format("You must wait %d day(s) before joining another pledge.", days)));
				return;
			}
		}

		if (player.getClanid() != 0) {
			if (player.isCrown()) {
				String player_clan_name = player.getClanname();
				L1Clan player_clan = L1World.getInstance().getClan(
						player_clan_name);

				if (player_clan == null) {
					return;
				}

				if (player.getId() != player_clan.getLeaderId()) {
					player.sendPackets(new S_ServerMessage(89));
					return;
				}

				if (player_clan.getCastleId() != 0
						|| player_clan.getHouseId() != 0) {
					player.sendPackets(new S_ServerMessage(665));
					return;
				}
			} else {
				player.sendPackets(new S_ServerMessage(89));
				return;
			}
		}
		target.setTempID(player.getId());
		target.sendPackets(new S_Message_YN(97, player.getName()));
	}

	@Override
	public String getType() {
		return C_JOIN_CLAN;
	}
}