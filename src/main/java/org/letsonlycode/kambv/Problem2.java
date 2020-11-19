package org.letsonlycode.kambv;

public class Problem2 {

    public static void main(String[] args) {

        // Given array is already sorted so need to sort

        int a[] = {5, 1, 2, 3, 4};

        // Logn

        // 1 2 3 4 5
        // 5 1 2 3 4 -> 1st
        // 4 5 1 2 3 -> 2nd
        // 3 4 5 1 2 -> 3rd
        // 2 3 4 5 1 -> 4th
        // 1 2 3 4 5

       /* int min = Integer.MAX_VALUE;
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        int index = 0;
        boolean flag = false;

        while(left < right){
            mid = (left + right) / 2;
            if(min > a[mid]){
                min = a[mid];
            }
            else if(min < a[mid]){
                right = mid - 1;
            }
            else if(min > a[mid]){
                left = mid + 1;
            }
        }

        if(flag){
            System.out.println(index);
        }
        else{
            mid = (left+right)/2;
            if(key == a[mid]){
                System.out.println(mid);
            }
            else{
                System.out.println("Not found");
            }
        }*/





    }
}
