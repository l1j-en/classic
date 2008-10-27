package l1j.server.server.model; 

import java.lang.reflect.Constructor;
import java.util.logging.Logger;

import l1j.server.server.IdFactory;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1QuestInstance;
import l1j.server.server.serverpackets.S_FollowerPack;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;

public class L1FollowerInstance extends L1NpcInstance { 
   private static final long serialVersionUID = 1L; 

   private static Logger _log = Logger.getLogger(L1FollowerInstance.class 
         .getName()); 

   public boolean noTarget() { 
      L1NpcInstance targetNpc = null; 
      for (L1Object object : L1World.getInstance().getVisibleObjects(this)) { 
         if (object instanceof L1NpcInstance) { 
            L1NpcInstance npc = (L1NpcInstance) object; 
            if (npc.getNpcTemplate().get_npcId() == 70740 // $2267 
                  && getNpcTemplate().get_npcId() == 71093) { // $2257 
               setParalyzed(true); 
               L1PcInstance pc = (L1PcInstance) _master; 
               if (!pc.getInventory().checkItem(40593)) { 
                  createNewItem(pc, 40593, 1); 
               } 
               deleteMe(); 
               return true; 
            } else if (npc.getNpcTemplate().get_npcId() == 70811 // $484 
                  && getNpcTemplate().get_npcId() == 71094) { // $2659 
               setParalyzed(true); 
               L1PcInstance pc = (L1PcInstance) _master; 
               if (!pc.getInventory().checkItem(40582)) { 
                  createNewItem(pc, 40582, 1); 
               } 
               deleteMe(); 
               return true; 
            } 
         } 
      } 

      if (_master.isDead() || getLocation().getTileLineDistance(_master.getLocation()) > 10) { 
         setParalyzed(true); 
         spawn(getNpcTemplate().get_npcId(), getX(), getY(), getHeading(), getMapId()); 
         deleteMe(); 
         return true; 
      } else if (_master != null && _master.getMapId() == getMapId()) { 
         if (getLocation().getTileLineDistance(_master.getLocation()) > 2) { 
            setDirectionMove(moveDirection(_master.getX(), _master.getY())); 
            setSleepTime(calcSleepTime(getPassispeed(), MOVE_SPEED)); 
         } 
      } 
      return false; 
   } 

   public L1FollowerInstance(L1Npc template, L1NpcInstance target, L1Character master) { 
      super(template); 

      _master = master; 

      setId(IdFactory.getInstance().nextId()); 

      setMaster(master); 
      setX(target.getX()); 
      setY(target.getY()); 
      setMap(target.getMapId()); 
      setHeading(target.getHeading()); 
      setLightSize(target.getLightSize()); 
       
      target.setParalyzed(true); 
      target.deleteMe(); 

      L1World.getInstance().storeObject(this); 
      L1World.getInstance().addVisibleObject(this); 
      for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(this)) { 
         onPerceive(pc); 
      } 

      startAI(); 
      master.addFollower(this); 
   } 

   @Override 
   public synchronized void deleteMe() { 
      _master.getFollowerList().remove(getId()); 
      getMap().setPassable(getLocation(), true); 
      super.deleteMe(); 
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
      if (isDead()) { 
         return; 
      } 
      if (getNpcTemplate().get_npcId() == 71093) { 
         if (_master.equals(player)) { 
            player.sendPackets(new S_NPCTalkReturn(getId(), "searcherk2")); 
         } else { 
            player.sendPackets(new S_NPCTalkReturn(getId(), "searcherk4")); 
         } 
      } else if (getNpcTemplate().get_npcId() == 71094) { 
         if (_master.equals(player)) { 
            player.sendPackets(new S_NPCTalkReturn(getId(), "endiaq2")); 
         } else { 
            player.sendPackets(new S_NPCTalkReturn(getId(), "endiaq4")); 
         } 
      } 
   } 

   @Override 
   public void onPerceive(L1PcInstance perceivedFrom) { 
      perceivedFrom.addKnownObject(this); 
      perceivedFrom.sendPackets(new S_FollowerPack(this, perceivedFrom)); 
   } 

   private void createNewItem(L1PcInstance pc, int item_id, int count) { 
      L1ItemInstance item = ItemTable.getInstance().createItem(item_id); 
      item.setCount(count); 
      if (item != null) { 
         if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) { 
            pc.getInventory().storeItem(item); 
         } else { 
            L1World.getInstance().getInventory(pc.getX(), pc.getY(), 
                  pc.getMapId()).storeItem(item); 
         } 
         pc.sendPackets(new S_ServerMessage(403, item.getLogName())); 
      } 
   } 

   public void spawn(int npcId, int X, int Y, int H, short Map) { 
      L1Npc l1npc = NpcTable.getInstance().getTemplate(npcId); 
      if (l1npc != null) { 
         L1NpcInstance mob = null; 
         try { 
            String implementationName = l1npc.getImpl(); 
            Constructor _constructor = Class.forName((new StringBuilder()).append("l1j.server.server.model.Instance.").append(implementationName).append("Instance").toString()).getConstructors()[0]; 
            mob = (L1NpcInstance) _constructor.newInstance(new Object[] { l1npc }); 
            mob.setId(IdFactory.getInstance().nextId()); 
            mob.setX(X); 
            mob.setY(Y); 
            mob.setHomeX(X); 
            mob.setHomeY(Y); 
            mob.setMap(Map); 
            mob.setHeading(H); 
            L1World.getInstance().storeObject(mob); 
            L1World.getInstance().addVisibleObject(mob); 
            L1Object object = L1World.getInstance().findObject(mob.getId()); 
            L1QuestInstance newnpc = (L1QuestInstance) object; 
            newnpc.onNpcAI(); 
         } catch (Exception e) { 
            e.printStackTrace(); 
         } 
      } 
   } 

}
