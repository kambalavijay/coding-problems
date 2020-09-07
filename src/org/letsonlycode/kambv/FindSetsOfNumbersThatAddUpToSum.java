package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.List;

public class FindSetsOfNumbersThatAddUpToSum {

    public static void main(String[] args) {

        int a[] = {2, 4, 6, 10};
        int sum = 16;

        List l = new ArrayList();

        System.out.println(countsSets(a, sum, 0));
        System.out.println(l);
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
        else if(sum < a[start]) {
            return countsSets(a, sum, start+1);
        }
        else{
            return countsSets(a, sum - a[start], start+1) + countsSets(a, sum,start+1);
        }
    }
}
