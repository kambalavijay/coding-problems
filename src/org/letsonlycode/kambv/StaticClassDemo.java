package org.letsonlycode.kambv;

import java.util.Comparator;

class Student implements Comparable<Student>{
    private String name;
    private int id;
    private int age;
    
    public Student() {}
    
    public Student(int id, String name, int age) {
    	this.age = age;
    	this.id = id;
    	this.name = name;
    }
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
	}

	
	public static class IdReverseComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o2.getId() - o1.getId();
		}
	}

	@Override
	public int compareTo(Student o) {
		return this.id - o.id;
	}
}

public class StaticClassDemo{
	
	public static void main(String[] args) {
		Method m = Method.GET;
		System.out.println(m.name().equals("GET"));

	}

	public enum Method {
		GET,
		POST,
		PUT,
		PATCH,
		DELETE
	}
}