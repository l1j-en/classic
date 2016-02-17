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

import java.util.StringTokenizer;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Lawful;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_PinkName;
import l1j.server.server.serverpackets.S_RawStringDialog;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Status implements L1CommandExecutor {

	private L1Status() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Status();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer tok = new StringTokenizer(arg);
			L1PcInstance target = pc;
			String char_name = pc.getName();
			
			//if they passed all 4 values, get the user they passed
			if (tok.countTokens() == 3){
				char_name = tok.nextToken();
				target = L1World.getInstance().getPlayer(char_name);
			}
			String param = tok.nextToken();
			int value = Integer.parseInt(tok.nextToken());
			
			if (target == null) {
				pc.sendPackets(new S_ServerMessage(73, char_name));
				return;
			}

			// -- not use DB --
			if (param.equalsIgnoreCase("AC")) {
				target.addAc((byte) (value - target.getAc()));
			} else if (param.equalsIgnoreCase("MR")) {
				target.addMr((short) (value - target.getMr()));
			} else if (param.equalsIgnoreCase("HIT")) {
				target.addHitup((short) (value - target.getHitup()));
			} else if (param.equalsIgnoreCase("DMG")) {
				target.addDmgup((short) (value - target.getDmgup()));
				// -- use DB --
			} else {
				if (param.equalsIgnoreCase("HP")) {
					target.addBaseMaxHp((short) (value - target.getBaseMaxHp()));
					target.setCurrentHpDirect(target.getMaxHp());
				} else if (param.equalsIgnoreCase("MP")) {
					target.addBaseMaxMp((short) (value - target.getBaseMaxMp()));
					target.setCurrentMpDirect(target.getMaxMp());
				} else if (param.equalsIgnoreCase("LAWFUL")) {
					target.setLawful(value);
					S_Lawful s_lawful = new S_Lawful(target.getId(),
							target.getLawful());
					target.sendPackets(s_lawful);
					target.broadcastPacket(s_lawful);
				} else if (param.equalsIgnoreCase("KARMA")) {
					target.setKarma(value);
				} else if (param.equalsIgnoreCase("STR")) {
					target.addBaseStr((byte) (value - target.getBaseStr()));
				} else if (param.equalsIgnoreCase("CON")) {
					target.addBaseCon((byte) (value - target.getBaseCon()));
				} else if (param.equalsIgnoreCase("DEX")) {
					target.addBaseDex((byte) (value - target.getBaseDex()));
				} else if (param.equalsIgnoreCase("INT")) {
					target.addBaseInt((byte) (value - target.getBaseInt()));
				} else if (param.equalsIgnoreCase("WIS")) {
					target.addBaseWis((byte) (value - target.getBaseWis()));
				} else if (param.equalsIgnoreCase("CHA")) {
					target.addBaseCha((byte) (value - target.getBaseCha()));
				} else if(param.equalsIgnoreCase("PINK")) {
					target.setPinkName(value == 1);
					
					target.sendPackets(new S_PinkName(target.getId(), 180 * value));
					target.broadcastPacket(new S_PinkName(target.getId(), 180 * value));
					
				} else {
					pc.sendPackets(new S_SystemMessage(param
							+ " is an unknown setting"));
					return;
				}
				target.save();
			}
			target.sendPackets(new S_OwnCharStatus(target));
			pc.sendPackets(new S_SystemMessage("Changed " + target.getName()
					+ "'s " + param + " to " + value));
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <player> <setting> <value> or .%1$s <setting> <value>",
							cmdName)));
			pc.sendPackets(new S_RawStringDialog(pc.getId(), 
					"Available settings:", "AC, MR, HIT, DMG, HP, MP, LAWFUL, KARMA, STR, CON, DEX, INT, WIS, CHA, PINK"));
		}
	}
}
