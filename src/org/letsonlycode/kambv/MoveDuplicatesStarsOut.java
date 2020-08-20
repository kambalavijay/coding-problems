package org.letsonlycode.kambv;

public class MoveDuplicatesStarsOut {

    public static void main(String[] args) {

        String s = "a***bc***d";

        char[] pattern = s.toCharArray();

        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex] = pattern[i];
                    writeIndex++;
                    isFirst = false;
                }
            } else {
                pattern[writeIndex] = pattern[i];
                writeIndex++;
                isFirst = true;
            }
        }
    }

}
