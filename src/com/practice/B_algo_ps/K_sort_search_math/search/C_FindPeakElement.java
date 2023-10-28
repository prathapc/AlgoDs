package com.practice.B_algo_ps.K_sort_search_math.search;

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

    //iterative
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        int start = 1, end = nums.length-2;
        while (start <= end) {
            int mid = start + end >> 1;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if (nums[mid-1] > nums[mid]) end = mid-1;
            else if (nums[mid] < nums[mid+1]) start = mid+1;
        }
        return -1;
    }

    //recursion
    public int findPeakElement1(int[] nums) {
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
