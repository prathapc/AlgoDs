package com.practice.algo.dp;

/**
 * Created by Prathap on 13 Dec, 2019
 *
 * https://leetcode.com/problems/target-sum/submissions/
 *
 * https://medium.com/swlh/solving-the-target-sum-problem-with-dynamic-programming-and-more-b76bd2a661f9
 */
//TODO
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (S > sum || -S < -sum || (S + sum) % 2 == 1) return 0;

        int[] dp = new int[(S + sum) / 2 + 1];
        dp[0] = 1;

        for (int num: nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] += dp[i - num]; // Crux
            }
        }

        return dp[dp.length - 1];
    }
}
