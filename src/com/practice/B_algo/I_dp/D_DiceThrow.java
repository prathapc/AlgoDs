package com.practice.B_algo.I_dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 *
 * You have d dice and each die has f faces numbered 1, 2, ..., f.
 * You are given three integers d, f, and target.
 *
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice
 * so the sum of the face-up numbers equals target.
 *
 * More details on MOD: https://www.geeksforgeeks.org/modulo-1097-1000000007/
 */
public class D_DiceThrow {

  public static void main(String args[]) {
    //System.out.println(findWays(6, 25, 100));
    System.out.println(numRollsToTarget(30, 30, 500));
  }

  //recursion with memorization
  static int MOD = 1000000000 + 7;
  static Map<String, Integer> memo = new HashMap<>();
  public static int numRollsToTarget(int d, int f, int target) {
    if (d==0 && target==0) return 1;
    if (d==0 || target==0) return 0;
    //instead of above statement, below statement eliminates several cases and its faster
    //if(d > target || d * f < target) return 0;

    String temp = d + " " + target;
    if (memo.containsKey(temp)) {
      return memo.get(temp);
    }
    int res = 0;
    for (int i=1; i<=f; i++) {
      if (target < i) {
        break;
      }
      res = (res + numRollsToTarget(d-1, f, target-i)) % MOD;
    }
    memo.put(temp, res);
    return res;
  }
}
