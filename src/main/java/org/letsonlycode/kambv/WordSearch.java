package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearch {

    public static void main(String[] args) {

        char [][] matrix = {
            {'a', 'b', 'c', 'l', 'm', 'o', 'm', 'x'},
            {'e', 'k', 'a', 'n', 'z', 'p', 'l', 'o'},
            {'a', 'l', 't', 'i', 'g', 'r', 'k', 't'},
            {'c', 'e', 'e', 'd', 'a', 'i', 'o', 'y'},
            {'k', 'd', 'a', 'p', 'c', 'j', 'k', 'z'},
            {'z', 'g', 'f', 'e', 'h', 'f', 'k', 'l'},
            {'y', 'z', 'h', 'x', 'q', 'a', 'r', 'm'},
            {'x', 'w', 'k', 'n', 's', 'p', 'n', 'q'}
        };

        String str = "abclnigrktz";

        /*System.out.println(exist(matrix, str));*/

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);list.add(1);list.add(2);

        list.stream().map(i -> i * 3).filter(num -> num/2 != 0).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> squares = numbers.stream().map(i -> i*i) .collect(Collectors.toList());

    }

    public static boolean exist(char[][] board, String word){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0) && searchRecursively(board, i, j, 0, word)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean searchRecursively(char[][] board, int i, int j, int count, String word) {
        if(count == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)){
            return false;
        }

        char temp = board[i][j];
        boolean found = searchRecursively(board, i+1, j, count+1, word) ||
                searchRecursively(board, i-1, j, count+1, word) ||
                searchRecursively(board, i, j+1, count+1, word) ||
                searchRecursively(board, i, j-1, count+1, word);

        board[i][j] = temp;
        return found;
    }
}
