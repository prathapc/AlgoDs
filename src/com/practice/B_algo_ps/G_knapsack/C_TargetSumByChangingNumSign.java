package com.practice.B_algo_ps.G_knapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 04/11/21.
 */
public class C_TargetSumByChangingNumSign {

    public static void main(String args[]) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays_recursion(nums, target));
        System.out.println(findTargetSumWays_dp(nums, target));
    }

    //recursion
    public static int findTargetSumWays_recursion(int[] nums, int target) {
        int result[] = new int[1];
        targetWaysUtil(nums, target, 0, 0, result);
        return result[0];
    }
    private static void targetWaysUtil(int[] nums, int target, int index, int sum, int[] result) {
        if (index == nums.length) {
            if (sum == target) {
                result[0]++;
            }
            return;
        }
        targetWaysUtil(nums, target, index+1, sum+nums[index], result);
        targetWaysUtil(nums, target, index+1, sum-nums[index], result);
    }

    //DP
    private static int findTargetSumWays_dp(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return returntargetWaysUtil_dp(nums, target, 0, 0, dp);
    }

    private static int returntargetWaysUtil_dp(int[] nums, int target, int index, int sum, Map<String, Integer> dp) {
        String temp = index + " " + sum;
        if (dp.containsKey(temp)) {
            return dp.get(temp);
        }

        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int add = returntargetWaysUtil_dp(nums, target, index+1, sum+nums[index], dp);
        int substract = returntargetWaysUtil_dp(nums, target, index+1, sum-nums[index], dp);
        dp.put(temp, add+substract);
        return add+substract;
    }
}
