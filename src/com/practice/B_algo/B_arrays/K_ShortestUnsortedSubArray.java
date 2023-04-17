package com.practice.B_algo.B_arrays;

/**
 * Created by prathapchowdary on 17/05/22.
 *
 * Given an integer array nums, you need to find one continuous subarray that
 * if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 * Return the shortest such subarray and output its length.
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class K_ShortestUnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        //6,4,8,1,2,3
        //1,2,3,6,4,8
        //1,2,6,4,8,3    1,2,6,4,8,30
        int left = -1, right = -1;
        int prevLow = 0, prevHigh = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[prevLow]){
                left = i;
            } else {
                prevLow = i;
            }
        }

        for(int i=nums.length-1; i >= 0; i--){
            if(nums[i] > nums[prevHigh]){
                right = i;
            } else {
                prevHigh = i;
            }
        }

        return (left>=0 && right>=0) ? (left-right)+1 : 0;
    }
}
