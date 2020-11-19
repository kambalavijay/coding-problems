package org.letsonlycode.kambv;

final class ImmutableStudent {
    private final int id;
    private final String name;
    private final Age age;

    public ImmutableStudent(int id, String name, Age age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ImmutableStudentDriver{
    public static void main(String[] args) {
        Age a = new Age();
        a.setDay(19);
        a.setMonth(11);
        a.setYear(1993);
        ImmutableStudent i = new ImmutableStudent(100, "A", a);
        System.out.println(i);
        Age a1 = i.getAge();
        System.out.println(a1);
        a1.setYear(1994);
        System.out.println(i);
        System.out.println(a1);

    }
}

class Age {
    private int day;
    private int month;
    private int year;
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Age{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
