package org.letsonlycode.kambv;

import java.util.*;

public class FindSetsOfNumbersThatAddUpToSum {

    public static void main(String[] args) {


        Object s = new TreeSet();

        s = new HashSet<>();
        /*int a[] = {2, 4, 6, 10};
        int sum = 16;
        System.out.println(countsSets(a, sum, 0));*/
    }

    private static int countsSets(int[] a, int sum, int start) {
        if(sum == 0)
            return 1;
        else if(sum < 0){
            return 0;
        }
        else if(start >= a.length){
            return 0;
        }
        else if(a[start] > sum) {
            return countsSets(a, sum, start+1);
        }
        else{
            return countsSets(a, sum - a[start], start+1) +
                    countsSets(a, sum,start+1);
        }
    }
}
