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
package l1j.server.server.serverpackets;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.datatables.MailTable;
import l1j.server.server.templates.L1Mail;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket
public class S_Mail extends ServerBasePacket {
	private static Logger _log = Logger.getLogger(S_WhoAmount.class.getName());
	private static final String S_MAIL = "[S] S_Mail";
	private byte[] _byte = null;

	public S_Mail(String receiverName, int type) {
		ArrayList<L1Mail> mails = new ArrayList<L1Mail>();
		for (L1Mail mail : MailTable.getInstance().getAllMail()) {
			if (mail.getReceiverName().equalsIgnoreCase(receiverName)) {
				if (mail.getType() == type) {
					mails.add(mail);
				}
			}
		}
		if (mails.isEmpty()) {
			return;
		}
		writeC(Opcodes.S_OPCODE_MAIL);
		writeC(type);
		writeH(mails.size());
		for (int i = 0; i < mails.size(); i++) {
			L1Mail mail = mails.get(i);
			writeD(mail.getId());
			writeC(mail.getReadStatus());
			StringTokenizer st = new StringTokenizer(mail.getDate(),"/"); // yy/mm/dd
			int size = st.countTokens();
			for (int j = 0;j < size; j++) {
				// XXX writeC(Year) writeC(Month) writeC(Day)
				writeC(Integer.parseInt(st.nextToken()));
			}
			writeS(mail.getSenderName());
			writeByte(mail.getSubject());
		}
	}

	public S_Mail(int type) { // M[m
		writeC(Opcodes.S_OPCODE_MAIL);
		writeC(type);
	}

	public S_Mail(int mailId,int type) {
		if (type == 0x30 || type == 0x31 || type == 0x32 || type == 0x40) {
			writeC(Opcodes.S_OPCODE_MAIL);
			writeC(type);
			writeD(mailId);
			writeC(1);
			return;
		}
		L1Mail mail = MailTable.getInstance().getMail(mailId);
		if (mail != null) {
			writeC(Opcodes.S_OPCODE_MAIL);
			writeC(type);
			writeD(mail.getId());
			writeByte(mail.getContent());
		}
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return S_MAIL;
	}
}