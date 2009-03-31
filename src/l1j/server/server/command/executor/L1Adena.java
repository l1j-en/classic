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
import java.util.logging.Logger;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Adena implements L1CommandExecutor {
	private static Logger _log = Logger.getLogger(L1Adena.class.getName());

	private L1Adena() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Adena();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer stringtokenizer = new StringTokenizer(arg);
			int count = Integer.parseInt(stringtokenizer.nextToken());

			L1ItemInstance adena = pc.getInventory().storeItem(L1ItemId.ADENA,
					count);
			if (adena != null) {
				pc.sendPackets(new S_SystemMessage((new StringBuilder())
						.append(count).append(" adena created").toString()));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage((new StringBuilder()).append(
					" amount").toString()));
		}
	}
}
