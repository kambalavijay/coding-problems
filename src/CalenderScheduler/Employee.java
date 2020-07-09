package CalenderScheduler;

class Employee{
	
	String name;
	TimePeriod preferredTimeSlot;
	TimePeriod[] employeeMeetings;
	
	public Employee(String name, TimePeriod preferredTimeSlot, TimePeriod[] employeeMeetings){
		
		this.name = name;
		this.preferredTimeSlot = preferredTimeSlot;
		this.employeeMeetings = employeeMeetings;
	}

	public String getName() {
		return name;
	}

	public TimePeriod getPreferredTimeSlot() {
		return preferredTimeSlot;
	}

	public TimePeriod[] getEmployeeMeetings() {
		return employeeMeetings;
	}
}