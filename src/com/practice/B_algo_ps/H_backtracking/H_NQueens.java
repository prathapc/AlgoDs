package com.practice.B_algo_ps.H_backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/
public class H_NQueens {

  List<List<String>> result = new ArrayList<>();
  public List<List<String>> solveNQueens(int n) {
    if (n <= 0) return result;
    int[][] sol = new int[n][n];
    nQueenUtil(sol, n, 0);
    return result;
  }

  private boolean nQueenUtil(int[][] sol, int n, int col) {
    if (col >= n) {
      result.add(resultBuilder(sol));
    }

    for (int row = 0; row < n; row++) {
      if (isSafe(sol, n, row, col)) {
        sol[row][col] = 1;
        if (nQueenUtil(sol, n, col+1)) {
          return true;
        }
        sol[row][col] = 0;
      }
    }
    return false;
  }

  private boolean isSafe(int board[][], int n, int row, int col) {
    int i, j;

    /* Check this row on left side */
    for (i = 0; i < col; i++)
      if (board[row][i] == 1)
        return false;

    /* Check upper diagonal on left side */
    for (i=row, j=col; i>=0 && j>=0; i--, j--)
      if (board[i][j] == 1)
        return false;

    /* Check upper diagonal on right side */
    for (i=row, j=col; j>=0 && i<n; i++, j--)
      if (board[i][j] == 1)
        return false;

    return true;
  }

  private List<String> resultBuilder(int[][] board) {
    int n = board.length;
    List<String> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String rString = "";
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 1) {
          rString += "Q";
        } else {
          rString += ".";
        }
      }
      list.add(rString);
    }
    return list;
  }
}
