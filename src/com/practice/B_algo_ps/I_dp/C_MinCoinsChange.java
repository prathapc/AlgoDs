package com.practice.B_algo_ps.I_dp;

import java.util.*;

/**
 * Created by Prathap on 30 Jan, 2020
 *
 * fewest number of coins that you need to make up that amount
 *
 * https://leetcode.com/problems/coin-change/
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 */
public class C_MinCoinsChange {

    //recursion with memo
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        return coinChangeUtil(coins, amount, dp);
    }

    private int coinChangeUtil(int[] coins, int remain, Map<Integer, Integer> dp) {
        if (remain == 0) return 0;
        if (remain < 0) return -1;

        if (dp.containsKey(remain)) {
            return dp.get(remain);
        }
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = coinChangeUtil(coins, remain-coin, dp);
            if (count == -1) {
                continue;
            }
            minCount = Math.min(minCount, count+1);

        }
        dp.put(remain, (minCount == Integer.MAX_VALUE) ? -1 : minCount);
        return dp.get(remain);
    }

    //Another method: bottom up DP
    public int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    dp[i] = dp[i]==-1 ? dp[i-coin]+1 : Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        return dp[amount];
    }
}
