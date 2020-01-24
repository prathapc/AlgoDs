package com.practice.ps;

/**
 * Created by Prathap on 21 Oct, 2019
 *
 * House robber problem
 *
 * https://leetcode.com/problems/house-robber
 *
 */
public class MaxSumNonAdjacentArray {

    public static void main(String args[]) {
        System.out.println(rob(new int[]{1,5,3,1,7}));
    }

    private static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
