/* This program is free software; you can redistribute it and/or modify
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

import static l1j.server.server.model.Instance.L1PcInstance.REGENSTATE_MOVE;

import l1j.server.config.Config;
import l1j.server.server.ClientThread;
import l1j.server.server.model.AcceleratorChecker;
import l1j.server.server.model.Dungeon;
import l1j.server.server.model.DungeonRandom;
import l1j.server.server.model.Instance.L1PcInstance;
import static l1j.server.server.model.skill.L1SkillId.*;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.trap.L1WorldTraps;
import l1j.server.server.serverpackets.S_MoveCharPacket;
import l1j.server.server.serverpackets.S_SystemMessage;
//import l1j.server.server.serverpackets.S_SystemMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_MoveChar extends ClientBasePacket {
	private static final String C_MOVE_CHAR = "[C] C_MoveChar";

	@SuppressWarnings("unused")
	private void sendMapTileLog(L1PcInstance pc) {  
		pc.sendPackets(new S_SystemMessage(pc.getMap().toString( pc.getLocation()))); 
	} 
	
	public C_MoveChar(byte decrypt[], ClientThread client) throws Exception {
		super(decrypt);
		int locx = readH();
		int locy = readH();
		int heading = readC();

		L1PcInstance pc = client.getActiveChar();

		if (pc.isTeleport()) { 
			return;
		}

		if (Config.CHECK_MOVE_INTERVAL) {
			int result;
			result = pc.getAcceleratorChecker()
					.checkInterval(AcceleratorChecker.ACT_TYPE.MOVE);
			if (result == AcceleratorChecker.R_DISCONNECTED) {
				return;
			}
		}

		pc.killSkillEffectTimer(MEDITATION);

		if (!pc.hasSkillEffect(ABSOLUTE_BARRIER)) { 
			pc.setRegenState(REGENSTATE_MOVE);
		}
		pc.getMap().setPassable(pc.getLocation(), true);

		switch (heading) {
		case 1: // '\001'
			locx++;
			locy--;
			break;

		case 2: // '\002'
			locx++;
			break;

		case 3: // '\003'
			locx++;
			locy++;
			break;

		case 4: // '\004'
			locy++;
			break;

		case 5: // '\005'
			locx--;
			locy++;
			break;

		case 6: // '\006'
			locx--;
			break;

		case 7: // '\007'
			locx--;
			locy--;
			break;

		case 0: // '\0'
			locy--;
			break;
		}

		if (Dungeon.getInstance().dg(locx, locy, pc.getMap().getId(), pc)) { 
			return;
		}
		if (DungeonRandom.getInstance().dg(locx, locy, pc.getMap().getId(),
				pc)) { 
			return;
		}

		L1Location oldLoc = pc.getLocation();
		if ((oldLoc.getX() + 10 < locx) || (oldLoc.getX() - 10 > locx) 
				|| (oldLoc.getY() + 10 < locy) || (oldLoc.getX() - 10 > locx))
		{
			return;
		}
		pc.getLocation().set(locx, locy);
		pc.setHeading(heading);
		if (!pc.isGmInvis() && !pc.isGhost() && !pc.isInvisble()) {
			pc.broadcastPacket(new S_MoveCharPacket(pc));
		}

		// sendMapTileLog(pc); 

		L1WorldTraps.getInstance().onPlayerMoved(pc);

		pc.getMap().setPassable(pc.getLocation(), false);
		// user.UpdateObject(); 
	}

	@Override
	public String getType() {
		return C_MOVE_CHAR;
	}
}