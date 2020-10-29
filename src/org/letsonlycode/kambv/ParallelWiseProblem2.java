package org.letsonlycode.kambv;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ParallelWiseProblem2 {
    public static void main(String[] args) {

        // No duplicates & +ve
        int a[] = {5,8,2,1,3,4,6,9};
        // {5, 2, 1, 3}

        for (int i = 0; i < a.length;) {
            if(a[i] < a.length && a[i] > 0){
                int rightIndex = a[i] - 1;
                int temp = a[rightIndex];
                a[rightIndex] = a[i];
                a[i] = temp;
                if(a[i]-1 == i){
                    i++;
                }
                continue;
            }
            i++;
        }

        System.out.println(Arrays.toString(a));

        boolean flag = true;
        int i = 1;
        for (; i < a.length; i++) {
            if(a[i-1]+1 != a[i]){
                flag = false;
                break;
            }
        }
        if(!flag){
            System.out.println(a[i-1]+1);
        }

        /*Arrays.sort(a);
        boolean flag = true;
        int i = 1;
        for (; i < a.length; i++) {
            if(a[i-1]+1 != a[i]){
                flag = false;
                break;
            }
        }

        if(!flag){
            System.out.println(a[i-1]+1);
        }*/
    }
}
