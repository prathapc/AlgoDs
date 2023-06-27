package com.practice.B_algo_ps.H_backtracking;

import java.util.*;

/**
 * Created by prathapchowdary on 11/12/21.
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * https://leetcode.com/problems/permutations-ii/ (contains duplicates)
 */
public class B_PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        System.out.println(permuteUnique(nums));
    }

    static Set<List<Integer>> set = new HashSet<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean used[] = new boolean[nums.length];
        permute(new ArrayList<Integer>(),nums, used);
        return new ArrayList(set);
    }

    public static void permute(List<Integer> permutation, int []nums,  boolean used[]){
        if(permutation.size() == nums.length){
            set.add(new ArrayList<Integer>(permutation));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                permutation.add(nums[i]);
                used[i] = true;
                permute(permutation, nums, used);
                permutation.remove(permutation.size()-1);
                used[i] =false;
            }

        }

    }
}
