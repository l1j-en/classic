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

import java.util.Calendar;

import l1j.server.server.ClientThread;
import l1j.server.server.model.L1DragonSlayer;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SendLocation;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.utils.L1SpawnUtil;

public class C_SendLocation extends ClientBasePacket {

	private static final String C_SEND_LOCATION = "[C] C_SendLocation";

	public C_SendLocation(byte abyte0[], ClientThread client) {
		super(abyte0);
		int type = readC();

		if (type == 0x0d) {
			return;
		}

		if (type == 0x0b) {
			String name = readS();
			int mapId = readH();
			int x = readH();
			int y = readH();
			int msgId = readC();

			if (name.isEmpty()) {
				return;
			}
			L1PcInstance target = L1World.getInstance().getPlayer(name);
			if (target != null) {
				L1PcInstance pc = client.getActiveChar();
				String sender = pc.getName();
				target.sendPackets(new S_SendLocation(type, sender, mapId, x, y,
						msgId));
				pc.sendPackets(new S_ServerMessage(1783, name));
			}
		} else if (type == 0x06) {
			readD();
			int gate = readD();
			int dragonGate[] = { 81273, 81274, 81275, 81276 };
			L1PcInstance pc = client.getActiveChar();
			if (gate >= 0 && gate <= 3) {
				Calendar nowTime = Calendar.getInstance();
				if (nowTime.get(Calendar.HOUR_OF_DAY) >= 8 && nowTime.get(Calendar.HOUR_OF_DAY) < 12) {
					pc.sendPackets(new S_ServerMessage(1643));
				} else {
					boolean limit = true;
					switch (gate) {
						case 0:
							for (int i = 0; i < 6; i++) {
								if (!L1DragonSlayer.getInstance().getPortalNumber()[i]) {
									limit = false;
								}
							}
							break;
						case 1:
							for (int i = 6; i < 12; i++) {
								if (!L1DragonSlayer.getInstance().getPortalNumber()[i]) {
									limit = false;
								}
							}
							break;
					}
					if (!limit) {
						if (!pc.getInventory().consumeItem(47010, 1)) {
							pc.sendPackets(new S_ServerMessage(1567));
							return;
						}
						L1SpawnUtil.spawn(pc, dragonGate[gate], 6, 120 * 60 * 1000);
					}
				}
			}
		}
	}

	@Override
	public String getType() {
		return C_SEND_LOCATION;
	}
}