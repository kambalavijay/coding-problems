package org.letsonlycode.kambv;

public class WordSearch {

    public static void main(String[] args) {

        char [][] matrix = {
            {'a', 'b', 'c', 'l', 'm', 'o', 'm','x'},
            {'e', 'k', 'a', 'n', 'z', 'p', 'l', 'o'},
            {'a', 'l', 't', 'i', 'g', 'r', 'k', 't'},
            {'c', 'e', 'e', 'd', 'a', 'i', 'o', 'y'},
            {'k', 'd', 'a', 'p', 'c', 'j', 'k', 'z'},
            {'z', 'g', 'f', 'e', 'h', 'f', 'k', 'l'},
            {'y', 'z', 'h', 'x', 'q', 'a', 'r', 'm'},
            {'x', 'w', 'k', 'n', 's', 'p', 'n', 'q'}
        };

        //String str = "elephan";
        String str = "abclmomx";

        int n = str.length();


        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                int charsToMatch = n;
                while( (charsToMatch - j - 1) > 0 && (charsToMatch - j - 1) < n  && matrix[i][j] == str.charAt(j)){
                    count++;
                    charsToMatch--;
                    j++;
                }
            }
            if(count == n){
                System.out.println("match found");
            }
        }
    }
}
