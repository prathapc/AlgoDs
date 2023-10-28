package com.practice.B_algo_ps.K_sort_search_math.search;

/**
 * Created by prathapchowdary on 04/12/21.
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class B_SearchInRotatedSortArray {

    public int search(int[] nums, int target) {
        int targetIndex = -1, start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                targetIndex = mid;
                break;
            }
            if (nums[start] <= nums[mid]) {
                //left<->mid is sorted
                if (nums[start] <= target && nums[mid] >= target) {
                    //target is at left side
                    end = mid;
                } else {
                    //target is at right side
                    start = mid + 1;
                }
            } else {
                //mid<->right is sorted
                if (nums[mid] <= target && nums[end] >= target) {
                    //target is at right side
                    start = mid + 1;
                } else {
                    //target is at left side
                    end = mid;
                }
            }
        }
        return targetIndex;
    }
}
