package com.practice.B_algo.A_sort_search_math.search;

/**
 * Created by prathapchowdary on 05/12/21.
 *
 * https://leetcode.com/problems/find-peak-element/
 *
 * return ANY peak (hence binary search  :))
 * Input: nums = [1,2,3,1]
 * Output: 2
 *
 * ALSO "first bad version" is similar problem:
 *  * https://leetcode.com/problems/first-bad-version/
 */
public class C_FindPeakElement {

    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }

    private int findPeakElement(int[] nums, int start, int end) {
        if (start == end) return start;
        int mid = start + (end-start)/2;
        if (nums[mid] < nums[mid+1]) { //peak at right side
            return findPeakElement(nums, mid+1, end);
        } else { //peak at left side
            return findPeakElement(nums, start, mid);
        }
    }
}
