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

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.MailTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_Mail;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.templates.L1Mail;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_Mail extends ClientBasePacket {

	private static final String C_MAIL = "[C] C_Mail";

	private static Logger _log = LoggerFactory.getLogger(C_Mail.class.getName());

	private static int TYPE_NORMAL_MAIL = 0;
	private static int TYPE_CLAN_MAIL = 1;
	private static int TYPE_MAIL_BOX = 2;

	public C_Mail(byte abyte0[], Client client) throws Exception {
		super(abyte0);
		int type = readC();
		L1PcInstance pc = client.getActiveChar();

		if (type == 0x00 || type == 0x01 || type == 0x02) { // Open
			pc.sendPackets(new S_Mail(pc, type));
		} else if (type == 0x10 || type == 0x11 || type == 0x12) { // Read
			int mailId = readD();
			MailTable.getInstance();
			L1Mail mail = MailTable.getMail(mailId);
			if (mail.getReadStatus() == 0) {
				MailTable.getInstance().setReadStatus(mailId);
			}
			pc.sendPackets(new S_Mail(mailId, type));
		} else if (type == 0x20) { // Write a general mail
			if (!pc.getInventory().checkItem(40308, 50)) {
				pc.sendPackets(new S_ServerMessage(189)); // Out of adena
				return;
			}
			readH();
			String receiverName = readS();
			byte[] text = readByte();
			L1PcInstance receiver = CharacterTable.getInstance()
							.restoreCharacter(receiverName);
			if (receiver == null) {
				pc.sendPackets(new S_ServerMessage(109, receiverName));
				// No one by that name.
				return;
			}
			if (getMailSizeByReceiver(receiver, TYPE_NORMAL_MAIL) >= 40) {
				pc.sendPackets(new S_Mail(type, false));
				return;
			}
			int mailId = MailTable.getInstance().writeMail(
							TYPE_NORMAL_MAIL, receiverName, pc, text, pc.getId());
			pc.sendPackets(new S_Mail(receiver, mailId, true));
			int mailId2 = MailTable.getInstance().writeMail(
							TYPE_NORMAL_MAIL, receiverName, pc, text, receiver.getId());
			if (receiver.getOnlineStatus() == 1) {
				receiver.sendPackets(new S_Mail(pc, mailId2, false));
				receiver.sendPackets(new S_SkillSound(receiver.getId(), 1091));
			}
			pc.getInventory().consumeItem(40308, 50);
			pc.sendPackets(new S_Mail(type, true));
		} else if (type == 0x21) { // Write clan email
			if (!pc.getInventory().checkItem(40308, 1000)) {
				pc.sendPackets(new S_ServerMessage(189)); // Out of adena
				return;
			}
			readH();
			String clanName = readS();
			byte[] text = readByte();
			L1Clan clan = L1World.getInstance().getClan(clanName);
			if (clan != null) {
				for (String name : clan.getAllMembers()) {
					L1PcInstance clanPc = CharacterTable.getInstance().restoreCharacter(name);
					int size = getMailSizeByReceiver(clanPc, TYPE_CLAN_MAIL);
					if (size >= 80) {
						continue;
					}
					int mailId = MailTable.getInstance().writeMail(TYPE_CLAN_MAIL, name,
									pc, text, clanPc.getId());
					if (clanPc.getOnlineStatus() == 1) { // Online
						clanPc.sendPackets(new S_Mail(clanPc, TYPE_CLAN_MAIL));
						clanPc.sendPackets(new S_SkillSound(clanPc.getId(), 1091));
					}
					pc.getInventory().consumeItem(40308, 1000);
				}
			}
		} else if (type == 0x30 || type == 0x31 || type == 0x32) { // Delete
			int mailId = readD();
			MailTable.getInstance().deleteMail(mailId);
			pc.sendPackets(new S_Mail(mailId, type));
		} else if (type == 0x60 || type == 0x61 || type == 0x62) { // Delete multiple
			int count = readD();
			for (int i = 0; i < count; i++) {
				int mailId = readD();
				pc.sendPackets(new S_Mail(mailId, (MailTable.getMail(mailId).getType() + 0x30)));
				MailTable.getInstance().deleteMail(mailId);
			}
		} else if(type == 0x40 || type == 0x41) { // Save in storage box
			int mailId = readD();
			MailTable.getInstance().setMailType(mailId, TYPE_MAIL_BOX);
			pc.sendPackets(new S_Mail(mailId, type));
		}
	}

	private int getMailSizeByReceiver(L1PcInstance pc, int type) {
		ArrayList<L1Mail> mails = new ArrayList<L1Mail>();
		MailTable.getInstance();
		for (L1Mail mail : MailTable.getAllMail()) {
			if (mail.getInBoxId() == pc.getId()) {
				if (mail.getType() == type) {
					mails.add(mail);
				}
			}
		}
		return mails.size();
	}

	@Override
	public String getType() {
		return C_MAIL;
	}
}
