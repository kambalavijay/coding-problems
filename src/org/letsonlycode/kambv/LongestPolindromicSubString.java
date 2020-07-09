package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.List;

public class LongestPolindromicSubString {
    public static void main(String[] args) {

        String str = "babad";
        List l = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++){
            char firstChar = str.charAt(i);
            l.add(firstChar + "");
            System.out.println(firstChar + "");
            StringBuilder sb = new StringBuilder(firstChar + "");
            for (int j = i + 1; j < str.length() ; j++){
                sb.append(str.charAt(j) + "");
               l.add(sb.toString());
                System.out.println(sb.toString());
            }
        }

        int a[] = {2, 1, 3, 5, 4};
        int k = 3;
        int n = a.length;
        int sum;

        for(int i = 0; i < n - k + 1; i++){
            sum = a[i];
            for (int j = i + 1; j < i + k; j++){
                sum = sum + a[j];
            }
            int avg = sum / k;
            System.out.println(avg);
        }
        //System.out.println(l);
    }
}
