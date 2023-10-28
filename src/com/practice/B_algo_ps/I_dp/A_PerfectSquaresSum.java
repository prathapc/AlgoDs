package com.practice.B_algo_ps.I_dp;

/**
 * Created by prathapchowdary on 02/07/23.
 */
public class A_PerfectSquaresSum {

  public int numSquares(int n) {
    //return numSquaresUtil_recursion(n);

    int dp[] = new int[n + 1];
    return numSquaresUtil(n, dp);
  }

  //recursion
  private int numSquaresUtil_recursion(int n) {
    if (n < 0) return Integer.MAX_VALUE;
    if (n == 0) return 0;

    int result = n;
    for (int i=1; i*i <= n; i++) {
      result = Math.min(result, numSquaresUtil_recursion(n-i*i));
    }
    return 1+result;
  }

  //dp
  private int numSquaresUtil(int n, int dp[]) {
    if (n < 0) {
      return Integer.MAX_VALUE;
    }
    if (n == 0) {
      return 0;
    }
    if (dp[n] > 0) {
      return dp[n];
    }

    int result = n;
    for (int i = 1; i * i <= n; i++) {
      result = Math.min(result, numSquaresUtil(n - i * i, dp));
    }
    dp[n] = result + 1;

    return result + 1;
  }
}
