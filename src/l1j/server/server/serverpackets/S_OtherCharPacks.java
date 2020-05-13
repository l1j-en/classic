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

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_OtherCharPacks
public class S_OtherCharPacks extends ServerBasePacket {
	private static final String S_OTHER_CHAR_PACKS = "[S] S_OtherCharPacks";
////	private static Logger _log = LoggerFactory.getLogger(S_OtherCharPacks.class
//			.getName());
	private static final int STATUS_POISON = 1;
	private static final int STATUS_INVISIBLE = 2;
	private static final int STATUS_PC = 4;
//	private static final int STATUS_FREEZE = 8;
	private static final int STATUS_BRAVE = 16;
	private static final int STATUS_ELFBRAVE = 32;
	private static final int STATUS_FASTMOVABLE = 64;
//	private static final int STATUS_GHOST = 128;
	private byte[] _byte = null;

	public S_OtherCharPacks(L1PcInstance pc, boolean isFindInvis) {
		buildPacket(pc, isFindInvis);
	}

	public S_OtherCharPacks(L1PcInstance pc) {
		buildPacket(pc, false);
	}

	private void buildPacket(L1PcInstance pc, boolean isFindInvis) {
		if(pc.getSpoofMob() != null && pc.isGm()) {
			L1NpcInstance npcTemplate = pc.getSpoofMob();
			npcTemplate.setStatus(0);
			npcTemplate.setLocation(pc.getLocation());
			npcTemplate.setHeading(pc.getHeading());
			npcTemplate.setId(pc.getId());
			
			new S_NPCPack(npcTemplate, this);
			return;
		}
		
		int status = STATUS_PC;

		if (pc.getPoison() != null) {
			if (pc.getPoison().getEffectId() == 1) {
				status |= STATUS_POISON;
			}
		}
		if (pc.isInvisble() && !isFindInvis) {
			status |= STATUS_INVISIBLE;
		}
		if (pc.isBrave()) {
			status |= STATUS_BRAVE;
		}
		if (pc.isElfBrave()) {
			status |= STATUS_BRAVE;
			status |= STATUS_ELFBRAVE;
		}
		if (pc.isFastMovable()) {
			status |= STATUS_FASTMOVABLE;
		}
		writeC(Opcodes.S_OPCODE_CHARPACK);
		writeH(pc.getX());
		writeH(pc.getY());
		writeD(pc.getId());
		if (pc.isDead()) {
			writeH(pc.getTempCharGfxAtDead());
		} else {
			writeH(pc.getTempCharGfx());
		}
		if (pc.isDead()) {
			writeC(pc.getStatus());
		} else {
			writeC(pc.getCurrentWeapon());
		}
		writeC(pc.getHeading());
		// writeC(0); // makes char invis (0x01), cannot move. spells display
		writeC(pc.getChaLightSize());
		writeC(pc.getMoveSpeed());
		writeD(0x0000); // exp
		// writeC(0x00);
		writeH(pc.getLawful());
		
		if(pc.isGm() && pc.getSpoofName() != null) {
			writeS(pc.getSpoofName());
		} else {
			writeS(pc.getName() + (isFindInvis && pc.isInvisble() ? "[*]" : ""));
		}
		
		writeS(pc.getTitle());
		writeC(status);
		writeD(pc.getClanid());
		writeS(pc.getClanname()); // Clan name
		writeS(null);
		writeC(0);
		writeC(0xFF);
		writeC(0); //TODO -- 0x08 for third speed?
		writeC(0); // PC = 0, Mon = Lv
		writeC(0); //
		writeC(0xFF);
		writeC(0xFF);
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
		return S_OTHER_CHAR_PACKS;
	}
}