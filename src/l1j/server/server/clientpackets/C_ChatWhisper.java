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
import l1j.server.server.ClientThread;
import l1j.server.server.datatables.ChatLogTable;
import l1j.server.server.datatables.ExcludeTable;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ChatPacket;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_ChatWhisper extends ClientBasePacket {

	private static final String C_CHAT_WHISPER = "[C] C_ChatWhisper";

	public C_ChatWhisper(byte abyte0[], ClientThread client) throws Exception {
		super(abyte0);
		String targetName = readS();
		String text = readS();
		L1PcInstance whisperFrom = client.getActiveChar();

		if (whisperFrom.hasSkillEffect(1005)) {
			whisperFrom.sendPackets(new S_ServerMessage(242));
			return;
		}
		if (whisperFrom.getLevel() < Config.WHISPER_CHAT_LEVEL) {
			whisperFrom.sendPackets(new S_ServerMessage(404, String
					.valueOf(Config.WHISPER_CHAT_LEVEL)));
			return;
		}
		L1PcInstance whisperTo = L1World.getInstance().getPlayer(targetName);

		if (whisperTo == null || (whisperTo.isGmAppearOffline() && !whisperFrom.isGm())) {
			whisperFrom.sendPackets(new S_ServerMessage(73, targetName));
			return;
		}
		if (whisperTo.equals(whisperFrom)) {
			return;
		}
		// TRICIDTODO: Make this configurable
		ExcludeTable excludeTable = ExcludeTable.getInstance();
		if (excludeTable.getExcludeList(whisperTo.getId()).containsId(whisperFrom.getId())
				&& !whisperFrom.isGm()) { // do not
																		// remove
																		// gm/mon
																		// whisper
																		// ability
			whisperFrom.sendPackets(new S_ServerMessage(117, whisperTo
					.getName()));
			return;
		}
		if (!whisperTo.isCanWhisper() && !whisperFrom.isGm()) { // do not remove gm/mon whisper
												// ability
			whisperFrom.sendPackets(new S_ServerMessage(205, whisperTo
					.getName()));
			return;
		}
		ChatLogTable.getInstance().storeChat(whisperFrom, whisperTo, text, 1);
		whisperFrom.sendPackets(new S_ChatPacket(whisperTo, text,
				Opcodes.S_OPCODE_GLOBALCHAT, 9));
		whisperTo.sendPackets(new S_ChatPacket(whisperFrom, text,
				Opcodes.S_OPCODE_WHISPERCHAT, 16));
	}

	@Override
	public String getType() {
		return C_CHAT_WHISPER;
	}
}