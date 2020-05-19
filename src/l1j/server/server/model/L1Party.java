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
import l1j.server.server.serverpackets.S_HPMeter;
import l1j.server.server.serverpackets.S_Party;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.model:
// L1Party

public class L1Party {

	private final List<L1PcInstance> _membersList = new ArrayList<L1PcInstance>();

	private L1PcInstance _leader = null;

	public void addMember(L1PcInstance pc) {
		if (pc == null) {
			throw new NullPointerException();
		}
		if (_membersList.size() == Config.MAX_PT && !_leader.isGm()
				|| _membersList.contains(pc)) {
			return;
		}

		if (_membersList.isEmpty()) {
			setLeader(pc);
		} else {
			createMiniHp(pc);
		}

		_membersList.add(pc);
		pc.setParty(this);
		showAddPartyInfo(pc);
		pc.startRefreshParty();
	}

	private void removeMember(L1PcInstance pc) {
		if (!_membersList.contains(pc)) {
			return;
		}

		_membersList.remove(pc);
		pc.setParty(null);
		if (!_membersList.isEmpty()) {
			deleteMiniHp(pc);
		}
	}

	public boolean isVacancy() {
		return _membersList.size() < Config.MAX_PT;
	}

	public int getVacancy() {
		return Config.MAX_PT - _membersList.size();
	}

	public boolean isMember(L1PcInstance pc) {
		return _membersList.contains(pc);
	}

	private void setLeader(L1PcInstance pc) {
		_leader = pc;
	}
	
	public void passLeader(L1PcInstance pc) {
		pc.getParty().setLeader(pc);
		
		for (L1PcInstance member : getMembers()) {
			member.sendPackets(new S_Party(106, pc));
		}
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

	private void createMiniHp(L1PcInstance pc) {
		L1PcInstance[] members = getMembers();

		for (L1PcInstance member : members) {
			member.sendPackets(new S_HPMeter(pc.getId(), 100
					* pc.getCurrentHp() / pc.getMaxHp()));
			pc.sendPackets(new S_HPMeter(member.getId(), 100
					* member.getCurrentHp() / member.getMaxHp()));
		}
	}

	private void deleteMiniHp(L1PcInstance pc) {
		L1PcInstance[] members = getMembers();

		for (L1PcInstance member : members) {
			pc.sendPackets(new S_HPMeter(member.getId(), 0xff));
			member.sendPackets(new S_HPMeter(pc.getId(), 0xff));
		}
	}

	public void updateMiniHP(L1PcInstance pc) {
		L1PcInstance[] members = getMembers();

		for (L1PcInstance member : members) {
			member.sendPackets(new S_HPMeter(pc.getId(), 100
					* pc.getCurrentHp() / pc.getMaxHp()));
		}
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
				breakup();
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
			breakup();
		} else {
			removeMember(pc);
			
			for (L1PcInstance member : getMembers()) {
				sendLeftMessage(member, pc);
			}
			
			sendLeftMessage(pc, pc);
		}
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

	private void showAddPartyInfo(L1PcInstance pc) {
		for (L1PcInstance member : getMembers()) {
			if (pc.getId() == getLeader().getId() && getNumOfMembers() == 1) {
				continue;
			}
			
			if (pc.getId() == member.getId()) {
				pc.sendPackets(new S_Party(104, pc));
			} else {
				member.sendPackets(new S_Party(105, pc));
			}
			
			member.sendPackets(new S_Party(110, member));
			createMiniHp(member);
		}
	}
}
