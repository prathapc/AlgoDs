package com.practice.B_algo_ps.H_backtracking;

import java.util.*;

/**
 * Created by Prathap on 27 Jan, 2020
 *
 * https://leetcode.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same "repeated number" may be chosen from candidates unlimited number of times.
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class C_CombinationSum {

    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        //Arrays.sort(candidates); - unnecessary
        combinationSum(candidates, 0, target, 0, temp);
        return result;
    }

    private static void combinationSum(int[] candidates, int index, int target, int sum, List<Integer> temp) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i=index; i<candidates.length; i++) {
            temp.add(candidates[i]);
            combinationSum(candidates, i, target, sum+candidates[i], temp);
            temp.remove(temp.size()-1);
        }
    }
}
