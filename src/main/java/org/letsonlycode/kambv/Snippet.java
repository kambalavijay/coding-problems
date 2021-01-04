package org.letsonlycode.kambv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// Java Program to find minimum number of manipulations
// required to make two strings identical
public class Snippet {

    private static Logger logger = Logger.getLogger(Snippet.class.toString());

    // Counts the no of manipulations required
    static int countManipulations(String s1, String s2)
    {
        logger.info("in countManipulations method...");
        int count = 0;

        // store the count of character
        int char_count[] = new int[26];

        // iterate though the first String and update
        // count
        for (int i = 0; i < s1.length(); i++)
            char_count[s1.charAt(i) - 'a']++;

        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < s2.length(); i++)
        {
            char_count[s2.charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(char_count));

        for(int i = 0; i < 26; ++i)
        {
            if(char_count[i] != 0)
            {
                count+=char_count[i];
            }
        }

        return count;
    }

    // Driver code
    public static void main(String[] args)
    {
        String prefix = "Vi";

        List list  = com.sun.tools.javac.util.List.of("Vijay", "Vinay", "Vikram", "Vijesh", "Vimala", "Vani");



        List list1 = (List) list.
                stream().
                filter(Filter.startswithPrefix(prefix)).
                map(Filter.getDistinctCharsFunction()).
                collect(Collectors.toList());

        System.out.println(list1);
    }
}

class Filter{

    public static Predicate<String> startswithPrefix(String prefix){
        Predicate<String> p = str -> str.startsWith(prefix);
        return p;
    }

    public static Function<String, Integer> getDistinctCharsFunction(){

        Function<String, Integer> fun = (String str) -> {
            Set distinctChars = new HashSet();
            for (int i = 0; i < str.length(); i++) {
                distinctChars.add(str.charAt(i));
            }
            return distinctChars.size();
        };

        return fun;
    }

}
