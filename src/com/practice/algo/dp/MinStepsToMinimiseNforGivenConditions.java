package com.practice.algo.dp;

public class MinStepsToMinimiseNforGivenConditions {

  public static void main(String[] args) {
    int n = 10;
    int[] dp = new int[n+1];
    for (int i=0; i<dp.length; i++) {
      dp[i] = -1;
    }
    System.out.println(minSteps(n, dp));
  }

  private static int minSteps(int n, int[] dp) {
    if (n == 1) {
      return 0;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    int res = minSteps(n-1, dp);
    if (n % 2 == 0) {
      res = Math.min(res, minSteps(n/2, dp));
    }
    if (n % 3 == 0) {
      res = Math.min(res, minSteps(n/3 , dp));
    }
    dp[n] = 1 + res;
    return dp[n];
  }
}
