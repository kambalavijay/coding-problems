package org.letsonlycode.kambv;

public class Problem1 {

    public static void main(String[] args) {

        int a[] = {10, 22, 36, 56, 55, 8};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secMax = Integer.MIN_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if(a[i] < min){
                secMin = min;
                min = a[i]; 
            }
            else if(a[i] < secMin){
                    secMin = a[i];
            }
            if(a[i] > max){
                secMax = max;
                max = a[i];
            }
            else if (a[i] > secMax){
                secMax = a[i];
            }
        }

        System.out.println(min);
        System.out.println(secMin);

        if(max - secMin > secMax - min) {
            System.out.println(max - secMin);
        }
        else /*(secMax - min > secMin - max)*/{
            System.out.println(secMax - min);
        }

    }
}