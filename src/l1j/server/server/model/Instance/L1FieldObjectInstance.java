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
package l1j.server.server.model.Instance;

import java.util.logging.Logger;

import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.L1HauntedHouse;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1FieldObjectInstance extends L1NpcInstance {

    private static final long serialVersionUID = 1L;
    private static Logger _log = Logger.getLogger(L1FieldObjectInstance.class.getName());

    public L1FieldObjectInstance(L1Npc template) {
            super(template);
    }

    @Override
    public void onAction(L1PcInstance pc) {
            if (getNpcTemplate().get_npcId() == 81171) {
                    if (L1HauntedHouse.getInstance().getHauntedHouseStatus() 
                    		== L1HauntedHouse.STATUS_PLAYING) {
                            int winnersCount = L1HauntedHouse.getInstance().getWinnersCount();
                            int goalCount = L1HauntedHouse.getInstance().getGoalCount();
                            if (winnersCount == goalCount + 1) {
                                    L1ItemInstance item = ItemTable.getInstance().createItem(49280);
                                    int count = 1;
                                    if (item != null) {
                                            if (pc.getInventory().checkAddItem(item, count) 
                                            		== L1Inventory.OK) {
                                                    item.setCount(count);
                                                    pc.getInventory().storeItem(item);
                                                    pc.sendPackets(new S_ServerMessage(403, item 
                                                    .getLogName()));
                                            }
                                    }
                                    L1HauntedHouse.getInstance().endHauntedHouse();
                            } else if (winnersCount > goalCount + 1) {
                                    L1HauntedHouse.getInstance().setGoalCount(goalCount + 1);
                                    L1HauntedHouse.getInstance().removeMember(pc);
                                    L1ItemInstance item = null;
                                    if (winnersCount == 3) {
                                            if (goalCount == 1) {
                                                    item = ItemTable.getInstance().createItem(49278);
                                            } else if (goalCount == 2) {
                                                    item = ItemTable.getInstance().createItem(49279);
                                            }
                                    } else if (winnersCount == 2) {
                                            item = ItemTable.getInstance() .createItem(49279);
                                    }
                                    int count = 1;
                                    if (item != null) {
                                            if (pc.getInventory().checkAddItem(item, count) 
                                            		== L1Inventory.OK) {
                                                    item.setCount(count);
                                                    pc.getInventory().storeItem(item);
                                                    pc.sendPackets(new S_ServerMessage(403, item 
                                                    .getLogName()));
                                            }
                                    }
                                    L1SkillUse l1skilluse = new L1SkillUse();
                                    l1skilluse.handleCommands(pc, CANCELLATION, pc.getId(), pc.getX(), 
                                    pc.getY(), null, 0, L1SkillUse.TYPE_LOGIN);
                                    L1Teleport.teleport(pc, 32624, 32813, (short) 4, 5, true);
                            }
                    }
            }
    }

    @Override
    public void deleteMe() {
            _destroyed = true;
            if (getInventory() != null) {
               getInventory().clearItems();
            }
            L1World.getInstance().removeVisibleObject(this);
            L1World.getInstance().removeObject(this);
            for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(this)) {
                 pc.removeKnownObject(this);
                 pc.sendPackets(new S_RemoveObject(this));
            }
            removeAllKnownObjects();
    }
}