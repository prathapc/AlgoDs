package com.practice.B_algo_ps.I_dp;

/**
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 */
public class Z_EggDropProblem {

  public static void main(String args[]) {
    int f = 10, e = 2;
    System.out.println(solveUsingDp1(e, f));
  }

  public static int solveUsingDp1(int e, int f) {
    int[][] dp = new int[e+1][f+1];
    for (int i=0; i<=e; i++) {
      dp[i][1] = 1;
    }
    for (int i=0; i<=f; i++) {
      dp[1][i] = i;
    }
    for (int i=2; i<=e; i++) {
      for (int j=2; j<=f; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int x=1; x<j; x++) {
          int brokenEgg = dp[i-1][x-1];
          int notBrokenEgg = dp[i][j-x];
          int max = 1 + Math.max(brokenEgg, notBrokenEgg);
          if (max < dp[i][j]) {
            dp[i][j] = max;
          }
        }
      }
    }
    return dp[e][f];
  }
}
