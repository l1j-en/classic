package l1j.server.server.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.AccessLevelTable;
import l1j.server.server.model.L1AccessLevel;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class RankingsController implements Runnable {
	private static Logger _log = Logger.getLogger(RankingsController.class.getName());
	private static RankingsController _instance;
	private static ArrayList<Short> _includedAccessLevels = new ArrayList<Short>();
	// this is for the IN statement in SQL.
	// it simply adds ?,?,? for the # of access levels needed
	private static String _inFields = ""; 
	
	private static HashMap<RankType, LinkedHashMap<String, Integer>> _rankings
			= new HashMap<RankType, LinkedHashMap<String, Integer>>();
	
	private static HashMap<RankType, LinkedHashMap<String, Integer>> _pledgeRankings
	= new HashMap<RankType, LinkedHashMap<String, Integer>>();
	
	private static HashMap<RankType, HashMap<Integer, LinkedHashMap<String, Integer>>> _classRankings
		= new HashMap<RankType, HashMap<Integer, LinkedHashMap<String, Integer>>>();
	
	public enum RankType {
	    PLEDGE, LEVEL, LEVELCLASS, LEVELPLEDGE, PVP, PVPCLASS, PVPPLEDGE, BOSSDAILY, PLEDGEBOSSDAILY,
	    BOSSWEEKLY, PLEDGEBOSSWEEKLY, BOSSMONTHLY, PLEDGEBOSSMONTHLY, BOSSYEARLY, PLEDGEBOSSYEARLY,;
	}

	public static RankingsController getInstance() {
		if (_instance == null)
			_instance = new RankingsController();
		
		return _instance;
	}
	
	private RankingsController() {
		Collection<L1AccessLevel> accessLevels = AccessLevelTable.getInstance().getAllAccessLevels();
		
		for(L1AccessLevel accessLevel : accessLevels) {
			if(accessLevel.getLevel() < Config.MIN_GM_ACCESS_LEVEL)
				_includedAccessLevels.add(accessLevel.getId());
		}
		
		StringBuilder builder = new StringBuilder();
		for( int i = 0 ; i < _includedAccessLevels.size(); i++ ) {
		    builder.append("?,");
		}
		
		_inFields = builder.deleteCharAt( builder.length() -1 ).toString();
	}
	
	public static String getRanks(RankType rankType) {
		return getRanks(rankType, 0);
	}
	
	// gets the 1-10 rankings
	public static String getRanks(RankType rankType, int number) {
		String names [] = new String[10];
		Arrays.fill(names, "");
		
		ArrayList<String> rankings = null;
		
		if(rankType == RankType.LEVELCLASS || rankType == RankType.PVPCLASS) {
			int classId = number - (rankType == RankType.LEVELCLASS ? 2 : 10); // need to update these values if the board order changes!
			rankings = new ArrayList<String>(_classRankings.get(rankType).get(classId).keySet());
		} else if(rankType == RankType.LEVELPLEDGE || rankType == RankType.PVPPLEDGE || rankType == RankType.PLEDGEBOSSDAILY
				 || rankType == RankType.PLEDGEBOSSWEEKLY || rankType == RankType.PLEDGEBOSSMONTHLY || rankType == RankType.PLEDGEBOSSYEARLY) {
			rankings = new ArrayList<String>(_pledgeRankings.get(rankType).keySet());
		} else
			rankings = new ArrayList<String>(_rankings.get(rankType).keySet());
		
		for(int i = 0; i < rankings.size() && i < 10; i++)
			names[i] = rankings.get(i);
		
		return "\n\r" + "  1. " + names[0] + "\n\r" + "  2. " + names[1]
				+ "\n\r" + "  3. " + names[2] + "\n\r" + "  4. " + names[3]
				+ "\n\r" + "  5. " + names[4] + "\n\r" + "  6. " + names[5]
				+ "\n\r" + "  7. " + names[6] + "\n\r" + "  8. " + names[7]
				+ "\n\r" + "  9. " + names[8] + "\n\r" + " 10. " + names[9]
				+ "\n\r" + "             ";
	}
	
	// gets an individual rank
	public static String getRank(L1PcInstance pc, RankType rankType) {
		String returnValue = "You are not ranked in the top 1000.";
		
		ArrayList<String> typeRanking = null;
		String lookupName = null;
		
		if(rankType == RankType.LEVELCLASS || rankType == RankType.PVPCLASS) {
			typeRanking = new ArrayList<String>(_classRankings.get(rankType).get(pc.getType()).keySet());
			lookupName = pc.getName();
		}
		else if(rankType == RankType.LEVELPLEDGE || rankType == RankType.PVPPLEDGE || rankType == RankType.PLEDGEBOSSDAILY
				 || rankType == RankType.PLEDGEBOSSWEEKLY || rankType == RankType.PLEDGEBOSSMONTHLY || rankType == RankType.PLEDGEBOSSYEARLY) {
			typeRanking = new ArrayList<String>(_pledgeRankings.get(rankType).keySet());
			lookupName = pc.getClanname();
		}
		else {
			typeRanking = new ArrayList<String>(_rankings.get(rankType).keySet());
			lookupName = pc.getName();
		}
		
		// should obviously never be null or blank for pc.getname,
		if(lookupName == null || lookupName.equals("")) 
			return "You are not in a pledge!";
			
		for(int i = 0; i < typeRanking.size(); i++) {
			if(typeRanking.get(i).equals(lookupName)) {
				int playerRank = i + 1;
				returnValue = String.format("You are ranked %s.", playerRank + getSuffix(playerRank));
				
				if(rankType == RankType.PVP)
					returnValue += String.format("\r\n\r\n  With a K/D Ratio of %s.", 
							formatNumber(_rankings.get(rankType).get(pc.getName())));
				else if(rankType == RankType.PVPPLEDGE)
					returnValue += String.format("\r\n\r\n  With a K/D Ratio of %s.", 
							formatNumber(_pledgeRankings.get(rankType).get(lookupName)));
				
				if(rankType == RankType.PVPCLASS)
					returnValue += String.format("\r\n\r\n  With a K/D Ratio of %s.", 
							formatNumber(_classRankings.get(rankType).get(pc.getType()).get(pc.getName())));
			}
		}		

		return returnValue;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("RankingsController");
		try {
			while (true) {
				_rankings = new LinkedHashMap<RankType, LinkedHashMap<String, Integer>>();
				_classRankings.put(RankType.LEVELCLASS,
						new HashMap<Integer, LinkedHashMap<String, Integer>>());
				_classRankings.put(RankType.PVPCLASS,
						new HashMap<Integer, LinkedHashMap<String, Integer>>());
				
				for(int i = 1; i <= 29; i++) {
					if(i == 1) // overall level rankings
						_rankings.put(RankType.LEVEL, generateGenericRanks(i));
					else if (i >= 2 && i <= 8) // class level rankings
						_classRankings.get(RankType.LEVELCLASS).put(i - 2, generateGenericRanks(i));
					else if(i == 9) // overall pvp rankings
						_rankings.put(RankType.PVP, generateGenericRanks(i));
					else if(i >= 10 && i <= 16) // class pvp rankings
						_classRankings.get(RankType.PVPCLASS).put(i - 10, generateGenericRanks(i));
					else if(i == 17) // Pledge Level Ranking
						_pledgeRankings.put(RankType.LEVELPLEDGE, generateGenericRanks(i));
					else if(i == 18) // Pledge PvP Ranking
						_pledgeRankings.put(RankType.PVPPLEDGE, generateGenericRanks(i));
					else if(i == 19) // Pledge Boss Daily Ranking
						_pledgeRankings.put(RankType.PLEDGEBOSSDAILY, generateGenericRanks(i));
					else if(i == 20) // Pledge Boss Weekly Ranking
						_pledgeRankings.put(RankType.PLEDGEBOSSWEEKLY, generateGenericRanks(i));
					else if(i == 21) // Pledge Boss Monthly Ranking
						_pledgeRankings.put(RankType.PLEDGEBOSSMONTHLY, generateGenericRanks(i));
					else if(i == 22) // Pledge Boss Yearly Ranking
						_pledgeRankings.put(RankType.PLEDGEBOSSYEARLY, generateGenericRanks(i));
					else if(i == 26) // Player Boss Daily Ranking
						_rankings.put(RankType.BOSSDAILY, generateGenericRanks(i));
					else if(i == 27) // Player Boss Weekly Ranking
						_rankings.put(RankType.BOSSWEEKLY, generateGenericRanks(i));
					else if(i == 28) // Player Boss Monthly Ranking
						_rankings.put(RankType.BOSSMONTHLY, generateGenericRanks(i));
					else if(i == 29) // Player Boss Yearly Ranking
						_rankings.put(RankType.BOSSYEARLY, generateGenericRanks(i));
				}
				
				_log.info("Rankings Updated.");
				Thread.sleep(3600000); // 1 hour
			}
		} catch (Exception ex) {
			_log.log(Level.WARNING, "Rankings failed to load.", ex);
		}
	}
	
	private LinkedHashMap<String, Integer> generateGenericRanks(int number) {		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		LinkedHashMap<String, Integer> returnValue = new LinkedHashMap<String, Integer>();

		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			switch (number) {
			case 1: // All Levels
				pstm = con
						.prepareStatement("SELECT char_name, Exp As Ratio FROM characters WHERE AccessLevel IN (" + _inFields + ") ORDER BY Exp DESC LIMIT 1000");
				break;
			case 2: // Royal Levels
				pstm = con
						.prepareStatement("SELECT char_name, Exp As Ratio  FROM characters WHERE Type = 0 And AccessLevel IN (" + _inFields + ") ORDER BY Exp DESC LIMIT 1000");
				break;
			case 3: // Knight Levels
				pstm = con
						.prepareStatement("SELECT char_name, Exp As Ratio  FROM characters WHERE Type = 1 And AccessLevel IN (" + _inFields + ") ORDER BY Exp DESC LIMIT 1000");
				break;
			case 4: // Elf Levels
				pstm = con
						.prepareStatement("SELECT char_name, Exp As Ratio  FROM characters WHERE Type = 2 And AccessLevel IN (" + _inFields + ") ORDER BY Exp DESC LIMIT 1000");
				break;
			case 5: // Mage Levels
				pstm = con
						.prepareStatement("SELECT char_name, Exp As Ratio  FROM characters WHERE Type = 3 And AccessLevel IN (" + _inFields + ") ORDER BY Exp DESC LIMIT 1000");
				break;
			case 6: // Dark Elf Levels
				pstm = con
						.prepareStatement("SELECT char_name, Exp As Ratio  FROM characters WHERE Type = 4 And AccessLevel IN (" + _inFields + ") ORDER BY Exp DESC LIMIT 1000");
				break;
			case 7: // DragonKnight Levels
				pstm = con
				.prepareStatement("SELECT char_name, Exp As Ratio  FROM characters WHERE Type = 5 And AccessLevel IN (" + _inFields + ") ORDER BY Exp DESC LIMIT 1000");
				break;
			case 8: // Illusionist Levels
				pstm = con
				.prepareStatement("SELECT char_name, Exp As Ratio  FROM characters WHERE Type = 6 And AccessLevel IN (" + _inFields + ") ORDER BY Exp DESC LIMIT 1000");
				break;
			case 9: // Overall PvP Ranking
				pstm = con
				.prepareStatement("SELECT a.killer_char_name AS char_name," +
					" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" +
					" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
					" JOIN characters AS b ON a.killer_char_name = b.char_name" + 
					" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
					" AND b.accesslevel IN (" + _inFields + ") GROUP BY a.killer_char_name" + 
					" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 10: // Royals PvP Ranking
				pstm = con
				.prepareStatement("SELECT a.killer_char_name AS char_name," + 
					" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" +
					" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
					" JOIN characters AS b ON a.killer_char_name = b.char_name" + 
					" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
					" AND b.accesslevel IN (" + _inFields + ") AND b.Type = 0 GROUP BY a.killer_char_name" + 
					" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 11: // Knights PvP Ranking
				pstm = con
				.prepareStatement("SELECT a.killer_char_name AS char_name," + 
					" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" +
					" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
					" JOIN characters AS b ON a.killer_char_name = b.char_name" + 
					" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
					" AND b.accesslevel IN (" + _inFields + ") AND b.Type = 1 GROUP BY a.killer_char_name" + 
					" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 12: // Elves PvP Ranking
				pstm = con
				.prepareStatement("SELECT a.killer_char_name AS char_name," + 
					" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" +
					" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
					" JOIN characters AS b ON a.killer_char_name = b.char_name" + 
					" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
					" AND b.accesslevel IN (" + _inFields + ") AND b.Type = 2 GROUP BY a.killer_char_name" + 
					" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 13: // Mages PvP Ranking
				pstm = con
				.prepareStatement("SELECT a.killer_char_name AS char_name," + 
					" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" +
					" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
					" JOIN characters AS b ON a.killer_char_name = b.char_name" + 
					" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
					" AND b.accesslevel IN (" + _inFields + ") AND b.Type = 3 GROUP BY a.killer_char_name" + 
					" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 14: // Dark Elves PvP Ranking
				pstm = con
				.prepareStatement("SELECT a.killer_char_name AS char_name," + 
					" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" +
					" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
					" JOIN characters AS b ON a.killer_char_name = b.char_name" + 
					" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
					" AND b.accesslevel IN (" + _inFields + ") AND b.Type = 4 GROUP BY a.killer_char_name" + 
					" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 15: // DragonKnight PvP Ranking
				pstm = con
				.prepareStatement("SELECT a.killer_char_name AS char_name," + 
					" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" +
					" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
					" JOIN characters AS b ON a.killer_char_name = b.char_name" + 
					" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
					" AND b.accesslevel IN (" + _inFields + ") AND b.Type = 5 GROUP BY a.killer_char_name" + 
					" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 16: // Illusionist PvP Ranking
				pstm = con
				.prepareStatement("SELECT a.killer_char_name AS char_name," + 
					" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" +
					" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
					" JOIN characters AS b ON a.killer_char_name = b.char_name" + 
					" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
					" AND b.accesslevel IN (" + _inFields + ") AND b.Type = 6 GROUP BY a.killer_char_name" + 
					" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 17: // Pledge Level Ranking
				pstm = con
				.prepareStatement("SELECT clanname as char_name, SUM(Exp) As Ratio FROM characters" + 
						" WHERE AccessLevel IN (" + _inFields + ") AND clanname IS NOT NULL AND clanname != ''" + 
						" GROUP BY clanname" + 
						" ORDER BY Ratio DESC LIMIT 1000");
				break;
			case 18: // Pledge PvP Ranking
				pstm = con
				.prepareStatement("SELECT b.clanname AS char_name," + 
						" (count(killer_char_name) - IFNULL((SELECT count(victim_char_name) FROM character_pvp" + 
						" WHERE victim_char_name = a.killer_char_name GROUP BY victim_char_name), 0)) AS Ratio FROM character_pvp AS a" + 
						" JOIN characters AS b ON a.killer_char_name = b.char_name AND b.clanname IS NOT NULL AND b.clanname != ''" + 
						" WHERE a.victim_lvl >= 60 AND a.penalty IN ('5','8','9')" + 
						" AND b.accesslevel IN (" + _inFields + ") GROUP BY b.clanname" + 
						" ORDER BY Ratio DESC, min(`date`) LIMIT 1000");
				break;
			case 19: // Pledge Daily Boss Kills
				pstm = con
				.prepareStatement("SELECT clan_name AS char_name, count(clan_name) AS Ratio FROM boss_kills"
						+ " JOIN characters ON boss_kills.killer_name = characters.char_name AND characters.accesslevel IN (" + _inFields + ")"
						+ " WHERE DATE(kill_date) = DATE(NOW()) AND YEAR(kill_date) = YEAR(NOW()) AND clanname != '' AND NOT clanname IS NULL GROUP BY clan_name"
						+ " ORDER BY Ratio DESC, min(kill_date) LIMIT 1000");
				break;
			case 20: // Pledge Weekly Boss Kills -- resets Sunday morning
				pstm = con
				.prepareStatement("SELECT clan_name AS char_name, count(clan_name) AS Ratio FROM boss_kills"
						+ " JOIN characters ON boss_kills.killer_name = characters.char_name AND characters.accesslevel IN (" + _inFields + ")"
						+ " WHERE YEARWEEK(kill_date) = YEARWEEK(NOW()) AND YEAR(kill_date) = YEAR(NOW()) AND clanname != '' AND NOT clanname IS NULL GROUP BY clan_name"
						+ " ORDER BY Ratio DESC, min(kill_date) LIMIT 1000");
				break;
			case 21: // Pledge Monthly Boss Kills
				pstm = con
				.prepareStatement("SELECT clan_name AS char_name, count(clan_name) AS Ratio FROM boss_kills"
						+ " JOIN characters ON boss_kills.killer_name = characters.char_name AND characters.accesslevel IN (" + _inFields + ")"
						+ " WHERE MONTH(kill_date) = MONTH(NOW()) AND YEAR(kill_date) = YEAR(NOW()) AND clanname != '' AND NOT clanname IS NULL GROUP BY clan_name"
						+ " ORDER BY Ratio DESC, min(kill_date) LIMIT 1000");
				break;
			case 22: // Pledge Yearly Boss Kills
				pstm = con
				.prepareStatement("SELECT clan_name AS char_name, count(clan_name) AS Ratio FROM boss_kills"
						+ " JOIN characters ON boss_kills.killer_name = characters.char_name AND characters.accesslevel IN (" + _inFields + ")"
						+ " WHERE YEAR(kill_date) = YEAR(NOW()) AND clanname != '' AND NOT clanname IS NULL GROUP BY clan_name"
						+ " ORDER BY Ratio DESC, min(kill_date) LIMIT 1000");
				break;
			case 26: // Daily Boss Kills
				pstm = con
				.prepareStatement("SELECT killer_name AS char_name, count(killer_name) AS Ratio FROM boss_kills"
						+ " JOIN characters ON boss_kills.killer_name = characters.char_name AND characters.accesslevel IN (" + _inFields + ")"
						+ " WHERE DATE(kill_date) = DATE(NOW()) AND YEAR(kill_date) = YEAR(NOW()) GROUP BY killer_name"
						+ " ORDER BY Ratio DESC, min(kill_date) LIMIT 1000");
				break;
			case 27: // Weekly Boss Kills -- resets Sunday morning
				pstm = con
				.prepareStatement("SELECT killer_name AS char_name, count(killer_name) AS Ratio  FROM boss_kills"
						+ " JOIN characters ON boss_kills.killer_name = characters.char_name AND characters.accesslevel IN (" + _inFields + ")"
						+ " WHERE YEARWEEK(kill_date) = YEARWEEK(NOW()) AND YEAR(kill_date) = YEAR(NOW()) GROUP BY killer_name"
						+ " ORDER BY Ratio DESC, min(kill_date) LIMIT 1000");
				break;
			case 28: // Monthly Boss Kills
				pstm = con
				.prepareStatement("SELECT killer_name AS char_name, count(killer_name) AS Ratio  FROM boss_kills"
						+ " JOIN characters ON boss_kills.killer_name = characters.char_name AND characters.accesslevel IN (" + _inFields + ")"
						+ " WHERE MONTH(kill_date) = MONTH(NOW()) AND YEAR(kill_date) = YEAR(NOW()) GROUP BY killer_name"
						+ " ORDER BY Ratio DESC, min(kill_date) LIMIT 1000");
				break;
			case 29: // Yearly Boss Kills
				pstm = con
				.prepareStatement("SELECT killer_name AS char_name, count(killer_name) AS Ratio  FROM boss_kills"
						+ " JOIN characters ON boss_kills.killer_name = characters.char_name AND characters.accesslevel IN (" + _inFields + ")"
						+ " WHERE YEAR(kill_date) = YEAR(NOW()) GROUP BY killer_name"
						+" ORDER BY Ratio DESC, min(kill_date) LIMIT 1000");
				break;
			}
		
			for(int i = 1; i <= _includedAccessLevels.size(); i++) {
				pstm.setShort(i, _includedAccessLevels.get(i-1));
			}
			
			rs = pstm.executeQuery();
			
			while (rs.next())
				returnValue.put(rs.getString("char_name"), rs.getInt("ratio"));
		
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}

		return returnValue;
	}
	
	private static String formatNumber(int number) {
		if (number > 0)
			return "+" + number;
		
		return number+ "";
	}
	
	private static String getSuffix(int rank) {
		int lastDigit = Math.abs(rank % 10);
		
		switch (lastDigit) {
			case 1:
				return "st";
			case 2:
				return "nd";
			case 3:
				return "rd";
			default:
				return "th";
		}
	}
}
