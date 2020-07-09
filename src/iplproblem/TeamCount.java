package iplproblem;

public class TeamCount {
	
	private int count;
	private String team;
	
	public TeamCount(int count, String team) {
		super();
		this.count = count;
		this.team = team;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	public void IncreaseCount() {
		this.count = this.count + 1; 
	}

	@Override
	public String toString() {
		return "TeamCount [count=" + count + ", team=" + team + "]";
	}
}
