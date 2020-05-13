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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Attribute;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_CharReset;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.CalcStat;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_CharReset extends ClientBasePacket {

	private static final String C_CHAR_RESET = "[C] C_CharReset";
	private static Logger _log = LoggerFactory.getLogger(C_CharReset.class.getName());

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
	private void checkProvidedStats(final L1PcInstance pc, int str, int intel,
			int wis, int dex, int con, int cha, Client client) {
		Map<L1Attribute, Integer> fixedStats = pc.getClassFeature()
				.getFixedStats();
		if (str < fixedStats.get(L1Attribute.Str)
				|| intel < fixedStats.get(L1Attribute.Int)
				|| wis < fixedStats.get(L1Attribute.Wis)
				|| dex < fixedStats.get(L1Attribute.Dex)
				|| con < fixedStats.get(L1Attribute.Con)
				|| cha < fixedStats.get(L1Attribute.Cha))
			emergencyCleanup(pc, String.format(
					"Candle: %s had less than starting stats!", pc.getName()),
					"Candle: issue with stats, contact a GM for help.", client);

		if (str > 35 || intel > 35 || wis > 35 || dex > 35 || con > 35
				|| cha > 35)
			emergencyCleanup(pc, String.format(
					"Candle: %s had individual stat above max", pc.getName()),
					"Candle: issue with stats, contact a GM for help.", client);

		int bonusStats = pc.getLevel() > 50 ? pc.getLevel() - 50 : 0;
		if (str + intel + wis + dex + con + cha > 75 + bonusStats
				+ pc.getElixirStats()) {
			emergencyCleanup(
					pc,
					String.format("Candle: %s has too many stats!",
							pc.getName()),
					"Candle: issue with stats, contact a GM for help.", client);
		}
		
		if (str < pc.getBaseStr() || intel < pc.getBaseInt() || wis < pc.getBaseWis()
				|| dex < pc.getBaseDex() || con < pc.getBaseCon() || cha < pc.getBaseCha()) {
			emergencyCleanup(pc, String.format(
					"Candle: %s tried to redistribute stats after level ups!", pc.getName()),
					"Candle: issue with stats, contact a GM for help.", client);
		}
	}

	private void checkProvidedStartingStats(final L1PcInstance pc, int str,
			int intel, int wis, int dex, int con, int cha, Client client) {
		Map<L1Attribute, Integer> startingStats = pc.getClassFeature()
				.getFixedStats();
		int originalStr = startingStats.get(L1Attribute.Str);
		int originalDex = startingStats.get(L1Attribute.Dex);
		int originalCon = startingStats.get(L1Attribute.Con);
		int originalWis = startingStats.get(L1Attribute.Wis);
		int originalCha = startingStats.get(L1Attribute.Cha);
		int originalInt = startingStats.get(L1Attribute.Int);
		int originalAmount = pc.getClassFeature().getFloatingStats();
		boolean isStatusError = false;

		if ((str < originalStr || dex < originalDex || con < originalCon
				|| wis < originalWis || cha < originalCha || intel < originalInt)
				|| (str > originalStr + originalAmount
						|| dex > originalDex + originalAmount
						|| con > originalCon + originalAmount
						|| wis > originalWis + originalAmount
						|| cha > originalCha + originalAmount || intel > originalInt
						+ originalAmount)) {
			isStatusError = true;
		}
		
		Map<L1Attribute, Integer> startingMaxStats = pc.getClassFeature()
				.getMaxFixedStats();
		int startingMaxSTR = startingMaxStats.get(L1Attribute.Str);
		int startingMaxDex = startingMaxStats.get(L1Attribute.Dex);
		int startingMaxCon = startingMaxStats.get(L1Attribute.Con);
		int startingMaxWis = startingMaxStats.get(L1Attribute.Wis);
		int startingMaxCha = startingMaxStats.get(L1Attribute.Cha);
		int startingMaxInt = startingMaxStats.get(L1Attribute.Int);

		if (str > startingMaxSTR || dex > startingMaxDex || con > startingMaxCon
				|| wis > startingMaxWis || cha > startingMaxCha || intel > startingMaxInt){
			isStatusError = true;
		}

		int statusAmount = dex + cha + con + intel + str + wis;

		if (statusAmount != 75 || isStatusError) {
			emergencyCleanup(pc, String.format(
					"Candle: %s had incorrect starting stats!", pc.getName()),
					"Candle: issue with stats, contact a GM for help.", client);
		}
	}

	public C_CharReset(byte abyte0[], Client client) {
		super(abyte0);
		L1PcInstance pc = client.getActiveChar();
		
		// quick check to see if they're on the map they get teleported to when candling
		//TODO -- not sure this check is actually required, but it crashes on 3.63 because CharReset is used for more than just candling
		/*if(pc.getMapId() != 997) {
			emergencyCleanup(pc, 
					String.format("%s attempted to candle on an incorrect map (may have sent the packet manually)! Mapid: %d", pc.getName(), pc.getMapId()),
					"Error candling. Contact a GM.", client);
			_log.warn(String.format("%s has sent a candle packet while on a non-candle map! MapId: %d", pc.getName(), pc.getMapId()));
		}*/
		
		int stage = readC();

		if (stage == 0x01) { // 0x01:LN^[
			// Stage 1: original stats

			int str = readC();
			int intel = readC();
			int wis = readC();
			int dex = readC();
			int con = readC();
			int cha = readC();

			// Rule #1 Never trust the client
			checkProvidedStartingStats(pc, str, intel, wis, dex, con, cha, client);

			int hp = pc.getClassFeature().getStartingHp();
			int mp = pc.getClassFeature().getStartingMp(wis);
			pc.sendPackets(new S_CharReset(pc, 1, hp, mp, 10, str, intel, wis,
					dex, con, cha));
			initCharStatus(pc, hp, mp, str, intel, wis, dex, con, cha);
			pc.refresh();
		} else if (stage == 0x02) { // 0x02:Xe[^Xz
			// Stage 2: Level ups and adding stats 1 by 1
			int type2 = readC();
			if (type2 == 0x00) { // 0x00:Lv1UP
				if ((pc.getTempLevel() >= pc.getTempMaxLevel()) || pc.getTempLevel() > 50)
					return;
				
				setLevelUp(pc, 1);
			} else if (type2 == 0x07) { // 0x07:Lv10UP
				if (pc.getTempMaxLevel() - pc.getTempLevel() < 10)
					return;
				setLevelUp(pc, 10);
			}   else {
				int fullStats = pc.getBaseStr() + pc.getBaseInt() + pc.getBaseWis() + pc.getBaseDex() + pc.getBaseCon() + pc.getBaseCha();
				int originalStats = pc.getOriginalStr() + pc.getOriginalInt() + pc.getOriginalWis() + pc.getOriginalDex() + pc.getOriginalCon() + pc.getOriginalCha();
				int increasedStats = fullStats - originalStats;
				int possiblePoints = pc.getLevel() - 50 + pc.getElixirStats();
				
				// increase possible stats by 1 since that is what will happen below
				if(increasedStats + 1 > possiblePoints) {
					emergencyCleanup(pc, 
							String.format("%s has attemped to exploit their stats! Increased Stats: %d, Possible Stats: %d",
									pc.getName(),
									increasedStats,
									possiblePoints),
							"Error candling. Contact a GM.", client);
				}
				
				if (type2 == 0x01) {
					pc.addBaseStr((byte) 1);
					setLevelUp(pc, 1);
				} else if (type2 == 0x02) {
					pc.addBaseInt((byte) 1);
					setLevelUp(pc, 1);
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
					int hmm = readC();
					switch (hmm) {
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
					
					saveNewCharStatus(pc, client);
				}
			}
		} else if (stage == 0x03) {
			// See the note above
			int str = readC();
			int intel = readC();
			int wis = readC();
			int dex = readC();
			int con = readC();
			int cha = readC();

			// Rule #2: Never trust the client
			checkProvidedStats(pc, str, intel, wis, dex, con, cha, client);

			pc.addBaseStr((byte) (str - pc.getBaseStr()));
			pc.addBaseInt((byte) (intel - pc.getBaseInt()));
			pc.addBaseWis((byte) (wis - pc.getBaseWis()));
			pc.addBaseDex((byte) (dex - pc.getBaseDex()));
			pc.addBaseCon((byte) (con - pc.getBaseCon()));
			pc.addBaseCha((byte) (cha - pc.getBaseCha()));
			saveNewCharStatus(pc, client);
		}
	}

	private synchronized void emergencyCleanup(final L1PcInstance pc,
			final String logEntry, final String message, Client client) {
		_log.error(logEntry);
		pc.sendPackets(new S_SystemMessage(message));

		// We'll be nice and just kick the player even though they're probably
		// trying to cheat
		// This reverts to the state at pc.save done at NPCAction
		Client.quitGame(pc, client.getLastActiveCharName());
		pc.getNetConnection().kick();

		// Terrible way to bail, but we're doing it for now.
		throw new IllegalStateException();
	}

	private synchronized void saveNewCharStatus(L1PcInstance pc, Client client) {
		if (pc.getTempMaxLevel() != pc.getLevel()) {
			emergencyCleanup(pc, "Candle: " + pc.getName() + "'s level "
					+ "doesn't match!",
					"Candle: issue with level, contact a GM!", client);
		}

		pc.setInCharReset(false);
		pc.refresh();
		pc.setCurrentHp(pc.getMaxHp());
		pc.setCurrentMp(pc.getMaxMp());
		pc.setMr(pc.getBaseMr());
		pc.setAc(pc.getBaseAc());
		
		if (pc.getOriginalMr() > 0) {
			pc.addMr(pc.getOriginalMr());
		}
		
		pc.sendPackets(new S_SPMR(pc));
		
		if (pc.getOriginalAc() > 0) {
			pc.addAc(0 - pc.getOriginalAc());
		}
		
		pc.sendPackets(new S_OwnCharAttrDef(pc));
		
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
				_log.error(e.getLocalizedMessage(), e);
			}
		}
		
		L1Teleport.teleport(pc, 32628, 32772, (short) 4, 4, false);
	}

	private void initCharStatus(L1PcInstance pc, int hp, int mp, int str,
			int intel, int wis, int dex, int con, int cha) {
		pc.addBaseMaxHp((short) (hp - pc.getBaseMaxHp()));
		pc.addBaseMaxMp((short) (mp - pc.getBaseMaxMp()));
		pc.setBaseStr((byte) str);
		pc.setBaseInt((byte) intel);
		pc.setBaseWis((byte) wis);
		pc.setBaseDex((byte) dex);
		pc.setBaseCon((byte) con);
		pc.setBaseCha((byte) cha);
		pc.setOriginalStr((byte) str);
		pc.setOriginalInt((byte) intel);
		pc.setOriginalWis((byte) wis);
		pc.setOriginalDex((byte) dex);
		pc.setOriginalCon((byte) con);
		pc.setOriginalCha((byte) cha);
		pc.addDmgup(0 - pc.getDmgup());
		pc.addHitup(0 - pc.getHitup());
		CharacterTable.saveCharStatus(pc);
	}

	private synchronized void setLevelUp(L1PcInstance pc, int addLv) {
		pc.setTempLevel(pc.getTempLevel() + addLv);
		for (int i = 0; i < addLv; i++) {
			short randomHp = CalcStat.calcStatHp(pc.getType(),
					pc.getBaseMaxHp(), pc.getBaseCon(), pc.getOriginalHpup());
			short randomMp = CalcStat.calcStatMp(pc.getType(),
					pc.getBaseMaxMp(), pc.getBaseWis(), pc.getOriginalMpup());
			pc.addBaseMaxHp(randomHp);
			pc.addBaseMaxMp(randomMp);
		}
		
		int newAc = CalcStat.calcAc(pc.getTempLevel(), pc.getBaseDex()) - pc.getOriginalAc();

		pc.sendPackets(new S_CharReset(pc, pc.getTempLevel(),
				pc.getBaseMaxHp(), pc.getBaseMaxMp(), newAc, pc.getBaseStr(),
				pc.getBaseInt(), pc.getBaseWis(), pc.getBaseDex(), pc
						.getBaseCon(), pc.getBaseCha()));
	}

	@Override
	public String getType() {
		return C_CHAR_RESET;
	}
}
