package com.practice.B_algo.B_arrays;

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
public class B_ThreeSum {

    public static void main(String args[]) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //Time Complexity: O(n^2)
    //twoSum is O(n), and we call it n times
    //Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2)
    //This is asymptotically equivalent to O(n^2)
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // if curr value > 0 then continue looping
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            // curr and prev numbers are same then continue looping
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }

    static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                ++left;
            } else if (sum > 0) {
                --right;
            } else {
                res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left - 1])
                    ++left;
            }
        }
    }
}
