package l1j.server.server.clientpackets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class C_Chat extends ClientBasePacket {
	private static final String C_CHAT = "[C] C_Chat";
	private static Logger _log = Logger.getLogger(C_Chat.class.getName());
	private static final int SHOUT_RANGE = 50;

	private static void sendChatPacket(final L1PcInstance sender,
			final Iterable<L1PcInstance> receivers, final String text,
			final int type, final int opcode) {
		ChatLogTable.getInstance().storeChat(sender, null, text, type);
		S_ChatPacket packet = new S_ChatPacket(sender, text, opcode, type);
		for (L1PcInstance receiver : filterForIgnored(sender, receivers))
			receiver.sendPackets(packet);
	}

	private static Iterable<L1PcInstance> filterForIgnored(final L1PcInstance sender,
			final Iterable<L1PcInstance> receivers) {
		List<L1PcInstance> filtered = new ArrayList<L1PcInstance>();
		for (L1PcInstance receiver : receivers)
			if (!receiver.getExcludingList().contains(sender.getName()))
				filtered.add(receiver);
		return filtered;
	}

	public C_Chat(byte abyte0[], ClientThread clientThread) {
		super(abyte0);

		L1PcInstance pc = clientThread.getActiveChar();
		int chatType = readC();
		String chatText = readS();
		if (pc.hasSkillEffect(SILENCE) || pc.hasSkillEffect(AREA_OF_SILENCE) || 
				pc.hasSkillEffect(STATUS_POISON_SILENCE)) {
			return;
		}
		if (pc.hasSkillEffect(1005)) { 
			pc.sendPackets(new S_ServerMessage(242)); 
			return;
		}

		// A lambda, a lambda, my kingdom for a (concise!) lambda.
		switch(chatType) {
			case 0:
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
					worldChat(pc, chatText.substring(1), 12);

					if (!pc.isGm()) {
						pc.checkChatInterval();
					}
					return;
				}

				// Cheap hack to fix shouting. The client insists that ! chat is of 
				// chatType 0. This is a (hopefully temporary) workaround that 
				// provides shouting via !!.
				if (chatText.startsWith("!")) {
					chatText = chatText.substring(1, chatText.length());

					// TODO: test this! The fix was using S_OPCODE_NPCSHOUT,
					// but the original code uses S_OPCODE_NORMALCHAT.
					normalChat(pc, chatText, 2, SHOUT_RANGE,
							Opcodes.S_OPCODE_NORMALCHAT);

					if (!pc.isGm()) {
						pc.checkChatInterval();
					}
					return;
				}

				// TODO: maybe there's a nicer way to expose that config setting?
				normalChat(pc, chatText, chatType, Config.PC_RECOGNIZE_RANGE,
						Opcodes.S_OPCODE_NORMALCHAT);
				break;
			case 2:
				if (pc.isGhost() && (!pc.isGm() || !pc.isMonitor()))
					return;

				// TODO: investigate. The original code uses the NORMALCHAT opcode,
				// but the hack above uses NPCSHOUT.
				normalChat(pc, chatText, chatType, SHOUT_RANGE,
						Opcodes.S_OPCODE_NORMALCHAT);
				break;
			case 3:
				worldChat(pc, chatText, chatType);
				break;
			case 4:
				clanChat(pc, chatText, chatType, L1Clan.CLAN_RANK_PUBLIC,
						L1Clan.CLAN_RANK_PROBATION);
				break;
			case 11:
				if (!pc.isInParty())
					return;

				sendChatPacket(pc, Arrays.asList(pc.getParty().getMembers()), 
						chatText, chatType, Opcodes.S_OPCODE_GLOBALCHAT);
				break;
			case 12:
				worldChat(pc, chatText, chatType);
				break;
			case 13:
				clanChat(pc, chatText, chatType, L1Clan.CLAN_RANK_GUARDIAN,
						L1Clan.CLAN_RANK_GUARDIAN);
				break;
			case 14:
				if (!pc.isInChatParty())
					return;

				sendChatPacket(pc, Arrays.asList(pc.getChatParty().getMembers()),
						chatText, chatType, Opcodes.S_OPCODE_NORMALCHAT);
				break;
			default:
		}

		if (!pc.isGm()) {
			pc.checkChatInterval();
		}
	}

	private void normalChat(final L1PcInstance sender, final String text,
			final int type, final int range, final int opcode) {

		List<L1PcInstance> receivers = 
			L1World.getInstance().getVisiblePlayer(sender, range);
		receivers.add(sender);

		sendChatPacket(sender, receivers, text, type,
				Opcodes.S_OPCODE_NORMALCHAT);

		echo(sender, text, type, range);
	}

	private void echo(final L1PcInstance sender, final String text,
			final int type, final int range) {
		for (L1Object obj : sender.getKnownObjects()) {
			if (!(obj instanceof L1MonsterInstance))
				continue;

			L1MonsterInstance mob = (L1MonsterInstance) obj;
			// Added HP check to prevent dead doppels from talking.
			if (!mob.getNpcTemplate().is_doppel() ||
					!mob.getName().equals(sender.getName()) ||
					mob.getCurrentHp() <= 0)
				continue;

			S_NpcChatPacket packet = new S_NpcChatPacket(mob, text, type);
			for (L1PcInstance player :
					L1World.getInstance().getVisiblePlayer(mob, range))
				player.sendPackets(packet);
		}
	}

	private void worldChat(final L1PcInstance sender, final String text,
			final int type) {
		if (!canWorldChat(sender))
			return;

		List<L1PcInstance> receivers = new ArrayList<L1PcInstance>();
		for (L1PcInstance player : L1World.getInstance().getAllPlayers())
			if ((type == 12 && player.showTradeChat()) ||
					(type == 3 && player.showWorldChat()))
				receivers.add(player);

		sendChatPacket(sender, receivers, text, type, Opcodes.S_OPCODE_GLOBALCHAT);
	}

	private void clanChat(final L1PcInstance sender, final String text,
			final int type, final int minSenderRank, final int minReceiverRank) {
		if (sender.getClanid() == 0)
			return;

		L1Clan clan = L1World.getInstance().getClan(sender.getClanname());
		int rank = sender.getClanRank();
		
		if (clan == null || rank < minSenderRank)
			return;

		List<L1PcInstance> receivers = new ArrayList<L1PcInstance>();
		for (L1PcInstance pledgemate : clan.getOnlineClanMember())
			if (pledgemate.getClanRank() >= minReceiverRank)
				receivers.add(pledgemate);

		sendChatPacket(sender, receivers, text, type, Opcodes.S_OPCODE_GLOBALCHAT);
	}

	private boolean canWorldChat(final L1PcInstance sender) {
		if (sender.isGm() || sender.isMonitor())
			return true;
		if (sender.getLevel() <= Config.GLOBAL_CHAT_LEVEL) {
			sender.sendPackets(new S_ServerMessage(195,
						String.valueOf(Config.GLOBAL_CHAT_LEVEL)));
			return false;
		}
		if (!L1World.getInstance().isWorldChatElabled()) {
			sender.sendPackets(new S_ServerMessage(510));
			return false;
		}
		/* TRICIDTODO: Make this a configurable option.
		if (sender.get_food() <= 2) {
			pc.sendPackets(new S_ServerMessage(462));
			return false;
		} else {
			pc.set_food(pc.get_food() - 2); // we dont want this on lineagedc
			pc.sendPackets(new S_PacketBox(S_PacketBox.FOOD, pc.get_food()));
		}
		*/
		return true;
	}

	@Override
	public String getType() {
		return C_CHAT;
	}
}
