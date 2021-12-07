package com.practice.B_algo.H_backtracking;

/**
 * Created by prathapchowdary on 30/07/21.
 */
public class BogglePuzzle {

    public static void main(String[] args) {
        char boggle[][] = { { 'G', 'I', 'Z' },
                            { 'U', 'E', 'K' },
                            { 'Q', 'S', 'E' } };
        System.out.println(exist(boggle, "GUQ"));
    }

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if( board[i][j] == word.charAt(0) )
                    if( dfs(i, j, board, word, 0) )
                        return true;
            }
        }
        return false;
    }

    public static boolean dfs(int i, int j, char[][] board, String s, int count) {

        if(count == s.length())
            return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != s.charAt(count))
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean ans =
                dfs(i + 1, j, board, s, count + 1)||
                        dfs(i, j + 1, board, s, count + 1)||
                        dfs(i - 1, j, board, s, count + 1)||
                        dfs(i, j - 1, board, s, count + 1);

        board[i][j]=temp;
        return ans;
    }
}
