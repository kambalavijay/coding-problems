package org.letsonlycode.kambv;

import java.util.Arrays;

//Largest Square of 1's in A Matrix
/*
           0  1  1  0  1
           1  1  0  1  0
           0  1  1  1  0
           1  1  1  1  0
           1  1  1  1  1
           0  0  0  0  0

           */
/* Answer would be 3(since the largest sub-matrix of 1's is 3)
* And we are going to change the matrix in here, but it should not be the case
* to bypass mutation we need to copy all the array contents and then pass the copied array by reference.
* */
public class LargestSquaresOf1InMatrix {

    public static void main(String[] args) {

        int [][] matrix = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int res = getTheSizeOfLargestSquaresOf1InMatrix(matrix);
        System.out.println(res);
    }

    private static int getTheSizeOfLargestSquaresOf1InMatrix(int[][] matrix) {
        int res = 0;
        for (int i = 1; i < matrix.length; i++) {
            int[] currRow = matrix[i];
            for (int j = 1; j < currRow.length; j++) {
                if(matrix[i][j] > 0){
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j-1], Math.min(matrix[i][j-1], matrix[i-1][j]));
                }
                res = matrix[i][j] > res ? matrix[i][j] : res;
            }
        }
        return res;
    }
}
