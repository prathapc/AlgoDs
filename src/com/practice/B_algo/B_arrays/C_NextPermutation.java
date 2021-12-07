package com.practice.B_algo.B_arrays;

/**
 * Created by prathapchowdary on 11/11/21.
 *
 * https://leetcode.com/problems/next-permutation/
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 */
public class C_NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) return;

        int i = nums.length-2;
        while (i>= 0 && nums[i+1] <= nums[i]) i--;
        if(i>=0) {
            int j = nums.length-1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i+1, nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
