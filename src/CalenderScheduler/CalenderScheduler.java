package CalenderScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalenderScheduler implements ICalendarScheduler{
	
	private int startTime = Integer.MIN_VALUE; // Maximum of all preferred times
	private int endTime = Integer.MAX_VALUE;   // Minimum of all preferred times
	private Set<TimePeriod> nonDuplicateMeetings = new HashSet<TimePeriod>();
	private List<TimePeriod> allMeetings = new ArrayList<TimePeriod>();
	
	/*
	 This method sets all the calendar data appropriately
	 such as Maximum of all preferred times(startTime)
	 such as Minimum of all preferred times(endTime)
	 Sorts out all meetings based on endtime so that we traverse easily on meetings and find all possible meetings
	*/
	private void setupCalendarData(List<Employee> user) {
		
		for (int i = 0; i < user.size(); i++) {
			nonDuplicateMeetings.addAll(Arrays.asList(user.get(i).getEmployeeMeetings()));
			if(user.get(i).getPreferredTimeSlot().getStart() > startTime) {
				startTime = user.get(i).getPreferredTimeSlot().getStart();
				continue;
			}
			else if(user.get(i).getPreferredTimeSlot().getEnd() < endTime) {
				endTime = user.get(i).getPreferredTimeSlot().getEnd();
				continue;
			}
		}
		
		allMeetings.addAll(nonDuplicateMeetings);
		Collections.sort(allMeetings);
	}

	@Override
	public List<TimePeriod> findAvailableSlots(List<Employee> users, int meetDuration) {

		List<TimePeriod> availableSlots = new ArrayList<TimePeriod>();

		setupCalendarData(users);

		int temp = startTime;

		boolean metStartTime = false;

		for (int i = 0; i < allMeetings.size() - 1; i++) {

			TimePeriod currentMeeting = allMeetings.get(i);
			TimePeriod nextMeeting = allMeetings.get(i + 1);

			if ((startTime <= currentMeeting.getStart() ) && (temp >= startTime)) {
				metStartTime = true;
				startTime = currentMeeting.getEnd();
				if (nextMeeting.getStart() <= startTime) {
					startTime = nextMeeting.getEnd();
				}
				else {
					for(; startTime + meetDuration <= nextMeeting.getStart() &&
							startTime + meetDuration <= endTime; startTime = startTime + meetDuration) {
						availableSlots.add(new TimePeriod(startTime, startTime + meetDuration));
					}
				}
			}
			else {
				if (metStartTime) {
					startTime = currentMeeting.getEnd();
					for(; startTime + meetDuration <= nextMeeting.getStart() &&
							startTime + meetDuration <= endTime; startTime = startTime + meetDuration) {
						availableSlots.add(new TimePeriod(startTime, startTime + meetDuration));
					}
				}
				temp = currentMeeting.getEnd();
			}
		}

		return availableSlots;
	}
}
