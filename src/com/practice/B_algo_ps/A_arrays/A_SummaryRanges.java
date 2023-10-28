package com.practice.B_algo_ps.A_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 08/07/23.
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * https://leetcode.com/problems/summary-ranges/
 */
public class A_SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    for (int i=0; i<nums.length; i++) {
      int num = nums[i];
      while (i < nums.length-1 && nums[i]+1 == nums[i+1]) {
        i++;
      }
      if (num == nums[i]) {
        result.add(String.valueOf(num));
      } else {
        result.add(num + "->" + nums[i]);
      }
    }

    return result;
  }
}
