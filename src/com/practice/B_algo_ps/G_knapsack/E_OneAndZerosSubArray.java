package com.practice.B_algo_ps.G_knapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 30/04/22.
 *
 * You are given an array of binary strings strs and two integers m and n.
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * A set x is a subset of a set y if all elements of x are also elements of y.
 *
 * https://leetcode.com/problems/ones-and-zeroes/
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 */
public class E_OneAndZerosSubArray {

    public int findMaxForm_caching(String[] strs, int m, int n) {
        Map<String, Integer> dp = new HashMap<>();
        return findMaxFormUtil(strs, 0, m, n, dp);
    }

    private int findMaxFormUtil(String[] strs, int currentIndex, int m, int n, Map<String, Integer> dp) {
        if (currentIndex >= strs.length) return 0;

        String key = currentIndex + ":" + m + ":" + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int[] count = count(strs[currentIndex]);
        int include = Integer.MIN_VALUE;
        if (count[0] <= m && count[1] <= n) {
            include = Math.max(include, 1 + findMaxFormUtil(strs, currentIndex+1, m-count[0], n-count[1], dp));
        }
        int exclude = findMaxFormUtil(strs, currentIndex+1, m, n, dp);

        dp.put(key, Math.max(include, exclude));
        return Math.max(include, exclude);
    }

    //beats 80%
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int[] count = count(s);

            for (int i=m; i>=count[0]; i--) {
                for (int j=n; j>=count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-count[0]][j-count[1]]);
                }
            }
        }

        return dp[m][n];
    }

    private int[] count(String s) {
        int[] count = new int[2];
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                count[1]++;
            } else {
                count[0]++;
            }
        }
        return count;
    }
}
