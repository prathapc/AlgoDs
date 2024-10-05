package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

/**
 * Created by prathapchowdary on 15/07/23.
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * https://leetcode.com/problems/palindrome-number/
 */
public class E_PalindromeNumber {
  public boolean isPalindrome(int x) {
    if(x < 0) return false;
    int y = x;
    int res = 0;
    while(y != 0) {
      res = res * 10 + y % 10;
      y /= 10;
    }
    return x == res;
  }
}
