package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoParallelStream {

    public static void main(String[] args) {

        List<Employee> l = new ArrayList<Employee>();

        for (int i = 1; i <= 5; i++) {
            Employee e = new Employee("A"+i, i);
            l.add(e);
        }
        int sum = l.stream().mapToInt((Employee e) -> e.salary).sum();
        System.out.println(sum);
    }
}


class Employee{
    String name;
    int salary;

    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
}
