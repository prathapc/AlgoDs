package com.practice.B_algo.B_arrays;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 04/09/22.
 *
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 * https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 */
public class G_LargestSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Arrays.stream(nums).parallel().reduce(0, (a, b) -> a+b);
        int curr_max = nums[0], max_so_far = nums[0], curr_min = nums[0], min_so_far = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(curr_max + nums[i], nums[i]);
            max_so_far = Math.max(max_so_far, curr_max);
            curr_min = Math.min(curr_min + nums[i], nums[i]);
            min_so_far = Math.min(min_so_far, curr_min);
        }
        if (min_so_far == sum) {
            return max_so_far;
        }
        return Math.max(max_so_far, sum - min_so_far);
    }
}
