package com.practice.B_algo.I_dp;

public class C_countWaysToReachNthStair {

  public static void main(String args[]) {

    countWaysToReachNthStair_maxTwoSteps(4);
    countWaysToReachNthStair_uptoMSteps(4, 3);
    noOfWaysToReachGivenScore(35); //reach 20 with [3,5,10]

  }

  /**
   * There are n stairs, a person standing at the bottom wants to reach the top.
   * The person can climb either 1 stair or 2 stairs at a time.
   * Count the number of ways, the person can reach the top.
   *
   * Similar to fibanocci except that, starting value is different dp[0] = 1
   */
  private static void countWaysToReachNthStair_maxTwoSteps(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1; //1 way (with no steps)
    dp[1] = 1; //1 way (with one step)
    for (int i=2; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i - 2];
    }
    System.out.println(dp[n]);
  }

  /**
   * count number of ways if the person can climb up to m stairs for a given value m?
   * For example if m is 4, the person can climb 1 stair or 2 stairs or 3 stairs or 4 stairs at a time.
   *
   * /**
   *  * slightly different from coin change as we will give preference to order here to reach 4th step with at most 3 steps;
   *  * solutions are:
   *  * 1,1,1,1
   *  * 1,1,2 & 2,1,1 & 1,2,1
   *  * 2,2
   *  * 1,3 & 3,1
   *  *
   *  * in coin change it will be:
   *  * 1,1,1,1
   *  * 1,1,2
   *  * 2,2
   *  * 1,3
   *  */
  private static void countWaysToReachNthStair_uptoMSteps(int n, int m) {
    // base case
    if (n == 1 || m == 1) {
      System.out.println(1);
    }
    // create an array of size `n+1` for storing solutions to the subproblems
    int[] lookup = new int[n + 1];
    // base case: 1 way (with no steps)
    lookup[0] = 1;
    // 1 way to reach the 1st stair
    lookup[1] = 1;
    // 2 ways to reach the 2nd stair
    lookup[2] = 2;
    // fill the lookup table in a bottom-up manner
    for (int i = 3; i <= n; i++)
    {
      lookup[i] = 0;
      for (int j = 1; j <= m && (i - j) >= 0; j++) {
        lookup[i] += lookup[i - j];
      }
    }
    System.out.println(lookup[n]);
  }

  /**
   * count number of ways to reach a target with given steps
   *
   * Same as coin change problem
   */
  private static void noOfWaysToReachGivenScore(int n) {
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

    System.out.println(table[n]);
  }
}
