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
package l1j.server.server.command.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.MailTable;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Mail;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.SQLUtil;

public class L1Resolve implements L1CommandExecutor {

	private L1Resolve() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Resolve();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			String[] args = arg.split(" ");
			int bugNumber = -1;
			boolean notify = false;
			
			if(args.length == 2) {
				if(!args[0].toLowerCase().equals("-n")){
					throw new Exception();
				}
				
				notify = true;
				bugNumber = Integer.valueOf(args[1]).intValue();
			} else {
				bugNumber = Integer.valueOf(arg).intValue();
			}
			
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("UPDATE bugs SET resolved=1 WHERE id=?");
			pstm.setInt(1, bugNumber);
			pstm.execute();
			pc.sendPackets(new S_SystemMessage("Bug #" + bugNumber
					+ " has been resolved!"));
			pstm.close();
			
			// unless they specified the -n flag, don't notify the player
			if(!notify) {
				return;
			}	
			
			// find the player and send them a mail letting them know
			// the bug has been resolved
			pstm = con.prepareStatement("SELECT charname, bugtext FROM bugs where resolved = 1 AND id=?");
			pstm.setInt(1, bugNumber);
			
			ResultSet rs = pstm.executeQuery();
			if(!rs.next()) {
				pc.sendPackets(new S_SystemMessage("Something went wrong notifying the player."));
				return;
			}
			
			String subject = "Bug #" + bugNumber + " Resolved!";
			String message = "Submitted Message:\n\n" + rs.getString(2);
			
			// default message just in case it screws up
			byte[] mailText = "B\0u\0g\0 \0R\0e\0s\0o\0l\0v\0e\0d\0!\0\0\0Y\0o\0u\0r\0 \0b\0u\0g\0 \0h\0a\0s\0 \0b\0e\0e\0n\0 \0r\0e\0s\0o\0l\0v\0e\0d\0!\0\0\0\0".getBytes("UTF-8");
		
			try {
				mailText = formatMessage(subject, message);
			} catch(Exception ex) { 
				pc.sendPackets(new S_SystemMessage("Error converting message. Default text sent."));
			}
			
			String submitterName = rs.getString(1);
			
			L1PcInstance receiver = L1World.getInstance().getPlayer(submitterName);

			if (receiver != null) {
				MailTable.getInstance().writeMail(0, submitterName, receiver,
						mailText, receiver.getId());

				if (receiver.getOnlineStatus() == 1) {
					receiver.sendPackets(new S_Mail(receiver, 0));
					receiver.sendPackets(
							new S_SystemMessage("A bug you submitted has been resolved. " + 
									"Check your mail for more info!"));
				}
			} else {
				try {
					L1PcInstance restorePc = CharacterTable.getInstance()
							.restoreCharacter(submitterName);

					if (restorePc != null) {
						MailTable.getInstance().writeMail(0, submitterName, restorePc, 
								mailText, restorePc.getId());
					} else {
						pc.sendPackets(new S_ServerMessage(109, submitterName));
					}
				} catch (Exception e) {}
			}
			
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".resolve [-n] <bugId>"));
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	
	private byte[] formatMessage(String subject, String message) throws Exception {
		return (padNulls(subject) + "\0\0\0" + padNulls(message) + "\0\0\0\0").getBytes("UTF-8");
	}
	
	private String padNulls(String text) {
		StringBuilder returnValue = new StringBuilder();
		returnValue.append(text.charAt(0));
		
		for (int i = 1; i < text.length(); i++){
		    char c = text.charAt(i);
		    
		    returnValue.append("\0" + c);
		}
		
		return returnValue.toString();
	}
}