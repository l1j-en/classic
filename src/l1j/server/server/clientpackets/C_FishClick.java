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
 * 
 * # FishingThread.java - Team Void Factory
 * 
 */

package l1j.server.server.clientpackets;

import java.util.logging.Logger;
import java.util.Random;

import l1j.server.server.ActionCodes;
import l1j.server.server.ClientThread;
import l1j.server.server.FishingTimeController;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1World;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_FishClick extends ClientBasePacket {

	private static final String C_FISHCLICK = "[C] C_FishClick";
	private static Logger _log = Logger.getLogger(C_FishClick.class.getName());
	private static Random _random = new Random();

	public C_FishClick(byte abyte0[], ClientThread clientthread) throws Exception {
		super(abyte0);
		L1PcInstance pc = clientthread.getActiveChar();
		long currentTime = System.currentTimeMillis();
		long time = pc.getFishingTime();

		if (currentTime < (time + 500) && currentTime > (time - 500)
				&& pc.isFishingReady()) {
			finishFishing(pc);

			int chance = _random.nextInt(200) + 1;
			if (chance >= 0 && chance < 50) {
				successFishing(pc, 41298);
			} else if (chance >= 50 && chance < 65) {
				successFishing(pc, 41300);
			} else if (chance >= 65 && chance < 80) {
				successFishing(pc, 41299);
			} else if (chance >= 80 && chance < 90) {
				successFishing(pc, 41296);
			} else if (chance >= 90 && chance < 100) {
				successFishing(pc, 41297);
			} else if (chance >= 100 && chance < 105) {
				successFishing(pc, 41301);
			} else if (chance >= 105 && chance < 110) {
				successFishing(pc, 41302);
			} else if (chance >= 110 && chance < 115) {
				successFishing(pc, 41303);
			} else if (chance >= 115 && chance < 120) {
				successFishing(pc, 41304);
			} else if (chance >= 120 && chance < 123) {
				successFishing(pc, 41306);
			} else if (chance >= 123 && chance < 126) {
				successFishing(pc, 41307);
			} else if (chance >= 126 && chance < 129) {
				successFishing(pc, 41305);
			} else if (chance >= 129 && chance < 134) {
				successFishing(pc, 21051);
			} else if (chance >= 134 && chance < 139) {
				successFishing(pc, 21052);
			} else if (chance >= 139 && chance < 144) {
				successFishing(pc, 21053);
			} else if (chance >= 144 && chance < 159) {
				successFishing(pc, 21054);
			} else if (chance >= 159 && chance < 164) {
				successFishing(pc, 21055);
			} else if (chance >= 164 && chance < 169) {
				successFishing(pc, 21056);
			} else if (chance >= 170 && chance < 171) {
				successFishing(pc, 41252);
			} else {
				pc.sendPackets(new S_ServerMessage(1136, "")); //
			}
		} else {
			finishFishing(pc);
			pc.sendPackets(new S_ServerMessage(1136, "")); //
		}
	}

	private void finishFishing(L1PcInstance pc) {
		pc.setFishingTime(0);
		pc.setFishingReady(false);
		pc.setFishing(false);
		pc.sendPackets(new S_CharVisualUpdate(pc));
		pc.broadcastPacket(new S_CharVisualUpdate(pc));
		FishingTimeController.getInstance().removeMember(pc);
	}

	private void successFishing(L1PcInstance pc, int itemId) {
		String message = null;

		switch (itemId) {
		case 41296: 
			message = "$5249";
			break;

		case 41297: 
			message = "$5250";
			break;

		case 41298: 
			message = "$5256";
			break;

		case 41299: 
			message = "$5257";
			break;

		case 41300:
			message = "$5258";
			break;

		case 41301: 
			message = "$5259";
			break;

		case 41302: 
			message = "$5260";
			break;

		case 41303: 
			message = "$5261";
			break;

		case 41304: 
			message = "$5262";
			break;

		case 41305: 
			message = "$5264";
			break;

		case 41306: 
			message = "$5263";
			break;

		case 41307: 
			message = "$5265";
			break;

		case 21051: 
			message = "$5269";
			break;

		case 21052: 
			message = "$5270";
			break;

		case 21053: 
			message = "$5271";
			break;

		case 21054: 
			message = "$5272";
			break;

		case 21055: 
			message = "$5273";
			break;

		case 21056: 
			message = "$5274";
			break;

		case 41252: 
			message = "$5248";
			break;

		default:
			break;
		}

		L1ItemInstance item = ItemTable.getInstance().createItem(itemId);
		if (item != null) {
			item.startItemOwnerTimer(pc);
			L1World.getInstance().getInventory(pc.getX(), pc.getY(),
					pc.getMapId()).storeItem(item);
			pc.sendPackets(new S_ServerMessage(1185, message));
		}
	}

	@Override
	public String getType() {
		return C_FISHCLICK;
	}
}
