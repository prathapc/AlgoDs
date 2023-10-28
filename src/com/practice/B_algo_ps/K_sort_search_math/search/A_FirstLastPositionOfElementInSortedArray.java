package com.practice.B_algo_ps.K_sort_search_math.search;

/**
 * Created by prathapchowdary on 06/06/22.
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class A_FirstLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstLast(nums, target, true);
        result[1] = findFirstLast(nums, target, false);
        return result;
    }
    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) idx = mid;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        return idx;
    }
    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) idx = mid;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return idx;
    }


    //with single method by using a param
    private int findFirstLast(int[] nums, int target, boolean first) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //if first element that we are trying to find - continue searching for it in left part of array
            //to see if that element present, if so return that other wise this
            if (target < nums[mid] || (first && target == nums[mid])) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
