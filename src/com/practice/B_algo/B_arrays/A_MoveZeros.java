package com.practice.B_algo.B_arrays;

import com.practice.C_ps.Utility;

/**
 * Created by prathapchowdary on 07/11/21.
 *
 * https://leetcode.com/problems/move-zeroes/
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class A_MoveZeros {
    public static void main(String args[]) {
        int nums[] = {0,1,0,3,12};
        moveZeroes(nums);
        Utility.printArray(nums);
    }

    public static void moveZeroes(int[] nums) {
        for (int i=0, j=0; j<nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
