package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllStringAnagramPatternMatching {

    public static void main(String[] args) {

        String input = "abbcabc";
        String pattern = "abc";
        List<Integer> output = findStringAnagrams(input, pattern);
        System.out.println("Output: " + output);
    }

    // exactly same as @StringPermutationPatternMatching only difference is return is list instead of boolean.
    private static List<Integer> findStringAnagrams(final String str, final String pattern) {
        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> pattCharFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            pattCharFrequencyMap.put(chr, pattCharFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        List<Integer> resultIndices = new ArrayList<Integer>();
        int windowEnd = 0;
        // our goal is to match all the characters from the map with the current window
        for ( ;windowEnd < pattern.length(); windowEnd++) {
            char chr = str.charAt(windowEnd);
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }
        if(charFrequencyMap.equals(pattCharFrequencyMap)){
            resultIndices.add(windowStart);
        }

        for ( ;windowEnd < str.length(); windowEnd++) {
            char chr = str.charAt(windowEnd);
            char chr1 = str.charAt(windowStart);
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
            charFrequencyMap.put(chr1, charFrequencyMap.getOrDefault(chr1, 0) - 1);
            windowStart++;
            if(charFrequencyMap.equals(pattCharFrequencyMap)){
                resultIndices.add(windowStart);
            }
        }

        return resultIndices;
    }
}
