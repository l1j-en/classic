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

import l1j.server.server.ClientThread;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_SelectTarget extends ClientBasePacket {

	private static final String C_SELECT_TARGET = "[C] C_SelectTarget";

	public C_SelectTarget(byte abyte0[], ClientThread clientthread)
			throws Exception {
		super(abyte0);

		int petId = readD();
		int type = readC();
		int targetId = readD();

		L1PetInstance pet = (L1PetInstance) L1World.getInstance().findObject(
				petId);
		L1Character target = (L1Character) L1World.getInstance().findObject(
				targetId);

		if (pet != null && target != null) {
			if (target instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) target;
				// checkNonPvP checks the altsetting, but we also always want pets not to attack PCs in safety zones.
				if (pc.checkNonPvP(pc, pet) || pc.getLocation().getMap().isSafetyZone(pc.getLocation())) {
					return;
				}
			}
			pet.setMasterTarget(target);
		}
	}

	@Override
	public String getType() {
		return C_SELECT_TARGET;
	}
}