package com.practice.B_algo_ps.A_arrays;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

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

    public static void moveZeroes1(int[] nums) {
        for (int i=0, j=0; j<nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    //another solution
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int l = 0, r = 1;
        while (r < nums.length) {
            if (nums[l] == 0 && nums[r] == 0) {
                r++;
                continue;
            }
            if (nums[l] == 0 && nums[r] != 0) {
                swap(nums, l, r);
            }
            l++;
            r++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
