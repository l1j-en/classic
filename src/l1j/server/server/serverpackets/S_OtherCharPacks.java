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

import l1j.server.server.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_OtherCharPacks

public class S_OtherCharPacks extends ServerBasePacket {

	private static final String S_OTHER_CHAR_PACKS = "[S] S_OtherCharPacks";
	private byte[] _byte = null;

	private static final int STATUS_INVISIBLE = 2;
	private static final int STATUS_PC = 4;
	private static final int STATUS_BRAVE = 16;
	private static final int STATUS_ELFBRAVE = 32;
	private static final int STATUS_FASTMOVABLE = 64;

	public S_OtherCharPacks(L1PcInstance pc) {
		int status = STATUS_PC;
		int light = pc.isLightOn() ? 14 : 0;

		if (pc.isInvisble()) {
			status |= STATUS_INVISIBLE;
			light = 0; // if the state INBIJI Wright OFF
		}
		if (pc.isBrave()) {
			status |= STATUS_BRAVE;
			if (pc.isElf()) {
				status |= STATUS_ELFBRAVE;
			}
		}
		if (pc.isFastMovable()) {
			status |= STATUS_FASTMOVABLE;
		}

		// int addbyte = 0;
		// int addbyte1 = 1;

		writeC(Opcodes.S_OPCODE_CHARPACK);
		writeH(pc.getX());
		writeH(pc.getY());
		writeD(pc.getId());
		writeH(pc.getTempCharGfx());
		if (pc.isDead()) {
			writeC(pc.getStatus());
		} else {
			writeC(pc.getCurrentWeapon());
		}
		writeC(pc.getHeading());
		// writeC(0); // makes char invis (0x01), cannot move. spells display
		writeC(light); // status (0x01 = running)
		writeC(pc.getMoveSpeed());
		writeD(0x0000); // exp
		// writeC(0x00);
		writeH(pc.getLawful());
		writeS(pc.getName());
		writeS(pc.getTitle());
		writeC(status);
		writeD(pc.getClanid());
		writeS(pc.getClanname()); // Clan name
		writeS(null);
		writeC(0);
		/*
		 * if(pc.is_isInParty()) // During Party { writeC(100 * pc.get_currentHp() /
		 * pc.get_maxHp()); } else { writeC(0xFF); }
		 */

		writeC(0xFF);
		writeC(0); // 
		writeC(0); // PC = 0, Mon = Lv
		writeC(0); //
		writeC(0xFF);
		writeC(0xFF);
		/*
		 * // _log.finest((new StringBuilder()).append("OtherCharPack ownchar :
		 * ").append(pc.get_name()).toString()); writeC(68); writeH(pc.get_x());
		 * writeH(cha.get_y()); writeD(pc.get_objectId());
		 * writeH(pc.get_tempchargfx());
		 * writeC(pc.get_status()+pc.get_currentWeapon()); // status
		 * writeC(pc.get_heading()); writeC(0); // makes char invis (0x01),
		 * cannot move. spells display writeC(light); // status (0x01 = running)
		 * writeC(pc.get_movespeed()); writeH(0x0000); // exp writeC(0x00);
		 * writeH(pc.get_lawful()); writeS(pc.get_name());
		 * writeS(pc.getTitle()); writeC(sta); writeD(0x00000000); writeC(0x00);
		 * writeH(0x0000); writeD(0x000000FF); //Perimeter get drunk and change? writeH(0xFFFF);
		 * writeD(GameTimeController.getInstance().getGameTime()); //GameTime Assuming //
		 * writeH(0x001B); // writeC(0x84);
		 */
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	public String getType() {
		return S_OTHER_CHAR_PACKS;
	}

}