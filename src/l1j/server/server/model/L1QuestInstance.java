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

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ChangeHeading;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.templates.L1Npc;

public class L1QuestInstance extends L1NpcInstance { 

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private static Logger _log = Logger.getLogger(L1QuestInstance.class 
         .getName()); 

   private L1QuestInstance _npc = this; 

   public L1QuestInstance(L1Npc template) { 
      super(template); 
   } 

   @Override 
   public void onNpcAI() { 
      if (isAiRunning()) { 
         return; 
      } 
      setActived(false); 
      startAI(); 
   } 

   @Override 
   public void onAction(L1PcInstance pc) { 
      L1Attack attack = new L1Attack(pc, this); 
      if (attack.calcHit()) { 
         attack.calcDamage(); 
         attack.calcStaffOfMana(); 
         attack.addPcPoisonAttack(pc, this); 
      } 
      attack.action(); 
      attack.commit(); 
   } 

   @Override 
   public void onTalkAction(L1PcInstance player) { 
      int pcx = player.getX(); 
      int pcy = player.getY(); 
      int npcx = getX(); 
      int npcy = getY(); 

      if (pcx == npcx && pcy < npcy) { 
         setHeading(0); 
      } else if (pcx > npcx && pcy < npcy) { 
         setHeading(1); 
      } else if (pcx > npcx && pcy == npcy) { 
         setHeading(2); 
      } else if (pcx > npcx && pcy > npcy) { 
         setHeading(3); 
      } else if (pcx == npcx && pcy > npcy) { 
         setHeading(4); 
      } else if (pcx < npcx && pcy > npcy) { 
         setHeading(5); 
      } else if (pcx < npcx && pcy == npcy) { 
         setHeading(6); 
      } else if (pcx < npcx && pcy < npcy) { 
         setHeading(7); 
      } 
      broadcastPacket(new S_ChangeHeading(this)); 

      if (getNpcTemplate().get_npcId() ==  71092 || getNpcTemplate().get_npcId() == 71093) { 
         if (player.isKnight() && player.getQuest().get_step(3) == 4) { 
                  player.sendPackets(new S_NPCTalkReturn(getId(), "searcherk1")); 
               } else { 
                  player.sendPackets(new S_NPCTalkReturn(getId(), "searcherk4")); 
               } 
      } else if (getNpcTemplate().get_npcId() == 71094) { 
         if (player.isDarkelf() && player.getQuest().get_step(4) == 1) { 
                  player.sendPackets(new S_NPCTalkReturn(getId(), "endiaq1")); 
               } else { 
                  player.sendPackets(new S_NPCTalkReturn(getId(), "endiaq4")); 
               } 
      } 

      synchronized (this) { 
         if (_monitor != null) { 
            _monitor.cancel(); 
         } 
         setRest(true); 
         _monitor = new RestMonitor(); 
         _restTimer.schedule(_monitor, REST_MILLISEC); 
      } 
   } 

   @Override 
   public void onFinalAction(L1PcInstance pc, String action) { 
      if (action.equalsIgnoreCase("start")) { 
         if ((getNpcTemplate().get_npcId() == 71092 || getNpcTemplate().get_npcId() == 71093) 
            && pc.isKnight() && pc.getQuest().get_step(3) == 4) { 
            L1Npc l1npc = NpcTable.getInstance().getTemplate(71093); 
            L1FollowerInstance follow = new L1FollowerInstance(l1npc, this, pc); 
            pc.sendPackets(new S_NPCTalkReturn(getId(), "")); 
         } else if (getNpcTemplate().get_npcId() == 71094 
            && pc.isDarkelf() && pc.getQuest().get_step(4) == 1) { 
            L1Npc l1npc = NpcTable.getInstance().getTemplate(71094); 
            L1FollowerInstance follow = new L1FollowerInstance(l1npc, this, pc); 
            pc.sendPackets(new S_NPCTalkReturn(getId(), "")); 
         } 
      } 
   } 

   private static final long REST_MILLISEC = 10000; 

   private static final Timer _restTimer = new Timer(true); 

   private RestMonitor _monitor; 

   public class RestMonitor extends TimerTask { 
      @Override 
      public void run() { 
         setRest(false); 
      } 
   } 

}
