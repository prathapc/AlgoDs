package com.practice.B_algo_ps.K_sort_search_math.search;

/**
 * Created by prathapchowdary on 30/06/23.
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class B_FindMinInRotatedSortedArray {

    //solved in 10mmins; beats 100%
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE, start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[mid]) {
                //left<->mid is sorted
                min = Math.min(min, nums[start]);
                start = mid+1;
            } else if (nums[mid] <= nums[end]) {
                //mid<->right is sorted
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        return min;
    }

    public int findMin_1(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return nums[left];
    }

}
