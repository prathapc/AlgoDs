package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

/**
 * Created by prathapchowdary on 08/02/24.
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words,
 * it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares
 * while 3 and 11 are not.
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * https://leetcode.com/problems/perfect-squares/
 */
public class O_PerfectSquares {
    public int numSquares(int n) {
        //return numSquaresUtil_recursion(n);

        int dp[] = new int[n+1];
        return numSquaresUtil(n, dp);
    }
    private int numSquaresUtil(int n, int dp[]) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        if (dp[n] > 0) return dp[n];

        int result = n;
        for (int i=1; i*i<=n; i++) {
            result = Math.min(result, numSquaresUtil(n - i*i, dp));
        }
        dp[n] = result+1;
        return result+1;
    }

    private int numSquaresUtil_recursion(int n) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;

        int result = n;
        for (int i=1; i*i <= n; i++) {
            result = Math.min(result, numSquaresUtil_recursion(n-i*i));
        }
        return 1+result;
    }
}
