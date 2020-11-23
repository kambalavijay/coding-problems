package org.letsonlycode.kambv;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pramati {

    static String whichSweetShouldIBring(List<String> votes) {

        List<Map.Entry<String, Long>> l = votes.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting()
                )
        ).entrySet().stream().
                sorted(Map.Entry.<String, Long>comparingByKey(Collections.reverseOrder())).
                collect(Collectors.toList()).stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).
                collect(Collectors.toList());

        return l.get(0).getKey();
    }


    public static void main(String[] args) throws IOException {

        /*List l = new ArrayList();
        l.add("A");
        l.add("A");
        l.add("C");
        l.add("C");
        l.add("C");
        l.add("D");
        l.add("D");
        l.add("D");
        l.add("B");l.add("B");l.add("B");l.add("B");

        String res = whichSweetShouldIBring(l);
        System.out.println(res);
        */
        Random r = new Random();
        System.out.println(r.nextInt(10));
    }
}
