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

package l1j.server.server.model.Instance;

import l1j.server.server.datatables.NpcSpawnTable;
import l1j.server.server.serverpackets.S_Board;
import l1j.server.server.serverpackets.S_BoardRead;
import l1j.server.server.serverpackets.S_Ranking;
import l1j.server.server.templates.L1Npc;

public class L1BoardInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;

	public L1BoardInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance player) {
		player.sendPackets(new S_Board(this, player));
	}

	public void onAction(L1PcInstance player, int number) {
		player.sendPackets(new S_Board(this, number, player));
	}

	public void onActionRead(L1PcInstance player, int number) {
		if (this.getSpawn() != NpcSpawnTable.bugBoard)
			player.sendPackets(new S_BoardRead(number));
		else
			player.sendPackets(new S_BoardRead(player, number));
	}

	public void onRanking(L1PcInstance player) {
		player.sendPackets(new S_Ranking(this));
	}

	public void onRankingRead(L1PcInstance player, int number) {
		player.sendPackets(new S_Ranking(player, number));
	}

}
