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

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ExpTable;
import l1j.server.server.model.L1Attribute;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CharReset;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.CalcStat;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_CharReset extends ClientBasePacket {

	private static final String C_CHAR_RESET = "[C] C_CharReset";
	private static Logger _log = Logger.getLogger(C_CharReset.class.getName());

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

	/**
	 * Log any suspicious behavior.
	 */
	private void checkProvidedStats(final L1PcInstance pc, int str, int intel, int wis, 
			int dex, int con, int cha) {
		Map<L1Attribute, Integer> fixedStats = pc.getClassFeature().getFixedStats();
		if (str < fixedStats.get(L1Attribute.Str) || 
				intel < fixedStats.get(L1Attribute.Int) ||
				wis < fixedStats.get(L1Attribute.Wis) ||
				dex < fixedStats.get(L1Attribute.Dex) ||
				con < fixedStats.get(L1Attribute.Con) ||
				cha < fixedStats.get(L1Attribute.Cha))
			_log.log(Level.SEVERE, 
					String.format("Candle: %s had less than starting stats!", 
						pc.getName()));
		
		int bonusStats = pc.getLevel() > 50 ? pc.getLevel() - 50 : 0;
		if (str + intel + wis + dex + con + cha > 75 + bonusStats + 
				pc.getElixirStats()) {
			emergencyCleanup(pc, "Candle: %s has too many stats!",
					"Candle: issue with stats, contact a GM for help.");
		}
	}

	public C_CharReset(byte abyte0[], ClientThread clientthread) {
		super(abyte0);
		L1PcInstance pc = clientthread.getActiveChar();
		int stage = readC();

		if (stage == 0x01) { // 0x01:LN^[
			// We can't trust these numbers, since they've been provided by the
			// client--this is the source of one of the candle glitches. On the
			// other hand, we can't just use the save numbers because that
			// effectively gives them all those bonus stats again.
			int str = readC();
			int intel = readC();
			int wis = readC();
			int dex = readC();
			int con = readC();
			int cha = readC();

			checkProvidedStats(pc, str, intel, wis, dex, con, cha);

			int hp = pc.getClassFeature().getStartingHp();
			int mp = pc.getClassFeature().getStartingMp(wis);
			pc.sendPackets(new S_CharReset(pc, 1, hp, mp, 10, str, intel, wis, dex, con, cha));
			initCharStatus(pc, hp, mp, str, intel, wis, dex, con, cha);
			CharacterTable.getInstance().saveCharStatus(pc);
			pc.setOriginalStr(str);
			pc.setOriginalCon(con);
			pc.setOriginalDex(dex);
			pc.setOriginalCha(cha);
			pc.setOriginalInt(intel);
			pc.setOriginalWis(wis);
			pc.refresh();
		} else if (stage == 0x02) { // 0x02:Xe[^Xz
			int type2 = readC();
			if (type2 == 0x00) { // 0x00:Lv1UP
				setLevelUp(pc, 1); 
			} else if (type2 == 0x07) { // 0x07:Lv10UP
				if (pc.getTempMaxLevel() - pc.getTempLevel() < 10) {
				return;
				}
				setLevelUp(pc,10);
			} else if (type2 == 0x01) {
				pc.addBaseStr((byte) 1);
				setLevelUp(pc, 1);
			} else if (type2 == 0x02) {
				pc.addBaseInt((byte) 1);
				setLevelUp(pc,1);
			} else if (type2 == 0x03) {
				pc.addBaseWis((byte) 1);
				setLevelUp(pc, 1);
			} else if (type2 == 0x04) {
				pc.addBaseDex((byte) 1);
				setLevelUp(pc, 1);
			} else if (type2 == 0x05) {
				pc.addBaseCon((byte) 1);
				setLevelUp(pc, 1);
			} else if (type2 == 0x06) {
				pc.addBaseCha((byte) 1);
				setLevelUp(pc, 1);
			} else if (type2 == 0x08) {
				switch(readC()){
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
				if (pc.getElixirStats() > 0) {
					pc.sendPackets(new S_CharReset(pc.getElixirStats()));
					return;
				}
				saveNewCharStatus(pc);
			}
		} else if (stage == 0x03) {
			// See the note above
			int str = readC();
			int intel = readC();
			int wis = readC();
			int dex = readC();
			int con = readC();
			int cha = readC();

			checkProvidedStats(pc, str, intel, wis, dex, con, cha);

			pc.addBaseStr((byte) (str - pc.getBaseStr()));
			pc.addBaseInt((byte) (intel - pc.getBaseInt()));
			pc.addBaseWis((byte) (wis - pc.getBaseWis()));
			pc.addBaseDex((byte) (dex - pc.getBaseDex()));
			pc.addBaseCon((byte) (con - pc.getBaseCon()));
			pc.addBaseCha((byte) (cha - pc.getBaseCha()));
			saveNewCharStatus(pc);
		}
	}
	
	private void emergencyCleanup(final L1PcInstance pc, final String logEntry,
			final String message) {
		_log.log(Level.SEVERE, logEntry);
		pc.sendPackets(new S_SystemMessage(message));
		L1Teleport.teleport(pc, 32628, 32772, (short) 4, 4, false);
		// Terrible way to bail, but we're doing it for now.
		throw new IllegalStateException();
	}

	private synchronized void saveNewCharStatus(L1PcInstance pc) {
		if (pc.getTempMaxLevel() != pc.getLevel()) {
			emergencyCleanup(pc, "Candle: " + pc.getName() + "'s level " +
				"doesn't match!", "Candle: issue with level, contact a GM!");
		}
		
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
		L1ItemInstance item = pc.getInventory().findItemId(49142);
		if (item != null) {
			try {
				pc.getInventory().removeItem(item, 1);
				pc.save();
			} catch (Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}
		L1Teleport.teleport(pc, 32628, 32772, (short) 4, 4, false);
	}

	private void initCharStatus(L1PcInstance pc, int hp, int mp, int str, int intel, int wis, int dex, int con, int cha) {
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

	private synchronized void setLevelUp(L1PcInstance pc ,int addLv) {
		pc.setTempLevel(pc.getTempLevel()+ addLv);
		for (int i = 0; i < addLv; i++) {
			short randomHp = CalcStat.calcStatHp(pc.getType(), pc.getBaseMaxHp(), pc.getBaseCon(), pc.getOriginalHpup());
			short randomMp = CalcStat.calcStatMp(pc.getType(), pc.getBaseMaxMp(), pc.getBaseWis(), pc.getOriginalMpup());
			pc.addBaseMaxHp(randomHp);
			pc.addBaseMaxMp(randomMp);
		}
		int newAc = CalcStat.calcAc(pc.getTempLevel(), pc.getBaseDex());
		
		pc.sendPackets(new S_CharReset(pc,pc.getTempLevel(),
		pc.getBaseMaxHp(), pc.getBaseMaxMp(), newAc,
		pc.getBaseStr(), pc.getBaseInt(), pc.getBaseWis(),
		pc.getBaseDex(), pc.getBaseCon(), pc.getBaseCha()));
	}

	@Override
	public String getType() {
		return C_CHAR_RESET;
	}
}
