package org.letsonlycode.kambv;

import java.util.Arrays;

public class RotateArrayLeft {

    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4, 5};
        // No of left rotations
        int d = 4;
        // Reminder of no of rotations divided by no of elements give exact no of rotations to be done
        d = d % a.length;

        for (int j = 0; j < d; j++) {
            int first = a[0];
            int i;
            for (i = 1; i < a.length; i++) {
                a[i-1] = a[i];
            }
            a[i-1] = first;
            System.out.println(Arrays.toString(a));
        }
    }
}
