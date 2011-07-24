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

import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ClientThread;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ExpTable;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.classes.L1ClassFeature;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CharReset;
import l1j.server.server.serverpackets.S_OwnCharStatus;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_CharReset extends ClientBasePacket {
	private static final String C_CHAR_RESET = "[C] C_CharReset";
	private static Logger _log = Logger.getLogger(C_CharReset.class.getName());
	private L1ClassFeature classFeature = null;
/**
 * //zuy m 127.0.0.1 Request Work ID : 120 0000: 78 01 0d 0a 0b 0a 12 0d
 * 
 * //10y 127.0.0.1 Request Work ID : 120 0000: 78 02 07 00 //1y 127.0.0.1
 * Request Work ID : 120 0000: 78 02 00 04
 * 
 * // 127.0.0.1 Request Work ID : 120 0000: 78 02 08 00 x...
 * 
 * //\Z 127.0.0.1 Request Work ID : 120 0000: 78 03 23 0a 0b 17 12 0d
 */	

	public C_CharReset(byte abyte0[], ClientThread clientthread) {
		super(abyte0);
		final int[] ORIGINAL_STR
		= new int[] { 13, 16, 11, 8, 12, 13, 11 };
        final int[] ORIGINAL_DEX
		= new int[] { 10, 12, 12, 7, 15, 11, 10 };
        final int[] ORIGINAL_CON
		= new int[] { 10, 14, 12, 12, 8, 14, 12 };
        final int[] ORIGINAL_WIS
		= new int[] { 11, 9, 12, 12, 10, 12, 12 };
        final int[] ORIGINAL_CHA
		= new int[] { 13, 12, 9, 8, 9, 8, 8 };
        final int[] ORIGINAL_INT
		= new int[] { 10, 8, 12, 12, 11, 11, 12 };
       final int[] ORIGINAL_AMOUNT
		= new int[] { 8, 4, 7, 16, 10, 6, 10 };

       int stage;
       int str;
       int intel;
       int wis;
       int dex;
       int con;
       int cha;
       int statusAmount;

       L1PcInstance pc = clientthread.getActiveChar();
       byte level = (byte)ExpTable.getLevelByExp(pc.getExp());
       classFeature = L1ClassFeature.newClassFeature(pc.getType());

       if(!pc.isInCharReset()) {
	     return;
       }
      
       stage = readC();
       switch(stage)
       {
	   case 0x01:
		str = readC();
		intel = readC();
		wis = readC();
		dex = readC();
		con = readC();
		cha = readC();
		boolean isStatusError = false;
		int originalStr = ORIGINAL_STR[pc.getType()];
		int originalDex = ORIGINAL_DEX[pc.getType()];
		int originalCon = ORIGINAL_CON[pc.getType()];
		int originalWis = ORIGINAL_WIS[pc.getType()];
		int originalCha = ORIGINAL_CHA[pc.getType()];
		int originalInt = ORIGINAL_INT[pc.getType()];
		int originalAmount = ORIGINAL_AMOUNT[pc.getType()];
		if (str < originalStr || dex < originalDex
			|| con < originalCon || wis < originalWis
			|| cha < originalCha || intel < originalInt
			|| (str > originalStr + originalAmount
			|| dex > originalDex + originalAmount
			|| con > originalCon + originalAmount
			|| wis > originalWis + originalAmount
			|| cha > originalCha + originalAmount
			|| intel > originalInt + originalAmount)) 
		{
			isStatusError = true;
		}
		statusAmount = str + intel + wis + dex + con + cha;
		if (statusAmount != 75 || isStatusError) 
		{
			return;
		}
		int hp = classFeature.InitHp();
		int mp = classFeature.InitMp(pc.getBaseWis());
		pc.sendPackets(new S_CharReset(pc, 1, hp, mp, 10, str, intel, wis,
			dex, con, cha));
		initCharStatus(pc, hp, mp, str, intel, wis, dex, con, cha);
		CharacterTable.saveCharStatus(pc);
		break;
	    case 0x02:
		int type2 = readC();
		switch(type2)
		{
			case 0x00:
				if (level - pc.getTempLevel() < 1) 
				{
					return;
				}
				setLevelUp(pc, 1); 
				break;
			case 0x01: case 0x02: case 0x03: case 0x04:
			case 0x05: case 0x06:
				if(!checkMaxAttr(pc, type2)) return;
				setLevelUp(pc, 1);
				break;
			case 0x07:
				if (level - pc.getTempLevel() < 10) 
				{
					return;
				}
				setLevelUp(pc,10);
				break;
			case 0x08:
				if(!checkMaxAttr(pc, readC()))
				{
					return;
				}
				if (pc.getElixirStats() > 0) 
				{
					pc.sendPackets(new S_CharReset(pc.getElixirStats()));
					return;
				}
				saveNewCharStatus(pc);
				pc.setInCharReset(false);
				break;
			default:
				return;
		}
		break;
	    case 0x03:
		str = readC();
		intel = readC();
		wis = readC();
		dex = readC();
		con = readC();
		cha = readC();
		statusAmount = str + intel + wis + dex + con + cha;
		if(!checkMaxAttrForTwo(str)
			|| !checkMaxAttrForTwo(con)
			|| !checkMaxAttrForTwo(dex)
			|| !checkMaxAttrForTwo(wis)
			|| !checkMaxAttrForTwo(intel)
			|| !checkMaxAttrForTwo(cha))
		{
			return;
		}
		if((75 + pc.getElixirStats() + pc.getBonusStats())!= statusAmount)
		{
			return;
		}
		pc.addBaseStr((byte) (str - pc.getBaseStr()));
		pc.addBaseInt((byte) (intel - pc.getBaseInt()));
		pc.addBaseWis((byte) (wis - pc.getBaseWis()));
		pc.addBaseDex((byte) (dex - pc.getBaseDex()));
		pc.addBaseCon((byte) (con - pc.getBaseCon()));
		pc.addBaseCha((byte) (cha - pc.getBaseCha()));
		pc.setInCharReset(false);
		saveNewCharStatus(pc);
		break;
	    default:
		return;
        }
    }
    
	private boolean checkMaxAttr(L1PcInstance pc,int d) {

	int attr=1;
        
	switch(d)
        {
	case 1:
		attr+=pc.getBaseStr();
		break;
	case 2:
		attr+=pc.getBaseInt();
		break;
	case 3:
		attr+=pc.getBaseWis();
		break;
	case 4:
		attr+=pc.getBaseDex();
		break;
	case 5:
		attr+=pc.getBaseCon();
		break;
	case 6:
		attr+=pc.getBaseCha();
		break;
    }

	if(attr > Config.MAX_ABILITY) 
		return false;
	switch(d)
    {
	case 1:
		pc.addBaseStr((byte) 1);
		break;
	case 2:
		pc.addBaseInt((byte) 1);
		break;
	case 3:
		pc.addBaseWis((byte) 1);
		break;
	case 4:
		pc.addBaseDex((byte) 1);
		break;
	case 5:
		pc.addBaseCon((byte) 1);
		break;
	case 6:
		pc.addBaseCha((byte) 1);
		break;
        }
      return true;
   }
	
   private boolean checkMaxAttrForTwo(int attr) {

   if(attr > Math.max(Config.MAX_ABILITY2, Config.MAX_ABILITY)) {
	   return false;
   }
      return true;
   }

   private void saveNewCharStatus(L1PcInstance pc) {
    
	pc.setInCharReset(false);
   
    if(pc.getOriginalAc() > 0) {
	   pc.addAc(pc.getOriginalAc());
    }
    if(pc.getOriginalMr() > 0) {
	   pc.addMr(0 - pc.getOriginalMr());
    }

    pc.refresh();
    pc.setCurrentHp(pc.getMaxHp());
    pc.setCurrentMp(pc.getMaxMp());

    if (pc.getTempMaxLevel() != pc.getLevel()) {
	  pc.setLevel(pc.getTempMaxLevel());
	  pc.setExp(ExpTable.getExpByLevel(pc.getTempMaxLevel()));
    }
    if (pc.getLevel() > 50) {
	pc.setBonusStats(pc.getLevel() - 50);
    } else {
	   pc.setBonusStats(0);
    }
    
    pc.sendPackets(new S_OwnCharStatus(pc));
    L1Teleport.teleport(pc, 32628, 32772, (short) 4, 4, false);
    }

   private void initCharStatus(L1PcInstance pc, int hp, int mp, int str,
   int intel, int wis, int dex, int con, int cha) {
     pc.addBaseMaxHp((short)(hp - pc.getBaseMaxHp()));
     pc.addBaseMaxMp((short)(mp - pc.getBaseMaxMp()));
     pc.addBaseStr((byte)(str - pc.getBaseStr()));
     pc.addBaseInt((byte)(intel - pc.getBaseInt()));
     pc.addBaseWis((byte)(wis - pc.getBaseWis()));
     pc.addBaseDex((byte)(dex - pc.getBaseDex()));
     pc.addBaseCon((byte)(con - pc.getBaseCon()));
     pc.addBaseCha((byte)(cha - pc.getBaseCha()));
     pc.addMr(0 - pc.getMr());
     pc.addDmgup(0 - pc.getDmgup());
     pc.addHitup(0 - pc.getHitup());
   }
   
   private boolean setLevelUp(L1PcInstance pc ,int addLv) {
   classFeature = L1ClassFeature.newClassFeature(pc.getType());
     if((pc.getTempLevel()+ addLv) > pc.getLevel()) return false;
         pc.setTempLevel(pc.getTempLevel()+ addLv);
     for (int i = 0; i < addLv; i++) {
    	 short randomHp = (short)classFeature.calclvUpHp(pc.getCon());
    	 short randomMp = (short)classFeature.calclvUpMp(pc.getWis());
	 if (pc.getBaseMaxHp() + randomHp > classFeature.MaxHp()) {
		randomHp = 0;
	 }
	 if (pc.getBaseMaxMp() + randomMp > classFeature.MaxMp()) {
		randomMp = 0;
	 }
	    pc.addBaseMaxHp(randomHp);
	    pc.addBaseMaxMp(randomMp);
     }

     int newAc = classFeature.calcLvDex2AC(pc.getTempLevel(), pc.getDex());
   
     pc.sendPackets(new S_CharReset(pc,pc.getTempLevel(),
     pc.getBaseMaxHp(), pc.getBaseMaxMp(), newAc,
     pc.getBaseStr(), pc.getBaseInt(), pc.getBaseWis(),
     pc.getBaseDex(), pc.getBaseCon(), pc.getBaseCha()));
     return true;
   }

   private int getInitialHp (L1PcInstance pc) {
     int hp = 1;
     
     if (pc.isCrown()) {
	     hp = 14;
     } else if (pc.isKnight()) {
	     hp = 16;
     } else if (pc.isElf()) {
	     hp = 15;
     } else if (pc.isWizard()) {
	     hp = 12;
     } else if (pc.isDarkelf()) {
	     hp = 12;
     } else if (pc.isDragonKnight()) {
	     hp = 15;
     } else if (pc.isIllusionist()) {
	     hp = 15;
     }
     return hp;
   }

   private int getInitialMp (L1PcInstance pc) {
     int mp = 1;
     
     if (pc.isCrown()) {
	     switch (pc.getWis()) {
		 case 11:
			mp = 2;
			break;
		 case 12:
		 case 13:
		 case 14:
		 case 15:
			mp = 3;
			break;
		 case 16:
		 case 17:
		 case 18:
			mp = 4;
			break;
		 default:
			mp = 2;
			break;
	     }
     } else if (pc.isKnight()) {
	   switch (pc.getWis()) {
	   case 9:
	   case 10:
	   case 11:
		 mp = 1;
		 break;
	   case 12:
	   case 13:
		 mp = 2;
		 break;
	   default:
		 mp = 1;
		 break;
	    }
     } else if (pc.isElf()) {
	   switch (pc.getWis()) {
	   case 12:
	   case 13:
	   case 14:
	   case 15:
		 mp = 4;
		 break;
	   case 16:
	   case 17:
	   case 18:
		 mp = 6;
		 break;
	   default:
		 mp = 4;
		 break;
	   }
    } else if (pc.isWizard()) {
	  switch (pc.getWis()) {
	   case 12:
	   case 13:
	   case 14:
	   case 15:
	     mp = 6;
		 break;
	   case 16:
	   case 17:
	   case 18:
	 	 mp = 8;
		 break;
	 default:
		 mp = 6;
		 break;
	   }
    } else if (pc.isDarkelf()) {
	  switch (pc.getWis()) {
	    case 10:
	    case 11:
		  mp = 3;
		  break;
	    case 12:
	    case 13:
	    case 14:
	    case 15:
		  mp = 4;
		  break;
	    case 16:
	    case 17:
	    case 18:
		  mp = 6;
		  break;
	  default:
		  mp = 3;
		 break;
	   }
    } else if (pc.isDragonKnight()) {
	  switch (pc.getWis()) {
	   case 12:
	   case 13:
	   case 14:
	   case 15:
		 mp = 4;
		 break;
	   case 16:
	   case 17:
	   case 18:
		 mp = 6;
		 break;
	  default:
		 mp = 4;
		 break;
	   }
    } else if (pc.isIllusionist()) {
	switch (pc.getWis()) {
	   case 12:
	   case 13:
	   case 14:
	   case 15:
		 mp = 4;
		 break;
	   case 16:
	   case 17:
	   case 18:
		 mp = 6;
		 break;
	  default:
		 mp = 4;
		break;
	   }
    }
      return mp;
    }
 
   @Override
   public String getType() {
      return C_CHAR_RESET;
      }
   }