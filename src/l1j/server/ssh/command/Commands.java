package l1j.server.ssh.command;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import l1j.server.Config;
import l1j.server.server.Account;
import l1j.server.server.GameServer;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.ChatLogTable;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.classes.L1ClassId;
import l1j.server.server.serverpackets.S_ChatPacket;
import l1j.server.server.storage.mysql.MySqlCharacterStorage;
import l1j.server.server.templates.L1Castle;
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

class GetOnlinePlayers implements Commands {
	@Override
	public String execute(String args) {
		try{
			boolean separateShops = Boolean.parseBoolean(args);
			
			HashMap<String, Integer> chars = new HashMap<String, Integer>();
			HashMap<String, Integer> shopChars = new HashMap<String, Integer>();
			
			for (L1PcInstance player : L1World.getInstance().getAllPlayers()) {
				String playerClass = L1ClassId.getClass(player.getClassId());
				
				if (player.isPrivateShop() && separateShops) {
					int currentCount = shopChars.get(playerClass) == null ? 0 : shopChars.get(playerClass);
					shopChars.put(playerClass, currentCount + 1);
				} else {
					int currentCount = chars.get(playerClass) == null ? 0 : chars.get(playerClass);
					chars.put(playerClass, currentCount + 1);
				}
			}
			
			// convert it to JSON and return it
			StringBuilder json = new StringBuilder("{\n\"Players\": {\n");
			
			Iterator<Entry<String, Integer>> it = chars.entrySet().iterator();
			String separator = "";
		    while (it.hasNext()) {
		        Map.Entry<String, Integer> gameClass = (Map.Entry<String, Integer>)it.next();
		        json.append(separator + "\"" + gameClass.getKey() + "\":" + gameClass.getValue());
		        it.remove();
		        separator = ",\n";
		    }
		    
		    json.append("\n},\n\"Shops\": {\n");
		    
		    it = shopChars.entrySet().iterator();
		    separator = "";
		    while (it.hasNext()) {
		        Map.Entry<String, Integer> gameClass = (Map.Entry<String, Integer>)it.next();
		        json.append(separator + "\"" + gameClass.getKey() + "\":" + gameClass.getValue());
		        it.remove();
		        separator = ",\n";
		    }
			
			json.append("\n}\n}");
			
			return json.toString();
		} catch(Exception ex) {
			return "getonlineplayers <optional separateShops>";
		}
	}

	public String formatMessage(String args) {
                return "GetOnlinePlayers with separateShops = " + args;
        }
}

class GetSiegeTimes implements Commands {
	@Override
	public String execute(String args) {
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
			List<L1Castle> castles = Arrays.asList(CastleTable.getInstance().getCastleTableList());
			// order the castles alphabetically
			Collections.sort(castles, new Comparator<L1Castle>() {
				@Override public int compare(L1Castle c1, L1Castle c2) {
		            return c1.getName().compareTo(c2.getName()) ;
		        }
			});
			
			StringBuilder json = new StringBuilder("[\n");
			
			String separator = "";
			for(L1Castle castle: castles) {
				//TODO -- There is probably a better way to check if the castle is active
				if(castle.getWarTime().get(Calendar.YEAR) > 2008) {
					json.append(separator + "{\"name\":\"" + castle.getName() + "\", \"war_time\": \"" + 
							format.format(castle.getWarTime().getTime()) + "\"}");
					separator = ",\n";
				}
			}

			return json.toString() + "\n]";
		} catch(Exception ex) {
			return "getsiegetimes";
		}
	}

	public String formatMessage(String args) {
                return "GetSiegeTimes";
        }
}

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
				Account.addIpRestriction(existingAccount.getName(), ip);
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
