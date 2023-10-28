package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 11/11/21.
 *
 * https://leetcode.com/problems/next-permutation/  #facebook
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 *
 * i/p: 1 5 8 4 7 6 5 3 1
 * found break at 3rd index and 4th index but swap 3rd with 6th index element (5) then sort remaining array in asc
 * o/p: 1 5 8 5 1 3 4 6 7
 */
public class C_NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) return;

        int i = nums.length-2;
        while (i>= 0 && nums[i] >= nums[i+1]) i--;

        if(i>=0) {
            int j = nums.length-1;
            while(nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }

        //after swap reverse right side elements as they must be in desc already and
        //we want it to be in asc order in the result
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
