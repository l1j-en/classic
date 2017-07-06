package l1j.server.ssh.command;

import java.util.StringTokenizer;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.GameServer;
import l1j.server.server.datatables.ChatLogTable;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ChatPacket;
import l1j.server.server.storage.mysql.MySqlCharacterStorage;
import l1j.server.server.utils.IntRange;

public interface Commands {
	String execute(String args);
        String formatMessage(String args);
}

class Fail implements Commands {
	@Override
	public String execute(String args) {
		return args + "command doesn't exist.";
	}

	@Override
	public String formatMessage(String args) {
		return "Unknown";
	}
}

class Echo implements Commands {
	@Override
	public String execute(String args) {
		return args;
	}

	@Override
        public String formatMessage(String args) {
                return "Echo with argument: " + args;
        }
}

class PlayerId implements Commands {
	@Override
	public String execute(String args) {
		L1PcInstance pc = L1World.getInstance().getPlayer(args);
		String result = pc == null ? "0" : String.valueOf(pc.getId());
		return result;
	}

	@Override
        public String formatMessage(String args) {
                return "PlayerId with objectid: " + args;
        }
}

class CharStatus implements Commands {
	@Override
	public String execute(String args) {
		int id = Integer.valueOf(args);
		L1Object obj = L1World.getInstance().findObject(id);
		if (obj == null) {
			return "ObjectId " + id + " not found";
		}
		if (!(obj instanceof L1Character)) {
			return "ObjectId " + id + " is not a character";
		}
		L1Character cha = (L1Character) obj;
		StringBuilder result = new StringBuilder();
		result.append("Name: " + cha.getName() + "\r\n");
		result.append("Level: " + cha.getLevel() + "\r\n");
		result.append("MaxHp: " + cha.getMaxHp() + "\r\n");
		result.append("CurrentHp: " + cha.getCurrentHp() + "\r\n");
		result.append("MaxMp: " + cha.getMaxMp() + "\r\n");
		result.append("CurrentMp: " + cha.getCurrentMp() + "\r\n");
		return result.toString();
	}

	@Override
        public String formatMessage(String args) {
                return "CharStatus with objectid: " + args;
        }
}

class GlobalChat implements Commands {
	@Override
	public String execute(String args) {
		StringTokenizer tok = new StringTokenizer(args, " ");
		String name = tok.nextToken();
		String text = args.substring(name.length() + 1);
		L1PcInstance pc = new MySqlCharacterStorage().loadCharacter(name);
		if (pc == null) {
			return "Character does not exist.";
		}
		pc.getLocation().set(-1, -1, 0);
		ChatLogTable.getInstance().storeChat(pc, null, text, 3);
		L1World.getInstance().broadcastPacketToAll(
				new S_ChatPacket(pc, text, Opcodes.S_OPCODE_GLOBALCHAT, 3));
		return "";
	}

	@Override
        public String formatMessage(String args) {
		StringTokenizer tok = new StringTokenizer(args, " ");
                String name = tok.nextToken();
                String text = args.substring(name.length() + 1);

                return "GlobalChat as the character: " + name + " with the message: " + text;
        }
}

class ShutDown implements Commands {
	@Override
	public String execute(String args) {
		int sec = args.isEmpty() ? 0 : Integer.parseInt(args);
		sec = IntRange.ensure(sec, 30, Integer.MAX_VALUE);
		GameServer.getInstance().shutdownWithCountdown(sec);
		return "";
	}

	@Override
        public String formatMessage(String args) {
                return "ShutDown with a countdown of: " + args;
        }
}

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
