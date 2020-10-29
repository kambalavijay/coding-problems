package org.letsonlycode.kambv;

import org.jetbrains.annotations.Contract;

public class StringCompression {

    public static void main(String[] args) {
        int arr[][] = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        System.out.println(hourGlassSum(arr));

    }

    @Contract(pure = true)
    static int hourGlassSum(int[][] arr) {
        int maxHourGlassValue = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length-1; i++){
            for(int j = 1; j < arr.length-1; j++){
                int currHourGlass = arr[i][j] + arr[i+1][j] + arr[i-1][j] + arr[i-1][j-1] + arr[i+1][j+1] + arr[i-1][j+1] + arr[i+1][j-1];
                maxHourGlassValue = currHourGlass > maxHourGlassValue ? currHourGlass : maxHourGlassValue;

            }
        }
        return maxHourGlassValue;
    }
}
