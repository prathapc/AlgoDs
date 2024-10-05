package com.practice.B_algo_ps.H_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prathapchowdary on 11/12/21.
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * https://leetcode.com/problems/subsets-ii/
 */
public class A_SubsetsII {
    public static void main(String args[]) {
        System.out.println(6/8);
        System.out.println(6%8);
        int[] a = {1,2,3};
        System.out.println(subsetsWithOutDuplicates(a));
    }

    public static List<List<Integer>> subsetsWithOutDuplicates(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates; remember i>0 won't work it must be i>start
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
