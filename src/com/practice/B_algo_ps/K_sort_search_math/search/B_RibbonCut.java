package com.practice.B_algo_ps.K_sort_search_math.search;

/**
 * Created by prathapchowdary on 10/07/23.
 *
 * Given an array of integers with elements representing lengths of ribbons.
 * Your goal is to obtain k ribbons of equal length cutting the ribbons into as many pieces as you want.
 * Find the maximum integer length L to obtain at least k ribbons of length L
 *
 * Input: arr = [1, 2, 3, 4, 9], k = 5
 * Output: 3
 * Explanation: cut ribbon of length 9 into 3 pieces of length 3,
 * length 4 into two pieces one of which is length 3 and the other length 1,
 * and one piece is already is of length 3.
 * So you get 5 total pieces (satisfying k) and the greatest length L possible which would be 3.
 *
 */
public class B_RibbonCut {
  private int greatestLength(int[] a, int k) {
    int left = 1, right = 1;
    for (int r : a) right = Math.max(right, r);
    while (left <= right) { //diff from koko problem where we were finding min
      int mid = left + (right - left) / 2;

      int temp = 0;
      for (int i : a) {
        temp += Math.floor((double) i/mid);
      }

      //if temp lesser than k pieces then we we need to evaluate smaller numbers to cut
      if (temp >= k) { //diff from koko problem where we were finding min
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    return right;
  }
}
