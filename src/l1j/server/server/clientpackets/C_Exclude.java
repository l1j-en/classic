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
package l1j.server.server.clientpackets;

import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ExcludeTable;
import l1j.server.server.model.L1ExcludingList;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1CharName;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_Exclude extends ClientBasePacket {

	private static final String C_EXCLUDE = "[C] C_Exclude";
	private static Logger _log = Logger.getLogger(C_Exclude.class.getName());

	public C_Exclude(byte[] decrypt, ClientThread client) {
		super(decrypt);
		String name = readS();
		if (name.isEmpty()) {
			return;
		}
		L1PcInstance pc = client.getActiveChar();
		try {
			ExcludeTable excludeTable = ExcludeTable.getInstance();
			L1ExcludingList exList = excludeTable.getExcludeList(pc.getId());
			if (exList.isFull()) {
				pc.sendPackets(new S_ServerMessage(472));
				return;
			}
			if (exList.containsName(name)) {
				excludeTable.removeExclude(pc.getId(), name);
				pc.sendPackets(new S_PacketBox(S_PacketBox.REM_EXCLUDE, name));
			} else {
				for (L1CharName cn : CharacterTable.getInstance().getCharNameList()) {
					if (name.equalsIgnoreCase(cn.getName())) {
						int objId = cn.getId();
						String n = cn.getName();
						exList.add(objId, n);
						excludeTable.addExclude(pc.getId(), objId, n);
						break;
					}
				}
				pc.sendPackets(new S_PacketBox(S_PacketBox.ADD_EXCLUDE, name));
			}
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	@Override
	public String getType() {
		return C_EXCLUDE;
	}
}