package org.letsonlycode.kambv;

import java.util.Arrays;

public class LongestSubStringWithoutRepeatingChars {


    public static void main(String[] args) {
        String str = "ABDEFGABEFTRSA";

        int n = str.length();
        int i = 0;

        int res = 0;

        int [] prevIndex = new int[256];
        for (int j = 0; j < prevIndex.length; j++) {
            prevIndex[j] = -1;
        }
        int j = 0;
        for (; j < n; j++) {

            i = Math.max(i, prevIndex[str.charAt(j)] + 1);

            res = Math.max(res, j - i + 1);

            prevIndex[str.charAt(j)] = j;
        }


    }
}
