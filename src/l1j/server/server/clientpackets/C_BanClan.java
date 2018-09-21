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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_BanClan extends ClientBasePacket {

	private static final String C_BAN_CLAN = "[C] C_BanClan";
	private static Logger _log = LoggerFactory.getLogger(C_BanClan.class.getName());

	public C_BanClan(byte abyte0[], Client client) throws Exception {
		super(abyte0);
		String s = readS();

		L1PcInstance pc = client.getActiveChar();
		L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
		if (clan != null) {
			String clanMemberName[] = clan.getAllMembers();
			int i;
			if (pc.isCrown() && pc.getId() == clan.getLeaderId()) {
				for (i = 0; i < clanMemberName.length; i++) {
					if (pc.getName().toLowerCase().equals(s.toLowerCase())) {
						return;
					}
				}
				L1PcInstance tempPc = L1World.getInstance().getPlayer(s);
				if (tempPc != null) {
					if (tempPc.getClanid() == pc.getClanid()) {
						tempPc.setClanid(0);
						tempPc.setClanname("");
						tempPc.setClanRank(0);
						tempPc.save();
						clan.delMemberName(tempPc.getName());
						tempPc.sendPackets(new S_ServerMessage(238, pc
								.getClanname()));
						pc.sendPackets(new S_ServerMessage(240, tempPc
								.getName()));
					} else {
						pc.sendPackets(new S_ServerMessage(109, s));
					}
				} else {
					try {
						L1PcInstance restorePc = CharacterTable.getInstance()
								.restoreCharacter(s);
						if (restorePc != null
								&& restorePc.getClanid() == pc.getClanid()) {
							restorePc.setClanid(0);
							restorePc.setClanname("");
							restorePc.setClanRank(0);
							restorePc.save();
							clan.delMemberName(restorePc.getName());
							pc.sendPackets(new S_ServerMessage(240, restorePc
									.getName()));
						} else {
							pc.sendPackets(new S_ServerMessage(109, s));
						}
					} catch (Exception e) {
						_log.error(e.getLocalizedMessage(), e);
					}
				}
			} else {
				pc.sendPackets(new S_ServerMessage(518));
			}
		}
	}

	@Override
	public String getType() {
		return C_BAN_CLAN;
	}
}