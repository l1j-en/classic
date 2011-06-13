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

import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.serverpackets.S_PetInventory;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_PetMenu extends ClientBasePacket {

	private static final String C_PET_MENU = "[C] C_PetMenu";
	private static Logger _log = Logger.getLogger(C_PetMenu.class.getName());

	public C_PetMenu(byte abyte0[], ClientThread clientthread)throws Exception {
		super(abyte0);

		int petId = readD();

		L1PetInstance pet = (L1PetInstance) L1World.getInstance().findObject(petId);
		L1PcInstance pc = clientthread.getActiveChar();

		if (pet != null && pc != null) {
			pc.sendPackets(new S_PetInventory(pet));
		}
	}

	@Override
	public String getType() {
		return C_PET_MENU;
	}
}