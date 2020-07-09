package iplproblem;

import java.util.Date;

public class Match {
	
	private int matchId;
	private int season;
	private String city;
	private Date date;
	private String team1;
	private String team2;
	private String tossWinner;
	private String tossDecision;
	private String result; 
	private String winner;
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDATE() {
		return date;
	}
	public void setDATE(Date date) {
		this.date = date;
	}
	public String geTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getTossWinneer() {
		return tossWinner;
	}
	public void setTossWinneer(String tossWinner) {
		this.tossWinner = tossWinner;
	}
	public String getTossDecision() {
		return tossDecision;
	}
	public void setTOSS_DECISION(String tossDecision) {
		this.tossDecision = tossDecision;
	}
	public String getRESULT() {
		return result;
	}
	public void setRESULT(String result) {
		this.result = result;
	}
	public String getWINNER() {
		return winner;
	}
	public void setWINNER(String winner) {
		this.winner = winner;
	}
	public Match(int matchId, int season, String city, Date date, String team1, String team2, String tossWinner,
			String tossDecision, String result, String winner) {
		super();
		this.matchId = matchId;
		this.season = season;
		this.city = city;
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.tossWinner = tossWinner;
		this.tossDecision = tossDecision;
		this.result = result;
		this.winner = winner;
	}
	
	@Override
	public String toString() {
		return "Match [MATCH_ID=" + matchId + ", SEASON=" + season + ", CITY=" + city + ", DATE=" + date + ", TEAM1="
				+ team1 + ", TEAM2=" + team2 + ", TOSS_WINNER=" + tossWinner + ", TOSS_DECISION=" + tossDecision
				+ ", RESULT=" + result + ", WINNER=" + winner + "]";
	}
}
