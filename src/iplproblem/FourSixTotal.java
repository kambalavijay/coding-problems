package iplproblem;

public class FourSixTotal {
	
	private int fourCount;
	private int sixCount;
	private int totalRuns;
	
	public FourSixTotal() {
		this.fourCount = 0;
		this.sixCount = 0;
		this.totalRuns = 0;
	}
	
	public void increaseFourCount() {
		this.fourCount = this.fourCount + 1;
	}
	
	public void increaseSixCount() {
		this.sixCount = this.sixCount + 1;
	}
	
	public void increseTotalRuns(int incrimentBy){
		totalRuns = totalRuns + incrimentBy;
	}

	public int getFourCount() {
		return fourCount;
	}

	public void setFourCount(int fourCount) {
		this.fourCount = fourCount;
	}

	public int getSixCount() {
		return sixCount;
	}

	public void setSixCount(int sixCount) {
		this.sixCount = sixCount;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	@Override
	public String toString() {
		return "FourSixTotal [fourCount=" + fourCount + ", sixCount=" + sixCount + ", totalRuns=" + totalRuns + "]";
	}
	
}
