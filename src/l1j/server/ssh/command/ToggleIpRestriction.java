package l1j.server.ssh.command;

import java.util.StringTokenizer;

import l1j.server.server.Account;

class ToggleIpRestriction implements Commands {
	@Override
	public String execute(String args) {
		try{
			StringTokenizer tok = new StringTokenizer(args, " ");
			String account = tok.nextToken();
			boolean enable = Boolean.parseBoolean(tok.nextToken());
			
			Account existingAccount = Account.load(account);
			if(existingAccount == null) {
				return "Account doesn't exist!";
			}
			
			Account.enableIpRestriction(existingAccount.getName(), enable);
			
			return "OK";
		} catch(Exception ex) {
			return "enable-ip-restriction <account> <true|false>";
		}
	}

	public String formatMessage(String args) {
                StringTokenizer tok = new StringTokenizer(args, " ");
                String account = tok.nextToken();

                return "Add an IP to the restriction list for the account: " + account;
        }
}