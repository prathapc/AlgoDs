package com.practice.algo.dp;

import java.util.Arrays;

public class EggDropProblem {

  public static void main(String args[]) {
    int f = 36, e = 2;
    System.out.println(solveUsingDp(f,e));
    System.out.println(solveUsingDp1(e, f));
  }

  public static int solveUsingDp(int f, int e) {
    final int results[][] = new int[f + 1][e + 1];
    for (int i = 0; i < f + 1; i++) {
      results[i][1] = i;
    }
    for (int i = 0; i < e + 1; i++) {
      results[1][i] = 1;
    }
    for (int i = 2; i < f + 1; i++) {
      for (int j = 2; j < e + 1; j++) {
        results[i][j] = Integer.MAX_VALUE;
        for (int x = 1; x < i; x++) {
          final int brokenEggResult = results[x - 1][j - 1];
          final int EggSurvivedResult = results[i - x][j];
          int temp = Math.max(brokenEggResult, EggSurvivedResult) + 1;
          if (temp < results[i][j]) {
            results[i][j] = temp;
          }
        }
      }
    }
    for (final int[] a : results) {
      System.out.println(Arrays.toString(a));
    }
    return results[f][e];
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
