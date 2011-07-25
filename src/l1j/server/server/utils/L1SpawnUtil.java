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
package l1j.server.server.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

import l1j.server.server.ActionCodes;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.L1DragonSlayer;
import l1j.server.server.model.L1NpcDeleteTimer;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_NPCPack;
import l1j.server.server.serverpackets.S_ServerMessage;

public class L1SpawnUtil {
	private static Logger _log = Logger.getLogger(L1SpawnUtil.class.getName());
	private static Random _random = new Random();
	
	public static void spawn(L1PcInstance pc, int npcId, int randomRange,
            int timeMillisToDelete) {
    try {
            L1NpcInstance npc = NpcTable.getInstance().newNpcInstance(npcId);
            npc.setId(IdFactory.getInstance().nextId());
            npc.setMap(pc.getMapId());
            if (randomRange == 0) {
                    npc.getLocation().set(pc.getLocation());
                    npc.getLocation().forward(pc.getHeading());
            } else {
                    int tryCount = 0;
                    do {
                            tryCount++;
                            npc.setX(pc.getX() + _random.nextInt(randomRange) - _random.nextInt(randomRange));
                            npc.setY(pc.getY() + _random.nextInt(randomRange) - _random.nextInt(randomRange));
                            if (npc.getMap().isInMap(npc.getLocation())
                                && npc.getMap().isPassable(npc.getLocation())) {
                                break;
                            }
                            Thread.sleep(1);
                    } while (tryCount < 50);

                    if (tryCount >= 50) {
                            npc.getLocation().set(pc.getLocation());
                            npc.getLocation().forward(pc.getHeading());
                    }
            }

            npc.setHomeX(npc.getX());
            npc.setHomeY(npc.getY());
            npc.setHeading(pc.getHeading());
            
            if (npc.get_npcId() == 81273) {
                    for (int i = 0; i < 6; i++) {
                            if (!L1DragonSlayer.getInstance().getPortalNumber()[i]) {
                                    L1DragonSlayer.getInstance().setPortalNumber(i, true);
                                    L1DragonSlayer.getInstance().resetDragonSlayer(i);
                                    npc.setPortalNumber(i);
                                    L1DragonSlayer.getInstance().portalPack()[i] = npc;
                                    break;
                            }
                    }
            } else if (npc.get_npcId() == 81274) {
                    for (int i = 6; i < 12; i++) {
                            if (!L1DragonSlayer.getInstance().getPortalNumber()[i]) {
                                    L1DragonSlayer.getInstance().setPortalNumber(i, true);
                                    L1DragonSlayer.getInstance().resetDragonSlayer(i);
                                    npc.setPortalNumber(i);
                                    L1DragonSlayer.getInstance().portalPack()[i] = npc;
                                    break;
                            }
                    }
            }
            L1World.getInstance().storeObject(npc);
            L1World.getInstance().addVisibleObject(npc);

            if (npc.getTempCharGfx() == 7548 || npc.getTempCharGfx() == 7550 
            		|| npc.getTempCharGfx() == 7552
                    || npc.getTempCharGfx() == 7554 
                    || npc.getTempCharGfx() == 7585 
                    || npc.getTempCharGfx() == 7591) {
                    npc.broadcastPacket(new S_NPCPack(npc));
                    npc.broadcastPacket(new S_DoActionGFX(npc.getId(), ActionCodes.ACTION_AxeWalk));
            } else if (npc.getTempCharGfx() == 7539 || npc.getTempCharGfx() == 7557 
            		|| npc.getTempCharGfx() == 7558
                    || npc.getTempCharGfx() == 7864 
                    || npc.getTempCharGfx() == 7869 
                    || npc.getTempCharGfx() == 7870) {
                    for (L1PcInstance _pc : L1World.getInstance().getVisiblePlayer(npc, 50)) {
                            if (npc.getTempCharGfx() == 7539) {
                                    _pc.sendPackets(new S_ServerMessage(1570));
                            } else if (npc.getTempCharGfx() == 7864) {
                                    _pc.sendPackets(new S_ServerMessage(1657));
                            }
                            npc.onPerceive(_pc);
                            S_DoActionGFX gfx = new S_DoActionGFX(npc.getId(), ActionCodes.ACTION_AxeWalk);
                            _pc.sendPackets(gfx);
                    }
                    npc.npcSleepTime(ActionCodes.ACTION_AxeWalk, L1NpcInstance.ATTACK_SPEED);
            } else if (npc.getTempCharGfx() == 145) {
                    npc.setStatus(11);
                    npc.broadcastPacket(new S_NPCPack(npc));
                    npc.broadcastPacket(new S_DoActionGFX(npc.getId(), ActionCodes.ACTION_Appear));
                    npc.setStatus(0);
                    npc.broadcastPacket(new S_CharVisualUpdate(npc, npc.getStatus()));
            }

            npc.turnOnOffLight();
            npc.startChat(L1NpcInstance.CHAT_TIMING_APPEARANCE);
            if (0 < timeMillisToDelete) {
                    L1NpcDeleteTimer timer = new L1NpcDeleteTimer(npc,
                                    timeMillisToDelete);
                    timer.begin();
            }
    } catch (Exception e) {
            _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
    }
  }
}