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

import java.util.logging.Logger;

import l1j.server.server.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_SkillBuy extends ServerBasePacket {
	public S_SkillBuy(int o, L1PcInstance player) {
		//Not used
		//int C = 0;
		int C = 0;
		int count = Scount(player);
		//Not used
		//boolean own = false;
		boolean own = false;

		writeC(Opcodes.S_OPCODE_SKILLBUY);
		writeD(100);
		writeH(count);
		for (int k = 0; k < count; k++) {
			/*
			 * C = C; if(chk(player, k + 1) == true) { own = true; } else { own =
			 * false; }
			 * 
			 * if(own == true) { C = C + 1; } else { C = C; } writeD(k + C);
			 */
			writeD(k);
		}
	}

	public int Scount(L1PcInstance player) {
		int RC = 0;
		// int TC = 0;
		switch (player.getType()) {
		case 0: // Prince
			/*
			 * if (player.get_level() >= 10 && player.get_level() <= 19) { RC =
			 * 8; } else if (player.get_level() >= 20) { RC = 16; }
			 */

			RC = 16;
			break;

		case 1: // Knight
			/*
			 * if (player.get_level() >= 50) { RC = 8; }
			 */

			RC = 8;
			break;

		case 2: // Elf
			/*
			 * if (player.get_level() >= 8 && player.get_level() <= 15) { RC =
			 * 8; } else if (player.get_level() >= 16 && player.get_level() <=
			 * 23) { RC = 16; } else if (player.get_level() >= 24) { RC = 23; }
			 */

			RC = 23;
			break;

		case 3: // WIZ
			/*
			 * if (player.get_level() >= 4 && player.get_level() <= 7) { RC = 8; }
			 * else if (player.get_level() >= 8 && player.get_level() <= 11) {
			 * RC = 16; } else if (player.get_level() >= 12) { RC = 23; }
			 */

			RC = 23;
			break;

		case 4: // DE
			/*
			 * if (player.get_level() >= 12 && player.get_level() <= 23) { RC =
			 * 8; } else if (player.get_level() >= 24) { RC = 16; }
			 */

			RC = 16;
			break;

		default:
			break;
		}
		return RC;
		/*
		 * for(int i = 0 ; i < RC ; ++i) { if(chk(player, i) == false) { TC++; } }
		 * return TC;
		 */
	}

	/*
	 * public boolean chk(L1PcInstance player, int i) { boolean have = false;
	 * try { Connection connection = null; connection =
	 * L1DatabaseFactory.getInstance().getConnection(); PreparedStatement
	 * preparedstatement = connection.prepareStatement("SELECT * FROM
	 * character_skills WHERE char_obj_id=?"); preparedstatement.setInt(1,
	 * player.get_objectId()); ResultSet resultset =
	 * preparedstatement.executeQuery(); while (resultset.next()) { int b =
	 * resultset.getInt(3); if (i == b) { have = true; } } resultset.close();
	 * preparedstatement.close(); connection.close(); } catch (Exception
	 * exception) { } return have; }
	 */
	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return _S__1B_SKILLBUY;
	}

	private static final String _S__1B_SKILLBUY = "[S] S_SkillBuy";

	@SuppressWarnings("unused")
	private static Logger _log = Logger.getLogger(S_SkillBuy.class.getName());
}
