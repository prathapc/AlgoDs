package com.practice.ps.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Prathap on 09 Nov, 2019
 *
 * https://leetcode.com/problems/combination-sum-ii/
 *
 * candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
public class P40_CombinationSumII {

    public static void main(String args[]) {
        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, target, result, temp);
        System.out.println(result);
    }

    private static void combinationSum2(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> temp) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i=index; i<candidates.length; i++) {
            //if two neighbouring elements are same; we should ignore as we don't want duplicates in result
            //that means first iteration we will get in and for next iterations we check for prev number same or not
            if (i == index || candidates[i] != candidates[i-1]) {
                temp.add(candidates[i]);
                combinationSum2(candidates, i+1, target-candidates[i], result, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
