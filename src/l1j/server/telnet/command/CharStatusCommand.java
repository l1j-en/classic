package l1j.server.telnet.command;

import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;

class CharStatusCommand implements TelnetCommand {
	public static final int CMD_INTERNAL_ERROR = 2;
	public static final int CMD_OK = 0;
	@Override
	public TelnetCommandResult execute(String args) {
		int id = Integer.valueOf(args);
		L1Object obj = L1World.getInstance().findObject(id);
		if (obj == null) {
			return new TelnetCommandResult(CMD_INTERNAL_ERROR, "ObjectId " + id
					+ " not found");
		}
		if (!(obj instanceof L1Character)) {
			return new TelnetCommandResult(CMD_INTERNAL_ERROR, "ObjectId " + id
					+ " is not a character");
		}
		L1Character cha = (L1Character) obj;
		StringBuilder result = new StringBuilder();
		result.append("Name: " + cha.getName() + "\r\n");
		result.append("Level: " + cha.getLevel() + "\r\n");
		result.append("MaxHp: " + cha.getMaxHp() + "\r\n");
		result.append("CurrentHp: " + cha.getCurrentHp() + "\r\n");
		result.append("MaxMp: " + cha.getMaxMp() + "\r\n");
		result.append("CurrentMp: " + cha.getCurrentMp() + "\r\n");
		return new TelnetCommandResult(CMD_OK, result.toString());
	}
}