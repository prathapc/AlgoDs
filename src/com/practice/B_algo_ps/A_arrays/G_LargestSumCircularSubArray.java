package com.practice.B_algo_ps.A_arrays;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 04/09/22.
 *
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 * https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 */
public class G_LargestSumCircularSubArray {

    /**
     * We know that the maximum "normal sum" is the Maximum Subarray problem which can be found with Kadane's.
     * As such, we can focus on finding the "special sum".
     *
     * Instead of thinking about the "special sum" as the sum of a prefix and a suffix,
     * we can think about it as the sum of all elements, minus a subarray in the middle.
     * In this case, we want to minimize this middle subarray's sum, which we can calculate using
     * Kadane's algorithm as well.
     *
     *
     * If we use Kadane's algorithm but use min() instead of max() to update the current subarray sum,
     * it will give us the minimum subarray. Then, we can just subtract the minimum subarray from the total sum to find the "special sum".
     *
     * There is one case we need to consider however;
     * what if the minimum subarray contains all elements, such as in the case where every element is negative?
     * In that case, our "special sum" would represent an empty array, which is invalid because the problem explicitly states that we need a non-empty subarray.
     *
     * If we find that the minimum subarray is equal to the total sum, then we need to ignore the "special sum" and just return the "normal sum".
     *
     * Algorithm
     * Calculate the maximum subarray maxSum using Kadane's algorithm.
     * Calculate the minimum subarray minSum using Kadane's algorithm, by using min() instead of max().
     * Calculate the sum of all the elements in nums, totalSum
     * If minSum == totalSum return maxSum, otherwise return max(maxSum, totalSum - minSum).
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int currMax = 0, currMin = 0, maxSum = nums[0], minSum = nums[0];
        int totSum = 0;
        for (int i : nums) {
            currMax = Math.max(currMax, 0) + i;
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(currMin, 0) + i;
            minSum = Math.min(minSum, currMin);

            totSum += i;
        }

        if (totSum == minSum) return maxSum;

        return Math.max(maxSum, totSum - minSum);
    }
}
