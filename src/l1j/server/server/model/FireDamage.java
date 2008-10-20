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

import static l1j.server.server.model.skill.L1SkillId.FIRE_WALL; 
import l1j.server.ThreadPools.GeneralThreadPool;
import l1j.server.server.ActionCodes; 
import l1j.server.server.model.L1Character; 
import l1j.server.server.model.L1Magic; 
import l1j.server.server.model.L1World; 
import l1j.server.server.model.Instance.L1EffectInstance; 
import l1j.server.server.model.Instance.L1PcInstance; 
import l1j.server.server.model.Instance.L1NpcInstance; 
import l1j.server.server.model.Instance.L1MonsterInstance; 
import l1j.server.server.serverpackets.S_DoActionGFX; 
import l1j.server.server.model.L1Object; 

public class FireDamage{ 

   private L1Character user = null; 
   private L1EffectInstance fire = null; 

   public FireDamage(L1Character cha,L1NpcInstance firewall){       
      user = (L1Character) cha; 
      fire = (L1EffectInstance) firewall; 
   } 

   class Damage implements Runnable{ 

      private Damage(){ 
      }    

      @Override 
      public void run(){       
         for (int findObjecCounts = 0; findObjecCounts < 8; findObjecCounts ++) { 
            try{ 
               for (L1Object objects : L1World.getInstance(). 
                        getVisibleObjects(user, 15)) { 
                  if (objects instanceof L1PcInstance) { 

                     L1PcInstance pc = (L1PcInstance) objects; 
                     if (pc.getLocation().equals(fire.getLocation())) { 

                        if (pc.isDead() 
                           || pc.getZoneType() == 1 
                           || DamageRegeneration(pc) 
                           || pc.hasSkillEffect(50) 
                           || pc.hasSkillEffect(78) 
                           || pc.hasSkillEffect(80) 
                           || pc.hasSkillEffect(157)) 
                           continue; 

                        L1Magic _magic = new L1Magic(user, pc); 
                        int damage = _magic.calcMagicDamage(FIRE_WALL); 

                        if (damage == 0) 
                           continue; 

                        pc.sendPackets(new S_DoActionGFX(pc.getId(), 
                              ActionCodes.ACTION_Damage)); 
                        pc.broadcastPacket(new S_DoActionGFX(pc.getId(), 
                              ActionCodes.ACTION_Damage)); 
                        pc.receiveDamage(user, damage); 
                        pc.removeSkillEffect(66); 
                     }    

                  } else if (objects instanceof L1MonsterInstance) { 

                     L1MonsterInstance npc = (L1MonsterInstance) objects; 
                     if (npc.getLocation().equals(fire.getLocation())) { 

                        if (npc.isDead() 
                           || npc.getHiddenStatus() != 0 
                           || DamageRegeneration(npc) 
                           || npc.hasSkillEffect(50) 
                           || npc.hasSkillEffect(78) 
                           || npc.hasSkillEffect(80) 
                           || npc.hasSkillEffect(157)) 
                           continue; 

                        L1Magic _magic = new L1Magic(user, npc); 
                        int damage = _magic.calcMagicDamage(FIRE_WALL);                         
                        if (damage == 0 ) 
                           continue; 

                        npc.broadcastPacket(new S_DoActionGFX(npc.getId(), 
                              ActionCodes.ACTION_Damage)); 

                        npc.receiveDamage(user, damage); 
                        npc.removeSkillEffect(66); 
                     } 
                  } 
               }                
            Thread.sleep(12 * 100);             
            }catch(Exception ex){}             
         } 
      } 
   } 

      public void onDamageAction(){ 
         Damage damage_run = new Damage(); 
         GeneralThreadPool.getInstance().execute(damage_run);          
    
      } 
      private boolean DamageRegeneration(L1Character cha){ 
         if(cha.hasSkillEffect(99999)) 
            return true; 
         cha.setSkillEffect(99999, 1000); 
         return false;                
      } 
} 
