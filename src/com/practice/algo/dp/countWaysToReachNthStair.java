package com.practice.algo.dp;


public class countWaysToReachNthStair {

  public static void main(String args[]) {

    int input = 4;
    //countWaysToReachNthStair_maxTwoSteps(input);
    countWaysToReachNthStair_mSteps(6, 6);

    System.out.println(noOfWaysToReachGivenScore(20)); //reach 20 with [3,5,10]

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
    for (int i=2; i<n; i++) {
      res[i] = 0;
      for (int j=1; j<=m && j<=i; j++)
        res[i] += res[i-j];
    }
    System.out.println(res[n-1]);
  }

  private static int noOfWaysToReachGivenScore(int n) {
    // table[i] will store count of solutions for
    // value i.
    int table[] = new int[n + 1], i;

    // Base case (If given value is 0)
    table[0] = 1;

    // One by one consider given 3
    // moves and update the table[]
    // values after the index greater
    // than or equal to the value of
    // the picked move
    for (i = 3; i <= n; i++)
      table[i] += table[i - 3];
    for (i = 5; i <= n; i++)
      table[i] += table[i - 5];
    for (i = 10; i <= n; i++)
      table[i] += table[i - 10];

    return table[n];
  }
}
