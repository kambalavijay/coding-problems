package iplproblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MatchService  {
	
	private static Map<Integer, Match> matchesMap = new HashMap<Integer, Match>();
	
	static {
		
		String csvFilePath = "C:\\Users\\kambv\\eclipse-workspace\\exercises\\src\\matches.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";

	    try {
	        br = new BufferedReader(new FileReader(csvFilePath));
	        br.readLine();
	        while ((line = br.readLine()) != null) {

	            // use comma as separator
	            String[] country = line.split(cvsSplitBy);
	            
	            String result = "";
	            
	            if(country.length == 10)
	            	result = country[9];
	            	
	            @SuppressWarnings("deprecation")
				Match match = new Match(Integer.parseInt(country[0]), 
	            					Integer.parseInt(country[1]), 
	            					country[2], 
	            					new Date(country[3].toString()), 
	            				    country[4], 
	            				    country[5], 
	            				    country[6], 
	            				    country[7], 
	            				    country[8],
	            				    result);
	            
	            matchesMap.put(match.getMatchId(), match);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	public static Match getMatchByid(Integer matchid) {
		return matchesMap.get(matchid);
	}
	
	public static Collection<Match> getAllMatches() {
		return matchesMap.values();
	}
	

	public static Map<String, HashMap<Integer, TeamCount>> getYearWiseElectedToFiledFirstTeamsAfterWinningToss(){
		
		Map<String, HashMap<Integer, TeamCount>> teamsVsYearVsTeamCount = new HashMap<String, HashMap<Integer, TeamCount>>();

		//getAllMatches().parallelStream().



		for (Match match : getAllMatches()) {
			if((match.getSeason() == 2016 || match.getSeason() == 2017) &&
					match.getTossDecision().equalsIgnoreCase("field") && 
					teamsVsYearVsTeamCount.containsKey(match.getTossWinneer())) {
				
				if( teamsVsYearVsTeamCount.get(match.getTossWinneer()).containsKey(match.getSeason()) ) {
					teamsVsYearVsTeamCount.get(match.getTossWinneer()).get(match.getSeason()).IncreaseCount();
					teamsVsYearVsTeamCount.get(match.getTossWinneer()).put(match.getSeason(), teamsVsYearVsTeamCount.get(match.getTossWinneer()).get(match.getSeason()));
				}
				else
					teamsVsYearVsTeamCount.get(match.getTossWinneer()).put(match.getSeason(), new TeamCount(1, match.getTossWinneer()));
			}
			else if ((match.getSeason() == 2016 || match.getSeason() == 2017) &&
					match.getTossDecision().equalsIgnoreCase("field")) {
				
				HashMap<Integer, TeamCount> yearVsTeamCount = new HashMap<Integer, TeamCount>();
				yearVsTeamCount.put(match.getSeason(), new TeamCount(1, match.getTossWinneer()));
				teamsVsYearVsTeamCount.put(match.getTossWinneer(), yearVsTeamCount);
			}
			else
				continue;
		}
		return teamsVsYearVsTeamCount;
	}
}
