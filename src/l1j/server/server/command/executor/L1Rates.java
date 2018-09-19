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

import l1j.server.Config;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Rates implements L1CommandExecutor {

	private L1Rates() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Rates();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		String changed = "Error";
		double data = 0;
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(arg);
			String param = stringtokenizer.nextToken();
			if (param.equalsIgnoreCase("RESET")) {
				Config.reset();
				changed = "RESET";
			} else {
				String value = stringtokenizer.nextToken();
				data = Double.parseDouble(value);
				if (param.equalsIgnoreCase("XP")) {
					Config.setParameterValue("RateXp", ""
							+ (Config.RATE_XP_ORG * data));
					changed = "XP";
				} else if (param.equalsIgnoreCase("ADENA")) {
					Config.setParameterValue("RateDropAdena", ""
							+ (Config.RATE_DROP_ADENA_ORG * data));
					changed = "ADENA";
				} else if (param.equalsIgnoreCase("DROP")) {
					Config.setParameterValue("RateDropItems", ""
							+ (Config.RATE_DROP_ITEMS_ORG * data));
					changed = "DROP";
				} else if (param.equalsIgnoreCase("LAW")) {
					Config.setParameterValue("RateLawful", ""
							+ (Config.RATE_LA_ORG * data));
					changed = "LAW";
				} else if (param.equalsIgnoreCase("KARMA")) {
					Config.setParameterValue(
							"RateKarma",
							""
									+ (Integer.valueOf(value) * Config.RATE_KARMA_ORG));
					changed = "KARMA";
				} else if (param.equalsIgnoreCase("WEIGHT")) {
					int rate = (int) (data * Config.RATE_WEIGHT_LIMIT_ORG);
					Config.setParameterValue("Weightrate", "" + rate);
					changed = "WEIGHT";
				} else if (param.equalsIgnoreCase("ALL")) {
					Config.setParameterValue("RateXp", ""
							+ (Config.RATE_XP_ORG * data));
					Config.setParameterValue("RateDropAdena", ""
							+ (Config.RATE_DROP_ADENA_ORG * data));
					Config.setParameterValue("RateDropItems", ""
							+ (Config.RATE_DROP_ITEMS_ORG * data));
					Config.setParameterValue("RateLawful", ""
							+ (Config.RATE_LA_ORG * data));
					Config.setParameterValue("RateKarma", ""
							+ (Config.RATE_KARMA_ORG * data));
					int rate = (int) (data * Config.RATE_WEIGHT_LIMIT_ORG);
					Config.setParameterValue("Weightrate", "" + rate);
					changed = "ALL";
				} else {
					pc.sendPackets(new S_SystemMessage(
							".rates ([XP,ADENA,DROP,LAW,KARMA,WEIGHT,ALL] VALUE) | RESET"));
					pc.sendPackets(new S_SystemMessage("XP: "
							+ (int) Config.RATE_XP));
					pc.sendPackets(new S_SystemMessage("ADENA: "
							+ (int) Config.RATE_DROP_ADENA));
					pc.sendPackets(new S_SystemMessage("DROP: "
							+ (int) Config.RATE_DROP_ITEMS));
					pc.sendPackets(new S_SystemMessage("LAW: "
							+ (int) Config.RATE_LA));
					pc.sendPackets(new S_SystemMessage("KARMA: "
							+ (int) Config.RATE_KARMA));
					pc.sendPackets(new S_SystemMessage("WEIGHT: "
							+ (int) Config.RATE_WEIGHT_LIMIT));
				}
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					".rates ([XP,ADENA,DROP,LAW,KARMA,WEIGHT,ALL] VALUE) | RESET"));
			pc.sendPackets(new S_SystemMessage("XP: " + (int) Config.RATE_XP));
			pc.sendPackets(new S_SystemMessage("ADENA: "
					+ (int) Config.RATE_DROP_ADENA));
			pc.sendPackets(new S_SystemMessage("DROP: "
					+ (int) Config.RATE_DROP_ITEMS));
			pc.sendPackets(new S_SystemMessage("LAW: " + (int) Config.RATE_LA));
			pc.sendPackets(new S_SystemMessage("KARMA: "
					+ (int) Config.RATE_KARMA));
			pc.sendPackets(new S_SystemMessage("WEIGHT: "
					+ (int) Config.RATE_WEIGHT_LIMIT));
		}
		if (!changed.equals("Error")) {
			if (changed.equals("RESET")) {
				broadcastToAll("Rates have been reset to x1.0.");
			} else {
				broadcastToAll("Rates for " + changed + " changed by x" + data
						+ ".");
			}
		}
	}

	private void broadcastToAll(String s) {
		L1World.getInstance().broadcastPacketToAll(new S_SystemMessage(s));
	}
}
