package com.practice.B_algo_ps.H_backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/
public class H_NQueens {

    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        solveNQueens(grid, 0);
        return result;
    }

    private void solveNQueens(char[][] grid, int r) {
        if (r == grid.length) {
            result.add(buildResult(grid));
            return;
        }
        for (int c = 0; c < grid.length; c++) {
            if (isSafe(grid, r, c)) {
                grid[r][c] = 'Q';
                solveNQueens(grid, r + 1);
                grid[r][c] = '.';
            }
        }
    }

    private boolean isSafe(char[][] grid, int r, int c) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
              if (i == r && j == c) {
                continue;
              }
                //same column (row already being traversed and no need to check)
              if (grid[i][j] == 'Q' && j == c) {
                return false;
              }
                //same diagonal
              if (grid[i][j] == 'Q' && Math.abs(i - r) == Math.abs(j - c)) {
                return false;
              }
            }
        }
        return true;
    }

    private List<String> buildResult(char[][] grid) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            res.add(new String(grid[i]));
        }
        return res;
    }
}
