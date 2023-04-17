package com.practice.B_algo.B_arrays;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 15/06/22.
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * https://leetcode.com/problems/3sum-closest/
 */
public class B_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            int low = i+1;
            int high = nums.length-1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target-sum) < Math.abs(diff)) {
                    diff = target-sum;
                }
                if (sum < target)
                    low++;
                else
                    high--;
            }

        }
        return target-diff;
    }
}
