package CalenderScheduler;

class TimePeriod implements Comparable<TimePeriod>{
	private int start;
	private int end;
	
	public TimePeriod(int start, int end) {
		
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		TimePeriod t = (TimePeriod)obj;
		return this.start == t.start && this.end == t.end;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + start +", " + end  + "]";
	}

	@Override
	public int compareTo(TimePeriod o) {
		// TODO Auto-generated method stub
		return this.end - o.end; /* this.end - o.end;*/
	}
	
}