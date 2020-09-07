package org.letsonlycode.kambv;

/*
You are given a string containing characters A and B only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, given the string S = "AABAAB" , remove an A at positions 0 and 3 to make s = "ABAB" in 2 deletions.

Function Description

Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of deletions to make the alternating string.

alternatingCharacters has the following parameter(s):
* */

public class AlternatingCharacters {

    public static void main(String[] args) {

        String s[] = new String[]{"AAAA", "BBBBB", "ABABABAB" ,"BABABA","AAABBB"};

        for(int k = 0; k < s.length; k++) {

            int i = 0;
            int n = s[k].length();
            char chars[] = s[k].toCharArray();
            int j = 1;
            int count = 0;

            while (j < n) {
                if (chars[i] == chars[j]) {
                    j++;
                    count++;
                }
                else if (chars[i] != chars[j]) {
                    i = j;
                    j++;
                }
            }

            System.out.println(count);
        }
    }

}

