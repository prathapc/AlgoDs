package com.practice.B_algo_ps.H_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 05/09/23.
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 *
 * https://leetcode.com/problems/combinations/
 */
public class C_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || n < k) return result;
        combinationsUtil(n, k, 1, new ArrayList<>(), result);
        return result;
    }
    private void combinationsUtil(int n, int k, int index, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i=index; i<=n; i++) {
            temp.add(i);
            combinationsUtil(n, k, i+1, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}
