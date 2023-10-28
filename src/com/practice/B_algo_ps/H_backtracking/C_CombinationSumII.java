package com.practice.B_algo_ps.H_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Prathap on 09 Nov, 2019
 *
 * https://leetcode.com/problems/combination-sum-ii/ (can't reuse same element)
 *
 * https://www.youtube.com/watch?v=IER1ducXujU&ab_channel=KevinNaughtonJr.
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
public class C_CombinationSumII {

    public static void main(String args[]) {
        //int candidates[] = {10,1,2,7,6,1,5};
        //int candidates[] = {1,1,2,2,3,3,4,4,5,5,6,6};
        int candidates[] = {1,2,3};
        int target = 4;
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
                //[[1, 1, 2, 3], [1, 1, 5], [1, 2, 4], [1, 3, 3], [1, 6], [2, 2, 3], [2, 5], [3, 4]]
                combinationSum2(candidates, i + 1, target - candidates[i], result, temp);
                temp.remove(temp.size() - 1);

                //if we want to take same number unlimitedly (combinationSumI problem)
                //[[1, 1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 2], [1, 1, 1, 1, 3], [1, 1, 1, 2, 2], [1, 1, 1, 4], [1, 1, 2, 3], [1, 1, 5], [1, 2, 2, 2], [1, 2, 4], [1, 3, 3], [1, 6], [2, 2, 3], [2, 5], [3, 4]]
                //combinationSum2(candidates, i, target-candidates[i], result, temp);
            }
        }
    }
}
