package org.letsonlycode.kambv;

public class RotateMatrix {

    static void printArray(String variant, int[][] a){
        System.out.println(variant + "\n");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%2d ", a[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    static void rotate(int a[][]){
        int n = a.length;
        int noSquares = n % 2 == 0 ?  n / 2 : (n / 2) + 1;
        int maxIndex = n - 1;
        for (int i = 0; i < noSquares; i++) {
            int noOfMoves = n - 2*i - 1;
            int j = i;
            for (int k = 0; k < noOfMoves; j++, k++) {
                int temp = a[i][j];
                a[i][j] = a[j][maxIndex-i];
                a[j][maxIndex-i] = a[maxIndex-i][maxIndex-j];
                a[maxIndex-i][maxIndex-j] = a[maxIndex-j][i];
                a[maxIndex-j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {

        // testcase1
        int a[][] = {
            {1,  2,  3,  4,  5},
            {6,  7,  8,  9,  10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        printArray("before", a);
        rotate(a);
        printArray("after", a);

        // testcase2
        int b[][] = {
                {1,  2,  3,  4},
                {6,  7,  8,  9},
                {11, 12, 13, 14},
                {16, 17, 18, 19},
        };
        printArray("before", b);
        System.out.println();
        rotate(b);
        printArray("after", b);

    }

}
