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

import static l1j.server.server.model.skill.L1SkillId.SHAPE_CHANGE;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_DoActionGFX;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_ExtraCommand extends ClientBasePacket {
	private static final String C_EXTRA_COMMAND = "[C] C_ExtraCommand";

	public C_ExtraCommand(byte abyte0[], Client client) throws Exception {
		super(abyte0);
		int actionId = readC();
		L1PcInstance pc = client.getActiveChar();

		if (pc.isGhost()) {
			return;
		}

		if (pc.isInvisble()) {
			return;
		}

		if (pc.isTeleport()) {
			return;
		}

		if (pc.hasSkillEffect(SHAPE_CHANGE)) {
			int gfxId = pc.getTempCharGfx();
			if (gfxId != 6080 && gfxId != 6094) {
				return;
			}
		}
		S_DoActionGFX gfx = new S_DoActionGFX(pc.getId(), actionId);
		pc.broadcastPacket(gfx);
	}

	@Override
	public String getType() {
		return C_EXTRA_COMMAND;
	}
}