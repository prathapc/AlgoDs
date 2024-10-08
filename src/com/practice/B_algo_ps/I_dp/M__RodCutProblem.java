package com.practice.B_algo_ps.I_dp;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 *
 * You should perform the cuts in order, you can change the order of the cuts as you wish.
 *
 * The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of
 * all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their
 * lengths is the length of the stick before the cut).
 *
 * Return the minimum total cost of the cuts.
 *
 * Input: n = 9, cuts = [5,6,1,4,2]
 * Output: 22
 * Explanation: If you try the given cuts ordering the cost will be 25.
 * There are much ordering with total cost <= 25, for example, the order [4, 6, 5, 2, 1] has total cost = 22
 * which is the minimum possible.
 */
public class M__RodCutProblem {

  public static void main(String args[]) {
    /*int l = 8;
    int value[] = {1,5,8,9,10,17,17,20};*/
    int l = 8;
    int value[] = {3,5,8,9,10,17,17,20};
    System.out.print(minCost(l, value));
  }

  //recursion with memo
  public static int minCost(int n, int[] cuts) {
    return helper(cuts, new HashMap<>(), 0, n);
  }

  //Complexity is n^3, where n = number of cuts.
  //Reason: on each half, we need to traverse through all cuts again. So, total complexity = n ( n*n) = n^3
  private static int helper(int[] cuts, Map<String, Integer> memo, int l, int r) {

    int res = Integer.MAX_VALUE;

    String key = l + "-" + r;
    if (memo.containsKey(key)) return memo.get(key);

    for (int i = 0; i < cuts.length; ++i) {
      if (cuts[i] <= l || cuts[i] >= r) {
        continue;
      }

      int cost = r - l;
      res = Math.min(
              // min cost of left stick + cost + min cost of right stick
              helper(cuts, memo, l, cuts[i]) + cost + helper(cuts, memo, cuts[i], r),
              res);
    }

    res = res == Integer.MAX_VALUE ? 0 : res;
    memo.put(key, res);

    return res;
  }

  //other approach
  private static int rodCutUtil(int[] value, int l) {
    int temp[][] = new int[value.length+1][value.length+1];
    for (int i=1; i<=value.length; i++) {
      for (int j=1; j<=value.length; j++) {
        if (i == 1) {
          temp[i][j] = value[i-1] * j;
          continue;
        }
        if (j < i) {
          temp[i][j] = temp[i-1][j];
          continue;
        }
        temp[i][j] = Utility.max(temp[i-1][j], j%i == 0 ? (j/i) * value[i-1] : ((j/i) * value[i-1] + temp[i][j%i]));
      }
    }
    return temp[value.length][value.length];
  }
}
