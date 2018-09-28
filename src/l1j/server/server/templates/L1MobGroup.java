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

import java.util.Collections;
import java.util.List;

import l1j.server.server.utils.collections.Lists;

public class L1MobGroup {
	private final int _id;
	private final int _leaderId;
	private final List<L1NpcCount> _minions = Lists.newArrayList();
	private final boolean _isRemoveGroupIfLeaderDie;

	public L1MobGroup(int id, int leaderId, List<L1NpcCount> minions,
			boolean isRemoveGroupIfLeaderDie) {
		_id = id;
		_leaderId = leaderId;
		_minions.addAll(minions); // QRs[As
		_isRemoveGroupIfLeaderDie = isRemoveGroupIfLeaderDie;
	}

	public int getId() {
		return _id;
	}

	public int getLeaderId() {
		return _leaderId;
	}

	public List<L1NpcCount> getMinions() {
		return Collections.unmodifiableList(_minions);
	}

	public boolean isRemoveGroupIfLeaderDie() {
		return _isRemoveGroupIfLeaderDie;
	}

}
