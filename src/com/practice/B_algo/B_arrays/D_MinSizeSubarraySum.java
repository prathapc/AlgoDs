package com.practice.B_algo.B_arrays;

/**
 * Created by prathapchowdary on 04/01/22.
 * https://leetcode.com/problems/minimum-size-subarray-sum
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which
 * the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 */
public class D_MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, result = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i-left+1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
