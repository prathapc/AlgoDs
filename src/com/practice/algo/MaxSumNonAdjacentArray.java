package com.practice.algo;

/**
 * Created by Prathap on 21 Oct, 2019
 *
 * House robber problem
 *
 * https://leetcode.com/problems/house-robber
 *
 */
public class MaxSumNonAdjacentArray {

    public static void main(String args[]) {
        System.out.println(rob(new int[]{1,5,3,1,7}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0], prevResult = 0;
        int temp = 0;
        for (int i=1; i<nums.length; i++) {
            temp = result;
            result = Math.max(result, nums[i]+prevResult);
            prevResult = temp;
        }
        return result;
    }
}
