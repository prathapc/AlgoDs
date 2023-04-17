package com.practice.B_algo.G_knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 16/01/22.
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * https://leetcode.com/problems/partition-equal-subset-sum
 */
public class C_PartitionEqualSubsetSum {

    public static void main(String args[]) {
        System.out.println(canPartition(new int[]{1,11,5,5}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int subsetSum = sum/2;
        return dfs(nums, subsetSum,nums.length-1);
    }
    private static boolean dfs(int[] nums, int sum, int index) {
        if (sum == 0) return true;
        if (index == 0 || sum < 0) return false;
        return dfs(nums, sum-nums[index], index-1) || dfs(nums, sum, index-1);
    }


    //DP - beats 5%
    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int subsetSum = sum/2;
        Map<String, Boolean> data = new HashMap<>();
        return dfs(nums, subsetSum, nums.length-1, data);  //starting from index 0 times gives time limit exceeded
    }
    private boolean dfs(int[] nums, int sum, int index, Map<String, Boolean> data) {
        if (sum == 0) return true;
        if (index == 0 || sum < 0) return false;
        if (data.containsKey(sum+":"+index)) return data.get(sum+":"+index);

        boolean result = dfs(nums, sum-nums[index], index-1, data) || dfs(nums, sum, index-1, data);

        data.put(sum + ":" + index, result);
        return result;
    }

    //DP - beats 95%
    public boolean canPartition2(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
        return dfs(nums, n - 1, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
        if (subSetSum == 0) return true;
        if (n == 0 || subSetSum < 0) return false;
        if (memo[n][subSetSum] != null) return memo[n][subSetSum];
        boolean result = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                dfs(nums, n - 1, subSetSum, memo);
        memo[n][subSetSum] = result;
        return result;
    }
}
