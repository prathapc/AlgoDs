package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 16/05/22.
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
 *
 * Input: nums = [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the maximum number of consecutive 1s. After flipping, the maximum number of consecutive 1s is 4.
 *
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class I_MaxConsecutiveOnes {

    //making it generic to work for k flip zeros
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, k = 1, left = 0;
        for (int right = 0; right<nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[left++] == 0) {
                    k++;
                }
            }

            result = Math.max(result, right-left+1);
        }
        return result;
    }

    public int longestSubarrayAfterDeletion(int[] nums) {
        int result = 0, k = 1, left = 0;
        for (int right = 0; right<nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[left++] == 0) {
                    k++;
                }
            }

            result = Math.max(result, right-left); //just "right-left" as we will be deleting 1 element
        }
        return result;
    }
}
