package l1j.server.ssh.command;

import java.util.StringTokenizer;

import l1j.server.server.Account;

class CreateAccount implements Commands {
	@Override
	public String execute(String args) {
		try{
			StringTokenizer tok = new StringTokenizer(args, " ");
			String account = tok.nextToken();
			String password = tok.nextToken();
			
			String ip = "";
			
			if(tok.hasMoreTokens()) {
				tok.nextToken();
			}		
			
			if(password.length() > 13) {
				return "Password too long";
			}
			
			Account existingAccount = Account.load(account);
			if(existingAccount != null) {
				return "Account already exists";
			}
			
			Account.create(account, password, ip, "");
			
			return "OK";
		} catch(Exception ex) {
			return "create <account> <password> <ip>";
		}
	}

	@Override
        public String formatMessage(String args) {
		StringTokenizer tok = new StringTokenizer(args, " ");
                String account = tok.nextToken();

                return "CreateAccount for the account: " + account;
        }
}