package iplproblem;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class IPLDataUtility<K1, K, V> extends MapUtility<K1, K, V>{
	
	public static List<Entry<Integer, BowlerBallsRuns>> getYearAndBowlerBallsRunsEntriesInDescOrder(
			List<Entry<Integer, BowlerBallsRuns>> yearandBowlerBallsRunsEntries) {
		// TODO Auto-generated method stub
		
		Collections.sort(yearandBowlerBallsRunsEntries, new Comparator<Entry<Integer, BowlerBallsRuns> >() {

			@Override
			public int compare(Entry<Integer, BowlerBallsRuns> o1, Entry<Integer, BowlerBallsRuns> o2) {
				// TODO Auto-generated method stub
				
				float economy1 = o1.getValue().getEconomy();
				float economy2 =  o2.getValue().getEconomy();
				
				if (economy1 < economy2) 
					return -1;
				if (economy1 > economy2) 
					return 1;
				return 0;
			}
		});
		
		return yearandBowlerBallsRunsEntries;
	}
	

	public static List<Entry<Integer, TeamCount>> getTeamCountOrderByDesc(
			List<Entry<Integer, TeamCount>> countandTeamCountEntries) {
		// TODO Auto-generated method stub
		Collections.sort(countandTeamCountEntries, new Comparator<Entry<Integer, TeamCount> >() {
			@Override
			public int compare(Entry<Integer, TeamCount> o1, Entry<Integer, TeamCount> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().getCount() - o1.getValue().getCount();
			} 
        });
		return countandTeamCountEntries;
	}
	
	public static Entry<String, RunRateStatistics> getTeamWithTopRunRateStatistics(Map<Integer, HashMap<String, RunRateStatistics>> yearVsTeamVsRunRateStatistics) {
						
		RunRateStatistics topRunRateStatisticsTeam = new RunRateStatistics();
		topRunRateStatisticsTeam.setNetRunRate(Float.MIN_VALUE);
		
		TeamVsRunrateStatistics<String, RunRateStatistics> teamWithHighestRunRate = new 
				TeamVsRunrateStatistics<String, RunRateStatistics> ("A", topRunRateStatisticsTeam);
		
		for (Entry<Integer, HashMap<String, RunRateStatistics>> entry : yearVsTeamVsRunRateStatistics.entrySet()){
			
			for (Entry<String, RunRateStatistics> innerEntry : entry.getValue().entrySet()){
				
				if(teamWithHighestRunRate.getValue().getNetRunRate() < innerEntry.getValue().getNetRunRate() ) {
										
					teamWithHighestRunRate.setKey(innerEntry.getKey());
					
					teamWithHighestRunRate.setValue(innerEntry.getValue());
				}
			}
		}
		return teamWithHighestRunRate;
	}
}
