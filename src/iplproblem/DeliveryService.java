package iplproblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DeliveryService  {
	
	private static List<Delivery> deliveries = new ArrayList<Delivery>();
	
	static {
		
		String csvFilePath = "C:\\Users\\kambv\\eclipse-workspace\\exercises\\src\\deliveries.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";

	    try {

	        br = new BufferedReader(new FileReader(csvFilePath));
	        br.readLine();
	        while ((line = br.readLine()) != null) {

	            // use comma as separator
	            String[] deliveryLine = line.split(cvsSplitBy);

				Delivery delivery = new Delivery(
						Integer.parseInt(deliveryLine[0]), 
						Integer.parseInt(deliveryLine[1]), 
    					deliveryLine[2],
    					deliveryLine[3],
    					Integer.parseInt(deliveryLine[4]),
    					Integer.parseInt(deliveryLine[5]),
    					deliveryLine[6], 
    					deliveryLine[7], 
    					Integer.parseInt(deliveryLine[8]),
    					Integer.parseInt(deliveryLine[9]), 
    					Integer.parseInt(deliveryLine[10]), 
    					Integer.parseInt(deliveryLine[11]),
    					Integer.parseInt(deliveryLine[12]),
    					Integer.parseInt(deliveryLine[13]),
    					Integer.parseInt(deliveryLine[14]),
    					Integer.parseInt(deliveryLine[15])
    					);
	            
	            deliveries.add( delivery);
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
	
	
	public static List<Delivery> getAllDeliveries() {
		
		return deliveries;
	}
	
	public static Map<String, HashMap<Integer, BowlerBallsRuns>> getYearWiseBowlerStatistics() {
		
		Map<String, HashMap<Integer, BowlerBallsRuns>> bowlerVsYearVsBowlerBallsRuns = new HashMap<String, HashMap<Integer, BowlerBallsRuns>>();
				
		for (Delivery delivery : deliveries){
			Integer season = MatchService.getMatchByid(delivery.getMacthId()).getSeason();
			String bowler = delivery.getBowler();
			int runsGiven = delivery.getTotalRuns() - delivery.getLegByeRuns() - delivery.getBYE_RUNS();
							
			if( bowlerVsYearVsBowlerBallsRuns.containsKey(bowler) ) {
				if(bowlerVsYearVsBowlerBallsRuns.get(bowler).containsKey(season)) {
					bowlerVsYearVsBowlerBallsRuns.get(bowler).get(season).increaseBallsCountByDelivery(delivery);
					bowlerVsYearVsBowlerBallsRuns.get(bowler).get(season).increseRuns(runsGiven);
				}
				else {
					BowlerBallsRuns newBowler = new BowlerBallsRuns(bowler);
					newBowler.increaseBallsCountByDelivery(delivery);
					newBowler.increseRuns(runsGiven);
					bowlerVsYearVsBowlerBallsRuns.get(bowler).put(season, newBowler);
				}
			}
			else {
				HashMap<Integer, BowlerBallsRuns> yearVsBowlerBallsRuns = new HashMap<Integer, BowlerBallsRuns>();
				BowlerBallsRuns newBowler = new BowlerBallsRuns(bowler);
				newBowler.increaseBallsCountByDelivery(delivery);
				newBowler.increseRuns(runsGiven);
				yearVsBowlerBallsRuns.put(season, newBowler);
				bowlerVsYearVsBowlerBallsRuns.put(bowler, yearVsBowlerBallsRuns);
			}
		}
		return bowlerVsYearVsBowlerBallsRuns;
	}
	
	public static Map<String, HashMap<Integer, BowlerBallsRuns>> removeWhoBowledLessThanTenOvers(Map<String, HashMap<Integer, BowlerBallsRuns>> bowlerVsYearVsBowlerBallsRuns) {
		
		Iterator<Entry<String, HashMap<Integer, BowlerBallsRuns>>> bowlerVsYearVsBowlerBallsRunsEntries = bowlerVsYearVsBowlerBallsRuns.entrySet().iterator();
		
		while (bowlerVsYearVsBowlerBallsRunsEntries.hasNext()) {
			Entry<String, HashMap<Integer, BowlerBallsRuns>> bowlerVsYearVsBowlerBallsRunsEntry = (Entry<String, HashMap<Integer, BowlerBallsRuns>>) bowlerVsYearVsBowlerBallsRunsEntries.next();
			int count = 0;
			int yearVsBowlerBallsRunsEntryEntriesCount = bowlerVsYearVsBowlerBallsRuns.entrySet().size();
			Iterator<Entry<Integer, BowlerBallsRuns>> yearVsBowlerBallsRunsEntries = bowlerVsYearVsBowlerBallsRunsEntry.getValue().entrySet().iterator();
			while (yearVsBowlerBallsRunsEntries.hasNext()) {
				Entry<Integer, BowlerBallsRuns> yearVsBowlerBallsRunsEntry = (Entry<Integer, BowlerBallsRuns>) yearVsBowlerBallsRunsEntries.next();
				if(yearVsBowlerBallsRunsEntry.getValue().getTotalOvers() < 10.00f) {
					yearVsBowlerBallsRunsEntries.remove();
					count++;
				}
			}
			if(count  == yearVsBowlerBallsRunsEntryEntriesCount)
				bowlerVsYearVsBowlerBallsRunsEntries.remove();
		}
		return bowlerVsYearVsBowlerBallsRuns;
	}
	
	public static Map<Integer, HashMap<String, FourSixTotal>> getYearWiseTeamsBoundariesAndRuns() {

		Map<Integer, HashMap<String, FourSixTotal>> yearVsTeamVsFourSixTotal = new HashMap<Integer, HashMap<String, FourSixTotal>>();
		
		for (Delivery delivery : deliveries){
			
			Match match = MatchService.getMatchByid(delivery.getMacthId());
			
			if(yearVsTeamVsFourSixTotal.containsKey(match.getSeason())) {
				
				if( yearVsTeamVsFourSixTotal.get(match.getSeason()).containsKey(delivery.getBattingTeam())) {
					if (delivery.getBatsmanRuns() == 4)
						yearVsTeamVsFourSixTotal.get(match.getSeason()).get(delivery.getBattingTeam()).increaseFourCount();
					else if (delivery.getBatsmanRuns() == 6)
						yearVsTeamVsFourSixTotal.get(match.getSeason()).get(delivery.getBattingTeam()).increaseSixCount();
					
					yearVsTeamVsFourSixTotal.get(match.getSeason()).get(delivery.getBattingTeam()).increseTotalRuns(delivery.getTotalRuns()); 						
				}
				else {
					FourSixTotal score = new FourSixTotal();
					if (delivery.getBatsmanRuns() == 4)
						score.increaseFourCount();
					else if (delivery.getBatsmanRuns() == 6)
						score.increaseSixCount();
					
					score.increseTotalRuns(delivery.getTotalRuns()); 
					yearVsTeamVsFourSixTotal.get(match.getSeason()).put(delivery.getBattingTeam(), score);
				}	
			}
			else {
				HashMap<String, FourSixTotal> teamVsFourSixTotal = new HashMap<String, FourSixTotal>();
				FourSixTotal score = new FourSixTotal();
				teamVsFourSixTotal.put(delivery.getBattingTeam(), score);
				if (delivery.getBatsmanRuns() == 4)
					score.increaseFourCount();
				else if (delivery.getBatsmanRuns() == 6)
					score.increaseSixCount();
				
				score.increseTotalRuns(delivery.getTotalRuns()); 
					
				yearVsTeamVsFourSixTotal.put(match.getSeason(), teamVsFourSixTotal);
			}
		}
		
		return yearVsTeamVsFourSixTotal;
	}

	public static Map<Integer, HashMap<String, RunRateStatistics>> getTeamsYearWiseWithTopRunRate() {
		
		Map<Integer, HashMap<String, RunRateStatistics>> yearVsTeamVsRunRate = new HashMap<Integer, HashMap<String, RunRateStatistics>>();
				
		for (Delivery delivery : deliveries){
			String battingTeam = delivery.getBattingTeam();
			String bowlingTeam = delivery.getBowlingTeam();
			Match match = MatchService.getMatchByid(delivery.getMacthId());
			int season = match.getSeason();
			delivery.setSeason(season);
			
			if(yearVsTeamVsRunRate.containsKey(delivery.getSeason())) {
				if( yearVsTeamVsRunRate.get(season).containsKey(battingTeam) ){
					yearVsTeamVsRunRate.get(season).get(battingTeam).updateBattingTeamByDelivery(delivery);
				}
				else {
					RunRateStatistics battingTeamStatistics = RunRateStatistics.getBattingTeamStatisticsByDelivery(delivery);
					yearVsTeamVsRunRate.get(season).put(battingTeam, battingTeamStatistics);
				}
				if( yearVsTeamVsRunRate.get(season).containsKey(bowlingTeam) ){
					yearVsTeamVsRunRate.get(season).get(bowlingTeam).updateBowlingTeamByDelivery(delivery);
				}
				else {
					RunRateStatistics bowlingTeamStatistics = RunRateStatistics.getBowlingTeamStatisticsByDelivery(delivery);
					yearVsTeamVsRunRate.get(season).put(bowlingTeam, bowlingTeamStatistics);
				}
			}
			else {
				RunRateStatistics battingTeamStatistics = RunRateStatistics.getBattingTeamStatisticsByDelivery(delivery);
				RunRateStatistics bowlingTeamStatistics = RunRateStatistics.getBowlingTeamStatisticsByDelivery(delivery);
				HashMap<String, RunRateStatistics> teamVsRunRateStatistics = new HashMap<String, RunRateStatistics>();
				teamVsRunRateStatistics.put(battingTeam, battingTeamStatistics);
				teamVsRunRateStatistics.put(bowlingTeam, bowlingTeamStatistics);
				yearVsTeamVsRunRate.put(season, teamVsRunRateStatistics);				
			}
		}
		
		return yearVsTeamVsRunRate;
	}
}
