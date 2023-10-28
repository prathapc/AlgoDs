package com.practice.B_algo_ps.K_sort_search_math.sort;

/**
 * Created by prathapchowdary on 01/07/23.
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * https://leetcode.com/problems/sort-colors/
 */
public class A_SortColors {

    public void sortColors(int[] nums) {
        int red = count(nums, 0);
        int white = count(nums, 1);
        //int blue = count(nums, 2);

        for (int i=0; i<nums.length; i++) {
            if (red-- > 0) {
                nums[i] = 0;
            } else if (white-- > 0) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    private int count(int[] nums, int c) {
        int count = 0;
        for (int i : nums) {
            if (i == c) count++;
        }
        return count;
    }

}
