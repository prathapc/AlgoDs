package com.practice.B_algo_ps.F_bfs_dfs;

/**
 * Created by Prathap on 28 Oct, 2019
 */
public class B2_NoOfIslands {
    //https://leetcode.com/problems/number-of-islands/
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
                if (grid[i][j] == '1' && !visited[i][j]) {
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

    //https://leetcode.com/problems/max-area-of-island/
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, i, j, visited));
                }
            }
        }
        return result;
    }
    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i>=grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(grid, i+1, j, visited) + dfs(grid, i, j+1, visited) + dfs(grid, i, j-1, visited) + dfs(grid, i-1, j, visited);
    }
}
