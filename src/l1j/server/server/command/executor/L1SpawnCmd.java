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

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.L1SpawnUtil;

public class L1SpawnCmd implements L1CommandExecutor {
	private static Logger _log = LoggerFactory.getLogger(L1SpawnCmd.class.getName());

	private L1SpawnCmd() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1SpawnCmd();
	}

	private void sendErrorMessage(L1PcInstance pc, String cmdName) {
		String errorMsg = cmdName + " npcid|name [number] [area]";
		pc.sendPackets(new S_SystemMessage(errorMsg));
	}

	private int parseNpcId(String nameId) {
		int npcid = 0;
		try {
			npcid = Integer.parseInt(nameId);
		} catch (NumberFormatException e) {
			npcid = NpcTable.getInstance().findNpcIdByNameWithoutSpace(nameId);
		}
		return npcid;
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer tok = new StringTokenizer(arg);
			String nameId = tok.nextToken();
			int count = 1;
			if (tok.hasMoreTokens()) {
				count = Integer.parseInt(tok.nextToken());
			}
			int randomrange = 0;
			if (tok.hasMoreTokens()) {
				randomrange = Integer.parseInt(tok.nextToken(), 10);
			}
			int npcid = parseNpcId(nameId);

			L1Npc npc = NpcTable.getInstance().getTemplate(npcid);
			if (npc == null) {
				pc.sendPackets(new S_SystemMessage("Cannot find NPC."));
				return;
			}
			for (int i = 0; i < count; i++) {
				L1SpawnUtil.spawn(pc, npcid, randomrange, 0);
			}
			String msg = String.format(
					"%s(%d) (%d) has been summoned. (range: %d)",
					npc.get_name(), npcid, count, randomrange);
			pc.sendPackets(new S_SystemMessage(msg));
		} catch (NoSuchElementException e) {
			sendErrorMessage(pc, cmdName);
		} catch (NumberFormatException e) {
			sendErrorMessage(pc, cmdName);
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
			pc.sendPackets(new S_SystemMessage(cmdName + " error."));
		}
	}
}
