package com.practice.algo.dp;


public class countWaysToReachNthStair {

  public static void main(String args[]) {

    int input = 4;
    countWaysToReachNthStair_maxTwoSteps(input);
    countWaysToReachNthStair_mSteps(4, 4);

  }

  /**
   * There are n stairs, a person standing at the bottom wants to reach the top.
   * The person can climb either 1 stair or 2 stairs at a time.
   * Count the number of ways, the person can reach the top.
   */
  private static void countWaysToReachNthStair_maxTwoSteps(int input) {
    input = input + 1;
    int[] dp = new int[input + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i=2; i <= input; i++) {
      dp[i] = dp[i-1] + dp[i - 2];
    }
    System.out.print(dp[input]);
  }

  /**
   * count number of ways if the person can climb up to m stairs for a given value m?
   * For example if m is 4, the person can climb 1 stair or 2 stairs or 3 stairs or 4 stairs at a time.
   */
  private static void countWaysToReachNthStair_mSteps(int n, int m) {
    int res[] = new int[n];
    res[0] = 1; res[1] = 1;
    for (int i=2; i<n; i++)
    {
      res[i] = 0;
      for (int j=1; j<=m && j<=i; j++)
        res[i] += res[i-j];
    }
    System.out.print(res[n-1]);
  }
}
