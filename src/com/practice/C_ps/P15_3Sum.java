package com.practice.C_ps;

import java.util.*;

/**
 * Created by Prathap on 01 Feb, 2020
 *
 * https://leetcode.com/problems/3sum/
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class P15_3Sum {

    public static void main(String args[]) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();
        HashSet<List<Integer>> triples = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            findTriples(nums, i, triples);
        }
        return new ArrayList<> (triples);
    }

    private static void findTriples(int[] nums, int index, HashSet<List<Integer>> triples) {
        // if first value is 2 then we need to find pair having sum as -2
        int sum = (-1) * nums[index++];
        int end = nums.length - 1;
        while(index < end) {
            int curSum = nums[index] + nums[end];
            if (curSum == sum) {
                triples.add(Arrays.asList(-sum, nums[index], nums[end]));
                index++;
                end--;
            } else if(curSum < sum) {
                index++;
            } else {
                end--;
            }
        }
    }
}
