package org.letsonlycode.kambv;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        int a[] = {2, 4, 6, 8, 9, 10};
        int b[] = {1, 3, 5, 6, 7, 11, 13};

        int c[] = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        /*
        * Iterate over both the array and copy the elements to new array based on comparison
        * */
        while (j < a.length && i < b.length){
            if(b[i] > a[j]){
                c[k++] = a[j++];
            }
            else if(b[i] < a[j]){
                c[k++] = b[i++];
            }
            else{
                c[k++] = a[j++];
                c[k++] = b[j++];
            }
        }

        // fill all elements in array a if there are any left overs
        while (j < a.length){
            c[k++] = a[j++];
        }

        // fill all elements in array a if there are any left overs
        while (i < b.length){
            c[k++] = b[i++];
        }

        System.out.println(Arrays.toString(c));
    }
}
