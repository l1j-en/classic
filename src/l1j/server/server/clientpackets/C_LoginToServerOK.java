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

//import java.util.logging.Logger;
import l1j.server.server.ClientThread;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_LoginToServerOK extends ClientBasePacket {

	private static final String C_LOGIN_TO_SERVER_OK = "[C] C_LoginToServerOK";

	//private static Logger _log = Logger.getLogger(C_LoginToServerOK.class.getName());

	public C_LoginToServerOK(byte[] decrypt, ClientThread client) {
		super(decrypt);
		int i = readC();
		int j = readC();
		L1PcInstance pc = client.getActiveChar();
		if(i==0) { //Client wants to change settings for Bloodpledge chat
			if(j==1){
				pc.set_bpchat(true);
			} else {
				pc.set_bpchat(false);
			}
		} else if(i==2) { //Client wants to change settings for Whisper chat
			if(j==1){
				pc.set_whisper(true);
			} else {
				pc.set_whisper(false);
			}
		} else if(i==6) { //Client wants to change settings for Global chat
			if(j==1){
				pc.set_globalchat(true);
			} else {
				pc.set_globalchat(false);
			}
		} else if(i==7) { //Client wants to change settings for Mail
			if(j==1){
				pc.set_mail(true);
			} else {
				pc.set_mail(false);
			}
		} else {
			//System.out.println("i="+i+", j="+j);
		}
	}

	@Override
	public String getType() {
		return C_LOGIN_TO_SERVER_OK;
	}
}

