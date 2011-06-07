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

package l1j.server.server.serverpackets;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import l1j.server.server.Opcodes;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_PetList extends ServerBasePacket {

	private static Logger _log = Logger.getLogger(S_PetList.class.getName());
	private static final String S_PETLIST = "[S] S_PetList";
	private byte[] _byte = null;

	public S_PetList(int npcObjId, L1PcInstance pc) {
		buildPacket(npcObjId, pc);
	}

	private void buildPacket(int npcObjId, L1PcInstance pc) {
		List<L1ItemInstance> amuletList = new ArrayList<L1ItemInstance>();
		for (Object itemObject : pc.getInventory().getItems()) {
			L1ItemInstance item = (L1ItemInstance) itemObject;
			if (item.getItem().getItemId() == 40314
					|| item.getItem().getItemId() == 40316) {
				if (!isWithdraw(pc, item)) {
					amuletList.add(item);
				}
			}
		}
		if (amuletList.size() != 0) {
			writeC(Opcodes.S_OPCODE_SELECTLIST);
			writeD(0x00000046); // Price
			writeH(amuletList.size());
			for (L1ItemInstance item : amuletList) {
				writeD(item.getId());
				writeC(item.getCount());
			}
		}
	}

	private boolean isWithdraw(L1PcInstance pc, L1ItemInstance item) {
		Object[] petlist = pc.getPetList().values().toArray();
		for (Object petObject : petlist) {
			if (petObject instanceof L1PetInstance) {
				L1PetInstance pet = (L1PetInstance) petObject;
				if (item.getId() == pet.getItemObjId()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return S_PETLIST;
	}
}
