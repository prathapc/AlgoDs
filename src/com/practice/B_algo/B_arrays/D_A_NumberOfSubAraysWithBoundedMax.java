package com.practice.B_algo.B_arrays;

/**
 * Created by prathapchowdary on 16/10/22.
 *
 * Given an integer array nums and two integers left and right, return the number of contiguous non-empty
 * subarrays such that the value of the maximum array element in that subarray is in the range [left, right].
 *
 * Input: nums = [2,1,4,3], left = 2, right = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 *
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 */
public class D_A_NumberOfSubAraysWithBoundedMax {

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private static int count(int[] nums, int bound) {
        int ans = 0, cnt = 0;
        for (int x : nums) {
            cnt = x <= bound ? cnt + 1 : 0; //this is nothing but n*n(+1)/2 which is counting no of subarrays in current array
            ans += cnt;
        }
        return ans;
    }

    public static void main(String args[]) {
        numSubarrayBoundedMax(new int[]{2,9,2,5,6}, 2, 8);
    }
}
