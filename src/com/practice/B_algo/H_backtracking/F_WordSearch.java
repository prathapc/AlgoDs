package com.practice.B_algo.H_backtracking;

/**
 * Created by prathapchowdary on 30/07/21.
 *
 * https://leetcode.com/problems/word-search/
 */
public class F_WordSearch {

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

    public static boolean dfs(int i, int j, char[][] board, String s, int index) {

        if(index == s.length())
            return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != s.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean ans =
                dfs(i + 1, j, board, s, index + 1)||
                        dfs(i, j + 1, board, s, index + 1)||
                        dfs(i - 1, j, board, s, index + 1)||
                        dfs(i, j - 1, board, s, index + 1);

        board[i][j]=temp;
        return ans;
    }

    /**
     * Complexity Analysis::
     *
     * Time Complexity: O(N*3^L)
     * where N is the number of cells in the board and L is the length of the word to be matched.
     *
     * For the backtracking function, initially we could have at most 4 directions to explore,
     * but further the choices are reduced into 3 (since we won't go back to where we come from).
     * As a result, the execution trace after the first step could be visualized as a 3-ary tree,
     * each of the branches represent a potential exploration in the corresponding direction.
     * Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L
     *
     * We iterate through the board for backtracking, i.e. there could be N times invocation for the backtracking function in the worst case.
     *
     * As a result, overall the time complexity of the algorithm would be O(N*3^L)
     *
     * Space Complexity: O(L) where L is the length of the word to be matched.
     * The main consumption of the memory lies in the recursion call of the backtracking function.
     * The maximum length of the call stack would be the length of the word.
     * Therefore, the space complexity of the algorithm is O(L).
     */
}
