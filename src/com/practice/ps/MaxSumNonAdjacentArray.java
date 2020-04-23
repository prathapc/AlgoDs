package com.practice.ps;

import java.util.Arrays;

/**
 * Created by Prathap on 21 Oct, 2019
 *
 * House robber problem
 *
 * https://leetcode.com/problems/house-robber
 * https://leetcode.com/problems/house-robber-ii
 *
 */
public class MaxSumNonAdjacentArray {

    public static void main(String args[]) {
        System.out.println(rob(new int[]{5,5,10,40,50,35,25}));
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

    public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[3];
        for(int i = nums.length-1; i > 0; i--){
            dp[0] = Math.max(nums[i] + dp[2], dp[1]);
            dp[2] = dp[1];
            dp[1] = dp[0];
        }
        int temp = dp[0];
        Arrays.fill(dp, 0);
        for(int i = nums.length-2; i >= 0; i--){
            dp[0] = Math.max(nums[i] + dp[2], dp[1]);
            dp[2] = dp[1];
            dp[1] = dp[0];
        }
        return Math.max(dp[0], temp);
    }
}
