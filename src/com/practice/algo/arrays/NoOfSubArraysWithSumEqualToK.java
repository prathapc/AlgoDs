package com.practice.algo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Input : arr[] = {10, 2, -2, -20, 10},
 *         k = -10
 * Output : 3
 * Subarrays: arr[0...3], arr[1...4], arr[3..4]
 * have sum exactly equal to -10.
 */
public class NoOfSubArraysWithSumEqualToK {
  public static void main(String[] args) {
    int arr[] = {10, 2, -2, -20, 10};
    int k = -10;
    int result = 0;
    int currSum = 0;
    Map<Integer, Integer> prevSums = new HashMap<>();
    for (int i=0; i<arr.length; i++) {
      currSum += arr[i];
      if (currSum == k) {
        result++;
      }

      if (prevSums.containsKey(currSum - k)) {

      }

    }
  }
}
