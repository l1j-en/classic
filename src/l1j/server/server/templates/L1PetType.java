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
package l1j.server.server.templates;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.utils.IntRange;

public class L1PetType {
	private final int _baseNpcId;

	private final L1Npc _baseNpcTemplate;

	private final String _name;

	private final int _itemIdForTaming;

	private final IntRange _hpUpRange;

	private final IntRange _mpUpRange;

	private final int _npcIdForEvolving;

	private final int _msgIds[];

	private final int _defyMsgId;

	public L1PetType(int baseNpcId, String name, int itemIdForTaming,
			IntRange hpUpRange, IntRange mpUpRange, int npcIdForEvolving,
			int msgIds[], int defyMsgId) {
		_baseNpcId = baseNpcId;
		_baseNpcTemplate = NpcTable.getInstance().getTemplate(baseNpcId);
		_name = name;
		_itemIdForTaming = itemIdForTaming;
		_hpUpRange = hpUpRange;
		_mpUpRange = mpUpRange;
		_npcIdForEvolving = npcIdForEvolving;
		_msgIds = msgIds;
		_defyMsgId = defyMsgId;
	}

	public int getBaseNpcId() {
		return _baseNpcId;
	}

	public L1Npc getBaseNpcTemplate() {
		return _baseNpcTemplate;
	}

	public String getName() {
		return _name;
	}

	public int getItemIdForTaming() {
		return _itemIdForTaming;
	}

	public boolean canTame() {
		return _itemIdForTaming != 0;
	}

	public IntRange getHpUpRange() {
		return _hpUpRange;
	}

	public IntRange getMpUpRange() {
		return _mpUpRange;
	}

	public int getNpcIdForEvolving() {
		return _npcIdForEvolving;
	}

	public boolean canEvolve() {
		return _npcIdForEvolving != 0;
	}

	public int getMessageId(int num) {
		if (num == 0) {
			return 0;
		}
		return _msgIds[num - 1];
	}

	public static int getMessageNumber(int level) {
		if (50 <= level) {
			return 5;
		}
		if (48 <= level) {
			return 4;
		}
		if (36 <= level) {
			return 3;
		}
		if (24 <= level) {
			return 2;
		}
		if (12 <= level) {
			return 1;
		}
		return 0;
	}

	public int getDefyMessageId() {
		return _defyMsgId;
	}

}
