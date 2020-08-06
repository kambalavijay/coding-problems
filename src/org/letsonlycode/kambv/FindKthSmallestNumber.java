package org.letsonlycode.kambv;

public class FindKthSmallestNumber {

    public static void main(String[] args) {

        /*Given an array and a number k where k is smaller than size of array,
        we need to find the k’th smallest element in the given array.
        It is given that all array elements are distinct.

        Examples:

        Input: arr[] = {7, 10, 4, 3, 20, 15}
        k = 3
        Output: 7

        Input: arr[] = {7, 10, 4, 3, 20, 15}
        k = 4
        Output: 10*/

        int input[] = {2, 4, 3, 8, 1, 9, 11, 6};

        //   sorted = {1, 2, 3, 4, 6, 8, 9, 11}
        int k = 1;
        int ele = findKthSmallestNumber(input, 0, input.length - 1 , k);
        System.out.println("Kth Smallest element : " + ele);

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

    static int findKthSmallestNumber(int[] array, int start, int end, int k) {

        int pivotIndex = partition(array, start, end);

        if(pivotIndex == k-1){
            return array[pivotIndex];
        }
        else if(pivotIndex < k-1 ){
            return findKthSmallestNumber(array, pivotIndex+1, end, k);
        }
        else{
            return findKthSmallestNumber(array, start, pivotIndex-1, k);
        }
    }
}
