package l1j.server.ssh.command;

import java.util.StringTokenizer;

import l1j.server.Config;
import l1j.server.server.Account;

class ChangePassword implements Commands {
	@Override
	public String execute(String args) {
		try{
			StringTokenizer tok = new StringTokenizer(args, " ");
			String account = tok.nextToken();
			String password = tok.nextToken();	
			
			if(password.length() > 13) {
				return "Password too long!";
			}
			
			Account existingAccount = Account.load(account);
			if(existingAccount == null) {
				return "Account doesn't exist!";
			}
			
			String newPassword = Account.makeSHA256(Config.PASSWORD_SALT + password
					+ Account.makeMD5(account));
			existingAccount.change_password(newPassword);
			
			return "OK";
		} catch(Exception ex) {
			return "changepassword <account> <password>";
		}
	}

	public String formatMessage(String args) {
                StringTokenizer tok = new StringTokenizer(args, " ");
                String account = tok.nextToken();

                return "ChangePassword for the account: " + account;
        }
}