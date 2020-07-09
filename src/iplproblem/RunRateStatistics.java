package iplproblem;

// * Net Run Rate = (Total Runs Scored / Total Overs Faced) – (Total Runs Conceded /Total Overs Bowled)

public class RunRateStatistics {
	
	private int totalRunsScored;
	private int totalBallsFaced;
	private int totalRunsConceded;
	private int totalBallsBowled;
	private int season;
	private float netRunRate;

	public RunRateStatistics() {
		this.totalRunsScored = 0;
		this.totalBallsFaced = 0;
		this.totalRunsConceded = 0;
		this.totalBallsBowled = 0;
		this.netRunRate = 0;
	}

	public float getNetRunRate() {
		calculateNetRunRate();
		return netRunRate;
	}

	public void setNetRunRate(float netRunRate) {
		this.netRunRate = netRunRate;
	}
	
	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getTotalRunsScored() {
		return totalRunsScored;
	}

	public void setTotalRunsScored(int totalRunsScored) {
		this.totalRunsScored = totalRunsScored;
	}

	public int getTotalBallsFaced() {
		return totalBallsFaced;
	}

	public void setBallsFaced(int totalBallsFaced) {
		this.totalBallsFaced = totalBallsFaced;
	}

	public int getTotalRunsConceded() {
		return totalRunsConceded;
	}

	public void setTotalRunsConceded(int totalRunsConceded) {
		this.totalRunsConceded = totalRunsConceded;
	}

	public int getTotalBallsBowled() {
		return totalBallsBowled;
	}

	public void setTotalBallsBowled(int totalBallsBowled) {
		this.totalBallsBowled = totalBallsBowled;
	}
	
	public void increaseBallsFaced(Delivery delivery) {
		if( !(delivery.getNoBallRuns() > 0 || delivery.getWideRuns() > 0))
			this.totalBallsFaced = this.totalBallsFaced + 1;
	}
	
	public void increaseBallsBowled(Delivery delivery) {
		if( !(delivery.getNoBallRuns() > 0 || delivery.getWideRuns() > 0))
			this.totalBallsBowled = this.totalBallsBowled + 1;
	}
	
	public void increaseTotalRunsScoredBy(int runsScored) {
		this.totalRunsScored = this.totalRunsScored + runsScored;
	}
	
	public void increaseTotalRunsConcededBy(int runsConceded) {
		this.totalRunsConceded = this.totalRunsConceded + runsConceded;
	}
	
	public float getTotalOversFaced(){
		float overs = getTotalBallsFaced() / 6;
		int overFlow = getTotalBallsFaced() % 6;
		float totalOvers = overs + (float) (overFlow > 0 ? (float) overFlow / 6 : 0.0);
		
		return (float) (Math.round(totalOvers * 100.0) / 100.0);
	}
	
	public float getTotalOversBowled(){
		float overs = getTotalBallsBowled() / 6;
		int overFlow = getTotalBallsBowled() % 6;
		float totalOvers = overs + (float) (overFlow > 0 ? (float) overFlow / 6 : 0.0);
		
		return (float) (Math.round(totalOvers * 100.0) / 100.0);
	}
	
	public void calculateNetRunRate(){
		
		float netRunrate = (float)(getTotalRunsScored() / getTotalOversFaced()) - (float)(getTotalRunsConceded() / getTotalOversBowled());
		
		this.netRunRate = (float) (Math.round(netRunrate * 100.0) / 100.0);
	}
	
	public static RunRateStatistics getBattingTeamStatisticsByDelivery(Delivery delivery) {
	
		RunRateStatistics battingTeamStatistics = new RunRateStatistics();
		battingTeamStatistics.setSeason(delivery.getSeason());
		battingTeamStatistics.increaseBallsFaced(delivery);
		battingTeamStatistics.increaseTotalRunsScoredBy(delivery.getTotalRuns());
		
		return battingTeamStatistics;
	}
	
	public static RunRateStatistics getBowlingTeamStatisticsByDelivery(Delivery delivery) {
		
		RunRateStatistics bowlingTeamStatistics = new RunRateStatistics();
		bowlingTeamStatistics.setSeason(delivery.getSeason());
		bowlingTeamStatistics.increaseBallsBowled(delivery);
		bowlingTeamStatistics.increaseTotalRunsConcededBy(delivery.getTotalRuns());
		
		return bowlingTeamStatistics;
	}
	
	public void updateBattingTeamByDelivery(Delivery delivery) {
		this.increaseBallsFaced(delivery);
		this.increaseTotalRunsScoredBy(delivery.getTotalRuns());
	}
	
	public void updateBowlingTeamByDelivery(Delivery delivery) {
		this.increaseBallsBowled(delivery);
		this.increaseTotalRunsConcededBy(delivery.getTotalRuns());
	}

	@Override
	public String toString() {
		return "RunRateStatistics [" +
				"netRunRate" + getNetRunRate() +
				", totalRunsScored=" + totalRunsScored +
				", totalOversFaced=" + getTotalOversFaced() +
				", totalBallsFaced=" + getTotalBallsFaced() +
				", totalRunsConceded=" + totalRunsConceded +
				", totalTotalOversBowled=" + getTotalOversBowled() +
				", totalBallsBowled=" + getTotalBallsBowled() +
				"]";
	}
	
}
