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
    int nums[] = {10, 2, -2, -20, 10};
    int k = -10;
    int prefix = 0;
    Map<Integer, Integer> map = new HashMap<>();//prefix -> occurence
    int count = 0;
    map.put(0, 1);
    for(int i = 0; i < nums.length; i++){
      prefix += nums[i];

      if(map.containsKey(prefix - k)){
        count += map.get(prefix - k);
      }

      if(!map.containsKey(prefix)){
        map.put(prefix, 1);
      }else{
        map.put(prefix, map.get(prefix) + 1);
      }
    }
    System.out.println(count);
  }
}
