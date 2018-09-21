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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.GetBackTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_OwnCharPack;
import l1j.server.server.templates.L1GetBack;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_Ship extends ClientBasePacket {

	private static final String C_SHIP = "[C] C_Ship";
	private static final int MAX_DISTANCE = 20;
	private static Logger _log = LoggerFactory.getLogger(C_Ship.class.getName());

	public C_Ship(byte abyte0[], Client client) {
		super(abyte0);

		// ignore these and look up the information from the DB instead
		int shipMapId = readH(); //shipMapId
		int locX = readH(); //locX
		int locY = readH(); //locY
		
		L1PcInstance pc = client.getActiveChar();
		int mapId = pc.getMapId();
		L1GetBack getBack = GetBackTable.getInstance().getBackByMapId(mapId);
		
		// if it is null, they're not on a boat, and if the coord is not in the acceptable range, crap out
		// since the coord seems to be a few places around the dock, and I didn't want to bother finding them all
		// I am just doing a generic check for them being within <MAX_DISTANCE> cells of the place the client is trying to send
		if(getBack == null || !validXCoord(getBack, locX) || !validYCoord(getBack, locY)) {
			_log.warn(String.format("%s attempted to exploit C_SHIP to move to X: %d, Y: %d, MapId: %d.", pc.getName(), locX, locY, shipMapId));
			return;
		}

		if (mapId == 5) { // Talking Island Ship to Aden Mainland
			pc.getInventory().consumeItem(40299, 1);
		} else if (mapId == 6) { // Aden Mainland Ship to Talking Island
			pc.getInventory().consumeItem(40298, 1);
		} else if (mapId == 83) { // Forgotten Island Ship to Aden Mainland
			pc.getInventory().consumeItem(40300, 1);
		} else if (mapId == 84) { // Aden Mainland Ship to Forgotten Island
			pc.getInventory().consumeItem(40301, 1);
		} else if (mapId == 446) { // Ship Hidden dock to Pirate island
			pc.getInventory().consumeItem(40303, 1);
		} else if (mapId == 447) { // Ship Pirate island to Hidden dock
			pc.getInventory().consumeItem(40302, 1);
		} else {
			return; // since this should only work with ships, return if they're not on a ship!
		}
		
		pc.sendPackets(new S_OwnCharPack(pc));
		L1Teleport.teleport(pc, locX, locY, (short) getBack.getGetback_mapid(), 0, false);
	}

	@Override
	public String getType() {
		return C_SHIP;
	}
	
	// the getback loc is just a rough idea, so we check to see if they are within 20 cells of this
	private boolean validXCoord(L1GetBack getBack, int x) {
		int minX = x - MAX_DISTANCE;
		int maxX = x + MAX_DISTANCE;
		
		return (getBack.getGetback_x1() >= minX && getBack.getGetback_x1() <= maxX) 
				|| (getBack.getGetback_x2() >= minX && getBack.getGetback_x2() <= maxX)
				|| (getBack.getGetback_x3() >= minX && getBack.getGetback_x3() <= maxX);
	}
	
	// the getback loc is just a rough idea, so we check to see if they are within 20 cells of this
	private boolean validYCoord(L1GetBack getBack, int y) {
		int minY = y - MAX_DISTANCE;
		int maxY = y + MAX_DISTANCE;
		
		return (getBack.getGetback_y1() >= minY && getBack.getGetback_y1() <= maxY)
				|| (getBack.getGetback_y2() >= minY && getBack.getGetback_y2() <= maxY)
				|| (getBack.getGetback_y3() >= minY && getBack.getGetback_y3() <= maxY);
	}
}