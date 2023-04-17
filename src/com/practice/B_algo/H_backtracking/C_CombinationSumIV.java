package com.practice.B_algo.H_backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 04/05/22.
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 *
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * Similar to coin change II but order does matter here
 * Let us clarify a bit on the reference of combination here, which is more of a permutation,
 * to be more precise, where the order of elements does matter.
 * For instance, we could have two combinations such as [1, 3] and [3, 1], which are valid and different for this problem.
 * While, for the problem of Coin Changes II, these two combinations would be considered to be the same.
 */
public class C_CombinationSumIV {
    Map<Integer, Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length ==0 || target < 0 ) return 0;
        if ( target ==0 ) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int num: nums){
            count += combinationSum4(nums, target-num);
        }
        map.put(target, count);
        return count;
    }
}
