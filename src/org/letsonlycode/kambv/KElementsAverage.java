package org.letsonlycode.kambv;

public class KElementsAverage {

    public static void main(String[] args) {

        int a[] = {2, 1, 3, 5, 4};
        int k = 3;
        int n = a.length;
        int sum = 0;

        for (int i = 0; i < k ; i++){
            sum = sum + a[i];
        }

        System.out.println(sum/k);

        for(int i = k; i < n; i++){
            sum = sum + a[i];
            sum = sum - a[i - k];
            System.out.println(sum/k);
        }
    }
}
