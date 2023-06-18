package com.practice.B_algo_ps.I_dp;

/**
 * Created by prathap on 05/08/17.
 *
 * https://www.geeksforgeeks.org/count-strings-can-formed-using-b-c-given-constraints/
 * Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’
 * with at-most one ‘b’ and two ‘c’s allowed.
 */
public class D_TotalNoOfStringsOfLengthNWithGivenCharacters {
  public static void main(String[] args) {
    int n = 3; // Total number of characters
    int bCount = 1, cCount = 2; //at most b and c counts
    System.out.println(count_recursion(n,bCount,cCount));
    System.out.println(count_dp(n,bCount,cCount));
  }

  //recursion
  private static int count_recursion(int n, int bCount, int cCount) {
    if (bCount < 0 || cCount < 0) return 0;
    if (bCount == 0 && cCount == 0) return 1;
    if (n == 0) return 1;

    int res = count_recursion(n-1, bCount, cCount);
    res += count_recursion(n-1, bCount-1, cCount);
    res += count_recursion(n-1, bCount, cCount-1);
    return res;
  }

  //dp => O(n)
  private static int count_dp(int[][][] dp, int n, int bCount, int cCount) {
    if (bCount < 0 || cCount < 0) return 0;
    if (bCount == 0 && cCount == 0) return 1;
    if (n == 0) return 1;

    if (dp[n][bCount][cCount] != -1) {
      return dp[n][bCount][cCount];
    }
    int res = count_recursion(n-1, bCount, cCount);
    res += count_recursion(n-1, bCount-1, cCount);
    res += count_recursion(n-1, bCount, cCount-1);

    dp[n][bCount][cCount] = res;
    return dp[n][bCount][cCount];
  }

  static int count_dp(int n, int bCount, int cCount) {
    int[][][] dp = new int[n + 1][2][3];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 3; k++) {
          dp[i][j][k] = -1;
        }
      }
    }
    return count_dp(dp, n, bCount, cCount);
  }
}
