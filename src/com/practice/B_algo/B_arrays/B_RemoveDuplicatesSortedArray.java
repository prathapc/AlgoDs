package com.practice.B_algo.B_arrays;

/**
 * Created by prathapchowdary on 10/11/21.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 */
public class B_RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int slow = 0, fast = slow+1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                ++slow;
                nums[slow] = nums[fast];
            }
            ++fast;
        }
        return slow+1;
    }
}
