package CalenderScheduler;

import java.util.List;

public interface ICalendarScheduler {

    List<TimePeriod> findAvailableSlots(List<Employee> employees, int meetDuration);
}
