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

import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ClientThread;
import l1j.server.server.GMCommands;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.PCommands;
import l1j.server.server.datatables.ChatLogTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ChatPacket;
import l1j.server.server.serverpackets.S_NpcChatPacket;
import l1j.server.server.serverpackets.S_ServerMessage;
import static l1j.server.server.model.skill.L1SkillId.*;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_Chat extends ClientBasePacket {
	private static final String C_CHAT = "[C] C_Chat";
	private static Logger _log = Logger.getLogger(C_Chat.class.getName());

	public C_Chat(byte abyte0[], ClientThread clientthread) {
		super(abyte0);

		L1PcInstance pc = clientthread.getActiveChar();
		int chatType = readC();
		String chatText = readS();
		if (pc.hasSkillEffect(SILENCE) || pc.hasSkillEffect(AREA_OF_SILENCE) || pc.hasSkillEffect(STATUS_POISON_SILENCE)) {
			return;
		}
		if (pc.hasSkillEffect(1005)) { 
			pc.sendPackets(new S_ServerMessage(242)); 
			return;
		}
		if (chatType == 0) { 
			if (pc.isGhost() && !(pc.isGm() || pc.isMonitor())) {
				return;
			}
			if (chatText.startsWith(".")) {
				String cmd = chatText.substring(1);
				GMCommands.getInstance().handleCommands(pc, cmd);
				return;
			} else if (chatText.startsWith("-")) {
				String cmd = chatText.substring(1);
				PCommands.getInstance().handleCommands(pc, cmd);
				return;
			}
			if (chatText.startsWith("$")) {
				String text = chatText.substring(1);
				chatWorld(pc, text, 12);
				if (!pc.isGm()) {
					pc.checkChatInterval();
				}
				return;
			}
			// Cheap hack to fix shouting.  The client insists that ! chat is of chatType 0.
			// This is a (hopefully temporary) workaround that provides shouting via !!.
			if (chatText.startsWith("!")) {
				if (pc.isGhost()) {
					return;
				}
				chatText = chatText.substring(1, chatText.length());
				ChatLogTable.getInstance().storeChat(pc, null, chatText, chatType);
				S_ChatPacket s_chatpacket = new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_NPCSHOUT, 2);
				if (!pc.getExcludingList().contains(pc.getName())) {
					pc.sendPackets(s_chatpacket);
				}
				for (L1PcInstance listner : L1World.getInstance().getVisiblePlayer(pc, 50)) {
					if (!listner.getExcludingList().contains(pc.getName())) {
						listner.sendPackets(s_chatpacket);
					}
				}
				for (L1Object obj : pc.getKnownObjects()) {
					if (obj instanceof L1MonsterInstance) {
						L1MonsterInstance mob = (L1MonsterInstance) obj;
						// Added HP check to prevent dead doppels from talking.
						if (mob.getNpcTemplate().is_doppel() && mob.getName().equals(pc.getName()) && mob.getCurrentHp() > 0) {
							for (L1PcInstance listner : L1World.getInstance().getVisiblePlayer(mob, 50)) {
								listner.sendPackets(new S_NpcChatPacket(mob, chatText, 2));
							}
						}
					}
				}
				return;
			}

			ChatLogTable.getInstance().storeChat(pc, null, chatText,chatType);
			S_ChatPacket s_chatpacket = new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_NORMALCHAT, 0);
			
			if (!pc.getExcludingList().contains(pc.getName())) {
				pc.sendPackets(s_chatpacket);
			}
			for (L1PcInstance listner : L1World.getInstance().getRecognizePlayer(pc)) {
				if (listner.getMapId() > 10000 
						&& listner.getInnKeyId() != pc.getInnKeyId()) {
	              break; 
				} else if (!listner.getExcludingList().contains(pc.getName())) {
					listner.sendPackets(s_chatpacket);
				}
			}
			for (L1Object obj : pc.getKnownObjects()) {
				if (obj instanceof L1MonsterInstance) {
					L1MonsterInstance mob = (L1MonsterInstance) obj;
					// Added HP check to prevent dead doppels from talking.
					if (mob.getNpcTemplate().is_doppel() && mob.getName().equals(pc.getName()) && mob.getCurrentHp() > 0) {
						mob.broadcastPacket(new S_NpcChatPacket(mob, chatText, 0));
					}
				}
			}
		} else if (chatType == 2) { 
			if (pc.isGhost()) {
				return;
			}
			ChatLogTable.getInstance().storeChat(pc, null, chatText, chatType);
			S_ChatPacket s_chatpacket = new S_ChatPacket(pc, chatText,
					Opcodes.S_OPCODE_NORMALCHAT, 2);
			if (!pc.getExcludingList().contains(pc.getName())) {
				pc.sendPackets(s_chatpacket);
			}
			for (L1PcInstance listner : L1World.getInstance().getVisiblePlayer(
					pc, 50)) {
				if (listner.getMapId() > 10000
						&& listner.getInnKeyId() != pc.getInnKeyId()) {
					break;
				} else if (!listner.getExcludingList().contains(pc.getName())) {
					listner.sendPackets(s_chatpacket);
				}
			}

			for (L1Object obj : pc.getKnownObjects()) {
				if (obj instanceof L1MonsterInstance) {
					L1MonsterInstance mob = (L1MonsterInstance) obj;
					// Added HP check to prevent dead doppels from talking.
					if (mob.getNpcTemplate().is_doppel() && mob.getName().equals(pc.getName()) && mob.getCurrentHp() > 0) {
						for (L1PcInstance listner : L1World.getInstance().getVisiblePlayer(mob, 50)) {
							listner.sendPackets(new S_NpcChatPacket(mob, chatText, 2));
						}
					}
				}
			}
		} else if (chatType == 3) { 
			chatWorld(pc, chatText, chatType);
		} else if (chatType == 4) { 
			if (pc.getClanid() != 0) { 
				L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
				int rank = pc.getClanRank();
				if (clan != null && (rank == L1Clan.CLAN_RANK_PUBLIC || rank == L1Clan.CLAN_RANK_GUARDIAN || rank == L1Clan.CLAN_RANK_PRINCE)) {
					ChatLogTable.getInstance().storeChat(pc, null, chatText, chatType);
					S_ChatPacket s_chatpacket = new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_GLOBALCHAT, 4);
					L1PcInstance[] clanMembers = clan.getOnlineClanMember();
					for (L1PcInstance listner : clanMembers) {
						if (!listner.getExcludingList().contains(pc.getName())) {
							listner.sendPackets(s_chatpacket);
						}
					}
				}
			}
		} else if (chatType == 11) { 
			if (pc.isInParty()) { 
				ChatLogTable.getInstance().storeChat(pc, null, chatText, chatType);
				S_ChatPacket s_chatpacket = new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_GLOBALCHAT, 11);
				L1PcInstance[] partyMembers = pc.getParty().getMembers();
				for (L1PcInstance listner : partyMembers) {
					if (!listner.getExcludingList().contains(pc.getName())) {
						listner.sendPackets(s_chatpacket);
					}
				}
			}
		} else if (chatType == 12) { 
			chatWorld(pc, chatText, chatType);
		} else if (chatType == 13) {
			if (pc.getClanid() != 0) { 
				L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
				int rank = pc.getClanRank();
				if (clan != null && (rank == L1Clan.CLAN_RANK_GUARDIAN || rank == L1Clan.CLAN_RANK_PRINCE)) {
					ChatLogTable.getInstance().storeChat(pc, null, chatText, chatType);
					S_ChatPacket s_chatpacket = new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_GLOBALCHAT, 13);
					L1PcInstance[] clanMembers = clan.getOnlineClanMember();
					for (L1PcInstance listner : clanMembers) {
						int listnerRank = listner.getClanRank();
						if (!listner.getExcludingList().contains(pc.getName()) && (listnerRank == L1Clan.CLAN_RANK_GUARDIAN || listnerRank == L1Clan.CLAN_RANK_PRINCE)) {
							listner.sendPackets(s_chatpacket);
						}
					}
				}
			}
		} else if (chatType == 14) { 
			if (pc.isInChatParty()) { 
				ChatLogTable.getInstance().storeChat(pc, null, chatText, chatType);
				S_ChatPacket s_chatpacket = new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_NORMALCHAT, 14);
				L1PcInstance[] partyMembers = pc.getChatParty().getMembers();
				for (L1PcInstance listner : partyMembers) {
					if (!listner.getExcludingList().contains(pc.getName())) {
						listner.sendPackets(s_chatpacket);
					}
				}
			}
		}
		if (!pc.isGm()) {
			pc.checkChatInterval();
		}
	}

	private void chatWorld(L1PcInstance pc, String chatText, int chatType) {
		if (pc.isGm() || pc.isMonitor()) { // Do not remove monitor ability
			ChatLogTable.getInstance().storeChat(pc, null, chatText, chatType);
			L1World.getInstance().broadcastPacketToAll(new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_GLOBALCHAT, chatType));
		} else if (pc.getLevel() >= Config.GLOBAL_CHAT_LEVEL) {
			if (L1World.getInstance().isWorldChatElabled()) {
				//TRICIDTODO: Make this a configurable option
				if (pc.get_food() >= 2) {
					// pc.set_food(pc.get_food() - 2); // we dont want this on lineagedc
					ChatLogTable.getInstance().storeChat(pc, null, chatText, chatType);
					//pc.sendPackets(new S_PacketBox(S_PacketBox.FOOD, pc
					//		.get_food()));
					for (L1PcInstance listner : L1World.getInstance().getAllPlayers()) {
						if (!listner.getExcludingList().contains(pc.getName())) {
							if (listner.isShowTradeChat() && chatType == 12) {
								listner.sendPackets(new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_GLOBALCHAT, chatType));
							} else if (listner.isShowWorldChat() && chatType == 3) {
								listner.sendPackets(new S_ChatPacket(pc, chatText, Opcodes.S_OPCODE_GLOBALCHAT, chatType));
							}
						}
					}
				} else {
					pc.sendPackets(new S_ServerMessage(462));
				}
			} else {
				pc.sendPackets(new S_ServerMessage(510));
			}
		} else {
			pc.sendPackets(new S_ServerMessage(195, String.valueOf(Config.GLOBAL_CHAT_LEVEL)));
		}
	}

	@Override
	public String getType() {
		return C_CHAT;
	}
}