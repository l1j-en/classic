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
package l1j.server.server.model;

import java.util.ArrayList;
import java.util.List;

import l1j.server.Config;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.model:
// L1ChatParty

public class L1ChatParty {

	private final List<L1PcInstance> _membersList = new ArrayList<L1PcInstance>();

	private L1PcInstance _leader = null;

	public void addMember(L1PcInstance pc) {
		if (pc == null) {
			throw new NullPointerException();
		}
		if (_membersList.size() == Config.MAX_CHAT_PT && !_leader.isGm()
				|| _membersList.contains(pc)) {
			return;
		}

		if (_membersList.isEmpty()) {
			setLeader(pc);
		}

		_membersList.add(pc);
		pc.setChatParty(this);
	}

	private void removeMember(L1PcInstance pc) {
		if (!_membersList.contains(pc)) {
			return;
		}

		_membersList.remove(pc);
		pc.setChatParty(null);
	}

	public boolean isVacancy() {
		return _membersList.size() < Config.MAX_CHAT_PT;
	}

	public int getVacancy() {
		return Config.MAX_CHAT_PT - _membersList.size();
	}

	public boolean isMember(L1PcInstance pc) {
		return _membersList.contains(pc);
	}

	private void setLeader(L1PcInstance pc) {
		_leader = pc;
	}

	public L1PcInstance getLeader() {
		return _leader;
	}

	public boolean isLeader(L1PcInstance pc) {
		return pc.getId() == _leader.getId();
	}

	public String getMembersNameList() {
		String _result = new String("");
		for (L1PcInstance pc : _membersList) {
			_result = _result + pc.getName() + " ";
		}
		return _result;
	}

	private void breakup() {
		L1PcInstance[] members = getMembers();

		for (L1PcInstance member : members) {
			removeMember(member);
			member.sendPackets(new S_ServerMessage(418));
		}
	}

	public void leaveMember(L1PcInstance pc) {
		L1PcInstance[] members = getMembers();
		if (isLeader(pc)) {
			breakup();
		} else {
			if (getNumOfMembers() == 2) {
				removeMember(pc);
				L1PcInstance leader = getLeader();
				removeMember(leader);

				sendLeftMessage(pc, pc);
				sendLeftMessage(leader, pc);
			} else {
				removeMember(pc);
				for (L1PcInstance member : members) {
					sendLeftMessage(member, pc);
				}
				sendLeftMessage(pc, pc);
			}
		}
	}

	public void kickMember(L1PcInstance pc) {
		if (getNumOfMembers() == 2) {
			removeMember(pc);
			L1PcInstance leader = getLeader();
			removeMember(leader);
		} else {
			removeMember(pc);
		}
		pc.sendPackets(new S_ServerMessage(419));
	}

	public L1PcInstance[] getMembers() {
		return _membersList.toArray(new L1PcInstance[_membersList.size()]);
	}

	public int getNumOfMembers() {
		return _membersList.size();
	}

	private void sendLeftMessage(L1PcInstance sendTo, L1PcInstance left) {
		sendTo.sendPackets(new S_ServerMessage(420, left.getName()));
	}

}
