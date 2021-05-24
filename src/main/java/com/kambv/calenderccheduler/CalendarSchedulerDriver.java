package com.kambv.calenderccheduler;

import java.util.ArrayList;
import java.util.List;

public class CalendarSchedulerDriver {

    public static void main(String[] args) {

        TimePeriod emp1PreferredSlot = new TimePeriod(9, 18);
        TimePeriod emp2PreferredSlot = new TimePeriod(9, 18);
        TimePeriod emp3PreferredSlot = new TimePeriod(9, 18);

        TimePeriod[] employee1Meetings = new TimePeriod[] {new TimePeriod(9, 11), new TimePeriod(19, 20)};
        TimePeriod[] employee2Meetings = new TimePeriod[] {new TimePeriod(10, 12), new TimePeriod(14, 16), new TimePeriod(13, 14)};
        TimePeriod[] employee3Meetings = new TimePeriod[] {new TimePeriod(8, 10), new TimePeriod(10, 11)};

        Employee employee1 = new Employee("Employee1", emp1PreferredSlot, employee1Meetings);
        Employee employee2 = new Employee("Employee2", emp3PreferredSlot, employee2Meetings);
        Employee employee3 = new Employee("Employee3", emp1PreferredSlot, employee3Meetings);

        List<Employee> employees = new ArrayList<Employee>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        ICalendarScheduler calenderScheduler = new CalenderScheduler();

        List<TimePeriod> availableSlots = calenderScheduler.findAvailableSlots(employees, 2);

        System.out.println(availableSlots);
    }
}
