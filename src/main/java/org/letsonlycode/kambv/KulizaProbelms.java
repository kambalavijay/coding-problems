package org.letsonlycode.kambv;

public class KulizaProbelms {

    public static void main(String[] args) {
        /*
        [white,black,white,black,black]
        [white,white,white,black,black]
        [white,white,white,black,white]
        [white,white,white,black,black]
        [white,black,white,white,black]
        */

        int a[][] = {
                {1, 1, 1},
                {1, 0, 1},
                {0, 1, 1}
        };

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j]==1){
                    count = Math.max(getContinuousPaths(a, i, j, 0), count);
                }
            }
        }

        System.out.println(count);
    }

    public static int getContinuousPaths(int a[][], int i, int j, int count){
        if((i < 0 || i > a.length-1) || (j < 0 || j > a[i].length-1)){
            return count;
        }

        if(a[i][j] == 0)
            return count;

        count = Math.max(Math.max(getContinuousPaths(a, i, j+1, count+1),
                getContinuousPaths(a, i+1, j, count+1)),
                getContinuousPaths(a, i+1, j+1, count+1));

        return count;
    }
}
