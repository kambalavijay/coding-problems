package org.letsonlycode.kambv;


import java.util.HashSet;
import java.util.Set;

public class FindPairEqualToSum {

    static boolean doesPairExist(int a[], int sum){
        boolean found = false;
        Set inverts = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int invert = sum - a[i];
            if(inverts.contains(invert)){
                found = true;
                break;
            }
            else{
                inverts.add(a[i]);
            }
        }

        return found;
    }

    public static void main(String[] args) {

        // testcase 1
        int a[] = {1, 2, 4, 4};
        int sum = 8;
        System.out.println(doesPairExist(a, sum));

        // testcase 2
        int b[] = {1, 2, 3, 7};
        sum = 8;
        System.out.println(doesPairExist(b, sum));

        // testcase 3
        int c[] = {1, 2, 3, 7};
        sum = 10;
        System.out.println(doesPairExist(c, sum));
    }
}
