package l1j.server.ssh.command;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

import l1j.server.server.Account;

class ManageIpRestrictions implements Commands {
	private static final Pattern PATTERN = Pattern.compile(
	        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	
	@Override
	public String execute(String args) {
		try{
			StringTokenizer tok = new StringTokenizer(args, " ");
			String action = tok.nextToken();
			String account = tok.nextToken();
			String ip = tok.nextToken();	
			
			if(!PATTERN.matcher(ip).matches()) {
				return "Invalid IP!";
			}
			
			Account existingAccount = Account.load(account);
			if(existingAccount == null) {
				return "Account doesn't exist!";
			}
			
			if(action.toLowerCase().equals("add")) {
				if(!Account.addIpRestriction(existingAccount.getName(), ip)) {
					return "ERROR";
				}
			} else {
				Account.deleteIpRestriction(existingAccount.getName(), ip);
			}
			
			return "OK";
		} catch(Exception ex) {
			return "iprestriction <add|del> <account> <ip>";
		}
	}

	public String formatMessage(String args) {
                StringTokenizer tok = new StringTokenizer(args, " ");
                String account = tok.nextToken();

                return "Add an IP to the restriction list for the account: " + account;
        }
}