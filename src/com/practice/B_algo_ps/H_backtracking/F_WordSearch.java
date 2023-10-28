package com.practice.B_algo_ps.H_backtracking;

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
        System.out.println(wordSearch(boggle, "GUQ"));
    }

    private static boolean wordSearch(char[][] board, String word) {
        int index = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (dfs(board, i, j, index, word, visited)) return true;
                }
            }
        }
        return false;
    }

    static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static boolean dfs(char[][] board, int r, int c, int index, String word, boolean[][] visited) {
        if (index == word.length()) return true; //should be on first line otherwise string index out of bounds
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]) return false;
        if (board[r][c] != word.charAt(index)) return false;

        visited[r][c] = true;
        for (int[] dir : dirs) {
            if (dfs(board, r+dir[0], c+dir[1], index+1, word, visited)) return true;
        }
        visited[r][c] = false; //if we had multiple choices/options at a point to take and had picked up first option
        // but couldn't reach end, hence we need to backtrack it so that we can try other choices/options
        return false;
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
     * Therefore, in the worst case, the total number of invocation would be
     * the number of nodes in a full 3-nary tree, which is about 3^L
     *
     * We iterate through the board for backtracking, i.e. there could be N times invocation for
     * the backtracking function in the worst case.
     *
     * As a result, overall the time complexity of the algorithm would be O(N*3^L)
     *
     * Space Complexity: O(L) where L is the length of the word to be matched.
     * The main consumption of the memory lies in the recursion call of the backtracking function.
     * The maximum length of the call stack would be the length of the word.
     * Therefore, the space complexity of the algorithm is O(L).
     */
}
