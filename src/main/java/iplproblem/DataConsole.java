package iplproblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataConsole {

	public static void printProblem4(TeamVsRunrateStatistics<String, RunRateStatistics> teamWithHighestRunRate) {
		
		System.out.println("================================================");
		System.out.println("YEAR \tTEAM\t\t\t      NETRUNRATE");
		System.out.println("================================================");
		
		System.out.printf("%4d \t%-30s %.2f%n", teamWithHighestRunRate.getValue().getSeason(), 
				teamWithHighestRunRate.getKey(),
				teamWithHighestRunRate.getValue().getNetRunRate());
		
		System.out.println("================================================");
	}
	
	public static void printProblem3(List<Entry<Integer, BowlerBallsRuns>> yearandBowlerBallsRunsEntries) {
		
		System.out.println("===================================");
		System.out.println("YEAR \tPLAYER\t\t    ECONOMY");
		System.out.println("===================================");
		
		for (int i = 0; i < 10; i++) {
			
			System.out.printf("%4d \t%-20s %.2f%n", yearandBowlerBallsRunsEntries.get(i).getKey(), 
					yearandBowlerBallsRunsEntries.get(i).getValue().getBowlerName(),
					yearandBowlerBallsRunsEntries.get(i).getValue().getEconomy()
					);
		}
		System.out.println("===================================");
	}

	public static void printProblem2(Map<Integer, HashMap<String, FourSixTotal>> yearVsTeamVsFourSixTotal) {
		
		System.out.println("===============================================================================");
		System.out.println("YEAR \tTEAMNAME\t\t\t   FOURS_COUNT SIXES_COUNT TOTAL_SCORE");
		System.out.println("===============================================================================");
		
		for(Entry<Integer, HashMap<String, FourSixTotal>> entry : yearVsTeamVsFourSixTotal.entrySet() ){
			for(Entry<String, FourSixTotal> innerEntry :  entry.getValue().entrySet()){
				System.out.printf("%4d \t%-35s %5d %10d %12d %n", entry.getKey(), innerEntry.getKey(), innerEntry.getValue().getFourCount(),
						innerEntry.getValue().getSixCount(),
						innerEntry.getValue().getTotalRuns());
			}
		}
		System.out.println("===============================================================================");
	}

	public static void printProblem1(List<Entry<Integer, TeamCount>> yearAndTeamCountEntries) {
		// TODO Auto-generated method stub
		
		System.out.println("======================================");
		System.out.println("YEAR \tTEAM\t\t\t COUNT");
		System.out.println("======================================");
		
		for (int i = 0; i < 4; i++) {
			
			System.out.printf("%4d \t%-25s %2d%n", yearAndTeamCountEntries.get(i).getKey(), 
					yearAndTeamCountEntries.get(i).getValue().getTeam(),
					yearAndTeamCountEntries.get(i).getValue().getCount()
					);
		}

		System.out.println("======================================");
	}

}
