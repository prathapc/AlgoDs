package com.practice.B_algo_ps.A_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 26/03/24.
 *
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 * and each integer appears once or twice, return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class S_FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int curr = Math.abs(nums[i])-1;
            if (nums[curr] < 0) {
                result.add(curr+1);
            }
            nums[curr] *= -1;
        }
        return result;
    }
}
