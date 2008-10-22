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
package l1j.server.server.model;

import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.map.L1Map;
import l1j.server.server.serverpackets.S_Paralysis;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_Teleport;

public class L1Teleport {

	public static final int TELEPORT = 0;

	public static final int CHANGE_POSITION = 1;

	public static final int ADVANCED_MASS_TELEPORT = 2;

	public static final int CALL_CLAN = 3;

	public static final int[] EFFECT_SPR = { 169, 2235, 2236, 2281 };

	public static final int[] EFFECT_TIME = { 280, 440, 440, 1120 };

	private L1Teleport() {
	}

	public static void teleport(L1PcInstance pc, L1Location loc, int head,
			boolean effectable) {
		teleport(pc, loc.getX(), loc.getY(), (short) loc.getMapId(), head,
				effectable, TELEPORT);
	}

	public static void teleport(L1PcInstance pc, L1Location loc, int head,
			boolean effectable, int skillType) {
		teleport(pc, loc.getX(), loc.getY(), (short) loc.getMapId(), head,
				effectable, skillType);
	}

	public static void teleport(L1PcInstance pc, int x, int y, short mapid,
			int head, boolean effectable) {
		teleport(pc, x, y, mapid, head, effectable, TELEPORT);
	}

	public static void teleport(L1PcInstance pc, int x, int y, short mapId,
			int head, boolean effectable, int skillType) {
		pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_TELEPORT_UNLOCK,false)); 
		if (effectable && (skillType >= 0 && skillType <= EFFECT_SPR.length)) {
			S_SkillSound packet = new S_SkillSound(pc.getId(),
					EFFECT_SPR[skillType]);
			pc.sendPackets(packet);
			pc.broadcastPacket(packet);

			try {
				Thread.sleep((int) (EFFECT_TIME[skillType] * 0.7));
			} catch (Exception e) {
			}
		}

		pc.setTeleportX(x);
		pc.setTeleportY(y);
		pc.setTeleportMapId(mapId);
		pc.setTeleportHeading(head);
		pc.sendPackets(new S_Teleport(pc));
	}

	public static void teleportToTargetFront(L1Character cha,
			L1Character target, int distance) {
		int locX = target.getX();
		int locY = target.getY();
		int heading = target.getHeading();
		L1Map map = target.getMap();
		short mapId = target.getMapId();

		switch (heading) {
		case 1:
			locX += distance;
			locY -= distance;
			break;

		case 2:
			locX += distance;
			break;

		case 3:
			locX += distance;
			locY += distance;
			break;

		case 4:
			locY += distance;
			break;

		case 5:
			locX -= distance;
			locY += distance;
			break;

		case 6:
			locX -= distance;
			break;

		case 7:
			locX -= distance;
			locY -= distance;
			break;

		case 0:
			locY -= distance;
			break;

		default:
			break;

		}

		if (map.isPassable(locX, locY)) {
			if (cha instanceof L1PcInstance) {
				teleport((L1PcInstance) cha, locX, locY, mapId, cha
						.getHeading(), true);
			} else if (cha instanceof L1NpcInstance) {
				((L1NpcInstance) cha).teleport(locX, locY, cha.getHeading());
			}
		}
	}

	public static void randomTeleport(L1PcInstance pc, boolean effectable) {
		L1Location newLocation = pc.getLocation().randomLocation(200, true);
		int newX = newLocation.getX();
		int newY = newLocation.getY();
		short mapId = (short) newLocation.getMapId();

		L1Teleport.teleport(pc, newX, newY, mapId, 5, effectable);
	}
}
