package com.practice.B_algo_ps.I_dp;

/**
 * Created by prathapchowdary on 09/10/21.
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * 1, 7, 30 day pass available
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 *
 * O(n) solution
 */
public class MinimumCostForTickets {
    public int mincostTickets_DP(int[] days, int[] costs) {
        // length up to the last travel + 1 day is good enough (no need for 365)
        int lastDay = days[days.length - 1];
        // dp[i] means up to i-th day the minimum cost of the tickets
        int[] dp = new int[lastDay + 1];
        boolean[] isTravelDays = new boolean[lastDay + 1];
        // mark the travel days
        for(int day : days) isTravelDays[day] = true;

        for(int i = 1; i <= lastDay; i++) {
            if(!isTravelDays[i]) { // no need to buy ticket if it is not a travel day
                dp[i] = dp[i - 1];
                continue;
            }
            // select which type of ticket to buy
            dp[i] = costs[0] + dp[i - 1]; // 1-day
            dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // 7-day
            dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // 30-day
        }
        return dp[lastDay];
    }
}
