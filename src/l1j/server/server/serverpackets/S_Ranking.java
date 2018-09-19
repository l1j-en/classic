/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.serverpackets;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import l1j.server.Config;
import l1j.server.server.controllers.RankingsController;
import l1j.server.server.controllers.RankingsController.RankType;
import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.classes.L1ClassId;

public class S_Ranking extends ServerBasePacket {

	private static final String S_Ranking = "[C] S_Ranking";
	private static List<Integer> _emptyPages = Arrays.asList(new Integer[] { 25, 30, 31, 32, 34, 40, 41, 42, 48, 49, 50 });

	private byte[] _byte = null;

	public S_Ranking(L1PcInstance pc, int number) {
		buildPacket(pc, number);
	}

	private void buildPacket(L1PcInstance pc, int number) {
		String date = time();
		writeC(Opcodes.S_OPCODE_BOARDREAD);
		writeD(number);
		writeS("");
		
		String playerClassName = L1ClassId.getClass(pc.getClassId());
		
		// Shorten DK and Illu.
		if(playerClassName.equals("Dragon Knight"))
			playerClassName = "DK";
		else if(playerClassName.equals("Illusionist"))
			playerClassName = "Illu.";
		
		// titles that display when reading a ranking post
		String[] titles = { 
				// Level Ranking Titles
				"Overall Lvl Ranking", "Royal Lvl Ranking", "Knight Lvl Ranking", "Elf Lvl Ranking", 
				"Mage Lvl Ranking", "Dark Elf Lvl Ranking", "DK Lvl Ranking", "Illu. Lvl Ranking",
				
				// Pvp Ranking Titles
				"Overall PvP Ranking", "Royal PvP Ranking", "Knight PvP Ranking", "Elf PvP Ranking",
				"Mage PvP Ranking", "Dark Elf PvP Ranking", "DK PvP Ranking", "Illu. PvP Ranking",
				
				// Pledge Ranking Titles
				"Pledge Level Rank", "Pledge PvP Rank", "Pledge Daily Boss", "Pledge Weekly Boss", 
				"Pledge Monthly Boss", "Pledge Yearly Boss", "Your Pledge Ranks",
				
				// Blanks for spacing
				"", "",
				
				// Boss Ranking Titles
				"Daily Boss Ranking", "Weekly Boss Ranking", "Monthly Boss Ranking", "Yearly Boss Ranking",
				
				// Blanks for spacing
				"", "", "", "", "",
				
				// Player-specific Ranking Titles
				"Overall Level Rank", playerClassName + " Level Rank", "Overall PvP Rank", 
				playerClassName + " PvP Rank", "Boss Kills Rank",
				
				// Blanks for spacing
				"", "", ""
				};
		
		RankingsController.RankType[] rankEnumAssoc = {
				RankType.LEVEL, RankType.LEVELCLASS, RankType.LEVELCLASS, RankType.LEVELCLASS, 
				RankType.LEVELCLASS, RankType.LEVELCLASS, RankType.LEVELCLASS, RankType.LEVELCLASS,
				RankType.PVP, RankType.PVPCLASS, RankType.PVPCLASS, RankType.PVPCLASS, 
				RankType.PVPCLASS, RankType.PVPCLASS, RankType.PVPCLASS, RankType.PVPCLASS,
				
				/* pledge rankings */
				RankType.LEVELPLEDGE, RankType.PVPPLEDGE, RankType.PLEDGEBOSSDAILY, RankType.PLEDGEBOSSWEEKLY, 
				RankType.PLEDGEBOSSMONTHLY,RankType.PLEDGEBOSSYEARLY, RankType.PLEDGE,
				
				/*FILLERS FOR EMPTY PAGES*/
				RankType.LEVEL, RankType.LEVEL,
				/*END FILLERS*/
				
				RankType.BOSSDAILY, RankType.BOSSWEEKLY, RankType.BOSSMONTHLY, RankType.BOSSYEARLY,
				/* FILLERS FOR THE EMPTY PAGES*/
				RankType.LEVEL, RankType.LEVEL, RankType.LEVEL, RankType.LEVEL, RankType.LEVEL,
				/*END FILLERS*/
				RankType.LEVEL, RankType.LEVELCLASS, RankType.PVP, RankType.PVPCLASS, RankType.BOSSDAILY
		};
		
		writeS(number < 1 ? "" :  titles[number - 1]);
		writeS(date);
		
		// just a stub to display on my blank pages
		if(number == 0 || _emptyPages.contains(number)) {
			writeS("Nothing to see here...");
			return;
		}
		
		RankType rankType = rankEnumAssoc[number-1];
		
		// > 34 = personal ranking
		if(number > 34) {
			if(rankType == RankType.BOSSDAILY) {// for boss rankings, just list them all on one page
				String dailyRank = RankingsController.getRank(pc, rankType).replace(".", " (Today).");
				String weeklyRank = RankingsController.getRank(pc, RankType.BOSSWEEKLY).replace(".", " (Week).");
				String monthlyRank = RankingsController.getRank(pc, RankType.BOSSMONTHLY).replace(".", " (Month).");
				String yearlyRank = RankingsController.getRank(pc, RankType.BOSSYEARLY).replace(".", " (Year).");
				
				writeS(String.format("\r\n\r\n%s\r\n\r\n%s\r\n\r\n%s\r\n\r\n%s", 
						dailyRank, weeklyRank, monthlyRank, yearlyRank));
				
			} else 
				writeS("\r\n\r\n\r\n     " + RankingsController.getRank(pc, rankType));
		} else if(rankType == RankType.PLEDGE) { // all pledge rankings
			String levelRank = RankingsController.getRank(pc, RankType.LEVELPLEDGE).replace(".", " (Level).");
			String pvpRank = RankingsController.getRank(pc, RankType.PVPPLEDGE).replaceFirst("\\.", " (PvP).");
			
			String dailyRank = RankingsController.getRank(pc, RankType.PLEDGEBOSSDAILY).replace(".", " (Boss Daily).");
			String weeklyRank = RankingsController.getRank(pc, RankType.PLEDGEBOSSWEEKLY).replace(".", " (Boss Weekly).");
			String monthlyRank = RankingsController.getRank(pc, RankType.PLEDGEBOSSMONTHLY).replace(".", " (Boss Monthly).");
			String yearlyRank = RankingsController.getRank(pc, RankType.PLEDGEBOSSYEARLY).replace(".", " (Boss Yearly).");
			
			writeS(String.format("%s\r\n\r\n%s\r\n\r\n%s\r\n\r\n%s\r\n\r\n%s\r\n\r\n%s", 
					levelRank, pvpRank, dailyRank, weeklyRank, monthlyRank, yearlyRank));
		} else {
			if(rankType == RankType.LEVELCLASS || rankType == RankType.PVPCLASS)
				writeS(RankingsController.getRanks(rankType, number, Config.ALT_RANKING_CLASS_TOP));
			else if(rankType == RankType.LEVEL || rankType == RankType.PVP)
				writeS(RankingsController.getRanks(rankType, Config.ALT_RANKING_OVERALL_TOP)); 
			else
				writeS(RankingsController.getRanks(rankType, Config.ALT_RANKING_CLASS_TOP));
		}
	}
	
	private static String time() {
		TimeZone tz = TimeZone.getTimeZone(Config.TIME_ZONE);
		Calendar cal = Calendar.getInstance(tz);
		int year = cal.get(Calendar.YEAR) - 2000;
		String year2;
		if (year < 10) {
			year2 = "0" + year;
		} else {
			year2 = Integer.toString(year);
		}
		int Month = cal.get(Calendar.MONTH) + 1;
		String Month2 = null;
		if (Month < 10) {
			Month2 = "0" + Month;
		} else {
			Month2 = Integer.toString(Month);
		}
		int date = cal.get(Calendar.DATE);
		String date2 = null;
		if (date < 10) {
			date2 = "0" + date;
		} else {
			date2 = Integer.toString(date);
		}
		return year2 + "/" + Month2 + "/" + date2;
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	public String getType() {
		return S_Ranking;
	}

}
