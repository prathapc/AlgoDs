package com.practice.algo.dp;

import java.util.ArrayList;
import java.util.List;

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

    //recursion
    uniquePathsRecursion(m, n);
    uniquePathsDp(m, n);
  }

  public static void uniquePathsRecursion(int m, int n) {
    System.out.println(uniquePathsUtil(0, 0, m, n));
  }

  public static int uniquePathsUtil(int currRow, int currCol, int m, int n) {
    if (currRow >= m || currCol >= n) {
      return 0;
    }

    if (currRow == m-1 && currCol == n-1) {
      return 1;
    }

    return uniquePathsUtil(currRow+1, currCol, m, n) + uniquePathsUtil(currRow, currCol+1, m, n);
  }

  public static void uniquePathsDp(int m, int n) {List<List<String>> result = new ArrayList<>();
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
