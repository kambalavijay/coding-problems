package iplproblem;

/**
 * Author  : Vijay Kambala
 * Problem : FRAGMA DATA
 * Date    : 03/01/2019
 * Place   : IVYComptech, Hyderabad
 * */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPLProblem{

	public static void main(String[] args) {

		System.out.println("\n\nPlease refer to CODING PROBLEM JVD201807.pdf");
		System.out.println("\n\n");
		
		/* problem1
		 * Top 4 teams which elected to field first after winning toss in the year 2016 and 2017.
		 * */
		System.out.println("Top 4 teams which elected to field first after winning toss in the year 2016 and 2017.");
		problem1();
		
		System.out.println("\n\n");
		
		/* problem2
		 * List total number of fours, sixes, total score with respect to team and year.
		 **/
		
		System.out.println("List total number of fours, sixes, total score with respect to team and year.");
		problem2(); 
		
		System.out.println("\n\n");
		
		/*
		 * problem3
		 * Top 10 best economy rate bowler with respect to year who bowled at least 10
		 * overs (LEGBYE_RUNS and BYE_RUNS should not be considered for Total Runs Given
		 * by a bowler
		 * */
		
		System.out.println("Top 10 best economy rate bowler with respect to year who bowled at least 10 overs");
		problem3();
		
		System.out.println("\n\n");
		
		/*
		 * problem4 
		 * Find the team name which has Highest Net Run Rate with respect to year.
		 * Net Run Rate = (Total Runs Scored / Total Overs Faced) – (Total Runs Conceded /Total Overs Bowled)
		 * */
		System.out.println("Find the team name which has Highest Net Run Rate with respect to year.");
		problem4();
		
	}

	private static void problem1() {
		
		Map<String, HashMap<Integer, TeamCount>> teamsVsYearVsTeamCount = MatchService.getYearWiseElectedToFiledFirstTeamsAfterWinningToss();

		List<Map.Entry<Integer, TeamCount>> yearAndTeamCountEntries = IPLDataUtility.getInnerKeyValueAsList(teamsVsYearVsTeamCount);
		
		yearAndTeamCountEntries = IPLDataUtility.getTeamCountOrderByDesc(yearAndTeamCountEntries);
		
		DataConsole.printProblem1(yearAndTeamCountEntries);
	}
	
	
	private static void problem2() {
		
		Map<Integer, HashMap<String, FourSixTotal>> yearVsTeamVsFourSixTotal = DeliveryService.getYearWiseTeamsBoundariesAndRuns();
		
		DataConsole.printProblem2(yearVsTeamVsFourSixTotal);
	}
	
	private static void problem3() {
		
		Map<String, HashMap<Integer, BowlerBallsRuns>> bowlerVsYearVsBowlerBallsRuns = DeliveryService.getYearWiseBowlerStatistics();
				
		bowlerVsYearVsBowlerBallsRuns = DeliveryService.removeWhoBowledLessThanTenOvers(bowlerVsYearVsBowlerBallsRuns);
		
		List<Map.Entry<Integer, BowlerBallsRuns>> yearandBowlerBallsRunsEntries = IPLDataUtility.getInnerKeyValueAsList(bowlerVsYearVsBowlerBallsRuns);
		
		yearandBowlerBallsRunsEntries = IPLDataUtility.getYearAndBowlerBallsRunsEntriesInDescOrder(yearandBowlerBallsRunsEntries);
						
		DataConsole.printProblem3(yearandBowlerBallsRunsEntries);
	}
	
	private static void problem4() {
		// TODO Auto-generated method stub
		Map<Integer, HashMap<String, RunRateStatistics>> yearVsTeamVsRunRateStatistics = DeliveryService.getTeamsYearWiseWithTopRunRate();
		
		TeamVsRunrateStatistics<String, RunRateStatistics> teamWithHighestRunRate = (TeamVsRunrateStatistics<String, RunRateStatistics>) 
				IPLDataUtility.getTeamWithTopRunRateStatistics(yearVsTeamVsRunRateStatistics);
					
		DataConsole.printProblem4(teamWithHighestRunRate);
	}
}