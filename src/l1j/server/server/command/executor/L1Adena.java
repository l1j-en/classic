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
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Adena implements L1CommandExecutor {

	private L1Adena() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Adena();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer tok = new StringTokenizer(arg);
			L1PcInstance target = pc;
			String char_name = pc.getName();
			
			//if they passed all 3 values, get the user they passed
			if (tok.countTokens() == 2){
				char_name = tok.nextToken();
				target = L1World.getInstance().getPlayer(char_name);
			}
			
			int count = Integer.parseInt(tok.nextToken());

			L1ItemInstance adena = target.getInventory().storeItem(L1ItemId.ADENA,
					count);
			if (adena != null) {
				pc.sendPackets(new S_SystemMessage(
						String.format("%d adena given to %s.", count, char_name)));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <amount> or .%1$s <player> <amount>", cmdName)));
		}
	}
}
