package org.letsonlycode.kambv;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Pramati {



    // Complete the whichSweetShouldIBring function below.
    static String whichSweetShouldIBring(List<String> votes) {

        Map<String, Integer> sweetsAndFreq = new TreeMap<>(Collections.reverseOrder());

        for (String sweet : votes) {
            if (sweetsAndFreq.containsKey(sweet)) {
                sweetsAndFreq.put(sweet, sweetsAndFreq.get(sweet) + 1);
            } else {
                sweetsAndFreq.put(sweet, 1);
            }
        }

        List<Map.Entry<String, Integer>> l = sweetsAndFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()).collect(Collectors.toList());

        return l.get(0).getKey();
    }


    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int votesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> votes = new ArrayList<>();

        for (int i = 0; i < votesCount; i++) {
            String votesItem = bufferedReader.readLine();
            votes.add(votesItem);
        }*/

        List l = new ArrayList();
        l.add("Gulab-jamun");
        l.add("Gulab-jamun");
        l.add("Gulab-jamun");
        l.add("Gajar-halwa");
        l.add("Gajar-halwa");
        l.add("Gajar-halwa");

        String res = whichSweetShouldIBring(l);

        /*bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
