package com.practice.B_algo_ps.K_sort_search_math.math;

/**
 * Created by prathapchowdary on 06/08/23.
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 * https://leetcode.com/problems/sqrtx/
 */
public class H_Sqrt {

  /**
   * we need to find largest number which num*num <= x,
   * hence we need to use binary search to find uppoer bould within range 1,x.
   */
  public int mySqrt(int x) {
    int i = 1, j = x, ans = 0;
    while (i <= j) {
      int mid = i + (j - i) / 2;
      if (mid <= x/mid) {
        i = mid + 1;
        ans = mid;
      } else {
        j = mid - 1;
      }
    }
    return ans;
  }
}
