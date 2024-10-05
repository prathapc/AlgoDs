package com.practice.B_algo_ps.A_arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 20/08/24.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * https://leetcode.com/problems/two-sum
 */
public class B_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
