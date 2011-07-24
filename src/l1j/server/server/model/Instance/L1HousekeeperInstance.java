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

import java.util.Calendar;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.datatables.HouseTable;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1World;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1House;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.StringUtil;

public class L1HousekeeperInstance extends L1NpcInstance {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private static Logger _log = Logger.getLogger(L1HousekeeperInstance.class
                        .getName());
        /**
         * @param template
         */
        public L1HousekeeperInstance(L1Npc template) {
                super(template);
        }

        @Override
        public void onAction(L1PcInstance pc) {
                onAction(pc, 0);
        }

        public void onAction(L1PcInstance pc, int skillId) {
                L1Attack attack = new L1Attack(pc, this);
                attack.calcHit();
                attack.action();
                attack.addChaserAttack();
                attack.calcDamage();
                attack.addPcPoisonAttack(pc, this);
                attack.commit();
        }

        @Override
        public void onTalkAction(L1PcInstance pc) {
                int objid = getId();
                L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
                                getNpcTemplate().get_npcId());
                int npcid = getNpcTemplate().get_npcId();
                String htmlid = null;
                String[] htmldata = null;
                boolean isOwner = false;

                if (talking != null) {
                        L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
                        if (clan != null) {
                                int houseId = clan.getHouseId();
                                if (houseId != 0) {
                                        L1House house = HouseTable.getInstance().getHouseTable(
                                                        houseId);
                                        if (npcid == house.getKeeperId()) {
                                                isOwner = true;
                                        }
                                }
                        }
                        if (!isOwner) {
                                // Housekeeper
                                L1House targetHouse = null;
                                for (L1House house : HouseTable.getInstance()
                                                .getHouseTableList()) {
                                        if (npcid == house.getKeeperId()) {
                                                targetHouse = house;
                                                break;
                                        }
                                }
                                
                                boolean isOccupy = false;
                                String clanName = null;
                                String leaderName = null;
                                for (L1Clan targetClan : L1World.getInstance().getAllClans()) {
                                        if (targetHouse.getHouseId() == targetClan.getHouseId()) {
                                                isOccupy = true;
                                                clanName = targetClan.getClanName();
                                                leaderName = targetClan.getLeaderName();
                                                break;
                                        }
                                }
                                if (isOccupy) {
                                        htmlid = "agname";
                                        htmldata = new String[] { clanName, leaderName,
                                                        targetHouse.getHouseName() };
                                } else {
                                        htmlid = "agnoname";
                                        htmldata = new String[] { targetHouse.getHouseName() };
                                }
                        }
                        if (htmlid != null) {
                                if (htmldata != null) {
                                        pc.sendPackets(new S_NPCTalkReturn(objid, htmlid,
                                                                        htmldata));
                                } else {
                                        pc.sendPackets(new S_NPCTalkReturn(objid, htmlid));
                                }
                        } else {
                                if (pc.getLawful() < -1000) {
                                        pc.sendPackets(new S_NPCTalkReturn(talking, objid, 2));
                                } else {
                                        pc.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
                                }
                        }
                }
        }

        @Override
        public void onFinalAction(L1PcInstance pc, String action) {
        }

        public void doFinalAction(L1PcInstance pc) {
        }

        private static final int FEE_AMOUNT = 2000;

        public void payFree(L1PcInstance pc) {
                if (!pc.getInventory().checkItem(L1ItemId.ADENA, FEE_AMOUNT)) {
                        pc.sendPackets(new S_ServerMessage(189));
                        return;
                }

                L1House house = HouseTable.getInstance().findByKeeperId(get_npcId());
                Calendar cal = house.getTaxDeadline();
                cal.add(Calendar.DATE, Config.HOUSE_TAX_INTERVAL);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                HouseTable.getInstance().updateHouse(house);
                pc.getInventory().consumeItem(L1ItemId.ADENA, FEE_AMOUNT);
        }

        public String[] makeHouseTaxStrings(L1PcInstance pc) {
                L1House house = HouseTable.getInstance().findByKeeperId(get_npcId());
                Calendar cal = house.getTaxDeadline();
                int month = cal.get(Calendar.MONTH) + 1;
                int day = cal.get(Calendar.DATE);
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                return StringUtil.newArray(getNameId(), FEE_AMOUNT, month, day, hour);
        }
}