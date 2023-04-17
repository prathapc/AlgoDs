package com.practice.B_algo.B_arrays;

import java.util.HashMap;

/**
 * Created by prathap on 28/12/17.
 * https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 * Input : arr[] = { 10, 5, 2, 7, 1, 9 },
 *         k = 15
 * Output : 4
 */
public class D_LongestSubArraySum {

  private static int lenOfLongSubarr(int[] arr, int k) {
    // HashMap to store (sum, index) tuples
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0, maxLen = 0;

    map.put(0, 1);
    // traverse the given array
    for (int i = 0; i < arr.length; i++) {

      sum += arr[i];

      // when subarray starts from index '0'
      //if (sum == k)
        //maxLen = i + 1;

      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }

      if (map.containsKey(sum - k)) {
        if (maxLen < (i - map.get(sum - k)))
          maxLen = i - map.get(sum - k);
      }
    }

    return maxLen;
  }

  public static void main(String args[]) {
    int a[] = {10, 5, 2, 7, 1, 9};
    int k = 15;
    System.out.println(lenOfLongSubarr(a, k));
    //int a[] = {10, 5, 2, 7, 1, 9};

    int sum = 0;
    int c = 0;
    int start = 0;
    int result = -1;
    int i=0;
    while(i<a.length && start<a.length) {
      sum += a[i];
      c++;
      if(sum == k) {
        if(result < c) {
          result = c;
        }
      } else if(sum > k) {
        sum = sum-a[start];
        start++;
        c--;
        if(sum == k) {
          if(result < c) {
            result = c;
          }
        }
      }
      i++;
    }
    System.out.print(result);
  }
}
