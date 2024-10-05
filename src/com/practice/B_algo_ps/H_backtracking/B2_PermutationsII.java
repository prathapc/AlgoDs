package com.practice.B_algo_ps.H_backtracking;

import java.util.*;
import java.util.stream.Collectors;

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
public class B2_PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1};
        System.out.println(permuteUnique(nums));
    }
    static List<List<Integer>> result = null;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        Arrays.sort(nums); //this is must unlike prev problems
        permuteUnique(nums, new ArrayList<>(), seen);
        return result;
    }
    private static void permuteUnique(int[] nums, List<Integer> temp, boolean[] seen) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (seen[i]) continue;
            if (i>0 && nums[i] == nums[i-1] && seen[i-1]) continue;
            temp.add(nums[i]);
            seen[i] = true;
            permuteUnique(nums, temp, seen);
            seen[i] = false;
            temp.remove(temp.size()-1);
        }
    }




    /**
     * For input [1,2,3,4,1]
     * At recursion level 0,
     * we have [1] + permute[2,3,4,1], [2] + permute[1,3,4,1], [3] + permute[2,1,4,1],
     * [4] + permute[2,3,1,1], [1] + permute[2,3,4,1].
     *
     * Here [1] + permute[2,3,4,1] is being repeated two times hence we need to maintain a set and avoid it
     */
    public static List<List<Integer>> permuteUnique1(int[] nums) {
        permute(nums, 0);
        return result;
    }
    private static void permute(int[] nums, int index) {
        if (index == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i=index; i<nums.length; i++) {
            if (appeared.contains(nums[i])) continue;
            appeared.add(nums[i]);
            swap(nums, index, i);
            permute(nums, index+1);
            swap(nums, index, i);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
