package org.letsonlycode.kambv;

public class SmallestMissingPostiveIntegerInArray {

    /*
    public static void main(String[] args) {
        int a[] = {-3, 4, 7, -1};
        System.out.println(getMissingInt(a));
    }
    */

    public static int getMissingInt(int a[]){

        // 3 4 7 1
        // 1 2 3 4
        int n = a.length;
        for (int i = 0; i < n; i++){
            int currNumCorrectIndex = a[i] - 1;
            while(1 <= a[i] && a[i] <= n && a[i] != a[currNumCorrectIndex]){
                int temp = a[i];
                a[i] = a[currNumCorrectIndex];
                a[currNumCorrectIndex] = temp;
                currNumCorrectIndex = a[i] - 1;
            }
        }

        for (int i = 0; i < n ; i++) {
            if(i+1 != a[i]){
                return i+1;
            }
        }


        return n+1;
    }
}
