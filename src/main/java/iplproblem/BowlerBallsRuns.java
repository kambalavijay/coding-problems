package iplproblem;

public class BowlerBallsRuns {
	
	private int balls;
	private int runs;
	private String bowlerName;
	
	public BowlerBallsRuns(String bowlerName) {
		super();
		this.balls = 0;
		this.runs = 0;
		this.bowlerName = bowlerName;
	}
	
	public int getBalls() {
		return balls;
	}
	
	public void setBalls(int balls) {
		this.balls = balls;
	}
	
	public int getRuns() {
		return runs;
	}
	
	public void setRuns(int runs) {
		this.runs = runs;
	}
	
	public void increaseBallsCountByDelivery(Delivery delivery){
		
		if( !(delivery.getNoBallRuns() > 0 || delivery.getWideRuns() > 0))
			this.balls = this.balls + 1;
	}
	
	public void increseRuns(int incrimentBy){
		this.runs = this.runs + incrimentBy;
	}
	
	public String getBowlerName(){
		return this.bowlerName;
	}
	
	@Override
	public String toString() {
		return "BallsRuns [bowler=" + this.bowlerName + ", balls=" + balls + ", runs=" + runs + ", overs=" + getTotalOvers() + ", economy=" + getEconomy() + "]";
	}

	public float getTotalOvers() {
		float overs = balls / 6;
		int overFlow = balls % 6;
		float totalOvers = overs + (float) (overFlow > 0 ? (float) overFlow / 6 : 0.0);
		
		return (float) (Math.round(totalOvers*100.0)/100.0);
	}
	
	public float getEconomy() {
		return (float) (Math.round((runs / getTotalOvers())*100.0)/100.0);
	}	
}
