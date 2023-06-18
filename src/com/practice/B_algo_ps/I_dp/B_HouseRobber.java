package com.practice.B_algo_ps.I_dp;

import java.util.Arrays;

/**
 * Created by Prathap on 21 Oct, 2019
 *
 * House robber problem
 *
 * https://leetcode.com/problems/house-robber
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * https://leetcode.com/problems/house-robber-ii (Houses in circle)
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 */
public class B_HouseRobber {

    public static void main(String args[]) {
        System.out.println(rob(new int[]{5,5,10,40,50,35,25}));
        System.out.println(rob_circle(new int[]{1,2,3,1}));
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

    /**
     * approach is same as above, its just that we need to ignore and consider last element to accommodate circle condition
     * [1,2,3,1] => max([1,2,3], [2,3,1])
     */
    public static int rob_circle(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max1 = rob(Arrays.copyOfRange(nums, 0, nums.length-1));
        int max2 = rob(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(max1, max2);
    }
}
