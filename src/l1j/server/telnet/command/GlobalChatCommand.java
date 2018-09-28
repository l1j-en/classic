package l1j.server.telnet.command;

import static l1j.server.server.encryptions.Opcodes.S_OPCODE_GLOBALCHAT;

import java.util.StringTokenizer;

import l1j.server.server.datatables.ChatLogTable;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ChatPacket;
import l1j.server.server.storage.mysql.MySqlCharacterStorage;
class GlobalChatCommand implements TelnetCommand {
	public static final int CMD_INTERNAL_ERROR = 2;
	public static final int CMD_OK = 0;

	@Override
	public TelnetCommandResult execute(String args) {
		StringTokenizer tok = new StringTokenizer(args, " ");
		String name = tok.nextToken();
		String text = args.substring(name.length() + 1);
		L1PcInstance pc = new MySqlCharacterStorage().loadCharacter(name);
		if (pc == null) {
			return new TelnetCommandResult(CMD_INTERNAL_ERROR,
					"Character does not exist.");
		}
		pc.getLocation().set(-1, -1, 0);
		ChatLogTable.getInstance().storeChat(pc, null, text, 3);
		L1World.getInstance().broadcastPacketToAll(
				new S_ChatPacket(pc, text, S_OPCODE_GLOBALCHAT, 3));
		return new TelnetCommandResult(CMD_OK, "");
	}
}