package iplproblem;

public class Delivery {

	private int matchId;	
	private int inning;
	private String battingTeam;	
	private String bowlingTeam;	
	private int over;
	private int ball;
	private String batsman;
	private String bowler;
	private int wideRuns;
	private int byeRuns;
	private int legByeRuns;
	private int noBallRuns;
	private int penaltyRuns;	
	private int batsmanRuns;	
	private int extraRuns;
	private int totalRuns;
	private int season;
	
	public Delivery(int matchId, int inning, String battingTeam, String bowlingTeam, int over, int ball, String batsman,
			String bowler, int wideRuns, int byeRuns, int legByeRuns, int noBallRuns, int penaltyRuns,
			int batsmanRuns, int extraRuns, int totalRuns) {
		super();
		this.matchId = matchId;
		this.inning = inning;
		this.battingTeam = battingTeam;
		this.bowlingTeam = bowlingTeam;
		this.over = over;
		this.ball = ball;
		this.batsman = batsman;
		this.bowler = bowler;
		this.wideRuns = wideRuns;
		this.byeRuns = byeRuns;
		this.legByeRuns = legByeRuns;
		this.noBallRuns = noBallRuns;
		this.penaltyRuns = penaltyRuns;
		this.batsmanRuns = batsmanRuns;
		this.extraRuns = extraRuns;
		this.totalRuns = totalRuns;
	}
	
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	
	public int getMacthId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getInning() {
		return inning;
	}
	public void setInning(int iNNING) {
		inning = iNNING;
	}
	public String getBattingTeam() {
		return battingTeam;
	}
	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}
	public String getBowlingTeam() {
		return bowlingTeam;
	}
	public void setBowlingTeam(String bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}
	public int getOVER() {
		return over;
	}
	public void setOver(int over) {
		this.over = over;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public String getBatsman() {
		return batsman;
	}
	public void setBatsamn(String batsman) {
		this.batsman = batsman;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	public int getWideRuns() {
		return wideRuns;
	}
	public void setWideRuns(int wideRuns) {
		this.wideRuns = wideRuns;
	}
	public int getBYE_RUNS() {
		return byeRuns;
	}
	public void setByeRuns(int byeRuns) {
		this.byeRuns = byeRuns;
	}
	public int getLegByeRuns() {
		return legByeRuns;
	}
	public void setLegByeRuns(int legByeRuns) {
		this.legByeRuns = legByeRuns;
	}
	public int getNoBallRuns() {
		return noBallRuns;
	}
	public void setNoBallRuns(int noBallRuns) {
		this.noBallRuns = noBallRuns;
	}
	public int getPenaltyRuns() {
		return penaltyRuns;
	}
	public void setPenaltyRuns(int penaltyRuns) {
		this.penaltyRuns = penaltyRuns;
	}
	public int getBatsmanRuns() {
		return batsmanRuns;
	}
	public void setBatsmanRuns(int batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}
	public int getExtraRuns() {
		return extraRuns;
	}
	public void setExtraRuns(int extraRuns) {
		this.extraRuns = extraRuns;
	}
	public int getTotalRuns() {
		return totalRuns;
	}
	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
	
	@Override
	public String toString() {
		return "Delivery [MATCH_ID=" + matchId + ", INNING=" + inning + ", BATTING_TEAM=" + battingTeam
				+ ", BOWLING_TEAM=" + bowlingTeam + ", OVER=" + over + ", BALL=" + ball + ", BATSMAN=" + batsman
				+ ", BOWLER=" + bowler + ", WIDE_RUNS=" + wideRuns + ", BYE_RUNS=" + byeRuns + ", LEGBYE_RUNS="
				+ legByeRuns + ", NOBALL_RUNS=" + noBallRuns + ", PENALTY_RUNS=" + penaltyRuns + ", BATSMAN_RUNS="
				+ batsmanRuns + ", EXTRA_RUNS=" + extraRuns + ", TOTAL_RUNS=" + totalRuns + "]";
	}
	
}
