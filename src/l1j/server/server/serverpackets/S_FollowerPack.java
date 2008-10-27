/* 
 * This program is free software; you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation; either version 2, or (at your option) 
 * any later version. 
 * 
 * This program is distributed in the hope that it will be useful , 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 * GNU General Public License for more details. 
 * 
 * You should have received a copy of the GNU General Public License 
 * along with this program; if not , write to the Free Software 
 * Foundation , Inc., 59 Temple Place - Suite 330, Boston , MA 
 * 02111-1307, USA. 
 * 
 * http://www.gnu.org/copyleft/gpl.html 
 */ 

package l1j.server.server.serverpackets; 

import java.util.logging.Logger; 

import l1j.server.server.Opcodes; 
import l1j.server.server.model.L1FollowerInstance;
import l1j.server.server.model.Instance.L1PcInstance; 

// Referenced classes of package l1j.server.server.serverpackets: 
// ServerBasePacket , S_DollPack 

public class S_FollowerPack extends ServerBasePacket { 

   private static Logger _log = Logger.getLogger(S_FollowerPack.class.getName()); 
   private static final String S_FOLLOWERPACK = "[S] S_FollowerPack"; 
   private byte[] _byte = null; 

   public S_FollowerPack(L1FollowerInstance pet, L1PcInstance player) { 
      writeC(Opcodes.S_OPCODE_CHARPACK); 
      writeH(pet.getX()); 
      writeH(pet.getY()); 
      writeD(pet.getId()); 
      writeH(pet.getGfxId()); 
      writeC(pet.getStatus()); 
      writeC(pet.getHeading()); 
      writeC(pet.getLightSize()); 
      writeC(pet.getMoveSpeed()); 
      writeD(0); 
      writeH(0); 
      writeS(pet.getNameId()); 
      writeS(pet.getTitle()); 
      writeC(0); 
      writeD(0); 
      writeS(null); 
      writeS(null); 
      writeC(0); 
      writeC(0xFF); 
      writeC(0); 
      writeC(pet.getLevel()); 
      writeC(0); 
      writeC(0xFF); 
      writeC(0xFF); 
   } 

   @Override 
   public byte[] getContent() { 
      if (_byte == null) { 
         _byte = _bao.toByteArray(); 
      } 

      return _byte; 
   } 

   public String getType() { 
      return S_FOLLOWERPACK; 
   } 

}
