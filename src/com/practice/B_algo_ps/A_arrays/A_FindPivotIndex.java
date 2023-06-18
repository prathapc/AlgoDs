package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 24/03/22.
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 *
 * https://leetcode.com/problems/find-pivot-index/
 */
public class A_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum=0, leftSum = 0;
        for (int x: nums) sum += x;
        for (int i=0; i<nums.length; i++) {
            int rightSum = sum-leftSum-nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
