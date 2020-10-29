package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Java 8 example to convert each element of List into upper case. You can use
 * Map function of Java 8 to transform each element of List or any collection.
 * @author Javin
 */
public class Java8MapExample {

    public static void main(String args[]) {
       List<String> cities = Arrays.asList("London", "HongKong", "Paris", "NewYork");

       System.out.println("Original list : " + cities);

       System.out.println("list transformed using Java 8 :" + transform(cities));
       System.out.println("list transformed using loop before Java 8 : " + beforeJava8(cities));
       
       
       // You can even on the fly tranform Collection in Java using
       // Map function
       // let's transform a List of integers to square each element
       List<Integer> numbers = Arrays.asList(8, 9, 1, 2, 3, 4, 5, 6, 9);

       numbers.stream().map(i -> i+1).filter(i -> i%2 !=0).allMatch(i -> i>=5);


       System.out.println("original list of numbers : " + numbers);

       //System.out.println("transformed list of integers using Map in Java 8 : " + squares);

    }

    /**
     * This is how you convert all elements of list into upper case 
     * using loop before Java 8
     * @param listOfString
     * @return List with each element converted into upper case
     */
    public static List<String> beforeJava8(List<String> listOfString) {
        List<String> coll = new ArrayList<>();
        for (String str : listOfString) {
            coll.add(str.toUpperCase());
        }
        return coll;
    }

    /**
     * You can use Java 8 map function to transform each element of list
     * @param listOfString
     * @return list of elements with upper case
     */
    public static List<String> transform(List<String> listOfString) {
        return listOfString.stream() // Convert list to Stream
                .map(String::toUpperCase) // Convert each element to upper case
                .collect(toList()); // Collect results into a new list
    }

}
