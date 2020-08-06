package org.letsonlycode.kambv;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int array[] = {2, 4, 3, 8, 1, 9, 11, 6};

        System.out.println("before sort : " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("after sort : " + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {

        if(start < end){
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex-1);
            quickSort(array, pivotIndex+1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pivotIndex = start;

        for (; start < end; start++) {
            if(array[start] <= pivot /*&& start != pivotIndex*/){
                int temp = array[start];
                array[start] = array[pivotIndex];
                array[pivotIndex] = temp;
                pivotIndex++;
            }
        }
        int temp = array[pivotIndex];
        array[pivotIndex] = array[end];
        array[end] = temp;

        return pivotIndex;
    }
}
