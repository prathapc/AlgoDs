package com.practice.algo.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 */
public class UniquePaths {

  public static void main(String[] args) {
    int m = 7, n = 3;
    int count[][] = new int[m][n];

    for (int i = 0; i < m; i++)
      count[i][0] = 1;

    for (int j = 0; j < n; j++)
      count[0][j] = 1;

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++)
        count[i][j] = count[i-1][j] + count[i][j-1];
    }
    System.out.println(count[m-1][n-1]);
  }
}
