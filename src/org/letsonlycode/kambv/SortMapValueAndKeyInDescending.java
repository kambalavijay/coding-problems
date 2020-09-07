package org.letsonlycode.kambv;

import java.io.*;
import java.util.*;;
import java.util.stream.Collectors;

public class SortMapValueAndKeyInDescending {

    // Complete the whichSweetShouldIBring function below.
    static String whichSweetShouldIBring(List<String> names) {

        Map<String, Integer> namesAndFreq = new TreeMap<>(Collections.reverseOrder());

        for (String sweet : names) {
            if (namesAndFreq.containsKey(sweet)) {
                namesAndFreq.put(sweet, namesAndFreq.get(sweet) + 1);
            } else {
                namesAndFreq.put(sweet, 1);
            }
        }

        List<Map.Entry<String, Integer>> l = namesAndFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()).collect(Collectors.toList());

        return l.get(0).getKey();
    }


    public static void main(String[] args) throws IOException {

        List l = new ArrayList();
        l.add("Gulab-jamun");
        l.add("Gulab-jamun");
        l.add("Gulab-jamun");
        l.add("Gajar-halwa");
        l.add("Gajar-halwa");
        l.add("Gajar-halwa");

        String res = whichSweetShouldIBring(l);

        System.out.println(res);
    }
}
