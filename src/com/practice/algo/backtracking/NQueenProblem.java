package com.practice.algo.backtracking;

import com.practice.ps.Utility;

public class NQueenProblem {

  public static void main(String args[]) {
    int n = 4;
    int r = 4, c = 4;
    int[][] sol = new int[r][c];
    if (!nQueenUtil(sol, n, 0)) {
      System.out.print("Solution does not exist");

    } else {
      Utility.printArray(sol, n, n);
    }
  }

  private static boolean nQueenUtil(int[][] sol, int n, int col) {

    if (col >= n) {
      return true;
    }

    for (int i = 0; i < n; i++) {
      if (isSafe(sol, n, i, col)) {
        sol[i][col] = 1;

        if (nQueenUtil(sol, n, col+1)) {
          return true;
        } else {
          //backtrack
          sol[i][col] = 0;
        }
      }
    }
    return false;
  }

  private static boolean isSafe(int board[][], int n, int row, int col) {
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
}
