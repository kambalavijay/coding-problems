package org.letsonlycode.kambv;

public class MaxConsecutiveOnes1 {

    public static void main(String[] args) {

        int A[] = new int[]{1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        int K = 8;



        int t = K;
        int max = 0;
        int count = 0;
        int i = 0;
        int j = 0;

        while(i < A.length && j < A.length) {
            if(A[j] == 1){
                count++;
            }
            else if(A[j] == 0 && t > 0){
                t--;
                count++;
            }
            // resetting the window
            else if(A[j] == 0  && t == 0){
                max = Math.max(count, max);
                while(i < A.length && A[i++] != 0){
                    count--;
                }
            }
            j++;
        }

        max = Math.max(count, max);
        System.out.println(max);
    }
}
