package org.letsonlycode.kambv;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int array[] = {7, 3, 1, 2, 8, 4};

        System.out.println("Before sort : " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("After sort : " + Arrays.toString(array));
    }private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {

            int pivot = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] >= pivot){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                j--;
            }

            array[j+1] = pivot;
        }
    }


}
