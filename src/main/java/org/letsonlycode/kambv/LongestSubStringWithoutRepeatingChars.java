package org.letsonlycode.kambv;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {


    public static void main(String[] args) {
        String str = "ABCDEFGHIJAKLMNOPQRSTUV";

        int n = str.length();
        int i = 0, j = 0;

        int maxLen = Integer.MIN_VALUE;
        Set s = new HashSet<>();

        while (j < n) {
            char c = str.charAt(j);
            if(s.contains(c)){
                s.clear();
                s.add(c);
                i++;
            }
            else{
                s.add(c);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        System.out.println("Longest substring " + str.substring(i, j));
        System.out.println("Length of longest substring " + maxLen);
    }

    void func1(){
        return;
    }
}
