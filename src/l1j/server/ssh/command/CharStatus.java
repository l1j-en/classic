package l1j.server.ssh.command;

import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;

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