package org.letsonlycode.kambv;

import java.util.HashMap;
import java.util.Map;

public class SpecialSubStringsWithZerosAndOnes {
    public static int getSpecialSubstring(String s, int k, String charValue) {
        // Write your code here
        int needed = k;
        int count = 0;
        int start = 0;
        int end   = 0;
        int maxLen = 0;
        int minStart = 0;
        int minEnd = 0;

        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        for(int i = 0; i < charValue.length(); i++){
            char charVal = (char)(97 + i);
            if(charValue.charAt(i) == '0')
                charMap.put(charVal, 0);
            else{
                charMap.put(charVal, 1);
            }
        }

        while(end != s.length()) {
            char currChar = s.charAt(end);
            int intRep = charMap.get(currChar);
            if (count < k && intRep == 0) {
                count++;
                end++;
            }
            else if (count < k && intRep == 1) {
                end++;
            }
            else if (count == k && (intRep == 1)) {
                end++;
            }
            else if (count == k && (intRep == 0)) {
                maxLen = Math.max(maxLen, end - start);
                while(charMap.get(s.charAt(start)) != 0){
                    start++;
                }
                start++;
                count--;
            }
            else{
                continue;
            }
        }

        maxLen = Math.max(maxLen, end - start);
        return maxLen;
    }

    public static void main(String[] args) {
        //System.out.println(getSpecialSubstring("stupid", 1, "00000000000000000000000000"));
        System.out.println(getSpecialSubstring("giraffe", 2, "01110101111111111011111111"));
        //System.out.println(getSpecialSubstring("abcdefghijkl", 2, "10101110111111111111111111"));
    }

    // gir ira

    //  a b c d e f g h i j k l m n o p q r s t u v w x y z
    //  0 1 1 1 1 0 0 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1 1 1
    /*

    while(end != s.length()) {
            if (charMap.get(s.charAt(end)) == 0) {
                count++;
            }
            while(needed <= count && start < end) {
                if (charMap.get(s.charAt(start)) == 1){
                    start++;
                }
                else if (needed < count && charMap.get(s.charAt(start)) == 0) {
                    count--;
                    start++;
                }
                else {
                    break;
                }
            }
            if(needed == count && maxLen < (end - start + 1)) {
                maxLen = (end - start + 1);
                minStart = start;
                minEnd = end;
            }
            end++;
        }

        return maxLen;
    * */
}


