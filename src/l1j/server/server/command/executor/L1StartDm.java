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

import l1j.server.server.datatables.UBTable;
import l1j.server.server.model.L1UltimateBattle;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1StartDm implements L1CommandExecutor {

	private L1StartDm() {

	}

	public static L1CommandExecutor getInstance() {

		return new L1StartDm();

	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer st = new StringTokenizer(arg);
			int startid = Integer.parseInt(st.nextToken().trim());
			// String startid = st.nextToken().toInt();
			// System.out.println(name);
			for (L1UltimateBattle ub : UBTable.getInstance().getAllUb()) {
				// System.out.println(ub.getUbName());
				if (!ub.isActive() && ub.getUbId() == startid) {

					L1World world = L1World.getInstance();

					ub.start(); // UB Start
					world.broadcastServerMessage("\\fR[******] The "
							+ ub.getUbName() + " Deathmatch will begin in 5");

					world.broadcastServerMessage("\\fR         minutes. Please enter the colosseum now.");

				}

			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(cmdName + " DM_ID"));
		}

	}

}
