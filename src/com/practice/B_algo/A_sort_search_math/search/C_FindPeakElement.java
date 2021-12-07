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
 *  * https://leetcode.com/problems/first-bad-version/submissions/
 */
public class C_FindPeakElement {

    public static void main(String args[]) {
        System.out.println(findPeakElement(new int[]{2,4,1,2,3,4,5}));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
