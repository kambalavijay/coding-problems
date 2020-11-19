package iplproblem;

import java.util.Map;

@SuppressWarnings("hiding")
public class TeamVsRunrateStatistics<String, RunRateStatistics> implements Map.Entry<String, RunRateStatistics> {
    private String key;
    private RunRateStatistics value;

    public TeamVsRunrateStatistics(String key, RunRateStatistics value) {
        this.key = key;
        this.value = value;
    }
    
    public void setKey(String key) {
    	this.key =  key;
    }
    
    @Override
    public String getKey() {
        return key;
    }

    @Override
    public RunRateStatistics getValue() {
        return value;
    }

    @Override
    public RunRateStatistics setValue(RunRateStatistics value) {
    	RunRateStatistics old = this.value;
        this.value = value;
        return old;
    }


	public java.lang.String toString() {
		return "TeamVsRunrateStatistics [key=" + key + ", value=" + this.value.toString() + "]";
	}
    
}