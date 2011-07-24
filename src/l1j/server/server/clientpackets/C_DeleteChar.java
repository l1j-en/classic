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

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.hackdetections.LogDeleteChar;
import l1j.server.server.ClientThread;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.classes.L1ClassId;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_DeleteCharOK;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket, C_DeleteChar
public class C_DeleteChar extends ClientBasePacket {

	private static final String C_DELETE_CHAR = "[C] RequestDeleteChar";
	private static Logger _log = Logger.getLogger(C_DeleteChar.class.getName());

	public C_DeleteChar(byte decrypt[], ClientThread client) throws Exception {
		super(decrypt);
		String name = readS();
		String hostip = client.getHostname();
		
		try {
			L1PcInstance pc = CharacterTable.getInstance().restoreCharacter(name);
			if (pc != null && pc.getLevel() >= 30 && Config.DELETE_CHARACTER_AFTER_7DAYS) {
				if (pc.getType() < 32) {
					switch(pc.getType()){
					case L1ClassId.ROYAL:
						pc.setType(L1ClassId.Del_ROYAL);
						break;
					case L1ClassId.KNIGHT:
						pc.setType(L1ClassId.Del_KNIGHT);
						break;
					case L1ClassId.ELF:
						pc.setType(L1ClassId.Del_ELF);
						break;
					case L1ClassId.WIZARD:
						pc.setType(L1ClassId.Del_WIZARD);
						break;
					case L1ClassId.DARK_ELF:
						pc.setType(L1ClassId.Del_DARK_ELF);
						break;
					case L1ClassId.DRAGON_KNIGHT:
						pc.setType(L1ClassId.Del_DRAGON_KNIGHT);
						break;
					case L1ClassId.ILLUSIONIST:
						pc.setType(L1ClassId.Del_ILLUSIONIST);
						break;
					}
					Timestamp deleteTime = new Timestamp(System.currentTimeMillis() + 604800000); // 7 Days
					pc.setDeleteTime(deleteTime);
					pc.save();
				} else {
					switch(pc.getType()){
					case L1ClassId.Del_ROYAL:
						pc.setType(L1ClassId.ROYAL);
						break;
					case L1ClassId.Del_KNIGHT: 
						pc.setType(L1ClassId.KNIGHT);
						break;
					case L1ClassId.Del_ELF:
						pc.setType(L1ClassId.ELF);
						break;
					case L1ClassId.Del_WIZARD:
						pc.setType(L1ClassId.WIZARD);
						break;
					case L1ClassId.Del_DARK_ELF:
						pc.setType(L1ClassId.DARK_ELF);
						break;
					case L1ClassId.Del_DRAGON_KNIGHT:
						pc.setType(L1ClassId.DRAGON_KNIGHT);
						break;
					case L1ClassId.Del_ILLUSIONIST:
						pc.setType(L1ClassId.ILLUSIONIST);
						break;
					}
					pc.setDeleteTime(null);
					pc.save();
				}
				client.sendPacket(new S_DeleteCharOK(S_DeleteCharOK.DELETE_CHAR_AFTER_7DAYS));
				return;
			}

			if (pc != null) {
				L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
				if (clan != null) {
					clan.delMemberName(name);
				}
			}
			LogDeleteChar ldc = new LogDeleteChar();
			ldc.storeLogDeleteChar(pc, hostip);
			CharacterTable.getInstance().deleteCharacter(client.getAccountName(), name);
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			client.close();
			return;
		}
		client.sendPacket(new S_DeleteCharOK(S_DeleteCharOK.DELETE_CHAR_NOW));
	}

	@Override
	public String getType() {
		return C_DELETE_CHAR;
	}
}