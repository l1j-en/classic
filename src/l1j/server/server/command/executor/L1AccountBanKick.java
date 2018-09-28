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

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import l1j.server.server.Account;
import l1j.server.server.datatables.AccessLevelTable;
import l1j.server.server.model.BanInfo;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CustomBoardRead;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1AccountBanKick implements L1CommandExecutor {

	private L1AccountBanKick() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1AccountBanKick();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			String[] args = arg.split(" ");
			
			String accountName = args[0];
			String action = args[1].toLowerCase();
			
			StringBuilder message = new StringBuilder();
			
			for(int i = 2; i < args.length; i++) {
				message.append(args[i] + " ");
			}
			
			if(message.toString().trim().length() == 0 && !action.equals("history")) {
				pc.sendPackets(new S_SystemMessage("A ban/unban reason is required!"));
				return;
			}

			Account playerAccount = Account.load(accountName);

			if (playerAccount != null) {
				if(pc.getAccessLevel().getLevel() != AccessLevelTable.getInstance().getMaxAccessLevel()
						&& playerAccount.getAccessLevel() >= pc.getAccessLevel().getLevel()) {
					pc.sendPackets(
							new S_SystemMessage("You can only ban/unban accounts with less privileges than you!"));
					return;
				}
				
				if(action.equals("ban")) {
					if(playerAccount.isBanned()) {
						pc.sendPackets(
								new S_SystemMessage(String.format("Account '%s' is already banned!", accountName)));
						return;
					}
					
					for(String char_name : playerAccount.getCharacters()) {
						L1PcInstance character = L1World.getInstance().getPlayer(char_name);
						
						if(character != null) {
							character.getNetConnection().kick();
							pc.sendPackets(new S_SystemMessage(
									String.format("Character '%s' in account '%s' has been kicked!",
											character.getName(), playerAccount.getName())));
						}
					}
					
					Account.ban(playerAccount.getName(), pc.getAccountName(), message.toString());
					pc.sendPackets(new S_SystemMessage(String.format("The account '%s' has been banned.",
							playerAccount.getName())));
				} else if(action.equals("unban")) {
					if(!playerAccount.isBanned()) {
						pc.sendPackets(
								new S_SystemMessage(String.format("Account '%s' is not banned!", accountName)));
						return;
					}
					
					Account.unban(playerAccount.getName(), pc.getAccountName(), message.toString());
					pc.sendPackets(new S_SystemMessage(String.format("The account '%s' has been unbanned.",
							playerAccount.getName())));
				} else if(action.equals("history")) {
					ArrayList<BanInfo> banHistory = playerAccount.getBanHistory();
					
					StringBuilder banHistoryString = new StringBuilder();
					SimpleDateFormat formatter =
		                      new SimpleDateFormat("MMM dd yyyy HH:mm");
					
					for(BanInfo historyItem : banHistory) {
						String accountInfoMessage = String.format("%s: \n\n%s by %s\nReason:\n%s\n\n",
								formatter.format(historyItem.getActionDate()),
								historyItem.getAction(),
								historyItem.getActionerAccountName(),
								historyItem.getMessage());
						banHistoryString.append(accountInfoMessage);
					}
					
					pc.sendPackets(new S_CustomBoardRead(playerAccount.getName() + " Ban History", 
							pc.getName(), banHistoryString.toString()));
				} else {
					throw new Exception();
				}
			} else {
				pc.sendPackets(new S_SystemMessage("No Account Found with the name: " + accountName));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " <account_name> [ban|unban|history] <reason>"));
		}
	}
}
