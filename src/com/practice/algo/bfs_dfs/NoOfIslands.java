package com.practice.algo.bfs_dfs;

/**
 * Created by Prathap on 28 Oct, 2019
 *
 * https://leetcode.com/problems/number-of-islands/
 *
 */
public class NoOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int result = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    dfs(grid, i, j, visited, r, c);
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int i, int j, boolean[][] visited, int r, int c) {
        if (i < 0 || j < 0 || i > r-1 || j > c-1 || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        for (int p=-1; p<=1; p++) {
            for (int q=-1; q<=1; q++) {
                if (Math.abs(p) != Math.abs(q)) {
                    dfs(grid, i+p, j+q, visited, r, c);
                }
            }
        }
    }
}
